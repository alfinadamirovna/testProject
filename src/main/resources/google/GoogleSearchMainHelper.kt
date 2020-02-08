package main.resources.google

import main.pages.GoogleSearchMainPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue


class GoogleSearchMainHelper(app: ApplicationManager) {
    private val googleMainPage = GoogleSearchMainPage(app.driver)
    private val googleSearchResultsPage = GoogleSearchResultHelper(app)


    fun isDisplay(): Boolean {
        return googleMainPage.isDisplay()
    }

    fun search(searchLine: String) {
        assertTrue(isDisplay(), "Expected: Google Main Page is shown")
        googleMainPage.submitSearchQuery(searchLine)
        assertTrue(googleSearchResultsPage.isDisplay(), "Expected: Google Search Results Page is shown")
    }

}