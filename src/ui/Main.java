package ui;
import model.ProjectManage;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main{

    private ProjectManage projectController;
    private Scanner reader;

    public Main(){

        this.reader = new Scanner(System.in);
        projectController = new ProjectManage();

    } 

/**
 * The main function runs a loop that displays a menu, validates user input, and executes the selected
 * choice until the user chooses to exit.
 */
    public static void main(String[] args) throws Exception{

        Main view = new Main();

        int choice = 0;

        do{

            view.menu();
            choice = view.validateIntegerInput();
            view.executeChoice(choice);



        }while(choice != 6);
    }

/**
 * The function displays a menu with options for creating a project, finishing a project stage,
 * registering a capsule, approving a capsule, publishing a capsule, or exiting the program.
 */
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

/**
 * This function executes different actions based on the user's choice.
 * 
 * @param choice an integer representing the user's choice from a menu of options. The method executes
 * different actions based on the value of this parameter.
 */
    public void executeChoice(int choice) throws Exception{
        
        switch(choice){

            case 1:
                
                System.out.println("You choosed to create a project.");
                System.out.println(" ");
                registProject();
                registStages();

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
                
                System.out.println("You choosed to approve a capsule.");
                System.out.println(" ");
                approveCapsule();
                break;

            case 5:

                System.out.println("You choosed to publish a capsule.");
                System.out.println(" ");
                publishCapsule();    
                break;

            case 6:

                System.out.println("Goodbye.");
                break;
        }
    }

/**
 * This function validates user input to ensure it is an integer value.
 * 
 * @return The method is returning an integer value, which is either the user input if it is a valid
 * integer, or -1 if the user input is not a valid integer.
 */
    public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Enter a valid value."); 
        }
        return option; 
    }

/**
 * This function registers a capsule by taking input from the user and passing it to a project
 * controller.
 */
    public void registCapsule(){

        String id = ""; 
        String description = "";
        String workerName = "";
        String workerCharge = "";
        String lection = "";
        String type = "";
        String projectName = " ";
         
        System.out.println("Type the name of the project.");
        projectName = reader.next();
        System.out.println("Type the capsule id: "); 
        id = reader.next(); 
        System.out.println("Type a short description: ");
        reader.next(); 
        description = reader.nextLine();
        System.out.println("Type the kind of the capsule: ");
        type = reader.next();
        System.out.println("Type the worker name: ");
        workerName = reader.next();
        System.out.println("Type the worker charge: ");
        workerCharge = reader.next();
        System.out.println("Type the lection to save: ");
        reader.next();
        lection = reader.nextLine(); 

        projectController.addCapsule(projectName, id, type, description, workerName, workerCharge, lection); 

        System.out.println("The capsule has been registed.");

    }
    
/**
 * This function registers a new project by taking input from the user for project name, client name,
 * expected start and end dates, and budget, and then adds the project to the project controller.
 */
    public void registProject() throws Exception{
        
        String projectName = "";
        String clientName = "";
        String expectedStartDateStr; 
        String expectedStartDateStageStr;
        String expectedEndDateStr;
        String realStartStageDateStr;
        double budget = 0.0;
        
        System.out.println("Type the name of the project: ");
        projectName = reader.next();
        System.out.println("Type the name of the client: ");
        clientName = reader.next();
        System.out.println("Type the expected start date");
        expectedStartDateStr = reader.next();
        Calendar expectedStartDate = stringsToCalendar(expectedStartDateStr);
        System.out.println("Type the expected end date");
        expectedEndDateStr = reader.next();
        Calendar expectedEndDate = stringsToCalendar(expectedEndDateStr);
        System.out.println("Type the budget of the project");
        budget = reader.nextDouble();

        projectController.addProject(projectName, clientName, expectedStartDate, expectedEndDate, budget);

    }

/**
 * This function registers stages for a project by taking input from the user for project name,
 * expected start date, and real start date.
 */
    public void registStages() throws Exception{

        String projectName = " ";
        String expectedStartDateStageStr = " ";
        String realStartStageDateStr = " ";

        System.out.println("Confirm the name of the project: ");
        projectName = reader.next();
        System.out.println("Now, please, type the expected start date for the first stage: ");
        expectedStartDateStageStr = reader.next();
        Calendar expectedStartDateStage = stringsToCalendar(expectedStartDateStageStr);

        System.out.println("Type the real start date for the first stage: ");
        realStartStageDateStr = reader.next();
        Calendar realStartDate = stringsToCalendar(realStartStageDateStr);

        projectController.initStages(projectName, expectedStartDateStage, realStartDate);

        System.out.println("The project has been registed succesfully.");
    }

/**
 * This function finishes the current stage of a project and initiates the next stage by taking input
 * from the user for project name, end date, and estimated amount of months for the next stage.
 */
    public void finishStage() throws Exception{

        String endDateStr = " ";
        int amountMonths = 0;
        String projectName = " ";

        System.out.println("Type the name of the project: ");
        projectName =reader.next();
        System.out.println("The current stage will be finished. Please, type today's date: ");
        endDateStr = reader.next();
        Calendar endDate = stringsToCalendar(endDateStr);
        System.out.println("Type the estimated amount of months for the next stage: ");
        amountMonths = reader.nextInt();

        projectController.finishStage(projectName, endDate, amountMonths);

        System.out.println("The current stage was finished succesfully. The next stage has been initiated.");

    }

/**
 * This function prompts the user to input information about a capsule to approve and then calls a
 * method to approve the capsule in a project.
 */
    public void approveCapsule() throws Exception{

        boolean newStatus = true;
        String capsuleId = " ";
        String approveDateStr = " ";
        String projectName = " ";

        System.out.println("Type the name of the project: ");
        projectName = reader.next();
        System.out.println("Please, type the id of the capsule to approve:  ");
        capsuleId = reader.next();
        System.out.println("Please, type today's date: ");
        approveDateStr = reader.next();
        Calendar approveDate = stringsToCalendar(approveDateStr);

        String msgConfirm = projectController.approveCapsule(projectName, capsuleId, approveDate, newStatus);

        System.out.println(msgConfirm);

    }

/**
 * This function prompts the user to input a project name and capsule ID, then calls a project
 * controller to publish the capsule and returns a URL.
 */
    public void publishCapsule(){

        boolean publishStatus = true;
        String capsuleId = " ";
        String projectName = " ";

        System.out.println("Please, type the name of the project: ");
        projectName = reader.next();
        System.out.println("Please, type the id of the capsule to publish: ");
        capsuleId = reader.next();
        

        String url = projectController.publishCapsule(projectName, capsuleId, publishStatus);

        System.out.println(url);
    }

/**
 * The function converts a string date in the format "dd/MM/yyyy" to a Calendar object.
 * 
 * @param date The date parameter is a string representing a date in the format "dd/MM/yyyy".
 * @return A Calendar object is being returned.
 */
    public Calendar stringsToCalendar(String date) throws Exception{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Calendar newDate = Calendar.getInstance();
        newDate.setTime(formatter.parse(date));

        return newDate; 
    }

}

