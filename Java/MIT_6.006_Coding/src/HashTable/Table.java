package HashTable;

import java.io.IOException;
import java.io.PrintWriter;


public class Table {
	PrintWriter writer;
	int m = 19;
	HashItem [] hashTable;
	
	public Table() throws IOException{
		this.writer = new PrintWriter("HashTable_Log.txt", "UTF-8");
		this.hashTable = new HashItem[this.m];
	}
	
	private int getHashKey(int n) {
		return n % this.m;
	}
	
	public void putItem(HashItem h) {
		int index = this.getHashKey(h.key);
		if ( this.hashTable[index] == null ){
			writer.printf("Inserting key->%d at index: %d",h.key,index);
			writer.println();
			this.hashTable[index] = h;
		} 
		else {
			writer.println("Collison detected at index: " + index);
			HashItem temp = this.hashTable[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = h;
			writer.println("Key->" + h.key + " chained at index: " + index);
		}
	}
	
	public HashItem lookupItem(int k) {
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
	
}
