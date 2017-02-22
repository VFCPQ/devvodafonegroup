//table3 17082016 code
// PROJ-1518930_BREQ-107 BREQ changes From line 614 to 643, 1039 to 1059,1272 to 1275,
  
finalString = "";
selectProductFijoMovil="";	// 02-01-2017 For BREQ091(One Net Feasibility)
matrixCount = 0; // 02-01-2017 For BREQ091(One Net Feasibility)

techTypeResponseArrayPrimario = string[];
techTypeResponseArrayPrimarioTemp = string[];
techTypeResponseArrayPriorityLegacy = string[];
techTypeResponseDictMvilFijo=dict("string");
techTypeResponseDictInternet = dict("string");
techTypeResponseArrayLegacy = string[];
techTypeResponseDictLegacy = string[];
selectedProdLegacy = "";
selectProductLegacy = "";
techTypeResponseDictLegacyAvalon = string[];
techTypeResponseArrayAvalon = string[];
techTypeResponseArrayPriorityAvalon = string[];
techTypeResponseDictAvalon = dict("string");
selectedProdAvalon = "";
selectProductAvalon = "";
legacyArray = string[];
avalonArray = string[];
sortDict=dict("string");
sortAMFlag=false;
headFreezeStart = "";
currentUserGroup_quotefinalString = "";
if(opco_quote == "ES"){
	responseParameter = ""; lineItemsKey = "";selectedPrd =""; autoLeadTime ="";
	referKey = ""; siteType = ""; studyLeveloptions = ""; siteSize = "";
	bragStatus = ""; configStatus = "Pending Configuration";
	pendingConfig = "Pending Configuration"; location = ""; twobackup = dict("string");
	feasibilityStatus = "Automatic Feasibility Done"; techTypeResponseDict = dict("string");
	errorCodeDict = dict("string"); bestFound = false;
	techTypeResponseArray = string[]; responeKeysArray = string[]; responseValuesArray = string[];
	siteDict = dict("string"); productString = ""; atuomaticAckDict = dict("string"); bestBackupTech = dict("string");
	siteName = string[];checkConfigFlag = false; extraOne = ""; Access_RAG_COST = string[];
	count = 0;cftRequestID = 001;//CFTMANREQ
	techType = string[]; requestType = "";
	ragStatus = string[]; comments = string[]; AccessProduct = "";
	count1 = 0;count2 = 0; count3 = 0; siteAddresss = "";
	resultString =""; recordAccess =recordset(); printOneTimeOnly = false;
	siteID = String[];
	eachResponse =string[]; manualSiteResponseDict = dict("string");
	siteAddress = string[]; 
	capEx =string[];
	inOpEx = string[]; 
	LeadTime = string[];
	reOpEx = string[];
	siteID1 = string[];
	eachManualRequest = string[];
	lineItemSites = string[]; lineItemProductsDict = dict("string");
	lineItemsSitesDict = dict("string"); lineItemProductsDict = dict("string");
	lineItemProducts = string[]; responseForSingleSite = string[];
	SiteAddDict = dict("string");
	RequestIDDict = dict("string");
	discardFeasibilityResponse = dict("string");
	responseRequestIDArray = string[]; listOfTechArray  = string[];
	responseRequestIDdict = dict("string");
	manualResponseDict = dict("string");
	techTypeDict = dict("string");
	requestParameter = "";
	eachRequest1 =string[];
	reasonCode = string[];
	reasonMsg = string[]; responseParameter = "";
	errorMsg = ""; technicalDetails = ""; type = "automatic"; profile = "";
	expiryDate = ""; configureRAGStatus = ""; autoFeasiblityID = "";
	techType1 = string[]; ragStatus1 =  string[]; configureRAGStatusString = ""; configureRAGStatusArray = string[];
	countT = 0; requestID = ""; getRequestID = ""; //cFTResponseForSingleSite_quote= string[];
	errorMsgFlag = false; errorMsg = ""; errorMsgFlagwithResult = false;
	capExValue = ""; inOpExValue = ""; reOpExValue = ""; columnHeader11 = ""; columnData11 = "";
	xmlResponse = ""; cpqRequestID = "";technology = "";
	xmlResponse = cFTParseResponse_quote; 
	filterAccessString = ""; cftMain = ""; cftBackup = "";
	siteName1= "";bestBackup = dict("string");
	maxLeadTime = "";
	headerForSales = "";
	headerForTES = "";
	prdName = "";
	selectedProdTemp = "";
	service = "";
	backupService = "";
	mainBandwidth = "";
	backupBandwidth = "";
	modalidadAcceso = "";
	tallaPpal = "";
	voiP = "";
	vpnLan = "";
	cosipvpn = "";
	internet = "";
	total = 0;
	recordFilterTES  = recordset(); recordFilterAM = recordset();
	techTypeResponseArrayPriority = string[];
	legacyInternet = string[];
	legacyMPLS = string[];
	legacyAvalon = string[];
	zeroPriorityFlag = false;

	childCounter = "";
	if(parentChildStatus == "Child"){
		childCounter = "C" + string(childQuotesCounter); 	
	}

	checkWA = string[]; // @chetan g -> PROJ-1619822_BUG-1303 -> 22-09
	WATech = ""; // @chetan g -> PROJ-1619822_BUG-1303 -> 22-09

	headFreezeStart = "<div id= \"dwrapper\">";
	headFreezeEnd = "</div>";

	if(_system_current_user_language == "es"){

		headerForSales = "<table id=\"fixed_hdr2\"> <thead><tr style=\"background-color: rgb(238, 238, 238);\"><th style=\"background-color: #1797C0\">Escoger </th><th style=\"background-color: #1797C0\">ID de solicitud</th><th style=\"background-color: #1797C0\">Estado configuración</th><th style=\"background-color: #1797C0\">Nombre Sede</th><th style=\"background-color: #1797C0\">Dirección completa</th><th style=\"background-color: #1797C0\">Product Name</th><th style=\"background-color: #1797C0\">Service</th><th style=\"background-color: #1797C0\">Backup Service</th><th style=\"background-color: #1797C0\">Main Bandwidth</th><th style=\"background-color: #1797C0\">Backup Bandwidth</th><th style=\"background-color: #1797C0\">Modalidad Acceso</th><th style=\"background-color: #1797C0\">Talla Ppal</th><th style=\"background-color: #1797C0\">VPN IP</th><th style=\"background-color: #1797C0\">VPN LAN</th><th style=\"background-color: #1797C0\">CoS</th><th style=\"background-color: #1797C0\">Internet</th><th style=\"background-color: #1797C0\">Tipo analisis</th><th style=\"background-color: #1797C0\">Tecnología de Acceso</th><th style=\"background-color: #1797C0\">BRAG estado</th><th style=\"background-color: #1797C0\">Tiempo espera</th><th style=\"background-color: #1797C0\">Id viabilidad automática</th><th style=\"background-color: #1797C0\">Fecha caducidad</th><th style=\"background-color: #1797C0\">Estado viabilidad</th><th style=\"background-color: #1797C0\">CFT descripción error</th><th style=\"background-color: #1797C0\">Related Site Reference</th><th style=\"background-color: #1797C0\">Nivel de estudio</th><th style=\"background-color: #1797C0\">Detalles técnicos</th></tr></thead><tbody>";

		headerForTES = "<table id=\"fixed_hdr2\"><thead ><tr><th style=\"background-color: #1797C0\">Escoger </th><th style=\"background-color: #1797C0\">ID de solicitud</th><th style=\"background-color: #1797C0\">Estado configuración</th><th style=\"background-color: #1797C0\">Nombre Sede</th><th style=\"background-color: #1797C0\">Dirección completa</th><th style=\"background-color: #1797C0\">Product Name</th><th style=\"background-color: #1797C0\">Service</th><th style=\"background-color: #1797C0\">Backup Service</th><th style=\"background-color: #1797C0\">Main Bandwidth</th><th style=\"background-color: #1797C0\">Backup Bandwidth</th><th style=\"background-color: #1797C0\">Modalidad Acceso</th><th style=\"background-color: #1797C0\">Talla Ppal</th><th style=\"background-color: #1797C0\">VPN IP</th><th style=\"background-color: #1797C0\">VPN LAN</th><th style=\"background-color: #1797C0\">CoS</th><th style=\"background-color: #1797C0\">Internet</th><th style=\"background-color: #1797C0\">Tipo analisis</th><th style=\"background-color: #1797C0\">Tecnología de Acceso</th><th style=\"background-color: #1797C0\">BRAG estado</th><th style=\"background-color: #1797C0\">CAPEX Acceso</th><th style=\"background-color: #1797C0\">OPEX Alta Acceso</th><th style=\"background-color: #1797C0\">OPEX Cuota Acceso</th><th style=\"background-color: #1797C0\">Tiempo espera</th><th style=\"background-color: #1797C0\">Id viabilidad automática</th><th style=\"background-color: #1797C0\">Fecha caducidad</th><th style=\"background-color: #1797C0\">Estado viabilidad</th><th style=\"background-color: #1797C0\">CFT descripción error</th><th style=\"background-color: #1797C0\">Related Site Reference</th><th style=\"background-color: #1797C0\">Nivel de estudio</th><th style=\"background-color: #1797C0\">Detalles técnicos</th></tr></thead><tbody>"; 

	}
	else{

		headerForSales = "<table id=\"fixed_hdr2\"> <thead><tr style=\"background-color: rgb(238, 238, 238);\"><th style=\"background-color: #1797C0\">Select</th><th style=\"background-color: #1797C0\">Request ID</th><th style=\"background-color: #1797C0\">Configuration Status</th><th style=\"background-color: #1797C0\">Nombre Sede</th><th style=\"background-color: #1797C0\">Dirección completa</th><th style=\"background-color: #1797C0\">Product Name</th><th style=\"background-color: #1797C0\">Service</th><th style=\"background-color: #1797C0\">Backup Service</th><th style=\"background-color: #1797C0\">Main Bandwidth</th><th style=\"background-color: #1797C0\">Backup Bandwidth</th><th style=\"background-color: #1797C0\">Modalidad Acceso</th><th style=\"background-color: #1797C0\">Talla Ppal</th><th style=\"background-color: #1797C0\">VPN IP</th><th style=\"background-color: #1797C0\">VPN LAN</th><th style=\"background-color: #1797C0\">CoS</th><th style=\"background-color: #1797C0\">Internet</th><th style=\"background-color: #1797C0\">Analaysis Type</th><th style=\"background-color: #1797C0\">Tecnología de Acceso</th><th style=\"background-color: #1797C0\">BRAG estado</th><th style=\"background-color: #1797C0\">Lead Time</th><th style=\"background-color: #1797C0\">Auto Feasibility ID</th><th style=\"background-color: #1797C0\">Expiry Date</th><th style=\"background-color: #1797C0\">Feasibility Status</th><th style=\"background-color: #1797C0\">CFT Error Desc</th><th style=\"background-color: #1797C0\">Related Site Reference</th><th style=\"background-color: #1797C0\">Study Level</th><th style=\"background-color: #1797C0\">Technical Details</th></tr></thead><tbody>";//<th>Backup Access</th><th>Backup BRAG</th>

		headerForTES = "<table id=\"fixed_hdr2\"><thead ><tr><th style=\"background-color: #1797C0\">Select</th><th style=\"background-color: #1797C0\">Request ID</th><th style=\"background-color: #1797C0\">Configuration Status</th><th style=\"background-color: #1797C0\">Nombre Sede</th><th style=\"background-color: #1797C0\">Dirección completa</th><th style=\"background-color: #1797C0\">Product Name</th><th style=\"background-color: #1797C0\">Service</th><th style=\"background-color: #1797C0\">Backup Service</th><th style=\"background-color: #1797C0\">Main Bandwidth</th><th style=\"background-color: #1797C0\">Backup Bandwidth</th><th style=\"background-color: #1797C0\">Modalidad Acceso</th><th style=\"background-color: #1797C0\">Talla Ppal</th><th style=\"background-color: #1797C0\">VoiP</th><th style=\"background-color: #1797C0\">VPN LAN</th><th style=\"background-color: #1797C0\">CoS</th><th style=\"background-color: #1797C0\">Internet</th><th style=\"background-color: #1797C0\">Analaysis Type</th><th style=\"background-color: #1797C0\">Tecnología de Acceso</th><th style=\"background-color: #1797C0\">BRAG estado</th><th style=\"background-color: #1797C0\">CAPEX Acceso</th><th style=\"background-color: #1797C0\">OPEX Alta Acceso</th><th style=\"background-color: #1797C0\">OPEX Cuota Acceso</th><th style=\"background-color: #1797C0\">Lead Time</th><th style=\"background-color: #1797C0\">Auto Feasibility ID</th><th style=\"background-color: #1797C0\">Expiry Date</th><th style=\"background-color: #1797C0\">Feasibility Status</th><th style=\"background-color: #1797C0\">CFT Error Desc</th><th style=\"background-color: #1797C0\">Related Site Reference</th><th style=\"background-color: #1797C0\">Study Level</th><th style=\"background-color: #1797C0\">Technical Details</th></tr></thead><tbody>"; 
	 
	}
	//Get CFT resposne
	if(cFTParseResponse_quote <> "") {
	 responseParameter = cFTParseResponse_quote ;
	}
	if(cFTRequestParameter_quote <> "" AND cFTParseResponse_quote == "Error"){
	  errorMsgFlag = true;
	}

	if(responseParameter <> ""){
	  eachResponse = split(responseParameter,"$,$");
	}

	if(cFTAllSelectedRequestParameters_quote <> ""){
	  requestParameter = cFTAllSelectedRequestParameters_quote;
	}

	if(manualFeasibilityRecords_quote <> ""){
	  eachManualRequest = split(manualFeasibilityRecords_quote,"$,$");
	}
	if(opco_quote == "ES" AND cFTParseResponse_quote <> "" AND NOT(ISNULL(cFTParseResponse_quote))){
		//Prepare dictonary for manual feasibility request.
		//CFTREQ2$$Pending Configuration$$BARC001$$24 Av. de Bruselas Madrid Spain Ireland$$ULL ADSL$$B$$44.0$$1.0$$44.0$$Manual Feasibility Done
		for each in eachManualRequest{
			if(each <> "") {
				eachOne = split(each , "$$");
				//key - REQUESTID**SITEID**ACCESS - value=>FeasibilityStatus
				key2 = eachOne[0] + "**" + eachOne[2] + "**" + eachOne[4];
				
				put(manualResponseDict , key2, eachOne[9] + "**" + eachOne[6] + "**" + eachOne[7] + "**" + eachOne[8]);
				put(techTypeDict , eachOne[0] + "**" + eachOne[2], eachOne[4] + "##" + eachOne[5]);
			}
		}

		//CFTREQ1$$Callao-46184$$Carrer,Perdiu,,74,,,46184,Colinas de San Antonio,Valencia,Spain,39.55,-0.5$$Y$$Y$$N$$N$$S$$None$$Horario de oficina 8x5$$Estandar$$Alquiler$$BASICO$$$$$$$$$$##
		if(responseParameter <> "") {
		  eachRequest1 = split(requestParameter,"##");
		}

		//CFTREQ2$$FernandoVela$$Calle,de Fernando Vela,,2,,,33001,Oviedo,Asturias,Spain,43.36746843,-5.8452424$$a10M$$Delicias__FernandoVela
		for each in eachRequest1{
			if(each <> "") {
				eachOne = split(each , "$$");
				
				key1 = eachOne[0]+ "**" + replace(eachOne[1]," ","");

				//Append Site Type and Reference Key
				if(eachOne[6] == "enlacePortador"){
					put(SiteAddDict , eachOne[1], eachOne[2]+"@@"+eachOne[4]+"@@"+eachOne[5] +"@@"+eachOne[6] +"@@"+eachOne[3]);
					if(containskey(RequestIDDict, key1) == false){
						put(RequestIDDict , key1, eachOne[2]+"@@"+eachOne[4]+"@@"+eachOne[5]+"@@"+eachOne[6] +"@@"+eachOne[3]);
					}
				}elif(eachOne[9] == "legacyProductMPLSAndVPLSONO" OR eachOne[9] == "legacyProductAccesoInternetONOAndVodafone"){		
					put(SiteAddDict , eachOne[1], eachOne[2] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" +eachOne[7]+ "@@" +eachOne[8] +"@@"+eachOne[9]);
					if(containskey(RequestIDDict, key1) == false){
						put(RequestIDDict , key1, eachOne[2] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" +eachOne[7] + "@@" +eachOne[8]+"@@"+eachOne[9] + "@@"+ eachOne[5] + "@@" + eachOne[6]);
					}
				}elif(eachOne[7] == "legacyProductVPNAvalon"){			
					put(SiteAddDict , eachOne[1], eachOne[2] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" +eachOne[5]+ "@@" +eachOne[6]+"@@"+eachOne[7] + "@@" + eachOne[9] + "@@" +eachOne[10]);
					if(containskey(RequestIDDict, key1) == false){
						put(RequestIDDict , key1, eachOne[2] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" +eachOne[5]+ "@@" +eachOne[6]+"@@"+eachOne[7] + "@@" + eachOne[9] + "@@" + eachOne[10]);
					}
				}elif(eachOne[9] == "primarioFijo" OR eachOne[9] == "primarioMvil"){	//@Chetan G / 28-12-2016/ For BREQ091(One Net Feasibility)
					put(SiteAddDict , eachOne[1], eachOne[2] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" +eachOne[7]+ "@@" +eachOne[8] +"@@"+eachOne[9]);
					if(containskey(RequestIDDict, key1) == false){
						put(RequestIDDict , key1, eachOne[2] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" +eachOne[7] + "@@" +eachOne[8]+"@@"+eachOne[9] + "@@"+ eachOne[5] + "@@" + eachOne[6]);
					}
				}else{
					put(SiteAddDict , eachOne[1], eachOne[2]+"@@"+eachOne[7] + "@@" + eachOne[13]+ "@@" + eachOne[14]+ "@@" + eachOne[15]+ "@@" + eachOne[8] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" + eachOne[5] + "@@" + eachOne[6]);
					if(containskey(RequestIDDict, key1) == false){
						put(RequestIDDict , key1, eachOne[2] + "@@" + eachOne[7] + "@@" + eachOne[13] + "@@" + eachOne[14]+ "@@" + eachOne[15]+ "@@" + eachOne[8] + "@@" + eachOne[3] + "@@" + eachOne[4] + "@@" + eachOne[5] + "@@" + eachOne[6]);
						
						referKeyIpvpn = eachOne[14];
											
						if(containskey(bestBackup, referKeyIpvpn)){
							put(bestBackup, referKeyIpvpn, get(bestBackup, referKeyIpvpn) + "**" + eachOne[13]);
						}else{
							put(bestBackup, referKeyIpvpn, eachOne[13]);
						}
					}
				}
				//Storing request ID against requestID+siteID			
			}
		}
		
		//Code for TES User
		if(currentUserGroup_quote == "tESUsers_ES" OR currentUserGroup_quote == "WholeSale_accountManager_ES"){
			for each in eachResponse{
				if(each <> "" AND each <> "Error"){
					response = split(each, "$$") ;
					feasibility = split(each, "@@") ;		
					expiryDate = feasibility[1];
					
					autoFeasiblityID = feasibility[2];
					requestID = feasibility[3];
					
					if(find(each, "#,#") <> -1){
						requestID = feasibility[1];
					}
					
				
					for each1 in response{
						if(each1 <> "" AND not(isnull(each1))) {
							if(find(each1, "#,#") <> -1) {
								errorScreen = split(each1, "@@");
								
								for each22 in errorScreen{

									if(each22 <> "" AND not(isnull(each22))) {
										errorMessages = split(each22, "#,#");

										siteID[count1] = errorMessages[0];
										
										if(errorMessages[2] <> "" AND not(isnull(errorMessages[2]))){
											expiryDate = "";
											put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + "MSG", errorMessages[2]);
										}
										
									}
								}
							}
							else{
					
								lineValues = split(each1 , "##");
								//check size of array for error code if array length is 2 then there is error.
								//if(sizeofarray(lineValues) > 2) { 
								if(lineValues[0] <> "" AND not(isnull(lineValues[0]))) {
									siteID[count1] = lineValues[0];
								}
								
								if(lineValues[2] <> "" AND not(isnull(lineValues[2]))) {
									if(find(each, "#,#") <> -1) {
										errorMessages = split(each, "#,#");
										reasonMsg[count1] = errorMessages[2];
										ragStatus1[count1] = " ";
										//Put Error Message RequestID + SITEID = Error Response
										put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + "MSG", errorMessages[2]);
									}else{
										ragStatus1[count1] = lineValues[2];
										reasonMsg[count1] = " ";
									}
								}
								
								total = 0;
								/*if(lineValues[3] <> "" AND not(isnull(lineValues[3]))) {
									capEx[count1] = lineValues[3];
								}	*/	//commented by santhosh for new capex values implementation			
								if(lineValues[3] <> "" AND not(isnull(lineValues[3]))) {
									total  = total + util.atof_Custom(lineValues[3]);
								} 
								if(lineValues[7] <> "" AND not(isnull(lineValues[7]))) {
									total  = total + util.atof_Custom(lineValues[7]);
								} 
								if(lineValues[8] <> "" AND not(isnull(lineValues[8]))) {
									total  = total + util.atof_Custom(lineValues[8]);
								} 
								capEx[count1] = string(total);	
													
								if(lineValues[4] <> "" AND not(isnull(lineValues[4]))) {
									inOpEx[count1] = lineValues[4];
								}
								if(lineValues[5] <> "" AND not(isnull(lineValues[5]))) {
									reOpEx[count1] = lineValues[5];
								}
								if(lineValues[6] <> "" AND not(isnull(lineValues[6]))) {
									leadTime[count1] = replace(lineValues[5], "@@" + expiryDate,"");
								}
								if(lineValues[1] <> "" AND not(isnull(lineValues[1]))) {
									if(sizeofarray(lineValues) == 3) { 
										reasonCode[count1] = lineValues[1];
										//Put Error Message RequestID + SITEID = Error Response
										//put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" +"CODE", lineValues[1]);
									}else{
										//print "in else";
										//Tech Type Prodcuts agains request - REQUESTID+**+Tech Type = Tech Type
										//Commented By Chandan(19th July)
										//if(selectProductFijoMovil <> "primarioFijo" AND selectProductFijoMovil <> "primarioMvil" AND lineValues[1]<>"VF EFM" AND lineValues[1]<>"VF FTTH"){
										//print "this is the one";
										put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus1[count1] + "**" + capEx[count1] + "**" + inOpEx[count1] + "**" + reOpEx[count1] + "**" + leadTime[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
										reasonCode[count1] = " ";
										append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
										//}
										
									}
								}
								responseRequestIDArray[count1] = requestID;
								put(responseRequestIDdict, requestID + "**" + siteID[count1], requestID);
								count1 = count1 + 1;
							}
						}
					}
				}elif(each == "Error"){
					errorMsgFlagwithResult = true;
				}
			}
		}
		else{		
			for each in eachResponse {
				if(each <> "" AND each <> "Error"){			
					//Full Response String
					feasibility = split(each, "@@");		
					
					//First Array element having cost and accesss technology
					response = split(feasibility[0], "$$");
					
					expiryDate = feasibility [1];	
					
					if(find(each, "#,#") <> -1){
						requestID = feasibility[1];
					}else{
						requestID = feasibility[3];
					}
					
					autoFeasiblityID = feasibility[2];			
					
					siteValue = each;				
					for each1 in response{				
						
						if(find(each1, "#,#") == -1){
							
							lineValues = split(each1 , "##");
							if(lineValues[2] == "G" OR lineValues[2] == "B" OR lineValues[2] == "A" OR lineValues[2] == "R") {
								
								//Get Site Name
								if(lineValues[0] <> "" AND not(isnull(lineValues[0]))){
									siteID[count1] = lineValues[0];
								}
								
								//Need to change error handling logic
								if(lineValues[2] <> "" AND not(isnull(lineValues[2]))){
									if(sizeofarray(lineValues) == 3) {
										append(reasonMsg,lineValues[2]);
										ragStatus[count1] = " ";
										put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + "MSG", lineValues[2]);
									}else{
										ragStatus[count1] = lineValues[2];
										//;reasonMsg[count1] = " ";
										append(reasonMsg, " ");
									}
								}
								
								//Storing Access Technology, Expiry Date and Auto Feasibility ID
								if(lineValues[1] <> "" AND not(isnull(lineValues[1]))){
									if(sizeofarray(lineValues) == 3) { 
										reasonCode[count1] = lineValues[1];
									//	put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + "CODE", lineValues[1]);
									}else{									
										//Get list of valid technology for selected site size and filter it out in repsonse.
										if(containskey(RequestIDDict, requestID +"**" + siteID[count1])){
											getSiteDetailsString = get(RequestIDDict, requestID +"**" + siteID[count1]);								
											requestSiteSize = util.getIndexedValue(getSiteDetailsString, "@@", 1);
											analysisTOCheck = util.getIndexedValue(getSiteDetailsString, "@@", 2);
											selectProduct = util.getIndexedValue(getSiteDetailsString, "@@", 4);
											selectProductFM = util.getIndexedValue(getSiteDetailsString, "@@", 5);
											selectedProdLegacy = util.getIndexedValue(getSiteDetailsString, "@@", 5);
											selectedProdAvalon = util.getIndexedValue(getSiteDetailsString, "@@", 5);
											selectedProdTemp = selectProduct;										
											listOfTechArray = util.getListOfTechnologiesForIPVPNBasedOnSiteSize(requestSiteSize, type, profile);
											
											if(selectedProdTemp == "iPVPN" AND findinarray(listOfTechArray, lineValues[1]) <> -1 ){
											//if(selectProductES_quote == "iPVPN" AND findinarray(listOfTechArray, lineValues[1]) <> -1 ){ //by santhosh											
												if(containskey(bestBackup, util.getIndexedValue(getSiteDetailsString, "@@", 3))){
													stringToCheck = get(bestBackup, util.getIndexedValue(getSiteDetailsString, "@@", 3));
													if(find(stringToCheck, "Main") <> -1 AND find(stringToCheck, "Backup") <> -1){
														if(containskey(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3))){
															
															techRequestCompare = get(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3));
															
															techCompare = util.getIndexedValue(techRequestCompare, "**", 0);
															requestCompare = util.getIndexedValue(techRequestCompare, "**", 1);
															if(techCompare <> lineValues[1] AND analysisTOCheck == "Main"){
																bestFound = true;
												
																put(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3), techCompare+"**"+ requestID);
																
																put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + techCompare, ragStatus[count1] + "**" + expiryDate + "**"+autoFeasiblityID);
																append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
																//Replace Backup repsone
																
																put(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3), lineValues[1] + "**"+ requestCompare);
																
																//Commented by Chetan B Gosavi on 04-01-2017 / Issue: Some Automatic responses gets invisible for AM 
																// put(techTypeResponseDict, requestCompare + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**"+autoFeasiblityID); 
																// And added below code @Chetan
																//print lineValues[1];print "lineValues[1]lineValues[1]lineValues[1]lineValues[1]397";
																put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**"+autoFeasiblityID);
																
															}elif(techCompare <> lineValues[1] AND analysisTOCheck == "Backup"){
																bestFound = true;
												
																put(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3), lineValues[1] +"**"+ requestID);
																
																put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
																append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
															}
															
														}else{
															bestFound = true;
												
															put(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3), lineValues[1] +"**"+ requestID
															);
															
															put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
															append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
														}
														
													}
													else{
														bestFound = true;										
														put(bestBackupTech, util.getIndexedValue(getSiteDetailsString, "@@", 3), lineValues[1]);
														
														put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
														append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
													
													}
												}
												
											}if(selectProductFM == "primarioFijo" OR selectProductFM == "primarioMvil"){
											//if(selectProductES_quote <> "iPVPN"){by santhosh
											//print lineValues[1];print "lineValues[1]lineValues[1]432";
												put(techTypeResponseDictMvilFijo, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
												//append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
											
											}elif(selectedProdLegacy == "legacyProductAccesoInternetONOAndVodafone" OR selectedProdLegacy == "legacyProductMPLSAndVPLSONO"){
												put(techTypeResponseDictInternet, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
												 append(techTypeResponseArrayPriorityLegacy,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
											}
											elif(selectedProdAvalon == "legacyProductVPNAvalon"){
												put(techTypeResponseDictAvalon, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
												 append(techTypeResponseArrayPriorityAvalon,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
											}elif(selectedProdTemp <> "iPVPN"){
												put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
												append(techTypeResponseArrayPriority,requestID + "**" + siteID[count1] + "**" + lineValues[1]);
											
											}											
											reasonCode[count1] = " ";
										}
										
									}
								}
							}
						}
						else {
							autoFeasiblityID = "";						
							//lineValues = split(each1 , "#,#");
							lineValues = split(each1 , "##");						
							//Get Site Name
							if(lineValues[0] <> "" AND not(isnull(lineValues[0]))){
								if(find(lineValues[0], "#,#") <> -1) {
									errorMessages = split(lineValues[0], "#,#");
									siteID[count1] = errorMessages[0];
								}else{
									siteID[count1] = lineValues[0];
								}
							}
							
							if(lineValues[0] <> "" AND not(isnull(lineValues[0]))){
								if(find(lineValues[0], "#,#") <> -1) {
									expiryDate = " ";
									errorMessages = split(lineValues[0], "#,#");
									append(reasonMsg, errorMessages[2]);
									ragStatus[count1] = " ";
									put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + "MSG", errorMessages[2]);
								}else{
									ragStatus[count1] = lineValues[2];
									reasonMsg[count1] = " ";
									append(reasonMsg, " ");
								}
							}
							
							if(lineValues[0] <> "" AND not(isnull(lineValues[0]))){
								if(find(lineValues[0], "#,#") <> -1) {
									expiryDate = " ";
									errorMessages = split(lineValues[0], "#,#");
									reasonCode[count1] = errorMessages[1];
								}else{								
									if(containskey(RequestIDDict, requestID +"**" + siteID[count1])){
										getSiteDetailsString = get(RequestIDDict, requestID +"**" + siteID[count1]);
										requestSiteSize = util.getIndexedValue(getSiteDetailsString, "@@", 1);
										listOfTechArray = util.getListOfTechnologiesForIPVPNBasedOnSiteSize(requestSiteSize, type, profile);
										
									}
									put(techTypeResponseDict, requestID + "**" + siteID[count1] + "**" + lineValues[1], ragStatus[count1] + "**" + expiryDate + "**" + autoFeasiblityID);
									reasonCode[count1] = " ";
								}
							}

						}
						put(responseRequestIDdict, requestID + "**" + siteID[count1], requestID);
						if(containskey(RequestIDDict, requestID +"**" + siteID[count1])){
							getSiteDetailsString = get(RequestIDDict, requestID +"**" + siteID[count1]);	
							//print "499:"+getSiteDetailsString;
							selectProduct = util.getIndexedValue(getSiteDetailsString, "@@", 4);
							if(find(getSiteDetailsString,"primarioFijo") > -1 OR find(getSiteDetailsString,"primarioMvil") > -1){// Added by Chetan Gosavi / 28-01-2017 For BREQ091(One Net Feasibility)(Regression Issue)
								selectProductFijoMovil = util.getIndexedValue(getSiteDetailsString, "@@", 5);	// 02-01-2017 For BREQ091(One Net Feasibility)
							}
							if(find(getSiteDetailsString,"legacyProductAccesoInternetONOAndVodafone") > -1 OR find(getSiteDetailsString,"legacyProductMPLSAndVPLSONO") > -1){
								selectProductLegacy = util.getIndexedValue(getSiteDetailsString, "@@", 5);	
							}
							if(find(getSiteDetailsString,"legacyProductVPNAvalon") > -1 ){
								selectProductAvalon = util.getIndexedValue(getSiteDetailsString, "@@", 5);
							}
							selectedProdTemp = selectProduct;
							if(selectedProdTemp == "iPVPN" AND bestFound == true){
								bestFound = false;
								break;
							}
						}
						count1 = count1 + 1;
						//@Add check for Legacy MPLS + Internet
						/*if(selectProductES_quote == "iPVPN" AND bestFound == true){ by santhosh
							bestFound = false;
							break;
						}*/
					}
					responseRequestIDArray[countT] = requestID;
				}elif(each == "Error") {
					errorMsgFlagwithResult = true;
				}
				
				siteID1[countT] = siteID[0];
				techType1[countT] = techType[0];
				ragStatus1[countT] = ragStatus[0];
				count1 = 0;
				countT = countT + 1;
			}
		}
		
		//Code of update configuration status.
		for line in line_process{
			if(line.siteName_line <> ""){
				append(lineItemSites , line.siteName_line);
				location = line.siteName_line;
				location = replace(location, " ", "");
			//append(lineItemProducts, line.cPQProductES_line);
			}
			if(line._line_item_comment <> ""){			
				comments = split(line._line_item_comment, "**");			
				commentProds = split(comments[25], "##");			
				if(productString == "") {
					productString = line.cPQProductES_line;
				} else {
					productString = productString + "##" + line.cPQProductES_line;	
				}			
				if(comments[28] <> "" AND not(isnull(comments[28]))) {
					//if(comments[29] <> "" AND not(isnull(comments[29]))) {
						put(lineItemsSitesDict , util.getIndexedValue(comments[28], "##", 0) + "**" + location, comments[28]);
						//Line Item Products dict agains Site Format - REQUESTID+**+SITENAME = Products
						put(lineItemProductsDict, comments[28] + "**" + location, productString + "##" + commentProds[0]);
					//}
				}
			}
		}
		
		//start PROJ-1518930_BREQ-107 BREQ Account Manager cant see "0" priority Technologies
		x = 0;
		y = 0;
		z = 0;
		if(currentUserGroup_quote == "accountManager_ES"){
			if(selectProductLegacy == "legacyProductAccesoInternetONOAndVodafone"){
				zeroPrioritylegacyInternet = bmql("select Technology from FeasibilityPriority where Priority = '0' AND Type = 'Internet Legacy'");
				//print zeroPriorityResults;
				for each in zeroPrioritylegacyInternet{
					legacyInternet[x] = get(each, "Technology");
					x = x +1;
				}
			}
			if(selectProductLegacy == "legacyProductMPLSAndVPLSONO"){
				zeroPrioritylegacyMPLS = bmql("select Technology from FeasibilityPriority where Priority = '0' AND Type = 'MPLS and VPLS Legacy'");
				//print zeroPriorityResults;
				for each in zeroPrioritylegacyMPLS{
					legacyMPLS[y] = get(each, "Technology");
					y = y +1;
				}
			}
			if(selectProductAvalon == "legacyProductVPNAvalon"){
				zeroPrioritylegacyAvalon = bmql("select Technology from FeasibilityPriority where Priority = '0' AND Type = 'Legacy Avalon'");
				//print zeroPriorityResults;
				for each in zeroPrioritylegacyAvalon{
					legacyAvalon[z] = get(each, "Technology");
					z = z +1;
				}
			}
			
		}
		//END PROJ-1518930_BREQ-107 BREQ Account Manager cant see "0" priority Technologies

		techTypeResponseArray = sort(keys(techTypeResponseDict));
		techTypeResponseArray = techTypeResponseArrayPriority;
		//Disable for concurrent need to work on this
		//techTypeResponseArray=util.sortingFeasibilityResponseNew(techTypeResponseArray,"");
		if(parentChildStatus <> "Child"){
			techTypeResponseArray=util.sortingFeasibilityResponseParentChild(techTypeResponseArray,"", parentChildStatus, childQuotesCounter);	
		}	
		//techTypeResponseArray = string[];	
		if(selectedProdTemp == "iPVPN" AND currentUserGroup_quote == "accountManager_ES" AND find(cFTParseResponse_quote, "QC") == -1){
			 productis = "";		 
			 //commented by Chetan Gosavi 05-01-2017
			 techTypeResponseArray = util.getBestBackupForSalesUser(techTypeResponseArray,selectedProdTemp,cFTAllSelectedRequestParameters_quote,cFTParseResponse_quote);
			 
			 //techTypeResponseArray=util.sortingFeasibilityResponseNew(techTypeResponseArray,"");
			 if(parentChildStatus <> "Child"){
				techTypeResponseArray=util.sortingFeasibilityResponseParentChild(techTypeResponseArray,"", parentChildStatus, childQuotesCounter);
			 }
		}
		techTypeResponseArrayPrimario = string[];
		// 02-01-2017 For BREQ091(One Net Feasibility)
		if((selectProductFijoMovil == "primarioFijo" OR selectProductFijoMovil == "primarioMvil") AND currentUserGroup_quote == "accountManager_ES" ){
			productis = "";

			blackListArray = string[];
			if(blacklistFiber_es_quote)
			{
			append(blackListArray,"FIBER");
			}
			if(blacklistRadio_es_quote)
			{
			append(blackListArray,"RADIO");
			}
			if(blacklistORLA_es_quote)
			{
			append(blackListArray,"ORLA T");
			}
			//techTypeResponseArray = util.getBestBackupForSalesUser(techTypeResponseArray,selectedProdTemp,cFTAllSelectedRequestParameters_quote,cFTParseResponse_quote);

			techTypeResponseArrayPrimarioTemp=util.applyPriorityMatrixForOneNetPrimary(cFTParseResponse_quote, cFTAllSelectedRequestParameters_quote, blackListArray);
			//techTypeResponseArray=util.sortingFeasibilityResponseNew(techTypeResponseArray,"");
			if(parentChildStatus <> "Child"){
				techTypeResponseArrayPrimarioTemp=util.sortingFeasibilityResponseParentChild(techTypeResponseArrayPrimarioTemp,"", parentChildStatus, childQuotesCounter);
			}
			if(NOT(ISNULL(techTypeResponseArrayPrimarioTemp)) AND NOT(isempty(techTypeResponseArrayPrimarioTemp))){
				for techTypeResponseArrayPrimarioTempeach in techTypeResponseArrayPrimarioTemp{
					append(techTypeResponseArray,techTypeResponseArrayPrimarioTempeach);
				}
			}
			techTypeResponseDictMFkey=keys(techTypeResponseDictMvilFijo);
			for techTypeResponseDictMFkeyeach in techTypeResponseDictMFkey{
				put(techTypeResponseDict,techTypeResponseDictMFkeyeach,get(techTypeResponseDictMvilFijo,techTypeResponseDictMFkeyeach));
			}
		}
		
		if((selectProductLegacy == "legacyProductAccesoInternetONOAndVodafone" OR selectProductLegacy == "legacyProductMPLSAndVPLSONO") AND currentUserGroup_quote == "accountManager_ES" ){
			techTypeResponseDictLegacy = sort(keys(techTypeResponseDictInternet));
			techTypeResponseDictLegacy = techTypeResponseArrayPriorityLegacy;
			for techTypeResponseDictLegacykeyeach in techTypeResponseDictLegacy{
				put(techTypeResponseDict,techTypeResponseDictLegacykeyeach,get(techTypeResponseDictInternet,techTypeResponseDictLegacykeyeach));
				append(legacyArray,techTypeResponseDictLegacykeyeach);
			}	
			techTypeResponseArrayLegacy=keys(techTypeResponseDict);
			techTypeResponseArrayLegacy = legacyArray;
			
			for techTypeResponseArrayLegacyeach in techTypeResponseArrayLegacy{
				append(techTypeResponseArray,techTypeResponseArrayLegacyeach);
			}
		}
		
		if(selectProductAvalon == "legacyProductVPNAvalon" AND currentUserGroup_quote == "accountManager_ES"){
			techTypeResponseDictLegacyAvalon = sort(keys(techTypeResponseDictAvalon));

			techTypeResponseDictLegacyAvalon = techTypeResponseArrayPriorityAvalon;		
			for techTypeResponseDictAvalonkeyeach in techTypeResponseDictLegacyAvalon{
				put(techTypeResponseDict,techTypeResponseDictAvalonkeyeach,get(techTypeResponseDictAvalon,techTypeResponseDictAvalonkeyeach));
				append(avalonArray,techTypeResponseDictAvalonkeyeach);
			}	
			techTypeResponseArrayAvalon=sort(keys(techTypeResponseDict));
			techTypeResponseArrayAvalon=avalonArray;
			
			for techTypeResponseArrayLegacyAvaloneach in techTypeResponseArrayAvalon{
				append(techTypeResponseArray,techTypeResponseArrayLegacyAvaloneach);
			}
		}
		techTypeResponseArray = util.sortingFeasibilityResponseParentChild(techTypeResponseArray,"", parentChildStatus, childQuotesCounter);	
		
		eachAutomaticackResponse = string[];
		if(cFTParseResponse_quote <> "") {
		  eachAutomaticackResponse = split(cFTParseResponse_quote,"$,$");
		}

		
		for each in eachAutomaticackResponse{		
			if(each <> "" AND each <> "Error"){				
				ackReseponse = split(each, "@@");			
				/**** @chetan g -> PROJ-1619822_BUG-1303 -> 22-09 **** */
				if(find(ackReseponse[0],"LTWA") <> -1){			
					ackSplit = split(ackReseponse[0], "$$");
					for rec in ackSplit{
						if(find(rec,"##") <> -1){
							recSplit = split(rec,"##");
							if(sizeofarray(recSplit) > 0 AND recSplit[6] <> "" AND find(recSplit[6],"LTWA") <> -1){
								WATech = recSplit[1];
								append(checkWA, ackReseponse[3] + "**" + WATech);
							}
						}
					}
				}
				/****************/			
				if(currentUserGroup_quote == "tESUsers_ES"  OR currentUserGroup_quote == "WholeSale_accountManager_ES"){			
					//If cost fileds are missing then dipslay ack resposne
					if(find(ackReseponse[0], "##") == -1 AND find(ackReseponse[0], "#,#") == -1){
						//KEY - SITENAME
						//Value -> RequestID
						put(atuomaticAckDict,ackReseponse[0], ackReseponse[2]);					
						if(containskey(RequestIDDict, ackReseponse[3] +"**" + ackReseponse[0])){
							getSiteDetailsString = get(RequestIDDict, ackReseponse[3] +"**" + ackReseponse[0]);
							getSiteDetailsArray = split(getSiteDetailsString, "@@");						
							//print getSiteDetailsArray;
							siteAddresss = getSiteDetailsArray[0];
							if(getSiteDetailsArray[3] == "enlacePortador"){
								siteType = getSiteDetailsArray[1];
								referKey = getSiteDetailsArray[2];
								//prdName = getSiteDetailsArray[3];
								prdName = replace(getSiteDetailsArray[3], "enlacePortador", "Enlance Portador");
								service = "";
								backupService = "";
								mainBandwidth = getSiteDetailsArray[4];
								backupBandwidth = "";
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[4] == "iPVPN"){						
								siteSize = getSiteDetailsArray[1];
								siteType = getSiteDetailsArray[2];
								//prdName = getSiteDetailsArray[4];
								prdName = replace(getSiteDetailsArray[4], "iPVPN", "IPVPN");
								service = "";
								backupService = "";
								mainBandwidth = "";
								backupBandwidth = "";
								modalidadAcceso = getSiteDetailsArray[5];
								tallaPpal = getSiteDetailsArray[1];
								voiP = getSiteDetailsArray[7];
								vpnLan = getSiteDetailsArray[8];
								cosipvpn = getSiteDetailsArray[9];
								internet = getSiteDetailsArray[6];
								referKey = getSiteDetailsArray[3];
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[5] == "legacyProductAccesoInternetONOAndVodafone" OR getSiteDetailsArray[5] == "legacyProductMPLSAndVPLSONO"){						
								siteType = getSiteDetailsArray[3];
								referKey = getSiteDetailsArray[4];
								//prdName = getSiteDetailsArray[5];
								if(getSiteDetailsArray[3] == "Main"){
									service = getSiteDetailsArray[1];
									mainBandwidth = getSiteDetailsArray[6];
									if(getSiteDetailsArray[2] == "Sin backup" ){							
										backupService = getSiteDetailsArray[2];
									}
									else{
										backupService = "";
									}							
									backupBandwidth = "";
								}
								if(getSiteDetailsArray[3] == "Backup"){
									service = "";
									backupService = getSiteDetailsArray[2];
									mainBandwidth = "";
									backupBandwidth = getSiteDetailsArray[7];
									
								}							
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								if(getSiteDetailsArray[5] == "legacyProductAccesoInternetONOAndVodafone"){
									prdName = replace(getSiteDetailsArray[5], "legacyProductAccesoInternetONOAndVodafone", "Legacy Internet");
								}
								elif(getSiteDetailsArray[5] == "legacyProductMPLSAndVPLSONO"){
									prdName = replace(getSiteDetailsArray[5], "legacyProductMPLSAndVPLSONO", "Legacy MPLS");
								}
								
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[5] == "legacyProductVPNAvalon"){						
								siteType = getSiteDetailsArray[3];
								referKey = getSiteDetailsArray[4];
								//prdName = getSiteDetailsArray[5];
								prdName = replace(getSiteDetailsArray[5], "legacyProductVPNAvalon", "Legacy Avalon");
								if(getSiteDetailsArray[3] == "Main"){
									service = getSiteDetailsArray[1];
									mainBandwidth = getSiteDetailsArray[6];
									print "getSiteDetailsArray[2]";
									print getSiteDetailsArray[2];
									if(getSiteDetailsArray[2] == "Sin Backup"){
										backupService = getSiteDetailsArray[2];
									}
									else{
										backupService = "";
									}
									backupBandwidth = "";
								}
								if(getSiteDetailsArray[3] == "Backup"){
									service = "";
									mainBandwidth = "";
									backupService = getSiteDetailsArray[2];
									backupBandwidth = getSiteDetailsArray[7];
								}
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[5] == "primarioFijo" OR getSiteDetailsArray[5] == "primarioMvil"){ 
								//@Chetan G / 28-12-2016/ For BREQ091(One Net Feasibility)
								siteType = getSiteDetailsArray[3];
								referKey = getSiteDetailsArray[4];
								//prdName = getSiteDetailsArray[5];							
								service = getSiteDetailsArray[1];
								backupService = getSiteDetailsArray[2];
								mainBandwidth = getSiteDetailsArray[6];
								backupBandwidth = getSiteDetailsArray[7];
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								if(getSiteDetailsArray[5] == "primarioFijo"){
									prdName = replace(getSiteDetailsArray[5], "primarioFijo", "Primario Fijo");
								}
								elif(getSiteDetailsArray[5] == "primarioMvil"){
									prdName = replace(getSiteDetailsArray[5], "primarioMvil", "Primario móvil");
								}
								
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}else{
								//siteType = "Main";
								siteType = getSiteDetailsArray[3];
							}
						}
						
						//Need to update logic
						/* commented by chetan g -> PROJ-1619822_BUG-0034 > 27-09 
							feasibilityStatus = "In Progress";
						*/
						feasibilityStatus = "Automatic Feasibility Requested"; // added by chetan g -> PROJ-1619822_BUG-0034 > 27-09
						errorMsg = "";
						studyLeveloptions = ""; AccessProduct = ""; configureRAGStatus ="RAG"; expiryDate = ""; autoFeasiblityID = "autoID";
						
						resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + ackReseponse[3] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + ackReseponse[0] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" +  siteType + "</td><td width=\"85px\" class=\"primaryAccess\">" + AccessProduct + "</td><td>" + configureRAGStatus + "</td><td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">Lead Time</td><td class=\"autoFID\">"+ autoFeasiblityID  +"</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ errorMsg +"</td>"+  columnData11 +"<td class=\"studyLevel\">" +  studyLeveloptions + "</td><td>NA</td></tr>";
						
						cftRequestID = cftRequestID + 1;
					}
				}//Tes User END
				else{
					if(find(ackReseponse[0], "##") == -1 AND find(ackReseponse[0], "#,#") == -1){
						//KEY - SITENAME
						//Value -> RequestID
						put(atuomaticAckDict,ackReseponse[0], ackReseponse[2]);					
						//ackReseponse[2] = "CFTREQ1";
						if(containskey(RequestIDDict, ackReseponse[3] +"**" + ackReseponse[0])){
							getSiteDetailsString = get(RequestIDDict, ackReseponse[3] +"**" + ackReseponse[0]);
							getSiteDetailsArray = split(getSiteDetailsString, "@@");						
							siteAddresss = getSiteDetailsArray[0];
							if(getSiteDetailsArray[3] == "enlacePortador"){
								siteType = getSiteDetailsArray[1];
								referKey = getSiteDetailsArray[2];
								//prdName = getSiteDetailsArray[3];
								prdName = replace(getSiteDetailsArray[3], "enlacePortador", "Enlance Portador");
								service = "";
								backupService = "";
								mainBandwidth = getSiteDetailsArray[4];
								backupBandwidth = "";
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[4] == "iPVPN"){					
								siteSize = getSiteDetailsArray[1];
								siteType = getSiteDetailsArray[2];
								//prdName = getSiteDetailsArray[4];
								prdName = replace(getSiteDetailsArray[4], "iPVPN", "IPVPN");
								service = "";
								backupService = "";
								mainBandwidth = "";
								backupBandwidth = "";
								modalidadAcceso = getSiteDetailsArray[5];
								tallaPpal = getSiteDetailsArray[1];
								voiP = getSiteDetailsArray[7];
								vpnLan = getSiteDetailsArray[8];
								cosipvpn = getSiteDetailsArray[9];
								internet = getSiteDetailsArray[6];
								referKey = getSiteDetailsArray[3];
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
								//columnData11 = "<td>"+ siteSize +"</td>";
							}elif(getSiteDetailsArray[5] == "legacyProductAccesoInternetONOAndVodafone" OR getSiteDetailsArray[5] == "legacyProductMPLSAndVPLSONO"){					
								siteType = getSiteDetailsArray[3];
								referKey = getSiteDetailsArray[4];
								//prdName = getSiteDetailsArray[5];
								if(getSiteDetailsArray[3] == "Main"){
									service = getSiteDetailsArray[1];
									mainBandwidth = getSiteDetailsArray[6];
									if(getSiteDetailsArray[2] == "Sin backup" ){							
										backupService = getSiteDetailsArray[2];
									}
									else{
										backupService = "";
									}	
									backupBandwidth = "";
								}
								if(getSiteDetailsArray[3] == "Backup"){
									service = "";
									backupService = getSiteDetailsArray[2];
									mainBandwidth = "";
									backupBandwidth = getSiteDetailsArray[7];
									
								}
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								if(getSiteDetailsArray[5] == "legacyProductAccesoInternetONOAndVodafone"){
									prdName = replace(getSiteDetailsArray[5], "legacyProductAccesoInternetONOAndVodafone", "Legacy Internet");
								}
								elif( getSiteDetailsArray[5] == "legacyProductMPLSAndVPLSONO"){
									prdName = replace(getSiteDetailsArray[5], "legacyProductMPLSAndVPLSONO", "Legacy MPLS");
								}
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[5] == "legacyProductVPNAvalon"){					
								siteType = getSiteDetailsArray[3];
								referKey = getSiteDetailsArray[4];
								//prdName = getSiteDetailsArray[5];
								prdName = replace(getSiteDetailsArray[5], "legacyProductVPNAvalon", "Legacy Avalon");
								if(getSiteDetailsArray[3] == "Main"){
									service = getSiteDetailsArray[1];
									mainBandwidth = getSiteDetailsArray[6];
									if(getSiteDetailsArray[2] == "Sin Backup"){
										backupService = getSiteDetailsArray[2];
									}
									else{
										backupService = "";
									}
									backupBandwidth = "";
								}
								if(getSiteDetailsArray[3] == "Backup"){
									service = "";
									mainBandwidth = "";
									backupService = getSiteDetailsArray[2];
									backupBandwidth = getSiteDetailsArray[7];
								}
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}elif(getSiteDetailsArray[5] == "primarioFijo" OR getSiteDetailsArray[5] == "primarioMvil"){
								//@Chetan G / 28-12-2016/ For BREQ091(One Net Feasibility)
								siteType = getSiteDetailsArray[3];
								referKey = getSiteDetailsArray[4];
								//prdName = getSiteDetailsArray[5];
								service = getSiteDetailsArray[1];
								backupService = getSiteDetailsArray[2];
								mainBandwidth = getSiteDetailsArray[6];
								backupBandwidth = getSiteDetailsArray[7];
								modalidadAcceso = "";
								tallaPpal = "";
								voiP = "";
								vpnLan = "";
								cosipvpn = "";
								internet = "";
								if(getSiteDetailsArray[5] == "primarioFijo"){
									prdName = replace(getSiteDetailsArray[5], "primarioFijo", "Primario Fijo");
								}
								elif( getSiteDetailsArray[5] == "primarioMvil"){
									prdName = replace(getSiteDetailsArray[5], "primarioMvil", "Primario móvil");
								}
								columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
							}else{
								//siteType = "Main";
								siteType = getSiteDetailsArray[3];
							}
						}
						
						//Need to update logic
						/* commented by chetan g -> PROJ-1619822_BUG-0034 > 27-09 
							feasibilityStatus = "In Progress";
						*/
						feasibilityStatus = "Automatic Feasibility Requested"; // added by chetan g -> PROJ-1619822_BUG-0034 > 27-09
						errorMsg = "";
						studyLeveloptions = ""; AccessProduct = ""; configureRAGStatus ="RAG"; expiryDate = ""; autoFeasiblityID = "autoID";
						
						resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + ackReseponse[3] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + ackReseponse[0] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + siteType + "</td><td width=\"85px\" class=\"primaryAccess\">" + AccessProduct + "</td><td>" + configureRAGStatus + "</td><td class=\"leadT\">Lead Time</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ errorMsg +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>NA</td></tr>";
						cftRequestID = cftRequestID + 1;
					}
				}//Account Managet loop end
			
			}//Error loop ends
			
		}//for loop ends
		//}

		inactiveTech = string[];
		activeCount = 0;
		records = bmql("select AccessTechnology from AccesEligibility where Active='NO'");
		for record in records {
			inactiveTech[activeCount] = get(record, "AccessTechnology");
			activeCount  =activeCount + 1;	
		}
		//print "914"; print techTypeResponseArray;
		//Traverse CFT resposne
		//Logic for populating feasibility resposne for TES user.

		//PROJ-1518930_BREQ-107 BREQ Manual Feasibility Gry response issue fix Start
		manualeachResponse = string[];
		count =0;	
		//manualrequestsDict = dict("string");
		manualFeasibilityrequestarray = "";
		if(manualFeasibilityActualResponse_quote <> ""){					
			manualeachResponse = split(manualFeasibilityActualResponse_quote,"$,$");	
			for requests in manualeachResponse{			
				if(find(requests, "#,#") == -1){
					//finalrequestsArray[count] = requests;
					//put(manualrequestsDict,requests,"$"+requests+"$");
					if(count ==0){
						manualFeasibilityrequestarray = requests;
					}else{
						manualFeasibilityrequestarray = manualFeasibilityrequestarray +"$,$"+requests;
					}
					count = count + 1;
				}
								
			}
		}				
		//PROJ-1518930_BREQ-107 BREQ Manual Feasibility Gry response issue fix END	
		
		for each in techTypeResponseArray{
			//e.g CFTREQ2**deNavascués**VF ORLA T //CPQ REQUEST ID + SITENAME + ACCESS TECHNOLOGY.
			if(each <> ""){		
				splitEachTechs = split(each,"**");
				//Check the key exists or not
				if(containskey(techTypeResponseDict, each) OR splitEachTechs[2] == "No available technology"){
				
					//eg.G**1134**0**179.99000549316406**179.99000549316406**05/10/2016**Aut-000002845
					// RAG STATUS + COST1 + COST2 + COST3 + EXPIRY DATE ++ CFT AUTO FID.
					if(splitEachTechs[2] <> "No available technology"){
						responseValues = get(techTypeResponseDict, each); 
						responseValuesArray = split(responseValues, "**");
						
						bragStatus = util.getHTMLForRAGStatus(responseValuesArray[0]);
					}
					else{
						bragStatus = "<td width=20px style=\"background-color:gray; color:gray\" class=\"primaryRAG\">GRAY</td>";
					}
					//keys
					responeKeysArray = split(each, "**"); //CFTREQ2**Callao-46184**ONO HFC
					feasibilityStatus = "Automatic Feasibility Done";
					
					//Site Address
					if(containskey(RequestIDDict, responeKeysArray[0]+"**"+responeKeysArray[1])){
						getSiteDetailsString = get(RequestIDDict, responeKeysArray[0]+"**"+responeKeysArray[1]);
						getSiteDetailsArray = split(getSiteDetailsString, "@@");					
						//print getSiteDetailsArray;
						siteAddresss = getSiteDetailsArray[0];
						if(getSiteDetailsArray[3] == "enlacePortador"){
							siteType = getSiteDetailsArray[1];
							referKey = getSiteDetailsArray[2];
							//prdName = getSiteDetailsArray[3];
								prdName = replace(getSiteDetailsArray[3], "enlacePortador", "Enlance Portador");
							service = "";
							backupService = "";
							mainBandwidth = getSiteDetailsArray[4];
							backupBandwidth = "";
							modalidadAcceso = "";
							tallaPpal = "";
							voiP = "";
							vpnLan = "";
							cosipvpn = "";
							internet = "";
							columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
						}elif(getSiteDetailsArray[4] == "iPVPN"){				
							siteType = getSiteDetailsArray[2];
							siteSize = getSiteDetailsArray[1];
							referKey = getSiteDetailsArray[3];
							//prdName = getSiteDetailsArray[4];
							prdName = replace(getSiteDetailsArray[4], "iPVPN", "IPVPN");
							service = "";
							backupService = "";
							mainBandwidth = "";
							backupBandwidth = "";
							modalidadAcceso = getSiteDetailsArray[5];
							tallaPpal = getSiteDetailsArray[1];
							voiP = getSiteDetailsArray[7];
							vpnLan = getSiteDetailsArray[8];
							cosipvpn = getSiteDetailsArray[9];
							internet = getSiteDetailsArray[6];
							columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
						}elif(getSiteDetailsArray[5] == "legacyProductAccesoInternetONOAndVodafone" OR getSiteDetailsArray[5] == "legacyProductMPLSAndVPLSONO"){				
							siteSize = getSiteDetailsArray[1];
							referKey = getSiteDetailsArray[4];
							siteType = getSiteDetailsArray[3];					
							//prdName = getSiteDetailsArray[5];
							if(getSiteDetailsArray[3] == "Main"){
								service = getSiteDetailsArray[1];
								mainBandwidth = getSiteDetailsArray[6];
								if(getSiteDetailsArray[2] == "Sin backup" ){							
									backupService = getSiteDetailsArray[2];
								}
								else{
									backupService = "";
								}						
								backupBandwidth = "";
							}
							if(getSiteDetailsArray[3] == "Backup"){
								service = "";
								backupService = getSiteDetailsArray[2];
								mainBandwidth = "";
								backupBandwidth = getSiteDetailsArray[7];
								
							}
							modalidadAcceso = "";
							tallaPpal = "";
							voiP = "";
							vpnLan = "";
							cosipvpn = "";
							internet = "";
							if(getSiteDetailsArray[5] == "legacyProductAccesoInternetONOAndVodafone"){
									prdName = replace(getSiteDetailsArray[5], "legacyProductAccesoInternetONOAndVodafone", "Legacy Internet");
							}
							elif(getSiteDetailsArray[5] == "legacyProductMPLSAndVPLSONO"){
									prdName = replace(getSiteDetailsArray[5], "legacyProductMPLSAndVPLSONO", "Legacy MPLS");
							}
							columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
						}elif(getSiteDetailsArray[5] == "legacyProductVPNAvalon"){				
							siteSize = getSiteDetailsArray[1];
							referKey = getSiteDetailsArray[4];					
							siteType = getSiteDetailsArray[3];					
							//prdName = getSiteDetailsArray[5];
							prdName = replace(getSiteDetailsArray[5], "legacyProductVPNAvalon", "Legacy Avalon");					
							if(getSiteDetailsArray[3] == "Main"){
								service = getSiteDetailsArray[1];
								mainBandwidth = getSiteDetailsArray[6];
								if(getSiteDetailsArray[2] == "Sin Backup"){
									backupService = getSiteDetailsArray[2];
								}
								else{
									backupService = "";
								}
								backupBandwidth = "";
							}
							if(getSiteDetailsArray[3] == "Backup"){
								service = "";
								mainBandwidth = "";
								backupService = getSiteDetailsArray[2];
								backupBandwidth = getSiteDetailsArray[7];
							}
							modalidadAcceso = "";
							tallaPpal = "";
							voiP = "";
							vpnLan = "";
							cosipvpn = "";
							internet = "";
							
							columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
						}
						elif(getSiteDetailsArray[5] == "primarioFijo" OR getSiteDetailsArray[5] == "primarioMvil"){
							//@Chetan G / 28-12-2016/ For BREQ091(One Net Feasibility)
							siteSize = getSiteDetailsArray[1];
							referKey = getSiteDetailsArray[4];
							siteType = getSiteDetailsArray[3];					
							//prdName = getSiteDetailsArray[5];
							service = getSiteDetailsArray[1];
							backupService = getSiteDetailsArray[2];
							mainBandwidth = getSiteDetailsArray[6];
							backupBandwidth = getSiteDetailsArray[7];
							modalidadAcceso = "";
							tallaPpal = "";
							voiP = "";
							vpnLan = "";
							cosipvpn = "";
							internet = "";
							if(getSiteDetailsArray[5] == "primarioFijo"){
									prdName = replace(getSiteDetailsArray[5], "primarioFijo", "Primario Fijo");
							}
							elif(getSiteDetailsArray[5] == "primarioMvil"){
									prdName = replace(getSiteDetailsArray[5], "primarioMvil", "Primario móvil");
							}
							columnData11 = "<td class=\"referKey\">"+ referKey +"</td>";
						}
					}
					if(containskey(techTypeResponseDict, responeKeysArray[0] + "**" + responeKeysArray[1] + "**" + "MSG")){
						errorMsg = get(techTypeResponseDict, responeKeysArray[0] + "**" + responeKeysArray[1] + "**" + "MSG");
					}	
					
					//Cost Values
					if(responseValuesArray[1] <> "" AND NOT(ISNULL(responseValuesArray[1]))){
						capExValue = string(round(util.atof_Custom(responseValuesArray[1]),2)); 					 
					}
					if(responseValuesArray[2] <> "" AND NOT(ISNULL(responseValuesArray[2]))){					
						inOpExValue = string(round(util.atof_Custom(responseValuesArray[2]),2)); 
					}
					if(responseValuesArray[3] <> "" AND NOT(ISNULL(responseValuesArray[3]))){
						reOpExValue = string(round(util.atof_Custom(responseValuesArray[3]),2));								
					}
					
					/*  Commented by @chetan g 23-09
					if(manualFeasibilityFlag_quote == true AND cFTResponseForSingleSite_quote <> "" AND cFTResponseSelectedRowID_quote <> "") {
						responseForSingleSite = split(cFTResponseForSingleSite_quote, "$$");
						getRequestID = get(responseRequestIDdict, responseRequestIDArray[count2] + "**" +siteID[count2]);
						//key - REQUESTID**SITEID**ACCESS - value=>FeasibilityStatus
						keyCheck = getRequestID + "**" + responseForSingleSite[2] + "**" + responseForSingleSite[4];
						if(getRequestID == responseForSingleSite[0] AND count2 == atoi(cFTResponseSelectedRowID_quote)) { 
							feasibilityStatus = "Manual Feasibility Done";
						}
						elif(containskey(manualResponseDict, keyCheck) == true) {
							feasibilityStatus = get(manualResponseDict, keyCheck);
						}
						
						//feasibilityStatus = "Manual";
					}*/
					
					/* **** @chetan g -> 26-09 ****  */
					manualRequestArray = string[];
					if(manualFeasibilityActualResponse_quote <> "" AND cFTParseResponse_quote <> ""){
						if(find(manualFeasibilityActualResponse_quote,"#,#") == -1){
							splitMFAR = split(manualFeasibilityActualResponse_quote,"$,$");
							for eachsMFAR in splitMFAR{
								spliteachsMFAR = split(eachsMFAR,"@@");
								if(sizeofarray(spliteachsMFAR) > 4){
									append(manualRequestArray, spliteachsMFAR[4]); // storing CFTMANREQ ids for which manual feasibility requested
								}
							}
						}
					}				
					autoIDwithTech = string[];
					splitAMFRP = split(allManualFeasibilityRequestParameters_quote,"##");
					for eachAMFRP in splitAMFRP {
						if(eachAMFRP <> "") {
							spliteachAMFRP = split(eachAMFRP, "$$") ;
							if(sizeofarray(spliteachAMFRP) > 1){
								if(findinarray(manualRequestArray,spliteachAMFRP[0]) <> -1 ){
									append(autoIDwithTech,spliteachAMFRP[1] + "**" + spliteachAMFRP[5]);
								}
							}
						}
					}
					//Below code is for Manual Feasibility Gray response issue replacing this manualFeasibilityActualResponse_quote to internal variable "manualFeasibilityrequestarray"
					if(find(allManualFeasibilityRequestParameters_quote, "CFTMANREQ"+ childCounter + string(cftRequestID) +  "$$") <> -1 AND find(manualFeasibilityrequestarray, "CFTMANREQ" + childCounter + string(cftRequestID) +  "@@") <> -1 AND find(allManualFeasibilityRequestParameters_quote, responeKeysArray[2] +  "$$") <> -1 AND find(manualFeasibilityrequestarray, responeKeysArray[0] +  "@@") <> -1){
						feasibilityStatus = "Manual Feasibility Requested";
						configStatus = "Pending Configuration";
					}
					
					/* **** @chetan g -> PROJ-1619822_BUG-1303 -> 22-09 ****  */
					if(sizeofarray(checkWA) > 0){
						if(findinarray(checkWA, responeKeysArray[0] + "**" + responeKeysArray[2]) <> -1){
							
							feasibilityStatus="Manual Workaround Done";
						} 
					}
					if(feasibilityStatus <> "Manual Feasibility Requested" AND feasibilityStatus <> "Manual Workaround Done"){
						feasibilityStatus = "Automatic Feasibility Done";
					}
					/* **************/
					
					if(currentUserGroup_quote == "tESUsers_ES"  OR currentUserGroup_quote == "WholeSale_accountManager_ES"){
					
						/* Commented by chetan **** @chetan g -> PROJ-1619822_BUG-1303 -> 22-09 **** 
						if(find(bragStatus,"BLUE")<>-1 or find(bragStatus,"RED")<>-1 or find(bragStatus,"AMBER")<>-1 or find(bragStatus,"GREEN")<>-1){
							asibilityStatus="Workaround Feasibility Done";
						}*/			
						//Expiry Date
						if(responseValuesArray[5] <> "" AND NOT(ISNULL(responseValuesArray[5]))) {
							expiryDate = responseValuesArray[5]; 
						}
						
						if(find(bragStatus, "Gray") <> -1){
							autoFeasiblityID = "";
						}
							
						//Automatic FeasibilityID
						if(responseValuesArray[6] <> "" AND NOT(ISNULL(responseValuesArray[6]))) {
							autoFeasiblityID = responseValuesArray[6]; 
						}
						//Get Refekey key for request ID.	
						if(containskey(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1])){
							refkeyString = get(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1]);
							tempVari =split(refkeyString, "@@");						
							if(tempVari[4] == "iPVPN"){
								lineItemsKey = util.getIndexedValue(refkeyString, "@@", 3) + "**" + responeKeysArray[1];
							}elif(tempVari[3] == "enlacePortador"){
								//get destination site and remove index
								dest = util.getIndexedValue(util.getIndexedValue(refkeyString, "@@", 2), "__", 1);
								
								lineItemsKey = util.getIndexedValue(refkeyString, "@@", 2) + "**" + util.getIndexedValue(util.getIndexedValue(refkeyString, "@@", 2), "__", 0) + "##" + util.getIndexedValue(dest, "_", 0);
							}
							else{
								lineItemsKey = util.getIndexedValue(refkeyString, "@@", 4) + "**" + responeKeysArray[1];
							}
							referKey =  util.getIndexedValue(refkeyString, "@@", 4) + "**" + responeKeysArray[0];
							selectedPrd = util.getIndexedValue(get(RequestIDDict,responeKeysArray[0] + "**" + responeKeysArray[1]), "@@", 5);
							
						}
						
						//Check if selected site along with request id is with line item grid.
						if(containskey(lineItemsSitesDict, lineItemsKey)){ 
							//Making discard key - RequestID + "**" + SiteName
							discardResponseKey = referKey;	
							//Check if site is configured if its configured then update status and discard remaing.
							if(containskey(discardFeasibilityResponse, discardResponseKey) == false){							
								AccessProductString = get(lineItemsSitesDict, lineItemsKey);
								configureProductsArray = split(AccessProductString, "##");							
								if(findinarray(configureProductsArray, responeKeysArray[2] +"$"+"Main") > -1 OR findinarray(configureProductsArray, responeKeysArray[2] +"$"+"Backup") > -1 OR findinarray(configureProductsArray, responeKeysArray[2] +"$"+"A-end") > -1 OR findinarray(configureProductsArray, responeKeysArray[2] +"$"+"B-end") > -1){
									
									if(siteType == "Main" OR siteType == "A-end"){
										AccessProduct = configureProductsArray[1];
										if(find(AccessProduct, "Main") > -1 OR find(AccessProduct, "A-end") > -1){
											AccessProduct = util.getIndexedValue(configureProductsArray[1], "$", 0);
										}else{
											if(not(isnull(configureProductsArray[2]))){
											AccessProduct = util.getIndexedValue(configureProductsArray[2], "$", 0);
											}
										}
									}else{
										if(not(isnull(configureProductsArray[2]))){
											AccessProduct = configureProductsArray[2];
											if(find(AccessProduct, "Backup") > -1 OR find(AccessProduct, "B-end") > -1){
													AccessProduct = util.getIndexedValue(configureProductsArray[2], "$", 0);
											}else{
												AccessProduct = util.getIndexedValue(configureProductsArray[1], "$", 0);
											}
										}
									}								
									stringhavingRAG = get(techTypeResponseDict, responeKeysArray[0] + "**" + responeKeysArray[1] + "**" + AccessProduct);
									stringhavingRAG = get(techTypeResponseDict, responeKeysArray[0] + "**" + responeKeysArray[1] + "**" + AccessProduct);								
									bragStatus = util.getHTMLForRAGStatus(util.getIndexedValue(stringhavingRAG, "**", 0));								
									errorMsg = "";
									if(find(bragStatus, "Gray") <> -1){
										autoFeasiblityID = "";
									}else{
										errorMsg = "";
									}
									
									capExValue = string(round(util.atof_Custom(util.getIndexedValue(stringhavingRAG, "**", 1)),2));
									inOpExValue = string(round(util.atof_Custom(util.getIndexedValue(stringhavingRAG, "**", 2)),2));
									reOpExValue = string(round(util.atof_Custom(util.getIndexedValue(stringhavingRAG, "**", 3)),2));
									
									//Get Study Level Option base on selected configuration table.
									if(responeKeysArray[2] <> "" AND not(isnull(responeKeysArray[2]))){
										studyLeveloptions = commerce.getStudyLevelOptionsForManualFeasibilityRequestParameters(AccessProduct, currentUserGroup_quote, siteAddresss);
										technology = AccessProduct;
										cpqRequestID = responeKeysArray[0];
										siteName1 = responeKeysArray[1];
										profile = "tESUsers_ES";
										type = "automatic";
										technicalDetails = util.getCFTTechnicalParameters(type, xmlResponse, technology, profile, cpqRequestID);
										
										type = "automaticLeadTime";
										maxLeadTime = util.getCFTAutomaticMaxLeadtime(type, xmlResponse, technology, profile, cpqRequestID,leadTime_quote);
										
										//For those having workaround applied on automatic feasibility response.
										if(find(allManualFeasibilityRequestParameters_quote, cpqRequestID +  "$$") <> -1 AND find(manualFeasibilityActualResponse_quote, cpqRequestID) == -1 AND findinarray(checkWA, responeKeysArray[0] + "**" + responeKeysArray[2]) <> -1){
											feasibilityStatus = "Manual Workaround Done";
											configStatus = "Configuration Done";
										}
										
										//For those having manual feasibility requested and got response for same.
										if(find(allManualFeasibilityRequestParameters_quote, cpqRequestID +  "$$") <> -1 AND find(		manualFeasibilityActualResponse_quote, cpqRequestID) <> -1 AND findinarray(checkWA, responeKeysArray[0] + "**" + responeKeysArray[2]) == -1 AND find(allManualFeasibilityRequestParameters_quote, responeKeysArray[2] +  "$$") <> -1){
											feasibilityStatus = "Manual Feasibility Requested";
											configStatus = "Configuration Done";
										}
										
										//For those having configured using auotmatic response
										if(find(allManualFeasibilityRequestParameters_quote, cpqRequestID +  "$$") <> -1 AND find(manualFeasibilityActualResponse_quote, cpqRequestID) == -1 AND findinarray(checkWA, responeKeysArray[0] + "**" + responeKeysArray[2]) == -1){
											feasibilityStatus = "Automatic Feasibility Done ";
											configStatus = "Configuration Done";
										}
									}
									
									resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + configStatus + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet  + "</td><td class=\"analysisType\">" +siteType  + "</td><td width=\"85px\" class=\"primaryAccess\">" + AccessProduct + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">"+ autoFeasiblityID +"</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ errorMsg +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails +"</td></tr>";
									
									put(discardFeasibilityResponse, discardResponseKey, discardResponseKey);
								}
							}//End of discard loop
						}//End of line item grid check logic
						else{
							//Filter feasibility response - @3.1 Release - @Access Technology						
							//Get Study Level Option base on selected configuration table.
							if(responeKeysArray[2] <> "" AND not(isnull(responeKeysArray[2]))){							
								studyLeveloptions = commerce.getStudyLevelOptionsForManualFeasibilityRequestParameters(responeKeysArray[2], currentUserGroup_quote, siteAddresss);							
								type = "automatic";
								technology = responeKeysArray[2];
								cpqRequestID = responeKeysArray[0];
								siteName1 = responeKeysArray[1];
								
								profile = "tESUsers_ES";
								type = "automatic";
								technicalDetails = util.getCFTTechnicalParameters(type, xmlResponse, technology, profile, cpqRequestID);
								
								type = "automaticLeadTime";
								
								maxLeadTime = util.getCFTAutomaticMaxLeadtime(type, xmlResponse, technology, profile, cpqRequestID,leadTime_quote);
						
							}
							if(errorMsg <> " " AND findinarray(inactiveTech, responeKeysArray[2]) == -1){
								filterTech = responeKeysArray[2];							
								if(filterTech <> "MSG"){
									//For Legacy Product @3.1
								
									if(containskey(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1])){
										selectedPrd = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1]), "@@", 5);
								
										if(selectedPrd == "legacyProductAccesoInternetONOAndVodafone" OR selectedPrd == "legacyProductMPLSAndVPLSONO"){	
									
											requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 3);								
											//if(filterTech == cftMain AND requestType == "Main"){//Commented as part of BREQ 107 MFT
											if(requestType == "Main"){								
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												printOneTimeOnly = false;
										
											}								
											//if(filterTech == cftBackup AND requestType == "Backup"){//Commented as part of BREQ 107 MFT
											if(requestType == "Backup"){								
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Backup" + "</td><td width=\"85px\" class=\"primaryAccess\">" +  responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												printOneTimeOnly = false;
										
											}
										}elif(selectedPrd == "legacyProductVPNAvalon"){
								
											type = "";
										
											requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]),	 "@@", 3);
										
											//if(requestType == "Main" AND filterTech == cftMain){//Commented as part of BREQ 107 MFT
											if(requestType == "Main"){		
									
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												printOneTimeOnly = false;
										
											}
											//if(requestType == "Backup" AND filterTech == cftBackup){//Commented as part of BREQ 107 MFT
											if(requestType == "Backup"){								
										
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Backup" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												printOneTimeOnly = false;
										
											}
										}
										// @Chetan G / 02-01-2017 For BREQ091(One Net Feasibility)
										elif(selectedPrd == "primarioFijo" OR selectedPrd == "primarioMvil"){	
									
											requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 3);							
											if(requestType == "Main"){
												// Added by Chetan Gosavi 	PROJ-1622713_BUG-0167 / 25-01-2017
												if(sizeofarray(techTypeResponseArray) > 0){
													//cftMain = util.getIndexedValue(filterAccessString, "##", 0);
													cftMain = "";
													for eachtech in techTypeResponseArray{
														if(util.getIndexedValue(eachtech, "**", 0) == responeKeysArray[0])
														{	
															cftMain = util.getIndexedValue(eachtech, "**", 2);
															if(filterTech == cftMain){
																break;
															}
														}
													}
												}
											}
											//If Main and Backup having different access technology
											if(filterTech == cftMain AND requestType == "Main"){	
												//if(requestType == "Main"){
												if(responeKeysArray[2]<>"VF FTTH" AND responeKeysArray[2]<>"VF EFM"){
													resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												}
												printOneTimeOnly = false;
											
											}elif(requestType == "Main" AND cftMain == "" AND printOneTimeOnly == false){
										
												//print "1442:";
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" +responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												printOneTimeOnly = true;
										
											}
										}
										else{
						
											resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + siteType + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + capExValue + "</td><td width=\"40px\" class=\"initialOpEx\">" + inOpExValue + "</td><td width=\"40px\" class=\"recurringOpEx\">" + reOpExValue + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";

										}
									}
								}else{
									// Added by Chetan Gosavi against defect PROJ-1622713_BUG-0193 on 21-01-2017 = Set capExValue, inOpExValue, reOpExValue to Blank
									resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" +siteType + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td width=\"40px\" class=\"capEx\">" + "" + "</td><td width=\"40px\" class=\"initialOpEx\">" + "" + "</td><td width=\"40px\" class=\"recurringOpEx\">" + "" + "</td><td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ errorMsg +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
								}
							}
						} //end of TES pending configuration
					}//End of TES loop
					else{ //Logic for Account Manager
						//print "1461"; print responseValuesArray;
						//Expiry Date
						if(responseValuesArray[1] <> "" AND NOT(ISNULL(responseValuesArray[1]))) {
							expiryDate = responseValuesArray[1]; 
						}
					
						//Automatic Feasiblity ID
						if(responseValuesArray[2] <> "" AND NOT(ISNULL(responseValuesArray[2]))) {
							//autoFeasiblityID = responseValuesArray[2];
							type = "getAutoID";
							cpqRequestID = responeKeysArray[0];
							autoFeasiblityID = util.getCFTTechnicalParameters(type, xmlResponse, technology, profile, cpqRequestID);					
						}
					
						if(find(bragStatus, "Gray") <> -1){
							autoFeasiblityID = "";
						}
									
						//Get Refekey key for request ID.
						if(containskey(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1])){
							refkeyString = get(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1]);
							tempVari =split(refkeyString, "@@");
							
							if(tempVari[4] == "iPVPN"){
									lineItemsKey = util.getIndexedValue(refkeyString, "@@", 3) + "**" + responeKeysArray[1];
							}
							elif(tempVari[3] == "enlacePortador"){
									//get destination site and remove index
									dest = util.getIndexedValue(util.getIndexedValue(refkeyString, "@@", 2), "__", 1);
									
									lineItemsKey = util.getIndexedValue(refkeyString, "@@", 2) + "**" + util.getIndexedValue(util.getIndexedValue(refkeyString, "@@", 2), "__", 0) + "##" + util.getIndexedValue(dest, "_", 0);
							}
							else{
									lineItemsKey = util.getIndexedValue(refkeyString, "@@", 4) + "**" + responeKeysArray[1];
							}
							//lineItemsKey = util.getIndexedValue(refkeyString, "@@", 4) + "**" + responeKeysArray[1];
							referKey =  util.getIndexedValue(refkeyString, "@@", 4) + "**" + responeKeysArray[0];
						}
						//Check if selected site along with request id is with line item grid.
						if(containskey(lineItemsSitesDict, lineItemsKey)){ 
						//Check if selected site along with request id is with line item grid.
							if(containskey(discardFeasibilityResponse, referKey) == false){
								
								discardResponseKey = referKey;
								//Get Configure Access Product.
								//AccessProduct = responeKeysArray[2];
								AccessProductString = get(lineItemsSitesDict, lineItemsKey);
								configureProductsArray = split(AccessProductString, "##");
								
								if(findinarray(configureProductsArray, responeKeysArray[2] +"$"+"Main") > -1 OR findinarray(configureProductsArray, responeKeysArray[2] +"$"+"Backup") > -1){						
								
									if(siteType == "Main"){
										AccessProduct = configureProductsArray[1];
										if(find(AccessProduct, "Main") > -1){
											AccessProduct = util.getIndexedValue(configureProductsArray[1], "$", 0);
										}else{
											AccessProduct = util.getIndexedValue(configureProductsArray[2], "$", 0);
										}
									}else{
										AccessProduct = configureProductsArray[2];
										if(find(AccessProduct, "Backup") > -1){
											AccessProduct = util.getIndexedValue(configureProductsArray[2], "$", 0);
										}else{
											AccessProduct = util.getIndexedValue(configureProductsArray[1], "$", 0);
										}
									}
									
									stringhavingRAG = get(techTypeResponseDict, responeKeysArray[0] + "**" + responeKeysArray[1] + "**" + AccessProduct);
									if(not(isnull(stringhavingRAG))){
										bragStatus = util.getHTMLForRAGStatus(util.getIndexedValue(stringhavingRAG, "**", 0));
										if(find(bragStatus, "Gray") <> -1){
											autoFeasiblityID = "";
										}	
									}
									
									technology = AccessProduct;
									cpqRequestID = responeKeysArray[0];
									siteName1 = responeKeysArray[1];
									profile = "accountManager_ES";
									type = "automatic";
									technicalDetails = util.getCFTTechnicalParameters(type, xmlResponse, technology, profile, cpqRequestID);
									type = "automaticLeadTime";
									
									maxLeadTime = util.getCFTAutomaticMaxLeadtime(type, xmlResponse, technology, profile, cpqRequestID,leadTime_quote);
									
									//Filter feasibility response - @3.1 Release
									//Get Study Level Option base on selected configuration table.
									if(responeKeysArray[2] <> "" AND not(isnull(responeKeysArray[2]))){
										//studyLeveloptions = commerce.getStudyLevelOptionsForManualFeasibilityRequest(AccessProduct, currentUserGroup_quote);
										studyLeveloptions = commerce.getStudyLevelOptionsForManualFeasibilityRequestParameters(AccessProduct, currentUserGroup_quote, siteAddresss);
									}
									
									resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Configuration Done" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + siteType  + "</td><td width=\"85px\" class=\"primaryAccess\">" + AccessProduct + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate  + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ errorMsg +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
									
									put(discardFeasibilityResponse, discardResponseKey, discardResponseKey);
								}
							}
						}
						else{
							//Filter feasibility response - @3.1 Release - @Access Technology						
							//Get Study Level Option base on selected configuration table.
							if(responeKeysArray[2] <> "" AND not(isnull(responeKeysArray[2]))){
								//studyLeveloptions = commerce.getStudyLevelOptionsForManualFeasibilityRequest(responeKeysArray[2], currentUserGroup_quote);
								studyLeveloptions = commerce.getStudyLevelOptionsForManualFeasibilityRequestParameters(responeKeysArray[2], currentUserGroup_quote, siteAddresss);
								technology = responeKeysArray[2];
								cpqRequestID = responeKeysArray[0];
								siteName1 = responeKeysArray[1];							
								profile = "accountManager_ES";
								type = "automatic";
								technicalDetails = util.getCFTTechnicalParameters(type, xmlResponse, technology, profile, cpqRequestID);
								type = "automaticLeadTime";
								maxLeadTime = util.getCFTAutomaticMaxLeadtime(type, xmlResponse, technology, profile, cpqRequestID,leadTime_quote);
							}
							if(errorMsg <> " " AND findinarray(inactiveTech, responeKeysArray[2]) == -1){
								filterTech = responeKeysArray[2];
								
								if(filterTech <> "MSG"){
									//For Legacy Product @3.1
									selectedPrd = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1]), "@@", 5);
									//if(selectProductES_quote == "legacyProductAccesoInternetONOAndVodafone" OR selectProductES_quote == "legacyProductMPLSAndVPLSONO"){
									if(selectedPrd == "legacyProductAccesoInternetONOAndVodafone" OR selectedPrd == "legacyProductMPLSAndVPLSONO"){
									
										requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 3);
										zeroPriorityFlag = false;
										if(findinarray(legacyInternet, responeKeysArray[2]) <> -1 AND selectedPrd == "legacyProductAccesoInternetONOAndVodafone"){									
											zeroPriorityFlag = true;
										}
										if(findinarray(legacyMPLS, responeKeysArray[2]) <> -1 AND selectedPrd == "legacyProductMPLSAndVPLSONO"){									
											zeroPriorityFlag = true;
										}
										
										
										//if(filterTech == cftMain AND requestType == "Main"){//Commented as part of BREQ 107 MFT
										if(requestType == "Main" AND zeroPriorityFlag == false){
										
											resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
											printOneTimeOnly = false;
										}									
										//if(filterTech == cftBackup AND requestType == "Backup"){//Commented as part of BREQ 107 MFT
										if(requestType == "Backup" AND zeroPriorityFlag == false){
										
											resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth+ "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Backup" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
											printOneTimeOnly = false;
										}
									}elif(selectedPrd == "legacyProductVPNAvalon"){
										type = "";
										
										requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 3);
										zeroPriorityFlag = false;
										if(findinarray(legacyAvalon, responeKeysArray[2]) <> -1){									
											zeroPriorityFlag = true;
										}
										
										//if(requestType == "Main" AND filterTech == cftMain){//Commented as part of BREQ 107 MFT
										if(requestType == "Main" AND zeroPriorityFlag == false){
										
											resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
											printOneTimeOnly = false;
										}
										//if(requestType == "Backup" AND filterTech == cftBackup){//Commented as part of BREQ 107 MFT
										if(requestType == "Backup" AND zeroPriorityFlag == false){
										
											resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Backup" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\"  class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
											printOneTimeOnly = false;
										}
									}
									//@Chetan G / 27-12-2016/ For BREQ091(One Net Feasibility)
									elif(selectedPrd == "primarioFijo" OR selectedPrd == "primarioMvil"){
										//print "1691:"; print filterTech; print responeKeysArray[0]; 
										 //print   techTypeResponseArray;	print responeKeysArray[0];								
										requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 3);
										if(requestType == "Main"){
											if(sizeofarray(techTypeResponseArray) > 0){
												//cftMain = util.getIndexedValue(filterAccessString, "##", 0);
												cftMain = ""; // Added by Chetan against Defect PROJ-1622713_BUG-0228 on 25-01-2017
												for eachtech in techTypeResponseArray{
													if(util.getIndexedValue(eachtech, "**", 0) == responeKeysArray[0])
													{	
														//cftMain = util.getIndexedValue(techTypeResponseArray[matrixCount], "**", 2);
														cftMain = util.getIndexedValue(eachtech, "**", 2);
														break;
													}
												}
											}										
										}		
										//If Main and Backup having different access technology
										if(filterTech == cftMain AND requestType == "Main"){
										//if(requestType == "Main"){
										
											if(responeKeysArray[2]<>"VF FTTH" AND responeKeysArray[2]<>"VF EFM")
											{
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
											}	
											printOneTimeOnly = false;
										}elif(requestType == "Main" AND cftMain == "No available technology" AND printOneTimeOnly == false){
											resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ"+ childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + "Main" + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
											
											printOneTimeOnly = true;
										}
										}else{
					
										selectedPrd = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" + responeKeysArray[1]), "@@", 3);
										//For Elance Portador @3.1 check zero priority.
										if(selectedPrd == "enlacePortador"){
											recordFilterAM = bmql("select Technology, Priority from FeasibilityPriority where Type = 'Enlace' AND Technology = $filterTech");
											
											requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 1);
										
											
										}else{
											//For IPVPN
											//recordFilterAM = bmql("select Technology, Priority from FeasibilityPriority where Sitesize = $siteSize AND Technology = $filterTech"); //commented by Chetan B Gosavi on 08-01-2017 ~ This filteration already handled in util.getBestBackupForSalesUser
											requestType = util.getIndexedValue(get(RequestIDDict, responeKeysArray[0] + "**" +responeKeysArray[1]), "@@", 2);
											//print "in ipvpn:"+requestType;
										}
										
										/*	//commented by Chetan B Gosavi on 08-01-2017
										for eachTech in recordFilterAM{
											if(get(eachTech, "Priority") <> "" AND atoi(get(eachTech, "Priority")) <> 0 AND get(eachTech, "Technology") <> ""){
											
												//resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\">" + util.manFeasibilityStatus("CFTMANREQ"+string(cftRequestID),manualFeasibilityActualResponse_quote) + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration" + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + requestType + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2] + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												
												resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0]  + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration " + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName+"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet  + "</td><td class=\"analysisType\">" + requestType + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2]  + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
												//sortAMFlag=true;
												//put(sortDict,responeKeysArray[0],resultStringSort);
											}
										}*/
										resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter + string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0]  + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration " + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1] + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss + "</td><td class=\"prdName\">"+ prdName+"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet  + "</td><td class=\"analysisType\">" + requestType + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2]  + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ "" +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
									}
								}else{//Error 
								//	print "1769:"; print cftRequestID;
									resultString = resultString + "<tr id =row" + string(cftRequestID) + "><td class=\"sitename2\" width=\"10px\"><input type=\"checkbox\" name=\"check[]\" class=\"checkbox2\" value=CFTMANREQ" + childCounter+ string(cftRequestID) + "></td><td width=\"85px\" class=\"autoRequestID\">" + responeKeysArray[0] + "</td><td width=\"85px\" class=\"configurationStatus\">" + "Pending Configuration " + "</td><td width=\"85px\" class=\"siteName\">" + responeKeysArray[1]  + "</td><td width=\"250px\" class=\"siteAddress\">" + siteAddresss  + "</td><td class=\"prdName\">"+ prdName  +"</td><td class=\"service\">" + service + "</td><td class=\"backupService\">" + backupService + "</td><td class=\"mainBandwidth\">" + mainBandwidth + "</td><td class=\"backupBandwidth\">" + backupBandwidth + "</td><td class=\"modalidadAcceso\">" + modalidadAcceso + "</td><td class=\"tallaPpal\">" + tallaPpal + "</td><td class=\"voiP\">" + voiP + "</td><td class=\"vpnLan\">" + vpnLan + "</td><td class=\"coS\">" + cosipvpn + "</td><td class=\"internet\">" + internet + "</td><td class=\"analysisType\">" + siteType  + "</td><td width=\"85px\" class=\"primaryAccess\">" + responeKeysArray[2]  + "</td>" + bragStatus + "<td class=\"leadT\">"+ maxLeadTime +"</td><td class=\"autoFID\">" + autoFeasiblityID   + "</td><td width=\"20px\" class=\"expiryDate\">" + expiryDate + "</td><td width=\"85px\" class=\"feasibilityStatus\">"+ feasibilityStatus + "</td><td width=\"20px\" class=\"cftErrorDesc\">"+ errorMsg +"</td>"+ columnData11 +"<td class=\"studyLevel\">" + studyLeveloptions + "</td><td>"+ technicalDetails+"</td></tr>";
								}
							}
						}
					}
					cftRequestID = cftRequestID + 1;
				}//End of tech type traverse array
				count2 = count2 + 1;		
			}//End of each condition
		}//end of main loop
	}

	if(currentUserGroup_quote == "tESUsers_ES" OR currentUserGroup_quote == "WholeSale_accountManager_ES") {
		finalString = headFreezeStart + headerForTES + resultString + "</tbody></table>" + headFreezeEnd;
	}
	else{
		finalString = headFreezeStart + headerForSales + resultString + "</tbody></table>" + headFreezeEnd;
	}
}
return finalString;
