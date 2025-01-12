package org.example.ActionFiles;

import org.example.XpathLocator.OrangeHRMLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMEleActions {

    private WebDriver driver;

    public OrangeHRMEleActions(WebDriver driver)
    {
        this.driver = driver;
        
    }

    public void OpenApplication(String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Browser title is: " + driver.getTitle());
    }

    public void enterUsername(String username)
    {
        WebElement usernameField = driver.findElement(By.xpath(OrangeHRMLocators.USERNAME_FIELD));
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        WebElement passwordField = driver.findElement(By.xpath(OrangeHRMLocators.PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn()
    {
        WebElement loginbtn = driver.findElement(By.xpath(OrangeHRMLocators.LOGIN_BUTTON));
        loginbtn.click();
    }
    public String getUsernameFieldValue() {
        WebElement usernameField = driver.findElement(By.xpath(OrangeHRMLocators.USERNAME_FIELD));
        return usernameField.getAttribute("value");
    }

    public String getPasswordFieldValue() {
        WebElement passwordField = driver.findElement(By.xpath(OrangeHRMLocators.PASSWORD_FIELD));
        return passwordField.getAttribute("value");
    }

    public void clickAdminTab()
    {
        WebElement adminTab = driver.findElement(By.xpath(OrangeHRMLocators.ADMIN_TAB));
        adminTab.click();
    }

    public void username_admin(String username_admin_field)
    {
        WebElement usernameField_admin = driver.findElement(By.xpath(OrangeHRMLocators.USERNAME_ADMIN_FIELD));
        usernameField_admin.click();
        usernameField_admin.sendKeys(username_admin_field);
    }
}

