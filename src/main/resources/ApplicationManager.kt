package main.resources

import main.resources.google.GoogleMainHelper
import main.resources.google.GoogleSearchResultHelper
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.

class ApplicationManager {
    val baseUrl = "https://www.google.com"
    val capabilities = DesiredCapabilities.
    val options = ChromeOptions()
    System.setProperty(
    "webdriver.chrome.driver",
    "${System.getProperty("user.dir")}/src/test/kotlin/ui/webdriver/chromedriver"
    )
    options.addArguments("start-maximized", "disable-browser-side-navigation")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)
    val service = ChromeDriverService.Builder()
        .usingAnyFreePort()
        .build()
    options.merge(capabilities)
    val driver: WebDriver
    ChromeDriver(service, options)


    var googleSearchHelper = GoogleMainHelper(this)
    var googleSearchResultHelper = GoogleSearchResultHelper(this)

    //mvn clean test
    //allure serve


    // прикрутить репорты
    // добавить документацию
    // разобраться как работать с браузерами
    //
}
