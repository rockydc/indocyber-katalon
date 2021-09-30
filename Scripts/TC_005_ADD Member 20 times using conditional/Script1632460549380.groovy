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

CustomKeywords.'helper.helper.loginBrowser'('rocky@gmail.com', 'Test1234')

int maxLoop = 20

String name = ''

int point = 0

for (int i = 1; i <= maxLoop; i++) {
    if ((i % 2) == 0) {
        name = 'Jaka'

        if (((i % 4) == 0) && ((i % 5) == 0)) {
            point = ((i * 4) * 5)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else if ((i % 4) == 0) {
            point = (i * 4)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else if ((i % 3) == 0) {
            point = (i * 3)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else if ((i % 5) == 0) {
            point = (i * 5)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else {
            point = i

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        }
    } else {
        name = 'Susan'

        if (((i % 3) == 0) && ((i % 5) == 0)) {
            point = ((i * 3) * 5)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else if ((i % 3) == 0) {
            point = (i * 3)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else if ((i % 5) == 0) {
            point = (i * 5)

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        } else {
            point = i

            CustomKeywords.'helper.helper.addDataMember'(name, point.toString())

            CustomKeywords.'helper.helper.checkingExistingData'('Name', name, 'Poin', point.toString())
        }
    }
}

