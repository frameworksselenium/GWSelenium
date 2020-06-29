package com.gw.elements;

import java.util.HashMap;
import org.openqa.selenium.By;
import com.gw.driver.LoggerClass;
import com.gw.utilities.ThreadCache;

public class Elements {
	public static String sheetname = "Elements";
	public static HashMap<String, By> hm = new HashMap<String, By>();
	private org.apache.log4j.Logger logger;

	public Elements() 
	{
	}

	static
	{
		// Common Objects Across all the Screens
		hm.put("eleCommonSearch", By.xpath("//*[contains(@id,'SearchLinksInputSet:Search')]"));
		hm.put("eljCommonSearch", By.xpath("//*[contains(@id,'SearchLinksInputSet:Search')]"));
		hm.put("eleCommonEdit", By.xpath("//*[contains(@id,'Edit-btnInnerEl')]"));
		hm.put("eleCommonSelect", By.xpath("//*[contains(@id,'_Select')]"));
		hm.put("eleCommonAdd", By.xpath(".//span[contains(text(), 'Add')]"));
		hm.put("eleCommonAddId", By.xpath(".//span[contains(@id, 'Add-btnInnerEl')]"));
		hm.put("eljCommonSaveChanges", By.xpath(".//span[contains(text(), 'Save Changes')]"));
		hm.put("CommonAssertForPage", By.xpath("//*[contains(@id,'ExtPopup:ttlBar')]"));
		hm.put("eleCommonUpdate", By.xpath("//*[contains(text(),'Update')]"));
		hm.put("eleCommonUpdateId", By.xpath(("//*[contains(@id,'Update-btnInnerEl')]")));
		hm.put("eljCommonUpdate", By.xpath("//span[contains(text(),'Update')]"));
		hm.put("eleCommonDelete", By.xpath(".//span[contains(text(), 'Delete')]"));
		hm.put("eleDeleteWarningMessage", By.id("messagebox-1001-displayfield-inputEl"));
		hm.put("eleWarningMessage", By.xpath("//*[contains(@id,'ExtPopup:_msgs')]"));
		hm.put("eleCommonSaveDraft", By.xpath(".//span[contains(@id, 'SaveDraftButton-btnInnerEl')]"));
		hm.put("eljCommonSaveDraft", By.xpath(".//span[contains(@id, 'SaveDraftButton-btnInnerEl')]"));
		hm.put("eleCommonWithDrawn", By.xpath(".//span[contains(text(), 'Withdrawn')]"));
		hm.put("eleCommonNext", By.xpath(".//span[contains(text(), 'Next >')]"));
		hm.put("eljCommonNext", By.xpath(".//span[contains(text(), 'Next >')]"));
		hm.put("eleCommonBack", By.xpath(".//span[contains(text(), '< Back')]"));
		hm.put("eleCommonUpToAccountFileSummary", By.xpath(".//a[contains(text(), 'Up to Account File Summary')]"));
		hm.put("eleCommonSaveChanges", By.xpath(".//span[contains(text(), 'Save Changes')]"));
		hm.put("eleCommonFinish", By.xpath(".//span[contains(text(), 'Finish')]"));
		hm.put("eljCommonFinish", By.xpath(".//span[contains(text(), 'Finish')]"));
		hm.put("eleCommonCancel", By.xpath("//span[contains(text(),'Cancel')]"));
		hm.put("eljCommonCancel", By.xpath("//span[contains(text(),'Cancel')]"));
		hm.put("eleCommonStandardize", By.xpath("//span[contains(.,'Standardize')]"));
		hm.put("eleCommonAccountNumber", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGAccountNumber-btnInnerEl']/span"));
		hm.put("eleQPBAccountNo", By.id("AccountFile:AccountFileInfoBar:Account-btnEl"));
		hm.put("eleSaveAsDraft", By.xpath("//*[contains(@id,'SaveAsDraftButton-btnInnerEl')]"));
		hm.put("eleCommonFinalize", By.xpath("//span[contains(text(),'Finalize')]"));
		hm.put("eleCommonErrorObject", By.xpath("//*[contains(@id,'_msgs')]"));
		hm.put("eleCommonZeroResults", By.xpath("//*[contains(@id,'_msgs')]"));
		hm.put("eleActvityScrollBottom", By.xpath("//*[contains(@class,'x-box-scroller x-menu-scroll-bottom x-unselectable')]"));
		hm.put("eleActvityScrollTop", By.xpath("//*[contains(@class,'x-box-scroller x-menu-scroll-top x-unselectable')]"));
		hm.put("eleShellSummaryActivityTable", By.id("HIGPolicyFile_Summary:26-body"));
		hm.put("eleCLAPolicyInfoMandatoryAlert", By.xpath("//div[contains(text(),'Please ensure Policy Number, Business Segment, Business Grouping, Effective Date, Expiration Date, MSI, SIC and Producer Code are populated before Issuance')]"));
		hm.put("eleOverRide", By.xpath("//*[contains(@id,'overrideButton_Ext-btnInnerEl')]"));
		hm.put("eleStandardise", By.xpath("//*[contains(@id,'standardizeButton_Ext-btnInnerEl')]"));
		hm.put("eleCommonOk", By.xpath(".//span[contains(text(),'OK')]"));
		hm.put("eljCommonOk", By.xpath("//*[contains(@id,'Update-btnInnerEl')]"));
		hm.put("eleTopInfobarJobLabel", By.xpath(".//*[@id='SubmissionWizard:JobWizardInfoBar:JobLabel-btnInnerEl']/span"));
		hm.put("eleNGSCloseOptions", By.xpath(".//*[contains(@id,'CloseOptions-btnInnerEl')]"));
		hm.put("eleNGSCloseOPtionsWithdrawTransaction", By.xpath("//*[contains(@id,'CloseOptions:WithdrawJob-textEl')]"));
		hm.put("eleNGSCloseOptionsDecline", By.xpath(".//*[contains(@id,'CloseOptions:Decline-textEl')]"));
		hm.put("eleCommonBindOptions", By.xpath("//*[contains(@id,'BindOptions-btnInnerEl')]"));
		hm.put("eleCommonCancelNow", By.xpath("//*[contains(@id,'CancelNow-textEl')]"));
		hm.put("elePagePrevious", By.xpath("//span[@class='x-btn-icon-el x-tbar-page-prev ']"));
		hm.put("eleNextPage", By.xpath("//a[@class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-plain-toolbar-small x-icon x-btn-icon x-btn-plain-toolbar-small-icon' and @data-qtip='Next Page']"));
		hm.put("eleFirstPage", By.xpath("//a[@class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-plain-toolbar-small x-icon x-btn-icon x-btn-plain-toolbar-small-icon' and @data-qtip='First Page']"));
		hm.put("eleCommonPageNumber", By.xpath("//div[contains(@id,'tbtext') and contains(text(),'of ')]"));
		hm.put("eleCommonEditTransaction", By.xpath("//span[contains(@id,'EditPolicyWorkflow-btnInnerEl')]"));
		hm.put("eleCommonWorkFlowEditTransaction", By.xpath("//span[contains(@id,'EditPolicy-btnInnerEl')]"));
		hm.put("eleUnDiscardChanges", By.xpath("//a[contains(text(),'Discard Unsaved Change')]"));
		hm.put("eleEditTransOk", By.id("button-1005"));
		hm.put("eleRenewalQuoteStatus", By.xpath("//span[text()='Renewal (Quoted)']"));
		hm.put("eleCommonSelectUser", By.xpath("//a[text()='Select User...']"));
		hm.put("eleNGSCloseOptionsNotTaken", By.xpath(".//*[contains(@id,'CloseOptions:NotTakenJob-textEl')]"));
		hm.put("eleNGSRejectConfirm", By.xpath(".//*[contains(@id,'RejectScreen:Update-btnInnerEl')]"));
		hm.put("eleNGSViewSubmission", By.xpath(".//*[contains(@id,'ViewJob-inputEl')]"));
		hm.put("lstNGSRejectReason", By.xpath(".//*[contains(@id,'RejectReason-inputEl')]"));
		// Universal login
		hm.put("pwdUniversalUserName", By.name("username"));
		hm.put("pwdUniversalPassword", By.name("password"));
		hm.put("btnUniversalLogin", By.xpath("login"));

		// LogIn Objects
		hm.put("edtUserName", By.id("username"));//By.id("Login:LoginScreen:LoginDV:username-inputEl"));
		hm.put("eleUserName", By.id("password"));//By.id("Login:LoginScreen:LoginDV:username-inputEl"));
		hm.put("pwdPassword", By.id("Login:LoginScreen:LoginDV:password-inputEl"));
		hm.put("btnLogin", By.id("Login:LoginScreen:LoginDV:submit-btnInnerEl"));
		//hm.put("pwdUniversalUserName", By.name("USER"));
		//hm.put("eleUniversalUserName", By.name("USER"));
		//hm.put("pwdUniversalPassword", By.name("PASSWORD"));
		hm.put("btnUniversalLogin", By.id("login"));//;By.xpath("//input[@type = 'submit']"));

		// Objects under Action Menu which is Under Desktop Main Menu
		hm.put("eleDeskTopAction", By.id("Submit"));
		hm.put("eleDeskTopNewAccount", By.id("Desktop:DesktopMenuActions:DesktopMenuActions_Create:DesktopMenuActions_NewAccount-textEl"));
		hm.put("melDesktop", By.id("TabBar:DesktopTab-btnWrap"));
		hm.put("eleUnattachedDocument", By.id("TabBar:DesktopTab:Desktop_DesktopUnattachedDocumentsPage-itemEl"));
		hm.put("eleResearchUnattachedDocument", By.id("TabBar:DesktopTab:Desktop_DesktopUnattachedDocumentsPage2-textEl"));

		// Enter New Account Search Objects
		hm.put("edtCompanyName", By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:companyName:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAccountInfoSearch", By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleAccountInfoCreateNewAccount", By.id("NewAccount:NewAccountScreen:NewAccountButton-btnInnerEl"));
		hm.put("eleCreateNewAccountForPerson", By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_Company-textEl"));

		// Create Account Objects
		hm.put("edtAddress1", By.xpath("//*[contains(@id,'GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("edjAddress1", By.xpath("//*[contains(@id,'GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("edtAddress", By.xpath("//*[contains(@id,'GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("edtFEIN", By.xpath("//input[contains(@id,'OfficialIDDV_Input-inputEl')]"));
		hm.put("eleCity", By.xpath("//*[contains(@id,'GlobalAddressInputSet:City-inputEl')]"));
		hm.put("eleDoc_ContactCity", By.xpath("//*[contains(@id,'GlobalAddressInputSet:City-inputEl')]"));
		hm.put("edtCity", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("zedCity", By.xpath("//*[contains(@id,'GlobalAddressInputSet:City-inputEl')]"));
		hm.put("lsjCity", By.xpath("//*[contains(@id,'GlobalAddressInputSet:City-inputEl')]"));
		hm.put("lstState", By.xpath("//*[contains(@id,'GlobalAddressInputSet:State-inputEl')]"));
		hm.put("edtState", By.xpath("//*[contains(@id,'GlobalAddressInputSet:State-inputEl')]"));
		hm.put("zedState", By.xpath("//*[contains(@id,'GlobalAddressInputSet:State-inputEl')]"));
		hm.put("lsjState", By.xpath("//*[contains(@id,'GlobalAddressInputSet:State-inputEl')]"));
		hm.put("eleState", By.xpath("//*[contains(@id,'GlobalAddressInputSet:State-inputEl')]"));
		hm.put("eleZipCode", By.xpath("//*[contains(@id,'GlobalAddressInputSet:PostalCode-inputEl')]"));

		hm.put("zedZipCode", By.xpath("//*[contains(@id,'GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("lsjZipCode", By.xpath("//*[contains(@id,'GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("edtFirstName", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtLastName", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:GlobalPersonNameInputSet:LastName-inputEl"));

		hm.put("lstZipCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("lstAddressType", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:AddressType-inputEl"));
		hm.put("lstOrgType", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:OrgType-inputEl"));

		hm.put("eleOrgSearch", By.xpath(".//*[contains(@id,'ProducerCode_Ext:SelectProducerCode_Ext')]"));
		hm.put("lstProducerCodeOrgType", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:Type-inputEl"));
		hm.put("SubmissionWizard:LOBWizardStepGroup:WC7WorkersCompStateCoveragesd", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:businessStartYear-inputEl"));
		hm.put("edtOrganizationName", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Description-inputEl"));
		hm.put("eleOrgResSearch", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleOrgSearchResults", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchLV:0:_Select"));
		hm.put("lstProducerCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:ProducerCode-inputEl"));
		hm.put("eleUpdate", By.cssSelector("a[id='CreateAccount:CreateAccountScreen:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("btnUpdate", By.id("CreateAccount:CreateAccountScreen:updateButton_Ext-btnInnerEl"));

		hm.put("eleCreateNewAccountNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl"));
		hm.put("eleNew", By.id("MatchingSearchResults_ExtWorksheet:ToolbarButton-btnEl"));
		hm.put("eleAddSuccessMsg", By.id("CreateAccount:CreateAccountScreen:_msgs"));
		hm.put("eleAccountName", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:Name-inputEl"));
		hm.put("eleAccountFileSummary", By.id("AccountFile_Summary:AccountFile_SummaryScreen:ttlBar"));
		hm.put("eleAccountFileSummaryPage", By.id("AccountFile_Summary:AccountFile_SummaryScreen:ttlBar"));
		hm.put("eleCreateAccountPage", By.id("CreateAccount:CreateAccountScreen:ttlBar"));
		hm.put("eleCreateAccountOK", By.id("button-1005-btnInnerEl"));
		hm.put("edtPhoneNumber", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:CreateAccountContactInputSet:Phone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("eleCreateAccountCancel", By.id("button-1008-btnInnerEl"));
		hm.put("eleCreateAccountMatchingRecordsPage", By.id("wsTabBar:wsTab_0-btnInnerEl"));
		hm.put("eleMatchingAccountCancle", By.id("MatchingSearchResults_ExtWorksheet:ToolbarButton1-btnInnerEl"));
		hm.put("eleCreateAccountMessagePage", By.id("messagebox-1001-displayfield-inputEl"));
		hm.put("eleEnterAccountInformationErrorMessages", By.id("NewAccount:NewAccountScreen:_msgs"));
		hm.put("eleCompanyNameExactMatch", By.id("NewAccount:NewAccountScreen:NewAccountSearchDV:CompanyNameExact-inputEl"));
		hm.put("eleEnterAccountInformationPage", By.id("NewAccount:NewAccountScreen:ttlBar"));
		hm.put("edtAccountProducerCode", By.xpath("//*[contains(@id,'ProducerCodeSearchDV:Code-inputEl')]"));
		hm.put("eleActivityCloseBtn", By.xpath("//span[@id='ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_SkipButton-btnInnerEl'][contains(text(),'Close')]"));

		// Edit Account
		hm.put("eleEdtButton", By.id("AccountFile_Summary:AccountFile_SummaryScreen:EditAccount-btnInnerEl"));
		hm.put("edtAIFNum", By.id("EditAccountPopup:EditAccountScreen:aifNumber_Ext-inputEl"));
		hm.put("edtAllianceNum", By.id("EditAccountPopup:EditAccountScreen:allianceNumber_Ext-inputEl"));
		hm.put("edtFEINNum", By.id("EditAccountPopup:EditAccountScreen:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("eleEditUpdate", By.cssSelector("a[id='EditAccountPopup:EditAccountScreen:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("edtAcount_OfficePhone", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtOfficePhone", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtAccount_Fax", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtAccount_PrimaryMail", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("edtPrimaryEmailAddress", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("edtAccount_SecondaryMail", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:EmailAddress2-inputEl"));
		hm.put("edtAccount_Website", By.id("EditAccountPopup:EditAccountScreen:website_Ext-inputEl"));
		hm.put("eleAccount_PrimaryMail", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:EmailAddress1-inputEl"));

		// Contacts
		hm.put("eleCreateNewContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton-btnInnerEl"));
		hm.put("elePrimaryContact", By.xpath(".//span[contains(text(), 'Primary Contact')]"));
		hm.put("elePrimaryNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
		hm.put("edtFName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtLName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("sclCTUpdate", By.id("NewAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleContactUpdate", By.id("NewAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleSecondaryContact", By.xpath(".//span[contains(text(), 'Secondary Contact')]"));
		hm.put("eleSecondaryNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
		//hm.put("eleSameAddressAs", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
		hm.put("eleSameAddressAs", By.xpath(".//*[contains(@id,':LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon')]"));
		//hm.put("eleAccountHolder", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
		//hm.put("eleAccountAddress", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress"));
		hm.put("eleAccountHolder", By.xpath(".//*[contains(@id,':LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl')]"));
		hm.put("eleAccountAddress", By.xpath(".//*[contains(@id,':LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress')]"));
		hm.put("eleAssertContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:ttlBar"));
		hm.put("eleBillingContact", By.xpath(".//span[contains(text(), 'Billing Contact')]"));
		hm.put("eleBillingNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
		hm.put("lsjAccountSummary_PolTran", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl"));
		hm.put("edtContactFirstName", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtContactLasttName", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));

		// LogOut
		// hm.put("elePreferences", By.id(":TabLinkMenuButton-btnIconEl"));
		hm.put("elePreferences", By.id(":TabLinkMenuButton-btnInnerEl"));
		hm.put("eleLogOut", By.id("TabBar:LogoutTabBarLink-textEl"));
		hm.put("btnLogOut", By.id("/html/body/table[2]/tbody/tr[1]/td[2]/a[4]"));
		hm.put("eleBuildInfo", By.id("TabBar:buildInformationTabBarLink"));
		hm.put("btnServerName", By.id("TabBar:buildInformationTabBarLink:BuildInfoMenu_Ext:BuildInfo_ExtMenuItemSet:serverIDMenuItem-textEl"));
		// melAccount edtAccountNumbar eleAccountSearch
		hm.put("melAccount", By.id("TabBar:AccountTab-btnInnerEl"));
		hm.put("melSearch", By.id("TabBar:SearchTab-btnInnerEl"));
		hm.put("melDesktop", By.id("TabBar:DesktopTab-btnWrap"));
		hm.put("melAccountSearch", By.id("TabBar:AccountTab-btnWrap"));
		hm.put("melAdministration", By.id("TabBar:AdminTab-btnWrap"));
		hm.put("edtaccountNumber", By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"));
		hm.put("btnAccountSearch", By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
		hm.put("eleAccountSearch", By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
		hm.put("eleSearchAccount", By.id("TabBar:SearchTab:Search_AccountSearch-textEl"));
		hm.put("eleAccountTab", By.id("TabBar:AccountTab-btnInnerEl"));
		hm.put("eleBusinesssetting", By.xpath(".//*[@id='Admin:MenuLinks:Admin_BusinessSettings']/div/span"));
		hm.put("eleClassCodes", By.xpath(".//*[@id='Admin:MenuLinks:Admin_BusinessSettings:BusinessSettings_ClassCodeAdminPage']/div/span"));
		hm.put("eleNGS", By.id("ClassCodeAdminPage:BP7ClassCodeAdminCardTab-btnInnerEl"));
		hm.put("eleSearchNGS", By.id("ClassCodeAdminPage:SearchAndReset:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleTblVal", By.xpath("//div[text()='Page' and contains(@id,'tbtext')]"));
		hm.put("edtClassCode", By.xpath(".//*[@id='ClassCodeAdminPage:SelectCode-inputEl']"));
		hm.put("lstClassCodeState", By.id("ClassCodeAdminPage:SelectState-inputEl"));
		hm.put("eleResetNGS", By.id("ClassCodeAdminPage:SearchAndReset:SearchAndResetInputSet:SearchLinksInputSet:Reset"));

		// NewSubmission
		// hm.put("eleActions", By.id("AccountFile:AccountFileMenuActions-btnIconEl"));
		// hm.put("eleActions",
		// By.xpath(".//*[contains(@id,'AccountFileMenuActions-btnInnerEl')]"));
		hm.put("eleActions", By.xpath(".//*[contains(@id,'MenuActions-btnInnerEl')]"));

		hm.put("eleNewSubmission", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl"));
		hm.put("eleOrganisationSearch", By.id("NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:Producer:SelectOrganization"));
		hm.put("edtOrganisationName", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleSearchButton", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSearchResult", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchResultsLV:0:_Select"));
		hm.put("lstProduverCodeList", By.id("NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:ProducerCode-inputEl"));
		// hm.put("lstSegment",
		// By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:segment_Ext-inputEl"));
		hm.put("lstSegment", By.xpath("//td//label[contains(text(),'Segment')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleassertforPolicyINFOPage", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:DateQuoteNeeded-labelEl"));
		// hm.put("edtEffDate",
		// By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:DefaultPPEffDate_Ext-inputEl"));
		// hm.put("lstBusinessGroup",
		// By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:businessGrouping_Ext-inputEl"));
		hm.put("lstBusinessGroup", By.xpath("//td//label[contains(text(),'Business Grouping')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstSalesAgreementCode", By.xpath("//td//label[contains(text(),'Sales Agreement Code')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lsjSalesAgreementCode", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:SalesAgreementCode-inputEl"));
		hm.put("eljShell", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:addSubmission"));
		hm.put("eljSOR", By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:SystemOfRecord"));
		// hm.put("eleProductNameTable",
		// By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV-body"));
		hm.put("eleProductNameTable", By.id("NewSubmission:NewSubmissionScreen:ProductSelectionLV-body"));
		// hm.put("funSelectLOB",
		// By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV-body"));
		hm.put("funSelectLOB", By.id("NewSubmission:NewSubmissionScreen:ProductSelectionLV"));
		hm.put("eleMultiple", By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:CreateSingle_false-inputEl"));
		hm.put("eleSingle", By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:CreateSingle_true-inputEl"));
		// hm.put("eleMakeSubmissions",
		// By.id("NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV_tb:MakeSubmissions-btnInnerEl"));
		hm.put("eleMakeSubmissions", By.id("NewSubmission:NewSubmissionScreen:ProductSelectionLV_tb:MakeSubmissions"));
		hm.put("eleNewSubmissionTitle", By.id("NewSubmission:NewSubmissionScreen:ttlBar"));
		// hm.put("edtEffDate",
		// By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:DefaultPPEffDate_Ext-inputEl"));
		hm.put("edtEffDate", By.xpath("//td//label[contains(text(),'Effective Date')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtExpDate", By.xpath("//td//label[contains(text(),'Expiration Date')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtExpDate",
		// By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:DefaultExpirationDate-inputEl"));
		hm.put("eleStateCoverage_EditTransaction", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));
		hm.put("elePolicyInfo_EditTransactionBtn", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));
		hm.put("eleStatusCanceled", By.xpath("//span[contains(text(), 'Canceled')]"));
		hm.put("eleStatusInforce", By.xpath("//span[contains(text(), 'In Force')]"));
		hm.put("edtDefaultBaseState", By.id("NewSubmission:NewSubmissionScreen:ProductSettingsDV:DefaultBaseState-inputEl"));

		// Organisation
		hm.put("eleOrganisation", By.id("SubmissionWizard:SubmissionWizard_PreQualificationScreen:ttlBar"));
		hm.put("eleUsers_Organisation", By.id("Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_OrganizationSearchPage"));
		hm.put("eleOrg_Searchbtn", By.id("OrganizationSearchPage:OrganizationSearchScreen:OrganizationSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleOrg_SelectOrg", By.id("OrganizationSearchPage:OrganizationSearchScreen:OrganizationSearchResultsLV:0:Name"));

		// Next is common for all the pages
		hm.put("eleNext", By.xpath("//span[contains(@id,'Next-btnInnerEl')]"));
		hm.put("eljNext", By.xpath("//span[contains(@id,'Next-btnInnerEl')]"));
		// PolicyInfo
		hm.put("eleOkAddress", By.id("EditPolicyAddressPopup:updateButton_Ext-btnInnerEl"));
		hm.put("elePolicyInfoQuickLaunch", By.xpath(".//span[contains(text(), 'Policy Info')]"));
		hm.put("elePISaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		// hm.put("eljPISaveDraft",
		// By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eljPISaveDraft", By.xpath("//span[contains(@id,'JobWizardToolbarButtonSet:Draft-btnInnerEl')]"));
		hm.put("eleIndustryCodeSearch", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:IndustryCode:SelectIndustryCode"));
		hm.put("edtIndustryCode", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Code-inputEl"));
		hm.put("edtSORIndustryCode", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Code-inputEl"));
		hm.put("btnSearchButton", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSelectCode", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchResultsLV:0:_Select"));
		hm.put("edtPolicyInfo_IndusType", By.xpath("//*[contains(@id,'AccountInfoInputSet:IndustryType-inputEl')]"));
		hm.put("edtIndusCode", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:IndustryCode-inputEl"));
		hm.put("edtNAICS", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:NAICSIndustryCode-inputEl"));
		hm.put("edtMSI", By.xpath("//input[contains(@id,'AccountInfoInputSet:MSIExt-inputEl')]"));
		// hm.put("edtEBS",
		// By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:YearBusinessStarted-inputEl"));
		hm.put("edtEBS", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:YearBusinesssStarted-inputEl"));

		hm.put("lstOrganisationType", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:OrganizationType-inputEl"));
		hm.put("lstProductType", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ProductType-inputEl"));
		// hm.put("lstSubmissionSource",
		// By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:SubmissionSource-inputEl")
		// );
		hm.put("lstSubmissionSource", By.xpath(".//*[contains(@id,'SubmissionSource-inputEl')]"));
		hm.put("edtNPNNum", By.xpath("//td//label[contains(text(),'NPN Number')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("NPNNum", By.xpath("//td//label[contains(text(),'NPN Number')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("elePI_SOR_NPNNum", By.xpath("//td//label[contains(text(),'NPN Number')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePI_SOR_NPNFirstName", By.xpath("//td//label[contains(text(),'NPN First Name')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePI_SOR_NPNLastName", By.xpath("//td//label[contains(text(),'NPN Last Name')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePI_SOR_NPNMiddleName", By.xpath("//td//label[contains(text(),'NPN Middle')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePS_BillingMethod", By.xpath("//td//label[contains(text(),'Billing Method')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePS_BillingNumber", By.xpath("//td//label[contains(text(),'Billing Number')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePS_InstallmentPlan", By.xpath("//td//label[contains(text(),'Installment Plan')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("elePS_TotalCost", By.xpath("//td//label[contains(text(),'Total Cost')]//ancestor::td[1]//following-sibling::td//div"));
		hm.put("lstAffinityGroup", By.xpath(".//*[contains(@id,'AffinityGroup1-inputEl')]"));
		hm.put("lstTradeMark", By.xpath(".//*[contains(@id,'Trademark-inputEl')]"));
		// hm.put("elePolicyInfoAssert",
		// By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:ttlBar"));
		hm.put("elePolicyInfoAssert", By.xpath("//*[contains(@id,'PolicyInfoScreen')]"));
		// hm.put("elePolicyInfoAssert",
		// By.id("PolicyFile_PolicyInfo:PolicyFile_PolicyInfoScreen:0"));
		hm.put("elePolBORStartDate", By.id("PolicyFile_PolicyInfo:PolicyFile_PolicyInfoScreen:PolicyFile_PolicyInfoDV:PolicyInfoInputSet:QuotePresented-bodyEl"));
		hm.put("elePolBOREndDate", By.id("PolicyFile_PolicyInfo:PolicyFile_PolicyInfoScreen:PolicyFile_PolicyInfoDV:PolicyInfoInputSet:QuoteSuccessful-bodyEl"));
		hm.put("eleSORPolicyStatus", By.xpath("//*[contains(@id,'WorkflowLabel-btnInnerEl')]"));
		hm.put("elePolicy Info", By.xpath(".//span[contains(text(),'Policy Info')]"));
		hm.put("eleSelectReturnPolicyOutput", By.xpath("//input[contains(@id,'ReturnPolicyOutput-inputEl')]"));
		hm.put("lstSelectReturnPolicyOutputReason", By.xpath("//input[contains(@id,'ReturnPolicyOutputReason-inputEl')]"));
		hm.put("eleGWCloseOptionsNotTaken", By.xpath(".//*[contains(@id, 'CloseOptions:SendToNotTaken-textEl')]"));
		hm.put("eleNonRenew", By.xpath(".//span[contains(text(),'Non-Renew')]"));
		hm.put("lstNonRenewalReasonCode", By.xpath("//input[contains(@id,'RenewalWizard_NonRenewPopup:RenewalWizard_NonRenewScreen:NonRenewReason-inputEl')]"));
		hm.put("edtNonRenewalReasonText", By.id("RenewalWizard_NonRenewPopup:RenewalWizard_NonRenewScreen:NonRenewAddExpl-inputEl"));
		hm.put("edtSubmissionOrginalDate", By.xpath("//input[contains(@id,':OriginalReceivedDateTime-inputEl')]"));
		hm.put("edtMMUserReceivedDate", By.xpath("//input[contains(@id,':MMUserNBReceivedDateTime-inputEl')]"));
		hm.put("edtPolicyInfo_YrBusinessStarted", By.xpath("//input[contains(@id,'PolicyInfoDV:AccountInfoInputSet:YearBusinesssStarted')]"));
		hm.put("edtPolicyInfo_NoOfLOB", By.xpath("//input[contains(@id,'PolicyInfoDV:AccountInfoInputSet:NumberofLinesofBusiness-inputEl')]"));
		hm.put("lstPolicyInfo_UWCompany", By.xpath("//input[contains(@id,'PolicyInfoDV:UWCompanyInputSet:UWCompany-inputEl')]"));
		hm.put("lstNGS_IndustryDetails_Segment", By.xpath(".//*[contains(@id,'Segment-inputEl')]"));
		hm.put("edtNGS_NegotiatedCommission", By.xpath(".//*[contains(@id,'NegotiatedCommission-inputEl')]"));
		hm.put("lstIndustryDetails_Segment", By.xpath("//div[@role='presentation']/ul"));

		// Location
		hm.put("eleLocationsSummary", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:Locations']/div/span"));
		hm.put("eleLocations", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:ttlBar"));
		// hm.put("eleLocSaveDraft",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		// hm.put("eleLocSaveDraft",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		// hm.put("eleLocSaveDraft",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eleLocSaveDraft", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:Draft-btnInnerEl')]"));

		// hm.put("eleLocSaveDraft",
		// By.xpath(".//*[contains(@id,':LocationsScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl')]"));
		hm.put("eleclkSubmissionLocation", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:LocationsPanelSet:LocationsEdit_DP:LocationsEdit_LV:0:Address"));
		hm.put("edtLocationNumberofEmp", By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LineLocationDetailInputSet:EmployeeCount-inputEl"));
		hm.put("eleLocationStandardize", By.id("LocationPopup:LocationScreen:standardizeButton_Ext-btnInnerEl"));
		// hm.put("eleLocationOK",
		// By.id("LocationPopup:LocationScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleLocationOK", By.xpath(".//*[contains(@id,'LocationPopup:LocationScreen:updateButton_Ext-btnInnerEl')]"));
		hm.put("eleLocNameIsureds", By.xpath(".//span[contains(@id, ':addNamedInsured_Ext-btnEl')]"));
		// hm.put("eleLocationNameInsAdd",
		// By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:locationNamedinsured:NameInsuredLV_tb:addNamedInsured_Ext:AddAll-textEl"));
		hm.put("eleLocationNameInsAddAll", By.xpath(".//span[contains(@id, ':AddAll-textEl')]"));
		hm.put("eleLocationPage", By.xpath("//span[text() = 'Locations' and @class = 'x-tree-node-text ']"));

		// R3
		hm.put("eleLocationCancel", By.xpath(".//*[contains(@id,'LocationScreen:Cancel-btnInnerEl')]"));
		hm.put("lstLocation_State", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl')]"));
		hm.put("eleAddress1ErrMsg", By.xpath(".//*[contains(@id,'BP7LocationPopup:LocationScreen:_msgs')]"));
		hm.put("eleLocationCounty", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl')]"));
		hm.put("eleAccountCheck", By.xpath(".//*[contains(@id,'gridview')]/tr[1]/td[2]/div/img"));
		hm.put("eleLocationCheck", By.xpath(".//table[contains(@id,'gridview')]//tr[1]/td[2]//img"));
		hm.put("elePriStateError", By.xpath(".//div[contains(@id,'LineWizardStepSet:BP7LocationScreen:_msgs')]"));
		hm.put("eleTexasCountyError", By.xpath(".//div[contains(@id,'BP7LocationPopup:LocationScreen:_msgs')]"));
		hm.put("eleTaxCode", By.xpath(".//div[contains(@id,'LocationDetailPanelSet:taxCode_Ext-inputEl')]"));
		hm.put("eleRemoveBtnValidate", By.xpath(".//a[contains(@class,'x-over x-btn-over x-btn-default-toolbar-small-over')]"));
		hm.put("eleCountryValidate", By.xpath(".//div[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl')]"));
		hm.put("lstLocationPoolID", By.xpath(".//*[contains(@id,'LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:PoolID_Ext-inputEl')]"));
		hm.put("lstLTTaxExemption", By.xpath(".//*[contains(@id,'LocationScreen:taxExemptApply_Ext-inputEl')]"));
		hm.put("edtLTLiaTaxCode", By.xpath(".//*[contains(@id,'LocationScreen:taxCode1_Ext-inputEl')]"));
		hm.put("edtLTPorpTaxCode", By.xpath(".//*[contains(@id,'LocationScreen:taxCode2_Ext-inputEl')]"));
		hm.put("eleLocations_Address1", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl']"));
		hm.put("eleLocations_City", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl']"));
		hm.put("clrLocationCountry", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl')]"));
		// State Coverages
		hm.put("eleStateCoverages", By.xpath(".//span[contains(text(),'State Coverages')]"));
		hm.put("eleStateCoverage", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:WC7WorkersCompStateCoverages']/div/span"));
		hm.put("eleWCSaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WorkersCompCoverageConfigScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eleAddClass", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV_tb:Add-btnInnerEl"));
		hm.put("edtClassification", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:WC7ClassCodeSearchDV:Classification-inputEl"));
		// hm.put("lstUWCompanies",
		// By.xpath("//input[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UWCompanyInputSet:UWCompany-inputEl']"));
		hm.put("lstUWCompanies", By.xpath(".//input[contains(@id,'LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UWCompanyInputSet:UWCompany-inputEl')]"));
		hm.put("assertforStateCoverage", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7PolicyCoveragesDV:0"));
		hm.put("eleAssertStateCoverage", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7PolicyCoveragesDV:0"));
		hm.put("eleCoveredEmployees", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:4"));
		hm.put("eleStateCoverageLookUp", By.xpath(".//div[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV:')]"));
		hm.put("edtRiskScore", By.xpath(".//*[contains(@name,'WC7StateCoverageCV:riskScore_Ext')]"));
		// hm.put("edtRiskScore",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:riskScore_Ext-inputEl"));
		hm.put("eleUWCompany", By.xpath(".//*[contains(@id,'UWCompany-inputEl')]"));
		// hm.put("edjAnniversaryDate",By.xpath("//td//label[contains(text(),'Anniversary
		// Date')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edjAnniversaryDate", By.xpath("//*[contains(@id,':WC7StateCoverageCV:anniversaryDate_Ext-inputEl')]"));
		hm.put("eljStateCoveragesEditPolTrans", By.id("PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));
		hm.put("eljScheduleRatingFactor", By.xpath(".//div[contains(@id,':ModifierInput_Rate-inputEl')]"));
		hm.put("eleScheduleRatingTitle", By.xpath(".//span[contains(text(),'Schedule Rating')]"));
		hm.put("edtSafetyCredit", By.xpath("//td//label[contains(text(),'Safety Credit')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edjSTPPOCredit", By.xpath("//td//label[contains(text(),'PPO Credit')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleSTPPOAnyUnionEmployeesNO", By.xpath(".//input[contains(@id,'unionEmployees_false-inputEl')]"));
		hm.put("edjSTPPOtotalEstimatedEmployees", By.xpath(".//input[contains(@id,'TotalEstimNumEmpls-inputEl')]"));
		hm.put("edjSTPPOInsuredName", By.xpath(".//input[contains(@id,'PPOInsuredName-inputEl')]"));
		hm.put("edjSTPPOAddressLine", By.xpath(".//input[contains(@id,'PPOAddressLine1-inputEl')]"));
		hm.put("edjSTPPOCity", By.xpath(".//input[contains(@id,'PPOCIty-inputEl')]"));
		hm.put("edjSTPPOState", By.xpath(".//input[contains(@id,'PPOState-inputEl')]"));
		hm.put("edjSTPPOZipCode", By.xpath(".//input[contains(@id,'PPOZipCode-inputEl')]"));
		hm.put("lstSTCertifiedRiskManagementProgram", By.xpath("//td//label[contains(text(),'Certified Risk Management Program (Cost Containment Certification Program)')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lsjCoinsuranceAmount", By.xpath("//*[contains(@id,'WC7CoinsuranceAmountTermInput-inputEl')]"));
		hm.put("edtDeptOfLaborID", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:officialIDs:1:ANI_OfficialIDEntry-inputEl"));
		hm.put("eleSCDesMedProCreYES", By.xpath("//td//label[contains(.,'Designated Medical Provider Credit')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'Yes')]"));

		// Add Class Table Elements
		hm.put("lsjGoverning LawTBD", By.name("WC7SpecialCoverage"));
		hm.put("lsjLocationTBD", By.name("Loc"));
		hm.put("selLocationTBD", By.name("Loc"));
		hm.put("lstAddClassSearchCodeTBD", By.name("ClassCode"));
		hm.put("lsjAnualPremiumEditTBD", By.name("AnnualRenum"));
		hm.put("eleClass CodeTBP", By.xpath(".//div[contains(@id,'WCCovEmpLV:')]"));
		hm.put("eleAddClassHeader", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV"));
		hm.put("lsjAnnual BasisTBD", By.name("AnnualRenum"));
		hm.put("clrAnnual BasisTBD", By.name("AnnualRenum"));
		hm.put("eljSelectInput", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:ClassCodeSearchResultsLV:0:_Select"));
		hm.put("eleAddClassColumnSearch", By.xpath(".//*[contains(@id,':WCCovEmpLV')]/div[2]/div/div"));
		hm.put("eleSTAddClassCoveredEmployees", By.xpath(".//*[contains(@id,':WC7StateCoverageCV:4')]"));
		hm.put("eleAddClassRemove", By.xpath("//a[contains(@id,':Remove') and @class = 'x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("edtClass Code RateTBD", By.name("Rate"));
		hm.put("edtClass CodeTBD", By.name("ClassCode"));
		// hm.put("eleClassCodeErr", By.xpath("//*[contains(text(),' is not a valid
		// class code for Connecticut and this governing law')]"));

		// Supplemental
		hm.put("eleSupplemental", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WorkersCompSupplementalScreen:ttlBar"));
		hm.put("eleSupRadioOver30Days", By.xpath("//div[contains(text(),'The policy change being requested is over 30 days')]//following::td[1]//input[@inputvalue='true']"));
		hm.put("eleSupRadioAreYouAware", By.xpath("//div[contains(text(),'Are you aware of any losses on or after the effective date')]//following::td[1]//input[@inputvalue='true']"));
		hm.put("eleSupp_Ques", By.id("PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:WC7SupplementalScreen:QuestionSetsDV:0:QuestionSetLV-body"));

		// WC Options
		hm.put("eleWCOptSaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:CoverageOptionsScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eleWCOpt", By.xpath(".//*[contains(@id,':WorkersCompOptions')]/div/span"));
		hm.put("eleAddWCOptions", By.xpath(".//*[contains(@id,'WC7CoverageOptionsScreen:ttlBar')]"));
		hm.put("eleWCParticipationPlanStateTable", By.xpath(".//*[contains(@id,'WC7ParticipationPlanPerStateConfig_LV-body')]"));
		hm.put("lsjWCPlanID", By.xpath(".//*[contains(@id,'PlanID-inputEl')]"));
		hm.put("lsjWCDividendVariation", By.xpath(".//*[contains(@id,'DividendVariation-inputEl')]"));
		hm.put("eleWCOptionsTab", By.xpath("//span[text() = 'WC Options' and @class = 'x-tree-node-text ']"));

		// State Summary
		hm.put("eleStateSummaryPage", By.id("SubmissionWizard:SubmissionWizard_StateSummaryScreen:ttlBar"));
		// Risk Analysis
		// hm.put("eleRiskAnalysis",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:0"));
		hm.put("eleRiskAnalysis", By.xpath("//*[contains(@id,'Job_RiskAnalysisScreen:0')]"));
		hm.put("eleRASaveDraft", By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eleRAQuote", By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		// hm.put("eleUWInfo",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWInfoTab-btnInnerEl"));
		hm.put("eleUWInfo", By.xpath("//*[contains(@id,'RiskAnalysisCV:UWInfoTab-btnInnerEl')]"));
		// hm.put("lstBestIndex",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWInfo_ExtDV:bestIndex-inputEl"));
		// hm.put("lstBestIndex",
		// By.xpath("//*[contains(@id,'RiskAnalysisScreen:RiskAnalysisCV:UWInfo_ExtDV:bestIndex-inputEl')]"));
		hm.put("lstBestIndex", By.xpath("//*[contains(@id,'RiskAnalysisScreen:RiskAnalysisCV:UWInfo_ExtDV:complexityScore-inputEl')]"));

		hm.put("eleCLA_RiskAnalysis", By.xpath(".//span[contains(text(), 'Risk Analysis')]"));
		hm.put("eleRiskAnalysisTab", By.xpath(".//span[contains(text(),'Risk Analysis')]"));
		hm.put("eleRiskAnalysisClaimsTab", By.xpath(".//span[contains(@id,'ClaimsCardTab-btnInnerEl')]"));
		hm.put("eljRA_AccountNo", By.xpath(".//span[@id='SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl']"));
		hm.put("eleRA_Claims_SrhBy", By.xpath(".//div[contains(@id,'PolicyNumberPicker:SelectPolicyNumberPicker')]"));
		hm.put("eleRA_Claims_SrhPol_Accno", By.xpath(".//input[contains(@id,'PolicySearchDV:AccountNumber-inputEl')]"));
		hm.put("eleRASc_ClaimsTab_Search", By.xpath(".//a[contains(@id,'SearchAndResetInputSet:SearchLinksInputSet:Search')]"));
		hm.put("eleRASc_ClaimsTab_ECOSinfo", By.xpath(".//span[contains(@id,'RiskAnalysisCV:IRESLink-btnInnerEl')]"));



		hm.put("eleRiskAnaErrMsg", By.id("HIGPolicyFile_RiskAnalysis_Ext:_msgs"));
		hm.put("eleRiskAnalysis_PriorLossesTab", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:LossHistoryCardTab-btnInnerEl"));
		hm.put("lstRiskHistoryType", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:LossHistoryTypeSelectDV:LossHistoryType-inputEl"));
		hm.put("eleTotalIncured", By.xpath(".//*[@id='SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:LossHistoryInputSet:ManualLossHistoryLV-body']//td[5]"));
		hm.put("edtRiskTotalIncurred", By.name("TotalIncurred"));
		hm.put("eleAddUWReferalReason_Btn", By.id("HIGPolicyFile_RiskAnalysis_Ext:UWReferralReasonsLV_tb:AddUWReferralReason-btnInnerEl"));
		hm.put("eleCreate_UWReason_Title", By.xpath("//span[@id='NewPSUWReferralReason_ExtPopup:ttlBar' and contains(text(),'Create New UW Referral Reason')]"));
		hm.put("lstIssueType", By.id("NewPSUWReferralReason_ExtPopup:NewPSUWReferralReason_ExtDV:IssueType-inputEl"));
		hm.put("edtShortDesc", By.id("NewPSUWReferralReason_ExtPopup:NewPSUWReferralReason_ExtDV:ShortDescription-inputEl"));
		hm.put("edtLongDesc", By.id("NewPSUWReferralReason_ExtPopup:NewPSUWReferralReason_ExtDV:LongDescription-inputEl"));
		hm.put("eleUpdateBtn_RiskAnalysis", By.id("NewPSUWReferralReason_ExtPopup:Update-btnInnerEl"));
		hm.put("eleUWReferralReason_tbl", By.xpath("//div[@id='HIGPolicyFile_RiskAnalysis_Ext:UWReferralReasonsLV-body']"));
		hm.put("eleViewDetails_btn", By.id("HIGPolicyFile_RiskAnalysis_Ext:UWReferralReasonsLV_tb:ViewUWReferralReason-btnInnerEl"));
		hm.put("eleReferralReasonDetails_Title", By.xpath("//span[@id='PSReferralReasonDetails_ExtPopup:ttlBar' and contains(text(),'Referral Reason Details')]"));
		hm.put("eleHistory_Referral_tbl", By.xpath("//div[@id='PSReferralReasonDetails_ExtPopup:referralReasonsLDV:3']//div[@id='PSReferralReasonDetails_ExtPopup:referralReasonsLDV:PSUWRefReasonHistory_ExtLV']"));
		hm.put("eleFlagIcon_AccInfoBar", By.xpath("//span[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:flag-btnEl']"));
		hm.put("eleCancel_ReferralReasonDetails", By.id("PSReferralReasonDetails_ExtPopup:Cancel-btnInnerEl"));
		hm.put("eljAccountNo", By.xpath("//span[@class='infobar_elem_val' and contains(text(),'Account #')]"));
		hm.put("eleRiskAnalysisApproval", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:ShortDescription"));
		hm.put("eleReleaseLock", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:Unlock-btnInnerEl')]"));
		hm.put("eleReleaseBtn", By.id("UWActivityPopup:Update-btnInnerEl"));
		hm.put("eleRAClaimtab", By.id("PolicyFile_RiskAnalysis:PolicyFile_RiskAnalysisScreen:PolicyFile_RiskAnalysisCV:PolicyFile_ClaimsCardTab-btnInnerEl"));
		hm.put("eleRAECOS", By.id("PolicyFile_RiskAnalysis:PolicyFile_RiskAnalysisScreen:PolicyFile_RiskAnalysisCV:IRESLink-btnInnerEl"));
		hm.put("lstAction", By.id("PSReferralReasonDetails_ExtPopup:referralReasonsLDV:PSRiskAnalysis_ExtInputSet:actionTaken-inputEl"));
		hm.put("eleReferralUpdate", By.id("PSReferralReasonDetails_ExtPopup:Update-btnInnerEl"));
		hm.put("eleRAAddUWIssue", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV_tb:AddManualIssue-btnInnerEl"));
		hm.put("lstNewUWIssueType", By.id("NewManualUWIssuePopup:NewUWIssueDelegateDV:IssueType-inputEl"));
		hm.put("eleRAPriorPolicies", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:PriorPolicyCardTab-btnInnerEl"));
		hm.put("eleRAPriorLosses", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:LossHistoryCardTab-btnInnerEl"));
		hm.put("lstComplexityScore", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWInfo_ExtDV:complexityScore-inputEl"));

		// Quote
		hm.put("eleQuotePageAfterIssue", By.xpath("//span[text()='Quote' and contains(@id,'PolicyFile_Pricing:PolicyFile_PricingScreen')]"));
		hm.put("eleQuotePage", By.xpath(".//span[contains(text(),'Quote')]"));
		hm.put("eleQuoteTab", By.xpath("//*[contains(@id,':PolicyMenuItemSet_Pricing')]//div"));
		hm.put("elePRQuote", By.xpath(".//*[contains(@id,'QuoteOrReview-btnInnerEl')]"));
		hm.put("eljPRQuote", By.xpath(".//*[contains(@id,'QuoteOrReview-btnInnerEl')]"));
		hm.put("eleBindOption", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions-btnWrap"));
		hm.put("eleCloseOption", By.xpath(".//*[contains(@id,':CloseOptions-btnInnerEl')]"));
		hm.put("bliCloseOption", By.xpath(".//*[contains(@id,':CloseOptions-btnInnerEl')]"));
		hm.put("eleRnlQuote", By.xpath("//*[contains(@id,'RenewalQuote-btnInnerEl')]"));
		hm.put("eljRewriteIssuePolicy", By.id("RewriteWizard:RewriteWizard_PaymentScreen:JobWizardToolbarButtonSet:BindRewrite-btnInnerEl"));
		hm.put("eleIssuePolicy", By.xpath(".//span[contains(text(),'Issue Policy')]"));
		hm.put("eleAlertPopUp", By.id("button-1005-btnInnerEl"));
		hm.put("eleDetails", By.id("UWBlockProgressIssuesPopup:IssuesScreen:DetailsButton-btnInnerEl"));
		hm.put("eleApprove", By.xpath(".//a[contains(text(), 'Approve')]"));
		hm.put("eljeditPolicyTransaction", By.xpath("//*[contains(@id,'EditPolicy-btnInnerEl')]"));
		hm.put("eleRiskOkButton", By.id("RiskApprovalDetailsPopup:Update-btnInnerEl"));
		// hm.put("eleApproveButton",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:Approve"));
		hm.put("eleApproveButton", By.xpath(".//*[contains(@id,':UWIssueRowSet:Approve')]"));
		hm.put("eleSPLApprvoalAssertTable1", By.id("SubmissionWizard/ViewQuote"));
		hm.put("eleSPLApprvoalAssertTable", By.xpath(".//label[contains(text(),'This quote will require underwriting approval prior to ')]"));
		// hm.put("eleSPLApprvoalAssertTable", By.xpath(".//label[contains(text(),'This
		// quote will require underwriting approval prior to issuance')]"));
		hm.put("eleSPLApprvoalAssert", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:WarningsPanelSet:0:PanelSet:Warning"));
		hm.put("eleRiskAnalysisPage", By.xpath(".//span[contains(text(),'Risk Analysis')]"));
		// hm.put("eleAuthorityApprove",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:authorityAcknowledge_Ext"));
		hm.put("eleAuthorityApprove", By.xpath(".//*[contains(@id,':authorityAcknowledge_Ext')]"));
		hm.put("eleBindOptionAssert", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions-btnInnerEl"));
		hm.put("eleAuthorityAckowledge", By.xpath(".//a[contains(text(), 'Authority Acknowledge')]"));
		// hm.put("eleAuthorityAckowledge",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:1:UWIssueRowSet:authorityAcknowledge_Ext"));
		hm.put("eleSpecialApprove", By.xpath(".//a[contains(text(),'Special Approve')]"));

		// hm.put("eleApproveButtonType",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:0-body"));
		hm.put("eleQuote", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
		hm.put("eleApproveButtonType", By.xpath(".//*[contains(@id,':RiskEvaluationPanelSet:0-body')]"));
		hm.put("eleSpecialApproveButton", By.xpath(".//*[contains(@id,':UWIssueRowSet:SpecialApprove')]"));
		hm.put("eleUWApprove", By.xpath("//a[text() = 'Approve']"));
		hm.put("eleUWSpecialApprove", By.xpath("//a[text() = 'Special Approve']"));
		hm.put("eleUWAuthorityAcknowledgement", By.xpath("//a[text() = 'Authority Acknowledge']"));
		hm.put("eleViewQuote", By.xpath("//td[contains(@id,'ViewQuote')]/div"));
		hm.put("eleWorkSpaceClear", By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl"));
		hm.put("eleSORQuote", By.xpath("//*[contains(@id,':ViewQuote')]/div"));
		// hm.put("eleNext ", By.id("PolicyChangeWizard:Next-btnInnerEl"));
		hm.put("eleEditPolicyTransaction", By.xpath(".//*[contains(@id,'EditPolicy-btnInnerEl')]"));

		// Payment
		hm.put("elePaymentPage", By.xpath(".//*[@id='SubmissionWizard:BillingInfo']/div/span[text()='Payment']"));
		//hm.put("eljPaymentPage", By.xpath(".//span[contains(text(),'Payment')]"));
		hm.put("eljPaymentPage", By.xpath(".//span[text()='Payment']"));
		hm.put("lstBillingMethod", By.xpath("//*[contains(@id,'BillingAdjustmentsDV:BillingMethod-inputEl')]"));
		hm.put("elePayBindOption", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:BindOptions-btnWrap"));
		hm.put("elePayIssuePolicy", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:BindOptions:BindAndIssue-textEl"));
		// hm.put("elePolicyNumber",
		// By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
		hm.put("elePolicyNumber", By.xpath(".//*[contains(@id,'ViewPolicy-inputEl')]"));
		hm.put("lstBillingNumber", By.xpath("//*[contains(@id,'billingnumber_Ext-inputEl')]"));
		// hm.put("edtBillingNumber",
		// By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:enterBillingNumber_Ext-inputEl"));
		hm.put("edtBillingNumber", By.xpath("//input[contains(@id,'enterBillingNumber')]"));
		hm.put("lstPay", By.xpath("//*[contains(@id,'installmentplans_Ext-inputEl')]"));
		hm.put("elePolicySummary", By.id("PolicyFile_Summary:Policy_SummaryScreen:0"));
		// hm.put("bliPayBindOption",
		// By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:BindOptions-btnWrap"));
		hm.put("bliPayBindOption", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:BindOptions-btnWrap')]"));
		// hm.put("bliPayBindOption",
		// By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:BindOptions-btnWrap')]"));
		hm.put("eleclkPolicyNumber", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
		hm.put("eleViewPolicy", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
		hm.put("elePolicyNumbetInPolicySummaryPage", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_PolicyDV:PolicyNumber-inputEl"));
		hm.put("elePayrollProviderImg", By.xpath("//*[contains(@id,'payrollprovidernametrigger:Selectpayrollprovidernametrigger')]"));
		hm.put("eleXactPayLaunchTitle", By.id("PSXactpayLaunch_ExtPopup:XactpayLaunchScreen:0"));
		hm.put("eleNewBillingNum", By.xpath("//*[contains(@id,'newBillingNumber-inputEl')]"));
		hm.put("eleAlternateNewPerson", By.xpath("//*[contains(@id,'AccountContactBillingInputSet:changeAltPayerContactButton_Ext:1:altPayerContactType-textEl')]"));
		hm.put("eleCollectedByAgent", By.xpath("//*[contains(@id,'BillingAdjustmentsDV:BillingMethodDependent:CollectedByAgent_Ext:CollectedByAgent-labelEl')]"));
		hm.put("eleClassName", By.className("x-list-plain"));
		hm.put("lstNewSubmissionSORSHELLList", By.xpath("//ul[@class='x-list-plain']"));
		hm.put("PolicyNumbetInPolicySummaryPage", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_PolicyDV:PolicyNumber-inputEl"));
		hm.put("SubmissionSource", By.id("PolicyFile_PolicyInfo:PolicyFile_PolicyInfoScreen:PolicyFile_PolicyInfoDV:PolicyInfoInputSet:SubmissionSource-inputEl"));
		hm.put("eleStandardPlan", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:installmentplantypeindicator_true-inputEl"));
		hm.put("eleOverridePlan", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:installmentplantypeindicator_false-inputEl"));

		// Final Submission Bound Page(To take the policy Number)
		hm.put("eleSubmissionBound", By.id("JobComplete:JobCompleteScreen:ttlBar"));
		hm.put("elePolicyNumberText", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
		hm.put("eleSubmissionNumber", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV:0:JobNumber"));
		hm.put("lstSelect", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:selectBillingNumber_Ext-inputEl"));

		hm.put("edtPayAddress1", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edtPayCityName", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		// Add Class Function
		// hm.put("eletableRowXpath",
		// By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV-body']/div/table/tbody"));
		hm.put("eletableRowXpath", By.xpath(".//*[contains(@id,':WCCovEmpLV-body')]"));
		hm.put("eleCheckingStateActExist", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV-body']/div/table/tbody/tr"));

		// State Edit Box
		hm.put("edtStateAct", By.name("WC7SpecialCoverage"));

		// Address Edit Box
		hm.put("edtAddressCode", By.name("Loc"));

		// Class CodeeleAccMerge
		hm.put("lstAddClassSearchCode", By.name("ClassCode"));
		hm.put("eleAddClassSearchButton", By.className("x-trigger-index-0 x-form-trigger x-form-search-trigger x-form-trigger-first"));
		hm.put("eleClassSearchButton", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV:0:ClassCode:SelectClassCode"));
		hm.put("edtEnterClassCode", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:WC7ClassCodeSearchDV:Code-inputEl"));
		hm.put("eleClassCodeButton", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:WC7ClassCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSelectInput", By.id("WC7ClassCodeSearchPopup:WC7ClassCodeSearchScreen:ClassCodeSearchResultsLV:0:_Select"));

		// Annual Premium
		hm.put("eleAnualPremiumEditClick", By.name("AnnualRenum"));
		hm.put("edtAnualPremiumEditClick", By.name("AnnualRenum"));
		hm.put("lstAnualPremiumEditClick", By.name("AnnualRenum"));

		// Search Policy
		hm.put("melPolicy", By.id("TabBar:PolicyTab-btnInnerEl"));
		hm.put("edtPolicyNumber", By.id("TabBar:PolicyTab:PolicyTab_PolicyRetrievalItem-inputEl"));
		hm.put("elePolicyNumberSearch", By.id("TabBar:PolicyTab:PolicyTab_PolicyRetrievalItem_Button"));
		hm.put("eleSearchResultsTbl", By.xpath("//div[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV-body']//table"));
		hm.put("elePolicyNum", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV:0:PolicyNumber"));
		// Merge Accounts
		hm.put("eleAccMerge", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_MergeAccounts-textEl"));
		hm.put("edtAccNum", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:AccountNumber-inputEl"));
		hm.put("eleMergeSearch", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSelect", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:OtherAccountSearchResults_ExtLV:0:Select_Ext"));
		hm.put("eleMerge", By.id("AccountFile_MergeAccountsSelection:MergeAccounts-btnInnerEl"));
		hm.put("edtMergeCompanyName", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleSameTgtasSrc", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:_msgs"));
		hm.put("eleMergeCancel", By.id("AccountFile_MergeAccountsSelection:CancelButton-btnInnerEl"));
		hm.put("btnResetbtn", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("txtMergeTranMsg", By.id("AccountFile_Summary:AccountFile_SummaryScreen:accountMergeMsg_Ext"));
		hm.put("txtMergeCancelMsg", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:GlobalContactNameInputSet:Name-labelEl"));
		hm.put("txtCapAccNum", By.xpath(".//*[@id='AccountFile:AccountFileInfoBar:Account-btnInnerEl']/span[2]"));
		hm.put("txtTagetAccNotExistMsg", By.xpath(".//*[@id='AccountFile_AccountSearch:OtherAccountSearchScreen:_msgs']/div[1]"));
		hm.put("eleContacts", By.xpath(".//span[contains(text(), 'Contacts')]"));
		hm.put("eleMergeTranMsg", By.id("AccountFile_Summary:AccountFile_SummaryScreen:accountMergeMsg_Ext"));
		hm.put("eleMergeCancelMsg", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:GlobalContactNameInputSet:Name-labelEl"));
		hm.put("eleCapAccNum", By.xpath(".//*[@id='AccountFile:AccountFileInfoBar:Account-btnInnerEl']/span[2]"));
		hm.put("eleTagetAccNotExistMsg", By.xpath(".//*[@id='AccountFile_AccountSearch:OtherAccountSearchScreen:_msgs']/div[1]"));
		// hm.put("eleContacts", By.xpath(".//span[contains(text(), 'Contacts')]"));
		// hm.put("eleContacts",
		// By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Contacts']/div/span"));
		hm.put("eleRole", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:RolesCardTab-btnInnerEl"));
		hm.put("eleMAHTable1", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']/div/table/tbody/tr[2]/td[4]"));

		// Merge Validation
		hm.put("eleSearchMenu", By.id("TabBar:SearchTab-btnWrap"));
		hm.put("eleAccSearch", By.id("TabBar:SearchTab:Search_AccountSearch-textEl"));
		hm.put("edtSourceAccount", By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:AccountNumber-inputEl"));
		hm.put("eleZeroResultMsg", By.xpath(".//div[contains(text(), 'The search returned zero results.')]"));
		hm.put("eleMVSearch", By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleCompMatch", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:CompanyNameExact-inputEl"));
		hm.put("edtMerAllianceNum", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:AllianceMember_Ext-inputEl"));
		hm.put("edtMerAIFNum", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:AIFNumber_Ext-inputEl"));
		hm.put("edtMerFEIN", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:FEIN_Ext-inputEl"));
		hm.put("edtMerExperian", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:AccountSearch_ExtDV:ExperianKey_Ext-inputEl"));
		hm.put("eleMAHTable2", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactRolesDV:ContactRolesLV-body']/div/table/tbody/tr/td[2]"));
		hm.put("txtCheckNewRoleActiveStatus", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']/div/table/tbody/tr[2]/td[2]"));
		hm.put("eleCheckNewRoleActiveStatus", By.xpath(".//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']/div/table/tbody/tr[2]/td[2]"));
		hm.put("eleMerAIFNum", By.id("EditAccountPopup:EditAccountScreen:aifNumber_Ext-inputEl"));
		hm.put("eleMerAllianceNum", By.id("EditAccountPopup:EditAccountScreen:allianceNumber_Ext-inputEl"));
		hm.put("eleMerFEINNum", By.id("EditAccountPopup:EditAccountScreen:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("accFileContactRoleTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body"));
		hm.put("eleAccFileContactRoleTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body"));

		// Policy Move
		hm.put("elePolicyMove", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_MovePolicies-textEl"));
		hm.put("eleMergePolicy", By.id("AccountFile_MovePoliciesSelection:MovePoliciesButton"));
		hm.put("btnMergePolicy", By.id("AccountFile_MovePoliciesSelection:MovePoliciesButton"));
		hm.put("txtPolicyMoveMsg", By.id("AccountFile_Summary:AccountFile_SummaryScreen:policyMoveMsg_Ext"));
		hm.put("eleMutilplePolicyMsgCheck", By.id("AccountFile_MovePoliciesSelection:_msgs"));
		hm.put("txtMutilplePolicyMsgCheck", By.id("AccountFile_MovePoliciesSelection:_msgs"));
		hm.put("elePMCount", By.id("AccountFile_MovePoliciesSelection:PSAccountFile_MovePoliciesSelection_ExtLV-body"));
		hm.put("rowPMCount", By.id("AccountFile_MovePoliciesSelection:PSAccountFile_MovePoliciesSelection_ExtLV-body"));
		hm.put("eleAfterPolicyMoveVerify", By.xpath(".//*[@id='AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV-body']"));
		hm.put("eleMergeAccounts", By.id("AccountFile_MergeAccountsSelection:MergeAccounts-btnInnerEl"));
		hm.put("elePolicyMoveButton", By.id("AccountFile_MovePoliciesSelection:MovePoliciesButton-btnInnerEl"));
		hm.put("txtMergeAccountinPolicyMove", By.id("AccountFile_MergeAccountsSelection:mergeAccountsAlert"));
		hm.put("txtMergeAccountinPolicyMove2", By.id("AccountFile_MergeAccountsSelection:mergeAccountRemovalAlert"));
		hm.put("eleMergeAccountinPolicyMove", By.id("AccountFile_MergeAccountsSelection:mergeAccountsAlert"));
		hm.put("eleMergeAccountinPolicyMove2", By.id("AccountFile_MergeAccountsSelection:mergeAccountRemovalAlert"));

		// Policy Move Verification
		hm.put("chkPolicyAvbleinTgtAcc", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:higpolicy"));
		hm.put("chkPolicyAvbleinTgtAcc1", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:1:higpolicy"));
		hm.put("elePolicyAvbleinTgtAcc", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:higpolicy"));
		hm.put("elePolicyAvbleinTgtAcc1", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:1:higpolicy"));
		hm.put("elePolicyMoveCancel", By.id("AccountFile_MovePoliciesSelection:ToolbarButton-btnInnerEl"));
		hm.put("txtCancelConfirmScreen", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:ttlBar"));
		hm.put("eleCancelConfirmScreen", By.id("AccountFile_AccountSearch:OtherAccountSearchScreen:ttlBar"));
		hm.put("elePopUpCancel", By.id("button-1008-btnInnerEl"));
		hm.put("txtPopUpWindowMsg", By.id("messagebox-1001-displayfield-inputEl"));
		hm.put("elePopUpWindowMsg", By.id("messagebox-1001-displayfield-inputEl"));

		// Account Contacts
		hm.put("eleAccountDetailTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDetailCardTab-btnInnerEl"));
		hm.put("eleRoleTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:RolesCardTab-btnInnerEl"));
		hm.put("txtAccNameinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("txtAddressinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("txtMailinginContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:AddressType-inputEl"));
		hm.put("txtEmailinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("txtFEINinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("eleAccNameinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAddressinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("eleMailinginContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:AddressType-inputEl"));
		hm.put("eleEmailinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("eleFEINinContactDetail", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("eleRoleTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactRolesDV:ContactRolesLV-body"));
		hm.put("eleAdrressesTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesCardTab-btnInnerEl"));
		hm.put("txtAddressinAddressTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("txtAddressTypeinAddressTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressType-inputEl"));
		hm.put("eleAddressinAddressTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("eleAddressTypeinAddressTab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressType-inputEl"));
		hm.put("eleCreateNewAccountforCompany", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton-btnWrap"));
		hm.put("eleBillingContactforCompany", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:5:roleType-arrowEl"));
		hm.put("eleBillingContactforCompany1", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:5:roleType:0:contactType-textEl"));
		hm.put("edtBillingContactName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleChangeStatus", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:changeActiveStatus-btnInnerEl"));
		hm.put("eleRemoveContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:removeContact-btnInnerEl"));
		hm.put("edtContactName", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAFContactUpdate", By.id("EditAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleAccountFileContactRoleTab", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:RolesCardTab-btnIconEl"));
		hm.put("eleAddRole", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton-btnWrap"));
		hm.put("eleAddRoleBC", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton:5:RoleType-textEl"));
		hm.put("eleAccountFileRoleTable", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactRolesDV:ContactRolesLV-body"));
		hm.put("eleRemoveRole", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactRolesDV:ContactRolesLV_tb:Remove-btnInnerEl"));
		hm.put("eleAddressTab", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesCardTab-btnInnerEl"));
		// R3 - hm.put("eleAddressTab",
		// By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesCardTab-btnInnerEl"));
		hm.put("eleAddAddress", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressesLV_tb:Add-btnInnerEl"));
		// hm.put("edtAddAddress1",
		// By.id("AddressStandardization_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		// hm.put("eleAddZipCode",
		// By.id("AddressStandardization_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		// hm.put("lstAddZipCode",
		// By.id("AddressStandardization_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edtAddAddress1", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		// r 3hm.put("edtAddAddress1",
		// By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edtAddCity", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("lstContact_State", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl')]"));
		hm.put("eleAddZipCode", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("lstAddZipCode", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		// R3 hm.put("lstAddZipCode",
		// By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleAddStandardize", By.id("EditAccountContactPopup:ContactDetailScreen:standardizeButton_Ext-btnInnerEl"));
		hm.put("eleAccountFileContactUpdate", By.cssSelector("a[id='EditAccountContactPopup:ContactDetailScreen:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleAddOK", By.id("AddressStandardization_ExtPopup:updateButton_Ext-btnInnerEl"));
		hm.put("eleAddressesTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressesLV-body"));
		hm.put("txtAddresses", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("txtMailing", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressType-inputEl"));
		hm.put("eleAddresses", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("eleMailing", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AddressesPanelSet:AddressDetailDV:AddressType-inputEl"));
		hm.put("eleAssociatedPoliceis", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:PoliciesCardTab-btnInnerEl"));
		hm.put("eleListofPolciesTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountFile_Contacts_PoliciesLV-body"));
		hm.put("eleAccountSummaryPage", By.id("PolicyFile_Summary:Policy_SummaryScreen:0"));
		hm.put("eleNewAddressTable", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AddressesPanelSet:AddressesLV-body"));
		hm.put("bliAddRole", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton-btnWrap"));
		hm.put("eleDBATab", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:DBACardTab-btnInnerEl"));
		hm.put("bliAddDBA", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:addContactButton-btnWrap"));
		hm.put("lstCompanyType", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:companyType_Ext-inputEl"));
		hm.put("edtCompanyDBAName", By.name("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name"));
		hm.put("eleDBAOK", By.id("NewDBAContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		hm.put("eleContactDBATab", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:DBACardTab-btnInnerEl"));
		hm.put("eleContacts_DBATable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV-body"));

		// Manage Activity
		hm.put("eleAction_Act", By.id("SubmissionWizard:WizardMenuActions-btnInnerEl"));
		// hm.put("eleNewActivity",
		// By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewActivity-textEl"));
		hm.put("eleNewShellActivity", By.xpath(".//*[contains(@id,'Create:ActivityID-textEl')]"));
		hm.put("eleNewActivity", By.xpath(".//a[contains(@id,'NewActivity-itemEl')]"));
		// R3 ---hm.put("eleNewActivity",
		// By.xpath(".//*[contains(@id,'MenuActions_NewActivity-textEl')]"));
		hm.put("eleReminder", By.xpath("//*[contains(@id,'NewActivityMenuItemSet')]//span[contains(text(), 'Reminder')]"));
		hm.put("eleFollowUp", By.xpath("//*[contains(@id,'NewActivityMenuItemSet')]//span[contains(text(), 'Follow up')]"));
		hm.put("eleRemainder", By.xpath("//*[contains(@id,'ActivityDetailWorksheet:ActivityDetailScreen:CloseAndCreateToolBarButton:CloseAndCreate_ExtMenuItemSet:')]//span[contains(text(), 'Reminder')]"));
		hm.put("eleRemainderFollowUp", By.xpath("//*[contains(@id,'ActivityDetailWorksheet:ActivityDetailScreen:CloseAndCreateToolBarButton:CloseAndCreate_ExtMenuItemSet:')]//span[contains(text(), 'Follow up')]"));
		hm.put("eleActivityOK", By.xpath("//*[contains(@id,'UpdateButton-btnInnerEl')]"));
		hm.put("eljActivityOK", By.xpath("//*[contains(@id,'UpdateButton-btnInnerEl')]"));
		hm.put("lstTopicAM", By.xpath("//*[contains(@id,'Topic-inputEl')]"));
		hm.put("edtTextAM", By.xpath("//*[contains(@id,'Text-inputEl')]"));
		hm.put("eleActivityTable", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV-body"));
		hm.put("ActivityTable", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV-body"));
		hm.put("eleActivityFollowUpList", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:0:Subject"));
		hm.put("eleCloseActivity", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_SkipButton-btnInnerEl"));
		hm.put("lstCurrentActivitiesAllOpen", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:activitiesFilter-inputEl"));
		hm.put("txtViewNoteWarningMsg", By.id("NewActivityWorksheet:NewActivityScreen:_msgs"));
		hm.put("eleViewNotes", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtons_ViewNotes-btnInnerEl"));
		hm.put("txtViewNotesMessage", By.id("x-form-el-AccountFile_Notes:NotesScreen:NotesLV:0:NoteRowSet:Body"));
		hm.put("eleViewNotesMessage", By.id("x-form-el-AccountFile_Notes:NotesScreen:NotesLV:0:NoteRowSet:Body"));
		hm.put("eleAccountFileNotesScreen", By.id("AccountFile_Notes:NotesScreen:ttlBar"));
		hm.put("clrDueDate", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:TargetDate-inputEl"));
		hm.put("clrEscalationDate", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:EscalationDate-inputEl"));
		hm.put("eleActivityCancel", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:Cancel-btnInnerEl"));
		hm.put("txtActivityStatus", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Status-inputEl"));
		// hm.put("eleActivityStatus",
		// By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Status-inputEl"));
		hm.put("eleActivityStatus", By.xpath(".//*[contains(@id, 'Status-inputEl')]"));
		hm.put("eleAssigmentErrorBanner", By.id("AssignmentAdmin_ExtPage:_msgs"));
		hm.put("eleActivityClosed0", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:0:Subject"));
		hm.put("eleActivityClosed3", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:3:Subject"));
		hm.put("eleActivityCompleted4", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:4:Subject"));
		hm.put("eleCompleteAcitivity", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_CompleteButton-btnInnerEl"));
		hm.put("eleCloseCreateNew", By.id("ActivityDetailWorksheet:ActivityDetailScreen:CloseAndCreateToolBarButton-btnWrap"));
		hm.put("blinewRemainder", By.id("ActivityDetailWorksheet:ActivityDetailScreen:CloseAndCreateToolBarButton-btnWrap"));
		// hm.put("eleRemainderCloseandCreate", By.xpath(".//span[contains(text(),
		// 'Reminder')]"));
		// hm.put("eleRemainderFollowUp", By.xpath(".//span[contains(text(), 'Follow
		// up')]"));
		hm.put("eleReplaceActivityCheck", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:ActivityStatus-inputEl"));
		hm.put("txtStatusCheck", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:ActivityStatus-inputEl"));
		hm.put("eleSearchLookUpMA", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:SelectFromList:AssigneePicker"));
		hm.put("lstMAQueue", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:SearchFor-inputEl"));
		hm.put("lsjMAQueue", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:SearchFor-inputEl"));
		hm.put("edtMAQueue", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:QueueName-inputEl"));
		hm.put("eleMAAssignQueue", By.id("PCAssigneePickerPopup:AssigneePickerScreen:PCAssignmentQueueLV:0:_Select"));
		hm.put("eleMASearch", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("edtMAUserName", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:Username-inputEl"));
		hm.put("eleMAUNAssign", By.id("PCAssigneePickerPopup:AssigneePickerScreen:PCAssignmentUserLV:0:_Select"));
		hm.put("eleMAPoleleActions", By.id("PolicyFile:PolicyFileMenuActions-btnIconEl"));
		// hm.put("eleMAPolNewActivity",
		// By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_Create:PolicyFileMenuActions_NewActivity-textEl"));
		hm.put("eleMAPolNewActivity", By.xpath(".//*[contains(@id,'NewActivity-textEl')]"));
		hm.put("eleMAPolReminder", By.xpath(".//span[contains(text(), 'Reminder')]"));
		hm.put("eleMAPolFollowUp", By.xpath(".//span[contains(text(), 'Follow up')]"));
		// hm.put("elePartnerException",
		// By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:PartnerException-inputEl"));
		hm.put("elePartnerException", By.xpath("//*[contains(@id,'PartnerException-inputEl')]"));
		hm.put("lstPartnerExceptionResason", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:ExceptionReason-inputEl"));
		hm.put("eleMAReset", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleRemainderXSellFollowUp", By.xpath(".//*[contains(text(),'X-Sell')]"));
		hm.put("lstActivity_Status", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:activitiesFilter-inputEl"));
		hm.put("eleActivityDesc", By.name("NewActivityWorksheet:NewActivityScreen:NewActivityDV:Description2-inputEl"));
		// hm.put("eleNewActivity",
		// By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID-itemEl"));
		// hm.put("eleReminder",
		// By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:7:NewActivityMenuItemSet_Category"));
		hm.put("eleFollowUp", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:7:NewActivityMenuItemSet_Category:0:item "));
		hm.put("eleRequest", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:8:NewActivityMenuItemSet_Category"));
		hm.put("eleNbPrep", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:8:NewActivityMenuItemSet_Category:14:item"));
		hm.put("eleOther", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:0:item"));
		hm.put("eleActivityAssign", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_AssignButton"));
		hm.put("eleAssignbutton", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentByGroupPopupScreen_ButtonButton"));
		hm.put("eleActivityEdit", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:Edit"));
		hm.put("eleAMP", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category"));
		hm.put("eleAMPToDo", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:28:item"));
		hm.put("eleAMPEvaluate", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:10:item"));
		hm.put("eleSummary", By.xpath(".//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Summary']/div/span"));
		hm.put("eljSummary", By.xpath(".//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Summary']/div/span"));
		hm.put("eleComplete", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_CompleteButton-btnInnerEl"));
		hm.put("eleAMPPreRenewalDirection", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:24:item"));
		// manage activity rathish going to be changed
		hm.put("eleAMPTABSFollowUp", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:27:item"));
		hm.put("eleAMPRequestACORD", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:21:item"));
		hm.put("eleAMPRequestRenewalInfo", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:23:item"));
		hm.put("eleAMPSecondRequest", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:26:item"));
		hm.put("eleAMPCertificateOfInsurance", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:7:item"));
		hm.put("eleAMPReferral", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:18:item"));
		hm.put("eleAMPAcknowledgeRenewal", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:1:item"));
		hm.put("eleAMPBrokerQuote", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category:5:item"));
		// hm.put("eleAMP",
		// By.xpath("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID:NewActivityMenuItemSet:1:NewActivityMenuItemSet_Category"));
		hm.put("lstRelatedTo", By.id("NewActivityWorksheet:NewActivityScreen:ActivityDetailNoteDV:RelatedTo-inputEl"));
		hm.put("eleRelatedTo", By.id("NewActivityWorksheet:NewActivityScreen:ActivityDetailNoteDV:RelatedTo-inputEl"));
		hm.put("edtActivityText", By.id("NewActivityWorksheet:NewActivityScreen:ActivityDetailNoteDV:Text-inputEl"));
		hm.put("lstActivityTopic", By.id("NewActivityWorksheet:NewActivityScreen:ActivityDetailNoteDV:Topic-inputEl"));
		hm.put("eleActivityErrorMsg", By.id("NewActivityWorksheet:NewActivityScreen:_msgs"));

		hm.put("eleMyQueues", By.id("Desktop:MenuLinks:Desktop_DesktopAssignableQueues"));
		hm.put("eleMyGroups", By.id("Desktop:MenuLinks:Desktop_DesktopAssignableGroups_Ext"));
		hm.put("eleMyActivities", By.id("Desktop:MenuLinks:Desktop_DesktopActivities"));
		hm.put("eleCallOutChcbx", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:CallOut-inputEl"));
		hm.put("eleCallOutLbl", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:CallOut-inputEl"));
		hm.put("edtEscalationDate", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:EscalationDate-inputEl"));
		hm.put("eleActivityTblBody", By.id("PCAssigneePickerPopup:AssigneePickerScreen:PCAssignmentUserLV-body"));
		hm.put("eleAssignPicker", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:SelectFromList:AssigneePicker"));
		hm.put("lstSearchFor", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:SearchFor-inputEl"));
		hm.put("eleAssignSearch", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleAssignReset", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleAssignBtn", By.xpath(".//a[contains(text(), 'AssigneePickerScreen')]"));
		hm.put("edtAssignFirstName", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:PLNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("eleAssignNewActivity", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewActivity-itemEl"));
		hm.put("eleReturnActivity", By.id("PCAssigneePickerPopup:__crumb__"));
		hm.put("eleActivityAssert", By.id("NewActivityWorksheet:NewActivityScreen:ttlBar"));
		hm.put("eleMyActivitiesTbl", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
		// hm.put("eleMyActivitiesAssign",
		// By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV_tb:DesktopActivities_AssignButton-btnInnerEl"));
		hm.put("eleMyActivitiesAssign", By.id("PCAssigneePickerPopup:AssigneePickerScreen:PCAssignmentUserLV-body"));

		hm.put("eleMyActivitiesDesktop", By.id("TabBar:DesktopTab-btnInnerEl"));
		hm.put("eleQueueAssignSelectedToMe", By.id("DesktopAssignableQueues:DesktopAssignableQueuesScreen:AssignSelectedButton-btnInnerEl"));
		hm.put("eleAssignTo", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:SelectFromList-inputEl"));
		hm.put("eleAccountSummary", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_Summary"));
		hm.put("eleMyQueuesTbl", By.id("DesktopAssignableQueues:DesktopAssignableQueuesScreen:DesktopAssignableQueuesLV-body"));

		hm.put("eleMyGroupsTbl", By.id("DesktopAssignableGroups_Ext:activitiesLV:DesktopAssignableGroups_ExtLV-body"));
		hm.put("eleGroupAssignSelectedToMe", By.id("DesktopAssignableGroups_Ext:AssignSelectedButton-btnInnerEl"));
		hm.put("elePartnerExceptionChckBox", By.xpath("//*[contains(@id,'PartnerException-inputEl')]"));
		hm.put("eleRestoration", By.xpath("//*[contains(@id,'BP7CoverageInputSet:CovPatternInputGroup:OptionTerm2:OptionTermInput2-inputEl')]"));

		// hm.put("eleExceptionReason",
		// By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:ExceptionReason-inputEl"));
		hm.put("lstExceptionReason", By.xpath("//*[contains(@id,'ExceptionReason-inputEl')]"));

		hm.put("lstAllGroupsBtn", By.id("DesktopAssignableGroups_Ext:activitiesLV:DesktopAssignableGroups_ExtLV:assignableGroupFilter-inputEl"));
		hm.put("edtAllGroupsBtn", By.id("DesktopAssignableGroups_Ext:activitiesLV:DesktopAssignableGroups_ExtLV:assignableGroupFilter-inputEl"));
		hm.put("eleMyGroupsAssert", By.id("DesktopAssignableGroups_Ext:ttlBar"));
		hm.put("lstAllOpenBtn", By.id("DesktopAssignableGroups_Ext:activitiesLV:DesktopAssignableGroups_ExtLV:activitiesFilter-inputEl"));
		hm.put("edtAllOpenBtn", By.id("DesktopAssignableGroups_Ext:activitiesLV:DesktopAssignableGroups_ExtLV:activitiesFilter-inputEl"));
		hm.put("elePriority", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:Priority-inputEl"));
		hm.put("eleSecurityLevel", By.id("NewActivityWorksheet:NewActivityScreen:ActivityDetailNoteDV:SecurityLevel-inputEl"));
		hm.put("elePartnerExceptionResason", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:ExceptionReason-inputEl"));
		hm.put("eleBulkAssignment", By.xpath(".//a[contains(text(), 'BulkAssignment')]"));
		hm.put("lstAssignTo", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:SelectFromList-inputEl"));
		hm.put("eleEscalationDate", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityDV:EscalationDate-inputEl"));
		hm.put("eleshellpolicyActivity", By.id("HIGPolicyFile_Summary:0:Subject"));
		hm.put("eleGrp_InQueue", By.xpath("//div[@id='Team:TeamMenuTree:TeamTreeView-body']//span[contains(@class,'x-tree-node-text') and text()='In Queue']"));
		hm.put("eleActivitySubjectVal", By.xpath("//*[contains(@id,'NewActivityDV:Subject-inputEl')]"));
		hm.put("eleActivityDescVal", By.xpath("//*[contains(@id,'NewActivityDV:Description2-inputEl')]"));
		hm.put("eleCancelNewActivity", By.id("NewActivityWorksheet:NewActivityScreen:NewActivityScreen_CancelButton-btnInnerEl"));
		hm.put("edtMAGroupName", By.id("PCAssigneePickerPopup:AssigneePickerScreen:AssignmentSearchDV:AssignmentSearchInputSet:GroupName-inputEl"));
		hm.put("eleActivityAudit", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_Create:PolicyFileMenuActions_NewActivity:NewActivityMenuItemSet:5:NewActivityMenuItemSet_Category:3:item-itemEl"));
		hm.put("eleActivityManual", By.id("SubmissionWizard:WizardMenuActions:WizardMenuActions_Create:WizardMenuActions_NewActivity:NewActivityMenuItemSet:13:NewActivityMenuItemSet_Category:15:item-itemEl"));
		hm.put("eleCloseActivity", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_SkipButton-btnInnerEl"));

		// Account Notes Search
		hm.put("eleAccNotes", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_Notes"));
		hm.put("edtAccNoteSearchText", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:TextSearch-inputEl"));
		hm.put("eleAccountNotesSearch", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("funAccountNotesVerify", By.id("x-form-el-AccountFile_Notes:NotesScreen:NotesLV:0:NoteRowSet:Subject"));
		hm.put("edtAccNoteSearchAuthor", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:Author-inputEl"));
		hm.put("lstAccNoteSearchTopic", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:Topic-inputEl"));
		hm.put("edtAccNoteSearchDateFrom", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:DateFrom-inputEl"));
		hm.put("edtAccNoteSearchDateTo", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:DateTo-inputEl"));
		hm.put("lstAccNoteSearchRelatedTo", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:RelatedTo-inputEl"));
		hm.put("eleAccountNoteReset", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleAccNoteAscOrder", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:sortAscending_true-inputEl"));
		hm.put("eleDecNoteAscOrder", By.id("AccountFile_Notes:NotesScreen:NoteSearchDV:sortAscending_false-inputEl"));

		// Account Search Screen
		hm.put("eleAccountFileNotes", By.id("AccountFile_Notes:NotesScreen:ttlBar"));

		// Create Account Notes
		hm.put("eleAccountAction", By.id("AccountFile:AccountFileMenuActions-btnInnerEl"));
		hm.put("eleNewNote", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewNote-textEl"));
		hm.put("lstTopic", By.id("NewAccountNoteWorksheet:NewNoteScreen:NewNoteDV:Topic-inputEl"));
		hm.put("edtSubjectText", By.id("NewAccountNoteWorksheet:NewNoteScreen:NewNoteDV:Subject-inputEl"));
		hm.put("edtText", By.id("NewAccountNoteWorksheet:NewNoteScreen:NewNoteDV:Text-inputEl"));
		hm.put("sclAccCreateUpdate", By.id("NewAccountNoteWorksheet:NewNoteScreen:NewNoteScreen_UpdateButton-btnInnerEl"));
		hm.put("eleAccCreateUpdate", By.id("NewAccountNoteWorksheet:NewNoteScreen:NewNoteScreen_UpdateButton-btnInnerEl"));

		// Delete Account Note
		hm.put("eleDelete", By.id("AccountFile_Notes:NotesScreen:NotesLV:0:NoteRowSet:NotesLV_DeleteLink"));
		hm.put("eleDeleteAccountNoteOK", By.id("button-1005-btnInnerEl"));

		// Edit Account Notes
		hm.put("eleAccountNoteEdit", By.id("AccountFile_Notes:NotesScreen:NotesLV:0:NoteRowSet:NotesLV_EditLink"));
		hm.put("edtEditAccNoteSubject", By.id("EditNotePopup:EditNoteScreen:EditNoteDV:Subject-inputEl"));
		hm.put("edtEditAccNoteText", By.id("EditNotePopup:EditNoteScreen:EditNoteDV:Text-inputEl"));
		hm.put("eleUpdateAccEditNote", By.id("EditNotePopup:EditNoteScreen:Update-btnInnerEl"));
		hm.put("eleCustomerVerified", By.id("AccountFile_Summary:AccountFile_SummaryScreen:custVerifiedButton_Ext-btnInnerEl"));

		// Policy Search
		hm.put("elePolicyTransactions", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_WorkOrders"));
		hm.put("eleSelectPolicy", By.id("AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:AccountWorkOrdersLV:0:PolicyNumber"));

		// Policy Summary
		// hm.put("elepolicySummary_Activitytbl",
		// By.id("HIGPolicyFile_Summary:26-body"));
		hm.put("elePSBillingNum", By.id("HIGPolicyFile_Summary:BillingInformationDV:BillingNumber-btnInnerEl"));
		hm.put("PolicyEffectiveDate", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_DatesDV:PolicyPerEffDate-inputEl"));
		hm.put("PolicyExpirationDate", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_DatesDV:PolicyPerExpirDate-inputEl"));
		hm.put("PolicyCompnayCode", By.xpath("//div[contains(@id,':UWCompany-inputEl')]"));
		hm.put("AccountProducerCode", By.xpath("//div[contains(@id,'producerCode_Ext-inputEl')]"));
		hm.put("ProducerCode", By.xpath("//div[contains(@id,'producerCode_Ext-inputEl')]"));
		hm.put("PolicySummaryTable", By.xpath("//div[@id='PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']"));
		hm.put("PolicySummaryHeader", By.xpath("//div[@id='PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV']//div[contains(@id,'headercontainer') and @class='x-box-inner ']"));
		hm.put("PSBillingNum", By.id("HIGPolicyFile_Summary:BillingInformationDV:BillingNumber-btnInnerEl"));
		// Search Policy Notes
		hm.put("elePolicyNotes", By.id("PolicyFile:MenuLinks:PolicyFile_PolicyFile_Notes"));
		hm.put("elePolicyNote", By.id("SubmissionWizard:Notes"));
		// hm.put("edtPolicySearchText",
		// By.id("PolicyFile_Notes:Policy_NotesScreen:NoteSearchDV:TextSearch-inputEl"));
		//hm.put("elePolicyNotesSearch", By.id("PolicyFile_Notes:Policy_NotesScreen:NoteSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("edtPolicySearchText", By.xpath(".//*[contains(@id,'Policy_NotesScreen:NoteSearchDV:TextSearch-inputEl')]"));
		//hm.put("funPolicyNotesVerify1", By.id("x-form-el-PolicyFile_Notes:Policy_NotesScreen:NotesLV:0:NoteRowSet:Body"));
		hm.put("elePolicyNotePage", By.id("PolicyFile_Notes:Policy_NotesScreen:ttlBar"));

		// Create Policy Notes
		hm.put("elePolicyAction", By.id("PolicyFile:PolicyFileMenuActions-btnInnerEl"));
		hm.put("elePolicyNewNote", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_Create:PolicyFileMenuActions_NewNote-textEl"));
		hm.put("elePolicyCreateNote", By.id("SubmissionWizard:WizardMenuActions:WizardMenuActions_Create:WizardMenuActions_NewNote-textEl"));
		hm.put("lstPolicyNotesTopic", By.id("NewNoteWorksheet:NewNoteScreen:NewNoteDV:Topic-inputEl"));
		hm.put("edtPolicyNotesSubjectText", By.id("NewNoteWorksheet:NewNoteScreen:NewNoteDV:Subject-inputEl"));
		hm.put("lstPolicyNotesRelatedTo", By.id("NewNoteWorksheet:NewNoteScreen:NewNoteDV:RelatedTo-inputEl"));
		hm.put("edtPolicyNotesText", By.id("NewNoteWorksheet:NewNoteScreen:NewNoteDV:Text-inputEl"));
		hm.put("elePolicyNotesCreateUpdate", By.id("NewNoteWorksheet:NewNoteScreen:NewNoteScreen_UpdateButton-btnInnerEl"));
		hm.put("sclPolicyNotesCreateUpdate", By.id("NewNoteWorksheet:NewNoteScreen:NewNoteScreen_UpdateButton-btnInnerEl"));

		// Policy Note Delete
		// hm.put("elePolicyNoteDelete",
		// By.id("PolicyFile_Notes:Policy_NotesScreen:NotesLV:0:NoteRowSet:NotesLV_DeleteLink"));
		hm.put("elePolicyNoteDelete", By.xpath(".//*[contains(@id,'Policy_NotesScreen:NotesLV:0:NoteRowSet:NotesLV_DeleteLink')]"));
		hm.put("eleDeletePolicyNoteOK", By.id("button-1005-btnWrap"));

		// Policy Note Edit
		// hm.put("elePolNoteEdit",
		// By.id("PolicyFile_Notes:Policy_NotesScreen:NotesLV:0:NoteRowSet:NotesLV_EditLink"));
		hm.put("elePolNoteEdit", By.xpath(".//*[contains(@id,'Policy_NotesScreen:NotesLV:0:NoteRowSet:NotesLV_EditLink')]"));
		hm.put("edtPolNoteUpdateSubject", By.id("EditNotePopup:EditNoteScreen:EditNoteDV:Subject-inputEl"));
		hm.put("edtPolNoteUpdateText", By.id("EditNotePopup:EditNoteScreen:EditNoteDV:Text-inputEl"));
		hm.put("elePolNoteUpdateNote", By.id("EditNotePopup:EditNoteScreen:Update-btnInnerEl"));

		// Create Bulk Activity

		hm.put("eleBulkActivity", By.id("Desktop:DesktopMenuActions:DesktopMenuActions_Create:DesktopMenuActions_CreateBulkActivties-textEl"));
		hm.put("edtPoliciesForBulkAct", By.id("CreateBulkActivity_Ext:policies-inputEl"));
		hm.put("eleBulkActivityErrorMsg", By.xpath("//div[contains(@class, 'message')]"));
		hm.put("eleCreateBulkActivity", By.id("CreateBulkActivity_Ext:Update-btnInnerEl"));

		// Activity Pattern
		hm.put("eleBusinessSettings", By.id("TabBar:AdminTab:Admin_BusinessSettings-textEl"));
		hm.put("eleActivityPatterns", By.id("TabBar:AdminTab:Admin_BusinessSettings:BusinessSettings_ActivityPatterns-textEl"));
		hm.put("eleNewActivityPattern", By.id("ActivityPatterns:ActivityPatternsScreen:ActivityPatterns_NewActivityPatternButton-btnInnerEl"));
		hm.put("edtSubject", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Subject-inputEl"));
		hm.put("edtCode", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Code-inputEl"));

		hm.put("lstPatternLevel", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:PatternLevel-inputEl"));
		hm.put("eleBSAdd", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV_tb:Add-btnInnerEl"));
		hm.put("eleBSAdd", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV_tb:Add-btnInnerEl"));
		hm.put("eleNewBSAdd", By.id("NewActivityPattern:ActivityPatternDetailScreen:skillAndTrackLV_tb:Add-btnInnerEl"));
		hm.put("bliEditGrouping", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:BusinessGroupingLV_tb:AddGrouping-btnInnerEl"));
		hm.put("eleSelectBG", By.xpath("//div[contains(@id,'ActivityPatternDetailScreen:BusinessGroupingLV-body')]/div/table/tbody/tr/td/div/img"));
		hm.put("eleRemoveBG", By.id("NewActivityPattern:ActivityPatternDetailScreen:BusinessGroupingLV_tb:RemoveGroup-btnInnerEl"));
		hm.put("eleEditRemoveBG", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:BusinessGroupingLV_tb:RemoveGroup-btnInnerEl"));

		hm.put("eleActivityPatterns", By.id("ActivityPatterns:ActivityPatternsScreen:ttlBar"));
		hm.put("eleNewAddBG", By.id("NewActivityPattern:ActivityPatternDetailScreen:BusinessGroupingLV_tb:AddGrouping-btnInnerEl"));

		hm.put("eleAutomatedOnly", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:AutomatedOnly-labelEl"));
		hm.put("eleMandatory", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Mandatory-labelEl"));
		hm.put("eleRecurring", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Recurring-labelEl"));
		hm.put("eleActivityClass", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:ActivityClass-inputEl"));

		// hm.put("eleBSTable",
		// By.id("NewActivityPattern:ActivityPatternDetailScreen:skillAndTrackLV-body"));
		// hm.put("eleBSTable",
		// By.id("ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV-body"));
		hm.put("eleBSTable", By.xpath(".//*[contains(@id, 'ActivityPatternDetailScreen:skillAndTrackLV-body')]"));
		hm.put("eleOverrideRating", By.xpath(".//span[contains(text(),'Override') and contains(text(),'Rating')]"));

		hm.put("lstBusinessSegement", By.name("businessSegment_Ext"));
		hm.put("lstSkill", By.name("skill_Ext"));
		hm.put("lstTrack", By.name("track_Ext"));
		hm.put("eleUpdateAP", By.id("NewActivityPattern:ActivityPatternDetailScreen:Update-btnInnerEl"));
		hm.put("eleCancelAP", By.id("NewActivityPattern:ActivityPatternDetailScreen:Cancel-btnInnerEl"));
		hm.put("eleLastPageArrow", By.xpath("//span[contains(@class,'x-btn-icon-el x-tbar-page-last')]"));
		hm.put("eljLastPageArrow", By.xpath(".//*[@id='ActivityPatterns:ActivityPatternsScreen:ActivityPatternsLV']/div[1]/div/div/a[6]"));
		hm.put("eleNextPageArrow", By.xpath("//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]"));
		hm.put("elePreviousLastArrow", By.xpath("//span[contains(@class,'x-btn-icon-el x-tbar-page-first')]"));
		hm.put("eleNewActivityPatternListTable", By.xpath(".//*[@id='ActivityPatterns:ActivityPatternsScreen:ActivityPatternsLV-body']/div/table/tbody"));
		// hm.put("eleActivityPatternTable",
		// By.id("ActivityPatterns:ActivityPatternsScreen:ActivityPatternsLV-body"));
		hm.put("eleActivityPatternPageCount", By.xpath("//*[contains(@id,'ActivityPatterns:ActivityPatternsScreen:ActivityPatternsLV')]//div[contains(text(),'of')]"));
		hm.put("eleUpToActivityPattern", By.id("NewActivityPattern:NewActivityPattern_UpLink"));
		hm.put("eljDeleteAP", By.id("ActivityPatterns:ActivityPatternsScreen:ActivityPatterns_DeleteButton"));
		hm.put("eleDeleteAP", By.cssSelector("a[id='ActivityPatterns:ActivityPatternsScreen:ActivityPatterns_DeleteButton'][class='x-btn x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleEditAP", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:Edit-btnInnerEl"));
		hm.put("edtEditSubject", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Subject-inputEl"));
		hm.put("eleEditUpdateAP", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:Update-btnInnerEl"));
		hm.put("eleEditUptoLink", By.id("ActivityPatternDetail:ActivityPatternDetail_UpLink"));
		hm.put("eleEditCancelAP", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:Cancel-btnInnerEl"));
		hm.put("txtSubjectMandatoryWarningMessage", By.xpath(".//*[@id='NewActivityPattern:ActivityPatternDetailScreen:_msgs']/div[1]"));
		hm.put("txtCodeMandatoryWarningMessage", By.xpath(".//*[@id='NewActivityPattern:ActivityPatternDetailScreen:_msgs']/div[2]"));
		hm.put("txtPatternLevelMandatoryWarningMessage", By.xpath(".//*[@id='NewActivityPattern:ActivityPatternDetailScreen:_msgs']/div[3]"));
		hm.put("eleRecurringYes", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Recurring_true-inputEl"));
		hm.put("lstPriority", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Priority-inputEl"));
		hm.put("lstCategory", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Category-inputEl"));
		hm.put("txtRecurring", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Recurring-inputEl"));
		hm.put("txtPriority", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Priority-inputEl"));
		hm.put("txtCategory", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Category-inputEl"));
		hm.put("txtType", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Type-inputEl"));
		hm.put("txtBusinessSegment", By.xpath(".//*[@id='ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV-body']/div/table/tbody/tr[1]/td[2]"));
		hm.put("txtSkillLevel", By.xpath(".//*[@id='ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV-body']/div/table/tbody/tr[1]/td[3]"));
		hm.put("txtTrack", By.xpath(".//*[@id='ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV-body']/div/table/tbody/tr[1]/td[4]"));
		hm.put("lstBusinessGrouping", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:ApplicableSegment_Ext-inputEl"));
		hm.put("txtBusinessGrouping", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:ApplicableSegment_Ext-inputEl"));
		hm.put("eleSelectBS", By.xpath("//img[@class='x-grid-checkcolumn']"));

		hm.put("eleRemoveBS", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV_tb:Remove-btnInnerEl"));

		hm.put("eleBSTableExist", By.xpath(".//*[@id='ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV-body']/div/table/tbody/tr[1]"));
		hm.put("edtAP_Description", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:Description-inputEl"));
		hm.put("edtAP_EscalationDays", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationDays-inputEl"));
		hm.put("edtAP_TargetDays", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetDays-inputEl"));
		hm.put("lstAP_escalationStartpt", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationStartPt-inputEl"));
		hm.put("lstAP_TargetStartpt", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetStartPoint-inputEl"));
		hm.put("lstAP_EsacalationIncDays", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationInclDays-inputEl"));
		hm.put("lstAP_TargetIncDays", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetIncludeDays-inputEl"));
		hm.put("edtAP_EscalationHours", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationHours-inputEl"));
		hm.put("edtAP_TargetHours", By.id("NewActivityPattern:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetHours-inputEl"));

		// CLA PolicyInfo
		hm.put("eleCLAPIName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:Name-inputEl"));
		// hm.put("lstCLAPolicySymbol",By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicySymbol-inputEl"));
		hm.put("eleUploadToQueue", By.id("PSPolicyTerm_Ext_Info:UploadToQuote-btnEl"));
		hm.put("eljUploadToQueue", By.id("PSPolicyTerm_Ext_Info:UploadToQuote-btnEl"));
		hm.put("lstCLAPolicySymbol", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicySymbol-inputEl"));
		hm.put("eleCLAPolicyInfo_Update", By.id("PSPolicyTerm_Ext_Info:update-btnInnerEl"));
		hm.put("eleCLAPolicyInfo_Edit", By.id("PSPolicyTerm_Ext_Info:ToolbarButton-btnInnerEl"));
		// hm.put("eleCLASaveDraft",
		// By.id("PSPolicyTerm_Ext_Info:ToolbarButton-btnInnerEl"));
		hm.put("eleCLASaveDraft", By.id("PSPolicyTerm_Ext_Info:ToolbarButton-btnEl"));
		hm.put("eleCLAUploadToQuote", By.id("PSPolicyTerm_Ext_Info:UploadToQuote-btnInnerEl"));
		hm.put("eleProfessionalLiablity", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProfLiabInd_true-inputEl"));
		hm.put("eleCLABindOption", By.id("PSPolicyTerm_Ext_Info:BindOptions-btnWrap"));
		hm.put("bliCLABindOption", By.id("PSPolicyTerm_Ext_Info:BindOptions-btnWrap"));
		hm.put("eleCLADraftBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:Draft-itemEl"));
		hm.put("eljCLADraftBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:Draft-itemEl"));
		hm.put("eleCLAQuotedBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:Quoted-itemEl"));
		hm.put("eleCLAQuotePresentedBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:QuotePresented-itemEl"));
		hm.put("eleCLAQuoteSuccessfulBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:QuoteSuccessful-itemEl"));
		hm.put("eljCLAQuoteSuccessfulBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:QuoteSuccessful-itemEl"));
		hm.put("eleCLAIssuePolicyBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:IssuePolicy-itemEl"));
		hm.put("eljCLAIssuePolicyBO", By.id("PSPolicyTerm_Ext_Info:BindOptions:IssuePolicy-itemEl"));
		hm.put("eleCLAIsPolicyManualYes", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyManual_true-inputEl"));
		hm.put("eleCLAIsPolicyManualNo", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyManual_false-inputEl"));
		hm.put("eleCLAtblLineOfBusiness", By.xpath("//*[@id='PSPolicyTerm_Ext_Info:LineOfBusinessLV-body']/div[1]/table/tbody"));
		hm.put("eleCLAAlertOk", By.id("button-1005-btnInnerEl"));
		hm.put("eljCLAAlertOk", By.id("button-1005-btnInnerEl"));
		hm.put("eleCLATitlePolicyInfo", By.id("PSPolicyTerm_Ext_Info:ttlBar"));
		hm.put("eleCLAPISaveDraft", By.xpath(".//span[contains(@id, 'SaveDraftButton-btnInnerEl')]"));
		hm.put("eleCLAManualYES", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyManual_true-inputEl"));
		hm.put("eleCLAAccountNumberExist", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGAccountName-btnInnerEl"));
		hm.put("eleCLAPolicyNumber", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPSPolicy-btnInnerEl"));
		hm.put("eleCLAReservePolicyNumber", By.id("PSPolicyTerm_Ext_Info:ReservePolicyNumber-btnInnerEl"));
		hm.put("eljCLAReservePolicyNumber", By.id("PSPolicyTerm_Ext_Info:ReservePolicyNumber-btnInnerEl"));
		// hm.put("edtCLAReservePolicyNumber",
		// By.id("PSPolicyTerm_Ext_Info:ReservePolicyNumber-btnInnerEl"));
		hm.put("eleCLAPIErrorMsgs", By.id("PSPolicyTerm_Ext_Info:_msgs"));
		hm.put("lstCLAPIOrganizationType", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:OrgType-inputEl"));
		hm.put("edtCLAProducerCode", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext-inputEl"));
		hm.put("eleProducerCodeSearchImg", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext:SelectProducerCode_Ext"));
		hm.put("eleCLACloseOption", By.id("PSPolicyTerm_Ext_Info:CloseOptions-btnInnerEl"));
		hm.put("eleCLACloseOptionWithDraw", By.id("PSPolicyTerm_Ext_Info:CloseOptions:WithdrawJob-textEl"));
		hm.put("eleCLACloseOptionDecline", By.id("PSPolicyTerm_Ext_Info:CloseOptions:Decline-textEl"));
		hm.put("eleCLACloseOptionNotTaken", By.id("PSPolicyTerm_Ext_Info:CloseOptions:NotTakenJob-textEl"));
		hm.put("lstCLANotTakenReason", By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:RejectReason-inputEl"));
		hm.put("edtCLANotTakenReasonTxt", By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:RejectReasonText-inputEl"));
		hm.put("eleCLANotTakenUpdateBtn", By.id("PSNotTakenReasonExtPopup:RejectScreen:Update-btnInnerEl"));
		hm.put("eleCLANotTakenCancelBtn", By.id("PSNotTakenReasonExtPopup:RejectScreen:Cancel-btnInnerEl"));
		hm.put("eleCLANotTakenTitle", By.id("PSNotTakenReasonExtPopup:RejectScreen:ttlBar"));
		hm.put("eleCLANotTakenReturnToPolicyInfo", By.id("PSNotTakenReasonExtPopup:__crumb__"));
		hm.put("eleCLAIsPolicyCanadianYes", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyCanadian_true-inputEl"));
		hm.put("eleCLAIsPolicyCanadianNo", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyCanadian_false-inputEl"));
		hm.put("eleCLAPolicyInfoQuickLaunch", By.xpath("//td[contains(@id,'LOBWizardStepGroup:PolicyInfo')]/div"));
		// R3 -- hm.put("eleCLAPolicyInfoQuickLaunch",
		// By.xpath(".//span[contains(text(), 'Policy Info')]"));
		hm.put("eleAccountSummaryPTCreationDate", By.id("gridcolumn-1931-triggerEl"));
		hm.put("eleAccountSummarySortDesc", By.xpath(".//span[contains(text(), 'Sort Descending')]"));
		hm.put("eleCLAPolicyStatus", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl"));
		hm.put("eleCLAAccountNumber", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGAccountNumber-btnInnerEl"));
		hm.put("eleBillingCompanySearchIcon", By.xpath("//*[contains(@id,'SelectAMPBillingCompany')]"));
		hm.put("edtBillingCompanyName", By.xpath("//*[contains(@id,'searchBillingCompany-inputEl')]"));
		hm.put("eleCLAIndustryCodeIcon", By.xpath("//*[contains(@id,'SICIndustryCode:SelectIndustryCode')]"));
		hm.put("eleReservePolicyNumberAssert", By.xpath(".//*[@id='PSPolicyTerm_Ext_Info:_msgs']/div[contains(text(),'An order has been sent to Reserve a Policy Number')]"));
		hm.put("eleUploadToQuoteAssert", By.xpath(".//*[@id='PSPolicyTerm_Ext_Info:_msgs']/div[contains(text(),'The policy has been sent for upload.')]"));
		hm.put("edtCLAIndustryCode", By.xpath("//*[contains(@id,'IndustryCodeSearchDV:Code-inputEl')]"));
		hm.put("eleCLAAnnualTermUnEdit", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:TermType-inputEl'][class='x-form-display-field']"));
		hm.put("eljCLAPI", By.xpath(".//span[contains(text(),'Policy Info')]"));
		hm.put("eleCLAManualNO", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyManual_false-inputEl"));
		hm.put("lstCLAQuotePolnum", By.name("policyNum"));
		// hm.put("eleCLANotTakenPolStatusAssert",
		// By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Not-taken')]"));
		hm.put("eleCLANotTakenPolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl']//span[contains(text(), 'Submission(Not-taken)')]"));
		hm.put("eleCLACancelPolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Canceled')]"));
		hm.put("eleCLAExpiredPolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Expired')]"));
		// hm.put("eleCLAWithDrawnPolStatusAssert",
		// By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Withdrawn')]"));
		hm.put("eleCLAWithDrawnPolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl']//span[contains(text(), 'Submission(Withdrawn)')]"));
		hm.put("eleCLARenewalDraftStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl']//span[contains(text(), 'Renewal(Draft)')]"));
		hm.put("eleCLARenewalWithDrawnStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl']//span[contains(text(), 'Renewal(Withdrawn)')]"));
		// hm.put("eleCLADeclinePolStatusAssert",
		// By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Decline')]"));
		hm.put("eleCLADeclinePolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl']//span[contains(text(), 'Submission(Declined)')]"));
		hm.put("eleCLAQuotePolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Quoted')]"));
		hm.put("eleCLADraftPolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'Draft')]"));
		hm.put("eleCLAIssuePolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']//span[contains(text(),'In Force')]"));
		hm.put("eleCLAQuotePolTypeAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyLabel-btnInnerEl']//span[contains(text(),'CLA Policy')]"));
		hm.put("eleCLAManualPolTypeAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyLabel-btnInnerEl']//span[contains(text(),'Manual Policy')]"));
		hm.put("lstCLABusinessGrouping", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusinessGrouping-inputEl"));
		hm.put("lstCLASegment", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusSegmentID-inputEl"));
		hm.put("eleTransactionStatus", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl"));
		hm.put("eleCLABORStartDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BORStart-inputEl"));
		hm.put("eleCLABOREndDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BORControlEnd-inputEl"));
		hm.put("elePolEffecDate", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGEffectiveDateID-inputEl'][class='x-form-display-field']"));
		hm.put("lstCommunicationType", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PSAMPPoliciesOnlyInputSet:CommunicationType-inputEl"));
		hm.put("edtCLAEffDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGEffectiveDateID-inputEl"));
		hm.put("lstCLAEffDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGEffectiveDateID-inputEl"));
		hm.put("edtCLAExpDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGExpirationDateID-inputEl"));
		hm.put("lstCLAExpDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGExpirationDateID-inputEl"));
		hm.put("elePolBusinessGrouping", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusinessGrouping-inputEl"));
		hm.put("elePolPolicyNumber", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicyNumber-inputEl"));
		hm.put("elePolExpDate", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGExpirationDateID-inputEl'][class='x-form-display-field']"));
		hm.put("elePolSIC", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:SICIndustryCode-inputEl'][class='x-form-display-field']"));
		hm.put("elePolMSI", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl'][class='x-form-display-field']"));
		hm.put("elePolBusinessSeg", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusSegmentID-inputEl'][class='x-form-display-field']"));
		hm.put("elePolProducer", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext-inputEl'][class='x-form-display-field']"));
		hm.put("eleBORStartDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BORStart-inputEl"));
		hm.put("eleBOREndDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BORControlEnd-inputEl"));
		hm.put("eleBORReceivedDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProfLiabAppDate-inputEl"));
		hm.put("clrCLAEffDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGEffectiveDateID-inputEl"));
		hm.put("clrCLAExpDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGExpirationDateID-inputEl"));
		hm.put("clrPolPolicyNumber", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicyNumber-inputEl"));
		hm.put("clrPolSIC", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:SICIndustryCode-inputEl'][class='x-form-display-field']"));
		hm.put("crlPolMSI", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl'][class='x-form-display-field']"));
		hm.put("clrPolBusinessSeg", By.cssSelector("div[id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusSegmentID-inputEl'][class='x-form-display-field']"));
		hm.put("eleProducerCodeXMark", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext_CLEAR"));
		hm.put("lstPolBusinessGrouping", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:RenewalReviewType-inputEl"));
		hm.put("eleQuoteSuc", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:QuoteSuccessful-inputEl"));
		hm.put("eleQuotePre", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:QuotePresented-inputEl"));
		hm.put("eleQuoteDateLabel", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:DateQuotePresented-labelEl"));
		// hm.put("eleQuoteDate",
		// By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:DateQuotePresented-inputEl"));
		hm.put("eleQuoteDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:DateQuotePresented-bodyEl"));
		hm.put("elePolProducerCode", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext"));
		hm.put("eleCLAPIEffDate", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGEffDate-btnInnerEl"));
		hm.put("eleSICSearch", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:SICIndustryCode:SelectIndustryCode"));
		hm.put("clrSIC", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:SICIndustryCode-inputEl"));
		hm.put("edtCLAMSI", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl"));
		hm.put("clrMSI", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl"));
		hm.put("clrPolNum", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicyNumberComplete-inputEl"));
		hm.put("edtExpiringPremium", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ExpiringPremium-inputEl"));
		hm.put("eleExpiringPremium", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ExpiringPremium-inputEl"));
		hm.put("lstRenewalType", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:RenewalReviewType-inputEl"));
		hm.put("eleRenewalType", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:RenewalReviewType-inputEl"));
		hm.put("lblPreviousPolNo", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PreviousPolicyNumber-labelCell"));
		// hm.put("EdtPreviousPolNo",
		// By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PreviousPolicyNumber-inputEl"));
		hm.put("edtPreviousPolNo", By.xpath("//*[contains(@id,'PreviousPolicyNumber-inputEl')]"));
		// hm.put("edtOtherPolicyNo",By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSCanadianPoliciesOnlyInputSet:OtherPolicyNumber-inputEl"));
		hm.put("edtOtherPolicyNo", By.xpath("//*[contains(@id,':OtherPolicyNumber-inputEl')and @role='textbox']"));
		hm.put("edtExchangeRate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSCanadianPoliciesOnlyInputSet:ExchangeRate-inputEl"));
		hm.put("eleOtherPolicyNo", By.xpath("//*[contains(@id,':OtherPolicyNumber-inputEl')and @role='textbox']"));
		hm.put("eleExchangeRate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSCanadianPoliciesOnlyInputSet:ExchangeRate-inputEl"));
		hm.put("elePI_ExchangeRate", By.xpath("//td//label[contains(text(), 'Exchange Rate')]//ancestor::td[1]//following-sibling::td[1]//div"));
		hm.put("elePI_OtherPolicyNO", By.xpath("//td//label[contains(text(), 'Other Policy')]//ancestor::td[1]//following-sibling::td[1]//div"));
		hm.put("elePI_TotalCostCandaian", By.xpath("//td//label[contains(text(), 'Total Cost Canadian')]//ancestor::td[1]//following-sibling::td[1]//div"));
		hm.put("elePI_MailDate", By.xpath("//td//label[contains(text(), 'Mail Date')]//ancestor::td[1]//following-sibling::td[1]//div"));
		hm.put("elePI_TotalCost", By.xpath("//td//label[text()='Total Cost']//ancestor::td[1]//following-sibling::td[1]//div"));
		hm.put("edtTotalCanadianCost", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSCanadianPoliciesOnlyInputSet:TotalCostCanadian-inputEl"));
		hm.put("edtTotalCost", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSManualAndCanadianPoliciesInputSet:TotalCost-inputEl"));
		hm.put("edtMailDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSManualAndCanadianPoliciesInputSet:MailDate-inputEl"));
		hm.put("eleTotalCanadianCost", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSCanadianPoliciesOnlyInputSet:TotalCostCanadian-inputEl"));
		hm.put("eleTotalCost", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSManualAndCanadianPoliciesInputSet:TotalCost-inputEl"));
		hm.put("eleMailDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSManualAndCanadianPoliciesInputSet:MailDate-inputEl"));
		hm.put("eleTodayDtepickerBtn", By.xpath("//div[@class='x-datepicker-footer']//span[text()='Today']"));
		hm.put("eleMailDateDtepicker", By.xpath("//td[@id='PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSManualAndCanadianPoliciesInputSet:MailDate-inputCell']/following-sibling::td"));
		hm.put("eleDatepickrControl", By.xpath("//div[contains(@id,'datepicker') and @role='grid']"));
		hm.put("eleCLAIsPolicyCanadianYes", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:IsPolicyCanadian_true-inputEl"));
		// hm.put("elePursueNextYearYes",
		// By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:PursueNextYear_true-inputEl"));
		hm.put("elePursueNextYearYes", By.xpath("//*[contains(@id,'PursueNextYear_true-inputEl')]"));
		// hm.put("lstCLASuccessfulCarrier",
		// By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:SuccessfulCarrier-inputEl"));
		hm.put("lstCLASuccessfulCarrier", By.xpath("//*[contains(@id,'SuccessfulCarrier-inputEl')]"));
		// hm.put("edtCLASuccessfulPremium",
		// By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:SuccessfulPremium-inputEl"));
		hm.put("edtCLASuccessfulPremium", By.xpath("//*[contains(@id,'SuccessfulPremium-inputEl')]"));
		hm.put("lstCLADeclineReason", By.id("PSDeclineReasonExtPopup:RejectScreen:PSRejectReasonExtDV:RejectReason-inputEl"));
		hm.put("edtCLADeclineReasonTxt", By.id("PSDeclineReasonExtPopup:RejectScreen:PSRejectReasonExtDV:RejectReasonText-inputEl"));
		hm.put("eleCLADeclineUpdateBtn", By.id("PSDeclineReasonExtPopup:RejectScreen:Update-btnInnerEl"));
		hm.put("eleCLADeclineTitle", By.id("PSDeclineReasonExtPopup:RejectScreen:ttlBar"));
		hm.put("eleCLADeclineReturnToPolicyInfo", By.id("PSDeclineReasonExtPopup:__crumb__"));
		// hm.put("edtOtherPolicyNo",By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ManualAndAMPInputs:PSCanadianPoliciesOnlyInputSet:OtherPolicyNumber-inputEl"));
		hm.put("elePursueNextYearNo", By.xpath("//*[contains(@id,'PursueNextYear_false-inputEl')]"));
		hm.put("eleCLABoundPolStatusAssert", By.xpath(".//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGJobTypeStatus-btnInnerEl']//span[contains(text(), 'Renewal(Bound)')]"));
		hm.put("eleExposureState", By.id("PSExposureStatesPopup:ExposureStates-containerEl"));
		hm.put("eleExposureStateList", By.id("PSExposureStatesPopup:ExposureStates-targetEl"));
		hm.put("eljPolicyInfo_Quote", By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:RenewalQuote-btnInnerEl"));
		hm.put("eljPolicyInfo_RenewalCheck", By.xpath("//span[contains(text(),'Workflow (Wait Timeout/Manual)')]"));
		hm.put("eljRenewalQuote", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:RenewalQuote-btnEl')]"));
		// hm.put("eljRenewalQuote",
		// By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_DifferencesScreen:JobWizardToolbarButtonSet:ApplyRenewalChange_Ext-btnInnerEl"));

		hm.put("eleTransPendCount_0", By.xpath("//div[text()='0']"));
		hm.put("eleTransPendCount_1", By.xpath("//div[text()='0']"));
		hm.put("eleGrpPol_1stItem", By.xpath("//div[starts-with(text(),'PG00')]"));
		hm.put("eleGrpPol_2ndItem", By.xpath("//div[starts-with(text(),'PG00')]/following-sibling::li"));
		hm.put("eleGrpPolItems_1stOption", By.xpath("//li[starts-with(text(),'PG00')]"));
		hm.put("eleGrpPolItems_2ndOption", By.xpath("//li[starts-with(text(),'PG00')]/following-sibling::li"));
		hm.put("lstGrpPol", By.xpath("//input[starts-with(@id,'simplecombo')]"));
		hm.put("eleRenewViewQuote", By.xpath("//span[contains(text(),'View Quote')]"));
		hm.put("btnPayment", By.id("PSPolicyTerm_Ext_Info:PaymentButton-btnInnerEl"));
		hm.put("elePolicyInfo_SICCode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:IndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_MSICode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:MSIExt-inputEl')]"));
		hm.put("elePolicyInfo_YearBusinessstarted", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:YearBusinessStarted-inputEl')]"));
		hm.put("eleRenewalPI_Updatebtn", By.id("PSPolicyTerm_Ext_Info:update-btnEl"));
		// Line of Business Table
		hm.put("elePolInfoLOBAdd", By.xpath(".//span[contains(@id, 'LineOfBusinessLV_tb:Add-btnInnerEl')]"));
		hm.put("elePolInfoLOBColumnSearch", By.xpath(".//*[contains(@id,':LineOfBusinessLV')]/div[1]/div/div"));
		hm.put("elePolInfoLOBColumnSearch_QA2", By.xpath(".//*[contains(@id,':LineOfBusinessLV')]/div[3]/div/div"));
		hm.put("lstLine Of BusinessTBD", By.name("LineofBusiness"));
		hm.put("lstLevel of SupportTBD", By.name("LevelofSupport"));
		hm.put("eleExposure StatesTBA", By.name("ExposureStates"));
		hm.put("edtTotal CostTBD", By.name("TotalCost"));
		hm.put("elePolInfoLOB", By.id("PSPolicyTerm_Ext_Info:2"));
		hm.put("edtNumber of Motorized VehiclesTBD", By.name("NumberofMotorizedVehicles"));
		hm.put("eleQuoteBtn", By.xpath("//span[contains(@id,'JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl')]"));

		// CLA Risk Analysis
		hm.put("eleCLARiskAnalysis", By.id("HIGPolicyFile:HIGPolicyFileAcceleratedMenuActions:HIGJobAcceleratedMenuItemSet:PSPolicyMenuItemSet_RiskAnalysis"));
		hm.put("eleCLARiskAnalysis_UWInfo", By.id("HIGPolicyFile_RiskAnalysis_Ext:uwInfoTab-btnInnerEl"));
		hm.put("eleCLARiskAnalysis_UWReferralReason", By.id("HIGPolicyFile_RiskAnalysis_Ext:uwReferralReasonTab-btnInnerEl"));

		// ProducerCode Page
		hm.put("edtProducerCodePagePC", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Code-inputEl"));
		hm.put("edtProducerCodePageAgencyName", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Description-inputEl"));
		hm.put("eleProducerCodePageSearchBtn", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleProducerCodePageSelectBtn", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchLV:0:_Select"));
		hm.put("bliCLACloseOption", By.id("PSPolicyTerm_Ext_Info:CloseOptions-btnInnerEl"));

		// CLA Quote Transactions
		hm.put("eleQuoteTransaction", By.xpath(".//*[@id='HIGPolicyFile:HIGPolicyFileAcceleratedMenuActions:HIGJobAcceleratedMenuItemSet:PSPolicyMenuItemSet_Quote']/div"));
		hm.put("eljCLAQT", By.xpath(".//span[contains(text(),'Quote Transactions')]"));
		hm.put("eleCLAQT", By.xpath(".//span[contains(text(),'Quote Transactions')]"));
		hm.put("eleCLAQTTitle", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:ttlBar"));
		hm.put("eleCLAQTSaveDraft", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:ToolbarButton"));
		hm.put("eljCLAQTSaveDraft", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:ToolbarButton"));
		// hm.put("eleCLAQTRemove",By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:Remove"));
		hm.put("eleCLAQTRemove", By.cssSelector("a[id='HIGPolicyFile_Quotes:PSJob_QuotesScreen:Remove'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCLAQTRemoveDisable", By.cssSelector("a[id='HIGPolicyFile_Quotes:PSJob_QuotesScreen:Remove'][class='x-btn x-unselectable x-item-disabled x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-disabled x-btn-disabled x-btn-default-toolbar-small-disabled x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCLAQTAlertOk", By.id("button-1005-btnInnerEl"));
		hm.put("eleCLAQTAdd", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:Add-btnInnerEl"));
		hm.put("eljCLAQTAdd", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:Add-btnInnerEl"));
		hm.put("eleCLAQTTable", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:QuoteTransactionLV-body"));
		hm.put("dblCLAQT_Table_TotalCost", By.xpath("//div[@id='HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:QuoteTransactionLV-body']//tr[1]//td[7]/div"));
		hm.put("lstCLAQT_Table_TotalCost", By.xpath("//div[@id='HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:QuoteTransactionLV-body']//tr[1]//td[7]/div"));
		hm.put("edtCLAQT_Table_TotalCost", By.xpath("//div[@id='HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:QuoteTransactionLV-body']//tr[1]//td[7]/div"));
		hm.put("lstCLACompleteDate", By.name("CompleteDate"));
		hm.put("lstCLASystemAddress", By.name("SystemAddress"));
		hm.put("lstCLAQuoteSeq", By.name("quoteSequence"));
		hm.put("lstCLAQuoteDesc", By.name("quoteDesc"));
		hm.put("lstCLATotalPrem", By.name("totalPremium"));
		hm.put("lstCLAEffectiveDate", By.name("effDate"));
		hm.put("lstCLAExpirationDate", By.name("expDate"));
		hm.put("eleCLAQTADDQuoteDetails", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:quoteTrans:Add-btnInnerEl"));
		hm.put("eljCLAQTADDQuoteDetails", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:quoteTrans:Add-btnInnerEl"));
		hm.put("eleCLAQTQDTable", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:QuoteTransaction:lobIDLV-body"));
		hm.put("lstCLAQTQDLOB", By.name("lob"));
		hm.put("lstCLAQTQDTotalCost", By.name("totalPremium"));
		hm.put("lstCLAQTQDExposureState", By.name("expoState"));
		hm.put("lstCLAQTQDCompany", By.name("issCompany"));
		hm.put("lstCLAQTQDLevelOfSupport", By.name("levelOfSupport"));
		hm.put("eleCLAQTSaveDraft", By.id("HIGPolicyFile_Quotes:PSJob_QuotesScreen:ToolbarButton-btnInnerEl"));
		hm.put("lstTotalAnnualCost", By.name("totalPremium"));
		// CLA Quoted Form
		// hm.put("eleCLAQFQuoteForm",By.id("HIGPolicyFile:HIGPolicyFileAcceleratedMenuActions:PSPolicyMenuItemSet_Form"));
		hm.put("eleCLAQFQuoteForm", By.xpath(".//span[contains(text(), 'Quoted Forms')]"));
		hm.put("eleCLAQFTitle", By.id("HIGPolicyFile_Forms:PSPolicyFormsScreen:ttlBar"));
		hm.put("eleCLAQFQuote#", By.id("HIGPolicyFile_Forms:PSPolicyFormsScreen:PolicyShellQuoteNumber-inputEl"));

		// CLA AMP Billing
		// hm.put("eleCLAAMPBilling",By.id("HIGPolicyFile:HIGPolicyFileAcceleratedMenuActions:PSPolicyMenuItemSet_AMPBilling"));
		hm.put("eleCLAAMPBilling", By.xpath(".//span[contains(text(), 'AMP Billing')]"));
		hm.put("eleCLAAMPTitle", By.id("HIGPolicyFile_AMPBilling:ttlBar"));

		// CLA Payment
		hm.put("eleCLAPaymentTitle", By.id("HIGPolicyFile_Payment_Ext:ttlBar"));
		hm.put("eleCLAPayment", By.xpath(".//*[@id='HIGPolicyFile:HIGPolicyFileAcceleratedMenuActions:HIGJobAcceleratedMenuItemSet:PSPayment']/div/span"));
		hm.put("eljAlternatePayer", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:AlternatePayer-inputEl"));
		hm.put("lsjPayerCode", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:PayerCode-inputEl"));
		hm.put("edtPayerName1", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Name1-inputEl"));
		hm.put("edtPayerAddress1", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Address1-inputEl"));
		hm.put("edtPayerCity", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:City-inputEl"));
		hm.put("lstPayerState", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:State-inputEl"));
		hm.put("edtPayerZip", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Zip-inputEl"));

		/*
		 * hm.put("eljAlternatePayer",By.xpath(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:AlternatePayer-inputEl')]"
		 * )); hm.put("lsjPayerCode",By.id(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:PayerCode-inputEl')]"
		 * )); hm.put("lsjPayerCode",By.id(
		 * "PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:PayerCode-inputEl"
		 * )); hm.put("edtPayerName1",By.id(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Name1-inputEl')]"
		 * )); hm.put("edtPayerAddress1",By.id(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Address1-inputEl')]"
		 * )); hm.put("edtPayerCity",By.id(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:City-inputEl')]"
		 * )); hm.put("lstPayerState",By.id(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:State-inputEl')]"
		 * )); hm.put("edtPayerZip",By.id(
		 * "//*[contains(@id,'PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Zip-inputEl')]"
		 * ));
		 */

		hm.put("eleClAPaymentBindOptions", By.id("HIGPolicyFile_Payment_Ext:BindOptions-btnInnerEl"));
		hm.put("elePaymentIssuepolicy", By.id("HIGPolicyFile_Payment_Ext:BindOptions:IssuePolicy-textEl"));
		// hm.put("edtCLABillingNumber",
		// By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:enterBillingNumber-inputEl"));
		hm.put("edtCLABillingNumber", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:enterBillingNumber-inputEl"));

		hm.put("eleAlternatePayer", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:AlternatePayer-inputEl"));
		hm.put("lstPayercode", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:PayerCode-inputEl"));
		hm.put("edtPayerName", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Name1-inputEl"));
		hm.put("edtPayerAddress", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Address1-inputEl"));
		hm.put("edtpayerCity", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:City-inputEl"));
		// hm.put("lstPayerState",
		// By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:State-inputEl"));
		// hm.put("edtPayerZip",
		// By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Zip-inputEl"));
		hm.put("eleCLAPayment_NoteMsg", By.id("HIGPolicyFile_PaymenFt_Ext:saveForChanges"));
		hm.put("eleInstallPlan_Standard_Type", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:installmentplantypeindicator_true-inputEl"));
		hm.put("eleInstallPlan_Override_Type", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:installmentplantypeindicator_false-inputEl"));
		hm.put("eleBillingContact_Icon", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:ChangeBillingContactButton:ChangeBillingContactButtonMenuIcon"));
		hm.put("eleNewPerson_billingContact", By.xpath("//span[contains(@id,'psBillingAdjustment:PSBillingAdjustment_ExtDV:ChangeBillingContactButton') and text()='New Person']"));
		hm.put("eleNewCompany_billingContact", By.xpath("//span[contains(@id,'psBillingAdjustment:PSBillingAdjustment_ExtDV:ChangeBillingContactButton') and text()='New Company']"));
		hm.put("eleNewBillingContact_title", By.xpath("//span[@id='HIGNewPolicyFileContactPopup:ContactDetailScreen:ttlBar' and text()='New Billing Contact']"));
		hm.put("edtBilling_FName", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtBilling_LName", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleBillingContact_OK", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		hm.put("elePayrollProviderImg", By.xpath("//*[contains(@id,'payrollprovidernametrigger:Selectpayrollprovidernametrigger')]"));
		hm.put("elePayrollProviderTitle", By.id("PayrollProviderSummaryPopup:ttlBar"));
		hm.put("eleXactPayLaunchTitle", By.id("PSXactpayLaunch_ExtPopup:XactpayLaunchScreen:0"));
		hm.put("elePayrollProviderName", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:payrollInfo:payrollprovidernametrigger-labelEl"));
		hm.put("elePayrollPartnerId", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:payrollInfo:payrollpartnerid-labelEl"));
		hm.put("elePayrollPartnerName", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:payrollInfo:payrollpartnername-labelEl"));
		hm.put("eleBillingNumber", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:PSBillingnumber-labelEl"));
		hm.put("eleDirectBillAlternatePayer", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:AlternatePayer-labelEl"));
		// hm.put("eljPayrollProviderNameSearch",
		// By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:payrollInfo:payrollprovidernametrigger:Selectpayrollprovidernametrigger"));
		hm.put("eljPayrollProviderNameSearch", By.xpath(".//*[contains(@id,'Selectpayrollprovidernametrigger')]"));
		hm.put("elePayrollProviderSearch", By.id("PayrollProviderSummaryPopup:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("edtProviderName", By.id("PayrollProviderSummaryPopup:payrollProviderName-inputEl"));
		hm.put("elePayrollSearch", By.id("PayrollProviderSummaryPopup:ttlBar"));
		hm.put("eleBillingContact", By.xpath("//*[contains(@id,'ChangeBillingContactButtonMenuIcon')]"));
		hm.put("eleNewCompany", By.xpath(".//span[contains(text(), 'New Company')]"));
		hm.put("eleNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
		hm.put("eleExistingBillingContacts", By.xpath(".//span[contains(text(), 'Existing Billing Contacts')]"));
		hm.put("eleEditPayment", By.id("HIGPolicyFile_Payment_Ext:Edit-btnInnerEl"));
		hm.put("elePaymentNote", By.id("HIGPolicyFile_Payment_Ext:saveForChanges"));
		hm.put("lstBillingNewContact", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:ChangeBillingContactButton:ChangeBillingContactButtonMenuIcon-fieldMenu"));
		hm.put("edtNewCompanyName", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleNewBillingOK", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		hm.put("eleVerifyExistingContact", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:ChangeBillingContactButton:ExistingBillingContact:0:UnassignedAccountContact-textEl"));
		hm.put("elePayrollProviderNameSearchicon", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:payrollInfo:payrollprovidernametrigger:Selectpayrollprovidernametrigger"));
		hm.put("elePayment_BillingMethod", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:psBillingMethod-inputEl"));
		hm.put("elePayment_BillingNumber", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:PSBillingnumber-inputEl"));
		hm.put("elePaymentInstPlanErrMsg", By.xpath("//div[contains(text(), 'Installment Plan : Missing required field \"Installment Plan\"')]"));
		hm.put("elePaymentCommonErrMsg", By.xpath("//div[contains(text(), 'Please fill in all required fields.')]"));
		hm.put("eleInstallmentTypeRadioS", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:installmentplantypeindicator_true-boxLabelEl"));
		hm.put("eleInstallmentTypeRadioO", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:installmentplantypeindicator_false-boxLabelEl"));
		hm.put("edtPayerAddress2", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:AlternatePayerInputGroup:alternatePayerInfo:alternatePayerContactInfo:Address2-inputEl"));
		// R2 NEW
		hm.put("lstCLABillingMethod", By.xpath("//td//label[contains(text(),'Billing')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstCLABillingInstallmentPlan", By.xpath("//td//label[contains(text(),'Installment')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstCLABillingNumber", By.xpath("//td//label[contains(text(),'Number')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstCLAPayment_FinalAudit", By.xpath("//td//label[contains(text(),'Final')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleCLApayment_update", By.id("PSBillingAdjustment_ExtPopup:UpdateButton-btnInnerEl"));
		hm.put("edtCLAPayment_TotalPremimum", By.id("PSBillingAdjustment_ExtPopup:AMPPaymentInfoDV:TotalPremiums-inputEl"));
		hm.put("edtCLAPayment_GrossCommission", By.id("PSBillingAdjustment_ExtPopup:AMPPaymentInfoDV:GrossCommissionPercentage-inputEl"));
		hm.put("edtCLAPayment_RetailAgencyCommission", By.id("PSBillingAdjustment_ExtPopup:AMPPaymentInfoDV:RetailAgentCommPercentage-inputEl"));
		// QPB Policy Selection
		hm.put("eleQuotePropsalBuilder", By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_QPB_ExtWizard']/div/span"));
		hm.put("eleNextQPB", By.id("QPB_ExtWizard:Next-btnInnerEl"));
		hm.put("elePolicySelection", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:ttlBar"));
		hm.put("lstQuoteVersions", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:AvailabePolicesDV:0:polinputset:QuoteVersionNSOR-inputEl"));
		hm.put("lstQPBPSProposalType", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:TestProposalSelection-inputEl"));
		hm.put("eljQPBLOBCheck", By.xpath(".//*[contains(@id, 'product-inputEl')]"));
		hm.put("eleQPBPolicySelection", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:qpbpolicyselction']/div/span"));
		hm.put("eleAvailablePolciesLabel0", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:AvailabePolicesDV:0:product-labelEl"));
		hm.put("eleQPBPolicy0", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:AvailabePolicesDV:0:polinputset:PN-inputEl"));
		hm.put("eleAvailablePolciesLabel1", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:AvailabePolicesDV:1:product-labelEl"));
		hm.put("eleQPBPolicy1", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:QPBPolicySelection_ExtScreen:AvailabePolicesDV:1:polinputset:PN-inputEl"));
		hm.put("eleBackQPB", By.id("QPB_ExtWizard:Prev-btnInnerEl"));
		hm.put("eleQPB_Tab", By.id("AccountFile:MenuLinks:AccountFile_QuoteProposalBuilderFiles"));
		hm.put("eleLaunchTab", By.id("QuoteProposalBuilderFiles:QuoteProposalBuildersScreen:QPBFilesLV:0:LaunchQPB"));
		// QPB Document Options
		hm.put("lstQPBDOName", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:DocumentOptionsWizardStepSet:SCDocumentOptions_ExtScreen:DocDV:TORecipientNames_Ext-inputEl"));
		hm.put("lstQPBDODeliveryType", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:DocumentOptionsWizardStepSet:SCDocumentOptions_ExtScreen:DocDV:TORecipientDeliveryType_Ext-inputEl"));
		hm.put("eleQPBDOFinalize", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:DocumentOptionsWizardStepSet:SCDocumentOptions_ExtScreen:finalizeDocument-btnInnerEl"));
		hm.put("txtQPBDOAgentorInsured", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:DocumentOptionsWizardStepSet:SCDocumentOptions_ExtScreen:DocDV:agentorinsured-inputEl"));
		hm.put("txtQPBDOEmail", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:DocumentOptionsWizardStepSet:SCDocumentOptions_ExtScreen:DocDV:DeliveryPreferenceTO_Ext:TOEmail_Ext-inputEl"));
		hm.put("eleQPBDOUpToAccountFileSummary", By.id("QPB_ExtWizard:QPB_ExtWizard_UpLink"));
		hm.put("eleQPBDocumentOption", By.id("QPB_ExtWizard:QPB_ExtWizard_UpLink"));
		hm.put("eleQPBPDFFinalize", By.id("AccountFile_Documents:DocumentsScreen:DocumentsLV:0:Icon"));
		hm.put("elePolicyDocuments", By.xpath(".//*[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Documents']/div/span[text()='Documents']"));

		// QPB Contact Info
		hm.put("edtQPBContactName", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:UWName-inputEl"));
		hm.put("eleContactInfoAssert", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:ttlBar"));
		hm.put("eleSearchLookUpPU", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:prefillUW:SelectUser"));
		hm.put("edtUserNameQPB", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchDV:Username-inputEl"));
		hm.put("eleSearchQPB", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSelectQPB", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchResultsLV:0:_Select"));
		hm.put("eleSearchLookUpPAM", By.xpath("html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/a/img"));
		hm.put("edtAddressQPB", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:ActMgrAddress-inputEl"));
		hm.put("edtCityAPB", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:ActMgrAddressCity-inputEl"));
		hm.put("lstStateQPB", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:ActMgrAddressState-inputEl"));
		hm.put("edtZipCodeQPB", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:ActMgrAddressZip-inputEl"));
		hm.put("eleContactInformation", By.id("QPB_ExtWizard:qpbWizrdStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:ttlBar"));
		hm.put("edtQPBProducreCode", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:producerName-inputEl"));
		hm.put("lstQPBOffice", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:UWOffice-inputEl"));
		hm.put("edtQPB_Name", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:QBPUWAssistant_ExtDV:actMgrName-inputEl"));
		hm.put("eleQPB_CreateProposal", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:createProposal-btnInnerEl"));
		hm.put("eleProposalCompletedMsg", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:_msgs"));

		// QPB Commercial Auto
		hm.put("eleCommercialAuto", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:ttlBar'][contains(text(),'Commercial Auto')]"));
		hm.put("edtQPBCommission", By.xpath(".//*[contains(@id, 'commission-inputEl')]"));
		hm.put("eleQPBAdditionalCharges", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:0:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBGolfMobiles", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:1:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("edtQPBGolfMobilesPrem", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:2:QPBModalQuestion_ExtInputSet:IntegerFieldInput-inputEl"));
		hm.put("eleNoFaultPIP", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:4:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("edtNoFaultPIPCov", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:5:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("sclQPBAdditionalPIPSCL", By.xpath(".//label[contains(text(), 'Additional PIP')]"));
		hm.put("eleQPBAdditionalPIP", By.xpath(".//label[contains(text(), 'Additional PIP')]"));
		hm.put("edtQPBAdditionalPIPCov", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:7:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("sclQPBOther", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:8:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("eleQPBOther", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:8:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("edtQPBOtherCoverage1", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:9:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBOtherCoverage1Prem", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:10:QPBModalQuestion_ExtInputSet:IntegerFieldInput-inputEl"));
		hm.put("eleQPBOtherCoverage2", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:12:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBOtherCoverage2", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:12:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBOtherCoverage2Prem", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:13:QPBModalQuestion_ExtInputSet:IntegerFieldInput-inputEl"));
		hm.put("eleQPBOtherCoverage3", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:15:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBOtherCoverage3", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:15:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBOtherCoverage3Prem", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV:16:QPBModalQuestion_ExtInputSet:IntegerFieldInput-inputEl"));
		hm.put("eleQPBCoverageDetails", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageDetailsDV:0:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBCoverageDetails", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageDetailsDV:0:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("eleQPBDocDriverList", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBOptionsDV:0:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("edtQPBDocDriverListCov", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBOptionsDV:1:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("eleQPBBroadened", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBOptionsDV:2:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("edtQPBBroadenedCov", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBOptionsDV:3:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("eleQPBMinimum", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV:0:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBDriver", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV:1:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBAcceptable", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV:2:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBVehicleId", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV:3:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBCertificates", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV:4:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBPrior", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV:6:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBPrimaryHired", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageHighlightsDV:1:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBOptionalForms", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:0:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBHA99130187", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:1:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBHA99160312", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:4:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBCA99401293", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:8:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBCA99161013", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:9:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBCA20011013", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:10:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("eleQPBHA20070614", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV:15:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("lstQPBBroadForm", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV:0:QPBModalQuestion_ExtInputSet:choicea:choicea_Arg-inputEl"));
		hm.put("lstQPBAutoClaims", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV:1:QPBModalQuestion_ExtInputSet:choicea:choicea_Arg-inputEl"));
		hm.put("lstQPBReportingAutoClaims", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV:2:QPBModalQuestion_ExtInputSet:choicea:choicea_Arg-inputEl"));
		hm.put("lstQPBTop10Auto", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV:3:QPBModalQuestion_ExtInputSet:choicea:choicea_Arg-inputEl"));
		hm.put("eleQPBAdditionalComments", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV:9:QPBModalQuestion_ExtInputSet:checkbox-inputEl"));
		hm.put("edtQPBAdditionalComments", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV:10:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("eleQPBPageAssert", By.xpath(".//*[contains(@id, 'QPBLOBDetail_ExtScreen:ttlBar')]"));
		hm.put("eleQPBAutoLiabDeduct", By.xpath(".//*[contains(text(), 'Auto Liability Deductible Premium (Already included in Total Estimated Premium)')]"));
		hm.put("eleQPBGolfMobilesAssert", By.xpath(".//*[contains(text(), 'Golfmobiles Premium (Already included in Total Estimated Premium)')]"));
		hm.put("eleQPBGolfMobilesAssert", By.xpath(".//*[contains(text(), '<DOC Drivers List (if applicable)>')]"));
		hm.put("eleQPBCAOFAssert", By.xpath(".//*[contains(text(), 'HA99130187')]"));
		hm.put("eleQPBCAOtherAssert", By.xpath(".//*[contains(text(), '<Other>')]"));
		hm.put("eleQPBCAAdditionCommentsAssert", By.xpath(".//*[contains(text(), '<Additional Comments>')]"));
		hm.put("eleQPBADSOther", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV']//label[contains(text(),'Other')]"));
		hm.put("eleQPBSUBOther", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBSubjectivitiesDV']//label[contains(text(),'Other')]"));
		hm.put("eleQPBOPFOther", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageFormsDV']//label[contains(text(),'Other')]"));
		hm.put("eleQPBCoverageDetailsDescribeTXA", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageDetailsDV']//label[contains(text(),'QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCoverageDetailsDV:')]"));

		// QPB Worker Compensation
		hm.put("eleQPBWCAdditionalCoverageOther", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV']//label[contains(text(),'Other')]"));
		hm.put("eleQPBWCOtherCoverage1", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBAdditonalCoveragesDV']//label[contains(text(),'Other Coverage1')]"));
		// hm.put("eleQPBCoverageMarketingFlyers",
		// By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV']/table/tbody"));
		hm.put("eleQPBCoverageMarketingFlyers", By.xpath("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:QPBLOBQuestions_ExtPanelSet:LOBCovAndMarkFlyersDV"));
		hm.put("eleQPBWCOptionalFormsAssert", By.xpath(".//*[contains(text(), 'WC990299')]"));
		hm.put("eleWorkerCompensationAssert", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:ttlBar'][contains(text(),'Workers Compensation')]"));

		// QPB General Liability
		hm.put("eleQPBGeneralLiability", By.xpath(".//*[contains(@id, 'QPBLOBDetail_ExtScreen:ttlBar')]"));

		// QPB General Liability
		hm.put("lstQPBSICCodeCheck", By.xpath(".//*[contains(text(), 'Wood Products')]"));
		hm.put("eleQPBOFGLAssert", By.xpath(".//*[contains(text(), 'HC21210700')]"));

		// QPB Additional Policy
		hm.put("eleAdditionalPolicy", By.xpath(".//*[@id='QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBAdditionalPolicyLOB_ExtScreen:ttlBar'][contains(text(),'Additional Policy')]"));
		// hm.put("eleAdditionalPolicy",
		// By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBAdditionalPolicyLOB_ExtScreen:ttlBar"));
		hm.put("eleProductPolicyType", By.xpath(".//span[contains(text(), 'Product/Policy Type')]"));
		hm.put("eleQPBNewAdditionalPolicy", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBAdditionalPolicyLOB_ExtScreen:AdditionalPoliciesLV_tb:Add-btnInnerEl"));
		hm.put("lstQPBPolicyEffectiveDate", By.id("QPBAdditionalPolicy_ExtPopup:policyeffdate-inputEl"));
		hm.put("edtQPBPremium", By.id("QPBAdditionalPolicy_ExtPopup:Premium-inputEl"));
		hm.put("eleQPBSaveChanges", By.id("QPBAdditionalPolicy_ExtPopup:ToolbarButton1-btnInnerEl"));

		// QPB Proposal Options
		hm.put("eleCreateProposal", By.xpath(".//span[contains(text(), 'Create Proposal')]"));
		// hm.put("eleCreateProposal",
		// By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:ToolbarButton-btnInnerEl"));
		hm.put("eleProposalOptions", By.xpath(".//label[contains(text(), 'Proposal Options')]"));
		hm.put("eleCreateProposalAssert", By.xpath(".//*[contains(text(), 'Quote Proposal is generated')]"));
		hm.put("eleQPBAccountSummary", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:ProposalOptionsDV:4:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("eleQPBComment", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:ProposalOptionsDV:5:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("edtQPBComment", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:ProposalOptionsDV:6:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("eleQPBAcceptablePO", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:AcctSubjectivitiesDV:1:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("eleQPBReceipt", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:AcctSubjectivitiesDV:2:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("eleQPBOtherPO", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:AcctSubjectivitiesDV:3:QPBModalQuestion_ExtInputSet:checkbox-boxLabelEl"));
		hm.put("edtQPBOtherPO", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:AcctSubjectivitiesDV:4:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("eleQPBAdditionalBilling", By.xpath(".//label[contains(text(), 'Additional Billing Considerations')]"));
		hm.put("edtQPBAdditionalBilling", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:AcctSubjectivitiesDV:20:QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl"));
		hm.put("edtQPBCoverLetter", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBProposalOptions_ExtScreen:ProposalOptionsDV:covletterinput-inputEl"));

		// Account Summary
		hm.put("elePolicyNumberTrasanction", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV:0:PolicyNumber"));
		hm.put("elePolicyProducerCode", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV:0:code"));
		hm.put("eleViewPTHome", By.xpath(".//span[contains(text(), 'Home')]"));
		hm.put("elePolicyTrasanctionNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV:0:WorkOrderNumber"));
		hm.put("PolicyTermHeader", By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV_header']/following-sibling::div[1]/div/div"));
		hm.put("PolicyTermTable", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV-body"));
		hm.put("PolicyTransactionHeader", By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_header']/following-sibling::div[2]/div/div"));
		hm.put("PolicyTransactionTable", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV-body"));
		hm.put("eleAS_CUEbtn", By.id("AccountFile_Summary:AccountFile_SummaryScreen:ToolbarButton-btnInnerEl"));
		hm.put("eleAS_RECONbtn", By.id("AccountFile_Summary:AccountFile_SummaryScreen:recon-btnInnerEl"));
		hm.put("eleClaimsTab", By.xpath("//td[contains(@id,'AccountFile_Claims')]"));
		hm.put("eleActivityClosebtn", By.xpath(".//*[contains(@id,'ActivityDetailToolbarButtons_SkipButton-btnInnerEl')]"));
		hm.put("eleAS_BillingMethod", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:billingNumber:BillingMethodLink_Ext:payrollBilling_Ext"));
		hm.put("eleASBillingNumber", By.xpath("//*[contains(text(),'Billing Number')]"));
		hm.put("AS_ReinsuranceInd", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:accLevelReinsuranceInd-bodyEl"));
		hm.put("eleRequestAIF", By.xpath("//*[contains(@id,':RequestAIF-btnInnerEl')]"));
		hm.put("eleAccountBtn", By.xpath(".//*[@id='SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl']/span[2]"));
		hm.put("eleClickFirstPol", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:higpolicy"));

		// ODS
		// Account Summary
		hm.put("eleAccountNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountNumber-bodyEl"));
		hm.put("bliCLAPayBindOption", By.id("HIGPolicyFile_Payment_Ext:BindOptions-btnInnerEl"));
		// hm.put("lstPayment_BillingMethod",
		// By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:psBillingMethod-inputEl"));
		// hm.put("lstPayment_BillingNumber",
		// By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:PSBillingnumber-inputEl"));

		// hm.put("lstPayment_BillingNumber",
		// By.xpath("//*contains(@id,'PSBillingAdjustment_ExtDV:PSBillingnumber-inputEl')]"));
		hm.put("lstPayment_BillingNumber", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:PSBillingnumber-inputEl"));

		// hm.put("lstPayment_BillingMethod",
		// By.xpath("//*[contains(@id,'PSBillingAdjustment_ExtDV:psBillingMethod-inputEl')]"));
		hm.put("lstPayment_BillingMethod", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:psBillingMethod-inputEl"));

		// Affinity Group
		hm.put("eleAdministration", By.id("TabBar:AdminTab-btnInnerEl"));
		hm.put("eleAuthorityActions", By.id("Admin:AdminMenuActions-btnInnerEl"));
		hm.put("eleNewAffinityGroup", By.id("Admin:AdminMenuActions:AdminMenuActions_Create:AdminMenuActions_NewAffinityGroup-textEl"));
		hm.put("eleAffinityGroup_Edit", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:Edit-btnInnerEl"));
		hm.put("edtCommertialProgramName", By.xpath("//*[contains(@id,'GlobalContactNameInputSet:Name-inputEl')]"));
		hm.put("edtAffGroupName", By.xpath("//*[contains(@id,'AffinityGroupDetailDV:Description-inputEl')]"));
		hm.put("edtAthorityCPID", By.xpath("//*[contains(@id,'AffinityGroupDetailDV:CPID_Ext-inputEl')]"));
		hm.put("lstAthoritySegment", By.xpath("//*[contains(@id,'BusinessSegment_Ext-inputEl')]"));
		hm.put("lstAthorityType", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:Type-inputEl"));
		hm.put("eleAthorityOrganizationlink", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:Organization:SelectOrganization"));
		hm.put("edtAthorityOrganizationName", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAuthoritySearch", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleAuthoritySelect", By.id("OrganizationSearchPopup:OrganizationSearchPopupScreen:OrganizationSearchResultsLV:0:_Select"));
		hm.put("eleAuthorityUpdate", By.xpath("//*[contains(@id,'Update-btnInnerEl')]"));
		hm.put("edtPCFirstName", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtPCPrefFirstName", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:GlobalPersonNameInputSet:PreferredFirstName-inputEl"));
		hm.put("edtPCLastName", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("edtPCPhoneNumber", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:PrimaryConPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtPCEmail", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:PrimaryEmail-inputEl"));
		hm.put("edtICFirstName", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:FirstName-inputEl"));
		hm.put("edtICLastName", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:LastName-inputEl"));
		hm.put("edtICPhoneNumber", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:InternalConPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtICEmail", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:Email-inputEl"));
		hm.put("edtAffinityGrpStartDt", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:StartDate-inputEl"));
		hm.put("edtAffinityGrpEndDt", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:EndDate-inputEl"));
		hm.put("eleJurisdictions", By.xpath("//*[contains(@id,'AffinityGroupDetail_JurisdictionsTab-btnInnerEl')]"));
		// hm.put("eleAffinityJurAdd",
		// By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupJurisdictionsLV_tb:Add-btnInnerEl"));
		hm.put("eleProductRemove", By.xpath("//*[@id='AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupProductsLV-body']//img")); // new element
		hm.put("eleAffinityJurAdd", By.xpath("//*[contains(@id,':Add-btnInnerEl')]"));
		// hm.put("eleAffinityJurAdd",
		// By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupJurisdictionsLV_tb:Add-btnInnerEl"));
		hm.put("eleAffinityProducts", By.xpath("//*[contains(@id,'AffinityGroupDetail_ProductsCardTab-btnInnerEl')]"));
		hm.put("bliAffinityProductAdd", By.xpath("//*[contains(@id,'AffinityGroupProductsLV_tb:AddProduct-btnInnerEl')]"));
		hm.put("eleAffinityProductvalue", By.xpath("//*[contains(@id,'AffinityGroupProductsLV_tb:AddProduct-btnInnerEl')]"));
		hm.put("sclAffinityProductvalue", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupProductsLV_tb:AddProduct:30:Product-textEl"));
		hm.put("eleAffinityProducerCode", By.xpath("//*[contains(@id,'ProducerCodeCardTab-btnInnerEl')]"));
		hm.put("eleAffinityProducerCodeAdd", By.xpath("//*[contains(@id,'ProducerCodesAffinityGroupLV_tb:Add-btnInnerEl')]"));
		hm.put("edtAffinityOrganizationName", By.xpath("//*[contains(@id,'ProducerCodeSearchDV:Description-inputEl')]"));
		hm.put("eleAffinityOrgResSearch", By.xpath("//*[contains(@id,'SearchAndResetInputSet:SearchLinksInputSet:Search')]"));
		hm.put("eleAffinityOrgSearchResults", By.xpath("//*[contains(@id,'AdminProducerCodeSearchLV:0:_Select')]"));
		hm.put("eleAffinityJuristictiontable", By.xpath("//*[contains(@id,'AffinityGroupDetailScreen:AffinityGroupJurisdictionsLV-body')]"));
		hm.put("eleProducerCodeRemove", By.xpath("//*[@id='AffinityGroupDetailPage:AffinityGroupDetailScreen:ProducerCodesAffinityGroupLV-body']//img")); // new element
		hm.put("eleAffinityProducerCodeRemove", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:ProducerCodesAffinityGroupLV_tb:Remove-btnInnerEl"));
		hm.put("eleAffinityJurisdictionVal", By.name("Jurisdiction"));
		hm.put("eleAffinityProductsRemove", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupProductsLV_tb:Remove-btnInnerEl"));
		hm.put("eleAffinityproducerCodetbl", By.xpath("//*[contains(@id,'ProducerCodesAffinityGroupLV-body')]"));
		hm.put("eleAffinityproducerCodeVal", By.name("EffDate"));
		hm.put("eleAffinityprodExpDt", By.name("ExpDate"));
		hm.put("sclAffinityGroupSearchTab", By.id("Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_SearchAffinityGroup"));
		hm.put("eleAffinityGroupSearchTab", By.id("Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_SearchAffinityGroup"));
		hm.put("edtAffinityGrp_CommPgmName", By.id("SearchAffinityGroup:AffinityGroupSearchScreen:AffinityGroupSearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAffinityGrp_Search", By.id("SearchAffinityGroup:AffinityGroupSearchScreen:AffinityGroupSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleAffinityGrp_clkSearchResult", By.id("SearchAffinityGroup:AffinityGroupSearchScreen:AffinityGroupSearchResultsLV:0:Name"));
		hm.put("eleAffinityGroup_Basics", By.xpath("//*[contains(@id,'BasicCardTab-btnInnerEl')]"));
		hm.put("eleSearchAvailableGrps", By.id("SearchAffinityGroup:AffinityGroupSearchScreen:0"));

		// Affinity Group Retrieve Data
		hm.put("eleAffinityGroup_AffinityName", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:Description-inputEl"));
		hm.put("eleAffinityGroup_CommPgmIden", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:AffinityGroupNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAffinityGroup_CPID", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:CPID_Ext-inputEl"));
		hm.put("eleAffinityGroup_Segment", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:BusinessSegment_Ext-inputEl"));
		hm.put("eleAffinityGroup_Type", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:Type-inputEl"));
		hm.put("eleAffinityGroup_Organization", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:Organization-inputEl"));
		hm.put("eleAffinityGroup_PCFirstName", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("eleAffinityGroup_PCPrefFirstName", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:GlobalPersonNameInputSet:PreferredFirstName-bodyEl"));
		hm.put("eleAffinityGroup_PCLastName", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleAffinityGroup_PCPhoneNumber", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:PrimaryConPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("eleAffinityGroup_PCEmail", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:PrimaryEmail-inputEl"));
		hm.put("eleAffinityGroup_ICFirstName", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:FirstName-inputEl"));
		hm.put("eleAffinityGroup_ICLastName", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:LastName_Ext-inputEl"));
		hm.put("eleAffinityGroup_ICPhoneNumber", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:InternalConPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("eleAffinityGroup_ICEmail", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:Email-inputEl"));
		hm.put("eleAffinityGroup_StartDate", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:StartDate-inputEl"));
		hm.put("eleAffinityGroup_EndDate", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:EndDate-inputEl"));
		hm.put("eleAffinityGroup_Jurisdictions", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetail_JurisdictionsTab-btnInnerEl"));
		hm.put("eleAffinityGroup_JurisdictionSt", By.xpath("//*[contains(@id,'JurisdictionsLV-body')]"));
		hm.put("eleAffinityGroup_Products", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetail_ProductsCardTab-btnInnerEl"));
		hm.put("eleAffinityGroup_ProductsSt", By.xpath("//*[contains(@id,'AffinityGroupProductsLV-body')]"));
		hm.put("eleAffinityGroup_ProducerCodes", By.xpath("//*[contains(@id,'ProducerCodeCardTab-btnInnerEl')]"));
		hm.put("eleAffinityGroup_ProducerCodesSt", By.xpath("//*[contains(@id,'ProducerCodesAffinityGroupLV-body')]"));
		hm.put("eleAffinityGroup_ProducerCodeFieldClick", By.xpath("//*[@id='AffinityGroupDetailPage:AffinityGroupDetailScreen:ProducerCodesAffinityGroupLV-body']//td[2]")); // new element
		hm.put("eleCompanyNameSearch", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:companyName:SelectcompanyName"));
		hm.put("edtAffinityCompanyName", By.id("PayrollCompanySearch_ExtPopup:searchBillingCompany-inputEl"));
		hm.put("eleVerifyCompany", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:companyName-inputEl"));
		hm.put("eleVerifyAffinityGroupName", By.cssSelector("[id='AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:Description-inputEl'][readonly='readonly']"));
		hm.put("eleVerifyCommmercialProgram", By.cssSelector("[id='AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:AffinityGroupNameInputSet:GlobalContactNameInputSet:Name-inputEl'][readonly='readonly']"));

		// PolicySummary Retrieve Data
		hm.put("elePolicySummary_AccountNumber", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_AccountDV:Number-inputEl"));
		hm.put("elePolicySummary_PolicyNumber", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_PolicyDV:PolicyNumber-inputEl"));
		hm.put("eleShell_PolicyNumber", By.id("HIGPolicyFile_Summary:PolicyNumber-inputEl"));
		hm.put("eleShellPolicySummarytab", By.id("HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Summary"));
		hm.put("elePolicySummary_ActivityDesc", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Description-inputEl"));
		hm.put("elePolicySummary_ActivityStatus", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Status-inputEl"));
		hm.put("elePolicySummary_CloseWS", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_CloseButton-btnInnerEl"));
		// hm.put("elePolicySummary_CloseWS",By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_SkipButton-btnInnerEl"));
		hm.put("eleShell_AccountNumber", By.id("HIGPolicyFile_Summary:Number-inputEl"));
		hm.put("eleActivity_Status", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:ActivityStatus-inputEl"));
		hm.put("eleActivity_EscalationDate", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:EscalationDate-inputEl"));
		hm.put("edtActivity_EscalationDate", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:EscalationDate-inputEl"));
		hm.put("eleActivityDesc", By.name("NewActivityWorksheet:NewActivityScreen:NewActivityDV:Description2-inputEl"));
		hm.put("elepolicySummary_Activitytbl", By.id("HIGPolicyFile_Summary:24-body"));
		hm.put("elePolicySummary_CancelWS", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_CancelButton-btnInnerEl"));
		hm.put("Shell_PolicyNumber", By.id("HIGPolicyFile_Summary:PolicyNumber-inputEl"));
		hm.put("elePolicyNumberSummary", By.xpath(".//*[@id='PolicyFile:PolicyFileMenuInfoBar:PolicyNumber-btnInnerEl']/span[2]"));
		// Account Summary Retrieve Data
		hm.put("eleAccountSummary_AccountNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl"));
		hm.put("lstAccountSummary_PolTran", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl"));
		hm.put("eleAccountSummary_PolicyTranTbl", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV-body"));
		hm.put("lstActivity_Status", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV:activitiesFilter-inputEl"));
		hm.put("eleAccountSummary_PolicyTermsTbl", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV-body"));

		// Account Contacts Retrieve data
		hm.put("eleAccountSummary_Contacttbl", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body"));
		hm.put("eleContacts_Name", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleContacts_Address", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("eleAccountSummary_Activitytbl", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV-body"));
		hm.put("eleAccountContactAddress", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("eleAccountContactCity", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("eleAccountContactState", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleAccountContactZip", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleCancel", By.id("EditAccountContactPopup:ContactDetailScreen:Cancel-btnInnerEl"));
		hm.put("eleAccountContactPhone", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("eleAccountContactFax", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("eleAccountContactPrimaryEmail", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("eleAccountContactSecondaryEmail", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:EmailAddress2-inputEl"));
		hm.put("eleAccountContactCountry", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("eleAccountContactCounty", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("eleAccountContactAddress", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("eleAccountContactCity", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("eleAccountContactState", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleAccountContactZip", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleAlternatePayerAdd", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:changeAltPayerContactButton_ExtMenuIcon"));
		hm.put("eleExistingAlternatePayer", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:ExistingAlternatePayerContact-textEl"));
		hm.put("eleExistingAlternateNewPerson", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:ExistingAlternatePayerContact:0:UnassignedAccountContactForAltPayer-textEl"));

		// Activity Pattern Retrieve Data
		hm.put("eleActivityPatterntbl", By.id("ActivityPatterns:ActivityPatternsScreen:ActivityPatternsLV-body"));
		hm.put("eleAP_Code", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Code-inputEl"));
		hm.put("eleAP_SegmentCode", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:ApplicableSegment_Ext-inputEl"));
		hm.put("eleAP_Pattern", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:PatternLevel-inputEl"));
		hm.put("eleAP_EscalationDays", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationDays-inputEl"));
		hm.put("eleAP_EscalationHours", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationHours-inputEl"));
		hm.put("eleAP_EscalationStartDate", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationStartPt-inputEl"));
		hm.put("eleAP_EscalationIncludeDays", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:EscalationInclDays-inputEl"));
		hm.put("eleAP_TargetDays", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetDays-inputEl"));
		hm.put("eleAP_TargetHours", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetHours-inputEl"));
		hm.put("eleAP_TargetIncludedays", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetIncludeDays-inputEl"));
		hm.put("eleAP_TargetStartpoint", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:TargetStartPoint-inputEl"));
		hm.put("eleAP_BusinessSegment", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:skillAndTrackLV-body"));
		hm.put("eleAP_ActiveClass", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:ActivityClass-inputEl"));
		hm.put("eleAP_AutomatedOnly", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:AutomatedOnly-inputEl"));
		hm.put("eleAP_Mandatory", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Mandatory-inputEl"));
		hm.put("eleAP_Type", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Type-inputEl"));
		hm.put("eleAP_Category", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Category-inputEl"));
		hm.put("eleAP_Priority", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Priority-inputEl"));
		hm.put("eleAP_Recurring", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Recurring-inputEl"));
		hm.put("eleAP_Subject", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailDV:Subject-inputEl"));

		// Edit Account RetrieveData
		hm.put("edtAccount_AIFNum", By.id("EditAccountPopup:EditAccountScreen:aifNumber_Ext-inputEl"));
		hm.put("edtAccount_AllianceNum", By.id("EditAccountPopup:EditAccountScreen:allianceNumber_Ext-inputEl"));
		hm.put("edtAccount_FEIN", By.id("EditAccountPopup:EditAccountScreen:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("edtAccount_AccountName", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("edtAccount_Country", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("eleAccount_Country", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("edtAccount_Address1", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edjAccount_Address1", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("eleAccount_Address1", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edtAccount_City", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("eleAccount_City", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("edtAccount_County", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("eleAccount_County", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("edtAccount_State", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleAccount_State", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("edtAccount_ZipCode", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleAccount_ZipCode", By.id("EditAccountPopup:EditAccountScreen:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edtAccount_OrganizationType", By.id("EditAccountPopup:EditAccountScreen:OrgType-inputEl"));
		hm.put("eleAccount_AddressType", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AddressShortInputSet:AddressType-inputEl"));
		hm.put("eleAccount_ExperianKey", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:experiankey-bodyEl"));
		hm.put("eleAccountSummary_LeftPane", By.xpath(".//span[contains(text(), 'Summary')]"));
		hm.put("eleAccount_StandardizeBtn", By.id("EditAccountPopup:EditAccountScreen:standardizeButton_Ext-btnInnerEl"));
		hm.put("eleAccount_Message", By.id("EditAccountPopup:EditAccountScreen:_msgs"));
		hm.put("eleEditAccount_Updatebtn", By.id("EditAccountPopup:EditAccountScreen:updateButton_Ext-btnInnerEl"));

		// CLA PolicyInfo Retrieve Data
		hm.put("edtBORCtrlStartDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BORStart-inputEl"));
		hm.put("edtBORCtrlEndDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BORControlEnd-inputEl"));
		hm.put("edtAARPNumber", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:AARP-inputEl"));
		hm.put("edtFEINCode", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:fein-inputEl"));
		hm.put("eleIndustryCodeSearchIcon", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:SICIndustryCode:SelectIndustryCode"));
		hm.put("eleInSearchButton", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleInSelect", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchResultsLV:0:_Select"));
		hm.put("eleNAICSSearch", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:NAICSIndustryCode:SelectIndustryCode"));
		hm.put("lstAffinityGroupName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:AffinityGroup1-inputEl"));
		hm.put("lstIndustryType", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:industryType-inputEl"));
		// hm.put("edtMSI1",
		// By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl"));
		hm.put("edtYearBusinessStarted", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:YearBusinessStarted-inputEl"));
		hm.put("edtNPNNumber", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNNumber-inputEl"));
		hm.put("edtNPNFirstName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNFirstName-inputEl"));
		hm.put("edtNPNLastName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNLastName-inputEl"));
		hm.put("edtOtherPolicyNumber", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PSAMPPoliciesOnlyInputSet:OtherPolicyNumber-inputEl"));
		hm.put("eleNonHartfordClaim", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PSAMPPoliciesOnlyInputSet:NonhartfordClaimsMade-inputEl"));
		hm.put("YearBusinessStarted", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:YearBusinessStarted-inputEl"));
		hm.put("NPNMiddleInitial", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNMiddleInitial-inputEl"));
		hm.put("NPNLastName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNLastName-inputEl"));
		hm.put("CLAMSI", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl"));
		hm.put("NPNFirstName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNFirstName-inputEl"));
		hm.put("CLASegment", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusSegmentID-inputEl"));
		hm.put("CLAFEIN", By.id("HIGPolicyFile_Summary:fein-inputEl"));
		// Search Tab
		hm.put("eleSearchTab", By.id("TabBar:SearchTab-btnWrap"));
		hm.put("eleSearchTabPolicyItm", By.id("TabBar:SearchTab:Search_PolicySearch-itemEl"));
		hm.put("eleSearchTabQLaunchPolicy", By.id("Search:MenuLinks:Search_PolicySearch"));
		hm.put("edtSearchTabCompanyName", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("edtSearchTabAccountNum", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:AccountNumber-inputEl"));
		hm.put("eleSearchTabSearchBtn", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eljSearchTabSearchBtn", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSearchTabErrorMsgs", By.id("PolicySearch:PolicySearchScreen:_msgs"));
		// hm.put("eleSearchTabSearchResults",By.xpath("//*[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV-body']/div/table/tbody"));
		hm.put("eleSearchTabSearchResults", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV-body"));
		hm.put("eleSearchTabPolicyTitle", By.id("PolicySearch:PolicySearchScreen:ttlBar"));
		hm.put("edtSearchTabPolicyNum", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:policyNumber-inputEl"));
		hm.put("edtSearchTabOtherPolicy", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:otherPolicyNumber-inputEl"));
		hm.put("edtSearchTabBillingNum", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:billingNumber-inputEl"));
		hm.put("edtSearchTabFEIN", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:TaxID-inputEl"));
		hm.put("eleSearchTabExactName", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:CompanyNameExact-inputEl"));
		hm.put("eleSearchTabResetBtn", By.xpath("//*[contains(@id,'SearchAndResetInputSet:SearchLinksInputSet:Reset')]"));
		hm.put("eljSearchTabResetBtn", By.xpath("//*[contains(@id,'SearchAndResetInputSet:SearchLinksInputSet:Reset')]"));
		hm.put("lstSearchTabState", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("lstSearchTabUWCompanies", By.id("PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:UWCompany-inputEl"));
		hm.put("eleSearchPoliciesResults", By.xpath("//*[contains(@id,'PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV')]//div[contains(text(),'of')]"));
		hm.put("eleSearchPoliciesPageNext", By.xpath(".//*[@id='PolicySearch:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV']//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]"));

		// Shell Policy Note Edit
		hm.put("eleShellPolNoteEdit", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:NotesLV:0:NoteRowSet:NotesLV_EditLink"));
		hm.put("edtShellPolNoteUpdateSubject", By.id("EditNotePopup:EditNoteScreen:EditNoteDV:Subject-inputEl"));
		hm.put("edtShellPolNoteUpdateText", By.id("EditNotePopup:EditNoteScreen:EditNoteDV:Text-inputEl"));
		hm.put("eleShellPolNoteUpdateNote", By.id("EditNotePopup:EditNoteScreen:Update-btnInnerEl"));
		hm.put("eleShell_ContactTable", By.id("HIGPolicyFile_Contacts:0-body")); // sheel contact
		hm.put("eleFName_ShellContacts", By.id("HIGPolicyFile_Contacts:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("eleLName_ShellContacts", By.id("HIGPolicyFile_Contacts:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));

		// Shell Policy Note Delete
		hm.put("eleShellPolicyNoteDelete", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:NotesLV:0:NoteRowSet:NotesLV_DeleteLink"));
		hm.put("eleShellDeletePolicyNoteOK", By.id("button-1005-btnWrap"));

		// Shell Summary Quick launch link
		hm.put("eleShellPolicySummaryQLaunch", By.id("HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Summary"));

		// Create Shell Policy Notes
		hm.put("eleShellPolicyAction", By.id("SubmissionWizard:WizardMenuActions-btnInnerEl"));
		hm.put("eleShellPolicyNewNote", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:HIGAccountMenuActions_NewNote-textEl"));
		hm.put("lstShellPolicyNotesTopic", By.id("NewHIGPolicyNoteWorksheet:NewNoteScreen:NewNoteDV:Topic-inputEl"));
		hm.put("edtShellPolicyNotesSubjectText", By.id("NewHIGPolicyNoteWorksheet:NewNoteScreen:NewNoteDV:Subject-inputEl"));
		hm.put("lstShellPolicyNotesRelatedTo", By.id("NewHIGPolicyNoteWorksheet:NewNoteScreen:NewNoteDV:RelatedTo-inputEl"));
		hm.put("edtShellPolicyNotesText", By.id("NewHIGPolicyNoteWorksheet:NewNoteScreen:NewNoteDV:Text-inputEl"));
		hm.put("eleShellPolicyNotesCreateUpdate", By.id("NewHIGPolicyNoteWorksheet:NewNoteScreen:NewNoteScreen_UpdateButton-btnInnerEl"));
		hm.put("eleShellPolicyNotesCreateCancel", By.id("NewHIGPolicyNoteWorksheet:NewNoteScreen:NewNoteScreen_CancelButton-btnInnerEl"));
		hm.put("eleShellPolicySummary", By.id("HIGPolicyFile_Summary:ttlBar"));
		hm.put("eleShellPolicyTopicErrorMsgs", By.xpath(".//*[@id='NewHIGPolicyNoteWorksheet:NewNoteScreen:_msgs']/div[1]"));
		hm.put("eleShellPolicyTextErrorMsgs", By.xpath(".//*[@id='NewHIGPolicyNoteWorksheet:NewNoteScreen:_msgs']/div[2]"));
		hm.put("elePolicyLinks", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:WizardMenuActions_Goto:policyShellLinks-itemEl"));

		// Search Shell Policy Notes
		hm.put("eleShellPolicyNotes", By.id("HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Notes"));
		hm.put("edtShellPolicySearchText", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:TextSearch-inputEl"));
		hm.put("edtShellTopicNote", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:Topic-inputEl"));
		hm.put("edtShellRelatedToNote", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:RelatedTo-inputEl"));
		hm.put("eleShellNotesSearchBtn", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("funPolicyShellNotesVerify", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:NotesLV-body"));
		hm.put("eleShellPolicyNoteTitle", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:ttlBar"));
		hm.put("eleShellPolicyResetBtn", By.id("HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));

		// Search Shell Policy
		hm.put("funSelectPolicy", By.xpath(".//*[@id='AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV-body']/div/table/tbody"));

		// Search Activities
		hm.put("eleSearchActivites", By.id("TabBar:SearchTab:Search_ActivitySearch-textEl"));
		hm.put("edtSearchActivitesProducerCode", By.id("ActivitySearch:ActivitySearchScreen:ActivitySearchDV:ProducerCode-inputEl"));
		hm.put("edtSearchActivitesAccountNumber", By.id("ActivitySearch:ActivitySearchScreen:ActivitySearchDV:AccountNumber-inputEl"));
		hm.put("eleSearchActivitesSearch", By.id("ActivitySearch:ActivitySearchScreen:ActivitySearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSearchTable", By.id("ActivitySearch:ActivitySearchScreen:ActivitiesSearchLV-body"));
		// R3 - -hm.put("SearchTable",
		// By.id("ActivitySearch:ActivitySearchScreen:ActivitiesSearchLV-body"));
		hm.put("eleSearchActivitiesReset", By.id("ActivitySearch:ActivitySearchScreen:ActivitySearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleSearchActivitesLookUp", By.id("ActivitySearch:ActivitySearchScreen:ActivitySearchDV:AssignedUser:SelectOrganization"));
		hm.put("edtSAUserName", By.id("SearchActivitiesUserSearch_ExtPopup:UserSearchPopupScreen:SearchActivitiesUserSearch_ExtDV:Username-inputEl"));
		hm.put("eleSAUNSearch", By.id("SearchActivitiesUserSearch_ExtPopup:UserSearchPopupScreen:SearchActivitiesUserSearch_ExtDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSAUNSelect", By.id("SearchActivitiesUserSearch_ExtPopup:UserSearchPopupScreen:UserSearchResultsLV:0:_Select"));
		hm.put("eleSAAssign", By.cssSelector("a[id='ActivitySearch:ActivitySearchScreen:ActivitiesSearchLV_tb:ActivitySearch_AssignButton'][class='x-btn x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("lstSASelectFromList", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:SelectFromList-inputEl"));
		hm.put("eleSAUserAssign", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentByGroupPopupScreen_ButtonButton-btnInnerEl"));
		hm.put("eleSAActivityWorkSpaceOK", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_UpdateButton-btnInnerEl"));
		hm.put("eleSAFindaUserorQueue", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:3-inputEl"));
		hm.put("lstSASearchFor", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentSearchInputSet:SearchFor-inputEl"));
		hm.put("lsjSASearchFor", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentSearchInputSet:SearchFor-inputEl"));
		hm.put("edtSAUNAA", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentSearchInputSet:Username-inputEl"));
		hm.put("edtSAFNAA", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentSearchInputSet:PLNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtSALNAA", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentSearchInputSet:PLNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleSASearchAA", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("edtSAQueueName", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:AssignmentSearchInputSet:QueueName-inputEl"));
		hm.put("eleSAResetAA", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleSARETURNSA", By.id("AssignActivitiesPopup:__crumb__"));
		hm.put("eleSARtoSAMsg", By.id("messagebox-1001-displayfield-inputEl"));
		hm.put("eleSAssigntoQueue", By.id("ActivitySearch:ActivitySearchScreen:ActivitySearchDV:AssignedQueue:SelectOrganization"));
		hm.put("edtSAQueueNameATQ", By.id("SearchQueue_ExtPopup:searchQueue-inputEl"));
		hm.put("eleSASearchATQ", By.id("SearchQueue_ExtPopup:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSASelectATQ", By.id("SearchQueue_ExtPopup:0:_Select"));
		hm.put("eleSAAssignUN", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentUserLV:0:_Select"));
		hm.put("txtOOTBTCON15", By.xpath(".//*[@id='SearchActivitiesUserSearch_ExtPopup:UserSearchPopupScreen:_msgs']/div"));
		hm.put("eleOOTBTCON15", By.xpath(".//*[@id='SearchActivitiesUserSearch_ExtPopup:UserSearchPopupScreen:_msgs']/div"));
		hm.put("eleDisableAssigntoQueue", By.cssSelector("input[id='ActivitySearch:ActivitySearchScreen:ActivitySearchDV:AssignedQueue-inputEl'][disabled='']"));
		hm.put("eleDisableAssigntoUser", By.cssSelector("input[id='ActivitySearch:ActivitySearchScreen:ActivitySearchDV:AssignedUser-inputEl'][disabled='']"));
		hm.put("eleSearchQueueSearchResultsTable", By.id("SearchQueue_ExtPopup:2-body"));
		hm.put("txtAssigntoQueueOOTB", By.xpath(".//*[@id='SearchQueue_ExtPopup:_msgs']/div"));
		hm.put("eleSAClose", By.cssSelector("a[id='ActivitySearch:ActivitySearchScreen:ActivitiesSearchLV_tb:ActivitySearch_SkipButton'][class='x-btn x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleSAComplete", By.cssSelector("a[id='ActivitySearch:ActivitySearchScreen:ActivitiesSearchLV_tb:ActivitySearch_CompleteButton'][class='x-btn x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleSAFollowUp", By.id("ActivitySearch:ActivitySearchScreen:ActivitiesSearchLV:0:Subject"));
		hm.put("eleSearchActivitiesTitle", By.id("ActivitySearch:ActivitySearchScreen:ttlBar"));
		hm.put("eleReturnToActivities", By.id("SearchActivitiesUserSearch_ExtPopup:__crumb__"));
		hm.put("eleSA_ErrMsg", By.id("AssignActivitiesPopup:AssignmentPopupScreen:_msgs"));
		hm.put("eleReturnToActivity", By.xpath("//*[contains(text(),'Return to Search Activities')]"));
		// R3 --hm.put("eleReturnToActivity",
		// By.id("SearchActivitiesUserSearch_ExtPopup:__crumb__"));

		// Document
		hm.put("eleSearchIDRAS", By.id("PolicyFile_Documents:Policy_DocumentsScreen:ExternalDocumentLinksDV:SearchIDARS-btnInnerEl"));
		hm.put("eleNoRecords", By.id("noResultsOk_label"));
		hm.put("eleoptCopyType", By.id("optCopyType"));
		hm.put("drpoptCopyType", By.id("optCopyType"));
		hm.put("eleSearch", By.id("searchButtonAD_label"));
		hm.put("eleView", By.id("viewButton_label"));
		hm.put("elePolicy_Document", By.id("PolicyFile:MenuLinks:PolicyFile_PolicyFile_Documents"));
		hm.put("eleDocument", By.id("HIGPolicyFile:MenuLinks:HIGPolicyFile_PolicyShell_Documents_Ext"));
		hm.put("eleDocumentAccount", By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Documents']/div/span[text()='Documents']"));
		hm.put("btnAccountMenu", By.xpath(".//*[@id='PolicyFile:PolicyFileMenuInfoBar:AccountNumber-btnInnerEl']/span[2]"));
		// Driver Information
		hm.put("eleCLADriver", By.id("HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicy_Drivers"));
		hm.put("eleCLADvrEdit", By.id("HIGPolicy_Drivers:DriversPanelSet:Edit-btnInnerEl"));
		hm.put("eleCLADvrAddDriver", By.id("HIGPolicy_Drivers:DriversPanelSet:Add-btnInnerEl"));
		hm.put("eleCLADvrOK", By.xpath("//*[contains(@id,'DriverPopup:Update-btnInnerEl')]"));
		hm.put("edtCLADvrFirstName", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:firstname-inputEl')]"));
		hm.put("edtCLADvrLastName", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:lastname-inputEl')]"));
		hm.put("edtCLADvrLicenceNumber", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:licenseno-inputEl')]"));
		hm.put("lstCLADvrLicenceState", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:licensestate-inputEl')]"));
		hm.put("txtFirstNameWarningandDOB", By.xpath("//*[contains(@id,'DriverPopup:_msgs')]/div"));
		hm.put("txtLastNameWarning", By.xpath(".//*[@id='HIGNewDriverPopup:_msgs']/div[2]"));
		hm.put("txtLicenceNumber", By.xpath(".//*[@id='HIGNewDriverPopup:_msgs']/div[3]"));
		hm.put("txtLicenceState", By.xpath(".//*[@id='HIGNewDriverPopup:_msgs']/div[4]"));
		hm.put("txtUpdateLicenceNumberAppropriate", By.xpath(".//*[@id='HIGNewDriverPopup:_msgs']/div[4]"));
		hm.put("eleCLADvrUpdate", By.id("HIGPolicy_Drivers:DriversPanelSet:Update-btnInnerEl"));
		hm.put("eleCLADvrAddDriverFirstRecord", By.xpath(".//*[@id='HIGEditDriverPopup:_msgs']/div"));
		hm.put("eleCLADvrEditDriverDetails", By.id("HIGEditDriverPopup:Edit-btnInnerEl"));
		hm.put("eleCLADvrCancel", By.id("HIGEditDriverPopup:Cancel-btnInnerEl"));
		hm.put("eleDriverInformationRecordTable", By.id("HIGPolicy_Drivers:DriversPanelSet:DriverDetailLV-body"));
		hm.put("eleCLADvrUpdateDriverDetails", By.id("HIGEditDriverPopup:Update-btnInnerEl"));
		hm.put("eleCLADvrChangeActiveStatus", By.id("HIGPolicy_Drivers:DriversPanelSet:changeActiveStatus-btnInnerEl"));
		hm.put("edtCLADvrDOB", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:dob-inputEl')]"));
		hm.put("eleCLADvrRemoveDriver", By.id("HIGPolicy_Drivers:DriversPanelSet:Remove-btnInnerEl"));
		hm.put("eleCLADvrDriverDetailsCancel", By.xpath("//*[contains(@id,'DriverPopup:Cancel-btnInnerEl')]"));
		hm.put("edtCLADvrDateFirstLicenced", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:dateFirstLicensed-inputEl')]"));
		hm.put("txtInactiveEffectiveDate", By.xpath("//*[contains(@id,'DriverPopup:HIGDriverInfoDV:inactiveDate-inputEl')]"));
		hm.put("eleCLADvrReturnToDriver", By.xpath("//*[contains(@id,'DriverPopup:__crumb__')]"));
		hm.put("eleCheckRemvoedDriverPresent", By.xpath(".//a[contains(text(), 'First')]"));
		hm.put("eleCLADvrPolicyNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:higpolicy"));
		hm.put("eleForceDMV", By.id("HIGPolicy_Drivers:DriversPanelSet:forceDMV"));
		hm.put("eleOrderMVR", By.id("HIGPolicy_Drivers:DriversPanelSet:orderMVR"));
		hm.put("eleBrowseButton", By.id("//a//span[contains(.,'Browse')]"));
		hm.put("eleSpreadsheet", By.id("HIGPolicy_Drivers:DriversPanelSet:driverExportImportMenu-btnInnerEl"));
		hm.put("eleImportSpreadsheet", By.id("HIGPolicy_Drivers:DriversPanelSet:driverExportImportMenu:Import-itemEl"));
		hm.put("eleOrderAll", By.id("HIGPolicy_Drivers:DriversPanelSet:orderAll"));
		hm.put("edtCLADvrMiddleName", By.id("HIGNewDriverPopup:HIGDriverInfoDV:middleName-inputEl"));
		// Vehicle / Auto Id Card
		hm.put("eleAutoIdCardActionMenu", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:newVehicle-textEl"));
		hm.put("eleAutoIdCardTitle", By.id("HIGVehicleIDPopup:ttlBar"));
		hm.put("lstAutoIdCardSourceOfRequest", By.id("HIGVehicleIDPopup:soureOfRequest-inputEl"));
		hm.put("edtAutoIdCardEndorsementEffDate", By.id("HIGVehicleIDPopup:endorsementEffDate-inputEl"));
		hm.put("lstAutoIdCardDeliveryType", By.id("HIGVehicleIDPopup:deliveryType-inputEl"));
		hm.put("lstAutoIdCardContactName", By.id("HIGVehicleIDPopup:contactName1-inputEl"));
		hm.put("eleAutoIdCardAddNewVehicleBtn", By.id("HIGVehicleIDPopup:PSVehicleDetails_ExtLV_tb:addVehicle-btnInnerEl"));
		hm.put("eleAutoIdCardSaveDraftBtn", By.id("HIGVehicleIDPopup:saveDraftButton-btnInnerEl"));
		hm.put("eleAutoIdCardCancelBtn", By.id("HIGVehicleIDPopup:CancelButton-btnInnerEl"));
		hm.put("eleAutoIdCardFinalizeBtn", By.cssSelector("a[id='HIGVehicleIDPopup:finalizeDocument'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eljAutoIdCardFinalizeBtn", By.cssSelector("a[id='HIGVehicleIDPopup:finalizeDocument'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleAutoIdCardRequestFormBtn", By.id("HIGVehicleIDPopup:requestForm-btnInnerEl"));
		hm.put("eleAutoIdCardReturntoPolicyInfolnk", By.id("HIGVehicleIDPopup:__crumb__"));
		hm.put("edtAutoIdCardToEmail", By.id("HIGVehicleIDPopup:DeliveryPreferenceTO_Ext:TOEmail_Ext-inputEl"));
		hm.put("edtAutoIdCardToFax", By.id("HIGVehicleIDPopup:DeliveryPreferenceTO_Ext:TOFax_Ext-inputEl"));
		hm.put("eleAutoIdCardAddEditUniqueContact", By.id("HIGVehicleIDPopup:uniqueContactInputSet:addEditUniqueContact-btnInnerEl"));
		hm.put("eleAutoIdCardUniqueContact", By.id("HIGVehicleIDPopup:uniqueContactInputSet:addEditUniqueContact:0:roleType-textEl"));
		hm.put("eleAutoIdCardAddEditCompany", By.id("HIGVehicleIDPopup:uniqueContactInputSet:addEditUniqueContact:0:roleType:0:contactType-textEl"));
		hm.put("eleAutoIdCardAddEditPerson", By.id("HIGVehicleIDPopup:uniqueContactInputSet:addEditUniqueContact:0:roleType:1:contactType-textEl"));
		hm.put("eleAutoIdCardRemoveUniqueContact", By.id("HIGVehicleIDPopup:uniqueContactInputSet:DeleteUniqueTo-btnInnerEl"));
		hm.put("eleAutoIdCardVehicleDetailsTable", By.id("HIGVehicleIDPopup:PSVehicleDetails_ExtLV-body"));
		hm.put("eleAutoIdCardErrorMsg", By.id("HIGVehicleIDPopup:_msgs"));

		// New Unique Contact
		hm.put("eleAIDNewUniqueContactTitle", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:ttlBar"));
		hm.put("edtAIDName", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:VehicleContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("lstAIDCountry", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("edtAIDAddressLine1", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edtAIDCity", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("edtAIDCountry", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("lstAIDState", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("edtAIDZipcode", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edtAIDFirstName", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:VehicleContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtAIDLastName", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:VehicleContactCV:VehicleContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleAIDUpdateBtn", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleAIDCancelBtn", By.id("AddVehicleUniqueContactPopup:ContactDetailScreen:Cancel-btnInnerEl"));
		hm.put("eleAIDReturnToAIDCardLnk", By.id("AddVehicleUniqueContactPopup:__crumb__"));

		// Vehicle Information
		hm.put("eleVINewVehicleTitle", By.id("PSNewVehicle_ExtPopup:ttlBar"));
		hm.put("lstVIState", By.id("PSNewVehicle_ExtPopup:vehicleState-inputEl"));
		hm.put("edtVIModelYear", By.id("PSNewVehicle_ExtPopup:vehicleYear-inputEl"));
		hm.put("edtVIMake", By.id("PSNewVehicle_ExtPopup:vehicleMake-inputEl"));
		hm.put("edtVIModel", By.id("PSNewVehicle_ExtPopup:vehicleModel-inputEl"));
		hm.put("edtVIVehicleVIN", By.id("PSNewVehicle_ExtPopup:vehicleVIN-inputEl"));
		hm.put("eleVIOkBtn", By.id("PSNewVehicle_ExtPopup:OK-btnInnerEl"));
		hm.put("eleVICancelBtn", By.id("PSNewVehicle_ExtPopup:Cancel-btnInnerEl"));
		hm.put("eleVIReturntoAIDCardLnk", By.id("PSNewVehicle_ExtPopup:__crumb__"));

		// Account Submission Manager
		hm.put("eleASMSubmissionTransQuickLink", By.xpath(".//span[contains(text(), 'Submission Manager')]"));
		hm.put("eleASMSubmissionManagerTitle", By.id("SubmissionManager:SubmissionManagerScreen:0"));
		hm.put("eleASMBannerMessage", By.id("SubmissionManager:SubmissionManagerScreen:Message"));
		hm.put("lstASMFilter", By.id("SubmissionManager:SubmissionManagerScreen:SubmissionManagerLV:submissionFilter-inputEl"));
		hm.put("eleASMNewSubmissionBtn", By.id("SubmissionManager:SubmissionManagerScreen:SubmissionManager_NewSubmission-btnInnerEl"));
		hm.put("eleASMSearchResultTable", By.id("SubmissionManager:SubmissionManagerScreen:SubmissionManagerLV-body"));
		hm.put("eleSubmissionManagerTab", By.id("AccountFile:MenuLinks:AccountFile_SubmissionManager"));
		// Customer Forms
		hm.put("eleCustomerForms", By.xpath("//span[contains(text(), 'Customer Forms')]"));
		hm.put("eleCFTSAddNewCustomerForm", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateScreenResultsLV_tb:addNewCertificate-btnInnerEl"));
		// hm.put("eleCFTSAddNewPolicy",
		// By.cssSelector("a[id='CertificatePopup:defaultCertScreen:CertificatePanelSet:certificatePolicyDataLV_tb:ToolbarButton'][class='x-btn
		// x-unselectable x-btn-toolbar x-box-item x-toolbar-item
		// x-btn-default-toolbar-small x-noicon x-btn-noicon
		// x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCFTSAddNewPolicy", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:certificatePolicyDataLV_tb:ToolbarButton-btnWrap"));
		hm.put("eleCFTSAddNewPolicyDataAddress", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:certificatePolicyDataLV_tb:ToolbarButton:0:policyLineToAdd-textEl"));
		hm.put("eleCFTSAddNewPolicy1", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:certificatePolicyDataLV:0:policyNumber"));
		hm.put("eleCFTSAddNewPolicy2", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:certificatePolicyDataLV:1:policyNumber"));
		hm.put("txtAddNewPolicyWarning", By.id("CertificatePopup:defaultCertScreen:_msgs"));
		hm.put("lstCFTSFormName", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:formType-inputEl"));
		hm.put("lstCFTSSourceOfRequest", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:sourceofRequest-inputEl"));
		hm.put("eleCFTSCopyInsured", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:CopyInsured-inputEl"));
		hm.put("lstCFTSHowSent", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:InsuredHowSent-inputEl"));
		hm.put("lsjCFTSHowSent", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:InsuredHowSent-inputEl"));
		hm.put("eleCFTSEMail", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:InsuredEmail-inputEl"));
		hm.put("edtCFTSEMail", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:InsuredEmail-inputEl"));
		hm.put("edtCFTSFax", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:InsuredFax-inputEl"));
		hm.put("eleCFTSSaveDraft", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:saveAndPrint-btnEl"));
		hm.put("txtFormNumber", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:certnumber-inputEl"));
		hm.put("eleCFTSAddNewCustomerFormTable", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateScreenResultsLV-body"));
		hm.put("eleCFTSAddAccountRecipients", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:accountReciepientLV_tb:addAccountrecipient-btnWrap"));
		// hm.put("eleCFTSFormNumber",
		// By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateScreenResultsLV:0:certNumber"));
		hm.put("eleCFTSFormNumber", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateScreenResultsLV_tb:addNewCertificate-btnInnerEl"));
		hm.put("eleCFTSFormNumber1", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateScreenResultsLV:1:certNumber"));
		hm.put("eleCFTSNewAccountRecipients", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:accountReciepientLV_tb:addAccountrecipient:newAccRec-textEl"));
		hm.put("edtCFTSName1", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:nameOne-inputEl')]"));
		// hm.put("edtCFTSName1",
		// By.xpath("//*[contains(@id,'accountRecipient-inputEl')]"));
		hm.put("lstCFTSHowSentRecipients", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:howSent-inputEl')]"));
		hm.put("lsjCFTSHowSentRecipients", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:howSent-inputEl')]"));
		hm.put("edtCFTSPrimaryEmail", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:EmailAddress1-inputEl')]"));
		hm.put("edtCFTSAddress1", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("eleCFTSAddress1", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("eleCFTSCity", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl')]"));
		hm.put("zedCFTSCity", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl')]"));
		// hm.put("eleCFTSState",
		// By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-triggerWrap')]"));
		hm.put("edtCFTSState", By.xpath("//*[contains(@id,':State-inputEl')]"));
		hm.put("zedCFTSState", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-triggerWrap')]"));
		// hm.put("eleCFTSZipCode",
		// By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("edtCFTSZipCode", By.xpath("//*[contains(@id,':PostalCode-inputEl')]"));
		hm.put("zedCFTSZipCode", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("eleCFTSStandardize", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:standardizeButton_Ext-btnInnerEl')]"));
		hm.put("eleCFTSUpdate", By.cssSelector("a[id='NewAccountRecipient_ExtPopup:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("lstCFTSCertType", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:typeCert-inputEl')]"));
		hm.put("eleCFTSExistingAccountRecipients", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:accountReciepientLV_tb:addAccountrecipient:existingAccRec-textEl"));
		hm.put("eleCFTSAccountReceipientsTable", By.id("AccountRecipientCert_ExtPopup:AccountRecipientSummaryScreen:AccountRecipientLV-body"));
		hm.put("eleCFTSAccountRecipientsEdit", By.id("EditAccountRecipient_ExtPopup:Edit-btnInnerEl"));
		// hm.put("eleCFTSUpdateEdit",
		// By.cssSelector("a[id='EditAccountRecipient_ExtPopup:updateButton_Ext'][class='x-btn
		// x-unselectable x-btn-toolbar x-box-item x-toolbar-item
		// x-btn-default-toolbar-small x-noicon x-btn-noicon
		// x-btn-default-toolbar-small-noicon x-over x-btn-over
		// x-btn-default-toolbar-small-over']"));
		hm.put("eleCFTSUpdateEdit", By.id("EditAccountRecipient_ExtPopup:updateButton_Ext"));
		hm.put("txtCFTSName", By.id("EditAccountRecipient_ExtPopup:nameOne-inputEl"));
		hm.put("txtCFTSPrimaryEmail", By.id("EditAccountRecipient_ExtPopup:EmailAddress1-inputEl"));
		hm.put("txtCFTSAddress", By.id("EditAccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("txtCFTSAnnual", By.id("EditAccountRecipient_ExtPopup:typeCert-inputEl"));
		hm.put("edtCFTSFormNumber", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateSearchDV:certnumber-inputEl"));
		hm.put("eleCFTSSearch", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleCFTSReset", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("txtZeroResults", By.xpath("//*[contains(text(),'The search returned zero results.')]"));
		hm.put("eleCFTSAddRecepient", By.cssSelector("a[id='AccountRecipientCert_ExtPopup:AccountRecipientSummaryScreen:AccountRecipientLV_tb:value1'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCFTSRequestForm", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:requestForm-btnInnerEl"));
		hm.put("eleCFTSFinalize", By.id("EditCertificatePopup:editCertScreen:EditCertificatePanelSet_tb:viewCertificate-btnInnerEl"));
		hm.put("eleCustomerFormsPageAssert", By.id("AccountFile_Certificates:CertificateSearchScreen:ttlBar"));
		hm.put("eleCFTSFinalizeCancel", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:cancel-btnInnerEl"));
		hm.put("eleCFTSView", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:accountReciepientLV:0:documentView"));
		hm.put("eleCFTSView1", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:accountReciepientLV:1:documentView"));
		hm.put("lstCFTSAsOfDate", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:certDate-inputEl"));
		hm.put("eleCFTSCancel", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:cancel-btnInnerEl"));
		hm.put("eleCFTSWithDrawForm", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:withdrawCertuificate-btnInnerEl"));
		hm.put("eleCFTSEvidenceOfPropertyTab", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:EvidenceOfPropertyTab-btnInnerEl')]"));
		hm.put("lstCFTSEvidenceType", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:evidenceFormType-inputEl')]"));
		hm.put("edtCFTSARFax", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl')]"));
		hm.put("eleAccountRecepientsTable", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:accountReciepientLV-body"));
		hm.put("eleCFTSAddNewLocation", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet:locationsLV_tb:AddLocation-btnInnerEl"));
		hm.put("edtCFTSLILocation", By.id("CertLocation_ExtPopup:locationNum-inputEl"));
		hm.put("edtCFTSLIBuilding", By.id("CertLocation_ExtPopup:BuildingNum-inputEl"));
		hm.put("lstCFTSLIState", By.id("CertLocation_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleCFTSLIState", By.id("CertLocation_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("edtCFTSLIAddress1", By.id("CertLocation_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("eleCFTSLIZipCode", By.id("CertLocation_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("lstCFTSLIZipCode", By.id("CertLocation_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("lsjCFTSLIZipCode", By.id("CertLocation_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleCFTSLIStandardise", By.id("CertLocation_ExtPopup:standardizeButton_Ext-btnInnerEl"));
		hm.put("eleCFTSLIUpdate", By.cssSelector("a[id='CertLocation_ExtPopup:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCFTSFormNameRO", By.cssSelector("div[id='CertificatePopup:defaultCertScreen:CertificatePanelSet:formType-inputEl'][class='x-form-display-field']"));
		hm.put("eleCFTSFormNumberRO", By.cssSelector("div[id='CertificatePopup:defaultCertScreen:CertificatePanelSet:certnumber-inputEl'][class='x-form-display-field']"));
		hm.put("eleCFTSSourceOfRequestRO", By.cssSelector("div[id='CertificatePopup:defaultCertScreen:CertificatePanelSet:sourceofRequest-inputEl'][class='x-form-display-field']"));
		hm.put("eleCFTSFinalWorkStatusRO", By.cssSelector("div[id='CertificatePopup:defaultCertScreen:CertificatePanelSet:status-inputEl'][class='x-form-display-field']"));
		hm.put("eleCFTSEOPRequestForm", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:requestForm_Ext-btnInnerEl"));
		hm.put("lstCFTSAccountRecepient", By.id("AccountFile_Certificates:CertificateSearchScreen:certSearchPanel:CertificateSearchDV:accountRecipient-inputEl"));
		hm.put("eleCFTSEditForm", By.id("CertificatePopup:defaultCertScreen:CertificatePanelSet_tb:requestForm_Ext-btnInnerEl"));
		hm.put("eleCFTSSaveAsDraft", By.id("EditCertificatePopup:editCertScreen:EditCertificatePanelSet_tb:saveAndPrint-btnInnerEl"));
		hm.put("eleCFTSAccountRecepientDataEntry", By.id("EditCertificatePopup:editCertScreen:ttlBar"));

		// Account Policy Transaction
		hm.put("eleAPTAccountSummaryTitle", By.id("AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:ttlBar"));
		// hm.put("eleAPTBannerMessage",
		// By.id("AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:policyShellMessage_Ext"));
		hm.put("eleAPTBannerMessage", By.xpath(".//span[contains(text(), 'This screen does not display all Policy Transactions. Please navigate to the Policy Shell for the CLA or Manual policy transactions.')]"));
		hm.put("eleAPTPolicyTransQuickLink", By.xpath(".//span[contains(text(), 'Policy Transactions')]"));
		hm.put("eleAPTStatus", By.id("AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:WorkOrdersCompletenessFilter-inputEl"));
		hm.put("eleAPTSearchResultTable", By.id("AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:AccountWorkOrdersLV-body"));
		hm.put("eleAPTPolicyTransactionTitle", By.id("PolicyFile_Jobs:Policy_JobsScreen:0"));
		hm.put("eleAPTPolicyTransactionAccountName", By.id("PolicyFile_Jobs:Policy_JobsScreen:DetailPanel:Policy_JobInfoDV:Policy_JobDetailsInputSet:Account-inputEl"));
		hm.put("edtProductList", By.xpath(".//*[@id='AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:ProductFilter-inputEl']"));
		hm.put("btnNGS", By.xpath(".//*[@id='AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:ProductFilter-inputEl']/following::li[3]"));
		hm.put("eleProductTable", By.xpath(".//*[@id='AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:ttlBar']//following::table[7]")); // Account Recepient
		hm.put("eleAccountReceipients", By.xpath(".//span[contains(text(), 'Account Recipients')]"));
		hm.put("eleNewAccountRecipient", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewAccountRecipient-textEl"));
		hm.put("edtARName1", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:nameOne-inputEl')]"));
		hm.put("edtARName2", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:nameTwo-inputEl')]"));
		hm.put("edtARName3", By.xpath(""));
		hm.put("lstARHowSentRecipients", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:howSent-inputEl')]"));
		hm.put("lstARHowSentSearch", By.xpath("//*[contains(@id,'AccountRecipientSummaryScreen:howSent-inputEl')]"));
		hm.put("edtARCitySearch", By.xpath("//*[contains(@id,'AccountRecipientSummaryScreen:cityStateZip-inputEl')]"));
		hm.put("edtARPrimaryEmail", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:EmailAddress1-inputEl')]"));
		hm.put("edtARFax", By.xpath("//*[contains(@id,'FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl')]"));
		hm.put("edtARAddress1", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("eleARCity", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl')]"));
		hm.put("zedARCity", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl')]"));
		hm.put("eleARState", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-triggerWrap')]"));
		hm.put("zedARState", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-triggerWrap')]"));
		hm.put("eleARZipCode", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("zedARZipCode", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("eleARStandardize", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:standardizeButton_Ext-btnInnerEl')]"));
		hm.put("eljARUpdate", By.xpath("//*[contains(@id,'updateButton_Ext-btnInnerEl')]"));
		hm.put("eleARUpdate", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:updateButton_Ext-btnInnerEl')]"));
		hm.put("lstARCertType", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:typeCert-inputEl')]"));
		hm.put("eleAROverride", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:overrideButton_Ext-btnInnerEl')]"));
		hm.put("eleAREvidenceOfPropertyTab", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:EvidenceOfPropertyTab-btnInnerEl')]"));
		hm.put("lstAREvidenceType", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:evidenceFormType-inputEl')]"));
		hm.put("txtAREvidenceType", By.id("NewAccountRecipient_ExtPopup:evidenceFormType-inputEl"));
		hm.put("eleARCancel", By.xpath("//*[contains(@id,'AccountRecipient_ExtPopup:Cancel-btnInnerEl')]"));
		hm.put("edtARAccountRecipients", By.id("AccountRecipientSummary_Ext:AccountRecipientSummaryScreen:accountRecipient-inputEl"));
		hm.put("eleARAccountRecipientsTable", By.id("AccountRecipientSummary_Ext:AccountRecipientSummaryScreen:AccountRecipientLV-body"));
		hm.put("txtARName1", By.id("EditAccountRecipient_ExtPopup:nameOne-inputEl"));
		hm.put("txtARName2", By.id("EditAccountRecipient_ExtPopup:nameTwo-inputEl"));
		hm.put("txtAREmail", By.id("EditAccountRecipient_ExtPopup:EmailAddress1-inputEl"));
		hm.put("txtARAddress", By.id("EditAccountRecipient_ExtPopup:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("txtARCertType", By.id("EditAccountRecipient_ExtPopup:typeCert-inputEl"));
		hm.put("eleAREdit", By.id("EditAccountRecipient_ExtPopup:Edit-btnInnerEl"));
		hm.put("eljAREdit", By.id("EditAccountRecipient_ExtPopup:Edit-btnInnerEl"));
		hm.put("eleAccountReceipientLabel", By.id("AccountRecipientSummary_Ext:AccountRecipientSummaryScreen:ttlBar"));
		hm.put("eleARSearch", By.id("AccountRecipientSummary_Ext:AccountRecipientSummaryScreen:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleAR_Update", By.id("EditAccountRecipient_ExtPopup:updateButton_Ext-btnInnerEl"));
		hm.put("eleARSelectAccountRecepient", By.xpath("//*[contains(@id,'AccountRecipientSummary_Ext:AccountRecipientSummaryScreen:AccountRecipientLV:')]"));
		hm.put("eleARErrortext", By.xpath("//*[contains(text(),'Enter at least one Search Criteria')]"));
		hm.put("edtAR_CityState", By.id("AccountRecipientSummary_Ext:AccountRecipientSummaryScreen:cityStateZip-inputEl"));
		hm.put("eleSpecialWording", By.id("NewAccountRecipient_ExtPopup:ApprovedSpecialWording"));
		hm.put("eleWordingCopyText", By.xpath(".//p[contains(text(),'Small Business Administration')]"));
		hm.put("edtAddlCertHolder", By.id("NewAccountRecipient_ExtPopup:AdditionalCertHolderText-inputEl"));
		hm.put("eleEditEvidencTab", By.xpath("//*[contains(@id,'EditAccountRecipient_ExtPopup:EvidenceOfPropertyTab-btnInnerEl')]"));
		hm.put("eleEditCertTypeTab", By.xpath("//*[contains(@id,'EditAccountRecipient_ExtPopup:CertificateOfInsuranceTab-btnInnerEl')]"));
		hm.put("eleReturnToAR", By.xpath(".//*[contains(text(), 'Return to Account Recipients')]"));

		// Policy Change
		hm.put("eleChangePolicy", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_ChangePolicy-textEl"));
		hm.put("lstCPEffectiveDate", By.xpath("//input[contains(@id,'ChangeDV:EffectiveDate_date-inputEl')]"));

		hm.put("lstCPDateReceived", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ReceivedDate_date-inputEl"));
		hm.put("eleCPNext", By.cssSelector("a[id='StartPolicyChange:StartPolicyChangeScreen:NewPolicyChange'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCPIssuePolicy", By.id("PolicyChangeWizard:PolicyChangeWizard_QuoteScreen:JobWizardToolbarButtonSet:BindPolicyChange-btnInnerEl"));
		hm.put("edtCPEffectiveDate", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:EffectiveDate_date-inputEl"));
		hm.put("edjCPDateReceived", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ReceivedDate_date-inputEl"));
		// Manual AMP Submission
		hm.put("eleReservePolicyNumFromCLA", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:action-btnInnerEl"));
		hm.put("eleRPNNextBtn", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:next-btnInnerEl"));
		hm.put("elePreEvaluateCompleteActivity", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:approveactivity-btnInnerEl"));
		hm.put("eleGoToLink", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:action-btnInnerEl"));
		hm.put("btnClassGuideSelectCustomerRadioBtn", By.cssSelector("input[name='segmentRBG'][value='Select Customer']"));
		hm.put("eleClassGuideSelectCustomerxpandRadioBtn", By.cssSelector("input[name='segmentRBG'][value='Priority Markets']"));
		hm.put("drpClassGuideRiskState", By.cssSelector("select[name='riskStateDDL']"));
		hm.put("btnCGSearchByClassDesc", By.cssSelector("input[name='searchSelector'][value='Radio1']"));
		hm.put("eleCGSearchBySpectrumCode", By.cssSelector("input[name='searchSelector'][value='Radio2']"));
		hm.put("eleCGSearchBySICCode", By.cssSelector("input[name='searchSelector'][value='Radio3']"));
		hm.put("eleCGSearchByISOGLCode", By.cssSelector("input[name='searchSelector'][value='Radio4']"));
		hm.put("eleCGSearchByWorkersCompCode", By.cssSelector("input[name='searchSelector'][value='Radio5']"));
		hm.put("eleCGSearchAgainBtn", By.cssSelector("input[name='backToSearchButton'][value='Search Again']"));
		hm.put("pwdCGClassDescText", By.cssSelector("input[name='classDescriptionText']"));
		hm.put("lstCGBusinessType", By.cssSelector("select[name='industryDDL']"));
		hm.put("eleCGSearchBtn", By.cssSelector("button[name='Search']"));
		hm.put("btnCGSearchBtn1", By.cssSelector("button[value='Search']"));
		hm.put("elewhatsnew", By.xpath(".//*[contains(@src,'whats_new2')]"));
		// Missing Inforamtion
		hm.put("eleMissingInformationTab", By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_MissingInfo_Ext']/div/span"));
		hm.put("eleGeneral", By.xpath(".//span[contains(text(),'Missing Information')]"));
		// R3 -hm.put("eleActivityGeneral", By.xpath(".//span[contains(text(),'Missing
		// Information')]"));
		hm.put("eleActivityGeneral", By.xpath(".//span[contains(text(),'General')]"));
		hm.put("eleGeneralASC", By.xpath(".//span[contains(text(),'ASC')]"));
		hm.put("eleActivityRemainder", By.xpath(".//span[contains(text(), 'Reminder')]"));
		hm.put("eleFollowUp", By.xpath(".//span[contains(text(), 'Follow up')]"));
		hm.put("eleActivityUnderWriterReview", By.xpath(".//span[contains(text(),'Underwriter Review')]"));
		hm.put("eleUnderWriterReviewReferToUW", By.xpath(".//span[contains(text(),'Refer to UW')]"));
		hm.put("eleCLANewActivity", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:ActivityID-textEl"));
		hm.put("lstActivityStatus", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:ActivityStatus-inputEl"));
		hm.put("eleActivityMissingInformation", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_MissingInfoButton-btnInnerEl"));
		hm.put("lstMIPolicyNumber", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:policyNumber-inputEl"));
		hm.put("lstMICorrespodence", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:Coresspondence-inputEl"));
		hm.put("lsjMICorrespodence", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:Coresspondence-inputEl"));
		hm.put("edtMIRecipientName", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:RecipientName-inputEl"));
		hm.put("eleMIRecipientName", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:RecipientName-inputEl"));
		hm.put("txtMissingInformationID", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:missingInfoID-inputEl"));
		hm.put("eleMICancel", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:cancel1-btnInnerEl"));
		hm.put("lstOriginalReceivedDate", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:date-inputEl"));
		hm.put("lsjOriginalReceivedDate", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:date-inputEl"));
		hm.put("eleOriginalReceivedDate", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:date-inputEl"));
		hm.put("eleMIFAX", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:Fax-inputEl"));
		hm.put("edtMIFAX", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:Fax-inputEl"));
		hm.put("eleOriginalReceivedDateUNEdit", By.cssSelector("div[id='MissingInformation_ExtPage:NewMissingInfoScreen:date-inputEl'][class='x-form-display-field']"));
		hm.put("lstActivityPendReason", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:PendStatus-inputEl"));
		hm.put("eleReferToUW", By.xpath(".//a[contains(text(),'Refer to UW')]"));
		hm.put("elePolicyActivityTable", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_ActivitiesLV-body"));
		hm.put("PolicyActivityTable", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_ActivitiesLV-body"));

		hm.put("eleMIAdd", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:Add-btnInnerEl"));
		hm.put("eljMIAdd", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:Add-btnInnerEl"));
		hm.put("eleMIAddReasonTable", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:2-body"));
		hm.put("lstMIReason", By.name("reasoncell"));
		hm.put("lsjMIReason", By.name("reasoncell"));
		hm.put("eleMISubmit", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:submit-btnInnerEl"));
		hm.put("eleMIMissingInformationTable", By.id("AccountFile_MissingInfo_Ext:3-body"));
		hm.put("eleMIMissingInfoID", By.id("AccountFile_MissingInfo_Ext:0:MissingInfoWO"));
		hm.put("eleMIErrorMessage", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:banner"));
		hm.put("eleMIStatus", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:Status-inputEl"));
		hm.put("eleMIMissingInformationFirstLetterSent", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:MIfirstlettersent-inputEl"));
		hm.put("eleMissingInformation", By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_MissingInfo_Ext']/div/span"));
		hm.put("eleAccountSummaryMissingInfoTable", By.id("AccountFile_Summary:AccountFile_SummaryScreen:MissingInfoLV-body"));
		hm.put("elePolicySummaryMissingInfoTable", By.id("PolicyFile_Summary:Policy_SummaryScreen:MissingInfoLV-body"));
		hm.put("eleMIPolicyNumberUnEdit", By.cssSelector("div[id='MissingInformation_ExtPage:NewMissingInfoScreen:policyNumber-inputEl'][class='x-form-display-field']"));
		hm.put("edtMIEmail", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:EmailAddress-inputEl"));
		hm.put("eleMIEmail", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:EmailAddress-inputEl"));
		hm.put("elePolicyShellSummaryMissingInfoTable", By.id("HIGPolicyFile_Summary:MissingInfoLV-body"));
		hm.put("eleMissingInfoLabel", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:ttlBar"));
		hm.put("eleNewActionMissingInfo", By.xpath(".//a[contains(text(),'New Missing Information')]"));
		hm.put("eleMISave", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:save-btnInnerEl"));
		hm.put("eleMissingInformationAssert", By.id("AccountFile_MissingInfo_Ext:ttlBar"));
		hm.put("eleMissingInformationLabel", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:ttlBar"));
		hm.put("eleMissingInfoReasonTable", By.xpath(".//span[contains(text(),'Missing Information Reason')]"));
		hm.put("edtMissingInfoID", By.xpath("//*[contains(@id,'MissingInformationID-inputEl')]"));
		hm.put("eleShellActivityTable", By.id("HIGPolicyFile_Summary:26-body"));
		hm.put("eleAddNewMissingInformation", By.id("AccountFile_MissingInfo_Ext:ToolbarButton-btnInnerEl"));
		hm.put("eleRecipientName", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:RecipientName-inputEl"));
		hm.put("eleEmailAddress", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:EmailAddress-inputEl"));
		// hm.put("eleMIUnderAction",
		// By.xpath("//span[contains(@id,'HIGPolicyFile:HIGPolicyFileMenuActions:WizardMenuActions_Goto:AccountFileMenuActions_NewMissingInfo')]"));
		hm.put("eleCreateMissingInformation", By.xpath(".//*[contains(@id,'AccountFileMenuActions_NewMissingInfo-textEl')]"));
		hm.put("eleMIEdit", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:Edit-btnInnerEl"));

		hm.put("eleMIUnderAction", By.xpath("//span[contains(@id,'AccountFileMenuActions_NewMissingInfo-textEl')]"));
		// hm.put("eleMIUnderAction",By.id("HIGPolicyFile:HIGPolicyFileMenuActions:WizardMenuActions_Goto:AccountFileMenuActions_NewMissingInfo-textEl"));
		hm.put("eleEMailID", By.id("MissingInformation_ExtPage:NewMissingInfoScreen:correspondenceInputSet:EmailAddress-bodyEl"));

		// Manage Affinity Group
		hm.put("eleICLastNamebutton", By.id("NewAffinityGroup:AffinityGroupDetailScreen:AffinityGroupDetailDV:LastName_Ext:SelectLastName_Ext"));
		hm.put("eleAffinityGrp_clkReset", By.id("SearchAffinityGroup:AffinityGroupSearchScreen:AffinityGroupSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleAuthorityCancel", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:Cancel-btnInnerEl"));
		hm.put("eleAuthorityBasics", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetail_BasicCardTab-btnInnerEl"));
		hm.put("eleAffinityGroupNamevfy", By.xpath("//label[contains(.,'Affinity Group')]//ancestor::tr[1]//following-sibling::tr[1]//table//tbody//td[2]//input"));
		hm.put("eleTrademarkvfy", By.xpath("//label[contains(.,'Affinity Group')]//ancestor::tr[1]//following-sibling::tr[2]//table//tbody//td[2]//input"));
		hm.put("eleAffinityGrpErrmsg", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:_msgs"));

		// Page Left Panel All Links
		hm.put("eleDeskTopLeftPanelLinks", By.xpath(".//*[@id='Desktop:MenuLinks-body']/div/table/tbody"));
		hm.put("eleDeskTopLeftPanelActions", By.id("Desktop:DesktopMenuActions-btnInnerEl"));
		// hm.put("eleDeskTopLeftPanelActions",
		// By.xpath(".//*[contains(@id,'MenuActions-btnInnerEl')]"));
		hm.put("eleAccountLeftPanelLinks", By.xpath(".//*[@id='AccountFile:MenuLinks']/div/table/tbody"));
		hm.put("eleAccountLeftPanelActions", By.id("AccountFile:AccountFileMenuActions-btnInnerEl"));
		hm.put("elePolicyLeftPanelLinks", By.xpath(".//*[@id='PolicyFile:MenuLinks-body']/div/table/tbody"));
		// hm.put("elePolicyLeftPanelActions",
		// By.id("PolicyFile:PolicyFileMenuActions-btnInnerEl"));
		hm.put("elePolicyLeftPanelActions", By.xpath(".//*[contains(@id,'MenuActions-btnInnerEl')]"));
		hm.put("eleAdminLeftPanelLinks", By.xpath(".//*[@id='Admin:MenuLinks-body']/div/table/tbody"));

		// Manage User
		hm.put("eleNewUser", By.id("Admin:AdminMenuActions:AdminMenuActions_Create:AdminMenuActions_NewUser-textEl"));
		hm.put("edtUser_FirstName", By.xpath(".//*[contains(@id,'Name:GlobalPersonNameInputSet:FirstName-inputEl')]"));
		hm.put("edtUser_LastName", By.xpath(".//*[contains(@id,'Name:GlobalPersonNameInputSet:LastName-inputEl')]"));
		hm.put("edtUser_UserName", By.xpath(".//*[contains(@id,'UserDetailInputSet:Username-inputEl')]"));
		hm.put("lstUser_UserType", By.xpath(".//*[contains(@id,'UserDetailDV:UserType-inputEl')]"));
		hm.put("eleUser_SkillTrack", By.xpath(".//*[contains(@id,'UserDetail_SkillTrackCardTab-btnInnerEl')]"));
		hm.put("eleUser_Attributes", By.xpath(".//*[contains(@id,'UserDetail_AttributesCardTab-btnInnerEl')]"));
		hm.put("eleUser_Access", By.xpath(".//*[contains(@id,'UserDetail_AccessCardTab-btnInnerEl')]"));
		hm.put("eleUser_Roles", By.xpath(".//*[contains(@id,'UserDetail_RolesCardTab-btnInnerEl')]"));
		hm.put("eleUser_Region", By.xpath(".//*[contains(@id,'UserDetail_RegionCardTab-btnInnerEl')]"));
		hm.put("eleUserUWAuthority", By.xpath(".//*[contains(@id,'UserDetail_AuthorityCardTab-btnInnerEl')]"));
		hm.put("eleUser_Update", By.xpath(".//*[contains(@id,'UserDetailToolbarButtonSet:Update-btnInnerEl')]"));
		hm.put("eljUser_Update", By.xpath(".//*[contains(@id,'UserDetailToolbarButtonSet:Update-btnInnerEl')]"));
		hm.put("eleUser_AddRole", By.xpath(".//*[contains(@id,'UserRolesLV_tb:Add-btnInnerEl')]"));
		hm.put("eleUser_Roletbl", By.xpath(".//*[contains(@id,'UserDetailScreen:UserRolesLV-body')]"));
		hm.put("eleUser_RoleName", By.name("RoleName"));
		hm.put("eleUser_AddSkill", By.xpath(".//*[contains(@id,'UserSkill_ExtLV_tb:Add-btnInnerEl')]"));
		hm.put("eleUser_Skilltbl", By.xpath(".//*[contains(@id,'UserDetailScreen:UserSkill_ExtLV-body')]"));
		hm.put("eleUser_RemoveSkill", By.xpath(".//*[contains(@id,'UserSkill_ExtLV_tb:Remove-btnInnerEl')]"));
		hm.put("eleUser_SkillSegment", By.name("BusinessSegment"));
		hm.put("eleUser_Skill", By.name("skills"));
		hm.put("eleUser_Tracktbl", By.xpath(".//*[contains(@id,'UserDetailScreen:UserTrack_ExtLV-body')]"));
		hm.put("eleUser_Track", By.name("tracks"));
		hm.put("eleUser_RemoveTrack", By.xpath(".//*[contains(@id,'UserTrack_ExtLV_tb:Remove-btnInnerEl')]"));
		hm.put("eleUser_RemoveRole", By.xpath(".//*[contains(@id,'UserRolesLV_tb:Remove-btnInnerEl')]"));
		hm.put("eleUser_RemoveUWAuthority", By.xpath(".//*[contains(@id,'UserAuthorityLV_tb:Remove-btnInnerEl')]"));
		hm.put("eleUser_AddTrack", By.xpath(".//*[contains(@id,'UserDetailScreen:UserTrack_ExtLV_tb:Add-btnInnerEl')]"));
		hm.put("eleUser_AddUWAuthoritytbl", By.xpath(".//*[contains(@id,'UserDetailScreen:UserAuthorityLV-body')]"));
		hm.put("eleUser_UWAuthorityName", By.name("Name"));
		hm.put("eleUser_AddUWAuthority", By.xpath(".//*[contains(@id,'UserDetailScreen:UserAuthorityLV_tb:Add-btnInnerEl')]"));
		hm.put("eleUser_EditUser", By.xpath(".//*[contains(@id,'UserDetailToolbarButtonSet:Edit-btnInnerEl')]"));
		hm.put("eleUser_Cancel", By.id("NewUser:UserDetailScreen:UserDetailToolbarButtonSet:Cancel-btnInnerEl"));
		hm.put("eleUser_UserSummary", By.id("AdminUserSearchPage:UserSearchScreen:ttlBar"));
		hm.put("lstUser_CLALterm", By.xpath(".//*[contains(@id,'logisticalTerminal_Ext-inputEl')]"));
		hm.put("edtUser_OperatorIni", By.xpath(".//*[contains(@id,'operatorInitials_Ext-inputEl')]"));
		hm.put("eleUser_AddAccess", By.xpath(".//*[contains(@id,'UserGroupsLV_tb:Add-btnInnerEl')]"));
		hm.put("eleUser_SelectAccessGrp", By.xpath(".//*[@id='OrganizationGroupTreePopup:OrganizationGroupTreePopupScreen:OrganizationGroupTreePopup:OrganizationGroupTreePopupPicker-body']//span[contains(text(),'Commercial Lines Operations')]"));
		hm.put("eleUser_RemoveAccess", By.xpath(".//*[contains(@id,'UserGroupsLV_tb:Remove-btnInnerEl')]"));
		hm.put("eleUser_Accesstbl", By.xpath(".//*[contains(@id,'AccessDV:UserGroupsLV-body')]"));
		hm.put("eleManageUsererrmsg", By.xpath(".//*[contains(@class,'message')]"));
		hm.put("lstUser_Prefix", By.xpath(".//*[contains(@id,'Name:GlobalPersonNameInputSet:Prefix-inputEl')]"));
		hm.put("edtUser_PreferredFirstName", By.xpath(".//*[contains(@id,':Name:GlobalPersonNameInputSet:PreferredFirstName-inputEl')]"));
		hm.put("eleUser_OrgAddress", By.xpath(".//*[contains(@id,'UseOrganizationAddress_false-inputEl')]"));
		hm.put("edtUser_AddressLine1", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl')]"));
		hm.put("edtUser_City", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl')]"));
		hm.put("eleUser_City", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl')]"));
		hm.put("edtUser_County", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl')]"));
		hm.put("lstUser_Country", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl')]"));
		hm.put("edtUser_Country", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl')]"));
		hm.put("lstUser_State", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl')]"));
		hm.put("edtUser_State", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl')]"));
		hm.put("edtUser_Zipcode", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("eleUser_Zipcode", By.xpath(".//*[contains(@id,'AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("lstUser_AddressType", By.xpath(".//*[contains(@id,'UserDetailDV:AddressType-inputEl')]"));
		hm.put("edtUser_AddressType", By.xpath(".//*[contains(@id,'UserDetailDV:AddressType-inputEl')]"));
		hm.put("lstUser_PrimaryPhone", By.xpath(".//*[contains(@id,'UserDetailDV:PrimaryPhone-inputEl')]"));
		hm.put("edtUser_PrimaryPhone", By.xpath(".//*[contains(@id,'UserDetailDV:PrimaryPhone-inputEl')]"));
		hm.put("edtUser_WorkPhone", By.xpath(".//*[contains(@id,'WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl')]"));
		hm.put("edtUser_Fax", By.xpath(".//*[contains(@id,'Fax:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl')]"));
		hm.put("eleUser_Fax", By.xpath(".//*[contains(@id,'Fax:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl')]"));
		hm.put("edtUser_Email", By.xpath(".//*[contains(@id,'UserDetailDV:Email-inputEl')]"));
		hm.put("eleUser_Email", By.xpath(".//*[contains(@id,'UserDetailDV:Email-inputEl')]"));
		hm.put("eleUser_Active", By.xpath(".//*[contains(@id,'UserDetailCommons:UserDetailInputSet:Active_true-inputEl')]"));
		hm.put("eleUser_UserName", By.xpath(".//*[contains(@id,'UserDetailInputSet:Username-inputEl')]"));
		hm.put("eleUserSummary_Active", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:UserDetailCommons:UserDetailInputSet:Active-inputEl"));
		hm.put("eleUserSummary_Prefix", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:UserDetailCommons:UserDetailInputSet:Name:GlobalPersonNameInputSet:Prefix-inputEl"));
		hm.put("eleUserSummary_FirstName", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:UserDetailCommons:UserDetailInputSet:Name:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("eleUserSummary_LastName", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:UserDetailCommons:UserDetailInputSet:Name:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleUserSummary_PreferredFirstName", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:UserDetailCommons:UserDetailInputSet:Name:GlobalPersonNameInputSet:PreferredFirstName-inputEl"));
		hm.put("eleUserSummary_UserType", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:UserType-inputEl"));
		hm.put("eleUserSummary_XactPay", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:accesstype-inputEl"));
		hm.put("lstUser_XactPay", By.xpath(".//*[contains(@id,'UserDetailScreen:UserDetailDV:accesstype-inputEl')]"));
		hm.put("eleUserSummary_ExternalUser", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:ExternalUser-inputEl"));
		hm.put("eleUser_ExternalFalse", By.xpath(".//*[contains(@id,'UserDetailScreen:UserDetailDV:ExternalUser_false-inputEl')]"));
		hm.put("eleUserSummary_Position", By.xpath(".//*[contains(@id,'UserDetailScreen:UserDetailDV:position_Ext-inputEl')]"));
		hm.put("edtUser_Position", By.xpath(".//*[contains(@id,'UserDetailScreen:UserDetailDV:position_Ext-inputEl')]"));
		hm.put("eleUserSummary_ProfessionalDesgn", By.id("UserDetailPage:UserDetailScreen:UserDetailDV:professionalDesignation_Ext-inputEl"));
		hm.put("edtUser_ProfessionalDesgn", By.xpath(".//*[contains(@id,'UserDetailScreen:UserDetailDV:professionalDesignation_Ext-inputEl')]"));
		hm.put("eleUser_NewSkillTrack", By.xpath(".//*[contains(@id,'UserDetailScreen:UserDetail_SkillTrackCardTab')]"));
		hm.put("eleUser_AddAttribute", By.xpath(".//*[contains(@id,'UserDetailScreen:UserAttributesLV_tb:Add-btnInnerEl')]"));
		hm.put("eleUser_AttributeTbl", By.id("UserAttributesPopup:UserAttributesPopupScreen:UserAttributesSearchLV-body"));
		hm.put("eleUser_AttributeTblSummary", By.id("UserDetailPage:UserDetailScreen:UserAttributesLV-body"));
		hm.put("eleUser_CancelButton", By.id("UserDetailPage:UserDetailScreen:UserDetailToolbarButtonSet:Cancel-btnInnerEl"));

		// Search User
		hm.put("edtUserSearch_UserName", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:Username-inputEl"));
		hm.put("eleUserSearch_Search", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleUserSearch_Reset", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleUserSearch_clkSearchResult", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchResultsLV:0:DisplayName"));
		hm.put("eleUserSearch_DeleteUser", By.id("UserDetailPage:UserDetailScreen:UserDetailToolbarButtonSet:UserDetailToolbarButtons_DeleteUserButton-btnInnerEl"));
		hm.put("eleUserSearch_DeleteUserOk", By.xpath(".//span[contains(text(),'OK')]"));
		hm.put("eleClickSearch", By.xpath("//*[contains(@id,'SearchLinksInputSet:Search')]"));

		// Assignment Administration
		hm.put("eleUSERSecurity", By.id("TabBar:AdminTab:Admin_UsersAndSecurity-textEl"));
		hm.put("eleAssignmentAdministation", By.xpath(".//*[@id='Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_AssignmentAdmin_ExtPage']/div/span"));
		hm.put("eleAAAdd", By.xpath("//*[contains(@id,'AddClassCodeButton-btnInnerEl')]"));
		// hm.put("eleAssignmentAdministrationTable",
		// By.id("AssignmentAdmin_ExtPage:1-body"));
		hm.put("eleAssignmentAdministrationTable", By.id("AssignmentAdmin_ExtPage:AssignmentAdminPanelSet:1-body"));
		hm.put("eleAssignmentAll", By.xpath(".//div[@class='x-grid-checkcolumn']"));
		hm.put("eleAAProducerCodeSearchIcon", By.xpath("//*[contains(@id,'ProducerCodeCell:SelectProducerCodeCell')]"));
		hm.put("edtAAAgencyName", By.xpath("//*[contains(@id,'ProducerCodeSearchDV:Description-inputEl')]"));
		hm.put("eleAAProducerCodeSearchButton", By.xpath("//*[contains(@id,'SearchLinksInputSet:Search')]"));
		hm.put("eleAAProducerCodeSelect", By.xpath("//*[contains(@id,'_Select')]"));
		hm.put("eleAAAssignedUserIcon", By.xpath("//*[contains(@id,'participantName_Ext:SelectparticipantName_Ext')]"));
		hm.put("edtAAUserName", By.xpath("//*[contains(@id,'Username-inputEl')]"));
		hm.put("eleAAUpdate", By.xpath("//*[contains(@id,'UpdateButton-btnInnerEl')]"));
		hm.put("eleAADelete", By.xpath("//*[contains(@id,'deleteButton_Ext-btnInnerEl')]"));
		hm.put("eleAAAssigneeRole", By.xpath("//*[contains(@id,'SelectAssignedUser')]"));
		hm.put("eleAAEditWarningAlert", By.xpath(".//*[@id='AssignmentAdmin_ExtPage:_msgs']/div"));
		hm.put("lstAssigneeRole", By.name("assigneeRole_Ext"));
		hm.put("lstAASegment", By.name("BusinessSegmentCell"));
		hm.put("lstEffectiveDate", By.name("EffectiveDateCell"));
		hm.put("eleAAEdit", By.xpath("//*[contains(@id,'EditButton-btnInnerEl')]"));
		hm.put("eleAAReset", By.xpath("//*[contains(@id,'SearchLinksInputSet:Reset')]"));
		hm.put("eleZeroResultsErrorMessage", By.xpath("//*[contains(@id,'AssignmentAdmin_ExtPage:_msgs')]"));
		hm.put("eleAABulkReassignment", By.xpath("//*[contains(@id,'BulkReassignButton-btnInnerEl')]"));
		hm.put("edtAANewAssignee", By.xpath("//*[contains(@id,'toUser-inputEl')]"));
		hm.put("eleAAAssign", By.xpath("//*[contains(@id,'AssignButton-btnInnerEl')]"));
		hm.put("eleAAProducerCode", By.xpath("//*[contains(@id,'SelectSelectedProducerCode')]"));
		hm.put("edtAAProducerCode", By.xpath("//*[contains(@id,'ParentCode-inputEl')]"));
		hm.put("eleSBACAdd", By.xpath("//*[contains(@id,'addNewSbac-btnInnerEl')]"));
		hm.put("eleSBACUWAssignment", By.xpath(".//*[@id='Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_SbacUWAssignment_Ext']/div/span"));
		hm.put("eleSBACUWAssignmentTable", By.id("SbacUWAssignment_Ext:2-body"));
		//hm.put("eleSBACUpdate", By.xpath("//*[contains(@id,'UpdateButton-btnInnerEl')]"));
		hm.put("eleSBACUpdate", By.id("SbacUWAssignment_Ext:updateButton-btnInnerEl"));
		hm.put("edtSBACUWAgentMail", By.name("AgentEmail"));
		hm.put("edtSBACUWAgentAgentFirstName", By.name("FirstName"));
		hm.put("edtSBACUWAgentAgentLastName", By.name("LastName"));
		hm.put("eleSBACEdit", By.xpath("//*[contains(@id,'editButton-btnInnerEl')]"));
		hm.put("eleCPIDParticipantAssignment", By.xpath(".//*[@id='Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_CPIDParticipant_Ext']/div/span"));
		hm.put("eleCPIDParticipantAssignmentTable", By.id("CPIDParticipant_Ext:2-body"));
		hm.put("eleCPIDUpdate", By.xpath("//*[contains(@id,'ToolbarButton-btnInnerEl')]"));
		hm.put("lstCPID", By.name("cpid"));
		hm.put("lstRO", By.name("regionalOfficeCode"));
		hm.put("lstCPIDAssigneeRole", By.name("assigneeRole"));
		hm.put("eleAACancel", By.xpath("//*[contains(@id,'Cancel-btnInnerEl')]"));
		hm.put("eleDuplicateExistErrorMsg", By.xpath("//*[contains(@id,'_Ext:_msgs')]"));
		hm.put("eleAADuplicateExistErrorMsg", By.id("AssignmentAdmin_ExtPage:_msgs"));
		hm.put("eleSBACDuplicateExistErrorMsg", By.id(""));
		hm.put("eleCPIDDuplicateExistErrorMsg", By.id(""));
		hm.put("lstSIC", By.name("SICCategory"));
		hm.put("lstRenewalReviewType", By.name("renewalReviewTypeInput_Ext"));
		hm.put("lstJobType", By.name("JobCell"));
		hm.put("eleAASelectUser", By.xpath("//*[contains(@id,'UserSearchResultsLV-body')]"));
		hm.put("eleSBACDelete", By.xpath("//*[contains(@id,'removeButton-btnInnerEl')]"));
		hm.put("eleSelectCPID", By.xpath(".//*[contains(@class,'search-trigger x-form-trigger-first') and contains(@id,'cpid:Selectcpid')]"));
		hm.put("edtCPID", By.id("CPIDSearch_ExtPopup:AffinityGroupSearchDV:CPID_Ext-inputEl"));
		hm.put("eleCPIDChoose", By.id("CPIDSearch_ExtPopup:AffinityGroupSearchResultsLV:0:_Select"));
		hm.put("eleReferFull", By.xpath("//*[contains(text(), 'Refer - Full')]"));
		hm.put("eleReferRenewal", By.xpath("//*[contains(text(), 'Refer Renewal')]"));
		hm.put("eleRenewalConfirmationMSG", By.xpath("//div[contains(text(), 'Are you sure you want to create a Renewal shell for this policy?')]"));

		// Policy Holds
		hm.put("eletblLineOfBusiness", By.xpath("//*[@id='NewPolicyHold:PolicyHoldDetailScreen:PolicyHoldDetailCV:PolicyHoldRuleLV-body']/div[1]/table/tbody"));
		hm.put("lstPolLOBval", By.name("LineofBusiness"));
		hm.put("lstPolPTTval", By.name("PolicyTransactionType"));
		hm.put("elePolLOBtbl", By.id("NewPolicyHold:PolicyHoldDetailScreen:PolicyHoldDetailCV:PolicyHoldRuleLV-body"));
		hm.put("eletitleNewPolicyHold", By.id("NewPolicyHold:PolicyHoldDetailScreen:ttlBar"));
		hm.put("lstPolTDTval", By.name("TransactionDateType"));

		// Midterm Intake Process
		hm.put("eleUnattachedDocuments", By.xpath("//*[contains(@id,'UnattachedDocumentWorkItemsLV-body')]"));
		hm.put("eleDocumentDetailsSearchIcon", By.xpath("//*[contains(@id,'SelectPolicyNumber')]"));
		hm.put("edtPolicyNumberLastSix", By.xpath("//*[contains(@id,'otherPolicyNumber-inputEl')]"));

		// Maintainence Transaction
		hm.put("edtMT_TransactionPremium", By.id("PSMaintenanceTransactionDetails_ExtPopup:transactionPremium-inputEl"));
		hm.put("eleMaintainanceTransactionsDetailsAssert", By.id("PSMaintenanceTransactionDetails_ExtPopup:ttlBar"));
		hm.put("eleMaintainanceTransactionsAssert", By.id("HIGPolicyFile_MidTermTransactions:ttlBar"));
		hm.put("eleMaintainanceTransactions", By.xpath(".//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_MidTermTransactions']/div/span"));
		hm.put("lstMT_TransactionType", By.xpath("//*[contains(@id,'transactionType-inputEl')]"));
		hm.put("lsjMT_TransactionType", By.xpath("//*[contains(@id,'transactionType-inputEl')]"));
		hm.put("edtMT_DateRecevied", By.xpath("//*[contains(@id,'dateReceived-inputEl')]"));
		hm.put("edtMT_TransactionEffective", By.xpath("//*[contains(@id,'transEffectiveDate-inputEl')]"));
		hm.put("edtMT_CompleteDate", By.xpath("//*[contains(@id,'completeDate-inputEl')]"));
		hm.put("lstMT_SourceOfSubmission", By.xpath("//*[contains(@id,'ourceOfSubmission-inputEl')]"));
		hm.put("lstMT_Type", By.xpath("//*[contains(@id,'claRefundMethod-inputEl')]"));
		hm.put("lstMT_CancelReason", By.xpath("//*[contains(@id,'ancelReason-inputEl')]"));
		hm.put("eleMT_PaymentTab", By.xpath("//*[contains(@id,'AMPPaymentTab-btnIconEl')]"));
		hm.put("edtMT_TranPremAmount", By.xpath("//*[contains(@id,'AMPTransactionPremAmount-inputEl')]"));
		hm.put("edtMT_GrossCommission", By.xpath("//*[contains(@id,'GrossCommissionPercentage-inputEl')]"));
		hm.put("edtMT_RetailAgencyCommission", By.xpath("//*[contains(@id,'RetailAgentCommPercentage-inputEl')]"));
		hm.put("eleMT_TranPremAmount", By.xpath("//*[contains(@id,'AMPTransactionPremAmount-inputEl')]"));
		hm.put("eleMT_GrossCommission", By.xpath("//*[contains(@id,'GrossCommissionPercentage-inputEl')]"));
		hm.put("eleMT_RetailAgencyCommission", By.xpath("//*[contains(@id,'RetailAgentCommPercentage-inputEl')]"));
		hm.put("edtMT_GrossCommissionVerify", By.id("HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:PSMaintTxnAMPPaymentDV:GrossCommissionPercentage-bodyEl"));
		hm.put("edtMT_RetailAgencyCommissionVerify", By.id("HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:PSMaintTxnAMPPaymentDV:RetailAgentCommPercentage-inputEl"));
		hm.put("txtMT_TransactionType", By.xpath("//*[contains(@id,':transactionDetailsDV:Type-inputEl')]"));
		hm.put("eleMT_TransactionType", By.xpath("//*[contains(@id,':transactionDetailsDV:Type-inputEl')]"));
		hm.put("eleMT_PaymentTab1", By.xpath("//*[contains(@id,'ampPaymentDetailTab-btnIconEl')]"));
		hm.put("eleMT_Table", By.id("HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0"));
		hm.put("eleMT_DeleteVerify", By.xpath("//*[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0:HIGTransactionType')]"));
		hm.put("edtMT_ChangeNarrative", By.xpath("//td//label[contains(.,'Change Narrative')]//ancestor::td[1]//following-sibling::td//textarea"));
		hm.put("eleMTBearingEndorse", By.id("HIGPolicyFile_Summary:LastEndorsementEffectiveDate-bodyEl"));
		hm.put("eleMTTotalCost", By.id("HIGPolicyFile_Summary:PolicyPerCost-bodyEl"));
		hm.put("eleMT_Canceled", By.xpath("//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPolicyStatus-btnInnerEl']/span[contains(.,'Canceled')]"));
		hm.put("eleMT_BearingEndorsement", By.xpath("//td//label[contains(.,'Is this a Premium Bearing Endorsement')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtMT_EndorsementNumber",
		// By.xpath("//td//label[contains(.,'Endorsement
		// Number')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtMT_EndorsementNumber", By.xpath("//*[contains(@id,'endorsementNumber-inputEl') and @type='text']"));
		hm.put("edtMT_AnnualPremium", By.xpath("//td//label[contains(.,'Annual Premium')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtMT_NameofRequestor", By.xpath("//td//label[contains(.,'Name of Requestor')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtMT_GrossCommission", By.xpath("//tr//td//label[contains(.,'Gross
		// Commission %')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtMT_RetailAgencyCommission",
		// By.xpath("//tr//td//label[contains(.,'Retail Agency Commission
		// %')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleMT_BearingEndorsement", By.xpath("//td//label[contains(.,'Is this a Premium Bearing Endorsement')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("elePolicyShellDoc_View", By.id("PolicyShell_Documents_Ext:PolicyShell_Documents_ExtScreen:DocumentsLV:0:DocumentsLV_ViewDoc"));
		hm.put("elePC_PolicyShellDocuments", By.xpath(".//*[@id='HIGPolicyFile:MenuLinks-body']//span[contains(text(),'Policy Shell Documents')]"));
		hm.put("eleMT_TransactionTab", By.id("PSMaintenanceTransactionDetails_ExtPopup:transactiondetailsTab-btnInnerEl"));
		hm.put("edtAuditExpDate", By.id("PSMaintenanceTransactionDetails_ExtPopup:auditExpDate-inputEl"));
		hm.put("eleCashBasisLabel", By.id("PSMaintenanceTransactionDetails_ExtPopup:cashBasis-inputEl"));
		hm.put("eleCashBasisCheckBox", By.id("PSMaintenanceTransactionDetails_ExtPopup:cashBasis-labelEl"));
		hm.put("elePremiumDeterminedAtAudit", By.id("PSMaintenanceTransactionDetails_ExtPopup:premDetermineInd-inputEl"));
		hm.put("elePremiumDeterminedAtAuditcheckbox", By.id("PSMaintenanceTransactionDetails_ExtPopup:premDetermineInd-labelEl"));
		hm.put("eleReturnMTLink", By.id("PSMaintenanceTransactionDetails_ExtPopup:__crumb__"));
		hm.put("eleMTListeClassName", By.className("x-boundlist-list-ct x-unselectable"));
		hm.put("eleMT_TranscationType", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[2]"));
		hm.put("eleMT_Endorsement", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[3]"));
		hm.put("eleMT_TransactionPremium", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[4]"));
		hm.put("eleMT_DateReceived", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[5]"));
		hm.put("eleMT_TransactionEffectiveDate", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[6]"));
		hm.put("eleMT_CompleteDate", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[7]"));
		hm.put("eleMT_TypeUnderTransaction", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:Type-inputEl')]"));
		hm.put("eleMT_SourceOfSubmission", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:SourceOfSubmission-inputEl')]"));
		hm.put("eleMT_NameOfRequestor", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:NameOfRequestor-inputEl')]"));
		hm.put("MT_TranscationType", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[2]"));
		hm.put("eleMT_CancelReason", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:CancelReason-inputEl')]"));
		hm.put("MT_TranscationType", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[2]"));
		hm.put("MT_Endorsement", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[3]"));
		hm.put("MT_TransactionPremium", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[4]"));
		hm.put("MT_DateReceived", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[5]"));
		hm.put("MT_TransactionEffectiveDate", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[6]"));
		hm.put("MT_CompleteDate", By.xpath("//div[contains(@id, 'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body')]//tr[1]/td[7]"));
		hm.put("MT_TypeUnderTransaction", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:Type-inputEl')]"));
		hm.put("MT_SourceOfSubmission", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:SourceOfSubmission-inputEl')]"));
		hm.put("MT_NameOfRequestor", By.xpath("//div[contains(@id,'HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:NameOfRequestor-inputEl')]"));
		hm.put("eleMT_TableBody", By.id("HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body"));
		hm.put("MT_TableBody", By.id("HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:0-body"));
		hm.put("edtMT_TotalAuditedCost", By.xpath("//input[contains(@id,'totalAuditedCost-inputEl')]"));
		hm.put("edtMT_AuditEffDate", By.xpath("//input[contains(@id,'auditEffDate-inputEl')]"));
		hm.put("edtEndorsementNumber_MT", By.xpath("//input[contains(@id, 'endorsementNumber-inputEl')]"));
		hm.put("lstTransactionType_MT", By.xpath("//input[contains(@id, 'transactionType-inputEl')]"));
		hm.put("edtTransactionPremium_MT", By.xpath("//input[contains(@id, 'transactionPremium-inputEl')]"));

		// Address Standardization
		hm.put("eleAccountLocAddNewLocation", By.id("AccountFile_Locations:AccountFile_LocationsScreen:AccountFile_LocationsLV_tb:AddNewLocation-btnInnerEl"));
		hm.put("eleNonSpecificLocationYES", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:NonSpecificLocation_true-inputEl"));
		hm.put("eleLoc.#", By.id("AccountFile_Locations:AccountFile_LocationsScreen:AccountFile_LocationsLV:1:Loc"));
		hm.put("eleNonSpecificLocationNo", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:NonSpecificLocation_false-inputEl"));
		hm.put("edtLocationCode", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:LocationCode-inputEl"));
		hm.put("edtLocationName", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:LocationName-inputEl"));
		hm.put("lstLocationCountry", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("edtLocationAddress1", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("lstLocationAddress1", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("lsjLocationAddress1", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edtLocationCity", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("lsjLocationState", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("lstLocationState", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleLocationState", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleLocationZipCode", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eljLocationZipCode", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edjLocationZipCode", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edtLocationZipCode", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("lsjLocationZipCode", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edtLocationPhone", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:Phone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtLocationNumberOfEmpls", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:EmployeeCount-inputEl"));
		hm.put("eleLocationNumberOfEmpls", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:EmployeeCount-inputEl"));
		hm.put("eleLocationUpdateBtn", By.cssSelector("a[id='AccountLocationPopup:LocationScreen:updateButton_Ext'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleLocationStandardizeBtn", By.id("AccountLocationPopup:LocationScreen:standardizeButton_Ext-btnInnerEl"));
		hm.put("eleLocationCancelBtn", By.id("AccountLocationPopup:LocationScreen:Cancel-btnInnerEl"));
		hm.put("eleReturntoAccountFileLocation", By.id("AccountLocationPopup:__crumb__"));
		hm.put("eleLocationInformationTitle", By.id("AccountLocationPopup:LocationScreen:ttlBar"));
		hm.put("eleLocationsQuickLaunch", By.xpath(".//span[contains(text(), 'Locations')]"));
		hm.put("eleAccountFileLocationTitle", By.id("AccountFile_Locations:AccountFile_LocationsScreen:ttlBar"));
		hm.put("eleLocationInfoMsg", By.id("AccountLocationPopup:LocationScreen:_msgs"));
		hm.put("eleLocationOverrideBtn", By.id("AccountLocationPopup:LocationScreen:overrideButton_Ext-btnInnerEl"));
		hm.put("eleAddressStdUpdate", By.xpath(".//*[contains(@id,'EditAccountScreen:updateButton_Ext-btnInnerEl')]"));
		hm.put("eleAddressStdCancel", By.xpath(".//*[contains(@id,'EditAccountScreen:Cancel-btnInnerEl')]"));

		// Account Location
		hm.put("eleLocation", By.xpath("//tr//td//div//span[contains(.,'Locations')]"));
		hm.put("eleAccAddNewLocation", By.xpath("//span//span[contains(.,'Add New Location')]")); 
		hm.put("eleAddNewLocation", By.xpath("//span//span[contains(.,'New Location')]"));
		hm.put("eleNonSpecificLocation", By.xpath("//label[contains(.,'Yes')]//preceding-sibling::input"));
		hm.put("edtLocationCode", By.xpath("//label[contains(.,'Location Code')]//ancestor::td[2]//following-sibling::td//input"));
		hm.put("edtLocationName", By.xpath("//label[contains(.,'Location Name')]//ancestor::td[2]//following-sibling::td//input"));
		// hm.put("edtLocationAddress1", By.xpath("//tr//td//label[contains(.,'Address
		// 1')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleLocationCity", By.xpath("//label[contains(.,'City')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstLocationCity", By.xpath("//label[contains(.,'City')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtLocationCounty", By.xpath("//label[contains(.,'County')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtLocationState", By.xpath("//label[contains(.,'State')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtLocationZipCode", By.xpath("//label[contains(.,'ZIP
		// Code')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleUpdateLocation", By.xpath("//span//span[contains(.,'Update')]"));
		hm.put("eleLocationChangeActiveStatus", By.xpath("//span//span[contains(.,'Change Active Status')]"));
		hm.put("eleLocationSetAsPrimary", By.xpath("//span//span[contains(.,'Set As Primary')]"));
		hm.put("eleLcoationRemoveLocations", By.xpath("//span//span[contains(.,'Remove Locations')]"));
		hm.put("eleLocationTable", By.id("AccountFile_Locations:AccountFile_LocationsScreen:AccountFile_LocationsLV-body"));
		hm.put("eleAccLocationTable", By.id("AccountFile_Locations:AccountFile_LocationsScreen:AccountFile_LocationsLV-body"));
		hm.put("eleALBannerMessage", By.id("AccountFile_Locations:AccountFile_LocationsScreen:AccntLocationMessage_Ext"));

		// Account Contacts related
		hm.put("edtAccountContactAddress1", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("lstAccountContactState", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("edtAccountContactZipCode", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("edtAccountContactFirstName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtAccountContactLastName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleAccountContactCreateNewContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton-btnWrap"));
		hm.put("eleAccountContactAdditionalInterest", By.xpath(".//span[contains(text(), 'Additional Interest')]"));
		hm.put("eleAccountContactNewPerson", By.xpath(".//span[contains(text(), 'New Person')]"));
		hm.put("eleContactsQuickLaunch", By.xpath(".//span[contains(text(), 'Contacts')]"));

		// User generated Docs for shell Policies
		// hm.put("eleDocumentsAssert",
		// By.id("AccountFile_Documents:DocumentsScreen:ttlBar"));
		hm.put("eleShellDocumentsAssert", By.id("PolicyShell_Documents_Ext:PolicyShell_Documents_ExtScreen:ttlBar"));
		// hm.put("eleDocumentTemplateSearchImg",
		// By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:TemplatePicker:SelectTemplatePicker"));
		hm.put("eleDocumentTemplateSearchImg", By.xpath(".//div[contains(@id, 'SelectTemplatePicker')]"));
		hm.put("lsjDocumentType", By.id("DocumentTemplateSearchPopup:DocumentTemplateSearchScreen:DocumentTemplateSearchDV:DocumentType-inputEl"));
		hm.put("lstDocumentState", By.id("DocumentTemplateSearchPopup:DocumentTemplateSearchScreen:DocumentTemplateSearchDV:State-inputEl"));
		hm.put("edtDocumentKeyWord", By.id("DocumentTemplateSearchPopup:DocumentTemplateSearchScreen:DocumentTemplateSearchDV:Keywords-inputEl"));
		hm.put("eleDocumentSearchBtn", By.id("DocumentTemplateSearchPopup:DocumentTemplateSearchScreen:DocumentTemplateSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleDocumentSearchResult", By.id("DocumentTemplateSearchPopup:DocumentTemplateSearchScreen:DocumentTemplateSearchResultsLV-body"));
		// hm.put("eleCreateNewdocFromTempLnk",
		// By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewDocument:AccountNewDocumentMenuItemSet:AccountNewDocumentMenuItemSet_Template-textEl"));
		// hm.put("eleNewDocumentLnk",
		// By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewDocument-textEl"));
		hm.put("eleGenerateDocumentBtn", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:CreateDocumentBundle-btnInnerEl"));
		hm.put("lsjUGD_DeliveryType", By.xpath("//tr//td//label[contains(.,'Delivery Type')]//ancestor::td[1]//following-sibling::td//input"));

		// hm.put("edtUGD_Name",
		// By.xpath("//tr//td//label[contains(.,'Name')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("lstUGD_Name",
		// By.xpath("//tr//td//label[contains(.,'Name')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtUGD_Email", By.xpath("//tr//td//label[contains(.,'Email')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtUGD_Fax", By.xpath("//tr//td//label[contains(.,'Fax')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lsjUGDCC_DeliveryType", By.xpath("//tr//td//label[contains(.,'CC Recipient')]//ancestor::tr[1]//following-sibling::tr//td//label[contains(.,'Delivery Type')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtUGDCC_Email", By.xpath("//tr//td//label[contains(.,'CC Recipient')]//ancestor::tr[1]//following-sibling::tr//td//label[contains(.,'Email')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtUGDCC_Fax", By.xpath("//tr//td//label[contains(.,'CC Recipient')]//ancestor::tr[1]//following-sibling::tr//td//label[contains(.,'Fax')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleAttachTemplate", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:NewDocumentAttachTemplate_ExtInputSet:AttachedTemplatesLV_tb:AttachTemplate"));
		hm.put("eleTempTable", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:NewDocumentAttachTemplate_ExtInputSet:AttachedTemplatesLV-body"));
		// hm.put("eleUGDSaveAsDraft",
		// By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveAsDraftButton"));
		// hm.put("eljUGDFinalise",
		// By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:FinalizeButton-btnInnerEl"));
		hm.put("eljUGDFinalise", By.xpath(".//*[contains(@id, 'NewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:FinalizeButton-btnInnerEl')]"));
		hm.put("eleUGDDocumentsTab", By.xpath("//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Documents']//div//span[contains(.,'Documents')]"));
		hm.put("eleDocumentFinalizeTable", By.id("AccountFile_Documents:DocumentsScreen:DocumentsLV-body"));
		// hm.put("DocumentFinalizeTable",
		// By.id("AccountFile_Documents:DocumentsScreen:DocumentsLV-body"));
		hm.put("DocumentFinalizeTable", By.xpath("//*[contains(@id,'DocumentsScreen:DocumentsLV-body')]"));
		hm.put("eleSaveToFileBtn", By.cssSelector("a[id='AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveToFileButton'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eljSaveToFileBtn", By.cssSelector("a[id='AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveToFileButton'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleLinkExistingDoc", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewDocument:AccountNewDocumentMenuItemSet:AccountNewDocumentMenuItemSet_Linked-textEl"));
		hm.put("eleBrowseToUploadBtn", By.name("fileContent"));
		hm.put("eleUGDDocType", By.id("DocumentDetailsPopup:DocumentDetailsScreen:DocumentDetailsDV:DocumentMetadataInputSet:MimeType-inputEl"));
		hm.put("eleUGDDocArchivalStatus", By.id("DocumentDetailsPopup:DocumentDetailsScreen:DocumentDetailsDV:DocumentMetadataInputSet:ArchivalStatus_Ext-inputEl"));
		hm.put("eleUGDSaveAsDraft", By.cssSelector("a[id='AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveAsDraftButton'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleCreateNewdocFromTempLnk", By.xpath(".//span[contains(@id, 'MenuItemSet_Template-textEl')]"));
		hm.put("eleNewDocumentLnk", By.xpath(".//span[contains(@id, 'MenuActions_NewDocument-textEl')]"));
		hm.put("eleGenerateDocumentBtn", By.xpath(".//*[contains(@id, 'CreateDocumentBundle-btnInnerEl')]"));
		hm.put("eljGenerateDocumentBtn", By.xpath(".//*[contains(@id, 'CreateDocumentBundle-btnInnerEl')]"));
		hm.put("edtUGD_Name", By.xpath(".//input[contains(@id, 'TORecipientName_Ext-inputEl')]"));
		hm.put("lsjUGD_Name", By.xpath(".//input[contains(@id, 'TORecipientNames_Ext-inputEl')]"));
		// hm.put("eleShellDocumentTable",
		// By.id("PolicyShell_Documents_Ext:PolicyShell_Documents_ExtScreen:DocumentsLV-body"));
		hm.put("eleDocumentTable", By.xpath(".//div[contains(@id, 'DocumentsLV-body')]"));
		hm.put("eleDocImg", By.xpath("//a[@id='PolicyShell_Documents_Ext:PolicyShell_Documents_ExtScreen:DocumentsLV:0:Icon']/img"));
		hm.put("eleUGD_LinkExistingDoc", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewDocument:AccountNewDocumentMenuItemSet:NewDocumentFromDragAndDrop-textEl"));
		hm.put("eleDocuments", By.xpath(".//*[text()='Documents' and @class='x-tree-node-text']"));
		hm.put("eleUGD_Cancel", By.id("NewDocumentLinkedFromDragDrop_ExtWorksheet:Cancel-btnInnerEl"));
		// hm.put("lstUGD_RecipientName",
		// By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:RecipientInformation_Ext:TORecipientInputSet_Ext:TORecipientNames_Ext-inputEl"));
		hm.put("lstUGD_RecipientName", By.xpath("//*[contains(@id, 'TORecipientInputSet_Ext:TORecipientNames_Ext-inputEl')]"));
		hm.put("eleSearchResultTitle", By.xpath("//span[contains(text(),'Search Results')]"));

		// Account Manage
		hm.put("eljAMCustVerificationBtn", By.id("AccountFile_Summary:AccountFile_SummaryScreen:custVerifiedButton_Ext"));
		hm.put("eleAMCustVerificationBtn", By.id("AccountFile_Summary:AccountFile_SummaryScreen:custVerifiedButton_Ext"));
		hm.put("eleAMDateCustVerified", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:accountStatus_Ext-inputEl"));
		hm.put("eleAMProducerCode", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV-body"));

		// Account UW Files
		hm.put("eleFirstEffectiveDate", By.xpath(".//span[contains(text(),'First Effective Date')]"));
		hm.put("eleUWFilesQuickLaunch", By.xpath(".//span[contains(text(), 'Underwriting Files')]"));
		hm.put("lstUWFilesFilterOptions", By.id("UnderwritingFiles:RenewalManagerScreen:RenewalManagerLV:jobGroupTypeFilter-inputEl"));
		hm.put("eleUWFilesTable", By.id("UnderwritingFiles:RenewalManagerScreen:RenewalManagerLV-body"));
		hm.put("UWFilesTable", By.id("UnderwritingFiles:RenewalManagerScreen:RenewalManagerLV-body"));
		hm.put("elePolicyAccountNumber", By.id("PolicyFile:PolicyFileMenuInfoBar:AccountNumber-btnEl"));
		hm.put("eleUWFile", By.id("UnderwritingFiles:RenewalManagerScreen:RenewalManagerLV:0:GroupName"));
		hm.put("eleUWActivityTab", By.id("MixedSubRenGroup_ExtDetail:activitiesTab-btnIconEl"));
		hm.put("eleUWActivityTable", By.id("MixedSubRenGroup_ExtDetail:MixedSubRenGroup_ExtScreen:DesktopActivitiesLV-body"));
		// hm.put("eleUWActivityTable",
		// By.id("MixedSubRenGroup_ExtDetail:DesktopActivitiesLV-body"));
		hm.put("eleUW_Activities", By.id("MixedSubRenGroup_ExtDetail:MixedSubRenGroup_ExtScreen:activitiesTab-btnInnerEl"));
		// hm.put("eleUW_Activities",
		// By.id("MixedSubRenGroup_ExtDetail:MixedSubRenGroup_ExtScreen:activitiesTab-btnInnerEl"));
		hm.put("edtUW_ActivityFilter", By.id("UnderwritingFiles:RenewalManagerScreen:RenewalManagerLV:jobGroupTypeFilter-inputCell"));
		hm.put("lstUW_ActivityFilter", By.id("UnderwritingFiles:RenewalManagerScreen:RenewalManagerLV:jobGroupTypeFilter"));
		hm.put("eleUW_FilesLink", By.id("MixedSubRenGroup_ExtDetail:MixedSubRenGroup_ExtDetail_UpLink"));
		hm.put("eleUWTransaction", By.id("MixedSubRenGroup_ExtDetail:MixedSubRenGroup_ExtScreen:MixedGroup_ExtJobLV:0:jobNumber"));
		// Rewrite Term
		// hm.put("eleRewriteTerm",
		// By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:RewriteTerm-textEl"));
		hm.put("eleRewriteTerm", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_NewPolTransactions:RewriteTerm-textEl"));
		hm.put("eleRewriteWarning", By.id("//span[contains(text(), 'Policy is being Rewritten')]"));
		hm.put("eleRewritePolicyNumberfLD", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicyNumberComplete-inputEl"));
		hm.put("eleRewritePolicy#", By.xpath("//*[@id='HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGPSPolicy']//span//span//span"));
		hm.put("eleRewrite New Term", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:StartRewriteMenuItemSet:RewriteNewTerm-textEl"));
		hm.put("eleActions_Rewrite", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_NewPolTransactions:RewriteTerm-itemEl"));
		hm.put("eleRewrite Full Term", By.xpath("//*[contains(text(),'Rewrite Full Term')]"));
		hm.put("eleRewrite Remainder of Term", By.xpath("//*[contains(text(),'Rewrite Remainder of Term')]"));
		hm.put("eleRNTWarningMsg", By.xpath("//*[contains(text(),'New period end date does not match end date of previous period. [ExpiryDateMismatch].')]"));

		// CLA Customer Completion Letter
		hm.put("elePC_CustomerCompletionletter", By.xpath(".//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_CustomerCompletionLetter']//span[contains(text(),'Customer Completion Letter')]"));
		hm.put("elePC_SaveDraft", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:saveButton-btnInnerEl"));
		hm.put("elePCVerifyErrorMessages", By.xpath(".//*[@class='message']"));
		hm.put("lstPC_TransactionType", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:transType-inputEl"));
		hm.put("eleCustomerCompltrYes", By.id("//*[contains(@id,'CCLetterIndicator_true-inputEl')])"));
		hm.put("eleCustomerCompltrNo", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:PSCustCompLetterTransInputSet:CCLetterIndicator_false-inputEl"));
		// hm.put("lstPC_DeliveryMethod",
		// By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:PSCustCompLetterTransInputSet:deliveryMethod-inputEl"));
		hm.put("lstPC_DeliveryMethod", By.xpath("//*[contains(@id,'deliveryMethod-inputEl')]"));
		hm.put("elePC_DeliveryMethod", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:PSCustCompLetterTransInputSet:deliveryMethod-inputEl"));
		hm.put("elePC_AttachDocuments", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:PSCustCompLetterTransInputSet:CompletionLetterAttachDocs_ExtInputSet:AttachedTemplatesLV_tb:AttachDocuments-btnInnerEl"));
		hm.put("elePC_Submit", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:submitLetter-btnInnerEl"));
		hm.put("elePC_CustomerCompletionltr", By.id("HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:ttlBar"));
		hm.put("elePolicyTransactionType", By.id("HIGPolicyFile_MidTermTransactions:MaintenanceTransactionLDV:transactionDetailsDV:Type-inputEl"));
		// hm.put("edtCustomerCompEmailAddress",
		// By.id("PolicyChangeWizard:PolicyChangeWizard_CompletionLetterScreen:CustomerCompletionLetterInputSet:CCLDeliveryEmail-inputEl"));
		hm.put("elePolicyChangeAssert", By.cssSelector("div[id='HIGPolicyFile_CustomerCompletionLetter:PSCustomerCompletionLetterScreen:transType-inputEl'][class='x-form-display-field']"));
		hm.put("edtCustomerCompEmailAddress", By.xpath("//input[contains(@id,'CCLDeliveryEmail')]"));
		hm.put("eleCustomerCompletionLetter", By.xpath("//span[contains(text(),'Customer Completion Letter')]"));
		hm.put("eleCustomerCompletion_YES", By.xpath("//td//label[contains(.,'Customer')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'Yes')]"));
		hm.put("eleCustomerCompletion_NO", By.xpath("//td//label[contains(.,'Customer')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'No')]"));

		// AMPBilling
		hm.put("eleCLAAMPBindOptions", By.xpath("//span[contains(.,'Issue Policy')]"));
		hm.put("lstNewSubmission", By.xpath("//div//a//span[contains(.,'New Submission')]"));
		hm.put("eleBillingCompany", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PSAMPPoliciesOnlyInputSet:AMPBillingCompany:SelectAMPBillingCompany"));
		hm.put("sclBillingCompany", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PSAMPPoliciesOnlyInputSet:AMPBillingCompany:SelectAMPBillingCompany"));
		hm.put("eleBillingCompanySearch", By.id("PS_AMPSearchBillingCompanyPopup:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleBillingCompanySelect", By.xpath("//*[@id='PS_AMPSearchBillingCompanyPopup:AMPBillingCompanyResultsLV-body']//table//tbody//tr[1]//td[1]//div//a[contains(.,'Select')]"));
		hm.put("lstAMPBillingMethod", By.xpath("//tr//td//label[contains(.,'Billing Method')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lsjAMPBillingMethod", By.xpath("//tr//td//label[contains(.,'Billing Method')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstAMPBillingNumber", By.xpath("//tr//td//label[contains(.,'Billing Number')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lsjAMPBillingNumber", By.xpath("//tr//td//label[contains(.,'Billing Number')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtAMPBillingNumber",
		// By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:enterBillingNumber-inputEl"));
		hm.put("edtAMPBillingNumber", By.xpath("//*[contains(@id,'PSBillingAdjustment_ExtDV:enterBillingNumber-inputEl')]"));
		// hm.put("lstAMPInstallmentPlan",
		// By.xpath("//tr//td//label[contains(.,'Installment
		// Plan')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtPolicyFee", By.xpath("//tr//td//label[contains(.,'Policy Fee')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtFilingFee", By.xpath("//tr//td//label[contains(.,'Filing
		// Fee')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtInspectionFee", By.xpath("//tr//td//label[contains(.,'Inspection
		// Fee')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtStampingFee", By.xpath("//tr//td//label[contains(.,'Stamping
		// Fee')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtPolicyTax", By.xpath("//tr//td//label[contains(.,'Policy
		// Tax')]//ancestor::td[1]//following-sibling::td//input"));
		// hm.put("edtAmpFee", By.xpath("//tr//td//label[contains(.,'AMP
		// Fee')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtWCAssessment", By.xpath("//tr//td//label[contains(.,'WC Assessment')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtWCExpenseConstant", By.xpath("//tr//td//label[contains(.,'WC Expense Constant')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtTotalPremium", By.xpath("//tr//td//label[contains(.,'Total Premium')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleTotalPremium", By.xpath("//tr//td//label[contains(.,'Total Premium')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleMailToProducer", By.xpath("//tr//td//label[contains(.,'Mail to Producer')]//ancestor::td[1]//following-sibling::td//tr//td[2]//label[contains(.,'Yes')]//preceding-sibling::input"));
		// hm.put("edtGrossCommission", By.xpath("//tr//td//label[contains(.,'Gross
		// Commission %')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtGrossCommission", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:GrossCommissionPercentage-inputEl"));
		hm.put("edtRetailAgencyCommission", By.xpath("//tr//td//label[contains(.,'Retail Agency Commission %')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("elePolicyInfoTab", By.xpath("//*[@id='HIGPolicyFile:HIGPolicyFileAcceleratedMenuActions:HIGJobAcceleratedMenuItemSet:PSPolicyMenuItemSet_PolicyInfo']//span[contains(.,'Policy Info')]"));
		hm.put("eleMaintenenceTab", By.xpath("//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_MidTermTransactions']/div/span[contains(.,'Maintenance Transactions')]"));
		hm.put("lstTransactionType", By.xpath("//label[contains(.,'Transaction Type')]//ancestor::td[1]//following-sibling::td//td[1]//input"));
		hm.put("lstSourceofSubmission", By.xpath("//label[contains(.,'Source of Submission')]//ancestor::td[1]//following-sibling::td//td[1]//input"));
		hm.put("edtTotalAuditedCost", By.xpath("//label[contains(.,'Total Audited Cost')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtAuditEffectDate", By.xpath("//label[contains(.,'Audit Effective Date')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtAuditExpireDate", By.xpath("//label[contains(.,'Audit Expiration Date')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleMTGrossCommission", By.xpath("//*[@id='HIGPolicyFile_Summary:PSAMPPoliciesOnlyInputSet:GrossCommissionPercentage-bodyEl']"));
		hm.put("eleMTRetailAgencyCommission", By.xpath("//*[@id='HIGPolicyFile_Summary:PSAMPPoliciesOnlyInputSet:RetailAgentCommPercentage-bodyEl']"));
		hm.put("lstAMPInstallmentPlan", By.xpath("//*[contains(@id,'psBillingInstallmentPlan-inputEl')]"));
		hm.put("edtFilingFee", By.xpath("//*[contains(@id,'FillingFee-inputEl')]"));
		hm.put("edtInspectionFee", By.xpath("//*[contains(@id,'InspectionFee-inputEl')]"));
		hm.put("edtStampingFee", By.xpath("//*[contains(@id,'StampingFee-inputEl')]"));
		hm.put("edtPolicyTax", By.xpath("//*[contains(@id,'PolicyTax-inputEl')]"));
		hm.put("edtAmpFee", By.xpath("//*[contains(@id,'AMPFee-inputEl')]"));
		hm.put("edtTransPremiumAmt", By.xpath("//*[contains(@id,'AMPTransactionPremAmount-inputEl')]"));
		hm.put("edjPolicyInfo_BOREnd", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:BOREndDate-inputCell"));
		hm.put("clrPolicyInfo_BOREnd", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:BOREndDate-inputCell"));
		hm.put("eleProducerCode_ErrMsg", By.xpath("//*[contains(text(), 'Producer Code is not ')]"));

		// Guided Workflow
		hm.put("eleGWSaveDraft", By.xpath("//span[contains(@id,'save-btnInnerEl')]"));
		hm.put("eleGuidedWorkFlowTab", By.xpath(".//*[contains(@id, 'guidedWorkflowsTab-btnInnerEl')]"));
		hm.put("eleGuidedWorkflow", By.xpath(".//*[contains(@id, 'PSJob_Step_ExtScreen:ttlBar')]"));
		hm.put("eleCancelPolicy", By.xpath(".//*[contains(@id, 'CancellationID-textEl')]"));
		hm.put("lstGWSource", By.xpath(".//*[contains(@id, 'Source-inputEl')]"));
		hm.put("lstGWSourceofSubmission", By.xpath(".//*[contains(@id, 'SourceofSubmission-inputEl')]"));
		hm.put("edtGWDateReceived", By.xpath(".//*[contains(@id, 'DateReceived_date-inputEl')]"));
		hm.put("lstGWReason", By.xpath(".//*[contains(@id, 'ReasonCode-inputEl')]"));
		hm.put("lstGWAuditPeriod", By.xpath(".//*[contains(@id, 'AuditPeriod-inputEl')]"));
		hm.put("lstGWRefundMethod", By.xpath(".//*[contains(@id, 'RefundMethod-inputEl')]"));
		hm.put("eleGWAccepatbleEvidence", By.xpath(".//*[contains(@id, 'IsAcceptableEvidence_true-inputEl')]"));
		hm.put("eleGWCancellationQuestions", By.xpath(".//*[contains(@id, 'QuestionSetLV-body')]"));
		hm.put("lstGWEvidenceType", By.xpath(".//*[contains(@id, 'EvidenceType-inputEl')]"));
		hm.put("edtNameOfRequestor", By.xpath("//input[contains(@id,'NameOfRequestor-inputEl')]"));
		hm.put("eleGWCLASummary", By.xpath(".//*[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:ttlBar']"));
		hm.put("eleGWOPERINIT", By.xpath(".//*[contains(@id, 'OperInIt-inputEl')]"));
		hm.put("edtGWOPERINIT", By.xpath(".//*[contains(@id, 'OperInIt-inputEl')]"));
		hm.put("eleGWCancelSummary", By.xpath(".//*[contains(@id, 'PSJob_ExtWizard:PSJob_Summary_ExtScreen:0')]"));
		hm.put("eleGWShortRateWarning", By.xpath(".//*[contains(@id, 'shortRatePenaltyVerbatim')]"));
		hm.put("eleGWCloseOptions", By.xpath(".//*[contains(@id, 'CloseOptions-btnWrap')]"));
		hm.put("eleGWWithDrawTransaction", By.xpath(".//*[contains(@id, 'WithdrawJob-textEl')]"));
		hm.put("eleGWWarning1", By.xpath(".//*[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']/div[2]"));
		hm.put("eleGWWarning2", By.xpath(".//*[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']/div[3]"));
		hm.put("eleGWWarning3", By.xpath(".//*[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']/div[4]"));
		hm.put("eleGWRewrite", By.xpath(".//*[contains(@id, 'Rewrite-inputEl')]"));
		hm.put("edtGWCancellationEffectiveDate", By.xpath(".//*[contains(@id, 'CancelEffDate_date-inputEl')]"));
		hm.put("eleGWAccepatbleEvidenceNo", By.xpath(".//*[contains(@id, 'IsAcceptableEvidence_false-inputEl')]"));
		hm.put("eleGWWarningMessages", By.xpath(".//*[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']/div"));
		hm.put("eleGuidedWorkFlowTable", By.id("HIGPolicyFile_MidTermTransactions:guidedWorkflowsTab:panelId"));
		hm.put("eleGuidedWorkFlowInfoBar", By.id("PSJob_ExtWizard:PSJob_ExtInfoBar:jobType-btnInnerEl"));

		// Test Data
		hm.put("lstPI_TermType", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:TermType-inputEl"));
		hm.put("eleLOBtbl", By.id("PSPolicyTerm_Ext_Info:LineOfBusinessLV-body"));
		hm.put("lstLOSval", By.name("LevelofSupport"));
		hm.put("lstLOBval", By.name("LineofBusiness"));
		hm.put("eleCLAPIAdd", By.id("PSPolicyTerm_Ext_Info:LineOfBusinessLV_tb:Add-btnInnerEl"));
		hm.put("edtAcc_ProducerCode", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Code-inputEl"));
		hm.put("edtPI_ExpirationDate", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGExpirationDateID-inputEl"));
		hm.put("eleExposureStateColumn", By.xpath(".//a[contains(text(), '<none>')]"));
		hm.put("dblExposureState", By.xpath("//li[contains(text(),'Connecticut')]"));
		hm.put("eleExposureStateArrow", By.id("button-1491-btnIconEl"));
		hm.put("eleCommonSave", By.xpath(".//span[contains(text(), 'Save')]"));
		hm.put("edtSelectProducer", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBContactInformation_ExtScreen:producerName-inputEl"));
		hm.put("eleSelectAcc", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGAccountNumber-btnInnerEl"));
		hm.put("eleinlandMarine", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:MMQPBWizardStepSet:QPBLOBDetail_ExtScreen:ttlBar"));

		// Policy Shell Participants
		hm.put("eleParticipants", By.xpath("//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Roles']/div"));
		hm.put("eleEdit", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:PSJobParticipants_ExtCV:PSJobParticipants_ExtPanelSet:TransactionRolesLV_tb:Edit-btnInnerEl"));
		hm.put("eleUpdParticipantsate", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:PSJobParticipants_ExtCV:PSJobParticipants_ExtPanelSet:TransactionRolesLV_tb:Update-btnInnerEl"));
		// hm.put("eleAdd",
		// By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:PSJobParticipants_ExtCV:PSJobParticipants_ExtPanelSet:TransactionRolesLV_tb:Add-btnInnerEl"));
		hm.put("eleAdd", By.xpath(".//*[contains(@id, 'Add-btnInnerEl')]"));
		hm.put("tblParticipants", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:PSJobParticipants_ExtCV:PSJobParticipants_ExtPanelSet:TransactionRolesLV-body"));
		hm.put("eleSelectUser", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:PSJobParticipants_ExtCV:PSJobParticipants_ExtPanelSet:TransactionRolesLV:1:AssignedUser:UserBrowseMenuItem"));
		hm.put("edtEnterUserID", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchDV:Username-inputEl"));
		hm.put("eleSearchPartUser", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSearchPartUserSelect", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchResultsLV:0:_Select"));
		hm.put("lstAssignmentRole", By.name("AssignmentRole"));
		hm.put("lstAssignedGroup", By.name("AssignedGroup"));
		hm.put("eleParticipentsErrorMessages", By.xpath(".//*[@id='HIGPolicyFile_Roles:PSJob_RoleScreen:_msgs']/div"));
		hm.put("eleParticipentsTitle", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:ttlBar"));
		hm.put("eleParticipentsRemove", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:PSJobParticipants_ExtCV:PSJobParticipants_ExtPanelSet:TransactionRolesLV_tb:Remove-btnInnerEl"));

		// Producer Code
		hm.put("eleAdministrationMenu", By.id("TabBar:AdminTab-btnInnerEl"));
		hm.put("edtAdminPCAgencyName", By.id("AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:Description-inputEl"));
		/*
		 * hm.put("eleAdminPCSearch", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"
		 * )); hm.put("eleAdminPCSearchResults", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:AdminProducerCodeSearchLV:0:Code"
		 * )); hm.put("eleAdminPCReset", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"
		 * )); hm.put("edtAdminPCMasterPC", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:ParentCode-inputEl"
		 * )); hm.put("edtAdminPCProducerCode", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:Code-inputEl"
		 * )); hm.put("edtAdminPCLocationPhone", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:locationPhone_Ext-inputEl"
		 * )); hm.put("eleAdminPCErrorMessage",
		 * By.id("AdminProducerCodeSearch:AdminProducerCodeSearchScreen:_msgs"));
		 * hm.put("edtAdminPCZipCode", By.id(
		 * "AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ProducerCodeSearchDV:AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"
		 * ));
		 */
		hm.put("eleAdminPCSearch", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search')]"));
		hm.put("eleAdminPCSearchResults", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:AdminProducerCodeSearchLV-body')]"));
		//hm.put("eleAdminPCSearchResults", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:AdminProducerCodeSearchLV-body:0:_Select')]"));
		//AdminProducerCodeSearchPopup:AdminProducerCodeSearchScreen:AdminProducerCodeSearchLV:0:_Select
		hm.put("eleAdminPCReset", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset')]"));
		hm.put("edtAdminPCMasterPC", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:ProducerCodeSearchDV:ParentCode-inputEl')]"));
		hm.put("edtAdminPCProducerCode", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:ProducerCodeSearchDV:Code-inputEl')]"));
		hm.put("edtAdminPCLocationPhone", By.xpath("//*[contains(@id,'AdminProducerCodeSearchScreen:ProducerCodeSearchDV:locationPhone_Ext-inputEl')]"));
		hm.put("eleAdminPCErrorMessage", By.id("AdminProducerCodeSearch:AdminProducerCodeSearchScreen:_msgs"));
		hm.put("edtAdminPCZipCode", By.xpath("//*[contains(@id,'GlobalAddressInputSet:PostalCode-inputEl')]"));
		hm.put("edtAccProducerCode", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:ProducerCode_Ext-inputEl"));
		hm.put("eleAccProducerName", By.id("CreateAccount:CreateAccountScreen:CreateAccountDV:ProducerSelectionInputSet:AgencyName_Ext-inputEl"));
		hm.put("edtMasterProducerCode", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:ParentCode-inputEl"));
		hm.put("edtProducerCode", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Code-inputEl"));
		hm.put("edtPCAgencyName", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Description-inputEl"));
		hm.put("elePCSearch", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eljPCSearch", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("elePCSelectSearchResults", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchLV:0:_Select"));
		hm.put("elePCReset", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eljPCReset", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("elePCSearchResultsTable", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchLV-body"));
		hm.put("elePolicyInfoErrorMessage", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:_msgs"));
		hm.put("elePolicyInfoPage", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:ttlBar"));
		hm.put("eleAdminPCPaging", By.id("AdminProducerCodeSearch:AdminProducerCodeSearchScreen:AdminProducerCodeSearchLV:_ListPaging"));
		hm.put("eleAdminProducerCodePage", By.id("AdminProducerCodeSearch:AdminProducerCodeSearchScreen:ttlBar"));
		hm.put("elePolicyInfonPCSearch", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerCode_Ext:SelectProducerCode_Ext"));
		hm.put("elePolicyInfonPCShellPCSearch", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext:SelectProducerCode_Ext"));
		hm.put("elePCShellPolicyInfoErrorMessage", By.id("WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs"));

		// New Named Insured
		hm.put("edtRelationInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:AdditionalNamedInsuredInfoDV:Relationship-inputEl"));
		hm.put("edtAddInsCompanyName", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("edtPhoneInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtFaxInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtAddressInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("lstCityInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("edtCountryInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("lstStateInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("lsjZipCodeInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("lstAddressTypeInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:AddressType-inputEl"));
		hm.put("edtFEINInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("eleStandInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:standardizeButton_Ext-btnInnerEl"));
		hm.put("eleOKInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleSearchIndustryCodeInsured", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:AdditionalNamedInsuredInfoDV:IndustryCode:SelectIndustryCode"));
		hm.put("eleAddInsAddDBA", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton-btnInnerEl"));
		hm.put("eleAddInsNewCompany", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton:0:ContactType-textEl"));
		hm.put("eleAddInsDBAAddedTable", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV-body"));
		hm.put("eleInsuredAllRemove", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:Remove-btnInnerEl']//following::div[@class='x-grid-checkcolumn']"));
		hm.put("eleAddInsDBARemove", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:Remove-btnInnerEl"));
		hm.put("eleExistingInsured", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:ChangePrimaryNamedInsuredButton:OtherExistingContact-textEl"));
		// Address Change in Policy Info
		hm.put("eleChangeTo", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:ChangePrimaryNamedInsuredButton-inputEl']/following::img[1]"));
		hm.put("eleChangeAddress", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:ChangePolicyAddressButton:ChangePolicyAddressButtonMenuIcon"));
		hm.put("eleEditAddress", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:ChangePolicyAddressButton:EditPolicyAddressMenuItem-textEl"));
		hm.put("lstAddresstypeIns", By.id("EditPolicyAddressPopup:PolicyAddressInputSet:AddressType-inputEl"));
		hm.put("eleStandAddress", By.id("EditPolicyAddressPopup:standardizeButton_Ext-btnInnerEl"));		
		hm.put("lstSegmentIns", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:Segment-inputEl"));
		/*
		 * //Additional Insured Extension hm.put("eleAddInsAddDBA", By.id(
		 * "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton-btnInnerEl"
		 * )); hm.put("eleAddInsNewCompany", By.id(
		 * "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton:0:ContactType-textEl"
		 * )); hm.put("eleAddInsRemoveDBA", By.id(
		 * "EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"
		 * )); hm.put("eleAddInsNewNamedInsuredPage",
		 * By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:ttlBar"));
		 * hm.put("edtAddInsCompanyName", By.id(
		 * "NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl"
		 * )); hm.put("eleAddInsSameAddAs", By.id(
		 * "NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"
		 * )); hm.put("eleAddInsSameAddAsType", By.id(
		 * "NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"
		 * )); hm.put("eleAddInsSameAddAsAddress", By.id(
		 * "NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"
		 * )); hm.put("eleAddInsOK", By.id(
		 * "NewAdditionalNamedInsuredPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"
		 * )); hm.put("eleAddInsDBAAddedTable", By.id(
		 * "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV-body"
		 * )); hm.put("eleAddInsSelDBA", By.xpath(
		 * ".//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV-body']/div/table/tbody/tr/td/div"
		 * )); hm.put("eleAddInsDBARemove", By.id(
		 * "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:Remove-btnInnerEl"
		 * )); hm.put("elePriNamedInsSelDBASetPrimary", By.xpath(
		 * ".//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:listOfDBAs:PolicyDBAsDV:NamedInsuredInputSet:DBAListLV-body']/div/table/tbody/tr/td/div"
		 * )); hm.put("elePriNamedInsDBASetPrimary", By.id(
		 * "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:listOfDBAs:PolicyDBAsDV:NamedInsuredInputSet:DBAListLV_tb:setToPrimary-btnInnerEl"
		 * )); hm.put("eleAccDBAs", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:DBACardTab-btnInnerEl"
		 * )); hm.put("eleAccAddDBA", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV_tb:addContactButton-btnInnerEl"
		 * )); hm.put("eleAccDBANewCompany", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV_tb:addContactButton:0:0:contactType-textEl"
		 * )); hm.put("edtAccDBAName", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"
		 * )); hm.put("eleAccNewDBARoleTab", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:RolesCardTab-btnInnerEl"
		 * )); hm.put("eleAccNewAddDBARole", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton-btnInnerEl"
		 * )); hm.put("eleAccNewAddDBARoleNamedInsured", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton:13:RoleType-itemEl"
		 * )); hm.put("eleAccNewAddDBARoleTable", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV-body"
		 * )); hm.put("eleAccNewAddDBARoleRemove", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV_tb:Remove-btnInnerEl"
		 * )); hm.put("eleAccDBAUpdate",
		 * By.id("NewDBAContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		 * hm.put("eleAccAddDBATable", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV-body"
		 * )); hm.put("eleAccRemoveDBA", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"
		 * )); // hm.put("eleAccountNumber",
		 * By.id("SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl"));
		 * hm.put("eleAccountNumber",
		 * By.xpath("//*[contains(@id, 'AccountNumber-btnInnerEl')]"));
		 * hm.put("eleAccCreateNewContact", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton-btnInnerEl"
		 * )); hm.put("eleAccNamedInsured", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:12:roleType-textEl"
		 * )); hm.put("eleAccNamedInsNewCompany", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:12:roleType:0:contactType-textEl"
		 * )); hm.put("edtAccNamedInsNewCompanyName", By.id(
		 * "NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"
		 * )); hm.put("eleAccNamedInsameAddAs", By.id(
		 * "NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"
		 * )); hm.put("eleAccNamedInsSameAddAsType", By.id(
		 * "NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"
		 * )); hm.put("eleAccNamedInsSameAddAsAddress", By.id(
		 * "NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"
		 * )); hm.put("eleAccNamedInsUpdate", By.id(
		 * "NewAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		 * hm.put("eleAccNamedInsTable", By.id(
		 * "AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body"));
		 * hm.put("eleAccNamedInsDBATab", By.id(
		 * "EditAccountContactPopup:ContactDetailScreen:AccountContactCV:DBACardTab-btnInnerEl"
		 * )); hm.put("eleAccNamedInsAddDBA", By.id(
		 * "EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:addContactButton-btnInnerEl"
		 * )); hm.put("eleAccNewNamedInsNewCompany", By.id(
		 * "EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:addContactButton:0:0:contactType-textEl"
		 * )); hm.put("eleAccNamedInsDBATable", By.id(
		 * "EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV-body"
		 * )); hm.put("eleAccNamedInsDBARemove", By.id(
		 * "EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"
		 * )); hm.put("edtAccNamedInsNewDBAName", By.id(
		 * "NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"
		 * )); hm.put("eleAccNamedInsNewDBAOK",
		 * By.id("NewDBAContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		 */


		// PolicySummary
		hm.put("elePolicyInfo", By.xpath("//span[text() = 'Policy Info' and @class = 'x-tree-node-text ']"));

		// CLAPolicySummary
		hm.put("eleCLAPolicyInfo", By.id("PolicyFile:PolicyFileAcceleratedMenuActions:PolicyMenuItemSet:PolicyMenuItemSet_PolicyInfo"));
		hm.put("eleCLAPolicyFile", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:WizardMenuActions_Goto:ToPolicyFile-textEl"));
		hm.put("eleCLAAccountName", By.id("HIGPolicyFile_Summary:AccountName-inputEl"));
		hm.put("elepolicySummary_CompletedTransactionTble", By.id("HIGPolicyFile_Summary:PSPolicy_Summary_TransactionsLV-body"));
		hm.put("eleBillingMetod_TransTble", By.xpath("//*[contains(@class,'miniButton') and contains(@id,'HIGPolicyFile_Summary:PSPolicy_Summary_TransactionsLV:0:BillingMethod')]"));
		hm.put("eleCLAPolicyEdit", By.id("PSPolicyTerm_Ext_Info:ToolbarButton-btnInnerEl"));
		hm.put("CLAInstallmentPlan", By.id("HIGPolicyFile_Summary:BillingInformationDV:InstallmentPlan-inputEl"));
		hm.put("CLATotalCost", By.id("HIGPolicyFile_Summary:PolicyPerCost-inputEl"));
		hm.put("CLAFEIN", By.id("HIGPolicyFile_Summary:fein-inputEl"));
		hm.put("CLABillingCompany", By.id("HIGPolicyFile_Summary:PSAMPPoliciesOnlyInputSet:AMPBillingCompany-labelEl"));
		hm.put("CLAAccountName", By.id("HIGPolicyFile_Summary:AccountName-inputEl"));
		hm.put("CLATotalCost", By.id("HIGPolicyFile_Summary:PolicyPerCost-inputEl"));
		hm.put("PCSUMBillingMethod", By.id("HIGPolicyFile_Summary:BillingInformationDV:BillingMethod-inputEl"));

		// Group
		hm.put("eleAdministration", By.id("TabBar:AdminTab-btnInnerEl"));
		hm.put("eleNewGroup", By.id("Admin:AdminMenuActions:AdminMenuActions_Create:AdminMenuActions_NewGroup-textEl"));
		hm.put("edtGroupName", By.id("NewGroup:GroupDetailScreen:GroupDetailDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("lstType", By.id("NewGroup:GroupDetailScreen:GroupDetailDV:Type-inputEl"));
		hm.put("lstSecZone", By.id("NewGroup:GroupDetailScreen:GroupDetailDV:GroupDetailInputSet:SecurityZone-inputEl"));
		hm.put("eleUpdateGroup", By.id("NewGroup:GroupDetailScreen:Update-btnInnerEl"));
		// hm.put("edtGroupInfoRecordTable",
		// By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:GroupNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		// hm.put("eleUserName",
		// By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:Username-inputEl"));
		hm.put("edtSearchGroupName", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:GroupNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleSearchGroupBtn", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSuperUser", By.id("AdminUserSearchPage:UserSearchScreen:UserSearchResultsLV:2:DisplayName"));
		hm.put("eleCancelGroup", By.id("NewGroup:GroupDetailScreen:Cancel-btnInnerEl"));

		// RenewalPolicy
		hm.put("elePreRenewal", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:PreRenewalID-textEl"));
		hm.put("elePreRenewalEdit", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:Edit-btnInnerEl"));
		hm.put("lstPreRenewalDirection", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirection-inputEl"));
		hm.put("lsjPreRenewalDirection", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirection-inputEl"));
		hm.put("edtPreRenewalDirection", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirection-inputEl"));
		hm.put("edtPreRenewalText", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:Text-inputEl"));
		hm.put("elePreRenewalUpdate", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:Update-btnInnerEl"));
		hm.put("elePreRenewalDelete", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirectionScreen_DeleteButton-btnInnerEl"));
		hm.put("eleRenewalHistoryTable", By.id("HIGPolicyFile_History:PSJob_HistoryScreen:HistoryScreenResultsLV"));
		hm.put("eleHistory", By.xpath(".//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_History']/div/span"));
		hm.put("elePreRenewalView", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirectionScreen_ViewNotesButton-btnInnerEl"));
		hm.put("elePreRenewalTopic", By.id("x-form-el-PSPreRenewalNotesPage:PolicyShell_Notes_ExtScreen:NotesLV:0:NoteRowSet:Topic"));
		// hm.put("eleRenewPolicy",
		// By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_NewPolTransactions:PolicyFileMenuActions_RenewPolicy"));

		hm.put("eleRenewPolicy", By.xpath("//*[contains(text(),'Renew Policy')]"));
		// r3 hm.put("eleRenewPolicy",
		// By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_NewPolTransactions:PolicyFileMenuActions_RenewPolicy-textEl"));
		hm.put("eleRenewShell", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_NewPolTransactions:PolicyFileMenuActions_RenewPolicy:RenewSORShell_ExtMenuItemSet:renewShell"));
		hm.put("eleProCodeLabel", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:ProducerCode_Ext-labelEl"));
		hm.put("eleProductLabel", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:Product-labelEl"));
		hm.put("eleEffDateLabel", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGEffectiveDateID-labelEl"));
		hm.put("eleBusSegLabel", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusSegmentID-labelEl"));
		hm.put("eleSummaryPreRenewalLabel", By.id("HIGPolicyFile_Summary:12"));
		hm.put("eleSummaryPreRenewalClick", By.id("HIGPolicyFile_Summary:PreRenewalDirection-inputEl"));
		hm.put("eleSelectAccount", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGAccountNumber"));
		hm.put("eleCloseOptionNonRenew", By.id("PSPolicyTerm_Ext_Info:CloseOptions:NonRenewJob-textEl"));
		hm.put("eleRenewalWarning", By.id("PSPolicyTerm_Ext_Info:NonRenewAlert"));
		hm.put("eleCloseOptionNotTaken", By.id("PSPolicyTerm_Ext_Info:CloseOptions:NotTakenJob-itemEl"));
		hm.put("eleNextYearYes", By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:PursueNextYear_true-inputEl"));
		hm.put("lstSuccessfulCarrier", By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:SuccessfulCarrier-inputEl"));
		hm.put("edtSuccessfulPremium", By.id("PSNotTakenReasonExtPopup:RejectScreen:PSRejectReasonExtDV:SuccessfulPremium-inputEl"));
		hm.put("elePreRenewalRemoved", By.xpath("//div[contains(text(), 'Pre Renewal Direction was Removed')]"));

		// Policy Shell Contacts
		hm.put("eleShellContactsLink", By.xpath("//*[@id='HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Contacts']/div"));
		hm.put("eleShellCreateNewContact", By.id("HIGPolicyFile_Contacts:AddNewToolbarButton"));
		hm.put("eleShellExistingContact", By.id("HIGPolicyFile_Contacts:AddexistingToolbarButton"));
		hm.put("eleShellAgentContact", By.xpath("//span[contains(text(), 'Agency Contact')]"));
		hm.put("eleShellBillingContact", By.xpath("//span[contains(text(), 'BillingContact')]"));
		hm.put("eleShellNewPerson", By.xpath("//span[contains(text(), 'New Person')]"));
		hm.put("eleShellRoleTab", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:RolesCardTab"));
		hm.put("eleShellAddRole", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:ContactRolesDV:ContactRolesLV_tb:AddRoleButton"));
		hm.put("eleShellRoleMenu", By.cssSelector(".x-panel.x-layer.x-panel-default.x-menu.x-border-box:not([style*='hidden']"));
		hm.put("eleShellExistingRoleMenu", By.cssSelector(".x-panel.x-layer.x-panel-default.x-menu.x-border-box:not([style*='hidden']"));
		hm.put("eleShellRoleTable", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:ContactRolesDV:ContactRolesLV-body"));
		hm.put("edtShellFirstName", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtShellLastName", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("edtShellAddress1", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("eleShellCity", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("zedShellCity", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("lstShellState", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleShellZipCode", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("zedShellZipCode", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleShellUpdate", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:Update"));
		hm.put("eleSummaryContacts", By.id("HIGPolicyFile_Contacts:ttlBar"));
		hm.put("eleBillingContact_List", By.xpath("//span[contains(text(), 'Billing Contact')]"));
		hm.put("eleShellSecContact", By.xpath("//span[contains(text(),'Secondary Contact - SrcExisting PolicyShellContact')]"));
		hm.put("eleAddExistingContact", By.id("HIGPolicyFile_Contacts:AddexistingToolbarButton-btnInnerEl"));
		hm.put("lstPrimaryphone", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:PrimaryPhone-inputEl"));
		hm.put("edtWorkPhone", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtFaxPhone", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtPrimaryEmail", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("edtSecondaryEmail", By.id("HIGNewPolicyFileContactPopup:ContactDetailScreen:AccountContactDV:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("eleFirstName", By.id("HIGPolicyFile_Contacts:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("eleLastName", By.id("HIGPolicyFile_Contacts:AccountContactDV:ContactNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("eleWorkPhone", By.id("HIGPolicyFile_Contacts:AccountContactDV:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));

		// Billing Contact
		hm.put("elePayBillingContactLink", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:ChangeBillingContactButton:ChangeBillingContactButtonMenuIcon"));
		hm.put("elePayNewPerson", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:ChangeBillingContactButton:1:contactType-textEl"));
		hm.put("edtPayFirstName", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtPayLastName", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("lstPayPrimaryPhone", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:PrimaryPhone-inputEl"));
		hm.put("elePayHomePhone", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:HomePhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtPayHomePhone", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:HomePhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("elePayFaxPhone", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("edtPayFaxPhone", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("elePayPrimaryEmail", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress1-inputEl"));
		hm.put("edtPayPrimaryEmail", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress1-inputEl"));
		hm.put("elePaySecryEmail", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress2-inputEl"));
		hm.put("edtPaySecryEmail", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress2-inputEl"));
		hm.put("elePayAddresslink", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
		hm.put("elePayAddress1link", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
		hm.put("elePayAddress2link", By.id("NewBillingContactPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
		hm.put("elePayOK", By.id("NewBillingContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("elePayStandardize", By.id("NewBillingContactPopup:ContactDetailScreen:standardizeButton_Ext-btnInnerEl"));
		hm.put("elePhonePref", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:PrimaryPhone-inputEl"));
		hm.put("eleHomePhone", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:HomePhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("eleFaxPhone", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:FaxPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("elePrimaryEmail", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress1-inputEl"));
		hm.put("eleSecondaryEmail", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress2-inputEl"));
		hm.put("eleContactCountry", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("eleContactAddress1", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("eleContactCity", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("eleContactCounty", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("eleContactState", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleContactZip", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("elePolicy_Contacttbl", By.id("PolicyFile_Contacts:Policy_ContactsScreen:Policy_ContactsLV-body"));

		// Cancel Policy
		hm.put("eleSORCancelPolicy", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_CancelPolicy-textEl"));
		hm.put("lstCan_Source", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:Source-inputEl"));
		hm.put("lstCan_Subsource", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:SubmissionSourceCancel-inputEl"));
		hm.put("edtCan_DateReceived", By.xpath("//*[contains(@id,'ReceivedDate_date-inputEl')]"));
		hm.put("lstCan_Reason", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:Reason-inputEl"));
		hm.put("edtCan_Reasondesc", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:ReasonDescription-inputEl"));
		hm.put("lstCan_RefundMethod", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:CalcMethod-inputEl"));
		// hm.put("edtCan_CanEffDate",By.xpath("//*[contains(@id,'ReceivedDate_date-inputEl')]"));
		hm.put("eleCan_SaveDraft", By.xpath(".//span[contains(@id, 'Draft-btnInnerEl')]"));

		hm.put("edjCan_CanEffDate", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:CancelDate_date-inputEl"));

		hm.put("eleCan_StartCancel", By.id("StartCancellation:StartCancellationScreen:NewCancellation-btnInnerEl"));
		hm.put("eleCan_EntryScreen", By.id("CancellationWizard:CancellationWizard_EntryScreen:ttlBar"));
		hm.put("eleCan_OdenYES", By.id(""));
		hm.put("eleCan_Validate", By.id("CancellationWizard:CancellationWizard_EntryScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		hm.put("eljCan_Validate", By.id("CancellationWizard:CancellationWizard_EntryScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		hm.put("eleCan_Confirmation", By.id("CancellationWizard:CancellationWizard_QuoteScreen:ttlBar"));
		hm.put("bliCan_BindOption", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions-btnInnerEl"));
		hm.put("eleCan_PopupOK", By.id("button-1005-btnInnerEl"));
		hm.put("eleCan_PolNumclk", By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
		hm.put("elwAccountAddress", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress"));
		hm.put("elwAddClass", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV_tb:Add-btnInnerEl"));
		hm.put("lsjSalesAgreementCode", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:SalesAgreementCode-inputEl"));
		hm.put("lsjOrganisationType", By.xpath("//input[contains(@id,'AccountInfoInputSet:OrganizationType-inputEl')]"));
		hm.put("lsjProductType", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ProductType-inputEl"));
		hm.put("lsjSubmissionSource", By.xpath(".//*[contains(@id,'SubmissionSource-inputEl')]"));
		hm.put("eleCan_AcceptableEvidence_No", By.xpath("//input[contains(@id,'CancelPolicyDV:IsAcceptableEvidence_false-inputEl')]"));
		hm.put("eleCan_AcceptableEvidence_Yes", By.xpath("//input[contains(@id,'CancelPolicyDV:IsAcceptableEvidence_true-inputEl')]"));
		hm.put("lstCan_EvidenceType", By.id("StartCancellation:StartCancellationScreen:CancelPolicyDV:AcceptableEvidence-inputEl"));

		// StartCancellation:StartCancellationScreen:CancelPolicyDV:IsAcceptableEvidence_false-inputEl
		// Lien Holder Contact
		hm.put("eleOfficePhone", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:WorkPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		//hm.put("elePayPremiumFinck", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:premiumfinanceindicator_Ext-inputEl"));
		hm.put("elePayPremiumFinck", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:premiumfinanceindicator_Ext-inputEl')]"));
		//hm.put("edtPayAgreementnum", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:agreementnumber-inputEl"));
		hm.put("edtPayAgreementnum", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:agreementnumber-inputEl')]"));
		hm.put("elePayName", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinanciername-inputEl')]"));
		hm.put("edtPayName", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinanciername-inputEl')]"));
		hm.put("elePayAddress", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancieraddress-inputEl')]"));
		hm.put("edtPayAddress", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancieraddress-inputEl')]"));
		hm.put("elePayCity", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinanciercity-inputEl')]"));
		hm.put("edtPayCity", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinanciercity-inputEl')]"));
		hm.put("lstPayState", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancierstate-inputEl')]"));
		hm.put("elePayZipCode", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancierzip-inputEl')]"));
		hm.put("edtPayZipCode", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancierzip-inputEl')]"));
		hm.put("elePolicyTran_LeftPane", By.xpath(".//span[contains(text(), 'Policy Transactions')]"));
		hm.put("eleViewPolicyTran", By.id("PolicyFile_Jobs:Policy_JobsScreen:DetailPanel:Policy_JobInfoDV:JobFile-inputEl"));
		hm.put("elePolicyPayment_LeftPane", By.xpath(".//span[contains(text(), 'Payment')]"));
		hm.put("eleLien_AddressLine1", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancieraddress-inputEl')]"));
		hm.put("eleLien_CityName", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinanciercity-inputEl')]"));
		hm.put("eleLien_State_Abbr", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancierstate-inputEl')]"));
		hm.put("eleLien_ZIPCODE", By.xpath("//*[contains(@id,'PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:premiumfinancedetails:premiumfinancierzip-inputEl')]"));
		hm.put("eleAcc_CustomerVer", By.id("AccountFile_Summary:AccountFile_SummaryScreen:custVerifiedButton_Ext-btnInnerEl"));
		hm.put("elePCOfficePhone", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:WorkPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("edtPCOfficePhone", By.id("EditAccountPopup:EditAccountScreen:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		hm.put("elePCFaxPhone", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:FaxPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("elePCPrimaryEmail", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress1-inputEl"));
		hm.put("elePCSecondaryEmail", By.id("PolicyFile_Contacts:Policy_ContactsScreen:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:EmailAddress2-inputEl"));
		hm.put("bliBusinessGrouping", By.id("NewActivityPattern:ActivityPatternDetailScreen:BusinessGroupingLV_tb:AddGrouping-btnWrap"));
		hm.put("tblAP_SegmentCode", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:BusinessGroupingLV-body"));
		hm.put("eleCan_ODENQues", By.id("CancellationWizard:CancellationWizard_EntryScreen:QuestionSetsDV:0:QuestionSetLV-body"));
		hm.put("elePolTrantbl", By.id("PolicyFile_Jobs:Policy_JobsScreen:DetailPanel:JobsLV-body"));
		hm.put("eleSORReinstate", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_ReinstatePolicy-textEl"));
		hm.put("lstRein_Reason", By.id("ReinstatementWizard:ReinstatementWizard_ReinstatePolicyScreen:ReinstatePolicyDV:ReasonCode-inputEl"));
		hm.put("edtReason_Desc", By.id("ReinstatementWizard:ReinstatementWizard_ReinstatePolicyScreen:ReinstatePolicyDV:ReasonDescription-inputEl"));
		hm.put("eleRein_Ques", By.id("ReinstatementWizard:ReinstatementWizard_ReinstatePolicyScreen:ReinstateQuestions:QuestionSetsDV:0:QuestionSetLV-body"));
		hm.put("eleRein_Quote", By.id("ReinstatementWizard:ReinstatementWizard_ReinstatePolicyScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		hm.put("eleRein_Quotettl", By.id("ReinstatementWizard:ReinstatementWizard_QuoteScreen:ttlBar"));
		hm.put("eleRein_Policy", By.id("ReinstatementWizard:ReinstatementWizard_QuoteScreen:JobWizardToolbarButtonSet:Reinstate-btnInnerEl"));
		hm.put("eleSORRewritePolicy", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:StartRewriteMenuItemSet:RewriteFullTerm-textEl"));
		hm.put("lstRewriteAs", By.id("RewriteWizard:LOBWizardStepGroup:RewriteWizard_PolicyInfoScreen:RewriteWizard_PolicyInfoDV:PolicyInfoInputSet:RewriteAs-inputEl"));
		hm.put("lstRewrite_Subsource", By.id("RewriteWizard:LOBWizardStepGroup:RewriteWizard_PolicyInfoScreen:RewriteWizard_PolicyInfoDV:PolicyInfoInputSet:SubmissionSource-inputEl"));
		hm.put("eleRewriteQuote", By.id("RewriteWizard:LOBWizardStepGroup:RewriteWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		hm.put("eleRewriteQuotettl", By.id("RewriteWizard:RewriteWizard_QuoteScreen:ttlBar"));
		hm.put("eleRewriteIssue", By.id("RewriteWizard:RewriteWizard_QuoteScreen:JobWizardToolbarButtonSet:BindRewrite-btnInnerEl"));

		// History
		hm.put("eleNaviToHistory", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_History"));
		hm.put("eleHistoryTable", By.xpath("//div[@id='AccountFile_History:1']//span[@class='x-column-header-text']"));
		hm.put("eleHistory_SelectUser", By.id("AccountFile_History:HistoryScreenDV:user:UserBrowseMenuItem"));
		hm.put("eleHistory_UserText", By.xpath("//div[@class='x-grid-view x-fit-item x-grid-view-default']/table"));
		hm.put("edtHistory_FirstName", By.id("UserSearchPopup:UserSearchPopupScreen:UserSearchDV:ContactInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("lstHistory_RelatedTo", By.id("AccountFile_History:HistoryScreenDV:relatedto-inputEl"));
		hm.put("eleHistory_Search", By.id("AccountFile_History:HistoryScreenDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleHistory_RelatedToDropdown", By.xpath("//table[@id='AccountFile_History:HistoryScreenDV:relatedto-triggerWrap']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']"));
		hm.put("eleHistory_RelatedToList", By.cssSelector(".x-list-plain>li"));

		// unattached doucment
		hm.put("eleUnattachDocScreenTitle", By.xpath("//*[contains(@id,':UnattachedDocumentsScreen:ttlBar')]"));
		hm.put("eleUnattachedDocTable", By.id("DesktopUnattachedDocumentsPage:UnattachedDocumentsScreen:UnattachedDocumentWorkItemsLV-body"));
		hm.put("eleDocumentDtlsTitle", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:ttlBar"));
		hm.put("eleAssociateAndGetNext", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:AssociateAndGNU-btnInnerEl"));
		hm.put("eleGetNextUrgentDoc", By.id("DesktopUnattachedDocumentsPage:UnattachedDocumentsScreen:WorkOnHandDocumentLV_tb:GetNextUrgencyDoc-btnInnerEl"));
		hm.put("btnEmail/Fax", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:EmailOfFax-btnInnerEl"));
		hm.put("eleEmail/FaxTitle", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:ttlBar"));
		hm.put("lstDeliveryMethod", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:deliveryMethod-inputEl"));
		hm.put("edtEmail", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:CCLDeliveryEmail-inputEl"));
		hm.put("edtFax", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:CCLDeliveryFax-inputEl"));
		hm.put("edtEmailOrFaxText", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:EmailFaxText-inputEl"));
		hm.put("btnSend", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:EmailOfFax"));
		hm.put("btnCancel", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:CancelButton"));
		hm.put("lstSource", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:Source-inputEl"));
		hm.put("eleDocumentName", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:DocumentName-inputEl"));
		// hm.put("eleAdd",
		// By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:Add-btnInnerEl"));
		hm.put("eleSetprimary", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:setToPrimary-btnInnerEl"));
		hm.put("eleCheck", By.xpath("//span[contains(text(), 'Document Intake Trans Type')]/following::div[7]"));

		hm.put("btnResearch", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:Research-btnInnerEl"));
		hm.put("btnDelete", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:DeleteDoc-btnInnerEl"));
		hm.put("eleUnAttachedMessage", By.id("DesktopUnattachedDocumentsPage:UnattachedDocumentsScreen:message"));
		hm.put("clrEmail", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:CCLDeliveryEmail-inputEl"));
		hm.put("clrFax", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:CCLDeliveryFax-inputEl"));
		hm.put("clrEmailOrFaxText", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:EmailFaxText-inputEl"));
		hm.put("eljSend", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:EmailOfFax"));
		hm.put("eljCancel", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:CancelButton"));
		hm.put("edtDocIntakeTab", By.className("x-form-field x-form-text x-form-focus x-field-form-focus x-field-default-form-focus"));
		hm.put("elePolicyPickerUnattached", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:PolicyNumber:SelectPolicyNumber"));
		hm.put("edtPolicySearchUnattached", By.id("UnattachedSearchPolicy_ExtPopup:UnattachedPolicySearchScreen:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:policyNumber-inputEl"));
		hm.put("eleSearchBtnUnattached", By.id("UnattachedSearchPolicy_ExtPopup:UnattachedPolicySearchScreen:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSelectPolicyUnattached", By.id("UnattachedSearchPolicy_ExtPopup:UnattachedPolicySearchScreen:PolicySearchScreen:DatabasePolicySearchPanelSet:PolicySearch_ResultsLV:0:_Select"));
		hm.put("lstMissingInfoUnattached", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:missingInfoID-inputEl"));
		hm.put("eleCancelUnattached", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:CancelButton-btnInnerEl"));
		hm.put("eleUpdateUnattached", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:Update-btnInnerEl"));
		hm.put("btnEdit", By.id("UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:Edit-btnInnerEl"));
		hm.put("eleUnattachedDocsTitle", By.id("DesktopUnattachedDocumentsPage:UnattachedDocumentsScreen:ttlBar"));
		hm.put("eleSend", By.id("UnattachedDocumentsEmailFaxDetail:UnattachedDocumentsEmailFaxDetailScreen:EmailOfFax"));

		// DocumentInfo
		hm.put("eleDocument", By.xpath(".//td[contains(@id, 'Documents')]/div/span"));
		hm.put("eleDocIcon", By.xpath(".//*[contains(@id, 'DocumentsLV:0:Icon')]"));
		hm.put("eleEditDocument", By.id("EditDocumentFromTemplate_ExtPopup:EditTemplateDocument_ExtDV:EditDocumentBundle-btnInnerEl"));
		hm.put("edtMAIL", By.id("EditDocumentFromTemplate_ExtPopup:EditTemplateDocument_ExtDV:RecipientInformation_Ext:TORecipientInputSet_Ext:DeliveryPreferenceTO_Ext:TOEmail_Ext-inputEl"));
		hm.put("eleFinalize", By.id("EditDocumentFromTemplate_ExtPopup:FinalizeButton-btnInnerEl"));
		hm.put("eleShellNewDoc", By.xpath(".//*[@id='HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:CreateDocument-textEl']"));
		hm.put("eleDocReset", By.xpath(".//*[contains(@id, 'SearchLinksInputSet:Reset')]"));
		hm.put("eleDeleteDocument", By.xpath(".//*[contains(@id, 'DeleteDocumentButton-btnInnerEl')]"));
		hm.put("elePolSaveDraft", By.cssSelector("a[id='NewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveAsDraftButton'][class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("eleViewButton", By.xpath("//a[@id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:DocumentsLV_ViewDoc']"));
		hm.put("eleCheckIn", By.xpath("//a[@id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:CheckInDocument']"));
		hm.put("eleCheckOut", By.xpath("//a[@id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:CheckOutDocument']"));
		hm.put("eleDiscardButton", By.xpath("//a[@id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:DiscardDocument']"));
		hm.put("eleView_DocButton", By.xpath("//a[@id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:DocumentsLV_ViewDoc']"));
		/*
		 * hm.put("eleDownload_DocButton", By.xpath(
		 * "//a[@id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:OpenDocument']"
		 * )); hm.put("eleCheckOut_Disabled", By.
		 * xpath("//span[@class='miniButton' and @id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:CheckOutDocument']"
		 * )); hm.put("eleCheckIn_Disabled", By.
		 * xpath("//span[@class='miniButton' and @id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:CheckInDocument']"
		 * )); hm.put("eleDiscard_Disabled", By.
		 * xpath("//span[@class='miniButton' and @id='AccountFile_Documents:DocumentsScreen:DocumentsLV:0:DiscardDocument']"
		 * )); hm.put("eleEdit_DocScreen",
		 * By.id("DocumentDetailsPopup:DocumentDetailsScreen:Edit-btnInnerEl"));
		 * hm.put("eleCheckIn_CheckInScreen",
		 * By.id("DocumentCheckIn_ExtPopup:ToolbarButton-btnInnerEl"));
		 * hm.put("eleBrowseDoc", By.xpath("//a[contains(@id,'fileuploadfield')]"));
		 */
		hm.put("eleViewButton", By.xpath("//a[contains(@id,'DocumentsLV:0:DocumentsLV_ViewDoc')]"));
		hm.put("eleCheckIn", By.xpath("//a[contains(@id,'DocumentsLV:0:CheckInDocument')]"));
		hm.put("eleCheckOut", By.xpath("//a[contains(@id,'DocumentsLV:0:CheckOutDocument')]"));
		hm.put("eleDiscardButton", By.xpath("//a[contains(@id,'DocumentsLV:0:DiscardDocument')]"));
		hm.put("eleView_DocButton", By.xpath("//a[contains(@id,'DocumentsLV:0:DocumentsLV_ViewDoc')]"));
		hm.put("eleDownload_DocButton", By.xpath("//a[contains(@id,'DocumentsLV:0:OpenDocument')]"));
		hm.put("eleCheckOut_Disabled", By.xpath("//span[@class='miniButton' and contains(@id,'DocumentsLV:0:CheckOutDocument')]"));
		hm.put("eleCheckIn_Disabled", By.xpath("//span[@class='miniButton' and contains(@id,'DocumentsLV:0:CheckInDocument')]"));
		hm.put("eleDiscard_Disabled", By.xpath("//span[@class='miniButton' and contains(@id,'DocumentsLV:0:DiscardDocument']"));
		hm.put("eleEdit_DocScreen", By.id("DocumentDetailsPopup:DocumentDetailsScreen:Edit-btnInnerEl"));
		hm.put("eleCheckIn_CheckInScreen", By.id("DocumentCheckIn_ExtPopup:ToolbarButton-btnInnerEl"));
		hm.put("eleBrowseDoc", By.xpath("//a[contains(@id,'fileuploadfield')]"));
		hm.put("edtDocumentName", By.xpath("//*[contains(@id,'DocumentsScreen:DocumentSearchDV:Name-inputEl')]"));
		hm.put("eleDocuments_Document", By.xpath(".//*[contains(text(), 'Quote Proposal for Intl Tool')]"));
		hm.put("eleDocuments_PolDocument", By.id("PolicyShell_Documents_Ext:PolicyShell_Documents_ExtScreen:DocumentsLV:0:Icon"));
		hm.put("eleDocIntakeTable", By.xpath("//div[@id='UnattachedDocumentsDetail:UnattachedDocumentsDetailScreen:4-body']"));
		hm.put("lstIntakeTransType", By.name("DocIntakeTransType"));
		hm.put("eleDocdetails", By.id("AccountFile_Documents:DocumentsScreen:DocumentsLV:0:Name"));
		hm.put("elePolShellDocdetails", By.id("PolicyShell_Documents_Ext:PolicyShell_Documents_ExtScreen:DocumentsLV:0:Name"));
		hm.put("eleReturnPolShellDoc", By.id("DocumentDetailsPopup:__crumb__"));
		hm.put("eleTableCheck", By.xpath("//img[contains(@class,'x-grid-checkcolumn')]"));
		hm.put("eleDocuments_Button", By.xpath("//*[contains(text(),'Documents')]"));
		hm.put("eleHiddenDocYes", By.id("AccountFile_Documents:DocumentsScreen:DocumentSearchDV:IncludeObsoletes_true-inputEl"));
		hm.put("eleHiddenDocNo", By.id("AccountFile_Documents:DocumentsScreen:DocumentSearchDV:IncludeObsoletes_false-inputEl"));
		hm.put("eleDocUnhide", By.id("AccountFile_Documents:DocumentsScreen:DocumentsLV_tb:PolicyFile_Documents_DeobsolesceButton-btnInnerEl"));
		hm.put("eleDocHide", By.id("AccountFile_Documents:DocumentsScreen:DocumentsLV_tb:PolicyFile_Documents_ObsolesceButton-btnInnerEl"));
		hm.put("eleTransType", By.xpath("//span[contains(text(),'Transaction type')]"));
		hm.put("eleEffDate", By.xpath("//span[contains(text(),'Effective Date')]"));
		hm.put("eleRecipient", By.xpath("//span[contains(text(),'Recipient')]"));

		// Participants Screen
		hm.put("eleParticipantTransTab", By.id("HIGPolicyFile_Roles:PSJob_RoleScreen:transactionLevelParticipantsCVTab-btnWrap"));
		hm.put("elePatAdd", By.xpath("//*[contains(@id,':ParticipantsScreen:JobRolesLV:2:AssignedUser:UserBrowseMenuItem')]"));
		hm.put("elePatSelect", By.xpath("//*[contains(@id,':ParticipantsScreen:JobRolesLV:2:AssignedUser:UserBrowseMenuItem')]"));
		hm.put("elePatUser", By.xpath("//*[contains(@id,':UserSearchPopupScreen:UserSearchDV:Username-inputEl')]"));
		hm.put("elePatSearch", By.xpath("//*[contains(@id,':UserSearchPopupScreen:UserSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search')]"));
		hm.put("elePatSelectUser", By.xpath("//*[contains(@id,':UserSearchPopupScreen:UserSearchResultsLV:0:_Select')]"));
		hm.put("elePatAssRole", By.xpath("//*[contains(@class,'x-grid-cell x-grid-td x-grid-cell-headerId-gridcolumn-2151 g-cell-edit x-grid-cell-selected')]"));
		hm.put("elePatUser", By.xpath("//*[contains(@id,':UserSearchPopupScreen:UserSearchDV:Username-inputEl')]"));
		// class="x-grid-cell-inner "

		// *[contains(@id,'gridview-2155-record-ext-record-1189')/ts[3]/div]

		// *[contains(@class,'x-grid-cell x-grid-td x-grid-cell-headerId-gridcolumn-2152
		// g-cell-edit')]

		// Account Participants
		hm.put("eleAccParticipants", By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Roles']/div/span"));
		hm.put("eleDisableEdit", By.xpath(".//span[contains(text(), 'Edit')]"));

		// Tool Participants
		hm.put("eleDisableAdd", By.xpath(".//span[contains(text(), 'Add')]"));
		hm.put("eleDisableRemove", By.xpath(".//span[contains(text(), 'Remove')]"));
		hm.put("eleSorParticipants", By.xpath(".//*[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Participants']/div/span"));
		hm.put("eleParticipantsTab", By.xpath(".//span[contains(text(), 'Participants')]"));
		hm.put("eleSubmissionParticipants", By.xpath("//td[contains(@id,'Participants') or contains(@id, 'HIGPolicyFile_Roles')]/div"));
		hm.put("lstParticipantAssigneeRole", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ParticipantsScreen:JobRolesLV:1:AssignedUser:UserBrowseMenuItem"));
		hm.put("lstParticipantAssigneeRole", By.name("AssignmentRole"));
		hm.put("lstParticipantAssignedGroup", By.name("AssignedGroup"));
		// hm.put("lstRenewalReviewType",By.name("renewalReviewTypeInput_Ext"));
		// hm.put("eleParticipantTable",
		// By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ParticipantsScreen:JobRolesLV-body"));
		hm.put("eleParticipantTable", By.xpath("//*[contains(@id, ':JobRolesLV-body') or contains(@id, 'ParticipantsLV-body') or contains(@id, ':PSPolicyRolesLV-body')]"));
		// hm.put("eljParticipantSaveDraft",
		// By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ParticipantsScreen:JobRolesLV_tb:Draft-btnInnerEl"));
		hm.put("eljParticipantSaveDraft", By.xpath("//*[contains(@id,':ParticipantsScreen:JobRolesLV_tb:Draft-btnInnerEl')]"));
		hm.put("eljRemoveParticipant", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ParticipantsScreen:JobRolesLV_tb:Remove-btnInnerEl"));

		// BBT
		hm.put("eleNewActivitytitle", By.id("NewActivityWorksheet:NewActivityScreen:ttlBar"));
		hm.put("eleBBPTGuideWorkFlowTitle", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:ttlBar"));
		hm.put("eleBBPTErrorMsg", By.xpath("//div[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']/div[@class='message']"));

		// AMP Policy
		hm.put("elePolicyInfo_RO", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:RegionalOffice-inputEl"));
		hm.put("edtPolicyInfo_PolicyNumber", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicyNumberComplete-inputEl"));
		hm.put("edtCLAPolicySymbol", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicySymbol-inputEl"));
		hm.put("eleCLAQuotePresented", By.id("PSPolicyTerm_Ext_Info:BindOptions:QuotePresented-textEl"));
		hm.put("eleCLAQuoteSuccessful", By.id("PSPolicyTerm_Ext_Info:BindOptions:QuoteSuccessful-textEl"));
		hm.put("edtPolicyInfo_PrimaryInsuredName", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:Name-inputEl"));
		hm.put("edtPolicyInfo_AddressLine1", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:HIGNamedInsured:HIGNamedInsuredInputSet:Address1-inputEl"));
		hm.put("edtCLABusinessGrouping", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusinessGrouping-inputEl"));
		hm.put("edtCLASegment", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:BusSegmentID-inputEl"));
		hm.put("lstAMPPolicyInfo_SubmissionSource", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:SubmissionSource-inputEl"));
		hm.put("edtNPNMiddleInitial", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:ProducerSelectionInputSet:NPNMiddleInitial-inputEl"));
		hm.put("edtMTCompleteDate", By.id("PSMaintenanceTransactionDetails_ExtPopup:completeDate-inputEl"));
		hm.put("lstMT_ActionRequiredRenewal", By.id("PSMaintenanceTransactionDetails_ExtPopup:actionOnRenewal-inputEl"));
		hm.put("edtPolicyInfo_MSI", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:MSIID-inputEl"));
		hm.put("eleRA_Edit", By.id("HIGPolicyFile_RiskAnalysis_Ext:Edit-btnInnerEl"));
		hm.put("lstRA_BestIndex", By.id("HIGPolicyFile_RiskAnalysis_Ext:bestIndex-inputEl"));
		hm.put("lstRA_ComplexityScore", By.id("HIGPolicyFile_RiskAnalysis_Ext:complexityScore-inputEl"));
		hm.put("eleRA_Update", By.id("HIGPolicyFile_RiskAnalysis_Ext:Update-btnInnerEl"));
		hm.put("lsjPayment_BillingMethod", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:psBillingMethod-inputEl"));
		hm.put("lsjPayment_BillingNumber", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:PSBillingnumber-inputEl"));

		// hm.put("lstPayment_InstallmentPlan",
		// By.xpath("//*[contains(@id,'PSBillingAdjustment_ExtDV:psBillingInstallmentPlan-inputEl')]"));
		hm.put("lstPayment_InstallmentPlan", By.id("PSBillingAdjustment_ExtPopup:PSBillingAdjustment_ExtDV:psBillingInstallmentPlan-inputEl"));

		hm.put("lstPayment_FinalAudit", By.id("HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:FinalAudit-inputEl"));
		hm.put("edtPayment_PolicyFee", By.xpath("//*[contains(@id,':PolicyFee-inputEl')]"));
		hm.put("edtPayment_FilingFee", By.xpath("//*[contains(@id,':FillingFee-inputEl')]"));
		hm.put("edtPayment_InspectionFee", By.xpath("//*[contains(@id,':InspectionFee-inputEl')]"));
		hm.put("edtPayment_StampingFee", By.xpath("//*[contains(@id,':StampingFee-inputEl')]"));
		hm.put("edtPayment_PolicyTax", By.xpath("//*[contains(@id,':PolicyTax-inputEl')]"));
		hm.put("edtPayment_AMPFee", By.xpath("//*[contains(@id,':AMPFee-inputEl')]"));
		hm.put("edtPayment_WCAssessment", By.xpath("//*[contains(@id,':WCAssessment-inputEl')]"));
		hm.put("edtPayment_WCExpenseConstant", By.xpath("//*[contains(@id,':WCExpenseConstant-inputEl')]"));
		hm.put("edtPayment_TotalPremium", By.xpath("//*[contains(@id,':TotalPremiums-inputEl')]"));
		hm.put("elePayment_PolicyFee", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:PolicyFee-inputEl"));
		hm.put("elePayment_FilingFee", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:FillingFee-inputEl"));
		hm.put("elePayment_InspectionFee", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:InspectionFee-inputEl"));
		hm.put("elePayment_StampingFee", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:StampingFee-inputEl"));
		hm.put("elePayment_PolicyTax", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:PolicyTax-inputEl"));
		hm.put("elePayment_AMPFee", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:AMPFee-inputEl"));
		hm.put("elePayment_WCAssessment", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:WCAssessment-inputEl"));
		hm.put("elePayment_WCExpenseConstant", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:WCExpenseConstant-inputEl"));
		hm.put("elePayment_TotalPremium", By.xpath("//*[contains(@id,':TotalPremiums-inputEl')]"));
		hm.put("elePayment_MailProducer", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:MailToProducer_false-inputEl"));
		hm.put("edtPayment_GrossCommission", By.xpath("//*[contains(@id,':GrossCommissionPercentage-inputEl')]"));
		hm.put("elePayment_GrossCommission", By.xpath("//*[contains(@id,':GrossCommissionPercentage-inputEl')]"));
		hm.put("edtPayment_RetailAgentCommission", By.xpath("//*[contains(@id,':RetailAgentCommPercentage-inputEl')]"));
		hm.put("edtPayment_AnniversaryDate", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:AnniversaryDate-inputEl"));
		hm.put("elePayment_Update", By.id("PSBillingAdjustment_ExtPopup:UpdateButton-btnInnerEl"));
		hm.put("bliPayment_Bind", By.id("HIGPolicyFile_Payment_Ext:BindOptions-btnWrap"));
		hm.put("lstLOBType", By.name("LineofBusiness"));
		hm.put("lstLOBLevelSupport", By.name("LevelofSupport"));
		hm.put("lstLOBAMPUWCompany", By.name("AMPUnderwritingCompany"));
		hm.put("eleCommonUdpate", By.xpath(".//span[contains(text(), 'Update')]"));
		hm.put("edtLOBTotalCost", By.name("TotalCost"));
		hm.put("eleLOBPackageOverriding", By.xpath("//*[contains(@class,'x-grid-dirty-cell x-grid-cell-selected')]/div"));
		hm.put("edtLOBNumMotrizedVehicle", By.name("NumberofMotorizedVehicles"));
		hm.put("eleLOBCompositeRated", By.xpath("//*[contains(@class,'x-grid-cell-last x-grid-cell-selected')]/div"));
		// hm.put("elePaymentPage", By.xpath("//span[contains(text(),'Payment')]"));

		// NameAddressChange
		hm.put("eleNameAddressScr", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_NameAddressChange_Ext"));
		hm.put("eleNewChange", By.id("AccountFile_NameAddressChange_Ext:newChange-btnInnerEl"));
		hm.put("lstSourceOfSub", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:sourceOfSubmission-inputEl"));
		hm.put("edtNameOfReq", By.id("NameAddressChange_ExtPage:NACAccountAndSubmissionInfo_ExtDV:reqName-inputEl"));
		hm.put("edtDateRec", By.id("NameAddressChange_ExtPage:NACAccountAndSubmissionInfo_ExtDV:receivedDate-inputEl"));
		hm.put("edtChangeEffDate", By.id("NameAddressChange_ExtPage:NACAccountAndSubmissionInfo_ExtDV:ChangeEffDate-inputEl"));
		hm.put("eleAIFChk", By.id("NameAddressChange_ExtPage:AIF-inputEl"));
		hm.put("eleNACSubmit", By.id("NameAddressChange_ExtPage:NACSubmit-btnInnerEl"));
		hm.put("elePolicyTable", By.id("NameAddressChange_ExtPage:higPolicyInfo:NACPolicyInfo_ExtLV-body"));
		hm.put("elePayerChk", By.id("NameAddressChange_ExtPage:payer-inputEl"));
		hm.put("eleNameChangeChk", By.id("NameAddressChange_ExtPage:nameChange-inputEl"));
		hm.put("eleNameChangeChk", By.id("NameAddressChange_ExtPage:nameChange-inputEl"));
		hm.put("eleAddressChangeChk", By.id("NameAddressChange_ExtPage:addressChange-inputEl"));
		hm.put("elePayerChk", By.id("NameAddressChange_ExtPage:payer-inputEl"));
		hm.put("edtPolicyInfoName2", By.id("NameAddressChange_ExtPage:higPolicyInfo:policyInfoName2-inputEl"));
		hm.put("clrNameOfReq", By.id("NameAddressChange_ExtPage:NACAccountAndSubmissionInfo_ExtDV:reqName-inputEl"));
		hm.put("clrDateRec", By.id("NameAddressChange_ExtPage:NACAccountAndSubmissionInfo_ExtDV:receivedDate-inputEl"));
		hm.put("clrChangeEffDate", By.id("NameAddressChange_ExtPage:NACAccountAndSubmissionInfo_ExtDV:ChangeEffDate-inputEl"));
		hm.put("eleSummaryOfChangestbl", By.id("AccountFile_NameAddressChange_Ext:socList:SummaryOfChanges_ExtLV-body"));
		hm.put("eleUptoSummaryOfChanges", By.id("NameAddressChange_ExtPage:NameAddressChange_ExtPage_UpLink"));
		hm.put("edtNAC_NameOfReq", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:reqName-inputEl"));
		hm.put("clrNAC_NameOfReq", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:reqName-inputEl"));
		hm.put("edtNAC_Date", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:receivedDate-inputEl"));
		hm.put("clrNAC_Date", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:receivedDate-inputEl"));
		hm.put("eleNAC_AIFchck", By.id("NameAddressChange_ExtPopup:AIF-inputEl"));
		hm.put("eleNAC_Submit", By.id("NameAddressChange_ExtPopup:Submit-btnInnerEl"));
		hm.put("edtNAC_ChangeEffDate", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:ChangeEffDate-inputEl"));
		hm.put("clrNAC_ChangeEffDate", By.id("NameAddressChange_ExtPopup:NACAccountAndSubmissionInfo_ExtDV:ChangeEffDate-inputEl"));
		hm.put("eleNAC_NameChangechck", By.id("NameAddressChange_ExtPopup:nameChange-inputEl"));
		hm.put("eleNAC_Payerchck", By.id("NameAddressChange_ExtPopup:payer-inputEl"));
		hm.put("eleSubmit", By.id("NameAddressChange_ExtPopup:Submit-btnInnerEl"));

		// Doing Business As
		hm.put("elePolPrimNameInsired", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:Name-inputEl"));
		hm.put("elePrimaryNamedInsuredDBAPage", By.id("EditPolicyContactRolePopup:ContactDetailScreen:ttlBar"));
		hm.put("elePriNamedInsContactDetTab", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:PolicyContactRoleDetailCardTab-btnInnerEl"));
		hm.put("elePriNamedInsRoleTab", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:RolesCardTab-btnInnerEl"));
		hm.put("elePriNamedInsAddressesTab", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:AddressesCardTab-btnInnerEl"));
		hm.put("elePriNamedInsDBATab", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:DBACardTab-btnInnerEl"));
		hm.put("elePriNamedInsAddDBA", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:ContactDBALV_tb:addContactButton-btnInnerEl"));
		hm.put("elePriNamedInsRemoveDBA", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"));
		hm.put("elePolPrimInsNewCompany", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:ContactDBALV_tb:addContactButton:0:0:contactType-textEl"));
		hm.put("elePolDBARolePage", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:ttlBar"));
		hm.put("edtPolDBARoleContDetTab", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactRoleDetailCardTab-btnInnerEl"));
		hm.put("edtPolDBARoleContDetContName", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("edtPolDBARoleContDetFEIN", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("elePolDBARoleAddressesTab", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesCardTab-btnInnerEl"));
		hm.put("elePolDBARoleAddrDetails", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailCardTab-btnInnerEl"));
		hm.put("elePolDBARoleOK", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:Update-btnInnerEl"));
		hm.put("elePolPrimInsOK", By.id("EditPolicyContactRolePopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("elePolInfoDBATable", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:listOfDBAs:PolicyDBAsDV:NamedInsuredInputSet:DBAListLV-body"));
		hm.put("elePolDBARoleContDetAdd1", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("elePolDBARoleContDetCity", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("elePolDBARoleContDetCounty", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("elePolDBARoleContDetState", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("elePolDBARoleContDetZip", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("elePolDBARoleContDetCountey", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:PolicyContactDetailsDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));

		hm.put("elePolDBARoleAddrAdd1", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("elePolDBARoleAddrCity", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:City-inputEl"));
		hm.put("elePolDBARoleAddrCounty", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:County-inputEl"));
		hm.put("elePolDBARoleAddrState", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("elePolDBARoleAddrZip", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("elePolDBARoleAddrCountey", By.id("NewPolicyDBAContact_ExtPopup:ContactDetailScreen:PolicyDBAContact_ExtCV:AddressesPanelSet:AddressDetailDV:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));

		hm.put("elePolInfoDBAAddedTable", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:listOfDBAs:PolicyDBAsDV:NamedInsuredInputSet:DBAListLV-body"));
		hm.put("elePriNamedInsDBAAddedTable", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:ContactDBALV-body"));
		hm.put("elePriNamedInsSelectDBARemove", By.xpath(".//*[@id='AccountFile:MenuLinks-body']/div/table/tbody/tr/td/div"));

		// Additional Insured Extension
		hm.put("eleAddInsAddDBA", By.xpath("//*[contains(@id, 'NamedInsuredsLV_tb:AddContactsButton-btnInnerEl')]"));
		hm.put("eleAddInsNewCompany", By.xpath("//*[contains(@id, 'ContactType-textEl')]"));

		hm.put("eleAddInsRemoveDBA", By.id("EditPolicyContactRolePopup:ContactDetailScreen:PolicyContactRoleDetailsCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"));
		hm.put("eleAddInsNewNamedInsuredPage", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:ttlBar"));
		hm.put("edtAddInsCompanyName", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAddInsSameAddAs", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
		hm.put("eleAddInsSameAddAsType", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
		hm.put("eleAddInsSameAddAsAddress", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
		hm.put("eleAddInsOK", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleAddInsDBAAddedTable", By.xpath("//*[contains(@id, 'NamedInsuredInputSet:NamedInsuredsLV-body')]"));
		hm.put("eleAddInsSelDBA", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV-body']/div/table/tbody/tr/td/div"));
		hm.put("eleAddInsDBARemove", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:Remove-btnInnerEl"));
		hm.put("elePriNamedInsSelDBASetPrimary", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:listOfDBAs:PolicyDBAsDV:NamedInsuredInputSet:DBAListLV-body']/div/table/tbody/tr/td/div"));
		hm.put("elePriNamedInsDBASetPrimary", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:listOfDBAs:PolicyDBAsDV:NamedInsuredInputSet:DBAListLV_tb:setToPrimary-btnInnerEl"));
		hm.put("eleAccDBAs", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:DBACardTab-btnInnerEl"));
		hm.put("eleAccAddDBA", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV_tb:addContactButton-btnInnerEl"));
		hm.put("eleAccDBANewCompany", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV_tb:addContactButton:0:0:contactType-textEl"));
		hm.put("edtAccDBAName", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAccNewDBARoleTab", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:RolesCardTab-btnInnerEl"));
		hm.put("eleAccNewAddDBARole", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton-btnInnerEl"));
		hm.put("eleAccNewAddDBARoleNamedInsured", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV_tb:AddRoleButton:13:RoleType-itemEl"));
		hm.put("eleAccNewAddDBARoleTable", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV-body"));
		hm.put("eleAccNewAddDBARoleRemove", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:ContactRolesDV:ContactRolesLV_tb:Remove-btnInnerEl"));
		hm.put("eleAccDBAUpdate", By.id("NewDBAContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		hm.put("eleAccAddDBATable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV-body"));
		hm.put("eleAccRemoveDBA", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"));
		// hm.put("eleAccountNumber",
		// By.id("SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl"));
		hm.put("eleAccountNumber", By.xpath("//*[contains(@id, 'AccountNumber-btnInnerEl')]"));
		hm.put("eleAccCreateNewContact", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton-btnInnerEl"));
		// hm.put("eleAccNamedInsured",
		// By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:12:roleType-textEl"));
		// hm.put("eleAccNamedInsNewCompany",
		// By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV_tb:addContactButton:12:roleType:0:contactType-textEl"));
		hm.put("eleAccNamedInsured", By.xpath("//span[@class='x-menu-item-text' and contains(text(),'Named Insured')]"));
		hm.put("eleAccNamedInsNewCompany", By.xpath("//span[@class='x-menu-item-text' and contains(text(),'New Company')]"));
		hm.put("edtAccNamedInsNewCompanyName", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAccNamedInsameAddAs", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
		hm.put("eleAccNamedInsSameAddAsType", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
		hm.put("eleAccNamedInsSameAddAsAddress", By.id("NewAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
		hm.put("eleAccNamedInsUpdate", By.id("NewAccountContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleAccNamedInsTable", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body"));
		hm.put("eleAccNamedInsDBATab", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:DBACardTab-btnInnerEl"));
		hm.put("eleAccNamedInsAddDBA", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:addContactButton-btnInnerEl"));
		hm.put("eleAccNewNamedInsNewCompany", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:addContactButton:0:0:contactType-textEl"));
		hm.put("eleAccNamedInsDBATable", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV-body"));
		hm.put("eleAccNamedInsDBARemove", By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:ContactDBALV_tb:removeDBAContact-btnInnerEl"));
		hm.put("edtAccNamedInsNewDBAName", By.id("NewDBAContactPopup:ContactDetailScreen:AccountDBAContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAccNamedInsNewDBAOK", By.id("NewDBAContactPopup:ContactDetailScreen:Update-btnInnerEl"));
		hm.put("eleAccDBA_NamedInsured", By.xpath("//span[contains(text(), 'Named Insured')]"));

		// BBT
		hm.put("eleNewActivitytitle", By.id("NewActivityWorksheet:NewActivityScreen:ttlBar"));
		hm.put("eleBBPTGuideWorkFlowTitle", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:ttlBar"));
		hm.put("eleBBPTErrorMsg", By.xpath("//div[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']/div[@class='message']"));
		hm.put("eleBBT_GuidedInfoBar", By.xpath("//span[@class='infobar_elem_val' and contains(text(),'Guided Workflow - Book of Business Transfer')]"));
		hm.put("eleClose_WithdrawTransaction", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:CloseOptions:WithdrawJob-textEl"));
		hm.put("eleJobNumber", By.id("PSJob_ExtWizard:PSJob_Summary_ExtScreen:PSJob_Summary_ExtDV:number-inputEl"));
		hm.put("eleStatus", By.id("PSJob_ExtWizard:PSJob_Summary_ExtScreen:PSJob_Summary_ExtDV:status-inputEl"));
		hm.put("eleActivity_TargetDate", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:TargetDate-inputEl"));
		hm.put("edtActivity_TargetDate", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:TargetDate-inputEl"));
		hm.put("eleActivity_AssignTo", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:AssignedTo-inputEl"));
		hm.put("eleActivity_ActivityDesc", By.xpath("//textarea[@id='ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Description-inputEl']"));

		// SST Guided workFlow
		hm.put("eleSSTGuidedWorkFlowTitle", By.xpath("//span[contains(text(),'SST Guided Workflow') and @class='g-title']"));
		hm.put("eleARUProcessingTitle", By.xpath("//span[contains(text(),'ARU Processing') and @class='g-title']"));
		hm.put("eleNotifyNewAgentTitle", By.xpath("//span[contains(text(),'Notify New Agent') and @class='g-title']"));
		hm.put("eleSSTProducerCodeIcon", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:newProducerCode:SelectnewProducerCode"));

		hm.put("lstSSTProcuderStatus", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Status-inputEl"));
		hm.put("edtOPERInit", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:OperInIt-inputEl"));
		hm.put("eleSysGeneratedTble", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:systemGen"));
		hm.put("eleAgencyNameExact", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:agencyNameExact_Ext-inputEl"));
		hm.put("eleErrorMsgs", By.xpath("//div[@id='PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:_msgs']//div[@class='message']"));
		hm.put("eleGuidedInfoBar", By.xpath("//span[@class='infobar_elem_val' and contains(text(),'Guided Workflow - Single Start Transfer')]"));
		hm.put("eljPolicyNo", By.xpath("//span[@class='infobar_elem_val' and contains(text(),'Policy #')]"));
		hm.put("edtEffectiveDate", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:effdatechange-inputEl"));
		hm.put("eleNewProducerCode", By.xpath("//input[contains(@id,'newProducerCode-inputEl')]"));
		hm.put("eleNewProducerName", By.xpath("//div[contains(@id,'newAgencyName-inputEl')]"));
		hm.put("elePAC", By.id("PolicyFile_Summary:Policy_SummaryScreen:ProducerCodesDV:PAC_Ext-inputEl"));

		hm.put("eleGuidedWrkFlw_MT", By.id("HIGPolicyFile_MidTermTransactions:guidedWorkflowsTab-btnInnerEl"));
		hm.put("eleGuidedWrkFlwTable", By.id("HIGPolicyFile_MidTermTransactions:guidedWorkflowsTab:panelId"));
		hm.put("eleDeclineReason", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:declineReason-inputEl"));
		hm.put("eleSysGeneratedYES", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:systemGen_true-inputEl"));
		hm.put("eleSysGeneratedNO", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:systemGen_false-inputEl"));
		hm.put("eleDeliveryMethodLbl", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:deliveryMethod-labelEl"));
		hm.put("edtDeliveryMethod", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:deliveryMethod-inputEl"));
		hm.put("elePolicySummary_PendingTransactn_Tble", By.id("HIGPolicyFile_Summary:PSPolicy_Summary_JobsInProgressLV-body"));

		// BOR Guided workFlow
		hm.put("eleBORWorkFlowTitle", By.xpath("//span[contains(text(),'CLA BOR Prep Guided Workflow') and @class='g-title']"));
		hm.put("elePolChgProducerSearchimg", By.xpath("//*[contains(@id,'ProducerCodeofService_Ext:SelectProducerCodeofService_Ext')]"));
		hm.put("eleBORQstnTable", By.id("PolicyChangeWizard:BORWizardStepGroup:PolicyChangeWizard_BOR_ExtScreen:QuestionSetsDV:0:QuestionSetLV-body"));
		// hm.put("eleBORQstnTable",
		// By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:QuestionSetsDV:0:QuestionSetLV"));
		// hm.put("eleBORQstnTable",
		// By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:QuestionSetsDV:0:QuestionSetLV-body"));
		hm.put("lstBORQstnlist", By.name("c1"));
		hm.put("eleProducerSearchIcon", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:ProducerSelectionInputSet:ProducerCode_Ext:SelectProducerCode_Ext"));
		hm.put("eleBOR_Closeoptions", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:CloseOptions-btnInnerEl"));
		hm.put("eleBORClose_Withdraw_options", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:CloseOptions:WithdrawJob-textEl"));
		hm.put("edtBOREffectiveDate", By.id("PSJob_ExtWizard:AllStepsWizardStepGroup:PSJob_Step_ExtScreen:ProducerSelectionInputSet:BOREffDate_date-inputEl"));
		hm.put("elePolicEff_Summary", By.id("HIGPolicyFile_Summary:PolicyPerEffDate-inputEl"));
		hm.put("eleBORerrorMsg", By.xpath("//*[contains(text(),'Create Single Start Transfer and withdraw this Broker Of Record request')]"));
		hm.put("eleBORMissing_Msg", By.xpath("//*[contains(text(),'Broker Of Record cannot be processed with missing information. Save Broker Of Record change until missing information is received')]"));
		hm.put("eleBORWithdraw_Msg", By.xpath("//*[contains(text(),'Withdraw this work order and handle as indicated in the Broker Of Record Exception Guide')]"));

		// Cla policy Summary
		hm.put("eleRecentNotesDesc", By.xpath("//div[@id='HIGPolicyFile_Summary:HigNotesSummaryLV']//table//tr//div[@id='x-form-el-HIGPolicyFile_Summary:HigNotesSummaryLV:0:NoteRowSet:Body']"));
		hm.put("eleRecentNotesTopic", By.xpath("//div[@id='HIGPolicyFile_Summary:HigNotesSummaryLV']//table//tr//div[@id='x-form-el-HIGPolicyFile_Summary:HigNotesSummaryLV:0:NoteRowSet:Topic']"));
		hm.put("eleRecentNotesSubject", By.xpath("//div[@id='HIGPolicyFile_Summary:HigNotesSummaryLV']//table//tr//div[@id='x-form-el-HIGPolicyFile_Summary:HigNotesSummaryLV:0:NoteRowSet:Subject']"));
		hm.put("eleRecentNotesHeader", By.xpath("//span[@class='g-title' and text()='Recent Notes']"));
		// hm.put("elepolicySummary_Activitytbl",
		// By.id("HIGPolicyFile_Summary:26-body"));
		hm.put("elePolicySummaryPage", By.id("PolicyFile_Summary:Policy_SummaryScreen:0"));
		hm.put("eleConfirmCancellation", By.xpath("//span[contains(text(), 'Canceled ')]"));
		hm.put("eleCUEbtn", By.id("HIGPolicyFile_Summary:CueButton-btnInnerEl"));
		hm.put("eleIssuedIndicator", By.id("HIGPolicyFile_Summary:Issued-inputEl"));
		hm.put("elePS_CLAPolicyNumber", By.xpath("//*[contains(@id,'PolicyNumber-inputEl')]"));

		// classifications
		hm.put("eleMMClassification", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_Classification_Ext"));
		hm.put("eleClassificationRefresh", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:Refresh-btnEl"));
		hm.put("eleMMClassGuideDetailTitle", By.xpath("//*[contains(@id,'AccountFile_Classification_Ext:Account_Classification_ExtScreen:ttlBar')]"));
		hm.put("eleClassificationErrorMsg", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:_msgs"));
		hm.put("eleEditClassification", By.xpath("//*[contains(@id,'EditClassificationButton-btnInnerEl')]"));
		hm.put("eleViewClassification", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:VCR-btnInnerEl"));
		hm.put("eleClassify", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ToolbarButton-btnInnerEl"));
		hm.put("edtClassificationSCI", By.id("myForm:classificationSearchView_sic"));
		hm.put("nedtClassificationSCI", By.id("myForm:classificationSearchView_sic"));
		hm.put("edtClassificationDesc", By.id("myForm:classificationSearchView_description"));
		hm.put("nedtClassificationDesc", By.id("myForm:classificationSearchView_description"));
		hm.put("DrpClassificationState", By.id("myForm:selState"));
		hm.put("btnClassificationSearch", By.id("myForm:search_button"));
		hm.put("btnSelectClassCode", By.id("myForm:cccTable:0:selectButton"));		
		hm.put("drpTXWC", By.id("myForm:classDetailsTbl:0:wcStateTbl:0:wcStateRateId"));
		hm.put("drpFCode", By.id("myForm:classDetailsTbl:0:propFCodeTbl:0:propertyFCodeListId"));
		hm.put("btnAssign", By.id("myForm:assign_button"));
		hm.put("sclAssign", By.id("myForm:assign_button"));
		hm.put("eleSICValue", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:Classification_IndustryCodeDetail_ExtInputSet:SIC-inputEl"));
		hm.put("eleAltPayNamelbl", By.id("HIGPolicyFile_Summary:PayerName-labelEl"));
		hm.put("eleAltPayName", By.id("HIGPolicyFile_Summary:PayerName-inputEl"));
		hm.put("eleAltPayAddresslbl", By.id("HIGPolicyFile_Summary:AddressSummary-labelEl"));
		hm.put("eleAltPayAddress", By.id("HIGPolicyFile_Summary:AddressSummary-inputEl"));
		hm.put("eleMM_Classify", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ClassifyButton-btnInnerEl"));
		// Bulk Mailing
		/*
		 * hm.put("eleBulkemailing",
		 * By.id("TabBar:AdminTab:Admin_BulkMailingMenu-arrowEl"));
		 * hm.put("eleHomeofficetorts", By.id(
		 * "TabBar:AdminTab:Admin_BulkMailingMenu:BulkMailingMenu_BulkMailingMainPage-textEl"
		 * )); hm.put("eleCreateNewBatch",
		 * By.id("BulkMailingMainPage:createNewBatch-btnInnerEl"));
		 * hm.put("lstDocumentTemplate",
		 * By.id("BulkMailingBatchPopup:batchType-inputEl")); hm.put("edtPolicies",
		 * By.id("BulkMailingBatchPopup:policylist-inputEl"));
		 * hm.put("eleBulkEmailingSpreadSheet",
		 * By.id("BulkMailingBatchPopup:Spreadsheet-btnWrap")); hm.put("eleImport",
		 * By.id("BulkMailingBatchPopup:Spreadsheet:Import-textEl"));
		 * hm.put("eleBrowse", By.xpath(".//span[contains(text(), 'Browse...')]"));
		 * hm.put("eleFatalErrors",
		 * By.id("BulkMailingImportPopup:ErrorDV:FatalErrors-labelEl"));
		 * hm.put("eleissueTypeIssueReason",
		 * By.id("BulkMailingImportPopup:ErrorDV:FatalErrors-inputEl"));
		 * hm.put("eleimportafterfileuploaded",
		 * By.id("BulkMailingImportPopup:ImportButton-btnInnerEl"));
		 * hm.put("eleReturntoGenerateBatch",
		 * By.id("BulkMailingImportPopup:__crumb__")); hm.put("eleBulkMailingTable",
		 * By.id("BulkMailingMainPage:BatchLV-body")); hm.put("edtBatchId",
		 * By.id("BulkMailingMainPage:batchNumber-inputEl")); hm.put("eleSearchRecords",
		 * By.id("BulkMailingMainPage:searchRecords-btnInnerEl"));
		 */
		hm.put("eleBulkemailing", By.id("TabBar:AdminTab:Admin_BulkMailingMenu-arrowEl"));
		hm.put("eleHomeofficetorts", By.id("TabBar:AdminTab:Admin_BulkMailingMenu:BulkMailingMenu_BulkMailingMainPage-textEl"));
		hm.put("eleCreateNewBatch", By.id("BulkMailingMainPage:createNewBatch-btnInnerEl"));
		hm.put("lstDocumentTemplate", By.id("BulkMailingBatchPopup:batchType-inputEl"));
		hm.put("edtPolicies", By.id("BulkMailingBatchPopup:policylist-inputEl"));
		hm.put("eleBulkEmailingSpreadSheet", By.id("BulkMailingBatchPopup:Spreadsheet-btnWrap"));
		hm.put("eleImport", By.id("BulkMailingBatchPopup:Spreadsheet:Import-textEl"));
		hm.put("eleBrowse", By.xpath(".//span[contains(text(), 'Browse...')]"));
		hm.put("eleFatalErrors", By.id("BulkMailingImportPopup:ErrorDV:FatalErrors-labelEl"));
		hm.put("eleissueTypeIssueReason", By.id("BulkMailingImportPopup:ErrorDV:FatalErrors-inputEl"));
		hm.put("eleimportafterfileuploaded", By.id("BulkMailingImportPopup:ImportButton-btnInnerEl"));
		hm.put("eleReturntoGenerateBatch", By.id("BulkMailingImportPopup:__crumb__"));
		hm.put("eleBulkMailingTable", By.id("BulkMailingMainPage:BatchLV-body"));
		hm.put("edtBatchId", By.id("BulkMailingMainPage:batchNumber-inputEl"));
		hm.put("eleSearchRecords", By.id("BulkMailingMainPage:searchRecords-btnInnerEl"));
		hm.put("eleSubmitBatch", By.id("BulkMailingBatchPopup:Update-btnInnerEl"));
		hm.put("elePrintButton", By.id("BulkMailingMainPage:BatchLV_tb:PrintMe-btnInnerEl"));
		hm.put("elePrintOkButton", By.id("PrintOptionPopup:PrintOptionPopupScreen:Ok-btnInnerEl"));
		hm.put("eleBulktbl", By.id("BulkMailingMainPage:BatchLV-body"));
		hm.put("eleSavechanges", By.id("BulkMailingMainPage:BatchLV_tb:SaveChanges-btnInnerEl"));
		hm.put("eleReturntohomeofficetorts", By.id("BulkMailingBatchPopup:__crumb__"));

		// Reinsurance
		hm.put("eleReinsurance", By.xpath(".//span[contains(text(), 'Reinsurance')]"));
		// hm.put("eleReinsurance",
		// By.id("HIGPolicyFile:MenuLinks:HIGPolicyFile_HIGPolicyFile_Reinsurance"));
		// hm.put("eleReinsuranceEdit",
		// By.id("PolicyFile_Reinsurance_Ext:ReinsuranceDetails_ExtScreen:ToolbarButtonid-btnInnerEl"));
		hm.put("eleReinsuranceEdit", By.xpath("//*[contains(@id,'ReinsuranceDetails_ExtScreen:ToolbarButtonid-btnInnerEl')]"));
		hm.put("elereinsuranceindicator", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:reinsuranceIndicator_Ext-inputEl"));
		hm.put("eleReinsurance_ReinsuranceCertTbl", By.id("PSReinsuranceEditScreen_ExtPopup:PSReinsuranceDetails_ExtScreen:third:QuestionSetsDV:0:QuestionSetLV-body"));

		hm.put("lstTranscationType", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:transactionType-inputEl"));
		hm.put("lstReinsured", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:reinsured-inputEl"));
		hm.put("eleReinsuranceUpdate", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleTranscationTypestatus", By.id("PolicyFile_Reinsurance_Ext:ReinsuranceDetails_ExtScreen:transactionType-inputEl"));
		hm.put("eleReinsuranceCheckBox", By.id("HIGPolicyFile_Reinsurance:PSReinsuranceDetails_ExtScreen:RI-inputEl"));
		hm.put("eleReinsuranceCheck", By.id("PSReinsuranceEditScreen_ExtPopup:PSReinsuranceDetails_ExtScreen:RI-inputEl"));

		hm.put("eleCOFttlbar", By.id("CertificatePopup:defaultCertScreen:ttlBar"));
		hm.put("lstSelectLOB", By.id("PSReinsuranceEditScreen_ExtPopup:PSReinsuranceDetails_ExtScreen:selectLOBDV:lines-inputEl"));
		hm.put("eljGeneratePDF_Reinsurance", By.id("HIGPolicyFile_Reinsurance:PSReinsuranceDetails_ExtScreen:GenPDF-btnInnerEl"));
		hm.put("eleReinsurance_Edit", By.id("HIGPolicyFile_Reinsurance:PSReinsuranceDetails_ExtScreen:ToolbarButton-btnInnerEl"));
		hm.put("eleRisk_ExcessOfLoss", By.xpath("//div[@id='HIGPolicyFile_Reinsurance:PSReinsuranceDetails_ExtScreen:third:QuestionSetsDV:1:QuestionSetLV-body']//tr[1]/td[2]//img"));
		// hm.put("eljReinsuranceUpdate_btn",
		// By.id("HIGPolicyFile_Reinsurance:PSReinsuranceDetails_ExtScreen:update-btnInnerEl"));
		hm.put("eljReinsuranceUpdate_btn", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:updateButton_Ext-btnInnerEl"));
		hm.put("edtReinsuranceCommission", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:commissionRate-inputEl"));
		hm.put("edtReinsurancePerBase", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:perBase-inputEl"));
		hm.put("edtReinsurancePerExposure", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:perExposure-inputEl"));
		hm.put("edtTermReinsuranceCost", By.id("ReinsuranceEditScreenPopup:ReinsuranceDetails_ExtScreen:termReinsuranceCost-inputEl"));

		// Desktop
		hm.put("eleDesktopNewSubmission", By.id("Desktop:DesktopMenuActions:DesktopMenuActions_Create:DesktopMenuActions_NewSubmission-textEl"));
		hm.put("eleRecentAccounts", By.id("TabBar:AccountTab:0:accountItem-textEl"));
		hm.put("eleNewAccount", By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		hm.put("eleRecentPolicies", By.id("TabBar:PolicyTab:PolicyMenuIt:0:PolicyMenuPolicy-textEl"));
		// R3 hm.put("eleRecentPolicies",
		// By.id("TabBar:PolicyTab:0:PolicyMenuPolicy-textEl"));
		hm.put("eleNewSubmissionPolicy", By.id("TabBar:PolicyTab:PolicyTab_NewSubmission-textEl"));

		// MySubmission
		hm.put("eleMySubmissions", By.id("Desktop:MenuLinks:Desktop_DesktopSubmissions"));
		hm.put("eleMySubmissionsAssert", By.id("DesktopSubmissions:DesktopSubmissionsScreen:0"));
		hm.put("eleMySubmissionBody", By.id("DesktopSubmissions:DesktopSubmissionsScreen:DesktopSubmissionsLV-body"));
		hm.put("lstMySubmissionsDropdown", By.id("DesktopSubmissions:DesktopSubmissionsScreen:jobFilter-inputEl"));

		// MyGroups
		hm.put("lstGroupsCategories", By.id("DesktopAssignableGroups_Ext:catetory-inputEl"));
		hm.put("eleGroupsAssignBtn", By.id("DesktopAssignableGroups_Ext:DesktopGroups_AssignButton-btnInnerEl"));
		hm.put("eleGroupName", By.id("GroupDetailPage:GroupDetailScreen:GroupDetailDV:GlobalContactNameInputSet:Name-labelEl"));
		hm.put("eleType", By.id("GroupDetailPage:GroupDetailScreen:GroupDetailDV:Type-labelEl"));
		hm.put("eleSecZone", By.id("GroupDetailPage:GroupDetailScreen:GroupDetailDV:GroupDetailInputSet:SecurityZone-labelEl"));
		hm.put("eleActionsNewGroup", By.id("Admin:AdminMenuActions:AdminMenuActions_Create:AdminMenuActions_NewGroup-itemEl"));
		hm.put("eleGroup", By.id("Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_AdminGroupSearchPage"));
		hm.put("edtGroupNameGroup", By.id("AdminGroupSearchPage:GroupSearchScreen:AdminGroupSearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleSearchBtnGroup", By.id("AdminGroupSearchPage:GroupSearchScreen:AdminGroupSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleEditBtnGroup", By.id("GroupDetailPage:GroupDetailScreen:Edit-btnInnerEl"));
		hm.put("edtGroupNameBasics", By.id("GroupDetailPage:GroupDetailScreen:GroupDetailDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleUpdateBtnGroup", By.id("GroupDetailPage:GroupDetailScreen:Update-btnInnerEl"));
		hm.put("eleDeleteBtn", By.id("GroupDetailPage:GroupDetailScreen:GroupDetailScreen_BasicCard_DeleteButton-btnInnerEl"));
		hm.put("eleSelectGroupFromTable", By.id("AdminGroupSearchPage:GroupSearchScreen:GroupSearchResultsLV-body"));
		hm.put("eleResestBtn", By.id("AdminGroupSearchPage:GroupSearchScreen:AdminGroupSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleRegionsLeftPanel", By.id("Admin:MenuLinks:Admin_UsersAndSecurity:UsersAndSecurity_Regions"));
		hm.put("eleAddRegionBtn", By.id("RegionsPage:RegionsScreen:RegionSearchResultsLV_tb:Regions_AddRegionButton-btnInnerEl"));
		hm.put("edtRegionName", By.id("NewRegion:RegionDetailScreen:Name-inputEl"));
		hm.put("lstCountry", By.id("NewRegion:RegionDetailScreen:Country-inputEl"));
		hm.put("lstTypeRegion", By.id("NewRegion:RegionDetailScreen:RegionDetailDV:zoneType-inputEl"));
		hm.put("eleUpdateBtn", By.id("NewRegion:RegionDetailScreen:Update-btnInnerEl"));
		hm.put("eleAddBtn", By.id("GroupDetailPage:GroupDetailScreen:GroupRegionLV_tb:Add-btnInnerEl"));
		hm.put("edtGroupRegionName", By.id("GroupRegionPopup:GroupRegionPopupScreen:RegionSearchDV:Name-inputEl"));
		hm.put("eleRegions", By.id("GroupDetailPage:GroupDetailScreen:GroupDetail_RegionsCardTab-btnInnerEl"));
		hm.put("eleSearchBtnBrowseGroup", By.id("GroupRegionPopup:GroupRegionPopupScreen:RegionSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleResestBtnBrowseGroup", By.id("GroupRegionPopup:GroupRegionPopupScreen:RegionSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleSelectRegionTable", By.id("GroupRegionPopup:GroupRegionPopupScreen:RegionSearchResultsLV-body"));
		hm.put("eleGroupSearch", By.id("AdminGroupSearchPage:GroupSearchScreen:ttlBar"));
		hm.put("eleActionsNewGroupPg", By.id("NewGroup:GroupDetailScreen:ttlBar"));
		hm.put("eleSelectBrowseGrpBtn", By.id("GroupRegionPopup:GroupRegionPopupScreen:RegionSearchResultsLV_tb:GroupRegionPopup_SelectButton-btnInnerEl"));
		hm.put("eleGroupScreenRegion", By.id("GroupRegionPopup:__crumb__"));
		hm.put("eleDeleteBtnRegions", By.id("RegionsPage:RegionsScreen:RegionSearchResultsLV_tb:Regions_DeleteButton-btnInnerEl"));
		hm.put("eleRegionsTable", By.id("RegionsPage:RegionsScreen:RegionSearchResultsLV-body"));
		hm.put("eleGrpTableAdd", By.id("GroupDetailPage:GroupDetailScreen:GroupRegionLV-body"));
		hm.put("eleSelectRegion", By.xpath("//*[contains(text(),'East')]//ancestor::tr[1]/td/div/img"));

		// MyActivities
		hm.put("lstActivityDuration", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV:activitiesFilter-inputEl"));
		hm.put("eleAssignActivityPopup", By.id("AssignActivitiesPopup:AssignmentPopupScreen:ttlBar"));
		// hm.put("eleCloseButton",
		// By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV_tb:DesktopActivities_SkipButton-btnInnerEl"));
		hm.put("eleCloseButton", By.xpath("//*[contains(@id,'_SkipButton-btnInnerEl')]"));
		hm.put("eleCompleteButton", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV_tb:DesktopActivities_CompleteButton-btnInnerEl"));
		hm.put("eleCancelActivity", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupScreen_CancelButton-btnInnerEl"));

		// Preferences
		hm.put("eleClickPreferences", By.id("TabBar:PrefsTabBarLink-textEl"));
		hm.put("eleVerifyPreferencePage", By.id("wsTabBar:wsTab_0-btnInnerEl"));
		hm.put("elePrefUpdate", By.id("UserPreferencesWorksheet:UserPreferencesScreen:Update-btnInnerEl"));
		hm.put("eleVerifyActivityPage", By.id("DesktopActivities:DesktopActivitiesScreen:0"));

		// MyAccounts
		hm.put("eleMyAccounts", By.id("Desktop:MenuLinks:Desktop_DesktopAccounts"));
		hm.put("lstAccDuration", By.id("DesktopAccounts:DesktopAccountsScreen:DesktopAccountsLV:accountsFilter-inputEl"));
		hm.put("eleMyAcctbl", By.id("DesktopAccounts:DesktopAccountsScreen:DesktopAccountsLV-body"));

		// classifications
		// hm.put("eleMMClassification",By.id("AccountFile:MenuLinks:AccountFile_AccountFile_Classification_Ext"));
		// hm.put("eleClassificationRefresh",By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:Refresh-btnEl"));
		hm.put("eleMMClassGuideDetailTitle", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ttlBar-btnEl"));
		hm.put("eleClassificationErrorMsg", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:_msgs"));
		hm.put("eleSCClassification", By.id("AccountFile:MenuLinks:AccountFile_AccountFile_Classification_Ext2"));
		hm.put("eleSCRefresh", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:Refresh-btnInnerEl"));
		hm.put("eleClassificationAssert", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ttlBar"));
		hm.put("eleMMClassificationPolicyTerms", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:Classification_PolicyTermInfo_ExtLV_header"));
		hm.put("elePolicyTermsAssert", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:Classification_PolicyTermInfo_ExtLV_header_hd-textEl"));

		// CUE SUBMISSION
		hm.put("eleCueButton", By.id("PSPolicyTerm_Ext_Info:CueButton-btnInnerEl"));

		// CUE Policy Summary
		hm.put("elePolicySummary_EffectiveDate", By.id("HIGPolicyFile_Summary:PolicyPerEffDate-inputEl"));
		hm.put("elePolicySummary_ExpirationDate", By.id("HIGPolicyFile_Summary:PolicyPerExpirDate-inputEl"));
		hm.put("eleDriver_SelectUser", By.xpath("//div[@class='x-grid-cell-inner x-grid-cell-inner-checkcolumn']/img"));
		hm.put("lstWC_PlanID", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanOptionDV:PlanID-inputEl"));
		hm.put("eljActions", By.xpath(".//*[contains(@id,'MenuActions-btnInnerEl')]"));
		hm.put("eleShellPolicyNoteName", By.id("x-form-el-HIGPolicyFile_Notes:PolicyShell_Notes_ExtScreen:NotesLV:0:NoteRowSet:Subject"));
		hm.put("eljForceDMV", By.id("HIGPolicy_Drivers:DriversPanelSet:forceDMV"));
		hm.put("eljCLAAccountNumber", By.id("HIGPolicyFile:PSPolicyTerm_ExtInfoBar:HIGAccountNumber-btnInnerEl"));
		hm.put("eljMergePolicy", By.id("AccountFile_MovePoliciesSelection:MovePoliciesButton"));
		hm.put("edtActivityEdit_Description", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Description-inputEl"));
		hm.put("lstEdit_ActivityStatus", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:ActivityStatus-inputEl"));
		hm.put("eleActivity_CompleteButton", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_CompleteButton"));
		hm.put("eleNaviToHistory_LeftPane", By.xpath(".//span[contains(text(), 'History')]"));
		hm.put("eljCLADvrUpdate", By.id("HIGPolicy_Drivers:DriversPanelSet:Update-btnInnerEl"));
		hm.put("eleLocation_Number", By.id("AccountFile_Locations:AccountFile_LocationsScreen:AccountFile_LocationsLV:0:Loc"));
		hm.put("eleLocationState", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl"));
		hm.put("eleLocationCountry", By.id("AccountLocationPopup:LocationScreen:AccountLocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("txtLicenseErrorMsg", By.xpath(".//*[@id='HIGNewDriverPopup:_msgs']/div[1]"));
		hm.put("eleAccountSummary_PolicyNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV:0:PolicyNumber"));

		// New Objects
		hm.put("elePursueNextyr", By.id("PSDeclineReasonExtPopup:RejectScreen:PSRejectReasonExtDV:PursueNextYear_true-inputEl"));
		hm.put("elePursueNextyrYES", By.xpath("//*[contains(@id,'PursueNextYear_true-inputEl')]"));
		hm.put("lstSuccessfulCarrier", By.id("PSDeclineReasonExtPopup:RejectScreen:PSRejectReasonExtDV:SuccessfulCarrier-inputEl"));
		hm.put("edtSuccessfulCaramt", By.id("PSDeclineReasonExtPopup:RejectScreen:PSRejectReasonExtDV:SuccessfulPremium-inputEl"));
		hm.put("eleCLAPolicySymbol", By.id("PSPolicyTerm_Ext_Info:PSPolicyTerm_ExtDV:PolicyNumberInputSet:PolicySymbol-inputEl"));
		hm.put("edtSORNPNFirstName", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:NPNFirstName-inputEl"));
		hm.put("edtSORNPNLastName", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:NPNLastName-inputEl"));
		hm.put("edtSORNPNMiddleName", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:NPNMiddleInitial-inputEl"));
		hm.put("eleCompPolTrantbl", By.id("HIGPolicyFile_Summary:PSPolicy_Summary_TransactionsLV-body"));
		hm.put("edtMTEndorsementNum", By.id("PSMaintenanceTransactionDetails_ExtPopup:endorsementNumber-inputEl"));
		hm.put("eleMTIsPreBeaEnd", By.id("PSMaintenanceTransactionDetails_ExtPopup:permiumBearingEndorsement-inputEl"));
		hm.put("edtMTChangeNar", By.id("PSMaintenanceTransactionDetails_ExtPopup:changeNarrative-inputEl"));
		hm.put("edtMTAnnualPre", By.id("PSMaintenanceTransactionDetails_ExtPopup:annualPremium-inputEl"));
		hm.put("edtMTNameReq", By.id("PSMaintenanceTransactionDetails_ExtPopup:requestorName-inputEl"));
		hm.put("elePCSUMBillingMethod", By.id("HIGPolicyFile_Summary:BillingInformationDV:BillingMethod-inputEl"));
		hm.put("edtMTAuditCost", By.id("PSMaintenanceTransactionDetails_ExtPopup:totalAuditedCost-inputEl"));
		hm.put("edtMTAuditEffDate", By.id("PSMaintenanceTransactionDetails_ExtPopup:auditEffDate-inputEl"));
		hm.put("eleMTleftMaintenanceTran", By.xpath(".//span[contains(text(),'Maintenance Transaction')]"));
		hm.put("eleMTPayment", By.id("PSMaintenanceTransactionDetails_ExtPopup:AMPPaymentTab-btnInnerEl"));
		hm.put("edtMTTranPreAmt", By.id("PSMaintenanceTransactionDetails_ExtPopup:PSMaintTxnAMPPaymentDV:AMPTransactionPremAmount-inputEl"));
		hm.put("eleMTPremRet", By.id("PSMaintenanceTransactionDetails_ExtPopup:PSMaintTxnAMPPaymentDV:totTransPremiumType_option1-inputEl"));
		hm.put("btnMTPremRet", By.id("PSMaintenanceTransactionDetails_ExtPopup:PSMaintTxnAMPPaymentDV:totTransPremiumType_option1-inputEl"));
		hm.put("eleCustomerCompltrYes", By.id("PolicyChangeWizard:PolicyChangeWizard_CompletionLetterScreen:CustomerCompletionLetterInputSet:CCLetterIndicator_true-inputEl"));
		// hm.put("lsjPC_DeliveryMethod",
		// By.id("PolicyChangeWizard:PolicyChangeWizard_CompletionLetterScreen:CustomerCompletionLetterInputSet:deliveryMethod-inputEl"));
		hm.put("lsjPC_DeliveryMethod", By.xpath("//*[contains(@id,'deliveryMethod-inputEl')]"));
		// hm.put("edtCustomerCompEmailAddress",
		// By.id("PolicyChangeWizard:PolicyChangeWizard_CompletionLetterScreen:CustomerCompletionLetterInputSet:CCLDeliveryEmail-inputEl"));
		hm.put("eljCustIssuePolicy", By.id("PolicyChangeWizard:PolicyChangeWizard_CompletionLetterScreen:JobWizardToolbarButtonSet:BindPolicyChange-btnInnerEl"));

		// Team Submission
		hm.put("elePolicy", By.id("TabBar:PolicyTab-btnEl"));
		hm.put("eleTeam", By.id("TabBar:TeamTab-btnInnerEl"));
		hm.put("eleTeamSubmissions", By.xpath(".//*[@id='TeamGroup:MenuLinks:TeamGroup_TeamSubmissions']/div//span"));
		hm.put("eleTeamActivities", By.xpath("//td[@id='TeamGroup:MenuLinks:TeamGroup_TeamActivities']//span[text()='Activities']"));
		hm.put("eljTeamSubmissions", By.xpath(".//*[@id='TeamGroup:MenuLinks:TeamGroup_TeamSubmissions']/div//span"));
		hm.put("eleTeamRenewals", By.id("TeamGroup:MenuLinks:TeamGroup_TeamRenewals"));
		// hm.put("eleTeamOtherPolicyTransactions",
		// By.xpath("//td[@id='TeamGroup:MenuLinks:TeamGroup_TeamOtherWorkOrders']//span[text()='Other
		// Policy Transactions']"));
		hm.put("eleTeamOtherPolicyTransactions", By.xpath("//*[@id='TeamGroup:MenuLinks:TeamGroup_TeamOtherWorkOrders']//span[text()='Other Policy Transactions']"));
		hm.put("elePolicySummary", By.id("PolicyFile_Summary:Policy_SummaryScreen:0"));
		hm.put("eleMyGroupSummaryPage", By.xpath("//span[@id='TeamSummary:TeamSummaryScreen:0' and contains(text(),'My Groups: Summary')]"));
		hm.put("eleMyGroupActivities", By.xpath("//span[@id='TeamActivities:TeamActivitiesScreen:0' and contains(text(),'My Groups: Activities')]"));
		hm.put("eleMyGroupSubmission", By.xpath("//span[@id='TeamSubmissions:TeamSubmissionsScreen:0' and contains(text(),'My Groups: Submissions')]"));
		hm.put("eleMyGroupRenewals", By.xpath("//span[@id='TeamRenewals:TeamRenewalsScreen:0' and contains(text(),'My Groups: Renewals')]"));
		hm.put("eleMyGroupPendingTransactions", By.xpath("//span[@id='TeamOtherWorkOrders:TeamOtherWorkOrdersScreen:0' and contains(text(),'My Groups: Other Pending Policy Transactions')]"));
		hm.put("lstTeamTypeSubmission", By.id("TeamSubmissions:TeamSubmissionsScreen:TeamSubmissionsToolbar:higSubmissionFilter-inputEl"));
		hm.put("eleSelectTransacFromTable", By.id("TeamSubmissions:TeamSubmissionsScreen:TeamSubmissionsLV-body"));
		hm.put("elePolicyInfoSaveDraft", By.id("PSPolicyTerm_Ext_Info:SaveDraftButton-btnInnerEl"));
		hm.put("eleSelectActivityFromTable", By.id("TeamActivities:TeamActivitiesScreen:TeamActivitiesLV-body"));
		hm.put("eleAssignBtn", By.id("TeamActivities:TeamActivitiesScreen:TeamActivitiesLV_tb:TeamGroupActivities_Assign-btnInnerEl"));
		hm.put("eleAssignCancelBtn", By.id("AssignActivitiesPopup:AssignmentPopupScreen:AssignmentPopupScreen_CancelButton-btnInnerEl"));
		hm.put("eleMisassignedActivitiesMyGroup", By.id("treeview-1182-record-0:0"));
		hm.put("eleAssignActivityScreen", By.xpath("//span[@id='AssignActivitiesPopup:AssignmentPopupScreen:ttlBar' and contains(text(),'Assign Activities')]"));
		hm.put("eleActivtyTable", By.xpath("//div[@id='TeamActivities:TeamActivitiesScreen:TeamActivitiesLV-body']"));
		hm.put("eleTeam_SubmissionTable", By.xpath("//div[@id='TeamSubmissions:TeamSubmissionsScreen:TeamSubmissionsLV-body']"));
		hm.put("eleTeam_RenewalTable", By.xpath("//div[@id='TeamRenewals:TeamRenewalsScreen:TeamRenewalsLV-body']"));
		// hm.put("eleTeam_RenewalTable",
		// By.xpath("//div[@id='TeamRenewals:TeamRenewalsScreen:TeamRenewalsLV-body']"));
		hm.put("edtTeam_Filter", By.xpath("//input[contains(@id,'Filter-inputEl')]"));
		hm.put("eleGrp_InQueue", By.xpath("//div[@id='Team:TeamMenuTree:TeamTreeView-body']//span[contains(@class,'x-tree-node-text') and text()='In Queue']"));
		hm.put("eleInQueuePage", By.xpath("//span[@id='TeamActivities:TeamActivitiesScreen:0' and contains(text(),'In Queue: Activities')]"));
		hm.put("eleTeam_InQueueTble", By.xpath("//div[@id='TeamActivities:TeamActivitiesScreen:TeamActivitiesLV-body']"));
		hm.put("ele_ActivityDetail_Title", By.xpath("//span[@id='ActivityDetailWorksheet:ActivityDetailScreen:ttlBar' and contains(text(),'Activity Detail')]"));
		hm.put("eljInQ_Actvty_SubjectLnk", By.xpath("//a[@id='TeamActivities:TeamActivitiesScreen:TeamActivitiesLV:0:Subject']"));
		hm.put("eleExposureStateList", By.id("PSExposureStatesPopup:ExposureStates-targetEl"));
		hm.put("eleTeam_OtherPendngTransTable", By.xpath("//div[@id='TeamOtherWorkOrders:TeamOtherWorkOrdersScreen:TeamOtherWorkOrdersLV-body']"));
		hm.put("elePremiumFinancing", By.cssSelector("input[id='HIGPolicyFile_Payment_Ext:psBillingAdjustment:PSBillingAdjustment_ExtDV:premiumFinanceIndicator-inputEl'][disabled='']"));
		hm.put("eleClassName", By.className("x-list-plain"));
		hm.put("edtAffinityGroup_CPID", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:CPID_Ext-inputEl"));
		hm.put("edtAffinityGroup_Segment", By.id("AffinityGroupDetailPage:AffinityGroupDetailScreen:AffinityGroupDetailDV:BusinessSegment_Ext-inputEl"));
		hm.put("eleUser_CancelButton", By.id("UserDetailPage:UserDetailScreen:UserDetailToolbarButtonSet:Cancel-btnInnerEl"));
		hm.put("elePayment_GrossCommission", By.id("HIGPolicyFile_Payment_Ext:AMPPaymentInfoDV:GrossCommissionPercentage-inputEl"));

		// 1058
		hm.put("eleisoglclasscode", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ISOorGLClassCode-inputEl"));
		hm.put("eleisoglclassdescriptionCode", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ISOorGLClassDescCode-inputEl"));
		hm.put("eleisoglclassDescription", By.id("AccountFile_Classification_Ext:Account_Classification_ExtScreen:ISOorGLClassDesc-inputEl"));

		// xact pay objects
		hm.put("eleXactPayApp", By.id("PSXactpayLaunch_ExtPopup:XactpayLaunchScreen:XactPayLV_tb:xactPayApp-btnInnerEl"));
		hm.put("eleXactPayAdmin", By.xpath("//*[contains(@id,'XactPayLV_tb:xactPayAdmin-btnInnerEl')]"));
		hm.put("eleXactPayTitle", By.xpath("//*[contains(@id,'XactpayLaunchScreen') and contains(text(),'XactPay Launch')]"));
		hm.put("eleXactpayTable", By.id("PSXactpayLaunch_ExtPopup:XactpayLaunchScreen:XactPayLV-body"));
		hm.put("eleCandidateMatch", By.id("pnlCandidateMatch"));
		hm.put("eleXactPayWindowTitlt", By.xpath("//h1[contains(text(),'XactPay')]"));
		hm.put("eleXactPayClose", By.xpath("//*[contains(text(),'Close')]"));
		hm.put("eleMatchBtn", By.id("btnDoMatchCandidate"));
		hm.put("eleReturnToHart", By.id("btnDoMatchCandidate"));
		hm.put("eleDataMainLink", By.xpath("//a[contains(text(),'Data Maintenance')]"));
		hm.put("eleTABBillWindow", By.xpath("//*[@class='sectionheadings' and contains(text(),'Billing Inquiry')]"));
		hm.put("eleXactReturn_AS", By.xpath("//*[contains(text(),'Return to Account File Summary')]"));

		// Prerenwal direction
		hm.put("elePreRenewalDirec_Title", By.xpath("//span[@id='PSPreRenewalDirectionPage:PreRenewalDirectionScreen:0' and contains(text(),'Pre-Renewal Direction')]"));
		hm.put("eleViewNotes_Prerenewal", By.xpath("//span[@id='PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirectionScreen_ViewNotesButton-btnInnerEl' and text()='View Notes']"));
		hm.put("eleNotesTitle", By.xpath("//span[@id='PSPreRenewalNotesPage:PolicyShell_Notes_ExtScreen:ttlBar' and text()='Notes']"));
		hm.put("elePrenewalDirection", By.xpath("//span[@id='HIGPolicyFile:HIGPolicyFileMenuActions:PolicyFileMenuActions_Create:PreRenewalID-textEl' and text()='Pre-Renewal Direction']"));
		hm.put("eleNotesTopic_Prenewal", By.id("PSPreRenewalNotesPage:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:Topic-inputEl"));
		hm.put("elePreRenewalDir_PolSummary", By.id("HIGPolicyFile_Summary:PreRenewalDirection-inputEl"));
		hm.put("eleOverRide", By.xpath("//*[contains(@id,'overrideButton_Ext-btnInnerEl')]"));
		hm.put("elePolicyHistory", By.id("PolicyFile:MenuLinks:PolicyFile_PolicyFile_History"));
		hm.put("elePolicyHistoryTble", By.id("HIGPolicyFile_History:PSJob_HistoryScreen:HistoryScreenResultsLV-body"));
		hm.put("eleReinsuranceIntentCheck_Catastrophe", By.xpath("//div[@id='HIGPolicyFile_Reinsurance:PSReinsuranceDetails_ExtScreen:third:QuestionSetsDV:0:QuestionSetLV-body']//tr[1]/td[2]//img"));
		hm.put("eleQueueAssignSelectedToMe", By.id("DesktopAssignableQueues:DesktopAssignableQueuesScreen:DesktopAssignableQueuesLV_tb:AssignSelectedButton-btnInnerEl"));
		hm.put("eleMTPremRet", By.id("PSMaintenanceTransactionDetails_ExtPopup:PSMaintTxnAMPPaymentDV:totTransPremiumType_option1-inputEl"));

		// R3
		hm.put("eleQualification", By.id("SubmissionWizard:SubmissionWizard_PreQualificationScreen:ttlBar"));
		hm.put("eleBusineesOwner", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:ttlBar"));
		hm.put("eleBusinessOwnerLocation", By.xpath("//span[contains(@id,'LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:ttlBar')]"));

		// R3 - PolicyInfo
		hm.put("lstPolicyInfo_PolicyType", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:coveragepart-inputEl"));
		hm.put("elePolicyInfo_NAICSSearch", By.xpath("//*[contains(@id,'NAICSIndustryCode:SelectIndustryCode')]"));
		hm.put("edtPolicyInfo_PredominantClassCode", By.xpath("//*[contains(@id,'PredoClassCode-inputEl')]"));
		hm.put("edtPopup_NAICSCode", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Code-inputEl"));
		// hm.put("elePolicyInfo_ProducerCodeSearch",
		// By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerCode_Ext:SelectProducerCode_Ext"));
		hm.put("elePolicyInfo_ProducerCodeSearch", By.xpath("//*[contains(@id,'ProducerCode_Ext:SelectProducerCode_Ext')]"));
		hm.put("edtPolicyInfo_AgencyNameProducerCode", By.id("ProducerCodeSearchPopup:ProducerCodeSearchScreen:ProducerCodeSearchDV:Description-inputEl"));
		hm.put("eleIndustryCodeResultTbl", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchResultsLV-body"));
		hm.put("lstBaseState", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:BaseState-inputEl"));

		hm.put("lsjSegment", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:Segment-inputEl"));
		// Business OwnersLines Details
		hm.put("lsjBLDetailBusinessType", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:BP7LineCoveragesPanelSet:BP7LineBusinessOperationsPanelSet:LineBusinessType-inputEl"));
		hm.put("elePeriodOfRestoration", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:BP7LineCoveragesPanelSet:MandatoryCoveragesLineStandardPropertyCovColTwo:BP7PropertyCoveragesColTwoDV:0:BP7CoverageInputSet:CovPatternInputGroup:OptionTerm2:OptionTermInput2-labelEl"));
		hm.put("eleInsuredBtn", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:LineAdditionalInsuredsCoverages:BP7AdditionalCoveragesPanelSet:BP7AdditionalCoveragesDV_tb:Add-btnInnerEl"));

		hm.put("edtSpecifiedLimit", By.xpath("//*[contains(@id,'DirectTermInput1-inputEl')]"));
		hm.put("eleCondName", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:PolicyLevelExclusionsAndConditions:BP7AdditionalExclusionsAndConditionsPanelSet:ConditionsPanel:BP7AdditionalConditionsDV:0:BP7CoverageInputSet:CovPatternInputGroup-legendTitle"));
		hm.put("elePollutionCondName", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:PolicyLevelExclusionsAndConditions:BP7AdditionalExclusionsAndConditionsPanelSet:ExclusionsPanel:BP7AdditionalExclusionsDV:3:BP7ReducedCoverageInputSet:CovPatternInputGroup-legendTitle"));
		hm.put("eleValTaxCode", By.id("BP7LocationPopup:LocationScreen:singleTaxCode_Ext-labelEl"));

		hm.put("eljBLNSGBundles", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:bundleCoveragesTab-btnInnerEl"));
		hm.put("eljBLAdditionalCoverages", By.xpath("//span[contains(@id,'LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:AdditionalCoveragesTab-btnInnerEl')]"));
		hm.put("eljPCSaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eleUmbrellaDetailTab", By.xpath("//*[contains(@id,'LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:BP7Umbrella_ExtTab-btnInnerEl')]"));
		hm.put("eleUmbrellaDetAuto", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbAutoPolicy-boxLabelEl')]"));
		hm.put("eleUmbrellaDetWC", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbWrkrsCompPolicy-boxLabelEl')]"));
		hm.put("eleUmbrellaDetFL", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbForeignLiabPolicy-boxLabelEl')]"));
		hm.put("eleUMBAutoChk", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbAutoPolicy-inputEl')]"));
		hm.put("eleUMBAutoCarrier", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:IsHartfordUndlyingCarrierAuto_true-inputEl')]"));
		hm.put("edtUMBAutoUnderlying", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UnderlyingCarrierNameAuto-inputEl')]"));
		hm.put("lstUMBAutoLiabilityLmt", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UndlyingAutoLiabLimits-inputEl')]"));
		hm.put("eleUMBAutoPolicyCover", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbCoverNonOwnedAutoInd_false-inputEl')]"));
		hm.put("eleUmbrellaWcChk", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbWrkrsCompPolicy-inputEl')]"));
		hm.put("eleUMBWcCarrier", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:IsHartfordUndlyingCarrierWkrComp_true-inputEl')]"));
		hm.put("lstUMBWcLiabilityLmt", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UndlyingEmpLiabLimits-inputEl')]"));
		hm.put("eleWorkersLimit", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UndlyingEmpLiabLimits-inputEl')]"));

		hm.put("edtUMBPrivatePassenger", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoPrivatePassenger-inputEl')]"));
		hm.put("edtLightWeight_MediumWeightTrucks", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoLightMedWtTrucks-inputEl')]"));
		hm.put("edtHeavyWeightTrucks", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoHeavyWtTrucks-inputEl')]"));
		hm.put("lstHWMaxRadOfOperation", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoHeavyWtTrucksRadOfOps-inputEl')]"));
		hm.put("edtExtraHeavyWgt", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoExtraHeavyWtTrucks-inputEl')]"));
		hm.put("lstEHWRadOfOperation", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoExtraHeavyWtTrucksRadOfOps-inputEl')]"));
		hm.put("edtExtraHeavyWgtTrucks_Tractors", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbAutoExtraHeavyWtTrkTractor-inputEl')]"));
		hm.put("lstEHWTTRadOfOperation", By.xpath("//*[contains(@id,'BP7Umbrella_ExtPanelSet:UmbAutoExtraHeavyWtTrkTractorRadOfOps-inputEl')]"));

		// Validation
		hm.put("edtDishonesty", By.xpath("//input[contains(@id,'CovPatternInputGroup:1:BP7CovTermInputSet:DirectTermInput-inputEl')]"));
		hm.put("edtFradulent", By.xpath("//*[contains(@id,'CovPatternInputGroup:1:BP7CovTermInputSet:DirectTermInput-inputEl')]"));

		hm.put("eleDetailsSpecified", By.xpath("//*[contains(@id,'CovPatternInputGroup:TypeKeyTerm:TypekeyTermInput-inputEl')]"));

		hm.put("eleDetailsActual", By.xpath("//*[contains(@id,'CovPatternInputGroup:TypeKeyTerm:TypekeyTermInput-inputEl')]"));
		hm.put("", By.xpath("//*[contains(@id,'')]"));
		hm.put("", By.xpath("//*[contains(@id,'')]"));
		hm.put("", By.xpath("//*[contains(@id,'')]"));
		hm.put("", By.xpath("//*[contains(@id,'')]"));

		hm.put("edtUMBAutoUnderlying", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UnderlyingCarrierNameAuto-inputEl')]"));
		hm.put("edtUMBWcUnderlying", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UnderlyingCarrierNameWkrComp-inputEl')]"));
		hm.put("eljUmbrellaFLChk", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbForeignLiabPolicy-boxLabelEl')]"));
		hm.put("eleUMBFLIsPolicyNo", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:IsHartfordUndlyingCarrierForeignLiab_false-inputEl')]"));
		hm.put("eleUMBFLIsPolicyYes", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:IsHartfordUndlyingCarrierForeignLiab_true-inputEl')]"));
		hm.put("edtUMBFLCarrier", By.xpath("//*[contains(@id,'UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UnderlyingCarrierNameForeignLiab-inputEl')]"));
		// hm.put("eleQuoteBOL",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		// Coverage
		hm.put("eleCoverages", By.xpath(".//div[@class='x-component x-fieldset-header-text x-component-default']"));

		// Locations
		hm.put("lstLocations_FeetWater", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationBusinessFieldsInputSet:FeetToHydrant-inputEl"));
		hm.put("lstLocations_FireProcClass", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationBusinessFieldsInputSet:FireProtectionClass-inputEl"));
		hm.put("", By.id(""));
		hm.put("edtFireProtectionClassCode", By.xpath("//input[contains(@id,'BuildingDetailPanelDV:FireProtectionClassPPC-inputEl')]"));
		hm.put("eleFireProtectionClassCode", By.xpath("//div[contains(@id,'BuildingDetailPanelDV:FireProtectionClassPPC-inputEl')]"));

		hm.put("edtPolicyInfo_IndustryClassfication", By.id("IndustryCodeSearchPopup:IndustryCodeSearchScreen:IndustryCodeSearchDV:Classification-inputEl"));

		hm.put("lstPolicyInfo_MarketGrp", By.xpath("//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:Marketgroup-inputEl']"));
		hm.put("eleModiferTable", By.xpath("//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:BP7ModifiersPanelSet:ScheduleRateDV:0:ScheduleRateLV-body']//tbody"));
		//hm.put("eleAddNewLocation", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP_tb:Add"));
		hm.put("eleOwnersNewLocation", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_LV_tb:Add-btnInnerEl"));
		hm.put("eleLocationTable", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:LocationsEdit_LV"));

		hm.put("edtNewLoc_addressLine", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));
		hm.put("edtNewLoc_Phone", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:Phone"));
		hm.put("eleNewLoc_NonSpecificLoc_YES", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:NonSpecificLocation_true-inputEl"));
		hm.put("eleNewLoc_NonSpecificLoc_NO", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:NonSpecificLocation_false-inputEl"));
		hm.put("edtNewLoc_LocCode", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:LocationCode-inputEl"));
		hm.put("edtNewLoc_LocName", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:LocationName-inputEl"));
		hm.put("lsjNewLoc_ZipCode", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));
		hm.put("eleNewLoc_ZipCode", By.id("BP7LocationPopup:LocationScreen:LocationDetailPanelSet:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl"));

		hm.put("eleNewLoc_LocDetailTbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:LocationsEdit_LV-body"));
		hm.put("eleLoc_EditBtn", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP_tb:editLocation-btnInnerEl"));
		hm.put("eleTerritory_SearchBtn", By.xpath("//a[contains(@id,'SearchAndResetInputSet:SearchLinksInputSet:Search')]"));
		hm.put("edtLoc_TerritoryCode", By.id("TerritoryCodeSearchPopup:TerritoryCodeSearchScreen:TerritoryCodeSearchDV:Code-inputEl"));
		hm.put("eleLoc_SearchTerritory", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationBusinessFieldsInputSet:TerritoryCode:SelectTerritoryCode"));
		hm.put("eleTerritoryTbl", By.id("TerritoryCodeSearchPopup:TerritoryCodeSearchScreen:TerritoryCodeSearchResultsLV-body"));

		// Additional Coverage
		hm.put("eleLoc_AdditionCovTab", By.xpath("//span[contains(@id,'AdditionalCoveragesCardTab-btnInnerEl')]"));
		hm.put("edtSearchCoverageName", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchDV:Keyword-inputEl"));
		hm.put("lstSearchCovCategory", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchDV:CoverageCategory-inputEl"));
		// hm.put("eleSearch_CovResultTbl",
		// By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleSearch_CovResultTbl", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchResultsLV-body"));

		hm.put("eleSearch_AddSelectedCovBtn", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchResultsLV_tb:AddCoverageButton-btnInnerEl"));
		// hm.put("eleAddCoverageBtn",
		// By.xpath("//span[contains(@id,'BP7AdditionalCoveragesPanelSet:BP7AdditionalCoveragesOneDV_tb:Add-btnInnerEl')]"));
		// hm.put("eleAddCoverageBtn",
		// By.xpath("//span[contains(@id,'BP7AdditionalCoveragesOneDV_tb:Add-btnInnerEl')]"));
		hm.put("eleAddCoverageBtn", By.xpath("//span[contains(text(), 'Add Coverages')]"));
		hm.put("eleEachPersonLimitvfy", By.xpath("//*[contains(@id,'BP7CoverageInputSet:CovPatternInputGroup:DirectTerm1:DirectTermInput1-labelEl')]"));

		// hm.put("eleAddCoverageBtn",
		// By.xpath("//span[contains(@id,'BP7AdditionalCoveragesOneDV_tb:Add-btnInnerEl')]"));
		hm.put("lstConstructionDetail", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7AdditionalCoveragesPanelSet:BP7AdditionalCoveragesDV:0:BP7CoverageInputSet:CovPatternInputGroup:TypeKeyTerm:TypekeyTermInput-inputEl"));

		hm.put("eljNextDisabled", By.xpath("//a[contains(@class,' x-item-disabled x-disabled x-btn-disabled x-btn-plain-toolbar-small-disabled')]//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]"));
		hm.put("eljAddCovNext", By.xpath("//a[@class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-plain-toolbar-small x-icon x-btn-icon x-btn-plain-toolbar-small-icon']//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]"));

		hm.put("elePageNumber", By.xpath("//table[@id='CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchResultsLV:_ListPaging']//following-sibling::div[contains(text(),'of')]"));
		hm.put("eleType_Exclusion", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchDV:SearchType_option1-inputEl"));
		hm.put("eleType_Condition", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchDV:SearchType_option0-inputEl"));
		hm.put("eleType_Excl_Condition", By.id("CoveragePatternSearchPopup:CoveragePatternSearchScreen:CoveragePatternSearchDV:SearchType_option2-inputEl"));
		hm.put("eleCoveragesAdd", By.xpath(""));
		hm.put("eleLoc_ExclusionConditionTab", By.xpath("//span[contains(@id,'xclusionsAndConditionsCardTab-btnInnerEl')]"));
		hm.put("eleEarthquakeCovFullLimitYes", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7AdditionalCoveragesPanelSet:BP7AdditionalCoveragesDV') and contains(@id,'BooleanTermInput_true-inputEl')]"));

		hm.put("eljBLExclusionConditionTab", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:ExclusionsAndConditionsCardTab-btnInnerEl"));

		// Dependent Coverage
		hm.put("edtDescriptionofPremises", By.id("BP7ScheduledItemPopup:PropertyInfoValues:1:ScheduledItemPropertyInputSet:StringInput:StringInputSet:Displayable-inputEl"));
		hm.put("eljAddButton", By.id("BP7ScheduledItemPopup:Add"));
		hm.put("eleLoc_AddexclusionCondition", By.xpath("//span[contains(@id,'BP7AdditionalExclusionsAndConditionsPanelSet:AddExclusionsOrCondition')]"));
		hm.put("eleLoc_AdditionalInsuredTab", By.xpath("//span[contains(@id,'AdditionalInsuredCoveragesTab-btnInnerEl')]"));
		hm.put("eljLoc_AdditionalInsuredTab", By.xpath("//span[contains(@id,'AdditionalInsuredCoveragesTab-btnInnerEl')]"));

		hm.put("eleAddtnlExclusionSection", By.xpath("//div[contains(@id,'BP7AdditionalExclusionsAndConditionsPanelSet:ExclusionsPanel:BP7AdditionalExclusionsDV_ref')]"));

		// Modifiers
		hm.put("eleModifiers", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:ttlBar"));
		hm.put("eleModifier_Tab", By.xpath(".//*[contains(@id,'LOBWizardStepGroup:Modifiers')]/div"));
		hm.put("edtModifier_ExpenseModific", By.xpath("//input[contains(@id,'ratingInputName-inputEl')]"));
		hm.put("edtModifier_RateTierFac", By.xpath("//input[contains(@id,':rateTierFactor-inputEl')]"));
		hm.put("edtModifier_ScheduleRatingFac", By.xpath("//input[contains(@id,'ScheduleRatingFactor')]"));
		hm.put("eleBO_SaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eljBO_SaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eleBO_DetailsTab", By.xpath("//span[contains(@id,'BP7LinePanelSet:DetailsTab-btnInnerEl')]"));
		hm.put("eljBO_DetailsTab", By.xpath("//span[contains(@id,'BP7LinePanelSet:DetailsTab-btnInnerEl')]"));
		// hm.put("eleModifierTbl",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:BP7ModifiersPanelSet:ScheduleRateDV:0:ScheduleRateLV-body"));
		hm.put("eleModifierTbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:BP7ModifiersPanelSet:0:BP7ScheduleRate_ExtDV:ScheduleRateLV"));
		hm.put("eleModifierTitle", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:ttlBar"));
		hm.put("lsjCredit(-)/Debit(+)", By.name("CreditDebit"));
		hm.put("edtJustification", By.name("Justification"));
		hm.put("eleErrorMessage", By.xpath("//div[contains(@id,'ModifiersScreen:_msgs')]/div"));
		hm.put("edtNGS_Ijudgethisrisktobe", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:BP7ModifiersPanelSet:BP7NonScheduleRateMod_ExtPanelSet:scheduleratemodrisk-inputEl"));
		hm.put("eleErrorimg", By.xpath(".//div[img[@class='error_icon']]"));
		// Building&Classficiation:
		hm.put("eleBuildingsAndClassificationsTAB", By.xpath(".//span[contains(text(),'Buildings and Classifications')]"));
		hm.put("eleBldClas_AddBuilding", By.xpath("//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP_tb:Add']"));
		hm.put("lstBldPercentOwner", By.xpath("//*[contains(@id,'BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:PercentOwnerOccupied-inputEl')]"));
		hm.put("lstTypeCuisine", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'TypeOfCuisine-inputEl')]"));
		hm.put("PropertyBaseCovErrorMsg", By.xpath("//*[contains(text(),''Property Base Coverages' is required')]"));
		hm.put("edtWelfareNoEmp", By.xpath("//*[contains(@id,'BP7CovTermInputSet:DirectTermInput-inputEl')]"));

		hm.put("edtCemeNoBodies", By.xpath("//*[contains(@id,'BP7AdditionalCoveragesDV:0:BP7CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"));
		hm.put("lstFireProtectionClass", By.xpath("//*[contains(@id,'BuildingDetailPanelDV:FireProtectionClassPPC-inputEl')]"));
		hm.put("edtBC_AnnualSalesRevenue", By.xpath(".//input[contains(@id,'BuildingDetailPanelDV:AnnualSales-inputEl')]"));
		hm.put("eleBldDet_BPPChk", By.xpath("//*[contains(@id,'BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:MandatoryCoveragesStandardProperty:BP7CoveragesDV:6:BP7CoverageInputSet:CovPatternInputGroup:_checkbox')]"));
		hm.put("eleBldClas_AddBuilding_MulLoc", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP_tb:addBuildingButton"));
		// hm.put("eleExclusionBtn",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:PolicyLevelExclusionsAndConditions:BP7AdditionalExclusionsAndConditionsPanelSet:AddExclusionsOrCondition-btnInnerEl"));
		hm.put("eleExclusionBtn", By.xpath("//span[contains(@id,'AddExclusionsOrCondition-btnInnerEl')]"));

		hm.put("edtExposure", By.name("Exposure")); 

		hm.put("eleBuildingDetailSection", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:GeneralInfoCardTab:panelId"));

		hm.put("edtExposure", By.name("Exposure"));

		hm.put("eleBuildingDetailSection", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:GeneralInfoCardTab:panelId"));

		hm.put("eleBldClas_AddBuilding_SingleLoc", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP_tb:Add-btnInnerEl"));
		// hm.put("eleExclusionBtn",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:policyLevelExclusionsAndConditions:AdditionalExclusionsAndConditionsPanelSet:AddExclusionsOrCondition-btnInnerEl"));
		hm.put("edtExposure", By.name("Exposure"));
		hm.put("eleIsFranchise", By.xpath(".//*[contains(text(),'Is this a franchise?')]"));
		hm.put("eleFranchiseYesOption", By.xpath(".//*[contains(@id,':IsFranchiseIDInd_Ext_true-inputEl') and @role='radio']"));
		hm.put("eleFranchiseNoOption", By.xpath(".//*[contains(@id,':IsFranchiseIDInd_Ext_false-inputEl') and @role='radio']"));

		hm.put("edtStoreId", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:StoreID-inputEl"));
		hm.put("eleStoreIdLabel", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:StoreID-labelEl"));
		hm.put("eleBuildingDetailSection", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:GeneralInfoCardTab:panelId"));

		hm.put("eleMulitpleLocList", By.xpath("//span[contains(@id,'location-textEl')]"));
		hm.put("eleBuildingDetailSection", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:GeneralInfoCardTab:panelId"));
		hm.put("eleMulitpleLocList", By.xpath("//span[contains(@id,'location-textEl')]"));
		hm.put("lsjBuilding_code_grade", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:EffectivenessGrade-inputEl"));
		hm.put("eleBuilding_Classification_table", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BuildingsEdit_LV-body"));
		// hm.put("lsjBldCode_EffectivenessGrade",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:EffectivenessGrade-inputEl"));

		hm.put("edtBuildingValue", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:BuildingValue_Ext-inputEl"));

		hm.put("eleQoute", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		hm.put("eleToleranceYes", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'CostimatWitInTlrncInd_Ext_true-inputEl')]"));
		hm.put("eleFireProtectionYes", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'DoesInsSubToFirePro_true-inputEl')]"));
		hm.put("eleFireProtectionNo", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'DoesInsSubToFirePro_false-inputEl')]"));
		hm.put("edtImportedProductsPercentage", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'ImportedProductsPercentage-inputEl')]"));
		hm.put("edtYearModern", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'YearModernized_Ext-inputEl')]"));
		hm.put("edtLiquorSale", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'LiquorSales_Ext-inputEl')]"));
		hm.put("eleNoFireSub", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'DoesInsSubToFirePro_false-inputEl')]"));
		hm.put("lstModern_Credit", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'BuildingModenCredit_Ext-inputEl')]"));
		hm.put("eleModernizationCreditLabel", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'BuildingModenCredit_Ext-labelEl') and contains(text(),'Building Modernization Credit')]"));
		hm.put("eleFranchiseIdLabel", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'FranchiseID_Ext-labelEl') and contains(text(),'Franchise ID')]"));
		hm.put("eleIndividualGraded_No", By.xpath("//input[contains(@id,'IsIndividuallyGraded_Ext_false-inputEl')]"));

		// new elements
		hm.put("eleErrorBanner", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,'Screen:_msgs')]"));
		hm.put("lstPrintingSchedule", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':PrintingPressType-inputEl')]"));
		hm.put("lstPrintManufacturer", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':Manufacturer-inputEl')]"));
		hm.put("edtPrintModel", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':Model-inputEl')]"));
		hm.put("edtSheetLength", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':MaxSheetLength-inputEl')]"));
		hm.put("edtSheetWidth", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':MaxSheetWidth-inputEl')]"));
		hm.put("lstColorNumber", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':NumberofColors-inputE')]"));
		hm.put("elePrintingPressTab", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,'printiingpressscheduleTab-btnInnerEl')]"));
		hm.put("edtCostPrint", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,':ReplacementCostValue-inputEl')]"));
		hm.put("elePrintAddBtn", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,'BuildingDetailCV:Add-btnInnerEl')]"));
		hm.put("eleAdditionalInterestTab", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,'BuildingAddlInterestTab-btnInnerEl')]"));
		hm.put("eleAddBtn_AdditionalInterest", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet') and contains(@id,'AdditionalInterestLV_tb:AddContactsButton-btnWrap')]"));
		hm.put("lstInterestType", By.xpath(".//*[contains(@id,'Popup:ContactDetailScreen:AdditionalInterestInfoDV:Type-inputEl')]"));
		hm.put("edtCompanyName_AddInterest", By.xpath(".//*[contains(@id,'Popup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl')]"));
		hm.put("edtDescInterest", By.xpath(".//*[contains(@id,'Popup:ContactDetailScreen:AdditionalInterestInfoDV:DescriptionOfProperty-inputEl')]"));
		hm.put("eleOkAddInterest", By.xpath(".//*[contains(@id,'Popup:ContactDetailScreen:Update')]"));
		hm.put("eleAddInterest_Company", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet') and contains(@id,'AddContactsButton:0:ContactType-textEl')]"));
		hm.put("eleAddInterest_Person", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet') and contains(@id,'AddContactsButton:1:ContactType-textEl')]"));
		hm.put("eleAddInterest_BannerMsg", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet') and contains(@id,'BP7BuildingDetailCV:3')]"));
		hm.put("eleImportedPercentageLabel", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet') and contains(@id,':ImportedProductsPercentage-labelEl')]"));
		// hm.put("lstInterestType",
		// By.id("BP7NewAdditionalInterestPopup:ContactDetailScreen:AdditionalInterestInfoDV:Type-inputEl"));
		// new elements
		hm.put("edtPercentOwner", By.xpath(".//input[contains(@id,'PercentageOwnerOccupied_Ext-inputEl')]"));
		hm.put("elePercentageOwnerLabel", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'PercentageOwnerOccupied_Ext-labelEl')]"));
		hm.put("eleFireProtectionNo", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'DoesInsSubToFirePro_false-inputEl')]"));
		hm.put("edtImportedProductsPercentage", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'ImportedProductsPercentage-inputEl')]"));
		hm.put("eleBuildingsAndClassificationsTable", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BuildingsEdit_LV"));
		hm.put("eleClassificationTable", By.xpath("//div[contains(@id,':Classifications_LV-body')]/div/table/tbody/tr/td[3]/div"));
		hm.put("eleRemoveBuildings", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP_tb:Remove-btnInnerEl"));
		hm.put("eleRemove_OK", By.id("button-1005-btnInnerEl"));
		hm.put("eleSelectBuilding", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP_tb:PPC-btnInnerEl']//following::img[2]"));
		hm.put("eleSetAsPrimaryBuilding", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP_tb:setAsPrimary-btnInnerEl"));
		// hm.put("edtBPPLimit",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:MandatoryCoveragesStandardProperty:BP7CoveragesDV:6:BP7CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl"));

		hm.put("eleExposureField", By.xpath(".//*[contains(@id,'BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body')]//td[6]"));

		// hm.put("eleExposureField",
		// By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body']//td[5]"));
		// hm.put("eleClassificationSearch",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV:0:Classification:SelectClassification"));
		// hm.put("eleClassification",
		// By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body']//td[2]"));

		hm.put("eleClassificationSearch", By.xpath("//*[contains(@id,'BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV:0:Classification:SelectClassification')]"));

		hm.put("eleClassification", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body']//td[3]"));
		hm.put("eleClassification", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body']//td[2]"));

		hm.put("eleClassification", By.xpath(".//*[contains(@id,'BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body')]//td[3]"));
										
		hm.put("eleClassCodeSearch", By.id("BP7ClassCodeSearch_ExtPopup:BP7ClassCodeSearchScreen:SearchAndResetInputSet:SearchLinksInputSet:Search"));
		hm.put("eleClassCodeReset", By.id("BP7ClassCodeSearch_ExtPopup:BP7ClassCodeSearchScreen:SearchAndResetInputSet:SearchLinksInputSet:Reset"));
		hm.put("eleCodeSearchHyperLink", By.id("BP7ClassCodeSearch_ExtPopup:__crumb__"));
		hm.put("eleClassCodeSearchTitile", By.id("BP7ClassCodeSearch_ExtPopup:BP7ClassCodeSearchScreen:ttlBar"));
		// To Verify Sub-screens for Additional Coverage and Exclusions & Conditions in
		// Buildings and Classifications
		hm.put("eleAdditionalCoveragesTabForBuildings_Page", By.id("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:1' and contains(text(),'Additional Coverages')]"));
		hm.put("eleExclusionsAndConditionsTabForBuildings_Page", By.id("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:exclusionsAndConditionsCardTab-btnInnerEl' and contains(text(),'Exclusions & Conditions')]"));
		hm.put("eleSearchCoveragesForBuilding_Page", By.xpath("//*[@id='CoveragePatternSearchPopup:CoveragePatternSearchScreen:ttlBar' and contains(text(),'Search Coverages')]"));
		hm.put("eleSearchExclusionsAndConditionsForBuilding_Page", By.xpath("//*[@id='CoveragePatternSearchPopup:CoveragePatternSearchScreen:ttlBar' and contains(text(),'Search Exclusions And Conditions')]"));
		//hm.put("eleAddExclusionOrConditionbtn", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:policyLevelExclusionsAndConditions:AdditionalExclusionsAndConditionsPanelSet:AddExclusionsOrCondition-btnInnerEl"));


		// Building details
		hm.put("lsjBldClas_PropType", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:PropertyType-inputEl"));
		hm.put("lsjBldClas_EffectivenessGrade", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:EffectivenessGradeClass-inputEl"));
		hm.put("lstBldClas_ConstructionType", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'ConstructionType-inputEl')]"));
		hm.put("lstBC_LTTaxExemption", By.xpath(".//input[contains(@id,'BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:DoestaxExemptApply-inputEl')]"));
		hm.put("eleBldClas_AutoSprinklerYes", By.xpath(".//input[contains(@id,'BuildingDetailPanelDV:Sprinklered_true-inputEl')]"));
		hm.put("eleBldClas_AutoSprinklerNo", By.xpath(".//input[contains(@id,'BuildingDetailPanelDV:Sprinklered_false-inputEl')] "));
		hm.put("eleBldClas_RatewitRiskYes", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:RABOPWanted_true-inputEl"));
		hm.put("eleBldClas_RatewitRiskNo", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:RABOPWanted_false-inputEl"));
		hm.put("edjBldClas_BuildingDesc", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Description-inputEl"));
		hm.put("edjBldClas_BuildingCode", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:buildingcode-inputEl"));

		hm.put("edtBldClas_SquareFootage", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'SquareFootage_Ext-inputEl')]"));
		hm.put("lstBldClas_BuldOccupancy", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'BuildingOccupancy_Ext-inputEl')]"));
		hm.put("lstBldClas_BuldOccupancyType", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'BuildingOccupancyType_Ext-inputEl')]"));

		hm.put("edtBldClas_StoriesNo", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'NumberofStories_Ext-inputEl')]"));

		hm.put("lstBldClas_LastRoof", By.xpath(".//*[contains(@id, 'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'LastReplacement_Ext-inputEl')]"));

		hm.put("edtBldClas_LastRoofYear", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:YearOfReplacement_Ext-inputEl"));
		hm.put("lstBldClas_FireProtectionClass", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:FireProtectionClassPPC-inputEl"));

		// hm.put("lstBldClas_FireProtectionClass",
		// By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet')
		// and contains(@id,'FireProtectionClass_Ext-inputEl')]"));
		hm.put("lstBldClas_PercentOwnerOccupied", By.xpath(".//*[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'OwnerOccupied_Ext-inputEl')]"));
		// hm.put("lstBldClas_RoofType",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:RoofType_Ext-inputEl"));

		hm.put("ImportedProductsPercentage", By.xpath("//input[contains(@id,'ImportedProductsPercentage-inputEl')]"));

		// AddClassification
		hm.put("eljBldClas_AddClassification", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BlstBldClas_LastRoofP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail_tb:Add-btnInnerEl"));
		hm.put("lsjClassification_ClassDesc", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:ClassDescription-inputEl"));
		hm.put("edtClassification_SqFootage", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:Area-inputEl"));

		hm.put("eljClassification_AmusementAreaYes", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:AmusementArea_true-inputEl"));
		hm.put("eljClassification_AmusementAreaNo", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:AmusementArea_false-inputEl"));
		hm.put("lstClassification_Playgrnd", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:Playground-inputEl"));
		hm.put("eljClassification_RatewitRiskYes", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:ClassificationRABOPWanted_true-inputEl"));
		hm.put("eljClassification_RatewitRiskNo", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:ClassificationRABOPWanted_false-inputEl"));

		hm.put("lstClassfication_PropRiskAnaysesType", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:ClassificationRABOPType-inputEl"));
		hm.put("lstClassfication_LiablityOccRiskAnayserType", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:ClassificationRABOPTypeLiabilityOccu-inputEl"));

		hm.put("eleFunctionalVal_Tab", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ClassificationsListDetail:FunctionalValuationCoveragesCardTab-btnInnerEl"));
		hm.put("eleClassification_AddCovTab", By.xpath("//span[contains(@id,'ClassificationsListDetail:AdditionalCoveragesCardTab-btnInnerEl')]"));
		hm.put("eleClassification_AddExclusionTab", By.xpath("//span[contains(@id,'ExclusionsAndConditionsCardTab-btnInnerEl')]"));
		hm.put("eleDetailsTab", By.xpath("//span[contains(@id,'GeneralInfoCardTab-btnInnerEl')]"));
		hm.put("eleReturnToLink", By.xpath("//a[@id='CoveragePatternSearchPopup:__crumb__']"));

		// Blanket
		hm.put("eleRemoveBlanket", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BlanketScreen:BP7BlanketPanelSet:BlanketEdit_DP_tb:Remove-btnInnerEl"));
		hm.put("eleBlanketRemoveTbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BlanketScreen:BP7BlanketPanelSet:BlanketEdit_DP:BlanketEdit_LV-body"));
		hm.put("eleBlanketAllRemove", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BlanketScreen:JobWizardToolbarButtonSet:CloseOptions-btnInnerEl']//following::div[@class='x-grid-checkcolumn']"));
		hm.put("eleBlanketTitle", By.id("BP7BlanketPopup:ttlBar"));
		hm.put("eleBlanketScreenTitle", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BlanketScreen:ttlBar"));
		// .put("eleBlanketAdd",
		// By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:BP7BlanketCoveragesLV_tb:AddToBlanketButton-btnInnerEl"));
		// hm.put("lsjblktType",
		// By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:BlanketType-inputEl"));
		// .put("eleBlanketAddTo",
		// By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:BP7BlanketCoveragesLV_tb:AddToBlanketButton-btnInnerEl"));
		hm.put("eleBlanketAddCoverages", By.id("BP7BlanketCoveragesSearchPopup:BP7BlanketCoveragesLV_tb:attachSelectedButton-btnInnerEl"));
		hm.put("eleBlanketRemove", By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:BP7BlanketCoveragesLV_tb:RemoveFromBlanketButton-btnInnerEl"));
		hm.put("eleBlanketOK", By.id("BP7BlanketPopup:Update-btnInnerEl"));
		hm.put("eljBlanketOK", By.id("BP7BlanketPopup:Update-btnInnerEl"));
		hm.put("eleBlanketRemove", By.id("BP7BlanketPopup:Cancel-btnInnerEl"));
		hm.put("eleBlanketCancel", By.id("BP7BlanketPopup:Cancel-btnInnerEl"));
		hm.put("eleDraftSave", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BlanketScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));

		// hm.put("eleValidationMsg",
		// By.xpath("//div[@id='WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs']//div[@class='message']"));
		hm.put("eleValidationMsg", By.xpath("//div[@id='WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs']"));
		hm.put("eleValidationMsg_BulkAct", By.xpath("//div[@id='CreateBulkActivity_Ext:_msgs']"));
		hm.put("eljBlanket_Next", By.id("SubmissionWizard:Next"));
		hm.put("eleBillingContactLink", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:ChangeBillingContactButton-inputEl"));

		// Blanket

		hm.put("eljAddBlanket", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BlanketScreen:BP7BlanketPanelSet:BlanketEdit_DP_tb:Add-btnInnerEl"));
		hm.put("lstBlanketType", By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:BlanketType-inputEl"));
		hm.put("lstGroupType", By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:GroupType-inputEl"));
		hm.put("eleBlanket_Location", By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:location-inputEl"));
		hm.put("selLocation", By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:location-inputEl"));
		hm.put("eljBlanketPopup_AddBlanket", By.id("BP7BlanketPopup:BP7BlanketDetailPanelSet:BP7BlanketCoveragesLV_tb:AddToBlanketButton-btnInnerEl"));
		hm.put("eleBlanketTbl", By.id("BP7BlanketCoveragesSearchPopup:BP7BlanketCoveragesLV-body"));
		hm.put("eleAllBlanketCov_Chk", By.xpath("//div[@id='BP7BlanketCoveragesSearchPopup:BP7BlanketCoveragesLV']//div[@class='x-grid-checkcolumn']"));
		hm.put("eljBlanketPopup_ReturnLink", By.xpath("//a[@id='BP7BlanketCoveragesSearchPopup:__crumb__']"));

		hm.put("edtPolicyInfo_NoOfLOB", By.xpath("//input[contains(@id,'PolicyInfoDV:AccountInfoInputSet:NumberofLinesofBusiness-inputEl')]"));
		hm.put("edtPolicyInfo_YrBusinessStarted", By.xpath("//input[contains(@id,'PolicyInfoDV:AccountInfoInputSet:YearBusinesssStarted')]"));
		hm.put("lstPolicyInfo_UWCompany", By.xpath("//input[contains(@id,'PolicyInfoDV:UWCompanyInputSet:UWCompany-inputEl')]"));

		hm.put("edtBO_Job ClassificationTBD", By.name("c2"));
		hm.put("edtBO_EmployeeTBD", By.name("c3"));
		hm.put("eleBusinesSOwnerTitle", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:ttlBar"));

		hm.put("eleValidation_ClearBtn", By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl"));
		hm.put("rdoBuilding_LiabilityOnly_No", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:LiabilityOnlyBuilding_Ext_false-inputEl"));
		hm.put("rdoBuilding_LiabilityOnly_Yes", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:LiabilityOnlyBuilding_Ext_true-inputEl"));

		hm.put("eleTab_BusinessOwner", By.xpath("//td[contains(@id,'WizardStepGroup:LineCoverages')]//span[text()='Businessowners Line']"));

		hm.put("eleNGS_SaveDraft", By.xpath("//span[contains(@id,'JobWizardToolbarButtonSet:Draft-btnInnerEl')]"));

		hm.put("edtPolicyInfo_PreClassCode_Popup", By.xpath(".//*[contains(@id,'ClassCodeSearchScreen:Code-inputEl')]"));
		hm.put("elePredominateSearchRes", By.xpath(".//*[contains(@id,'BP7ClassCodeSearchScreen:1-body')]"));

		// hm.put("elePolicyInfo_PredominantClassCode",By.xpath(".//*[contains(@id,'PredoClassCode:SelectPredoClassCode']"));

		// hm.put("elePolicyInfo_PredominantClassCode",By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:predoclasscode:Selectpredoclasscode"));
		hm.put("elePolicyInfo_PolicySymbol", By.xpath(".//*[contains(@id,'PolicySymbol-inputCell')]"));
		hm.put("elePolicyInfo_PredominantClassCode", By.xpath(".//*[contains(@id,'PredoClassCode:SelectPredoClassCode')]"));
		hm.put("edtPolicyInfo_PreClassCode_Popup", By.xpath(".//*[contains(@id,'ClassCodeSearchScreen:Code-inputEl')]"));
		hm.put("elePredominateSearchRes", By.xpath(".//*[contains(@id,'BP7ClassCodeSearchScreen:1-body')]"));
		hm.put("edtPolicyInfo_PreClassCode_Popup", By.xpath("//*[contains(@id,'BP7ClassCodeSearchScreen:Code-inputEl')]"));
		hm.put("elePredominateSearchRes", By.xpath("//*[contains(@id,'BP7ClassCodeSearchScreen:1-body')]"));
		hm.put("edtPolicyInfo_PreClassDesc_Popup", By.id("BP7ClassCodeSearchPopup:BP7ClassCodeSearchScreen:ClassCodeDescription-inputEl"));
		hm.put("elePolicyCommission", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:commissionPercent-inputEl"));
		hm.put("elePolicyCommissionAfterIssue", By.id("PolicyFile_Pricing:PolicyFile_PricingScreen:PolicyFile_Quote_SummaryDV:commissionPercent-inputEl"));
		hm.put("eleQuote_TotalPremium", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:TotalPremium-inputEl"));

		// Forms
		// hm.put("eleFormsTab", By.xpath(".//*[contains(@id,
		// 'RenewalWizard:Forms')]/div"));
		hm.put("eleFormsTab", By.xpath("//span[text()='Forms']"));
		hm.put("eleSystemGenerated", By.xpath("//span[contains(text(),'System-Generated')]"));
		hm.put("SystemForms", By.xpath("//div[contains(@id,'Forms1LV-body')]"));
		hm.put("eleFormsTitle", By.xpath("//span[contains(@class,'g-title') and contains(text(),'Forms')]"));
		hm.put("eleDocumentsAssert", By.xpath("//span[contains(@class,'g-title') and contains(text(),'Account File Documents')]"));
		// hm.put("FormsBody",
		// By.id("PolicyFile_Forms_WC7:PolicyFile_PolicyLine_FormsScreen:PolicyFileFormsCV:FormsLV-body"));
		hm.put("FormsBody", By.xpath("//*[contains(@id,'FormsCV:FormsLV-body')]"));
		hm.put("FormsBodySysGen", By.id("PolicyFile_Forms_WC7:PolicyFile_PolicyLine_FormsScreen:PolicyFileFormsCV:Forms1LV-body"));
		hm.put("RenewalSystemGenFormsBody", By.id("RenewalWizard:PostQuoteWizardStepSet:FormsScreen:FormsCV:Forms1LV-body"));

		// Submission Withdrawn

		hm.put("eleSubmissionWithdrawn", By.id("JobComplete:JobCompleteScreen:ttlBar"));

		// Submission Declined
		hm.put("eleSubmissionDeclined", By.id("DeclineReasonPopup:RejectScreen:ttlBar"));
		hm.put("lsjReasonCode", By.xpath(".//*[contains(@id,'RejectReason-inputEl')]"));
		hm.put("eleDecline", By.id("DeclineReasonPopup:RejectScreen:Update-btnInnerEl"));
		hm.put("eleSubmissionDeclined_JobComplete", By.id("JobComplete:JobCompleteScreen:ttlBar"));

		hm.put("btnAlertPopUp", By.id("button-1005-btnInnerEl")); // ICON Validation

		hm.put("eljAccountNumber", By.xpath("//a[@id='SubmissionWizard:JobWizardInfoBar:AccountNumber']"));
		hm.put("elePolicySummary_Tab", By.xpath(".//*[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Summary']/div/span"));
		hm.put("eleAccountSummary_AccountName", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:Name-inputEl"));
		hm.put("eleAccountSummary_FEIN", By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl']"));
		hm.put("eleAccountSummary_Address", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AddressShortInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"));
		hm.put("eleAccountSummary_Phone", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:PhoneNumber-inputEl"));
		hm.put("eleAccountSummary_Email", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:Email-inputEl"));
		hm.put("eleAccountSummary_Website", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:website_Ext-inputEl"));
		hm.put("eleAccountSummary_ProducerCode", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV:0:code"));
		// hm.put("eleAccountSummary_ProducerCode",
		// By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV-body']//tr//td[1]/div"));
		hm.put("eleAccountSummary_AgencyName", By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV-body']//tr//td[2]/div"));
		hm.put("eleAccountSummary_AgencyName", By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV-body']//tr[1]//td[2]/div"));
		hm.put("eleAccountContacts_Name", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("eleAccountContacts_Phone", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:WorkPhone:GlobalPhoneInputSet:PhoneDisplay-inputEl"));
		hm.put("eleAccountContacts_Email", By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:EmailAddress1-inputEl"));
		hm.put("elePolicyInfo_Product", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_PolicyDV:Product-inputEl"));
		hm.put("elePolicyInfo_Name", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:Name-inputEl')]"));
		hm.put("elePolicyInfo_PhoneNo", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:Phone:GlobalPhoneInputSet:PhoneDisplay-inputEl')]"));
		hm.put("elePolicyInfo_Address", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:PolicyAddressDisplayInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl')]"));
		hm.put("elePolicyInfo_FEIN", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:PolicyOfficialIDInputSet:OfficialIDDV_Input-inputEl')]"));
		hm.put("edtPolicyInfo_FEIN", By.xpath("//*[contains(@id,'AccountInfoInputSet:PolicyOfficialIDInputSet:OfficialIDDV_Input-inputEl')]"));
		hm.put("elePolicyInfo_TermType", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:TermType-inputEl')]"));
		hm.put("elePolicyInfo_ProductType", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:ProductType-inputEl')]"));
		hm.put("lstPolicyInfo_ProductType", By.xpath("//input[contains(@id,'ProductType-inputEl')]"));
		hm.put("elePolicyInfo_Segment", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:Segment-inputEl')]"));
		hm.put("elePolicyInfo_ProducerCode", By.xpath("//*[contains(@id,':ProducerCode_Ext-bodyEl')]"));
		hm.put("elePolicyInfo_AgencyName", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:AgencyName_Ext-inputEl')]"));
		hm.put("elePolicyInfo_EffDate", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:EffectiveDate_date-inputEl')]"));
		hm.put("elePolicyInfo_ExpDate", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:ExpirationDate_date-inputEl')]"));
		hm.put("elePolicyInfo_OrgType", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:OrganizationType-inputEl')]"));
		hm.put("lstPolicyInfo_OrgType", By.xpath("//*[contains(@id,'AccountInfoInputSet:OrganizationType-inputEl')]"));
		hm.put("edtPolicyInfo_SICCode", By.xpath("//*[contains(@id,'AccountInfoInputSet:IndustryCode-inputEl')]"));
		hm.put("edtSORSICCode", By.xpath("//*[contains(@id,'AccountInfoInputSet:IndustryCode-inputEl')]"));
		hm.put("edtPolicyInfo_NAICSCode", By.xpath("//*[contains(@id,'AccountInfoInputSet:NAICSIndustryCode-inputEl')]"));
		hm.put("edtSORNAICSCode", By.xpath("//*[contains(@id,'AccountInfoInputSet:NAICSIndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_NAICSDesc", By.xpath("//textarea[contains(@id,'PolicyInfoDV:AccountInfoInputSet:NAICSDescription-inputEl')]"));
		hm.put("edtPolicyInfo_MSICode", By.xpath("//*[contains(@id,'AccountInfoInputSet:MSIExt-inputEl')]"));
		hm.put("edtSORMSICode", By.xpath("//*[contains(@id,'AccountInfoInputSet:MSIExt-inputEl')]"));
		hm.put("edtPolicyInfo_YearBusinessstarted", By.xpath("//*[contains(@id,'AccountInfoInputSet:YearBusinesssStarted-inputEl')]"));
		// hm.put("edtPolicyInfo_YearBusinessstarted",By.xpath("//*[contains(@id,'AccountInfoInputSet:YearBusinessStarted-inputEl')]"));
		hm.put("elePolicyInfo_SubmissionSource", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:SubmissionSource-inputEl')]"));
		// hm.put("lstPolicyInfo_SubmissionSource",By.xpath("//*[contains(@id,'PolicyInfoInputSet:SubmissionSource-inputEl')]"));
		hm.put("lstSORSubmissionSource", By.xpath("//*[contains(@id,'PolicyInfoInputSet:SubmissionSource-inputEl')]"));
		hm.put("elePolicyInfo_SICCode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:IndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_NAICSCode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:NAICSIndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_MSICode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:MSIExt-inputEl')]"));
		hm.put("elePolicyInfo_YearBusinessstarted", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:YearBusinessStarted-inputEl')]"));
		hm.put("eleAccountContacts_NameInsured", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[1]"));
		hm.put("eleAccountContacts_NameInsured", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[1]"));
		hm.put("eleAccountContacts_DBA", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[1]/td[7]"));
		hm.put("edtPolicyInfo_NAICSCode", By.xpath("//*[contains(@id,'AccountInfoInputSet:NAICSIndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_NAICSDesc", By.xpath("//textarea[contains(@id,'PolicyInfoDV:AccountInfoInputSet:NAICSDescription-inputEl')]"));
		hm.put("edtPolicyInfo_MSICode", By.xpath("//*[contains(@id,'AccountInfoInputSet:MSIExt-inputEl')]"));
		hm.put("elePolicyInfo_SubmissionSource", By.xpath("//div[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:SubmissionSource-inputEl')]"));
		hm.put("lstPolicyInfo_SubmissionSource", By.xpath("//*[contains(@id,'PolicyInfoInputSet:SubmissionSource-inputEl')]"));
		hm.put("elePolicyInfo_SICCode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:IndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_NAICSCode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:NAICSIndustryCode-inputEl')]"));
		hm.put("elePolicyInfo_MSICode", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:MSIExt-inputEl')]"));
		hm.put("elePolicyInfo_YearBusinessstarted", By.xpath("//div[contains(@id,'PolicyInfoDV:AccountInfoInputSet:YearBusinessStarted-inputEl')]"));
		hm.put("eleAccountContacts_DBA", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[1]/td[7]"));

		// new
		hm.put("eleAccountContacts_NameAccountHolder", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[2]/td[3]"));
		hm.put("eleAccountContacts_PhoneAccountHolder", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[2]/td[5]"));
		hm.put("eleAccountContacts_EmailAccountHolder", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[2]/td[6]"));
		hm.put("eleAccountContacts_DBAAccountHolder", By.xpath("//div[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']//tr[2]/td[7]"));
		hm.put("elePolicyInfo_BaseState", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:BaseState-inputEl']"));
		hm.put("elePolicyInfo_SubType", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:SubmissionType-inputEl']"));

		hm.put("eleLocations_State", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:State-inputEl']"));
		hm.put("eleLocations_ZipCode", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:PostalCode-inputEl']"));
		hm.put("eleLocations_Phone", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationDetailInputSet:Phone-inputEl']"));
		hm.put("eleLocations_Country", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LocationScreen:BP7LocationPanelSet:LocationsEdit_DP:BP7LocationDetailCV:BP7LocationDetailInputSet:AddressInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl"));
		hm.put("elePolicyInfo_AddressType", By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:PolicyAddressDisplayInputSet:AddressType-inputEl']"));
		hm.put("eleRiskAnalysis_NoissuanceFlag", By.id("PolicyFile_RiskAnalysis:PolicyFile_RiskAnalysisScreen:PolicyFile_RiskAnalysisCV:RiskEvaluationPanelSet:NoIssuesMessage"));
		hm.put("eleRiskAnalysisQuote_NoissuanceFlag", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:NoIssuesMessage"));
		hm.put("eleAIFNum", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:aif_Ext-bodyEl"));
		hm.put("elePolicyInfo_PolicyStatus", By.id("PolicyFile:PolicyFileMenuInfoBar:StatusAndExpDate-btnInnerEl"));
		hm.put("eleRiskAnalysis_RiskAnalysis", By.id("PolicyFile:MenuLinks:PolicyFile_PolicyFile_RiskAnalysis"));
		hm.put("eleRiskAnalysis_UWIssues", By.id("PolicyFile_RiskAnalysis:PolicyFile_RiskAnalysisScreen:PolicyFile_RiskAnalysisCV:PolicyFile_EvaluationIssuesCardTab-btnInnerEl"));
		hm.put("eleStateCoverage_StateCoverage", By.id("SubmissionWizard:LOBWizardStepGroup:WC7WorkersCompStateCoverages"));
		hm.put("eleStateCoverage_RiskScore", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:riskScore_Ext-inputEl"));
		hm.put("elePolicyInfo_BOR_startDate", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:BORStartDate-inputEl"));
		hm.put("elePolicyInfo_BOR_EndDate", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:BOREndDate-inputEl"));
		// hm.put("eleSubmissionQuoted",
		// By.id("SubmissionWizard:JobWizardInfoBar:JobLabel-btnInnerEl"));
		// hm.put("eleAccountNumberClick",
		// By.id("SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl"));
		hm.put("eleAccountNumberClick", By.xpath("//*[contains(@id,'AccountNumber-btnInnerEl')]"));
		hm.put("eleIssuanceFlag", By.id("PolicyFile_RiskAnalysis:PolicyFile_RiskAnalysisScreen:PolicyFile_RiskAnalysisCV:RiskEvaluationPanelSet:0-body"));
		hm.put("eleAccountSummary_ActivityNill", By.xpath("//div[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV-body']//tr[1]/td[1]"));
		hm.put("eleRiskAnalysis_Button", By.xpath("//*[contains(text(),'Risk Analysis')]"));
		hm.put("eleDocumentTableIssued", By.id("PolicyFile_Documents:Policy_DocumentsScreen:DocumentsLV-body"));
		hm.put("eleStateCoverage_StateCoverageIssued", By.xpath("//span[text() = 'State Coverages' and @class = 'x-tree-node-text ']"));
		hm.put("eleSummary_BillingNumber", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingNumber_Ext-btnInnerEl"));
		hm.put("eleAccountSummary_AIFNumber", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:aif_Ext-inputEl"));
		hm.put("eleAccountNumberClickPolicy", By.id("PolicyFile:PolicyFileMenuInfoBar:AccountNumber-btnInnerEl"));
		hm.put("eleDocumentTableIssued", By.id("PolicyFile_Documents:Policy_DocumentsScreen:DocumentsLV-body"));
		// hm.put("eleStateCoverage_RiskScoreIssued",
		// By.id("PolicyFile_WC7StateCoverages:PolicyFile_WC7StateRateScreen:WC7StateCoverageCV:riskScore_Ext-inputEl"));
		// //AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl
		hm.put("eleStateCoverage_RiskScoreIssued", By.xpath("//*[contains(@id,':riskScore_Ext-inputEl')]")); // AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl
		hm.put("edtSpecificReason", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:StringTermInput-inputEl"));
		hm.put("clrGuranteedCost_RiskAlternative", By.id("PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UnsplitModifiers:WC7ModifiersInputSet:WC7JurisdictionModifierInput:WC7JurisdictionModifierInputSet:ModIteratorEligible:2:EligibilityInputGroup:ModifierInput-inputEl"));
		hm.put("eleSubmissionBound", By.xpath("//*[contains(text(),'(Bound)')]"));
		hm.put("eleSubmissionQuote", By.xpath("//*[contains(text(),'(Quoted)')]"));
		hm.put("eleSubmissionDraft", By.xpath("//*[contains(text(),'Submission (Draft)')]"));
		hm.put("eleSubmissionWithdrawn", By.xpath("//*[contains(text(),'(Withdrawn)')]"));
		hm.put("eleSubmissionNotTaken", By.xpath("//*[contains(text(),'(Not-taken)')]"));
		hm.put("eleSubmissionCanceled", By.xpath("//*[contains(text(),'Canceled')]"));
		hm.put("eleSubmissionDeclined", By.xpath("//*[contains(text(),'Declined')]"));
		hm.put("eleApproveAll", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:approveAll_Ext-btnInnerEl"));

		// Activity
		hm.put("eleActivity_ActivitySubject", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:Subject-inputEl"));
		hm.put("eleCloseActivity", By.id("ActivityDetailWorksheet:ActivityDetailScreen:CloseAndCreateToolBarButton-btnInnerEl"));
		hm.put("eleAccountSummary_Locations", By.xpath(".//span[contains(text(), 'Locations')]"));

		// Documents
		hm.put("eleDocumentTable", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:Policy_DocumentsScreen:DocumentsLV-body"));
		hm.put("lstQueueRoles", By.id("DesktopAssignableQueues:DesktopAssignableQueuesScreen:DesktopAssignableQueuesLV:assignableQueueFilter-inputEl"));
		hm.put("eleQueueAssignTo", By.xpath("//a[@id='DesktopAssignableQueues:DesktopAssignableQueuesScreen:DesktopAssignableQueuesLV_tb:AssignSelectedButton'][@class='x-btn x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		hm.put("elePolicyInfo_tab", By.xpath("//td[contains(@id,'PolicyInfo')]//span[text()='Policy Info']"));
		hm.put("elePolicyInfo_Title", By.xpath("//span[@class='g-title' and text()='Policy Info']"));
		hm.put("eljMyQueue_Next", By.xpath("//a[@class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-plain-toolbar-small x-icon x-btn-icon x-btn-plain-toolbar-small-icon']//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]"));
		hm.put("eljMyQueue_NextDisabled", By.xpath("//a[contains(@class,' x-item-disabled x-disabled x-btn-disabled x-btn-plain-toolbar-small-disabled')]//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]"));
		hm.put("eleDeleteDocument", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:DeleteDocumentButton-btnInnerEl"));
		hm.put("eleSaveAsDraft", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveAsDraftButton-btnInnerEl"));

		hm.put("eleFinalize", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:FinalizeButton-btnInnerEl"));
		hm.put("lstStatus", By.id("AccountFile_Documents:DocumentsScreen:DocumentSearchDV:Status-inputEl"));
		hm.put("eleAccountFileDocumentsvfy", By.id("AccountFile_Documents:DocumentsScreen:ttlBar"));
		hm.put("eleDocumentsScreenvfy", By.id("AccountFile_Documents:DocumentsScreen:0"));
		hm.put("eleDocDeleteDocumentButton", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:DeleteDocumentButton-btnInnerEl"));
		hm.put("eleDocSaveAsDraftButton", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:SaveAsDraftButton-btnInnerEl"));
		hm.put("eleDocFinalize", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:FinalizeButton-btnInnerEl"));

		// SOR Policy
		// hm.put("lstSORPolicyInfo_EffDate",By.xpath("//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:EffectiveDate_date-inputEl']"));
		// hm.put("lstSORPolicyInfo_ExpDate",By.xpath("//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ExpirationDate_date-inputEl']"));
		hm.put("lstSORPolicyInfo_ExpDate", By.xpath("//input[contains(@id,'PolicyInfoInputSet:ExpirationDate_date-inputEl')]"));
		hm.put("lstSORPolicyInfo_EffDate", By.xpath("//input[contains(@id,'PolicyInfoInputSet:EffectiveDate_date-inputEl')]"));
		hm.put("lstSORPolicyInfo_TermType", By.xpath("//input[contains(@id,'SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:TermType-inputEl')]"));
		hm.put("edtSORPolicyInfo_ExpDate", By.xpath("//input[@id='SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ExpirationDate_date-inputEl']"));

		// Edit policy
		hm.put("eleLocation_EditPolicy", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));

		// Location - SOR
		hm.put("eleLocations", By.id("SubmissionWizard:LOBWizardStepGroup:Locations"));
		hm.put("eleLocation_NewLoc", By.xpath("//span[contains(@id,'LocationsEdit_DP_tb:Add-btnInnerEl')]"));

		hm.put("edtLocation_AddressLine", By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:TargetedAddressInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl"));

		hm.put("eleStateCov_UpdateAll", By.xpath("//*[contains(@id,'WC7StateCoverageCV:SplitBases-btnInnerEl')]"));
		// hm.put("eleStateCov_StateTbl",
		// By.xpath("//div[contains(@id,'LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:PolicyLinePerStateConfig_LV-body')]"));
		hm.put("eleStateCov_StateTbl", By.xpath("//*[contains(@id,'PolicyLinePerStateConfig_LV-body')]"));

		// hm.put("eleStateCov_StateTbl",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:PolicyLinePerStateConfig_LV-body"));
		// hm.put("eleStateCov_ClassAddress", By.xpath("//li[@role='option' and
		// @class='x-boundlist-item']"));
		hm.put("selAddressCode", By.name("Loc"));
		// hm.put("eljAddClass",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7ClassesInputSet:WCCovEmpLV_tb:Add-btnInnerEl"));
		hm.put("eljAddClass", By.xpath("//*[contains(@id,'WCCovEmpLV_tb:Add-btnInnerEl')]"));
		hm.put("eleStateCov_SaveDraft", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));

		// hm.put("eljStateCov_SaveDraft",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eljStateCov_SaveDraft", By.xpath("//*[contains(@id,':Draft-btnInnerEl')]"));

		// hm.put("eljStateCov_SaveDraft",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("eljStateCov_SaveDraft", By.xpath("//*[contains(@id,':Draft-btnInnerEl')]"));
		hm.put("edtLocCode", By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:LocationCode-inputEl"));

		hm.put("eleModiferTable", By.xpath("//table[contains(@id,'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UnsplitModifiers:WC7ModifiersInputSet:WC7JurisdictionModifierInput:WC7JurisdictionModifierInputSet') and contains(@class,'-default x-table-form-item')]"));
		hm.put("edtStateCov_RatingFac", By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV:ScheduleRatingFactor-inputEl"));
		hm.put("edjStateCov_RatingFac", By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV:ScheduleRatingFactor-inputEl"));
		hm.put("clrStateCov_RatingFac", By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV:ScheduleRatingFactor-inputEl"));
		hm.put("eleStateCov_RatingFacOKbtn", By.id("WC7ScheduleCreditPopup:Update-btnInnerEl"));
		// hm.put("eleLineCov_ConditionTab",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsTab-btnInnerEl"));
		hm.put("eleLineCov_ConditionTab", By.xpath("//*[contains(@id,':WC7ConditionsTab-btnInnerEl')]"));
		hm.put("eleLineCov_EmployeeLeasingTab", By.xpath("//*[contains(@id,'WC7EmployeeLeasingTab-btnInnerEl')]"));
		hm.put("edtLC_EL_ProfessionalEmployeeType", By.xpath("//*[contains(@id,'ProfessionalEmployeeType-inputEl')]"));
		hm.put("eleLineCov_CoverageHeading", By.xpath("//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV_ref']//div[@class='x-component x-fieldset-header-text x-component-default']"));
		hm.put("eleWCoption_StateTable", By.xpath("//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanPerStateConfig_LV-body']"));
		hm.put("lsjLineCov_PlanId", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanOptionDV:PlanID-inputEl"));
		hm.put("lstLineCov_DividendVar", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanOptionDV:DividendVariation-inputEl"));
		hm.put("eljLocation_PriMaryAddress", By.xpath("//*[contains(@id, 'LocationsEdit_DP:LocationsEdit_LV:0:Address')]"));
		//hm.put("edtEditLocation_TaxCode", By.xpath("//input[@id='LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LineLocationDetailInputSet:taxCode_Ext-inputEl']"));
		hm.put("edtEditLocation_TaxCode", By.xpath("//input[@id='BP7LocationPopup:LocationScreen:singleTaxCode_Ext-inputEl']"));


		// state summary
		// hm.put("eleStateSummary",
		// By.id("SubmissionWizard:SubmissionWizard_StateSummaryScreen:ttlBar"));
		hm.put("eleStateSummary", By.xpath("//span[contains(@id,'StateSummaryScreen:ttlBar')]"));
		hm.put("eleLineCoverage", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:ttlBar"));
		hm.put("eleStateCoverage", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:ttlBar"));
		hm.put("edtStateCov_NCCIIntraStateID", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:0:ANI_OfficialIDEntry-inputEl"));
		hm.put("elePolicyInfo_EditTransaction", By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicyWorkflow-btnInnerEl"));
		// hm.put("eljPolicyInfo_EditTransaction",
		// By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));
		hm.put("eljApplyChangesToRenewal", By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_DifferencesScreen:JobWizardToolbarButtonSet:ApplyRenewalChange_Ext-btnInnerEl"));
		hm.put("edtLocation_PhNum", By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:Phone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));

		// State_Coverage
		hm.put("lstWorkplaceSafetyProgramCredit", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UnsplitModifiers:WC7ModifiersInputSet:WC7JurisdictionModifierInput:WC7JurisdictionModifierInputSet:ModIterator:1:ModifierInput_TypeKey-inputEl"));

		// Line Coverages
		// hm.put("eljAddBlanketWaiver",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverOfSubroLV_tb:Add-btnInnerEl"));
		hm.put("eleBanket_tbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverOfSubroLV-body"));
		hm.put("edtBlanketStateAct", By.name("State"));
		hm.put("edtPercentageCharge", By.name("pc"));
		hm.put("edtWCLaw", By.name("WCLaw"));
		hm.put("eljLCAddBlanketWaiver1", By.xpath("//*[contains(text(),'Waiver of Our Right to Recover from Others Endorsement')]//ancestor::fieldset//following::a//span[contains(text(),'Add Blanket Waiver')]"));
		hm.put("eljLCAddBlanketWaiver", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverOfSubroLV_tb:Add-btnInnerEl"));
		hm.put("eljLCAddBlanketWaiver2", By.xpath(".//*[contains(@id,':Add-btnEl')]"));
		hm.put("eljLCVoluntaryAdd", By.xpath("//div[contains(text(),'Voluntary Compensation And Employers')]//ancestor::fieldset//following::a//span[contains(text(),'A')]"));
		hm.put("eljLCAddLongShore", By.xpath("//div[contains(text(),'Longshore And Harbor Workers Compensation Act Rate Change Endorsement ')]//ancestor::fieldset//following::a//span[contains(text(),'A')]"));
		hm.put("lsjLCABW_StateTBD", By.name("State"));
		hm.put("lsjLCABW_WC LawTBD", By.name("WCLaw"));
		hm.put("lsjLCABW_Percentage ChargeTBD", By.name("pc"));
		hm.put("lsjLCVoluntary_Form StateTBD", By.name("c1"));
		hm.put("lsjLCVoluntary_State of EmploymentTBD", By.name("c2"));
		hm.put("lsjLCVoluntary_EmployeesTBD", By.name("c3"));
		hm.put("lsjLCLongShore_StateTBD", By.name("c1"));
		hm.put("edtLCLongShore_Date of ChangeTBD", By.name("c2"));
		hm.put("lsjLCLongShore_% ChangeTBD", By.name("c3"));
		hm.put("edtLCFVC_Employees Name or Job FunctionTBD", By.name("EmpOrJobFunc"));
		hm.put("lstLCFVC_Country of EmploymentTBD", By.name("CountryOfEmp"));
		hm.put("lstLCFVC_Form StateTBD", By.name("FormState"));
		hm.put("edtLCFVC_Designated WC LawTBD", By.name("DesignatedWCLaw"));
		hm.put("edtLCFVC_Maximum Number of DaysTBD", By.name("MaxNoOfDays"));
		hm.put("eljAddForeignVoluntary", By.xpath(".//*[contains(@id,'WC7ForeignVolunCovLV_tb:Add-btnInnerEl')]"));
		hm.put("edtLCFVC_Maximum Number of Days", By.name("MaxNoOfDays"));
		hm.put("edtLCSolePropFirstName", By.xpath("//input[contains(@id,':FirstName-inputEl')]"));
		hm.put("edtLCSolePropLastName", By.xpath("//input[contains(@id,':LastName-inputEl')]"));
		hm.put("eleLCSolePropNewPerson", By.xpath("//span[text()='New Person']"));
		hm.put("lstLCSolePropState", By.xpath("//input[contains(@id,':State-inputEl')]"));
		hm.put("edtLCASW_DescriptionTBD", By.name("Description"));
		hm.put("edtLCASW_Job IDTBD", By.name("JobID"));
		hm.put("edtLCASW_StateTBD", By.name("State"));
		hm.put("edtLCASW_LocationTBD", By.name("Location"));
		hm.put("edtLCASW_Percentage ChargeTBD", By.name("Percentage Charge"));
		hm.put("lsjLCASW_Class CodeTBD", By.name("ClassCode"));
		hm.put("edtLCASW_WC LawTBD", By.name("WC7Law"));
		hm.put("edtLCASW_Annual Project PayrollTBD", By.name("AnnualProjectPayroll"));
		hm.put("eljAddSpecific WaiverTBL1", By.xpath("//*[contains(text(),'Waiver of Our Right to Recover from Others Endorsement')]//ancestor::fieldset//following::a//span[contains(text(),'Specific Waiver')]"));
		// hm.put("eljLCAddSpecific WaiverTBL2",
		// By.xpath(".//*[contains(@id,':Add-btnInnerEl')]");
		hm.put("lstLCSolePropTitleRelation", By.xpath("//input[contains(@id,':TitleRelationship-inputEl')]"));
		// hm.put("eleLCEL_AddOtherContacts", By.name("AddOtherContact-textEl"));
		hm.put("eleLCEL_AddOtherContacts", By.xpath("//*[contains(@id,'AddOtherContact-textEl')]"));
		hm.put("eleLCEL_AddExisting_Scenario", By.xpath("//*[contains(@id,'AccountContact-textEl')]"));
		hm.put("eleLC_EmployeeLeasingBody", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7EmployeeLeasingDV:WC7ExclusionGroupIterator:0:CoverageInputSet:ExclusionInputGroup:WC7PolicyLaborContractorDetailsLV-body"));
		hm.put("lstELE_Form StateTBD", By.name("State"));
		hm.put("eleExistingLabor", By.xpath("//span[text()='Existing Labor Contractor']"));
		hm.put("eleOtherContactsList", By.xpath("//div[contains(@id,'AccountContact')]"));
		hm.put("eleOtherContacts", By.xpath("//span[text()='Other Contacts']"));
		// hm.put("eleExclusions",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ExclusionsTab-btnInnerEl"));
		hm.put("eleExclusions", By.xpath("//*[contains(@id,'WC7ExclusionsTab-btnInnerEl')]"));
		hm.put("edtLCEX_Name of Officer or Employee or Class ThereofTBD", By.name("c1"));
		hm.put("eleLineCoverage_LineCoverage", By.xpath(".//*[contains(@id,'LOBWizardStepGroup:WC7WorkersCompLineCoverages')]"));
		// hm.put("eleLineCoverage_LineCoverage",
		// By.id("PolicyChangeWizard:LOBWizardStepGroup:WC7WorkersCompLineCoverages"));
		hm.put("eleLineCoverageTab", By.xpath("//span[text() = 'Line Coverages' and @class = 'x-tree-node-text ']"));

		// hm.put("eleLineCoverage_LineCoverage",
		// By.xpath(".//*[contains(@id,'LOBWizardStepGroup:WC7WorkersCompLineCoverages')]"));
		// ICON_Policy_Summary
		hm.put("eleVerify_TotalPremium", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_DatesDV:PolicyPerPremium-inputEl"));
		hm.put("elePolicy_Summary", By.xpath(".//span[contains(text(),'State Coverages')]"));
		hm.put("eleVerifyBillingMethod", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingMethod_Ext-inputEl"));
		hm.put("eleVerifyInstallmentPlan", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:PaymentPlan_Ext-inputEl"));
		hm.put("eleVerifyBillingNumber", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingNumber_Ext-btnInnerEl"));

		// hm.put("eljAccountNumberClickPolicy",
		// By.id("PolicyFile:PolicyFileMenuInfoBar:AccountNumber"));
		// State Coverage
		hm.put("eleBasicBroadForm", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:WC7CoverageGroupIterator:0:CoverageInputSet:0:WC7SplitableInputSet:CovPatternInputGroup:_checkbox"));
		// hm.put("edtDeductibleAmount",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:WC7CoverageGroupIterator:0:CoverageInputSet:0:WC7SplitableInputSet:CovPatternInputGroup:WC7DeductibleAmountTermInput-inputEl"));
		hm.put("eleClassCodeError", By.xpath("//*[contains(text(),'1234 is not a valid class code for Connecticut and this governing law')]"));
		hm.put("eleScheduleRateTbl", By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV:ScheduleRateLV-body"));

		// Line Coverage
		hm.put("eleScheduledItemsTbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:8:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0-body"));
		hm.put("edtLongShore_State", By.name("c1"));
		hm.put("edtDateOfChange", By.name("c2"));
		hm.put("edtPercentageChange", By.name("c3"));
		hm.put("eleWCoption_StateTable", By.xpath("//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanPerStateConfig_LV-body']"));
		hm.put("lsjLineCov_PlanId", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanOptionDV:PlanID-inputEl"));
		hm.put("lstLineCov_DividendVar", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7CoverageOptionsScreen:WC7OptionsPanelSet:WCOptionsCV:WC7ParticipationPlanOptionDV:DividendVariation-inputEl"));
		// hm.put("eljLocation_PriMaryAddress",
		// By.xpath("//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:LocationsPanelSet:LocationsEdit_DP:LocationsEdit_LV:0:Address']"));
		//hm.put("edtEditLocation_TaxCode", By.xpath("//input[@id='LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LineLocationDetailInputSet:taxCode_Ext-inputEl']"));

		// state summary
		hm.put("eleLineCoverage", By.xpath("//*[contains(@id,':WC7LineCoverageScreen:ttlBar')]"));
		// hm.put("eleStateCoverage",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:ttlBar"));
		hm.put("eleStateCoverageTitle", By.xpath("//*[contains(@id,':WC7StateCoverageScreen:ttlBar')]"));
		// hm.put("edtStateCov_NCCIIntraStateID",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:0:ANI_OfficialIDEntry-inputEl"));
		// hm.put("edtStateCov_NCCIIntraStateID",By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:officialIDs:0:ANI_OfficialIDEntry-inputEl"));
		hm.put("elePolicyInfo_EditTransaction", By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicyWorkflow-btnInnerEl"));
		// hm.put("eljPolicyInfo_EditTransaction",
		// By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicyWorkflow-btnInnerEl"));
		hm.put("eljPolicyInfo_EditTransaction", By.xpath(".//*[contains(text(),'dit Policy Transaction')]"));
		hm.put("eljApplyChangesToRenewal", By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_DifferencesScreen:JobWizardToolbarButtonSet:ApplyRenewalChange_Ext-btnInnerEl"));
		hm.put("edtLocation_PhNum", By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:Phone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"));
		// State_Coverage
		hm.put("lstWorkplaceSafetyProgramCredit", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UnsplitModifiers:WC7ModifiersInputSet:WC7JurisdictionModifierInput:WC7JurisdictionModifierInputSet:ModIterator:1:ModifierInput_TypeKey-inputEl"));

		// Line Coverages
		// hm.put("eljAddBlanketWaiver",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverOfSubroLV_tb:Add-btnInnerEl"));
		hm.put("eljAddBlanketWaiver", By.xpath("//span[contains(@id,'WC7BlanketWaiverLV_tb:Add-btnInnerEl')]"));
		hm.put("eleAddVoluntaryCompensation", By.xpath(".//*[contains(@id, 'ScheduleInputSet:Add-btnInnerEl')]"));
		// hm.put("eleAddVoluntaryCompensation",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:19:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:Add-btnInnerEl"));
		hm.put("lstAddFormState", By.name("c1"));
		hm.put("eleBanket_tbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverOfSubroLV-body"));
		hm.put("edtBlanketStateAct", By.name("State"));
		hm.put("edtPercentageCharge", By.name("pc"));
		// hm.put("edtWCLaw",By.name("WCLaw"));
		// hm.put("eleAddVoluntaryCompensation",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:19:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:Add-btnInnerEl"));
		// hm.put("lstAddFormState", By.name("c1"));
		hm.put("eleBanket_tbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverOfSubroLV-body"));
		// hm.put("lstStateOfEmployment", By.name("c2"));
		// hm.put("edjEmployees", By.name("c3"));
		// hm.put("eleVoluntarySchedule_tbl",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:19:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0"));

		// hm.put("eleVoluntarySchedule_tbl",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:19:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0"));
		hm.put("lstStateOfEmployment", By.name("c2"));
		hm.put("edjEmployees", By.name("c3"));
		hm.put("edtWCLaw", By.name("WCLaw"));
		hm.put("edtSpecificReasonForAdjustment", By.xpath(".//span[contains(text(),'"));
		// hm.put("FormsBodySysGen",
		// By.id("PolicyFile_Forms_WC7:PolicyFile_PolicyLine_FormsScreen:PolicyFileFormsCV:Forms1LV-body"));

		// ICON_Policy_Summary
		hm.put("eleVerify_TotalPremium", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_DatesDV:PolicyPerPremium-inputEl"));
		hm.put("elePolicy_Summary", By.xpath(".//span[contains(text(),'State Coverages')]"));

		hm.put("eleVerifyBillingMethod", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingMethod_Ext-inputEl"));
		hm.put("eleVerifyInstallmentPlan", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:PaymentPlan_Ext-inputEl"));
		hm.put("eleVerifyBillingNumber", By.id("PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingNumber_Ext-btnInnerEl"));
		// hm.put("eljAccountNumberClickPolicy",
		// By.id("PolicyFile:PolicyFileMenuInfoBar:AccountNumber-btnInnerEl"));
		hm.put("eljAccountNumberClickPolicy", By.xpath(".//span[contains(@id,'AccountNumber-btnInnerEl')]"));
		hm.put("eleAccount_Summary_PolicyClick", By.xpath(".//span[contains(@id,'PolicyNumber-btnInnerEl')]"));
		hm.put("eleNotTaken", By.xpath(".//span[contains(text(),'Not-Taken')]"));
		// State Coverage
		hm.put("eleBasicBroadForm", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:WC7CoverageGroupIterator:0:CoverageInputSet:0:WC7SplitableInputSet:CovPatternInputGroup:_checkbox"));
		hm.put("edjDeductibleBasis", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:WC7CoverageGroupIterator:0:CoverageInputSet:0:WC7SplitableInputSet:CovPatternInputGroup:WC7DeductibleBasisTermInput-inputEl"));
		// hm.put("edtDeductibleAmount",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:WC7CoverageGroupIterator:0:CoverageInputSet:0:WC7SplitableInputSet:CovPatternInputGroup:WC7DeductibleAmountTermInput-inputEl"));
		hm.put("edjDeductibleAmount", By.xpath("//*[contains(@id,'WC7SplitableInputSet:CovPatternInputGroup:WC7DeductibleAmountTermInput-inputEl')]"));
		hm.put("eljStateCoverage_DrugFreeYES", By.xpath("//td//label[contains(.,'Drug Free Workplace Credit')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'Yes')]"));
		hm.put("eljStateCoverage_DrugFreeNO", By.xpath("//td//label[contains(.,'Drug Free Workplace Credit')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'No')]"));
		// hm.put("eleScheduleRateTbl",
		// By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV:ScheduleRateLV-body"));
		hm.put("ValidateDrugFreeWorkPlaceNoCheckBox", By.xpath("//td//label[contains(.,'Drug Free Workplace Credit')]/./ancestor::td[1]//following-sibling::td//label[contains(text(),'No')]//ancestor::table[1][contains(@class,'x-form-cb-checked')]"));
		hm.put("eleScheduleRateTblHeader", By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV"));
		hm.put("lstSTMeritRatingMod", By.xpath("//td//label[contains(text(),'Merit Rating Mod')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtSTNCCIInterStateID", By.xpath("//td//label[contains(text(),'NCCI Interstate ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstSTCompulsoryWorkplace", By.xpath("//td//label[contains(text(),'Compulsory Workplace Safety Program Surcharge')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstSTSafetyIncentive", By.xpath("//td//label[contains(text(),'Safety Incentive Program Credit')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lsjSTSafeWorkplaceCredit", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UnsplitModifiers:WC7ModifiersInputSet:WC7JurisdictionModifierInput:WC7JurisdictionModifierInputSet:ModIterator:1:ModifierInput_TypeKey-inputEl"));
		hm.put("lstSTReturnToWork", By.xpath("//td//label[contains(text(),'Return To Work Program Credit')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtSTStateTaxID", By.xpath("//td//label[contains(text(),'State Tax ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edjSTStateUnemployementID", By.xpath("//td//label[contains(text(),'State Unemployment ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtSTStateUnemployementID", By.xpath("//td//label[contains(text(),'State Unemployment ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtSTIntraStateID", By.xpath("//td//label[contains(text(),'NCCI Intrastate ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtRiskID", By.xpath("//td//label[contains(text(),'Risk ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eljSTDrugFreeWorkplaceYES", By.xpath("//td//label[contains(.,'Drug & Alcohol  Prevention Program Credit (WSLPIP)')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'Yes')]"));
		hm.put("eljSTDrugFreeWorkplaceNO", By.xpath("//td//label[contains(.,'Drug & Alcohol  Prevention Program Credit (WSLPIP)')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'No')]"));
		hm.put("eljStateCoverage_Drug&AlcoholFreeYES", By.xpath("//td//label[contains(.,'Drug & Alcohol Free')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'Yes')]"));
		hm.put("eleAlcohol_DrugFreeYES", By.xpath("//td//label[contains(.,'Alcohol & Drug Free Workplace Premium Credit')]//ancestor::td[1]//following-sibling::td//label[contains(text(),'Yes')]"));
		hm.put("eleSTSplitPeriod", By.xpath("//*[contains(@id,'WC7StateCoverageCV:SplitPeriod-btnInnerEl')]"));
		hm.put("eleSTSelectAllStates", By.xpath("//span[text()='State']//ancestor::div[3]/div[1]/div/span"));
		hm.put("edtSTSplitDate", By.id("WC7SplitPeriodPopup:SplitDate-inputEl"));
		hm.put("edtSTSplitType", By.id("WC7SplitPeriodPopup:splitType-inputEl"));
		hm.put("eljSTSplitUpdate", By.id("WC7SplitPeriodPopup:Update-btnInnerEl"));
		// hm.put("FormsBody",
		// By.id("PolicyFile_Forms_WC7:PolicyFile_PolicyLine_FormsScreen:PolicyFileFormsCV:FormsLV-body"));
		hm.put("FormsBody", By.xpath("//*[contains(@id,'FormsCV:FormsLV-body')]"));
		hm.put("FormsBodySysGen", By.id("PolicyFile_Forms_WC7:PolicyFile_PolicyLine_FormsScreen:PolicyFileFormsCV:Forms1LV-body"));
		// hm.put("FormsBodySysGen",
		// By.xpath("//*[contains(@id,'PolicyFileFormsCV:Forms1LV-body')]"));
		hm.put("RenewalSystemGenFormsBody", By.id("RenewalWizard:PostQuoteWizardStepSet:FormsScreen:FormsCV:Forms1LV-body"));

		// hm.put("eleDrug Free Workplace CreditYES",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyLinePerStateConfigDV:UnsplitModifiers:WC7ModifiersInputSet:WC7JurisdictionModifierInput:WC7JurisdictionModifierInputSet:ModIterator:1:ModifierInput_Boolean_true-inputEl"));
		hm.put("eleDrug Free Workplace CreditYES", By.xpath("//*[contains(@id,'ModifierInput_Boolean_true-inputEl')]"));
		hm.put("eleDrug Free Workplace CreditNO", By.xpath("//*[contains(@id,'ModifierInput_Boolean_false-inputEl')]"));

		// Audit Policy Transactions
		hm.put("eleAuditSchedule", By.xpath("//span[contains(text(),'Audit Schedule')]"));
		hm.put("eleAuditInfoScreen", By.id("PolicyFile_Audits:AuditInformationScreen:0"));
		hm.put("eleAuditActionWithDraw", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:0:Withdraw"));
		hm.put("eleAuditActionStart", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:0:Start"));
		hm.put("eljAuditActionStart", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:0:Start"));
		hm.put("eleAuditActionEdit", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:0:Edit"));
		hm.put("eleWaiveFinalAuditOK", By.id("button-1005-btnInnerEl"));
		hm.put("eleCreateNewAudit", By.id("PolicyFile_Audits:AuditInformationScreen:CreateAdHocAudit-btnInnerEl"));
		hm.put("edtAuditMethod", By.id("CreateNewAuditInformationPopup:AuditMethodList-inputEl"));
		hm.put("eleAuditMethodTBD", By.xpath("//*[contains(text(),'TBD')]"));
		hm.put("eleAddNewAuditOK", By.id("CreateNewAuditInformationPopup:UpdateButton-btnInnerEl"));
		hm.put("eleAuditSchedule_Tbl", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV-body"));
		hm.put("eljFinalAuditLink", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:0:AuditType"));
		// hm.put("eleSummaryScreen",By.id("AuditWizard:AuditWizard_SummaryScreen:ttlBar"));
		hm.put("eleSummaryScreen", By.xpath("//*[contains(text(),'Summary')]"));
		hm.put("edtSummaryMethod", By.id("AuditWizard:AuditWizard_SummaryScreen:AuditSummaryDV:MethodActual-inputEl"));
		hm.put("eleSummaryNext", By.id("AuditWizard:Next-btnInnerEl"));
		hm.put("eleDetailsScreen", By.id("AuditWizard:AuditWizard_DetailsScreen:ttlBar"));
		hm.put("eleAuditDetailstableRow", By.id("AuditWizard:AuditWizard_DetailsScreen:AuditDetailsPanelSet:0:0:wcCovEmpLV-body"));
		hm.put("edtTotalExposure", By.id("AuditWizard:AuditWizard_DetailsScreen:totalExposure_Ext-inputEl"));
		hm.put("eljCalculatePremium", By.id("AuditWizard:AuditWizard_DetailsScreen:Quote-btnEl"));
		hm.put("edt_DateReceived", By.id("AuditWizard:AuditWizard_SummaryScreen:AuditSummaryDV:AuditProcessingInputSet:ReceivedDate-inputEl"));
		hm.put("elePremiumScreen", By.id("AuditWizard:AuditWizard_PremiumsScreen:ttlBar"));
		hm.put("edtPremiumComment", By.id("AuditWizard:AuditWizard_PremiumsScreen:PremiumsScreenDV:Comment-inputEl"));
		hm.put("elePremiumSubmit", By.id("AuditWizard:AuditWizard_PremiumsScreen:JobWizardToolbarButtonSet:SubmitAudit-btnInnerEl"));
		hm.put("edtAuditAuditedActualBasis", By.name("auditedActualBasis_Ext"));
		hm.put("eleVerifyScheduled", By.xpath("//*[contains(text(),'Scheduled')]"));
		hm.put("eleViewFinalAudit", By.xpath("//*[contains(@id,'JobCompleteDV:ViewJob-inputEl')]"));
		hm.put("eleAuditUpdate", By.xpath("//*[contains(@id,'Update-btnInnerEl')]"));
		//hm.put("edtEditProcessStart", By.id("EditAuditInformationPopup:InitDate-inputEl"));
		hm.put("edtEditProcessStart", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:0:Edit"));

		
		hm.put("edtDueDate", By.id("EditAuditInformationPopup:DueDate-inputEl"));
		hm.put("edtEditAuditMethod", By.id("EditAuditInformationPopup:Method-inputEl"));
		hm.put("AuditTable", By.xpath("//*[contains(@id,'AuditInformationScreen:AuditsLV-body')]"));
		hm.put("eleVerifyUWActivity", By.id("UWActivityPopup:ttlBar"));
		hm.put("edtCloseout/Estimate", By.xpath("//*[contains(@id,'AuditProcessingInputSet:closeoutEstimate_Ext-inputEl')]"));
		hm.put("edtNonCompliantYears", By.xpath("//*[contains(@id,'auditedNoOfNonCompliantYears_Ext-inputEl')]"));
		hm.put("elePremiumDetails", By.xpath("//*[contains(text(),'Premium Details')]"));
		hm.put("PremiumTable", By.xpath(".//*[contains(@id,'StateSummaryDetailDV:WC7AuditRateCostDetailStateLV-body')]"));
		hm.put("elePremiumTable", By.xpath(".//*[contains(@id,'StateSummaryDetailDV:WC7AuditRateCostDetailStateLV-body')]"));
		hm.put("PremiumTableHeader", By.xpath("//div[@id='AuditWizard:AuditWizard_PremiumsScreen:RatingDetailPanel:AuditPremiumDetailsPanelSet:0:JurisdictionPanelSet:0:StateSummaryDetailDV:WC7AuditRateCostDetailStateLV']/div[1]/div/div"));
		hm.put("edtAuditInfoFilter", By.id("PolicyFile_Audits:AuditInformationScreen:AuditsLV:displayableInfoFilters-inputEl"));
		hm.put("eleRevisebutton", By.xpath("//*[contains(@id,'Revise')]"));
		hm.put("edtRevisionReason", By.id("AuditWizard:AuditWizard_SummaryScreen:AuditSummaryDV:AuditProcessingInputSet:reasonForRevision_Ext-inputEl"));
		hm.put("edtAuditEditOverride", By.xpath("//*[contains(@id,'auditEditOverride_Ext-inputEl')]"));
		hm.put("eleAuditOverridebtn", By.xpath("//*[contains(@id,'auditOverride_Ext-btnInnerEl')]"));
		hm.put("elePremium", By.xpath("//*[contains(text(),'Premiums')]"));
		hm.put("eleInProgress", By.xpath("//*[contains(text(),'In Progress')]"));
		hm.put("PremiumTable_Vermont", By.xpath("//span[text()='Vermont']//following::tr[16]//following-sibling::div[contains(@id,'StateSummaryDetailDV:WC7AuditRateCostDetailStateLV-body')]"));
		hm.put("PremiumTable_WestVirginia", By.xpath("//span[text()='West Virginia']//following::tr[16]//following-sibling::div[contains(@id,'StateSummaryDetailDV:WC7AuditRateCostDetailStateLV-body')]"));

		// Schedule Rating
		hm.put("eleScheduleRateTbl", By.id("WC7ScheduleCreditPopup:WC7ScheduleCreditDV:ScheduleRateLV-body"));
		hm.put("eleScheduleRatingFactor", By.xpath(".//label[contains(text(),'Schedule Rating Factor')]//following::td[1]/div"));
		hm.put("lsjCredit(-)/Debit(+)", By.name("CreditDebit"));
		hm.put("clrCredit(-)/Debit(+)", By.name("CreditDebit"));
		hm.put("eleScheduleRatingTitle", By.id("WC7ScheduleCreditPopup:ttlBar"));
		hm.put("lstJustification", By.name("Justification"));
		hm.put("clrJustification", By.name("Justification"));

		// Line Coverage
		hm.put("eleScheduledItemsTbl", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:8:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0-body"));
		hm.put("edtLongShore_State", By.name("c1"));
		hm.put("edtDateOfChange", By.name("c2"));
		hm.put("edtPercentageChange", By.name("c3"));
		hm.put("eljAddLongshoreItems", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:8:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:Add-btnInnerEl"));
		hm.put("eleSORRenewPolicy", By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_RenewPolicy-itemEl"));

		// Policy Change
		hm.put("eleLocationsTbl", By.xpath("//*[contains(@id, 'LocationsEdit_DP:LocationsEdit_LV-body')]"));
		// hm.put("eljAddVoluntary",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:20:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:Add-btnInnerEl"));
		// hm.put("eleVoluntaryScheduledItemsTbl",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:20:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0-body"));
		hm.put("eljAddVoluntary", By.xpath("//*[contains(@id,'CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:Add-btnInnerEl')]"));
		// hm.put("eleVoluntaryScheduledItemsTbl",
		// By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:21:CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0-body"));
		hm.put("eleVoluntaryScheduledItemsTbl", By.xpath("//*[contains(@id,'CoverageInputSet:CovPatternInputGroup:ScheduleInputSet:0-body')]"));
		hm.put("edtForm_State", By.name("c1"));
		hm.put("edtState", By.name("c2"));
		hm.put("edtEmployees", By.name("c3"));
		hm.put("eleRemovebtn", By.xpath("//*[contains(@id,'Remove-btnInnerEl')]"));
		hm.put("eljLCRemoveBlanketbtn", By.xpath("//*[contains(@id,'WC7BlanketWaiverLV_tb:Remove-btnInnerEl')]"));
		hm.put("elePolicyChangeAddClassTbl", By.id("PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:WC7StateCoverageScreen:WC7StateCoverageCV:WC7PolicyChangeClassesInputSet:WCCovEmpLV-body"));

		// Coverage
		hm.put("eleCoverages", By.xpath(".//div[@class='x-component x-fieldset-header-text x-component-default']"));
		hm.put("eljPolicyChangeQuote", By.id("PolicyChangeWizard:PolicyChangeWizard_DifferencesScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		// Named Insured
		hm.put("bliAddNamedInsured", By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton-btnWrap"));
		hm.put("edtNamedInsuredCompanyName", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("edtAddInsFEIN", By.id("NewAdditionalNamedInsuredPopup:ContactDetailScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"));
		hm.put("eljLocationNameInsAdd", By.id("LocationPopup:LocationScreen:LocationDetailPanelSet:LocationDetailCV:locationNamedinsured:NameInsuredLV_tb:addNamedInsured_Ext:AddAll-itemEl"));
		hm.put("elePolicyChangeBlanketTbl", By.id("PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:WC7LineCoverageScreen:WC7LineCoverageCV:WC7ConditionsDV:1:CoverageInputSet:ConditionInputGroup:WC7BlanketWaiverLV-body"));

		// MyQueues
		hm.put("eleMyQueuesTtl", By.id("DesktopAssignableQueues:DesktopAssignableQueuesScreen:0"));
		hm.put("eleMyQueuesTitle", By.id("DesktopAssignableQueues:DesktopAssignableQueuesScreen:0"));

		// PolicyChange
		hm.put("edjPolicyChange_ChangeReason", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:changereasonabc_Ext-inputEl"));
		hm.put("edjPolicyChange_SubmissionSource", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:subSource:SubmissionSource-inputEl"));
		hm.put("eljPolicyChangeProviderNamePicker", By.id("PolicyChangeWizard:PolicyChangeWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:PayrollInfo_Ext:payrollprovidername:SelectOrganization"));

		hm.put("eljPolChangPaymentIssue", By.id("PolicyChangeWizard:PolicyChangeWizard_PaymentScreen:JobWizardToolbarButtonSet:BindPolicyChange-btnInnerEl"));

		// PolicyReview
		// hm.put("elePolicyReview",
		// By.xpath(".//*[contains(text(),'PolicyNumber-inputEl')]"));
		hm.put("elePolicyReview", By.xpath(".//*[contains(text(),'Policy Review')]"));
		hm.put("UWInfo_Issuance", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWInfo_ExtDV:ISOSpectrumClassCode-inputEl"));
		hm.put("eleSupplementalTtlBar", By.xpath(".//span[contains(@id,'WC7SupplementalScreen:ttlBar')]"));
		hm.put("eleQuotePolicyNumber", By.xpath("//div[contains(@id,'PolicyNumber-inputEl')]"));

		hm.put("eleCommission", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:RatingCumulDetailsPanelSet:0:JurisdictionPanelSet:0:PeriodDetailDV:CommissionRate-labelEl"));

		// Payment
		//hm.put("elePayment_Versions", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:Versions-btnInnerEl"));
		//hm.put("elePayment_MultiVersion", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:JobWizardToolbarButtonSet:Versions:NewVersion-textEl"));
		hm.put("elePayment_EditTransaction", By.xpath("//*[contains(@id,':EditPolicy-btnInnerEl')]"));

		hm.put("eleQuoted", By.xpath(".//span[contains(text(),'Submission (Quoted)')]"));
		hm.put("eleOrigReceivedDate", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailDV:OrigReceivedDate-inputEl"));
		hm.put("elePolicyPeriod", By.xpath("//*[contains(@id,':PolicyPeriod-inputEl')]"));
		hm.put("eleQuoteLHS", By.xpath("//Span[contains(text(),'Quote')]"));
		hm.put("STCOV_ExpModStatus", By.xpath("//*[contains(@id,'InterIntraModStatus-inputEl')]"));
		hm.put("STCOV_SchedFactor", By.xpath("//*[contains(@id,'modifierInputGroup:ModifierInput_Rate-labelEl')]"));
		hm.put("elePaymentmsgwarning", By.xpath(".//label[contains(@class,'msg-warning')]"));
		// InitiateManualRenewal
		hm.put("eleConvertManualPolicy", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_ConvertManualPolicy-textEl"));
		hm.put("edtInitiateProducts", By.id("InitManualRenewalPage:products-inputEl"));

		// Policy Info
		hm.put("edtPolicyInfoFirstYearWritten", By.xpath("//*[contains(@id,'firstYearWritten_Ext-inputEl')]"));
		hm.put("edtExpiringPremium", By.xpath("//*[contains(@id,'expiringPremiumInput_Ext-inputEl')]"));
		hm.put("eleAssignAct_Assignbtn", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_AssignButton-btnInnerEl"));
		// hm.put("elePolicyInfo_PolicyInfo", By.xpath(".//*[contains(text(),'Policy
		// Info')]"));
		hm.put("eleSystem Generated", By.xpath("//*[contains(text(),'System Generated')]"));
		// Renewal Policy Info
		hm.put("lstRenewalReviewType", By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:RenewalWizard_PolicyInfoDV:PolicyInfoInputSet:RenewalReviewType_Ext-inputEl"));
		// Pre Renewal Directions
		hm.put("eleShellCloseOptions", By.xpath("//*[contains(text(),'lose Options')]"));
		hm.put("elePreRenewalDirectionTab", By.xpath("//*[contains(text(),'Pre-Renewal Direction')]"));
		hm.put("edtPreRenewal_Direction", By.id("PreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirection-inputEl"));
		hm.put("lsjPreRenewal_Direction", By.id("PSPreRenewalDirectionPage:PreRenewalDirectionScreen:PreRenewalDirection-inputEl"));
		// hm.put("edtNonRenewReason",By.id("PreRenewalDirectionPage:PreRenewalDirectionScreen:NonRenewReason-inputEl"));
		hm.put("edtNonRenewReason", By.xpath("//*[contains(@id,'Screen:NonRenewReason-inputEl')]"));
		hm.put("elePreRenewal_Topic", By.id("PSPreRenewalNotesPage:PolicyShell_Notes_ExtScreen:PolicyShell_NotesSearch_ExtDV:Topic-inputEl"));
		hm.put("elePreRenewal_NotTaken", By.xpath("//div[contains(text(), 'Not-Taken')]"));
		hm.put("elePredominantClassCode", By.xpath("//input[contains(@id,'PolicyInfoInputSet:PredoClassCode-inputEl')]"));

		// Forms
		// hm.put("eleFormsTab", By.xpath(".//*[contains(@id,
		// 'RenewalWizard:Forms')]/div"));
		hm.put("eleFormsTab", By.xpath("//span[text()='Forms']"));
		hm.put("eleSystemGenerated", By.xpath("//span[contains(text(),'System-Generated')]"));
		hm.put("SystemForms", By.xpath("//div[contains(@id,'Forms1LV-body')]"));
		hm.put("eleFormsTitle", By.xpath("//span[contains(@class,'g-title') and contains(text(),'Forms')]"));
		hm.put("eleDocumentsAssert", By.xpath("//span[contains(@class,'g-title') and contains(text(),'Account File Documents')]"));

		// Renewal
		// hm.put("ARNDueDate",
		// By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:Quote_SummaryDV:ARNDueDate_Ext-inputEl"));
		hm.put("ARNDueDate", By.xpath("//*[contains(@id,':ARNDueDate_Ext-inputEl')]"));
		hm.put("ActivityTable", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_ActivitiesLV-body"));
		hm.put("ParticipantTable", By.xpath("//*[contains(@id, 'ParticipantsScreen:JobRolesLV-body')]"));

		// Quote Proposal Builder
		hm.put("eleQuoteProposalBuilderLaunch", By.xpath("//*[contains(@id,'QuoteProposalBuildersScreen:QPBFilesLV-body')]"));
		hm.put("eleQuotePropsalBuilderTab", By.xpath("//span[contains(text(),'Quote Proposal Builder')]"));
		hm.put("edtQPBFaxNumber", By.id("QPB_ExtWizard:qpbWizardStepGroup:QPBWizardStepSet:DocumentOptionsWizardStepSet:SCDocumentOptions_ExtScreen:DocDV:DeliveryPreferenceTO_Ext:TOFax_Ext-inputEl"));
		hm.put("eleQuoteProposalBuilderResults", By.xpath("//*[contains(@id,'QuoteProposalBuildersScreen:QPBFilesLV-body')]"));
		// Policy Info
		hm.put("edtNegotiatedCommission", By.xpath("//td//label[contains(text(),'Negotiated Commission')]//ancestor::td[1]//following-sibling::td//input"));

		// Non Renewal Data Entry
		hm.put("eleNon-Renewal Data Entry", By.xpath("//span[contains(text(),'Non-Renewal Data Entry')]"));
		hm.put("edtAdditionalText", By.id("RenewalWizard_NonRenewPopup:RenewalWizard_NonRenewScreen:NonRenewAddExpl-inputEl"));

		// UWActivity page
		// hm.put("eleUWRequestApprovalBtn",
		// By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV_tb:RequestApproval-btnInnerEl"));
		hm.put("eleUWRequestApprovalBtn", By.xpath("//*[contains(@id,'RequestApproval-btnInnerEl')]"));
		hm.put("lstUWSecurityLevel", By.xpath("//*[contains(@id,'SecurityLevel-inputEl')]"));
		hm.put("lstUWPriority", By.xpath("//*[contains(@id,'Priority-inputEl')]"));
		hm.put("eleUWMandatoryRBtnY", By.xpath("//*[contains(@id,'Mandatory_true-inputEl')]"));
		hm.put("eleUWMandatoryRBtnN", By.xpath("//*[contains(@id,'Mandatory_false-inputEl')]"));
		hm.put("edtUWDiscription", By.xpath("//*[contains(@id,'Description2-inputEl')]"));
		hm.put("eleUWSendRequestBtn", By.xpath("//*[contains(@id,'Update-btnInnerEl')]"));
		// hm.put("Activity_UWDiscription",By.xpath("//*[contains(@id,'Description2-inputEl')]"));
		hm.put("edtUWDueDate", By.xpath("//*[contains(@id,'TargetDate-inputEl')]"));
		hm.put("edtUWEscalationDate", By.xpath("//*[contains(@id,'EscalationDate-inputEl')]"));
		hm.put("lstUWAssignTo", By.xpath("//*[contains(@id,'SelectFromList-inputEl')]"));
		hm.put("eleUWRecurringRBtnY", By.xpath("//*[contains(@id,'Recurring_true-inputEl')]"));
		hm.put("eleUWRecurringRBtnN", By.xpath("//*[contains(@id,'Recurring_false-inputEl')]"));
		// Application Links
		hm.put("eleApplicationLinks", By.id("TabBar:ApplnTab-btnWrap"));
		hm.put("eleOPSReference", By.id("TabBar:ApplnTab:OPSRefe-itemEl"));
		hm.put("bliApplicationselection", By.xpath(".//*[@id='TabBar:ApplnTab:UWRef']//ancestor::div"));
		hm.put("bliUWSelectionitems", By.xpath(".//*[@id='TabBar:ApplnTab:UWRef:UWRef_ExtMenuItemSet:Venture']//ancestor::div"));
		hm.put("eleCLAUploadTool", By.id("TabBar:ApplnTab:OPSRefe:OPSReference_ExtMenuItemSet:CLAUploadTool-itemEl"));
		hm.put("eleIDRAS", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:WizardMenuActions_Goto:policyShellLinks:PolicyShellLinksMenuItemSet:Idars-itemEl"));
		hm.put("eleIRES", By.id("HIGPolicyFile:HIGPolicyFileMenuActions:WizardMenuActions_Goto:policyShellLinks:PolicyShellLinksMenuItemSet:IRES-itemEl"));
		hm.put("eleECOS", By.id("TabBar:ApplnTab:OPSRefe:OPSReference_ExtMenuItemSet:ECOS-textEl"));
		// Organization
		hm.put("eleNewOrganization", By.xpath("//*[contains(@id,'AdminMenuActions_NewOrganization-textEl')]"));
		hm.put("edtNewOrganizationName", By.xpath("//*[contains(@id,'GlobalContactNameInputSet:Name-inputEl')]"));
		hm.put("edtOrg_OrganisationName", By.id("OrganizationSearchPage:OrganizationSearchScreen:OrganizationSearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("lstOrganizationType", By.xpath("//*[contains(@id,'OrganizationDetail_BasicDV:Type-inputEl')]"));
		hm.put("lstOrgStatus", By.xpath("//*[contains(@id,'ProducerStatus-inputEl')]"));
		hm.put("edtOrgDesc", By.xpath("//*[contains(@id,'GroupDetailInputSet:Description-inputEl')]"));
		hm.put("eleOrgSupervisor", By.xpath("//*[contains(@id,'GroupDetailInputSet:Supervisor:SupervisorMenuIcon')]"));
		hm.put("eleOrgSupervisorSelect", By.xpath("//*[contains(@id,'Supervisor:UserBrowseMenuItem-textEl')]"));
		hm.put("eleOrgUpdate", By.xpath("//*[contains(@id,'OrganizationDetailScreen:Update-btnInnerEl')]"));
		hm.put("eleOrgDelete", By.xpath("//*[contains(@id,'OrganizationDetailScreen:OrganizationDetailScreen_BasicCard_DeleteButton-btnInnerEl')]"));
		hm.put("eleOrg_Users", By.id("OrganizationDetail:OrganizationDetailScreen:OrganizationDetail_UserCardTab-btnInnerEl"));
		hm.put("eleOrg_ProdCodes", By.id("OrganizationDetail:OrganizationDetailScreen:OrganizationDetail_ProducerCodesCardTab-btnInnerEl"));
		hm.put("eleOrg_Queues", By.id("OrganizationDetail:OrganizationDetailScreen:OrganizationDetail_QueuesCardTab-btnInnerEl"));
		hm.put("eleOrg_Regions", By.id("OrganizationDetail:OrganizationDetailScreen:OrganizationDetail_RegionsCardTab-btnInnerEl"));
		// Groups
		hm.put("edtGroupOrganizationName", By.xpath("//*[contains(@id,'GroupDetailDV:Organization-inputEl')]"));
		hm.put("lstGroupParentName", By.xpath("//*[contains(@id,'GroupDetailDV:Parent-inputEl')]"));
		// Users
		hm.put("lstCLALTerm", By.xpath("//*[contains(@id,'UserDetailDV:logisticalTerminal_Ext-inputEl')]"));
		hm.put("eleOrgAddressNo", By.xpath("//*[contains(@id,'UserDetailDV:UseOrganizationAddress_false-inputEl')]"));
		hm.put("edtUserType", By.xpath("//*[contains(@id,'UserDetailCommons:UserDetailInputSet:Username-inputEl')]"));
		hm.put("edtOperatorInitials", By.xpath("//*[contains(@id,'UserDetailScreen:UserDetailDV:operatorInitials_Ext-inputEl')]"));
		hm.put("eleUserRole", By.xpath("//div[@class='x-grid-cell-inner ']"));
		hm.put("edtUserFirstName", By.xpath(".//*[contains(@id,'Name:GlobalPersonNameInputSet:FirstName-inputEl')]"));
		hm.put("edtUserLastName", By.xpath(".//*[contains(@id,'Name:GlobalPersonNameInputSet:LastName-inputEl')]"));
		hm.put("lstUserRole", By.xpath("//input[@class='x-form-field x-form-text x-form-focus x-field-form-focus x-field-default-form-focus']"));
		// Roles
		hm.put("eleRoles", By.xpath(".//span[contains(text(),'Roles')]"));
		hm.put("eleNewRole", By.xpath("//*[contains(@id,'RolesScreen:Roles_NewRoleButton-btnInnerEl')]"));
		hm.put("edtRoleName", By.xpath("//*[contains(@id,'NewRole:RoleDetailScreen:RoleDetailDV:Name-inputEl')]"));
		hm.put("edtRoleDesc", By.xpath("//*[contains(@id,'RoleDetailDV:Description-inputEl')]"));
		hm.put("eleRoleUsers", By.xpath("//*[contains(@id,'RoleDetail_UsersCardTab-btnInnerEl')]"));
		hm.put("eleVerifyRoleName", By.xpath(".//*[contains(@id,'Roles:RolesScreen:ttlBar')]"));
		hm.put("eleMyRolesTb", By.id("Roles:RolesScreen:RolesLV-body"));
		hm.put("eleMyRolesTbl", By.id("Roles:RolesScreen:RolesLV"));
		hm.put("eleRoleUpdate", By.id("NewRole:RoleDetailScreen:Update-btnInnerEl"));
		hm.put("eleDeleteRoles", By.xpath(".//span[contains(@id, 'Roles_DeleteButton-btnInnerEl')]"));
		// Documents
		hm.put("eleDoc_AddContact", By.xpath("//*[contains(@id,'AddUniqueTo-btnInnerEl')]"));
		hm.put("eleDocUniqueContact", By.xpath("//*[contains(@id,'roleType-textEl')]"));
		hm.put("eleDocSelectAddCompany", By.xpath("//*[contains(@id,'contactType-textEl')]"));
		hm.put("eleDoc_ContactUpdate", By.id("AddUniqueContactPopup:ContactDetailScreen:updateButton_Ext-btnInnerEl"));
		hm.put("lstLCEL_Form StateTBD", By.name("State"));
		hm.put("eleAcc_CreateNewdocFromTempLnk", By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewDocument:AccountNewDocumentMenuItemSet:AccountNewDocumentMenuItemSet_Template-textEl"));
		hm.put("lstDoc_CCRecipientDeliveryType", By.id("NewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:RecipientInformation_Ext:CCRecipientInputSet_Ext:CCRecipientDeliveryType_Ext-inputEl"));
		hm.put("eleDocumentTitle", By.xpath("//span[contains(@class,'g-title') and text()='Documents']"));
		hm.put("lstPolicy Number", By.id("AccountNewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:SpecifyPolicyDetails_Ext:PolicyNumber_Ext-inputEl"));
		// LineCoverage
		hm.put("eleLCEX_AddExistingOwner", By.xpath("//*[contains(@id,'AddExistingContact-textEl')]"));
		hm.put("eleLCEX_AddUndefinedOwner", By.xpath("//*[contains(@id,'UnassignedOwnerOfficer-textEl')]"));
		hm.put("edtDocState", By.id("NewDocumentFromTemplateWorksheet:NewDocumentFromTemplateScreen:NewTemplateDocumentDV:documentState-inputEl"));
		hm.put("edtLCNCCHS_NameTBD", By.name("c2"));
		hm.put("edtLCNCCHS_AddressTBD", By.name("c3"));
		hm.put("edtLCNCCHS_Number of Days for NonpayTBD", By.name("c4"));
		hm.put("edtLCNCCHS_Number of Days for Cancellation by CompanyTBD", By.name("c5"));
		hm.put("edtLCNCCHS_Number of Days for Cancellation by InsuredTBD", By.name("c6"));
		hm.put("edtLCNCCHS_Number of Days for NonrenewalTBD", By.name("c7"));
		hm.put("edtLCINRRC_Named Resident - RelativesTBD", By.name("c1"));
		hm.put("eleActivity_Edit", By.id("ActivityDetailWorksheet:ActivityDetailScreen:ActivityDetailToolbarButtonSet:ActivityDetailToolbarButtons_EditButton-btnInnerEl"));
		// Icon Validation new
		hm.put("edtPolicyInfo_EffDate", By.xpath("//input[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:EffectiveDate_date-inputEl')]"));
		hm.put("edtPolicyInfo_ExpDate", By.xpath("//input[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:ExpirationDate_date-inputEl')]"));
		hm.put("edtPolicyInfo_FEIN", By.xpath("//*[contains(@id,'AccountInfoInputSet:PolicyOfficialIDInputSet:OfficialIDDV_Input-inputEl')]"));
		hm.put("edtPolicyInfo_TermType", By.xpath("//input[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:TermType-inputEl')]"));
		hm.put("edtPolicyInfo_ProductType", By.xpath("//input[contains(@id,'SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ProductType-inputEl')]"));
		hm.put("edtPolicyInfo_Segment", By.xpath("//input[contains(@id,'PolicyInfoDV:PolicyInfoInputSet:Segment-inputEl')]"));
		hm.put("edtPolicyInfo_ProducerCode", By.xpath("//input[contains(@id,'PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerCode_Ext-inputEl')]"));
		hm.put("edtPolicyInfo_OrgType", By.xpath("//input[contains(@id,'PolicyInfoDV:AccountInfoInputSet:OrganizationType-inputEl')]"));
		hm.put("edtPolicyInfo_NAICSCode", By.xpath("//*[contains(@id,'AccountInfoInputSet:NAICSIndustryCode-inputEl')]"));
		hm.put("edtSTDeptOfLaborID", By.xpath("//td//label[contains(text(),'Dept of Labor ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtSTDeptOfLaborID", By.xpath("//td//label[contains(text(),'Dept of Labor ID')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("lstLC_Number of Days for Nonpay Option", By.xpath("//*[contains(@id,':CovTermInputSet:OptionTermInput'')]"));
		hm.put("lstLC_Number of Days for Any Other Reason ", By.xpath("//*[contains(@id,':CovTermInputSet:OptionTermInput-inputEl')]"));
		hm.put("edtCFTSState", By.xpath("//*[contains(@id,':State-inputEl')]"));
		hm.put("edtCFTSZipCode", By.xpath("//*[contains(@id,':PostalCode-inputEl')]"));
		hm.put("eleAccountSummary_OrgType", By.xpath("//div[contains(@id,'AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:OrgType-inputEl')]"));
		hm.put("edtSearchCompanyName", By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:GlobalContactNameInputSet:Name-inputEl"));
		hm.put("AccountSearchResultsTbl", By.id("AccountSearch:AccountSearchScreen:AccountSearchResultsLV-body"));
		hm.put("eleSSTWarning_Msg", By.name("Policy is canceled due to Non-Payment. SST delayed until 60 days after cancellation effective date. A new SST Transfer activity and policy Note have been created. Select Next to complete Guided Workflow."));
		hm.put("eleAccountSearchResults", By.id("AccountSearch:AccountSearchScreen:AccountSearchResultsLV-body"));
		hm.put("eleSearchErrorMessage", By.xpath("//*[contains(text(),'Please enter one of the minimum required fields: Policy Number (with Symbol)')]"));
		// Skill & Track
		hm.put("eleUsers&SecurityUser", By.id("TabBar:AdminTab:Admin_UsersAndSecurity-arrowEl"));
		hm.put("eleSkill/Track", By.id("UserDetailPage:UserDetailScreen:UserDetail_SkillTrackCardTab-btnInnerEl"));
		hm.put("businessSegementSkill", By.id("UserDetailPage:UserDetailScreen:UserSkill_ExtLV-body"));
		hm.put("businessSegementTrack", By.id("UserDetailPage:UserDetailScreen:UserTrack_ExtLV-body"));
		hm.put("eleAddSegement", By.id("UserDetailPage:UserDetailScreen:UserSkill_ExtLV_tb:Add-btnInnerEl"));
		hm.put("eleAddSkill", By.id("UserDetailPage:UserDetailScreen:UserTrack_ExtLV_tb:Add-btnInnerEl"));
		hm.put("lstSkill_BusinessSegment", By.name("BusinessSegment"));
		hm.put("lstSkill_Skill", By.name("skills"));
		hm.put("lstSkill_Track", By.name("tracks"));
		// LineCoverages
		hm.put("lsjLCFE_LocationTBD", By.name("Loc"));
		hm.put("lsjLCFE_Description Of WorkTBD", By.name("FELADescriptionOfWork"));

		// R3 table handlionf
		// table handling
		hm.put("eleAddExistingContact_Popup", By.xpath("//span[contains(@id,'AddOtherContact-textEl')]"));
		hm.put("eleExistingContact_Popup", By.xpath("//span[contains(@id,'AddContactsButton:AddOtherContact:0:OtherContact-textEl')]"));
		hm.put("eleAdd_PickerList", By.xpath("//div[@class='x-box-inner x-vertical-box-overflow-body' and contains(@id,'ext-gen')]//span[@class='x-menu-item-text']"));
		hm.put("lstExclusion_Description of Operation(s)TBD", By.name("c2"));
		hm.put("lstBldClas_RoofType", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:RoofType_Ext-inputEl"));

		hm.put("eleNewMail", By.name("New Mail"));
		hm.put("eleBlanketLimit", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:basecovIterator:0:BP7BundleCoverage_ExtInputSet:CovPatternInputGroup:1:BP7CovTermBundle_ExtInputSet:OptionTermInput-inputEl"));
		hm.put("eleBundleWarnMsg", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:_msgs"));
		hm.put("lstVariation", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:basecovIterator:0:BP7BundleCoverage_ExtInputSet:CovPatternInputGroup:0:BP7CovTermBundle_ExtInputSet:TypekeyTermInput-inputEl"));
		// WEISS Login
		hm.put("pwdWEISS_UserName", By.xpath("//form[@action='Authenticate.do']//input[@name='userid']"));
		hm.put("pwdWEISS_Password", By.xpath("//form[@action='Authenticate.do']//input[@name='password']"));
		hm.put("btnWEISS_Login", By.xpath("//input[@value='Sign on']"));
		hm.put("eleWEISS_Login", By.xpath("//input[@value='Sign on']"));
		hm.put("lstWEISS_AppName", By.xpath("//form[@action='SetApplication.do']//select[@name='applicationName']"));
		hm.put("drpWEISS_AppName_COMPASS", By.xpath("//form[@action='SetApplication.do']//select[@name='applicationName']"));
		hm.put("btnWEISS_Continue", By.xpath("//input[@value='Continue']"));
		hm.put("drpWEISS_EnvName", By.xpath("//select[@name='environmentName']"));
		hm.put("btnLink_AppFiles", By.xpath("//a[text()='App Files']"));
		hm.put("btnWEISS_PortList", By.xpath("//h2[contains(text(),'Application files for: ComPAS')]/parent::td//a[@target='_new']"));
		hm.put("eleWEISS_FielList", By.xpath("//table[@class='filelist']//tr[@class='mouseout']"));
		hm.put("eleQuote_PolicyNumber", By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:PolicyNumber-inputEl"));
		hm.put("btnWEISS_Date", By.xpath("//table[@class='filelist']//th[@title='Sort files by date']/a"));
		hm.put("eleNegotiatedCommission", By.xpath(".//*[contains(@id,'NegotiatedCommission-inputEl')]"));
		hm.put("eleQuote_Quote", By.xpath("*[@id='SubmissionWizard:ViewQuote']"));
		//hm.put("edtFailSafeJudgeThisRisk", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:BP7ModifiersPanelSet:0:BP7ScheduleRate_ExtDV:scheduleratemodrisk-inputEl"));
		hm.put("edtFailSafeJudgeThisRisk", By.xpath(".//input[contains(@id,'BP7ModifiersScreen:BP7ModifiersPanelSet:1:BP7ScheduleRate_ExtDV:scheduleratemodrisk-inputEl')]"));
		hm.put("clrFailSafeJudgeThisRisk", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7ModifiersScreen:BP7ModifiersPanelSet:0:BP7ScheduleRate_ExtDV:scheduleratemodrisk-inputEl"));
		hm.put("edtFileSafeRateDevFactor", By.xpath("//td//label[contains(text(),'FailSafe Rate Development Factor')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("edtModifier_JudgementMod", By.xpath("//td//label[contains(text(),'Judgment Modification')]//ancestor::td[1]//following-sibling::td//input"));
		hm.put("eleEducatorCovVerify", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:PolicyLevelExclusionsAndConditions:BP7AdditionalExclusionsAndConditionsPanelSet:ConditionsPanel:BP7AdditionalConditionsDV:0:BP7CoverageInputSet:CovPatternInputGroup-legendTitle"));
		hm.put("edtBulidingClassLiquorSales", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:LiquorSales_Ext-inputEl"));
		hm.put("eleBlanketTab", By.xpath("//span[text() = 'Blanket' and @class = 'x-tree-node-text ']"));
		hm.put("eleContractorsEndorsementCovVerify", By.name("Contractors Endorsement - Standard"));
		hm.put("eleExclusionSexualAbuseCovVerify", By.name("Exclusion - Sexual Abuse or Molestation"));
		hm.put("eleExclusionFungiBacVirusCovVerify", By.name("Exclusion - Fungi, Bacteria and Viruses"));
		hm.put("eleExclusionActivitiesCovVerify3", By.name("Exclusion - Activities"));
		hm.put("eleFireProtectionSubscriptionTaxesNo", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:DoesInsPayFireProTax_Ext_false-inputEl"));
		hm.put("eleAddExistingLocation", By.xpath(".//*[contains(@id,':addExistingLocationButton-btnInnerEl')]"));
		hm.put("eleExistLocationUnassignedLoc", By.xpath(".//*[contains(@id,'UnassignedAccountLocation-textEl')]"));
		hm.put("eljBO_Addbutton", By.xpath(".//*[contains(@id,'CovPatternInputGroup:BP7ScheduleInputSet:BP7ScheduledItemsLV_tb:Add-btnEl')]"));
		hm.put("edtEST_Description of Operation(s)TBD", By.name("c2"));
		hm.put("edtEDP_Description of Professional ServicesTBD", By.name("c2"));
		hm.put("eleAutolabel", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbAutoPolicy-boxLabelEl"));
		hm.put("eleWCLabel", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbWrkrsCompPolicy-boxLabelEl"));
		hm.put("eleFLLabel", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:UnderlyingUmbrellaPolicies_Ext:BP7Umbrella_ExtPanelSet:UmbForeignLiabPolicy-boxLabelEl"));
		hm.put("eleBuildingClasS_Title", By.xpath("//span[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:ttlBar' and text()='Buildings and Classifications']"));
		hm.put("eleEachCommonCauseBodilyInjuryLimit", By.xpath(".//*[contains(@id,':DirectTermInput3-inputEl')]"));
		hm.put("eleEachPersonBodilyInjuryLimit", By.xpath(".//*[contains(@id,':DirectTerm4:DirectTermInput4-inputEl')]"));
		hm.put("eleEachPersonLossofMeansofSupportLimit", By.xpath(".//*[contains(@id,':DirectTerm5:DirectTermInput5-inputEl')]"));
		hm.put("eleEachCommonCauseLossofMeansofSupportLimit", By.xpath(".//*[contains(@id,':DirectTerm6:DirectTermInput6-inputEl')]"));
		hm.put("eleDocDetSaveAsDraft", By.id("EditDocumentFromTemplate_ExtPopup:SaveAsDraftButton-btnInnerEl"));
		hm.put("eleDocDetDeleteDocumentbtn", By.id("EditDocumentFromTemplate_ExtPopup:DeleteDocumentButton-btnInnerEl"));
		hm.put("lstSoilType", By.xpath("//input[contains(@id,'SoilType_Ext-inputEl')]"));
		hm.put("lstDoesTaxEx", By.xpath("//input[contains(@id,'DoestaxExemptApply-inputEl')]"));
		hm.put("eleAddExclusionOrConditionbtn", By.xpath("//span[contains(@id,'AddExclusionsOrCondition-btnInnerEl')]"));

		//hm.put("eleSP_Policy#TB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div/div/div[3]//span[contains(text(),'Policy #')]"));
		hm.put("eleSP_Policy#TB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Policy #')]"));
		//hm.put("eleSP_PrimaryNameTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[4]//span[contains(text(),'Primary Named Insured')]"));
		hm.put("eleSP_PrimaryNameTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Primary Named Insured')]"));
		//hm.put("eleSP_Account#TB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[5]//span[contains(text(),'Account #')]"));
		hm.put("eleSP_Account#TB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Account #')]"));
		//hm.put("eleSP_ProductTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[6]//span[contains(text(),'Product')]"));
		hm.put("eleSP_ProductTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Product')]"));
		//hm.put("eleSP_SystemTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[7]//span[contains(text(),'System')]"));
		hm.put("eleSP_SystemTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'System')]"));
		//hm.put("eleSP_StatusTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[8]//span[contains(text(),'Status')]"));
		hm.put("eleSP_StatusTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Status')]"));
		//hm.put("eleSP_EffDateTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[9]//span[contains(text(),'Effective Date')]"));
		hm.put("eleSP_EffDateTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Effective Date')]"));
		//hm.put("eleSP_ExpDateTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[10]//span[contains(text(),'Expiration Date')]"));
		hm.put("eleSP_ExpDateTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Expiration Date')]"));
		//hm.put("eleSP_ProducerTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[4]/div/div/div[11]//span[contains(text(),'Producer')]"));
		hm.put("eleSP_ProducerTB", By.xpath("//span[contains(text(), 'Search Results')]/following::div[12]/div//span[contains(text(),'Producer')]"));
		hm.put("eleSales", By.id("TabBar:ApplnTab:Sales-itemEl"));
		hm.put("eleAgencyDashboard", By.id("TabBar:ApplnTab:Sales:Sales_ExtMenuItemSet:AgencyDashboard-textEl")); 
		hm.put("eleBuildingsAndClassPage", By.xpath(".//*[contains(text(),'Buildings and Classifications')]"));
		hm.put("edtPercentageOfImported", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:ImportedProductsPercentage-inputEl"));
		hm.put("eleUWManage", By.xpath(".//*[contains(@id,':Manage-btnInnerEl')]"));
		hm.put("eleUWSaveChanges", By.xpath(".//*[contains(@id,':saveChanges-btnInnerEl')]")); 
		hm.put("eleDeleteAP", By.id("ActivityPatternDetail:ActivityPatternDetailScreen:ActivityPatternDetailScreen_DeleteButton-btnInnerEl")); 
		hm.put("eleDueDate",By.xpath("//td[contains(@id,'NewActivityWorksheet:NewActivityScreen:NewActivityDV:TargetDate-bodyEl')]/table/tbody/tr/td[2]"));
		hm.put("eleEscalationDate",By.xpath("//td[contains(@id,'NewActivityWorksheet:NewActivityScreen:NewActivityDV:EscalationDate-bodyEl')]/table/tbody/tr/td[2]"));
		hm.put("eleDueInput", By.xpath("//input[contains(@id,'NewActivityWorksheet:NewActivityScreen:NewActivityDV:TargetDate-inputEl')]"));
		hm.put("eleEscalationInput", By.xpath("//input[contains(@id,'NewActivityWorksheet:NewActivityScreen:NewActivityDV:EscalationDate-inputEl')]"));


		hm.put("eleMonthDateView",By.xpath("//div[contains(@class,'x-datepicker x-layer x-datepicker-default x-unselectable x-border-box')]/div/div/div/a/span/span/span[1]"));            hm.put("navigateRight", By.xpath("//*[contains(@title,'Next Month (Ctrl+Right)') and contains(@id,'datepicker')]"));

		hm.put("eleMonthDateView",By.xpath("//div[contains(@class,'x-datepicker x-layer x-datepicker-default x-unselectable x-border-box')]/div/div/div/a/span/span/span[1]"));
		hm.put("navigateRight", By.xpath("//*[contains(@title,'Next Month (Ctrl+Right)') and contains(@id,'datepicker')]"));

		hm.put("eleActivitiesTable", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
		hm.put("ActivitiesTable", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
		hm.put("elePolicyNotesSearch", By.xpath("//a[contains(@id,'NoteSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search')]")); 
		hm.put("funPolicyNotesVerify1", By.xpath("//div[contains(@id,'Policy_NotesScreen:NotesLV:0:NoteRowSet:Body')]")); 
		
		hm.put("edtTexasPlaceCode",By.xpath("//*[contains(@id,'texasPlaceCode_Ext-inputEl')]"));
		hm.put("eleLocationRemoveBtn",By.xpath("//*[contains(@id,'LocationsEdit_DP_tb:Remove-btnInnerEl')]"));
		hm.put("eleClassificationTbl",By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body"));         
		//            hm.put("eleDcoumentss",By.xpath("//td[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Documents']"));
		hm.put("eleDcoumentss",By.xpath("//td[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Documents']"));
		//hm.put("eleAlternatePayerLink", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:changeAltPayerContactButton_ExtMenuIcon"));	
		hm.put("eleAlternatePayerLink", By.xpath("//*[contains(@id,':BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:changeAltPayerContactButton_ExtMenuIcon')]"));
		// hm.put("eleAPCNewPerson", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:1:altPayerContactType-itemEl"));
		hm.put("eleAPCNewPerson",By.xpath("//*[contains(@id,'AccountContactBillingInputSet:changeAltPayerContactButton_Ext:1:altPayerContactType-itemEl')]"));
		//hm.put("edtAPFirstName", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		/*hm.put("edtAPLastName", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
            hm.put("eleAPSameAs", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
            hm.put("eleAPAddress", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
            hm.put("eleAPAdressSelect", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
            hm.put("eleAPOK", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:updateButton_Ext-btnInnerEl"));*/
		hm.put("elePayPremiumFincance", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:premiumfinanceindicator_Ext-inputEl"));
		hm.put("eleReturnToBlanket", By.xpath("//a[@id='BP7BlanketPopup:__crumb__']"));
		hm.put("eleI_Inadequate", By.xpath("//*[contains(text(), 'I - Inadequate')]"));
		hm.put("eleS_Superior", By.xpath("//*[contains(text(), 'S - Superior')]"));
		hm.put("eleA-Adequate", By.xpath("//*[contains(text(), 'A - Adequate')]"));
		hm.put("eleViewSubmission", By.xpath(".//*[contains(text(), 'View your submission')]"));
		hm.put("eleNGSCloseOptionsNotTaken", By.xpath("//*[contains(@id,'CloseOptions:NotTakenJob')]"));
		hm.put("eleNGSNotTaken", By.id("NotTakenReasonPopup:RejectScreen:Update-btnInnerEl"));

		hm.put("edtNoOfPercentageSales", By.xpath("//input[contains(@id,'BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:PercentageOfProfSales')]"));
		hm.put("eleTitleElements", By.xpath("//span[contains(@id,'Screen:ttlBar')]"));
		hm.put("eleReturnToPolicyInfo", By.id("UWActivityPopup:__crumb__"));

		hm.put("eleWithdrawTransactionbtn",By.xpath("//*[contains(@id,'WithdrawJob-btnInnerEl')]"));
		hm.put("elePreviousPolicyNum", By.id("RewriteWizard:LOBWizardStepGroup:RewriteWizard_PolicyInfoScreen:RewriteWizard_PolicyInfoDV:PolicyInfoInputSet:PreviousPolicyNumber-inputEl"));	

		funAdditionalElements();
	}
	public static void funAdditionalElements()
	{
		  hm.put("eleMonthDateView",By.xpath("//div[contains(@class,'x-datepicker x-layer x-datepicker-default x-unselectable x-border-box')]/div/div/div/a/span/span/span[1]"));            hm.put("navigateRight", By.xpath("//*[contains(@title,'Next Month (Ctrl+Right)') and contains(@id,'datepicker')]"));

          hm.put("eleMonthDateView",By.xpath("//div[contains(@class,'x-datepicker x-layer x-datepicker-default x-unselectable x-border-box')]/div/div/div/a/span/span/span[1]"));
          hm.put("navigateRight", By.xpath("//*[contains(@title,'Next Month (Ctrl+Right)') and contains(@id,'datepicker')]"));

          hm.put("eleActivitiesTable", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
          hm.put("ActivitiesTable", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
          hm.put("elePolicyNotesSearch", By.xpath("//a[contains(@id,'NoteSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search')]")); 
          hm.put("funPolicyNotesVerify1", By.xpath("//div[contains(@id,'Policy_NotesScreen:NotesLV:0:NoteRowSet:Body')]")); 
          
          hm.put("edtTexasPlaceCode",By.xpath("//*[contains(@id,'texasPlaceCode_Ext-inputEl')]"));
          hm.put("eleLocationRemoveBtn",By.xpath("//*[contains(@id,'LocationsEdit_DP_tb:Remove-btnInnerEl')]"));
          hm.put("eleClassificationTbl",By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body"));         
//          hm.put("eleDcoumentss",By.xpath("//td[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Documents']"));
          hm.put("eleDcoumentss",By.xpath("//td[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Documents']"));
          hm.put("eleAlternatePayerLink", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:changeAltPayerContactButton_ExtMenuIcon"));	
          hm.put("eleAPCNewPerson", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:1:altPayerContactType-itemEl"));
          hm.put("edtAPFirstName", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
          hm.put("edtAPLastName", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
          hm.put("eleAPSameAs", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
          hm.put("eleAPAddress", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
          hm.put("eleAPAdressSelect", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
          hm.put("eleAPOK", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:updateButton_Ext-btnInnerEl"));
          hm.put("elePayPremiumFincance", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:premiumfinanceindicator_Ext-inputEl"));
          hm.put("eleReturnToBlanket", By.xpath("//a[@id='BP7BlanketPopup:__crumb__']"));
          hm.put("eleI_Inadequate", By.xpath("//*[contains(text(), 'I - Inadequate')]"));
          hm.put("eleS_Superior", By.xpath("//*[contains(text(), 'S - Superior')]"));
          hm.put("eleA-Adequate", By.xpath("//*[contains(text(), 'A - Adequate')]"));
          hm.put("eleViewSubmission", By.xpath(".//*[contains(text(), 'View your submission')]"));
          hm.put("eleNGSCloseOptionsNotTaken", By.xpath("//*[contains(@id,'CloseOptions:NotTakenJob')]"));
          hm.put("eleNGSNotTaken", By.id("NotTakenReasonPopup:RejectScreen:Update-btnInnerEl"));
	            hm.put("edtNoOfPercentageSales", By.xpath("//input[contains(@id,'BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:PercentageOfProfSales')]"));
          hm.put("eleTitleElements", By.xpath("//span[contains(@id,'Screen:ttlBar')]"));
          hm.put("eleReturnToPolicyInfo", By.id("UWActivityPopup:__crumb__"));
        //Newly added
          hm.put("eleCancelPolicybtn", By.id("StartCancellation:StartCancellationScreen:Cancel-btnInnerEl"));
          hm.put("eleCan_PopupCancel", By.id("button-1008-btnInnerEl"));
          hm.put("eleConfirmation", By.id("CancellationWizard:CancellationWizard_QuoteScreen:ttlBar"));
          hm.put("eleCloseOptions", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:CloseOptions-btnWrap"));
          hm.put("eleCanwithdraw", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:CloseOptions:WithdrawJob-textEl"));
          hm.put("eleCancellation", By.id("JobComplete:JobCompleteScreen:ttlBar"));
          hm.put("eleReleaseCancelBtn", By.id("UWActivityPopup:Cancel-btnInnerEl"));
          hm.put("eleCustomerCompletionLetter", By.id("CancellationWizard:CancellationWizard_CompletionLetterScreen:ttlBar"));
          hm.put("edtCCFax", By.id("CancellationWizard:CancellationWizard_CompletionLetterScreen:CustomerCompletionLetterInputSet:CCLDeliveryFax-inputEl"));
          hm.put("eleScheduleCancel", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions:SubmitCancellation-textEl"));
          hm.put("eleCanBack", By.id("CancellationWizard:Prev-btnEl"));
          hm.put("eleConfirmation", By.id("CancellationWizard:ViewQuote"));
          hm.put("eleCan_edtpolicytxn", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));
          hm.put("eleEntry", By.id("CancellationWizard:CancellationWizard_EntryScreen:ttlBar"));

          
          hm.put("elePolicyChnge_ManulaPolicyChk", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualPolicy-inputEl"));
          hm.put("selPolicyChnge_manualReason", By.xpath("//input[@id='StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualReason-inputEl']"));
          hm.put("dumPolicyChnge_manualReason", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualReason"));
          hm.put("clrPolicyChnge_manualReason", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualReason"));
          hm.put("selPolicyChnge_DescOfOther", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ReasonDescription-inputEl"));
          
          //Copy Submission
          hm.put("eleCopySubmission", By.xpath("//span[text()= 'Copy Submission']"));
          
          hm.put("elePC_EditEffective",By.id("PolicyChangeWizard:WizardMenuActions:WizardMenuActions_Change:WizardMenuActions_ChangeEffDate-textEl"));

          hm.put("eleRewriteDraftStatus", By.xpath("//span[contains(text(), 'Rewrite Full Term (Draft)')]"));
          hm.put("eleAccSumm_ProdCode", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV-body"));
          hm.put("eleVerifyBillingSubTab", By.id("AccountFile:MenuLinks:AccountFile_Billing"));
          //SC Classification Screen
          hm.put("eleSCClassification", By.xpath(".//span[contains(text(), 'SC Classification')]"));
          hm.put("eleSCClassification_Refresh", By.xpath(".//span[contains(text(), 'Refresh')]"));
          hm.put("btnSelectClassCode1", By.xpath("//table[@class='defaultList']/tbody/tr/td[2]"));
          hm.put("btnsavetoPC", By.xpath("//input[contains(@name,'saveToPolicyCenterButton')]"));
          hm.put("eleviewclassreport", By.xpath("//*[contains(@id,'ViewClassReportButton-btnInnerEl')]"));
          hm.put("eleTechnicalError", By.xpath("//p[contains(@class,'errorText')]"));
          hm.put("eleSCClass_PolTerms", By.xpath("//span[contains(text(), 'Policy Terms')]"));
          hm.put("eleVerifyBillingAgencyBill", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:billingNumber:BillingMethodLink_Ext:agencyBill_Ext"));
          hm.put("eleVerifyAuditPackageNA", By.xpath("//span[contains(text(),'Audit Package')]"));
          hm.put("eleAuditSaveDraft", By.id("AuditWizard:AuditWizard_SummaryScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
          hm.put("elePolicySummaryTable", By.xpath("//div[@id='PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']"));
          hm.put("eleRequiresFinalAudit", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:FinalAudit-inputEl"));

          hm.put("elePayment_Versions", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:Versions-btnInnerEl')]"));
          hm.put("elePayment_MultiVersion", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:Versions:NewVersion-textEl')]"));
          hm.put("edtVersionNum", By.id("SubmissionWizard:MultiQuoteAcceleratedMenuActions:PolicyPeriodSelector:PolicyPeriodSelector_Arg-inputEl"));
          hm.put("elePolicyVersions", By.xpath("//span[contains(text(),'Policy Versions')]"));
          hm.put("elePolicyVersionCheckBox", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV:br:1:BranchNameCB"));
	      hm.put("elePolicyVersionSelectbtn", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV_tb:Wizard_ManageBranchesDV_SelectBranchButton-btnInnerEl"));
          hm.put("elePolicyVersionRenamebtn", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV_tb:Wizard_ManageBranchesDV_RenameButton-btnInnerEl"));
	      hm.put("elePolicyVersionWithdrawbtn", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV_tb:Wizard_ManageBranchesDV_WithdrawButton-btnInnerEl"));
	      hm.put("edtPolciyVersionRename", By.id("messagebox-1001-textfield-inputEl"));
	      hm.put("elePolSumPendingPolicyTransactions", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_JobsInProgressLV-body"));
          hm.put("elePolicyNumber", By.id("PolicyChangeWizard:JobWizardInfoBar:PolicyNumber-btnInnerEl"));
          hm.put("edtExposureField", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body']//td[6]"));
	

          //For reinstate usecase
          hm.put("eleRiskAnalysis_Table", By.xpath("//*[contains(@id,':Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:0-body')]"));
    		hm.put("elereboundforce", By.xpath("//*[@role='presentation']/tbody/tr[3]/td"));
    		hm.put("eleReNext", By.id("ReinstatementWizard:Next-btnInnerEl"));
    		hm.put("eleRequote", By.id("ReinstatementWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
    		hm.put("elecancelvalidate", By.id("CancellationWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
    		//CancellationWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl
    		hm.put("elePolicyTransactions", By.xpath("//span[text() = 'Policy Transactions' and @class = 'x-tree-node-text ']"));
			hm.put("labelClassName", By.xpath("//*[@class='x-form-item-label x-unselectable x-form-item-label-left']"));
			
			hm.put("elCanWarnnigMessage", By.id("CancellationWizard:CancellationWizard_QuoteScreen:WarningsPanelSet:0:PanelSet:Warning"));
          hm.put("elCanPreQuoteIssue", By.id("UWBlockProgressIssuesPopup:IssuesScreen:PreQuoteIssueTitle"));
          hm.put("eleCanRiskAnalysis", By.id("CancellationWizard:Job_RiskAnalysisScreen:0"));
          hm.put("elReturnlink", By.id("UWBlockProgressIssuesPopup:__crumb__"));  
          hm.put("elUnderUWreview", By.id("SubmissionWizard:JobWizardInfoBar:EditLock-btnWrap"));  
          hm.put("eleLockreview", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV_tb:LockForReview-btnInnerEl"));
          hm.put("eleRA_Approved", By.xpath("//*[contains(text(), 'Already Approved')]"));
          hm.put("eleRA_Blocking", By.xpath("//*[contains(text(), 'Blocking Issuance')]"));
          hm.put("eleRA_Reopen", By.xpath(".//*[contains(@id,':UWIssueRowSet:Reopen')]"));
          hm.put("eleRiskApproval_Cancel", By.id("RiskApprovalDetailsPopup:Cancel-btnInnerEl"));
          hm.put("eleRiskAnalysis_Table", By.xpath("//*[contains(@id,':Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:0-body')]"));
          hm.put("lsjBldCode_EffectivenessGrade",By.xpath("//*[contains(@id,':BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:EffectivenessGradeRange-inputEl')]"));
          hm.put("edtBldClas_YearBulit", By.xpath(".//*[contains(@id,':LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'YearBuilt_Ext-inputEl')]"));
          hm.put("eleIndividuallyGraded", By.xpath(".//*[contains(@id,':LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:IsIndividuallyGraded_Ext_true-inputEl')]"));
          hm.put("eljBldClas_SaveDraft", By.xpath(".//*[contains(@id,':LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl')]"));
          hm.put("eleCopySubmission", By.xpath("//span[text()= 'Copy Submission']"));
          hm.put("txtGotoBar", By.id("QuickJump-inputEl"));
          hm.put("eleAccountSubTabs",By.xpath("//div[@id='AccountFile:MenuLinks-body']//span[@class='x-tree-node-text ']"));
          hm.put("elePolicySubTabs",By.xpath("//div[contains(@id,'westPanel-innerCt')]//span[@class='x-tree-node-text ']"));
		hm.put("eleMonthDateView",By.xpath("//div[contains(@class,'x-datepicker x-layer x-datepicker-default x-unselectable x-border-box')]/div/div/div/a/span/span/span[1]"));            hm.put("navigateRight", By.xpath("//*[contains(@title,'Next Month (Ctrl+Right)') and contains(@id,'datepicker')]"));

		hm.put("eleMonthDateView",By.xpath("//div[contains(@class,'x-datepicker x-layer x-datepicker-default x-unselectable x-border-box')]/div/div/div/a/span/span/span[1]"));
		hm.put("navigateRight", By.xpath("//*[contains(@title,'Next Month (Ctrl+Right)') and contains(@id,'datepicker')]"));

		hm.put("eleActivitiesTable", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
		hm.put("ActivitiesTable", By.id("DesktopActivities:DesktopActivitiesScreen:DesktopActivitiesLV-body"));
		hm.put("elePolicyNotesSearch", By.xpath("//a[contains(@id,'NoteSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search')]")); 
		hm.put("funPolicyNotesVerify1", By.xpath("//div[contains(@id,'Policy_NotesScreen:NotesLV:0:NoteRowSet:Body')]")); 
		hm.put("edtAreaAssociated", By.xpath("//*[contains(@id,'BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:AreaAssocWithOper_Ext-inputEl')]"));
		hm.put("edtTexasPlaceCode",By.xpath("//*[contains(@id,'texasPlaceCode_Ext-inputEl')]"));
		hm.put("eleLocationRemoveBtn",By.xpath("//*[contains(@id,'LocationsEdit_DP_tb:Remove-btnInnerEl')]"));
		hm.put("eleClassificationTbl",By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body"));         
		//          hm.put("eleDcoumentss",By.xpath("//td[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Documents']"));
		hm.put("eleDcoumentss",By.xpath("//td[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Documents']"));
		//   hm.put("eleAlternatePayerLink", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:changeAltPayerContactButton_ExtMenuIcon"));	
		// hm.put("eleAPCNewPerson", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethodDependent:BillingContactsInputs:AccountContactBillingInputSet:changeAltPayerContactButton_Ext:1:altPayerContactType-itemEl"));
		//hm.put("edtAPFirstName", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl"));
		hm.put("edtAPFirstName",By.xpath("//*[contains(@id,':PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:FirstName-inputEl')]"));
		//hm.put("edtAPLastName", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:LastName-inputEl"));
		hm.put("edtAPLastName",By.xpath("//*[contains(@id,':PolicyContactDetailsDV:PolicyContactRoleNameInputSet:GlobalPersonNameInputSet:LastName-inputEl')]"));
		hm.put("eleAPSameAs", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:LinkAddressMenuMenuIcon"));
		hm.put("eleAPAddress", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail-textEl"));
		hm.put("eleAPAdressSelect", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:NewPolicyContactRoleDetailsCV:PolicyContactDetailsDV:LinkedAddressInputSet:LinkAddressMenu:0:contactDetail:PrimaryAddress-textEl"));
		// hm.put("eleAPOK", By.id("NewAlternatePayerPopup:alternatePayerContactScreen:updateButton_Ext-btnInnerEl"));
		hm.put("eleAPOK",By.xpath("//*[contains(@id,'updateButton_Ext-btnInnerEl')]"));
		hm.put("elePayPremiumFincance", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:premiumfinanceindicator_Ext-inputEl"));
		hm.put("eleReturnToBlanket", By.xpath("//a[@id='BP7BlanketPopup:__crumb__']"));
		hm.put("eleI_Inadequate", By.xpath("//*[contains(text(), 'I - Inadequate')]"));
		hm.put("eleS_Superior", By.xpath("//*[contains(text(), 'S - Superior')]"));
		hm.put("eleA-Adequate", By.xpath("//*[contains(text(), 'A - Adequate')]"));
		hm.put("eleViewSubmission", By.xpath(".//*[contains(text(), 'View your submission')]"));
		hm.put("eleNGSCloseOptionsNotTaken", By.xpath("//*[contains(@id,'CloseOptions:NotTakenJob')]"));
		hm.put("eleNGSNotTaken", By.id("NotTakenReasonPopup:RejectScreen:Update-btnInnerEl"));
		hm.put("edtNoOfPercentageSales", By.xpath("//input[contains(@id,'BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:PercentageOfProfSales')]"));
		hm.put("eleTitleElements", By.xpath("//span[contains(@id,'Screen:ttlBar')]"));
		hm.put("eleReturnToPolicyInfo", By.id("UWActivityPopup:__crumb__"));
		//Newly added
		hm.put("eleCancelPolicybtn", By.id("StartCancellation:StartCancellationScreen:Cancel-btnInnerEl"));
		hm.put("eleCan_PopupCancel", By.id("button-1008-btnInnerEl"));
		hm.put("eleConfirmation", By.id("CancellationWizard:CancellationWizard_QuoteScreen:ttlBar"));
		hm.put("eleCloseOptions", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:CloseOptions-btnWrap"));
		hm.put("eleCanwithdraw", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:CloseOptions:WithdrawJob-textEl"));
		hm.put("eleCancellation", By.id("JobComplete:JobCompleteScreen:ttlBar"));
		hm.put("eleReleaseCancelBtn", By.id("UWActivityPopup:Cancel-btnInnerEl"));
		hm.put("eleCustomerCompletionLetter", By.id("CancellationWizard:CancellationWizard_CompletionLetterScreen:ttlBar"));
		hm.put("edtCCFax", By.id("CancellationWizard:CancellationWizard_CompletionLetterScreen:CustomerCompletionLetterInputSet:CCLDeliveryFax-inputEl"));
		hm.put("eleScheduleCancel", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:BindOptions:SubmitCancellation-textEl"));
		hm.put("eleCanBack", By.id("CancellationWizard:Prev-btnEl"));
		hm.put("eleConfirmation", By.id("CancellationWizard:ViewQuote"));
		hm.put("eleCan_edtpolicytxn", By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"));
		hm.put("eleEntry", By.id("CancellationWizard:CancellationWizard_EntryScreen:ttlBar"));


		hm.put("elePolicyChnge_ManulaPolicyChk", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualPolicy-inputEl"));
		hm.put("selPolicyChnge_manualReason", By.xpath("//input[@id='StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualReason-inputEl']"));
		hm.put("dumPolicyChnge_manualReason", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualReason"));
		hm.put("clrPolicyChnge_manualReason", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ManualReason"));
		hm.put("selPolicyChnge_DescOfOther", By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:ReasonDescription-inputEl"));

		//Copy Submission
		hm.put("eleCopySubmission", By.xpath("//span[text()= 'Copy Submission']"));

		hm.put("elePC_EditEffective",By.id("PolicyChangeWizard:WizardMenuActions:WizardMenuActions_Change:WizardMenuActions_ChangeEffDate-textEl"));

		hm.put("eleRewriteDraftStatus", By.xpath("//span[contains(text(), 'Rewrite Full Term (Draft)')]"));
		hm.put("eleAccSumm_ProdCode", By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountPCsLV-body"));
		hm.put("eleVerifyBillingSubTab", By.id("AccountFile:MenuLinks:AccountFile_Billing"));
		//SC Classification Screen
		hm.put("eleSCClassification", By.xpath(".//span[contains(text(), 'SC Classification')]"));
		hm.put("eleSCClassification_Refresh", By.xpath(".//span[contains(text(), 'Refresh')]"));
		hm.put("btnSelectClassCode1", By.xpath("//table[@class='defaultList']/tbody/tr/td[2]"));
		hm.put("btnsavetoPC", By.xpath("//input[contains(@name,'saveToPolicyCenterButton')]"));
		hm.put("eleviewclassreport", By.xpath("//*[contains(@id,'ViewClassReportButton-btnInnerEl')]"));
		hm.put("eleTechnicalError", By.xpath("//p[contains(@class,'errorText')]"));
		hm.put("eleSCClass_PolTerms", By.xpath("//span[contains(text(), 'Policy Terms')]"));
		hm.put("eleVerifyBillingAgencyBill", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:billingNumber:BillingMethodLink_Ext:agencyBill_Ext"));
		hm.put("eleVerifyAuditPackageNA", By.xpath("//span[contains(text(),'Audit Package')]"));
		hm.put("eleAuditSaveDraft", By.id("AuditWizard:AuditWizard_SummaryScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"));
		hm.put("elePolicySummaryTable", By.xpath("//div[@id='PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']"));
		hm.put("eleRequiresFinalAudit", By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:FinalAudit-inputEl"));

		hm.put("elePayment_Versions", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:Versions-btnInnerEl')]"));
		hm.put("elePayment_MultiVersion", By.xpath("//*[contains(@id,'JobWizardToolbarButtonSet:Versions:NewVersion-textEl')]"));
		hm.put("edtVersionNum", By.id("SubmissionWizard:MultiQuoteAcceleratedMenuActions:PolicyPeriodSelector:PolicyPeriodSelector_Arg-inputEl"));
		hm.put("elePolicyVersions", By.xpath("//span[contains(text(),'Policy Versions')]"));
		hm.put("elePolicyVersionCheckBox", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV:br:1:BranchNameCB"));
		hm.put("elePolicyVersionSelectbtn", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV_tb:Wizard_ManageBranchesDV_SelectBranchButton-btnInnerEl"));
		hm.put("elePolicyVersionRenamebtn", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV_tb:Wizard_ManageBranchesDV_RenameButton-btnInnerEl"));
		hm.put("elePolicyVersionWithdrawbtn", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV_tb:Wizard_ManageBranchesDV_WithdrawButton-btnInnerEl"));
		hm.put("edtPolciyVersionRename", By.id("messagebox-1001-textfield-inputEl"));
		hm.put("elePolSumPendingPolicyTransactions", By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_JobsInProgressLV-body"));
		hm.put("elePolicyNumber", By.id("PolicyChangeWizard:JobWizardInfoBar:PolicyNumber-btnInnerEl"));
		hm.put("edtExposureField", By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:Classifications_LV-body']//td[6]"));


		//For reinstate usecase
		hm.put("eleRiskAnalysis_Table", By.xpath("//*[contains(@id,':Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:0-body')]"));
		hm.put("elereboundforce", By.xpath("//*[@role='presentation']/tbody/tr[3]/td"));
		hm.put("eleReNext", By.id("ReinstatementWizard:Next-btnInnerEl"));
		hm.put("eleRequote", By.id("ReinstatementWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		hm.put("elecancelvalidate", By.id("CancellationWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"));
		//CancellationWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl
		hm.put("elePolicyTransactions", By.xpath("//span[text() = 'Policy Transactions' and @class = 'x-tree-node-text ']"));
		hm.put("labelClassName", By.xpath("//*[@class='x-form-item-label x-unselectable x-form-item-label-left']"));

		hm.put("elCanWarnnigMessage", By.id("CancellationWizard:CancellationWizard_QuoteScreen:WarningsPanelSet:0:PanelSet:Warning"));
		hm.put("elCanPreQuoteIssue", By.id("UWBlockProgressIssuesPopup:IssuesScreen:PreQuoteIssueTitle"));
		hm.put("eleCanRiskAnalysis", By.id("CancellationWizard:Job_RiskAnalysisScreen:0"));
		hm.put("elReturnlink", By.id("UWBlockProgressIssuesPopup:__crumb__"));  
		hm.put("elUnderUWreview", By.id("SubmissionWizard:JobWizardInfoBar:EditLock-btnWrap"));  
		hm.put("eleLockreview", By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV_tb:LockForReview-btnInnerEl"));
		hm.put("eleRA_Approved", By.xpath("//*[contains(text(), 'Already Approved')]"));
		hm.put("eleRA_Blocking", By.xpath("//*[contains(text(), 'Blocking Issuance')]"));
		hm.put("eleRA_Reopen", By.xpath(".//*[contains(@id,':UWIssueRowSet:Reopen')]"));
		hm.put("eleRiskApproval_Cancel", By.id("RiskApprovalDetailsPopup:Cancel-btnInnerEl"));
		hm.put("eleRiskAnalysis_Table", By.xpath("//*[contains(@id,':Job_RiskAnalysisScreen:RiskAnalysisCV:RiskEvaluationPanelSet:0-body')]"));
		hm.put("lsjBldCode_EffectivenessGrade",By.xpath("//*[contains(@id,':BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:EffectivenessGradeRange-inputEl')]"));
		hm.put("edtBldClas_YearBulit", By.xpath(".//*[contains(@id,':LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet') and contains(@id,'YearBuilt_Ext-inputEl')]"));
		hm.put("eleIndividuallyGraded", By.xpath(".//*[contains(@id,':LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:IsIndividuallyGraded_Ext_true-inputEl')]"));
		hm.put("eljBldClas_SaveDraft", By.xpath(".//*[contains(@id,':LOBWizardStepGroup:LineWizardStepSet:BP7BuildingScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl')]"));
		hm.put("eleVerifyPolicyVersionstbl", By.id("SubmissionWizard:JobWizardToolsMenuWizardStepSet:ManageBranchesScreen:Wizard_ManageBranchesDV:Wizard_ManageBranchesLV-body"));
		hm.put("eleNarrativesbtn", By.id("PolicyChangeWizard:PolicyChangeWizard_QuoteScreen:ViewNarratives-btnInnerEl"));
		hm.put("eleContractorName", By.id("PolicyChangeWizard:LOBWizardStepGroup:PolicyChangeWizard_PolicyInfoScreen:PolicyChangeWizard_PolicyInfoDV:PolicyInfoInputSet:ContractorName-inputEl"));
		hm.put("eleLocations_AddAllExisting", By.xpath(".//*[contains(@id,':LocationsEdit_LV_tb:addAllLocationsButton-btnInnerEl')]"));
		hm.put("eleNarrativestbl", By.id("NarrativesPopup:NarrativesListScreen:NarrativeListLDV:NarrativeItemListLV-body"));
		hm.put("elePolicyReviewDifftbl", By.xpath(".//*[contains(@id,':DifferencesPanelSet:DiffTreePanelSet:DiffTreePanelLV-body')]"));
		hm.put("eleLiabilityCov", By.xpath(".//*[contains(text(),'Liability Worldwide Coverage')]"));
		hm.put("eleUmbrellaCov", By.xpath(".//*[contains(@id,'BP7AdditionalUmbCoveragesPanelSet:BP7AdditionalCoveragesDV:0:BP7CoverageInputSet:CovPatternInputGroup-legendTitle')]"));
		hm.put("elePol", By.id("AccountFile_Summary:AccountFile_SummaryScreen:PSPolicyTermInfo_ExtLV:0:higpolicy"));
		hm.put("edtAnnualSalesandRevenue", By.xpath(".//*[contains(@id,'BuildingDetailPanelDV:AnnualSales-inputEl')]"));
		hm.put("eleAlternatePayerNameclk", By.xpath(".//*[contains(@id,'AccountContactBillingInputSet:changeAltPayerContactButton_Ext-inputEl')]"));
		hm.put("eleAlternatePayerRemove", By.xpath(".//*[contains(@id,'changeAltPayerContactButton_Ext:Remove')]"));
		hm.put("eleLiabiltyOnly", By.xpath("//*[contains(@id,':BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:BuildingDetailPanelDV:LiabilityOnlyBuilding_Ext_true-inputEl')]"));
		hm.put("eleBuildingCoverages", By.xpath("//*[contains(@id,':BP7BuildingScreen:BP7BuildingPanelSet:BuildingsEdit_DP:BP7BuildingDetailCV:BP7BuildingCoveragesPanelSet:MandatoryCoveragesStandardProperty:0')]"));
		//Locations
		hm.put("eleLocationCheck_2", By.xpath(".//table[contains(@id,'gridview')]//tr[2]/td[2]//img"));

		//BusinessOwnersLine_AdditionalCovg
		hm.put("edtRetroactiveDate", By.xpath(".//input[contains(@id,'BP7CoverageInputSet:CovPatternInputGroup:DateTerm1:DateTimeTermInput-inputEl')]"));
		hm.put("eleEachPersonLimit", By.name("Each Person Limit"));
	    hm.put("eleOccurenceLimit", By.name("Occurrence Limit"));
	    hm.put("eleAggregateLimit", By.name("Aggregate Limit"));
	    hm.put("elePolicyFormPatterns", By.xpath(".//*[@id='Admin:MenuLinks:Admin_BusinessSettings:BusinessSettings_FormPatterns']/div/span"));
	    hm.put("edtFormNumber", By.id("FormPatterns:FormPatternSearchScreen:FormPatternSearchDV:FormNumber-inputEl"));
	    hm.put("eleFormSearch", By.id("FormPatterns:FormPatternSearchScreen:FormPatternSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"));
	    hm.put("eleFormTable", By.id("FormPatterns:FormPatternSearchScreen:FormPatternSearchResultsLV-body"));
	    hm.put("eleFormName", By.id("FormPatternDetail:FormPatternDetailScreen:FormPatternDetailCV:FormPatternDetail_BasicsDV:Name-inputEl"));
	    hm.put("eleLocationQuestionstbl", By.xpath(".//*[contains(@id,'LocationsEdit_DP:BP7LocationDetailCV:QuestionSetsDV:0:QuestionSetLV-body')]"));
	    hm.put("eleLocationsPage", By.xpath(".//*[contains(text(),'Locations')]"));
	    hm.put("eleLocQuestionstab", By.xpath(".//*[contains(@id,':BP7LocationDetailCV:LocationQuestionsCardTab-btnInnerEl')]"));
	    hm.put("eleDescriptionofPremises", By.name("Description of Premises, Project or Operations"));
	    hm.put("eleBusinessIncomeCoverage", By.name("Business Income and Extra Expense for Schools"));
	    hm.put("lstLimitType", By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:BP7LineScreen:BP7LinePanelSet:BP7LineCoveragesPanelSet:MandatoryCoveragesLineStandardPropertyCovColOne:BP7PropertyCoveragesColOneDV:0:BP7CoverageInputSet:CovPatternInputGroup:TypeKeyTerm:TypekeyTermInput-inputEl"));
	    hm.put("lstBC_LTTaxExemption", By.xpath("//input[contains(@id,'BuildingDetailPanelDV:DoestaxExemptApply-inputEl')]"));    
	}
	public By getObject(String ff) 
	{
		logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),ThreadCache.getInstance().getProperty("TCID"));
		//System.out.println("In Elements::::"+ThreadCache.getInstance().getProperty("TCID"));
		By retuValue = null;
		if (hm.containsKey(ff)) {
			retuValue = hm.get(ff);
		} else // if(retuValue == null)
		{
			logger.info("oops " + ff + " element is not available in the repository");
		}
		return retuValue;
	}
}

