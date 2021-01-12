package ma7;

public class PointerList {
	public class Node {
		Node next;
		String key;
		int value;
		public Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
		public Node(String key, int value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	Node first;
	
	public PointerList(String key, int value) {
		first = new Node(key, value);
	}
	
	public boolean insert(String key, int value) {
		if(first == null) {
			first = new Node(key, value);
			return true;
		}
		if(key.compareTo(first.key) < 0) { 
			Node newNode = new Node(key, value);
			newNode.next = first;
			first = newNode;
			return true;
		} 
		Node current = first;
		while(current.next != null) {
			if(current.key.equals(key)) { 
				current.value = value;
				return false;
			}
			if(current.next.key.compareTo(key) > 0) {
				break; 
			}
			current = current.next;
		}
		Node newNode = new Node(key, value, current.next); 
		current.next = newNode;
		return true;
	}
	
	public Integer get(String key) {
		Node current = first;
		while(current != null) {
			if(current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}
	
	public String floor(String key) {
		if(first == null) {
			return null;
		}
		Node current = first;
		while(current.next != null) {
			if(current.next.key.compareTo(key) > 0) {
				break; 
			}
			current = current.next;
		}
		if(current.key.compareTo(key) <= 0) {
			return current.key;
		}
		return null;
	}
	
	public String control(String key) {
		Node current = first;
		while(current != null) {
			if(current.key.equals(key)) { 
				return current.next == null ? null : current.next.key;
			}
			current = current.next;
		}
		return null;
	}

}
