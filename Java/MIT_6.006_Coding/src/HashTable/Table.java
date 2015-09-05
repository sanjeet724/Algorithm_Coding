package HashTable;

import java.io.IOException;
import java.io.PrintWriter;


public class Table {
	PrintWriter writer;
	int m = 503; // table size
	int n = 0;  // # of items in table
	int occupied; // # of occupied slots
	HashItem [] hashTable; 
	
	public Table() throws IOException{
		this.writer = new PrintWriter("HashTable_Log.txt", "UTF-8");
		this.hashTable = new HashItem[this.m];
		this.occupied = 0;
		this.n = 0;
	}
	
	private int getHashKey(int n) {
		return n % this.m;
	}
	
	public void putItem(HashItem h) {
		this.n++;
		int index = this.getHashKey(h.key);
		if ( this.hashTable[index] == null ){
			writer.printf("Inserting key->%03d at index: %03d",h.key,index);
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
		int index = this.getHashKey(k);
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
	
	public void TableStats(){
		writer.println();
		writer.println("***Table Stats***");
		writer.println("Table Size: " + this.m);
		writer.println("Total # of items: " + this.n);
		writer.println("Occupied Slots in Table: " + this.occupied);
		writer.println("Free slots in the table(if any): ");
		for (int i = 0; i < this.m; i++){
			if (this.hashTable[i] == null){
				writer.println("Free Slot at index: " + i);
			}
		}
	}
	
	
}
