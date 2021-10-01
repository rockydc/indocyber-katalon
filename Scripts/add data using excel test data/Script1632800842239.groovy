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

WebUI.openBrowser('http://116.254.100.222:81/login')

CustomKeywords.'helper.helper.loginBrowser'(GlobalVariable.username, GlobalVariable.password)

Object dataExcel = findTestData('ExcelData')

Object excelRowNumber = findTestData('ExcelData').getRowNumbers()

//String getName = dataExcel.getValue('Job',1)
//println(getName)
for (int rowCounter = 1; rowCounter < excelRowNumber; rowCounter++) {
    'Mengambil nama dari excel'
    String getName = dataExcel.getValue('Nama', rowCounter)

    'Mengamil job dari excel'
    String getJob = dataExcel.getValue('Job', rowCounter)

    'Mengambil point dari id di excel'
    String getPoint = dataExcel.getValue('No', rowCounter)

    CustomKeywords.'helper.helper.addDataMember'((getName + '_') + getJob, getPoint)

    CustomKeywords.'helper.helper.checkingExistingData'('Name', (getName + '_') + getJob, 'Poin', getPoint)
}

