package pl.flaaaxxx.springshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class ShopPro {

    private ShopPlus shopPlus;

    @Value("${pro-info.discount}")
    private int discount;

    @Autowired
    public ShopPro(ShopPlus shopPlus) {
        this.shopPlus = shopPlus;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    // wyliczenie rabatu
    public float coutDiscount(){
        return (shopPlus.addVat()-shopPlus.addVat()*discount/100);
    }

}
