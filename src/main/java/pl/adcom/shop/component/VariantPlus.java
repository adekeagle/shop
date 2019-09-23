package pl.adcom.shop.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.adcom.shop.service.ProductService;

@Component
@Profile("PLUS")
public class VariantPlus {

    @Value("${vat}")
    private Integer vat;

    private ProductService productService;

    @Autowired
    public VariantPlus(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPriceWithVat(){
        double result = productService.totalPrice() * ((Double.valueOf(vat)+100)/100);
        System.out.println("Wartosc netto " + productService.totalPrice() + " , brutto " + result);
    }
}
