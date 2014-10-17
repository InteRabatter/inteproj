package inteproj;

import java.util.HashMap;
import java.util.Map.Entry;

public class Receipt {

	private HashMap<Product, Double> products = new HashMap<Product, Double>();
	
	public void add(Product p, double unitValue){
		if(products.containsKey(p)){
			
			products.put(p, unitValue+products.get(p));
		}
		else
			products.put(p, unitValue);
		
	}
	
	public double getLineSubTotal(double lineIndex){
		
		// A hashmap does not have index so let's iterate through it and count the iterations.
		int counter = 1;
				
		for (Entry<Product, Double> e : products.entrySet()){
			
			if(counter == lineIndex){
				
				return (double)(e.getKey().getPrice() * e.getValue());
				
			}
			
		}
		return 0;
	} 
}
