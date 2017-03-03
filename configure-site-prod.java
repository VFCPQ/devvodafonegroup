result = "";
parameters = string[];
responseParams = ""; cftRequestString = "";
requestParams = string[];
elementToFind  = "";
responsetoAppend = string[];
finalResultString = "";
parseParameter = string[];
parameterString = ""; leadTime = 0;
ArrayRow  = string[];  sourceDict=dict("string");
configSiteDict = dict("string"); AllRequestArray = string[];
parameterValue  ="";
responseParameters  = string[]; requestParameters = string[];
i = 0; sourceDestStringArray = string[]; 
resultString = ""; keytoCheck = "";
cftManDict = dict("string");
params = string[];
loopKey = "";
epeachrequest = string[];
selectproduct = "";
selectedSiteKey = "";
resultString_Hungary = "";
capexCost =string[];
coststringDict = dict("string");

if(cFTAllSelectedRequestParameters_quote <> "" AND cFTResponseForSingleSite_quote <> "") {
	requestParameters = split(cFTAllSelectedRequestParameters_quote, "##");
	responseParameters = split(cFTResponseForSingleSite_quote, "$$");
}

if(cFTParseResponse_quote<>""){
	parseParameter = split(cFTParseResponse_quote,"$,$");
	//SITENAME##ACCESS_TECH##RAG_STATUS
	for each in parseParameter {
		if(find(each, responseParameters[3] + "##" + responseParameters[5] + "##" + responseParameters[6]) <> -1){
			parameterString = each ;
		}
	}
	ArrayRow = split(parameterString, "$$");
	for each in ArrayRow {
		if(find(each, responseParameters[3] + "##" + responseParameters[5] + "##" + responseParameters[6]) <> -1){
			parameterValue = each ;
		}
	} 
	rowArray = split(parameterValue, "##");
}

// Site Selection Code for Hungary Fixed - Shashank(12/13/2016)
if(opco_quote == "Hungary"){
	resultString_Hungary = selectedSitesInformation_quote;
	resultString_HungarySplit=split(resultString_Hungary,"##");
	for each_address in resultString_HungarySplit{
	 if(each_address<>"$$"){
	   resultString=resultString+each_address+"##";
	  }
	}		
	return resultString;
}

//@3.0 Prepare Configuration String for one Net Products
if(selectProductES_quote == "sIPTelephony" OR selectProductES_quote == "oneNetIPTrunk" OR selectProductES_quote == "oneNetCloudContactCentre" OR selectProductES_quote == "oneNetCollaborationForLync" OR selectProductES_quote == "legacyProductExtraServices" OR selectProductES_quote == "Bespoke" OR selectProductES_quote == "iPPBX"){
	resultString = siteSelectionForSIP_ES_quote + "$$" + selectProductES_quote; 
	return resultString;
}

if(((selectProductES_quote == "legacyProductMPLSAndVPLSONO" OR selectProductES_quote == "primarioFijo" OR selectProductES_quote == "primarioMvil" OR selectProductES_quote == "legacyProductAccesoInternetONOAndVodafone" OR selectProductES_quote == "legacyProductVPNAvalon") AND FeasibilityRequired_Quote)){
	
	if(selectProductES_quote == "legacyProductVPNAvalon"){
		if(siteSelectionForSIP_ES_quote <> ""){
			resultString = siteSelectionForSIP_ES_quote + "$$" + selectProductES_quote + "$$" + "None" +"$$"+ "true";
			return resultString;
		}
			resultString = selectedSitesInformation_quote + "$$" + selectProductES_quote + "$$" + "None" +"$$"+ "true";
			return resultString;
		}
	else{
		if(siteSelectionForSIP_ES_quote <> ""){
			resultString = siteSelectionForSIP_ES_quote + "$$" + selectProductES_quote + "$$" + service_quote +"$$"+ "true";
			return resultString;
		}
		resultString = selectedSitesInformation_quote + "$$" + selectProductES_quote + "$$" + service_quote +"$$"+ "true";
		return resultString;
	}
}

//print find(textAreaES3_quote, "enlacePortador");

