package inteproj;

import java.util.HashMap;

public class Receipt {

	private HashMap<Product, Double> products = new HashMap<Product, Double>();
	
	public void add(Product p, double unitValue){
		if(products.containsKey(p)){
			
			products.put(p, unitValue+products.get(p));
		}
		else
			products.put(p, unitValue);
		
	}
	
	public double getLineSubTotal(int lineIndex){
		
		// A hashmap does not have index so let's iterate through it and count the iterations.
		
		for (entry e : products.entrySet()){
			
			
			
		}
		
	} 
}
