package main.pages

import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class WikipediaArticlePage(driver: WebDriver) : Utils(driver) {

    //Locators
    private val wikipediaLogoLocator = By.xpath("//a[@class='mw-wiki-logo']")

    private fun iviLinkLocator(link: String) = By.xpath("//*[contains(text(),'$link')]")

    // Functions
    fun isDisplay(): Boolean {
        return isDisplay(wikipediaLogoLocator)
    }

    fun countLinks(link: String): Int {
        val links = driver.findElements(iviLinkLocator(link))
        return if (links.isNotEmpty()) {
            links.count()
        } else {
            0
        }
    }


}