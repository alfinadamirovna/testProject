package main.resources.google

import main.pages.GoogleMainPage
import main.resources.ApplicationManager


class GoogleMainHelper(val app: ApplicationManager) {
    private val googleMainPage = GoogleMainPage(app.driver)

    fun open() {
        googleMainPage.open()
    }

}