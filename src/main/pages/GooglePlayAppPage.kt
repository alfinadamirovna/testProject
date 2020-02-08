package main.pages

import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert.assertTrue

class GooglePlayAppPage(driver: WebDriver) : Utils(driver) {

    private val googlePlayLogoLocator = By.xpath("//img[contains(@src, 'android/market_images/')]")
    private val appRatingLocator = By.xpath("//*[contains(@aria-label,'stars out of five stars')]")
    private val iviAppTitleLocator = By.xpath("//h1/span[contains(text(),'ivi')]")

    fun isDisplay(): Boolean {
        return isDisplay(googlePlayLogoLocator)
    }

    fun isIviAppDisplay(): Boolean {
        return isDisplay(iviAppTitleLocator)
    }

    fun searchIviAppRating(appData: String): String {
        // search decimal number
        val ratingRegex = Regex(pattern = """\d\.\d""")
        return if (isDisplay(appRatingLocator)) {
            val text = driver.findElement(appRatingLocator).getAttribute("aria-label").toString()
            assertTrue(
                text.isNotEmpty(),
                "Expected: Google App Page contains rating\nActual: can't find rating on a Google App Page"
            )
            ratingRegex.find(text)!!.value
        } else {
            appData
        }
    }
}