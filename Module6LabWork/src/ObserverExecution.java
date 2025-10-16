public class ObserverExecution {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        WeatherDisplay mobileApp = new WeatherDisplay("Weathero");
        WeatherDisplay digitalBillboard = new WeatherDisplay("DigitBill");
        EmailAlertSystem emailAlert = new EmailAlertSystem("alertsweather@storm.com");

        weatherStation.registerObserver(mobileApp);
        weatherStation.registerObserver(digitalBillboard);
        weatherStation.registerObserver(emailAlert);

        weatherStation.setTemperature(25.0f);
        weatherStation.setTemperature(30.0f);

        weatherStation.removeObserver(digitalBillboard);
        weatherStation.setTemperature(28.0f);
    }
}