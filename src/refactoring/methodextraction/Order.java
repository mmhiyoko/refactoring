package refactoring.methodextraction;

class Order {
    double _amount;

    public Order(double amount) { _amount = amount; }

    double getAmount() {
        return _amount;
    }
}
