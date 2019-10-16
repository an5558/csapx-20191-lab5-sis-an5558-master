import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

/**
 * Represents the backend that SIS (frontend) interfaces with.
 * It creates the course and user databases from the input files. It is responsible for taking requests
 * from SIS and invoking the appropriate operations on the databases.
 *
 * A course file is a comma separated text file in the format(one per line):
 * {CourseID},{Course_Name},{CourseLevel}
 *
 * A professor file is a comma separated text file in the format(one per line):
 * {ProfessorUsername},{CourseId_1},{CourseId_2}...
 *
 * A student file is a comma separated text file in the format(one per line):
 * {StudentUsername},{CourseId_1},{CourseId_2}...
 *
 * @author Ayane Naito
 */

public class Backend {
    /**the course database*/
    private CourseDB courseDB;
    /**the user database*/
    private UserDB userDB;

    /**
     * Initializes the course database and user database.
     * @param courseFile the course file
     * @param professorFile the professor file
     * @param studentFile the student file
     * @throws FileNotFoundException if any of the files cannot be found
     */
    public Backend(String courseFile, String professorFile, String studentFile) throws FileNotFoundException {
        initializeCourseDB(courseFile);
        initializeUserDB(professorFile, studentFile);
    }

    /**
     * Adds courses to a user's course list given a String[] of course IDs.
     * @param user the user the courses should be added to
     * @param courseIds the course IDs of the courses to be added
     */
    private void addCourses(User user, String[] courseIds) {
        for(int i = 0; i < courseIds.length; i++){
            user.addCourse(courseDB.getValue(Integer.parseInt(courseIds[i])));
        }
    }

    /**
     * Checks whether a course exists or not.
     * @param id course ID of the course to be checked
     * @return true if the course exists, false if the course doesn't exist
     */
    public boolean courseExists(int id) {
        return courseDB.haskey(id);
    }

    /**
     * Enrolls a student in a course. This requires that they are added to both the course and
     * student's courses.
     * @param username username of the student to be enrolled
     * @param courseId course ID of the course the student should be enrolled in
     * @return true if the student was enrolled in the course, false if they were not
     */
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

    /**
     * Accessor for all courses in the system.
     * @return all courses
     */
    public Collection<Course> getAllCourses() {
        return courseDB.getAllValues();
    }

    /**
     * Accessor for all users in the system.
     * @return all users
     */
    public Collection<User> getAllUsers() {
        return userDB.getAllValues();
    }

    /**
     * Get a course by the id.
     * @param id the course id
     * @return the course associated with the id
     */
    public Course getCourse(int id) {
        return courseDB.getValue(id);
    }

    /**
     * Get the courses for a particular user.
     *
     * Precondition: the username exists
     * @param username the username of the user
     * @return the collection of courses for a user
     */
    public Collection<Course> getCourseUser(String username) {
        return userDB.getValue(username).getCourses();
    }

    /**
     * A utility method for initializing the course database.
     * @param courseFile name of course file
     * @throws FileNotFoundException if the courses file cannot be found
     */
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

    /**
     * A utility method for initializing the user database.
     * @param professorFile name of the professor file
     * @param studentFile name of the student file
     * @throws FileNotFoundException if any of the files cannot be found
     */
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

    /**
     * Check whether a username belongs to a student.
     *
     * Precondition: the username exists in the database
     * @param username the username
     * @return whether the username belongs to a student or not
     */
    public boolean isStudent(String username) {
        return userDB.getValue(username).getUserType().equals(User.UserType.STUDENT);
    }

    /**
     * Unenroll a student in a course. This requires they are removed from both the course
     * and the student's courses.
     *
     * Precondition: the user exists, the user is a student, the course exists
     * @param username the username of student to unenroll
     * @param courseId the id of the course
     * @return true if the student was unenrolled, false if the student was not enrolled in the course
     */
    public boolean unenrollStudent(String username, int courseId) {
        User user = userDB.getValue(username);
        Course course = courseDB.getValue(courseId);
        if(!user.getCourses().contains(course) && !course.getStudents().contains(user)){
            return false;
        } else{
            user.removeCourse(course);
            course.removeStudent(username);
        }
        return true;
    }

    /**
     * Checks if a username exists in the system.
     * @param username the username to check
     * @return whether the username is in the system or not
     */
    public boolean userExists(String username) {
        return userDB.haskey(username);
    }
}
