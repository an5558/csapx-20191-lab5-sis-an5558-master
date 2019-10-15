import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class Backend {
    private CourseDB courseDB;
    private UserDB userDB;

    public Backend(String courseFile, String professorFile, String studentFile) throws FileNotFoundException {
        try(Scanner in = new Scanner(new File(courseFile))){
            while(in.hasNext()){
                String[] fields = in.nextLine().split(",");
                Course course = new Course(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]));
                courseDB.addValue(course);
            }
        }
        try(Scanner in = new Scanner(new File(professorFile))){
            while(in.hasNext()){
                String[] fields = in.nextLine().split(",");
                Professor professor = new Professor(fields[0]);
                userDB.addValue(professor);
            }
        }
        try(Scanner in = new Scanner(new File(studentFile))){
            while(in.hasNext()){
                String[] fields = in.nextLine().split(",");
                Student student = new Student(fields[0]);
                userDB.addValue(student);
            }
        }
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
