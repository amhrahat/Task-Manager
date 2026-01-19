package src.app;

import src.service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while(true){
            System.out.print("Welcome to Task Managemet\n" +
            "1. View Tasks\n" +
            "2. Add Task\n" +
            "3. Show Task Description\n" +
            "4. Delete Task\n" +
            "5. Change Task Status\n" + 
            "6. Exit\n" +
            "Enter an option: ");

            int num = scanner.nextInt();
            scanner.nextLine();

            switch(num){

                case 1 :  
                    taskManager.viewTasks();
                    break;

                case 2 :
                    taskManager.addTasks();
                    break;

                case 3 :
                    taskManager.showTaskDescription();
                    break;

                case 4 :
                    taskManager.deleteTask();
                    break;

                case 5 :
                    taskManager.updateStatus();
                    break;

                case 6 :
                    System.out.println("Existing..");
                    scanner.close();
                    return;

                default :
                    System.out.println("Invalid option");
                    return;
            }
    
        }
    }


}
