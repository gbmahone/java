package org.gbmahone;

import entities.Product;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Product, Double> cookies = new HashMap<>();

        Product p1 = new Product("Tv", 900.00);
        Product p2 = new Product("Notebook", 1200.00);
        Product p3 = new Product("Tablet", 400.00);

        cookies.put(p1, p1.getPrice());
        cookies.put(p2, p2.getPrice());
        cookies.put(p3, p3.getPrice());

        Product ps = new Product("Tv", 900.00);

        System.out.println("Contains 'ps' key: " + cookies.containsKey(ps));
    }
}