package main.pages

import main.models.GoogleSearchTypes
import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert.assertTrue


class GoogleSearchResultPage(driver: WebDriver) : Utils(driver) {

    private val searchResultsLocator = By.xpath("//h1[contains(text(),'Search Results')]")
    private fun searchLocator(searchType: String): By {
        return By.xpath("//div[@id='hdtbSum']//a[contains(text(),'${GoogleSearchTypes.valueOf(searchType)}')]")
    }

    private fun chosenSearchLocator(searchType: String): By {
        return By.xpath("//span[contains(text(),'${GoogleSearchTypes.valueOf(searchType)}')]")
    }

    private val googlePlayIviLinkLocator = By.xpath("//a[contains(@href, 'ivi.client')]")
    private val googlePlayIviRatingLocator = By.xpath("//a[contains(@href, 'ivi.client')]/../..//g-review-stars/..")
    private fun pageNumberLocator(number: Int): By {
        return By.xpath("//a[@aria-label='Page $number']")
    }

    fun isDisplay(): Boolean {
        return isDisplay(searchResultsLocator)
    }

    fun switchSearchType(searchType: String) {
        assertTrue(isDisplay(), "Expected: Search Results Page is shown")
        click(searchLocator(searchType))
        assertTrue(isDisplay(chosenSearchLocator(searchType)), "Expected: $searchType is chosen")
    }

    fun searchIviAppRating(appData: String): String {
        // search decimal number
        val ratingRegex = Regex(pattern = """\d\.\d""")
        return if (isDisplay(googlePlayIviRatingLocator)) {
            val text = driver.findElement(googlePlayIviRatingLocator).text
            ratingRegex.find(text)!!.value
        } else {
            appData
        }
    }

    fun openIviAppLink() {
        click(googlePlayIviLinkLocator)
    }

    fun nextPage(number: Int) {
        click(pageNumberLocator(number))
    }
}
