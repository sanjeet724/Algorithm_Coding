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
		t.writer.close(); // the log file for the hash table
	}
}
