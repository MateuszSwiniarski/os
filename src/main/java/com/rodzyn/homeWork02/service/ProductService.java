package com.rodzyn.homeWork02.service;

import com.rodzyn.homeWork02.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private Product product;

    @Value("${page.info.vat}")
    private int vat;

    @Value("${page.info.discout}")
    private int discout;

    public int getDiscout() {
        return discout;
    }

    public int getVat() {
        return vat;
    }

    public ProductService(Product product) {
        this.product = product;
    }

    private List<Product> productList;
    public ProductService() {

        productList = new ArrayList<>();

        Product product1 = new Product("komputer", 3210);
        Product product2 = new Product("playstation 4", 1235);
        Product product3 = new Product("TV Samsung", 2460);
        Product product4 = new Product("Apple X", 5212);
        Product product5 = new Product("Laptop", 1456);
        Product product6 = new Product("kino domowe", 3575);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);

    }

    public List<Product> getProductList(){
        return productList;
    }

    public int rand(){
        Random randomPrice = new Random();
        return randomPrice.nextInt(301)+50;
    }

}
