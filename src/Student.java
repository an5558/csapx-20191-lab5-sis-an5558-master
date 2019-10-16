/**
 * A student prefers to list their courses alphabetically by course name.
 */

public class Student extends User {
    /**
     * Creates a new student. Here you want to pass to parent constructor
     * the user and a comparator that orders the courses ascending by course name.
     * @param username the username
     */
    public Student(String username) {
        super(username, UserType.STUDENT, new CourseCompStudent());
    }
}
