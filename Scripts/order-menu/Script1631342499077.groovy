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


//Faker
//
WebUI.openBrowser('http://116.254.100.222:81/login')

CustomKeywords.'helper.helper.loginBrowser'('rocky@gmail.com', 'rocky182')

WebUI.click(findTestObject('Object Repository/dashboard/transaction-menu'))

WebUI.scrollToElement(findTestObject('Object Repository/orderPage/orderAction_btn'), 1)

WebUI.click(findTestObject('Object Repository/orderPage/orderAction_btn'))

WebUI.verifyElementPresent(findTestObject('Object Repository/orderPage/modal-content'), 1)

WebUI.click(findTestObject('Object Repository/orderPage/btn-nasi'))

WebUI.verifyElementPresent(findTestObject('Object Repository/orderPage/modal-cat-nasi'), 1)

WebUI.click(findTestObject('Object Repository/orderPage/btn-nasi-goreng'))

WebUI.verifyElementPresent(findTestObject('Object Repository/orderPage/Modal-order'), 1)

WebUI.verifyElementText(findTestObject('Object Repository/orderPage/modal-title-order'), 'Order Delivery')

WebUI.setText(findTestObject('Object Repository/orderPage/form-order/input-name'), name)

WebUI.setText(findTestObject('Object Repository/orderPage/form-order/input-address'), address)

WebUI.click(findTestObject('Object Repository/orderPage/form-order/input-phone'))

WebUI.setText(findTestObject('Object Repository/orderPage/form-order/input-phone'), '0813920443')

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/orderPage/form-order/input-order'), 'value', 'Nasi Goreng', 
    1)

WebUI.click(findTestObject('Object Repository/orderPage/form-order/btn-submit'), FailureHandling.STOP_ON_FAILURE)

existingData = CustomKeywords.'helper.helper.checkingExistingData'('Name',name,'Address',address)

existingData.equals(true)

