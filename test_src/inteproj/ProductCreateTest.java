package inteproj;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductCreateTest {

	@Test
	public void createProductTest() {
		// We test constructor indirectly by checking getName. (Is there a direct way to check the constructor?)
		Product p = new Product("Banan", 15);
		assertEquals("Banan", p.getName());
	}
	
	@Test
	public void ProductPriceTest(){
		Product p = new Product("Banan", 15);
		assertEquals(15, p.getPrice(), 0.00001);
	}

}
