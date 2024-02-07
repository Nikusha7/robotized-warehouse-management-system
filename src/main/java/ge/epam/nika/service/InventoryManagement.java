package ge.epam.nika.service;

import ge.epam.nika.model.productEntity.Product;

import java.util.List;

public class InventoryManagement {
    private List<Product> warehouseProductList;

    private int capacity;

    public InventoryManagement(List<Product> warehouseProductList, int capacity) {
        this.warehouseProductList = warehouseProductList;
        this.capacity = capacity;
    }

    public List<Product> getWarehouseProductList() {
        return warehouseProductList;
    }

    public void setWarehouseProductList(List<Product> warehouseProductList) {
        this.warehouseProductList = warehouseProductList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "InventoryManagement{" +
                "warehouseProductList=" + warehouseProductList +
                ", capacity=" + capacity +
                '}';
    }
}