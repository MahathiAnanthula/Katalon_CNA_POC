import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Calling the reusable Testcase by passing the corresponding variables'
WebUI.callTestCase(findTestCase('ReusableTC'), [('Username') : Username, ('Password') : Password, ('ProducerCode') : ProducerCode
        , ('OrganizationName') : OrganizationName, ('AddressType') : AddressType, ('Zipcode') : Zipcode, ('State') : State
        , ('City') : City, ('Address1') : Address1, ('CompanyName') : CPCompanyName], FailureHandling.OPTIONAL)

'Select Commericial Property'
WebUI.click(findTestObject('Object Repository/Guidewire_New Submissions Page/div_Select_Commericial Property'))

'verify Policy Info page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Info Page/div_Policy Info'), 2)
'Get todays date'
def todaydate = new Date().format('MM/dd/YYYY')
'Pass current date to Quote Needed textbox'
WebUI.setText(findTestObject('Object Repository/Guidewire_Policy Info Page/input_Date Quote Needed'), todaydate)
'Select the organization type'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Policy Info Page/select_organizationType'), OrganizationType, 
    false)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify Buildings and Locations page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Buildings and Locations Page/div_Buildings and Locations'), 
    2)

'verify default location is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Buildings and Locations Page/div_default location'), 
    '1: 3449 Morgan ave, Corpus Christi, TX (Primary)')

'Click on down arrow to create a new building'
WebUI.click(findTestObject('Object Repository/Guidewire_Buildings and Locations Page/div_Down arrow icon'))
'Mouse over on Add building'
WebUI.mouseOver(findTestObject('Object Repository/Guidewire_Buildings and Locations Page/div_Add Building'))
'Click on New Building Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Buildings and Locations Page/div_New Building'))
'Delay the execution by 2 sec'
WebUI.delay(2)
'Send Property Class Code'
WebUI.setText(findTestObject('Object Repository/Guidewire_New Building Page/input_Property Class Code'), PropertyClassCode)
'Click on TAB from Keyboard'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_New Building Page/input_Property Class Code'), Keys.chord(Keys.TAB))
'Delay the execution by 2 sec'
WebUI.delay(2)

'scroll to select the coverages'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_New Building Page/select_Coverage From'), 3)
'click on the coverages'
WebUI.click(findTestObject('Object Repository/Guidewire_New Building Page/select_Coverage From'))
'Delay the execution by 2 sec'
WebUI.delay(2)
'Select the coverage from value'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_New Building Page/select_Coverage From'), CoverageFrom, 
    false)

'scroll to coverages tab'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_New Building Page/div_Coverages'), 2)
'Navigate to Coverages Tab'
WebUI.click(findTestObject('Object Repository/Guidewire_New Building Page/div_Coverages'))

'verify all different coverages are displayed'
WebUI.verifyElementChecked(findTestObject('Object Repository/Guidewire_New Building Page/input_Building Coverage_checkbox'), 
    0)

WebUI.verifyElementChecked(findTestObject('Object Repository/Guidewire_New Building Page/input_Business Income Coverage_checkbox'), 
    0)

WebUI.verifyElementChecked(findTestObject('Object Repository/Guidewire_New Building Page/input_Business Personal Property Coverage_checkbox'), 
    0)

WebUI.verifyElementChecked(findTestObject('Object Repository/Guidewire_New Building Page/input_Extra Expense Coverage_checkbox'), 
    0)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_New Building Page/input_Income Limit - Not Mfg or Rental'), 
    2)
