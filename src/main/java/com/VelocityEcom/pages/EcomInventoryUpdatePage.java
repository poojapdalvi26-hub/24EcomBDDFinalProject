package com.VelocityEcom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcomInventoryUpdatePage {

    @FindBy(xpath = "//a[text()='Inventory Update']")
    private WebElement inventoryUpdateButton;
    @FindBy(xpath = "(//div[@class='stat-value'])[1]")
    private WebElement totalEntries;
    @FindBy(xpath = "(//div[@class='stat-value'])[2]") private WebElement openPartial;
    @FindBy(xpath = "(//div[@class='stat-value'])[3]") private WebElement fullyReceived;
    @FindBy(xpath = "(//div[@class='stat-value'])[4]")
    private WebElement pendingReceiving;

    public EcomInventoryUpdatePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void clickOnInventoryUpdatePage()
    {
        inventoryUpdateButton.click();
        System.out.println("Clicking on inventory update button");
    }
    public String getTotalEntries()
    {
        System.out.println("getting total entries");
       return totalEntries.getText();
    }
    public String getOpen_partialOrders(){
        System.out.println("getting Open_partial Orders");
        return openPartial.getText();
    }
    public String getFullyReceivedOrders(){
        System.out.println("getting fully received orders");
        return fullyReceived.getText();
    }
    public String getPendingReceivingOrders(){
        System.out.println("getting pending receiving orders");
        return pendingReceiving.getText();
    }
}
