package ui;
import model.CapsuleManage;
import model.ProjectManage;
import java.util.Calendar;
import java.util.Scanner;

public class Main{

    private CapsuleManage capsuleController;
    private ProjectManage projectController;
    private Scanner reader;

    public Main(){

        this.reader = new Scanner(System.in);
        capsuleController = new CapsuleManage();
        projectController = new ProjectManage();

    } 

    public static void main(String[] args){

        Main view = new Main();

        int choice = 0;

        do{

            view.menu();
            choice = view.validateIntegerInput();
            view.executeChoice(choice);



        }while(choice != 6);
    }

    public void menu(){

        System.out.println("--------------------------------------------");
        System.out.println("Hello there!");
        System.out.println(" ");
        System.out.println("Please, choose an option: ");
        System.out.println(" ");
        System.out.println("1. Create a project.");
        System.out.println("2. Finish a project stage.");
        System.out.println("3. Regist a capsule.");
        System.out.println("4. Approve a capsule.");
        System.out.println("5. Public a capsule.");
        System.out.println("6. Exit.");
        System.out.println(" ");
        System.out.println("--------------------------------------------");

    }

    public void executeChoice(int choice){
        
        switch(choice){

            case 1:
                
                System.out.println("You choosed to create a project.");
                System.out.println(" ");
                registProject();

                break;

            case 2:

                System.out.println("You choosed to finish a project stage.");
                System.out.println(" ");
                finishStage();
                break;
            
            case 3:
                
                System.out.println("You choosed regist a capsule.");
                System.out.println(" ");
                registCapsule();

                break;

            case 4:


                break;

            case 5:

                
                break;

            case 6:

                System.out.println("Goodbye.");
                break;
        



        }

    }

    public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Ingrese un valor entero."); 
        }
        return option; 
    }

    public void registCapsule(){

        String id = ""; 
        String description = "";
        String workerName = "";
        String workerCharge = "";
        String lection = "";
        String type = "";
         

        System.out.println("Type the capsule id: "); 
        id = reader.next(); 
        System.out.println("Type a short description: ");
        reader.next(); 
        description = reader.nextLine();
        System.out.println("Type the kind of the capsule: ");
        type = reader.next();
        System.out.println("Type the worker name: ");
        reader.next();
        workerName = reader.nextLine();
        System.out.println("Type the worker charge: ");
        workerCharge = reader.next();
        System.out.println("Type the lection to save: ");
        reader.next();
        lection = reader.nextLine(); 

        capsuleController.addCapsule(id, type, description, workerName, workerCharge, lection); 

        System.out.println("The capsule has been registed.");

    }
    
    public void registProject(){
        
        String projectName = "";
        String clientName = "";
        String expectedStartDate; 
        String expectedStartDateStage;
        String expectedEndDateStage;
        String expectedEndDate;
        double budget = 0.0;
        
        System.out.println("Type the name of the project: ");
        reader.next();
        projectName = reader.nextLine();
        System.out.println("Type the name of the client: ");
        reader.next();
        clientName = reader.nextLine();
        System.out.println("Type the expected start date");
        reader.next();
        expectedStartDate = reader.nextLine();
        System.out.println("Type the expected end date");
        reader.next();
        expectedEndDate = reader.nextLine();
        System.out.println("Type the budget of the project");
        budget = reader.nextDouble();

        projectController.addProject(projectName, clientName, expectedStartDate, expectedEndDate, budget);

        System.out.println("Now, please, type the expected start date for the first stage: ");
        reader.next();
        expectedStartDateStage = reader.nextLine();
        System.out.println("Type the expected ennd date for the first stage: ");
        reader.next();
        expectedEndDateStage = reader.nextLine();

        projectController.initStages(expectedStartDateStage, expectedEndDateStage);

        System.out.println("The project has been registed succesfully.");

    }

    public void finishStage(){

        System.out.println("The current stage will be finished.");
        projectController.finishStage();

        System.out.println("The current stage was finished succesfully. The next stage has been initiated.");

    }
}