package map;



import com.rudy.collecion.Iterator;
import com.rudy.collecion.LinkedList;

public class HashMap2<K, V> {

	//arraylist .linkedlist    ---------99%会
	//自己                                                      ----------20%
	//git上去，   
	// key 不能重复

	private LinkedList<Entry>[] table = (LinkedList<Entry>[]) new LinkedList<?>[10];
	private int size;

	public void put(K key, V value) {
		Entry entry = new Entry(key, value);
		// 当key值相同的时候，不能继续添加
		int hashCode = Math.abs(key.hashCode());
		int position = hashCode % table.length;
		if(table[position] != null) {
			LinkedList<Entry> list = table[position];
			for (Iterator<Entry> iterator = list.iterator(); iterator.hasNext();) {
				Entry temp = iterator.next();
				if(temp.getKey().equals(entry.getKey())) {    //如果有值的情况下，则修改其对应的值
					temp.setValue(entry.getValue());
					return;
				}
			}
			list.add(entry);  //没有找到对应的值，则将数据添加到链表中去
		} else {
			LinkedList<Entry> list = new LinkedList<Entry>();
			list.add(entry);
			table[position] = list;  //将链表指针放到数组上去吗
		}
		size++;
	}

	public int size() {
		return size;
	}

	public V get(K k) {
		int hashCode = Math.abs(k.hashCode());
		int position = hashCode % table.length;
		LinkedList<Entry> list = table[position];
		for (Iterator<Entry> iterator = list.iterator(); iterator.hasNext();) {
			Entry temp = iterator.next();
			if(temp.getKey().equals(k)) {    //如果有值的情况下，则修改其对应的值
				return (V) temp.getValue();
			}
		}
		return null;
		
	}
	
	
	
	

}
