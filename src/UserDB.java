import java.util.Collection;
import java.util.HashMap;

/**
 * Storage of all users where the key is the unique username and the value is the
 * associated User object.
 */

public class UserDB implements DB<String, User> {
    /** user storage */
    private HashMap<String, User> users;

    /**
     * Create the user database.
     */
    public UserDB() {
        users = new HashMap<String, User>();
    }

    /**
     * Add a value entry to the database in constant time. The database will determine the key
     * based on the value type.
     * @param user the value to add
     * @return the previous value associated with the key, otherwise null
     */
    public User addValue(User user) {
        if(users.get(user) != null){
            return users.put(user.getUsername(), user);
        } else{
            users.put(user.getUsername(), user);
        }
        return null;
    }

    /**
     * Get all the values in the database in linear time.
     * @return all values
     */
    public Collection<User> getAllValues() {
        return users.values();
    }

    /**
     * Get the value for an associated key in constant time.
     * @param username the key
     * @return the value that is associated with the key, or null if not present
     */
    public User getValue(String username) {
        return users.get(username);
    }

    /**
     * Indicates whether a key is in the database or not, in constant time.
     * @param username the key to search for
     * @return whether the key is present or not
     */
    public boolean haskey(String username) {
        return users.containsKey(username);
    }
}
