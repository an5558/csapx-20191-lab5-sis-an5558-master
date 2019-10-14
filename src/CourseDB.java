import java.util.Collection;
import java.util.HashMap;

public class CourseDB implements DB<Integer, Course> {
    private HashMap<Integer, Course> courses;

    public CourseDB() {

    }

    public Course addValue(Course course) {
        return null;
    }

    public Collection<Course> getAllValues() {
        return null;
    }

    public Course getValue(Integer id) {
        return null;
    }

    public boolean haskey(Integer id) {
        return false;
    }
}
