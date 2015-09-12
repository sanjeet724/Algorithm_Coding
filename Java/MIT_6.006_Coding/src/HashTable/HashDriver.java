package HashTable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HashDriver {

	public static void main(String[] args) throws IOException {
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		Table t = new Table();
		System.out.println("Adding some items to the Table");
		while (scanner.hasNextInt()) {
			int  i = scanner.nextInt();
			HashItem h = new HashItem(i);
			t.putItem(h);
		}
		scanner.close();
		//t.lookupItem(35);
		t.printTable(t.hashTable);
		t.TableStats();
		t.deleteKey(23);
		t.printTable(t.hashTable);
		t.deleteKey(86);
		t.printTable(t.hashTable);
		t.deleteKey(28);
		t.printTable(t.hashTable);
		t.deleteKey(39);
		t.printTable(t.hashTable);
		t.deleteKey(01);
		t.writer.close(); // the log file for the hash table
	}
}
