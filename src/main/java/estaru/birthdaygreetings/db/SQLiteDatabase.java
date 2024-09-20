package estaru.birthdaygreetings.db;

import estaru.birthdaygreetings.Database;
import estaru.birthdaygreetings.Friend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDatabase implements Database {

        private Connection connection;

        private static final String URL = "jdbc:sqlite:friends.db";



        @Override
        public List<Friend> getFriends() {
            List<Friend> friends = new ArrayList<>();

            String query = "SELECT first_name, last_name, date_of_birth, email FROM friends";

            try (Connection conn = DriverManager.getConnection(URL);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    LocalDate dateOfBirth = LocalDate.parse(rs.getString("date_of_birth"));
                    String email = rs.getString("email");
                    friends.add(new Friend(firstName, lastName, dateOfBirth, email));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return friends;
        }



}
