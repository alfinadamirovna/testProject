package main.pages

import main.tests.Utils
import org.openqa.selenium.WebDriver

class GoogleMainPage(driver: WebDriver): Utils(driver) {

    fun open(){
        driver.get("http://www.google.com")
    }

}
