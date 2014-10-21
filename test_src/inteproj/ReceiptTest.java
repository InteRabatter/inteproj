package inteproj;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceiptTest {

	@Test
	public void SubTotalTest() {
		Receipt k = new Receipt();
		Product p = new Product("Äpple", 5);
		
		k.add(p, 1);
		k.add(p, 1);
		k.add(p, 1);
		
		assertEquals(15, k.getLineSubTotal(1), 0.0000001);
	}
	
	@Test
	public void SubTotalWithDiscountTest(){
		Receipt k = new Receipt();
		Product p = new Product("Äpple", 5);
		Discount d = new Discount(3, 10);
		
		p.setDiscount(d);
		
		k.add(p, 1);
		k.add(p, 1);
		k.add(p, 1);
		
		assertEquals(13.5, k.getLineSubTotal(1), 0.0000001);
	}
	
	@Test
	public void TotalTest(){
		Receipt k = new Receipt();
		Product p1 = new Product("Äpple", 5);
		Product p2 = new Product("Päron", 8);
		Product p3 = new Product("Tomat", 3);
		
		k.add(p1, 2);
		k.add(p1, 1);
		k.add(p2, 4);
		k.add(p3, 0.5);
		
		assertEquals(48.5, k.getTotal(), 0.0000001);
	}
	
	@Test
	public void TotalWithDiscountTest(){
		Receipt k = new Receipt();
		Discount d = new Discount(40, 15);
		Product p1 = new Product("Äpple", 5);
		Product p2 = new Product("Päron", 8);
		Product p3 = new Product("Tomat", 3);
		
		k.setDiscount(d);
		
		k.add(p1, 2);
		k.add(p1, 1);
		k.add(p2, 4);
		k.add(p3, 0.5);
		
		assertEquals(41.225, k.getTotal(), 0.0000001);
	}
	
	@Test
	public void DiscountGetTest(){
		Discount d = new Discount(2, 50);
		Receipt k = new Receipt(d);
		
		assertNotNull(k.getDiscount());
	}
	
	@Test
	public void DiscountAddTest(){
		Discount d = new Discount(2, 50);
		Receipt k = new Receipt();
		
		k.setDiscount(d);
		
		assertNotNull(k.getDiscount());
	}
	
	@Test
	public void DiscountRemoveTest(){
		Discount d = new Discount(2, 50);
		Receipt k = new Receipt(d);
		
		k.removeDiscount();
		
		assertNull(k.getDiscount());
	}

}
