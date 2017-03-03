/* Created By/Date:  Sandip/17022016       
   Comments: Get feasibility call and parse response after applying Pirority matrix for BLUE and GREEN.
*/

//General list of attributes
address2 = "";
count = 0; 
cftEndPointURL = "";
feasibilityExpirationDate = "";
requestID = "";
returnString = "";
count1 = 0; 
typeValue = "";
output = "";
techType = String[];
rAGStatus = String[];
capEx = string[];
initialOpEx = string[];
recurringOpEx = string[]; 

Dict = dict("string");
dictn=dict("string"); 
recordBlue =recordset();
recordGreen =recordset();
headDict=dict("string");
headDict1=dict("string");
caOpDict = dict("string");

capExOpEx =string[];
capExOpExB = string[];
capExOpExG = string[];
accessLeadTime  = string[];
siteValue = string[];
rrags = string[];
siteResponse = ""; headers = dict("string"); errorCodeFlag = false; httpErrorFlag = false;
finalString = "";SERVICES = ""; RAG_STATUS = "";

//Attributes for handling RAG status as per given response.
techArray =string[];
countArray =0; techBlue =""; techGreen =""; techAmber =""; techRed ="";
i = 0; j = 0;
k = 0; l = 0;techTypeB =string[]; techTypeG =string[]; rAGStatusB =string[]; rAGStatusG =string[];
B =0;	technologyB = string[]; technologyG = string[]; G = 0;
type = "";

COUNTRY_VALUE = ""; MARKET_SEGMENT = ""; LAT_LONG = "";  OPPORTUNITY_STATUS = "";TRANSACTION_ID = "";
USER_ID = "";USER_PROFILE = ""; USER_NAME = ""; USER_SURNAME = ""; USER_DEAPRTMENT = ""; CLIENT_ID = ""; CONTACT_PERSONCONTACT_PHONE_NUMBER = "";
Opportunity_ID = ""; QUOTE_NUMBER = ""; REQUEST_ID = ""; FEASIBILLITY_TYPE = "";CPQ_AUTO_FID = "";
MODE_OF_ACCESS = ""; ACCESS_SYMMETRIC = ""; ACCESS_TECHNOLOGY= ""; PRIMARY_ACCESS = ""; PREVIOUS_RESPONSE= "";
CPQ_FEASIBILITYID = ""; AUTOMATIC_FEASIBILITY_ID = ""; ANALYSIS_TYPE = ""; STUDY_LEVEL = "";AUTOMATIC_FEASIBILITY_ID = "";CLIENT_SOLUTION_ANALYSIS = ""; CLIENT_SOLUTION_TYPE = ""; CLIENT_SOLUTION_NUMBER = ""; ACCESS_TECHNOLOGY = "";MAN_FEASIBILITY_ID_OF_MAIN = ""; TAX_IDENTIFICATION_NUMBER = "";
/*Spain!!
006Z000000FAF0FIAX!!00009601!!CFTREQ24!!Automatic
hfcmadrid!!Calle!!de Las Delicias!!!!28!!!!!!28045!!Madrid!!Madrid!!Spain!!L!!40.40403716!!-3.69214355
None!!Asymmetric!!!!PRIMARY_ACCESS!!*/


//Name, Street_Type__c, Street_Name__c, Building__c, Number__c, Doorway__c, Portal__c, Zip_Code__c, City__c, X1SF_State__c, X1SF_Country__c
//Location attributes
locationArray = split(location, "!!" );
siteinfoID = locationArray[0];
StreetTypec = locationArray[1];
ZipCodec = locationArray[7];
StreetNamec = locationArray[2];
Buildingc = locationArray[3];
Numberc = locationArray[4];
Doorwayc = locationArray[5];  
Portalc = locationArray[6];
Cityc = locationArray[8];
X1SFStatec = locationArray[9];
X1SFCountryc = locationArray[10];
X1SFCountryc = "ES";
Latitude = locationArray[12];
Longitude = locationArray[13];

AccessSize = locationArray[11];
address = locationArray[14];
//Common Input parameters
if(commonInput <> "") {
	commonInputArray = split(commonInput, "!!" );
	COUNTRY_VALUE = commonInputArray[0];
	MARKET_SEGMENT = commonInputArray[1];
}

//OPPORTUNITY_ID!!QUOTE_NUMBER!!OPPORTUNITY_STATUS!!TRANSACTION_ID
//Parent Input parameters
if(parentIdentifier <> "") {
	parentIdentifierArray = split(parentIdentifier, "!!" );
	
	Opportunity_ID = parentIdentifierArray[0];
	QUOTE_NUMBER = parentIdentifierArray[1];
	OPPORTUNITY_STATUS = parentIdentifierArray[2];
	TRANSACTION_ID = parentIdentifierArray[3];
	TAX_IDENTIFICATION_NUMBER = parentIdentifierArray[4];
}

