package main.tests

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert.assertTrue

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

    fun fillInField(by: By, value: String?) {
        click(by)
        driver.findElement(by).clear()
        driver.findElement(by).sendKeys(value)
    }

    fun click(by: By) {
        assertTrue(isClickable(by), "Expected: element $by have to be clickable\nActual: can't click to not clickable element")
        assertTrue(isVisible(by), "Expected: element $by have to be visible\nActual: can't click to invisible element")
        driver.findElement(by).click()
    }

    fun scrollDown() {
        (driver as JavascriptExecutor)
            .executeScript("window.scrollTo(0, document.body.scrollHeight);")
        // Can't find the element which test could wait, add sleep() instead of it. Need to fix it.
        Thread.sleep(2000)
    }
}