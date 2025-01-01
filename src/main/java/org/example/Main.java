package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","driver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Browser title is : " + driver.getTitle());

        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        usernameField.click();
        usernameField.sendKeys("Admin");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
        passwordField.click();
        passwordField.sendKeys("admin123");

        String username = usernameField.getAttribute("value");
        String password = passwordField.getAttribute("value");

        System.out.println("Username and Password for the login are : " + username + " " + password);

        WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginbtn.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
}