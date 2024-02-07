package ge.epam.nika.model.robotEntity;

import ge.epam.nika.model.robotEntity.enums.RobotType;

public abstract class Robot {
    private int id;
    private String name;
    private RobotType robotType;

    public Robot(int id, String name, RobotType robotType) {
        this.id = id;
        this.name = name;
        this.robotType = robotType;
    }

    public void cleanWarehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RobotType getRobotType() {
        return robotType;
    }

    public void setRobotType(RobotType robotType) {
        this.robotType = robotType;
    }

}