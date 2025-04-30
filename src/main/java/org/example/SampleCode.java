package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Set;

public class SampleCode {
    public static void main(String[]args){
   WebDriver driver = new ChromeDriver();
   String url = "https://www.flipkart.com/";
//   driver.get(url);
        driver.navigate().to(url);
   driver.manage().window().maximize();
   WebElement element = driver.findElement(By.xpath("//label[text()='Enter Email/Mobile number']/parent::div//input"));
   element.sendKeys("9846198729");
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
WebElement element1 = driver.findElement(By.xpath("//label[text()='Enter Email/Mobile number']"));
element.sendKeys("rfrg");
Select s= new Select(element);

driver.getWindowHandles();

            // first get the current window

        String currentWindowID = driver.getWindowHandle();

        Set<String> listOfAllWindow = driver.getWindowHandles();

        for(String st:listOfAllWindow){
            driver.switchTo().window(st);
        }
    }



    void hello(){
//        Assert.assertEquals();
    }

}

