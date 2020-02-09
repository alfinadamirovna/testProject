package main.resources.other

import io.qameta.allure.Step
import main.pages.WikipediaArticlePage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class WikipediaHelper(app: ApplicationManager) {
    private val wikipediaArticlePage = WikipediaArticlePage(app.driver)

    @Step("Wikipedia Article: check that Wikipedia Article is shown")
    fun isDisplay(): Boolean {
        return wikipediaArticlePage.isDisplay()
    }

    @Step("Wikipedia Article: find links which refer to Ivi on Wikipedia Article")
    fun pageContainsLink(link: String): Int {
        assertTrue(isDisplay(), "Expected: Wikipedia page is shown")
        return wikipediaArticlePage.countLinks(link)
    }
}