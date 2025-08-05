package com.customkeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.io.BufferedReader;

import internal.GlobalVariable

public class updateCSVExample {
	@Keyword
	def updateCSV()  {
		File csvFile = new File('C:\\Users\\mahathi.ananthula\\Katalon Studio\\SmartComm Project\\Sample CSV Template.csv')
		def lines = csvFile.readLines()
		def updatedLines = []
		lines.eachWithIndex { line, idx ->
			if (idx == 1) {
				updatedLines << 'source.pdf,target.pdf'
			} else {
				updatedLines << line
			}
		}
		csvFile.text = updatedLines.join('\n')
	}
}

