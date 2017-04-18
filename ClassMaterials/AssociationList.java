import java.util.ArrayList;

public class AssociationList<K, V> {
	
	private static class Pair<T, U> {
		public T key;
		public U value;
		
		public Pair (T key, U value) {
			this.key = key;
			this.value = value;
		}
		
		@SuppressWarnings("unchecked")
		public boolean equals(Object o) {
			if(o instanceof Pair) {
				Pair<T, U> other = (Pair<T, U>) o;
				return key.equals(other.key) && value.equals(other.value);
			}
			return false;
		}
	}
	
	private ArrayList<Pair<K, V>> list; 
	
	public AssociationList() {
		list = new ArrayList<>();
	}
	
	
	public void put(K key, V value) {
		list.add(new Pair<>(key, value));
	}
	
	public V get(K key) {
		for(Pair<K, V> p : list) {
			if(p.key == key) {
				return (V) p.value;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean containsKey(K key) {
		for(Pair<K, V> p : list) {
			if(p.key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(K key) {
		for(Pair<K, V> p : list) {
			if(p.key.equals(key)) {
				list.remove(p);
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		AssociationList<String, Integer> a = new AssociationList<>();
		a.put("dog",  3);
		a.put("cat",  3);
		a.put("fish",  4);
		a.put("whale",  5);
		System.out.println("Fish? " + a.containsKey("fish"));
		a.delete("fish");
		System.out.println("Fish again? " + a.containsKey("fish"));
	}
}
