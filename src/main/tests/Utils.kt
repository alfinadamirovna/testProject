package main.tests

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class Utils {
    fun get(by: By): SelenideElement {
        return `$`(by)
    }


}