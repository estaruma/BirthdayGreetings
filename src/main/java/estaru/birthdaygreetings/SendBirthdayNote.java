package estaru.birthdaygreetings;

import java.util.List;

public class SendBirthdayNote implements Reminder {
    @Override
    public void sendBirthdayMessage(Friend friend) {
        System.out.println(friend.getEmail());
    }

    @Override
    public void sendReminder(List<Friend> birthday, Friend recipient) {
        System.out.println(recipient.getEmail());

    }
}
