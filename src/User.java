import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class User implements Comparable<User> {
    private TreeSet<Course> courses;
    private User.UserType type;
    private String username;

    public User(String username, User.UserType type, Comparator<Course> comp) {

    }

    public boolean addCourse(Course course) {
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    public Collection<Course> getCourses() {
        return null;
    }

    public String getUsername() {
        return null;
    }

    public int hashCode() {
        return -1;
    }

    public boolean removeCourse(Course course) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
