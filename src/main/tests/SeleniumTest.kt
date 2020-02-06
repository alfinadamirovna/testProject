package main.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.testng.Assert.assertTrue
import org.testng.annotations.Test


class SeleniumTest : TestFixture() {

    @Feature("First Feature")
    @Story("First Story")
    @Test
    @Description("Simple test")
    fun simpleUITest() {
        app.driver.get(app.baseUrl)
        app.googleMainHelper.search("ivi")
        app.googleSearchResultHelper.switchSearchType("Images", hashMapOf("Size" to "Large"))
        val actualIviLinks = app.googleSearchResultHelper.countIviLinks(10)
        val minExpectedIviLinks = 390
        assertTrue(
            actualIviLinks >= minExpectedIviLinks,
            "Expected: at least $minExpectedIviLinks are shown on search results\nActual: $actualIviLinks are shown on search results"
        )
    }
}