if(textAreaES3_quote <> "") {
	responseParameters = split(textAreaES3_quote  , "##");
	for each in responseParameters{
		if(each <> "" AND not(isnull(each))){
			sourceDestStringArray = split(each, "$$");
			type = "manual";
			requestKey = sourceDestStringArray[12];
			techKey = "";
			costString = util.getCFTCostForAccountManager_ES(type, manualFeasibilityActualResponse_quote, requestKey, techKey);
			put(coststringDict, util.getIndexedValue(each,"$$",11),costString);			
			put(sourceDict, sourceDestStringArray[11] + "!!" + sourceDestStringArray[18],sourceDestStringArray[5] + "!!" + sourceDestStringArray[6] + "!!" + sourceDestStringArray[13] + "!!" + sourceDestStringArray[14] + "!!" + sourceDestStringArray[15] + "!!" + sourceDestStringArray[19] + "!!" + sourceDestStringArray[1]);
		}
	}
	sourceKeys = string[];
	sourceKeys = keys(sourceDict);

	print "start";	
	print sourceKeys;	
	
	if(cFTAllSelectedRequestParameters_quote <> "") {
		requestParameters = split(cFTAllSelectedRequestParameters_quote, "##");	
		for each in requestParameters {
			if(each <> "" AND not(isnull(each))) {
				params = split(each, "$$");//Request ID
				////print params;
				if(params[7] == "legacyProductVPNAvalon"){
					selectproduct = params[7]; 
				}elif(params[9] == "legacyProductMPLSAndVPLSONO" OR params[9] == "legacyProductAccesoInternetONOAndVodafone" OR params[9] == "primarioFijo" OR params[9] == "primarioMvil"){
					selectproduct = params[9]; 
				}elif(params[15] == "iPVPN"){
					selectproduct = params[15]; 
				}elif(params[6] == "enlacePortador"){
					selectproduct = params[6]; 
				}
				
				cftRequestString = params[1] + "$$" + params[2] + "$$" + params[3] + "$$" + params[4];
				
				techResponseString = get(sourceDict,params[4] +"!!"+ params[5] );
				techResponseArray = split(techResponseString, "!!");
				
				if(containskey(coststringDict,util.getIndexedValue(cftRequestString,"$$",3))){
					capexCoststring = get(coststringDict,util.getIndexedValue(cftRequestString,"$$",3));
					capexCost = split(capexCoststring, "$$");
				}
				print capexCost;print findinarray(sourceKeys, "A-end"+"!!"+params[5]);
				if(findinarray(sourceKeys,params[4]+"!!"+params[5]) <> -1 AND findinarray(sourceKeys, "A-end"+"!!"+params[5]) <> -1) {
					resultString = resultString + selectproduct + "$$" + cftRequestString + "$$" + techResponseArray[0] + "$$" + techResponseArray[1] + "$$" + techResponseArray[2] + "$$" + techResponseArray[3] + "$$" + techResponseArray[4]+ "$$" + techResponseArray[5] + "$$" + params[0]+ "$$" + params[5] + "$$" + techResponseArray[6]+ "$$" + capexCost[4]+ "$$" + capexCost[0]+ "$$" + capexCost[5]+  "##";
				}else{
					resultString = resultString + selectproduct + "$$" + cftRequestString + "$$" + techResponseArray[0] + "$$" + techResponseArray[1] + "$$" + techResponseArray[2] + "$$" + techResponseArray[3] + "$$" + techResponseArray[4]+ "$$" + techResponseArray[5] + "$$" + params[0]+ "$$" + params[5] + "$$" + techResponseArray[6]+ "$$" + capexCost[0]+ "$$" + capexCost[4]+ "$$" + capexCost[5]+  "##";
				}
			}
		}
	}
resultString = substring(resultString, 0, len(resultString)-2);
//print resultString;
}
else{
	//@3.1 Prepare Configuration String for Legacy MPLS and Internet
	//Prepare ReferKey Dict 
	AllRequestArray = split(allManualFeasibilityRequestParameters_quote, "##");
	
	for eachReq in AllRequestArray{
		eachRequestDetailsArray = split(eachReq, "$$");
		//MANU REQUSTID + CPQ AUTOMATIC REQUST ID + SITE NAME.
		key = eachRequestDetailsArray[0] + "##" + eachRequestDetailsArray[1] + "##" + eachRequestDetailsArray[3];
		
		//Analysis Type + CFT AUTO FID + Refer Key + CPQ MANU REQUSTID.
		val = eachRequestDetailsArray[11] + "##" + eachRequestDetailsArray[12] + "##" + eachRequestDetailsArray[13];
		put(cftManDict, key, val);
	
	//Table3
		if(cFTResponseForSingleSite_quote <> "") {
			responseParameters = split(cFTResponseForSingleSite_quote, "##");
			////print sizeofarray(responseParameters);
			for eachItem in responseParameters{
				responseString = split(eachItem, "$$");
				//key - requestID + siteName + Address + Tech + RAG - expirty date
				//value - Expirty Date + Analysis Type + REfere Key.
				if(currentUserGroup_quote == "tESUsers_ES" OR  currentUserGroup_quote == "WholeSale_accountManager_ES"){
					//start New Capex
					type = "automatic";
					requestKey = responseString[1];
					techKey = responseString[3] + "##" + responseString[5]+ "##" + responseString[6];
					costString = util.getCFTCostForAccountManager_ES(type, cFTParseResponse_quote, requestKey, techKey);				
					capexCosts = split(costString,"$$");
					capexTotal = 0.0;
						if(capexCosts[0] <> ""){
							capexTotal = capexTotal + util.atof_Custom(capexCosts[0]);
						}
						if(capexCosts[4] <> ""){
							capexTotal = capexTotal +  util.atof_Custom(capexCosts[4]);
						}
						if(capexCosts[5] <> ""){
							capexTotal = capexTotal +  util.atof_Custom(capexCosts[5]);
						}
					
					//end New Capex
					if(eachRequestDetailsArray[18] == "legacyProductMPLSAndVPLSONO" OR eachRequestDetailsArray[18] == "primarioFijo" OR eachRequestDetailsArray[18] == "primarioMvil"){
						put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[13]  + "$$" + string(capexTotal)  + "$$" + capexCosts[1]  + "$$" + capexCosts[2] + "$$" + responseString[17] + "$$" +capexCosts[0] + "$$" +capexCosts[4] + "$$" +capexCosts[5] +"$$"+ responseString[8]);
					}elif(eachRequestDetailsArray[18] == "legacyProductAccesoInternetONOAndVodafone"){
						put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[13]  + "$$" + string(capexTotal)  + "$$" + capexCosts[1]  + "$$" + capexCosts[2] + "$$" + responseString[17] + "$$" +capexCosts[0] + "$$" +capexCosts[4] + "$$" +capexCosts[5] +"$$"+ responseString[8]);
					}
					elif(eachRequestDetailsArray[18] == "enlacePortador"){
						put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[13]  + "$$" + string(capexTotal)  + "$$" + capexCosts[1]  + "$$" + capexCosts[2] + "$$" + responseString[17] + "$$" +capexCosts[0] + "$$" +capexCosts[4] + "$$" +capexCosts[5] +"$$"+ responseString[8]);
					}else{
						put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[13]  + "$$" + string(capexTotal)  + "$$" + capexCosts[1]  + "$$" + capexCosts[2] + "$$" + responseString[17] + "$$" +capexCosts[4] + "$$" +capexCosts[0] + "$$" +capexCosts[5] +"$$"+ responseString[8]);
						
					}
				}else{
					type = "automatic";
					requestKey = responseString[1];
					techKey = responseString[3] + "##" + responseString[5]+ "##" + responseString[6];
					costString = util.getCFTCostForAccountManager_ES(type, cFTParseResponse_quote, requestKey, techKey);
					capexCosts = split(costString,"$$");
					capexTotal = 0.0;
					if(capexCosts[0] <> ""){
						capexTotal = capexTotal + util.atof_Custom(capexCosts[0]);
					}
					if(capexCosts[4] <> ""){
						capexTotal = capexTotal +  util.atof_Custom(capexCosts[4]);
					}
					if(capexCosts[5] <> ""){
						capexTotal = capexTotal +  util.atof_Custom(capexCosts[5]);
					}
					
					put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[13] + "$$" + string(capexTotal) + "$$" + capexCosts[1] + "$$" + capexCosts[2] + "$$" + capexCosts[3]+ "$$" + capexCosts[0] + "$$" + capexCosts[4] + "$$" + capexCosts[5] + "$$" + responseString[14]+"$$"+ responseString[8]);
				}
				
			}
		}
	}
	
	//Table4
	if(textAreaES3_quote <> "") {	
		responseParameters = split(textAreaES3_quote, "##");
		
		for eachItem in responseParameters{
			responseString = split(eachItem, "$$");
			
			//key - requestID + siteName + Address + Tech + RAG - expirty date
			//value - Expirty Date + Analysis Type + REfere Key.
			ManualFeasibilityStatus = "Manual Feasibility Done";
			if(currentUserGroup_quote == "tESUsers_ES" OR  currentUserGroup_quote == "WholeSale_accountManager_ES"){
				//start New Capex
				type = "manual";
				requestKey = responseString[1];
				techKey = "";
				costString = util.getCFTCostForAccountManager_ES(type, manualFeasibilityActualResponse_quote, requestKey, techKey);
				capexCosts = split(costString, "$$");
				capexTotal = 0.0;
				if(capexCosts[0] <> ""){
					capexTotal = capexTotal + util.atof_Custom(capexCosts[0]);
				}
				if(capexCosts[4] <> ""){
					capexTotal = capexTotal +  util.atof_Custom(capexCosts[4]);
				}
				if(capexCosts[5] <> ""){
					capexTotal = capexTotal +  util.atof_Custom(capexCosts[5]);
				}
				//commenting elif part of this loop Added Internet Legacy condition @Production - P1
				if(responseString[20] == "legacyProductMPLSAndVPLSONO"  OR responseString[20] == "primarioFijo" OR responseString[20] == "primarioMvil" OR responseString[20] == "legacyProductAccesoInternetONOAndVodafone"){
					put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[18] + "$$" + string(capexTotal) + "$$" + capexCosts[1] + "$$" + capexCosts[2] + "$$" + responseString[19] + "$$" + capexCosts[0] + "$$" + capexCosts[4] + "$$" + capexCosts[5] + "$$" + ManualFeasibilityStatus);	
				}
				else {
					put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] , responseString[7] + "$$" + responseString[11] + "$$" + responseString[18] + "$$" + string(capexTotal) + "$$" + capexCosts[1] + "$$" + capexCosts[2] + "$$" + responseString[19] + "$$" + capexCosts[4] + "$$" + capexCosts[0] + "$$" + capexCosts[5] + "$$" + ManualFeasibilityStatus);
				}
			}
			else {
				type = "manual";
				requestKey = responseString[1];
				techKey = "";				
				
				costString = util.getCFTCostForAccountManager_ES(type, manualFeasibilityActualResponse_quote, requestKey, techKey);
				//print "dsfd";
				//print costString;
				capexCosts = split(costString, "$$");
								
				capexTotal = 0.0;
				if(capexCosts[0] <> ""){
					capexTotal = capexTotal + util.atof_Custom(capexCosts[0]);
				}
				if(capexCosts[4] <> ""){
					capexTotal = capexTotal +  util.atof_Custom(capexCosts[4]);
				}
				if(capexCosts[5] <> ""){
					capexTotal = capexTotal +  util.atof_Custom(capexCosts[5]);
				}
				//print "=============Chandan======";
				
				put(configSiteDict, responseString[1] + "##" + responseString[3] + "##" + responseString[4] + "##" + responseString[5]+ "##" + responseString[6] ,  responseString[7] + "$$" + responseString[11] + "$$" + responseString[18] + "$$" + string(capexTotal) + "$$" + capexCosts[1] + "$$" + capexCosts[2] + "$$" + responseString[19] + "$$" + capexCosts[0] + "$$" + capexCosts[4] + "$$" + capexCosts[5] + "$$" + ManualFeasibilityStatus);
			}
		}
	}
	
	if(cFTAllSelectedRequestParameters_quote <> "") {
		requestParameters = split(cFTAllSelectedRequestParameters_quote, "##");	
		for each in requestParameters {
			
			//key - requestID + siteName + Address
			if(each <> "" AND not(isnull(each))) {
				params = split(each, "$$");
				//print params;
				keytoCheck = params[1] + "##" + params[2];
				//print "keytocheck";
				//print keytoCheck;
				if(params[7] == "legacyProductVPNAvalon"){
					cftRequestString = params[1] + "$$" + params[2] + "$$" + params[3] + "$$" + params[4] + "$$" + params[5];
				}elif(params[9] == "legacyProductAccesoInternetONOAndVodafone" OR params[9] == "legacyProductMPLSAndVPLSONO" OR params[9] == "primarioFijo" OR params[9] == "primarioMvil"){
					cftRequestString = params[1] + "$$" + params[2] + "$$" + params[3] + "$$" + params[4] + "$$" + params[5] + "$$" + params[6] + "$$" + params[7];
				}
				elif(params[6] == "enlacePortador"){
					cftRequestString = params[1] + "$$" + params[2] + "$$" + params[3] + "$$" + params[4];
				}else{//print "Hi..........";
					cftRequestString = params[1] + "$$" + params[2] + "$$" + params[3] + "$$" + params[4] + "$$" + params[5] + "$$" + params[6] + "$$" + params[7]+ "$$" + params[8]+ "$$" + params[9]+ "$$" + params[10]+ "$$" + params[11]+ "$$" + params[12];//print cftRequestString;
				}
				
			}
			configKeys = keys(configSiteDict);
			//print "configKeys";
			//print configKeys;
			mandictKeys = keys(cftManDict);
			//print mandictKeys;
			//Iterate selected rows
			for eachOne in configKeys{
				//check config selected key available in request paramters string.
				//print "eachOne";//print eachOne;
				if(find(eachOne, keytoCheck) <> -1) {
					//Get selected response keys
					keyDataString = split(eachOne, "##");
					
					//Get Reference Key
					valuesDataString = get(configSiteDict, eachOne);
					valuesDataArray = split(valuesDataString, "$$");
				
					if(params[7] == "legacyProductVPNAvalon"){
						selectproduct = params[7]; 
					}elif(params[9] == "legacyProductMPLSAndVPLSONO" OR params[9] == "legacyProductAccesoInternetONOAndVodafone"  OR params[9] == "primarioFijo" OR params[9] == "primarioMvil"){
						selectproduct = params[9]; 
					}elif(params[15] == "iPVPN"){
						selectproduct = params[15]; 
					}elif(params[6] == "enlacePortador"){
						selectproduct = params[6];
					}
					
					//print selectproduct;	
					//print "====================";
					//print valuesDataArray;
					//Analysis Type + Reference Kye
					selectedSiteKey = valuesDataArray[1] + "$$" + valuesDataArray[2];
					
					//print "Selected Site Key-----"; //print selectedSiteKey;
					
					//Analaysis TYpe + Reference key
					if(params[7] == "legacyProductVPNAvalon"){
						loopKey = params[5] + "$$" + params[6];
					}
					elif(params[9] == "legacyProductAccesoInternetONOAndVodafone" OR params[9] == "legacyProductMPLSAndVPLSONO" OR params[9] == "primarioFijo" OR params[9] == "primarioMvil"){
						loopKey = params[7] + "$$" + params[8];
					}elif(params[6] == "enlacePortador"){
						loopKey = params[4] + "$$" + params[5];
					}
					else{
						loopKey = params[13] + "$$" + params[14];
					}
					//print "selectedSiteKeyselectedSiteKey";
					//print selectedSiteKey;
					//print "loopKeyloopKey";
					//print loopKey;
					if(selectedSiteKey == loopKey){
							resultString = resultString + selectproduct + "$$" + cftRequestString + "$$" + keyDataString[3] + "$$" + keyDataString[4] + "$$" + valuesDataArray[3] + "$$" + valuesDataArray[4] + "$$" + valuesDataArray[5] + "$$" + valuesDataArray[6] + "$$" + keyDataString[0] + "$$" + valuesDataArray[2] + "$$" + valuesDataArray[1] + "$$" + valuesDataArray[7] + "$$" + valuesDataArray[8] + "$$" + valuesDataArray[9] + "$$" + valuesDataArray[10]+ "##";
					}
				}					
			}
		}
	}
}

