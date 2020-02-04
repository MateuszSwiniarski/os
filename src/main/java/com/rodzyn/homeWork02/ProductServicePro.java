package com.rodzyn.homeWork02;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("PRO")
public class ProductServicePro {

    private ProductService productService;

    public ProductServicePro(ProductService productService) {
        this.productService = productService;
    }

    double totalPrice = 0;

    @EventListener(ApplicationReadyEvent.class)
    public void getAllProduct(){
        for(int i = 0; i < productService.getProductList().size(); i++){
            int price = productService.rand();

            System.out.println(productService.getProductList().get(i).getName());
            System.out.println("Cena netto:   " + price + " zł");
            System.out.println("Stawka wat:   " + productService.getVat() + "%");
            float cenaBrutto = price* productService.getVat()/100 + price;
            System.out.println("Cena cenaBrutto:  " + cenaBrutto + "zł");
            System.out.println();
            totalPrice += cenaBrutto;
        }
        System.out.println("Rabat na zakupy:   " + productService.getDiscout() + " zł");
        System.out.println("Cena bez rabatu:   " + totalPrice + " zł");
        System.out.println("Cena po rabacie:   " + (totalPrice - productService.getDiscout()) + " zł");
    }
}