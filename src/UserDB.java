import java.util.Collection;
import java.util.HashMap;

public class UserDB implements DB<String, User> {
    private HashMap<String, User> users;

    public UserDB() {
        users = new HashMap<String, User>();
    }

    public User addValue(User user) {
        if(users.get(user) != null){
            return users.put(user.getUsername(), user);
        } else{
            users.put(user.getUsername(), user);
        }
        return null;
    }

    public Collection<User> getAllValues() {
        return users.values();
    }

    public User getValue(String username) {
        return users.get(username);
    }

    public boolean haskey(String username) {
        return users.containsKey(username);
    }
}
