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



        }while(choice != 11);
    }

/**
 * The function displays a menu with options for creating a project, finishing a project stage,
 * registering a capsule, approving a capsule, publishing a capsule, or exiting the program.
 */
    public void menu(){

        System.out.println("--------------------------------------------");
        System.out.println("GreenSQA Knowledge management.");
        System.out.println(" ");
        System.out.println("Please, choose an option: ");
        System.out.println(" ");
        System.out.println("1. Create a project.");
        System.out.println("2. Finish a project stage.");
        System.out.println("3. Regist a capsule.");
        System.out.println("4. Approve a capsule.");
        System.out.println("5. Public a capsule.");
        System.out.println("6. Get informed about the amount of capsules by type.");
        System.out.println("7. Get informed about the lections learned in an especific stage.");
        System.out.println("8. Get informed about which is the project with more capsules registered.");
        System.out.println("9. Get informed about if a worker has registered capsules.");
        System.out.println("10. Get informed about a learned lection according to its hashtags.");
        System.out.println("11. Exit.");
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
                setStartDates();
                setEndDates();

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

                showCapsulesByType();
                break;
            
            case 7:

                showCapsulesLection();
                break;

            case 8:

                searchProjectWithMoreCapsules();
                break;
            
            case 9:

                validateIfWokerHasRegisteredCapsules();
                break;
            
            case 10:

                searchLectionsByKeyword();
                break;

            case 11:

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
        String hashtags = " ";
        int type = 0;
        String projectName = " ";
         
        System.out.println("Type the name of the project.");
        projectName = reader.next();
        System.out.println("Type the capsule id: "); 
        id = reader.next(); 
        System.out.println("Type a short description: ");
        reader.next(); 
        description = reader.nextLine();
        System.out.println("Enter the option of the type of capsule to regist : ");
        System.out.println("1. Technical capsule.");
        System.out.println("2. Management capsule.");
        System.out.println("3. Domain capsule.");
        System.out.println("4. Experiences capsule.");
        type = reader.nextInt();
        System.out.println("Type the worker name: ");
        workerName = reader.next();
        System.out.println("Type the worker charge: ");
        workerCharge = reader.next();
        System.out.println("Type the lection to save: ");
        reader.next();
        lection = reader.nextLine();
        System.out.println("Type the hashtags asociated: ");
        reader.next();
        hashtags = reader.nextLine(); 

        String confirmMessage = projectController.addCapsule(projectName, type, id, description, workerName, workerCharge, lection, hashtags); 


        System.out.println(confirmMessage);

    }
    
/**
 * This function registers a new project by taking input from the user for project name, client name,
 * expected start and end dates, and budget, and then adds the project to the project controller.
 */
    public void registProject() throws Exception{
        
        String confirmMsg = " ";
        String projectName = "";
        String clientName = "";
        String expectedStartDateStr; 
        String expectedEndDateStr;

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

        confirmMsg = projectController.addProject(projectName, clientName, expectedStartDate, expectedEndDate, budget);
        System.out.println(confirmMsg);
    }

/**
 * This function registers stages for a project by taking input from the user for project name,
 * expected start date, and real start date.
 */
    public void registStages() throws Exception{

        String confirmMsg = " ";
        String projectName = " ";
        String expectedStartDateStageStr = " ";
        String realStartStageDateStr = " ";
        int firstStageMonths = 0;

        System.out.println("Confirm the name of the project: ");
        projectName = reader.next();
        System.out.println("Now, please, type the expected start date for the first stage: ");
        expectedStartDateStageStr = reader.next();
        System.out.println("Type the real start date for the first stage: ");
        realStartStageDateStr = reader.next();
        System.out.println("Type the amount of months for the first stage:");
        firstStageMonths = reader.nextInt();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar expectedStartDateStage = Calendar.getInstance();
        expectedStartDateStage.setTime(format.parse(expectedStartDateStageStr));
        Calendar realStartDate = Calendar.getInstance();
        realStartDate.setTime(format.parse(realStartStageDateStr));

        confirmMsg = projectController.initStages(projectName, expectedStartDateStage, realStartDate, firstStageMonths);

        System.out.println(confirmMsg);
    }


 /**
  * This function prompts the user to input the name of a project and the current date, then uses
  * a project controller to finish the current stage of the project and outputs a confirmation message.
  */
    public void finishStage() throws Exception{

        String confirmMsg = " ";
        String endDateStr = " ";
        String projectName = " ";

        System.out.println("Type the name of the project: ");
        projectName =reader.next();
        System.out.println("The current stage will be finished. Please, type today's date: ");
        endDateStr = reader.next();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(format.parse(endDateStr));

        confirmMsg = projectController.finishStage(projectName, endDate);

        System.out.println(confirmMsg);

    }

/**
 * This function sets the start dates for a project based on user input of the project name.
 */
    public void setStartDates(){

        String projectName = " ";
    
        System.out.println("For the next two steps, the user has to confirm the project name twice: ");
        projectName = reader.next();
        projectController.setStartDates(projectName);
    }

/**
 * This function sets the end dates for a project based on user input for the project name and the
 * number of months required to complete the next stage.
 */
    public void setEndDates(){

        String projectName = " ";
        int monthsToAdd = 0;

        System.out.println("Confirm the project name once again: ");
        projectName = reader.next();
        System.out.println("Type the amount of months required to complete the next stage: ");
        monthsToAdd = reader.nextInt();

        projectController.setEndDates(projectName, monthsToAdd);
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
 * This function prints out information about capsules grouped by their type.
 */
    public void showCapsulesByType(){
        
        String inform = projectController.showCapsulesByType();

        System.out.println(inform);
    }

/**
 * This function prompts the user to input a project name and stage, then calls a method to retrieve
 * and display the lections associated with that project and stage.
 */
    public void showCapsulesLection(){
        
        String projectName = " ";
        int stage = 0;

        System.out.println("Enter the name of the project: ");
        projectName = reader.next();
        System.out.println("Choose the stage of the project: ");
        System.out.println("0. Start stage.");
        System.out.println("1. Analyt stage.");
        System.out.println("2. Design stage.");
        System.out.println("3. Execut stage. ");
        System.out.println("4. Close stage.");
        System.out.println("5. Follow and control stage.");
        stage = reader.nextInt();

        String inform = projectController.showCapsulesLections(projectName, stage);
        System.out.println("The lections are: " + inform);
    }

/**
 * This function searches for a project with the highest number of capsules and prints the result.
 */
    public void searchProjectWithMoreCapsules(){

        String inform = projectController.searchProjectWithMoreCapsules();

        System.out.println(inform);
    }

/**
 * This function ask the user to input a worker's name and then calls a method to search for
 * capsules associated with that worker.
 */
    public void validateIfWokerHasRegisteredCapsules(){
        String workerName = " ";

        System.out.println("Type the name of the worker: ");
        workerName = reader.next();

        String inform = projectController.searchCapsulesByWorker(workerName);

        System.out.println(inform);

    }

/**
 * This function prompts the user to input a hashtag and then calls a method to search for
 * lectures that contain that hashtag.
 */
    public void searchLectionsByKeyword(){

        String hashtag = " ";

    
        System.out.println("Type the hashtag to search: ");
        hashtag = reader.next();

        System.out.println(projectController.searchLectionByHashtag(hashtag));
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

