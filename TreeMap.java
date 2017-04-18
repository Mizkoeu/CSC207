
public class TreeMap<K extends Comparable<K>, V> {

	private static class Node<K extends Comparable<K>, V> {
		private K key;
		private V value;
		private Node<K, V> left;
		private Node<K, V> right;
		
		public Node (K key, V value, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}

		private Node<K, V> root;

		public static <K extends Comparable<K>, V> Node<K, V> put (K key, V value, Node<K, V> cur) {
			if (cur == null) {
				return new Node<>(key, value, null, null);
			}
			else {
				if(cur.key.compareTo(key) > 0) {
					cur.right = put(key, value, cur.right);
				}
				else if(cur.key.compareTo(key) < 0) {
					cur.left = put(key, value, cur.left);
				}
				else {
					cur.value = value;
				}
				return cur;
			}
		}

		public void put(K key, V value) {
			root = put(key, value, root);
		}


		public static <K extends Comparable <K>, V> V get(Node<K, V> cur, K key) {	
			if (cur == null) {
				throw new IllegalArgumentException();
			}
			else {
				if (cur.key.compareTo(key) > 0) {
					return get(cur.right, key);
				}
				else if (cur.key.compareTo(key) < 0) {
					return get(cur.left, key);
				}
				else {
					return cur.value;
				}
			}
		}
		
		public V get(K key) {
			return get(root, key); 
		}
	}
}
