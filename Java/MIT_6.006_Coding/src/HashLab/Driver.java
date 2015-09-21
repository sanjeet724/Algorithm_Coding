package HashLab;
/* 
This package is just for testing the various hash 
functions and the Karp-Rabin algorithm 
*/

class Driver {

	public static void main(String[] args) {
		// System.out.println("Old School Way");
		// Tester test = new Tester();
		// test.getNumericValue("the");
		//test.getNumericValue("thei");
		//test.getNumericValue("hei");
		// System.out.println("Rolling Hash Technique");
		RollHash r1 = new RollHash();
		r1.appendChar('t');
		r1.appendChar('h');
		r1.appendChar('e');
		RollHash r2 = new RollHash();
		r2.appendChar('a');
		r2.appendChar('b');
		r2.appendChar('c');
		r2.appendChar('t');
		r2.skipChar();
		r2.appendChar('h');
		r2.skipChar();
		r2.appendChar('e');
		r2.skipChar();

		}

}
