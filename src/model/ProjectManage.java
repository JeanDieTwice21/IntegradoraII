package model;

public class ProjectManage{

    public static final int SIZE_ARRAY = 10;
    private Projects[] projects;

    public ProjectManage(){

        projects = new Projects[SIZE_ARRAY];
    }
    
    public void addProject(String projectName, String clientName, Calendar expectedStartDate, Calendar expectedEndDate double budget){
	
		Projects project = new Projects(projectName, clientName, expectedStartDate, expectedEndDate, budget); 
		int pos = getFirstValidPosition();
		if(pos != -1){
		    projects[pos] = project; 
		}
	}

	public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_ARRAY && !isFound; i++){
			if(project[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
}