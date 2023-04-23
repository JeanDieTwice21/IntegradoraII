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


/**
 * The function returns the total number of capsules across all stages.
 * 
 * @return The method is returning an integer value, which represents the total number of capsules in
 * all stages.
 */
    public int searchAmountCapsules(){

        int capsulesCounter = 0;

        for(int i = 0; i < SIZE_STAGES; i++){
            capsulesCounter += stages[i].countCapsules();
        }

        return capsulesCounter;
    }

/**
 * The function adds a stage to an array of stages at the first available position.
 * 
 * @param stage The stage object that needs to be added to an array of stages.
 */
    public void addStage(Stages stage){

        int pos = getFirstValidPosition();
        if(pos != -1){
            stages[pos] = stage;
        }

    }


/**
 * The function returns an array of Stages.
 * 
 * @return An array of objects of type "Stages".
 */
    public Stages[] getStages(){
        return stages;
    }

/**
 * The function returns the name of a project.
 * 
 * @return The method is returning the value of the variable "projectName", which is likely a String
 * representing the name of a project.
 */
    public String getName(){
        return projectName;
    }
    
/**
 * This function returns the first available position in an array of stages.
 * 
 * @return The method is returning an integer value which represents the first valid position in an
 * array called "stages". If no valid position is found, the method returns -1.
 */
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