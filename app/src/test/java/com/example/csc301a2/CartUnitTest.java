package com.example.csc301a2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
        assertEquals(0, c.getCart().size());
    }
}
