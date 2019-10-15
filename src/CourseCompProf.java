import java.util.Comparator;

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
