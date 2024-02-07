package ge.epam.nika;

import ge.epam.nika.model.Truck;
import ge.epam.nika.model.orderEntity.FactoryOrder;
import ge.epam.nika.model.orderEntity.MarketOrder;
import ge.epam.nika.model.productEntity.Product;
import ge.epam.nika.model.productEntity.enums.CocaColaType;
import ge.epam.nika.model.productEntity.enums.TypeOfVessel;
import ge.epam.nika.model.robotEntity.PackegerRobot;
import ge.epam.nika.model.robotEntity.StorageLoaderRobot;
import ge.epam.nika.model.robotEntity.TruckLoaderRobot;
import ge.epam.nika.model.robotEntity.enums.RobotType;
import ge.epam.nika.service.InventoryManagement;
import ge.epam.nika.service.Warehouse;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        creating products that will be sent by Coca-Cola Factory
        Product product1 = new Product(CocaColaType.CLASSIC, TypeOfVessel.BOTTLE_2L, 20);
        Product product2 = new Product(CocaColaType.DIET, TypeOfVessel.BOTTLE_2L, 10);
        Product product3 = new Product(CocaColaType.SUGAR_FREE, TypeOfVessel.BOTTLE_2L, 15);

//        creating product list that will be sent by Factory
        List<Product> factoryOrderProducts = new ArrayList<>();
        factoryOrderProducts.add(product1);
        factoryOrderProducts.add(product2);
        factoryOrderProducts.add(product3);
//        creating factory order and passing product list
        FactoryOrder factoryOrder = new FactoryOrder(factoryOrderProducts);

//        empty list of products, assigned in inventory management since warehouse has not received any product yet
        List<Product> warehouseProductList = new ArrayList<>();
        InventoryManagement inventoryManagement = new InventoryManagement(warehouseProductList, 100);

//        creating robots and truck to pass to warehouse
        PackegerRobot packegerRobot = new PackegerRobot(1, "Falcon-Packager", RobotType.PRODUCT_PACKAGER);
        StorageLoaderRobot storageLoaderRobot = new StorageLoaderRobot(2, "Falcon-Storage-Loader", RobotType.STORAGE_LOADER);
        TruckLoaderRobot truckLoaderRobot = new TruckLoaderRobot(3, "Falcon-Truck-Loader", RobotType.TRUCK_LOADER);

        Truck truck = new Truck(1, false);

//        warehouse is created
        Warehouse warehouse = new Warehouse("Coca-Cola Robotized warehouse", "Tbilisi, Main Street",
                inventoryManagement, packegerRobot, storageLoaderRobot, truckLoaderRobot, truck);

//        warehouse receivesFactory order and will store products if capacity of warehouse is enough
        warehouse.receiveFactoryOrder(factoryOrder);

//        creating products and product list for market order
        Product marketProduct1 = new Product(CocaColaType.CLASSIC, TypeOfVessel.BOTTLE_2L, 10);
        Product marketProduct2 = new Product(CocaColaType.DIET, TypeOfVessel.BOTTLE_2L, 5);
        Product marketProduct3 = new Product(CocaColaType.SUGAR_FREE, TypeOfVessel.BOTTLE_2L, 12);
        List<Product> marketProductList = new ArrayList<>();
        marketProductList.add(marketProduct1);
        marketProductList.add(marketProduct2);
        marketProductList.add(marketProduct3);

//        created market order
        MarketOrder marketOrder = new MarketOrder(marketProductList, "Rustaveli Street Corner N-15");

//        warehouse receives market order and if it has enough product robots will do their jobs and product will be delivered
        warehouse.receiveMarketOrder(marketOrder);
    }
}