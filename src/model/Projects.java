package model;


public class Projects{

    private String projectName;
    private String clientName;
    private Calendar expectedStartDate;
    private Calendar expectedEndDate;
    private double budget;
    
    public Projects(String projectName, String clientName, String expectedStartDate, String expectedEndDate, double budget){
        
        this.projectName = projectName;
        this.clientName = clientName;
        this.expectedStartDate = expectedStartDate;
        this.expectedEndDate = expectedEndDate;
        this.budget = budget;
    }

    public void initStages()
}