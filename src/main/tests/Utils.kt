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

    fun switchTab(index: Int) {
        driver.switchTo().window(ArrayList(driver.windowHandles)[index])
    }

    fun fillInField(by: By, value: String?) {
        driver.findElement(by).click()
        driver.findElement(by).clear()
        driver.findElement(by).sendKeys(value)
    }


}