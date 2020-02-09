package main.resources.google

import io.qameta.allure.Step
import main.pages.GoogleSearchImagesResultPage
import main.pages.GoogleSearchResultPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class GoogleSearchResultHelper(app: ApplicationManager) {

    private val googleSearchResultsPage = GoogleSearchResultPage(app.driver)
    private val googleImagesResultPage = GoogleSearchImagesResultPage(app.driver)

    @Step("Google Search Result: check that Google Search Result Page is shown")
    fun isDisplay(): Boolean {
        return googleSearchResultsPage.isDisplay()
    }

    @Step("Google Search Result: change search mode")
    fun switchSearchType(type: String = "Images", option: HashMap<String, String> = hashMapOf("" to "")) {
        googleSearchResultsPage.switchSearchType(type)
        googleImagesResultPage.configureSearchResult(option)
    }

    @Step("Google Search Result: count links which refer to ivi")
    fun countIviImagesLinks(maxPages: Int, minExpectedIviLinks: Int): Int {
        return googleImagesResultPage.countImages(maxPages, minExpectedIviLinks)
    }

    @Step("Google Search Result: execute a search on a limited searches pages")
    fun search(maxSearchPages: Int, searchFunction: () -> (String)): String {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        var currentPage = 1
        var searchData = searchFunction()
        // if searchData isn't found on the first page, check following pages
        while (currentPage < maxSearchPages && searchData.isEmpty()) {
            googleSearchResultsPage.nextPage(++currentPage)
            searchData = searchFunction()
        }
        return searchData
    }

    @Step("Google Search Result: find a link to Wikipedia")
    fun searchWikiLink(maxSearchPages: Int): String {
        val wikiLink = search(maxSearchPages, googleSearchResultsPage::searchWikiLink)
        return wikiLink
    }

    @Step("Google Search Result: find a rating of Ivi App in Google Play Preview")
    fun searchIviAppRating(maxSearchPages: Int): String {
        val rating = search(maxSearchPages, googleSearchResultsPage::searchIviAppRating)
        assertTrue(
            rating.isNotEmpty(),
            "Expected: first $maxSearchPages pages contain data about Ivi Google App\nActual: can't find data about Ivi App in search results"
        )
        assertTrue(rating.toDouble() <= 5, "Expected: App Rating is less than 5.0\nActual: App Rating = $rating")
        return rating
    }

    @Step("Google Search Result: open Ivi App in Google Play from Google Search Results")
    fun openIviAppLink() {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        googleSearchResultsPage.openIviAppLink()
    }

    @Step("Google Search Result: open article about Ivi in Wikipedia from Google Search Results")
    fun openWikiLink() {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        googleSearchResultsPage.openIviWikiArticleLink()
    }
}