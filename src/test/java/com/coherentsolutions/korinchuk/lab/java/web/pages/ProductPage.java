package com.coherentsolutions.korinchuk.lab.java.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(id = "our_price_display")
    private WebElement productPrice;

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantity;

    @FindBy(id = "wishlist_button")
    private WebElement addToWishlistButton;

    @FindBy(name = "Submit")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage open() {
        return null;
    }

    @Step(value = "Add product to wishlist")
    public ProductPage addToWishlist() {
        addToWishlistButton.click();
        return this;
    }

    @Step(value = "Add product to cart")
    public ProductPage addToCart() {
        addToCartButton.click();
        return this;
    }

    public double getProductPrice() {
        return Double.parseDouble(productPrice.getText().replace("$", ""));
    }

    public int getProductQuantity(){
        System.out.println(productQuantity.getText());
        return Integer.parseInt(productQuantity.getAttribute("value"));
    }
}
