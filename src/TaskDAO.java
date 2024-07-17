
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    //  insertar una tarea
    public void insertTask(Task task) {
        String query = "INSERT INTO tasks (title, description, status, due_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus());
            stmt.setDate(4, new java.sql.Date(task.getDueDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // obtener todas las tareas
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Task task = new Task(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getDate("due_date")
                );
                task.setId(rs.getInt("id"));
                tasks.add(task);
            }
        } catch (SQLException e) {
        }
        return tasks;
    }

    // actualizar una tarea
    public void updateTask(Task task) {
        String query = "UPDATE tasks SET title = ?, description = ?, status = ?, due_date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus());
            stmt.setDate(4, new java.sql.Date(task.getDueDate().getTime()));
            stmt.setInt(5, task.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    //eliminar una tarea
    public void deleteTask(int id) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
}

