package main.pages

import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert.assertTrue


class GoogleSearchImagesResultPage(driver: WebDriver) : Utils(driver) {

    // Locators
    private val imageResultLocator = By.xpath("//span[contains(text(),'Images')]")
    private val toolsButtonLocator = By.xpath("//div[contains(text(),'Tools')]")
    private val imagesWithIviLinkLocator = By.xpath("//img[data-iurl=contains(text(), 'ivi.ru')]")
    private fun optionNameLocator(name: String) = By.xpath("//div[contains(text(), '$name')]")
    private fun optionValueLocator(value: String) = By.xpath("//span[contains(text(), '$value')]")

    // Functions
    fun isDisplay(): Boolean {
        return isDisplay(imageResultLocator)
    }

    fun configureSearchResult(option: HashMap<String, String>) {
        assertTrue(isDisplay(), "Expected: Images Google Search Page is shown")
        click(toolsButtonLocator)
        // choose needed option
        click(optionNameLocator(option.keys.first()))
        isDisplay(optionValueLocator(option.values.first()))
        click(optionValueLocator(option.values.first()))
        // check that chosen option is set correctly
        isDisplay(optionValueLocator(option.values.first()))
    }

    fun countImages(maxPages: Int, minExpectedIviLinks: Int): Int {
        var count = driver.findElements(imagesWithIviLinkLocator).count()
        var i = 1
        while (i <= maxPages && count < minExpectedIviLinks) {
            scrollDown()
            count = driver.findElements(imagesWithIviLinkLocator).count()
            ++i
        }
        return count
    }
}
