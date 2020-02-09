package main.resources.other

import io.qameta.allure.Step
import main.pages.GooglePlayAppPage
import main.resources.ApplicationManager
import org.testng.Assert.assertTrue

class GooglePlayHelper(app: ApplicationManager) {
    private val googlePlayAppPageLocator = GooglePlayAppPage(app.driver)

    @Step("Google Play App: check that Google Play App is shown")
    fun isDisplay(): Boolean {
        return googlePlayAppPageLocator.isDisplay()
    }

    @Step("Google Play App: find rating of Ivi App on Google Play App")
    fun searchIviAppRating(): String {
        assertTrue(isDisplay(), "Expected: Google Play App Page is shown")
        assertTrue(googlePlayAppPageLocator.isIviAppDisplay(), "Expected: Ivi App Page is shown")
        val appData = googlePlayAppPageLocator.searchIviAppRating("")
        assertTrue(
            appData.isNotEmpty(),
            "Expected: Google App Page contains rating\nActual: can't find rating on a Google App Page"
        )
        assertTrue(appData.toDouble() <= 5, "Expected: App Rating is less than 5.0\nActual: App Rating = $appData")
        return appData
    }
}