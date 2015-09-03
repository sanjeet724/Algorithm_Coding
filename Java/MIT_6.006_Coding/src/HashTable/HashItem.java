package HashTable;
import java.util.UUID;

// A linked list to handle chaining
public class HashItem {
	int key;
	String value;
	HashItem next;
	
	public HashItem(int k) {
		this.key = k;
		this.value = this.generateRandomString();
		this.next = null;
	}
	
	private String generateRandomString(){
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
}
