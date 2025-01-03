package org.example.MainMethod;

import org.example.ActionFiles.OrangeHRMEleActions;
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

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        OrangeHRMEleActions actions = new OrangeHRMEleActions(driver);
        actions.OpenApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        System.out.println("Browser title is : " + driver.getTitle());

        actions.enterUsername("Admin");
        actions.enterPassword("admin123");
        String username = actions.getUsernameFieldValue();
        String password = actions.getPasswordFieldValue();

        System.out.println("Username and Password for the login are : " + username + " " + password);

        actions.clickLoginBtn();

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        actions.clickAdminTab();

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        driver.quit();

    }
}