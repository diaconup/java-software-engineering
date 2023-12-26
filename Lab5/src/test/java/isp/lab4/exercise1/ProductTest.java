package isp.lab4.exercise1;

import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductTest extends TestCase {

    public void testGetProductId() {
        List<Product> products = new ArrayList<>();

        Address address1 = new Address("Rozelor","Sighisoara");
        Customer customer1 = new Customer("1","Paul","07342",address1);

        products.add(new Product("23","Samsung Fold",1222.3, ProductCategory.ELECTRONICS, customer1));
        products.add(new Product("23","Samsung Fold",1222.3, ProductCategory.ELECTRONICS, customer1));

        Order order = new Order("24", LocalDateTime.now(),300, products);

        assertEquals("24",order.getOrderId());
    }

    public void testTestGetName() {
        List<Product> products = new ArrayList<>();

        Address address1 = new Address("Rozelor","Sighisoara");
        Customer customer1 = new Customer("1","Paul","07342",address1);

        products.add(new Product("23","Samsung Fold",1222.3, ProductCategory.ELECTRONICS, customer1));
        products.add(new Product("23","Samsung Fold",1222.3, ProductCategory.ELECTRONICS, customer1));

        Order order = new Order("24", LocalDateTime.now(),300, products);

        assertEquals("Paul",customer1.getName());
    }

    public void testTotalPrice() {
        List<Product> products = new ArrayList<>();

        Address address1 = new Address("Rozelor","Sighisoara");
        Customer customer1 = new Customer("1","Paul","07342",address1);

        products.add(new Product("23","Samsung Fold",1222.3, ProductCategory.ELECTRONICS, customer1));
        products.add(new Product("23","Samsung Fold",1222.3, ProductCategory.ELECTRONICS, customer1));

        Order order = new Order("24", LocalDateTime.now(),300, products);

        assertEquals(300,order.getTotalPrice(),300);

    }
}