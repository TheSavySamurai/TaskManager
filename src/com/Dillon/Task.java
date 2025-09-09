package src.com.Dillon;

public class Task {
    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    @Override
    public String toString() {
        // Format: [ID] Description (Status)
        String status = isCompleted() ? "DONE" : "TODO";
        return "[" + id + "] " + description + " (" + status + ")";
    }
}
