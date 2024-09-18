package estaru.birthdaygreetings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFile implements Database {

    //Imagine you have a flat file with all your friends
    // the way you retrieve the friends data (for instance, try switching to a SQLite Db)
    @Override
    public List<Friend> getFriends() {
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("John", "Doe", LocalDate.of(1982, 10, 8), "johuna.sommere@hotmail.com"));
        friends.add(new Friend("Mary", "Ann", LocalDate.of(1975, 9, 11), "daphne.odarnat@hotmail.com"));
        friends.add(new Friend("Leap", "Year", LocalDate.of(1991, 10, 2), "edurne.olvido@hotmail.com"));
        return friends;
    }
}

