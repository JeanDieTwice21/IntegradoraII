package model;

public class CapsuleManage{

    public static int SIZE = 50;
    private Capsule[] capsules;

    public CapsuleManage(){

        capsules = new Capsule[SIZE];


    }

	public void addCapsule(String id, String type, String description, String workerName, String workerCharge, String lection){
	
		Capsule capsule = new Capsule(id, type, description, workerName, workerCharge, lection); 
		int pos = getFirstValidPosition();
		if(pos != -1){
			capsules[pos] = capsule; 
		}
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