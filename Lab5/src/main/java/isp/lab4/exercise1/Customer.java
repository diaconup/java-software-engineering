package isp.lab4.exercise1;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address;


    //methods

    public Customer(String customerId, String name, String phone, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address.toString() +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
