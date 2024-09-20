package estaru.birthdaygreetings;

import java.util.List;

public interface Reminder {
    void sendBirthdayMessage(Friend friend);
    void sendReminder(List<Friend> friends, Friend recipient);
}
