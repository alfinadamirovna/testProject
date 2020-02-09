package main.tests

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert.assertTrue

open class Utils(var driver: WebDriver) {

    // will return true once the element is found in the DOM
    // use timeout in ms if you need to change default timeout
    fun isDisplay(by: By, timeout: Long = 5): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed
        } catch (exp: Exception) {
            false
        }
    }

    // checking an element is visible and enabled such that we can click on the element
    // use timeout in ms if you need to change default timeout
    fun isClickable(by: By, timeout: Long = 5): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            wait.until(ExpectedConditions.elementToBeClickable(by)).isEnabled
        } catch (exp: Exception) {
            false
        }
    }

    // check if the element is present on the DOM of a page and visible (element is not just displayed but also should also has a height)
    // use timeout in ms if you need to change default timeout
    fun isVisible(by: By, timeout: Long = 5): Boolean {
        return try {
            val wait = WebDriverWait(driver, timeout)
            wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed
        } catch (exp: Exception) {
            false
        }
    }

    // fill in a field
    fun fillInField(by: By, value: String?) {
        click(by)
        driver.findElement(by).clear()
        driver.findElement(by).sendKeys(value)
    }

    // click to element
    fun click(by: By) {
        assertTrue(isClickable(by), "Expected: element $by have to be clickable\nActual: can't click to not clickable element")
        assertTrue(isVisible(by), "Expected: element $by have to be visible\nActual: can't click to invisible element")
        driver.findElement(by).click()
    }

    // scroll page down
    fun scrollDown() {
        (driver as JavascriptExecutor)
            .executeScript("window.scrollTo(0, document.body.scrollHeight);")
        // Can't find the element which test could wait, add sleep() instead of it. Need to fix it.
        Thread.sleep(2000)
    }
}