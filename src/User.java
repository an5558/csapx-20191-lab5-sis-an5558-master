import java.util.*;

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
        if(other instanceof User){
            if(this.getUsername().compareTo(((User)other).getUsername()) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(User o) {
        if(this.getUsername().compareTo(o.getUsername()) < 0){
            return -1;
        } else if(this.getUsername().compareTo(o.getUsername()) == 0){
            return 0;
        } else{
            return 1;
        }
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public String getUsername() {
        return username;
    }

    public int hashCode() {
        return username.hashCode();
    }

    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    @Override
    public String toString() {
        List<Course> courseList = new ArrayList<Course>(courses);
        String[] courseNames = new String[courseList.size()];
        for(int i = 0; i < courseList.size(); i++){
            courseNames[i] = courseList.get(i).getName();
        }
        return "User{username=" + username +
                ", type=" + type +
                ", courses=" + Arrays.toString(courseNames) +
                "}";
    }
}
