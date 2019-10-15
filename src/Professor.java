public class Professor extends User {
    public Professor(String username) {
        super(username, UserType.PROFESSOR, new CourseCompProf());
    }
}
