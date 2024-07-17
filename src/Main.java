import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();

        // Insertar una nueva tarea
        Task newTask = new Task("Learn Java", "Complete the JDBC tutorial", "Pending", new Date());
        taskDAO.insertTask(newTask);
        System.out.println("Task inserted!");

        // Obtener y mostrar todas las tareas
        List<Task> tasks = taskDAO.getAllTasks();
        System.out.println("All Tasks:");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId() + ", Title: " + task.getTitle() + ", Description: " + task.getDescription() + ", Status: " + task.getStatus() + ", Due Date: " + task.getDueDate());
        }

        // Actualizar una tarea
        if (!tasks.isEmpty()) {
            Task taskToUpdate = tasks.get(0);
            taskToUpdate.setStatus("Completed");
            taskDAO.updateTask(taskToUpdate);
            System.out.println("Task updated!");

            // Mostrar todas las tareas después de la actualización
            tasks = taskDAO.getAllTasks();
            System.out.println("All Tasks After Update:");
            for (Task task : tasks) {
                System.out.println("ID: " + task.getId() + ", Title: " + task.getTitle() + ", Description: " + task.getDescription() + ", Status: " + task.getStatus() + ", Due Date: " + task.getDueDate());
            }
        }

        // Eliminar una tarea
        if (!tasks.isEmpty()) {
            Task taskToDelete = tasks.get(0);
            taskDAO.deleteTask(taskToDelete.getId());
            System.out.println("Task deleted!");

            // Mostrar todas las tareas después de la eliminación
            tasks = taskDAO.getAllTasks();
            System.out.println("All Tasks After Deletion:");
            for (Task task : tasks) {
                System.out.println("ID: " + task.getId() + ", Title: " + task.getTitle() + ", Description: " + task.getDescription() + ", Status: " + task.getStatus() + ", Due Date: " + task.getDueDate());
            }
        }
    }
}
