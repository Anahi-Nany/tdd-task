package edu.uaslp.objetos.taskslist;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String s){
        super(s);
    }
}
