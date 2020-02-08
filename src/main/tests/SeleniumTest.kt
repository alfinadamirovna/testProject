package main.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.testng.Assert.assertTrue
import org.testng.annotations.Ignore
import org.testng.annotations.Test


class SeleniumTest : TestFixture() {

    @Feature("Google Search")
    @Story("Images")
    @Test
    @Description("Task 1")
    @Ignore
    fun searchIviImagesLinksTest() {
        app.driver.get(app.baseUrl)
        app.googleMainHelper.search("ivi")
        app.googleSearchResultHelper.switchSearchType("Images", hashMapOf("Size" to "Large"))
        val actualIviLinks = app.googleSearchResultHelper.countIviImagesLinks()
        val minExpectedIviLinks = 3
        assertTrue(
            actualIviLinks >= minExpectedIviLinks,
            "Expected: at least $minExpectedIviLinks are shown on search results\nActual: $actualIviLinks are shown on search results"
        )
    }

    @Feature("Google Search")
    @Story("Pages")
    @Test
    @Description("Task 2")
    fun searchIviAppLinksTest() {
        app.driver.get(app.baseUrl)
        app.googleMainHelper.search("ivi")
        val maxSearchPages = 5
        val iviAppRatingInSearchResult = app.googleSearchResultHelper.searchIviAppRating(maxSearchPages)
        app.googleSearchResultHelper.openSearchResult()
        val iviAppRatingInGooglePlay = app.googlePlayHelper.searchIviAppRating()
        assertTrue(
            iviAppRatingInSearchResult == iviAppRatingInGooglePlay,
            "Expected: Ivi App Rating have to be equal on Google Search Result Page and Google Play Page\nActual: Google Search Result Rating = $iviAppRatingInSearchResult, Google Play Rating = $iviAppRatingInGooglePlay"
        )
    }
}