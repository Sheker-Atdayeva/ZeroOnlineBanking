package com.zerobank.stepdefinitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
        BrowserUtils.waitForPageToLoad(2);
        Assert.assertEquals("Zero - Account Summary", Driver.get().getTitle());
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkName) {
        new AccountSummaryPage().openLink(linkName);
        BrowserUtils.waitForPageToLoad(3);
    }

    @Then("the {string} page should be displayed")
    public void the_Account_Activity_page_should_be_displayed(String pageName) {
        Assert.assertEquals("Zero - " + pageName,Driver.get().getTitle());
        BrowserUtils.waitFor(3);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String linkname) {
        BrowserUtils.waitForVisibility(new AccountActivityPage().accountDropdownElement,4);
        Select stateDropdown = new Select(new AccountActivityPage().accountDropdownElement);
        String actual = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(linkname,actual);
        BrowserUtils.waitFor(2);
}


}
