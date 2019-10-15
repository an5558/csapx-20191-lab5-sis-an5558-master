import java.util.Comparator;

public class CourseCompStudent implements Comparator<Course> {
    public CourseCompStudent() {

    }

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
