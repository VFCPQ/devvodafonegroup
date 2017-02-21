
/**
 * @param dependencies {Array} name of modules this code depends on. Can exclude ".js"
 * @param callback {Function} function containing this module's functionality.
 * @version Wed Aug 19 16:33:00 2015
 */


 
require([], function() {
  /*
   * Put all functions for sitewide context here
   */

  //this function runs when the page loads
  require.ready(function() {
	  
		if ($("#cftFeasiblilty input:checkbox:checked").length > 0){
		}
		else{
			$("#selectedSitesInformation_quote").val('');
		}

		//Added for NEBA BREQ057
		$("#perfileDescripion_ES").change(function() {
			$("#perfileDescripionText_ES").val($('#perfileDescripion_ES :selected').text());
		});
	
		
		//Disable modified checkbox
		jQuery("td[id*='modifyCostFlag_line_ES'] input[type=checkbox]").attr('disabled','true');	
		jQuery("td[id*='bulkDiscountFlag_line'] input[type=checkbox]").attr('disabled','true');
		  
		/*Freeze Code Start here*/
		usageValue = jQuery("[name='usageSME_quote']").val();
		contractType = jQuery("[name='quoteType_quote']").val();
		SMESpecificOutcome1 = jQuery("[name='ruleCondition_quote']").val();
		//Added by Chandan to fix 1675
		quoteStatus = jQuery("[name='quoteStatus_quote']").val();
		if(quoteStatus == "Approved"){
			jQuery("td[id='selectall2'] input[type=checkbox]").attr('disabled','true');
		}
		//Defect 1675
		//Code For SME Defect
		if(usageValue != "Call Profile" && contractType == "New" && SMESpecificOutcome1=="SME Condition"){
			 $('#upload_file').closest("table").hide();
		 }
		 else{
		    $('#upload_file').closest("table").show();   
		 }
		if(SMESpecificOutcome1=="SME Condition"){
		$("#tab5625971").closest("table").hide();
		$("#tab5625971").hide();
		$("#tab5584788").hide();
		$('#reasons_for_bespoke_contract').closest("table").hide();
		$('#generate_contract_support_request').closest("table").hide();
		$('#generate_order_form').closest("table").hide();
		$("#generate_proposal").closest("table").hide();
		$('#generate_proposal_\\(rtf\\)').hide();
		$('#generate_proposal_(rtf)').hide();
		$("#proposalTitle_quote").closest("table").hide();
		$("#annexure_ES_quote").closest("table").hide();
		$('#generate_proposal_\\(rtf\\)').closest("table").hide();
		$('#create_contract_\\(pdf\\)').closest("table").hide();
		$('#create_contract_\\(rtf\\)').closest("table").hide();
		$('#quote_summary').closest("table").hide();
		$('#create_contract_1sf').closest("table").hide();
		$('#connect_quote_to_1sf').closest("table").hide();
		$('#create_psn_contract1\\(pdf\\)').closest("table").hide();
		$('#create_contract').closest("table").hide();
		$('#create_contract').closest("table").hide();
		$('#create_contract_\\(\\pdf)').closest("table").hide();
		$('#reasons_for_bespoke_contract').closest("table").hide();
		$('#generate_contract_support_request').closest("table").hide();
		}
		else{
			$('#attach_contract_to_opportunity\\.').closest("table").hide();
			$('#generate_order_form_sme').closest("table").hide();
			$('#generate_contract_\\(pdf\\)').closest("table").hide();
			$('#export_account_summary_excel').closest("table").hide();
			
			}
		//Hide for timebeing dont know what is the reason
		// $('#field_wrapper_1_quoteType_quote select').on("change", function(){
			// $('#pagerefreshforapproval').click();
		// });
		
		$('#field_wrapper_1_usageSME_quote select').on("change", function(){
			$('#pagerefreshforapproval').click();
		});
		
		app_handle_listing_horisontal_scroll();
		//Table 3 Body
		$('#fixed_hdr2 td').css( "word-wrap", "break-word");
		$('#fixed_hdr2 td').css( "overflow", "hidden");
		$('#fixed_hdr2 th').css( "word-wrap", "break-word");
		$('#fixed_hdr2 th').css( "overflow", "hidden");
		$('#fixed_hdr2').css( "table-layout", "fixed");
		$('#fixed_hdr2').css( "width", "100%");
		//Table 4 Body
		$('#fixed_hdr3 td').css( "word-wrap", "break-word");
		$('#fixed_hdr3 td').css( "overflow", "hidden");
		$('#fixed_hdr3 th').css( "word-wrap", "break-word");
		$('#fixed_hdr3 th').css( "overflow", "hidden");
		$('#fixed_hdr3').css( "table-layout", "fixed");
		$('#fixed_hdr3').css( "width", "100%");
		//Table 3 Header
		//$('#siteConfigurationForEP tr').remove();
		$('#siteConfigurationForEP td').css( "word-wrap", "break-word");
		$('#siteConfigurationForEP td').css( "overflow", "hidden");
		$('#siteConfigurationForEP th').css( "word-wrap", "break-word");
		$('#siteConfigurationForEP th').css( "overflow", "hidden");
		//Table 4 Header
		$('#cftManualResponse td').css( "word-wrap", "break-word");
		$('#cftManualResponse td').css( "overflow", "hidden");
		$('#cftManualResponse th').css( "word-wrap", "break-word");
		$('#cftManualResponse th').css( "overflow", "hidden");
		$(".ft_r").each(function(i) {
			$(this).css( "table-layout", "fixed");
			$(this).css( "width", "100%");
		});
		
		//line item grid header freeze
		/*$('#line-item-grid thead tr').css( "display", "block");
		$('#line-item-grid th').css( "word-wrap", "break-word");
		$('#line-item-grid td').css( "word-wrap", "break-word");
		$('#line-item-grid tbody').css( "display", "block");
		$('#line-item-grid tbody').css( "max-height", "200px");                  
		$('#line-item-grid tbody').css( "overflow-y", "auto");
		$('#line-item-grid tbody').css( "overflow-x", "auto");*/

		$("#showColumns_quote4").parent().html("");
		
		/***********START LOAD SITES ******************/
		//Code for select All
		$('#selecctall').click(function(event) {  //on click
			if(this.checked) { // check select status
				$(".sitename .checkbox1").prop("checked", true).trigger("change");
			}else{
				$(".sitename .checkbox1").prop("checked", false).trigger("change");
			}
		});
		
		//Code for select All
		$('#selectAll5').click(function(event) {  //on click
			if(this.checked) { // check select status
				$(".sitename5 .checkbox5").prop("checked", true).trigger("change");
			}else{
				$(".sitename5 .checkbox5").prop("checked", false).trigger("change");
			}
		});
		
		//Code for select All
		$('#selectAll6').click(function(event) {  //on click
			if(this.checked) { // check select status
				$(".sitename6 .checkbox6").prop("checked", true).trigger("change");
			}else{
				$(".sitename6 .checkbox6").prop("checked", false).trigger("change");
			}
		});
		
		//alternate row colors for load site details
		$("#cftFeasiblilty tr:even").css("background-color", "#eeeeee");
		$("#cftFeasiblilty tr:odd").css("background-color", "#ffffff");
		
		//Code for getting selected sites
		$("#cftFeasiblilty input[type=checkbox]").on("change",function(){
			var siteSize = [];
			
			if($(this).prop("checked")) {
				//Check code start here
				var selectedValue = $(this).val();
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				
				//Get existing site details value
				siteDetails = $("#selectedSitesInformation_quote").val();
				
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
			
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				
				//Assign selected site details string to quote level attribute.
				$("#selectedSitesInformation_quote").val(siteDetails);	
				
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = "";
				
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
				siteDetails = $("#selectedSitesInformation_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				$("#selectedSitesInformation_quote").val(ss);	

			}
		});
		/***********END LOAD SITES ******************/
		
		/*************VAT ID CODE START @aditi*********************/
		//Code for select All
		$('#selectall2').click(function(event) {  //on click
			if(this.checked) { // check select status
				//$('.checkbox1').each(function() { //loop through each checkbox
					$(".IDnumber .checkbox2").prop("checked", true).trigger("change");
				//});
			}else{
				//$('.checkbox1').each(function() { //loop through each checkbox
					$(".IDnumber .checkbox2").prop("checked", false).trigger("change");
				//});        
			}
			
		});
		
		//alternate row colors for load IdValue details
		$("#VATID tr:even").css("background-color", "#eeeeee");
		$("#VATID tr:odd").css("background-color", "#ffffff");
		
		//Code for getting selected sites
		$("#VATID input[type=checkbox]").on("change",function(){
			var IdSize = [];
				
			if( $( this ).prop( "checked" ) ) {
				var siteID = "";
				var IdDetails = "";    
				var IdValue = "";
				
				//Get existing IdValue details value
				IdDetails = $("#vATIDNew_quote").val();
				
				//Get IdValue and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				
				IdValue = siteID;
				
				//Check if IdValue is exist in array if not then push IdValue in array
				res = $.inArray(IdValue, IdSize);
				if(res == -1) {
					IdSize.push(IdValue);
				}
				
				//Traverse array and make string
				$.each(IdSize, function() {
					if(IdDetails != "") {
						IdDetails = IdDetails + "##" + this;
					}
					else {
						IdDetails = this;
					}
				});
				
				//Assign selected IdValue details string to quote level attribute.
				$("#vATIDNew_quote").val(IdDetails);	
			}	
			else {
				//Uncheck code start here
				var IdValue = "";
				var ss = "";
				
				//Get IdValue and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				
				IdValue = siteID;
				
				IdDetails = $("#vATIDNew_quote").val();
				
				if(IdDetails != "") {
					IdSize = IdDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				IdSize = $.grep(IdSize, function(value) {
					return value != IdValue;
				});
				
				//Prepare string and store in attribute.
				$.each(IdSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				$("#vATIDNew_quote").val(ss);	
			}
			
		});
		
		// Hide Quote life cycle clear call action for all user
		
		$("#quotelifecycleclearcall").parent().parent().parent().parent().parent().hide();
		
		//---------------------------------------------------------------------------------
		
		
		/*************VAT ID CODE END @aditi*********************/
		/***********START GET CFT REQUEST PARAMETERS FOR SITES ******************/
		//Code for select All
		$('#selecctAllRequest').click(function(event) {  //on click
			if(this.checked) { // check select status
				$(".sitename2 .checkbox2").prop("checked", true).trigger("change");
			}else{
				$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
			}
		});
		
		//alternate row colors for Request site details
		$("#cftRequestSites tr:even").css("background-color", "#eeeeee");
		$("#cftRequestSites tr:odd").css("background-color", "#ffffff");
		
		//Code for getting selected sites
		//$('input[type=checkbox]:not("#selectall")').click(function() {
		$('#cftRequestSites input[type=checkbox]:not(#selectAll6)').on("change",function(){
			var siteSize = [];
			var siteDetails = ""; 
			
			if( $( this ).prop( "checked" ) ) {
				//Check code start here
				var selectedValue = $(this).val();
				//alert(selectedValue);
				
				var siteID = "";
				var siteDetails = ""; 
				var selectedSiteDetails = "";
				var site = "";
				
				//Get existing site details value
				siteDetails = $("#cFTRequestParameter_quote").val();
				selectedSiteDetails = $("#cFTAllSelectedRequestParameters_quote").val();
				
				//Get site and Address from html and prepared string
				requestID = selectedValue;
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				internet = $(this).closest('tr').find('td:eq(3)').text();
				ipvpn = $(this).closest('tr').find('td:eq(4)').text();
				vlan = $(this).closest('tr').find('td:eq(5)').text();
				voip = $(this).closest('tr').find('td:eq(6)').text();
				monitor = $(this).closest('tr').find('td:eq(7)').text();
				sla = $(this).closest('tr').find('td:eq(8)').text();
				cpeSalesModePrimary = $(this).closest('tr').find('td:eq(9)').text();
				cpeSalesTypePrimary = $(this).closest('tr').find('td:eq(10)').text();
				siteSizePrimary = $(this).closest('tr').find('td:eq(11)').text();
				modeOfAccessPrimary = $(this).closest('tr').find('td:eq(12)').text();
				backupRequired = $(this).closest('tr').find('td:eq(13)').text();
				siteSizeSecondary = $(this).closest('tr').find('td:eq(14)').text();
				modeOfAccessSecondary = $(this).closest('tr').find('td:eq(15)').text();
				cpeSalesModeBackup = $(this).closest('tr').find('td:eq(16)').text();
				cpeSalesTypeBackup = $(this).closest('tr').find('td:eq(17)').text();
				siteType = $(this).closest('tr').find('td:eq(18)').text();
				refereceKey = $(this).closest('tr').find('td:eq(19)').text();
				
				site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" + monitor + "$$" + sla + "$$" + cpeSalesModePrimary + "$$" + cpeSalesTypePrimary + "$$" + siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + backupRequired + "$$" + siteSizeSecondary + "$$" + modeOfAccessSecondary + "$$" + cpeSalesModeBackup + "$$" + cpeSalesTypeBackup + "$$" + siteType + "$$" + refereceKey;
				
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				// Store selected site request from table2. 
				$("#cFTRequestForSingleSite_quote").val(site);
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(selectedSiteDetails != "") {
						selectedSiteDetails = selectedSiteDetails + "##" + this;
					}
					else {
						selectedSiteDetails = this;
					}
				});
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				
				//Assign selected site details string to quote level attribute.
				$("#cFTRequestParameter_quote").val(siteDetails);	
				$("#cFTAllSelectedRequestParameters_quote").val(selectedSiteDetails);
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = ""; var ss1 = "";
				var selectedValue = $(this).val();
				
				//Get site and Address from html and prepared string
				requestID = selectedValue;
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				internet = $(this).closest('tr').find('td:eq(3)').text();
				ipvpn = $(this).closest('tr').find('td:eq(4)').text();
				vlan = $(this).closest('tr').find('td:eq(5)').text();
				voip = $(this).closest('tr').find('td:eq(6)').text();
				monitor = $(this).closest('tr').find('td:eq(7)').text();
				sla = $(this).closest('tr').find('td:eq(8)').text();
				cpeSalesModePrimary = $(this).closest('tr').find('td:eq(9)').text();
				cpeSalesTypePrimary = $(this).closest('tr').find('td:eq(10)').text();
				siteSizePrimary = $(this).closest('tr').find('td:eq(11)').text();
				modeOfAccessPrimary = $(this).closest('tr').find('td:eq(12)').text();
				backupRequired = $(this).closest('tr').find('td:eq(13)').text();
				siteSizeSecondary = $(this).closest('tr').find('td:eq(14)').text();
				modeOfAccessSecondary = $(this).closest('tr').find('td:eq(15)').text();
				cpeSalesModeBackup = $(this).closest('tr').find('td:eq(16)').text();
				cpeSalesTypeBackup = $(this).closest('tr').find('td:eq(17)').text();
				siteType = $(this).closest('tr').find('td:eq(18)').text();
				refereceKey = $(this).closest('tr').find('td:eq(19)').text();
				
				site = requestID + "$$" + siteID + "$$" + siteAddress  + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" + monitor + "$$" + sla + "$$" + cpeSalesModePrimary + "$$" + cpeSalesTypePrimary + "$$" + siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + backupRequired + "$$" + siteSizeSecondary + "$$" + modeOfAccessSecondary + "$$" + cpeSalesModeBackup + "$$" + cpeSalesTypeBackup  + "$$" + siteType + "$$" + refereceKey;
				
				//Empty selected site request.

				$("#cFTRequestForSingleSite_quote").val("");
				
				siteDetails = $("#cFTRequestParameter_quote").val();
				AllSiteDetails = $("#cFTAllSelectedRequestParameters_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				if(AllSiteDetails != "") {
					AllSiteSize = AllSiteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Remove unchecked element from selected sites array.
				AllSiteSize = $.grep(AllSiteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				//Prepare string and store in attribute.
				$.each(AllSiteSize, function() {
					if(ss1 != "") {
						ss1 = ss1 + "##" + this;
					} else {
						ss1 = this;
					}
				});
				
				$("#cFTRequestParameter_quote").val(ss);
				$("#cFTAllSelectedRequestParameters_quote").val(ss1);				
			}
		});
		/***********END GET CFT REQUEST PARAMETERS FOR SITES ******************/
		
		
		//alternate row colors for Request site details
		$("#siteConfiguration tr:even").css("background-color", "#eeeeee");
		$("#siteConfiguration tr:odd").css("background-color", "#ffffff");
		
		/***********START GET CFT RESPONSE FOR SITE CONFIGURATION**************/
		$("#siteConfiguration input[type=radio]").on("change",function() {
			var siteSize = [];
			if( $( this ).prop( "checked" ) ) {
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				
				//Get site and Address from html and prepared string
				
				selectedRow = $(this).closest('tr').find('td').find('input').val();
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				configurationStatus = $(this).closest('tr').find('td:eq(2)').text();
				siteName = $(this).closest('tr').find('td:eq(3)').text();
				siteAddress = $(this).closest('tr').find('td:eq(4)').text();
				primaryAccess = $(this).closest('tr').find('td:eq(5)').text();
				primaryRAG = $(this).closest('tr').find('td:eq(6)').text();
				//secondaryAccess = $(this).closest('tr').find('td:eq(7)').text();
				//secondaryRAG = $(this).closest('tr').find('td:eq(8)').text();
				feasibilityExpiryDate = $(this).closest('tr').find('td:eq(7)').text();
				feasibilityStatus = $(this).closest('tr').find('td:eq(8)').text();
				
				//Get existing site details valuek8
				userGroup = $("#1_currentUserGroup_quote").val();
				
				site = siteID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG;
				
				if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
					feasibilityStatus = $(this).closest('tr').find('td:eq(11)').text();
					
					CapEx = $(this).closest('tr').find('td:eq(8)').text();
					Initial_OpEx = $(this).closest('tr').find('td:eq(9)').text();
					Recurring_OpEx = $(this).closest('tr').find('td:eq(10)').text();
					site = site + "$$" + CapEx + "$$" + Initial_OpEx + "$$" + Recurring_OpEx + "$$" + feasibilityStatus; 
				} else {
					site = site + "$$" + feasibilityStatus; 
				}
				
				//CFT Response For Single site.
				$('#cFTResponseSelectedRowID_quote').val('');
				$('#cFTResponseSelectedRowID_quote').val(selectedRow);
				
				$('#cFTResponseForSingleSite_quote').val('');
				
				//GET Access Technology for manual feasibility
				$("#primaryAccessForTES_quote").val('');
				$("#primaryAccessForTES_quote").val(primaryAccess);
				
				//Assign selected site details string to quote level attribute.
				$("#cFTResponseForSingleSite_quote").val(site);	
			}	
			else {
				//Uncheck code start here
				$('#cFTResponseForSingleSite_quote').val('');
				$('#cFTResponseSelectedRowID_quote').val('');
			}
		});
		/***********END GET CFT RESPONSE FOR SITE CONFIGURATION**************/	
		
		//Hide Page Refresh for Approval Action on commerce page.
		$('#pagerefreshforapproval').parents('table').eq(0).hide();
		$('#approvalconfirmclear_quote').parents('table').eq(0).hide();
		
		/******Code for Approval confirm checkbox trigger Save and Price****************************/
		$('#field_wrapper_1_approvalConfirm_quote input[type="checkbox"]').change(function() {
			if($(this).is(":checked")) {
			   //$('#save_and_price').click();
			   $('#pagerefreshforapproval').click();
			}else{
			   $('#approvalconfirmclear_quote').click();
			}
		});
		
		/******Code for Rejection reasons trigger Save and Price ****************************/
		$('#field_wrapper_1_rejectionReasons_quote input[type="checkbox"]').change(function() {
			if($(this).is(":checked")) {
			   //$('#save_and_price').click();
			   $('#pagerefreshforapproval').click();
			}else{
			   $('#approvalconfirmclear_quote').click();
			}
		});
		/******End Code for Rejection reasons trigger Save and Price ****************************/
		
		/******Code for Massive Discount flag checkbox trigger Save and Price****************************/
		 $('#field_wrapper_1_applyBulkDiscoutForFixedProduct_ES input[type="checkbox"]').change(function() {
				if($(this).is(":checked")) {
					 $('#save_and_price').click();
					 $('#save_and_price').click();
						
				}else{
					 $('#save_and_price').click();
					 $('#save_and_price').click();
				}
		 });
		 
		
        /******End Code for Massive Discount flag checkbox trigger Save and Price ****************************/								

		
		//Set value of selected product
		var prdSelected = $(".select-product-es select").val();
		$('#selectedProduct_ES_quote').val(prdSelected);
		
		/******Code Start for SIP Telephony & One Net IP Trunk & One net oneNetCloudContactCentre ****************************/
		//Hide Actions attr_wrapper_1_selectProductES_quote
			
		$(".select-product-es select").live('click', function() {
			
			var prd = $(this).val();
			$('#selectedProduct_ES_quote').val(prd);
			
			//this if is added for defect 0346 by Ravi Yelhekar
			if((prd == "legacyProductAccesoInternetONOAndVodafone" || prd == "iPVPN") && $("#1_currentUserGroup_quote").val() == "accountManager_ES")
			//if($("#1_currentUserGroup_quote").val() == "accountManager_ES")
			{
				$('#add_to_services').parents('table').eq(0).hide();
				$('#aadir_servicios').parents('table').eq(0).hide();
				$('#aadir_servicios').parents('div').eq(1).hide();
				$('#add_to_services').parents('div').eq(0).hide();
				$('#aadir_servicios').parents('div').eq(0).hide();
				$('#clear_services').parents('table').eq(0).hide();
				$('#limpiar_servicios').parents('table').eq(0).hide();
				$('#clear_services').parents('div').eq(0).hide();
				$('#limpiar_servicios').parents('div').eq(0).hide();
			}
			
			if(prd == "sIPTelephony" || prd == "oneNetCloudContactCentre" || prd == "oneNetCollaborationForLync"  || prd == "legacyProductExtraServices" || prd == "Bespoke" || prd == "iPPBX") {
				
				//Clear the previous selected site selection.
				$('#siteSelectionForSIP_ES_quote').val('');
				
				//alert(prd);
				//alert("Inside first Fixed product if"); // added1
				$('#add_primary_tariff').parents('div').eq(1).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#add_sites_for_feasibility_request').parents('div').eq(1).hide(); 
				//$('#anadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#run_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad').parents('div').eq(1).hide();
				$('#load_sites').parents('div').eq(1).show();
				$('#cargar_sedes').parents('div').eq(1).show();
				$('#configure_site').parents('div').eq(0).show();
				$('#configurar_sedes').parents('div').eq(0).show();
				$('#configure_site').parents('table').eq(0).show();
				$('#configurar_sedes').parents('table').eq(0).show();
				$('#perform_manual_feasibility').parents('div').eq(1).hide();
				$('#submit_additional_info').parents('div').eq(1).hide();
				$('#reclaim_feasibility_request').parents('div').eq(1).hide();
				$('#cancel_feasibility_request').parents('div').eq(1).hide();
				$('#cancelar_solicitud_viabilidad').parents('div').eq(1).hide();
				$('#validate_feasibility_request').parents('div').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('div').eq(0).hide();
				$('#validate_feasibility_request').parents('table').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('table').eq(0).hide();
				$('#run_manual_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad_manual').parents('div').eq(1).hide();
				// temporary commented 'get_manual_feasibility_response' to implement stub @Chetan 15-02-2017
				//$('#get_manual_feasibility_response').parents('table').eq(0).hide();
				//$('#get_manual_feasibility_response').parents('div').eq(0).hide();
				
				$('#add_to_services').parents('table').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
				$('#add_to_services').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).hide();
				$('#clear_services').parents('table').eq(0).hide();
				$('#limpiar_servicios').parents('table').eq(0).hide();
				$('#clear_services').parents('div').eq(0).hide();
				$('#limpiar_servicios').parents('div').eq(0).hide();
				
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
				$('#ejecutar_viabilidad_manual').parents('table').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
				$('#export_manual_feasibility_result').parents('table').eq(0).hide();
				$('#export_manual_feasibility_result').parents('div').eq(0).hide
				$('#aadir_servicios').parents('table').eq(0).hide();
				$('#aadir_servicios').parents('div').eq(1).hide();
				$('#aadir_servicios').parents('div').eq(0).hide();
				//$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
				//$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
			}
			
		
			if(prd == "iPVPN" || prd == "enlacePortador" || prd == "legacyProductMPLSAndVPLSONO" || prd == "legacyProductAccesoInternetONOAndVodafone" || prd == "legacyProductVPNAvalon" || prd == "primarioMvil" || prd == "primarioFijo"){
				//alert("Called");
				//alert(prd);
				//alert("Inside leagacy  product if"); // added2
				$('#add_primary_tariff').parents('div').eq(1).hide();
				$('#load_sites').parents('div').eq(1).show();
				$('#cargar_sedes').parents('div').eq(1).show();
				$('#add_sites_for_feasibility_request').parents('div').eq(1).show();
				//$('#anadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).show();
				$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).show();				
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).show();				
				$('#run_feasibility').parents('div').eq(1).show();
				$('#ejecutar_viabilidad').parents('div').eq(1).show();
				$('#configure_site').parents('div').eq(0).show();
				$('#configurar_sedes').parents('div').eq(0).show();
				$('#configure_site').parents('table').eq(0).show();
				$('#configurar_sedes').parents('table').eq(0).show();
				$('#perform_manual_feasibility').parents('div').eq(1).show();
				$('#submit_additional_info').parents('div').eq(1).show();
				$('#reclaim_feasibility_request').parents('div').eq(1).show();
				$('#cancel_feasibility_request').parents('div').eq(1).show();
				$('#cancelar_solicitud_viabilidad').parents('div').eq(1).show();
				$('#validate_feasibility_request').parents('table').eq(0).show();
				$('#validar_solicitud_viabilidad').parents('table').eq(0).show();
				$('#validate_feasibility_request').parents('div').eq(0).show();
				$('#validar_solicitud_viabilidad').parents('div').eq(0).show();
				$('#run_manual_feasibility').parents('div').eq(1).show();
				$('#ejecutar_viabilidad_manual').parents('div').eq(1).show();
				$('#get_manual_feasibility_response').parents('table').eq(0).show();
				$('#get_manual_feasibility_response').parents('div').eq(0).show();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).show();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).show();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).show();
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(1).show();
				
				if((prd == "legacyProductAccesoInternetONOAndVodafone" || prd == "iPVPN") && $("#1_currentUserGroup_quote").val() != "accountManager_ES")
				{
					$('#add_primary_tariff').parents('div').eq(1).hide();
					$('#add_to_services').parents('table').eq(0).show();
					$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).show();
					$('#add_to_services').parents('div').eq(0).show();
					$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).show();
					$('#clear_services').parents('table').eq(0).show();
					$('#limpiar_servicios').parents('table').eq(0).show();
					$('#clear_services').parents('div').eq(0).show();
					$('#limpiar_servicios').parents('div').eq(0).show();
				}
				// else{
					
					// $('#add_to_services').parents('table').eq(0).show();
					// $('#adir_servicios').parents('table').eq(0).show();
					// $('#add_to_services').parents('div').eq(0).show();
					// $('#aadir_servicios').parents('div').eq(0).show();
					// $('#clear_services').parents('table').eq(0).show();
					// $('#limpiar_servicios').parents('table').eq(0).show();
					// $('#clear_services').parents('div').eq(0).show();
					// $('#limpiar_servicios').parents('div').eq(0).show();
					
				// }
				
				
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).show();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).show();
				$('#ejecutar_viabilidad_manual').parents('table').eq(0).show();
			}
			// added code on 01/09/2016
			if(prd == "" || prd == "none"){
			//alert(prd);
				//alert(prd);
				//alert("inside second none"); // added2
				$('#add_primary_tariff').parents('div').eq(1).hide();
				$('#load_sites').parents('div').eq(1).hide();
				
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				
				$('#cargar_sedes').parents('div').eq(1).hide();
				$('#add_sites_for_feasibility_request').parents('div').eq(1).hide();
				//$('#anadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).hide();
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
				$('#run_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad').parents('div').eq(1).hide();
				//$('#configure_site').parents('div').eq(1).hide();
				$('#configure_site').parents('div').eq(0).hide();
				$('#configurar_sedes').parents('div').eq(0).hide();
				$('#configure_site').parents('table').eq(0).hide();
				$('#configurar_sedes').parents('table').eq(0).hide();
				$('#perform_manual_feasibility').parents('div').eq(1).hide();
				$('#submit_additional_info').parents('div').eq(1).hide();
				$('#reclaim_feasibility_request').parents('div').eq(1).hide();
				$('#cancel_feasibility_request').parents('div').eq(1).hide();
				$('#cancelar_solicitud_viabilidad').parents('div').eq(1).hide();
				//Beacuse in same action strip
				$('#validate_feasibility_request').parents('table').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('table').eq(0).hide();
				$('#validate_feasibility_request').parents('div').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('div').eq(0).hide();
				$('#run_manual_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad_manual').parents('div').eq(1).hide();
				//Beacuse in same action strip
				// temporary commented 'get_manual_feasibility_response' to implement stub @Chetan 15-02-2017
				//$('#get_manual_feasibility_response').parents('table').eq(0).hide();
				//$('#get_manual_feasibility_response').parents('div').eq(0).hide();
				
				$('#add_to_services').parents('table').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
				$('#add_to_services').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).hide();
				$('#clear_services').parents('table').eq(0).hide();
				$('#limpiar_servicios').parents('table').eq(0).hide();
				$('#clear_services').parents('div').eq(0).hide();
				$('#limpiar_servicios').parents('div').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
				$('#export_manual_feasibility_result').parents('table').eq(0).hide();
				$('#export_manual_feasibility_result').parents('div').eq(0).hide();
				$('#aadir_servicios').parents('table').eq(0).hide();
				$('#aadir_servicios').parents('div').eq(1).hide();
				$('#aadir_servicios').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			}
			if(prd == "oneNetIPTrunk"){
				$('#add_primary_tariff').parents('div').eq(1).show();
				$('#load_sites').parents('div').eq(1).hide();
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#cargar_sedes').parents('div').eq(1).hide();
				$('#add_sites_for_feasibility_request').parents('div').eq(1).hide();
				//$('#anadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).hide();
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
				$('#run_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad').parents('div').eq(1).hide();
				//$('#configure_site').parents('div').eq(1).hide();
				$('#configure_site').parents('div').eq(0).hide();
				$('#configurar_sedes').parents('div').eq(0).hide();
				$('#configure_site').parents('table').eq(0).hide();
				$('#configurar_sedes').parents('table').eq(0).hide();
				$('#perform_manual_feasibility').parents('div').eq(1).hide();
				$('#submit_additional_info').parents('div').eq(1).hide();
				$('#reclaim_feasibility_request').parents('div').eq(1).hide();
				$('#cancel_feasibility_request').parents('div').eq(1).hide();
				$('#cancelar_solicitud_viabilidad').parents('div').eq(1).hide();
				//Beacuse in same action strip
				$('#validate_feasibility_request').parents('table').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('table').eq(0).hide();
				$('#validate_feasibility_request').parents('div').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('div').eq(0).hide();
				$('#run_manual_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad_manual').parents('div').eq(1).hide();
				//Beacuse in same action strip
				// temporary commented 'get_manual_feasibility_response' to implement stub @Chetan 15-02-2017
				//$('#get_manual_feasibility_response').parents('table').eq(0).hide();
				//$('#get_manual_feasibility_response').parents('div').eq(0).hide();
				$('#add_to_services').parents('table').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
				$('#add_to_services').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).hide();
				$('#clear_services').parents('table').eq(0).hide();
				$('#limpiar_servicios').parents('table').eq(0).hide();
				$('#clear_services').parents('div').eq(0).hide();
				$('#limpiar_servicios').parents('div').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
				$('#export_manual_feasibility_result').parents('table').eq(0).hide();
				$('#export_manual_feasibility_result').parents('div').eq(0).hide();
				$('#adir_servicios').parents('table').eq(0).hide();
				$('#adir_servicios').parents('div').eq(1).hide();
				$('#aadir_servicios').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			}
		});
		
		var selectedPrd = "";
		
		selectedPrd = $('#attr_wrapper_1_selectProductES_quote select').val();
		//alert(selectedPrd);
		//alert("inside first none");
		if(selectedPrd == "" || selectedPrd == "none"){
			//alert(selectedPrd);
			$('#add_primary_tariff').parents('div').eq(1).hide();
			$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
			$('#load_sites').parents('div').eq(1).hide();
			$('#cargar_sedes').parents('div').eq(1).hide();
			$('#add_sites_for_feasibility_request').parents('div').eq(1).hide();
			//$('#anadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
			$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).hide();
			$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
			$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();	
			$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();			
			$('#run_feasibility').parents('div').eq(1).hide();
			$('#ejecutar_viabilidad').parents('div').eq(1).hide();
			//$('#configure_site').parents('div').eq(1).hide();
			$('#configure_site').parents('div').eq(0).hide();
			$('#configurar_sedes').parents('div').eq(0).hide();
			$('#configure_site').parents('table').eq(0).hide();
			//--Hide TES Support Button Hungary
			$('#generate_tes_support_request').parents('div').eq(0).hide();
            $('#generate_tes_support_request').parents('table').eq(0).hide();
			//--END TES Support Button Hungary
			$('#configurar_sedes').parents('table').eq(0).hide();
			$('#perform_manual_feasibility').parents('div').eq(1).hide();
			$('#submit_additional_info').parents('div').eq(1).hide();
			$('#reclaim_feasibility_request').parents('div').eq(1).hide();
			$('#cancel_feasibility_request').parents('div').eq(1).hide();
			$('#cancelar_solicitud_viabilidad').parents('div').eq(1).hide();
			//Beacuse in same action strip
			$('#validate_feasibility_request').parents('table').eq(0).hide();
			$('#validar_solicitud_viabilidad').parents('table').eq(0).hide();
			$('#validate_feasibility_request').parents('div').eq(0).hide();
			$('#validar_solicitud_viabilidad').parents('div').eq(0).hide();
			$('#run_manual_feasibility').parents('div').eq(1).hide();
			$('#ejecutar_viabilidad_manual').parents('div').eq(1).hide();
			//Beacuse in same action strip
			// temporary commented 'get_manual_feasibility_response' to implement stub @Chetan 15-02-2017
			//$('#get_manual_feasibility_response').parents('table').eq(0).hide();
			//$('#get_manual_feasibility_response').parents('div').eq(0).hide();
			$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#add_to_services').parents('table').eq(0).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#add_to_services').parents('div').eq(0).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).hide();
			$('#clear_services').parents('table').eq(0).hide();
			$('#limpiar_servicios').parents('table').eq(0).hide();
			$('#clear_services').parents('div').eq(0).hide();
			$('#limpiar_servicios').parents('div').eq(0).hide();
			$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
			$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
			$('#export_manual_feasibility_result').parents('table').eq(0).hide();
			$('#export_manual_feasibility_result').parents('div').eq(0).hide();
			$('#anadir_servicios').parents('table').eq(0).hide();
			$('#anadir_servicios').parents('div').eq(1).hide();
			$('#anadir_servicios').parents('div').eq(0).hide();
			
			
		}
		
		if(selectedPrd == "sIPTelephony" || selectedPrd == "oneNetCloudContactCentre" || selectedPrd == "oneNetCollaborationForLync"  || selectedPrd == "legacyProductExtraServices" || selectedPrd == "iPPBX" || selectedPrd == "Bespoke") {
			//$('#load_sites').parents('div').eq(1).hide();
			$('#add_primary_tariff').parents('div').eq(1).hide();
			$('#add_sites_for_feasibility_request').parents('div').eq(1).hide();
			$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
			$('#run_feasibility').parents('div').eq(1).hide();
			$('#ejecutar_viabilidad').parents('div').eq(1).hide();
			//$('#configure_site').parents('div').eq(1).hide();
			//$('#configure_site').parents('div').eq(0).hide();
			//$('#configure_site').parents('table').eq(0).hide();
			$('#perform_manual_feasibility').parents('div').eq(1).hide();
			$('#submit_additional_info').parents('div').eq(1).hide();
			$('#reclaim_feasibility_request').parents('div').eq(1).hide();
			$('#cancel_feasibility_request').parents('div').eq(1).hide();
			$('#cancelar_solicitud_viabilidad').parents('div').eq(1).hide();
			//Beacuse in same action strip
			$('#validate_feasibility_request').parents('table').eq(0).hide();
			$('#validar_solicitud_viabilidad').parents('table').eq(0).hide();
			$('#validate_feasibility_request').parents('div').eq(0).hide();
			$('#validar_solicitud_viabilidad').parents('div').eq(0).hide();
			$('#run_manual_feasibility').parents('div').eq(1).hide();
			$('#ejecutar_viabilidad_Manual').parents('div').eq(1).hide();
			//Beacuse in same action strip
			// temporary commented 'get_manual_feasibility_response' to implement stub @Chetan 15-02-2017
			//$('#get_manual_feasibility_response').parents('table').eq(0).hide();
			//$('#get_manual_feasibility_response').parents('div').eq(0).hide();
			
			$('#add_to_services').parents('table').eq(0).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#add_to_services').parents('div').eq(0).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).hide();
			$('#clear_services').parents('table').eq(0).hide();
			$('#limpiar_servicios').parents('table').eq(0).hide();
			$('#clear_services').parents('div').eq(0).hide();
			$('#limpiar_servicios').parents('div').eq(0).hide();
			$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
			$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
			$('#export_manual_feasibility_result').parents('table').eq(0).hide();
			$('#export_manual_feasibility_result').parents('div').eq(0).hide();
			
			
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			$('#ejecutar_viabilidad_manual').parents('table').eq(0).hide();
			$('#configurar_sedes').parents('div').eq(0).show();
			$('#anadir_servicios').parents('table').eq(0).hide();
			$('#anadir_servicios').parents('div').eq(1).hide();
			$('#anadir_servicios').parents('div').eq(0).hide();
		}
		//Chandan - BREQ - 022 (Hiding all buttons for Primary Tariff)
		
		if(selectedPrd == "oneNetIPTrunk"){
				$('#add_primary_tariff').parents('div').eq(1).show();
				$('#load_sites').parents('div').eq(1).hide();
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#cargar_sedes').parents('div').eq(1).hide();
				$('#add_sites_for_feasibility_request').parents('div').eq(1).hide();
				//$('#anadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();
				$('#solicitar_sedes_para_viabilidad').parents('div').eq(1).hide();
				$('#adir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(1).hide();		
				$('#run_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad').parents('div').eq(1).hide();
				//$('#configure_site').parents('div').eq(1).hide();
				$('#configure_site').parents('div').eq(0).hide();
				$('#configurar_sedes').parents('div').eq(0).hide();
				$('#configure_site').parents('table').eq(0).hide();
				$('#configurar_sedes').parents('table').eq(0).hide();
				$('#perform_manual_feasibility').parents('div').eq(1).hide();
				$('#submit_additional_info').parents('div').eq(1).hide();
				$('#reclaim_feasibility_request').parents('div').eq(1).hide();
				$('#cancel_feasibility_request').parents('div').eq(1).hide();
				$('#cancelar_solicitud_viabilidad').parents('div').eq(1).hide();
				//Beacuse in same action strip
				$('#validate_feasibility_request').parents('table').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('table').eq(0).hide();
				$('#validate_feasibility_request').parents('div').eq(0).hide();
				$('#validar_solicitud_viabilidad').parents('div').eq(0).hide();
				$('#run_manual_feasibility').parents('div').eq(1).hide();
				$('#ejecutar_viabilidad_manual').parents('div').eq(1).hide();
				//Beacuse in same action strip
				// temporary commented 'get_manual_feasibility_response' to implement stub @Chetan 15-02-2017
				//$('#get_manual_feasibility_response').parents('table').eq(0).hide();
				//$('#get_manual_feasibility_response').parents('div').eq(0).hide();
				$('#add_to_services').parents('table').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
				$('#add_to_services').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('div').eq(0).hide();
				$('#clear_services').parents('table').eq(0).hide();
				$('#limpiar_servicios').parents('table').eq(0).hide();
				$('#clear_services').parents('div').eq(0).hide();
				$('#limpiar_servicios').parents('div').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('table').eq(0).hide();
				$('#export_automatic_feasibility_result').parents('div').eq(0).hide();
				$('#export_manual_feasibility_result').parents('table').eq(0).hide();
				$('#export_manual_feasibility_result').parents('div').eq(0).hide();
				$('#anadir_servicios').parents('table').eq(0).hide();
				$('#anadir_servicios').parents('div').eq(1).hide();
				$('#anadir_servicios').parents('div').eq(0).hide();
				$('#aadir_sedes_para_la_solicitud_de_viabilidad').parents('table').eq(0).hide();
			}
		
		/***********START SELECT SITES FOR HUNGARY******************/
		
		//Hungary 
		var partType = "";
		//partType = $("#field_wrapper_1_partType_quote select").val();
		partType = $("#1_microSegmentHU_quote").val();
		
		//alert(partType);
		if(partType != ""){
			$('#load_sites').parents('div').eq(1).show();
			$('#configure_site').parents('div').eq(0).show();
			$('#configure_site').parents('table').eq(0).show();
			$('#generate_tes_support_request').parents('div').eq(0).show();
			$('#generate_tes_support_request').parents('table').eq(0).show();
		}
		/*$("#field_wrapper_1_partType_quote select").on("change",function(){
			partType = $(this).val();
			//alert(partType);
			if(partType != ""){
				$('#configure_site').parents('div').eq(0).show();
				$('#configure_site').parents('table').eq(0).show();
				$('#generate_tes_support_request').parents('div').eq(0).show();
				$('#generate_tes_support_request').parents('table').eq(0).show();
			}
		});*/	
		
		//alternate row colors for load site details
		$("#siteSelection_Hungary tr:even").css("background-color","#eeeeee");
		$("#siteSelection_Hungary tr:odd").css("background-color","#ffffff");
		
		//Code for getting selected sites
		$("#siteSelection_Hungary input[type=checkbox]").on("change",function(){
			var siteSize = [];
			
			if($(this).prop("checked")) {
				//Check code start here
				var selectedValue = $(this).val();
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				
				//Get existing site details value
				siteDetails = $("#selectedSitesInformation_quote").val();
				
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
			
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				
				 /*$('#configure_site').parents('div').eq(0).show();
			     $('#configure_site').parents('table').eq(0).show();
				 $('#generate_tes_support_request').parents('div').eq(0).show();
                 $('#generate_tes_support_request').parents('table').eq(0).show();*/
				//Assign selected site details string to quote level attribute.
				$("#selectedSitesInformation_quote").val(siteDetails);	
				
				
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = "";
				//alert(siteDetails);
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
				siteDetails = $("#selectedSitesInformation_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				$("#selectedSitesInformation_quote").val(ss);	

			}
		});
		
		/***********END SELECT SITES FOR HUNGARY******************/
		
		
		//alternate row colors for load site details
		$("#siteDetailsForSIP tr:even").css("background-color", "#eeeeee");
		$("#siteDetailsForSIP tr:odd").css("background-color", "#ffffff");
		
		//Site Selction for SIP Telephony Single site select
		$("#siteDetailsForSIP input[type=radio]").on("change",function() {
			if( $( this ).prop( "checked" ) ) {
				var siteName = "";
				var siteAddress = "";    
				var site = "";
				
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				
				$('#siteSelectionForSIP_ES_quote').val('');				 	
				site = siteID + "$$" + siteAddress;
				$('#siteSelectionForSIP_ES_quote').val(site);				
			}
		});
		
		/******Code End for SIP Telephony ****************************/
		
		//Hide Start Over Action for opco as ES		
		// if($('#opco').val() == "ES"){
		  // $('.button-start-over').hide();
		// }
		
		//Due to version changes ID's got changes >changing the code and its only specific to fixed products
		
		SelectedProduct =$('#attribute-selectedFixedProduct_ES').val();


		if($('#attribute-opco').val() == "ES" && (SelectedProduct == "sIPTelephony" || SelectedProduct == "iPVPN" ||SelectedProduct == "oneNetIPTrunk" || SelectedProduct == "oneNetCloudContactCentre" || SelectedProduct == "primarioFijo" ||SelectedProduct == "primarioMvil" || SelectedProduct == "oneNetCollaborationForLync" || SelectedProduct == "enlacePortador" ||SelectedProduct == "legacyProductAccesoInternetONOAndVodafone" || SelectedProduct == "legacyProductMPLSAndVPLSONO" || SelectedProduct == "legacyProductVPNAvalon" || SelectedProduct == "legacyProductExtraServices" || SelectedProduct == "iPPBX" || SelectedProduct == "none")){
	
		  $('.button-start-over').hide();
		}
		
		//Code for Update configuration group header of SIP Telephony for SIP Trunk product.
		if($('#attribute-selectedFixedProduct_ES').val() == "oneNetIPTrunk"){
			//Update Channel Details header to Service Details
			//$('#group-20559970').closest('.group-content').find('.group-header').text('Service Details'); // Commented code for bereq 124 
			$('#group-20559970').closest('.group-content').find('.group-header').hide(); 
			
			//Update tariff plan header to Price Plan Details
			$('#group-20581917').closest('.group-content').find('.group-header').text('Price Plan Details');
			
			//Hide Number IP Trunk for SIp Telephony Products
			//$('#grid-21086184').hide();
			//$('#group-21086184').hide();
			
			//Hide Service Details Section
			$('#grid-20560085').hide();
			
			//Update Default tab name of SIP Telephony to IP Trunk
			$('#tab-defaultTab').find('.tab-text').text('IP Trunk Product Configuration');
			
			//Update 2nd tab name Addon to "NumeraciÃ³n IP Trunk"
			$('#tab-sIPAddons').find('.tab-text').text('NumeraciÃ³n IP Trunk');
			
			//Update 3nd tab name Primary Numbering to "NumeraciÃ³n Primario"
			$('#tab-primaryNumberingDDI_ES').find('.tab-text').text('NumeraciÃ³n Primario');
			
			/*userGroup = $("#currentusergroup").val();
			reconfigflag = $("#reconfigureGlobalFlag").val();
			if(reconfigflag == "true" && userGroup == "accountManager_ES") {

				$( "#serviceType_IPTrunk_ES" ).prop( "disabled", true );
			}*/
		}
		
		//AccountManager reconfigure functionality
			reconfigflag = $("#attribute-reconfigureGlobalFlag").val(); 
			userGroup = $("#attribute-currentusergroup").val();
			modelcreated = $("#attribute-modelConfiguredBy_ES").val();
			
			//if($('#attribute-selectedFixedProduct_ES').val() == "legacyProductAccesoInternetONOAndVodafone"){
				//if(reconfigflag == "true" && userGroup == "accountManager_ES" && modelcreated == "tESUsers_ES") {
								
				if(reconfigflag == "true" && (userGroup == "accountManager_ES" ||  userGroup == "WholeSale_accountManager_ES" ) && modelcreated == "tESUsers_ES" ) {
					
					
					$( "#clientTypeLegacy_ES" ).prop( "disabled", true );
					//$( "#cPESalesModeLegacy_ES" ).prop( "disabled", true );
					$( "#unSoloCPELegacy_ES_true" ).prop( "disabled", true );
					$( "#routerTypeLegacy_ES" ).prop( "disabled", true );
					$( "#backupRouterType_MPLS_ES" ).prop( "disabled", true );
					$( "#bundleLegacyMPLS_ES" ).prop( "disabled", true );
					$( "#backupCPEBundleLegacyMPLS_ES" ).prop( "disabled", true );
					$( "#legacyBOM_ES" ).prop( "disabled", true );
					$( "#backupCPEBOMLegacyMPLS_ES" ).prop( "disabled", true );
					$( "#primaryCPEComponent_ES" ).prop( "disabled", true ); 
					$( "#direccionamientoIPV4Legacy_ES" ).prop( "disabled", true );
					$( "#direccionamientoIPV6Legacy_ES" ).prop( "disabled", true );
					$( "#backupCPEComponent_IPVPN_ES" ).prop( "disabled", true );
					$( "#quantityLegacyIPV4_ES" ).prop( "disabled", true );
					$( "#quantityLegacyIPV6_ES" ).prop( "disabled", true );
					
					$( "#coSPlatino64kbpsLegacy_ES" ).prop( "disabled", true );
					$( "#coSOro64kbpsLegacy_ES" ).prop( "disabled", true );
					$( "#accessExists_IPVPN_ES_Main" ).prop( "disabled", true );
					$( "#accessExists_IPVPN_ES_Backup" ).prop( "disabled", true );
					
					$( "#accessExists_LegacyMPLS_ES_Main" ).prop( "disabled", true );
					$( "#accessExists_LegacyMPLS_ES_Backup" ).prop( "disabled", true );
					$( "#accessExists_LegacyAvalon_ES_Main" ).prop( "disabled", true );
					$( "#accessExists_LegacyAvalon_ES_Backup" ).prop( "disabled", true );
					// New attributes implemented for BREQ PROJ-1518930_BREQ-107 by Chetan Gosavi 20-02-2017
					$( "#mainAccessServiceLegacy_ES" ).prop( "disabled", true );
					$( "#backupAccessServiceLegacy_ES" ).prop( "disabled", true );
					$( "#mainAccessBandwidthLegacy_ES" ).prop( "disabled", true );
					$( "#backupAccessBandwidthLegacy_ES" ).prop( "disabled", true );
					
					
					
					
					//---------------------------------------------------------------------------
					// Product IP VPN: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------
					
					$( "#primaryModeOfAccess_ES" ).prop( "disabled", true );
					$( "#backupModeOfAccess_ES" ).prop( "disabled", true );
					$( "#primaryBandwidth_ES" ).prop( "disabled", true );
					$( "#backupBandwidth_ES" ).prop( "disabled", true );
					$( "#sLA_ES" ).prop( "disabled", true );
					$( "#monitorType_ES" ).prop( "disabled", true );
					$( "#sVA1_ES" ).prop( "disabled", true );
					$( "#sVA2_ES" ).prop( "disabled", true );
					$( "#unSoloCPEIPVPN_ES_true" ).prop( "disabled", true ); 
					//Commented by Chandan for BREQ - 102
					//$( "#primaryCPESalesMode_ES" ).prop( "disabled", true );
					//$( "#backupCPESalesMode_ES" ).prop( "disabled", true );
					$( "#primaryCPESalesType_ES" ).prop( "disabled", true );
					$( "#backupCPESalesType_ES" ).prop( "disabled", true );
					$( "#primaryProfile_ES" ).prop( "disabled", true );
					$( "#backupCPEProfile_ES" ).prop( "disabled", true );
					$( "#primaryCPEBOM_ES" ).prop( "disabled", true );
					$( "#backupCPEBOM_ES" ).prop( "disabled", true );
					$( "#primaryCPEComponent_ES" ).prop( "disabled", true );
					$( "#backupCPEComponent_IPVPN_ES" ).prop( "disabled", true );
					$( "#dataCenter_ES" ).prop( "disabled", true );
					
					$( "#accessExists_LegacyMPLS_ES_Main" ).prop( "disabled", true );
					$( "#accessExists_LegacyMPLS_ES_Backup" ).prop( "disabled", true );
					
					$( "#accessExists_IPVPN_ES_Main" ).prop( "disabled", true );
					$( "#accessExists_IPVPN_ES_Backup" ).prop( "disabled", true );
					
					
					
					//---------------------------------------------------------------------------
					// Product AVALON: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------
					
					
					
					$( "#cPESalesModeLegacyAvalon_ES" ).prop( "disabled", true );
					$( "#routerMainLegacyAvalon_ES" ).prop( "disabled", true );
					$( "#bundleAvalonLegacy_ES" ).prop( "disabled", true );
					$( "#bOMMainAvalon_ES" ).prop( "disabled", true );
					$( "#primaryCPEComponent_ES" ).prop( "disabled", true );
					$( "#backupCPESalesModeLegacyAvalon_ES" ).prop( "disabled", true );
					$( "#routerBackupLegacyAvalon_ES" ).prop( "disabled", true );
					$( "#bundleBackupAvalon_ES" ).prop( "disabled", true );
					$( "#bOMBackupAvalon_ES" ).prop( "disabled", true ); 
					$( "#backupCPEComponent_IPVPN_ES" ).prop( "disabled", true );
					$( "#legacyAvalonServiceArrayController_ES" ).prop( "disabled", true );
					$( "#accessExists_LegacyAvalon_ES" ).prop( "disabled", true );
					$( "#legacyAvalonProductArrayController_ES" ).prop( "disabled", true );
					$( "#accessExists_LegacyAvalon_ES_Main" ).prop( "disabled", true );
					$( "#accessExists_LegacyAvalon_ES_Backup" ).prop( "disabled", true );
					$( "#quantityLegacyAvalon_ServiceArray_ES" ).prop( "disabled", true );
					$( "#serviceLegacyAvalon_ServiceArray_ES" ).prop( "disabled", true );
					$( "#bandwidthLegacyAvalon_ServiceArray_ES" ).prop( "disabled", true );
					// New attributes implemented for BREQ PROJ-1518930_BREQ-107 by Chetan Gosavi 20-02-2017
					$( "#mainAccessServiceAvalon_ES" ).prop( "disabled", true );
					$( "#backupAccessServiceAvalon_ES" ).prop( "disabled", true );
					$( "#mainAccessBandwidthAvalon_ES" ).prop( "disabled", true );
					$( "#backupAccessBandwidthAvalon_ES" ).prop( "disabled", true );
					
					//---------------------------------------------------------------------------
					// Product Extra services: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------
					
					
					
					$( "#catalogProductTypeLegacyExtra_ES" ).prop( "disabled", true );
					$( "#level4ProductName_ES" ).prop( "disabled", true );
					$( "#level5ProductName_ES" ).prop( "disabled", true );
					$( "#level6ProductNameLegacyExtra_ES" ).prop( "disabled", true );
					$( "#partnerLegacyExtra_ES_Vodafone" ).prop( "disabled", true );
					$( "#productLegacyExtra_ES" ).prop( "disabled", true );
					$( "#quantityLegacyExtra_ES" ).prop( "disabled", true );
					$( "#legacyExtraServicesArrayController_ES" ).prop( "disabled", true );
					
					$( "#partnerLegacyExtra_ES_TECNOCOM" ).prop( "disabled", true );
					$( "#partnerLegacyExtra_ES_SATEC" ).prop( "disabled", true );
					$( "#partnerLegacyExtra_ES_ALALZA" ).prop( "disabled", true );
					$( "#partnerLegacyExtra_ES_KONECTA" ).prop( "disabled", true );
					



					
					
					//---------------------------------------------------------------------------
					// Product SIP Telephony: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------
					
					$( "#noOfCTN_SIP_ES" ).prop( "disabled", true );
					$( "#selectChannels_SIP_ES" ).prop( "disabled", true );
					$( "#tariffPlan_SIP_ES" ).prop( "disabled", true );
					$( "#addonName_SIP_addon_ES" ).prop( "disabled", true );
					$( "#noOfCTNs_SIP_addon_ES" ).prop( "disabled", true );
					
					//---------------------------------------------------------------------------
					// Product IP Trunk: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------			
					
					$( "#serviceType_IPTrunk_ES" ).prop( "disabled", true );
					// $( "#selectPricePlan_IPTrunk_ES" ).prop( "disabled", true );
					// $( "#quantityPricePlan_IPtrunk_ES" ).prop( "disabled", true );
					// $( "#Numbering_IPTrunk_ES" ).prop( "disabled", true );
					// $( "#qunatity_Numbering_IPTrunk_ES" ).prop( "disabled", true );
					// $( "#addonName_SIP_addon_ES" ).prop( "disabled", true );
					// $( "#noOfCTNs_SIP_addon_ES" ).prop( "disabled", true );		
				//	$( "#offerPrice_oneOffFee_channel_SIP_ES" ).prop( "disabled", true );
					$( "#offerPrice_oneOffFee_channel_SIP_ES" ).prop( "disabled", true );
					$( "#offerPrice_Installtation_channel_SIP_ES" ).prop( "disabled", true );
					$( "#offerPrice_monthlyFee_channel_SIP_ES" ).prop( "disabled", true );
					$( "#offerPrice_minconsumptionFee_channel_SIP_ES" ).prop( "disabled", true );
					$( "#offerPrice_yearlyFee_channel_SIP_ES" ).prop( "disabled", true );				
				
					

					//---------------------------------------------------------------------------
					// Product primary fijo: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------	
					$( "#accessExistsPrimaryProductES_Main" ).prop( "disabled", true );
					$( "#leadTimeinDays_ResponseArray_ES" ).prop( "disabled", true );					
					//$( "#selectPricePlan_PrimaryLines_ES" ).prop( "disabled", true );
					$( "#quantitiy_PrimaryLines_ES" ).prop( "disabled", true );
					// $( "#portabilidadSino_PRI_fixed_ES" ).prop( "disabled", true );
					// $( "#numeracinNueva_PRI_Fixed_ES" ).prop( "disabled", true );
					// $( "#gestinDeLaPBX_PRI_fixed_ES" ).prop( "disabled", true );
					// $( "#actuacionesPBX_PRI_fixed_ES" ).prop( "disabled", true );
					// $( "#modalidad_PRI_fixed_ES" ).prop( "disabled", true );					
					// $( "#empresaMant_PRI_fixed_ES" ).prop( "disabled", true );
					// $( "#hWContratado_PRI_Fixed_ES" ).prop( "disabled", true );
					// $( "#Numbering_IPTrunk_ES" ).prop( "disabled", true );
					// $( "#qunatity_Numbering_IPTrunk_ES" ).prop( "disabled", true );				
					// $( "#mediumUtilization_usagesRates_SIP_ES" ).prop( "disabled", true );	
					// $( "#numberOfImplementations_IPTrunck_Numbering_ES" ).prop( "disabled", true );	
					

					//---------------------------------------------------------------------------
					// Product primary movil: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------	


					// $( "#selectPricePlan_PrimaryLines_ES" ).prop( "disabled", true );
					// $( "#quantitiy_PrimaryLines_ES" ).prop( "disabled", true );
					// $( "#modalidad_PrimaryLines_Mobile_ES" ).prop( "disabled", true );
					// $( "#integracinPBXPlacaPrimario" ).prop( "disabled", true );
					// $( "#Numbering_IPTrunk_ES" ).prop( "disabled", true );
					// $( "#qunatity_Numbering_IPTrunk_ES" ).prop( "disabled", true );
					
					//---------------------------------------------------------------------------
					// Product One net CCC: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------	
					$( "#selectChannels_OneNetCCC_ES" ).prop( "disabled", true );
					$( "#quantity_OneNetCCC_New_ES" ).prop( "disabled", true );
					$( "#plan_CCCAgents_ES" ).prop( "disabled", true );
					$( "#quantity_CCCAgents_ES" ).prop( "disabled", true );
					$( "#productName_TrainingServices_OneNetCCC_ES" ).prop( "disabled", true );
					$( "#quantity_TrainingServices_OneNetCCC_ES" ).prop( "disabled", true );
					$( "#productName_AdvancedServices_OneNetCCC_ES" ).prop( "disabled", true );
					$( "#quantity_AdvancedServices_OneNetCCC_ES" ).prop( "disabled", true );
					$( "#selectTrainingAndAdvancedServices_OneNetCCC_ES_true" ).prop( "disabled", true );
					

					//---------------------------------------------------------------------------
					// Product One Net Lync: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------	
					// $( "#plan_OneNetLyncLicences_ES" ).prop( "disabled", true );
					// $( "#quantity_OneNetLyncLicences_ES" ).prop( "disabled", true );
					// $( "#productType_OneNetLyncPriceplan_ES_New" ).prop( "disabled", true );
					// $( "#license_OneNetLyncPriceplanNew_ES" ).prop( "disabled", true );
					// $( "#quantity_OneNetLyncPriceplanNew_ES" ).prop( "disabled", true );
					// $( "#productType_OneNetLyncModules_ES" ).prop( "disabled", true );
					// $( "#productType_OneNetLyncModulesprice_ES" ).prop( "disabled", true );
					// $( "#quantity_OnenEtLyncModule_ES" ).prop( "disabled", true );
					// $( "#plan_OneNetLyncProfServices_ES" ).prop( "disabled", true );
					// $( "#quantity_OnenEtLyncProfServices_ES" ).prop( "disabled", true );

					//---------------------------------------------------------------------------
					// Product IP PBX: Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------	
					//$( "#productTypeVoice_ES" ).prop( "disabled", true );
					//$( "#cell-quantityVoice_ES" ).prop( "disabled", true );
					$( "#productNameVoice_ES" ).prop( "disabled", true );
					$( "#quantityVoice_ES" ).prop( "disabled", true );
					$( "#selectProductVoice_ES" ).prop( "disabled", true );
					$( "#noOfCTNVoice_ES" ).prop( "disabled", true );
					$(".array-add").hide();
					$(".array-remove-cell").hide();
					
					$( "#siteAddressFeasibilty_ES-0" ).prop( "disabled", true );
                    $( "#siteNameFeasibility_ES-0" ).prop( "disabled", true );
					$( "#siteInfoControllingArray_ES" ).prop( "disabled", true );
					
					//---------------------------------------------------------------------------
					// Product Primary : Disabled attributes for Account Manager 
					//---------------------------------------------------------------------------
				
					$( "#quintity_ResponseArray_ES-0" ).prop( "disabled", true );
					

										
				//}
			}
			
			// Product Avlon: Disabled attributes for Account Manager 
			
			// // if(reconfigflag == "true" && userGroup == "accountManager_ES" && modelcreated == "tESUsers_ES") {
					
					// alert("Second");
					// alert(reconfigflag);
					// alert(userGroup);
					// alert(modelcreated);
					
					// $( "#cPESalesModeLegacyAvalon_ES" ).prop( "disabled", true );
					// $( "#routerMainLegacyAvalon_ES" ).prop( "disabled", true );
					// $( "#bundleAvalonLegacy_ES" ).prop( "disabled", true );
					// $( "#bOMMainAvalon_ES" ).prop( "disabled", true );
					// $( "#primaryCPEComponent_ES" ).prop( "disabled", true );
					// $( "#backupCPESalesModeLegacyAvalon_ES" ).prop( "disabled", true );
					// $( "#routerBackupLegacyAvalon_ES" ).prop( "disabled", true );
					// $( "#bundleBackupAvalon_ES" ).prop( "disabled", true );
					// $( "#bOMBackupAvalon_ES" ).prop( "disabled", true ); 
					// $( "#backupCPEComponent_IPVPN_ES" ).prop( "disabled", true );
					// $( "#serviceLegacyAvalon_ServiceArray_ES" ).prop( "disabled", true );
					// $( "#bandwidthLegacyAvalon_ServiceArray_ES" ).prop( "disabled", true );
			// // //		$( "#quantityLegacyIPV4_ES" ).prop( "disabled", true );
				// // //	$( "#quantityLegacyIPV6_ES" ).prop( "disabled", true );
					
				// // //}
			// // }
		
		//Code for Update configuration group header of SIP Telephony for SIP Trunk product.
		/*if($('#attribute-selectedFixedProduct_ES').val() == "primarioFijo" || $('#attribute-selectedFixedProduct_ES').val() == "primarioMvil"){
			$('#tab-defaultTab').show();
			$('#tab-addOnsNumberingIPTrunk').show();
		}*/
		
		//Reset all selected checbox for EP product
		$('.sourceMultiselect input[type="button"]').on('click', function() {
			$('#sourceSite :checked').removeAttr('checked');
		});		
		
		
		//Defect 1060
		$('#siteSelectionForSIP_ES_quote').val('');
		
		//Defect 1080
		$("#textAreaES5_quote").val('');
		
		//@Start EP - 14/1/2015
		//alternate row colors for load site details
		$("#sourceSite tr:even").css("background-color", "#eeeeee");
		$("#sourceSite tr:odd").css("background-color", "#ffffff");
		
		$("#destinationSite tr:even").css("background-color", "#eeeeee");
		$("#destinationSite tr:odd").css("background-color", "#ffffff");
		
		//Code for getting selected source sites
		$("#sourceSite input[type=checkbox]").on("change",function(){
			var siteSize = [];
				
			if( $( this ).prop( "checked" ) ) {
				//Check code start here
				var selectedValue = $(this).val();
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				
				//Get existing site details value
				siteDetails = $("#selectedSourceSites_quote").val();
				//$("#selectedSourceSites_quote").val('');
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
				
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				
				//Assign selected site details string to quote level attribute.
				$("#selectedSourceSites_quote").val(siteDetails);	
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = "";
				
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
				
				siteDetails = $("#selectedSourceSites_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				$("#selectedSourceSites_quote").val(ss);	
			}
			
		});
		
		//Code for getting selected Destination sites
		$("#destinationSite input[type=radio]").on("change",function(){
			var siteSize = [];
				
			if( $( this ).prop("checked" ) ) {
				//Check code start here
				var selectedValue = $(this).val();
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				
				//Get existing site details value
				//siteDetails = $("#selectedDestinationSites_quote").val();
				$("#selectedDestinationSites_quote").val('');
				//Get site and Address from html and prepared string
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				site = siteID + "$$" + siteAddress;
				
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				
				//Assign selected site details string to quote level attribute.
				$("#selectedDestinationSites_quote").val(siteDetails);	
			}	
			else {
				//Uncheck code start here
				$("#selectedDestinationSites_quote").val('');
			}
		});
		
		//Code for getting list of selected sites from table 2 for Enlance Portador
		$("#cftRequestSitesForEP input[type=checkbox]").on("change",function(){
			//alert("called");
			var siteSize = [];
			var siteDetails = ""; 
			
			if( $( this ).prop( "checked" ) ) {
				//Check code start here
				var selectedValue = $(this).val();
				//alert(selectedValue);
				
				var siteID = "";
				var siteDetails = ""; 
				var selectedSiteDetails = "";
				var site = "";
				var prodcutName ="";
				
				//Get existing site details value
				siteDetails = $("#cFTRequestParameter_quote").val();
				selectedSiteDetails = $("#cFTAllSelectedRequestParameters_quote").val();
				
				//Get site and Address from html and prepared string
				requestID = selectedValue;
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				capacity = $(this).closest('tr').find('td:eq(5)').text();
				siteType = $(this).closest('tr').find('td:eq(7)').text();
				refereceKey = $(this).closest('tr').find('td:eq(8)').text();
				prodcutName = $(this).closest('tr').find('td:eq(9)').text();
				
				site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + capacity + "$$" + siteType + "$$" + refereceKey + "$$" + prodcutName;
				
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				// Store selected site request from table2. 
				$("#cFTRequestForSingleSite_quote").val(site);
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(selectedSiteDetails != "") {
						selectedSiteDetails = selectedSiteDetails + "##" + this;
					}
					else {
						selectedSiteDetails = this;
					}
				});
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				//alert(siteDetails);
				//Assign selected site details string to quote level attribute.
				$("#cFTRequestParameter_quote").val(siteDetails);	
				$("#cFTAllSelectedRequestParameters_quote").val(selectedSiteDetails);
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = ""; var ss1 = "";
				var selectedValue = $(this).val();
				
				//Get site and Address from html and prepared string
				requestID = selectedValue;
				siteID = $(this).closest('tr').find('td:eq(1)').text();
				siteAddress = $(this).closest('tr').find('td:eq(2)').text();
				capacity = $(this).closest('tr').find('td:eq(5)').text();
				siteType = $(this).closest('tr').find('td:eq(7)').text();
				refereceKey = $(this).closest('tr').find('td:eq(8)').text();
				prodcutName = $(this).closest('tr').find('td:eq(9)').text();
				
				site = requestID + "$$" + siteID + "$$" + siteAddress  + "$$" + capacity + "$$" + siteType + "$$" +refereceKey + "$$" + prodcutName;
				
				//Empty selected site request.
				$("#cFTRequestForSingleSite_quote").val("");
				//Get CFT automatic Request Parameter Value
				siteDetails = $("#cFTRequestParameter_quote").val();
				//Get all CFT Automatic request parameters
				AllSiteDetails = $("#cFTAllSelectedRequestParameters_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				if(AllSiteDetails != "") {
					AllSiteSize = AllSiteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				//Remove unchecked element from selected sites array.
				AllSiteSize = $.grep(AllSiteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(AllSiteSize, function() {
					if(ss1 != "") {
						ss1 = ss1 + "##" + this;
					} else {
						ss1 = this;
					}
				});
				
				$("#cFTRequestParameter_quote").val(ss);
				$("#cFTAllSelectedRequestParameters_quote").val(ss1);				
			}
		});
		/***********END GET CFT REQUEST PARAMETERS FOR SITES ******************/
		
		/***********###3.1 START Get Automatic/Manual Feasibility Response **************/
		
		$("#fixed_hdr2 input[type=checkbox]").on("change",function() {
			var siteSize = [];
			if( $( this ).prop( "checked" ) ) {	
				//alert("called");
				var manRequestID = $(this).val();
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				var prdName = "";
				var errrMsg = "";
				//alert(manRequestID);
				
				
				//Empty string after error message.
				errrMsg = $("ul.error-text li:eq(2)").text();
				//alert(errrMsg);
				if(errrMsg == "Configure RAG Status"){
					$("#manualFeasibilityRequestParameters_quote").val('');
					
					$("#manualFeasibilityValidateRequest_quote").val('');
					$("#cFTResponseForSingleSite_quote").val(''); 
					$("ul.error-text li:eq(2)").text('');
				}
				
				//Empty string after configuration.
				var sss = $("#testText6ES_quote").val();
				//alert(sss);
				if($("#testText6ES_quote").val() == "true"){
					$("#manualFeasibilityRequestParameters_quote").val('');
					
					$("#manualFeasibilityValidateRequest_quote").val('');
					$("#testText6ES_quote").val('');
				}
				
				//CLear selection of table4 for old quotes.
				//$("#1_textAreaES3_quote").val(''); // commented by santhosh for defect PROJ-1619822_BUG-1091
				//alert($("#1_textAreaES3_quote").val(''));

				//Get existing site details value
				//siteDetails = $("#cFTResponseForSingleSite_quote").val();
				//$("#cFTResponseForSingleSite_quote").val("");
				//Get existing site details value
				siteDetails = $("#manualFeasibilityRequestParameters_quote").val();
				//$("#manualFeasibilityRequestParameters_quote").val("");
				selectedSiteDetails = $("#allManualFeasibilityRequestParameters_quote").val();
				
				//Get Service Details for Manual Feasibility Request.
				
				//Get site and Address from html and prepared string
				selectedRow = $(this).closest('tr').find('td').find('input').val();
				autoRequestID = $(this).closest('tr').find(".autoRequestID").text();
				//siteID = $(this).closest('tr').find('td:eq(2)').text();
				configurationStatus = $(this).closest('tr').find(".configurationStatus").text();
				siteName = $(this).closest('tr').find(".siteName").text();
				siteAddress = $(this).closest('tr').find(".siteAddress").text();
				primaryAccess = $(this).closest('tr').find(".primaryAccess").text();
				primaryRAG = $(this).closest('tr').find(".primaryRAG").text();
				//Change for Search Functionality.
				if(primaryRAG == "RED"){
					primaryRAG = "R";
				}
				else if(primaryRAG == "GREEN"){
					primaryRAG = "G";
				}
				else if(primaryRAG == "AMBER"){
					primaryRAG = "A";
				}
				else if(primaryRAG == "Gray"){
					primaryRAG = "Gray";
				}
				else if(primaryRAG == "BLUE"){
					primaryRAG = "B";
				}
				else{
					primaryRAG = "";
				}
				feasibilityExpiryDate = $(this).closest('tr').find(".expiryDate").text();
				//@3.1
				feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
				cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
				studyLevel = $(this).closest('tr').find('td').find('select').val();
				analysisType = $(this).closest('tr').find(".analysisType").text();
				autoFID = $(this).closest('tr').find(".autoFID").text();
				referKey = $(this).closest('tr').find(".referKey").text();
				leadT = $(this).closest('tr').find(".leadT").text();
				prdName = $(this).closest('tr').find(".prdName").text();
				if(prdName == "Legacy Avalon"){
					prdName = "legacyProductVPNAvalon";
				}
				if(prdName == "Legacy MPLS"){
					prdName = "legacyProductMPLSAndVPLSONO";
				}
				if(prdName == "Legacy Internet"){
					prdName = "legacyProductAccesoInternetONOAndVodafone";
				}
				if(prdName == "Enlance Portador"){
					prdName = "enlacePortador";
				}
				if(prdName == "IPVPN"){
					prdName = "iPVPN";
				}
				if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioFijo";
				}	
				if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioMvil";
				}
				//Get existing site details valuek8
				userGroup = $("#1_currentUserGroup_quote").val();
				
				site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + referKey + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + leadT + "$$" + prdName;
				
				if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
					feasibilityStatus = $(this).closest('tr').find('td:eq(11)').text();
					
					//@Cost Attributes
					CapEx = $(this).closest('tr').find(".capEx").text();
					Initial_OpEx = $(this).closest('tr').find(".initialOpEx").text();
					Recurring_OpEx = $(this).closest('tr').find(".recurringOpEx").text();
					
					//@3.1
					feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
					cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
					studyLevel = $(this).closest('tr').find('td').find('select').val();
					analysisType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referKey").text();
					autoFID = $(this).closest('tr').find(".autoFID").text();
					leadT = $(this).closest('tr').find(".leadT").text();
					prdName = $(this).closest('tr').find(".prdName").text();
					if(prdName == "Legacy Avalon"){
						prdName = "legacyProductVPNAvalon";
					}
					if(prdName == "Legacy MPLS"){
						prdName = "legacyProductMPLSAndVPLSONO";
					}
					if(prdName == "Legacy Internet"){
						prdName = "legacyProductAccesoInternetONOAndVodafone";
					}
					if(prdName == "Enlance Portador"){
						prdName = "enlacePortador";
					}
					if(prdName == "IPVPN"){
						prdName = "iPVPN";
					}
					if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioFijo";
					}	
					if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioMvil";
					}
					//site = site + "$$" + CapEx + "$$" + Initial_OpEx + "$$" + Recurring_OpEx; 
					
					site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + referKey + "$$" + CapEx+ "$$" + Initial_OpEx + "$$" + Recurring_OpEx + "$$" + leadT + "$$" + prdName  ;	
					//alert(prdName);					
					//alert(site);
				}
				
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(selectedSiteDetails != "") {
						selectedSiteDetails = selectedSiteDetails + "##" + this;
					}
					else {
						selectedSiteDetails = this;
					}
				});
				
				//CFT Response For Single site.
				$('#cFTResponseSelectedRowID_quote').val('');
				$('#cFTResponseSelectedRowID_quote').val(selectedRow);
				
				$("#testTextArea9ES_quote").val('');
				
				$("#testTextArea9ES_quote").val(site);
				
				
				//Used for Configuration String for temporary will remove this.
				$("#cFTResponseForSingleSite_quote").val(siteDetails);
				//Get selected rows for manual feasiblity requset parameter.
				$("#manualFeasibilityRequestParameters_quote").val(siteDetails);
				//alert(siteDetails);
				
				
				var ttt = $("#manualFeasibilityRequestParameters_quote").val();
				 $("#textAreaES5_quote").val(ttt);
				//alert(tver);
				//Get and store all selected rows for manual feasiblity requset parameter.
				$("#allManualFeasibilityRequestParameters_quote").val(selectedSiteDetails);
				//alert(siteDetails);	
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = ""; var ss1 = "";
				var prdName = "";
				var manRequestID = $(this).val();
				
				
				//Get site and Address from html and prepared string
				selectedRow = $(this).closest('tr').find('td').find('input').val();
				
				//@Start
				autoRequestID = $(this).closest('tr').find(".autoRequestID").text();
				//siteID = $(this).closest('tr').find('td:eq(2)').text();
				configurationStatus = $(this).closest('tr').find(".configurationStatus").text();
				siteName = $(this).closest('tr').find(".siteName").text();
				siteAddress = $(this).closest('tr').find(".siteAddress").text();
				primaryAccess = $(this).closest('tr').find(".primaryAccess").text();
				primaryRAG = $(this).closest('tr').find(".primaryRAG").text();
				//Change for Search Functionality.
				if(primaryRAG == "RED"){
					primaryRAG = "R";
				}
				else if(primaryRAG == "GREEN"){
					primaryRAG = "G";
				}
				else if(primaryRAG == "AMBER"){
					primaryRAG = "A";
				}
				else if(primaryRAG == "Gray"){
					primaryRAG = "Gray";
				}
				else if(primaryRAG == "BLUE"){
					primaryRAG = "B";
				}
				else{
					primaryRAG = "";
				}
				feasibilityExpiryDate = $(this).closest('tr').find(".expiryDate").text();
				//@3.1
				feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
				cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
				studyLevel = $(this).closest('tr').find('td').find('select').val();
				analysisType = $(this).closest('tr').find(".analysisType").text();
				referKey = $(this).closest('tr').find(".referKey").text();
				autoFID = $(this).closest('tr').find(".autoFID").text();
				leadT = $(this).closest('tr').find(".leadT").text();
				prdName = $(this).closest('tr').find(".prdName").text();
				if(prdName == "Legacy Avalon"){
					prdName = "legacyProductVPNAvalon";
				}
				if(prdName == "Legacy MPLS"){
					prdName = "legacyProductMPLSAndVPLSONO";
				}
				if(prdName == "Legacy Internet"){
					prdName = "legacyProductAccesoInternetONOAndVodafone";
				}
				if(prdName == "Enlance Portador"){
					prdName = "enlacePortador";
				}
				if(prdName == "IPVPN"){
					prdName = "iPVPN";
				}
				if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioFijo";
				}	
				if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioMvil";
				}
				//Get existing site details valuek8
				userGroup = $("#1_currentUserGroup_quote").val();
				
				site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + referKey + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + leadT + "$$" + prdName;
				
				if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
					feasibilityStatus = $(this).closest('tr').find('td:eq(11)').text();
					
					//@Cost Attributes
					CapEx = $(this).closest('tr').find(".capEx").text();
					Initial_OpEx = $(this).closest('tr').find(".initialOpEx").text();
					Recurring_OpEx = $(this).closest('tr').find(".recurringOpEx").text();
					
					//@3.1
					feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
					cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
					studyLevel = $(this).closest('tr').find('td').find('select').val();
					analysisType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referKey").text();
					autoFID = $(this).closest('tr').find(".autoFID").text();
					leadT = $(this).closest('tr').find(".leadT").text();
					prdName = $(this).closest('tr').find(".prdName").text();
					if(prdName == "Legacy Avalon"){
					prdName = "legacyProductVPNAvalon";
					}
					if(prdName == "Legacy MPLS"){
						prdName = "legacyProductMPLSAndVPLSONO";
					}
					if(prdName == "Legacy Internet"){
						prdName = "legacyProductAccesoInternetONOAndVodafone";
					}
					if(prdName == "Enlance Portador"){
						prdName = "enlacePortador";
					}
					if(prdName == "IPVPN"){
						prdName = "iPVPN";
					}
					if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioFijo";
					}	
					if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioMvil";
					}
					//site = site + "$$" + CapEx + "$$" + Initial_OpEx + "$$" + Recurring_OpEx; 
					
					site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + referKey + "$$" + CapEx+ "$$" + Initial_OpEx + "$$" + Recurring_OpEx+ "$$" + leadT + "$$" + prdName;
				}

				//Empty selected site request.
				//$("#cFTRequestForSingleSite_quote").val("");
				//Get CFT automatic Request Parameter Value
				siteDetails = $("#manualFeasibilityRequestParameters_quote").val();
				//Get all CFT Automatic request parameters
				AllSiteDetails = $("#allManualFeasibilityRequestParameters_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				if(AllSiteDetails != "") {
					AllSiteSize = AllSiteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				//Remove unchecked element from selected sites array.
				AllSiteSize = $.grep(AllSiteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(AllSiteSize, function() {
					if(ss1 != "") {
						ss1 = ss1 + "##" + this;
					} else {
						ss1 = this;
					}
				});
				
				$("#testTextArea9ES_quote").val('');
				$('#cFTResponseSelectedRowID_quote').val('');
				//alert(ss);
				$("#cFTResponseForSingleSite_quote").val(ss);	
				//Get selected rows for manual feasiblity requset parameter.
				$("#manualFeasibilityRequestParameters_quote").val(ss);
				//Get and store all selected rows for manual feasiblity requset parameter.
				$("#allManualFeasibilityRequestParameters_quote").val(ss1);	
				//alert(ss);
			}
		});
		/***********END GET CFT RESPONSE FOR SITE CONFIGURATION**************/
		
		
		//alternate row colors for Request site details
		$("#cftRequestSitesLegacy tr:even").css("background-color", "#eeeeee");
		$("#cftRequestSitesLegacy tr:odd").css("background-color", "#ffffff");
		
		//@Prapare Validate & Cancel Request
		$('#cftRequestSitesLegacy input[type=checkbox]:not("#selectAll5")').on("change",function(){
			var siteSize = [];
			var siteDetails = ""; 
			
			if( $( this ).prop( "checked" ) ) {
				//Check code start here
				var selectedValue = $(this).val();
				//alert(selectedValue);
				
				var siteID = "";
				var siteDetails = ""; 
				var selectedSiteDetails = "";
				var site = "";
				var prd = "";
				
				//Get existing site details value
				
				/*if($('#selecctall1').attr('checked') && $("#cFTRequestParameter_quote").val() == "") {
					selectedSiteDetails = "";
					ksiteDetails = "";
				}else{
					
				} */
				selectedSiteDetails = $("#cFTAllSelectedRequestParameters_quote").val();
				siteDetails = $("#cFTRequestParameter_quote").val();
				
				//Get site and Address from html and prepared string
				requestID = selectedValue;
				siteID = $(this).closest('tr').find(".siteName").text();
				siteAddress = $(this).closest('tr').find(".siteAddress").text();
				service = $(this).closest('tr').find(".mainService").text();
				backup = $(this).closest('tr').find(".backupService").text();
				//referKey = $(this).closest('tr').find('td:eq(5)').text();
				
				site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + service + "$$" + backup;
				
				//prd = $('#selectedProduct_ES_quote').val();
				prd = $(this).closest('tr').find(".productName").text();
				//var prodName = $(this).closest('tr').find(".productName").text();
				
				
				//if(prd == "legacyProductAccesoInternetONOAndVodafone" || prd == "legacyProductMPLSAndVPLSONO"){
				if(prd == "Legacy Internet" || prd == "Legacy MPLS"){					
					mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
					backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();	
					analysisRequestType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					if(prd == "Legacy Internet"){
						prd =  "legacyProductAccesoInternetONOAndVodafone";
					}
					if(prd == "Legacy MPLS"){
						prd = "legacyProductMPLSAndVPLSONO";
					}

					site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + prd + "$$" + fbStatus;	
				}
				if(prd == "Legacy Avalon"){
				//if(prd == "legacyProductVPNAvalon"){
					analysisRequestType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referenceKey").text();	
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
					backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();
					prd =  "legacyProductVPNAvalon";
					site = site + "$$" + analysisRequestType + "$$" + referKey + "$$" + prd + "$$" + fbStatus + "$$" + mainBandwidth + "$$" + backupBandwidth;
				}
				
				if(prd == "Enlance Portador"){				
				//if(prd == "enlacePortador"){
					capacity = $(this).closest('tr').find(".mainBandwidth").text();
					siteType = $(this).closest('tr').find(".analysisType").text();
					refereceKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					prd =  "enlacePortador";					
					site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + capacity + "$$" + siteType + "$$" + refereceKey + "$$" + prd + "$$" + fbStatus;
				}
				if(prd == "IPVPN"){
				//if(prd == "iPVPN"){
					//alert(selectedValue);
					internet = $(this).closest('tr').find(".interet").text();
					ipvpn = $(this).closest('tr').find(".voip").text();
					vlan = $(this).closest('tr').find(".vplnlan").text();
					voip = $(this).closest('tr').find(".cos").text();					
					siteSizePrimary = $(this).closest('tr').find(".siteSize").text();
					modeOfAccessPrimary = $(this).closest('tr').find(".modeOfAccess").text();
					siteType = $(this).closest('tr').find(".analysisType").text();
					refereceKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					prd =  "iPVPN";
					/*monitor = $(this).closest('tr').find(".monitor").text();
					sla = $(this).closest('tr').find(".sla").text();
					cpeSalesModePrimary = $(this).closest('tr').find(".cpeSalesModePrimary").text();
					cpeSalesTypePrimary = $(this).closest('tr').find(".cpeSalesTypePrimary").text();
					siteSizePrimary = $(this).closest('tr').find(".siteSizePrimary").text();
					modeOfAccessPrimary = $(this).closest('tr').find(".modeOfAccessPrimary").text();
					siteSizeSecondary = $(this).closest('tr').find(".siteSizeSecondary").text();
					modeOfAccessSecondary = $(this).closest('tr').find(".modeOfAccessSecondary").text();
					backupRequired = $(this).closest('tr').find().text(".backupRequired");
					iteSizeSecondary = $(this).closest('tr').find(".iteSizeSecondary").text();
					modeOfAccessSecondary = $(this).closest('tr').find(".modeOfAccessSecondary").text();
					cpeSalesModeBackup = $(this).closest('tr').find(".cpeSalesModeBackup").text();
					cpeSalesTypeBackup = $(this).closest('tr').find(".cpeSalesTypeBackup").text();*/
					//siteType = $(this).closest('tr').find().text("");
					//refereceKey = $(this).closest('tr').find(".").text();					
					/*site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" + siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + siteType + "$$" + refereceKey + "$$" + prd;*/
					site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" + siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + siteType + "$$" + refereceKey + "$$" + prd + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + fbStatus;
					
				}
				if(prd == "Primario Fijo" || (prd == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prd.toLowerCase().indexOf("primario m") != -1 && prd.toLowerCase().indexOf("vil") != -1))){					
					mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
					backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();	
					analysisRequestType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					if(prd == "Primario Fijo"){
						prd =  "primarioFijo";
					}
					if((prd == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prd.toLowerCase().indexOf("primario m") != -1 && prd.toLowerCase().indexOf("vil") != -1))){
						prd = "primarioMvil";
					}

					site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + prd + "$$" + fbStatus;	
				}
				//alert(prd);
				if(prd != ""){	
					//Check if site is exist in array if not then push site in array
					res = $.inArray(site, siteSize);
					if(res == -1) {
						siteSize.push(site);
					}
					
					// Store selected site request from table2. 
					$("#cFTRequestForSingleSite_quote").val(site);
					
					//Traverse array and make string
					$.each(siteSize, function() {
						if(selectedSiteDetails != "") {
							selectedSiteDetails = selectedSiteDetails + "##" + this;
						}
						else {
							selectedSiteDetails = this;
						}
					});
					
					//Traverse array and make string
					$.each(siteSize, function() {
						if(siteDetails != "") {
							siteDetails = siteDetails + "##" + this;
						}
						else {
							siteDetails = this;
						}
					});
					
					//alert(selectedSiteDetails);
					//alert(siteDetails);
				
					//Assign selected site details string to quote level attribute.
					$("#cFTRequestParameter_quote").val(siteDetails);	
					$("#cFTAllSelectedRequestParameters_quote").val(selectedSiteDetails);
				}
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = ""; var ss1 = "";
				var selectedValue = $(this).val();
				
				//Get site and Address from html and prepared string
				requestID = selectedValue;
				siteID = $(this).closest('tr').find(".siteName").text();
				siteAddress = $(this).closest('tr').find(".siteAddress").text();
				service = $(this).closest('tr').find(".mainService").text();
				backup = $(this).closest('tr').find(".backupService").text();
				mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
				backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();
				
				site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + service + "$$" + backup;
				
				//prd = $('#selectedProduct_ES_quote').val();
				prd = $(this).closest('tr').find(".productName").text();
				
				if(prd == "Legacy Internet" || prd == "Legacy MPLS"){
				//if(prd == "legacyProductAccesoInternetONOAndVodafone" || prd == "legacyProductMPLSAndVPLSONO"){
					mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
					backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();	
					analysisRequestType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					if(prd == "Legacy Internet"){
						
						prd =  "legacyProductAccesoInternetONOAndVodafone";
						
					}
					if(prd == "Legacy MPLS"){
						
						prd = "legacyProductMPLSAndVPLSONO";
						
					}
					site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + prd + "$$" + fbStatus;
				}
				if(prd == "Legacy Avalon"){
				//if(prd == "legacyProductVPNAvalon"){
					analysisRequestType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
					backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();
					prd =  "legacyProductVPNAvalon";
					site = site + "$$" + analysisRequestType + "$$" + referKey + "$$" + prd + "$$" + fbStatus + "$$" + mainBandwidth + "$$" + backupBandwidth;
				}
				//Empty selected site request.
				if(prd == "Enlance Portador"){
				//if(prd == "enlacePortador"){
					capacity = $(this).closest('tr').find(".mainBandwidth").text();
					siteType = $(this).closest('tr').find(".analysisType").text();
					refereceKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					prd = "enlacePortador";					
					site = site + "$$" + capacity + "$$" + siteType + "$$" + refereceKey + "$$" + prd + "$$" + fbStatus;
				}
				if(prd == "IPVPN"){
				//if(prd == "iPVPN"){
					//alert(selectedValue);
					internet = $(this).closest('tr').find(".interet").text();
					ipvpn = $(this).closest('tr').find(".voip").text();
					vlan = $(this).closest('tr').find(".vplnlan").text();
					voip = $(this).closest('tr').find(".cos").text();					
					siteSizePrimary = $(this).closest('tr').find(".siteSize").text();
					modeOfAccessPrimary = $(this).closest('tr').find(".modeOfAccess").text();
					siteType = $(this).closest('tr').find(".analysisType").text();
					refereceKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					prd = "iPVPN";
					/*monitor = $(this).closest('tr').find(".monitor").text();
					sla = $(this).closest('tr').find(".sla").text();
					cpeSalesModePrimary = $(this).closest('tr').find(".cpeSalesModePrimary").text();
					cpeSalesTypePrimary = $(this).closest('tr').find(".cpeSalesTypePrimary").text();
					siteSizePrimary = $(this).closest('tr').find(".siteSizePrimary").text();
					modeOfAccessPrimary = $(this).closest('tr').find(".modeOfAccessPrimary").text();
					siteSizeSecondary = $(this).closest('tr').find(".siteSizeSecondary").text();
					modeOfAccessSecondary = $(this).closest('tr').find(".modeOfAccessSecondary").text();
					backupRequired = $(this).closest('tr').find().text(".backupRequired");
					iteSizeSecondary = $(this).closest('tr').find(".iteSizeSecondary").text();
					modeOfAccessSecondary = $(this).closest('tr').find(".modeOfAccessSecondary").text();
					cpeSalesModeBackup = $(this).closest('tr').find(".cpeSalesModeBackup").text();
					cpeSalesTypeBackup = $(this).closest('tr').find(".cpeSalesTypeBackup").text();*/
					//siteType = $(this).closest('tr').find().text("");
					//refereceKey = $(this).closest('tr').find(".").text();					
					/*site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" + siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + siteType + "$$" + refereceKey + "$$" + prd;*/
					site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" + siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + siteType + "$$" + refereceKey + "$$" + prd + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + fbStatus;
					
				}
				if(prd == "Primario Fijo" || (prd == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prd.toLowerCase().indexOf("primario m") != -1 && prd.toLowerCase().indexOf("vil") != -1))){					
					mainBandwidth = $(this).closest('tr').find(".mainBandwidth").text();
					backupBandwidth = $(this).closest('tr').find(".backupBandwidth").text();	
					analysisRequestType = $(this).closest('tr').find(".analysisType").text();
					referKey = $(this).closest('tr').find(".referenceKey").text();
					fbStatus = $(this).closest('tr').find(".fbStatus").text();
					if(prd == "Primario Fijo"){
						prd =  "primarioFijo";
					}
					if((prd == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prd.toLowerCase().indexOf("primario m") != -1 && prd.toLowerCase().indexOf("vil") != -1))){
						prd = "primarioMvil";
					}

					site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + prd + "$$" + fbStatus;	
				}
				
				$("#cFTRequestForSingleSite_quote").val("");
				
				siteDetails = $("#cFTRequestParameter_quote").val();
				AllSiteDetails = $("#cFTAllSelectedRequestParameters_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
				
				if(AllSiteDetails != "") {
					AllSiteSize = AllSiteDetails.split("##");
				}
				
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Remove unchecked element from selected sites array.
				AllSiteSize = $.grep(AllSiteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				//Prepare string and store in attribute.
				$.each(AllSiteSize, function() {
					if(ss1 != "") {
						ss1 = ss1 + "##" + this;
					} else {
						ss1 = this;
					}
				});
				
				$("#cFTRequestParameter_quote").val(ss);
				$("#cFTAllSelectedRequestParameters_quote").val(ss1);				
			}
		});
		/***********END GET CFT REQUEST PARAMETERS FOR SITES ******************/
		
		/* @3.1 Manual Feasibility Request input parameters*/
		
		$('#field_wrapper_1_selectService_quote select').on("change",function(){
		   $('#accessSpeedSelectedValue_quote').val('');
		   $('#flowRateSelectedValue_quote').val('');
		    $('#flowRateSelectedValue_quote').val('');
		    $('#pagerefreshforapproval').click();
		});
		
		//For populate WAN Interface refresh page
		$('#field_wrapper_1_serviceTypeManaulRequest_quote select').on("change",function(){
		   $('#pagerefreshforapproval').click();
		});
		
		$('#attr_wrapper_1_wANInterface_quote select').on("change",function(){
			//alert($(this).val());
		   $('#wANInterfaceSelectedValue_quote').val($(this).val());
		   $('#pagerefreshforapproval').click();
		});

		 $('#selectedProduct_ES_quote select').on("change",function(){
			alert($(this).val());
		 $('#showMessageAlertForOneNet_quote').val("show message");
		 });
		// show message when you select product
		 $('#field_wrapper_1_activeLoyaltyGroupsES_quote select').on("change",function(){
			 //alert($(this).val());
		    $('#testText9ES_quote').val($(this).val());
		 });
		$('#field_wrapper_1_accessSpeed_quote select').on("change",function(){
			//alert($(this).val());
		   $('#accessSpeedSelectedValue_quote').val($(this).val());
		   $('#pagerefreshforapproval').click();
		});
		//$('#accessSpeedSelectedValue_quote').val('');
		//@PROJ-1518023_BUG-0897
		/*$('#add_to_services').on("click",function(){
			var tt = $('#accessSpeedSelectedValue_quote').val();
			alert(tt);
			//$('#wANInterfaceSelectedValue_quote').val($(this).val());
			//$('#flowRateSelectedValue_quote').val($(this).val());
		});*/
		
		$('#field_wrapper_1_flowRate_quote select').on("change",function(){
			//alert($(this).val());
		   $('#flowRateSelectedValue_quote').val($(this).val());
		   $('#pagerefreshforapproval').click();
		});
		
		//Clear Table 3 and table4 selection @DEFECT
		$("#cFTResponseForSingleSite_quote").val('');
		$("#1_textAreaES3_quote").val('');
		//Empty string after error message.
		errrMsg = $("ul.error-text li:eq(2)").text();
		//alert(errrMsg);
		if(errrMsg == "Bandwidth is not define for selected services"){
			$("#cFTRequestParameter_quote").val("");
			//$("ul.error-text li:eq(2)").text('');
		}
		
		$("#manualFeasibilityRequestParameters_quote").val('');
		//Defect 743
		$("#manualFeasibilityValidateRequest_quote").val('');
		//Defect 708
		//$('#selectedSitesInformation_quote").val('');
		//@Defect 1117
		$("#manualFeasibilityCancellationRequest_quote").val('');
		
		
		//WA-Needs to remove this code after actual fix.
		/*if($("body").hasClass("model-config")) {
			var attr = $(this).attr('cPEBundleDescription_ES');

			// For some browsers, `attr` is undefined; for others,
			// `attr` is false.  Check for both.
			if (typeof attr !== typeof undefined && attr !== false) {
				var temp;
				temp = $('#bundleLegacyMPLS_ES').val();
				var bundleDesc;
				bundleDesc = $('#cPEBundleDescription_ES').val();
				if(temp != "" && bundleDesc == ""){
					$("#update").click();
				}
			}
		}*/
		
		
		/***********###3.1 START Get Automatic/Manual Feasibility Response **************/
		$("#fixed_hdr3 input[type=checkbox]").on("change",function() {
			var siteSize = [];
			if( $( this ).prop( "checked" ) ) {	
				//alert("called");
				var manRequestID = $(this).val();
				var siteID = "";
				var siteDetails = "";    
				var site = "";
				var prdName = "";
				
				
				//Empty string after error message.
				errrMsg = $("ul.error-text li:eq(2)").text();
				//alert(errrMsg);
				if(errrMsg == "Configure RAG Status"){
					$("#manualFeasibilityValidateRequest_quote").val('');
					$("#manualFeasibilityRequestParameters_quote").val('');
					$("ul.error-text li:eq(2)").text('');
				}
				
				//Empty string after configuration.
				//alert($("#testText6ES_quote").val());
				if($("#testText6ES_quote").val() == "true"){
					$("#manualFeasibilityValidateRequest_quote").val('');
					$("#manualFeasibilityRequestParameters_quote").val('');
					$("#testText6ES_quote").val('');
				}
				
				
				//$("#testTextArea9ES_quote").val("");
				//Get existing site details value
				siteDetails = $("#manualFeasibilityValidateRequest_quote").val();
				//alert(siteDetails);
				//siteDetails = $("#1_1_textAreaES3_quote").val();
				//$("#manualFeasibilityValidateRequest_quote").val("");
				//Get Service Details for Manual Feasibility Request.
				//alert(siteDetails);
				//Get site and Address from html and prepared string
				selectedRow = $(this).closest('tr').find('td').find('input').val();
				autoRequestID = $(this).closest('tr').find(".autoRequestID").text();
				//siteID = $(this).closest('tr').find('td:eq(2)').text();
				configurationStatus = $(this).closest('tr').find(".configurationStatus").text();
				siteName = $(this).closest('tr').find(".siteName").text();
				siteAddress = $(this).closest('tr').find(".siteAddress").text();
				primaryAccess = $(this).closest('tr').find(".primaryAccess").text();
				primaryRAG = $(this).closest('tr').find(".primaryRAG").text();
				
				//Change for Search Functionality.
				if(primaryRAG == "RED"){
					primaryRAG = "R";
				}
				else if(primaryRAG == "GREEN"){
					primaryRAG = "G";
				}
				else if(primaryRAG == "AMBER"){
					primaryRAG = "A";
				}
				else if(primaryRAG == "Gray"){
					primaryRAG = "Gray";
				}
				else if(primaryRAG == "BLUE"){
					primaryRAG = "B";
				}
				else{
					primaryRAG = "";
				}
				
				feasibilityExpiryDate = $(this).closest('tr').find(".expiryDate").text();
				//@3.1
				feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
				cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
				studyLevel = $(this).closest('tr').find('td').find('select').val();
				analysisType = $(this).closest('tr').find(".analysisType").text();
				autoFID = $(this).closest('tr').find(".autoFID").text();
				cftStatus = $(this).closest('tr').find(".cftStatus").text();
				slA = $(this).closest('tr').find(".slA").text();
				refereKey = $(this).closest('tr').find(".refereKey").text();
				leadTime = $(this).closest('tr').find(".leadTime").text();
				prdName = $(this).closest('tr').find(".prdName").text();
				//alert(analysisType);
				//alert(refereKey);
				if(prdName == "Legacy Avalon"){
					prdName = "legacyProductVPNAvalon";
				}
				if(prdName == "Legacy MPLS"){
					prdName = "legacyProductMPLSAndVPLSONO";
				}
				if(prdName == "Legacy Internet"){
					prdName = "legacyProductAccesoInternetONOAndVodafone";
				}
				if(prdName == "Enlance Portador"){
					prdName = "enlacePortador";
				}
				if(prdName == "IPVPN"){
					prdName = "iPVPN";
				}
				if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioFijo";
				}	
				if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioMvil";
				}
				//Get existing site details valuek8
				userGroup = $("#1_currentUserGroup_quote").val();
				
				site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + cftStatus + "$$" + slA + "$$" + refereKey + "$$" + leadTime + "$$" + prdName;				
				//alert(prdName);
				
				if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
					feasibilityStatus = $(this).closest('tr').find('td:eq(11)').text();
					
					//@Cost Attributes
					CapEx = $(this).closest('tr').find(".capEx").text();
					Initial_OpEx = $(this).closest('tr').find(".initialOpEx").text();
					Recurring_OpEx = $(this).closest('tr').find(".recurringOpEx").text();
					
					//@3.1
					feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
					cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
					studyLevel = $(this).closest('tr').find('td').find('select').val();
					analysisType = $(this).closest('tr').find(".analysisType").text();
					autoFID = $(this).closest('tr').find(".autoFID").text();
					
					cftStatus = $(this).closest('tr').find(".cftStatus").text();
					slA = $(this).closest('tr').find(".slA").text();
					refereKey = $(this).closest('tr').find(".refereKey").text();
					leadTime = $(this).closest('tr').find(".leadTime").text();
					prdName = $(this).closest('tr').find(".prdName").text();
					if(prdName == "Legacy Avalon"){
						prdName = "legacyProductVPNAvalon";
					}
					if(prdName == "Legacy MPLS"){
						prdName = "legacyProductMPLSAndVPLSONO";
					}
					if(prdName == "Legacy Internet"){
						prdName = "legacyProductAccesoInternetONOAndVodafone";
					}
					if(prdName == "Enlance Portador"){
						prdName = "enlacePortador";
					}
					if(prdName == "IPVPN"){
						prdName = "iPVPN";
					}
					if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioFijo";
					}	
					if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioMvil";
					}
					//site = site + "$$" + CapEx + "$$" + Initial_OpEx + "$$" + Recurring_OpEx; 
					
					site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID  + "$$" + CapEx+ "$$" + Initial_OpEx + "$$" + Recurring_OpEx + "$$" + cftStatus + "$$" + slA + "$$" + refereKey + "$$" + leadTime + "$$" + prdName ;
					//alert(site);
				}
				
				//Check if site is exist in array if not then push site in array
				res = $.inArray(site, siteSize);
				if(res == -1) {
					siteSize.push(site);
				}
				
				//Traverse array and make string
				$.each(siteSize, function() {
					if(siteDetails != "") {
						siteDetails = siteDetails + "##" + this;
					}
					else {
						siteDetails = this;
					}
				});
				//alert(siteDetails);
				//stored selected site string of table 4 (Manaul Feasibility Response)for configuration.
				$("#1_textAreaES3_quote").val(siteDetails);
				//alert(siteDetails);
				//Get selected rows for manual feasiblity requset parameter.
				$("#manualFeasibilityValidateRequest_quote").val(siteDetails);
				
				//Get selected rows for manual feasiblity requset parameter.
				$("#manualFeasibilityCancellationRequest_quote").val(siteDetails);
				
			}	
			else {
				//Uncheck code start here
				var site = "";
				var ss = ""; var ss1 = "";
				var prdName = "";
				var manRequestID = $(this).val();
				
				
				//Get site and Address from html and prepared string
				selectedRow = $(this).closest('tr').find('td').find('input').val();
				
				//@Start
				autoRequestID = $(this).closest('tr').find(".autoRequestID").text();
				//siteID = $(this).closest('tr').find('td:eq(2)').text();
				configurationStatus = $(this).closest('tr').find(".configurationStatus").text();
				siteName = $(this).closest('tr').find(".siteName").text();
				siteAddress = $(this).closest('tr').find(".siteAddress").text();
				primaryAccess = $(this).closest('tr').find(".primaryAccess").text();
				primaryRAG = $(this).closest('tr').find(".primaryRAG").text();
				//Change for Search Functionality.
				if(primaryRAG == "RED"){
					primaryRAG = "R";
				}
				else if(primaryRAG == "GREEN"){
					primaryRAG = "G";
				}
				else if(primaryRAG == "AMBER"){
					primaryRAG = "A";
				}
				else if(primaryRAG == "Gray"){
					primaryRAG = "Gray";
				}
				else if(primaryRAG == "BLUE"){
					primaryRAG = "B";
				}
				else{
					primaryRAG = "";
				}
				feasibilityExpiryDate = $(this).closest('tr').find(".expiryDate").text();
				//@3.1
				feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
				cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
				studyLevel = $(this).closest('tr').find('td').find('select').val();
				analysisType = $(this).closest('tr').find(".analysisType").text(); 
				autoFID = $(this).closest('tr').find(".autoFID").text();
				//Get existing site details valuek8
				userGroup = $("#1_currentUserGroup_quote").val();
				
				cftStatus = $(this).closest('tr').find(".cftStatus").text();
				slA = $(this).closest('tr').find(".slA").text();
				refereKey = $(this).closest('tr').find(".refereKey").text();
				leadTime = $(this).closest('tr').find(".leadTime").text();
				prdName = $(this).closest('tr').find(".prdName").text();
				if(prdName == "Legacy Avalon"){
					prdName = "legacyProductVPNAvalon";
				}
				if(prdName == "Legacy MPLS"){
					prdName = "legacyProductMPLSAndVPLSONO";
				}
				if(prdName == "Legacy Internet"){
					prdName = "legacyProductAccesoInternetONOAndVodafone";
				}
				if(prdName == "Enlance Portador"){
					prdName = "enlacePortador";
				}
				if(prdName == "IPVPN"){
					prdName = "iPVPN";
				}
				if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioFijo";
				}	
				if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
					prdName = "primarioMvil";
				}
				
				/*site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + cftStatus + "$$" + slA + "$$" + refereKey + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + leadTime + "$$" + prdName;*/
				site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + cftStatus + "$$" + slA + "$$" + refereKey + "$$" + leadTime + "$$" + prdName;
				
				if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
					//feasibilityStatus = $(this).closest('tr').find('td:eq(11)').text();
					
					//@Cost Attributes
					CapEx = $(this).closest('tr').find(".capEx").text();
					Initial_OpEx = $(this).closest('tr').find(".initialOpEx").text();
					Recurring_OpEx = $(this).closest('tr').find(".recurringOpEx").text();
					
					//@3.1
					feasibilityStatus = $(this).closest('tr').find(".feasibilityStatus").text();
					cftErrorDesc = $(this).closest('tr').find(".cftErrorDesc").text();
					studyLevel = $(this).closest('tr').find('td').find('select').val();
					analysisType = $(this).closest('tr').find(".analysisType").text();
					autoFID = $(this).closest('tr').find(".autoFID").text();
					//site = site + "$$" + CapEx + "$$" + Initial_OpEx + "$$" + Recurring_OpEx; 
					
					cftStatus = $(this).closest('tr').find(".cftStatus").text();
					slA = $(this).closest('tr').find(".slA").text();
					refereKey = $(this).closest('tr').find(".refereKey").text();
					leadTime = $(this).closest('tr').find(".leadTime").text();
					prdName = $(this).closest('tr').find(".prdName").text();
					if(prdName == "Legacy Avalon"){
						prdName = "legacyProductVPNAvalon";
					}
					if(prdName == "Legacy MPLS"){
						prdName = "legacyProductMPLSAndVPLSONO";
					}
					if(prdName == "Legacy Internet"){
						prdName = "legacyProductAccesoInternetONOAndVodafone";
					}
					if(prdName == "Enlance Portador"){
						prdName = "enlacePortador";
					}
					if(prdName == "IPVPN"){
						prdName = "iPVPN";
					}
					if(prdName == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioFijo";
					}	
					if(prdName == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prdName.toLowerCase().indexOf("primario m") != -1 && prdName.toLowerCase().indexOf("vil") != -1)){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						prdName = "primarioMvil";
					}
					/*site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID + "$$" + cftStatus + "$$" + slA + "$$" + refereKey + "$$" + CapEx+ "$$" + Initial_OpEx + "$$" + Recurring_OpEx + "$$" + leadTime + "$$" + prdName  ;*/
					site = manRequestID + "$$" + autoRequestID + "$$" + configurationStatus + "$$" + siteName + "$$" + siteAddress + "$$" + primaryAccess + "$$" + primaryRAG + "$$" + feasibilityExpiryDate + "$$" + feasibilityStatus + "$$" + cftErrorDesc + "$$" + studyLevel + "$$" + analysisType + "$$" + autoFID  + "$$" + CapEx+ "$$" + Initial_OpEx + "$$" + Recurring_OpEx + "$$" + cftStatus + "$$" + slA + "$$" + refereKey + "$$" + leadTime + "$$" + prdName ;
				}

				//Get CFT automatic Request Parameter Value
				siteDetails = $("#manualFeasibilityValidateRequest_quote").val();
				
				if(siteDetails != "") {
					siteSize = siteDetails.split("##");
				}
								
				//Remove unchecked element from selected sites array.
				siteSize = $.grep(siteSize, function(value) {
					return value != site;
				});
				
				//Prepare string and store in attribute.
				$.each(siteSize, function() {
					if(ss != "") {
						ss = ss + "##" + this;
					} else {
						ss = this;
					}
				});
				
				//Empty Selected sites string.
				$("#1_textAreaES3_quote").val(ss);
				
				//Get selected rows for manual feasiblity requset parameter.
				$("#manualFeasibilityValidateRequest_quote").val(ss);
				
				//Get selected rows for manual feasiblity requset parameter.
				$("#manualFeasibilityCancellationRequest_quote").val(ss);
			}
		});
		/***********END GET CFT RESPONSE FOR SITE CONFIGURATION**************/
		
		//@Defect 935 - Remove EP for Account manager
		/*userGroup = $("#1_currentUserGroup_quote").val();
		if(userGroup == "accountManager_ES"){
			$("#field_wrapper_1_selectProductES_quote select option[value='enlacePortador']").remove();
		}*/
		
		//@Defect 1086 - Tab name fix for SIP & IP Trunk
		$('#attr-selectPricePlan_IPTrunk_ES-constraint').find('.tab-name').text('Product Confiugration ');
		
		/***********START DELETE CFT REQUEST FROM TABLE 2**************/
		$(document).on('click', '.array-remove', function () {
			//Uncheck code start here
			var site = "";
			var ss = "";
			var ss1 = "";
 			var siteSize = [];
			var siteDetails = "";
			var siteSize1 = [];
			var siteDetails1 = "";
			var siteID = "";
			var selectedSiteDetails = "";
			var prd = "";
			var manualServiceDetail = "";
			var cftReq = "";
			siteID = $(this).closest('tr').find('.siteName').text();
			cftReq = $(this).closest('tr').find('input:checkbox').val();
			//alert(cftReq);
			//Get Parse Response
			siteDetails = $("#cFTParseResponse_quote").val();
			
			Service1 = $(this).closest('tr').find('td:eq(0)').text();
			
			var n = siteDetails.search(cftReq); 
			//Check if feasiblity done or not
			if(n >= 0 && Service1 !== "Voice" && Service1 !== "Symmetric Data" && Service1 !== "Asymmetric Data" && Service1 !== "Carrying Circuits") {
				alert("Feasibility completed, deletion from this table is not permitted");
			}
			else {
				//alert($(this).closest('tr').find('td:eq(0)').prop("checked"));
				var result = confirm("Click OK to Delete or Cancel to retain the selected record(s)");
				if (result) {
					//Get site and Address from html and prepared string
					
					var selectedValue = $(this).val();
					//Get site and Address from html and prepared string
					//requestID = selectedValue;
					siteID = $(this).closest('tr').find('.siteName').text();
					siteAddress = $(this).closest('tr').find('.siteAddress').text();
					service = $(this).closest('tr').find('.mainService').text();
					backup = $(this).closest('tr').find('.backupService').text();
					
					//Get Manaul Feasiblity Service Selection	
					if(siteID !== "Voice" || siteID !== "Symmetric Data" || siteID !== "Asymmetric Data"){
						Service1 = $(this).closest('tr').find('td:eq(0)').text();
						ServiceType = $(this).closest('tr').find('td:eq(1)').text();
						WANInterface = $(this).closest('tr').find('td:eq(2)').text();
						SpeedAccess = $(this).closest('tr').find('td:eq(3)').text();
						FlowRate = $(this).closest('tr').find('td:eq(4)').text();
						Quantity = $(this).closest('tr').find('td:eq(5)').text();
						manualServiceDetail = Service1 + "$$" + ServiceType + "$$" + WANInterface + "$$" + SpeedAccess +"$$" + FlowRate + "$$" + Quantity;
					}
					
					//prd = $('#field_wrapper_1_selectProductES_quote select').val();
					prd = $(this).closest('tr').find('.productName').text();
					
					/*if(prd == "iPVPN"){
						prd = "iPVPN";
					}else{
						prd = $(this).closest('tr').find('td:eq(9)').text();
					}*/

					//site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + service + "$$" + backup;	
					site = siteID + "$$" + siteAddress + "$$" + service + "$$" + backup;	
					if(prd == "Legacy Internet"){
						mainBandwidth = $(this).closest('tr').find('.mainBandwidth').text();
						backupBandwidth = $(this).closest('tr').find('.backupBandwidth').text();	
						analysisRequestType = $(this).closest('tr').find('.analysisType').text();
						referKey = $(this).closest('tr').find('.referenceKey').text();
						site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + "legacyProductAccesoInternetONOAndVodafone";
					}
					
					if(prd == "Legacy MPLS"){
						mainBandwidth = $(this).closest('tr').find('.mainBandwidth').text();
						backupBandwidth = $(this).closest('tr').find('.backupBandwidth').text();	
						analysisRequestType = $(this).closest('tr').find('.analysisType').text();
						referKey = $(this).closest('tr').find('.referenceKey').text();
						site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + "legacyProductMPLSAndVPLSONO";
					}
					
					if(prd == "Legacy Avalon"){
						analysisRequestType = $(this).closest('tr').find('.analysisType').text();
						referKey = $(this).closest('tr').find('.referenceKey').text();					
						mainBandwidth = $(this).closest('tr').find('.mainBandwidth').text();
						backupBandwidth = $(this).closest('tr').find('.backupBandwidth').text();							
						site = site + "$$" + analysisRequestType + "$$" + referKey + "$$" + "legacyProductVPNAvalon" + "$$" + mainBandwidth + "$$" + backupBandwidth;
					}
					
					if(prd == "Enlance Portador"){
						capacity = $(this).closest('tr').find('.mainBandwidth').text();
						siteType = $(this).closest('tr').find('.analysisType').text();
						refereceKey = $(this).closest('tr').find('.referenceKey').text();		
						//site = requestID + "$$" + siteID + "$$" + siteAddress + "$$" + capacity + "$$" + siteType + "$$" + refereceKey + "$$" + prd;
						site = siteID + "$$" + siteAddress + "$$" + capacity + "$$" + siteType + "$$" + refereceKey + "$$" + "enlacePortador";
					}
					
					//if(prd != "enlacePortador" || prd != "legacyProductVPNAvalon" || prd != "legacyProductAccesoInternetONOAndVodafone" || prd != "legacyProductMPLSAndVPLSONO" && prd == "iPVPN"){
					if(prd == "IPVPN"){
						var selectedValue = $(this).val();
						//Get site and Address from html and prepared string
						site = "";
						siteID = $(this).closest('tr').find('.siteName').text();
						
						//Get Manaul Feasiblity Service Selection
						if(siteID !== "Voice" || siteID !== "Symmetric Data" || siteID !== "Asymmetric Data"){
							Service1 = $(this).closest('tr').find('td:eq(0)').text();
							ServiceType = $(this).closest('tr').find('td:eq(1)').text();
							WANInterface = $(this).closest('tr').find('td:eq(2)').text();
							SpeedAccess = $(this).closest('tr').find('td:eq(3)').text();
							FlowRate = $(this).closest('tr').find('td:eq(4)').text();
							Quantity = $(this).closest('tr').find('td:eq(5)').text();
							manualServiceDetail = Service1 + "$$" + ServiceType + "$$" + WANInterface + "$$" + SpeedAccess +"$$" + FlowRate + "$$" + Quantity;
						}
						
						siteAddress = $(this).closest('tr').find('.siteAddress').text();
						internet = $(this).closest('tr').find('.interet').text();
						ipvpn = $(this).closest('tr').find('.voip').text();
						vlan = $(this).closest('tr').find('.vplnlan').text();
						voip = $(this).closest('tr').find('.cos').text();
						/*monitor = $(this).closest('tr').find('td:eq(7)').text();
						sla = $(this).closest('tr').find('td:eq(8)').text();
						cpeSalesModePrimary = $(this).closest('tr').find('td:eq(9)').text();
						cpeSalesTypePrimary = $(this).closest('tr').find('td:eq(10)').text();*/
						siteSizePrimary = $(this).closest('tr').find('.siteSize').text();
						modeOfAccessPrimary = $(this).closest('tr').find('.modeOfAccess').text();
						backupRequired = $(this).closest('tr').find('td:eq(13)').text();
						//siteSizeSecondary = $(this).closest('tr').find('td:eq(14)').text();*/
						analysisRequestType = $(this).closest('tr').find('.analysisType').text();
						referKey = $(this).closest('tr').find('.referenceKey').text();	
						
						site = siteID + "$$" + siteAddress + "$$" + internet + "$$" + ipvpn + "$$" + vlan + "$$" + voip + "$$" +  siteSizePrimary + "$$" + modeOfAccessPrimary + "$$" + "" + "$$" + "" + "$$" + "" + "$$" + ""+ "$$" + analysisRequestType + "$$" + referKey;
						
						if(analysisRequestType == "Main"){
							site = site + "$$" + "false";
						}
					}
					if(prd == "Primario Fijo"){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						mainBandwidth = $(this).closest('tr').find('.mainBandwidth').text();
						backupBandwidth = $(this).closest('tr').find('.backupBandwidth').text();	
						analysisRequestType = $(this).closest('tr').find('.analysisType').text();
						referKey = $(this).closest('tr').find('.referenceKey').text();
						site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + "primarioFijo";
					}
					if((prd == "Primario mÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³vil" || (prd.toLowerCase().indexOf("primario m") != -1 && prd.toLowerCase().indexOf("vil") != -1))){	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
						mainBandwidth = $(this).closest('tr').find('.mainBandwidth').text();
						backupBandwidth = $(this).closest('tr').find('.backupBandwidth').text();	
						analysisRequestType = $(this).closest('tr').find('.analysisType').text();
						referKey = $(this).closest('tr').find('.referenceKey').text();
						site = site + "$$" + mainBandwidth + "$$" + backupBandwidth + "$$" + analysisRequestType + "$$" + referKey + "$$" + "primarioMvil";
					}
					
					//alert(site);
					/*Start CFT Request Deletion*/
					siteDetails = $("#cFTRequestSitesServices_quote").val();
					
					if(siteDetails != "") {
						siteSize = siteDetails.split("##");
					}

					//Remove unchecked element from selected sites array.
					siteSize = $.grep(siteSize, function(value) {
						return value != site;
					});

					//Prepare string and store in attribute.
					$.each(siteSize, function() {
						if(ss != "") {
							ss = ss + "##" + this;
						} else {
							ss = this;
						}
					});
					
					$("#cFTRequestSitesServices_quote").val(ss);	
					/*End*/
					
					/*Start CFT Request Deletion*/
					siteDetails1 = $("#manualFeasibilityServiceSelectionDetails_quote").val();
					if(siteDetails1 != "") {
						siteSize1 = siteDetails1.split("##");
					}

					//Remove unchecked element from selected sites array.
					siteSize1 = $.grep(siteSize1, function(value) {
						return value != manualServiceDetail;
					});

					//Prepare string and store in attribute.
					$.each(siteSize1, function() {
						if(ss1 != "") {
							ss1 = ss1 + "##" + this;
						} else {
							ss1 = this;
						}
					});
					$("#manualFeasibilityServiceSelectionDetails_quote").val(ss1);	
					/*End*/
					
					$(this).closest('tr').remove();
					return false;
				}
			}
			 //e.preventDefault();
		});
		
		//Table1
		$('#searchAddFeasibilityRequest_quote').keyup(function() {
			SelectedProduct = $('#attr_wrapper_1_selectProductES_quote select').val();
			if(SelectedProduct == "iPVPN" ||  SelectedProduct == "enlacePortador" ||SelectedProduct == "legacyProductAccesoInternetONOAndVodafone" || SelectedProduct == "legacyProductMPLSAndVPLSONO" || SelectedProduct == "legacyProductVPNAvalon" || SelectedProduct == "primarioFijo"	 || SelectedProduct == "primarioMvil"){
				var $rows = $('#cftFeasiblilty tbody tr:not(:nth-child(1))');
				var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');
				$rows.hide().filter(function() {
					var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
					var matchesSearch = true;
					$(val).each(function(index, value) {
						matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
					});
					return matchesSearch;
				}).show();
			}else{
				var $rows = $('#siteDetailsForSIP tbody tr:not(:nth-child(1))');
				var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');
				$rows.hide().filter(function() {
					var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
					var matchesSearch = true;
					$(val).each(function(index, value) {
						matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
					});
					return matchesSearch;
				}).show();
			}
		});
		
		//Table2	
		$('#searchAuotmaticRequest_quote').keyup(function() {
		  var $rows = $('#cftRequestSitesLegacy tbody tr:not(:nth-child(1))');
		  var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');

		  $rows.hide().filter(function() {
			var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
			var matchesSearch = true;
			$(val).each(function(index, value) {
			  matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
			});
			return matchesSearch;
		  }).show();
		});
			
		//Table3
		$('#searchAutomaticResponse_quote').keyup(function() {
		  var $rows = $('#fixed_hdr2 tbody tr');
		  var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');
		  $rows.hide().filter(function() {
			var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
			var matchesSearch = true;
			$(val).each(function(index, value) {
			  matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
			});
			return matchesSearch;
		  }).show();
		});
		
		//Table4
		$('#searchManualResponse_quote').keyup(function() {
			//debugger;
			var $rows = $('#fixed_hdr3 tbody tr');
			var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');
			$rows.hide().filter(function() {
				var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
				var matchesSearch = true;
				$(val).each(function(index, value) {
				  matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
				});
				return matchesSearch;
			}).show();
		});

		//@Defect 0259	
		var strToChk ="";	
		strToChk = $('#feasibilityFilterSelection').val();
		if(strToChk==null)
		{
			strToChk="";
		}
		strOfIndex = strToChk.indexOf("zero");
		if(strOfIndex == -1){
			$('#showColumns_quote0').prop('checked', false);
			var arrToBeHide = [6,7,8,9];
			flag = false;
			showColumns(arrToBeHide,flag);
		}else{
			$('#showColumns_quote0').prop('checked', true);
		}
		
		//Diable Modified Flag checkbox
		//jQuery("td[id*='modifyCostFlag_line_ES'] input[type=checkbox]").attr('disabled','true');
		
		// code for Legacy product checkbox
		$('#showColumns_quote0').click(function() {
			existingSelection = $('#feasibilityFilterSelection').val();
			if(existingSelection==null)
			{
				existingSelection="";
			}
			if(existingSelection.indexOf("zero") == -1){
				existingSelection = existingSelection + "$$" +"zero"; 
				$('#feasibilityFilterSelection').val(existingSelection);	
			}
			else{
				existingSelection = existingSelection.replace('zero','');
				$("#feasibilityFilterSelection").val(existingSelection);
			}
			
			var arrToBeHide = [6,7,8,9];
			if($(this).prop("checked")){
				flag = true;
				showColumns(arrToBeHide,flag);	
			}else{
				flag = false;
				showColumns(arrToBeHide,flag);	
			}
		}); 
		
		
		// if user is account manager then cost&LeadTime should hide
		// added code on 26/09/2016	
		userGroup1 = $("#1_currentUserGroup_quote").val();
		if(userGroup1 == "accountManager_ES"){
			$('#showColumns_quote1').hide();
			$('label[for="showColumns_quote1"]').hide();
		}else{
			if (strToChk.indexOf("one") == -1){
				$('#showColumns_quote1').prop('checked', false);
				var arrToBeHide = [19,20,21,22];
				flag = false;
				showColumns(arrToBeHide,flag);
			}else{
				$('#showColumns_quote1').prop('checked', true);
			}
			
			$('#showColumns_quote1').click(function() {
				//Store the existing selection.
				existingSelection = $('#feasibilityFilterSelection').val();
				if(existingSelection==null)
				{
					existingSelection="";
				}
				if($('#feasibilityFilterSelection').val() != "" && existingSelection.indexOf("one") == -1){
					existingSelection = existingSelection + "$$" +"one"; 
					$('#feasibilityFilterSelection').val(existingSelection);	
				}else{
					existingSelection = existingSelection.replace('one','');
					$("#feasibilityFilterSelection").val(existingSelection);
				}
					
				var arrToBeHide = [19,20,21,22];
				
				if($(this).prop("checked")){
					flag = true;
					showColumns(arrToBeHide,flag);	
				}else{
					flag = false;
					showColumns(arrToBeHide,flag);	
				}
			}); 
		} 
		
		// Checkbox2 - Start
		// code for IPVPN checkbox
		if (strToChk.indexOf("two") == -1){
			$('#showColumns_quote2').prop('checked', false);
			var arrToBeHide = [10,11,12,13,14,15];
			flag = false;
			showColumns(arrToBeHide,flag);
		}else{
			$('#showColumns_quote2').prop('checked', true);
		}
			
		$('#showColumns_quote2').click(function() {
			existingSelection = $('#feasibilityFilterSelection').val();
			if(existingSelection==null)
			{
				existingSelection="";
			}
			if($('#feasibilityFilterSelection').val() != "" && existingSelection.indexOf("two") < 0){
				existingSelection = existingSelection + "$$" +"two"; 
				$('#feasibilityFilterSelection').val(existingSelection);	
			}else{			
				existingSelection = existingSelection.replace('two','');
				$("#feasibilityFilterSelection").val(existingSelection);
			}
			
			var arrToBeHide = [10,11,12,13,14,15];
			if($(this).prop("checked")){
				flag = true;
				showColumns(arrToBeHide,flag);	
			}else{
				flag = false;
				showColumns(arrToBeHide,flag);	
			}
		}); 
		
		//Checkbox3 - start
		if (strToChk.indexOf("three") == -1){
			$('#showColumns_quote3').prop('checked', false);
			var arrToBeHide = [23,24,25,26,27];
			flag = false;
			showColumns(arrToBeHide,flag);
		}else{
			$('#showColumns_quote3').prop('checked', true);
		}
		
		$('#showColumns_quote3').click(function() {
			existingSelection = $('#feasibilityFilterSelection').val();
			if(existingSelection==null)
			{
				existingSelection="";
			}
			if($('#feasibilityFilterSelection').val() != "" && existingSelection.indexOf("three") < 0){
				existingSelection = existingSelection + "$$" +"three"; 
				$('#feasibilityFilterSelection').val(existingSelection);	
			}else{
				existingSelection = existingSelection.replace('three','');
				$("#feasibilityFilterSelection").val(existingSelection);
			}
			var arrToBeHide = [23,24,25,26,27];
			if($(this).prop("checked")){
				flag = true;
				showColumns(arrToBeHide,flag);	
			}else{
				flag = false;
				showColumns(arrToBeHide,flag);	
			}
		}); 

		// // code for Service References checkbox
		$('#showColumns_for_manual_quote0').click(function() {
			var arrToBeHide = [19,22];
			if($(this).prop("checked")){
				flag = true;
				showColumns(arrToBeHide,flag);	
			}else{
				flag = false;
				showColumns(arrToBeHide,flag);	
			}
			
		}); 

		
		//Function for column hide
		function showColumns(arrToBeHide,flag) {
			var i=0;
			//if($(this).prop("checked"))
			//alert("flag is");alert(flag);
			if(flag == true)	
			{
				$(".ft_rwrapper #siteConfigurationForEP tr").each(function(){
					
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
				});
				$("#fixed_hdr2 tr").each(function(){
					
					i=0;
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
					i=0;
					$("td", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
				});
			}else
			{
				i=0;
				$(".ft_rwrapper #siteConfigurationForEP tr").each(function(){
					
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
				});
				$("#fixed_hdr2 tr").each(function(){
					
					i=0;
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
					i=0;
					$("td", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
				});
			}
		}
		
		
		$('#showColumns_for_manual_quote1').click(function() {
			var arrToBeHide = [9,10,11,17,21,22];
			var i=0;
			if($(this).prop("checked"))
			{
				$(".ft_rwrapper #cftManualResponse tr").each(function(){
					
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
				});
				$("#fixed_hdr3 tr").each(function(){
					
					i=0;
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
					i=0;
					$("td", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
				});
			}else
			{
				i=0;
				$(".ft_rwrapper #cftManualResponse tr").each(function(){
					
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
				});
				$("#fixed_hdr3 tr").each(function(){
					
					i=0;
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
					i=0;
					$("td", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
				});
			}
		}); 
			 
		// // code for Technical Details checkbox
		$('#showColumns_for_manual_quote2').click(function() {
			var arrToBeHide = [8,12,13,14,18];
			var i=0;
			if($(this).prop("checked"))
			{
				$(".ft_rwrapper #cftManualResponse tr").each(function(){
					
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
				});
				$("#fixed_hdr3 tr").each(function(){
					
					i=0;
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
					i=0;
					$("td", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).show();
						}
						++i;
					});
				});
			}else
			{
				i=0;
				$(".ft_rwrapper #cftManualResponse tr").each(function(){
					
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
				});
				$("#fixed_hdr3 tr").each(function(){
					
					i=0;
					$("th", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
					i=0;
					$("td", this).each(function(){
						if(arrToBeHide.indexOf(i)>=0)
						{
							$(this).hide();
						}
						++i;
					});
				});
			}
		}); 
		 
		//Quote Life Cycle
		//@Commenting code for now, will enable in 3.2
		/*if($('#field_wrapper_1_quoteType_quote select').val() == 'New'){
		  $('#add_quote_life_cycle').parents('table').eq(0).hide();  
		  $('#tab20806138').hide();
		}else{
		  $('#add_quote_life_cycle').parents('table').eq(0).show(); 
		}
		
		$('#attr_wrapper_1_quoteType_quote select').on("change", function(){
			$('#pagerefreshforapproval').click();
		});	*/
	
		//Validation on perform manual feasibiltiy		
		$("#perform_manual_feasibility").click(function(e) {			
			var temp =$("#manualFeasibilityRequestParameters_quote").val();
			if(temp == ""){
				e.preventDefault();
				alert("Please select record for manual feasibility workaround");
				return false;
			}	
		}); 
		
		$("#manualFeasibilitID_quote").val('');
		//Validation on Run Manual feasibilty
		userGroup = $("#1_currentUserGroup_quote").val();
		//$("#run_manual_feasibility").click(function(e) {
		$("#ejecutar_viabilidad_manual").click(function(e) {
			backupCount = 0; mainCount =0; var manID = ""; mainRef = 0; backupRef = 0;
			var temp =$("#cFTResponseForSingleSite_quote").val();
			if(temp == ""){
				e.preventDefault();
				alert('Please select at least single site to Run manual feasibility');  
				return false;  
			}
			var res = temp.split("##");
			//alert(res);
			for(var i in res){
				var res1 = res[i].split("$$");
				//alert(res1);
				if(userGroup == "accountManager_ES" && (res1[18]== "legacyProductVPNAvalon" || res1[18]== "legacyProductMPLSAndVPLSONO" || res1[18]== "enlacePortador") ){
					e.preventDefault();
					alert('Sales User not allowed to do Feasibility for Complex products');
					$("#cFTResponseForSingleSite_quote").val("");
					return false; 				
				}
				
				if((userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") && (res1[11]== "B-end" || res1[11]== "Backup") && (res1[18] !="enlacePortador")){
					backupCount = backupCount + 1;
				}
				
				if((userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") && (res1[11]== "A-end" || res1[11]== "Main") && (res1[18] !="enlacePortador")){
					mainCount = mainCount + 1;
				}
				
				if(userGroup == "accountManager_ES" && (res1[11]== "B-end" || res1[11]== "Backup")){
					backupCount = backupCount + 1;
				}
				if(userGroup == "accountManager_ES" && (res1[11]== "A-end" || res1[11]== "Main")){
					mainCount = mainCount + 1;
				}
				
				//Update referece index
				if((userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") && res1[13]== "Backup" && res1[18]== "iPVPN"){
					backupRef = backupRef + 1;
				}
				if((userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") && res1[13]== "Main" || res1[8]== "iPVPN"){
					mainRef = mainRef + 1;
				}
			//}
			}
			requestCount = res.length;
			manID = $("#manualFeasibilitID_quote").val();
			
			//Defect @1526
			if(userGroup == "accountManager_ES"){
				//If only backup
				if(requestCount == backupCount){
					e.preventDefault();
					alert('Only Backup feasibiltiy not allowed for sales user');
					//Uncheck current selection
					//$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
					//$("#cFTResponseForSingleSite_quote").val("");
					//$("#manualFeasibilityRequestParameters_quote").val("");
					return false; 				
				}
			}
			
			if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES"){
				//If only backup
				if(requestCount == backupCount && manID == ""){
					e.preventDefault();
					alert('Please enter valid Manual Feasiblity ID,it should be start with Via- only');
					//Uncheck current selection
					$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
					//$("#cFTResponseForSingleSite_quote").val("");
					//$("#manualFeasibilityRequestParameters_quote").val("");
					return false; 				
				}
				
				//If Main + backup
				if(mainCount != backupCount && backupCount != 0 && mainCount != 0){
					e.preventDefault();
					alert('Pair is not matching please select valid pair for manual feasibilty');
					//Uncheck current selection
					$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
					$("#cFTResponseForSingleSite_quote").val("");
					$("#manualFeasibilityRequestParameters_quote").val("");
					return false; 				
				}
				
				//This condition true for IPVPN if user is trying to select mulitple main and backup
				if(backupCount > 1 && mainCount > 1 && mainRef == backupRef){
					e.preventDefault();
					//alert('System is not allowing to do manual feasibility for muiltiple technologies');
					alert('Manual feasibility cannot be requested for more than one pair of main and backup at the same site');
					//Uncheck current selection
					$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
					$("#cFTResponseForSingleSite_quote").val("");
					$("#manualFeasibilityRequestParameters_quote").val("");
					return false; 				
				}
			}
			
		}); 

		//Empty Manual Feasibilty ID value on page refresh.	
		$("#manualFeasibilitID_quote").val();	
		$("#cFTRequestParameter_quote").val("");
		//Validation on perform Run Feasibility	
		userGroup = $("#1_currentUserGroup_quote").val();
		//$("#run_feasibility").click(function(e) {
		$("#ejecutar_viabilidad").click(function(e) {
			var temp =$("#cFTRequestParameter_quote").val();
			if(temp == ""){
				e.preventDefault();
				alert('Please select at least single site to Run Automatic feasibility');  
				return false;  
			}
			//var str = "";
		    
			var res = temp.split("##");
			//alert(res);
			for(var i in res){
			var res1 = res[i].split("$$");
			//alert(res1);
				if(userGroup == "accountManager_ES" && (res1[7]== "legacyProductVPNAvalon" || res1[9]== "legacyProductMPLSAndVPLSONO" || res1[6]== "enlacePortador") ){
					e.preventDefault();
					alert('Sales User not allowed to do Feasibility for Complex products');
					$("#cFTRequestParameter_quote").val("");
					return false; 				
				}
			}
		});	
		
		//@1420
		//$("#run_feasibility").click(function(e) {
		//$("#configurar_sedes").click(function(e) {
		//alert("before configuration");
		//console.log("before migration");
		$("#configure_site").click(function(e) {
		//$("#configurar_sedes").click(function(e) {
			var temp = $("#cFTResponseForSingleSite_quote").val();
			//alert(temp);
			var temp1 = $("#1_textAreaES3_quote").val(); 
			
			/*if(temp == "" || temp1 == ""){
				e.preventDefault();
				alert('Please select at least one response for configuration');  
				return false;  
			}*/
			
			var res = temp.split("##");
			//console.log(res);
			//alert(res);
			for(var i in res){
			var res1 = res[i].split("$$");
			var checkPrimary = "";	// @Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
			//alert(res[i]);
			//alert(res1[18]); // print product name
				if(userGroup == "accountManager_ES" && res1[1].indexOf("QC") >= 0){
					e.preventDefault();
					$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
					alert('Sales User not allowed to configure the TES Feasibilities');
					$("#cFTResponseForSingleSite_quote").val("");
					$("#1_textAreaES3_quote").val();
					return false; 				
				}
				
				//Added this condition to allow account manager to configure ORLA Technologies for Primario Fijo & Movil
				//@Chetan G / 29-12-2016/ For BREQ091(One Net Feasibility)
				 if(res1.length > 18){
					 if(res1[18] == "primarioFijo" || res1[18] == "primarioMvil"){
						 checkPrimary = res1[18];
					 }
				 }
				//alert(res1[18]) ;
				//alert(checkPrimary);
				if(userGroup == "accountManager_ES" && (res[i].indexOf("ORLA T") >= 0 || res[i].indexOf("ORLA E") >= 0) && (checkPrimary.length == 0)){
				//alert("inside the account manager");
				//alert(res[i]);
				e.preventDefault();
					$(".sitename2 .checkbox2").prop("checked", false).trigger("change");
					alert('Sales User not allowed to configure ORLA TECHNOLOGIES');
					$("#cFTResponseForSingleSite_quote").val("");
					$("#1_textAreaES3_quote").val();
					return false; 				
				}
						
			}
		});	
		
		//Code to hide rappel when there is no item in line

		
		var table = $("#line-item-grid tbody");
		table.find('tr').each(function (i) {
			var $tds = $(this).find('td').each(function (i){
				if($(this).text() == "No Line Items Attached" || $(this).text() == "Sin lÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬ ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬ ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÂ¢Ã¢â‚¬Å¾Ã‚Â¢ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬ ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã¢â‚¬Â¦Ãƒâ€šÃ‚Â¡ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬Ãƒâ€¦Ã‚Â¡ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â­neas de ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬ ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬ ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÂ¢Ã¢â‚¬Å¾Ã‚Â¢ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¾Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬ ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡Ãƒâ€šÃ‚Â¬ÃƒÆ’Ã¢â‚¬Â¦Ãƒâ€šÃ‚Â¡ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬Ãƒâ€¦Ã‚Â¡ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â­tem anexadas") {
					$('[name=DiscountES_quote]').val( '' );
					
				}
				
			});
		});

		
		//Code to hide rappel when there is no item in line
		
		//Code to hide delete button in Line Item added by Amit
if($("#1_parentChildStatus").val() == "Parent" && $("#1_currentUserGroup_quote").val() == "tESUsers_ES"){
  $('#line-item-grid').find('*').removeClass("line-item-delete");
  $('#delete_selected').closest("table").hide();
}


	// Code starts for door and floor - 08/02/2017
	
	// Code for removing unwanted table entries.Replace it with blank spaces
	var table = $("#main_floor_door");
	var val1;
	var rowcount=0;
	table.find('tr').each(function (i) {
	     rowcount++;
	     var $tds = $(this).find('td').each(function (i){
		 val1=$(this).text();
		
		 if(val1=="Duplicated-")
		 {
			
			$(this).html("");
		 }
		if(val1=="Stair-")
		 {
			
			$(this).html("");
		 }
		if(val1=="Floor-")
		 {
		
			$(this).html("");
		 }
		 if(val1=="Door-")
		 {
			
			$(this).html("");
		 }
		 if(val1=="Building-")
		 {
			
			$(this).html("");
		 }

		
		});
		
	  
		
        
                                                  
    });
	
	if(rowcount==0)
	{
		$("#searchHomeIdDetails_ES").prop('disabled',true);
	}
	
	var table = $("#backup_floor_door");
	rowcount=0;
	
	table.find('tr').each(function (i) {
	rowcount++;
	var $tds = $(this).find('td').each(function (i){
		 val1=$(this).text();
		
		 if(val1=="Duplicated-")
		 {
			
			$(this).html("");
		 }
		if(val1=="Stair-")
		 {
			
			$(this).html("");
		 }
		if(val1=="Floor-")
		 {
			
			$(this).html("");
		 }
		 if(val1=="Door-")
		 {
			
			$(this).html("");
		 }
		 if(val1=="Building-")
		 {
			
			$(this).html("");
		 }

		
		});
		
	  
		
        
                                                  
    });
	
	if(rowcount==0)
	{
		$("#searchHomeIdDetails_Backup_ES").prop('disabled',true);
	}
	
	
	
	
     //Default values and hogar checkbox and textbox when the page loads
	 
     $("#hogarId_ES").prop('disabled',true);
	 //$("#hogarId_ES").val("");
    if($("#manualEnterHomeIdDetails_ES").attr('data-initial-value') == "true")
	{
            $("#hogarId_ES").prop('disabled',false);
			jQuery("#main_floor_door").find("input[type='radio']").each(function(i)
			{
			jQuery(this).attr('disabled', true);
			});

	}	
    $("#hogarId_Backup_ES").prop('disabled',true);
	//$("#hogarId_Backup_ES").val("");
	if($("#manualEnterHomeIdDetails_Backup_ES").attr('data-initial-value') == "true")
	{
			 $("#hogarId_Backup_ES").prop('disabled',false);
			jQuery("#backup_floor_door").find("input[type='radio']").each(function(i)
			{
			jQuery(this).attr('disabled', true);
			});

	}
    
	//Code to search hogar details in table
	$('#searchHomeIdDetails_ES').keyup(function() {
                                                //alert("ss");
                                                var $rows = $('#main_floor_door tbody tr:not(:nth-child(1))');
                                                var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');
                                                $rows.hide().filter(function() {
                                                                var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
                                                                var matchesSearch = true;
                                                                $(val).each(function(index, value) {
                                                                                matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
                                                                });
                                                                return matchesSearch;
                                                }).show();
                                });


                                $('#searchHomeIdDetails_Backup_ES').keyup(function() {
                                                //alert("ss");
                                                var $rows = $('#backup_floor_door tbody tr:not(:nth-child(1))');
                                                var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase().split(' ');
                                                $rows.hide().filter(function() {
                                                                var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
                                                                var matchesSearch = true;
                                                                $(val).each(function(index, value) {
                                                                                matchesSearch = (!matchesSearch) ? false : ~text.indexOf(value);
                                                                });
                                                                return matchesSearch;
                                                }).show();
                                });




     //Enable/Disable table and textbox on check tick and untick
	 
	$('#manualEnterHomeIdDetails_ES').find("input[type='checkbox']").change(function() {
                                
								var ischecked= $(this).is(':checked');
                                if (ischecked)
                                {
                                console.log("else");
								$("#hogarId_ES").prop('disabled',false);
                                
                                                console.log("else");
                                                jQuery("#main_floor_door").find("input[type='radio']").each(function(i)
                                                {
                                                jQuery(this).attr('disabled', true);
                                                });
                                }
                                
                                else
                                {
                                console.log("if");
								$("#hogarId_ES").prop('disabled',true);
                                $("#selectedDoorAndFloorDetails_ES").val("");
                                jQuery("#main_floor_door").find("input[type='radio']").each(function(i) 
                                                {
                                                jQuery(this).attr('disabled',false);
                                                });
                                }
                                
                
                
    });
                
                
    $('#manualEnterHomeIdDetails_Backup_ES').find("input[type='checkbox']").change(function() {
                                var ischecked= $(this).is(':checked');
                                if (ischecked)
                                {
                                console.log("else");
								$("#hogarId_Backup_ES").prop('disabled',false);
                                
                                                console.log("else");
                                                jQuery("#backup_floor_door").find("input[type='radio']").each(function(i)
                                                {
                                                jQuery(this).attr('disabled', true);
                                                });
                                }
                                
                                else
                                {
                                console.log("if");
								$("#hogarId_Backup_ES").prop('disabled',true);
                                $("#selectedDoorAndFloorDetails_Backup_ES").val("");
                                jQuery("#backup_floor_door").find("input[type='radio']").each(function(i) 
                                                {
                                                jQuery(this).attr('disabled',false);
                                                });
                                }
                                
                
                
    });


    // Get selected hogar details(readonly-text) on radio button event               

$("#main_floor_door").on('change',':radio',function()

{


	var a1=$(this).closest('tr');
	var r6=$(a1).find("td").eq(6).html();
	r6 = r6.replace(/\D/g,'');
	var r2=$(a1).find("td").eq(2).html();
	r2 = r2.replace('Duplicated-','');
	var r3=$(a1).find("td").eq(3).html();
	r3 = r3.replace('Stair-','');
	var r4=$(a1).find("td").eq(4).html();
	r4 = r4.replace('Floor-','');
	var r5=$(a1).find("td").eq(5).html();
	r5 = r5.replace('Door-','');
	//console.log(r6+","+r2+","+r3+","+r4+","+r5);
	$("#selectedDoorAndFloorDetails_ES").val(r6+","+r2+","+r3+","+r4+","+r5);
	$("#attribute-selectedDoorAndFloorDetails_ES").find('span').text(r6+","+r2+","+r3+","+r4+","+r5);
	//$('#myTable > tbody:last-child').append('<tr><td>'+inp+'</td><td></td><td></td></tr>');


});


$("#backup_floor_door").on('change',':radio',function()

{

	var a1=$(this).closest('tr');
	var r6=$(a1).find("td").eq(6).html();
	r6 = r6.replace(/\D/g,'');
	var r2=$(a1).find("td").eq(2).html();
	r2 = r2.replace('Duplicated-','');
	var r3=$(a1).find("td").eq(3).html();
	r3 = r3.replace('Stair-','');
	var r4=$(a1).find("td").eq(4).html();
	r4 = r4.replace('Floor-','');
	var r5=$(a1).find("td").eq(5).html();
	r5 = r5.replace('Door-','');
	//console.log(r6+","+r2+","+r3+","+r4+","+r5);
	$("#selectedDoorAndFloorDetails_Backup_ES").val(r6+","+r2+","+r3+","+r4+","+r5);
	$("#attribute-selectedDoorAndFloorDetails_Backup_ES").find('span').text(r6+","+r2+","+r3+","+r4+","+r5);
	//$('#myTable > tbody:last-child').append('<tr><td>'+inp+'</td><td></td><td></td></tr>');
});

	
	
	// Code end for door and floor
		
  });

  function searchTable(inputVal)
	{
		var table = $('#fixed_hdr2');
		table.find('tr').each(function(index, row)
		{
			var allCells = $(row).find('td');
			if(allCells.length > 0)
			{
				var found = false;
				allCells.each(function(index, td)
				{
					var regExp = new RegExp(inputVal, 'i');
					if(regExp.test($(td).text()))
					{
						found = true;
						return false;
					}
				});
				if(found == true)$(row).show();else $(row).hide();
			}
		});
	}
  
  function app_handle_listing_horisontal_scroll()
	{
	  //debugger;
	  //Table 3 - Automatic 
	  $('#fixed_hdr2').css( "table-layout", "fixed");
	  userGroup = $("#1_currentUserGroup_quote").val();
	  colModalTable3 = [];
	  if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
		  colModal = [
			   { width: 60, align: 'center' },//Select
			   { width: 70, align: 'left' },//	
			   { width: 110, align: 'left' },
			   { width: 70, align: 'left' },
			   { width: 320, align: 'left' },
			   { width: 70, align: 'center' },
			   { width: 90, align: 'left' },//added by santhosh start
			   { width: 90, align: 'left' },
			   { width: 90, align: 'left' },
			   { width: 80, align: 'left' },
			   { width: 80, align: 'left' },
			   { width: 40, align: 'left' },
			   { width: 65, align: 'left' },
			   { width: 50, align: 'left' },
			   { width: 40, align: 'left' },
			   { width: 50, align: 'left' },//end santhosh
			   { width: 65, align: 'center' },//analysis type
			   { width: 100, align: 'center' },//TECH
			   { width: 80, align: 'left' }, //RAG
			   { width: 65, align: 'left' },
			   { width: 65, align: 'left' },
			   { width: 90, align: 'left' },
			   { width: 60, align: 'left' }, //lead time
			   { width: 90, align: 'left' }, //Auto ID	
			   { width: 90, align: 'left' },
			   { width: 120, align: 'left' },
			   { width: 150, align: 'left' },
			   { width: 150, align: 'left' },//Ref key
			   { width: 150, align: 'left' },			   
			   { width: 320, align: 'left' }
			];
	  }
	  else{
		   colModal = [
			   { width: 60, align: 'center' },//Select
			   { width: 70, align: 'left' },//	
			   { width: 110, align: 'left' },
			   { width: 70, align: 'left' },
			   { width: 320, align: 'left' },
			   { width: 70, align: 'center' },
			   { width: 90, align: 'left' },//added by santhosh start
			   { width: 90, align: 'left' },
			   { width: 90, align: 'left' },
			   { width: 80, align: 'left' },
			   { width: 80, align: 'left' },
			   { width: 40, align: 'left' },
			   { width: 65, align: 'left' },
			   { width: 50, align: 'left' },
			   { width: 40, align: 'left' },
			   { width: 50, align: 'left' },//end santhosh
			   { width: 65, align: 'center' },//analysis type
			   { width: 100, align: 'center' },//TECH
			   { width: 90, align: 'left' }, //RAG
			   { width: 60, align: 'left' }, //lead time
			   { width: 90, align: 'left' }, //Auto ID	
			   { width: 90, align: 'left' },
			   { width: 120, align: 'left' },
			   { width: 150, align: 'left' },
			   { width: 150, align: 'left' },//Ref key
			   { width: 150, align: 'left' },			   
			   { width: 320, align: 'left' }
			];
	  }
	  
	  $('#fixed_hdr2').fxdHdrCol({
		id:"siteConfigurationForEP",
		fixedCols: 3,
		width:  '100%',
		height: 400,
		colModal : colModal				
	  });
		
		/*if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
						
		}
		else{
			colModal: [
			   { width: 30, align: 'center' },
			   { width: 70, align: 'left' },
			   { width: 110, align: 'left' },
			   { width: 80, align: 'left' },
			   { width: 320, align: 'left' },//siteaddress
			   { width: 80, align: 'left' },//product name
			   { width: 60, align: 'left' },//tech Access
			   { width: 80, align: 'center' },//RAG
			   { width: 80, align: 'left' },//Expiry Date
			   { width: 70, align: 'left' },
			   { width: 200, align: 'left' },//error desc
			   { width: 60, align: 'left' },
			   { width: 50, align: 'left' },
			   { width: 80, align: 'left' },
			   { width: 80, align: 'center' },
			   { width: 80, align: 'left' },
			   { width: 320, align: 'left' },
			   { width: 60, align: 'left' },
			   { width: 50, align: 'left' },//pair
			   { width: 30, align: 'left' }//delete
			]
		}*/
		//Table 4 - Manual 
		$('#fixed_hdr3').css( "table-layout", "fixed");
		if(userGroup == "tESUsers_ES" || userGroup == "WholeSale_accountManager_ES") {
			$('#fixed_hdr3').fxdHdrCol({
				id:"cftManualResponse",
				fixedCols: 3,
				width:  '100%',
				height: 400,
				colModal: [
				   { width: 40, align: 'center' },
				   { width: 80, align: 'left' },
				   { width: 110, align: 'left' },
				   { width: 80, align: 'left' },
				   { width: 320, align: 'left' },//siteaddress
				   { width: 80, align: 'center' },//product name
				   { width: 125, align: 'left' },//tech Access
				   { width: 60, align: 'center' },//RAG
				   { width: 50, align: 'center' },//Expiry Date
				   { width: 80, align: 'center' },//cost1
				   { width: 80, align: 'center' },//cost1
				   { width: 80, align: 'center' },//cost1
				   { width: 60, align: 'left' },
				   { width: 60, align: 'left' },
				   { width: 60, align: 'left' },//study level
				   { width: 45, align: 'left' },//analysis
				   { width: 320, align: 'left' },//man ID
				   { width: 90, align: 'center' }, //CFT status
				   { width: 80, align: 'center' },//SLA
				   { width: 70, align: 'center' },
				   { width: 80, align: 'center' },
				   { width: 80, align: 'center' },//lead Time
				   { width: 200, align: 'left'}//pair
				]		
			});
		}else{
			$('#fixed_hdr3').fxdHdrCol({
				id:"cftManualResponse",
				fixedCols: 3,
				width:  '100%',
				height: 700,
				colModal: [
				   { width: 40, align: 'center' },
				   { width: 80, align: 'left' },
				   { width: 110, align: 'left' },
				   { width: 80, align: 'left' },
				   { width: 320, align: 'left' },//siteaddress
				   { width: 80, align: 'center' },//product name
				   { width: 125, align: 'left' },//tech Access
				   { width: 60, align: 'center' },//RAG
				   { width: 50, align: 'center' },//Expiry Date
				   { width: 80, align: 'center' },//cost1
				   { width: 80, align: 'center' },
				   { width: 70, align: 'center' },
				   { width: 50, align: 'left' },//study level
				   { width: 320, align: 'left' },//analysis
				   { width: 80, align: 'center' },//man ID
				   { width: 80, align: 'center' }, //CFT status
				   { width: 70, align: 'center' },//SLA
				   { width: 70, align: 'center' },
				   { width: 70, align: 'center' },
				   { width: 200, align: 'left' }//lead Time
				  
				]		
			});
		}
	}  
	
});

