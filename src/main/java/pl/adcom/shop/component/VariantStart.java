package pl.adcom.shop.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.adcom.shop.service.ProductService;

@Component
@Profile("START")
public class VariantStart {

    private ProductService productService;

    @Autowired
    public VariantStart(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPrice(){
        productService.addNewProduct("Pokrowiec na laptopa", 300.0);
        System.out.println("Total price = " + productService.totalPrice());
    }
}
