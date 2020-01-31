package main.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.testng.annotations.Test
import com.codeborne.selenide.Selenide.open
import org.openqa.selenium.By
import org.testng.Assert.assertTrue

class SimpleTest : TestFixture() {

    @Feature("First Feature")
    @Story("First Story")
    @Test
    @Description("Simple test")
    fun SimpleUITest() {
       open(app.baseUrl)
        assertTrue(app.utils.get(By.cssSelector("input[type='text'][title='Search']")).isDisplayed, "Expected: Search input is displayed")

    }
}