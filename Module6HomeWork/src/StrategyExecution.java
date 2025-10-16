import java.util.*;
public class StrategyExecution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();
        System.out.println("Select payment method: 1 - Credit Card, 2 - PayPal, 3 - Crypto");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                context.setPaymentStrategy(new CreditCardPayment()); break;
            case "2":
                context.setPaymentStrategy(new PayPalPayment()); break;
            case "3":
                context.setPaymentStrategy(new CryptoPayment()); break;
            default:
                System.out.println("Not that."); return;
        }

        System.out.println("Enter amount:");
        double amount = Double.parseDouble(scanner.nextLine());

        context.executePayment(amount);
    }
}