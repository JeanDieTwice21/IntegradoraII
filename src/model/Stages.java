package model;


public class Stages{

    private String type;
    private String expectedStartDate;
    private String expectedEndDate;
    private String realStartDate;
    private String realEndDate;
    private boolean approveStage;

    public Stages(String type, String expectedStartDate, String expectedEndDate, String realStartDate, String realEndDate){
        
        this.type = type;
        this.expectedStartDate = expectedStartDate;
        this.expectedEndDate = expectedEndDate;
        this.realStartDate = realStartDate;
        this.realEndDate = realEndDate;
        this.approveStage = true;




    }



    
}