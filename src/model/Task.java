package src.model;
public class Task {



    static int taskId = 1;

    private int id;
    private String title;
    private String description;
    private Status status;

    static int getTaskId(){
        return Task.taskId;
    }



    public Task(String tittle, String description){
        this.id = taskId++;
        this.title = tittle;
        this.description = description;
        this.status = Status.PENDING;
        
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public Status getStatus(){
        return this.status;
    }
    
    public void setStatus(Status updatedStatus){
        this.status = updatedStatus;

    }
}
