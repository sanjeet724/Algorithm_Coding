package HashTable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class HashDriver {

	public static void main(String[] args) throws IOException {
		System.out.println("Reading the input file... ");
		Scanner scanner = new Scanner(new File("inputKeys.txt"));
		while (scanner.hasNextInt()){
			int  i = scanner.nextInt();
			 System.out.println("Adding to the Table: " + i);
		}
		scanner.close();

	}

}
