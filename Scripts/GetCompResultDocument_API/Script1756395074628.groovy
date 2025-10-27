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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.FileUtil as FileUtil
import java.nio.file.Files
import java.nio.file.Paths

String Policynum = "0909608860"
//8341571859 -- failure
//9831696594 -- success
//1682034791 -- junk
//0909608860--- new

// Load your API test object and Send the request
def response = WS.sendRequest(findTestObject('Object Repository/API_Validation/CompResultAPI', [('FormNumber') : Policynum]))

//WS.verifyResponseStatusCode(response, 200)

// Get response as byte array
byte[] fileContent = response.getResponseBodyContent()

// Define output file path
String filePath = "C:\\Users\\mahathi.ananthula\\Katalon Studio\\SmartComm Project\\PC_${Policynum}.html" // Change file extension as needed

// Write to file
Files.write(Paths.get(filePath), fileContent)

println "File downloaded to: $filePath"

WS.delay(2)



//printing HTML file content

// Create a File object
File htmlFile = new File(filePath)

// Read the entire file content
String filedata = htmlFile.text

// Print the content to the console
println("HTML Content:\n" + filedata)