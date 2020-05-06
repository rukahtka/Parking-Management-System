import static org.junit.Assert.*;

import org.junit.Test;

public class TestingHome {

	@Test
	public void test() {
		HomePage hp = new HomePage();
		boolean st = hp.verifyAdmin("admin", "admin123");
		assertEquals(true, st);
		
		st = hp.verifyAdmin("admin1", "admin123");
		assertEquals(false, st);
		
		st = hp.verifyAdmin("", "");
		assertEquals(false, st);
		
		
		
	}

}
