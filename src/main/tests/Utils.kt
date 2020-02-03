package main.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

open class Utils(var driver: WebDriver) {
//    fun isDisplay(e: SelenideElement, timeout: Long = 5): Boolean {
//        return try {
//            e.waitUntil(Condition.visible, timeout * 1000).isDisplayed
//        } catch (exp: Error) {
//            false
//        }
//    }
//
//    // For cssSelectors only
//    fun isDisplay(e: String, timeout: Long = 5): Boolean {
//        return try {
//            get(By.cssSelector(e)).waitUntil(Condition.visible, timeout * 1000).isDisplayed
//        } catch (exp: Error) {
//            false
//        }
//    }

    fun isDisplay(by: By): Boolean {
        return try {
            driver.findElement(by).isDisplayed
        } catch (exp: Exception) {
            false
        }
    }

    fun switchTab(index: Int) {
        driver.switchTo().window(ArrayList(driver.windowHandles)[index])
    }

    fun fillInField(selector: String, value: String?) {
        driver.findElement(By.cssSelector(selector)).click()
        driver.findElement(By.cssSelector(selector)).clear()
        driver.findElement(By.cssSelector(selector)).sendKeys(value)
    }


}