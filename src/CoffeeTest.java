import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTest {

	Coffee c1,c2,c3,c4;
	@Before
	public void setUp() throws Exception {
		c1 = new  Coffee ("c1Name", Size.SMALL, false,false ); // My enum named Size
		c2 = new  Coffee ("c2NAme", Size.MEDIUM, true,true );
		c3 = new  Coffee ("c3NAme", Size.LARGE, false, true );
		c4 = new  Coffee ("c4NAme", Size.SMALL, true, false );
		
	}

	@After
	public void tearDown() throws Exception {
		c1=c2=c3=c4=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,c1.getBasePrice(), .01);
		assertEquals(2.0,c2.getBasePrice(), .01);
		assertEquals(2,c3.getBasePrice(), .01);
		assertEquals(2,c4.getBasePrice(), .01);
	}

	@Test
	public void testCalPrice() {
		
		assertEquals(2,c1.calcPrice(), .01 );
		assertEquals(4,c2.calcPrice(), .01 );
		assertEquals(4.5,c3.calcPrice(), .01 );
		assertEquals(2.5,c4.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		
		assertTrue(c1.toString().contains(c1.getBevName()));
		assertTrue(c1.toString().contains(String.valueOf(c1.calcPrice()) ));
		assertTrue(c1.toString().contains(c1.getSize().toString() ));
	 
	 
	}
}
