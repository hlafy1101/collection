package map;

public class HashMap<K, V> implements Map<K, V> {

	// key �����ظ�

	private Entry[] table = new Entry[100];
	private int size;

	@Override
	public void put(K key, V value) {
		Entry entry = new Entry(key, value);
		// ��keyֵ��ͬ��ʱ�򣬲��ܼ������
		for (int i = 0; i < size; i++) {
			Entry temp = table[i];
			if (temp.getKey().equals(key)) { // key����
				temp.setValue(value);
				return;
			}
		}
		if (size >= table.length) { // capacity����
			int capacity = table.length + (table.length >> 1); // ����һ��
			Entry[] newArray = new Entry[capacity];
			System.arraycopy(table, 0, newArray, 0, table.length);
			table = newArray; // �����øı�
		}
		this.table[size++] = entry;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public V get(K key) {
		for (Entry<K, V> entry : table) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public void remove(K key) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (table[i].getKey().equals(key)) {
				index = i;
				break;
			}
		}
		if(index!=-1) {
			System.arraycopy(table, index+1, table, index, table.length-index-1);
			table[--size] = null;   // let gc do it work
		}
		
	}

}
