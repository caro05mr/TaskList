import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;

    // Constructor para crear una nueva tarea (sin ID)
    public Task(String title, String description, String status, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    // Constructor para tareas existentes (con ID)
    public Task(int id, String title, String description, String status, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Description: " + description + ", Status: " + status + ", Due Date: " + dueDate;
    }
}


