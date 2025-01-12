package org.example.MainMethod;

import org.apache.commons.io.FileUtils;
import org.example.ActionFiles.OrangeHRMEleActions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OrangeHRMMain {
    public static void main(String[] args) throws InterruptedException, IOException {

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

        Thread.sleep(3000);

        actions.username_admin("test@123");

        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot.png");
        FileUtils.copyFile(srcfile, destFile);

        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());

        Thread.sleep(3000);


        driver.quit();

    }
}