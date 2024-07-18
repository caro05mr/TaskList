import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una acción:");
            System.out.println("1. Crear una nueva tarea");
            System.out.println("2. Consultar todas las tareas");
            System.out.println("3. Actualizar una tarea");
            System.out.println("4. Eliminar una tarea");
            System.out.println("5. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el título de la tarea:");
                    String title = scanner.nextLine();
                    System.out.println("descripción de la tarea:");
                    String description = scanner.nextLine();
                    System.out.println("estado de la tarea:");
                    String status = scanner.nextLine();
                    System.out.println("Ingrese la fecha de vencimiento de la tarea (YYYY-MM-DD):");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());

                    Task newTask = new Task(title, description, status, dueDate);
                    taskDAO.addTask(newTask);
                    System.out.println("¡Tarea insertada!");
                    break;

                case 2:
                    List<Task> tasks = taskDAO.getAllTasks();
                    System.out.println("Todas las tareas:");
                    for (Task task : tasks) {
                        System.out.println(task);
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el ID de la tarea a actualizar:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Ingrese el nuevo título de la tarea:");
                    String updateTitle = scanner.nextLine();
                    System.out.println("nueva descripción de la tarea:");
                    String updateDescription = scanner.nextLine();
                    System.out.println("nuevo estado de la tarea:");
                    String updateStatus = scanner.nextLine();
                    System.out.println("Ingrese la nueva fecha de vencimiento de la tarea (YYYY-MM-DD):");
                    LocalDate updateDueDate = LocalDate.parse(scanner.nextLine());

                    Task updatedTask = new Task(updateId, updateTitle, updateDescription, updateStatus, updateDueDate);
                    taskDAO.updateTask(updatedTask);
                    System.out.println("¡Tarea actualizada!");
                    break;

                case 4:
                    System.out.println("Ingrese el ID de la tarea a eliminar:");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); 

                    taskDAO.deleteTask(deleteId);
                    System.out.println("¡Tarea eliminada!");
                    break;

                case 5:
                    System.out.println("¡Saliendo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}

