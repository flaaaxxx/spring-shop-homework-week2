package pl.flaaaxxx.springshop.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.flaaaxxx.springshop.Shop;
import pl.flaaaxxx.springshop.ShopPlus;
import pl.flaaaxxx.springshop.ShopPro;

@Service
@Profile("PRO")
public class ShopProService {
    private ShopPro shopPro;
    private ShopPlus shopPlus;
    private Shop shop;

    @Autowired
    public ShopProService(ShopPro shopPro, ShopPlus shopPlus, Shop shop) {
        this.shopPro = shopPro;
        this.shopPlus = shopPlus;
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void shoppingDiscount(){
        System.out.println("Cena całego koszyka: " + shop.calculateCartPrice());
        System.out.println("Cena z vatem " + shopPlus.addVat());
        System.out.println("Cena po rabacie " + shopPro.coutDiscount());
    }
}
