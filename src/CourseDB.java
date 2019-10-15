import java.util.Collection;
import java.util.HashMap;

public class CourseDB implements DB<Integer, Course> {
    private HashMap<Integer, Course> courses;

    public CourseDB() {
        courses = new HashMap<Integer, Course>();
    }

    public Course addValue(Course course) {
        if(courses.get(course.getId()) != null){
            return courses.put(course.getId(), course);
        } else{
            courses.put(course.getId(), course);
        }
        return null;
    }

    public Collection<Course> getAllValues() {
        return courses.values();
    }

    public Course getValue(Integer id) {
        return courses.get(id);
    }

    public boolean haskey(Integer id) {
        return courses.containsKey(id);
    }
}
