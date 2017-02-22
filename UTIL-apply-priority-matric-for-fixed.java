//@Sandip - Apply Priority Matrix logic on Automatic Feasibility Repsonse.
//Modified by -- santhosh for PROJ-1518930_BREQ-107 BREQ for Feasibility Priority logic updated

i = 0; j = 0; m =0;n =0; p =0;q=0;
k = 0; l = 0;B =0;G = 0; A=0; R= 0;
techTypeB =string[]; techTypeG =string[]; techTypeR =string[]; techTypeA =string[];
rAGStatusB =string[]; rAGStatusG =string[]; rAGStatusA =string[]; rAGStatusR =string[];
technologyB = string[]; technologyG = string[];  technologyA = string[]; technologyR = string[]; 
techArray =string[];
countArray =0; techBlue =""; techGreen =""; techAmber =""; techRed ="";
headDict=dict("string"); headDict1=dict("string"); headDict2=dict("string"); headDict3=dict("string");
headArray =string[]; headArray1=string[]; headArray2 =  string[]; headArray3 = string[];
caOpDict = dict("string");
priorityDict = dict("string");
priorityArray = string[];
capExOpEx =string[];
capExOpExB = string[]; capExOpExG = string[]; capExOpExA = string[]; capExOpExR = string[];
accessLeadTime  = string[];
siteValue = string[];  rrags = string[];
recordBlue =recordset();recordGreen =recordset(); recordAmber =recordset(); recordRed =recordset();
siteinfoID = "";
finalString = "";  finalStringA = ""; finalStringR = "";
techArray[2]="";techArray[3]="";
responseOne = ""; AccessSize = "";
capacity = "";
requestType = "";
prioCnt = 0;finalStringforBackup = ""; backupTech = "";
blueTechnologyArray = string[];
greenTechnologyArray = string[];
amberTechnologyArray = string[];
redTechnologyArray = string[];

//Getting Site size for IPVPN 
if(requestParameter <> "" AND productType == "IPVPN"){
	AccessSize = util.getIndexedValue(requestParameter, "$$", 7);
	requestType = util.getIndexedValue(requestParameter, "$$", 13);
	
}elif(productType == "enlacePortador"){
	capacity = util.getIndexedValue(requestParameter, "$$", 3);
}

responseOne = util.getIndexedValue(responseXML, "@@", 0);

siteValue = split(responseOne, "$$");

//print "<ns2:Status listID=\"\"xmlns:ns2=\"http://group.vodafone.com/schema/common/v1\">";
for each in siteValue {
	if(each <> "" AND not(isnull(each))){
		siteinfoID = util.getIndexedValue(each, "##", 0);
		//Code of response having RAG status is BLUE stored in 0th index of techType Array.
		if(find(each,"##B##") <> -1){
			//print "enter for Blue";
			techBlue = techBlue + each + "$$";
			techArray[0] = techBlue;
			i = i + 1;
		}
		//Code of response having RAG status is Green stored in 1st index of techType Array.
		elif(find(each, "##G##") <> -1){
			//print "enter for Green";
			techGreen = techGreen + each + "$$";
			techArray[1] = techGreen  ;
			j = j + 1;
			
		}
		//Code of response having RAG status is AMBER stored in 2nd index of techType Array.
		elif(find(each, "##A##") <> -1){
			//print "enter for amber";
			techAmber =techAmber + each + "$$";
			techArray[2] = techAmber ;
			m = m+1;
		}
		//Code of response having RAG status is RED stored in 3rd index of techType Array.
		elif(find(each, "##R##") <> -1){
			//print "enter for Red";
			techRed =techRed + each + "$$";
			techArray[3] = techRed ;
			n= n+1;
		}
	}
}
//print "AMBER"; //print techArray[2];
//print "RED"; //print techArray[3];

