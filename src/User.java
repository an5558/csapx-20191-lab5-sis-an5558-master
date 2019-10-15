import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class User implements Comparable<User> {
    /** The type of user */
    public enum UserType{
        PROFESSOR,
        STUDENT
    }

    private TreeSet<Course> courses;
    private User.UserType type;
    private String username;

    public User(String username, User.UserType type, Comparator<Course> comp) {
        this.username = username;
        this.type = type;
        courses = new TreeSet<Course>(comp);
    }

    public UserType getUserType(){
        return type;
    }

    public boolean addCourse(Course course) {
        return !(courses.add(course));
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
