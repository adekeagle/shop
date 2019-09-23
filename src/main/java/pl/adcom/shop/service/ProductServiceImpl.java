package pl.adcom.shop.service;

import org.springframework.stereotype.Service;
import pl.adcom.shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> productList;

    public ProductServiceImpl() {
        Product product1 = new Product("Klawiatura", randomBetween50And300());
        Product product2 = new Product("Myszka", randomBetween50And300());
        Product product3 = new Product("Karta pamieci", randomBetween50And300());
        Product product4 = new Product("Sluchawki", randomBetween50And300());

        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }

    private double randomBetween50And300() {
        return ThreadLocalRandom.current().nextInt(50, 300);
    }

    public void addNewProduct(String name, double price){
        productList.add(new Product(name, price));
    }

    public double totalPrice() {
        double totalPrice = 0.0;
        for (Product product : productList) {
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }
}