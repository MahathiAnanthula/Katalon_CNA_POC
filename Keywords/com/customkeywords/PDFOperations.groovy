package com.customkeywords

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
//import org.apache.pdfbox.text.PDFTextStripper

//import org.apache.pdfbox.pdmodel.PDDocument;
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

import internal.GlobalVariable

public class PDFOperations {

	@Keyword
	def checkAndSavePDF(String downloadPath, String originalFileName, TestObject DownloadButton) {
		Path pdfPath = Paths.get(downloadPath, originalFileName)
		// Check if PDF already exists and delete it
		if (Files.exists(pdfPath)) {
			Files.delete(pdfPath)
			println "Existing PDF deleted: ${originalFileName}"
		}
		// Click 'Download' button to download the PDF
		WebUI.delay(5)
		WebUI.click(DownloadButton)

		// Wait for the PDF to download (add a wait time if necessary)
		WebUI.delay(15) // Adjust based on download speed


		// Define the original and new file paths
		//String downloadsPath = downloadPath // Replace with your actual path
		//String originalFileName = "downloaded_file.pdf" // Replace with the original filename
		String newFileName = "PolicyManuscriptFreeFormRev1_Target.pdf" // Replace with the desired new filename
		Path originalFilePath = Paths.get(downloadPath, originalFileName)
		Path newFilePath = Paths.get(downloadPath, newFileName)

		if (Files.exists(newFilePath)) {
			Files.delete(newFilePath)
		}

		try {
			Files.move(originalFilePath, newFilePath)
			println("File renamed successfully from $originalFileName to $newFileName")
		} catch (IOException e) {
			println("Error renaming file: " + e.getMessage())
		}

		// Verify if PDF was downloaded
		if (Files.exists(newFilePath)) {
			println "New PDF downloaded: ${originalFileName}"
		} else {
			println "PDF download failed: ${originalFileName}"
			assert false : "PDF download failed."
		}
	}


	/*	private String extractTextFromPDF(Path pdfPath) {
	 String text = ""
	 //File file = new java.io.File(pdfPath);
	 //PDDocument document = Loader.loadPDF(file)
	 //	PDDocument document = PDDocument.load(pdfPath.toFile())
	 //new java.io.File(FileToValidate.toString())
	 try {
	 PDFTextStripper pdfStripper = new PDFTextStripper()
	 text = pdfStripper.getText(document)
	 } finally {
	 document.close()
	 }
	 return text
	 }
	 */
}
