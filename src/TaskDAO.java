import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/TaskManagerDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Caro#03-05-2005";

    public TaskDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
    }

    public void addTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, status, due_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getStatus());
            statement.setDate(4, Date.valueOf(task.getDueDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                LocalDate dueDate = resultSet.getDate("due_date").toLocalDate();
                Task task = new Task(id, title, description, status, dueDate);
                tasks.add(task);
            }
        } catch (SQLException e) {
        }
        return tasks;
    }

    public void updateTask(Task task) {
        String sql = "UPDATE tasks SET title = ?, description = ?, status = ?, due_date = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getStatus());
            statement.setDate(4, Date.valueOf(task.getDueDate()));
            statement.setInt(5, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
