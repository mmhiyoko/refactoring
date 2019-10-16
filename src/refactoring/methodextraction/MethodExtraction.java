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
        Enumeration<Order> e = _orders;
        double outstanding = 0.0;

        printBanner();

        // 未払い料金の計算
        while (e.hasMoreElements()) {
            Order each = e.nextElement();
            outstanding += each.getAmount();
        }

        // 明細の印刷
        System.out.println("name:" + _name);
        System.out.println("amount:" + outstanding);
    }

    void printBanner() {
        System.out.println("*******************");
        System.out.println("** Customer Owns **");
        System.out.println("*******************");

    }
}
