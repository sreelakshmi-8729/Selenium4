package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

//this comment only in develop branch
@Test
public class LoginPageValidations {
    WebDriver driver = null;
    Boolean value = null;

    @Test(priority = 1)
    public void verifyLoginPage() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(8000L);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys("student");
        password.sendKeys("Password123");
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
        Thread.sleep(5000L);
        List<WebElement> elements = driver.findElements(By.xpath("//h1[text()='Logged In Successfully']"));
        Assert.assertEquals(elements.size(), 1, "Logged In Successfully message is not displayed");

        value = driver.findElement(By.xpath("//strong[text()='Congratulations student. You successfully logged in!']")).isDisplayed();
        Assert.assertTrue(value, "Congratulations student. You successfully logged in message is not displayed");
        boolean buttonIsDisplayed = driver.findElement((By.xpath("//a[text()='Log out']"))).isDisplayed();
        Assert.assertTrue(buttonIsDisplayed, "Logout button is not displayed");
    }

    @Test(priority = 2)
    public void invalidLoginNegativeUsernameTest() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        WebElement invalidUsername = driver.findElement(By.xpath("//input[@name='username']"));
        invalidUsername.sendKeys("abcdefgh");
        WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
        Password.sendKeys("Password123");
        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        button.sendKeys(Keys.ENTER);
        Thread.sleep(3000L);
        List<WebElement> errorMsgList = driver.findElements(By.xpath("//div[text()='Your username is invalid!']"));
        Assert.assertEquals(errorMsgList.size(), 1, "Error message is not displaying");

    }
    @Test(priority = 3)
    public void invalidLoginPassword() throws InterruptedException {
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys("student");
        WebElement invalidPassword = driver.findElement(By.xpath("//input[@name='password']"));
        invalidPassword.sendKeys("fgfg@22324");
        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        button.sendKeys(Keys.ENTER);
        Thread.sleep(3000L);
        List<WebElement> errorMsgList = driver.findElements(By.xpath("//div[text()='Your password is invalid!']"));
        Assert.assertEquals(errorMsgList.size(), 1, "Error message is not displaying");
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

