package main.resources

import main.resources.google.GoogleMainHelper
import main.resources.google.GoogleSearchResultHelper
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
    var googleMainHelper = GoogleMainHelper(this)
    var googleSearchResultHelper = GoogleSearchResultHelper(this)


    private fun createLocalDriver(): WebDriver {
                val capabilities = DesiredCapabilities(BrowserType.CHROME, "79.0", Platform.ANY)
                val options = ChromeOptions()
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
    //mvn clean test
    //allure serve


    // прикрутить репорты
    // добавить документацию
    // разобраться как работать с браузерами
    //
