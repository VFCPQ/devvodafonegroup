/* Created By/Date:  Sandip/07092015 
   Comments: Get feasibility call and parse response after applying Pirority matrix for BLUE and GREEN.
*/
cftAccessString = "";cftMain = "";cftBackup = "";
epRecordSet=recordset();
epRecordSetElse=recordset();
requestParameter = "";
eachRequest =string[];
siteName = string[];
siteAddress = string[];
uniqueRequest = string[];
cftRequestDict = dict("string");
resultString = "";
responseCFT = "";
count = 0; batchCounter = 0;
batchCount = 0;
accssSymmetric = "Asymmetric";
fesibilityType = "Automatic";
accessTechnology = ""; previousResponse = "";
country = "Spain"; eachOne = string[];
productSelectionString = ""; permission = "";
feasibility = ""; uniqueDict = dict("string");
Market = "VF-ES";opco = "ES"; accessTechnology = ""; type = "Symmetric";
productName = "";
prodName = "";condition = "";
validationValue = "";

//cFTRequestParameter_quote
//CFTREQ1$$Estación-05001$$Paseo,de la Estación,,18,,,05001,Ávila,Ávila,Spain,40.66,-4.69$$Y$$Y$$N$$N$$S$$None$$Horario de oficina 8x5$$Estandar$$Alquiler$$AMBOS$$$$$$$$$$##CFTREQ2$$Estación-05001$$Paseo,de la Estación,,18,,,05001,Ávila,Ávila,Spain,40.66,-4.69$$Y$$Y$$N$$N$$L$$None$$Horario de oficina 8x5$$Estandar$$Alquiler$$AMBOS$$$$$$$$$$

if(opco_quote == "GB") {
  country = "United Kingdom";
}

//[CFTREQ1, Callao, Carrera,Perdiu,12,74,21,14,46184,Callao de San Antonio,Madrid,Spain,40.66,40.66, Y, Y, N, N, S, None, Horario de oficina 8x5, Estandar, Alquiler, AMBOS, , , , , ]
//[Carrera, Perdiu, 12, 74, 21, 14, 46184, Callao de San Antonio, Madrid, Spain, 40.66, 40.66]

//Get Batch Count.
condition = _system_company_name + "_batch";
results = bmql("select Value from FixedConstants where Name = $condition");
for result in results {
	batchCounter = atoi(get(result, "Value"));
}

//Logic for Bulk Feasiblity Request
cftRemainingRequest = util.getCFTRequestForBulkFeasiblity(cFTAllSelectedRequestParameters_quote, backupCFTParseResponse_quote , productName);

if(cFTRequestParameter_quote <> ""){
	requestParameter = cFTRequestParameter_quote;
}else{
	requestParameter = cftRemainingRequest;
}
if(parentChildStatus == "Parent"){
	requestParameter  = util.sortingFeasibilityRequest(requestParameter , type);
}
//if(cFTRequestParameter_quote <> ""){

