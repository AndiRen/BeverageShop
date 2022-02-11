import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTestGFA {
	Order r1,r2,r3,r4;
	@Before
	public void setUp() throws Exception {
		r1 = new Order (8, Day.MONDAY, new Customer ("Mary", 22));
		r2 = new Order (12, Day.SATURDAY, new Customer ("John", 45));
		r3 = new Order (10, Day.SUNDAY, new Customer ("Kate", 21));
	}

	@After
	public void tearDown() throws Exception {
		r1=r2=r3=null;
	}
	
	@Test 
	public void testGetBeverage( )
	{
		Coffee cf = new Coffee("regular Coffee", Size.SMALL, false,false);
		Alcohol al = new Alcohol ("Mohito", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM,1,false);
		Smoothie sm2 = new Smoothie("Detox", Size.LARGE,1,false);
		
		r1.addNewBeverage("regular Coffee", Size.SMALL, false,false);
		r1.addNewBeverage("Mohito", Size.SMALL); 
		r1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(0).equals(cf) );
		assertTrue(r1.getBeverage(1).equals(al) );
		assertTrue(r1.getBeverage(2).equals(sm1) );
		assertFalse(r1.getBeverage(2).equals(sm2) );
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException   {
		
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("regular Coffee", Size.SMALL, false,false);
	 	assertTrue(r1.getBeverage(0).getType().equals(Type.COFFEE));
		r1.addNewBeverage("Mohito", Size.SMALL); 
		assertTrue(r1.getBeverage(1).getType().equals(Type.ALCOHOL));
		r1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(r1.getTotalItems() == 3);
		
		r2.addNewBeverage("Detox", Size.MEDIUM,4,true); 
		assertTrue(r2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		r2.addNewBeverage("Mohito", Size.SMALL); 
		assertTrue(r2.getBeverage(1).getType().equals(Type.ALCOHOL));
		r2.addNewBeverage("regular Coffee", Size.MEDIUM, true,false);
		assertTrue(r2.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(r2.getTotalItems() == 3);
		 
	}
	 
	 
	@Test
	public void testCalcOrderTotal()   {
		r1.addNewBeverage("regular Coffee", Size.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", Size.SMALL); 
		r1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
	 
		assertEquals(7.5,r1.calcOrderTotal(),.01);
		
		r2.addNewBeverage("regular Coffee", Size.MEDIUM, true,false);
	 	r2.addNewBeverage("Mohito", Size.SMALL); 
		r2.addNewBeverage("Detox", Size.MEDIUM,4,true); 
		
		assertEquals(12.6,r2.calcOrderTotal(),.01);
		 
	}
	
	 
 

}
