package com.coherentsolutions.korinchuk.lab.java.web.tests;

import com.coherentsolutions.korinchuk.lab.java.web.pages.WishlistPage;
import org.testng.annotations.Test;
import com.coherentsolutions.korinchuk.lab.java.web.pages.AuthenticationPage;
import static org.testng.Assert.*;

public class WishlistTest extends BaseTest{

    public static final String BESTSELLER_NAME = "Faded Short Sleeve T-shirts";
    public static final String NEW_WISHLIST_NAME = "Clothes wishlist";

    @Test(description = "Test ability to add auto-created wishlist succeeded")
    public void testAddAutoCreatedWishlistSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        WishlistPage wishlistPage = authenticationPage.
                open().
                login(EMAIL, PASSWORD).
                openWishlists();
        int wishlistQuantityBeforeAdding = wishlistPage.
                        getWishlistQuantity();
        assertEquals(wishlistQuantityBeforeAdding, 0, "Wishlist isn't empty");
        wishlistPage.
                openBestseller(BESTSELLER_NAME).
                addToWishlist();
        int wishlistQuantityAfterAdding = wishlistPage.
                open().
                getWishlistQuantity();
        assertEquals(wishlistQuantityAfterAdding, 1, "Product isn't added to wishlist");
    }

    @Test(description = "Test the ability to add to wishlist succeeded")
    public void testAbilityToAddToWishlistSucceeded() {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        WishlistPage wishlistPage = authenticationPage.
                open().
                login(EMAIL, PASSWORD).
                openWishlists().
                createNewWishlist(NEW_WISHLIST_NAME);
        wishlistPage.
                openBestseller(BESTSELLER_NAME).
                addToWishlist();
        boolean isItemAppearsInWishlist = wishlistPage.
                open().
                viewWishlistProducts(NEW_WISHLIST_NAME).
                isItemAppearsInWishlist(BESTSELLER_NAME);
        assertTrue(isItemAppearsInWishlist, "Item wasn't added to wishlist" + NEW_WISHLIST_NAME);
    }
}
