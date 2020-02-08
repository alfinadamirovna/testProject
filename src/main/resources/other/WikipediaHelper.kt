package main.resources.other

import main.pages.WikipediaArticlePage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class WikipediaHelper(app: ApplicationManager) {
    private val wikipediaArticlePage = WikipediaArticlePage(app.driver)

    fun isDisplay(): Boolean {
        return wikipediaArticlePage.isDisplay()
    }

    fun pageContainsLink(link: String): Int {
        assertTrue(isDisplay(), "Expected: Wikipedia page is shown")
        return wikipediaArticlePage.countLinks(link)
    }
}