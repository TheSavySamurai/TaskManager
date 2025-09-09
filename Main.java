package src.com.Dillon; // Your package

// Correct imports
import java.util.Scanner;
import java.util.List;

public class Main { // Class names should start with a capital letter (convention)
    public static void main(String[] args) {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        
        // CRITICAL FIX: Create the TaskManager ONCE, outside the loop.
        TaskManager taskManager = new TaskManager();
        
        while(running) {
            System.out.println("\n--- TaskMaster Menu ---");
            System.out.println("1) View Tasks");
            System.out.println("2) Add Task");
            System.out.println("3) Remove Task");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            // The switch statement now uses the SAME taskManager object every time.
            switch(choice) {
                case 1: // View tasks
                    System.out.println("\nViewing Tasks:");
                    List<Task> tasks = taskManager.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("Your task list is empty.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                    }
                    break;
                    
                case 2: // Add task
                    System.out.print("Enter task description: ");
                    scanner.nextLine(); // Clear the input buffer
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    System.out.println("Task added successfully!");
                    break;
                    
                case 3: // Remove task
                    // First, show the user what tasks they can remove
                    List<Task> tasksToRemove = taskManager.getAllTasks();
                    if (tasksToRemove.isEmpty()) {
                        System.out.println("No tasks to remove.");
                    } else {
                        System.out.println("\nWhich task would you like to remove?");
                        for (Task task : tasksToRemove) {
                            System.out.println(task);
                        }
                        System.out.print("Enter the task ID to remove: ");
                        int idToRemove = scanner.nextInt();
                        // Call the method to delete the task and check if it worked
                        boolean wasRemoved = taskManager.deleteTask(idToRemove);
                        if (wasRemoved) {
                            System.out.println("Task removed successfully.");
                        } else {
                            System.out.println("Error: Could not find a task with ID " + idToRemove);
                        }
                    }
                    break;
                    
                case 4: // Exit
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
        scanner.close();
    }
}