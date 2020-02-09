package main.tests

import io.qameta.allure.Description
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.testng.Assert.assertTrue
import org.testng.annotations.Test


class SearchIviTest : TestFixture() {

    @Feature("Google Search")
    @Story("Images")
    @Test
    @Description("Task 1")
    fun searchIviImagesLinksTest() {
        app.driver.get(app.baseUrl)
        app.googleMainHelper.search("ivi")
        app.googleSearchResultHelper.switchSearchType("Images", hashMapOf("Size" to "Large"))
        val maxSearchPages = 1
        val minExpectedIviLinks = 3
        val actualIviLinks = app.googleSearchResultHelper.countIviImagesLinks(maxSearchPages, minExpectedIviLinks)
        assertTrue(
            actualIviLinks >= minExpectedIviLinks,
            "Expected: at least $minExpectedIviLinks are shown on search results\nActual: $actualIviLinks are shown on search results"
        )
    }

    @Feature("Google Search")
    @Story("Google Play")
    @Test
    @Description("Task 2")
    fun searchIviAppLinksTest() {
        app.driver.get(app.baseUrl)
        app.googleMainHelper.search("ivi")
        val maxSearchPages = 5
        val iviAppRatingInSearchResult = app.googleSearchResultHelper.searchIviAppRating(maxSearchPages)
        app.googleSearchResultHelper.openIviAppLink()
        val iviAppRatingInGooglePlay = app.googlePlayHelper.searchIviAppRating()
        assertTrue(
            iviAppRatingInSearchResult == iviAppRatingInGooglePlay,
            "Expected: Ivi App Rating have to be equal on Google Search Result Page and Google Play Page\nActual: Google Search Result Rating = $iviAppRatingInSearchResult, Google Play Rating = $iviAppRatingInGooglePlay"
        )
    }

    @Feature("Google Search")
    @Story("Wikipedia")
    @Test
    @Description("Task 3")
    fun searchIvilinkWikiTest() {
        app.driver.get(app.baseUrl)
        app.googleMainHelper.search("ivi")
        val maxSearchPages = 5
        val wikiLink = app.googleSearchResultHelper.searchWikiLink(maxSearchPages)
        val expectedLink = "wikipedia.org/wiki/ivi.ru"
        assertTrue(
            wikiLink.contains(expectedLink, ignoreCase = true),
            "Expected: link to wikipedia contains '$expectedLink'\nActual: wikipedia link = $wikiLink"
        )
        app.googleSearchResultHelper.openWikiLink()
        val links = app.wikipediaHelper.pageContainsLink("ivi.ru")
        assertTrue(links > 0, "Expected: Wikipedia Article contains at least one 'ivi.ru' link")
    }
}