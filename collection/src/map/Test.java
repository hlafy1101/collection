package map;

public class Test {
	
	
	public static void main(String[] args) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		map.put(10, 10);
		map.put(10, 2000);
		
		
		System.out.println(map.get(10));
		System.out.println(map.size());
		map.remove(10);
		System.out.println(map.size());
		
		
		
	}
	
}
