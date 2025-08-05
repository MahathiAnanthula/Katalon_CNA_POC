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
import org.junit.Assert as Assert
import org.junit.Before as Before
import org.junit.Test as Test
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedCondition as ExpectedCondition
import org.openqa.selenium.support.ui.Wait as Wait
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
//import org.apache.pdfbox.text.PDFTextStripper as PDFTextStripper
//import org.apache.pdfbox.pdmodel.PDDocument as PDDocument
import javax.xml.xpath.XPath as XPath
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

'Calling the reusable Testcase by passing the corresponding variables'
WebUI.callTestCase(findTestCase('ReusableTC'), [('Username') : Username, ('Password') : Password, ('ProducerCode') : ProducerCode
        , ('OrganizationName') : OrganizationName, ('AddressType') : AddressType, ('Zipcode') : Zipcode, ('State') : State
        , ('City') : City, ('Address1') : Address1, ('CompanyName') : CACompanyName], FailureHandling.OPTIONAL)

'Select Commericial Auto Option'
WebUI.click(findTestObject('Object Repository/Guidewire_New Submissions Page/div_Select Commercial Auto'))

'verify offerings page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Offerings Page/div_Offerings'), 2)

'Select OfferingSelection value'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Offerings Page/select_OfferingSelection'), OfferingSelection, 
    false)

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

'Select the OrganizationType Value'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Policy Info Page/select_organizationType'), OrganizationType, 
    false)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify Commercial auto line page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/div_Commercial Auto Line'), 
    2)

'Select the Product value from dropdown'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/select_product'), Product, 
    false)
'Delay the execution by 1 sec'
WebUI.delay(1)
'Select the Fleet value from Dropdown'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/select_fleet'), Fleet, 
    false)
'Delay the execution by 1 sec'
WebUI.delay(1)
'Click on Liability checkbox'
WebUI.click(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/input_Bobtail Liability'))
'Delay the execution by 1 sec'
WebUI.delay(1)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify locations page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Locations Page/div_Locations'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify Vehicles page is displayed' 
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Vehicles Page/div_Vehicles'), 2)

'Click on Create vehicle'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicles Page/div_Create Vehicle'))
'Delay the execution by 2 sec'
WebUI.delay(2)

'Click on garaged address for vehicle'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicle Information Page/select_Garaged at'))
'Press down arrow to select the address'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/select_Garaged at'), Keys.chord(Keys.ARROW_DOWN))
'Press Enter to select the address'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/select_Garaged at'), Keys.chord(Keys.ENTER))
'Delay the execution by 2 sec'
WebUI.delay(2)
'Click on the vehicle type'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicle Information Page/select_VehicleType'))
'Press down arrow to select the address'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/select_VehicleType'), Keys.chord(Keys.ARROW_DOWN))
'Press Enter to select the address'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/select_VehicleType'), Keys.chord(Keys.ENTER))
'Delay the execution by 1 sec'
WebUI.delay(1)
'Scroll to select VIN'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_VIN'), 2)
'Click on VIN textbox'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_VIN'))
'Delay the execution by 1 sec'
WebUI.delay(1)
'Input the value of VIN'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_VIN'), VIN)
'Delay the execution by 1 sec'
WebUI.delay(1)
'Scroll to select cost'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_Cost'), 2)
'Click on cost checkbox'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_Cost'))
'Delay the execution by 1 sec'
WebUI.delay(1)
'Input the value of cost'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_Cost'), Cost)
'Scroll to ClassCode Element'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_Class_SelectClassCode'), 
    2)
'Click on Class Code'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_Class_SelectClassCode'))

WebUI.delay(1)
'Input the ClassCode Value'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Vehicle Information Page/input_Class_SelectClassCode'), ClassCode)
'Click on OK Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Vehicle Information Page/div_OK'))

WebUI.delay(5)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify State Info page is displayed' 
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_State Info Page/div_State Info'), 2)
'Click on Back Button to navigate back to Commercial Auto Line page'
WebUI.click(findTestObject('Object Repository/Guidewire_State Info Page/div_Back'))

WebUI.delay(2)
'Click on Back Button to navigate back to Commercial Auto Line page'
WebUI.click(findTestObject('Object Repository/Guidewire_State Info Page/div_Back'))

WebUI.delay(2)
'Click on Back Button to navigate back to Commercial Auto Line page'
WebUI.click(findTestObject('Object Repository/Guidewire_State Info Page/div_Back'))

WebUI.delay(2)
'Click on Clear button'
WebUI.click(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/div_Clear'))
'verify Liability Limit is defaulted to 1M CSL value'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Commercial Auto Line page/Selected_Liability_Limit'), 
    LiabilityLimit)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

'verify Drivers page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Drivers Page/div_Drivers'), 2)
'Click on Add Driver Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Drivers Page/div_Add Driver'))

