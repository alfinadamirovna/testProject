package main.pages

import main.tests.Utils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver


class GoogleImagesResultPage(driver: WebDriver) : Utils(driver) {

    private val imageResultLocator = By.xpath("//div[@id='hdtbSum']//span[contains(text(),'Images')]")
    private val toolsButtonLocator = By.xpath("//div[contains(text(),'Tools')]")
    private val imgsWithIviLink = By.xpath("//img[data-iurl=contains(text(), 'ivi.ru')]")

    fun isDisplay(): Boolean {
        return isDisplay(imageResultLocator)
    }

    fun configureSearchResult(option: HashMap<String, String>) {
        isDisplay()
        click(toolsButtonLocator)
        val optionNameLocator = By.xpath("//div[contains(text(), '${option.keys.first()}')]")
        click(optionNameLocator)
        val optionValueLocator = By.xpath("//span[contains(text(), '${option.values.first()}')]")
        isDisplay(optionValueLocator)
        click(optionValueLocator)
        isDisplay(optionValueLocator)
    }

    fun countImages(maxPages: Int): Int {
        var count = driver.findElements(imgsWithIviLink).count()
        var i = 1
        while (maxPages >= i) {
            (driver as JavascriptExecutor)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)")
            count = driver.findElements(imgsWithIviLink).count()
            i++
        }
        return count
    }


}
