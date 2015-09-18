package HashTable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HashDriver {

	public static void main(String[] args) throws IOException {
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys_unique.txt"));
		Table_1 t = new Table_1();
		System.out.println("Adding some items to the Table");
		while (scanner.hasNextInt()) {
			int  i = scanner.nextInt();
			HashItem h = new HashItem(i);
			t.putItem(h);
		}
		/*
		t.printTable(t.hashTable);
		System.out.println("Deleting some items to the Table");
		scanner = new Scanner(new File("deleteKeys.txt"));
		while (scanner.hasNextInt()) {
			int  i = scanner.nextInt();
			t.deleteKey(i);
		}
		*/
		scanner.close();
		t.printTable(t.hashTable);
		t.TableStats();
		long startTime = System.nanoTime();   
		HashItem x = t.lookupItem(654642874);
		long stopTime = System.nanoTime(); 
		long elapsedTime = stopTime - startTime;
		if (x != null){
			System.out.println(x.key + " was found in: " + elapsedTime);
		}
		System.out.println("Check 'HashTable_log' for verbose logs");
		t.writer.close(); // the log file for the hash table
	}
}
