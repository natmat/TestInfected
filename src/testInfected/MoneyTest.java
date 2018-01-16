package testInfected;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	private static Money f7GBP;
	private static Money f14GBP;
	private static Money f21GBP;
	private static Money f7USD;
	private static Money f14USD;
	private static Money f21USD;
	private static MoneyBag fMB1;
	private static MoneyBag fMB2;

	@Before
	public void setUp() throws Exception {
		f7GBP = new Money(7, "GBP");
		f14GBP = new Money(14, "GBP");
		f21GBP = new Money(21, "GBP");
		f7USD = new Money( 7, "USD");
		f14USD = new Money( 14, "USD");
		f21USD = new Money(21, "USD");
		fMB1 = new MoneyBag(f7GBP, f7USD);
		fMB2 = new MoneyBag(f14GBP, f14USD);
	}

	@Test
	public void testSimpleAdd() {
		Money actual = (Money) f7GBP.add(f14GBP);
		final Money expecteds = f21GBP;
		assertTrue(expecteds.equals(actual));
	}

	@Test
	public void testEquals() {
		assertTrue(!f7GBP.equals(null));
		assertEquals(f7GBP, f7GBP);
		assertEquals(f7GBP, new Money(7, "GBP"));
		assertTrue(!f7GBP.equals(f21GBP));
	}	

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testBagEquals() {
		assertTrue(!fMB1.equals(null));
		assertEquals(fMB1, fMB1);
		assertTrue(!fMB1.equals(f7GBP));
		assertTrue(!f7GBP.equals(fMB1));
		assertTrue(!fMB1.equals(fMB2));
	}
	
	@Test
	public void testMixedSimpleAdd() { 
	    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]} 
		Money bag[]= { f7GBP, f7USD }; 
	    MoneyBag expected = new MoneyBag(bag); 
	    assertEquals(expected, f7GBP.add(f7USD)); 
	}
	
	@Test
	public void testBagSimpleAdd() {
		// add a MoneyBag to a simple Money
		Money bag1[] = { f7GBP, f7USD };
		MoneyBag mb1 = new MoneyBag(bag1);
		
		Money bag2[] = { f14GBP, f7USD };
		MoneyBag mb2 = new MoneyBag(bag2);
		
		assertEquals(mb2, f7GBP.add(mb1));
	}

	@Test
	public void testSimpleBagAdd() {
		// add a simple Money to a MoneyBag
		Money bag1[] = { f7GBP, f7USD };
		MoneyBag mb1 = new MoneyBag(bag1);
		
		Money bag2[] = { f14GBP, f7USD };
		MoneyBag mb2 = new MoneyBag(bag2);
		
		assertEquals(mb2, mb1.add(f7GBP));
	}
	
	@Test
	public void testBagBagAdd() {
		// add two MoneyBags
		final Money bag[] = { f21GBP, f21USD };
		final MoneyBag expected = new MoneyBag(bag);
		
		assertEquals(expected, fMB1.add(fMB2));
	}
}



