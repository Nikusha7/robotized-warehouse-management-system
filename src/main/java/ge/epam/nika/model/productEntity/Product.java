package ge.epam.nika.model.productEntity;

import ge.epam.nika.model.productEntity.enums.CocaColaType;
import ge.epam.nika.model.productEntity.enums.TypeOfVessel;

public class Product {
    private CocaColaType colaType;
    private TypeOfVessel vesselType;
    private int quantity;

    public Product(CocaColaType colaType, TypeOfVessel vesselType, int quantity) {
        this.colaType = colaType;
        this.vesselType = vesselType;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CocaColaType getColaType() {
        return colaType;
    }

    public void setColaType(CocaColaType colaType) {
        this.colaType = colaType;
    }

    public TypeOfVessel getVesselType() {
        return vesselType;
    }

    public void setVesselType(TypeOfVessel vesselType) {
        this.vesselType = vesselType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "quantity='" + quantity + '\'' +
                ", colaType=" + colaType +
                ", vesselType=" + vesselType +
                '}';
    }
}