package com.rodzyn.homeWork02;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("PLUS")
public class ProductServicePlus {

    private ProductService productService;

    public ProductServicePlus(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getAllProduct(){
        for(int i = 0; i < productService.getProductList().size(); i++){
            System.out.println(productService.getProductList().get(i));
            System.out.println("Stawka wat:     " + productService.getVat() + "%");
            double cenaBrutto = productService.getProductList().get(i).getPrice()* productService.getVat()/100 + productService.getProductList().get(i).getPrice();
            System.out.println("Cena cenaBrutto:    " + cenaBrutto + "zł");
            System.out.println();
        }
    }
}
