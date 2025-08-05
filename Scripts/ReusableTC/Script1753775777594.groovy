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

'Open Browser'
WebUI.openBrowser('')

'Launch the Guidewire Url'
WebUI.navigateToUrl(GlobalVariable.GuidewireUrl)
'Maximize Window'
WebUI.maximizeWindow()

'Enter Username'
WebUI.setText(findTestObject('Object Repository/GuideWire_LoginPage/input_Username'), Username)

'Enter password'
WebUI.setEncryptedText(findTestObject('Object Repository/GuideWire_LoginPage/input_Password'), Password)
'Click on login button'
WebUI.click(findTestObject('Object Repository/GuideWire_LoginPage/div_Log In'))
'verify Homepage is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_HomePage/div_My Summary'), 5)

'Click on New Account under Actions'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_New Account'))

//Enter Account information and click on search
'generating a random num for unique company name'
def n = (int)((Math.random() * 10000) + 1); 

//def n = Math.random()
	

'pass the company name value'
WebUI.setText(findTestObject('Object Repository/Guidewire_Enter Account Information/input_Company Name'), CompanyName +
	n)
'Get the Company Name value and store it in variable'
def company_name = WebUI.getText(findTestObject('Object Repository/Guidewire_Enter Account Information/input_Company Name'))
'scroll to search button'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Enter Account Information/div_Search'), 3)
'click on search button'
WebUI.click(findTestObject('Object Repository/Guidewire_Enter Account Information/div_Search'))

'verify The search returned zero results message is displayed'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Enter Account Information/div_The search returned zero results'),
	3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Enter Account Information/div_The search returned zero results'),
	2)

'scroll to Create New account element'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Enter Account Information/div_CNCreate New Account'),
	3)
'Click on New Account Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Enter Account Information/div_CNCreate New Account'))
'Click on Company Name'
WebUI.click(findTestObject('Object Repository/Guidewire_Enter Account Information/div_Company'))

//Create Account by providing all details
'Verify create account page is disaplyed'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Create account/input_Name_CreateAccountPage'), company_name)
'Update the Address value'
WebUI.setText(findTestObject('Object Repository/Guidewire_Create account/input_Address 1'), Address1)
'Pass the City from Excel'
WebUI.setText(findTestObject('Object Repository/Guidewire_Create account/input_City'), City)
'Delay the execution by 2 sec'
WebUI.delay(2)
'Scroll to State element'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Create account/select_state'), 10)
'click on state dropdown'
WebUI.click(findTestObject('Object Repository/Guidewire_Create account/select_state'))

WebUI.delay(2)
'pass the state from excel'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Create account/select_state'), State, false)
'get the state value and store it in variable'
String selected_state = WebUI.getText(findTestObject('Object Repository/Guidewire_Create account/Selected_State'))
'scroll to zipcode field'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Create account/input_ZIP Code'), 10)

WebUI.delay(2)
'set the zipcode value from excel'
WebUI.setText(findTestObject('Object Repository/Guidewire_Create account/input_ZIP Code'), Zipcode)

WebUI.delay(2)
'click on address type DD'
WebUI.click(findTestObject('Object Repository/Guidewire_Create account/select_AddressType'))

WebUI.delay(2)
'Select the addresstype value from dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Create account/select_AddressType'), AddressType, false)

WebUI.delay(2)
'click on organization search icon'
WebUI.click(findTestObject('Object Repository/Guidewire_Create account/span_Organization_search-icon'))
'pass the organization name to search'
WebUI.setText(findTestObject('Object Repository/Guidewire_Organizations/input_Organization Name'), OrganizationName)
'click on search button'
WebUI.click(findTestObject('Object Repository/Guidewire_Organizations/div_Search'))

WebUI.delay(1)
'select the corresponding organization'
WebUI.click(findTestObject('Object Repository/Guidewire_Organizations/div_Select'))
'get the organization name and store it in variable'
String Organization_Name = WebUI.getText(findTestObject('Object Repository/Guidewire_Create account/input_Organization Name'))
'select the producer code value from dropdown'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Create account/select_ProducerCode'), ProducerCode,
	false)
'click on update button'
WebUI.click(findTestObject('Object Repository/Guidewire_Create account/div_Update'))

'verify New Submissions page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Account Summary_Page/Account Summary Title'), 3)

'Click on Actions-->New Submission'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.click(findTestObject('Object Repository/Guidewire_Account Summary_Page/div_New Submission'))

'Validate that Organization details, Default Base State, and Default Effective Date are populated correctly'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_New Submissions Page/input_Organization_NewSubmission'),
	Organization_Name)

WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_New Submissions Page/Default_Selected_State'), selected_state)

def todaysdate = new Date().format('MM/dd/YYYY')

String actualdate = WebUI.getAttribute(findTestObject('Object Repository/Guidewire_New Submissions Page/Selected_Default Date'),
	'value')

WebUI.verifyMatch(todaysdate, actualdate, false)

