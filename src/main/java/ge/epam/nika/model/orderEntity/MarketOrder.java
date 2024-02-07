package ge.epam.nika.model.orderEntity;

import ge.epam.nika.model.productEntity.Product;

import java.util.List;

public class MarketOrder extends Order{
    private String marketLocation;
    public MarketOrder(List<Product> productList, String marketLocation) {
        super(productList);
        this.marketLocation = marketLocation;
    }

    public String getLocation() {
        return marketLocation;
    }

    public void setLocation(String marketLocation) {
        this.marketLocation = marketLocation;
    }
}