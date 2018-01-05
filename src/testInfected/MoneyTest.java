package testInfected;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	private static Money m12CHF;
	private static Money m14CHF;

	
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp()");
        m12CHF = new Money(12, "CHF");  // (1)
        m14CHF = new Money(14, "CHF");        
	}

	@Test
	public void testSimpleAdd() {
        Money expected= new Money(26, "CHF");
        Money result= m12CHF.add(m14CHF);    // (2)
        assertTrue(expected.equals(result));     // (3)
        m12CHF = new Money(1212, "CHF");
	}
	
	@Test
	public void testEquals() {
	    assertTrue(!m12CHF.equals(null));
	    assertEquals(m12CHF, m12CHF);
	    assertEquals(m12CHF, new Money(12, "CHF")); // (1)
	    assertTrue(!m12CHF.equals(m14CHF));
	}	
}
