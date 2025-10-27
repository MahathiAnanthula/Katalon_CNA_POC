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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Calling the reusable Testcase by passing the corresponding variables'
WebUI.callTestCase(findTestCase('AccountCreation_ReusableTC'), [('Username') : Username, ('Password') : Password, ('ProducerCode') : ProducerCode
		, ('OrganizationName') : OrganizationName, ('AddressType') : AddressType, ('Zipcode') : Zipcode, ('State') : State
		, ('City') : City, ('Address1') : Address1, ('CompanyName') : GLCompanyName], FailureHandling.OPTIONAL)


'Click on Actions-->New Submission'
WebUI.click(findTestObject('Object Repository/Guidewire_HomePage/div_Actions'))

WebUI.click(findTestObject('Object Repository/Guidewire_Account Summary_Page/div_New Submission'))
WebUI.delay(4)
'Validate that Organization details, Default Base State, and Default Effective Date are populated correctly'
//WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_New Submissions Page/input_Organization_NewSubmission'),OrganizationName)
//WebUI.delay(4)
WebUI.verifyElementText(findTestObject('Object Repository/Guidewire_New Submissions Page/Default_Selected_State'), State)

def todaysdate = new Date().format('MM/dd/YYYY')

String actualdate = WebUI.getAttribute(findTestObject('Object Repository/Guidewire_New Submissions Page/Selected_Default Date'),
	'value')

WebUI.verifyMatch(todaysdate, actualdate, false)




'Select General Liability Option'
WebUI.click(findTestObject('Object Repository/Guidewire_New Submissions Page/GeneralLiability_Select'))

WebUI.delay(4)
'verify offerings page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Offerings Page/div_Offerings'), 2)

'Select OfferingSelection value'
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Offerings Page/select_OfferingSelection'), GLOfferingSelection,
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
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Policy Info Page/select_organizationType'), 2)
WebUI.selectOptionByValue(findTestObject('Object Repository/Guidewire_Policy Info Page/select_organizationType'), OrganizationType, false)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)
'verify locations page is displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Locations Page/div_Locations'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))

WebUI.delay(4)
'Navigate to Additional Coverages Tab'
WebUI.click(findTestObject('Object Repository/Guidewire_Coverages Page/Additional Coverages Tab'))
'Click on Add Coverages Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Coverages Page/Add Coverages Button'))
WebUI.delay(3)

'click on search button to look for the coverages'
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Search Button'))

//Select all related coverages
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Pollution Coverage_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Contractual Liability Railroads_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Contractual Liab for Personal and Advertising_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Condominiums_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Electronic Data Liability_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Governmental Subdivisions_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Lawn Care Services_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Limited Fungi or Bacteria Coverage_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Underground Resources and Equip Coverage_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Coverage for injury to leased Workers_Checkbox'))

'Scroll and click on Add Selected coverages button'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Add Selected Coverages Button'),2)
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Add Selected Coverages Button'))

'Navigate to Exclusions and Conditions Tab'
WebUI.click(findTestObject('Object Repository/Guidewire_Coverages Page/Exclusions_Conditions Tab'))

'Click on Add Exclusions and conditions Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Coverages Page/Add Exclusion or Condition_Button'))
WebUI.delay(3)

'click on search button to look for the coverages'
WebUI.click(findTestObject('Object Repository/Guidewire_Search Coverages for General Liability Line/Search Button'))
WebUI.delay(2)

//Select all related Exclusions
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Pollution Absolute_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Pollution - Except Heating Equip Hostile Fire_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Pollution - Except Hostile Fire_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Amend Liquor Liability_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Contract Liability Limitation_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Abuse or Molestation_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Damage to Rented Premises_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Damage to Subcontractors Work_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Exterior Insulation Finish Systems_Checkbox'))
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Exclude Fungi or Bacteria_Checkbox'))

'Scroll and click on Add exclusions button'
WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Add Selected Exclusions And Conditions_Button'), 2)
WebUI.click(findTestObject('Object Repository/Guidewire_Search Exclusions And Conditions for General Liability Line/Add Selected Exclusions And Conditions_Button'))

WebUI.delay(3)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(3)

'verify Exposures page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Exposures Page/div_Exposures'), 2)
WebUI.click(findTestObject('Object Repository/Guidewire_Exposures Page/div_Add Button'))

WebUI.click(findTestObject('Object Repository/Guidewire_Exposures Page/select_Address DD'))
'Press down arrow to select the address'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Exposures Page/select_Address DD'), Keys.chord(Keys.ARROW_DOWN))
'Press Enter to select the address'
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Exposures Page/select_Address DD'), Keys.chord(Keys.ENTER))
'Delay the execution by 2 sec'
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Guidewire_Exposures Page/search icon_Basis Type'))
'select the corresponding Basis'
WebUI.click(findTestObject('Object Repository/Guidewire_Organizations/div_Select'))
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Exposures Page/search icon_Basis Type'), Keys.chord(Keys.TAB))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/Guidewire_Exposures Page/Basis Amount'), "10")
WebUI.delay(2)

'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(3)

'verify Modifiers page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Modifiers Page/div_Modifiers'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(3)

'verify Risk Analysis page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Risk Analysis Page/div_Risk Analysis'), 2)
'Click on Next Button'
WebUI.click(findTestObject('Object Repository/div_Next'))
WebUI.delay(3)

'verify Policy Review page is dispalyed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Policy Review'), 2)
WebUI.delay(3)

'Click on Quote Button'
WebUI.click(findTestObject('Object Repository/Guidewire_Policy Review Page/div_Quote'))
WebUI.delay(4)

'Wait for Bind options element is present'
WebUI.waitForElementPresent(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'), 10)
'Clikc on Bind Options button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Payment Page/div_BOBind Options'))

WebUI.delay(4)
'Click on Bind Only Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote/div_Issue Policy DD'))

WebUI.delay(4)
'Click on Bind Only Button'
WebUI.enhancedClick(findTestObject('Object Repository/Guidewire_Quote/div_Issue Policy DD'))
'Accept the alert for corresponding Policy'
WebUI.acceptAlert()

WebUI.delay(4)
'Get the Policy number value and store it in variable'
String PolicyNum = WebUI.getText(findTestObject('Object Repository/Guidewire_Submission Bound Page/div_Policy Num'))
'Print the Policy Num'
println('Policy is: ' + PolicyNum + ' created')
'Click on View your Policy link'
WebUI.click(findTestObject('Object Repository/Guidewire_Submission Bound Page/View your submission link'))

'Get the Policy number value and store it in variable'
String SubNum = WebUI.getText(findTestObject('Object Repository/Guidewire_Submission Bound Page/Submission_Num'))
'Print the Policy Num'
println(SubNum)

WebUI.scrollToElement(findTestObject('Object Repository/Guidewire_Quote/div_Documents Tab'), 3)
WebUI.click(findTestObject('Object Repository/Guidewire_Quote/div_Documents Tab'))

