package org.example.stocksimulationfx;

import java.util.ArrayList;
import java.util.HashSet;

public class GameStock {
    private HashSet<Stock> stocks;

    public GameStock(){
        this.stocks = new HashSet<Stock>();
    }

    public void createStocks(){
        ArrayList<Float> applePrices = new ArrayList<>();
        applePrices.add(175.1f);
        applePrices.add(170.12f);
        applePrices.add(169.12f);
        applePrices.add(169f);
        applePrices.add(170.73f);
        applePrices.add(172.75f);
        applePrices.add(173.23f);
        applePrices.add(171.13f);
        applePrices.add(173f);
        applePrices.add(172.62f);
        applePrices.add(173.72f);
        applePrices.add(176.08f);
        applePrices.add(178.67f);
        applePrices.add(171.37f);
        applePrices.add(172.28f);
        applePrices.add(170.85f);
        applePrices.add(169.71f);
        applePrices.add(173.31f);
        applePrices.add(171.48f);
        applePrices.add(170.03f);
        Stock apple = new Stock("apple", applePrices, 200);
        stocks.add(apple);

        ArrayList<Float> microsoftPrices = new ArrayList<>();
        microsoftPrices.add(414.92f);
        microsoftPrices.add(402.65f);
        microsoftPrices.add(402.09f);
        microsoftPrices.add(409.14f);
        microsoftPrices.add(406.22f);
        microsoftPrices.add(404.52f);
        microsoftPrices.add(415.28f);
        microsoftPrices.add(415.10f);
        microsoftPrices.add(425.22f);
        microsoftPrices.add(416.42f);
        microsoftPrices.add(417.32f);
        microsoftPrices.add(421.41f);
        microsoftPrices.add(425.23f);
        microsoftPrices.add(429.37f);
        microsoftPrices.add(428.74f);
        microsoftPrices.add(422.86f);
        microsoftPrices.add(421.65f);
        microsoftPrices.add(421.43f);
        microsoftPrices.add(420.72f);
        microsoftPrices.add(424.57f);
        Stock microsoft = new Stock("microsoft", microsoftPrices, 150);
        stocks.add(microsoft);

        ArrayList<Float> googlePrices = new ArrayList<>();
        googlePrices.add(139f);
        googlePrices.add(140.77f);
        googlePrices.add(144.34f);
        googlePrices.add(142.17f);
        googlePrices.add(148.48f);
        googlePrices.add(147.92f);
        googlePrices.add(149.68f);
        googlePrices.add(148.74f);
        googlePrices.add(151.77f);
        googlePrices.add(151.15f);
        googlePrices.add(151.70f);
        googlePrices.add(151.94f);
        googlePrices.add(152.26f);
        googlePrices.add(156.50f);
        googlePrices.add(155.87f);
        googlePrices.add(156.37f);
        googlePrices.add(156.98f);
        googlePrices.add(157.56f);
        googlePrices.add(158.03f);
        googlePrices.add(159.54f);
        Stock google = new Stock("google", googlePrices, 300);
        stocks.add(google);

        ArrayList<Float> amazonPrices = new ArrayList<>();
        amazonPrices.add(174.12f);
        amazonPrices.add(173.51f);
        amazonPrices.add(176.82f);
        amazonPrices.add(175.35f);
        amazonPrices.add(171.96f);
        amazonPrices.add(175.39f);
        amazonPrices.add(176.56f);
        amazonPrices.add(178.75f);
        amazonPrices.add(174.42f);
        amazonPrices.add(174.48f);
        amazonPrices.add(175.90f);
        amazonPrices.add(178.15f);
        amazonPrices.add(178.15f);
        amazonPrices.add(178.87f);
        amazonPrices.add(179.71f);
        amazonPrices.add(178.30f);
        amazonPrices.add(179.83f);
        amazonPrices.add(180.38f);
        amazonPrices.add(180.97f);
        amazonPrices.add(180.71f);
        Stock amazon = new Stock("amazon", amazonPrices, 200);
        stocks.add(amazon);

        ArrayList<Float> danonePrices = new ArrayList<>();
        danonePrices.add(59.08f);
        danonePrices.add(59.21f);
        danonePrices.add(58.73f);
        danonePrices.add(58.88f);
        danonePrices.add(58.75f);
        danonePrices.add(58.97f);
        danonePrices.add(59.16f);
        danonePrices.add(59.54f);
        danonePrices.add(59.41f);
        danonePrices.add(59.60f);
        danonePrices.add(59.34f);
        danonePrices.add(59.29f);
        danonePrices.add(59.38f);
        danonePrices.add(59.15f);
        danonePrices.add(59.57f);
        danonePrices.add(60.01f);
        danonePrices.add(59.73f);
        danonePrices.add(59.89f);
        danonePrices.add(58.98f);
        danonePrices.add(58.52f);
        Stock danone = new Stock("danone", danonePrices, 500);
        stocks.add(danone);
    }

    public HashSet<Stock> getStocks() {
        return stocks;
    }
}
