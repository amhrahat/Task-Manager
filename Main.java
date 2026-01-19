import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("Welcome to Task Managemet\n" +
            "1. View Tasks\n" +
            "2. Add Task\n" +
            "3. Enter Task To Update/Delete\n" +
            "4. Exit\n" +
            "Enter an option: ");
            int num = input.nextInt();
            input.nextLine();
            switch(num){
                case 1 : 


                case 2 :
                System.out.print("Give title: ");
                String title = input.nextLine();

                System.out.print("Give Description: ");
                String description = input.nextLine();

                Task task = new Task (title, description);
                System.out.println(task.getTitle() + " is added with id " + task.getId());
                System.out.println();

            }
        }
    
}
    
}
