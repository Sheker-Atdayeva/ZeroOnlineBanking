package com.zerobank.stepdefinitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountActivityStepDefs {

    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedDropdownOptions) {
        List<String> actualDropdownOptions = BrowserUtils.getElementsText(Driver.get().findElements(By.cssSelector("#aa_accountId>option")));
        Assert.assertEquals(expectedDropdownOptions,actualDropdownOptions);
    }

    @Then("Transactions table should have following column names")
    public void transactions_table_should_have_following_column_names(List<String> expectedTableColumns) {
        BrowserUtils.waitFor(3);
        List<String> actualTableColumns = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div[@id = 'all_transactions_for_account']//thead//th")));
        Assert.assertEquals(expectedTableColumns,actualTableColumns);
    }
}
