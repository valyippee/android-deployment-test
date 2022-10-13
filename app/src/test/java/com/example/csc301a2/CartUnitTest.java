package com.example.csc301a2;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.Product;

public class CartUnitTest {
    @Test
    public void cart_ClearCart_Clears() {
        Cart c = new Cart();
        Product p = new Product("123", 1.2);
        c.addProduct(p);
        assertTrue(c.getCart().size() > 0);
        c.clearCart();
        assertTrue(c.getCart().size() == 0);
    }
}
