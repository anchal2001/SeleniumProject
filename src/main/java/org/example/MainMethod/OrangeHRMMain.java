package org.example.MainMethod;

import org.example.XpathLocator.OrangeHRMLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHRMMain {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Browser title is : " + driver.getTitle());

        WebElement usernameField = driver.findElement(By.xpath(OrangeHRMLocators.USERNAME_FIELD));
        usernameField.click();
        usernameField.sendKeys("Admin");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.xpath(OrangeHRMLocators.PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys("admin123");

        String username = usernameField.getAttribute("value");
        String password = passwordField.getAttribute("value");

        System.out.println("Username and Password for the login are : " + username + " " + password);

        WebElement loginbtn = driver.findElement(By.xpath(OrangeHRMLocators.LOGIN_BUTTON));
        loginbtn.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
}