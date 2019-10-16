import java.util.Comparator;

/**
 * A class that overrides the natural order comparison of courses for a professor
 * to order them by ascending course level first and then alphabetically by course name.
 *
 * @author Ayane Naito
 */

public class CourseCompProf implements Comparator<Course> {
    public CourseCompProf() {

    }

    @Override
    public int compare(Course o1, Course o2) {
        if(o1.getLevel() == o2.getLevel()){
            return o1.getName().compareTo(o2.getName());
        } else{
            if(o1.getLevel() < o2.getLevel()){
                return -1;
            } else if(o1.getLevel() == o2.getLevel()){
                return 0;
            } else{
                return 1;
            }
        }
    }
}
