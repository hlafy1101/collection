package map;

public interface Map<K,V> {
	
	
	void put(K key,V value);

	int size();
	
	V get(K key);
	
	void remove(K key);
	
}
