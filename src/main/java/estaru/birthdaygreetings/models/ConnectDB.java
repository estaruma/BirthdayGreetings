package estaru.birthdaygreetings.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:friends.db";

        String sql = "INSERT INTO friends(first_name, last_name, date_of_birth, email) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Sample data
            pstmt.setString(1, "John");
            pstmt.setString(2, "Doe");
            pstmt.setString(3, "1982-10-08");
            pstmt.setString(4, "john.doe@hotmail.com");
            pstmt.executeUpdate();

            pstmt.setString(1, "Mary");
            pstmt.setString(2, "Ann");
            pstmt.setString(3, "1975-09-11");
            pstmt.setString(4, "mary.ann@hotmail.com");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}