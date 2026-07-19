package com.VelocityEcom.pages;

import com.VelocityEcom.driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class EcomDashboardPage {

    @FindBy(xpath = "(//div[@class='stat-value'])[1]")  private WebElement totalProducts;
    @FindBy(xpath = "(//div[@class='stat-value'])[2]")  private WebElement totalOrders;
    @FindBy(xpath = "(//div[@class='stat-value'])[3]")  private WebElement lowStockItems;
    @FindBy(xpath = "(//div[@class='stat-value'])[4]")  private WebElement pendingOrders;
    @FindBy(xpath =  "(//div[@class='stat-value'])[5]") private WebElement totalRevenue;
    @FindBy(xpath = "(//div[@class='stat-value'])[6]") private WebElement backOrders;
    @FindBy(xpath = "//button[@title='Dismiss']") private WebElement closeButton;

    public EcomDashboardPage(WebDriver driver)
    {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    public void closeButton()
    {
        closeButton.click();
        System.out.println("popup button closed");
    }

    public String getTotalProducts()
    {
        System.out.println("getting total products");
        return totalProducts.getText();
    }
    public String getTotalOrders()
    {
        System.out.println("getting total orders");
        return totalOrders.getText();
    }
    public String getLowStockItems()
    {
        System.out.println("getting low stock items");
        return lowStockItems.getText();
    }
    public  String getPendingOrders()
    {
        System.out.println("getting pending orders");
        return pendingOrders.getText();
    }
    public String getTotalRevenue()
    {
        System.out.println("getting total revenue");
        return totalRevenue.getText();
    }

    }