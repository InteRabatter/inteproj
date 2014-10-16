package inteproj;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductCreateTest {

	@Test
	public void createProductTest() {
		Product p = new Product("Banan", 15);
		assertEquals("Banan", p.getName());
	}

}
