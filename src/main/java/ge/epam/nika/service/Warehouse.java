package ge.epam.nika.service;

import ge.epam.nika.model.Robot;
import ge.epam.nika.model.Truck;
import ge.epam.nika.model.orderEntity.FactoryOrder;
import ge.epam.nika.model.orderEntity.MarketOrder;
import ge.epam.nika.model.productEntity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Warehouse {
    private static final Logger logger = LoggerFactory.getLogger(Warehouse.class);

    private String name;
    private String location;
    private InventoryManagement inventory;
    private Robot robot;
    private Truck truck;

    public void sendDelivery(Truck truck, String marketLocation) {

    }

    public void receiveFactoryOrder(FactoryOrder factoryOrder) {
        List<Product> productList = factoryOrder.getProductList();

        int requestedCapacity = 0;
        for (Product product : productList) {
            requestedCapacity += product.getQuantity();
        }

        if (inventory.capacity >= requestedCapacity) {
            logger.info("Warehouse has enough space for your order! deliver products and our robots will store them! ");
            storeProducts(factoryOrder);
            inventory.warehouseProductList.addAll(productList);
            logger.info("Inventory has been updated!");
        } else {
            logger.info("Warehouse is out of space! Our current Capacity: " + inventory.capacity + "Try to minimize your order and send it again.");
        }
    }

    private void storeProducts(FactoryOrder factoryOrder) {
        logger.info("Products has been delivered to warehouse, our robot will store them safely");
        robot.storeProducts(factoryOrder.getProductList());
    }


    public void receiveMarketOrder(MarketOrder marketOrder) {
        List<Product> productList = marketOrder.getProductList();

        int availableProduct = 0;
        for (Product product : productList) {
            for (int i = 0; i < inventory.warehouseProductList.size(); i++) {
                if (inventory.warehouseProductList.get(i).getColaType().equals(product.getColaType())
                        && inventory.warehouseProductList.get(i).getVesselType().equals(product.getVesselType())
                        && inventory.warehouseProductList.get(i).getQuantity() >= product.getQuantity()) {
                    availableProduct += 1;
                }
            }
        }

        if (availableProduct >= productList.size()) {
            logger.info("Warehouse has enough products for you! Your order will be packed and sent");
//            robot is packing the product
            robot.packProducts(productList);
//            robot load the truck
            robot.loadTruck(productList);
//            keep updating inventory management system: updated productList and inventory capacity
            inventory.warehouseProductList.removeAll(productList);
            int removedCapacity = 0;
            for (Product product : productList) {
                removedCapacity += product.getQuantity();
            }
            inventory.capacity = inventory.capacity - removedCapacity;
//            sending truck to delivery
            truck.startDelivery(marketOrder.getMarketLocation());
            logger.info("Products has been successfully delivered to the market");
        } else {
            logger.info("Warehouse is out of product! Our current products: "
                    + inventory.toString() +
                    " Try to minimize your order and send it again.");
        }

    }


}