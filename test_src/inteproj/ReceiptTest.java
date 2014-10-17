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

}
