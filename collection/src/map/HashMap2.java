package map;



import com.rudy.collecion.Iterator;
import com.rudy.collecion.LinkedList;

public class HashMap2<K, V> {

	//arraylist .linkedlist    ---------99%��
	//�Լ�                                                      ----------20%
	//git��ȥ��   
	// key �����ظ�

	private LinkedList<Entry>[] table = (LinkedList<Entry>[]) new LinkedList<?>[10];
	private int size;

	public void put(K key, V value) {
		Entry entry = new Entry(key, value);
		// ��keyֵ��ͬ��ʱ�򣬲��ܼ������
		int hashCode = Math.abs(key.hashCode());
		int position = hashCode % table.length;
		if(table[position] != null) {
			LinkedList<Entry> list = table[position];
			for (Iterator<Entry> iterator = list.iterator(); iterator.hasNext();) {
				Entry temp = iterator.next();
				if(temp.getKey().equals(entry.getKey())) {    //�����ֵ������£����޸����Ӧ��ֵ
					temp.setValue(entry.getValue());
					return;
				}
			}
			list.add(entry);  //û���ҵ���Ӧ��ֵ����������ӵ�������ȥ
		} else {
			LinkedList<Entry> list = new LinkedList<Entry>();
			list.add(entry);
			table[position] = list;  //������ָ��ŵ�������ȥ��
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
			if(temp.getKey().equals(k)) {    //�����ֵ������£����޸����Ӧ��ֵ
				return (V) temp.getValue();
			}
		}
		return null;
		
	}
	
	
	
	

}
