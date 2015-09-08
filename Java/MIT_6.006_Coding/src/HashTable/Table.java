package HashTable;

import java.io.IOException;
import java.io.PrintWriter;


public class Table {
	PrintWriter writer;
	int m = 5;     // table size
	int n = 0;      // # of items in table
	int occupied;   // # of occupied slots
	HashItem [] hashTable; 
	
	public Table() throws IOException{
		this.writer = new PrintWriter("HashTable_Log.txt", "UTF-8");
		this.hashTable = new HashItem[this.m];
		this.occupied = 0;
		this.n = 0;
	}
	
	
	private int getHashIndex(int k) {
		return k % this.m;
	}
	
	public void putItem(HashItem h) {
		// Table Doubling
		if (this.n > this.m) {
			writer.println("n is: " + this.n);
			writer.println("m is: " + this.m);
			this.tableDoubling();
		}
		this.n++;
		int index = this.getHashIndex(h.key);
		if ( this.hashTable[index] == null ){
			writer.printf("Inserting key->%03d at index: %02d",h.key,index);
			writer.println();
			this.hashTable[index] = h;
			this.occupied++;
		} 
		else {
			writer.println("Collison detected at index: " + index);
			HashItem temp = this.hashTable[index];
			writer.printf("%d--->",temp.key);
			while (temp.next != null) {
				writer.printf("%d--->",temp.next.key);
				temp = temp.next;
			}
			temp.next = h;
			writer.println(h.key);
		}
	}
	
	public HashItem lookupItem(int k) {
		writer.println();
		writer.println("Searching for key: " + k + "---->");
		int index = this.getHashIndex(k);
		if (this.hashTable[index] != null) {
			if (this.hashTable[index].key == k) {
				writer.println("Item Found: " + k + " at index: " + index);
				return this.hashTable[index];
			}
			else {
				HashItem temp = this.hashTable[index];
				while (temp != null) {
					if (temp.key == k){
						writer.println("Item was chained at index: " + index);
						return this.hashTable[index];
					}
					temp = temp.next;
				}
				System.out.println("Key not found in the chain: " + k);
				return null;
			}
		}
		System.out.println("Key Not Found in the Table: " + k);
		return null;
	}
	
	private void tableDoubling() {
		writer.println("Doubling the Table and Re-Hasing...");
		this.m = 2*this.m;
		this.n = 0;
		HashItem [] tempTable = this.hashTable;
		this.hashTable = new HashItem[this.m];
		for (int i = 0; i < tempTable.length; i++) {
			if (tempTable[i] != null){
				// iterate over the list at the slot
				HashItem current = tempTable[i];
				while (current != null){
					this.putItem(current);
					current = current.next;
				}
			}
		}
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
