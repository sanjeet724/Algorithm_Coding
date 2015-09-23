package HashLab;
/* 
This package is just for testing the various hash 
functions and the Karp-Rabin algorithm 
*/

class Driver {

	public static void main(String[] args) {
		//testRollHash_1();
		testRollHash_2();
		}
	
	private static void testRollHash_1() {
		System.out.println("Rolling Hash Test 1");
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
	
	private static void testRollHash_2() {
		System.out.println("Rolling Hash Test 2");
		RollHash2 r1 = new RollHash2();
		r1.appendChar('t');
		r1.appendChar('h');
		r1.appendChar('e');
		RollHash2 r2 = new RollHash2();
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
