package main.resources.google

import main.pages.GoogleSearchImagesResultPage
import main.pages.GoogleSearchResultPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class GoogleSearchResultHelper(app: ApplicationManager) {

    private val googleSearchResultsPage = GoogleSearchResultPage(app.driver)
    private val googleImagesResultPage = GoogleSearchImagesResultPage(app.driver)

    fun isDisplay(): Boolean {
        return googleSearchResultsPage.isDisplay()
    }

    fun switchSearchType(type: String = "Images", option: HashMap<String, String> = hashMapOf("" to "")) {
        googleSearchResultsPage.switchSearchType(type)
        googleImagesResultPage.configureSearchResult(option)
    }

    fun countIviImagesLinks(maxPages: Int = 1): Int {
        return googleImagesResultPage.countImages(maxPages)
    }

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

    fun searchWikiLink(maxSearchPages: Int): String {
        val wikiLink = search(maxSearchPages, googleSearchResultsPage::searchWikiLink)
        return wikiLink
    }

    fun searchIviAppRating(maxSearchPages: Int): String {
        val rating = search(maxSearchPages, googleSearchResultsPage::searchIviAppRating)
        assertTrue(
            rating.isNotEmpty(),
            "Expected: first $maxSearchPages pages contain data about Ivi Google App\nActual: can't find data about Ivi App in search results"
        )
        assertTrue(rating.toDouble() <= 5, "Expected: App Rating is less than 5.0\nActual: App Rating = $rating")
        return rating
    }

    fun openIviAppLink() {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        googleSearchResultsPage.openIviAppLink()
    }

    fun openWikiLink() {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        googleSearchResultsPage.openIviWikiArticleLink()
    }

}