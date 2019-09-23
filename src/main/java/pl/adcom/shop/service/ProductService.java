package pl.adcom.shop.service;

public interface ProductService {
    void addNewProduct(String name, double price);
    double totalPrice();
}
