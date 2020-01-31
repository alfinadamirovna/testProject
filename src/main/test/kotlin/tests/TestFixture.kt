package main.test.kotlin.tests

import main.test.kotlin.resources.ApplicationManager
import org.testng.annotations.BeforeClass

open class TestFixture {

    lateinit var app: ApplicationManager

    @BeforeClass
    fun init(){
        app = ApplicationManager()
    }
}