//Feasibility Input parameters
//CPQ_FEASIBILITYID!!AUTOMATIC_FEASIBILITY_ID!!ANALYSIS_TYPE!!STUDY_LEVEL!!CLIENT_SOLUTION_ANALYSIS!!CLIENT_SOLUTION_TYPE!!CLIENT_SOLUTION_NUMBER!!MAN_FEASIBILITY_ID_OF_MAIN!!ACCESS_TECHNOLOGY!!CPQ_AUTO_FID
if(feasibility <> "") {
	feasibilityArray = split(feasibility, "!!" );

	CPQ_FEASIBILITYID = feasibilityArray[0];
	AUTOMATIC_FEASIBILITY_ID = feasibilityArray[1];
	ANALYSIS_TYPE = feasibilityArray[2];
	STUDY_LEVEL = feasibilityArray[3];
	CLIENT_SOLUTION_ANALYSIS = feasibilityArray[4];
	CLIENT_SOLUTION_TYPE = feasibilityArray[5];
	CLIENT_SOLUTION_NUMBER = feasibilityArray[6];
	MAN_FEASIBILITY_ID_OF_MAIN = feasibilityArray[7];
	ACCESS_TECHNOLOGY = feasibilityArray[8];
	CPQ_AUTO_FID = feasibilityArray[9];
	RAG_STATUS = feasibilityArray[10];
	referKey = feasibilityArray[11];
}

//print "MAN_FEASIBILITY_ID_OF_MAIN";
//print MAN_FEASIBILITY_ID_OF_MAIN;

bmiSessionId = _user_session_id;
bmSiteName = lower(_company_name);
commerceProcess = "quickstart_commerce_process";
quoteProcess = "quote_process";

//Response XML.
//responseXML = "https://" + lower(bmSiteName)  +".bigmachines.com/bmfsweb/"+ lower(bmSiteName) + "/image/XML/" + siteinfoID + ".xml";

put(headers , "Accept-Encoding", "gzip,deflate");
put(headers , "Content-Type", "text/xml; text/xml;charset=UTF-8");
put(headers , "SOAPAction", "http://group.vodafone.com/contract/vbs/service/check-service-feasibility/v1/manual");

results = bmql("select Value from FixedConstants where Name = $_company_name");
for result in results {
	cftEndPointURL = get(result, "Value");
}

//print cftEndPointURL;
//cftEndPointURL = "https://gaservice.fit.esb.vodafone.com/enterprise-services/fit/cpq/service-feasibility/v1";

//Request XML.
//cftRequestXML = "https://" + lower(bmSiteName)  +".bigmachines.com/bmfsweb/"+ lower(bmSiteName) + "/image/XML/CheckManualServiceFeasibilityRequest.xml";
cftRequestXML = "https://" + lower(bmSiteName)  +".bigmachines.com/bmfsweb/"+ lower(bmSiteName) + "/image/XML/Manual-Request.xml";
//print cftRequestXML ;
//print requestXML;
//Preparing feasiblity request as per selected site.
soapString = urldatabyget(cftRequestXML, "", "error");
//print soapString ;

//@1
soapString = replace(soapString , "MARKET_SEGMENT", MARKET_SEGMENT);

//@2
//OPPID!!QUOTE_NUMBER!!OPP_STATUS!!TRASACTION_ID
//Opportunity_ID = "123456";
soapString = replace(soapString , "OPPORTUNITY_ID", Opportunity_ID);
soapString = replace(soapString , "QUOTE_NUMBER", QUOTE_NUMBER);
soapString = replace(soapString , "OPPORTUNITY_STATUS", OPPORTUNITY_STATUS);
soapString = replace(soapString , "TRANSACTION_ID", TRANSACTION_ID);

//@3
//Need to replace actual values
soapString = replace(soapString , "STREET_TYPE", StreetTypec);
soapString = replace(soapString , "STREET_NAME", StreetNamec);
soapString = replace(soapString , "STREET_NUMBER", Numberc);
soapString = replace(soapString , "POSTCODE", ZipCodec);
soapString = replace(soapString , "LOCATION_CITY", Cityc);
soapString = replace(soapString , "PROVINCE", X1SFStatec);
soapString = replace(soapString , "LOCATION_COUNTRY", "ES");
soapString = replace(soapString , "COUNTRY", "ES");
//soapString = replace(soapString , "LATITUDE_MEASURE", Latitude);
//soapString = replace(soapString , "LONGITUDE_MEASURE", Longitude);

