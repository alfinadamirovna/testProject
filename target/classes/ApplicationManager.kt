package main.resources

import main.resources.google.GoogleSearchMainHelper
import main.resources.google.GoogleSearchResultHelper
import main.resources.other.GooglePlayHelper
import main.resources.other.WikipediaHelper
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.BrowserType
import org.openqa.selenium.remote.DesiredCapabilities

class ApplicationManager {
    val baseUrl = "https://www.google.com"
    val driver = createLocalDriver()
    var googleMainHelper = GoogleSearchMainHelper(this)
    var googleSearchResultHelper = GoogleSearchResultHelper(this)
    var googlePlayHelper = GooglePlayHelper(this)
    val wikipediaHelper = WikipediaHelper(this)

    // describe capabilities for chrome driver
    private fun createLocalDriver(): WebDriver {
        val capabilities = DesiredCapabilities(BrowserType.CHROME, "79.0", Platform.ANY)
        val options = ChromeOptions()
        // add '.exe' if you are using Windows
        System.setProperty(
            "webdriver.chrome.driver",
            "${System.getProperty("user.dir")}/src/main/resources/chromedriver"
        )
        options.addArguments("start-maximized", "disable-browser-side-navigation")
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)
        val service = ChromeDriverService.Builder()
            .usingAnyFreePort()
            .build()
        options.merge(capabilities)
        return ChromeDriver(service, options)
    }
}
// прикрутить репорты
// добавить документацию
