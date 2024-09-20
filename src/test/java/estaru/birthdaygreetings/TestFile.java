package estaru.birthdaygreetings;

import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


class TestFile {
    @Test
    public void testIsBirthdayOnSameDay() {
        Friend friend = new Friend("John", "Doe", LocalDate.of(1985, 5, 5), "john.doe@hotmail.com");
        LocalDate today = LocalDate.of(2022, 5, 5);
        assertTrue(friend.isBirthday(today));
    }

    @Test
    public void testIsBirthdayLeapYear() {
        Friend leapYearFriend = new Friend("Leap", "Year", LocalDate.of(1992, 2, 29), "leap.year@gmail.com");
        assertTrue(leapYearFriend.isBirthday(LocalDate.of(2023, 2, 28))); // non-leap year
        assertFalse(leapYearFriend.isBirthday(LocalDate.of(2023, 2, 27)));
        assertTrue(leapYearFriend.isBirthday(LocalDate.of(2024, 2, 29))); // leap year
    }
    @Test
    public void testSendBirthdayMessage() {
        Friend friend = new Friend("John", "Doe", LocalDate.of(1982, 10, 8), "john.doe@hotmail.com");
        SendBirthdayNote birthdayNote = Mockito.spy(new SendBirthdayNote());

        birthdayNote.sendBirthdayMessage(friend);

        verify(birthdayNote).sendEmail(
                eq("john.doe@hotmail.com"),
                eq("Happy birthday"),
                eq("Happy birthday, dear John")
        );
    }
    @Test
    public void testSendReminder() {
        Friend friend1 = new Friend("John", "Doe", LocalDate.of(1982, 10, 8), "john.doe@hotmail.com");
        Friend friend2 = new Friend("Mary", "Ann", LocalDate.of(1975, 9, 11), "mary.ann@hotmail.com");
        Friend recipient = new Friend("Edurne", "Olvido", LocalDate.of(1991, 10, 2), "edurne.olvido@hotmail.com");

        SendBirthdayNote birthdayNote = Mockito.spy(new SendBirthdayNote());

        birthdayNote.sendReminder(Arrays.asList(friend1, friend2), recipient);

        Mockito.verify(birthdayNote).sendEmail(
                eq("edurne.olvido@hotmail.com"),
                eq("Birthday Reminder"),
                contains("John Doe, Mary Ann")
        );
    }

}
