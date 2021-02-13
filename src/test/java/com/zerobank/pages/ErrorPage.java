package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {

    public ErrorPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "details-button")
    public WebElement AdvancedBtn;

    @FindBy(css = "#details>p>a")
    public WebElement link;

    public void pass(){
        AdvancedBtn.click();
        link.click();
    }
}
