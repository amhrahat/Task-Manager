public class Task {

    static int taskId = 1;

    private int id;
    private String title;
    private String description;

    static int getTaskId(){
        return Task.taskId;
    }



    Task(String tittle, String description){
        this.id = taskId++;
        this.title = tittle;
        this.description = description;
        
    }

    int getId(){
        return this.id;
    }

    String getTitle(){
        return this.title;
    }
    
}
