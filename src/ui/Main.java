package ui;
import model.CapsuleManage;
import model.ProjectManage;
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
            view.executeChoice();



        }while(choice != 6);
    }

    public void menu(){

        System.out.println("--------------------------------------------");
        System.out.println("Hello there!");
        System.out.println(" ")
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


                break;

            case 2:


                break;
            
            case 3:
                
                System.out.println("You choosed regist a capsule.")
                System.out.println(" ");
                initCapsule();

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

    public void initCapsule(){

        String id = ""; 
        String description = "";
        String workerName = "";
        String workerCharge = "";
        String lection = "";
         

        System.out.println("Type the capsule id: "); 
        id = reader.next(); 
        System.out.println("Type a short description: "); 
        description = reader.nextLine();
        System.out.println("Type the worker name: ");
        workerName = reader.nextLine();
        System.out.println("Type the worker charge: ");
        workerCharge = reader.next();
        System.out.println("Type the lection to save: ");
        lection = reader.nextLine(); 

        capsuleController.initCapsule(id, description, workerName, workerCharge, lection); 


    }
 
}