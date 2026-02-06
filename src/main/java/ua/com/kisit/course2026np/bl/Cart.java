package ua.com.kisit.course2026np.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisit.course2026np.entity.Products;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cart {

    List<ItemCart> cart;
    private double totalValue;
    private int sumElCart;

    public Cart() {
        cart = new ArrayList<>();
        totalValue = 0;
        sumElCart = 0;
    }

    public synchronized void addNewItemToCart(Products products, int quantity) {

//        boolean logic = false;

        for (ItemCart itemCart : cart) {
            if(itemCart.getProducts().getId().equals(products.getId())) {
                itemCart.setQuantity(itemCart.getQuantity() + quantity);
                return;
            }
        }

            cart.add(new ItemCart(products, quantity));

    }

    public synchronized void updateItemFromCart(Products products, int quantity) {
        if(quantity <= 0) {
            for (ItemCart itemCart : cart) {
                if(itemCart.getProducts().getId().equals(products.getId())) {
                    cart.remove(itemCart);
                    break;
                }
            }
        }
        if(quantity > 0){
            for (ItemCart itemCart : cart) {
                if(itemCart.getProducts().getId().equals(products.getId())) {
                    itemCart.setQuantity(quantity);
                }
            }
        }
    }

    public synchronized void removeItemFromCart(Products products) {
        for (ItemCart itemCart : cart) {
            if(itemCart.getProducts().getId().equals(products.getId())) {
                cart.remove(itemCart);
                break;
            }
        }
    }

    public synchronized void removeAllItemFromCart() {
        cart.clear();
        totalValue = 0;
        sumElCart = 0;

    }

    public synchronized double getTotalValueFromCart() {
        totalValue = 0;
        for (ItemCart itemCart : cart) {
            totalValue+=itemCart.getQuantity()*itemCart.getProducts().getPrice().doubleValue();
        }

        return totalValue;
    }

    public synchronized int getSumItem() {
       return sumElCart = cart.size();
    }


}
