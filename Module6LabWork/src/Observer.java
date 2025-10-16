import java.util.*;

interface IObserver {
    void update(float temperature);
}
interface ISubscriber {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}

class WeatherStation implements ISubscriber {
    private List<IObserver> observers = new ArrayList<>();
    private float temperature;

    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(temperature);
        }
    }
    public void setTemperature(float newTemperature) {
        System.out.println("Temperature changed: " + newTemperature + "°C");
        temperature = newTemperature;
        notifyObservers();
    }
}
class WeatherDisplay implements IObserver {
    private final String name;
    public WeatherDisplay(String name) {
        this.name = name;
    }
    public void update(float temperature) {
        System.out.println(name + " shows new temperature: " + temperature + "°C");
    }
}

class EmailAlertSystem implements IObserver {
    private final String email;
    public EmailAlertSystem(String email) {
        this.email = email;
    }
    public void update(float temperature) {
        System.out.println("Sending email alert to " + email + ": Current temperature is " + temperature + "°C");
    }
}