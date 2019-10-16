import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class Backend {
    private CourseDB courseDB;
    private UserDB userDB;

    public Backend(String courseFile, String professorFile, String studentFile) throws FileNotFoundException {
        initializeCourseDB(courseFile);
        initializeUserDB(professorFile, studentFile);
    }

    private void addCourses(User user, String[] courseIds) {
        for(int i = 0; i < courseIds.length; i++){
            user.addCourse(courseDB.getValue(Integer.parseInt(courseIds[i])));
        }
    }

    public boolean courseExists(int id) {
        return courseDB.haskey(id);
    }

    public boolean enrollStudent(String username, int courseId) {
        User user = userDB.getValue(username);
        Course course = courseDB.getValue(courseId);
        if(!user.getCourses().contains(course) || !course.getStudents().contains(user)){
            user.addCourse(course);
            course.addStudent(username);
            return true;
        }
        return false;
    }

    public Collection<Course> getAllCourses() {
        return courseDB.getAllValues();
    }

    public Collection<User> getAllUsers() {
        return userDB.getAllValues();
    }

    public Course getCourse(int id) {
        return courseDB.getValue(id);
    }

    public Collection<Course> getCourseUser(String username) {
        return userDB.getValue(username).getCourses();
    }

    private void initializeCourseDB(String courseFile) throws FileNotFoundException{
        courseDB = new CourseDB();
        try(Scanner in = new Scanner(new File(courseFile))){
            while(in.hasNext()){
                String[] fields = in.nextLine().split(",");
                Course course = new Course(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]));
                courseDB.addValue(course);
            }
        }
    }

    private void initializeUserDB(String professorFile, String studentFile) throws FileNotFoundException{
        userDB = new UserDB();
        String[] courseIdsProf;
        String[] courseIdsStudent;
        try(Scanner in = new Scanner(new File(professorFile))){
            while(in.hasNext()){
                String[] fields = in.nextLine().split(",");
                Professor professor = new Professor(fields[0]);
                courseIdsProf = new String[fields.length - 1];
                for(int i = 1; i < fields.length; i++){
                    courseIdsProf[i-1] = fields[i];
                }
                addCourses(professor, courseIdsProf);
                for(String id : courseIdsProf){
                    courseDB.getValue(Integer.parseInt(id)).addProfessor(professor.getUsername());
                }
                userDB.addValue(professor);
            }
        }
        try(Scanner in = new Scanner(new File(studentFile))){
            while(in.hasNext()){
                String[] fields = in.nextLine().split(",");
                Student student = new Student(fields[0]);
                courseIdsStudent = new String[fields.length - 1];
                for(int i = 1; i < fields.length; i++){
                    courseIdsStudent[i-1] = fields[i];
                }
                addCourses(student, courseIdsStudent);
                for(String id : courseIdsStudent){
                    courseDB.getValue(Integer.parseInt(id)).addStudent(student.getUsername());
                }
                userDB.addValue(student);
            }
        }
    }

    public boolean isStudent(String username) {
        return userDB.getValue(username).getUserType().equals(User.UserType.STUDENT);
    }

    public boolean unenrollStudent(String username, int courseId) {
        User user = userDB.getValue(username);
        Course course = courseDB.getValue(courseId);
        if(!user.getCourses().contains(course) && !course.getStudents().contains(user)){
            return false;
        } else{
            user.getCourses().remove(course);
            course.removeStudent(username);
        }
        return true;
    }

    public boolean userExists(String username) {
        return userDB.haskey(username);
    }
}
