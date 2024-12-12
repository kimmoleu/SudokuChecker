import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

//Change first character to a
String iD5 = "a17369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Change first digit to 0
String iD1 = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Change last digit to 10
String iD4 = "4173698256321589479587243168254371697915864323469127582896435715732916841648752910";
// Change first digit to duplicate 1 for the subgrid
String iG1G3 = "117369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Change places of 1st and 10th digit
String iR1R3 = "617369825432158947958724316825437169791586432346912758289643571573291684164875293";
// Change places of 1st and 2nd digit
String iC1C3 = "147369825632158947958724316825437169791586432346912758289643571573291684164875293";

SudokuVerifier v = new SudokuVerifier();

	@Test // D2 D3 G2 R2 C2
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", 0, a);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", -2, a);
	}

	@Test // D5
	public void testNotNumber() {
		int a = v.verify(iD5);
		assertEquals("incorrect string", 1, a);
	}
	

	@Test // D1
	public void testIncorrectValue0() {
		int a = v.verify(iD1);
		assertEquals("incorrect string", -1, a);
	}

	@Test // D4
	public void testIncorrectValue10() {
		int a = v.verify(iD4);
		assertEquals("incorrect string", -1, a);
	}

	@Test // G1 G3
	public void testIncorrectSubgrid() {
		int a = v.verify(iG1G3);
		assertEquals("incorrect string", -2, a);
	}

	@Test // R1 R3
	public void testIncorrectRow() {
		int a = v.verify(iR1R3);
		assertEquals("incorrect string", -3, a);
	}

	@Test // C1 C3
	public void testIncorrectColumn() {
		int a = v.verify(iC1C3);
		assertEquals("incorrect string", -4, a);
	}
	
}
