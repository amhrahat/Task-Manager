import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();

        while(true){
            System.out.print("Welcome to Task Managemet\n" +
            "1. View Tasks\n" +
            "2. Add Task\n" +
            "3. Delete Task\n" +
            "4. Exit\n" +
            "Enter an option: ");
            System.out.println();

            int num = scanner.nextInt();
            scanner.nextLine();

            switch(num){

                case 1 :  
                    viewTasks(tasks);
                    break;


                case 2 :
                    addTasks(scanner, tasks);
                    break;

                case 3 :
                    deleteTask(scanner, tasks);
                    break;

            }
    
        }
    }

    static void viewTasks(ArrayList<Task> tasks){

        int count = 1;
        for (Task task : tasks){
            int taskId = task.getId();
            String taskTitle = task.getTitle();
            Task.Status taskStatus = task.getStatus();
            String output = String.format("Task no: %d | Id: %d | %s | %s", count, taskId, taskTitle, taskStatus);
            count++;
            System.out.println(output);
            System.out.println();
        }
    }

    static void addTasks(Scanner scanner, ArrayList<Task> tasks){
            
        System.out.print("Give title: ");

        String title = scanner.nextLine();
        System.out.print("Give Description: ");

        String description = scanner.nextLine();
        Task task = new Task (title, description);

        System.out.println();
        System.out.println(task.getTitle() + " is added with id " + task.getId());
        System.out.println();
        tasks.add(task);
    }

    static void deleteTask(Scanner scanner, ArrayList<Task> tasks){

        viewTasks(tasks);
        System.out.print("Type id number of the task to delete: ");
        int idNum = scanner.nextInt();

        int removeIndex = -1;
        for(int taskIndex = 0; taskIndex < tasks.size(); taskIndex++ ){
            if (idNum  == tasks.get(taskIndex).getId()){
                removeIndex = taskIndex;
            }
        }
        if (removeIndex != -1){
            System.out.println(tasks.get(removeIndex).getTitle() + " is deleted with id " + tasks.get(removeIndex).getId());
            tasks.remove(removeIndex);

        }
        else{
            System.out.println("Task is not found!");
        }
        

    }
}