//Code for if response containts more that one BLUE then store in BLUE techtype array.
if(i >= 2){
	//Split BLUE 
	tech1 = split(techArray[0],"$$");
	for each in tech1{
		if(each<>""){
		//print each;
			techB = split(each, "##");
			techTypeB[k] = techB[1];
			rAGStatusB[k] = techB[2];
			techBstr = "";
			pass =0;
			 for val in techB {
				if(pass >= 3) {
					techBstr = techBstr + val + "##";
				}
				pass = pass + 1;
			 }
			//capExOpExB[k] = techB[3] + "##" + techB[4] + "##" + techB[5] + "##" + techB[6] + "##" + techB[7]+ "##" + //techB[8]+ "##" + techB[9]+ "##" + techB[10];	

			//put(caOpDict, techTypeB[k], capExOpExB[k]);
			put(caOpDict, techTypeB[k], techBstr);
			k = k + 1;  
		}
	}

}
//print caOpDict;
//Code for if response containts more that one GREEN then store in GREEN techtype array.
if(j>=2){
	tech2 = split(techArray[1],"$$");
	for each in tech2{
		if(each<>""){ 
		//print each;
		techG = split(each, "##");
			techTypeG[l] = techG[1];
			rAGStatusG[l] = techG[2];
			techGstr = "";
			pass =0;
			for val in techG {
				if(pass >= 3) {
					techGstr = techGstr + val + "##";
				}
				pass = pass + 1;
			}
			//capExOpExG[l] = techG[3] + "##" + techG[4] + "##" + techG[5] + "##" + techG[6] + "##" + techG[7]+ "##" + techG[8];
			//put(caOpDict,techTypeG[l], capExOpExG[l]);

			//put(caOpDict,techTypeG[l], capExOpExG[l]);
			put(caOpDict,techTypeG[l], techGstr);			
			l = l + 1;
		}
	}

}
//print techTypeG;
//@451- for Amber
//Code for if response containts more that one AMBER then store in AMBER techtype array.
if(m>=2){
	tech2 = split(techArray[2],"$$");
	for each in tech2{
		if(each<>""){ 
		//print each;
		techA = split(each, "##");
			techTypeA[p] = techA[1];
			rAGStatusA[p] = techA[2];
			//capExOpExA[p] = techA[3] + "##" + techA[4] + "##" + techA[5] + "##" + techA[6];
			techAstr = "";
			pass =0;
			for val in techA {
				if(pass >= 3) {
					techAstr = techAstr + val + "##";
				}
				pass = pass + 1;
			}
			//capExOpExA[p] = techA[3] + "##" + techA[4] + "##" + techA[5] + "##" + techA[6] + "##" + techA[7]+ "##" + techA[8];
			//put(caOpDict,techTypeA[p], capExOpExA[p]);
			put(caOpDict,techTypeA[p], techAstr);
					
			p = p + 1;
		}
	}
}

//@451- for RED
//Code for if response containts more that one RED then store in RED techtype array.
if(n>=2){
	tech2 = split(techArray[3],"$$");
	for each in tech2{
		if(each<>""){ 
		//print each;
		techR = split(each, "##");
			techTypeR[q] = techR[1];
			rAGStatusR[q] = techR[2];
			techRstr = "";
			pass =0;
			for val in techR {
				if(pass >= 3) {
					techRstr = techRstr + val + "##";
				}
				pass = pass + 1;
			}
			//capExOpExR[q] = techR[3] + "##" + techR[4] + "##" + techR[5] + "##" + techR[6] + "##" + techR[7]+ "##" + techR[8];
			//put(caOpDict,techTypeR[q], capExOpExR[q]);
			put(caOpDict,techTypeR[q], techRstr);		
			q = q + 1;
		}
	}
}

