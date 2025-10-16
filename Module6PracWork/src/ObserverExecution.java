public class ObserverExecution {
    public static void main(String[] args) {
        StockExchange exchange = new StockExchange();
        Trader trader1 = new Trader("Trader 1");
        Trader trader2 = new Trader("Trader 2");
        TradingBot bot1 = new TradingBot("TradeBot 1", 90.0, 150.0);
        EmailAlert alert1 = new EmailAlert("investor1@gmail.com");

        exchange.registerObserver("APLS", trader1);
        exchange.registerObserver("APLS", bot1);
        exchange.registerObserver("APLS", alert1);
        exchange.registerObserver("GOLD", trader2);

        exchange.setStockPrice("APLS", 120.5);
        exchange.setStockPrice("GOLD", 2000.0);
        exchange.setStockPrice("APLS", 85.0);
        exchange.setStockPrice("APLS", 160.0);

        exchange.removeObserver("APLS", trader1);
        exchange.setStockPrice("APLS", 110.0);
    }
}