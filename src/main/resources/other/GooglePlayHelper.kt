package main.resources.other

import main.pages.GooglePlayAppPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class GooglePlayHelper(app: ApplicationManager) {
    private val googlePlayAppPage = GooglePlayAppPage(app.driver)

    fun isDisplay(): Boolean {
        return googlePlayAppPage.isDisplay()
    }

    fun searchIviAppRating(): String {
        assertTrue(isDisplay(), "Expected: Google Play App Page is shown")
        assertTrue(googlePlayAppPage.isIviAppDisplay(), "Expected: Ivi App Page is shown")
        val appData = googlePlayAppPage.searchIviAppRating("-1.0")
        assertTrue(
            appData != "-1.0",
            "Expected: Google App Page contains rating\nActual: can't find rating on a Google App Page"
        )
        assertTrue(appData.toDouble() <= 5, "Expected: App Rating is less than 5.0\nActual: App Rating = $appData")
        return appData
    }
}