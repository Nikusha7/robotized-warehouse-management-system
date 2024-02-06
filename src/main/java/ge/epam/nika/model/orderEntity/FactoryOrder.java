package ge.epam.nika.model.orderEntity;

import ge.epam.nika.model.productEntity.Product;

import java.util.List;

public class FactoryOrder {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}