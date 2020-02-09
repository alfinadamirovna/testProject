package main.pages

import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class GoogleSearchMainPage(driver: WebDriver) : Utils(driver) {

    // Locators
    private val searchLineLocator = By.xpath("//input[@type='text']")
    private val searchButtonLocator = By.xpath("//form//input[@type='submit'][@name='btnK']")

    // Functions
    fun submitSearchQuery(searchQuery: String) {
        fillInField(searchLineLocator, searchQuery)
        click(searchButtonLocator)
    }

    fun isDisplay(): Boolean {
        return isDisplay(searchLineLocator)
    }
}