'Enter Driver First Name'
WebUI.setText(findTestObject('Object Repository/Guidewire_Driver Details_Page/input_First name'), DriverFirstName)
'Enter Driver Last Name'
WebUI.setText(findTestObject('Object Repository/Guidewire_Driver Details_Page/input_Last name'), DriverlastName)
'Enter Driver DOB'
WebUI.setText(findTestObject('Object Repository/Guidewire_Driver Details_Page/input_Date of Birth'), DateOfBirth)
'Enter Driver License Num'
WebUI.setText(findTestObject('Object Repository/Guidewire_Driver Details_Page/input_License'), License)
'Scroll To State Element'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Driver Details_Page/select_state'), 10)
'Click on State Dropdown'
WebUI.click(findTestObject('Object Repository/Guidewire_Driver Details_Page/select_state'))

WebUI.delay(2)
'Select the State value as Texas'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Driver Details_Page/select_state'), State, false)

WebUI.delay(2)
'Click on OK Button to add the driver info'
WebUI.click(findTestObject('Object Repository/Guidewire_Driver Details_Page/div_OK'))

WebUI.delay(2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)

'verify Covered Vehicles page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Covered Vehicles Page/div_Covered Vehicles'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)

'verify Modifiers page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Modifiers Page/div_Modifiers'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)

'verify Risk Analysis page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Risk Analysis Page/div_Risk Analysis'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)

'verify Policy Review page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Policy Review'), 2)
'Click on Quote Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Quote'))

WebUI.delay(5)
'Verify submissed Quoted Text'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Quote Page/div_Submission (Quoted)'), 'Submission (Quoted)')
'Click on Next button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(2)

'verify Forms page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Forms Page/div_Forms'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(10)

'verify Payments page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_Payment'), 2)
'verify billing method as Direct Bill'
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_Payment Page/Selected_Billing_Method'), 'Direct Bill')
'Wait for Bind options element is present'
WebUI.waitForElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'), 10)
'Clikc on Bind Options button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'))

WebUI.delay(2)
'Click on Bind Only Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_Bind Only'))

WebUI.delay(2)
'Click on Bind Only Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_Bind Only'))
'Accept the alert for corresponding Policy'
WebUI.acceptAlert()

WebUI.delay(2)
'Get the Policy number value and store it in variable'
String PolicyNum = WebUI.getText(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_Policy Num'))
'Print the Policy Num'
println(('Policy is: ' + PolicyNum) + 'created')
'Click on View your Policy link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_View your policy link' //click on view your policy link
        ))

'verify Policy Summary page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Policy Summary Title'), 3)
'Click on Actions to navigate to Issue policy Page'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))
'Click on Issue Policy Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Issue Policy'))

WebUI.delay(2)
'Verify Offerings Page is Displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Offerings Page/div_Offerings'), 2)

'click on quote'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Quote'))

WebUI.delay(3)
'verify issuance is quoted'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Quote Page/div_Issuance (Quoted)'), 3)

WebUI.delay(2)
'Click on Issue Policy Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote Page/div_Issue Policy'))

WebUI.delay(2)
'Click On Issue Policy Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote Page/div_Issue Policy'))
'Accept Alert for Policy Issuance'
WebUI.acceptAlert()

WebUI.delay(2)
'Verify Issuance Bound Status'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Issuance Bound Page/Issuance_bound_status'), 3)
'Click on View Policy Link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_View your policy link' //click on view policy link
        ))

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

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Guidewire_Policy Summary Page/select_Creation Type'), CreationType, 
    false)

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Search'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Search'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Select'), 2)

/*
WebDriver driver = DriverFactory.getWebDriver();
List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'AccPanelSet-2')]//table//tbody/tr/td//div[contains(@id,'select')]"))
println("size: "+elements.size())

	for (int i = 1;  i < elements.size(); i++) {
	WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/Select_Buttons',[("index"):i]),2)	
	WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/Select_Buttons',[("index"):i]))
	}
*/
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

'click on submit'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Submit'), 2)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Submit'))

'navigate to Documents'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'), 3)

WebUI.click(findTestObject('Object Repository/Guidewire_Policy Summary Page/div_Documents'))

WebUI.delay(2)
'verify the options available in the document page'
//verify the options available in the document page
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_view document properties'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_view distribution status'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Documents page/span_Delete document'), 2)

/*
 WebUI.click(findTestObject('Object Repository/Guidewire_Documents page/span_view document properties'))

'get text of the document name'
//get text of the document name
String doc_name = WebUI.getText(findTestObject('Object Repository/Guidewire_Document Properties Page/Document_Name'))

println('Document Name: ' + doc_name)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Document Properties Page/SmartCommJobId'), 2)
*/
WebUI.delay(1)

'Close th Browser'
WebUI.closeBrowser()
