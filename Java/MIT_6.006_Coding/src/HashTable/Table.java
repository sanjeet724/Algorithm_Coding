package HashTable;

public class Table {
	int m = 20;
	HashItem [] hashTable;
	
	public Table() {
		this.hashTable = new HashItem[this.m];
	}
	
	private int getHashKey(int n) {
		return n % this.m;
	}
	
	public void putItem(HashItem h) {
		int index = this.getHashKey(h.key);
		if ( this.hashTable[index] == null ){
			System.out.println("Inserting at index: " + index);
			this.hashTable[index] = h;
		} 
		else {
			System.out.println("Collison detected...");
			HashItem temp = this.hashTable[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = h;
		}
	}
	
	public void lookupItem(int k) {
		int index = this.getHashKey(k);
		if (this.hashTable[index] != null) {
			if (this.hashTable[index].key == k) {
				System.out.println("Item Found: " + k + " at index: " + index);
				return;
			}
			else {
				System.out.println("Item was overwritten: " + k);
				HashItem temp = this.hashTable[index];
				while (temp.next != null) {
					if (temp.key == k){
						System.out.println("Item was found in the list");
						return;
					}
					temp = temp.next;
				}
				return;
			}
			//return this.hashTable[index];
		}
		System.out.println("Item Not Found: " + k);
		return;
		//return null;
	}
	
}
