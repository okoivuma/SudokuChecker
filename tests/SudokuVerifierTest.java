import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();
	
	// 1
	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}
	
	// 2
	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	// 3
	@Test
	public void testTooShortString() {
		int a = v.verify(c.substring(0, 80));
		assertEquals("String is too short", -1, a);
		
	}
	
	// 4
	@Test
	public void testTooLongString() {
		int a = v.verify(c + "1");
		assertEquals("String is too Long", -1, a);
		
	}
	
	// 5
	@Test
	public void inCorrectCellValue() {
		String inCorrect = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(inCorrect);
		assertEquals("String contains invalid value", -1, a);
		
	}
	
	// 6
	@Test
	public void testDuplicatesRow() {
		String rowDuplicate = "418369825632158947957724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(rowDuplicate);
		assertEquals("Duplicate on first row", -3, a);
	}
	
	// 7
	@Test
	public void testDuplicatesColumn() {
		String columnDuplicate = "417369825632158947958724316825437169791586432346912758289643571573291684461875293";
		int a = v.verify(columnDuplicate);
		assertEquals("Duplicate on column", -4, a);
	}
	
	// 8
	@Test
	public void testCharValue() {
		String includesChar = "x17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(includesChar);
		assertEquals("Invalid value x", 1, a);
	}
	
	// 9
	@Test
	public void testNaughtyValue() {
		String invalid = "Ⱦ17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(invalid);
		assertEquals("Invalid value Ⱦ", 1, a);
	}
	
	// 10
	@Test
	public void testNullValue() {
		String includesNull = "173698256321589479NULL58724316825437169791586432346912758289643571573291684164875";
		int a = v.verify(includesNull);
		assertEquals("Invalid value NULL", 1, a);
	}
	
}
