interface IPaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements IPaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}
class PayPalPayment implements IPaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " through PayPal.");
    }
}
class CryptoPayment implements IPaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Crypto.");
    }
}

class PaymentContext {
    private IPaymentStrategy paymentStrategy;
    public void setPaymentStrategy(IPaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("None selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}