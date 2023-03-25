package model;

public class Capsule{

    private String id;
    private String description;
    private String workerName;
    private String workerCharge;
    private String lection;

    public Capsule(String id, String description, String workerName, String workerCharge, String lection){

        this.id = id;
        this.description = description;
        this.workerName = workerName;
        this.workerCharge = workerCharge;
        this.lection = lection;
        
    }
}