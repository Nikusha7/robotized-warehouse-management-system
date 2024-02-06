package ge.epam.nika.model.orderEntity;

import ge.epam.nika.model.productEntity.Product;

import java.util.List;

public class MarketOrder {
    private List<Product> productList;

    private String marketLocation;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getMarketLocation() {
        return marketLocation;
    }

    public void setMarketLocation(String marketLocation) {
        this.marketLocation = marketLocation;
    }
}