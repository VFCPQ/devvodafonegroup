/* Created By/Date:  Krihna/03082015       
   Updated By/Date:  Krishna/24082015
   Updated By/Date:  Sandip/07092015 - Prearing request and make generic UTIL
   Comments: Get feasibility call and parse response after applying Pirority matrix for BLUE and GREEN.
*/

//General list of attributes
//siteinfoID = SiteName; 
address2 = "";
techType = String[];
rAGStatus = String[];count = 0 ;
capEx = string[];
initialOpEx = string[];
recurringOpEx = string[]; cftEndPointURL = "";
feasibilityExpirationDate = "";
cpqFeasiblityID = "";
Dict = dict("string");
dictn=dict("string"); recordBlue =recordset();
recordGreen =recordset();
returnString = ""; count1 = 0; typeValue = "";
headDict=dict("string");
headDict1=dict("string");
caOpDict = dict("string");
capExOpEx =string[];
capExOpExB = string[];
capExOpExG = string[]; accessLeadTime  = string[];
siteValue = string[];  rrags = string[];
siteResponse = ""; headers = dict("string"); errorCodeFlag = false; httpErrorFlag = false;
finalString = ""; output = "";

//Attributes for handling RAG status as per given response.
techArray =string[];
countArray =0; techBlue =""; techGreen =""; techAmber =""; techRed ="";
i = 0; j = 0;
k = 0; l = 0;techTypeB =string[]; techTypeG =string[]; rAGStatusB =string[]; rAGStatusG =string[];
B =0;	technologyB = string[]; technologyG = string[]; G = 0;
xslt = "";

COUNTRY_VALUE = ""; MARKET_SEGMENT = "";
Opportunity_ID = ""; QUOTE_ID = ""; REQUEST_ID = ""; FEASIBILLITY_TYPE = "";
MODE_OF_ACCESS = ""; ACCESS_SYMMETRIC = ""; ACCESS_TECHNOLOGY= ""; PRIMARY_ACCESS = ""; PREVIOUS_RESPONSE= "";
COUNTRY_VALUE = ""; MARKET_SEGMENT = ""; LAT_LONG = "";  OPPORTUNITY_STATUS = "";TRANSACTION_ID = "";
USER_ID = "";USER_PROFILE = ""; USER_NAME = ""; USER_SURNAME = ""; USER_DEAPRTMENT = ""; CLIENT_ID = ""; CONTACT_PERSONCONTACT_PHONE_NUMBER = "";
Opportunity_ID = ""; QUOTE_NUMBER = ""; REQUEST_ID = ""; FEASIBILLITY_TYPE = "";
MODE_OF_ACCESS = ""; ACCESS_SYMMETRIC = ""; ACCESS_TECHNOLOGY= ""; PRIMARY_ACCESS = ""; PREVIOUS_RESPONSE= "";
CPQ_FEASIBILITYID = ""; AUTOMATIC_FEASIBILITY_ID = ""; ANALYSIS_TYPE = ""; STUDY_LEVEL = "";AUTOMATIC_FEASIBILITY_ID = "";CLIENT_SOLUTION_ANALYSIS = ""; CLIENT_SOLUTION_TYPE = ""; CLIENT_SOLUTION_NUMBER = ""; ACCESS_TECHNOLOGY = "";MAN_FEASIBILITY_ID_OF_MAIN = ""; timeStamp = "";
/*Spain!!
006Z000000FAF0FIAX!!00009601!!CFTREQ24!!Automatic
hfcmadrid!!Calle!!de Las Delicias!!!!28!!!!!!28045!!Madrid!!Madrid!!Spain!!L!!40.40403716!!-3.69214355
None!!Asymmetric!!!!PRIMARY_ACCESS!!*/


//Name, Street_Type__c, Street_Name__c, Building__c, Number__c, Doorway__c, Portal__c, Zip_Code__c, City__c, X1SF_State__c, X1SF_Country__c
//Location attributes
locationArray = split(location, "!!" );
siteinfoID = locationArray[0];
////print "siteinforid----";
//print siteinfoID;
//print "siteinforid----";
StreetTypec = locationArray[1];
ZipCodec = locationArray[7];
StreetNamec = locationArray[2];
Buildingc = locationArray[3];
Numberc = locationArray[4];
Doorwayc = locationArray[5];  
Portalc = locationArray[6];

Cityc = locationArray[8];
//Cityc = "Colinas de San Antonio";
X1SFStatec = locationArray[9];

//X1SFStatec = "";
X1SFCountryc = locationArray[10];

if(X1SFCountryc == "Spain"){
	X1SFCountryc = "ES";
}elif(X1SFCountryc == "France"){
	X1SFCountryc = "PT";
}elif(X1SFCountryc == "Morocco"){
	X1SFCountryc = "MA";
}elif(X1SFCountryc == "Portugal"){
	X1SFCountryc = "AD";
}


Latitude = locationArray[12];
//Latitude = "1.00";
Longitude = locationArray[13];

AccessSize = locationArray[11];


//get current date and time
timeStamp = datetostr(getdate(true));

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
}
//Feasibility Input parameters
if(feasibility <> "") {
	feasibilityArray = split(feasibility, "!!" );
	////print feasibilityArray;
	MODE_OF_ACCESS = feasibilityArray[0];
	ACCESS_SYMMETRIC = feasibilityArray[1];
	CPQ_FEASIBILITYID = feasibilityArray[2];
}

