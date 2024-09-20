package estaru.birthdaygreetings;

import estaru.birthdaygreetings.db.SQLiteDatabase;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Database database = new SQLiteDatabase();


        List<Friend> friends = database.getFriends();

        SendBirthdayNote birthdayMessages = new SendBirthdayNote();
        LocalDate today = LocalDate.now();

        for (Friend friend : friends) {
            if (friend.isBirthday(today)) {
                birthdayMessages.sendBirthdayMessage(friend);
            }
        }
    }
}
