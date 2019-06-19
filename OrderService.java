package net.xstream.shop;

import net.xstream.shop.products.Product;

import java.util.List;
import java.util.Map;

public class OrderService {

    public Order createOrder(String customerFirstName, String customerLastName, String customerEmail, String customerType, Map<Product, Integer> lines) {
        return new Order(customerFirstName, customerLastName, customerEmail, customerType, lines);
    }

    public List<Order> customerOrders(String customerEmail) {
        return Order.findCustomerOrders(customerEmail);
    }
}
