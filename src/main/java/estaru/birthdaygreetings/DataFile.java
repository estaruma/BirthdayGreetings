package estaru.birthdaygreetings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFile implements Database {

    @Override
    public List<Friend> getFriends() {
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Juhana", "Sommer", LocalDate.of(1988, 9, 24), "johuna.sommere@hotmail.com"));
        friends.add(new Friend("Daphne", "Odarnat", LocalDate.of(1986, 3, 26), "daphne.odarnat@hotmail.com"));
        friends.add(new Friend("Leap", "Year", LocalDate.of(1991, 10, 2), "edurne.olvido@hotmail.com"));
        return friends;
    }
}

