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
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter
import java.time.LocalTime

WebUI.openBrowser('')

WebUI.navigateToUrl('http://34.232.179.226:5000/login')
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_PDF Comparator/input_User ID_form-control custom-input ng-_9d5c70'), 
    'test@htcinc.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PDF Comparator/input_Password_form-control custom-input ng_eac701'), 
    'cvW8qx4B2o3F4VwP/kNsqA==')

WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/button_Sign in'))

WebUI.delay(5)

/*
 WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/input_Full Document radio Button'))
 
 WebUI.delay(1)
 
 WebUI.uploadFile(findTestObject('Object Repository/Page_PDF Comparator/input_Source Document_Browse Button'), "C:\\Users\\mahathi.ananthula\\Katalon Studio\\SmartComm Project\\PolicyManuscriptFreeFormRev1_Source.pdf")
 
 WebUI.uploadFile(findTestObject('Object Repository/Page_PDF Comparator/input_Target Document_Browse Button'), "C:\\Users\\mahathi.ananthula\\Katalon Studio\\SmartComm Project\\PolicyManuscriptFreeFormRev1_Target.pdf")
 
 //WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/input_Output_Both Radio Button'))
 WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/input_Output_HTML Radio Button'))
 
 WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/input_Ignore Spaces Exception_Radio Button'))
 
 WebUI.scrollToElement(findTestObject('Object Repository/Page_PDF Comparator/button_Submit'), 2)
 
 WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/button_Submit'))
 
 WebUI.delay(5)
 
 WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/button_Download'))
 
 WebUI.delay(15)
 
 */

WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/icon_three lines_Menu Options'))

WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/span_Schedule Option'))

WebUI.delay(4)

WebUI.sendKeys(findTestObject('Object Repository/Page_PDF Comparator/span_Schedule Option'), Keys.chord(Keys.ESCAPE))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/button_Schedule'))

WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/input_Full Document radio Button'))

WebUI.delay(1)

WebUI.uploadFile(findTestObject('Object Repository/Page_PDF Comparator/input_Path CSV Attchment'), "C:\\Users\\mahathi.ananthula\\Katalon Studio\\SmartComm Project\\CSVTemplate 1 2 3(in).csv")

WebUI.click(findTestObject('Object Repository/Pdf_calenderPick'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Pdf_activeDatePicker'))

Calendar c = Calendar.getInstance();

		// Print corresponding instances by passing
		// required some as in arguments
		int hour=c.get(Calendar.HOUR)
		System.out.println("Hour : " + hour);
		
		int minute=c.get(Calendar.MINUTE)
		System.out.println("Minute : " + minute)
		
String type=DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now()); 
System.out.println("Type : " + type)

if(hour <= 11)
	hour++
else
	hour = 1	
	
WebUI.click(findTestObject('Object Repository/timePick'))
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/numberPick',[("No"):hour]))

//WebUI.delay(3)
//WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/input__timepicker'))
WebUI.sendKeys(findTestObject('Object Repository/Page_PDF Comparator/input_Minute Picker-touched active'), Keys.chord(Keys.TAB))
//WebUI.delay(2)

//WebUI.enhancedClick(findTestObject('Object Repository/minutesPick',[("Min"):55]))

/*
if(minute<5) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"05"]))	
}else if(minute>=5 & minute<10) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"10"]))	
}
else if(minute>=10 & minute<15) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"15"]))
}
else if(minute>=15 & minute<20) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"20"]))
}
else if(minute>=20 & minute<25) {
	minute = "25"
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):minute]))
}
else if(minute>=25 & minute<30) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"30"]))
}
else if(minute>=30 & minute<35) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"35"]))
}
else if(minute>=35 & minute<40) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"40"]))
}
else if(minute>=40 & minute<45) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"45"]))
}
else if(minute>=45 & minute<50) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"50"]))
}
else if(minute>=50 & minute<55) {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"55"]))
}
else if(minute>=55 & minute<60) {
	minute = 59
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):minute]))
}else {
	WebUI.click(findTestObject('Object Repository/minutesPick',[("Min"):"00"]))
}

*/

WebUI.delay(1)
if(type.contains('am')) 
	WebUI.click(findTestObject('Object Repository/timetypeselection',[("type"):"AM"]))
else 
	WebUI.click(findTestObject('Object Repository/timetypeselection',[("type"):"PM"]))

WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/span_OK'))
WebUI.delay(2)
WebUI.scrollToElement(findTestObject('Object Repository/Page_PDF Comparator/button_Schedule'), 2)
WebUI.click(findTestObject('Object Repository/Page_PDF Comparator/button_Schedule'))




WebUI.delay(15)

//WebUI.closeBrowser()