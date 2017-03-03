uniqueReqBanwidth = dict("string");
record = recordset();
productName = "";
resultString = "";
if(cFTAllSelectedRequestParameters_quote <> "")
{
	splitAllSite = split(cFTAllSelectedRequestParameters_quote,"##");
	
	for eachAllSite in splitAllSite{
		if(not(isnull(eachAllSite))){
			eachSingleSite = split(eachAllSite, "$$");
			print eachSingleSite;
			//if(not(isnull(eachSingleSite[0])) AND not(isnull(eachSingleSite[8])) AND not(isnull(eachSingleSite[9]))){
			if(not(isnull(eachSingleSite[0]))){
				print "debug";
				print eachSingleSite[15];
				//Get Product Name
				if(eachSingleSite[9] == "legacyProductAccesoInternetONOAndVodafone"){
					productName = "Internet Legacy";
					//get request ID and store product name and bandwidth against
					if(eachSingleSite[7] == "Main"){
							put(uniqueReqBanwidth, eachSingleSite[0], eachSingleSite[5] + "##"+ productName);	
					}
					if(eachSingleSite[7] == "Backup"){
							put(uniqueReqBanwidth, eachSingleSite[0], eachSingleSite[5] + "##"+ productName);	
					}
				}
				elif(eachSingleSite[9] == "primarioFijo"){
					productName = "primarioFijo";
				}
				elif(eachSingleSite[9] == "primarioMvil"){
					productName = "primarioMvil";
				}
				elif(eachSingleSite[15] == "iPVPN"){
					productName = "IPVPN";
					put(uniqueReqBanwidth, eachSingleSite[0], eachSingleSite[8] + "##"+ productName);	
				}
			}
		}
	}
}
print uniqueReqBanwidth;
//Logic for getting service selection from table 
if(cFTResponseForSingleSite_quote <> "")
{
	allSelectedManualRequest = split(cFTResponseForSingleSite_quote,"##");
	
	for eachManual in allSelectedManualRequest{
		if(not(isnull(eachManual))){
			eachManualRequest = split(eachManual, "$$");
			if(not(isnull(eachManualRequest[5])) AND not(isnull(eachManualRequest[0]))){
				
				bwPrd = get(uniqueReqBanwidth, eachManualRequest[1]);
				AccessTech = util.getIndexedValue(eachManual, "$$", 5);

				//Get Bandwidth and product name
				bandwidthAccess = util.getIndexedValue(bwPrd, "##", 0);
				selectedProduct = util.getIndexedValue(bwPrd, "##", 1);
				
				//Check if bw is black or none
				if(bandwidthAccess == "None" OR bandwidthAccess == "" OR (find(bandwidthAccess, "PaP") == -1)){	
					//For IPVPN get based on service selection
					if(selectedProduct == "IPVPN"){
					//print profile;
						if(profile <> ""){
							print selectedProduct;
							print AccessTech;
							print profile;
							record = bmql("select Service,ServiceType,WANInterface,SpeedAccess,FlowRate,Quantity from DefaultSalesValues where Product=$selectedProduct AND  AccessTech = $AccessTech AND ServiceSelection = $profile");
						}
						else{
							record = bmql("select Service,ServiceType,WANInterface,SpeedAccess,FlowRate,Quantity from DefaultSalesValues where Product=$selectedProduct AND  AccessTech = $AccessTech");
						}	
					}
					else{	
						record = bmql("select Service,ServiceType,WANInterface,SpeedAccess,FlowRate,Quantity from DefaultSalesValues where Product=$selectedProduct AND  AccessTech = $AccessTech");
					}
				}else{
					if(selectedProduct == "IPVPN"){	
						if(profile<>""){
							record = bmql("select Service,ServiceType,WANInterface,SpeedAccess,FlowRate,Quantity from DefaultSalesValues where Product=$selectedProduct AND  AccessTech = $AccessTech AND Bandwidth = $bandwidthAccess AND ServiceSelection = $profile");
						}
						else{
							record = bmql("select Service,ServiceType,WANInterface,SpeedAccess,FlowRate,Quantity from DefaultSalesValues where Product=$selectedProduct AND  AccessTech = $AccessTech AND Bandwidth = $bandwidthAccess");
						}	
					}
					else{
						record = bmql("select Service,ServiceType,WANInterface,SpeedAccess,FlowRate,Quantity from DefaultSalesValues where Product=$selectedProduct AND  AccessTech = $AccessTech AND Bandwidth = $bandwidthAccess");
					}						
				}
				for each in record{
					resultString =  get(each,"Service")+"$$"+get(each,"ServiceType")+"$$"+get(each,"WANInterface")+"$$"+get(each,"SpeedAccess")+"$$"+get(each,"FlowRate")+"$$"+get(each,"Quantity")+"##";
				}
				
				if(selectedProduct == "primarioFijo" OR selectedProduct == "primarioMvil"){
					resultString = "Voice"+"$$"+"PRA"+"$$"+"RJ45"+"$$"+""+"$$"+""+"$$"+string(1)+"##";
				}				
			}
		}
	}
}
return resultString;