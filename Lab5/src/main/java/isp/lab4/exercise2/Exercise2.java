package isp.lab4.exercise2;

public class Exercise2 {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(32);
        SmartPhone phone1 = new SmartPhone(56);
        SmartWatch watch1 = new SmartWatch(44);

        laptop1.charge(20);
        phone1.charge(5);
        watch1.charge(3);
    }
}
