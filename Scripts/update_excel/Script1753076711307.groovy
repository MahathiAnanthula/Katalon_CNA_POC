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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

String doc_name = "PolicyManuscriptFreeFormRev1_Source"

//String excelpath= "C:\\Users\\mahathi.ananthula\\Katalon Studio\\SmartComm Project\\Sample CSV Template.csv"
String excelpath= "Sample CSV Template.csv"
String src_doc_path = "/home/ubuntu/pdfcomp/uat_server-06-09-23/python/"

String src_doc = src_doc_path + doc_name;

//CustomKeywords.'com.customkeywords.reusableMethods.updateCSVfile'(excelpath)
//CustomKeywords.com.customke
CustomKeywords.'com.customkeywords.updateCSVExample.updateCSV'()




























/*
//getting job_id
 String smartcomm_job_id = "https://na10-sb.smartcommunications.cloud/one/oauth1/bulkServices/api/v9/jobs/1196"

//Determine the starting index for the required substring
//startIndex = originalString.length() - desiredLength;

int strt_index = smartcomm_job_id.size() - 4;

println("starting index is : " +strt_index)

//get the substring value
//String sub = originalString.substring(startIndex);

String sub_str = smartcomm_job_id.substring(strt_index)

println("Sub string is : " + sub_str)
*/





/*
 //pdf data
 String str=" Endorsement Letter Named Insured Policy Number Automate_0.8337293238843773 9794613977 Carrier Policy Period HTC Insurance Company 11/01/2024 to 11/01/2025 Form Number F1234 THIS ENDORSEMENT CHANGES THE POLICY. PLEASE READ IT CAREFULLY. THIS ENDORSEMENT MODIFIES INSURANCE PROVIDED UNDER THE FOLLOWING: COMMERCIAL PROPERTY COVERAGE PART Schedule Premises Number Building Number Deductible Covered Cause(s) Of Loss *For each deductible listed in this Schedule enter the number corresponding to the Covered cause(s) of Loss to which that deductible applies (or enter the description) (1) All covered causes of Loss (2) All covered causes of Loss except Windstorm or Hail (3) All covered causes of Loss except Theft (4) All covered causes of Loss except Windstorm Or Hail and Theft (5) Windstorm or Hail (6) Theft (7) Water loss that directly and solely results in loss of damage or initiates a sequence of events that results in loss or damage, regardless of the nature of any intermediate or final event in that sequence. The deductible listed in this schedule does not apply where another cause of loss initiated a sequence of events that included water loss. Information required to complete this Schedule. If not shown above, will be shown in Declarations. This endorsement changes the policy to which it is attached and unless otherwise stated, is effective on the date issues at 12:01 A.M. standard time at your mailing address shown in the policy. The information below is required only when this endorsement is issued subsequent to commencement of the policy. Endorsement Effective 11/01/2024 Policy No.9794613977 Insured Automate_0.8337293238843773 Endorsement No.10 Countersigned Jack Smith By: ANIC CP 037 10 91"

String[] arrayList = str.split("\\s+")

println arrayList[7]
println arrayList[8]
println arrayList[20]


*/
WebUI.delay(2)
