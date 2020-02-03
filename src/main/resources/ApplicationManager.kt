package main.resources

import main.resources.google.GoogleMainHelper
import main.resources.google.GoogleSearchResultHelper
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class ApplicationManager {
    val baseUrl = "https://www.google.com"
    val driver: WebDriver = ChromeDriver()
    var googleSearchHelper = GoogleMainHelper(this)
    var googleSearchResultHelper = GoogleSearchResultHelper(this)

    //mvn clean test
    //allure serve
}
