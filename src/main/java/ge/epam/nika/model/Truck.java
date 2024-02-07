package ge.epam.nika.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Truck {
    private static final Logger logger = LoggerFactory.getLogger(Truck.class);
    private int id;
    private boolean loaded;

    public Truck(int id, boolean loaded) {
        this.id = id;
        this.loaded = loaded;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public void startDelivery(String location){
        logger.info("Your delivery is on the way! ");
    }
}