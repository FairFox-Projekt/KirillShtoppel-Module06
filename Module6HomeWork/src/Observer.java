import java.util.*;
interface IObserver {
    void update(String currency, double rate);
}
interface ISubject {
    void attach(IObserver observer);
    void detach(IObserver observer);
    void notifyObservers();
}
class CurrencyExchange implements ISubject {
    private Map<String, Double> rates = new HashMap<>();
    private List<IObserver> observers = new ArrayList<>();
    public void attach(IObserver observer) {
        observers.add(observer);
    }
    public void detach(IObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (IObserver observer : observers) {
            for (Map.Entry<String, Double> e : rates.entrySet()) {
                observer.update(e.getKey(), e.getValue());
            }
        }
    }
    public void setRate(String currency, double rate) {
        rates.put(currency, rate);
        System.out.println("\nRate update: " + currency + " = " + rate);
        notifyObservers();
    }

    public double getRate(String currency) {
        return rates.getOrDefault(currency, 0.0);
    }
}

class WebsiteObserver implements IObserver {
    public void update(String currency, double rate) {
        System.out.println("Updated rate on site: " + currency + " = " + rate);
    }
}
class EmailObserver implements IObserver {
    public void update(String currency, double rate) {
        System.out.println("Notifcation sent through EMail on: " + currency + " = " + rate);
    }
}

class InternetJournalObserver implements IObserver {
    public void update(String currency, double rate) {
        System.out.println("Entry published: " + currency + " rate is now " + rate);
    }
}