if(Latitude <> "" AND Longitude <> ""){

	LAT_LONG = "<v12:LocationCoordinates actionCode=\"ADD\"><v12:LatitudeMeasure>"+ Latitude +"</v12:LatitudeMeasure><v12:LongitudeMeasure>"+Longitude+"</v12:LongitudeMeasure><v12:SystemID>100</v12:SystemID></v12:LocationCoordinates>";
	
	soapString = replace(soapString , "LAT_LONG", LAT_LONG);
}

//selectProductES_quote + "!!" + preparedByFirstName_quote + "!!" + preparedByLastName_quote+ "!!"+userDepartment_quote+"!!"+userProfile_quote+"!!"+userVFUID_quote;

//Temporary code for manual feasibility execution.
if(_company_name == "devvodafonegroup"){
	soapString = replace(soapString , "DEPARTMENT", "Account");
	soapString = replace(soapString , "LDAP_USER_ID", "tuser");
	soapString = replace(soapString , "ACCOUNT_REGION", "South");
	soapString = replace(soapString , "TAX_IDENTIFICATION_NUMBER", "A60407087");
}else{
	userInfo = split(productSelectionString, "!!");
	soapString = replace(soapString , "FIRST_NAME", userInfo[1]);
	soapString = replace(soapString , "LAST_NAME", userInfo[2]);
	soapString = replace(soapString , "DEPARTMENT", userInfo[3]);
	soapString = replace(soapString , "PROFILE", userInfo[4]);
	soapString = replace(soapString , "LDAP_USER_ID", userInfo[5]);
	soapString = replace(soapString , "ACCOUNT_REGION", userInfo[6]);
	soapString = replace(soapString , "TAX_IDENTIFICATION_NUMBER", TAX_IDENTIFICATION_NUMBER);	
}

//@4
//USER_ID!!USER_PROFILE!!USER_NAME!!USER_SURNAME!!CLIENT_COMPANY_NAME!!USER_DEAPRTMENT!!CLIENT_ID!!CONTACT_PERSONCONTACT_PHONE_NUMBER
soapString = replace(soapString , "EMAIL_ADDRESS", USER_ID);
soapString = replace(soapString , "EMAIL_ADDRESS", _user_email);
soapString = replace(soapString , "USER_PROFILE", USER_PROFILE);
soapString = replace(soapString , "USER_NAME", USER_NAME);
soapString = replace(soapString , "USER_SURNAME", USER_SURNAME);
soapString = replace(soapString , "USER_DEAPRTMENT", USER_DEAPRTMENT);
soapString = replace(soapString , "CLIENT_ID", CLIENT_ID);
soapString = replace(soapString , "CONTACT_PERSONCONTACT_PHONE_NUMBER", CONTACT_PERSONCONTACT_PHONE_NUMBER);

//@5
//CPQ_FEASIBILITYID!!AUTOMATIC_FEASIBILITY_ID!!ANALYSIS_TYPE!!STUDY_LEVEL!!CLIENT_SOLUTION_ANALYSIS!!CLIENT_SOLUTION_TYPE!!CLIENT_SOLUTION_NUMBER!!MAN_FEASIBILITY_ID_OF_MAIN!!ACCESS_TECHNOLOGY

/*if(ANALYSIS_TYPE == "Backup" OR ANALYSIS_TYPE =="B-end"){
	MAN_FEASIBILITY_ID_OF_MAIN = "123";
}else{
	MAN_FEASIBILITY_ID_OF_MAIN = "";
}*/

if(CLIENT_SOLUTION_ANALYSIS == "true"){
	CLIENT_SOLUTION_ANALYSIS = "Y";
}else{
	CLIENT_SOLUTION_ANALYSIS = "N";
	CLIENT_SOLUTION_TYPE = "";
	CLIENT_SOLUTION_NUMBER = "";
}
	
soapString = replace(soapString , "CPQ-FEASIBILITY_ID", CPQ_FEASIBILITYID);
soapString = replace(soapString , "AUTOMATIC_FEASIBILITY_ID", AUTOMATIC_FEASIBILITY_ID);
soapString = replace(soapString , "ANALYSIS_TYPE", ANALYSIS_TYPE);
soapString = replace(soapString , "STUDY_LEVEL", STUDY_LEVEL);
soapString = replace(soapString , "CLIENT_SOLUTION_ANALYSIS", CLIENT_SOLUTION_ANALYSIS);
if(CLIENT_SOLUTION_TYPE == "productoFueraPortfolio"){
 CLIENT_SOLUTION_TYPE = "Producto Fuera Portfolio";
}
soapString = replace(soapString , "CLIENT_SOLUTION_TYPE", CLIENT_SOLUTION_TYPE);
soapString = replace(soapString , "CLIENT_SOLUTION_NUMBER", CLIENT_SOLUTION_NUMBER);
soapString = replace(soapString , "MAN_FEASIBILITY_ID_OF_MAIN", MAN_FEASIBILITY_ID_OF_MAIN);
soapString = replace(soapString , "ACCESS_TECHNOLOGY", ACCESS_TECHNOLOGY);
soapString = replace(soapString , "RAG_STATUS", RAG_STATUS);
//@6 - Service Details
//Asymmetric$$VPN MPLS$$$$$$$$##Voice$$PRA$$$$$$$$12