finalStringArray = string[];
resultStringArray = split(resultString, "##");
finalStringDict = dict("string");
prdID = "";
for each in resultStringArray{
	prdId = util.getIndexedValue(each, "$$", 0);
	if(prdID == "enlacePortador"){
		//Analysis TYPE + referenceKey
		key = util.getIndexedValue(each, "$$", 4) + "$$" + util.getIndexedValue(each, "$$", 12);
		put(finalStringDict, key, each);
	}elif(prdID == "iPVPN"){
		key = util.getIndexedValue(each, "$$", 20) + "$$" + util.getIndexedValue(each, "$$", 21);
		put(finalStringDict, key, each);
	}elif(prdID == "legacyProductAccesoInternetONOAndVodafone"){
		key = util.getIndexedValue(each, "$$", 15) + "$$" + util.getIndexedValue(each, "$$", 16);
		put(finalStringDict, key, each);
	}elif(prdID == "legacyProductMPLSAndVPLSONO"  OR prdID == "primarioFijo" OR prdID == "primarioMvil"){
		key = util.getIndexedValue(each, "$$", 15) + "$$" + util.getIndexedValue(each, "$$", 16);
		put(finalStringDict, key, each);
	}elif(prdID == "legacyProductVPNAvalon"){
		key = util.getIndexedValue(each, "$$", 13) + "$$" + util.getIndexedValue(each, "$$", 14);
		put(finalStringDict, key, each);
	}
}

finalResultString1 = "";
finalStringArray = keys(finalStringDict);

for each in finalStringArray{
	if(containskey(finalStringDict,each)){
		if(finalResultString1 <> ""){
			finalResultString1 = finalResultString1 + "##" + get(finalStringDict, each);
		}
		else{
			finalResultString1 = get(finalStringDict, each);
		}
	}
}

return finalResultString1 + "##";