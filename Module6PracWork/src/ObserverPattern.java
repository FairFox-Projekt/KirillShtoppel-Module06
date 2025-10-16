import java.util.*;

interface IObserver {
    void update(String stockSymbol, double price);
}
interface ISubscriber {
    void registerObserver(String stockSymbol, IObserver observer);
    void removeObserver(String stockSymbol, IObserver observer);
    void notifyObservers(String stockSymbol, double price);
}

class StockExchange implements ISubscriber {
    private Map<String, List<IObserver>> observers = new HashMap<>();
    private Map<String, Double> stockPrices = new HashMap<>();
    public void registerObserver(String stockSymbol, IObserver observer) {
        observers.computeIfAbsent(stockSymbol, k -> new ArrayList<>()).add(observer);
    }
    public void removeObserver(String stockSymbol, IObserver observer) {
        List<IObserver> obsList = observers.get(stockSymbol);
        if (obsList != null) obsList.remove(observer);
    }
    public void notifyObservers(String stockSymbol, double price) {
        List<IObserver> obsList = observers.get(stockSymbol);
        if (obsList != null) {
            for (IObserver observer : obsList) {
                observer.update(stockSymbol, price);
            }
        }
    }
    public void setStockPrice(String stockSymbol, double newPrice) {
        stockPrices.put(stockSymbol, newPrice);
        System.out.println("Price update: " + stockSymbol + " = $" + newPrice);
        notifyObservers(stockSymbol, newPrice);
    }

    public double getStockPrice(String stockSymbol) {
        return stockPrices.getOrDefault(stockSymbol, 0.0);
    }
}
class Trader implements IObserver {
    private String name;
    public Trader(String name) {
        this.name = name;
    }

    public void update(String stockSymbol, double price) {
        System.out.println(name + " received update: " + stockSymbol + " is now $" + price);
    }
}
class TradingBot implements IObserver {
    private String name;
    private double buyThreshold;
    private double sellThreshold;
    public TradingBot(String name, double buyThreshold, double sellThreshold) {
        this.name = name;
        this.buyThreshold = buyThreshold;
        this.sellThreshold = sellThreshold;
    }
    public void update(String stockSymbol, double price) {
        if (price < buyThreshold) {
            System.out.println(name + " decided to BUY " + stockSymbol + " at $" + price);
        } else if (price > sellThreshold) {
            System.out.println(name + " decided to SELL " + stockSymbol + " at $" + price);
        } else {
            System.out.println(name + " is monitoring " + stockSymbol + " at $" + price);
        }
    }
}
class EmailAlert implements IObserver {
    private String email;
    public EmailAlert(String email) {
        this.email = email;
    }
    public void update(String stockSymbol, double price) {
        System.out.println("Sending email to " + email + ": " + stockSymbol + " is now $" + price);
    }
}

