MFTNEBA = "";
perfil="";
Zona="";
serviceArray="";
tchnologyNEBA="";
productName="";

INTERNETService="";
VLANService="";
IPVPNService="";
CoSService="";

returnString = "";
records = BMQL("select Value from CPQVariables where AttributeName = 'MFTNEBA' and VariableName = 'MFTNEBA' ");

for recordsEach in records
{
	MFTNEBA = get(recordsEach,"Value");
}

	if(MFTNEBA == "TRUE")
	{
		if(siteInformationStringfromcommerce_ES <> "" AND cFTParseResponse_quote <> "")
		{
			filteredResponseSplit = split(siteInformationStringfromcommerce_ES,"##");
			cFTParseResponse = split(cFTParseResponse_quote,"$,$");
			
			
					requestNumber="";


					siteinfoSplit = split(siteInformationStringfromcommerce_ES,"##");
					for siteinfoSplitEach in siteinfoSplit
					{
						if(NOT(ISNULL(siteinfoSplitEach)) AND siteinfoSplitEach<>"")
						{
							if(util.getIndexedValue(siteinfoSplitEach, "$$", 0)=="iPVPN")
							{
								requestNumber = util.getIndexedValue(siteinfoSplitEach, "$$", 19);
								tchnologyNEBA = util.getIndexedValue(siteinfoSplitEach, "$$", 13);
								productName = "iPVPN";
								if(util.getIndexedValue(siteinfoSplitEach, "$$", 3)=="Y")
								{
									INTERNETService="1";
								}
								else{
									INTERNETService="0";
								}
								if(util.getIndexedValue(siteinfoSplitEach, "$$", 4)=="Y")
								{
									VLANService="1";
								}
								else{
									VLANService="0";
								}
								if(util.getIndexedValue(siteinfoSplitEach, "$$", 5)=="Y")
								{
									IPVPNService="1";
								}
								else{
									IPVPNService="0";
								}
								if(util.getIndexedValue(siteinfoSplitEach, "$$", 6)=="Y")
								{
									CoSService="1";
								}
								else{
									CoSService="0";
								}
								
							}
							elif(util.getIndexedValue(siteinfoSplitEach, "$$", 0)=="legacyProductVPNAvalon")
							{
								requestNumber = util.getIndexedValue(siteinfoSplitEach, "$$", 12);
								tchnologyNEBA = util.getIndexedValue(siteinfoSplitEach, "$$", 6);
								productName = "legacyProductVPNAvalon";
							}
							elif(util.getIndexedValue(siteinfoSplitEach, "$$", 0)=="legacyProductAccesoInternetONOAndVodafone")
							{
								requestNumber = util.getIndexedValue(siteinfoSplitEach, "$$", 14);
								tchnologyNEBA = util.getIndexedValue(siteinfoSplitEach, "$$", 8);
								productName = "legacyProductAccesoInternetONOAndVodafone";
							}	
							
					
				
					for cftString in cFTParseResponse
					{
						cFTParseResponseSplit = split(cftString,"##");
						cFTParseResponseSplitRequestID = split(cftString,"@@");
						if(NOT(ISNULL(requestNumber)) AND NOT(ISNULL(cFTParseResponseSplitRequestID[3])))
						{
							if(requestNumber==cFTParseResponseSplitRequestID[3])
							{
								for cFTParseResponseSplitEach in cFTParseResponseSplit
								{
									//checking perfil key in CFTresponse's technical parameter and getting its value
									if(find(cFTParseResponseSplitEach,"perfil")>-1)
									{
										splitPerfil = split(cFTParseResponseSplitEach,"!!");
										perfil = splitPerfil[0];
									}
									//checking zona key in CFTresponse's technical parameter and getting its value
									if(find(cFTParseResponseSplitEach,"Zona")>-1)
									{
										splitPerfil = split(cFTParseResponseSplitEach,"!!");
										Zona = splitPerfil[0];
									}
						
								}
								
								
								
								
								serviceArray="0000"+INTERNETService+VLANService+IPVPNService+CoSService;
								
								
								returnString = returnString+perfil+"!!"+Zona+"!!"+tchnologyNEBA+"!!"+productName+"!!"+serviceArray+"!!"+requestNumber+"##";
							}
						}
					}
				}	
			}
	}
}

return returnString;
//return "VDSL!!AC_FIB_NEBA_22M/8M QoS!!NEBA FTTH!!legacyProductAccesoInternetONOAndVodafone!!00001000!!CFTREQ1####";