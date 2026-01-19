package src.service;

import src.model.Task;
import src.model.Status;

import java.util.ArrayList;
import java.util.Scanner;


public class TaskManager {


    private final ArrayList<Task> tasks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public int getTaskByIndex(int idNum){
        for(int taskIndex = 0; taskIndex < tasks.size(); taskIndex++ ){
            if (idNum  == tasks.get(taskIndex).getId()){
                return taskIndex;
            }
        }
        return -1;
    }

    public void viewTasks(){

        if (tasks.size() == 0){
            System.out.println("No task currently.");
            System.out.println();
            return;
            
        }

        int count = 1;
        for (Task task : tasks){
            int taskId = task.getId();
            String taskTitle = task.getTitle();
            Status taskStatus = task.getStatus();
            String output = String.format("Task no: %d | Id: %d | %s | %s", count, taskId, taskTitle, taskStatus);
            count++;
            System.out.println(output);
            System.out.println();
        }
    }

    public void showTaskDescription(){
        viewTasks();
        System.out.print("Type id number of the task to see the description: ");
        int idNum = scanner.nextInt();
        scanner.nextLine();

        int desIndex = getTaskByIndex(idNum);
        if (desIndex != -1){
            String taskDescription = tasks.get(desIndex).getDescription();
            System.out.println(taskDescription);
            System.out.println();
            viewTasks();

        }
        else{
            System.out.println("Task is not found!");
        }

    }


    public void addTasks(){
            
        System.out.print("Give title: ");

        String title = scanner.nextLine();
        System.out.print("Give Description: ");

        String description = scanner.nextLine();
        Task task = new Task (title, description);

        System.out.println();
        System.out.println(task.getTitle() + " is added with id " + task.getId());
        System.out.println();
        tasks.add(task);
        viewTasks();
    }



    public void deleteTask(){

        viewTasks();
        System.out.print("Type id number of the task to delete: ");
        int idNum = scanner.nextInt();
        scanner.nextLine();

        int removeIndex = getTaskByIndex(idNum);
        if (removeIndex != -1){
            System.out.println(tasks.get(removeIndex).getTitle() + " is deleted with id " + tasks.get(removeIndex).getId());
            tasks.remove(removeIndex);
            System.out.println();
            viewTasks();

        }
        else{
            System.out.println("Task is not found!");
        }
        

    }

    public void updateStatus(){
        
        viewTasks();
        System.out.print("Type id number of the task to change status: ");
        int idNum = scanner.nextInt();
        scanner.nextLine();


        int changeIndex = getTaskByIndex(idNum);

        if (changeIndex != -1){
        Task taskChangeStatus =  tasks.get(changeIndex);

        System.out.println("Choose an option to update status of task with id " + taskChangeStatus.getId());
        System.out.println("Status to Choose: \n" + 
            "1. PENDING\n" +
            "2. IN_PROGRESS\n" +
            "3. DONE");
        System.out.print("Enter option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option){
            case 1 :
                taskChangeStatus.setStatus(Status.PENDING);
                break;
            case 2 :
                taskChangeStatus.setStatus(Status.IN_PROGRESS);
                break;
            case 3 :
                taskChangeStatus.setStatus(Status.DONE);
                break;
            default :
                System.out.println("Invalid option");
                return;
        }
        System.out.println("Task with id " + taskChangeStatus.getId() + " status updated");
        viewTasks();
        }
        else{
            System.out.println("Task is not found!");
        }



    }
    
}
