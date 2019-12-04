package pl.flaaaxxx.springshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Shop {

    private List<Product> cart;

    public Shop() {
        this.cart = new ArrayList<>();
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public void addProduct(Product product){
        cart.add(product);
    }

    public float calculateCartPrice(){
        float pay = 0;
        for (int i=0; i<cart.size(); i++){
            pay += cart.get(i).getPrice();
        }
        return pay;
    }

    // losuje liczby float z podanego zakresu
    public float randomPrice(int start, int end){
        Random g = new Random();
        return (g.nextFloat()*((end - start))) + start;
    }

    // dodanie produktów do koszyka na start
    @EventListener(ApplicationReadyEvent.class)
    public void startInitializer(){
        addProduct(new Product("pomidory", randomPrice(50, 52)));
        addProduct(new Product("chleb", randomPrice(50, 300)));
        addProduct(new Product("ciastka", randomPrice(50, 300)));
        addProduct(new Product("wędlina", randomPrice(50, 300)));
        addProduct(new Product("woda", randomPrice(50, 300)));
    }
}
