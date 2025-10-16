public class ObserverExecution {
    public static void main(String[] args) {
        CurrencyExchange exchange = new CurrencyExchange();
        IObserver website = new WebsiteObserver();
        IObserver email = new EmailObserver();
        IObserver journal = new InternetJournalObserver();
        
        exchange.attach(website);
        exchange.attach(email);
        exchange.attach(journal);

        exchange.setRate("USD", 537.6);
        exchange.setRate("EUR", 622.3);

        exchange.detach(email);

        exchange.setRate("RUB", 6.7); //как же было приятно когда оно было поменьше всё таки...
    }
}