if(requestParameter <> ""){	
	//requestParameter = cFTRequestParameter_quote;
	requestDetails1 = split(requestParameter , "##");
	
	for each in requestDetails1{
		put(uniqueDict, each, each);
	}
	

	requestDetails = keys(uniqueDict);
	
	for each in requestDetails {
		if(each <> "" AND batchCount < batchCounter) {
			
			eachOne = split(each , "$$");
			//print "Out Chetan:";
			for e in eachOne{
				print e;
			}
			
			//@1 
			//COUNTRY!!MARKET_SEGMENT
			commonInput = country + "!!" + a1SFMarket_quote;
			
			//@2 - Parent Identifier
			//OPPID!!QUOTE_NUMBER!!OPP_STATUS!!TRASACTION_ID
			parentIdentifier = crmOpportunityId_quote + "!!" + quoteNumber_quote + "!!" + opportunityStage_quote + "!!" + transactionID_quote; 
			
			//@3 - Site Address
			//Location Details
			locationDetails = split(eachOne[2], ",");
			
			location = eachOne[1] + "!!" + locationDetails[0] + "!!" + locationDetails[1] + "!!" + locationDetails[2] + "!!" +  locationDetails[3] + "!!" + locationDetails[4]+ "!!" + locationDetails[5]+ "!!" + locationDetails[6]+ "!!" + locationDetails[7]+ "!!" + locationDetails[8]+ "!!" + locationDetails[9] + "!!" + eachOne[7] + "!!" + locationDetails[10]+ "!!" + locationDetails[11];

			if(fesibilityType == "Automatic") {
				accessTechnology = "";
				previousResponse = "";
			}
			
			
			//For IPVPN
			if(eachOne[15] == "iPVPN"){
				prodName = eachOne[15];
			//if(selectProductES_quote == "iPVPN"){
			//Fixing symmetric request for Large site
				if(eachOne[7] == "XL" OR eachOne[7] == "L") {
					accssSymmetric = "Symmetric";
					feasibility = eachOne[8] + "!!" + accssSymmetric + "!!" + eachOne[0];	
				}else{
					accssSymmetric = "Asymmetric";
					feasibility = "" + "!!" + accssSymmetric + "!!" + eachOne[0];
				}
				
				//feasibility = eachOne[8] + "!!" + accssSymmetric + "!!" + eachOne[0];
			}
			
			//FOR Legacy MPLS & Internet
			if(eachOne[9] == "legacyProductMPLSAndVPLSONO" OR eachOne[9] == "legacyProductAccesoInternetONOAndVodafone"){
			//if(selectProductES_quote == "legacyProductMPLSAndVPLSONO" OR selectProductES_quote == "legacyProductAccesoInternetONOAndVodafone"){
				prodName = eachOne[9];
				//Check Permission for  Main Request
				if(eachOne[7] == "Main"){
				
					
					
					cftAccessString = util.getCFTMainBackupForLegacyProduct(eachOne[9]+ "##" + eachOne[7], eachOne[3] , eachOne[5]);
					cftMain = util.getIndexedValue(cftAccessString, "##", 0);
					cftBackup = util.getIndexedValue(cftAccessString, "##", 1); 
				
					permission = commerce.getPermissionForCFTFeasibilityInputParameters(Market, Opco, cftMain, Type);
				}else{
				
					cftAccessString = util.getCFTMainBackupForLegacyProduct(eachOne[9]+ "##" + eachOne[7], eachOne[4] , eachOne[6]);
					cftMain = util.getIndexedValue(cftAccessString, "##", 0);
					cftBackup = util.getIndexedValue(cftAccessString, "##", 1); 
					permission = commerce.getPermissionForCFTFeasibilityInputParameters(Market, Opco, cftBackup, Type);
				}
				
				
				if(permission == "Yes"){
					//Temporary fix for defect 894/907
					if(eachOne[7] == "Main"){
						//Added by Chandan to @defect 593/894/907 fixes
						feasibilityModeOfAccess = util.getModeOfAccessAgainstBandwidth_ES(eachOne[9]+ "##" + eachOne[7], eachOne[3] , eachOne[5]);
						feasibility = feasibilityModeOfAccess + "!!" + "Symmetric" + "!!" + eachOne[0];
					}else{
						feasibilityModeOfAccess = util.getModeOfAccessAgainstBandwidth_ES(eachOne[9]+ "##" + eachOne[7], eachOne[4] , eachOne[6]);
						feasibility = feasibilityModeOfAccess + "!!" + "Symmetric" + "!!" + eachOne[0];
					}
				}else{
					feasibility = "" + "!!" + "Asymmetric" + "!!" + eachOne[0];
				}
			}
			
			//Primary Fijo & Movil
			if(eachOne[9] == "primarioFijo" OR eachOne[9] == "primarioMvil"){
				//print "in if Chetan:";
				//print eachOne;
				prodName = eachOne[9];
				//Check Permission for  Main Request
				if(eachOne[7] == "Main"){
					cftAccessString = util.getCFTMainBackupForLegacyProduct(eachOne[9]+ "##" + eachOne[7], eachOne[3] , eachOne[5]);
					cftMain = util.getIndexedValue(cftAccessString, "##", 0);
					cftBackup = util.getIndexedValue(cftAccessString, "##", 1); 
				
					permission = commerce.getPermissionForCFTFeasibilityInputParameters(Market, Opco, cftMain, Type);
				}				
				
				// if(permission == "Yes"){
					// //Temporary fix for defect 894/907
					// if(eachOne[7] == "Main"){
						// //Added by Chandan to @defect 593/894/907 fixes
						// feasibilityModeOfAccess = util.getModeOfAccessAgainstBandwidth_ES(eachOne[9]+ "##" + eachOne[7], eachOne[3] , eachOne[5]);
						// feasibility = feasibilityModeOfAccess + "!!" + "Symmetric" + "!!" + eachOne[0];
					// }
				// }else{
					// feasibility = "" + "!!" + "Asymmetric" + "!!" + eachOne[0];
				// }
				feasibility = "PaP_2M" + "!!" + "Symmetric" + "!!" + eachOne[0];
			}
			//Primary end
			
			//FOR Legacy MPLS & Internet
			if(eachOne[7] == "legacyProductVPNAvalon"){
				prodName = eachOne[7];
			//if(selectProductES_quote == "legacyProductVPNAvalon"){
				//type = "";
///				//cftAccessString = util.getCFTMainBackupForLegacyProduct(selectProductES_quote, eachOne[3], eachOne[4]);
				
				if(eachOne[5] == "Main"){
					//line from 189 to 204 Commented for PROJ-1518930_BREQ-107 BREQ
					/*cftAccessString = util.getAccesTechnologyForLEGACYAVALON(eachOne[3], type);
					print "cftAccessString";
					print cftAccessString;
					cftMain = util.getIndexedValue(cftAccessString, "##", 0);
					bandwdith = util.getIndexedValue(cftAccessString, "##", 1); 
					print "bandwdith";
					print bandwdith;
					
					//permission = commerce.getPermissionForCFTFeasibilityInputParameters(Market, Opco, cftMain, Type);
					
					if(permission == "Yes"){
						feasibility = bandwdith + "!!" + "Symmetric" + "!!" + eachOne[0];
					}else{
						feasibility = "" + "!!" + "Asymmetric" + "!!" + eachOne[0];
					}*/
					
					if(eachOne[3] == "Symmetric"){
						feasibility = eachOne[9] + "!!" + "Symmetric" + "!!" + eachOne[0];
					}else{
						feasibility = "" + "!!" + "Asymmetric" + "!!" + eachOne[0];
					}
					
				}else{
					//line from 214 to 223 Commented for PROJ-1518930_BREQ-107 BREQ
					/*cftAccessString =util.getAccesTechnologyForLEGACYAVALON(eachOne[4], type);
					
					cftBackup= util.getIndexedValue(cftAccessString, "##", 0);
					bandwdith = util.getIndexedValue(cftAccessString, "##", 1); 
					permission = commerce.getPermissionForCFTFeasibilityInputParameters(Market, Opco, cftBackup, Type);
					if(permission == "Yes"){
						feasibility = bandwdith + "!!" + "Symmetric" + "!!" + eachOne[0];
					}else{
						feasibility = "" + "!!" + "Asymmetric" + "!!" + eachOne[0];
					}*/
					if(eachOne[4] == "Symmetric"){
						feasibility = eachOne[10] + "!!" + "Symmetric" + "!!" + eachOne[0];
					}else{
						feasibility = "" + "!!" + "Asymmetric" + "!!" + eachOne[0];
					}
				}
			}
			
			if(eachOne[6] == "enlacePortador"){
			//if(selectProductES_quote == "enlacePortador"){
				prodName = eachOne[6];
				tempeachOne=eachOne[3];
				eachOneTemp=eachOne[3];
				epRecordSet=bmql("select EPParameter,Value from EPPriceParameter where EPParameter=$eachOneTemp");
				
				for epResult in epRecordSet{
					tempeachOne=get(epResult,"Value");
				}
				feasibility = tempeachOne + "!!" + "Symmetric" + "!!" + eachOne[0];
			}
			
			//@5 - Selected Product + User Information
			// ProductName!!USER_ID!!USER_PROFILE!!USER_NAME!!USER_SURNAME!!CLIENT_COMPANY_NAME!!USER_DEAPRTMENT!!CLIENT_ID!!CONTACT_PERSONCONTACT_PHONE_NUMBER
		//	productSelectionString = selectProductES_quote + "!!" + "";
			productSelectionString = prodName + "!!" + "";
			
	
			//Get CFT Response 
			//responseCFT = util.readServiceAvailbilityCheck(commonInput, parentIdentifier, location, feasibility);
			//if condition added for oo60 defect 

			if((eachOne[9] == "legacyProductMPLSAndVPLSONO" OR eachOne[9] == "legacyProductAccesoInternetONOAndVodafone" OR eachOne[9] == "primarioFijo" OR eachOne[9] == "primarioMvil") AND find(feasibility, "Asymmetric") == -1){
				
				if(find(feasibility, "PaP") <> -1){
					responseCFT = util.automaticReadServiceAvailabilityCheck(commonInput, parentIdentifier, location, feasibility, productSelectionString);
				}else{
					validationValue = "Bandwidth is not define for selected services";
				}
			}
			else{
				responseCFT = util.automaticReadServiceAvailabilityCheck(commonInput, parentIdentifier, location, feasibility, productSelectionString);
			}
			if(resultString == "") {
			  resultString = responseCFT;
			}else {
			  resultString = resultString + "$,$" + responseCFT;	
			}
			batchCount = batchCount + 1;
		}
	}
}


