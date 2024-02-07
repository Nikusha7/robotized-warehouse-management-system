package ge.epam.nika.model.orderEntity;

import ge.epam.nika.model.productEntity.Product;

import java.util.List;

public class FactoryOrder extends Order{
    public FactoryOrder(List<Product> productList) {
        super(productList);
    }
}