package com.heroku.app.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {
    @Test
    public void loginTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        String welcomePageText = "Welcome to the Secure Area. When you are done click logout below.";
        WebDriver driver = new ChromeDriver();
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        WebElement userNameField = driver.findElement(By.xpath("//input[@name=\'username\']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name=\'password\']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@class=\'radius\']"));
        userNameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        loginButton.click();
        Thread.sleep(3000);
        String loginText = driver.findElement(By.xpath("//h4[@class=\'subheader\']")).getText();
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href=\'/logout\']"));
        Assert.assertEquals(welcomePageText, loginText);
        logoutButton.click();

        driver.quit();
    }
}
