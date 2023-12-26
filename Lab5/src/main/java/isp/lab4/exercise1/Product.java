package isp.lab4.exercise1;

import java.util.List;

public class Product {

    //attributes
    private String productId;
    private String name;
    private double price;
    private ProductCategory ProductCategory;
    private Customer customer;

    //methods

    public Product(String productId, String name, double price, ProductCategory productCategory, Customer customer) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        ProductCategory = productCategory;
        this.customer = customer;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ProductCategory=" + ProductCategory +
                ", customer=" + customer +
                '}';
    }
}
