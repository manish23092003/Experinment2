package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebpageTest {
    private WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://manish23092003.github.io/Experinment2/");

        // Wait until the page is fully loaded
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Page title: " + actualTitle);
        String expectedTitle = "Animated Web Page";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected.");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
