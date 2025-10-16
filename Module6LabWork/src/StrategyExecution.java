import java.util.*;
public class StrategyExecution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeliveryContext deliveryContext = new DeliveryContext();
        System.out.println("Select shipping type: 1 - Standard, 2 - Express, 3 - International");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                deliveryContext.setShippingStrategy(new StandardShippingStrategy()); break;
            case "2":
                deliveryContext.setShippingStrategy(new ExpressShippingStrategy()); break;
            case "3":
                deliveryContext.setShippingStrategy(new InternationalShippingStrategy()); break;
            case "4":
                deliveryContext.setShippingStrategy(new NightShippingStrategy()); break;
            default:
                System.out.println("Not that."); return;
        }

        System.out.println("Enter weight:");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter distance:");
        double distance = Double.parseDouble(scanner.nextLine());

        double cost = deliveryContext.calculateCost(weight, distance);
        System.out.println("Shipping cost: " + cost);
    }
}