interface IShippingStrategy {
    double calculateShippingCost(double weight, double distance);
}

class StandardShippingStrategy implements IShippingStrategy {
    public double calculateShippingCost(double weight, double distance) {
        return weight * 0.5 + distance * 0.1;
    }
}

class ExpressShippingStrategy implements IShippingStrategy {
    public double calculateShippingCost(double weight, double distance) {
        return (weight * 0.75 + distance * 0.2) + 10;
    }
}
class InternationalShippingStrategy implements IShippingStrategy {
    public double calculateShippingCost(double weight, double distance) {
        return weight * 1.0 + distance * 0.5 + 15;
    }
}
class NightShippingStrategy implements IShippingStrategy {
    public double calculateShippingCost(double weight, double distance) {
        return (weight * 0.8 + distance * 0.25) + 20;
    }
}
class DeliveryContext {
    private IShippingStrategy shippingStrategy;
    public void setShippingStrategy(IShippingStrategy strategy) {
        this.shippingStrategy = strategy;
    }
    public double calculateCost(double weight, double distance) {
        return shippingStrategy.calculateShippingCost(weight, distance);
    }
}