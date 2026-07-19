package stepDefinitions;

import com.VelocityEcom.driverFactory.DriverFactory;
import com.VelocityEcom.pages.EcomDashboardPage;
import com.VelocityEcom.pages.EcomInventoryUpdatePage;
import com.VelocityEcom.pages.EcomLoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class DashboardValidation {
    EcomLoginPage ecomLoginPage= new EcomLoginPage(DriverFactory.getDriver());
    EcomDashboardPage ecomDashboardPage = new EcomDashboardPage(DriverFactory.getDriver());
    EcomInventoryUpdatePage ecomInventoryUpdatePage= new EcomInventoryUpdatePage(DriverFactory.getDriver());
    SoftAssert softAssert= new SoftAssert();

    @Given("user clicks on admin button of VelocityEcom application")
    public void user_clicks_on_admin_button_of_velocity_ecom_application() {
          ecomLoginPage.clickOnAdminButton();
    }

    @When("user enters userName as {string}")
    public void user_enters_user_name_as(String username) {
        ecomLoginPage.enterUserName(username);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
             ecomLoginPage.enterPassword(password);
    }

    @When("user clicks on access dashboard button")
     public void user_clicks_on_access_dashboard_button() throws InterruptedException {
           ecomLoginPage.clickOnAccessDashboard();
       // Assert.fail();
    }

    @Then("user navigates to VelocityEcom dashboard page and validate details")
    public void user_navigates_to_velocity_ecom_dashboard_page_and_validate_details() throws InterruptedException {

        Thread.sleep(3000);
        ecomDashboardPage.closeButton();
     String actualTotalOrders =ecomDashboardPage.getTotalOrders();
     String actualTotalProducts=ecomDashboardPage.getTotalProducts();
     String actualLowStockItems=ecomDashboardPage.getLowStockItems();

        Reporter.log("Total orders are " +actualTotalOrders, true);
        Reporter.log("Total Products are " +actualTotalProducts, true);
        Reporter.log("Total low stock items are " + actualLowStockItems, true );

        softAssert.assertNotNull(actualTotalOrders,"Actual total orders are null");
        softAssert.assertNotNull(actualTotalProducts,"Actual total products are null");
        softAssert.assertNotNull(actualLowStockItems,"Actual low stock items are null");
        softAssert.assertAll();
    }

    @And("user clicks on Inventory update")
    public void userClicksOnInventoryUpdate() throws InterruptedException {
      //  Thread.sleep(2000);
     ecomInventoryUpdatePage.clickOnInventoryUpdatePage();
     Thread.sleep(4000);
    }

    @Then("user validates total entries, open_partial, fullyreceived orders")
    public void userValidatesTotalEntriesOpen_partialFullyreceivedOrders() {
        Reporter.log("Total entries" + ecomInventoryUpdatePage.getTotalEntries(),true);
        Reporter.log("Total open_partialOrders are " + ecomInventoryUpdatePage.getOpen_partialOrders(), true);
        Reporter.log("Fully received orders are " + ecomInventoryUpdatePage.getFullyReceivedOrders(), true);
        Reporter.log("Pending receiving orders are " + ecomInventoryUpdatePage.getPendingReceivingOrders(), true);

        String expectedTotalEntries="53";
        String actualTotalEntries = ecomInventoryUpdatePage.getTotalEntries();
        softAssert.assertEquals(actualTotalEntries,expectedTotalEntries,"Actual and expected entries are not matching");
        String expectedOpenPartialOrders = "12";
        String actualOpenPartialOrders = ecomInventoryUpdatePage.getOpen_partialOrders();
        softAssert.assertEquals(actualOpenPartialOrders, expectedOpenPartialOrders, "Actual and expected open_partial orders are not matching, TC failed");
        String expectedFullyReceivedOrders = "39";
        String actualFullyReceivedOrders = ecomInventoryUpdatePage.getFullyReceivedOrders();
        softAssert.assertEquals(actualFullyReceivedOrders, expectedFullyReceivedOrders, "Actual and expected fully received orders are not matching, TC failed");
        softAssert.assertAll();

    }
}
