import java.util.*;
public class StrategyExecution {
    public static void main(String[] args) {
       System.out.println("Select transport type: 1 - airplane, 2 - train, 3 - bus");
       Scanner enter = new Scanner(System.in);
       int transportChoice = enter.nextInt();
       TravelBookingContext context = new TravelBookingContext();

       switch(transportChoice) {
           case 1: context.SetCostCalculationStrategy(new AirplaneCostStrategy()); break;
           case 2: context.SetCostCalculationStrategy(new TrainCostStrategy()); break;
           case 3: context.SetCostCalculationStrategy(new BusCostStrategy()); break;
           default: System.out.println("Nope");
       }
       double cost = context.GetTravelCost(0,0,"",true);
       System.out.println("Total cost: " + cost);
    }
}
