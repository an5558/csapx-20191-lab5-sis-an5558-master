import java.util.Collection;

/**
 * A generic interface used by the two databases in SIS, CourseDB and UserDB.
 * @param <K> key type
 * @param <V> value type
 */

public interface DB<K, V> {
    /**Add a value entry to the database in constant time*/
    public V addValue(V value);
    /**Get all the values in the database in linear time*/
    public Collection<V> getAllValues();
    /**Get the value for an associated key in constant time*/
    public V getValue(K key);
    /**Indicates whether a key is in the database or not, in constant time*/
    public boolean haskey(K key);
}
