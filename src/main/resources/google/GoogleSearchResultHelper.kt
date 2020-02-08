package main.resources.google

import main.pages.GoogleImagesResultPage
import main.pages.GoogleSearchResultPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class GoogleSearchResultHelper(app: ApplicationManager) {

    private val googleSearchResultsPage = GoogleSearchResultPage(app.driver)
    private val googleImagesResultPage = GoogleImagesResultPage(app.driver)

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

    fun searchIviAppRating(maxSearchPages: Int): String {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        var currentPage = 1
        var appData = googleSearchResultsPage.searchIviAppRating("-1.0")
        // search decimal number
        while (currentPage < maxSearchPages && appData == "-1.0") {
            googleSearchResultsPage.nextPage(++currentPage)
            appData = googleSearchResultsPage.searchIviAppRating(appData)
        }
        assertTrue(
            appData != "-1.0",
            "Expected: first $maxSearchPages pages contain data about Ivi Google App\nActual: can't find data about Ivi App in search results"
        )
        assertTrue(appData.toDouble() <= 5, "Expected: App Rating is less than 5.0\nActual: App Rating = $appData")
        return appData
    }

    fun openSearchResult() {
        assertTrue(isDisplay(), "Expected: Google Search Result page is shown")
        googleSearchResultsPage.openIviAppLink()
    }

}