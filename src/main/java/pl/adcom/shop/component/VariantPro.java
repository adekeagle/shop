package pl.adcom.shop.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.adcom.shop.service.ProductService;

@Component
@Profile("PRO")
public class VariantPro {

    @Value("${vat}")
    private Integer vat;

    @Value("${discount}")
    private int discount;
    private ProductService productService;

    @Autowired
    public VariantPro(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getProductWithVatAndDiscount(){
        double result = productService.totalPrice() * ((Double.valueOf(vat)+100)/100);
        double resultWithDiscount = result-result*(Double.valueOf(discount)/100);
        System.out.println("Wartosc brutto z upustem " + resultWithDiscount);
    }

}
