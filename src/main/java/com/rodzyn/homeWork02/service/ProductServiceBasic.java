package com.rodzyn.homeWork02.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("BASIC")
public class ProductServiceBasic {

    private ProductService productService;

    public ProductServiceBasic(ProductService productService) {
        this.productService = productService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void getAllProduct(){
        double totalSum = 0;
        for(int i = 0; i < productService.getProductList().size(); i++){
            System.out.println(productService.getProductList().get(i));
            System.out.println();
            totalSum += productService.getProductList().get(i).getPrice();
        }
        System.out.println("Cena za zakupy wynosi: " + totalSum + " zł");
    }
}
