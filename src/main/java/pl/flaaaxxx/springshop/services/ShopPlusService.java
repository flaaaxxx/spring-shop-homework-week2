package pl.flaaaxxx.springshop.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.flaaaxxx.springshop.Shop;
import pl.flaaaxxx.springshop.ShopPlus;

@Service
@Profile("PLUS")
public class ShopPlusService {
    private ShopPlus shopPlus;
    private Shop shop;

    @Autowired
    public ShopPlusService(ShopPlus shopPlus, Shop shop) {
        this.shopPlus = shopPlus;
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void shopping(){
        System.out.println("Cena całego koszyka: " + shop.calculateCartPrice());
        System.out.println("Cena z vatem " + shopPlus.addVat());
    }
}
