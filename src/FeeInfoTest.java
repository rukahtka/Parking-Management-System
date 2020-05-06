import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class FeeInfoTest {

	@Test
	public void test() throws ParseException {
		FeeInfoUI fi = new FeeInfoUI();
		boolean st;
		st = fi.deallocateParkingSpace(0, 3);
		assertEquals(true, st);
		
		st = fi.deallocateParkingSpace(0, 10);
		assertEquals(true, st);
		
		st = fi.deallocateParkingSpace(0, 6);
		assertEquals(false, st);
		
		st = fi.deallocateParkingSpace(1, 2);
		assertEquals(true, st);
		
		st = fi.deallocateParkingSpace(1, 6);
		assertEquals(true, st);
		
		st = fi.deallocateParkingSpace(1, 9);
		assertEquals(false, st);
		
	}

}
