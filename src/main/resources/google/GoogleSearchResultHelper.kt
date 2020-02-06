package main.resources.google

import main.pages.GoogleImagesResultPage
import main.pages.GoogleMainPage
import main.pages.GoogleSearchResultPage
import main.resources.ApplicationManager

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

    fun countIviLinks(maxPages: Int = 1): Int {
        return googleImagesResultPage.countImages(maxPages)
    }

}