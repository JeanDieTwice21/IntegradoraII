package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ProjectManage{

    public static final int SIZE_ARRAY = 10;
    private Projects[] projects;
	private int technicalCounter = 0;
    private int managementCounter = 0;
    private int domainCounter = 0;
	private int experiencesCounter = 0;

    public ProjectManage(){

        projects = new Projects[SIZE_ARRAY];
    }
    
 /**
  * This function adds a new project to the projects array.
  * 
  * @param projectName The name of the project.
  * @param clientName The name of the client.
  * @param expectedStartDate The date that the project is expected to start.
  * @param expectedEndDate The date the project is expected to end.
  * @param budget The budget of the project.
  */
    public void addProject(String projectName, String clientName, Calendar expectedStartDate, Calendar expectedEndDate, double budget){
	
		Projects project = new Projects(projectName, clientName, expectedStartDate, expectedEndDate, budget); 
		int pos = getFirstValidPosition();
		if(pos != -1){
		    projects[pos] = project; 
		}
	}


/**
 * This function initializes stages for a project with given start dates and adds them to the project's
 * list of stages.
 * 
 * @param projectName a String representing the name of the project
 * @param expectedStartDate The expected start date for the first stage of the project.
 * @param realStartDate The actual start date of a project stage.
 */
	public void initStages(String projectName, Calendar expectedStartDate, Calendar realStartDate) throws Exception{
		
		String refillDateStr = "01/01/2001";
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		boolean isFound = false;

		Calendar expectedStartDateEmpt = Calendar.getInstance();
		expectedStartDateEmpt.setTime(format.parse(refillDateStr));
		Calendar realStartDateEmpt = Calendar.getInstance();
		realStartDateEmpt.setTime(format.parse(refillDateStr));

		for(int i = 0; i < SIZE_ARRAY && !isFound; i++){

			if(projects[i] != null){
				if(projects[i].getName().equals(projectName)){

					Stages startStage = new Stages(expectedStartDate, realStartDate);
					boolean stageStatus = startStage.getStatus();
					if(stageStatus == false){
						stageStatus = true;
						startStage.setStatus(stageStatus);
					}
					projects[i].addStage(startStage);

					Stages analytStage = new Stages(expectedStartDateEmpt, realStartDateEmpt);
					projects[i].addStage(analytStage);
	
					Stages designStage = new Stages(expectedStartDateEmpt, realStartDateEmpt);
					projects[i].addStage(designStage);
	
					Stages executStage = new Stages(expectedStartDateEmpt, realStartDateEmpt);
					projects[i].addStage(executStage);
	
					Stages closeStage = new Stages(expectedStartDateEmpt, realStartDateEmpt);
					projects[i].addStage(closeStage);

					Stages followAndControlStage = new Stages(expectedStartDateEmpt, realStartDateEmpt);
					projects[i].addStage(followAndControlStage);

					isFound = true;

			}
			}

		}
	}

/**
 * This function adds a capsule to the current stage of a project
 * 
 * @param projectName The name of the project
 * @param capsuleId The id of the capsule
 * @param capsuleType 
 * @param capsuleDescription A description of the capsule.
 * @param capsuleWorkerName The name of the worker who is assigned to the capsule.
 * @param capsuleWorkerCharge The charge of the worker in the capsule
 * @param capsuleLection The lection of the capsule.
 */
	public String addCapsule(String projectName, int type, String capsuleId, String capsuleDescription, String capsuleWorkerName, String capsuleWorkerCharge, String capsuleLection){
		
		Type capsuleType = null;
		String msg = "The capsule hasnt been registed";
		boolean isFoundProject = false;
		boolean isFoundStage = false;
		boolean activatedStatus = false;
		

		for(int i = 0; i < SIZE_ARRAY && !isFoundProject; i++){
			if(projects[i] != null){
				if(projects[i].getName().equals(projectName)){
					Stages[] stages = projects[i].getStages();
					isFoundProject = true;
					for(int o = 0; i < stages.length && !isFoundStage; o++){
						if(stages[o].getStatus() == true){

							if(type ==  1){

								capsuleType = Type.TECHNICAL;
								technicalCounter += 1;
							}
							else if(type == 2){
					
								capsuleType = Type.MANAGE;
								managementCounter += 1;
							}
							else if(type == 3){
					
								capsuleType = Type.DOMAIN;
								domainCounter += 1;
							}
							else if(type == 4){
					
								capsuleType = Type.EXPERIENCES;
								experiencesCounter += 1;
							}

							Capsule capsule = new Capsule(capsuleId, capsuleType, capsuleDescription, capsuleWorkerName, capsuleWorkerCharge, capsuleLection);
							
							activatedStatus = stages[o].getStatus();
							stages[o].addCapsule(activatedStatus, capsule);
							isFoundStage = true;
							msg = "The capsule has been registed succesfully";
						}
					}
				}
				else{
					msg = "The project wastn found";
				}
			}
			else if(projects[i] == null){
				msg = "Theres isnt any registed projects.";
			}
		}
		return msg;
	}

/**
 * The function receives a project name, a capsule id, a publish date and a new status. It checks if
 * the project exists, if it does, it checks if the stage is active, if it is, it checks if the capsule
 * exists, if it does, it checks if the new status is true, if it is, it changes the status of the
 * capsule to true and sets the publish date to the one received as a parameter. If the new status is
 * false, it returns a message saying that the status hasn't changed
 * 
 * @param projectName The name of the project
 * @param capsuleId The id of the capsule to be approved.
 * @param publishDate The date the capsule wash published.
 * @param newStatus The new approved status of the capsule.
 * @return The method is returning a String.
 */
	public String approveCapsule(String projectName, String capsuleId, Calendar approveDate, boolean newStatus){

		boolean isFoundProject = false;
		boolean isFoundStage = false;
		boolean isFoundCapsule = false;
		String msg = " ";

		for(int i = 0; i < SIZE_ARRAY && !isFoundProject; i++){
			if(projects[i] != null){
				if(projects[i].getName().equalsIgnoreCase(projectName)){
					Stages[] stages = projects[i].getStages();
					isFoundProject = true;
					for(int o = 0; o < stages.length && !isFoundStage; o++){
						if(stages[o].getStatus() == true){
							Capsule[] capsules = stages[o].getCapsules();
							isFoundStage = true;
							for(int u = 0; u < capsules.length && !isFoundCapsule; u++){
								if(capsules[u].getId().equals(capsuleId)){
									if(newStatus == true){
										capsules[u].setApproveStatus(newStatus);
										capsules[u].setApproveDate(approveDate);
										msg = "The status of the capsule " + capsuleId + " has been changed to approved. Approve Date: " + approveDate;
										isFoundCapsule = true;
									 }
									else if(newStatus == false){
										msg = "The status hasnt changed, the capsule still innapproved.";
									}     									
	
								}
								else{

										msg = "The capsule wasnt found";

								 	}
								}
							}

						}
					}
					else{
						msg = "The project wanst found";
					}
			}
			else if(projects[i] == null){
				msg = "There isnt any project registered.";
			}
			}			
				return msg;
		}

/**
 * This function is used to publish a capsule that is approved and not published yet
 * 
 * @param projectName The name of the project that the capsule is in.
 * @param capsuleId The id of the capsule to be published.
 * @param newPublishedStatus true or false
 * @return A string.
 */
	public String publishCapsule(String projectName, String capsuleId, boolean newPublishedStatus){

		boolean isFoundProject = false;
		boolean isFoundStage = false;
		boolean isFoundCapsule = false;
		String msg = " ";

		for(int i = 0; i < SIZE_ARRAY && !isFoundProject; i++){
			if(projects[i] != null){
				if(projects[i].getName().equals(projectName)){
					Stages[] stages = projects[i].getStages();
					isFoundProject = true;
					for(int o = 0; o < stages.length && isFoundStage; o++){
						if(stages[o].getStatus() == true){
							Capsule[] capsules = stages[o].getCapsules();
							isFoundStage = true;
							for(int u = 0; u < capsules.length && !isFoundCapsule; u++){
								if(capsules[u].getId().equals(capsuleId)){
									if(capsules[u].getApproveStatus() == true){
										if(capsules[u].getIsPublished() == false){
											capsules[u].setIsPublished(newPublishedStatus);
											isFoundCapsule = true;
											msg =  "https/GreenCapsule" + capsuleId + ".net";
										}
										else{
											msg = "The capsule is already published.";
										}
									 }
									else{
										msg = "Cannot publish a capsule that is not approved.";
									}     									
	
								}
								else{
									msg = "Couldnt find the capsule.";
								}
								}
						}
						
						}
				}
				else{
					msg = "Couldn find the project.";
				}
			}
			else{
				msg = "There isnt any project registered.";
			}
			
		}			
				return msg;
	}		
		
         
    


/**
 * If the current stage is not the last stage, then deactivate the current stage and activate the next
 * stage
 */
	public void finishStage(String projectName, Calendar endDate, int amountMonths){

		boolean isFoundProject = false;

		for(int o = 0; o < SIZE_ARRAY && !isFoundProject; o++){
			if(projects[o] != null){
				if(projects[o].getName().equals(projectName)){
					Stages[] stages = projects[o].getStages();
					isFoundProject = true;
					for(int i = 0; i < stages.length && !stages[i].isActivated; i++){
						if(i < stages.length){
							stages[i].isActivated = false;
						}
						if(i < stages.length - 1){
							stages[i+1].isActivated = true;
							Calendar newStartDate = stages[i].getRealEndDate();
							stages[i+1].setExpectedStartDate(newStartDate);
							stages[i+1].setRealStartDate(newStartDate);
							stages[i+1].setExpectedEndDate(amountMonths);
						}
					}
				}
			}

		}


	}

	public String showCapsulesByType(){

		String msg = "The amount of technical capsules is : " + technicalCounter + "\n" + "The amount of management capsules is: " + managementCounter + "\n" + "The amount of domain capsules is: " + domainCounter + "\n" + "The amount of experiences capsules is: " + experiencesCounter;

		return msg;
	
	}

	public String showCapsulesLections(String projectName, int stagesPos){

		String msg = " ";
		boolean isFoundProject = false;
		
		for(int i = 0; i < SIZE_ARRAY && !isFoundProject; i++){
			if(projects[i] != null && projects[i].getName().equals(projectName)){
					Stages[] stages = projects[i].getStages();
					isFoundProject = true;
						Capsule[] capsules = stages[stagesPos].getCapsules();
						for(int z = 0; z < capsules.length; z++){
							if(capsules[z] != null){
								msg += capsules[z].getLection() + "\n";
							}
							
						}
					}
					else{
						msg = "There isnt any project registed";
					}
			
			}
			return msg;
		}
		
		

		
	

	public String searchCapsulesByWorker(String workerName){
		
		String msg = " ";

		for(int i = 0; i < SIZE_ARRAY; i++){
			if(projects[i] != null){

					Stages[] stages = projects[i].getStages();

					for(int j = 0; j < stages.length; j++){

						Capsule[] capsules = stages[j].getCapsules();

						for(int z = 0; z < capsules.length; z++){
							if(capsules[z] != null){
								
								if(capsules[z].getWorker().equals(workerName)){
									msg = "Yes, the worker " + workerName + "has registed capsules.";
								}
								else{
	
									msg = "No, the worker " + workerName + "hasnt registed capsules.";
	
								}
							}

						}
					}
				}

			}
				return msg;
		}

		public String[] searchLections(String projectName){
			
			boolean isFoundProject = false;
			String[] keywords = null;
			String lections = " ";
			int count = 0;
			
			for(int i = 0; i < SIZE_ARRAY && !isFoundProject; i++){
				if(projects[i] != null && projects[i].getName().equals(projectName)){
						Stages[] stages = projects[i].getStages();
						isFoundProject = true;
						for(int j = 0; j < stages.length; j++){
							Capsule[] capsules = stages[j].getCapsules();
							for(int z = 0; z < capsules.length; z++){
								if(capsules[z] != null && capsules[z].getApproveStatus() == true && capsules[z].getIsPublished() == true){

									lections += capsules[z].getLection() + "\n";

									String [] subStrings = lections.split("#");
									count += subStrings.length;

									keywords = new String[count];
									for(int k = 0; k < subStrings.length; k++){
										keywords[k] = subStrings[k].trim();
									}

								}
							}
						}
				}

			}			


			return keywords;

			}



			
		

 	public String searchProjectWithMoreCapsules(){
		
		int capsulesCounter = 0;
		String msg = " ";
		String projectName = " ";
		int maxCapsules = 0;

		for(int i = 0; i < SIZE_ARRAY; i++){
			if(projects[i] != null){
			 	capsulesCounter = projects[i].searchAmountCapsules();
			 	if(capsulesCounter > maxCapsules){
					maxCapsules = capsulesCounter;
					projectName = projects[i].getName();
					msg = "The project with more capsules is: " + projectName + " with " + maxCapsules;
				 }
			}

		}

		return msg;
	} 	



	
/**
 * > This function returns the first valid position in the array.
 * 
 * @return The first valid position in the array.
 */
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

	public boolean checkProjectArray(){

		boolean isFound = false;
		boolean confirmVar = false;

		for(int i = 0; i < SIZE_ARRAY && !isFound; i++){
			if(projects[i] != null){

				confirmVar = true;

			}
		}

		return confirmVar;
	}



}