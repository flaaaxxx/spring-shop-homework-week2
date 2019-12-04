package pl.flaaaxxx.springshop;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Product {

    private String productName;
    private float price;

    public Product(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
