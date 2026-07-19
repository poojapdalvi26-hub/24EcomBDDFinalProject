package com.VelocityEcom.pages;

import com.VelocityEcom.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcomLoginPage {
    @FindBy(id = "tab-admin") private WebElement adminButton;
    @FindBy(id="admin-username") private WebElement usernameField;
    @FindBy(id= "admin-password") private WebElement passwordField;
    @FindBy(id= "btn-admin-signin")  private WebElement accessDashboard;

    public EcomLoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAdminButton(){
        adminButton.click();
        System.out.println("clicking on admin button");
    }

    public void enterUserName(String username ){
        Utility.scrollIntoView(usernameField);
        usernameField.sendKeys(username);
        System.out.println("entering username");
    }

    public void enterPassword(String password){
        Utility.scrollIntoView(passwordField);
        passwordField.sendKeys(password);
        System.out.println("entering password");
    }
    public void clickOnAccessDashboard() throws InterruptedException {

        Utility.scrollIntoView(accessDashboard);
        accessDashboard.click();
        Thread.sleep(200);
        System.out.println("clicking on Access dashboard button");
    }
}
