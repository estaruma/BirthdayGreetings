package estaru.birthdaygreetings;

import java.time.LocalDate;
import java.util.List;

public class SendBirthdayNote implements Reminder {
    @Override
    public void sendBirthdayMessage(Friend friend) {
        String subject = "Happy birthday";
        String message = "Happy birthday, dear " + friend.getFirstName();

        sendEmail(friend.getEmail(), subject, message);

    }
    protected void sendEmail(String email, String subject, String message) {
        System.out.println(email);
        System.out.println(subject);
        System.out.println(message);
        }

    @Override
    public void sendReminder(List<Friend> birthdayFriends, Friend recipient) {
        if (birthdayFriends.isEmpty()) {
            return;
        }
        String subject = "Birthday Reminder";
        StringBuilder message = new StringBuilder(recipient.getFirstName() + ",\n\nToday is ");
        for (int i = 0; i < birthdayFriends.size(); i++) {
            Friend bdayFriend = birthdayFriends.get(i);
            message.append(bdayFriend.getFirstName()).append(" ").append(bdayFriend.getLastName());
            if (i < birthdayFriends.size() - 1) {
                message.append(", ");
            }
        }
        message.append("'s birthday.\nDon't forget to send them a message!");
        sendEmail(recipient.getEmail(), subject, message.toString());
    }

    public boolean isBirthday(LocalDate today) {
        if (today.getMonthValue() == 2 && today.getDayOfMonth() == 29 && !today.isLeapYear()) {
            return today.getMonthValue() == 2 && today.getDayOfMonth() == 28;
        }
        return today.getMonthValue() == today.getMonthValue() && today.getDayOfMonth() == today.getDayOfMonth();
    }


}
