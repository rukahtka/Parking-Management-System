import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CreateEntryTestClass {

	@Test
	public void test() {
		CreateEntryUI ce = new CreateEntryUI();
		boolean st;
		st = ce.addParkingEntry(0, 3, "MH 78 LP 9087", "9988775437", "2018-10-28 01:53:34");
		assertEquals(true, st);
		
		st = ce.addParkingEntry(0, 11, "MH 09 KP 9547", "9965005437", "2018-10-28 01:58:34");
		assertEquals(true, st);
		
		st = ce.addParkingEntry(0, 10, "MH 07 LP 8087", "7898775437", "2018-10-27 01:53:34");
		assertEquals(false, st);
		
		st = ce.addParkingEntry(1, 10, "MH 12 OP 9547", "7788775437", "2018-10-28 01:53:34");
		assertEquals(true, st);
		
		st = ce.addParkingEntry(1, 6, "MH 14 PP 9847", "9900891137", "2018-10-28 01:58:34");
		assertEquals(true, st);
		
		st = ce.addParkingEntry(1, 5, "MH 12 IP 8007", "7000075437", "2018-10-27 01:53:34");
		assertEquals(false, st);
	}

}
