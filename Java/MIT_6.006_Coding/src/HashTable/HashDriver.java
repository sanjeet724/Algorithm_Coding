package HashTable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HashDriver {

	public static void main(String[] args) throws IOException {
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		Table t = new Table();
		System.out.println("Adding items to the Table...");
		while (scanner.hasNextInt()) {
			int  i = scanner.nextInt();
			HashItem h = new HashItem(i);
			t.putItem(h);
		}
		scanner.close();
		t.lookupItem(95);
		t.writer.close();
	}
}
