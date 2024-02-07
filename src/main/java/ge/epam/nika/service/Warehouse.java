package ge.epam.nika.service;

import ge.epam.nika.model.Truck;
import ge.epam.nika.model.orderEntity.FactoryOrder;
import ge.epam.nika.model.orderEntity.MarketOrder;
import ge.epam.nika.model.productEntity.Product;
import ge.epam.nika.model.robotEntity.PackegerRobot;
import ge.epam.nika.model.robotEntity.StorageLoaderRobot;
import ge.epam.nika.model.robotEntity.TruckLoaderRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Warehouse {
    private static final Logger logger = LoggerFactory.getLogger(Warehouse.class);

    private String name;
    private String location;
    private InventoryManagement inventory;
    private PackegerRobot packegerRobot;
    private StorageLoaderRobot storageLoaderRobot;
    private TruckLoaderRobot truckLoaderRobot;
    private Truck truck;

    public Warehouse(String name, String location, InventoryManagement inventory, PackegerRobot packegerRobot, StorageLoaderRobot storageLoaderRobot, TruckLoaderRobot truckLoaderRobot, Truck truck) {
        this.name = name;
        this.location = location;
        this.inventory = inventory;
        this.packegerRobot = packegerRobot;
        this.storageLoaderRobot = storageLoaderRobot;
        this.truckLoaderRobot = truckLoaderRobot;
        this.truck = truck;
    }

    public void receiveFactoryOrder(FactoryOrder factoryOrder) {
        List<Product> productList = factoryOrder.getProductList();

        int requestedCapacity = 0;
        for (Product product : productList) {
            requestedCapacity += product.getQuantity();
        }

        if (inventory.getCapacity() >= requestedCapacity) {
            logger.info("Warehouse has enough space for your order! deliver products and our robots will store them! ");
            storeProducts(factoryOrder);
            inventory.getWarehouseProductList().addAll(productList);
            logger.info("Inventory has been updated!");
        } else {
            logger.info("Warehouse is out of space! Our current Capacity: " + inventory.getCapacity() + "Try to minimize your order and send it again.");
        }
    }

    private void storeProducts(FactoryOrder factoryOrder) {
        logger.info("Products has been delivered to warehouse, our robot will store them safely");
        storageLoaderRobot.storeProducts(factoryOrder.getProductList());
    }


    public void receiveMarketOrder(MarketOrder marketOrder) {
        List<Product> productList = marketOrder.getProductList();

        int availableProduct = 0;
        for (Product product : productList) {
            for (int i = 0; i < inventory.getWarehouseProductList().size(); i++) {
                if (inventory.getWarehouseProductList().get(i).getColaType().equals(product.getColaType())
                        && inventory.getWarehouseProductList().get(i).getVesselType().equals(product.getVesselType())
                        && inventory.getWarehouseProductList().get(i).getQuantity() >= product.getQuantity()) {
                    availableProduct += 1;
                }
            }
        }

        if (availableProduct >= productList.size()) {
            logger.info("Warehouse has enough products for you! Your order will be packed and sent");
//            robot is packing the product
            packegerRobot.packProducts(productList);
//            robot load the truck
            truckLoaderRobot.loadTruck(productList);
            truck.setLoaded(true);

//            keep updating inventory management system: updated productList and inventory capacity
            inventory.getWarehouseProductList().removeAll(productList);
            int removedCapacity = 0;
            for (Product product : productList) {
                removedCapacity += product.getQuantity();
            }
            int newCapacity = inventory.getCapacity() - removedCapacity;
            inventory.setCapacity(newCapacity);
            logger.info("Inventory has been updated");
//            sending truck to delivery
            if (truck.isLoaded()) {
                truck.startDelivery(marketOrder.getLocation());
            }
            logger.info("Products has been successfully delivered to the market");
        } else {
            logger.info("Warehouse is out of product! Our current products: "
                    + inventory.toString() +
                    " Try to minimize your order and send it again.");
        }

    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", inventory=" + inventory +
                ", packegerRobot=" + packegerRobot +
                ", storageLoaderRobot=" + storageLoaderRobot +
                ", truckLoaderRobot=" + truckLoaderRobot +
                ", truck=" + truck +
                '}';
    }
}