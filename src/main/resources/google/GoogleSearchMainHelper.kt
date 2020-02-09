package main.resources.google

import io.qameta.allure.Step
import main.pages.GoogleSearchMainPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue


class GoogleSearchMainHelper(app: ApplicationManager) {
    private val googleMainPage = GoogleSearchMainPage(app.driver)
    private val googleSearchResultsPage = GoogleSearchResultHelper(app)

    @Step("Google Search: check that Main Google Search Page is shown")
    fun isDisplay(): Boolean {
        return googleMainPage.isDisplay()
    }

    @Step("Google Search: execute a search")
    fun search(searchLine: String) {
        assertTrue(isDisplay(), "Expected: Google Main Page is shown")
        googleMainPage.submitSearchQuery(searchLine)
        assertTrue(googleSearchResultsPage.isDisplay(), "Expected: Google Search Results Page is shown")
    }
}