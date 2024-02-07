package ge.epam.nika.model.orderEntity;

import ge.epam.nika.model.productEntity.Product;

import java.util.List;

public abstract class Order {
    public List<Product> productList;

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}