package main.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.Test


class SeleniumTest : TestFixture() {

    @Feature("First Feature")
    @Story("First Story")
    @Test
    @Description("Simple test")
    fun SimpleUITest() {
        val driver: WebDriver = ChromeDriver()
        driver.get(app.baseUrl)
        app.googleSearchHelper.open()

    }
}