//Convert Bandwith 
if(MODE_OF_ACCESS <> ""){
	MODE_OF_ACCESS = util.getValidBandwdithName_ES(MODE_OF_ACCESS);
}

//MODE_OF_ACCESS = "PaP_2M";

bmiSessionId = _user_session_id;
bmSiteName = lower(_company_name);
commerceProcess = "quickstart_commerce_process";
quoteProcess = "quote_process";

//Response XML.

put(headers , "Accept-Encoding", "gzip,deflate");
put(headers , "Content-Type", "text/xml; text/xml;charset=UTF-8");
put(headers , "SOAPAction", "http://group.vodafone.com/contract/vbs/service/check-service-feasibility/v1/check");

results = bmql("select Value from FixedConstants where Name = $_company_name");
for result in results {
	cftEndPointURL = get(result, "Value");
}

//print cftEndPointURL;
//cftEndPointURL = "https://gaservice.fit.esb.vodafone.com/enterprise-services/fit/cpq/service-feasibility/v1";

//Request XML.
cftRequestXML = "https://" + lower(bmSiteName)  +".bigmachines.com/bmfsweb/"+ lower(bmSiteName) + "/image/XML/CheckServiceFeasibilityRequest-Automatic.xml";
//print cftRequestXML ;

//Preparing feasiblity request as per selected site.
soapString = urldatabyget(cftRequestXML, "", "error");
////print soapString ;

//@1
soapString = replace(soapString , "MARKET_SEGMENT", MARKET_SEGMENT);

//@2
//OPPID!!QUOTE_NUMBER!!OPP_STATUS!!TRASACTION_ID
soapString = replace(soapString , "OPPORTUNITY_ID", Opportunity_ID);
soapString = replace(soapString , "QUOTE-NUMBER", QUOTE_NUMBER);
soapString = replace(soapString , "OPPORTUNITY_STATUS", OPPORTUNITY_STATUS);
soapString = replace(soapString , "TRANSACTION_ID", TRANSACTION_ID);
soapString = replace(soapString , "CURRENT_TIME", timeStamp);

//@3
//Need to replace actual values
soapString = replace(soapString , "STREET_TYPE", StreetTypec);
soapString = replace(soapString , "STREET_NAME", StreetNamec);
soapString = replace(soapString , "STREET_NUMBER", Numberc);
soapString = replace(soapString , "POSTCODE", ZipCodec);
soapString = replace(soapString , "LOCATION_CITY", Cityc);
soapString = replace(soapString , "PROVINCE", X1SFStatec);
//soapString = replace(soapString , "LOCATION_COUNTRY", X1SFCountryc);
soapString = replace(soapString , "COUNTRY", X1SFCountryc);
//soapString = replace(soapString , "LATITUDE_MEASURE", Latitude);
//soapString = replace(soapString , "LONGITUDE_MEASURE", Longitude);

if(Latitude <> "" AND Longitude <> ""){

	LAT_LONG = "<ns2:LocationCoordinates actionCode=\"ADD\"><ns2:LatitudeMeasure>"+ Latitude +"</ns2:LatitudeMeasure><ns2:LongitudeMeasure>"+Longitude+"</ns2:LongitudeMeasure><ns2:SystemID>100</ns2:SystemID></ns2:LocationCoordinates>";
	
	soapString = replace(soapString , "LAT_LONG", LAT_LONG);
}

soapString = replace(soapString , "MODE_OF_ACCESS_BANDWIDTH", MODE_OF_ACCESS);
soapString = replace(soapString , "ACCESS_SYMMETRIC", ACCESS_SYMMETRIC);
soapString = replace(soapString , "CPQ-FEASIBILITY_ID", CPQ_FEASIBILITYID);

print "--------CFT REQUEST START-----------";
print soapString;
print "--------CFT RESPONSE END------------";

//requestXML = "https://sitvfcpq.bigmachines.com/bmfsweb/sitvfcpq/image/XML/cpq-request-final.xml";

//soapString = urldatabyget(requestXML, "", "error");
responseArray = string[];
//resultXML = ""; commented by Santhosh
//Webservice call to run feasiblity.
resultXML = urldatabypost(cftEndPointURL , soapString , "", headers, true); //uncomment by santhosh

//print "--------CFT RESPONSE START-----------";
//print resultXML ;
//print "--------CFT RESPONSE END-----------";
//print find(resultXML, "HTTP response code: 500");
//finalString = util.removeEscapeCharacter(resultXML);
if(find(resultXML, "HTTP response code: 500") <> -1){
	//SITENAME#,#ERROR_CODE#,#MESSAGE@@CPQREQUSTID
	output = siteinfoID + "#,#" + "500" + "#,#"+ "HTTP 500 Error" + "@@" + CPQ_FEASIBILITYID + "@@";
}else{
	
	
	finalString = util.removeAllNamespacesFromXMLUsingXSLT(resultXML);
	xslt = "/XML/parse-automatic-ack-response.xsl";	
	output = transformxml(finalString, xslt);
	output = replace(output, "SITE_NAME", siteinfoID);
}

//output = "delaQuintana@@@@@@CFTREQ1";
output = replace(output, "SITE_NAME", siteinfoID);

return output;