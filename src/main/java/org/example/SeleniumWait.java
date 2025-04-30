package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWait {

    @Test
    void implicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/");
        driver.findElement(By.xpath("//div[@id=\"main-header\"]//input[@aria-label=\"Search For Products\"]"))
                .sendKeys(Keys.LEFT_SHIFT,"iphone" );
        driver.findElement(By.xpath("//div[@id='main-header']//button[@type=\"submit\"]"))
                .sendKeys(Keys.ENTER);
        driver.quit();
    }

    @Test
    void explicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/");
        wait.until(ExpectedConditions.urlToBe("https://ecommerce-playground.lambdatest.io/"));
        driver.findElement(By.xpath("//div[@id=\"main-header\"]//input[@aria-label=\"Search For Products\"]"))
                .sendKeys(Keys.LEFT_SHIFT,"iphone" );
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//div[@id=\"main-header\"]//input[@aria-label=\"Search For Products\"]"))));
        driver.findElement(By.xpath("//div[@id='main-header']//button[@type=\"submit\"]")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"main-header\"]//input[@aria-label=\"Search For Products\"]"))));
        driver.quit();
    }
}


