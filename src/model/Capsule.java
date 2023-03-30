package model;

public class Capsule{

    private String id;
    private String type;
    private String description;
    private String workerName;
    private String workerCharge;
    private String lection;
    private boolean approveStatus;

    public Capsule(String id, String type, String description, String workerName, String workerCharge, String lection){

        this.id = id;
        this.type = type;
        this.description = description;
        this.workerName = workerName;
        this.workerCharge = workerCharge;
        this.lection = lection;
        this.approveStatus = false;

    }
}