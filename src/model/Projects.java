package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Projects{

    public static final int SIZE_STAGES = 6;
    private String projectName;
    private String clientName;
    private Calendar expectedStartDate;
    private Calendar expectedEndDate;
    private double budget;
    private Stages[] stages;
    
    public Projects(String projectName, String clientName, Calendar expectedStartDate, Calendar expectedEndDate, double budget){
        
        this.projectName = projectName;
        this.clientName = clientName;
        this.expectedStartDate = expectedStartDate;
        this.expectedEndDate = expectedEndDate;
        this.budget = budget;
        stages = new Stages[SIZE_STAGES];
    }

    public void addStage(Stages stage){

        int pos = getFirstValidPosition();
        if(pos != -1){
            stages[pos] = stage;
        }

    }

    public Stages[] getStages(){
        return stages;
    }

    public String getName(){
        return projectName;
    }
    public int getFirstValidPosition(){

		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_STAGES && !isFound; i++){
			if(stages[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
    }
}