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
				
				Product prod = e.getKey();
				Discount disc = prod.getDiscount();
				
				if(disc == null){
					return (double)(e.getKey().getPrice() * e.getValue());
				}else{
					double normalPrice = prod.getPrice();
					double discountPrice = prod.getPrice() - (prod.getPrice() * (disc.getValue() / 100));
					
					double discProdsCount = Math.floor(e.getValue() / disc.getMinimum()) * disc.getMinimum();
					double nonDiscProdsCount = e.getValue() % disc.getMinimum();
					
					return normalPrice * nonDiscProdsCount + discountPrice * discProdsCount;
				}
			}
			
		}
		return 0;
	}
	
	public double getTotal(){
		
		double total = 0;
		
		for (Entry<Product, Double> e : products.entrySet()){
			total += e.getKey().getPrice() * e.getValue();
		}
		
		if(this.discount != null){
			if(total >= discount.getMinimum()){
				return total - total * (discount.getValue() / 100);
			}
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
