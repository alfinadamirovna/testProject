package main.pages

import main.models.GoogleSearchTypes
import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert.assertTrue


class GoogleSearchResultPage(driver: WebDriver) : Utils(driver) {

    // Locators
    private val searchResultsLocator = By.xpath("//h1[contains(text(),'Search Results')]")
    private val googlePlayIviLinkLocator = By.xpath("//a[contains(@href, 'ivi.client')]")
    private val googlePlayIviRatingLocator = By.xpath("//a[contains(@href, 'ivi.client')]/../..//g-review-stars/..")
    private val wikiIviLinkLocator = By.xpath("//*[@id='search']//a[contains(@href, 'wikipedia.org')]")

    //Functions
    private fun searchLocator(searchType: String) =
        By.xpath("//div[@id='hdtbSum']//a[contains(text(),'${GoogleSearchTypes.valueOf(searchType)}')]")

    private fun chosenSearchLocator(searchType: String) =
        By.xpath("//span[contains(text(),'${GoogleSearchTypes.valueOf(searchType)}')]")

    private fun pageNumberLocator(number: Int) = By.xpath("//a[@aria-label='Page $number']")

    // Functions
    fun isDisplay(): Boolean {
        return isDisplay(searchResultsLocator)
    }

    fun switchSearchType(searchType: String) {
        assertTrue(isDisplay(), "Expected: Search Results Page is shown")
        click(searchLocator(searchType))
        assertTrue(isDisplay(chosenSearchLocator(searchType)), "Expected: $searchType is chosen")
    }

    fun searchWikiLink(): String {
        return if (isDisplay(wikiIviLinkLocator)) {
            driver.findElement(wikiIviLinkLocator).getAttribute("href").toString()
        } else {
            ""
        }
    }

    fun searchIviAppRating(): String {
        return if (isDisplay(googlePlayIviRatingLocator)) {
            val text = driver.findElement(googlePlayIviRatingLocator).text
            // search decimal number
            val ratingRegex = Regex(pattern = """\d\.\d""")
            ratingRegex.find(text)!!.value
        } else {
            ""
        }
    }

    fun openIviAppLink() {
        click(googlePlayIviLinkLocator)
    }

    fun openIviWikiArticleLink() {
        click(wikiIviLinkLocator)
    }

    fun nextPage(number: Int) {
        click(pageNumberLocator(number))
    }
}
