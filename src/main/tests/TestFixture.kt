package main.tests

import main.resources.ApplicationManager
import org.testng.annotations.BeforeMethod

open class TestFixture {

    lateinit var app: ApplicationManager

    @BeforeMethod
    fun init(){
        app = ApplicationManager()
    }
}