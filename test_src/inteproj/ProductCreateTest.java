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
	public void createProductTest2(){
		// Let's test the second constructor! Why? Because we must have 100% coverage!
		Discount d = new Discount(4, 20);
		Product p = new Product("Banan", 15, d);
		assertEquals("Banan", p.getName());
	}
	
	@Test
	public void ProductPriceTest(){
		Product p = new Product("Banan", 15);
		assertEquals(15, p.getPrice(), 0.00001);
	}
	
	@Test
	public void DiscountGetTest(){
		Discount d = new Discount(4, 20);
		Product p = new Product("Banan", 15, d);
		
		assertNotNull(p.getDiscount());
	}
	
	@Test
	public void DiscountAddTest(){
		Discount d = new Discount(4, 20);
		Product p = new Product("Banan", 15);
		p.setDiscount(d);
		
		assertNotNull(p.getDiscount());
	}
	
	@Test
	public void DiscountRemoveTest(){
		Discount d = new Discount(4, 20);
		Product p = new Product("Banan", 15, d);
		p.removeDiscount();
		
		assertNull(p.getDiscount());
	}

}
