import java.util.Collection;
import java.util.HashMap;

/**
 * Storage of all courses where the key is the unique course id and
 * the value is the associated Course object.
 */

public class CourseDB implements DB<Integer, Course> {
    /**course storage*/
    private HashMap<Integer, Course> courses;

    /**
     * Creates the course database.
     */
    public CourseDB() {
        courses = new HashMap<Integer, Course>();
    }

    /**
     * Add a value entry to the database in constant time. The database will
     * determine the key based on the value type.
     * @param course the value to add
     * @return the previous value associated with the key, otherwise null
     */
    public Course addValue(Course course) {
        if(courses.get(course.getId()) != null){
            return courses.put(course.getId(), course);
        } else{
            courses.put(course.getId(), course);
        }
        return null;
    }

    /**
     * Get all the values in the database in linear time.
     * @return all values
     */
    public Collection<Course> getAllValues() {
        return courses.values();
    }

    /**
     * Get the value for an associated key in constant time.
     * @param id the key
     * @return the value that is associated with they key, or null if not present
     */
    public Course getValue(Integer id) {
        return courses.get(id);
    }

    /**
     * Indicated whether a key is in the database or not, in constant time.
     * @param id the key to search for
     * @return whether the key is present or not
     */
    public boolean haskey(Integer id) {
        return courses.containsKey(id);
    }
}
