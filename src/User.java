import java.util.*;

/**
 * Represents a user who is either a professor or student. All users have a unique username
 * and store the courses they are currently teaching (professor) or enrolled in (student),
 * in a tree set that is organized based on their preference.
 */

public class User implements Comparable<User> {
    /** The type of user */
    public enum UserType{
        PROFESSOR,
        STUDENT
    }

    /**The courses the professor is teaching, or student is enrolled in*/
    private TreeSet<Course> courses;
    /** The user type */
    private User.UserType type;
    /** The username(unique)*/
    private String username;

    /**
     * Creates a new user.
     * @param username the username (must be unique)
     * @param type the user type
     * @param comp the comparator that the tree set, courses, is to use
     */
    public User(String username, User.UserType type, Comparator<Course> comp) {
        this.username = username;
        this.type = type;
        courses = new TreeSet<Course>(comp);
    }

    /**
     * Gets the user type.
     * @return user type
     */
    public UserType getUserType(){
        return type;
    }

    /**
     * Add a course for this user. For a professor it means they add it to the courses
     * they are teaching. If they are a student, they are enrolling in the course.
     * @param course the course to add
     * @return whether the course was added or not (false if it was not added)
     */
    public boolean addCourse(Course course) {
        return !(courses.add(course));
    }

    /**
     * Two users are equal if they have the same username.
     * @param other the other user to compare to
     * @return whether they are equal or not
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof User){
            if(this.getUsername().compareTo(((User)other).getUsername()) == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Users are naturally ordered alphabetically by username.
     * @param o the user to compare to
     * @return a value less than 0 if this username is less than other's username,
     * 0 if the usernames are the same,
     * a value greater than 0 if this username is greater than other's username.
     */
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

    /**
     * Returns the courses the user is currently teaching or enrolled in.
     * @return
     */
    public Collection<Course> getCourses() {
        return courses;
    }

    /**
     * Get the username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * The hash code of a user is the hash code of the username.
     * @return
     */
    public int hashCode() {
        return username.hashCode();
    }

    /**
     * Removes a course for this user. In both cases for a professor or student
     * the meaning is the course no longer exists in their collection of courses.
     * @param course the course to remove
     * @return true if the student was removed from the course, false if the student was not in the course
     */
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    /**
     * Returns a string representation of the user in the format:
     * User{username=USERNAME, type=TYPE, courses=COURSE_LIST}
     *
     * COURSE_LIST is a list of courses, with brackets surrounding the comma separated
     * entries, which are the course names in ascending alphabetical order for students, and the
     * first by course level and second by ascending alphabetical course name for professors.
     * @return the formatted string
     */
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
