package edu.uaslp.objetos.taskslist;

import java.util.*;

public class TaskList {
    LinkedList<Task> taskLinkedList = new LinkedList<>();

    public TaskList(){

    }

    public int getSize(){
        return taskLinkedList.size();
    }

    public void add(Task task){
        taskLinkedList.add(task);
    }
    public void remove(Task task){
        taskLinkedList.remove(task);
    }
    public Task find(String taskName) throws TaskNotFoundException{
        for(int i=0;i<taskLinkedList.size();i++){
            if(taskName == taskLinkedList.get(i).getTitle())
                return taskLinkedList.get(i);
        }
        throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");
    }

    public void markAsDone (String task){
        Task taskf=find(task);
        taskf.setDone(true);
    }
    public void markAsNotDone (String task){
        Task taskf=find(task);
        taskf.setDone(false);
    }

    public Task getNextTask(){
        String title = taskLinkedList.element().getTitle();

        int size = taskLinkedList.size();
        int i;
        for (i = 0; size > i && !Objects.equals(title, taskLinkedList.get(i).getTitle()); i++);

        return taskLinkedList.get(i+1);
    }

    public List<Task> getNextTasks(){
        List<Task> taskList = new LinkedList<>();

        int size = this.taskLinkedList.size();
        for (Task task : this.taskLinkedList) {
            if (!task.isDone()) {
                taskList.add(task);
            }
        }
        taskList.sort(Comparator.comparing(Task::getDueDate));

        return taskList;
    }
}
