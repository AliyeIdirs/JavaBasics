package com.unitedcoder.homework.week10day3method;

import com.unitedcoder.homework.week10day3method.Product;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.RSAUtil;

public class ProductPrinter {
    public static void main(String[] args) {

        Product product = new Product("Dell Precision 5000", "Windows PC", 599.99);
        System.out.println("Product Name: "+product.getName());
        System.out.println("Product Category: "+product.getCategory());
        System.out.println("Product Price: "+product.getPrice());
        product.reducePrice();
        product.increasePrice();

    }
}
