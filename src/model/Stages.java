package model;


public class Stages{

    private String expectedStartDate;
    private String expectedEndDate;
    private String realStartDate;
    private String realEndDate;
    private boolean approveStage;
    private boolean isActivated;

    public Stages(String expectedStartDate, String expectedEndDate){
        
        this.expectedStartDate = expectedStartDate;
        this.expectedEndDate = expectedEndDate;
        this.realStartDate = realStartDate;
        this.realEndDate = realEndDate;
        this.approveStage = false;
        this.isActivated= false;

    }

    public String getExpectedStartDate(){
        return expectedStartDate;
    }

    public String getExpectedEndDate(){
        return expectedEndDate;
    }

    public boolean getApproveStage(){
        return approveStage;
    }

    public boolean getStatus(){
        return isActivated;
    }

    public void setApproveStage(boolean approveStage){
        this.approveStage = approveStage;
    }

    public void setStatus(boolean status){
        this.isActivated = status;

    }


    
}