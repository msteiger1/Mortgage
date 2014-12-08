package MainPackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Test;

public class MorgageEstimatorTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test 
	public void testValue(){
		Engine test = new Engine();
		assertEquals("Max morgage should be 140104.95608956058" ,test.pv(.005, 360, 840, 0, false));
		}
	
	}
