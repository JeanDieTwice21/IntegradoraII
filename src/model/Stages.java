package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class Stages{

    public static final int SIZE =  50;
    private Calendar expectedStartDate;
    private Calendar expectedEndDate;
    private Calendar realStartDate;
    private Calendar realEndDate;
    public boolean approveStage;
    public boolean isActivated;
    private Capsule[] capsules;


    public Stages(Calendar expectedStartDate, Calendar realStartDate){
        
        this.expectedStartDate = expectedStartDate; 
        this.realStartDate = realStartDate;
        this.approveStage = false;
        this.isActivated= false;
        capsules = new Capsule[SIZE];

    }

    public void addCapsule(boolean isActivated, Capsule capsule){

        if(isActivated == true ){
            int pos = getFirstValidPosition();
            if(pos != -1){
                capsules[pos] = capsule;
            }
        }

    }

    public int countCapsules(){
        
        int capsulesCounter = 0;

        for(int i = 0; i < SIZE; i++){
            if(capsules[i] != null){
                capsulesCounter += 1;
            }
        }

        return capsulesCounter;
    }

/**
 * The function returns an array of Capsule objects.
 * 
 * @return An array of Capsule objects is being returned.
 */
    public Capsule[] getCapsules(){
        return capsules;
    }
/**
 * The function returns the expected start date as a Calendar object.
 * 
 * @return A Calendar object representing the expected start date.
 */
    public Calendar getExpectedStartDate(){
        return expectedStartDate;
    }

/**
 * This function returns the expected end date as a Calendar object.
 * 
 * @return The method is returning a Calendar object named expectedEndDate.
 */
    public Calendar getExpectedEndDate(){
        return expectedEndDate;
    }

/**
 * This function returns a boolean value indicating whether the approve stage has been reached.
 * 
 * @return A boolean value is being returned.
 */
    public boolean getApproveStage(){
        return approveStage;
    }

/**
 * The function returns the status of whether something is activated or not.
 * 
 * @return The method is returning the value of the boolean variable "isActivated".
 */
    public boolean getStatus(){
        return isActivated;
    }

/**
 * This function sets the expected end date by adding a specified number of months to the expected
 * start date.
 * 
 * @param monthsToAdd The number of months to add to the expected start date to calculate the expected
 * end date.
 */
    public void setExpectedEndDate(int monthsToAdd){

        Calendar expectedStart = getExpectedStartDate();
        Calendar expectedEndDate = (Calendar) expectedStart.clone();
        expectedEndDate.add(Calendar.MONTH, monthsToAdd);

        this.expectedEndDate = expectedEndDate;
    }

/**
 * This function sets the value of a Calendar object called "realStartDate".
 * 
 * @param newRealStartDate A Calendar object representing the new real start date that will be set for
 * an instance variable called realStartDate.
 */
    public void setRealStartDate(Calendar newRealStartDate){
        this.realStartDate = newRealStartDate;
    }

/**
 * This function sets the expected start date of a task to a new value.
 * 
 * @param newExpectedStartDate A Calendar object representing the new expected start date that will be
 * set for the current object.
 */
    public void setExpectedStartDate(Calendar newExpectedStartDate){
        this.expectedStartDate = newExpectedStartDate;
    }

/**
 * This function sets the real end date of a stage using a Calendar object.
 * 
 * @param endDate The parameter "endDate" is a Calendar object representing the actual end date of a
 * task or project. This method sets the value of the instance variable "realEndDate" to the value of
 * the "endDate" parameter.
 */
    public void setRealEndDate(Calendar endDate){
        this.realEndDate = endDate;
    }

/**
 * The function returns the real end date as a Calendar object.
 * 
 * @return A Calendar object representing the real end date.
 */
    public Calendar getRealEndDate(){
        return realEndDate;
    }

/**
 * This function sets the value of a boolean variable called "approveStage".
 * 
 * @param approveStage a boolean variable that represents whether a certain stage has been approved or
 * not. The method setApproveStage sets the value of this variable.
 */
    public void setApproveStage(boolean approveStage){
        this.approveStage = approveStage;
    }

/**
 * This Java function sets the status of an object's activation to a boolean value.
 * 
 * @param status a boolean value representing the status to be set for the object. If it is true, it
 * means the object is activated, and if it is false, it means the object is deactivated.
 */
    public void setStatus(boolean status){
        this.isActivated = status;

    }



/**
 * This function returns the index of the first null element in an array of capsules.
 * 
 * @return The method is returning an integer value which represents the first valid position in an
 * array called "capsules". If there is no valid position, the method returns -1.
 */
	public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE && !isFound; i++){
			if(capsules[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}


    
}