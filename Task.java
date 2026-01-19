public class Task {

    enum Status{
        PENDING,
        IN_PROGRESS,
        DONE
    }

    static int taskId = 1;

    private int id;
    private String title;
    private String description;
    private Status status;

    static int getTaskId(){
        return Task.taskId;
    }



    Task(String tittle, String description){
        this.id = taskId++;
        this.title = tittle;
        this.description = description;
        this.status = Status.PENDING;
        
    }

    int getId(){
        return this.id;
    }

    String getTitle(){
        return this.title;
    }

    Status getStatus(){
        return this.status;
    }
    
    
}
