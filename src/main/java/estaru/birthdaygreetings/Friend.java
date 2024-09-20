package estaru.birthdaygreetings;

import java.time.LocalDate;

public class Friend {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    private String email;

    public Friend(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }


    public boolean isBirthday(LocalDate today) {
        if (dateOfBirth.getMonthValue() == 2 && dateOfBirth.getDayOfMonth() == 2 && !today.isLeapYear()) {
            return today.getMonthValue() == 2 && today.getDayOfMonth() == 28;
        }
        return dateOfBirth.getMonthValue() == today.getMonthValue() && dateOfBirth.getDayOfMonth() == today.getDayOfMonth();
    }

}
