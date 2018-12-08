import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitIntroduction {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executed Before");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}


	@Test
	public void test2() {
		fail("Not yet implemented");
	}
	
}
