package inteproj;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiscountTest {
	
	@Test
	public void minimumTest() {
		Discount d = new Discount(3, 10);
		
		assertEquals(3, d.getMinimum(), 0.01);
	}
	
	@Test
	public void amountTest(){
		Discount d = new Discount(3, 10);
		
		assertEquals(10, d.getValue(), 0.01);
	}

}
