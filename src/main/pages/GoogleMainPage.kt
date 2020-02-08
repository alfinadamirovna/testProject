package main.pages

import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class GoogleMainPage(driver: WebDriver) : Utils(driver) {

    private val searchLineLocator = By.xpath("//input[@type='text']")
    private val searchButtonLocator = By.xpath("//form//input[@type='submit'][@name='btnK']")

    fun submitSearchQuery(searchQuery: String) {
        fillInField(searchLineLocator, searchQuery)
        click(searchButtonLocator)
    }

    fun isDisplay(): Boolean {
        return isDisplay(searchLineLocator)
    }


}
