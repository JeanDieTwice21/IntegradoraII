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

    public static void main(String[] args) throws Exception{

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

    public void executeChoice(int choice) throws Exception{
        
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

        System.out.println("Now, please, type the expected start date for the first stage: ");
        expectedStartDateStageStr = reader.next();
        Calendar expectedStartDateStage = stringsToCalendar(expectedStartDateStageStr);

        System.out.println("Type the real start date for the first stage: ");
        realStartStageDateStr = reader.next();
        Calendar realStartDate = stringsToCalendar(realStartStageDateStr);

        projectController.initStages(projectName, expectedStartDateStage, realStartDate);

        System.out.println("The project has been registed succesfully.");

    }

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

    public void approveCapsule() throws Exception{

        boolean newStatus = true;
        String capsuleId = " ";
        String publishDateStr = " ";
        String projectName = " ";

        System.out.println("Type the name of the project: ");
        projectName = reader.next();
        System.out.println("Please, type the id of the capsule to approve:  ");
        capsuleId = reader.next();
        System.out.println("Please, type today's date: ");
        publishDateStr = reader.next();
        Calendar publishDate = stringsToCalendar(publishDateStr);

        String msgConfirm = projectController.approveCapsule(projectName, capsuleId, publishDate, newStatus);

        System.out.println(msgConfirm);

    }

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

    public Calendar stringsToCalendar(String date) throws Exception{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Calendar newDate = Calendar.getInstance();
        newDate.setTime(formatter.parse(date));

        return newDate; 
    }

}

