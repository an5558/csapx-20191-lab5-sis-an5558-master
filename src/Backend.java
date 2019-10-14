import java.util.Collection;

public class Backend {
    private CourseDB courseDB;
    private UserDB userDB;

    public Backend(String courseFile, String professorFile, String studentFile) {

    }

    private void addCourses(User user, String[] courseIds) { }

    public boolean courseExists(int id) {
        return false;
    }

    public boolean enrollStudent(String username, int courseId) {
        return false;
    }

    public Collection<Course> getAllCourses() {
        return null;
    }

    public Collection<User> getAllUsers() {
        return null;
    }

    public Course getCourse(int id) {
        return null;
    }

    public Collection<Course> getCourseUser(String username) {
        return null;
    }

    private void initializeCourseDB(String courseFile) {

    }

    private void initializeUserDB(String professorFile, String studentFile) {

    }

    public boolean isStudent(String username) {
        return false;
    }

    public boolean unenrollStudent(String username, int courseId) {
        return false;
    }

    public boolean userExists(String username) {
        return false;
    }
}