if(serviceDetails <> "") {
	serviceDetailsArray = split(serviceDetails, "##");
	for each in serviceDetailsArray{
		if(not(isnull(each))){
			individualService = split(each, "$$");
			if(not(isnull(individualService[0]))){
				if(individualService[0] == "Voice"){
				SERVICES = SERVICES + "<v13:Service><v12:Name>" + individualService[0] + "</v12:Name><v12:Type>" + individualService[1] +"</v12:Type><v13:WANInterface>" + individualService[2] + "</v13:WANInterface><v13:Quantity>" + individualService[5] + "</v13:Quantity></v13:Service>";
				}elif(individualService[0] == "Symmetric Data"){
					SERVICES = SERVICES + "<v13:Service><v12:Name>" + individualService[0] + "</v12:Name><v12:Type>" + individualService[1] +"</v12:Type><v13:WANInterface>" + individualService[2] + "</v13:WANInterface><v13:AccessSpeed>" + util.getValidBandwidthForManualFeasibility(individualService[3], type) + "</v13:AccessSpeed><v13:Capacity>" + util.getValidBandwidthForManualFeasibility(individualService[4], type) + "</v13:Capacity></v13:Service>";
				}elif(individualService[0] == "Asymmetric Data"){
					print "enter loop";
					SERVICES =  SERVICES + "<v13:Service><v12:Name>" + individualService[0] + "</v12:Name><v12:Type>" + individualService[1] + "</v12:Type><v13:AccessSpeed>" + individualService[3] + "</v13:AccessSpeed></v13:Service>";
				}elif(individualService[0] == "Carrying Circuits"){
					SERVICES = SERVICES + "<v13:Service><v12:Name>" + individualService[0] +"</v12:Name><v12:Type>" + individualService[1] + "</v12:Type><v13:WANInterface>" + individualService[2] +"</v13:WANInterface><v13:AccessSpeed>" + util.getValidBandwidthForManualFeasibility(individualService[3], type) + "</v13:AccessSpeed><v13:Quantity>" + individualService[5] + "</v13:Quantity></v13:Service>";
				}	
			}			
		}
	}
}

//Passing inccorect values need error code from CESB to handle it
//#1016#,#It is mandatory to send at lea
if(SERVICES == ""){
	SERVICES = "<v13:Service><v12:Name>Assymmmetric Data</v12:Name><v12:Type>VPN MPLS</v12:Type><v13:AccessSpeed>50/5</v13:AccessSpeed></v13:Service>";
}

soapString = replace(soapString , "SERVICES", SERVICES);

//Fixed against defect 337.
soapString = replace(soapString , "ADDRESS_ADDTIONAL_DATA", address);


print "--------CFT REQUEST START-----------";
print soapString;
print "--------CFT REQUEST END------------";

responseArray = string[];

//Webservice call to run feasiblity.
resultXML = urldatabypost(cftEndPointURL , soapString , "", headers, true);
//responseXML = "https://devvodafonegroup.bigmachines.com/bmfsweb/devvodafonegroup/image/XML/CheckManualFeasibilityAcknowledgement.xml";

//resultXML = urldatabyget(responseXML , "", "error");
print "--------CFT RESPONSE START-----------";
print resultXML;
print "--------CFT RESPONSE END-----------";

if(find(resultXML, "HTTP response code: 500") <> -1){
	output = siteinfoID + "#,#" + "500" + "#,#"+ "HTTP 500 Error" + "@@" + CPQ_AUTO_FID;
}
else{
	//finalString = util.removeEscapeCharacter(resultXML);
	finalString = util.removeAllNamespacesFromXMLUsingXSLT(resultXML);

	xslt = "/XML/parse-manual-ack-response.xsl";

	output = transformxml(finalString, xslt); 
	output = replace(output, "SITE_NAME", siteinfoID);

	output = replace(output, "CPQ_AUTOMATIC_FID", CPQ_AUTO_FID);
}

return output;