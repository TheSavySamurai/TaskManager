package src.com.Dillon;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    
    private Map<Integer, Task> taskMap;
    private int nextId;

    public TaskManager() {
        this.taskMap = new HashMap<>();
        this.nextId=1;
    }
    public Task getTask(int id){
        return taskMap.get(id);
    }
    public void addTask(String description){
        Task newTask = new Task(nextId, description);
        taskMap.put(nextId,newTask);
        nextId++;
    }
    public List<Task> getAllTasks(){
        return new ArrayList<>(taskMap.values());
    }
    public void markTaskCompleted(int id){
        Task taskToUpdate = taskMap.get(id);
        if(taskToUpdate != null){
            taskToUpdate.setCompleted(true);
        }
    }
    public boolean deleteTask(int id){
        if(taskMap.containsKey(id)){
            taskMap.remove(id);
            return true;
        }
        return false;
    }
}
