package HashTable;

import java.io.IOException;
import java.io.PrintWriter;


public class Table {
	PrintWriter writer;
	int m = 5;      // table size
	int n = 0;      // # of items in table
	int occupied;   // # of occupied slots
	int searchIndex;
	HashItem [] hashTable; 
	
	public Table() throws IOException{
		this.writer = new PrintWriter("HashTable_Log.txt", "UTF-8");
		this.hashTable = new HashItem[this.m];
		this.occupied = 0;
		this.n = 0;
		this.searchIndex = -999;
	}
	
	private int getHashIndex(int k) {
		return k % this.m;
	}
	
	public void putItem(HashItem h) {
		this.n++;
		int index = this.getHashIndex(h.key);
		if ( this.hashTable[index] == null ){
			writer.printf("Inserting key->%03d at index: %02d",h.key,index);
			writer.println();
			this.hashTable[index] = h;
			this.occupied++;
		} 
		else {
			writer.println("Collision detected at index: " + index);
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
		if (this.n == this.m) {
			writer.println("n is: " + this.n);
			writer.println("m is: " + this.m);
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
		this.n--;
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
		if (this.n == this.m/4){
			writer.println();
			writer.println("n is: " + this.n);
			writer.println("m is: " + this.m);
			writer.println("***Shrinking the Table***");
			HashItem [] temp = this.copyOldTable();
			// this.printTable(temp);   // Sanity Check
			this.hashTable = null;      // old table deleted
			this.m = this.m/2;          // half the table
			this.n = 0;
			this.occupied = 0;
			this.hashTable = new HashItem[this.m]; // new table of double size
			this.reHash(temp);
			writer.println("**Table Shrinking Complete**");
		}
	}
	
	public HashItem lookupItem(int k) {
		writer.println("Searching for key: " + k );
		int index = this.getHashIndex(k);
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
		HashItem [] copy = new HashItem[this.m];
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
		this.m = 2*this.m;          // double the table
		this.n = 0;
		this.occupied = 0;
		this.hashTable = new HashItem[this.m]; // new table of double size
		this.reHash(temp);
	}
	
	public void TableStats(){
		writer.println();
		writer.println("***Table Stats***");
		writer.println("Table Size: " + this.m);
		writer.println("Total # of items: " + this.n);
		writer.println("Occupied Slots in Table: " + this.occupied);
		int freeSlots = 0;
		for (int i = 0; i < this.m; i++){
			if (this.hashTable[i] == null){
				freeSlots++;
			}
		}
		writer.println("# of free slots: " + freeSlots);
	}
	
	
}
