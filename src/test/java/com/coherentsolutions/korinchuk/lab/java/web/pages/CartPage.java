package com.coherentsolutions.korinchuk.lab.java.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    private static final String CART_PAGE_URL = "index.php?controller=order";
    private static final String CART_ITEM = "//td[@class='cart_product']//img[contains(@alt, '%s')]";

    @FindBy(id = "total_product")
    private WebElement totalPriceValue;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step(value = "Open cart page")
    @Override
    public CartPage open() {
        super.open(CART_PAGE_URL);
        return this;
    }

    public double getTotalPrice() {
        return Double.parseDouble(totalPriceValue.getText().replace("$", ""));
    }

    public boolean isCartItemVisible(String cartItem) {
        return driver.findElement(By.xpath(String.format(CART_ITEM, cartItem))).isDisplayed();
    }
}