'Pass the income limit value'
WebUI.setText(findTestObject('Object Repository/Guidewire_New Building Page/input_Income Limit - Not Mfg or Rental'), IncomeLimit)
'Click on OK button'
WebUI.click(findTestObject('Object Repository/Guidewire_Driver Details_Page/div_OK'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'Once building is craeted click next button'
WebUI.click(findTestObject('Object Repository/div_Next'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'verify Blankets page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Blankets Page/div_Blankets'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'verify Modifiers page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Modifiers Page/div_Modifiers'), 2)
'Click on Next button'
WebUI.click(findTestObject('Object Repository/div_Next'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'verify Risk Analysis page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Risk Analysis Page/div_Risk Analysis'), 2)
'click on next button'
WebUI.click(findTestObject('Object Repository/div_Next'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'verify Policy Review page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Policy Review'), 2)
'Click on Rate Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Rate'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'Verify the submission is rated'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Quote Page 2/div_Submission (Rated)'), 'Submission (Rated)')
'Click on Finish Quote Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Quote Page 2/div_FinishQuote'))
'Delay the execution by 2 sec'
WebUI.delay(2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'verify Forms page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Forms Page/div_Forms'), 2)
'click on next button'
WebUI.click(findTestObject('Object Repository/div_Next'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'verify Payments page is dispalyed and verify the billing method as Direct Bill'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_Payment'), 2)

WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Payment Page/Selected_Billing_Method'), 'Direct Bill')

'Wait for Bind options button and click on it'
WebUI.waitForElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'), 10)

WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'))
'Delay the execution by 2 sec'
WebUI.delay(2)
'Click on Bind only option'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_Bind Only'))
'Delay the execution by 2 sec'
WebUI.delay(2)
'Click on Bind only option'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_Bind Only'))
'Accept alert for the policy'
WebUI.acceptAlert()
'Delay the execution by 2 sec'
WebUI.delay(2)
'Get the policy num created'
String PolicyNum = WebUI.getText(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_Policy Num'))
'Print the policy num'
print('Policy Num is: ' + PolicyNum)

'click on view your policy link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_View your policy link'))

WebUI.delay(5)

'verify Policy Summary page is displayed and click Issue Policy under actions'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Policy Summary Title'), 3)

WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Issue Policy'))

WebUI.delay(2)

'click on Rate Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Rate'))

WebUI.delay(2)

'click on Finish Quote Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Quote Page 2/div_FinishQuote'))

WebUI.delay(2)

'click on Issue policy Button and accept alert'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote Page/div_Issue Policy'))

WebUI.delay(2)

WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote Page/div_Issue Policy'))
'Accept Alert'
WebUI.acceptAlert()

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Issuance Bound Page/Issuance_bound_status'), 3)
'click on view policy link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_View your policy link'))

WebUI.delay(2)

'navigate to new document under Actions'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.mouseOver(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_New Document'))

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_SmartCOMM - Create from a template'))

WebUI.delay(5)

//--------Documents Section-------------
'verifying all the elemnts are available or not'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Document Type'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Language'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/input_Keywords'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/input_Effective Date'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Creation Type'), 3)

'select creation type as Interactive and click search'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Search'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Search'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Select'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Select'))

WebUI.delay(2)

'navigate to Recipients Tab'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Recipients'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Recipients'))

WebUI.delay(2)

'select primary recipient as the company that we created'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_SPSet Primary Recipient'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_SPSet Primary Recipient'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Company Address'))

WebUI.delay(2)

'select delivery channel as print'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Delivery Channel'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Delivery Channel'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Delivery Channel'), DeliveryChannel, 
    false)

WebUI.delay(5)

'click on create Documnet Draft Button'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page2/div_Create Document Draft'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page2/div_Create Document Draft'), 
    2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page2/div_Create Document Draft'))

'Login to SmartComm Page and click on Finalize Document'
WebUI.delay(4)

WebUI.setText(findTestObject('Object Repository/Guidewire_Edit Document Draft Page/input_User ID_username'), SmartCommUserId)

WebUI.setEncryptedText(findTestObject('Object Repository/Guidewire_Edit Document Draft Page/input_Forgot password_password'), 
    SmartCommPwd)

WebUI.click(findTestObject('Object Repository/Guidewire_Edit Document Draft Page/button_Sign in'))

WebUI.delay(8)

WebUI.click(findTestObject('Object Repository/Guidewire_Edit Document Draft Page/div_Finalize Document'))

WebUI.delay(2)

'navigate to Documents'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'), 3)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'))

WebUI.delay(2)

'verify the options available in the document page'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_view document properties'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_view distribution status'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_Delete document'), 2)

'Close the Browser'
WebUI.closeBrowser()