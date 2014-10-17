package inteproj;

import java.util.HashMap;
import java.util.Map.Entry;

public class Receipt {

	private HashMap<Product, Double> products = new HashMap<Product, Double>();
	private Discount discount = null;
	
	public Receipt(){
		
	}
	
	public Receipt(Discount disc){
		this.discount = disc;
	}
	
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
	
	public double getTotal(){
		
		double total = 0;
		
		for (Entry<Product, Double> e : products.entrySet()){
			total += e.getKey().getPrice() * e.getValue();
		}
		
		return total;
	}
	
	public void setDiscount(Discount disc){
		this.discount = disc;
	}
	
	public Discount getDiscount(){
		return this.discount;
	}
	
	public void removeDiscount(){
		this.discount = null;
	}
}
