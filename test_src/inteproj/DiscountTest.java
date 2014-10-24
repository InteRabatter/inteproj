package inteproj;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscountTest {
	
	@Test
	public void minimumTest() {
		Discount d = new Discount(3, 10, Discount.DiscountType.PERCENTAGE);
		
		assertEquals(3, d.getMinimumPurchaseAmount(), 0.01);
	}
	
	@Test
	public void amountTest(){
		Discount d = new Discount(3, 10, Discount.DiscountType.PERCENTAGE);
		
		assertEquals(10, d.getDiscountValue(), 0.01);
	}
	
	@Test
	public void discountTypePercentageTest(){
		Discount d = new Discount(5, 0.2, Discount.DiscountType.PERCENTAGE);
		
		Receipt r  = new Receipt();
		Product p = new Product("Blomma", 15);
		
		p.setDiscount(d);
		r.add(p, 5);
		
		assertEquals(60, r.getTotal(), 0.001);
	}
	
	@Test
	public void discountTypeAbsoluteTest(){
		Discount d = new Discount(0, 10, Discount.DiscountType.ABSOLUTE);
		
		Receipt r  = new Receipt();
		Product p = new Product("Blomma", 15);
		
		p.setDiscount(d);
		r.add(p, 5);
		
		assertEquals(25, r.getTotal(), 0.001);
	}
	
	@Test
	public void zeroMinimumPurchaseAmountTest(){
		/*
		 * EclEmma is claiming we don't have coverage for a discount with a minimumPurchaseAmount == 0
		 * so we wrote this test specificaly for that.
		 * EclEmma is still complaining. Bad times :(
		 * */
		Discount d = new Discount(0, 1, Discount.DiscountType.ABSOLUTE);
		
		Receipt r = new Receipt();
		
		Product p = new Product("Godis", 100);
		p.setDiscount(d);
		
		r.add(p, 1);
		
		assertEquals(99, r.getTotal(), 0.001);
	}

}
