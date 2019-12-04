package pl.flaaaxxx.springshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.flaaaxxx.springshop.Product;
import pl.flaaaxxx.springshop.Shop;

import javax.crypto.spec.PSource;

@Service
@Profile("START")
public class ShopStartService {

    private Shop shop;

    @Autowired
    public ShopStartService(Shop shop) {
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void shopping(){
        System.out.println("Cena całego koszyka: " + shop.calculateCartPrice());
//        shop.getCart().forEach(System.out::println);
    }
}
