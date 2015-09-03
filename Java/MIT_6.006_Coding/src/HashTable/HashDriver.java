package HashTable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class HashDriver {

	public static void main(String[] args) throws IOException {
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		Table t = new Table();
		while (scanner.hasNextInt()){
			int  i = scanner.nextInt();
			HashItem h = new HashItem(i);
			t.putItem(h);
			//System.out.println("Adding to the Table: " + i);
		}
		scanner.close();
		Scanner scanner2 = new Scanner(new File("inputKeys.txt"));
		System.out.println("Searching the table...");
		while (scanner2.hasNextInt()){
			t.lookupItem(scanner2.nextInt());
	    }
		scanner2.close();
	}
}
