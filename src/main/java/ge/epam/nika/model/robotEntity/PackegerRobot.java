package ge.epam.nika.model.robotEntity;

import ge.epam.nika.model.productEntity.Product;
import ge.epam.nika.model.robotEntity.enums.RobotType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PackegerRobot extends Robot {
    private static final Logger logger = LoggerFactory.getLogger(PackegerRobot.class);

    public PackegerRobot(int id, String name, RobotType robotType) {
        super(id, name, robotType);
    }

    public void packProducts(List<Product> product) {
        logger.info("Product has been packed and ready for loading! ");
    }

    @Override
    public void cleanWarehouse() {
        logger.info("Packaging area has been cleaned!");
    }
}
