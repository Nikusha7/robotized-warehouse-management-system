package ge.epam.nika.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Truck {
    private static final Logger logger = LoggerFactory.getLogger(Robot.class);

    private int id;
    private boolean loaded;

    public void startDelivery(String location){
        logger.info("Your delivery is on the way! ");
    }
}