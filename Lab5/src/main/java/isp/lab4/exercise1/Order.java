package isp.lab4.exercise1;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    //atributes
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private List<Product> products;

    //methods

    public Order(String orderId, LocalDateTime date, double totalPrice, List<Product> products) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
