package estaru.birthdaygreetings.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:friends.db";

        String sql = "CREATE TABLE IF NOT EXISTS friends (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " first_name TEXT NOT NULL,\n"
                + " last_name TEXT NOT NULL,\n"
                + " date_of_birth TEXT NOT NULL,\n"
                + " email TEXT NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
