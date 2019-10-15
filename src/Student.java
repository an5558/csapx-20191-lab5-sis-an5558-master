public class Student extends User {
    public Student(String username) {
        super(username, UserType.STUDENT, new CourseCompStudent());
    }
}