//--------BLUE-------------
//Fetch Technology and priority and apply Priority matrix if more than one BLUE.
if(i>=2){
	if(productType == "IPVPN"){
		recordBlue = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $AccessSize AND Technology  in $techTypeB");	
	}
	if(productType == "enlacePortador"){
		recordBlue = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $capacity AND Technology  in $techTypeB");		
	}
	if(productType == "Internet Legacy"){
		recordBlue = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeB AND Type = 'Internet Legacy'");		
	}
	if(productType == "MPLS and VPLS Legacy"){
		recordBlue = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeB AND Type = 'MPLS and VPLS Legacy'");		
	}
	if(productType == "Legacy Avalon"){
		recordBlue = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeB AND Type = 'Legacy Avalon'");		
	}
}

 
for each in recordBlue{
	if(get(each, "Priority") <> "0" AND productType == "enlacePortador"){
		put(headDict,get(each, "Priority"), get(each, "Technology"));
		append(blueTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Internet Legacy" OR productType == "MPLS and VPLS Legacy"){
		put(headDict,get(each, "Priority"), get(each, "Technology"));
		append(blueTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Legacy Avalon"){
		put(headDict,get(each, "Priority"), get(each, "Technology"));
		append(blueTechnologyArray,get(each, "Priority"));
	}else{
		if(containskey(headDict, get(each, "Priority")) == false) {
			put(headDict,get(each, "Priority"), get(each, "Technology"));
			append(blueTechnologyArray,get(each, "Priority"));
		}else{
			//For Remaining Zero priority technologies.
			append(headArray, get(each, "Technology")); 
		}
	}
}

//Sorting Access Priority BLUE higest priority index come first
//keyB= sort(keys(headDict), "desc");
keyB= sort(keys(headDict));
keyB = blueTechnologyArray;
for each in keyB{
	technologyB[B]=get(headDict,each);
	B = B + 1;
}
for each1 in headArray{
	technologyB[B]=each1;
	B = B + 1;
}

//--------GREEN-------------
//Fetch Technology and priority and apply Priority matrix if more than one GREEN.
if(j>=2){
	if(productType == "IPVPN"){
		recordGreen = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $AccessSize AND Technology  in $techTypeG");
	}
	if(productType == "enlacePortador"){
		recordGreen = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $capacity AND Technology  in $techTypeG");
	}
	if(productType == "Internet Legacy"){
		recordGreen = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeG AND Type = 'Internet Legacy'");		
	}
	if(productType == "MPLS and VPLS Legacy"){
		recordGreen = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeG AND Type = 'MPLS and VPLS Legacy'");		
	}
	if(productType == "Legacy Avalon"){
		recordGreen = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeG AND Type = 'Legacy Avalon'");		
	}
}

for each in recordGreen{
	if(get(each, "Priority") <> "0" AND productType == "enlacePortador"){
		put(headDict1,get(each, "Priority"), get(each, "Technology"));
		append(greenTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Internet Legacy" OR productType == "MPLS and VPLS Legacy"){
		put(headDict1,get(each, "Priority"), get(each, "Technology"));
		append(greenTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Legacy Avalon"){
	
		put(headDict1,get(each, "Priority"), get(each, "Technology"));
		append(greenTechnologyArray,get(each, "Priority"));
	}else{
		if(containskey(headDict1, get(each, "Priority")) == false) {
			put(headDict1,get(each, "Priority"), get(each, "Technology"));
			append(greenTechnologyArray,get(each, "Priority"));
		}else{
			//For Remaining Zero priority technologies.
			append(headArray1, get(each, "Technology")); 
		}
	}
}

//keyG= sort(keys(headDict1), "desc");
keyG= sort(keys(headDict1));
keyG = greenTechnologyArray;
for each in keyG {
	technologyG[G]=get(headDict1,each); 
	G = G + 1;
}
for each1 in headArray1{
	technologyG[G]=each1;
	G = G + 1;
}

//--------AMBER-------------
//Fetch Technology and priority and apply Priority matrix if more than one GREEN.
if(m>=2){
	if(productType == "IPVPN"){
		recordAmber = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $AccessSize AND Technology  in $techTypeA");
	}
	if(productType == "enlacePortador"){
		recordAmber = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $capacity AND Technology  in $techTypeA");
	}
	if(productType == "Internet Legacy"){
		recordAmber = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeA AND Type = 'Internet Legacy'");		
	}
	if(productType == "MPLS and VPLS Legacy"){
		recordAmber = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeA AND Type = 'MPLS and VPLS Legacy'");		
	}
	if(productType == "Legacy Avalon"){
		recordAmber = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeA AND Type = 'Legacy Avalon'");		
	}
}

for each in recordAmber{
	if(get(each, "Priority") <> "0" AND productType == "enlacePortador"){
		put(headDict2,get(each, "Priority"), get(each, "Technology"));
		append(amberTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Internet Legacy" OR productType == "MPLS and VPLS Legacy"){
		put(headDict2,get(each, "Priority"), get(each, "Technology"));
		append(amberTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Legacy Avalon"){
		put(headDict2,get(each, "Priority"), get(each, "Technology"));
		append(amberTechnologyArray,get(each, "Priority"));
	}else{
		if(containskey(headDict2, get(each, "Priority")) == false) {
			put(headDict2,get(each, "Priority"), get(each, "Technology"));
			append(amberTechnologyArray,get(each, "Priority"));
		}else{
			//For Remaining Zero priority technologies.
			append(headArray2, get(each, "Technology")); 
		}
	}
}

//keyA= sort(keys(headDict2), "desc");
keyA= sort(keys(headDict2));
keyA = amberTechnologyArray;
for each in keyA {
	technologyA[A]=get(headDict2,each);
	A = A + 1;
}
for each1 in headArray2{
	technologyA[A]=each1;
	A = A + 1;
}
//--------RED-------------
//Fetch Technology and priority and apply Priority matrix if more than one GREEN.
if(n>=2){
	if(productType == "IPVPN"){
		recordRed = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $AccessSize AND Technology  in $techTypeR");
	}
	if(productType == "enlacePortador"){
		recordRed = bmql("select Technology, Priority from FeasibilityPriority where  Sitesize = $capacity AND Technology  in $techTypeR");
	}
	if(productType == "Internet Legacy"){
		recordRed = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeR AND Type = 'Internet Legacy'");		
	}
	if(productType == "MPLS and VPLS Legacy"){
		recordRed = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeR AND Type = 'MPLS and VPLS Legacy'");		
	}
	if(productType == "Legacy Avalon"){
		recordRed = bmql("select Technology, Priority from FeasibilityPriority where Technology  in $techTypeR AND Type = 'Legacy Avalon'");		
	}
}

for each in recordRed{
	if(get(each, "Priority") <> "0" AND productType == "enlacePortador"){
		put(headDict3,get(each, "Priority"), get(each, "Technology"));
		append(redTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Internet Legacy" OR productType == "MPLS and VPLS Legacy"){
		put(headDict3,get(each, "Priority"), get(each, "Technology"));
		append(redTechnologyArray,get(each, "Priority"));
	}
	elif(productType == "Legacy Avalon"){
		put(headDict3,get(each, "Priority"), get(each, "Technology"));
			append(redTechnologyArray,get(each, "Priority"));
	}else{
		if(containskey(headDict3, get(each, "Priority")) == false) {
			put(headDict3,get(each, "Priority"), get(each, "Technology"));
			append(redTechnologyArray,get(each, "Priority"));
		}else{
			//For Remaining Zero priority technologies.
			append(headArray3, get(each, "Technology")); 
		}
	}
}

//keyR= sort(keys(headDict3), "desc");
keyR= sort(keys(headDict3));
keyR = redTechnologyArray;

for each in keyR {	
	//if(atoi(each) <> 0){
		technologyR[R]=get(headDict3,each); 
	//}
	R = R + 1;
}

for each1 in headArray3{
	technologyR[R]=each1;
	R = R + 1;
}

//Preparing final result string for populating table3.
finalStringB = ""; 
finalStringG = "";

for each in technologyB{
	finalStringB = finalStringB + siteinfoID + "##" + each + "##" + "B" + "##" + get(caOpDict,each) + "$$";
}
for each in technologyG{
	finalStringG = finalStringG + siteinfoID + "##" + each + "##" + "G" + "##" + get(caOpDict,each) + "$$";
}
for each in technologyA{
	finalStringA = finalStringA + siteinfoID + "##" + each + "##" + "A" + "##" + get(caOpDict,each) + "$$";
}
for each in technologyR{
	finalStringR = finalStringR + siteinfoID + "##" + each + "##" + "R" + "##" + get(caOpDict,each) + "$$";
}

//BLUE
if(i == 1){
	finalString = finalString + techArray[0];
}
elif(i >=2){
	finalString = finalString + finalStringB;
}

//GREEN
if(j == 1){
	finalString = finalString + techArray[1];
}
elif(j >= 2){
	finalString = finalString + finalStringG;
}

//AMBER
if(m == 1){
	finalString = finalString + techArray[2];
}
elif(m >= 2){
	finalString = finalString + finalStringA;
}

//RED
if(n == 1){
	finalString = finalString + techArray[3];
}
elif(n >= 2){
	finalString = finalString + finalStringR;
}

//$$@@2016-11-20@@Aut-000029034@@CFTREQ2";

/*if(productType == "IPVPN" AND requestType == "Backup" AND finalString <> ""){
	finalString = finalString + techArray[2] + techArray[3];
	//print "Enter";
	priorityArray = split(finalString, "$$");
	for each in priorityArray{
		if(each <> "" AND not(isnull(each))){
			//print prioCnt; //print each;
			if(prioCnt == 1){
				backupTech =  each;
			}elif(finalStringforBackup == ""){
				finalStringforBackup = each + "$$";
			}else{
				finalStringforBackup = finalStringforBackup + each + "$$";
			}
			prioCnt  = prioCnt + 1;
		}
	}
	finalString = backupTech + "$$" + finalStringforBackup + "@@" + util.getIndexedValue(responseXML, "@@", 1) + "@@" + util.getIndexedValue(responseXML, "@@", 2) + "@@" + util.getIndexedValue(responseXML, "@@", 3);
}else{
	finalString = finalString + techArray[2] + techArray[3] + "@@" + util.getIndexedValue(responseXML, "@@", 1) + "@@" + util.getIndexedValue(responseXML, "@@", 2) + "@@" + util.getIndexedValue(responseXML, "@@", 3);
}*/

//finalString = finalString + techArray[2] + techArray[3] + "@@" + util.getIndexedValue(responseXML, "@@", 1) + "@@" + util.getIndexedValue(responseXML, "@@", 2) + "@@" + util.getIndexedValue(responseXML, "@@", 3);

finalString = finalString + "@@" + util.getIndexedValue(responseXML, "@@", 1) + "@@" + util.getIndexedValue(responseXML, "@@", 2) + "@@" + util.getIndexedValue(responseXML, "@@", 3) + "@@";

return finalString;