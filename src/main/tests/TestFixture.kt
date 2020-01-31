package main.tests

import main.resources.ApplicationManager
import org.testng.annotations.BeforeClass

open class TestFixture {

    lateinit var app: ApplicationManager

    @BeforeClass
    fun init(){
        app = ApplicationManager()
    }
}