/**
 * A professor prefers to list their courses by ascending course level, and if there is a
 * tie then alphabetically by course name.
 */

public class Professor extends User {
    /**
     * Creates a new professor. Calls the parent constructor and passes the
     * username of the user, the enum class UserType PROFESSOR, and a comparator that
     * orders courses first by ascending course level and second alphabetically by course name.
     * @param username the username
     */
    public Professor(String username) {
        super(username, UserType.PROFESSOR, new CourseCompProf());
    }
}
