package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryStepDefs {

    @When("the user navigates to {string} tab")
    public void the_user_navigates_to_tab(String tabName) {
        new AccountSummaryPage().navigateToModule(tabName);
        BrowserUtils.waitForPageToLoad(3);
    }

    @Then("the {string} page should have the title {string}")
    public void the_page_should_have_the_title(String pageName, String pageTitle) {
        Assert.assertEquals(pageTitle, Driver.get().getTitle());
    }

    @Then("the Account Summary page should have following account types")
    public void the_Account_Summary_page_should_have_following_account_types(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }

    @Then("Credit Accounts table must have following columns")
    public void table_must_have_following_columns(List<String> expectedTableColumns) {
        List<String> actualTableColumns = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("(//table[@class='table'])[3]/thead//th")));
        Assert.assertEquals(expectedTableColumns,actualTableColumns);
    }
}