//retStr = "1~cFTResponceSite_quote~resultString|";
retStr = "";
//Second One

resultStringcFTResponceSite_quote = resultString;
requestParameter = "";
eachRequest =string[];
siteName = string[];
siteAddress = string[];
uniqueRequest = string[];
cftResponse = string[];
cftRequestDict = dict("string");
resultString = "";
count = 0; flagFeasibility = false;
accssSymmetric = "Symmetric";
fesibilityType = "Automatic";
accessTechnology = ""; previousResponse = "";
country = "Spain";
unqiueResultDict = dict("string");
feasibilityArr = String[];

//END Second one

if(cFTRequestParameter_quote <> "") {
  requestParameter = cFTRequestParameter_quote ;
}
if(requestParameter <> "") {
  eachRequest = split(requestParameter,"##");
}

newResult = "";
if(cFTParseResponse_quote <> "") {
	//BARC001##FTTH VF##GREEN##12##33##33##5$$BARC001##ORLA 1G##AMBER##12##33##33##5$$BARC001##ORLA 10M##RED##12##33##33##5@@30122015@@CFTREQ2
	

	if(resultStringcFTResponceSite_quote <> ""){
		cftResponse = split(resultStringcFTResponceSite_quote , "$,$");
		for each in cftResponse{
			feasibilityArr = split(each, "@@") ;		
			requestID = feasibilityArr[3];
			
			//Append Acknowledgement if request is not found.
			if(find(cFTParseResponse_quote, requestID + "@@") == -1) {
				
				flagFeasibility = true;
				if(newResult == ""){
					newResult = each;
				}else {
					newResult = newResult + "$,$" + each;
				}
				
			}
			else {
				resultString = cFTParseResponse_quote;
			}
		}
		
	}else{
		resultString = cFTParseResponse_quote;
	}
	
	if(flagFeasibility == true){
		resultString = cFTParseResponse_quote + "$,$" +newResult;
	}
	
} else {
	resultString = resultStringcFTResponceSite_quote;
}
retStr = retStr + "1~cFTParseResponse_quote~"+resultString+"|";

//resultString = substring(resultString, 0, len(resultString)-3);


result = "";
//cftRemainingRequest = "";
cftRemainingRequestArray = string[]; 
productName = "";
resultString = "";

currentDate = _system_date;

result = "1~cFTResponseForSingleSite_quote~|1~manualFeasibilityRequestParameters_quote~";

//cftRemainingRequest = util.getCFTRequestForBulkFeasiblity(cFTAllSelectedRequestParameters_quote, backupCFTParseResponse_quote , productName);

if(cftRemainingRequest<> ""){
  cftRemainingRequestArray = split(cftRemainingRequest, "##");
}

//Return timer feasibility.
if(isempty(cftRemainingRequestArray) == false){
	
	if(sizeofarray(cftRemainingRequestArray) > 1){
		result = result + "|" + "1~bulkFeasibilityTimer_quote~" + currentDate;
		result = result + "|" + "1~feasibiltiyResultPendingFlag_quote~" + "true";
	}
}

result = result + "|" + "1~cFTRequestParameter_quote~|";
result = result + "1~validationRule_quote~"+validationValue+"|";


retStr = retStr + result;

return retStr;