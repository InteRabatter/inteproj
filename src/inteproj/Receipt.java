package inteproj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Receipt {

	private HashMap<Product, Double> products = new HashMap<Product, Double>();
	private ArrayList<Product> productIndex = new ArrayList<Product>();
	private Discount discount = null;
	
	public Receipt(){
		
	}
	
	public Receipt(Discount disc){
		this.discount = disc;
	}
	
	public void add(Product p, double unitValue){
		if(products.containsKey(p)){	// Check if the product exists in the HashMap
			products.put(p, unitValue + products.get(p));
		}else{
			products.put(p, unitValue);
			productIndex.add(p);
		}
	}
	
	public double getLineSubTotal(int lineIndex){
		
		Product prod = productIndex.get(lineIndex - 1);
		Discount disc = prod.getDiscount();
		
		if(disc == null){
			return prod.getPrice() * products.get(prod);
		}else{
			double normalPrice = prod.getPrice();
			double discountPrice = prod.getPrice() - (prod.getPrice() * (disc.getValue()));
			
			if(disc.getMinimum() == 0){
				// Special case, if minimum required amount is zero you get a discount on the entire subtotal.
				return discountPrice * products.get(prod); 
			}
			
			double discProdsCount = Math.floor(products.get(prod) / disc.getMinimum()) * disc.getMinimum();
			double nonDiscProdsCount = products.get(prod) % disc.getMinimum();
			
			return normalPrice * nonDiscProdsCount + discountPrice * discProdsCount;
		}
		
		
		
		
		/*	Commented away old, faulty solution.
		
		// A hashmap does not have index so let's iterate through it and count the iterations.
		int counter = 1;
		
		assert products != null;
		assert products.isEmpty() == false;
		
		for (Entry<Product, Double> e : products.entrySet()){
			
			if(counter == lineIndex){
				
				Product prod = e.getKey();
				Discount disc = prod.getDiscount();
				
				if(disc == null){
					return (double)(e.getKey().getPrice() * e.getValue());
				}else{
					double normalPrice = prod.getPrice();
					double discountPrice = prod.getPrice() - (prod.getPrice() * (disc.getValue()));
					
					if(disc.getMinimum() == 0){
						// Special case, if minimum required amount is zero you get a discount on the entire subtotal.
						return discountPrice * e.getValue(); 
					}
					
					double discProdsCount = Math.floor(e.getValue() / disc.getMinimum()) * disc.getMinimum();
					double nonDiscProdsCount = e.getValue() % disc.getMinimum();
					
					return normalPrice * nonDiscProdsCount + discountPrice * discProdsCount;
				}
			}
			counter++;
		}
		return 0;	// We tried assert but we don't fully understand it, so here have a zero.
		
		*/
	}
	
	public double getTotal(){
		
		double total = 0;
		
		/* Commented away, we used the below loop instead because it's nicer.
		for(int i = 0; i < productIndex.size(); i++){
			total += productIndex.get(i).getPrice() * products.get(productIndex.get(i));
		}
		*/
		
		for(Entry<Product, Double> e : products.entrySet()){
			total += e.getValue() * e.getKey().getPrice();
		}
		
		if(this.discount != null){
			if(total >= discount.getMinimum()){
				return total - total * discount.getValue();
			}
		}
		
		return total;
		
		/* old solution
		double total = 0;
		
		for (Entry<Product, Double> e : products.entrySet()){
			total += e.getKey().getPrice() * e.getValue();
		}
		
		if(this.discount != null){
			if(total >= discount.getMinimum()){
				return total - total * (discount.getValue());
			}
		}
		return total;
		*/
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
