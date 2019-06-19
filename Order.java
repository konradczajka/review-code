package net.xstream.shop;

import net.xstream.shop.products.Product;

import java.util.List;
import java.util.Map;

/**
 * This class represents shop order
 */
public class Order {

    //customer name
    private String customerFirstName;

    //customer lastname
    private String customerLastName;

    //customer email
    private String customerEmail;

    // customer type (one of: private, company)
    private String customerType;

    // products and their quantities
    private Map<Product, Integer> lines;

    private Double total;

    private static OrderRepository repository = new OrderRepository();

    public Order(String customerFirstName, String customerLastName, String customerEmail, String customerType, Map<Product, Integer> lines) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerType = customerType;
        this.lines = lines;

        total = calculateTotal();

        repository.save(this);

        EmailSender.sendEmail("ORDER_CREATED", customerEmail, lines, total);

        additionalCreationCallback();
    }

    private double calculateTotal() {
        double x = 0d;
        for (Map.Entry<Product, Integer> y: lines.entrySet())  {
            x += y.getKey().getPrice() * y.getValue();
        }

        switch (customerType) {
            case "private":
                break;
            case "company":
                x = x * 0.9;
                break;
            case "vip":
                x = x * 0.85;
                break;
        }
        return x;
    }

    public static List<Order> findCustomerOrders(String email) {
        List<Order> result = repository.findByCustomerEmail(email);
        if (result == null) {
            throw new RuntimeException("Not found");
        }
        return result;
    }

    void additionalCreationCallback() {
        // Just in case we ever need to add some behavior when the order is created we can create new order type and override this method.
        // Not used for now
    }
}
