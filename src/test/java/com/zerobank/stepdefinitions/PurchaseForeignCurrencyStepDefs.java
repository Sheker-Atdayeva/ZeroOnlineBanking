package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.ErrorPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
        BrowserUtils.waitForPageToLoad(2);
        new AccountSummaryPage().navigateToModule("Pay Bills");
        BrowserUtils.waitForPageToLoad(4);
        new PayBillsPage().navigateToTab("Purchase Foreign Currency");
        BrowserUtils.waitForVisibility(new PayBillsPage().tabName,5);
        Assert.assertEquals("Purchase foreign currency cash",new PayBillsPage().tabName.getText());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(new PayBillsPage().currencyOptions);
        Assert.assertEquals(expectedOptions,actualOptions);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        Select stateDropdown = new Select(Driver.get().findElement(By.cssSelector("#pc_currency")));
        stateDropdown.selectByVisibleText("Select One");
        new PayBillsPage().purchaseBtn.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",alert.getText());
        alert.accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Select stateDropdown = new Select(Driver.get().findElement(By.cssSelector("#pc_currency")));
        stateDropdown.selectByIndex(3);
        new PayBillsPage().purchaseAmountInput.clear();
        new PayBillsPage().purchaseBtn.click();
    }
}
