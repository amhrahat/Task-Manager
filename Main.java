import java.util.Scanner;



import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();

        while(true){
            System.out.print("Welcome to Task Managemet\n" +
            "1. View Tasks\n" +
            "2. Show Task Description\n" +
            "3. Add Task\n" +
            "4. Delete Task\n" +
            "5. Change Task Status\n" + 
            "6. Exit\n" +
            "Enter an option: ");

            int num = scanner.nextInt();
            scanner.nextLine();

            switch(num){

                case 1 :  
                    viewTasks(tasks);
                    break;

                case 2 :
                    showTaskDescription(scanner, tasks);
                    break;
                case 3 :
                    addTasks(scanner, tasks);
                    break;

                case 4 :
                    deleteTask(scanner, tasks);
                    break;

                case 5 :
                    updateStatus(scanner, tasks);
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

    static int getTaskByIndex(ArrayList<Task> tasks, int idNum){
        for(int taskIndex = 0; taskIndex < tasks.size(); taskIndex++ ){
            if (idNum  == tasks.get(taskIndex).getId()){
                return taskIndex;
            }
        }
        return -1;
    }

    static void viewTasks(ArrayList<Task> tasks){

        if (tasks.size() == 0){
            System.out.println("No task currently");
            return;
            
        }

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

    static void showTaskDescription(Scanner scanner, ArrayList<Task> tasks){
        
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
        scanner.nextLine();

        int removeIndex = getTaskByIndex(tasks, idNum);
        if (removeIndex != -1){
            System.out.println(tasks.get(removeIndex).getTitle() + " is deleted with id " + tasks.get(removeIndex).getId());
            tasks.remove(removeIndex);
            viewTasks(tasks);

        }
        else{
            System.out.println("Task is not found!");
        }
        

    }

    static void updateStatus(Scanner scanner, ArrayList<Task> tasks){
        
        viewTasks(tasks);
        System.out.print("Type id number of the task to change status: ");
        int idNum = scanner.nextInt();
        scanner.nextLine();


        int changeIndex = getTaskByIndex(tasks, idNum);

        if (changeIndex != -1){
        Task taskChangeStatus =  tasks.get(changeIndex);

        System.out.println("Enter an option to update status of task with id " + taskChangeStatus.getId());
        System.out.println("Status to Choose: \n" + 
            "1. PENDING\n" +
            "2. IN_PROGRESS\n" +
            "3. DONE");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option){
            case 1 :
                taskChangeStatus.setStatus(Task.Status.PENDING);
                break;
            case 2 :
                taskChangeStatus.setStatus(Task.Status.IN_PROGRESS);
                break;
            case 3 :
                taskChangeStatus.setStatus(Task.Status.DONE);
                break;
            default :
                System.out.println("Invalid option");
                return;
        }
        System.out.println("Task with id " + taskChangeStatus.getId() + " status updated");
        viewTasks(tasks);
        }
        else{
            System.out.println("Task is not found!");
        }



    }
}
