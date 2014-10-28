package inteproj;

import java.util.ArrayList;
import java.util.List;

public class Inteproj {

	public static void main(String[] args) {
		// Our little testing prog
		
		Product vara1 = new Product("Klubba", 10);
		Product vara2 = new Product("Glass", 12);
		Product vara3 = new Product("Gurka", 25.90);
		Product vara4 = new Product("Banan", 19.90);
		
		
		Discount disc1 = new Discount(3, 1/3d, Discount.DiscountType.PERCENTAGE);
		Discount disc2 = new Discount(0, 1/10d, Discount.DiscountType.PERCENTAGE);
		Discount disc3 = new Discount(20, 1/20d, Discount.DiscountType.PERCENTAGE);
		
		System.out.println(disc1.getDiscountValue());
		System.out.println(disc2.getDiscountValue());
		System.out.println(disc3.getDiscountValue());
		
		System.out.println("--");
		
		vara2.setDiscount(disc1);
		vara4.setDiscount(disc2);
		
		Receipt kvitto = new Receipt();
		
		kvitto.setDiscount(disc3);
		kvitto.add(vara1, 20);
		kvitto.add(vara2, 5);
		kvitto.add(vara3, 1.5);
		kvitto.add(vara4, 2.3);
		kvitto.add(vara4, 2);
		
		System.out.println(kvitto.getItemSubTotal(1));
		System.out.println(kvitto.getItemSubTotal(2));
		System.out.println(kvitto.getItemSubTotal(3));
		System.out.println(kvitto.getItemSubTotal(4));
		System.out.println(kvitto.getTotal());
		
		
		/*		2014-10-16
		List<Product> lista = new ArrayList<Product>();
		Product vara = new Product("Mango", 8);
		
		lista.add(vara);
		
		Receipt r = new Receipt();
		r.add(vara, 1);
		r.add(vara, 1);
		
		r.tester();
		*/
	}

}
