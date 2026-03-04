package edu.ucalgary.oop;

import java.util.Objects;

public class Task {
    private String id;
    private String title;
    private boolean isCompleted = false;

    public Task(String id,String title){
        this.id = id;
        this.title = title;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
               Objects.equals(title, task.title) &&
               isCompleted == task.isCompleted; 
    }
    public Task copy(Task task){
        return(new Task(this.id,this.title));
    }
    public boolean getIsCompleted(){
        return this.isCompleted;
    }
    public String getTitle(){
        return this.title;
    }
    public String getId(){
        return this.id;
    }
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setId(String id){
        this.id = id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }
}
