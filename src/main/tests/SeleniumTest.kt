package main.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.testng.annotations.Test


class SeleniumTest : TestFixture() {

    @Feature("First Feature")
    @Story("First Story")
    @Test
    @Description("Simple test")
    fun SimpleUITest() {
        app.googleSearchHelper.open()

    }
}