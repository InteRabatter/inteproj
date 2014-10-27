package inteproj;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscountTest {
	
	@Test
	public void minimumTest() {
		Discount d = new Discount(3, 0.1, Discount.DiscountType.PERCENTAGE);
		
		assertEquals(3, d.getMinimumPurchaseAmount(), 0.01);
	}
	
	@Test
	public void amountTest(){
		Discount d = new Discount(3, 0.1, Discount.DiscountType.PERCENTAGE);
		
		assertEquals(0.1, d.getDiscountValue(), 0.01);
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
	public void zeroPurchaseAmountonReceiptTest(){
		Discount d = new Discount(0, 1/10d, Discount.DiscountType.PERCENTAGE);
		Receipt r = new Receipt();
		Product p = new Product("Ice", 0.1);
		
		r.add(p, 500);
		p.setDiscount(d);
		
		assertEquals(45, r.getItemSubTotal(1), 0.001);
	}
	
	@Test
	public void equivalenceClassPartitioningNr2Test(){
		Discount d = new Discount(5, 20, Discount.DiscountType.ABSOLUTE);
		Receipt r  = new Receipt();
		Product p = new Product("Candy", 50);

		p.setDiscount(d);
		r.add(p, 2);
		
		assertEquals(60, r.getTotal(), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr3Test(){
		Discount d = new Discount(-1, 4, Discount.DiscountType.PERCENTAGE);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr4Test(){
		Discount d = new Discount(8, -1, Discount.DiscountType.PERCENTAGE);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr5Test(){
		Discount d = new Discount(8, -1, Discount.DiscountType.ABSOLUTE);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr6Test(){
		Discount d = new Discount(8, 1.2, Discount.DiscountType.PERCENTAGE);
	}
	
	@Test(expected=IllegalStateException.class)
	public void equivalenceClassPartitioningNr7Test(){
		Discount d = new Discount(8, 100, Discount.DiscountType.ABSOLUTE);
		Product p = new Product("Balloon", 4.95);
		
		p.setDiscount(d);
	}
	
	@Test
	public void equivalenceClassPartitioningNr8Test(){
		Discount d = new Discount(0, 0.04, Discount.DiscountType.PERCENTAGE);
		Receipt r  = new Receipt();
		Product p = new Product("Blomma", 10);
		
		p.setDiscount(d);
		r.add(p, 1);
		
		assertEquals(9.6, r.getTotal(), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr9Test(){
		Discount d = new Discount(8, 0, Discount.DiscountType.PERCENTAGE);
		Receipt r  = new Receipt();
		Product p = new Product("Blomma", 10);
		
		p.setDiscount(d);
		r.add(p, 8);
		
		assertEquals(80, r.getTotal(), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr10Test(){
		Discount d = new Discount(8, 1, Discount.DiscountType.PERCENTAGE);
	}
	
	@Test(expected=IllegalStateException.class)
	public void equivalenceClassPartitioningNr11Test(){
		Discount d = new Discount(8, 10, Discount.DiscountType.ABSOLUTE);
		Product p = new Product("Blomma", 10);
		
		p.setDiscount(d);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void equivalenceClassPartitioningNr12Test(){
		Discount d = new Discount(8, 0, Discount.DiscountType.ABSOLUTE);
	}
	
	@Test
	public void stateMachineTest(){
		Receipt r = new Receipt();
		Product banan = new Product("Banan", 9);
		Product kaffe = new Product("Kaffe", 39);
		Product tomat = new Product("Tomat", 2.9);
		Product melon = new Product("Melon", 12);
		Product apelsin = new Product("Apelsin", 5);
		Discount d = new Discount(3, 1/3d, Discount.DiscountType.PERCENTAGE);
		
		banan.setDiscount(d);
		
		r.add(kaffe, 1);
		r.add(banan, 1);
		r.removeProduct(kaffe);
		r.add(tomat, 1);
		r.add(banan, 1);
		r.add(melon, 1);
		r.removeProduct(banan);
		r.add(apelsin, 1);
		r.add(banan, 1);
		r.removeProduct(banan);
		r.removeProduct(banan);
		r.add(banan, 1);
		r.add(banan, 1);
		r.add(banan, 1);
		
		assertEquals(18, r.getItemSubTotal(4), 0.001);
	}

}
