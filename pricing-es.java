//Pricing Library - For Spain(ES) Opco
	/*param: 
		actionName - submit / update 
	Assumption: 
		- a) Parts Custom fields 
			field1 - family
			field2 - cost
			field3 - max discount
			field8 - fee type
		
		1) Functionality list 
		2) Get latest part information
		3) Calculate based on the parts information
		4) Calculate the quote level information 
		
		Created By: Mandar Jadye
		Modified: Pooja Panwar 30-08-2016 Implementing playbook functionality for accountManager_ES
		Modified : Pooja P 27-10-2016 Added code to forceset discount for one net module based on PPM discounts 
		*/
		
		//returncomment="Fixed"+"**"+siteName_ES+"**"+productName_PricingArray_ES[index]+"**"+productdescription+"**"+productType_PricingArray_ES[index]+"**"+string(mRCPrice_PricingArray_ES[index])+"**"+string(nRCPrice_PricingArray_ES[index])+"**"+string(mRCNetPrice_PricingArray_ES[index])+"**"+string(nRCNetPrice_PricingArray_ES[index])+"**"+string(directCostToVF_PricingArray_ES[index])+"**"+string(yearlyCost_PricingArray_ES[index])+"**"+string(interconnectedCost_PricingArray_ES[index])+"**"+"0.0"+"**"+string(capex_PricingArray_ES[index])+"**"+"20.0"+"**"+"0.0"+"**"+"30.0"+"**"+"0.0"+"**"+string(maxDiscountFlag_PricingArray_ES[index])+"**"+"FALSE";
		//Part_number~Quantity~SiteName+"**"+SiteId+"**"+productName+ "**" +productDescription+ "**" +productType+ "**" + mrcSLPrice+ "**" +nrcSLPrice+ "**" +mrcFinalPrice+ "**" + nrcFinalPrice+"**"+mrcCost+"**"+directCost+"**"+yearlyCost+"**"+interConnectCost+"**"+OBACost+"**"+Capex+"**"+infrastructureCap+"**"+TxNetworkCap+"**"+accessNetworkCap+"**"+systemCap+"**"+MaxDiscountFlag+ "**"+controlType+ "**"+”~Price~Index|^|
		todayDate= strtojavadate(getstrdate(), "MM/dd/yyyy", "London");
		documentNumber1="";
		countModel = 0;
		reviseMonthly = 0.0; 
		reviseOneOff = 0.0; 
		reviseInstall = 0.0; 
		reviseYearly = 0.0; 
		reviseMinCons = 0.0;
		tcvValue = "";
		MinimumConsumption = 0.0;
		MinimumConsumptionDiscount= 0.0;
		MinimumConsumptionOffer= 0.0;
		productIDDict=dict("string");
		//startDate = getdate();
		endDate = getdate();
		productIDArray=string[];
		discountarray=string[];
		discountarraydict=dict("string");
		approvalFlag=false;
		capexTotal = 0.0;
		tarifaConcertadaCharges="";
		modelName="";
		recurrencerevenue = 0.0;
		totalRevenueFixedVal="";
		SiteDict=dict("string");
		totalRevenueVal="";
		showColumn="";
		AOVValue=0.0;
		MonthlyFee=0.0;
		documentNumberLatest = "";
		mobileCPQproductinfo = "";
		//previousRevenueL7ProductValue= 0.0;
		
		//declaring for defect 0880
		
		//AOVValueES=0.0; commented by Mahesh
		tcvValueES=0.0;
		
		deviceCatagory=dict("integer");
		productTermDevice = 1;
		
		//0880 declaration ends
		
		modelNameQuote = "";
		Aovaluenew=0.0;
		productContractEndDAte=getDate();
		testTextArea7ES = "";
		excessCharges = "";
		prodDescription="";
		serviceFlag="";
		startMonthVal=0;
		fixedFlag=false;
		MobileFlag=false;
		// kiran 
		modifiedCostFlag="";
		mobileRevenue="";
		siteName="";
		lineRes="";
		ARPUValue = "";
		ragStatus = "";
		tariffPlan="";
		productTerm = 1;
		
		techFund = 0.0;
		cashbonus = 0.0;
		invoiceCredit = 0.0;
		hardwareSubsidies = 0.0;
		migrationCredit = 0.0;
		devicePriceDiscount = 0.0;
		VGERedFlag = "";
		startDateValue = "01/01/0001 00:00:00";
		endDateValue = "01/01/0001 00:00:00";
		//startDate = "01/01/0001 00:00:00";
		//endDate = "01/01/0001 00:00:00";
		startDateEarliest = "12/31/9999";
		endDateLatest = "01/01/0001";
		cloudServerFlag = false;
		productName="";
		productDesc="";
		mrcListPrice=0.0;
		nrcListPrice=0.0;
		mrcNetPrice=0.0;
		nrcNetPrice=0.0;
		directCost=0.0;
		mrcDiscount=0.0;
		nrcDiscount=0.0;
		yearlyCost=0.0;
		monthyCost=0.0;
		InterconnectCost=0.0;
		targetSpendVal=0.0;
		capex=0.0;
		infrastructureCapex=0.0;
		txNetwork=0.0;
		systemCapex=0.0;
		accessNetwork=0.0;
		cap=float[];
		startMonth=1;
		internet_ES="";
		iPVPN_ES="";
		vLAN_ES="";
		coS_ES="";
		siteName_ES="";
		connectivityType_ES="";
		connectivityTypeVal="";
		siteNameVal="";
		selectedService="";
		connectiontypeValue = "";
		VATIDString="";
		validatedByContractManager = false;
		CRMCode="";
		cpeDetails = ""; 
		PPMRoamingPlanString="";
		/*Changes start for Getting ConfiguredplansES in a string - Sarita*/
		selectedPlanFromCommerce="";
		selectedPlanstring="";//Getting ConfiguredplansES in a string
		planStringflag=false;
		/*Changes End for Getting ConfiguredplansES in a string*/
			
		closeDAteDay = "";
		closeDateMonth = ""; closeDAteYear = "";
		productid =string[];
		prodID = string[];	
		count=0;
		count1=0;
		count2=0;
		count3=0;
		VATIDCount=0;
		inputstr = "";
		accessinitialval=float[];
		selectedVATIDsArray=String[];
		accessreccuringval=float[];
		responseprodidval=String[];
		revisedmrc=dict("float");
		datestr=strtojavadate(_system_date,"yyyy-MM-dd HH:mm:ss");
		//datestr=strtojavadate("2016-07-25 16:07:00","yyyy-MM-dd HH:mm:ss");
		currentdate=datetostr(datestr,"dd/MM/yyyy");
		contractterm=1;
		mrcprice=0.0;
		nrcprice=0.0;
		price = string[];
		datacenter="";
		targetSpent = 0.0;
		producttype=string[];
		VATIDCountArray=string[];
		sitesize = "";
		planInfo = "";
		accessinitial="";
		discount=0.0;
		formedProductIDstring = "";
		formedProductIdArray = string[];
		modifyFlag = false;
		maxSubsidyRedEmpressa = 0.0; 
		deviceSubsidy = 0.0;
		category = "";
		discountcodeValue = ""; //Minimum Discount Code for Mobile Products
		discountcodeOneTimeValue = ""; //One Time Discount Code for Mobile Products
		discountcodeInstallValue = ""; //Installation Discount Code for Mobile Products
		discountcodeMonthlyValue = ""; //Monthly Discount Code for Mobile Products
		discountcodeYearlyValue = ""; //Yearly Discount Code for Mobile Products
		ppmRateDetails="";
		//leadTime = 0;
		leadTime = 25;
		service="";
		eurosVFFlag=false;
		totalBMPrice = 0.0;
		installFee = 0.0;
		oneTimeCost = 0.0;
		listpriceDic = dict("string");
			
		/*Start Changes for Massive Discount for 5 fixed products*/
		mrcDiscountBulk=0.0;
		nrcDiscountBulk=0.0; 
		runMassive = false;
		thresholdMassiveFlagES = false;
		thresholdMassiveString = "";
		selectCustomerSegment = "";
		V_SumMRCost = 0;
		V_SumNRC=0;
		V_SumMRC = 0;
		V_SumNRCost = 0;
		V_SumCMargin = 0;
		V_SumMarginPercent = 0;
		V_RCDiscountValue = 0;
		V_MRDiscountPer = 0;
		V_MRDiscountPerRound = 0;
		thresholdMassiveCount = 0;
		reason = "";
		sumString = "";
		disFlag = "false";
		selectCustomerSegment = upper(microSegment_quote);
		overrideFlag = true;
		V_MarginPercent =0;
		fixedPlaninfo = "";
		producttypeMassive = string[];
		fixedProducts = dict("string");
		//29/12/2016 added by santhosh
		V_TotalMRDiscount = 0.0;
		V_TotalMRDiscountRound = 0.0;
		V_CMargin = 0.0;
		V_CMarginper = 0.0;
		WeightedMArgin = 0.0;
		WeightedMArginRound	= 0.0;
		V_TotalMRDiscountRound1	= 0.0;
		V_MRCDiscountValue = 0.0;
		V_MRCDiscountValueRound	= 0.0;
		V_MRDiscountPer	= 0.0;
		V_TotalMRDiscountMargin = 0.0;
		mrcThresholdflag = "false";
		nrcThresholdflag = "false";
		blukDiscountflag = "false";
		reasonMRC = "";
		reasonNRC = "";
		modelLevelMassiveFlag = false;
		disflagMRCEqual = "false";
		disflagNRCEqual = "false";
		disflagMRCMAX = "false";
		disflagNRCMAX = "false";
		bulkDisountApplyflag = false;
		overrideuserflagNRC = "false";
		overrideuserflagMRC = "false";
		nrcthresholdvalue = 0.0;
		mrcthresholdvalue = 0.0;
		quantity=1;
		mrcnetpriceDic = dict("string");
		nrcnetpriceDic = dict("string");
		negativediscountflagNRC = false;
		negativediscountflagMRC = false;
		nrcoverrideflag = false;
		mrcoverrideflag = false;
		mrcreturnDiscount = 0.0;
		reconfigFlagforPrimary = "";
		migrationDateForCPE = "";
		primaryTariffInfo = "";
		quantityForPrimaryTariff = 0;
			
		/*Start Code To deactivate and activate Massive disocunt functionality for daily migration*/
		//Get a flag from table,if flag is "Y" then run all Massive discount code in library
		resultSet = BMQL("SELECT VariableName FROM CPQVariables WHERE AttributeName = 'MigrationDateCPE'");
		for each in resultSet{
			migrationDateForCPE = get(each, "VariableName");
		}
		records = bmql("select IsMassiveDiscount from BulkDiscount_Fixed where FixedPlan='MassiveDiscount'");
		for each in records{
			flag=get(each,"IsMassiveDiscount");
			if(flag=="Y"){			
				runMassive=true;			
			}
		}
		/* End Code To deactivate and activate Massive disocunt functionality for daily migration*/
		/*End Changes for Massive Discount for 6 fixed products*/
			
			
			/*Commented By : Ganeshram M Purpose : Term per connection*/
			If(contractTermMenu_quote <> "others"){
			
				if(isnumber(contractTermMenu_quote)){
				contractterm = atoi(contractTermMenu_quote);
				}
			}
			else{
				contractterm=contractTermOther_quote;
			}
			lineCommentArray=string[];
			
			//OpportunityContractDate formatting--------------------
			
			if(find(opportunityCloseDate_quote,"/")<>-1)
			{
				closeDAteDay =  substring(opportunityCloseDate_quote,0,2);//extracting year of close date
				closeDateMonth = substring(opportunityCloseDate_quote,3,5);//extracting month of close DAte
				closeDAteYear =  substring(opportunityCloseDate_quote,6,10);//extracting year of close date
					
					
			}
			if(find(opportunityCloseDate_quote,"-")<>-1)
			{
				closeDAteDay =  substring(opportunityCloseDate_quote,8,10);//extracting year of close date
				closeDateMonth = substring(opportunityCloseDate_quote,5,7);//extracting month of close DAte
				closeDAteYear =  substring(opportunityCloseDate_quote,0,4);//extracting year of close date
			}
				
			formattedopprotunityclosedate = closeDAteDay + "/" + closeDateMonth + "/" + closeDAteYear;  

			productIdArray = split(textAreaES2_quote,"%%%");
			// //print "productIdArray";
			// //print productIdArray;
			// //print "productIdArray";
			//// //print "textAreaES2_quote";
			//// //print textAreaES2_quote;
			/*Created By : Ganeshram M Purpose : To Constraint model wise*/
			for eachModel in productIdArray{
				modelCheck = split(eachModel,"$$");
				formedProductIDstring = formedProductIDstring +"##"+ modelCheck[1];
			}
			formedProductIdArray = split(formedProductIDstring,"##");	
			
			mrcListPriceTotal = 0.0;
			nrcListPriceTotal = 0.0;
			mrcNetPriceTotal =0.0;
			nrcNetPriceTotal =0.0;
			//line.mRCNetPrice_line = 0.0;
			//line.nRCNetPrice_line = 0.0;
			//Site Size
			for line in line_process {
				if(line._parent_doc_number == ""){
					countModel = countModel + 1;
					sitesize_ES = getconfigattrvalue(line._document_number,"primarySiteSize_ES");
					if(not(isnull(sitesize_ES)) AND sitesize_ES <>""){
				
					append(discountarray,sitesize_ES);
					}
					service = getconfigattrvalue(line._document_number,"afterSalesService_voiceData_ES");
				}
				if(line._parent_doc_number <> ""){
					lineComment=line._line_item_comment;
					lineCommentArray=split(lineComment,"**");
					siteName=lineCommentArray[25];
					VGERedFlag=lineCommentArray[68];
					put(SiteDict, line._parent_doc_number, siteName);
					
					put(SiteDict, line._document_number, lineCommentArray[55]);
				
					append(productIDArray,lineCommentArray[55]);
		
			
					//***Start Massive discount functionality -- *** - santhosh ***
					//To get Sum of all Costs,Prices and Margin for Masive discount products
					if(runMassive==true){	  
						if(NOT(ISNULL(lineCommentArray[52])) AND (lineCommentArray[52]<>"") AND ((lineCommentArray[52]=="legacyProductVPNAvalon") OR (lineCommentArray[52]=="legacyProductMPLSAndVPLSONO")  OR (lineCommentArray[52]=="legacyProductAccesoInternetONOAndVodafone") OR (lineCommentArray[52]=="enlacePortador") OR (lineCommentArray[52]=="iPVPN") OR (lineCommentArray[52]=="Legacy Extra Service"))){
							overrideFlag = false;
							append(producttypeMassive,lineCommentArray[52]);					
							mrcListPrice = util.atof_Custom(lineCommentArray[11]);
							nrcListPrice = util.atof_Custom(lineCommentArray[9]);
							monthlyCost = util.atof_Custom(lineCommentArray[7]);
							directCost = util.atof_Custom(lineCommentArray[6]);
							mrcNetPrice = util.atof_Custom(lineCommentArray[16]);
							nrcNetPrice = util.atof_Custom(lineCommentArray[14]);
							
							//mrcNetPriceTotal = mrcNetPriceTotal + (line.mRCNetPrice_line*quantity);
							//nrcNetPriceTotal = nrcNetPriceTotal + (line.nRCNetPrice_line*quantity);
							fixedPlaninfo = fixedPlaninfo + lineCommentArray[52]+"**";
							if(line._parent_doc_number <> ""){
								quantity=line._price_quantity;
								mrcListPriceTotal = mrcListPriceTotal + (mrcListPrice*quantity);
								nrcListPriceTotal = nrcListPriceTotal + (nrcListPrice*quantity);
								mrcNetPriceTotal = mrcNetPriceTotal + (mrcNetPrice*quantity);
								nrcNetPriceTotal = nrcNetPriceTotal + (nrcNetPrice*quantity);
							
								//put(listpriceDic1,line._document_number,mrcListPrice1);
								//containskey(dictionaryIdentifier, key)
								if(containskey(listpriceDic, line._parent_doc_number+"MRClistprice")){
							
									price1 = util.atof_Custom(get(listpriceDic,line._parent_doc_number+"MRClistprice"));
									price1 = price1 + mrcListPriceTotal;
									put(listpriceDic,line._parent_doc_number+"MRClistprice",string(price1));
									mrcListPriceTotal = 0.0;
								}
								else{
									put(listpriceDic,line._parent_doc_number+"MRClistprice",string(mrcListPriceTotal));
									mrcListPriceTotal = 0.0;
								}
								if(containskey(listpriceDic, line._parent_doc_number+"NRClistprice")){
								
									price1 = util.atof_Custom(get(listpriceDic,line._parent_doc_number+"NRClistprice"));
									price1 = price1 + nrcListPriceTotal;
									put(listpriceDic,line._parent_doc_number+"NRClistprice",string(price1));
									nrcListPriceTotal = 0.0;
								}
								else{
									put(listpriceDic,line._parent_doc_number+"NRClistprice",string(nrcListPriceTotal));
									nrcListPriceTotal = 0.0;
								}
								if(containskey(listpriceDic, line._parent_doc_number+"MRCNetprice")){
								
									price1 = util.atof_Custom(get(listpriceDic,line._parent_doc_number+"MRCNetprice"));
									price1 = price1 + mrcNetPriceTotal;
									put(listpriceDic,line._parent_doc_number+"MRCNetprice",string(price1));
									mrcNetPriceTotal = 0.0;
								}
								else{
									put(listpriceDic,line._parent_doc_number+"MRCNetprice",string(mrcNetPriceTotal));
									mrcNetPriceTotal = 0.0;
								}
								if(containskey(listpriceDic, line._parent_doc_number+"NRCNetprice")){
								
									price1=util.atof_Custom(get(listpriceDic,line._parent_doc_number+"NRCNetprice"));
									price1= price1 + nrcNetPriceTotal;
									put(listpriceDic,line._parent_doc_number+"NRCNetprice",string(price1));
									nrcNetPriceTotal = 0.0;
								}
								else{
									put(listpriceDic,line._parent_doc_number+"NRCNetprice",string(nrcNetPriceTotal));
									nrcNetPriceTotal = 0.0;
								}
							}								
							//Calculation for newly added columns				
							//Calculate recurring margin
							
								V_CMargin = (mrcListPrice - monthlyCost)*quantity;
								
								//Calculate recurring margin percentage
								if(mrcListPrice <> 0 ){
								V_MarginPercent = ( mrcListPrice - monthlyCost / mrcListPrice ) * 100;
								}
								//total of Margin Percent
								V_SumMarginPercent = V_SumMarginPercent + V_MarginPercent ;
								
								//Calculate Sum of monthly recurring list price
								V_SumMRC = V_SumMRC + (mrcListPrice*quantity);
								
								//Calculate sum of NRC list price
								V_SumNRC = V_SumNRC + (nrcListPrice*quantity);
								
								//Calculate Sum of One Time Cost
								V_SumNRCost = V_SumNRCost + directCost ;
								
								//Calculate Sum of Monthly Cost
								V_SumMRCost = V_SumMRCost + monthlyCost ;
								
								//Calculate Sum of CMargin
								V_SumCMargin = V_SumCMargin + V_CMargin ;
							
						}

						//***END Massive discount functionality -- *** - santhosh ***
					}
				
					//Added by Nikita Meharunkar for JO PDF 
					if(service=="Servicio Postventa Premium Planes Integrados" AND lineCommentArray[4]=="MPMVA"){
						fees= util.atof_Custom(lineCommentArray[16])- 1;
					}
					else{
						fees= util.atof_Custom(lineCommentArray[16]);
					}
					lineRes = lineRes + line._document_number + "~currencyES1_line~" +string(fees)+ "|";
					lineRes = lineRes + line._document_number + "~externalId_line~" +line._document_number + "-" + _system_buyside_id+"-"+version_number_version_quote+ "|";

				
				}
			}
			
				record = bmql("select Site_Size_Discount,Discount from GenericDiscount where Site_Size_Discount in $discountarray");
				for result in record{
					put(discountarraydict,get(result,"Site_Size_Discount"),get(result,"Discount"));
									//discount = util.atof_Custom(get(result,"Discount"));
					} 
		priceResult = recordset();
			if(customerSegment_quote <> "VGE"){
			priceResult=bmql("select ProductID,NRCInstallation,OneOffCharge,MonthlyRC,YearlyRC,MinConsumptionCharge,ActiveDate,ExpiryDate from PriceplanMobile where ProductID in $productIDArray");
		}
			//// //print "Site Dict";
			//// //print SiteDict;
			
			
			//Start Changes for Massive Discount for 6 fixed products //Added by santhosh
			records = bmql("select IsMassiveDiscount,FixedPlan from BulkDiscount_Fixed where FixedPlan in $producttypeMassive");
			for each in records{
				flag=get(each,"IsMassiveDiscount");
				productName=get(each,"FixedPlan");
				put(fixedProducts,productName,flag);
			}
			//End Changes for Massive Discount for 5 fixed products //Added by santhosh
				
			mrcListPricedoc = 0.0;
			nrcListPricedoc = 0.0;
			mrcNetPricedoc = 0.0;
			nrcNetPricedoc = 0.0;	
			mrcdisNetPriceTotal = 0.0;
			nrcdisNetPriceTotal = 0.0;		
			for line in line_process {
				monthyCost=0.0;
				modifiedCostFlag = "false";
				documentNumber=line._document_number;
			
				// add virendra for VGA
				if(line._parent_doc_number == "" AND getconfigattrvalue(line._document_number,"totalTargetSpent_VGE")<>"" AND getconfigattrvalue(line._document_number,"totalTargetSpent_VGE")<>"null" AND NOT(ISNULL(getconfigattrvalue(line._document_number,"totalTargetSpent_VGE"))) ){
									Aovaluenew = util.atof_Custom(getconfigattrvalue(line._document_number,"totalTargetSpent_VGE"));
					}
				
				if(string(line.productTerm_line)<>"" AND NOT(ISNULL(string(line.productTerm_line))) AND line.productTerm_line<>0 ){
							productContractEndDAte = adddays(strtojavadate(formattedopprotunityclosedate,"dd/MM/yyyy"),line.productTerm_line*30);
						}
				if(line._parent_doc_number == ""){

					//***Start Massive discount functionality -- *** - santhosh *** 
					MassiveFixedProducts = getconfigattrvalue(line._document_number,"selectedFixedProduct_ES");
					
					if((MassiveFixedProducts == "iPVPN" OR MassiveFixedProducts == "legacyProductAccesoInternetONOAndVodafone" OR MassiveFixedProducts == "legacyProductMPLSAndVPLSONO" OR MassiveFixedProducts == "enlacePortador" OR MassiveFixedProducts == "legacyProductVPNAvalon" OR MassiveFixedProducts =="legacyProductExtraServices") AND NOT(ISNULL(MassiveFixedProducts))){
						modelLevelMassiveFlag = false;
						overrideFlag = false;
						bulkDisountApplyflag = false;					
					}
					else{
						modelLevelMassiveFlag = true;
						overrideFlag = true;
						bulkDisountApplyflag = false;						
					}
					//***END Massive discount functionality -- *** - santhosh ***
					
					// Added by Dev to frame CPQ Details
					cpeDetails= getconfigattrvalue(line._document_number,"cPEPricingString");
					if(cpeDetails == "null" OR ISNULL(cpeDetails)){
					cpeDetails = "";
					}
					//End of Dev
					
					modelName=line._model_name;
					// //print "model Name";
					// //print modelName;
					// //print "modelName";
					if(VGERedFlag == "VGERed" or VGERedFlag == "OPA"){
								ARPUValue = getconfigattrvalue(line._document_number,"aRPUVGERed_VGE");
								//// //print "arpuvalue123";
								//// //print ARPUValue;
					}
					lineRes = lineRes + documentNumber + "~textES1_line~" + modelName + "|";
					responseprodid = getconfigattrvalue(line._document_number,"prodID_ResponseArray_ES");
					if(NOT(ISNULL(responseprodid)) and responseprodid <> "") {
						responseprodid1=split(responseprodid,"~");
						for each in responseprodid1{
							responseprodidval[count1]=each;
							count1= count1+1;
						}					
					}
					accessreccuring = getconfigattrvalue(line._document_number,"accessRecurringOpex_ResponseArray_ES");
					if(NOT(ISNULL(accessreccuring)) and accessreccuring <> "") {
						accessreccuring1 = split(accessreccuring,"~");
						for each in accessreccuring1{
							accessreccuringval[count2]=util.atof_Custom(each);
							count2= count2+1;
						}
					}	
					accessinitial = getconfigattrvalue(line._document_number,"accessInitialOpex_ResponseArray_ES");
					if(NOT(ISNULL(accessinitial)) and accessinitial <> "") {
						accessinitial1 = split(accessinitial,"~");
						for each in accessinitial1{
							accessinitialval[count3]=util.atof_Custom(each);
							count3= count3+1;
						}
					}
					selectedVATIDsCounter = getconfigattrvalue(line._document_number,"selectVATID_ES"); //added by:aditi
					if(NOT(ISNULL(selectedVATIDsCounter)) and selectedVATIDsCounter <> "") {
						selectedVATIDsValues=split(selectedVATIDsCounter,"$,$");
						for each in selectedVATIDsValues{
								VATIDCountArray[VATIDCount] = each ;
								VATIDCount = VATIDCount + 1;
						}					
					}
					selectedVATIDsString = getconfigattrvalue(line._document_number,"cIFGroup_ES"); //added by:aditi
					if(NOT(ISNULL(selectedVATIDsString)) and selectedVATIDsString <> "") {
					VATIDCount = 0;
					checkedID=0;
					
						selectedVATIDsValues=split(selectedVATIDsString,"$,$");
						for each in selectedVATIDsValues{
							if(VATIDCountArray[VATIDCount] == "true" AND VATIDCount==0){
								VATIDString = each ;
								checkedID = checkedID +1;
							}
							elif(VATIDCountArray[VATIDCount] == "true"){
								VATIDString = VATIDString + "" + each ;
								checkedID = checkedID +1;
							}
							VATIDCount = VATIDCount + 1;
						}		
						VATIDString = string(checkedID)+"**"+VATIDString;
					}
					
					//Setting product contract End Date
					
					configLeadTime = getconfigattrvalue(line._document_number,"maxLeadTimeLegacy_ES");
					reconfigFlagforPrimary = getconfigattrvalue(line._document_number, "reconfigureGlobalFlag");
					if(NOT(ISNULL(configLeadTime)) and configLeadTime <> "") {			
						if(atoi(configLeadTime) > leadTime) {
							leadTime = atoi(configLeadTime);
						}
					}
					// below if added for defect 1304
					//Commented by chandan to fix it permanaently
					if(parentChildStatus == "Child"){
						if(globalLeadTimeFinal_ES_quote > leadTime){
							leadTime = globalLeadTimeFinal_ES_quote;
						}
					}
					if((parentChildStatus == "Parent") AND (overallLeadTime_quote > 0)){
						if(overallLeadTime_quote > leadTime){
							leadTime = overallLeadTime_quote;
						}
					}
					//Setting product contract End Date
					selectedService="";
					internet_ES=getconfigattrvalue(line._document_number,"internet_ES");
					iPVPN_ES=getconfigattrvalue(line._document_number,"iPVPN_ES");
					vLAN_ES=getconfigattrvalue(line._document_number,"vLAN_ES");
					coS_ES=getconfigattrvalue(line._document_number,"coS_ES");
					//Getting ConfiguredplansES in a string
					selectedPlanFromCommerce=getconfigattrvalue(line._document_number,"selectedPlanFromCommerce_ES");
			
					//@aditi
					if(selectedPlanFromCommerce == "pPM"){
						ppmrateName = getconfigattrvalue(line._document_number,"tariffGroups_tariff_rateArray_ES");
						ppmcalls = getconfigattrvalue(line._document_number,"numberOfCalls_tariff_rateArray_ES");
						ppmMinutes = getconfigattrvalue(line._document_number,"callMinutes_tariff_rateArray_ES");
						// added - Pooja discount should be same as ppm
						ppmDiscount = getconfigattrvalue(line._document_number,"discount_tariff_rateArray_ES");
						
						ppmRateDetails = ppmrateName + "**" + ppmcalls + "**" + ppmMinutes + "**" + ppmDiscount;
						
					}
					lineRes = lineRes + documentNumber + "~ConfigAttribute1_line~" + ppmRateDetails + "|";
					
					if(not(isnull(internet_ES)) AND internet_ES=="true"){
					
						selectedService=selectedService+"Internet,";
					
					}
					if(not(isnull(iPVPN_ES)) AND iPVPN_ES=="true"){
					
						selectedService=selectedService+"IPVPN,";
					
					}
					if(not(isnull(vLAN_ES)) AND vLAN_ES=="true"){
					
					selectedService=selectedService+"VLAN,";
					}
					if(not(isnull(coS_ES)) AND coS_ES=="true"){
					
					selectedService=selectedService+"CoS,";
					}
					
					if(endswith(selectedService, ",")){
					selectedService=substring(selectedService,0,len(selectedService)-1);
					}
				
					connectivityType_ES=getconfigattrvalue(line._document_number,"connectivityType_ES");
					if(not(isnull(connectivityType_ES)) AND connectivityType_ES <>""){
					
					connectivityTypeVal=connectivityType_ES;
					}
				
					//Code for fetching Site Name for fixed line products
					siteNameVal = get(SiteDict, line._document_number);
					
					//// //print "Site Name";//// //print siteNameVal;
					
					datacenter_ES = getconfigattrvalue(line._document_number,"dataCenter_ES");
					if(not(isnull(datacenter_ES)) AND datacenter_ES <>""){
					
					datacenter=datacenter_ES;
					}
				
					sitesize_ES = getconfigattrvalue(line._document_number,"primarySiteSize_ES");
					if(not(isnull(sitesize_ES)) AND sitesize_ES <>""){
				
					sitesize=sitesize_ES;
					}
					if(line._model_name=="Smart Devices"){
						deviceSubsidyConfi = getconfigattrvalue(line._document_number,"subsidyConsumedDeviceArray_ES");
						
						if(not(isnull(deviceSubsidy)) AND deviceSubsidyConfi <>""){
							deviceSubsidy = util.atof_Custom(deviceSubsidyConfi);
						}
					}
					
					//***Start Massive discount functionality -- *** - santhosh ***
					if(containskey(listpriceDic,line._document_number+"MRClistprice")){
						mrcListPricedoc = util.atof_Custom(get(listpriceDic,line._document_number+"MRClistprice"));
						
					}else{
						mrcListPricedoc = 0.0;
					}
					
					if(containskey(listpriceDic,line._document_number+"NRClistprice")){
						nrcListPricedoc = util.atof_Custom(get(listpriceDic,line._document_number+"NRClistprice"));
						
					}else{
						nrcListPricedoc = 0.0;
					}
					
					if(containskey(listpriceDic,line._document_number+"MRCNetprice")){
						mrcNetPricedoc = util.atof_Custom(get(listpriceDic,line._document_number+"MRCNetprice"));
						
					}else{
						mrcNetPricedoc = 0.0;
					}
				
					if(containskey(listpriceDic,line._document_number+"NRCNetprice")){
						nrcNetPricedoc = util.atof_Custom(get(listpriceDic,line._document_number+"NRCNetprice"));
						
					}else{
						nrcNetPricedoc = 0.0;
					}
					//***END Massive discount functionality -- *** - santhosh ***
				
					if(modelName == "Quote Life Cycle"){
						modelNameQuote = "Ciclo de vida";
						lineRes = lineRes 	+ documentNumber + "~customizedProductName_line~" + modelNameQuote + "|"
						+ documentNumber + "~connectivityType_line~" + connectivityTypeVal + "|"
						+ documentNumber + "~productDescription_line~" + selectedService + "|";
						
					}			
					else{
						 if(siteNameVal<>""){
						   lineRes = lineRes 	+ documentNumber + "~siteName_line~" + siteNameVal + "|";	 
						  }
						lineRes = lineRes + documentNumber + "~connectivityType_line~" + connectivityTypeVal + "|"
						+ documentNumber + "~productDescription_line~" + selectedService + "|"
						+ documentNumber + "~overrideFlagsetFixed_ES_line~" + string(overrideFlag)+ "|"
						+ documentNumber + "~modeLevelMassiveFlag_line~" + string(modelLevelMassiveFlag)+ "|"
						+ documentNumber + "~bulkDiscountApplied_line~" + string(bulkDisountApplyflag)+ "|";
						
					}
					if(modelLevelMassiveFlag == false){
						lineRes = lineRes 	+ documentNumber + "~mRCListPriceES_line~" + String(mrcListPricedoc) + "|"
								+ documentNumber + "~nRCListPriceES_line~" + String(nrcListPricedoc) + "|"
								+ documentNumber + "~mRCNetPrice_line~" + String(mrcNetPricedoc) + "|"
								+ documentNumber + "~nRCNetPrice_line~" + String(nrcNetPricedoc) + "|";
					}
					// //// //print "productContractEndDate_line---";
					// //// //print productContractEndDAte;
				
					
				
					//	+ documentNumber + "~productContractEndDate_line~" + datetostr(productContractEndDAte)+ "|";
					//Added by Nikita Meharunkar for JO PDF BUG             
					CIFGroup = getconfigattrvalue(line._document_number,"cIFGroup_ES");
					if(not(isnull(CIFGroup)) AND find(CIFGroup,"$,$") <> -1){
						SplitCIFGroup=split(CIFGroup,"$,$");
						//// //print SplitCIFGroup;
			
						Percentage = getconfigattrvalue(line._document_number,"percentageAllocated_ES");
						SplitPercentage=split(Percentage,"$,$");
						//// //print SplitPercentage;
				
						index=0;
						for each in SplitCIFGroup{
		
							testTextArea7ES=testTextArea7ES+SplitCIFGroup[index]+"#"+ SplitPercentage[index] +";";
							////// //print testTextArea7ES;
			
							index=index+1;
						}
					}
					 //Added by Nikita Meharunkar for Post sales services(CR)
					service = getconfigattrvalue(line._document_number,"afterSalesService_voiceData_ES");
					serviceType = getconfigattrvalue(line._document_number,"serviceType_RedEm_ES");
					if(NOT(isnull(service)) AND service <> "" OR NOT(isnull(serviceType)) AND serviceType <> ""){
					
						if(service=="Servicio Postventa Class" OR serviceType =="Servicio Postventa Class"){
							eurosVFFlag=true;
						}
					}
						
					excessCharges1=getconfigattrvalue(line._document_number,"excessOfCharge_voiceData_ES");
					if(NOT(isnull(excessCharges1))){
					excessCharges=excessCharges1;
					}
					//// //print "excessCharges";
					//// //print excessCharges;
					
					//Start : Added by Mahesh for PPM Roaming CR
					PPMRoamingPlan=getconfigattrvalue(line._document_number,"roamingPlanForPPM_ES");
					if(NOT(ISNULL(PPMRoamingPlan)))
					{
					  PPMRoamingPlanString="PPMRoaming!!"+PPMRoamingPlan+"@"+string(1)+"**";
					}
					//End
				}
				
				discount = util.atof_Custom(get(discountarraydict,sitesize));
				if(line._parent_doc_number <> ""){
				
			
					lineComment=line._line_item_comment;
					lineCommentArray=split(lineComment,"**");
					if(not(isnull(lineCommentArray[4]))){
						CRMCode = lineCommentArray[4];
					}else{
						CRMCode = "";
					}
					/* Created By : Ganeshram M Purpose : Term Per Connection*/
					startMonthTerm = lineCommentArray[59];
					startYear = lineCommentArray[60];
					endMonthTerm = lineCommentArray[62];
					endYear = lineCommentArray[63];	
						
					//// //print startDateValue;
					if(startMonthTerm<>"" AND startMonthTerm<>"null" AND NOT(ISNULL(startMonthTerm)) AND startYear<>"" AND startYear<>"null" AND NOT(ISNULL(startYear))){
						startDateValue = startMonthTerm+"/01/"+startYear+" 00:00:00";
					}
					elif(line.date1ES_line<>"" AND line.date1ES_line<>"null" AND NOT(ISNULL(line.date1ES_line))){
						startDateValue = line.date1ES_line;
						startDateTemp = split(startDateValue,"-");
						startDateValue = startDateTemp[1]+"/"+substring(startDateTemp[2],0,2)+"/"+startDateTemp[0]+" 00:00:00";
					}
					if(endMonthTerm<>"" AND endMonthTerm<>"null" AND NOT(ISNULL(endMonthTerm)) AND endYear<>"" AND endYear<>"null" AND NOT(ISNULL(endYear))){
						if(endMonthTerm<>"2"){
							endDateValue = endMonthTerm+"/30/"+endYear+" 00:00:00";
						}
						if(endMonthTerm == "2"){
							endDateValue = endMonthTerm+"/28/"+endYear+" 00:00:00";
						}
					}
					elif(line.date2ES_line<>"" AND line.date2ES_line<>"null" AND NOT(ISNULL(line.date2ES_line))){
						endDateValue = line.date2ES_line;
						endDateTemp = split(endDateValue,"-");
						endDateValue = endDateTemp[1]+"/"+substring(endDateTemp[2],0,2)+"/"+endDateTemp[0]+" 00:00:00";
					}
					startDate = strtojavadate(startDateValue,"MM/dd/yyyy HH:mm:ss");					
					finalStartDate = datetostr(startDate,"MM/dd/yyyy HH:mm:ss");
					endDate = strtojavadate(endDateValue,"MM/dd/yyyy HH:mm:ss");
					
					//Product Term Calculation
					startDateValueArray = split(startDateValue,"/");
					endDateValueArray = split(endDateValue,"/");
					endYear1 = atoi(substring(endDateValueArray[2],0,4));
					startYear1 = atoi(substring(startDateValueArray[2],0,4));
					endMonth1 = atoi(endDateValueArray[0]);
					startMonth1 = atoi(startDateValueArray[0]);
					if(VGERedFlag == "VGERed" or VGERedFlag == "OPA"){
						productTerm = testIntegerES1_quote - line.startMonth_line + 1;
					}
					elif(lineCommentArray[52] <> "DEVICES"){
						productTerm = ((endYear1 - startYear1)*12+(endMonth1-StartMonth1) +1);
					}
					
					if(productTerm > contractTerm){
					
						contractTerm = productTerm;
					}
						
					if(lineCommentArray[27]<>"" AND lineCommentArray[27]<>"null" AND NOT(ISNULL((lineCommentArray[27])))){
						category = lineCommentArray[27];
					}
					
					finalEndDate = datetostr(endDate,"MM/dd/yyyy HH:mm:ss");
					qty=line._price_quantity;
					
					//logic to calculate AOV================================
					if(lower(lineCommentArray[52]) == "ppm" OR lower(lineCommentArray[52]) == "integrated" OR lower(lineCommentArray[52]) == "hbd" OR lower(lineCommentArray[52]) == "lpd" OR (find(lineCommentArray[52],"red empresa") <> -1) OR lower(lineCommentArray[52]) == "integrateddata" OR lower(lineCommentArray[52]) == "integratedvoice"){
					
						put(deviceCatagory,"Mobile",productTerm);
					
					}elif(lower(lineCommentArray[52]) == "local sim" OR lower(lineCommentArray[52]) == "global sim"){
						put(deviceCatagory,"M2M",productTerm);
					}					
					if(lineCommentArray[1] == "DC Cloud Server Entry" OR lineCommentArray[1] == "DC Cloud Server Advanced"){
						cloudServerFlag = true;
					}
					// Fixed loop starts Here
					if(lineCommentArray[0] == "Fixed"){
						fixedFlag=true;
						siteName=lineCommentArray[25];
						productName=lineCommentArray[1];
						if(lineCommentArray[27] =="Bespoke" OR lineCommentArray[27] =="Bespoke-Capex"){
							productDesc=lineCommentArray[2];
						
						}
						else{
							productDesc=line._part_desc;
						}
						mrcListPrice=util.atof_Custom(lineCommentArray[11]);
						nrcListPrice=util.atof_Custom(lineCommentArray[9]);
						modifiedCostFlag = lineCommentArray[76];
						if(lineCommentArray[52]=="iPVPN"){
							modifiedCostFlag = lineCommentArray[64];
						}
						if(lineCommentArray[52]=="enlacePortador"){
							modifiedCostFlag = lineCommentArray[67];
						}
						if(lineCommentArray[52]=="legacyProductVPNAvalon" OR lineCommentArray[52]=="legacyProductAccesoInternetONOAndVodafone" OR lineCommentArray[52]=="legacyProductMPLSAndVPLSONO"){
							modifiedCostFlag = lineCommentArray[69];
						}
						// CR 007 implementation for fesibility product E
						monthyCost=util.atof_Custom(lineCommentArray[7]);
						//added by chandan to fix IP trunk defect
						installationCostSIP = util.atof_Custom(lineCommentArray[5]);
						directCost=util.atof_Custom(lineCommentArray[6]);
						yearlyCost=util.atof_Custom(lineCommentArray[8]);
						InterconnectCost=util.atof_Custom(lineCommentArray[31]);
						OtherIncreamentalCost=util.atof_Custom(lineCommentArray[32]);
						capex=util.atof_Custom(lineCommentArray[37]);
						annualFee=util.atof_Custom(lineCommentArray[12]);
						annualFeeDiscount=util.atof_Custom(lineCommentArray[22]);
						annualFeeOffer=util.atof_Custom(lineCommentArray[17]);
						infrastructureCapex=util.atof_Custom(lineCommentArray[33]);
						txNetwork=util.atof_Custom(lineCommentArray[34]);
						systemCapex=util.atof_Custom(lineCommentArray[35]);
						accessNetwork=util.atof_Custom(lineCommentArray[36]);
						producttype[count] = lineCommentArray[52];
						productid[count] =lineCommentArray[55];
						recurrencerevenue = mrcNetPrice + annualFeeOffer/12 + MinimumConsumptionOffer;
						
				//***Start Massive discount functionality -- *** - santhosh ***
				//To get all Fixed plans added in line items
				//fixedPlaninfo = fixedPlaninfo + lineCommentArray[52]+"**";
				
				if(runMassive==true){
					if(parentChildStatus <> "Child"){
						bulkDiscountFlag=false;
						massapprovalFlag=false;
						overrideuserflagNRC = "false";
						overrideuserflagMRC = "false";
						overrideuserflagNRC = "false";
						overrideuserflagMRC = "false";
						bulkDisountApplyflag = false;
						negativediscountflagNRC = false;
						negativediscountflagMRC = false;
						nrcoverrideflag = false;
						mrcoverrideflag = false;
						blukDiscountflag = "false";	
						nrcDiscountBulk = 0.0;
						mrcDiscountBulk = 0.0;					
						thresholdMassiveCount = thresholdMassiveCount + 1;
						selectCustomerSegment = microSegment_quote;
						
						if(containskey(fixedProducts,lineCommentArray[52])){
							flag = get(fixedProducts,lineCommentArray[52]);
							if(flag == "Y"){
								bulkDiscountFlag=true;
							}
						}
						if(bulkDiscountFlag == true AND applyBulkDiscoutForFixedProduct_ES == true AND tesValidationflag_Quote ==true){
						
							//print "Massive Discounts for Legacy";
							//producttypeMassive = lineCommentArray[52];
							productidMassive =lineCommentArray[55];					
							if(targetOneTimetext_Quote <> "" AND targetRecurringtext_Quote <> ""){
								//print "Target price";
								bulkDisountApplyflag = true;
								blukDiscountflag = "false";	
								manualOverrideNRCFlag = "false";
								manualOverrideMRCFlag = "false";							
								overrideuserflagNRC = "false";
								overrideuserflagMRC = "false";
								negativediscountflagNRC = false;
								negativediscountflagMRC = false;
								nrcoverrideflag = false;
								mrcoverrideflag = false;
								//NRC Discount Calculation based on Target price
								/*if(nrcListPrice <> 0.0 AND line.overrideNRCDiscountFixedtext_line == ""){
									nrcNetPrice = util.atof_Custom(targetOneTimetext_Quote);
								}
								else{								
									nrcListPrice = util.atof_Custom(lineCommentArray[9]);
								}*/			
								if(line.overrideNRCDiscountFixedtext_line == ""){
									if(V_SumNRC <> 0.0){
										nrcDiscountBulk1 = round((V_SumNRC - util.atof_Custom(targetOneTimetext_Quote))/V_SumNRC*100,2);
									}
									else{
										nrcDiscountBulk = 0.0;
									}
									if(nrcDiscountBulk1 < 0.0){
										negativediscountflagNRC = true;
									}
									else{
										if(nrcListPrice <> 0.0){
											nrcDiscountBulk = nrcDiscountBulk1;
										}
										else{
											nrcDiscountBulk = 0.0;
										}
									}
									if(parentChildStatus == "Child"){
										nrcDiscountBulk = 0.0;
									}
									
								}
								else{
									if((util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideNRCDiscountFixedtext_line)){
										manualOverrideNRCFlag ="true";
										nrcDiscountBulk = util.atof_Custom(line.overrideNRCDiscountFixedtext_line);
									}
									else{
										nrcoverrideflag = true;
										
									}
								}
								
								//MRC Discount Calculation based on Target price
								/*if(mrcListPrice <> 0.0 AND line.overrideMRCDiscountFixedtext_line == ""){
									
									mrcNetPrice = util.atof_Custom(targetRecurringtext_Quote);
								}
								else{
									
									mrcListPrice=util.atof_Custom(lineCommentArray[11]);
								}*/
								if(line.overrideMRCDiscountFixedtext_line == ""){
									//print "override user MRC BULK";
									if(V_SumMRC <> 0){
										mrcDiscountBulk1 = round((V_SumMRC -  util.atof_Custom(targetRecurringtext_Quote))/V_SumMRC*100,2);
									}
									else{
										mrcDiscountBulk = 0.0;
									}
									if(mrcDiscountBulk1 < 0.0){
										negativediscountflagMRC = true;
									}
									else{
										mrcDiscountBulk = mrcDiscountBulk1;
										mrcreturnDiscount = util.mRCCalcualtedMassiveDiscount_ES(mrcDiscountBulk, mrcListPrice, monthyCost, nrcListPrice, qty, integer(V_SumMRC), integer(V_SumCMargin));
										if(mrcreturnDiscount <> 0.0){
											mrcDiscountBulk = mrcreturnDiscount;	
										}
										else{
											mrcDiscountBulk = 0.0;
										}
										if(parentChildStatus == "Child"){
											mrcDiscountBulk = 0.0;
										}
										
									}
									
								}	
								else{
									if((util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideMRCDiscountFixedtext_line)){
										manualOverrideMRCFlag ="true";									
										mrcDiscountBulk = util.atof_Custom(line.overrideMRCDiscountFixedtext_line);
									}
									else{
										mrcoverrideflag = true;
									}
									
								}
								/*print "mrcDiscountBulk";
								print productidMassive;
								print mrcDiscountBulk;
								print nrcDiscountBulk;
								print mrcListPrice;
								print nrcListPrice;
								print contractTerm;
								print selectCustomerSegment;*/	
								if(negativediscountflagNRC == false OR negativediscountflagMRC == false){	
									returnStr = util.massiveDiscountsNetPriceCalculations_ES(productidMassive, mrcDiscountBulk, nrcDiscountBulk, mrcListPrice, nrcListPrice, contractTerm, upper(selectCustomerSegment), manualOverrideNRCFlag, manualOverrideMRCFlag);
									//returnStr = util.massiveDiscountsNetPriceCalculation_ES(productidMassive, mrcDiscountBulk, nrcDiscountBulk, mrcListPrice, nrcListPrice, contractTerm, upper(selectCustomerSegment));
								
									//print returnStr;
									if(not(isnull(returnStr)) AND returnStr <> "" AND find(returnStr,"&&") <> -1){
										strArray = split(returnStr,"&&");
										mrcNetPrice = util.atof_Custom(strArray[0]);
										nrcNetPrice = util.atof_Custom(strArray[1]);
										nrcThresholdflag = strArray[2];
										reasonNRC = strArray[3];
										mrcThresholdflag = strArray[4];
										reasonMRC = strArray[5];
										disflagMRCEqual = strArray[6];
										disflagNRCEqual = strArray[7];
										disflagMRCMAX = strArray[8];
										disflagNRCMAX = strArray[9];
										mrcDiscount = util.atof_Custom(strArray[10]);
										nrcDiscount = util.atof_Custom(strArray[11]);
										//blukDiscountflag = strArray[12];
										nrcthresholdvalue = util.atof_Custom(strArray[13]);
										mrcthresholdvalue = util.atof_Custom(strArray[14]);
										MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
										MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
										MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
										if(nrcThresholdflag == "true" AND line.overrideNRCDiscountFixedtext_line <> "" ){
											
											if(util.atof_Custom(line.overrideNRCDiscountFixedtext_line) >= nrcthresholdvalue){
										
												blukDiscountflag = "true";
												overrideuserflagNRC = "true";
											}
										}
										if(mrcThresholdflag == "true" AND line.overrideMRCDiscountFixedtext_line <> ""){
											
											//blukDiscountflag = "false";
											if(util.atof_Custom(line.overrideMRCDiscountFixedtext_line) >= mrcthresholdvalue){
											
												blukDiscountflag = "true";
												overrideuserflagMRC = "true";
											}
										}
									}
								}
								else{
									mrcNetPrice=util.atof_Custom(lineCommentArray[16]);
									nrcNetPrice=util.atof_Custom(lineCommentArray[14]);
									mrcDiscount=util.atof_Custom(lineCommentArray[21]);
									nrcDiscount=util.atof_Custom(lineCommentArray[19]);
									MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
									MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
									MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
								}
							}
							else{
								print "ALl condtions";
								if((oneTimeBulkDiscount_ES >= 0.0 AND oneTimeBulkDiscount_ES <=100) OR (monthlyRecurringBulkDiscount_ES > 0.0 AND monthlyRecurringBulkDiscount_ES <=100)){
									
									bulkDisountApplyflag = true;
									blukDiscountflag = "false";
									manualOverrideNRCFlag = "false";
									manualOverrideMRCFlag = "false";
									negativediscountflagNRC = false;
									negativediscountflagMRC = false;
									nrcoverrideflag = false;
									mrcoverrideflag = false;
																	
									if(line.overrideNRCDiscountFixedtext_line == "" AND targetOneTimetext_Quote ==""){
										//print "santhoshNRCline";
										if(oneTimeBulkDiscount_ES >=0.0 AND oneTimeBulkDiscount_ES <=100 AND nrcListPrice <> 0.0){
											nrcDiscountBulk = oneTimeBulkDiscount_ES; 
										}
										else{
											nrcDiscountBulk = 0.0;
										}
										//Added By Chandan for BUG - 094
										if(parentChildStatus == "Child"){
											nrcDiscountBulk = 0.0;
										}
									}
									elif(targetOneTimetext_Quote <> ""){
										//print "entered target onetime";
										//print targetOneTimetext_Quote;
										bulkDisountApplyflag = true;
										/*if(line.overrideNRCDiscountFixedtext_line == ""){
										//print "ENter NRC target price";
											if(nrcListPrice <> 0.0){
												nrcNetPrice = util.atof_Custom(targetOneTimetext_Quote);
												//print "nrcNetPrice";
												//print nrcNetPrice;
											}
										}
										else{
											nrcListPrice = util.atof_Custom(lineCommentArray[9]);
										}*/
										
										if(line.overrideNRCDiscountFixedtext_line == ""){
											if(V_SumNRC <> 0.0){
												nrcDiscountBulk1 = round((V_SumNRC - util.atof_Custom(targetOneTimetext_Quote))/V_SumNRC*100,2);
											
											}
											else{
												nrcDiscountBulk = 0.0;
											}
											if(nrcDiscountBulk1 < 0.0){
												negativediscountflagNRC = true;
											}
											else{
												if(nrcListPrice <> 0.0){
													nrcDiscountBulk = nrcDiscountBulk1;
												}
												else{
													nrcDiscountBulk = 0.0;
												}
											}
											if(parentChildStatus == "Child"){
												nrcDiscountBulk = 0.0;
											}
											
										}
										else{
											if((util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideNRCDiscountFixedtext_line)){
												manualOverrideNRCFlag ="true";
												nrcDiscountBulk = util.atof_Custom(line.overrideNRCDiscountFixedtext_line);
											}
											else{
												nrcoverrideflag = true;
											}
											
										}
									}
									else{
										if((util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideNRCDiscountFixedtext_line)){
											manualOverrideNRCFlag = "true";
											nrcDiscountBulk = util.atof_Custom(line.overrideNRCDiscountFixedtext_line);
										}
										else{
											nrcoverrideflag = true;
										}
										//mrcDiscountBulk = line.overrideMRCDiscountFixed_line;		
									}
									//MRC Discount clculation Based on given Monthly bulk discount								
									if(line.overrideMRCDiscountFixedtext_line == "" AND targetRecurringtext_Quote == ""){
										if(monthlyRecurringBulkDiscount_ES > 0.0 AND monthlyRecurringBulkDiscount_ES <= 100 ){
											
											mrcDiscountBulk = monthlyRecurringBulkDiscount_ES;
										
											mrcreturnDiscount = util.mRCCalcualtedMassiveDiscount_ES(mrcDiscountBulk, mrcListPrice, monthyCost, nrcListPrice, qty, integer(V_SumMRC), integer(V_SumCMargin));
											if(mrcreturnDiscount <> 0.0){
												mrcDiscountBulk = mrcreturnDiscount;	
											}
											else{
												mrcDiscountBulk = 0.0;
											}
										
										}
										if(parentChildStatus == "Child"){
											nrcDiscountBulk = 0.0;
										}
									}
									elif(targetRecurringtext_Quote <> ""){								
										bulkDisountApplyflag = true;
										
										/*if(line.overrideMRCDiscountFixedtext_line <> ""){
											if(mrcListPrice <> 0.0){
												mrcNetPrice = util.atof_Custom(targetRecurringtext_Quote);
											}
										}
										else{
											mrcListPrice=util.atof_Custom(lineCommentArray[11]);
										}*/
										
										if(line.overrideMRCDiscountFixedtext_line == ""){
											if(V_SumMRC <> 0.0){
												mrcDiscountBulk1 = round((V_SumMRC - util.atof_Custom(targetRecurringtext_Quote))/V_SumMRC*100,2);
											}
											else{
												mrcDiscountBulk = 0.0;
											}
											if(mrcDiscountBulk1 < 0.0){
												
												negativediscountflagMRC = true;
											}
											else{
												mrcDiscountBulk = mrcDiscountBulk1;
												mrcreturnDiscount = util.mRCCalcualtedMassiveDiscount_ES(mrcDiscountBulk, mrcListPrice, monthyCost, nrcListPrice, qty, integer(V_SumMRC), integer(V_SumCMargin));
												if(mrcreturnDiscount <> 0.0){
													mrcDiscountBulk = mrcreturnDiscount;	
												}
												else{
													mrcDiscountBulk = 0.0;
												}
											}
											if(parentChildStatus == "Child"){
												nrcDiscountBulk = 0.0;
											}
											
										}
										else{
											if((util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideMRCDiscountFixedtext_line)){	
												manualOverrideMRCFlag ="true";
												mrcDiscountBulk = util.atof_Custom(line.overrideMRCDiscountFixedtext_line);
											}
											else{
												mrcoverrideflag = true;
											}
											
										}
									}
									else{								
										if((util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideMRCDiscountFixedtext_line)){
											manualOverrideMRCFlag = "true";
											//nrcDiscountBulk = line.overrideNRCDiscountFixed_line;										
											mrcDiscountBulk = util.atof_Custom(line.overrideMRCDiscountFixedtext_line);	
										}
										else{
											mrcoverrideflag = true;
										}									
									}

									/*print "mrcDiscountBulk Discount";
									print productidMassive;
									print mrcDiscountBulk;
									print nrcDiscountBulk;
									print mrcListPrice;
									print nrcListPrice;
									print contractTerm;
									print selectCustomerSegment;*/
									//Below Util Used for MRC AND NRC Net price calculation based on calculated discount
									returnStr = util.massiveDiscountsNetPriceCalculations_ES(productidMassive, mrcDiscountBulk, nrcDiscountBulk, mrcListPrice, nrcListPrice, contractTerm, upper(selectCustomerSegment), manualOverrideNRCFlag, manualOverrideMRCFlag);
									//returnStr = util.massiveDiscountsNetPriceCalculation_ES(productidMassive, mrcDiscountBulk, nrcDiscountBulk, mrcListPrice, nrcListPrice, contractTerm, upper(selectCustomerSegment));
								
									if(negativediscountflagNRC == false OR negativediscountflagMRC == false){	
										if(not(isnull(returnStr)) AND returnStr <> "" AND find(returnStr,"&&") <> -1){
											strArray = split(returnStr,"&&");
											
											mrcNetPrice = util.atof_Custom(strArray[0]);
											nrcNetPrice = util.atof_Custom(strArray[1]);
											nrcThresholdflag = strArray[2];
											reasonNRC = strArray[3];
											mrcThresholdflag = strArray[4];
											reasonMRC = strArray[5];
											disflagMRCEqual = strArray[6];
											disflagNRCEqual = strArray[7];
											disflagMRCMAX = strArray[8];
											disflagNRCMAX = strArray[9];
											mrcDiscount = util.atof_Custom(strArray[10]);
											nrcDiscount = util.atof_Custom(strArray[11]);
											//blukDiscountflag = strArray[12];
											nrcthresholdvalue = util.atof_Custom(strArray[13]);
											mrcthresholdvalue = util.atof_Custom(strArray[14]);
											MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
											MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
											MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
										}
										if(nrcThresholdflag == "true" AND line.overrideNRCDiscountFixedtext_line <> "" ){
											
											if(util.atof_Custom(line.overrideNRCDiscountFixedtext_line) >= nrcthresholdvalue){
											
												blukDiscountflag = "true";
												overrideuserflagNRC = "true";
											}
										}
										if(mrcThresholdflag == "true" AND line.overrideMRCDiscountFixedtext_line <> ""){
											
											//blukDiscountflag = "false";
											if(util.atof_Custom(line.overrideMRCDiscountFixedtext_line) >= mrcthresholdvalue){
											
												blukDiscountflag = "true";
												overrideuserflagMRC = "true";
											}
										}
									}
									else{
										mrcNetPrice=util.atof_Custom(lineCommentArray[16]);
										nrcNetPrice=util.atof_Custom(lineCommentArray[14]);
										mrcDiscount=util.atof_Custom(lineCommentArray[21]);
										nrcDiscount=util.atof_Custom(lineCommentArray[19]);
										
										MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
										MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
										MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
									}
									

								}
								
							}
						
						}
						elif(bulkDiscountFlag == true AND applyBulkDiscoutForFixedProduct_ES == false AND (line.overrideMRCDiscountFixedtext_line <> "" OR line.overrideNRCDiscountFixedtext_line <> "" AND tesValidationflag_Quote ==true)){
						
							print "Only Manual Override condition";						
							bulkDisountApplyflag = false;
							manualOverrideNRCFlag = "false";
							manualOverrideMRCFlag = "false";
							nrcoverrideflag = false;
							mrcoverrideflag = false;
										
							//bulkDisountApplyflag = true;
							if(line.overrideMRCDiscountFixedtext_line <> ""){
								if((util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideMRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideMRCDiscountFixedtext_line)){	
									manualOverrideMRCFlag = "ture";
									mrcDiscountBulk = util.atof_Custom(line.overrideMRCDiscountFixedtext_line); 
								}
								else{
									mrcoverrideflag = true;
								}
							}
							if(line.overrideNRCDiscountFixedtext_line <> ""){
								if((util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=0 OR util.atof_Custom(line.overrideNRCDiscountFixedtext_line) <=100) AND isnumber(line.overrideNRCDiscountFixedtext_line)){
								manualOverrideNRCFlag = "true";
									nrcDiscountBulk = util.atof_Custom(line.overrideNRCDiscountFixedtext_line);
								}
								else{
									nrcoverrideflag = true;
								}
							}
							productidMassive = lineCommentArray[55];
							returnStr = util.massiveDiscountsNetPriceCalculations_ES(productidMassive, mrcDiscountBulk, nrcDiscountBulk, mrcListPrice, nrcListPrice, contractTerm, upper(selectCustomerSegment), manualOverrideNRCFlag, manualOverrideMRCFlag);					
							//returnStr = util.massiveDiscountsNetPriceCalculation_ES(productidMassive, mrcDiscountBulk, nrcDiscountBulk, mrcListPrice, nrcListPrice, contractTerm, upper(selectCustomerSegment));
							
							if(not(isnull(returnStr)) AND returnStr <> "" AND find(returnStr,"&&") <> -1){
								strArray = split(returnStr,"&&");
								mrcNetPrice = util.atof_Custom(strArray[0]);
								nrcNetPrice = util.atof_Custom(strArray[1]);
								nrcThresholdflag = strArray[2];
								reasonNRC = strArray[3];
								mrcThresholdflag = strArray[4];
								reasonMRC = strArray[5];
								disflagMRCEqual = strArray[6];
								disflagNRCEqual = strArray[7];
								disflagMRCMAX = strArray[8];
								disflagNRCMAX = strArray[9];
								mrcDiscount = util.atof_Custom(strArray[10]);
								nrcDiscount = util.atof_Custom(strArray[11]);
								blukDiscountflag = strArray[12];
								nrcthresholdvalue = util.atof_Custom(strArray[13]);
								mrcthresholdvalue = util.atof_Custom(strArray[14]);
								if(nrcThresholdflag == "true" AND line.overrideNRCDiscountFixedtext_line <> "" ){
									overrideuserflagNRC = "true";
								}
								if(mrcThresholdflag == "true" AND line.overrideMRCDiscountFixedtext_line <> ""){
									overrideuserflagMRC = "true";
								}
							}
							
						}
						else{			
							//If bulkdiscount flag is false(other than 5 fixed products in line item) then get values from configuration
							mrcNetPrice=util.atof_Custom(lineCommentArray[16]);
							nrcNetPrice=util.atof_Custom(lineCommentArray[14]);
							mrcDiscount=util.atof_Custom(lineCommentArray[21]);
							nrcDiscount=util.atof_Custom(lineCommentArray[19]);
							
							MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
							MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
							MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
						}
					}
					else{			
						//If bulkdiscount flag is false(other than 5 fixed products in line item) then get values from configuration
						mrcNetPrice=util.atof_Custom(lineCommentArray[16]);
						nrcNetPrice=util.atof_Custom(lineCommentArray[14]);
						mrcDiscount=util.atof_Custom(lineCommentArray[21]);
						nrcDiscount=util.atof_Custom(lineCommentArray[19]);
						
						MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
						MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
						MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
					}				
					//}
				}
				else{

					//If bulkdiscount flag is false(other than 5 fixed products in line item) then get values from configuration
					mrcNetPrice=util.atof_Custom(lineCommentArray[16]);
					nrcNetPrice=util.atof_Custom(lineCommentArray[14]);
					mrcDiscount=util.atof_Custom(lineCommentArray[21]);
					nrcDiscount=util.atof_Custom(lineCommentArray[19]);
					
					MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
					MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
					MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
				}
				bulkDiscountFlag=false;
				if(runMassive==true){
					if(containskey(fixedProducts,lineCommentArray[52])){
						flag = get(fixedProducts,lineCommentArray[52]);
						if(flag == "Y"){
							bulkDiscountFlag=true;
						}
					}
					if(bulkDiscountFlag == true AND tesValidationflag_Quote ==true){
						mrcdisNetPriceTotal = mrcdisNetPriceTotal + (mrcNetPrice*qty);
						nrcdisNetPriceTotal = nrcdisNetPriceTotal + (nrcNetPrice*qty);
						if(containskey(mrcnetpriceDic, line._parent_doc_number+"MRCNetprice")){
						
							mrcprice = util.atof_Custom(get(mrcnetpriceDic,line._parent_doc_number+"MRCNetprice"));
							mrcprice = mrcprice + mrcdisNetPriceTotal;
							put(mrcnetpriceDic,line._parent_doc_number+"MRCNetprice",string(mrcprice));
							mrcdisNetPriceTotal = 0.0;
						}
						else{
							put(mrcnetpriceDic,line._parent_doc_number+"MRCNetprice",string(mrcdisNetPriceTotal));
							mrcdisNetPriceTotal = 0.0;
						}
						if(containskey(nrcnetpriceDic, line._parent_doc_number+"NRCNetprice")){
						
							nrcprice = util.atof_Custom(get(nrcnetpriceDic,line._parent_doc_number+"NRCNetprice"));
							nrcprice = nrcprice + nrcdisNetPriceTotal;
							put(nrcnetpriceDic,line._parent_doc_number+"NRCNetprice",string(nrcprice));
							nrcdisNetPriceTotal = 0.0;
						}
						else{
							put(nrcnetpriceDic,line._parent_doc_number+"NRCNetprice",string(nrcdisNetPriceTotal));
							nrcdisNetPriceTotal = 0.0;
						}
					}
				}
		
		//***END Massive discount functionality -- ***santhosh***
										
					//planInfo = planInfo + lineCommentArray[52]+"@"+string(qty)+"**";
					inputstr=lineCommentArray[42];
					//connectiontypeValue = lineCommentArray[56]; //Commented By : Ganeshram M Purpose : Handled in detailed scenarios in below
									
					//startMonth=lineCommentArray[5];
					revisedprice =util.priceVersioningforFixed_ES(currentdate,productid,responseprodidval,accessreccuringval,inputstr,contractterm,accessinitialval,cap);
					if(containskey(revisedprice,productid[0])){
						price = split(get(revisedprice,productid[0]),"###");
						mrcprice = util.atof_Custom(price[0]);
						nrcprice = util.atof_Custom(price[1]);
						
						if(lineCommentArray[52] == "Access" and datacenter <> "None"){
							/*	record = bmql("select Discount from GenericDiscount where Site_Size_Discount = $sitesize");
								for result in record{
									discount = util.atof_Custom(get(result,"Discount"));
								}
							*/		
									
								mrcprice = mrcprice - (mrcprice *discount)/100;
						}
						else{
							mrcprice = util.atof_Custom(price[0]);
						}
					}
					
					targetSpendVal=targetSpendVal+(mrcNetPrice+nrcNetPrice);
					/*********Added BY : Sandip Kharinar: Update connection type for Renewal/Amendment Journey***********/
				/*********Added BY : Sandip Kharinar: Update connection type for Renewal/Amendment Journey***********/
				/****Modified By : Ganeshram M Purpose : TO get from Configuration *************/
					/*if(quoteType_quote == "Renewal"){
						if(line.existingProduct_line){
							connectiontypeValue = "Renew";
						}
					}
					if(quoteType_quote == "Acquisition"){
						if(line.existingProduct_line){
							connectiontypeValue = "Existing";
						}
					}*/
						//// //print "428---";
						
						//if(line.isTES_line <> "TES"){
					if(not(isnull(lineCommentArray[55])) AND lineCommentArray[55] <> "" AND findinarray(formedProductIdArray,lineCommentArray[55])<>-1){
						remove(formedProductIdArray,findinarray(formedProductIdArray,lineCommentArray[55]));
						if(quoteType_quote == "Renewal"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Renew";
							//}
						}elif(quoteType_quote == "Acquisition"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Existing";
							//}
						}
						elif(quoteType_quote == "New"){
							//if(line.existingProduct_line){
								connectiontypeValue = "New";
							//}
						}
					}
					//else{
						
						elif((parentChildStatus == "Parent" AND line.isTES_line <> "TES") OR parentChildStatus == "Child"){
						//// //print "449--";
						if((lineCommentArray[52] == "Bespoke") AND (line.booleanES1_line == true)){
							if(quoteType_quote == "Renewal"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Renew";
							//}
							}elif(quoteType_quote == "Acquisition"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Existing";
							//}
							}
							elif(quoteType_quote == "New"){
							//if(line.existingProduct_line){
								connectiontypeValue = "New";
							//}
							}
						}
						else{
							if(lineCommentArray[56]<>"" AND lineCommentArray[56]<>"null" AND NOT(ISNULL((lineCommentArray[56])))){
							connectiontypeValue = lineCommentArray[56];
							}
							else{
							connectiontypeValue = "None";
							}
						}
					}elif(parentChildStatus == "Parent" AND line.isTES_line == "TES"){
						
						
						connectiontypeValue = line.connectionType_line;
					}
					//}
					
					//Check existing quote quantity with new clone quote & Set Modify Flag.
					totprice = 0;
					totprice = mrcNetPrice + nrcNetPrice;
					//// //print "pricing tootal";
					//// //print line.finalPriceFixed_line;
					//// //print totprice;
					if(quoteType_quote == "Renewal" OR quoteType_quote == "Acquisition") {
						if(qty <> line.numberOfQuantityFixed_line OR totprice <> line.finalPriceFixed_line){
							modifyFlag = true;
						}else {
							modifyFlag = false;
						}
					}
					if(line.booleanES1_line){
					lineRes = lineRes + documentNumber + "~modifyFlag_line~" + string(modifyFlag) + "|";
					}
					modelLevelMassiveFlag = false;
					
					totalBMPrice = nrcNetPrice + mrcNetPrice + MinimumConsumptionOffer + annualFeeOffer;
					installFee = nrcListPrice;
					oneTimeCost = installationCostSIP + directCost;
					//previousRevenueL7ProductValue = mrcNetPrice;
					lineRes = lineRes + documentNumber + "~socCode_line~" + CRMCode + "|";
					if((lineCommentArray[52]=="primarioFijo" OR lineCommentArray[52]=="primarioMvil") AND (lineCommentArray[41]=="Primary Access")){
						if(quoteType_quote == "Renewal"){
							if(reconfigFlagforPrimary <> "true"){
								infrastructureCapex =0.0;
								txNetwork = 0.0;
								accessNetwork = 0.0;
								directCost =0.0;
							}	
						}
					}
					//Added by Chandan - BREQ - 022
					if((lineCommentArray[52] == "legacyProductVPNAvalon") OR (lineCommentArray[52] == "primarioMvil")){
						if((lineCommentArray[41] <> "") AND (lineCommentArray[41] <> "0.0")){
							primaryTariffInfo = primaryTariffInfo + lineCommentArray[41] + "!!";
							quantityForPrimaryTariff = quantityForPrimaryTariff + util.atoi_Custom(util.getIndexedValue(lineCommentArray[41], "##", 1));
						}
					}
					if(lineCommentArray[52] == "One Net IP Trunk"){
						if(lineCommentArray[41] == "Price Plan"){
							qty = quantityForPrimaryTariff;
						}
					}
					lineRes = lineRes + documentNumber + "~customizedProductName_line~" + productName + "|"
							+documentNumber + "~cPQProductES_line~" + productName + "|"
							+ documentNumber + "~_price_quantity~" + string(qty) + "|"
							+ documentNumber + "~mRCNetPrice_line~" + string(mrcNetPrice) + "|"
							+ documentNumber + "~nRCNetPrice_line~" + string(nrcNetPrice) + "|"
							+ documentNumber + "~mRCListPriceES_line~" + string(mrcListPrice) + "|"
							+ documentNumber + "~nRCListPriceES_line~" + string(nrcListPrice) + "|"
							+ documentNumber + "~discountMRC_ES_line~" + string(mrcDiscount) + "|"
							+ documentNumber + "~discountNRC_ES_line~" + string(nrcDiscount) + "|"
							//+ documentNumber + "~previousRevenueL7Product_line~" + string(mrcNetPrice) + "|"
							//added by chandan to fix IP trunk defect
							+ documentNumber + "~installationCostES_Line~" + string(installationCostSIP) + "|"
							+ documentNumber + "~directCostOnly_line~" + string(directCost) + "|"
							+ documentNumber + "~monthlyCost_line~" + string(monthyCost) + "|"
							+ documentNumber + "~yearlyCost_line~" + string(yearlyCost) + "|"
							+ documentNumber + "~cAPEX_line~" + string(capex) + "|"
							+ documentNumber + "~interconnectCost_line~" + string(InterconnectCost) + "|"
							+ documentNumber + "~otherIncrementalCosts_line~" + string(OtherIncreamentalCost) + "|"
							+ documentNumber + "~infrastructureCapex_line~" + string(infrastructureCapex) + "|"
							+ documentNumber + "~txNetwork_line~" + string(txNetwork) + "|"
								// added by Chandan
							+ documentNumber + "~category_line~" + category+ "|"
							//for fixed Bespoke
							+ documentNumber + "~systemCapex_line~" + string(systemCapex) + "|"
							+ documentNumber + "~accessNetwork_line~" + string(accessNetwork) + "|"
							+ documentNumber + "~fixedProductid_line~" + productid[count] + "|"
							//+ documentNumber + "~modifyFlag_line~" + string(modifyFlag) + "|"
							+ documentNumber + "~productTerm_line~" + string(contractterm) + "|"
							+ documentNumber + "~revisedMRCprice_line~" + string(mrcprice) + "|"
							+ documentNumber + "~revisedNRCprice_line~" + string(nrcprice) + "|"
							+ documentNumber + "~descriptionOneSF_line~" + productDesc + "|"
							+ documentNumber + "~connectionType_line~" + connectiontypeValue + "|"
							+ documentNumber + "~date1ES_line~" + startDateValue + "|"
							+ documentNumber + "~productTerm_line~" + string(productTerm) + "|"
							+ documentNumber + "~date2ES_line~" + endDateValue + "|"
							+ documentNumber + "~annualFeeES_line~" + string(annualFee) + "|"
							+ documentNumber + "~annualFeeDiscES_line~" + string(annualFeeDiscount) + "|"
							+ documentNumber + "~annualFeeOfferES_line~" + string(annualFeeOffer) + "|"
							+ documentNumber + "~recurringRevenue_line~" + string(recurrencerevenue) + "|"
							+ documentNumber + "~oneOffCosts_line~" + string(directCost) + "|"
							+ documentNumber + "~overrideFlagsetFixed_ES_line~" + string(overrideFlag) + "|"
							+ documentNumber + "~minimumConsumptionES_line~" + string(MinimumConsumption) + "|"
							+ documentNumber + "~minConsumptionDiscES_line~" + string(MinimumConsumptionDiscount) + "|"
							+ documentNumber + "~minConsumptionES_line~" + string(MinimumConsumptionOffer) + "|"
							+ documentNumber + "~modifyCostFlag_line_ES~" + modifiedCostFlag + "|"
							//Addedd By Chandan for Defect 1552
							+ documentNumber + "~netPriceEach_line~" + string(totalBMPrice)+ "|"
							+ documentNumber + "~installCharge_line~" + string(installFee)+ "|"
							+ documentNumber + "~oneOffCosts_line~" + string(oneTimeCost)+ "|"
							+ documentNumber + "~nRCThresholdFlag_line~" + nrcThresholdflag+ "|"
							+ documentNumber + "~mRCThresholdFlag_line~" + mrcThresholdflag+ "|"
							+ documentNumber + "~bulkDiscountFlag_line~" + blukDiscountflag+ "|"
							+ documentNumber + "~modeLevelMassiveFlag_line~" + string(modelLevelMassiveFlag)+ "|"
							+ documentNumber + "~mRCTHresholdEqualFlag_line~" + disflagMRCEqual+ "|"
							+ documentNumber + "~nRCTHresholdEqualFlag_line~" + disflagNRCEqual+ "|"
							+ documentNumber + "~bulkDiscountApplied_line~" + string(bulkDisountApplyflag)+ "|"
							+ documentNumber + "~overrideflag_line~" + overrideuserflagNRC+ "|"
							+ documentNumber + "~mRCOverrideFlag_line~" + overrideuserflagMRC+ "|"
							+ documentNumber + "~overridenrcflag_line~" + string(nrcoverrideflag)+ "|"
							+ documentNumber + "~overridemrcflag_line~" + string(mrcoverrideflag)+ "|"
							+ documentNumber + "~migrationDate_ES_line~" + migrationDateForCPE+ "|";
							if(actionName == "revert"){
								lineRes= lineRes + documentNumber + "~overrideMRCDiscountFixedtext_line~" + ""+ "|"
								+ documentNumber + "~overrideNRCDiscountFixedtext_line~" + ""+ "|";
							}
							if(actionName == "apply"){
								lineRes= lineRes + documentNumber + "~overrideMRCDiscountFixedtext_line~" + ""+ "|"
								+ documentNumber + "~overrideNRCDiscountFixedtext_line~" + ""+ "|";
							}
								if((comparedates(strtojavadate(startDateValue,"MM/dd/yyyy"),strtojavadate(startDateEarliest,"MM/dd/yyyy")) == -1) AND lineCommentArray[52] <> "DEVICES"){
									startDateEarliest = startDateValue;
									documentNumber = line._document_number;
								} 					
							if(endDateValue<>""){
								if((comparedates(strtojavadate(endDateValue,"MM/dd/yyyy"),strtojavadate(endDateLatest,"MM/dd/yyyy")) == 1) AND lineCommentArray[52] <> "DEVICES"){
									endDateLatest = endDateValue;
									documentNumber = line._document_number;
								}
							}
			}
			else{
				//// //print "enter Mobile ";
					overrideFlag = true;
					overrideuserflagNRC = "false";
					overrideuserflagMRC = "false";
					negativediscountflag = false;
					nrcoverrideflag = false;
					mrcoverrideflag = false;
					
					//print "overrideFlag4";
					//print overrideFlag;
					modelLevelMassiveFlag = false;
					bulkDisountApplyflag = false;
					MobileFlag=true;
					planStringflag=true;
					if(not(isnull(selectedPlanFromCommerce)) AND selectedPlanFromCommerce <>""){
							selectedPlanstring=selectedPlanstring + "**" +selectedPlanFromCommerce;
					}
					//Mobile**Red empresas opcion empresa 1+1**0.0**YES**000**0.0**0.0**0.0**0.0**120.0**300.0**110.0**100.0**50.0**120.0**300.0**110.0**100.0**50.0************0.0****0.0****0.0**0.0**0.0**0.0**0.0**0.0**0.0**0.0**0.0**0.0**0.0****YES**0.0**0.0**0.0**0.0
					
					qty=line._price_quantity;
					tariffPlan=lineCommentArray[1];
					directCost=util.atof_Custom(lineCommentArray[26]);
					InterconnectCost=util.atof_Custom(lineCommentArray[31]);
					OtherIncreamentalCost=util.atof_Custom(lineCommentArray[23]);
					yearlyCost=util.atof_Custom(lineCommentArray[8]);
					monthlyCost=util.atof_Custom(lineCommentArray[7]);
					oneOffCost = util.atof_Custom(lineCommentArray[6]);
					installationCost = util.atof_Custom(lineCommentArray[5]);
					
					onOffFeeES=util.atof_Custom(lineCommentArray[9]);
					InstallationFee=util.atof_Custom(lineCommentArray[10]);
					MonthlyFee=util.atof_Custom(lineCommentArray[11]);
					MinimumConsumption=util.atof_Custom(lineCommentArray[13]);
					annualFee=util.atof_Custom(lineCommentArray[12]);
					
					onOffFeeESDiscount=util.atof_Custom(lineCommentArray[19]);
					InstallationFeeDiscount=util.atof_Custom(lineCommentArray[20]);
					MonthlyFeeDiscount=util.atof_Custom(lineCommentArray[21]);
					MinimumConsumptionDiscount=util.atof_Custom(lineCommentArray[23]);
					annualFeeDiscount=util.atof_Custom(lineCommentArray[22]);
					
					onOffFeeOffer=util.atof_Custom(lineCommentArray[14]);
					InstallationFeeOffer=util.atof_Custom(lineCommentArray[15]);
					MonthlyFeeOffer=util.atof_Custom(lineCommentArray[16]);
					MinimumConsumptionOffer=util.atof_Custom(lineCommentArray[18]);
					annualFeeOffer=util.atof_Custom(lineCommentArray[17]);
					//Chandan to map for CAPEX in Primary Movil
					//capex = util.atof_Custom(lineCommentArray[36]);
					accessNetwork = util.atof_Custom(lineCommentArray[36]);
					if((VGERedFlag == "VGERed" or VGERedFlag == "OPA") AND (lineCommentArray[56] <> "Addon")){
							recurrencerevenue =	round((util.atof_Custom(ARPUValue)+MonthlyFeeOffer),2);
					}
					else{
					recurrencerevenue = MonthlyFeeOffer + MinimumConsumptionOffer + annualFeeOffer/12;
					}
					
					for each in priceResult{
					if(get(each,"ProductID") == lineCommentArray[55] and comparedates(strtojavadate(get(each,"ExpiryDate"),"dd/MM/yyyy","London"),todayDate) <> -1){
					reviseMonthly = util.atof_Custom(get(each,"MonthlyRC")); 
					reviseOneOff = util.atof_Custom(get(each,"OneOffCharge")); 
					reviseInstall = util.atof_Custom(get(each,"NRCInstallation")); 
					reviseYearly = util.atof_Custom(get(each,"YearlyRC")); 
					reviseMinCons = util.atof_Custom(get(each,"MinConsumptionCharge")); 
					break;
					//ProductID,NRCInstallation,OneOffCharge,MonthlyRC,YearlyRC,MinConsumptionCharge,ActiveDate,ExpiryDate
					}
					}
					if(lineCommentArray[68]<>"VGERed" AND lineCommentArray[68]<>"OPA"){
					if(lineCommentArray[27] =="Bespoke" OR lineCommentArray[27] =="Bespoke-Capex"){
					productDesc=lineCommentArray[2];
					startMonthVal=1;
					/*if(isnumber(lineCommentArray[56])){
						startMonthVal=atoi(lineCommentArray[56]);
					}*/	//commented by : aditi (currently no index in RI for start month)
					prodDescription=lineCommentArray[55];
					}
					else{
					startMonthVal=1; // FOR spain start month is alway 1, confirmed by breq team.... 
					  productDesc=line._part_desc;
					}
					}
					else{
						startMonthVal = atoi(lineCommentArray[59]);	
					}
					
					if(lineCommentArray[27] =="Bespoke-Capex" OR lineCommentArray[27] =="Repeaters"){//Modified by Mahesh for PROJ-1518023_BREQ-020
					infrastructureCapex=util.atof_Custom(lineCommentArray[33]);
					}
					planInfo = planInfo + lineCommentArray[52]+"@"+string(qty)+"**"+PPMRoamingPlanString;//Modified by Mahesh for PPM Roaming CR :Added PPMRoamingPlanString
					if(find(lineCommentArray[52],"Red Empresa") <> -1) {
						maxSubsidyRedEmpressa = maxSubsidyRedEmpressa + (MonthlyFee*qty);
					}
					prodId[count]  = lineCommentArray[55];  
					priceDict = util.pricePlanRepository_ES(prodId[count]);             			
					revisedPrice = "";
					if(containsKey(priceDict, "1")) {
						price = split(get(priceDict, "1"), "**");
						revisedPrice = price[11]+"**"+price[12]+"**"+price[13]+"**"+price[14]+"**"+price[4];
					}
					
					//targetSpendVal = onOffFeeOffer + InstallationFeeOffer + MonthlyFeeOffer + MinimumConsumptionOffer + annualFeeOffer;
			/*********Added BY : Sandip Kharinar: Update connection type for Renewal/Amendment Journey***********/
				/****Modified By : Ganeshram M Purpose : TO get from Configuration *************/
					/*if(quoteType_quote == "Renewal"){
						if(line.existingProduct_line){
							connectiontypeValue = "Renew";
						}
					}
					if(quoteType_quote == "Acquisition"){
						if(line.existingProduct_line){
							connectiontypeValue = "Existing";
						}
					}*/
					//// //print "lineCommentArray[55]";
					//// //print lineCommentArray[55];
					//// //print "formedProductIdArray";
					//// //print formedProductIdArray;
					// //print "Chan";
					if(not(isnull(lineCommentArray[55])) AND lineCommentArray[55] <> "" AND findinarray(formedProductIdArray,lineCommentArray[55])<>-1){
					// //print "1396";
					//// //print lineCommentArray[56];
					// //print formedProductIdArray;
					
					//if(lineCommentArray[56] <> ""){
					remove(formedProductIdArray,findinarray(formedProductIdArray,lineCommentArray[55]));
						if(quoteType_quote == "Renewal"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Renew";
							//}
						}elif(quoteType_quote == "Acquisition"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Existing";
							//}
						}
						elif(quoteType_quote == "New"){
							//if(line.existingProduct_line){
								connectiontypeValue = "New";
							//}
						}
					}
					//}
					//else{
					//	connectiontypeValue = "None";
					//}
					
					elif((parentChildStatus == "Parent" AND line.isTES_line <> "TES") OR parentChildStatus == "Child"){
						
						if((lineCommentArray[52] == "Bespoke") AND (line.booleanES1_line == true)){
							if(quoteType_quote == "Renewal"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Renew";
							//}
							}elif(quoteType_quote == "Acquisition"){
							//if(line.existingProduct_line){
								connectiontypeValue = "Existing";
							//}
							}
							elif(quoteType_quote == "New"){
							//if(line.existingProduct_line){
								connectiontypeValue = "New";
							//}
							}
						}
						else{
							if(lineCommentArray[56]<>"" AND lineCommentArray[56]<>"null" AND NOT(ISNULL((lineCommentArray[56])))){
							connectiontypeValue = lineCommentArray[56];
							}
							else{
							connectiontypeValue = "None";
							}
						}
					}elif(parentChildStatus == "Parent" AND line.isTES_line == "TES"){
						connectiontypeValue = line.connectionType_line;
					}
					/* Start for Discount Code in Mobile Products*/
					if(lineCommentArray[61]<>"" AND lineCommentArray[61]<>"null" AND NOT(ISNULL((lineCommentArray[61])))){
							discountcodeValue = lineCommentArray[61];
						}
						else{
							discountcodeValue = "";
						}
						
					if(lineCommentArray[64]<>"" AND lineCommentArray[64]<>"null" AND NOT(ISNULL((lineCommentArray[64])))){
							discountcodeOneTimeValue = lineCommentArray[64];
						}
						else{
							discountcodeOneTimeValue = "";
						}
						
					if(lineCommentArray[65]<>"" AND lineCommentArray[65]<>"null" AND NOT(ISNULL((lineCommentArray[65])))){
							discountcodeInstallValue = lineCommentArray[65];
						}
						else{
							discountcodeInstallValue = "";
						}
						
					if(lineCommentArray[66]<>"" AND lineCommentArray[66]<>"null" AND NOT(ISNULL((lineCommentArray[66])))){
							discountcodeMonthlyValue = lineCommentArray[66];
						}
						else{
							discountcodeMonthlyValue = "";
						}
						
					if(lineCommentArray[67]<>"" AND lineCommentArray[67]<>"null" AND NOT(ISNULL((lineCommentArray[67])))){
							discountcodeYearlyValue = lineCommentArray[67];
						}
						else{
							discountcodeYearlyValue = "";
						}
					if(lineCommentArray[68]<>"" AND lineCommentArray[68]<>"null" AND NOT(ISNULL((lineCommentArray[68])))){
							VGERedFlag = lineCommentArray[68];
					}
					if(lineCommentArray[69]<>"" AND lineCommentArray[69]<>"null" AND NOT(ISNULL((lineCommentArray[69])))){
							techFund = atof(lineCommentArray[69]);
					}
					if(lineCommentArray[70]<>"" AND lineCommentArray[70]<>"null" AND NOT(ISNULL((lineCommentArray[70])))){
							cashbonus = atof(lineCommentArray[70]);
					}
					if(lineCommentArray[71]<>"" AND lineCommentArray[71]<>"null" AND NOT(ISNULL((lineCommentArray[71])))){
							invoiceCredit = atof(lineCommentArray[71]);
					}
					if(lineCommentArray[72]<>"" AND lineCommentArray[72]<>"null" AND NOT(ISNULL((lineCommentArray[72])))){
							hardwareSubsidies = atof(lineCommentArray[72]);
							//// //print "VGE Red";
							//// //print hardwareSubsidies;
					}
					if(lineCommentArray[73]<>"" AND lineCommentArray[73]<>"null" AND NOT(ISNULL((lineCommentArray[73])))){
							devicePriceDiscount = atof(lineCommentArray[73]);
					}
					if(lineCommentArray[74]<>"" AND lineCommentArray[74]<>"null" AND NOT(ISNULL((lineCommentArray[74])))){
							migrationCredit = atof(lineCommentArray[74]);
					}
					if(lineCommentArray[75]<>"" AND lineCommentArray[75]<>"null" AND NOT(ISNULL((lineCommentArray[75])))){
							ragStatus = lineCommentArray[75];
					}
					if(lineCommentArray[27]<>"" AND lineCommentArray[27]<>"null" AND NOT(ISNULL((lineCommentArray[27])))){
							category = lineCommentArray[27];
					}
						
					/* End for Discount Code in Mobile Products*/
					
					//For requirement 011
					fixedMobile = 0;
					//Total to all Mobile Fees
					fixedMobile = MonthlyFee + InstallationFee + onOffFeeES + annualFee + MinimumConsumption;
					//// //print "total";
					//// //print fixedMobile;
					//// //print line.finalPriceMobile_line;
					//Check existing quote quantity with new clone quote & Set Modify Flag.
					if(quoteType_quote == "Renewal" OR quoteType_quote == "Acquisition") {
					 // if(line.booleanES1_line){
						if(qty <> line.numberOfQuantityMobile_line OR fixedMobile <> line.finalPriceMobile_line){
							modifyFlag = true;
						}else {
							modifyFlag = false;
						}
					  }
					//}
					if(line.booleanES1_line){
					lineRes = lineRes + documentNumber + "~modifyFlag_line~" + string(modifyFlag) + "|";
					}
					
					/* 
					
		Put Opp CLose date as Service Start Date and Full Revenue Date in Case Of These Dates are Less Then Opp CLose Date.
		This issue occures when Quote is cloned and Opprtunity Close date is of current opprtunity is greater then the cloned product service start date and end date.
		
		*/
			serviceStartDate="";
			fullRevenueDate="";
		
			lineServiceStartDate = strtojavadate(line.serviceStartDate_line,"yyyy-MM-dd");
			oppCloseDate= strtojavadate(opportunityCloseDate_quote,"yyyy-MM-dd");
			lineFullRevenuDate = strtojavadate(line.fullRevenueDate_line,"yyyy-MM-dd"); 
			
			if (comparedates(lineServiceStartDate,oppCloseDate) == -1) {
					serviceStartDate =opportunityCloseDate_quote ; 
			}
			else{	
					serviceStartDate = line.serviceStartDate_line;
			}
			
			if (comparedates(lineFullRevenuDate,oppCloseDate ) == -1) {
					fullRevenueDate =opportunityCloseDate_quote ; 
			}
			else{
				fullRevenueDate	= line.fullRevenueDate_line ;
			}
					/*Start: For Defect 1423*/
					//To get CPQ Product name and quantity in a string
						mobileCPQproductinfo = mobileCPQproductinfo + lineCommentArray[1] + "@" + string(qty)+"**";
					/*Start: For Defect 1423*/
					//Addedd by Chandan for Defect 1552
					totalBMPrice = onOffFeeES + MonthlyFee + InstallationFee + MinimumConsumption + annualFee;
					installFee = onOffFeeES + InstallationFee;
					oneTimeCost = directCost;
					
						

			
					//previousRevenueL7ProductValue = MonthlyFeeOffer;
					//print "----------colour flag";
					print "CAPEX in mobile";
					print capex;
					lineRes = lineRes + documentNumber + "~customizedProductName_line~" +tariffPlan + "|"
					+documentNumber + "~cPQProductES_line~" + tariffPlan + "|"
							+ documentNumber + "~_price_quantity~" + string(qty) + "|"
							// + documentNumber + "~mRCNetPrice_line~" + string(mrcNetPrice) + "|"
							// + documentNumber + "~nRCNetPrice_line~" + string(nrcNetPrice) + "|"
							// + documentNumber + "~mRCDiscount_line~" + string(mrcDiscount) + "|"
							// + documentNumber + "~nRCDiscount_line~" + string(nrcDiscount) + "|"
							+ documentNumber + "~directCostOnly_line~" + string(directCost) + "|"
							+ documentNumber + "~monthlyCost_line~" + string(monthlyCost) + "|"
							+ documentNumber + "~yearlyCost_line~" + string(yearlyCost) + "|"
							+ documentNumber + "~cAPEX_line~" + string(capex) + "|"
							+ documentNumber + "~interconnectCost_line~" + string(InterconnectCost) + "|"
							+ documentNumber + "~otherIncrementalCosts_line~" + string(OtherIncreamentalCost) + "|"
							
							+ documentNumber + "~oneOffFeeES_line~" + string(onOffFeeES) + "|"
							+ documentNumber + "~installationFeeES_line~" + string(InstallationFee) + "|"
							+ documentNumber + "~monthlyFeeES_line~" + string(MonthlyFee) + "|"
							+ documentNumber + "~minimumConsumptionES_line~" + string(MinimumConsumption) + "|"
							+ documentNumber + "~annualFeeES_line~" + string(annualFee) + "|"
							
							+ documentNumber + "~annualFeeDiscES_line~" + string(annualFeeDiscount) + "|"
							+ documentNumber + "~insatallionFeeDiscES_line~" + string(InstallationFeeDiscount) + "|"
							+ documentNumber + "~oneOffFeeDiscES_line~" + string(onOffFeeESDiscount) + "|"
							+ documentNumber + "~monthlyFeeDiscES_line~" + string(MonthlyFeeDiscount) + "|"
							+ documentNumber + "~minConsumptionDiscES_line~" + string(MinimumConsumptionDiscount) + "|"
							
							+ documentNumber + "~oneOFfFeeOfferES_line~" + string(onOffFeeOffer) + "|"
							+ documentNumber + "~installationFeeOfferES_line~" + string(InstallationFeeOffer) + "|"
							//+documentNumber + "~previousRevenueL7Product_line~" + string(MonthlyFeeOffer) + "|"
							+ documentNumber + "~monthlyFeeOfferES_line~" + string(MonthlyFeeOffer) + "|"
							+ documentNumber + "~annualFeeOfferES_line~" + string(annualFeeOffer) + "|"
							+ documentNumber + "~minConsumptionES_line~" + string(MinimumConsumptionOffer) + "|"
							+"1~configuredPlanES_quote~"+selectedPlanstring+ "|"//Getting ConfiguredplansES 
							+ documentNumber + "~oneOffCostES_Line~" + string(oneOffCost) + "|"
							+ documentNumber + "~installationCostES_Line~" + string(installationCost)+"|"
							+ documentNumber + "~startMonth_line~" + string(startMonthVal) + "|"
							+ documentNumber + "~category_line~" + category+ "|"
							+ documentNumber + "~productDescription_line~" + prodDescription + "|"
							//+ documentNumber + "~modifyFlag_line~" + string(modifyFlag) + "|"
							+ documentNumber + "~currentPriceES_line~" + revisedPrice + "|"
							 + documentNumber + "~fixedProductid_line~" + prodId[count] + "|"
							+ documentNumber + "~productTerm_line~" + string(contractterm) + "|"
							+ documentNumber + "~infrastructureCapex_line~" + string(infrastructureCapex) + "|"
							+ documentNumber + "~recurringRevenue_line~" + string(recurrencerevenue) + "|"
							+ documentNumber + "~oneOffCosts_line~" + string(oneOffCost) + "|"
							+documentNumber + "~descriptionOneSF_line~" + productDesc + "|"
							+ documentNumber + "~connectionType_line~" + connectiontypeValue + "|"
							+ documentNumber + "~date1ES_line~" + startDateValue + "|"
							+ documentNumber + "~date2ES_line~" + endDateValue + "|"
							+ documentNumber + "~productTerm_line~" + string(productTerm) + "|"
							+ documentNumber + "~textES3_line~" + discountcodeValue + "|"//Discount Code for Mobile Products
							+ documentNumber + "~textES4_line~" + discountcodeOneTimeValue + "|"//One Time Discount Code for Mobile Products
							+ documentNumber + "~textES5_line~" + discountcodeInstallValue + "|"//Installation Discount Code for Mobile Products
							+ documentNumber + "~textES6_line~" + discountcodeMonthlyValue + "|"//Monthly Discount Code for Mobile Products
							+ documentNumber + "~textES7_line~" + discountcodeYearlyValue + "|"//Yearly Discount Code for Mobile Products
							+ documentNumber + "~revisemonthlyFee_line~" + string(reviseMonthly) + "|"
							+ documentNumber + "~reviseOneOffFee_line~" + string(reviseOneOff) + "|"
							//+ documentNumber + "~reviseInstallationFee_line~" + string(reviseInstall) + "|"
							//+ documentNumber + "~reviseAnnualFee_line~" + string(reviseYearly) + "|"
							//+ documentNumber + "~reviseMinConsumptionFee_line~" + string(reviseMinCons) + "|"
							//reviseInstall = util.atof_Custom(get(each,"NRCInstallation")); 
					//reviseYearly = util.atof_Custom(get(each,"YearlyRC")); 
					//reviseMinCons 
							+ documentNumber + "~monthlyFeeVGE_line~" + string(MonthlyFee) + "|"//Monthly Discount Code for Mobile Products
							+ documentNumber + "~offerPriceVGE_line~" +string(MonthlyFeeOffer) + "|"//Yearly Discount Code for Mobile Products
							+ documentNumber + "~discountVGE_line~" + string(MonthlyFeeDiscount) + "|"
							+ documentNumber + "~ragStatus_line~" + ragStatus + "|"//VGERed
							 + documentNumber + "~productTCVVGE_line~" +string(productTerm*MonthlyFeeOffer*line._price_quantity) + "|"//VGERed
							+ documentNumber + "~techFundPerCTN_line~" + string(techFund) + "|"
							+ documentNumber + "~cashBonusPerCTN_line~" + string(cashBonus) + "|"//Mapping cash bonus to line item attribute
							+ documentNumber + "~hardwareSubsidiesperCTN_line~" + string(hardwareSubsidies) + "|"+documentNumber + "~devicePriceDiscountperCTN_line~" +string(devicePriceDiscount)+ "|"+documentNumber + "~migrationCreditPerCTN_line~" +string(migrationCredit)+ "|"+documentNumber + "~invoiceCreditPerCTN_line~" +string(invoiceCredit)+ "|"
							+ documentNumber + "~overrideFlagsetFixed_ES_line~" + string(overrideFlag) + "|"
							+ documentNumber + "~serviceStartDate_line~" + serviceStartDate+ "|"
							+ documentNumber + "~fullRevenueDate_line~" + fullRevenueDate+ "|"
							//Addedd By Chandan for Defect 1552
							+ documentNumber + "~netPriceEach_line~" + string(totalBMPrice)+ "|"
							+ documentNumber + "~installCharge_line~" + string(installFee)+ "|"
							+ documentNumber + "~oneOffCosts_line~" + string(oneTimeCost)+ "|"
							+ documentNumber + "~nRCThresholdFlag_line~" + nrcThresholdflag+ "|"
							+ documentNumber + "~mRCThresholdFlag_line~" + mrcThresholdflag+ "|"
							+ documentNumber + "~bulkDiscountFlag_line~" + blukDiscountflag+ "|"
							+ documentNumber + "~modeLevelMassiveFlag_line~" + string(modelLevelMassiveFlag)+ "|"
							+ documentNumber + "~mRCTHresholdEqualFlag_line~" + disflagMRCEqual+ "|"
							+ documentNumber + "~nRCTHresholdEqualFlag_line~" + disflagNRCEqual+ "|"
							+ documentNumber + "~bulkDiscountApplied_line~" + string(bulkDisountApplyflag)+ "|"
							+ documentNumber + "~overrideflag_line~" + overrideuserflagNRC+ "|"
							+ documentNumber + "~mRCOverrideFlag_line~" + overrideuserflagMRC+ "|"
							+ documentNumber + "~accessNetwork_line~" + string(accessNetwork) + "|"
							+ documentNumber + "~overridenrcflag_line~" + string(nrcoverrideflag)+ "|"
							+ documentNumber + "~overridemrcflag_line~" + string(mrcoverrideflag)+ "|"
							+ documentNumber + "~migrationDate_ES_line~" + migrationDateForCPE+ "|";
							/*+ documentNumber + "~infrastructureCapex_line~" + string(infrastructureCapex) + "|"
							+ documentNumber + "~txNetwork_line~" + string(txNetwork) + "|"
							+ documentNumber + "~systemCapex_line~" + string(systemCapex) + "|"
							*/
							//Added By : Chandan A J 
							//Purpose : To get the smallest Start Date and Largest End Date for Mobile Products
							//From Line 746 to 751
							// // //print "contract TErms 1409---";
							// // //print tariffPlan;
							// // //print startDateValue;
							// // //print startDateEarliest;
							// // //print "-------------1409---------";
							
								if(comparedates(strtojavadate(startDateValue,"MM/dd/yyyy"),strtojavadate(startDateEarliest,"MM/dd/yyyy")) == -1 AND lineCommentArray[52] <> "DEVICES"){
									startDateEarliest = startDateValue;
									documentNumber1 = line._document_number;
									
								
								} 
														
							/*if(strtojavadate(startDateValue,"MM/dd/yyyy") <> strtojavadate(startDateEarliest,"MM/dd/yyyy") AND documentNumber1 == line._document_number AND lineCommentArray[52] <> "DEVICES"){
								 startDateEarliest = lineCommentArray[59]+"/01"+"/"+lineCommentArray[60];
								 //documentNumber = line._document_number;
								
							}*/
							
								if(comparedates(strtojavadate(endDateValue,"MM/dd/yyyy"),strtojavadate(endDateLatest,"MM/dd/yyyy")) == 1 AND lineCommentArray[52] <> "DEVICES"){
									
									endDateLatest = endDateValue;
									documentNumberLatest = line._document_number;
								}
						
							//// //print lineCommentArray[63];
							/*if(strtojavadate(endDateValue,"MM/dd/yyyy") <> strtojavadate(endDateLatest,"MM/dd/yyyy") AND documentNumberLatest == line._document_number AND lineCommentArray[52] <> "DEVICES"){
							
								 endDateLatest = lineCommentArray[62]+"/30"+"/"+lineCommentArray[63];
								 // documentNumber = line._document_number;
							}*/
						
							
							
					}

	//lineRes = lineRes + line._document_number + "~netPriceEach_line~" + string(tcvValueES) + "|";				
					lineRes = lineRes + documentNumber + "~socCode_line~" + CRMCode + "|";		//Since it is common for Fixed and mobile
					if(VGERedFlag <> "VGERed" AND VGERedFlag <> "OPA"){
						if(connectiontypeValue == "New" OR connectiontypeValue == "Nueva" OR connectiontypeValue == "None" OR connectiontypeValue == ""){
							lineRes = lineRes + documentNumber + "~type_line~" + "New" + "|";				// This is hard coded for R2 since now Renewel in scope , changes required in r3
						}
						else{
						lineRes = lineRes + documentNumber + "~type_line~" + "Renewal" + "|"
							+ documentNumber +"~previousMonthlyRevenue_line~"+"0.1" + "|";
						}
					}
					if(VGERedFlag == "VGERed" OR VGERedFlag == "OPA"){// @Abhishek Since VGE has connection type other than 'new'
					if(connectiontypeValue == "New" OR connectiontypeValue == "None" OR connectiontypeValue == ""){
						lineRes = lineRes + documentNumber + "~type_line~" + "New" + "|";
					}
					elif(connectiontypeValue=="Addon" AND startMonthVal == 2){
						lineRes = lineRes + documentNumber + "~type_line~" + "New" + "|";
					}
					else{
						lineRes = lineRes + documentNumber + "~type_line~" + "Renewal" + "|";
					}
						lineRes = lineRes + documentNumber + "~endMonth_line~" +string(testIntegerES1_quote)+ "|";
					}	
				}
				targetSpent =targetSpent + recurrencerevenue *productTerm * line._price_quantity;
			
		//lineRes = lineRes + documentNumber + "~productContractEndDate_line~" + datetostr(productContractEndDAte,"yyyy-MM-dd HH:mm:ss")+ "|";
			}
			nrcoverrideflag = false;
			mrcoverrideflag = false;
		
		//***start Massive discount functionality -- ***20012017*** - ***santhosh***
		print mrcnetpriceDic;
		nrcdisNetPricedoc = 0.0;
		mrcdisNetPricedoc = 0.0;
		//***Dont use below line_process only used for Massive discount Model level summation after Bulk Discount apply*** 
		for line in line_process{
		documentNumber=line._document_number;
			if(line._parent_doc_number == "" AND modelLevelMassiveFlag == false){
				if(containskey(mrcnetpriceDic,line._document_number+"MRCNetprice")){
					mrcdisNetPricedoc = util.atof_Custom(get(mrcnetpriceDic,line._document_number+"MRCNetprice"));
					
				}else{
					mrcdisNetPricedoc = 0.0;
				}
			
				if(containskey(nrcnetpriceDic,line._document_number+"NRCNetprice")){
					nrcdisNetPricedoc = util.atof_Custom(get(nrcnetpriceDic,line._document_number+"NRCNetprice"));
					
				}else{
					nrcdisNetPricedoc = 0.0;
				}
				
				lineRes = lineRes + documentNumber + "~mRCNetPrice_line~" + String(mrcdisNetPricedoc) + "|"
								  + documentNumber + "~nRCNetPrice_line~" + String(nrcdisNetPricedoc) + "|";
				
			}
			
		}
		//***END Massive discount functionality -- ***20012017*** - santhosh ***
		
			maxVal = 0.0;   
	records = bmql("select Value from MobileConstants where Name='Max  Subsidy Empressa'");
	for record1 in records {
		maxVal = util.atof_Custom(get(record1, "Value"));
	}
	 
	maxSubsidyRedEmpressa = maxSubsidyRedEmpressa*contractterm*maxVal;  
	// Code by Ganeshram to calculate the Contract Term

	/*startDateEarliest = "12/31/9999";
	endDateLatest = "01/01/0001";
	/*for line in line_process{
		if(line._parent_doc_number <> "" AND startDateValue<>"" AND startDateValue<>"null" AND NOT(ISNULL(startDateValue))){
			if(comparedates(strtojavadate(startDateValue,"MM/dd/yyyy"),strtojavadate(startDateEarliest,"MM/dd/yyyy")) == -1){
				startDateEarliest = startDateValue;
			}
			if(comparedates(strtojavadate(endDateValue,"MM/dd/yyyy"),strtojavadate(endDateLatest,"MM/dd/yyyy")) == 1){
				endDateLatest = endDateValue;
			}
		}	
	}
	*/

	startYearMonth = split(startDateEarliest,"/");
	startYearMonth1 = split(startYearMonth[2]," ");
	startYearContractTerm = atoi(startYearMonth1[0]);
	startMonthContractTerm = atoi(startYearMonth[0]);
	endYearMonth = split(endDateLatest,"/");
	endYearMonth1 = split(endYearMonth[2]," ");
	endYearContractTerm = atoi(endYearMonth1[0]);
	endMonthContractTerm = atoi(endYearMonth[0]);

	contractTermFromConfig = (((endYearContractTerm - startYearContractTerm)*12) + (endMonthContractTerm - startMonthContractTerm) + 1);

	if(contractTermFromConfig < 1 OR contractTermFromConfig > 84){
		contractTermFromConfig = 1;
	}
	// end of code to calculate the Contract Term

			
			/*Changes start for Getting ConfiguredplansES in a string - Sarita*/
				if(planStringflag == false){
						selectedPlanstring="";
						lineRes = lineRes + "1~configuredPlanES_quote~"+selectedPlanstring+ "|";//Getting ConfiguredplansES
				}
							
				
			/*Changes End for Getting ConfiguredplansES in a string*/
				
			// Added By Preeti
			////// //print productid;
		/*
			cap=float[];
			revisedprice =util.priceVersioningforFixed_ES(currentdate,productid,responseprodidval,accessreccuringval,inputstr,contractterm,accessinitialval,cap);
			////// //print revisedprice;
			mrcprice = 0.0;
			nrcprice =0.0;
			//count4 = 0;
			count5 = 0;
			for each in productid{
					
				//// //print "---------Product Detail---";
					for line in line_process{
						//lineCommentArray[24];- product id
						lineComment=line._line_item_comment;
					lineCommentArray=split(lineComment,"**");
				documentNumber=line._document_number;	
				if(line._parent_doc_number <> "" and lineCommentArray[0] == "Fixed"){
					
					if(containskey(revisedprice,lineCommentArray[24])){							 
						 price = split(get(revisedprice,lineCommentArray[24]),"###");
						 mrcprice = util.atof_Custom(price[0]);
						 nrcprice = util.atof_Custom(price[1]);
						if(lineCommentArray[4] == "Access" and datacenter <> "None"){
								record = bmql("select Discount from GenericDiscount where Site_Size_Discount = $sitesize");
								for result in record{
									discount = util.atof_Custom(get(result,"Discount"));
								} 
								mrcprice = mrcprice - (mrcprice *discount)/100;
						}
						else{
							mrcprice = util.atof_Custom(price[0]);
						}
						
						//count4 = count4+1;
					}
					
					
					lineRes = lineRes + documentNumber + "~revisedMRCprice_line~" + string(mrcprice) + "|"
							+documentNumber + "~revisedNRCprice_line~" + string(nrcprice) + "|";
					
				}
				// else{
					// lineRes = lineRes + documentNumber + "~revisedMRCprice_line~" + "0.0" + "|"
							 // +documentNumber + "~revisedNRCprice_line~" + "0.0" + "|";
				// }
				count5 =count5 +1;
			}
		}	
	}		 
	*/		
	//Added by : Aditi : To set P&L Attributes Value : 7/9/2015

	// PnLValues=commerce.pLAttributes(); //commented by:aditi
	// calString=split(PnLValues,"!!!");
	PnLValuesVGE = dict("string");
	if(customerSegment_quote  == "VGE"){
		PnLValuesVGE=commerce.pLValues_VGE("");
	}
	// if(customerSegment_quote <> "VGE"){
		// tcvValue = calString[1];
	// }
	// else{
	if(customerSegment_quote == "VGE" AND VGERedFlag <>"VGERed"){	//@Aditi:added condition on VGE.
		tcvValueVGE = get(PnLValuesVGE,"Mobile TCV##mobileTCV");
		if(find(tcvValueVGE,"##")<>-1){
			tcvValueVGEArray = split(tcvValueVGE,"$,$");
			for eachTCV in tcvValueVGEArray{
				tcvValues = split(eachTCV,"##");
				tcvValue = string(util.atof_Custom(tcvValue) + util.atof_Custom(tcvValues[1]));
			}
		}
		lineRes=lineRes+"1~targetSpend_quote~"+string(totalRevenue_quote)+ "|";
	}
	//else{
		//lineRes=lineRes+"1~targetSpend_quote~"+string(compromiseBilling_quote)+ "|";
		//lineRes=lineRes+"1~targetSpend_quote~"+string(totalRevenue_quote)+ "|";
	//}	
		if(VGERedFlag == "VGERed" OR VGERedFlag == "OPA"){
			AOVValue=targetSpent;
		}
		if(contractterm <> 0 AND VGERedFlag <> "OPA"){                                                      
			AOVValue= AOVValue + util.atof_Custom(tcvValue)/(contractterm/12.0);
		}
		
		lineRes=lineRes+"1~targetSpend_quote~"+string(AOVValue)+ "|"
				+"1~annualOfferValue_quote~" + string(round(AOVValue,2)) + "|";

	// }
	// totalGrossMargin = calString[55];
	// fixedGrossMargin = calString[54];
	// mobileGrossMargin = calString[53];
	// paybackMonths="0";
	// if(isnumber(calString[49])){
		// paybackMonths = calString[49];
	// }
	// if(isnumber(calString[86])){ //  tarifaConcertadaCharges Req 072----Added By Manadar
		// tarifaConcertadaCharges = calString[86];
	// }

	//Capex calculation-------------------------------

	// capexTotal = util.atof_Custom(calString[82])+util.atof_Custom(calString[83]);

	// profitabilityIndex=0.0;

	// profitabilityIndex = util.atof_Custom(calString[57]);

	// totalOtherRevenue = calString[56];
	// mobileRevenue = calString[58];
	if(MobileFlag){
		serviceFlag=serviceFlag+"Mobile##";
		
	}
	if(fixedFlag){
		serviceFlag=serviceFlag+"Fixed##";
	}

	//Code to set Show Column Value for ES -- Added By Mandar
	if(MobileFlag AND fixedFlag){

	showColumn="Fixed~Mobile";

	}elif(MobileFlag){
		showColumn="Mobile";
	}elif(fixedFlag){
		showColumn="Fixed";
	}

	//if(cpqSpecificOutcome_qoute == "OPA"){
	//AOVValue=Aovaluenew;
	// for line3 in line_process{
					// if(line3._parent_doc_number == "" AND getconfigattrvalue(line3._document_number,"totalTargetSpent_VGE")<>"" AND getconfigattrvalue(line3._document_number,"totalTargetSpent_VGE")<>"null" AND NOT(ISNULL(getconfigattrvalue(line3._document_number,"totalTargetSpent_VGE"))) ){
									// AOVValue = util.atof_Custom(getconfigattrvalue(line3._document_number,"totalTargetSpent_VGE"));
					// }
	// }
	//}
	//else{
				// if(cpqSpecificOutcome_qoute == "VGERed" OR cpqSpecificOutcome_qoute == "OPA"){
						// AOVValue=targetSpent;
				// }
					// if(contractterm <> 0 AND cpqSpecificOutcome_qoute <> "OPA"){                                                      
						// AOVValue= AOVValue + util.atof_Custom(tcvValue)/(contractterm/12.0);
					// }
		//}

	// rappleOnValue = calString[59];//To set compromised billing on rapple selection
	// totalRevenueVal=calString[68];
	// totalRevenueFixedVal=calString[69];

	//Based on contract type setting validated by contract manager checkbox 
	/* Pooja Panwar - Added conditions for accountManager_ES to have the playbook functionality */

	if((_system_user_groups == "VGE_accountManager_ES" OR _system_user_groups =="WholeSale_accountManager_ES" OR _system_user_groups == "accountManager_ES") AND (selectcontractType_quote == "No Contract")){
		validatedByContractManager = true;//
	}
	elif((_system_user_groups == "VGE_accountManager_ES" OR _system_user_groups =="WholeSale_accountManager_ES" OR _system_user_groups == "accountManager_ES") AND (selectcontractType_quote == "Standard Contract")){
		validatedByContractManager = true;//
	}
	/*elif(_system_user_groups == "VGE_accountManager_ES" AND (selectcontractType_quote == "Bespoke Contract" OR selectcontractType_quote == "Playbook T&Cs") AND approvalRequestIdContract_quote <> "" AND approvalQueueStatusContract_quote == "Submitted"){
		validatedByContractManager = false;
	}**/
	elif((_system_user_groups == "VGE_accountManager_ES" OR _system_user_groups == "accountManager_ES") AND selectcontractType_quote == "Bespoke Contract"  AND approvalRequestIdContract_quote <> "" AND approvalQueueStatusContract_quote == "Submitted"){
		validatedByContractManager = false;//
	}
	elif((_system_user_groups == "VGE_accountManager_ES" OR _system_user_groups =="WholeSale_accountManager_ES" OR _system_user_groups == "accountManager_ES") AND selectcontractType_quote == "Playbook T&Cs" AND approvalRequestIdContract_quote <> "" AND approvalQueueStatusContract_quote == "Submitted"){//
		validatedByContractManager = false;
	}
	elif((_system_user_groups == "VGE_accountManager_ES" OR _system_user_groups == "accountManager_ES") AND selectcontractType_quote == "Bespoke Contract"  AND approvalRequestIdContract_quote <> "" AND approvalQueueStatusContract_quote == "Approved"){
		validatedByContractManager = true;//
	}
	elif((_system_user_groups == "VGE_accountManager_ES" OR _system_user_groups =="WholeSale_accountManager_ES" OR _system_user_groups == "accountManager_ES") AND selectcontractType_quote == "Playbook T&Cs" AND approvalRequestIdContract_quote <> "" AND approvalQueueStatusContract_quote == "Approved"){
		validatedByContractManager = true;//
	}
	elif(_system_user_groups == "WholeSale_accountManager_ES" AND selectcontractType_quote == "Bespoke Contract"){
		validatedByContractManager = true;
	}
	loyaltyInfo = "";
	if(customerSegment_quote <> "VGE"){
	loyaltyInfo = commerce.calculateLoyaltyPoints_ES();
	}
	loyaltyValues = split(loyaltyInfo, "!!!");
	smtv = "";
	if(loyaltyValues[7] <> "" AND loyaltyValues[7] <> "null" AND NOT(isnull(loyaltyValues[7]))){
	smtv = loyaltyValues[7];
	}
	else{
	smtv = "0.00";
	}
	percentIncrease = loyaltyValues[8];
	if(eurosVFFlag){
	loyaltyPoints=1.0;
	}
	else{
	loyaltyPoints = util.atof_Custom(loyaltyValues[0]);
	}
	if(loyaltyValues[5]=="true"){
	approvalFlag=true;
	}


	// lineRes=lineRes+"1~targetSpend_quote~"+string(util.atof_Custom(tcvValue))+ "|"
	// +"1~annualOfferValue_quote~" + string(round(AOVValue,2)) + "|"
	// lineRes=lineRes+"1~grossMargin_quote~" + (totalGrossMargin) + "|"
	// +"1~fixedMargin_quote~" + (fixedGrossMargin) + "|"
	// +"1~mobileMargin_quote~" + (mobileGrossMargin) + "|"
	// +"1~paybackMonths_quote~" + (paybackMonths) + "|"
	// +"1~profitabilityIndex_quote~" + string(profitabilityIndex) + "|"
	// +"1~otherRevenue_Quote~" + (totalOtherRevenue) + "|"
	// +"1~mobileRevenue_quote~" +(mobileRevenue) + "|"
	//below if added for defect 0880

	/* Start : Added by Mahesh for AOV calculation */

	print "negativediscountflag";
	print negativediscountflagNRC;
	print negativediscountflagMRC; 
	PnLValuesES=commerce.pLValues_ES("");
	AOVValueES=util.atof_Custom(get(PnLValuesES,"AOV_VALUE"));
	// //print "AOVValueES***************************************";
	// //print AOVValueES;
	/* End : Added by Mahesh for AOV calculation */
	if(customerSegment_quote <> "VGE")
	{
		lineRes=lineRes+"1~annualOfferValue_quote~" + string(round(AOVValueES,2)) + "|";
	}
	lineRes=lineRes+"1~configuredServicesES_quote~" +(serviceFlag) + "|"
	// +"1~compromiseBilling_quote~" +(rappleOnValue) + "|"
	+"1~mobilePlansInfoES_quote~" +(planInfo) + "|"
	+"1~showLineGridColumns_quote~" +(showColumn) + "|"
	// +"1~totalRevenue_quote~" +(totalRevenueVal) + "|"
	// +"1~totalRevenueFixed_quote~" +(totalRevenueFixedVal) + "|"
	//+"1~vATIDCurrentCount_quote~" +string(VATIDCount) + "|";_
	//+"1~vATIDNew_quote~" +VATIDString+ "|"
	+"1~validatedByContractManager_quote~" +string(validatedByContractManager)+ "|"
	+"1~loyaltyPointsES_quote~" +string(loyaltyPoints) + "|"
	+"1~testFloatES1_quote~" +smtv + "|"
	//+"1~testFloatES2_quote~" +percentIncrease + "|"
	+"1~testBoolean1ES_quote~" + string(cloudServerFlag) + "|"
	+"1~loyaltyApprovalFlag_quote~" + string(approvalFlag) + "|"
	// +"1~capex_quote~" + string(capexTotal) + "|"
	+"1~contractTermOther_quote~" + string(contractTermFromConfig) + "|"
	// +"1~currencyES2_quote~" + tarifaConcertadaCharges + "|"
	+"1~currencyES3_quote~" + string(maxSubsidyRedEmpressa) + "|"
	+"1~currencyES4_quote~" + string(deviceSubsidy) + "|"
	+"1~testTextArea10ES_quote~" + testTextArea7ES + "|"
	+"1~testText8ES_quote~" + excessCharges + "|"
	+"1~testTextArea12ES_quote~" + cpeDetails + "|"
	+"1~thresholdMassiveFlag_quote~" + string(thresholdMassiveFlagES) + "|"
	+"1~thresholdMassiveString_quote~" + thresholdMassiveString + "|"
	+"1~totalFixedProductOneTimeListPrice_ES~" + string(V_SumNRC) + "|"
	+"1~totalFixedProductMonthlyListPrice_ES~" + string(V_SumMRC) + "|"
	+"1~totalFixedProductRecurringCost~" + string(V_SumMRCost) + "|"
	+"1~totalFixedProductOneTimeCost_ES~" + string(V_SumNRCost) + "|"
	+"1~totalCMargin_ES~" + string(V_SumCMargin) + "|"
	+"1~totalRecurringDiscount_ES~" + string(V_SumMarginPercent) + "|"
	+"1~fixedPlaninfoES_quote~" + fixedPlaninfo + "|" 
	+"1~mobileCPQProductString_ES_quote~" + mobileCPQproductinfo + "|"
	+"1~negativetargetdiscountflag_Quote~" + string(negativediscountflagNRC) + "|" 
	+"1~negativetargetdiscountflagMRC_Quote~" + string(negativediscountflagMRC) + "|"
	+"1~primaryTariffInfo_ES_quote~" + primaryTariffInfo + "|";

	if(parentChildStatus == "Parent"){
		lineRes = lineRes +"1~leadTime_parentGlobal_quote~" + string(leadTime) + "|";
	}
	else{
		lineRes = lineRes +"1~overallLeadTime_quote~" + string(leadTime) + "|";
	}

	// // CR:PROJ-1515111_BREQ-015 - Added for plRevenues caculation
	// plRevenuesList = calString[60] +"@@@" +calString[61] +"@@@" +calString[62] +"@@@" +calString[63] +"@@@" +calString[64] +"@@@" +calString[65] +"@@@" +calString[66] +"@@@" +calString[67];
	// lineRes = lineRes +"1~revenuesList_quote~" +plRevenuesList +"|";
	if(_system_current_user_language == "es"){
		lineRes = replace(lineRes,"connectionType_line~New","connectionType_line~Nueva");
		lineRes = replace(lineRes,"connectionType_line~Renew","connectionType_line~Renovación");
		lineRes = replace(lineRes,"connectionType_line~Existing","connectionType_line~Existente");
	}

	return lineRes;