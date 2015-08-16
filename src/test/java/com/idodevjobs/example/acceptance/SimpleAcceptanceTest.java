package com.idodevjobs.example.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SimpleAcceptanceTest {
    private WebDriver webDriver = new ChromeDriver();

    @Before
    public void setup() {
        System.getProperties().setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Test
    public void shouldOpenBlogPostWithProperContent() throws Exception {
        webDriver.get("https://idodevjobs.wordpress.com/2015/04/13/key-java-5-6-7-8-features-flash-card/");
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        WebElement firstParagraph = wait.until(visibilityOfElementLocated(By.xpath("//*[@id='post-310']/div[@class='entry-content']/p[1]")));
        String firstParagraphText = firstParagraph.getText();
        assertEquals("The text in first paragraph is incorrect.", "Some key Java 5, 6, 7 & 8 features – Flash card.", firstParagraphText);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
