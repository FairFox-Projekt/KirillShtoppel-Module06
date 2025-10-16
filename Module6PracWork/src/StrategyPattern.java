interface ICostCalculationStrategy {
    double CalculateCost(double distance, int passenger, String serviceClass, boolean hasDiscount);
}
class AirplaneCostStrategy implements ICostCalculationStrategy {
    public double CalculateCost(double distance, int passenger, String serviceClass, boolean hasDiscount) {
        double baseCost = distance * 0.2;
        if (serviceClass == "Business") {
            baseCost *= 1.5;
        }
        return baseCost;
    }
}
class TrainCostStrategy implements ICostCalculationStrategy {
    public double CalculateCost(double distance, int passenger, String serviceClass, boolean hasDiscount) {
        double baseCost = distance * 0.1;
        if (serviceClass == "Business") {
            baseCost *= 1.5;
        }
        return baseCost;
    }
}
class BusCostStrategy implements ICostCalculationStrategy {
    public double CalculateCost(double distance, int passenger, String serviceClass, boolean hasDiscount) {
        double baseCost = distance * 0.4;
        if (serviceClass == "Business") {
            baseCost *= 1.5;
        }
        return baseCost;
    }
}

class TravelBookingContext {
    private ICostCalculationStrategy _strategy;
    public void SetCostCalculationStrategy(ICostCalculationStrategy strategy) {
        _strategy = strategy;
    }

    public double GetTravelCost(double distance, int passenger, String serviceClass, boolean hasDiscount) {
        if (_strategy != null) {
            return _strategy.CalculateCost(distance, passenger, serviceClass, hasDiscount);
        }
        else {
            System.out.println("Strategy not selected");
            return 0;
        }
    }
}
