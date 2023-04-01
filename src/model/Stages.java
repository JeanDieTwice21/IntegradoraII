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

    public Capsule[] getCapsules(){
        return capsules;
    }
    public Calendar getExpectedStartDate(){
        return expectedStartDate;
    }

    public Calendar getExpectedEndDate(){
        return expectedEndDate;
    }

    public boolean getApproveStage(){
        return approveStage;
    }

    public boolean getStatus(){
        return isActivated;
    }

    public void setExpectedEndDate(int monthsToAdd){

        Calendar expectedStart = getExpectedStartDate();
        Calendar expectedEndDate = (Calendar) expectedStart.clone();
        expectedEndDate.add(Calendar.MONTH, monthsToAdd);

        this.expectedEndDate = expectedEndDate;
    }

    public void setRealStartDate(Calendar newRealStartDate){
        this.realStartDate = newRealStartDate;
    }

    public void setExpectedStartDate(Calendar newExpectedStartDate){
        this.expectedStartDate = newExpectedStartDate;
    }

    public void setRealEndDate(Calendar endDate){
        this.realEndDate = endDate;
    }

    public Calendar getRealEndDate(){
        return realEndDate;
    }

    public void setApproveStage(boolean approveStage){
        this.approveStage = approveStage;
    }

    public void setStatus(boolean status){
        this.isActivated = status;

    }

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