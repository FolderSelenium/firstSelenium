package com.selenium;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class FirstTest {

    private static WebDriver driver;
    private static String SITE_NAME = "https://www.linkedin.com/";
    private static String LOGIN = "";
    private static String PASS = "";
    private static String EXISTING_STRING = "";

    @BeforeClass
    public static void setup() {
        System.out.println("\nStart setup before class...");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_NAME);
        System.out.println("Go to " + SITE_NAME + "...");
    }

    @Test
    public void userLogin() {
        System.out.println("\nStart userLogin test...");
        WebElement loginField = driver.findElement(By.name("session_key"));
        loginField.sendKeys(LOGIN);
        System.out.println("Enter login...");

        WebElement passField = driver.findElement(By.name("session_password"));
        passField.sendKeys(PASS);
        System.out.println("Enter pass...");

        WebElement loginBtn = driver.findElement(By.id("login-submit"));
        loginBtn.click();
        System.out.println("Clicked LogIn!");

        WebElement profileUser = driver.findElement(By.cssSelector(".tap-target.feed-identity-module__actor-link.profile-rail-card__actor-link.ember-view"));
        String mailUser = profileUser.getText();
        System.out.println("mailUser: " + mailUser);
        Assert.assertEquals(EXISTING_STRING, mailUser);
    }
}
