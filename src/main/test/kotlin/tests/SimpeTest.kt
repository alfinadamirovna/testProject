package main.test.kotlin.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.testng.annotations.Test
import com.codeborne.selenide.Selenide.open

class SimpleTest : TestFixture() {

    @Feature("First Feature")
    @Story("First Story")
    @Test
    @Description("Simple test")
    fun SimpleUITest() {
       open(app.baseUrl)
    }
}