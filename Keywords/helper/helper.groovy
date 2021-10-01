package helper
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class helper {

	/**
	 * Login browser
	 */
	@Keyword
	def loginBrowser(String email, String password) {
		try {
			WebUI.setText(findTestObject('loginpage/input-email'), email)

			WebUI.setText(findTestObject('loginpage/input_password'), password)

			WebUI.click(findTestObject('loginpage/btn-login'))
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}
	/**
	 * checkingExistingData
	 */
	@Keyword
	def checkingExistingData(String col1,String expectedValue1,String col2,String expectedValue2) {
		try {
			Boolean existing1 = false
			Boolean existing2 = false

			WebDriver driver = DriverFactory.getWebDriver()
			WebElement Table = driver.findElement(By.xpath('//table/tbody'))
			List<WebElement> Rows = Table.findElements(By.tagName('tr'))

			List<WebElement> tblHeader = Table.findElements(By.xpath('//table/thead/tr/th'))


			'Find a matching text in a table '
			for (int i = 0; i < Rows.size(); i++) {

				List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
				for(int j = 0; j<Cols.size();j++) {
					if(tblHeader.get(j).getText() == col1 ){
						println()
						if(Cols.get(j).getText() == expectedValue1) {
							existing1=true
						}
					} else if (tblHeader.get(j).getText() == col2) {
						if(Cols.get(j).getText() == expectedValue2) {
							existing2=true
						}
					}
				}

				if(existing1 == true && existing2 == true) {
					break;
				}
			}

			assert existing1==existing2
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Data is Not Existing")
		}
	}
	//	def checkingExistingData(String col1,String expectedValue1,String col2,String expectedValue2,String col3,String expectedValue3) {
	//		try {
	//			Boolean existing1 = false
	//			Boolean existing2 = false
	//			Boolean existing3 = false
	//
	//			WebDriver driver = DriverFactory.getWebDriver()
	//			WebElement Table = driver.findElement(By.xpath('//table/tbody'))
	//			List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	//
	//			List<WebElement> tblHeader = Table.findElements(By.xpath('//table/thead/tr/th'))
	//
	//
	//			'Find a matching text in a table '
	//			for (int i = 0; i < Rows.size(); i++) {
	//
	//				List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
	//				for(int j = 0; j<Cols.size();j++) {
	//					if(tblHeader.get(j).getText() == col1 ){
	//						println()
	//						if(Cols.get(j).getText() == expectedValue1) {
	//							existing1=true
	//						}
	//					} else if (tblHeader.get(j).getText() == col2) {
	//						if(Cols.get(j).getText() == expectedValue2) {
	//							existing2=true
	//						}
	//					}
	//					else if (tblHeader.get(j).getText() == col3) {
	//						if(Cols.get(j).getText() == expectedValue3) {
	//							existing3=true
	//						}
	//					}
	//				}
	//
	//				if(existing1 == true && existing2 == true && existing3 ==true) {
	//					break;
	//				}
	//			}
	//
	//			assert existing1==existing2==existing3
	//		} catch (WebElementNotFoundException e) {
	//			KeywordUtil.markFailed("Data is Not Existing")
	//		}
	//	}

	/**
	 * addDataMember
	 */
	@Keyword

	def addDataMember(String name,String point) {
		try {

			WebUI.setText(findTestObject('dashboard/form-sample-page/input-name'), name)

			WebUI.setText(findTestObject('dashboard/form-sample-page/input-point'), point)

			WebUI.click(findTestObject('dashboard/form-sample-page/btn-submit'))

			GlobalVariable.tmpData.add([name, point])


		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Data is Not Existing")
		}
	}

	/**
	 * deleteDataMember
	 */
	@Keyword

	def deleteDataMember(String name,String point) {
		try {

			Boolean isExist = true
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement Table = driver.findElement(By.xpath('//table/tbody'))
			List<WebElement> Rows = Table.findElements(By.tagName('tr'))

			'Find a matching text in a table '
			for (int i = 0; i < Rows.size(); i++) {
				List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

				if(Cols.get(0).getText() == name && Cols.get(1).getText() == point) {
					println(Cols.get(0).getText()+Cols.get(1).getText())
					Cols.get(Cols.size()-1).findElement(By.tagName('a')).click()
					WebUI.delay(2)
					WebUI.acceptAlert()
					isExist = false
					break
				}
			}

			assert isExist == false
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Data is Not Existing")
		}
	}

	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}