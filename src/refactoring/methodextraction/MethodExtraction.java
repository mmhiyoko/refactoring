package refactoring.methodextraction;

import java.util.Enumeration;

public class MethodExtraction {
    Enumeration<Order> _orders;
    String _name;

    public MethodExtraction(Enumeration<Order> orders, String name) {
        _orders = orders;
        _name = name;
    }

    void printOwing() {
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    double getOutstanding() {
        Enumeration<Order> e = _orders;
        double outstanding = 0.0;

        while (e.hasMoreElements()) {
            Order each = e.nextElement();
            outstanding += each.getAmount();
        }

        return outstanding;
    }

    void printBanner() {
        System.out.println("*******************");
        System.out.println("** Customer Owns **");
        System.out.println("*******************");

    }

    void printDetails(double outstanding) {
        System.out.println("name:" + _name);
        System.out.println("amount:" + outstanding);
    }
}
