package shoppingCart;

import org.junit.Assert;
import org.junit.Test;

public class T {
    ShoppingCart cart = new ShoppingCart();

    // When created, the cart has 0 items
    @Test
    public void EmptyNewTest() {
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals(cart.getItemCount(), 0);
    }

    // When empty, the cart has 0 items
    @Test
    public void EmptyAfterClear() {
        cart.addItem(new Product("PS5", 499));
        cart.empty();
        Assert.assertEquals(cart.getItemCount(), 0);
    }

    // When a new product is added, the number of items must be incremented
    @Test
    public void IncrementedAfterAdded() {
        int lenInitial = cart.getItemCount();
        cart.addItem(new Product("PS5", 499));
        Assert.assertEquals(cart.getItemCount(), lenInitial+1);
    }

    //    When a new product is added, the new balance must be the sum of
    //    the previous balance plus the cost of the new product
    @Test
    public void newBalance() {
        cart.addItem(new Product("PS5", 499));
        cart.addItem(new Product("RTX 3070", 699));
        double actualBalance = cart.getBalance();
        Product prod = new Product("Switch", 350);
        cart.addItem(prod);
        Assert.assertEquals(cart.getBalance(), actualBalance+prod.getPrice(), 4);
    }

    // When an item is removed, the number of items must be decreased
    @Test
    public void itemRemoved() throws ProductNotFoundException {
        cart.addItem(new Product("PS5", 499));
        Product prod = new Product("Switch", 350);
        cart.addItem(prod);
        int actualLen = cart.getItemCount();
        cart.removeItem(prod);
        Assert.assertEquals(cart.getItemCount(), actualLen-1);
    }

    // When a product not in the cart is removed, a
    // shoppingCart.ProductNotFoundException must be thrown
    @Test
    public void trhownException() {
        cart.addItem(new Product("PS5", 499));
        Product prod = new Product("Switch", 350);
//        cart.addItem(prod);
        try {
            cart.removeItem(prod);
            Assert.fail("Expected an Exception");
        } catch (ProductNotFoundException pnfe) {
            System.out.println("Eccezione shoppingCart.ProductNotFoundException");
        }
    }

}
