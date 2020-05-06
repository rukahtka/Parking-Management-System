import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class ParkingSpaceTest {

	@Test
	public void test() throws SQLException {
		ParkingSpace pst = new ParkingSpace();
		String stTest = ParkingSpace.getEntry(1, 0);
		String str = "MH 12 lk 9087,"+"7898765432"+",2018-10-28 01:53:34.0";
		assertEquals(str, stTest);
		
		
		 stTest = ParkingSpace.getEntry(8, 0);
		 str = "GJ 65 JH 9823"+","+"8765432198"+",2018-10-28 03:38:28.0";
		assertEquals(str, stTest);
		
		 stTest = ParkingSpace.getEntry(10, 0);
		 str = "JK 45 LL 9822"+","+"9895690054"+",2018-10-28 09:53:08.0";
		assertEquals(str, stTest);
		
		 stTest = ParkingSpace.getEntry(5, 1);
		 str = "mh 12 kk 5433"+","+"9876543212"+",2018-10-28 11:44:32.0";
		assertEquals(str, stTest);
		
		 stTest = ParkingSpace.getEntry(7, 1);
		 str = "HP 90 TY 7865"+","+"9870565757"+",2018-10-29 12:13:04.0";
		assertEquals(str, stTest);
		
		/* stTest = ParkingSpace.getEntry(12, 0);
		 str = "0000-00-00 00:00:00";
		assertEquals(str, stTest);
		
		 stTest = ParkingSpace.getEntry(12, 1);
		 str = "0000-00-00 00:00:00";
		assertEquals(str, stTest);*/
	}

}
