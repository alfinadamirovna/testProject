package main.pages

import main.models.GoogleSearchTypes
import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert.assertTrue


class GoogleSearchResultPage(driver: WebDriver) : Utils(driver) {

    private val searchResultsLocator = By.xpath("//h1[contains(text(),'Search Results')]")

    fun isDisplay(): Boolean {
        return isDisplay(searchResultsLocator)
    }

    fun switchSearchType(searchType: String) {
        assertTrue(isDisplay(), "Expected: Search Results Page is shown")
        val searchLocator = "//div[@id='hdtbSum']//a[contains(text(),'${GoogleSearchTypes.valueOf(searchType)}')]"
        click(By.xpath(searchLocator))
        val chosenSearchLocator =
            "//span[contains(text(),'${GoogleSearchTypes.valueOf(searchType)}')]"
        assertTrue(isDisplay(By.xpath(chosenSearchLocator)), "Expected: $searchType is chosen")
    }
}
