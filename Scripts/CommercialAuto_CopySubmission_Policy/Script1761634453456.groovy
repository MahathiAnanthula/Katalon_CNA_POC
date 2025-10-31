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

import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
WebUI.delay(5)
'verify Homepage is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_HomePage/div_My Summary'), 5)

WebUI.click(findTestObject('Object Repository/Guidewire_My Summary Page/div_PolicyDownArrow_Expand'))
WebUI.setText(findTestObject('Object Repository/Guidewire_My Summary Page/input_PolicyNumber_Search'), PolicyNumber)
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_My Summary Page/input_PolicyNumber_Search'), Keys.chord(Keys.ENTER))

WebUI.delay(6)

'Click on New Account under Actions'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Copy Submission'))
WebUI.delay(2)

'verify offerings page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Offerings Page/div_Offerings'), 2)

'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify qualifications page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Qualification/div_Qualification'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify Policy Info page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Info Page/div_Policy Info'), 2)

'Get System today date'
def todaydate = new Date().format('MM/dd/YYYY')

'Pass the current date to Date Quote Needed field'
WebUI.setText(findTestObject('Object Repository/Guidewire_Policy Info Page/input_Date Quote Needed'), todaydate)

'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(4)

'verify Commercial auto line page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/div_Commercial Auto Line'),
	2)

'Delay the execution by 1 sec'
WebUI.delay(3)

//Select all required coverages
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_Limit Value'), 3)
WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_Limit Value'), "10")
WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_Start Coverage Date'), todaydate)
// Get current date
LocalDate currentDate = LocalDate.now()

// Add 2 year
LocalDate nextYearDate = currentDate.plusYears(2)

// Format date as needed (e.g., MM/dd/YYYY)
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY")
String formattedextyearDate = nextYearDate.format(formatter)

WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_End Coverage Date'), formattedextyearDate)

WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_Cost Of Fire'), "15")
WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_NumEmployees'), 4)
WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_NumEmployees'), "15")
WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_TotalPartners'), "20")
WebUI.setText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_TotalVolunteers'), "5")
WebUI.delay(2)

'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(4)
'verify locations page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Locations Page/div_Locations'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(4)
'verify Vehicles page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Vehicles Page/div_Vehicles'), 2)

WebUI.delay(5)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(4)
'verify State Info page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_State Info Page/div_State Info'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)
'verify Drivers page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Drivers Page/div_Drivers'), 2)
WebUI.delay(4)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)

'verify Covered Vehicles page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Covered Vehicles Page/div_Covered Vehicles'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)

'verify Modifiers page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Modifiers Page/div_Modifiers'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)

'verify Risk Analysis page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Risk Analysis Page/div_Risk Analysis'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)

'verify Policy Review page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Policy Review'), 2)
'Click on Quote Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Quote'))

WebUI.delay(5)
'Verify submissed Quoted Text'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Quote Page/div_Submission (Quoted)'), 'Submission (Quoted)')
'Click on Next button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)

'verify Forms page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Forms Page/div_Forms'), 2)
WebUI.delay(10)
WebUI.takeScreenshot()

'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(10)

'verify Payments page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_Payment'), 2)
WebUI.delay(4)
'verify billing method as Direct Bill'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Payment Page/Selected_Billing_Method'), 'Direct Bill')
'Wait for Bind options element is present'
WebUI.waitForElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'), 10)
'Clikc on Bind Options button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'))

WebUI.delay(4)
'Click on Bind Only Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_Bind Only'))

WebUI.delay(4)
'Click on Bind Only Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_Bind Only'))
'Accept the alert for corresponding Policy'
WebUI.acceptAlert()

WebUI.delay(4)
'Get the Policy number value and store it in variable'
String PolicyNum = WebUI.getText(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_Policy Num'))
'Print the Policy Num'
println(('Policy is: ' + PolicyNum) + 'created')
'Click on View your Policy link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_View your policy link' //click on view your policy link
		))
WebUI.delay(4)
'verify Policy Summary page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Policy Summary Title'), 3)
'Click on Actions to navigate to Issue policy Page'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))
'Click on Issue Policy Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Issue Policy'))

WebUI.delay(4)
'Verify Offerings Page is Displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Offerings Page/div_Offerings'), 2)

'click on quote'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Quote'))

WebUI.delay(3)
'verify issuance is quoted'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Quote Page/div_Issuance (Quoted)'), 3)

WebUI.delay(4)
'Click on Issue Policy Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote Page/div_Issue Policy'))

WebUI.delay(4)
'Click On Issue Policy Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote Page/div_Issue Policy'))
'Accept Alert for Policy Issuance'
WebUI.acceptAlert()

WebUI.delay(4)
'Verify Issuance Bound Status'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Issuance Bound Page/Issuance_bound_status'), 3)
'Click on View Policy Link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_View your policy link' //click on view policy link
		))
/*
//navigate to new document under Actions
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.mouseOver(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_New Document'))

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_SmartCOMM - Create from a template'))

WebUI.delay(5)

//--------Documents Section-------------
//verifying all the elemnts are available or not
'verifying all the elemnts are available or not'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Document Type'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Language'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/input_Keywords'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/input_Effective Date'), 3)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Creation Type'), 3)

'select creation type as Batch and click search'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Creation Type'), 10)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Creation Type'))

WebUI.delay(4)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Creation Type'), CreationType,
	false)

WebUI.delay(4)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Search'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Search'))

WebUI.delay(4)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Select'), 2)


WebDriver driver = DriverFactory.getWebDriver();
List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'AccPanelSet-2')]//table//tbody/tr/td//div[contains(@id,'select')]"))
println("size: "+elements.size())

	for (int i = 1;  i < elements.size(); i++) {
	WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/Select_Buttons',[("index"):i]),2)
	WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/Select_Buttons',[("index"):i]))
	}

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Select'))

WebUI.delay(4)

'navigate to Recipients Tab'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Recipients'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Recipients'))

WebUI.delay(4)

'select primary recipient as the company that we created'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_SPSet Primary Recipient'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_SPSet Primary Recipient'))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Company Address'))

WebUI.delay(4)

'select delivery channel as print'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Delivery Channel'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Delivery Channel'))

WebUI.delay(4)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Delivery Channel'), DeliveryChannel,
	false)

WebUI.delay(5)

'click on submit'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Submit'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Submit'))
*/
WebUI.delay(2)
'navigate to Documents'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'), 3)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'))

WebUI.delay(4)

'verify the options available in the document page'
//verify the options available in the document page
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_view document properties'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_view distribution status'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_Delete document'), 2)

WebUI.delay(20)
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Notes'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'))
WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_Download icon'), 15)
WebUI.click(findTestObject('Object Repository/Guidewire_Documents page/span_Download icon'))
