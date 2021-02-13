package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(xpath = "//li[@class='ui-state-default ui-corner-top']/a")
    public WebElement FindTransactionsTab;

    @FindBy(css = "#aa_accountId")
    public WebElement accountDropdownElement;

    @FindBy(id = "aa_type")
    public WebElement typeDropdown;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(css = "#aa_toDate")
    public WebElement toDateInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr")
    public List<WebElement> raws;

    public List<String> getTransactionDatesList(){
        List<String> transactionDatesList = new ArrayList<>();
        for(int i=1; i<=raws.size(); i++){
            WebElement cell = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[1]"));
            transactionDatesList.add(cell.getText());
        }
        return transactionDatesList;
    }

    public List<String> getTransactionDescriptionList(){
        List<String> transactionDescriptionsList = new ArrayList<>();
        for(int i=1; i<=raws.size(); i++){
            WebElement cell = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[2]"));
            transactionDescriptionsList.add(cell.getText());
        }
        return transactionDescriptionsList;
    }

    public List<String> getDepositList(){
        List<String> depositList = new ArrayList<>();
        for(int i=1; i<=raws.size(); i++){
            WebElement cell = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[3]"));
            if(!cell.getText().isBlank()) {
                depositList.add(cell.getText());
            }
        }
        return depositList;
    }

    public List<String> getWithdrawalList(){
        List<String> withdrawalList = new ArrayList<>();
        for(int i=1; i<=raws.size(); i++){
            WebElement cell = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td[4]"));
            if(!cell.getText().isBlank()) {
                withdrawalList.add(cell.getText());
            }
        }
        return withdrawalList;
    }

    public WebElement getType(String type){
        WebElement typeOption = Driver.get().findElement(By.xpath("//select[@id='aa_type']/option[.='"+ type +"']"));
        return typeOption;
    }

    public void cleanAllBox(){
        descriptionInput.clear();
        toDateInput.clear();
        fromDateInput.clear();
    }


}