/*
A jQuery plugin to convert a well formatted table into a table with fixed
rows and columns.

*/
(function ($) {
	
	$.fn.fxdHdrCol = function (o) {
		var cfg = {
			id:'',
			height: 0,
			width: 0,		
			fixedCols: 0,
			colModal: [],			
			tableTmpl: function () {
				return '<table />';							
			},
			sort: false
		};
		$.extend(cfg, o);
		
		return this.each (function () {
			var lc = {
					ft_container: null,
					ft_rel_container: null,
					ft_wrapper: null,
					ft_rc: null,
					ft_r: null,
					ft_c: null,
					tableWidth: 0
			};
			
			var $this = $(this);
			$this.addClass('ui-widget-header');
			$this.find('tbody tr').addClass('ui-widget-content');
			var resizeHeight=0;
			if($this.find("tr").length<6){
				if($this.find("tr").length<=1){
					cfg.height = 50;
				}
				else if($this.find("tr").length<4){
					cfg.height = cfg.height/3;
				}
				else
				{
					cfg.height = cfg.height/2;
				}
			}					
			$this.wrap('<div class="ft_container" />');
			lc.ft_container = $this.parent().css({width: cfg.width, height: cfg.height});		
			
			var $ths = $('thead tr', $this).first().find('th');
			
			if (cfg.sort && sorttable && cfg.fixedCols == 0) {				
				$ths.addClass('fx_sort_bg');				
			}

			var $thFirst = $ths.first();
			var thSpace = parseInt($thFirst.css('paddingLeft'), 10) + parseInt($thFirst.css('paddingRight'), 10);

			/* set width and textAlign from colModal */
			var ct = 0;
			$ths.each(function (i, el) {
				var calcWidth = 0;
				for (var j = 0; j < el.colSpan; j++) {
					calcWidth += cfg.colModal[ct].width;
					ct++;
				}
				$(el).css({width: calcWidth, textAlign: cfg.colModal[ct-1].align});
				
				lc.tableWidth += calcWidth + thSpace + ((i == 0)?2:1);
			});
								
			$('tbody', $this).find('tr').each(function (i, el) {
				$('td', el).each(function (i, tdel) {
					if(cfg.colModal && cfg.colModal[i] && cfg.colModal[i].align){
						tdel.style.textAlign = cfg.colModal[i].align;
					}
				});
			});
			
			$this.width(lc.tableWidth);

			//add relative container
			$this.wrap('<div class="ft_rel_container" />');
			lc.ft_rel_container = $this.parent();
						
			//add wrapper to base table which will have the scrollbars
			$this.wrap('<div class="ft_scroller" />');
			lc.ft_wrapper = $this.parent().css('width', cfg.width - 5);
			
			var theadTr = $('thead', $this);
			//clone the thead->tr 
			var theadTrClone = theadTr.clone();
			
			//construct fixed row (full row)
			lc.ft_rel_container
				.prepend($(cfg.tableTmpl(), {'class': 'ft_r ui-widget-header'})
				.append(theadTrClone));

			//an instance of fixed row
			lc.ft_r = $('.ft_r', lc.ft_rel_container);
			lc.ft_r[0].id = cfg.id;
			lc.ft_r.wrap($('<div />', {'class': 'ft_rwrapper'}));
			
			lc.ft_r.width(lc.tableWidth);
			
			if (cfg.fixedCols > 0) {
				//clone the thead again to construct the 
				theadTrClone = theadTr.clone();
				
				//calculate the actual column's count (support for colspan)					
				var r1c1ColSpan = 0;		
				for (var i = 0; i < cfg.fixedCols; i++ ) {
					if(this.rows[0].cells[i] && this.rows[0].cells[i].colSpan){
						r1c1ColSpan += this.rows[0].cells[i].colSpan;
					}					
				}					
				
				//prepare rows/cols for fixed row col section
		        $('tr', theadTrClone).each(function () {
		          var tdct = 0;
		          $(this).find('th').filter(function() {
		            tdct += this.colSpan;
		            return tdct > r1c1ColSpan;
		          }).remove();
		        });
				
				//add fixed row col section
				lc.ft_rel_container
					.prepend($(cfg.tableTmpl(), {'class': 'ft_rc ui-widget-header','style':'display:none;'})
					.append(theadTrClone));
				
				//an instance of fixed row column
				lc.ft_rc = $('.ft_rc', lc.ft_rel_container);
				
				//now clone the fixed row column and append tbody for the remaining rows
				lc.ft_c = lc.ft_rc.clone();
				lc.ft_c[0].className = 'ft_c';
				//lc.ft_c[0].id = cfg.id;
				
				//append tbody
				lc.ft_c.append('<tbody />');
				
				//append row by row while just keeping the frozen cols
				var ftc_tbody = lc.ft_c.find('tbody'); 
				$.each ($this.find('tbody > tr'), function (idx, el) {
					var tr = $(el).clone();
					
					tdct = 0;
					tr.find('td').filter(function (){
						tdct += this.colSpan;
						return tdct > r1c1ColSpan;
					}).remove();
					
					ftc_tbody.append(tr);
				});
				
				//lc.ft_rc.after(lc.ft_c);
				
				//lc.ft_c.wrap($('<div />', {'class': 'ft_cwrapper'}));
				
				var tw = 0;
				for (var i = 0; i < cfg.fixedCols; i++) {
					tw += $(this.rows[0].cells[i]).outerWidth(true);
				}
				lc.ft_c.add(lc.ft_rc).width(tw);       
				lc.ft_c.height($this.outerHeight(true));
					
				//set height of fixed_rc and fixed_c
				for (var i = 0; i < this.rows.length; i++) {
					var ch = $(this.rows[i]).outerHeight();
					var fch = $(lc.ft_c[0].rows[i]).outerHeight(true);
					
					ch = (ch>fch)?ch:fch;
					
					if (i < lc.ft_rc[0].rows.length) {
						$(lc.ft_r[0].rows[i])
							.add(lc.ft_rc[0].rows[i])								
							.height(ch);
					}
					
					//$(lc.ft_c[0].rows[i]).add(this.rows[i]).height(ch);
				}
				
				/*lc.ft_c			
					.parent()
					.css({height: lc.ft_container.height() - 17})
					.width(lc.ft_rc.outerWidth(true) + 1);*/
			}		
			
			lc.ft_r
				.parent()
				.css({width: lc.ft_wrapper.width()- 17});
			
			//events (scroll and resize)
			lc.ft_wrapper.scroll(function () {
				if (cfg.fixedCols > 0) { 
					//lc.ft_c.css('top', ($(this).scrollTop()*-1));
				}
				lc.ft_r.css('left', ($(this).scrollLeft()*-1));
			});
			
			/*$(window).on('resize', function () {
				lc.ft_r
				.parent()
				.css({width: lc.ft_rel_container.width()- 17});			
			});*/		

		});

	};	

})(jQuery);