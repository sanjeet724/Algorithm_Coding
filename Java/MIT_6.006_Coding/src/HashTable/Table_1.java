package HashTable;

import java.io.IOException;
import java.io.PrintWriter;

// A Hash Table with Chaining

public class Table_1 {
	PrintWriter writer;
	static int collsionCount = 0;
	static int m = 80021;     // table size
	static int n = 0;         // # of items in table
	int occupied;             // # of occupied slots
	int searchIndex;
	HashItem [] hashTable; 
	
	public Table_1() throws IOException{
		this.writer = new PrintWriter("HashTable_Log.txt", "UTF-8");
		this.hashTable = new HashItem[m];
		this.occupied = 0;
		this.searchIndex = -1;
	}
	
	// Division Hash Function
	/*
	private static int DivisionHashIndex(int k) {
		return k % m;
	}
	*/

	
	// a better hash function - Universal Hash
	// h(k) = [(ak + b) mod p] mod m 

	private static int UniversalHashIndex(int k){
		// Universal Hashing Constants
		int a = 9491;
		int b = 5233;
		int p = 99999989;
		return Math.abs(((a*k + b) % p) % m);
	}
	
	public void putItem(HashItem h) {
		n++;
		int index = UniversalHashIndex(h.key);
		if ( this.hashTable[index] == null ){
			writer.printf("Inserting key->%03d at index: %02d",h.key,index);
			writer.println();
			this.hashTable[index] = h;
			this.occupied++;
		} 
		else {
			writer.println("Collision detected at index: " + index);
			collsionCount++;
			HashItem temp = this.hashTable[index];
			writer.printf("%d--->",temp.key);
			while (temp.next != null) {
				writer.printf("%d--->",temp.next.key);
				temp = temp.next;
			}
			temp.next = h;
			writer.println(h.key);
		}
		// Table Doubling
		if (n == m) {
			writer.println("n is: " + n);
			writer.println("m is: " + m);
			writer.println("***Doubling the table***");
			this.tableDoubling();
			writer.println("**Table Double Complete**");
		}
	}
	
	public void deleteKey(int k) {
		writer.println();
		writer.println("Deleting key: " + k );
		HashItem found = this.lookupItem(k);
		if (found == null){
			return;
		}
		n--;
		HashItem current = this.hashTable[this.searchIndex];
		// Item is the head of the list
		if (current.key == k){
			if (current.next == null){
				this.hashTable[this.searchIndex] = null;
				this.checkForResize();
				writer.println("Key Deleted: " + k );
				return;
			}
			if (current.next != null){
				this.hashTable[this.searchIndex] = current.next;
				current = null;
				this.checkForResize();
				writer.println("Key Deleted: " + k );
				return;
			}
		}
		// item is somewhwere in the chain
		else {
			while (current.next != null){
				if (current.next.key == k) {
					current.next = current.next.next;
					this.checkForResize();
					writer.println("Key Deleted: " + k );
					return;
				}
			    current = current.next;
			}
		}
		
	}
	
	private void checkForResize() {
		if (n == m/4){
			writer.println();
			writer.println("n is: " + n);
			writer.println("m is: " + m);
			writer.println("***Shrinking the Table***");
			HashItem [] temp = this.copyOldTable();
			// this.printTable(temp);   // Sanity Check
			this.hashTable = null;      // old table deleted
			m = m/2;          // half the table
			n = 0;
			this.occupied = 0;
			this.hashTable = new HashItem[m]; // new table of double size
			this.reHash(temp);
			writer.println("**Table Shrinking Complete**");
		}
	}
	
	public HashItem lookupItem(int k) {
		writer.println("Searching for key: " + k );
		int index = UniversalHashIndex(k);
		if (this.hashTable[index] != null) {
			if (this.hashTable[index].key == k) {
				writer.println("Key Found-->" + k + " at index: " + index);
				this.searchIndex = index;
				return this.hashTable[index];
			}
			else {
				HashItem temp = this.hashTable[index];
				while (temp != null) {
					if (temp.key == k){
						writer.println("Item found chained at index: " + index);
						this.searchIndex = index;
						return temp;
					}
					temp = temp.next;
				}
				writer.println("Key not found in the chain: " + k);
				return null;
			}
		}
		writer.println("Key Not Found in the Table: " + k);
		return null;
	}
	
	private HashItem [] copyOldTable() {
		writer.println("Making a copy of the old Table...");
		HashItem [] copy = new HashItem[m];
		for (int i = 0; i < this.hashTable.length ; i++){
			copy[i] = this.hashTable[i];
		}
		return copy;
	}
	
	public void printTable(HashItem [] h) {
		writer.println();
		writer.println("Printing the table...");
		for (int i = 0; i < h.length; i++){
			writer.printf("Index[%d] : ",i);
			if (h[i] != null) {
				HashItem current = h[i];
				while (current != null){
					writer.printf("%2d-->", current.key);
					current = current.next;
				}
			}
			writer.println("Null");
		}
	}
	
	private void reHash(HashItem [] t){
		writer.println("Rehashing the existing keys");
		for (int i = 0; i < t.length; i++) {
			if (t[i] != null) {
				HashItem current = t[i];
				while (current != null){
					// create a new item because its a linked list
					HashItem reHashedItem = new HashItem(current);
					this.putItem(reHashedItem);
					current = current.next;
				}
			}
		}
	}
	
	// make a copy of the old table and create a new table of double size
	private void tableDoubling() {
		HashItem [] temp = this.copyOldTable();
		// this.printTable(temp);   // Sanity Check
		this.hashTable = null;      // old table deleted
		m = 2*m;                    // double the table
		n = 0;
		this.occupied = 0;
		this.hashTable = new HashItem[m]; // new table of double size
		this.reHash(temp);
	}
	
	public void TableStats(){
		writer.println();
		writer.println("***Table Stats***");
		writer.println("Table Size: " + m);
		writer.println("Total # of items: " + n);
		writer.println("Occupied Slots in Table: " + this.occupied);
		int freeSlots = 0;
		for (int i = 0; i < m; i++){
			if (this.hashTable[i] == null){
				freeSlots++;
			}
		}
		writer.println("# of free slots: " + freeSlots);
		writer.println("# of Collisions: " + collsionCount);
	}
	
	
}
