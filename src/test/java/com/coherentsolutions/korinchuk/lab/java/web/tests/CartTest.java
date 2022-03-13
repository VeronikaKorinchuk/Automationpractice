package com.coherentsolutions.korinchuk.lab.java.web.tests;

import com.coherentsolutions.korinchuk.lab.java.web.pages.CartPage;
import com.coherentsolutions.korinchuk.lab.java.web.pages.WishlistPage;
import org.testng.annotations.Test;
import com.coherentsolutions.korinchuk.lab.java.web.pages.AuthenticationPage;
import com.coherentsolutions.korinchuk.lab.java.web.pages.ProductPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    public static final String FIRST_PURCHASED_PRODUCT = "Printed Chiffon Dress";
    public static final String SECOND_PURCHASED_PRODUCT = "Faded Short Sleeve T-shirts";
    public static final String THIRD_PURCHASED_PRODUCT = "Blouse";

    @Test
    public void testAbilityAddToCartSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        WishlistPage wishlistPage = authenticationPage.
                open().
                login(EMAIL, PASSWORD).
                openWishlists();
        ProductPage firstProduct = wishlistPage.
                openBestseller(FIRST_PURCHASED_PRODUCT);
        double firstProductPrice = firstProduct.getProductPrice();
        int firstProductQuantity = firstProduct.getProductQuantity();
        firstProduct.
                addToCart();
        ProductPage secondProduct = wishlistPage.
                open().
                openBestseller(SECOND_PURCHASED_PRODUCT);
        double secondProductPrice = firstProduct.getProductPrice();
        int secondProductQuantity = firstProduct.getProductQuantity();
        secondProduct.
                addToCart();
        ProductPage thirdProduct = wishlistPage.
                open().
                openBestseller(THIRD_PURCHASED_PRODUCT);
        double thirdProductPrice = firstProduct.getProductPrice();
        int thirdProductQuantity = firstProduct.getProductQuantity();
        thirdProduct.
                addToCart();
        double expectedTotal = firstProductPrice*firstProductQuantity +
                secondProductPrice*secondProductQuantity +
                thirdProductPrice*thirdProductQuantity;

        CartPage cartPage = new CartPage(driver);
        cartPage.
                open();
        assertTrue(cartPage.isCartItemVisible(FIRST_PURCHASED_PRODUCT), FIRST_PURCHASED_PRODUCT + " isn't added to cart");
        assertTrue(cartPage.isCartItemVisible(SECOND_PURCHASED_PRODUCT), SECOND_PURCHASED_PRODUCT + " isn't added to cart");
        assertTrue(cartPage.isCartItemVisible(THIRD_PURCHASED_PRODUCT), THIRD_PURCHASED_PRODUCT + " isn't added to cart");
        assertEquals(cartPage.getTotalPrice(), expectedTotal, "Total price count isn't correct");
    }
}
