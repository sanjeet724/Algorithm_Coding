package MockDataSetup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

public class RandomUniqueInputs {

	public static void main(String[] args) throws IOException {
		Random randomGenerator = new Random();
		int sizeOfInput = 0;
		HashMap<Integer, Integer> unique = new HashMap<Integer, Integer>();
		System.out.println("Generating some random uique inputs: ");
		PrintWriter writer = new PrintWriter("inputKeys_unique.txt", "UTF-8");
		int duplicates = 0;
		while (sizeOfInput != 80000){
			int randomNumber = randomGenerator.nextInt(1000000000);
			if (unique.containsKey(randomNumber)) {
				duplicates++;
				System.out.println("Key already exists: ");
			}
			else {
				System.out.println("Number generated is: " + randomNumber);
				unique.put(randomNumber, randomNumber);
				writer.println(randomNumber);
				sizeOfInput++;
			}
		}
		System.out.println("Size of Input: " + sizeOfInput);
		System.out.println("Duplicates detected: " + duplicates);
		writer.close();

	}

}
