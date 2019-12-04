package pl.flaaaxxx.springshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.SourceFilteringListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopPlus {

    private Shop shop;
    @Value("${plus-info.vat}") // pobranie vat z pliku konfiguracyjnego
    private int vat;

    public ShopPlus() {
    }

    @Autowired
    public ShopPlus(Shop shop) {
        this.shop = shop;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    // doliczenie vat
    public float addVat() {
        return (shop.calculateCartPrice() + shop.calculateCartPrice() * vat / 100);
    }
}
