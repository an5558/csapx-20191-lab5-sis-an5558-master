import java.util.Collection;

public interface DB<K, V> {
    public V addValue(V value);
    public Collection<V> getAllValues();
    public V getValue(K key);
    public boolean haskey(K key);
}
