package main.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class Utils(var driver: WebDriver) {

    fun isDisplay(by: By, timeout: Long = 5): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed
        } catch (exp: Exception) {
            false
        }
    }

    fun isClickable(by: By, timeout: Long = 5): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            wait.until(ExpectedConditions.elementToBeClickable(by)).isEnabled
        } catch (exp: Exception) {
            false
        }
    }

    fun isVisible(by: By, timeout: Long = 5): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed
        } catch (exp: Exception) {
            false
        }
    }

    fun switchTab(index: Int) {
        driver.switchTo().window(ArrayList(driver.windowHandles)[index])
    }

    fun fillInField(by: By, value: String?) {
        click(by)
        driver.findElement(by).clear()
        driver.findElement(by).sendKeys(value)
    }

    fun click(by: By) {
        isClickable(by)
        isVisible(by)
        driver.findElement(by).click()
    }


}