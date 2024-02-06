package ge.epam.nika.model;

import ge.epam.nika.model.productEntity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Robot {
    private int id;

    private static final Logger logger = LoggerFactory.getLogger(Robot.class);

    public void storeProducts(List<Product> product) {
        logger.info("Products has been successfully stored in warehouse!");
    }
    public void packProducts(List<Product> product){
        logger.info("Product has been packed and ready for loading! ");
    }
    public void loadTruck(List<Product> product) {
        logger.info("Products has been successfully loaded into shipping truck!");
    }

}