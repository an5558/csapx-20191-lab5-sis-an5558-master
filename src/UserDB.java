import java.util.Collection;
import java.util.HashMap;

public class UserDB implements DB<String, User> {
    private HashMap<String, User> users;

    public UserDB() {

    }

    public User addValue(User user) {
        return null;
    }

    public Collection<User> getAllValues() {
        return null;
    }

    public User getValue(String username) {
        return null;
    }

    public boolean haskey(String username) {
        return false;
    }
}
