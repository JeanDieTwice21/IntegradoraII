package model;

public class CapsuleManage{
    
    private Capsule capsule;

    public CapsuleManage(){


    }

    public void initCapsule(String id, String description, String workerName, String workerCharge, String lection){

        this.capsule = new Capsule(id, description, workerName, workerCharge, lection);

    }
}