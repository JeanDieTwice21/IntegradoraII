package model;
import java.util.Calendar;

public class ProjectManage{

    public static final int SIZE_ARRAY = 10;
	public static final int SIZE_STAGES = 6;
    private Projects[] projects;
	private Stages[] stages;

    public ProjectManage(){

        projects = new Projects[SIZE_ARRAY];
		stages = new Stages[SIZE_STAGES];
    }
    
    public void addProject(String projectName, String clientName, double budget){
	
		Projects project = new Projects(projectName, clientName, budget); 
		int pos = getFirstValidPosition();
		if(pos != -1){
		    projects[pos] = project; 
		}
	}

	public void initStages(String expectedStartDate, String expectedEndDate){
		
		int pos;
		String expectedStartDateEmpt = " ";
		String expectedEndDateEmpt = " ";
		String realStartDateEmpt = " ";
		String realEndDateEmpt = " ";

		Stages startStage = new Stages(expectedStartDate, expectedEndDate, realStartDate, realEndDate);

			boolean stageStatus = startStage.getStatus();
			if(stageStatus == false){
				stageStatus = true;
				startStage.setStatus(stageStatus);
			}

			pos = getFirstValidPosition();
			if(pos != -1){
			    stages[pos] = startStage; 
			}
	
		Stages analytStage = new Stages(expectedStartDateEmpt, expectedEndDateEmpt, realStartDateEmpt, realEndDateEmpt);
			pos = getFirstValidPosition();
			if(pos != -1){
		    	stages[pos] = analytStage; 
			}
	
		Stages designStage = new Stages(expectedStartDateEmpt, expectedEndDateEmpt, realStartDateEmpt, realEndDateEmpt);
			pos = getFirstValidPosition();
			if(pos != -1){
		    	stages[pos] = designStage; 
			}
	
		Stages executStage = new Stages(expectedStartDateEmpt, expectedEndDateEmpt, realStartDateEmpt, realEndDateEmpt);
			pos = getFirstValidPosition();
			if(pos != -1){
		    	stages[pos] = executStage; 
			}
	
		Stages closeStage = new Stages(expectedStartDateEmpt, expectedEndDateEmpt, realStartDateEmpt, realEndDateEmpt);
			pos = getFirstValidPosition();
			if(pos != -1){
		    	stages[pos] = closeStage; 
			}
		Stages followAndControlStage = new Stages(expectedStartDateEmpt, expectedEndDateEmpt, realStartDateEmpt, realEndDateEmpt);
			pos = getFirstValidPosition();
			if(pos != -1){
		    	stages[pos] = followAndControlStage; 
			}

	}

	public void finishStage(){

		while(int i = 0; i < SIZE_STAGES && !stages[i].isActivated; i++){
			if(i < SIZE_STAGES){
				stages[i].isActivated = false;
			}
			if(i < SIZE_STAGES - 1){
				stages[i+1].isActivated = true;
			}
		}
	}


	public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_ARRAY && !isFound; i++){
			if(projects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
}