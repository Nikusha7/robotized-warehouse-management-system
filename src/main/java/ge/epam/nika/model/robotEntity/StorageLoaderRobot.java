package ge.epam.nika.model.robotEntity;

import ge.epam.nika.model.productEntity.Product;
import ge.epam.nika.model.robotEntity.enums.RobotType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StorageLoaderRobot extends Robot {
    private static final Logger logger = LoggerFactory.getLogger(StorageLoaderRobot.class);

    public StorageLoaderRobot(int id, String name, RobotType robotType) {
        super(id, name, robotType);
    }

    public void storeProducts(List<Product> product) {
        logger.info("Products has been successfully stored in warehouse!");
    }

    @Override
    public void cleanWarehouse() {
        logger.info("Loading area has been cleaned!");
    }

}