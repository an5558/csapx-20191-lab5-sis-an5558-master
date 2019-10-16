import java.util.Comparator;

/**
 * A class that overrides the natural order comparison of courses for a student
 * to order them alphabetically by course name.
 *
 * @author Ayane Naito
 */

public class CourseCompStudent implements Comparator<Course> {
    public CourseCompStudent() {

    }

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
