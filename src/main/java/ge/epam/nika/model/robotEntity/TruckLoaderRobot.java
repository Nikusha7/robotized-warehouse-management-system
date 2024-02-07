package ge.epam.nika.model.robotEntity;

import ge.epam.nika.model.productEntity.Product;
import ge.epam.nika.model.robotEntity.enums.RobotType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TruckLoaderRobot extends Robot {
    private static final Logger logger = LoggerFactory.getLogger(TruckLoaderRobot.class);

    public TruckLoaderRobot(int id, String name, RobotType robotType) {
        super(id, name, robotType);
    }

    public void loadTruck(List<Product> product) {
        logger.info("Products has been successfully loaded into shipping truck!");
    }

    @Override
    public void cleanWarehouse() {
        super.cleanWarehouse();
    }
}
