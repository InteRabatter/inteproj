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
			double discountPrice = disc.getDiscountedPrice(prod.getPrice());
			
			if(disc.getMinimum() == 0){
				// Special case, if minimum required amount is zero you get a discount on the entire subtotal.
				return discountPrice * products.get(prod); 
			}
			
			double discProdsCount = Math.floor(products.get(prod) / disc.getMinimum()) * disc.getMinimum();
			double nonDiscProdsCount = products.get(prod) % disc.getMinimum();
			
			return normalPrice * nonDiscProdsCount + discountPrice * discProdsCount;
		}
	}
	
	public double getTotal(){
		
		double total = 0;
		
		for(Entry<Product, Double> e : products.entrySet()){
			Product p = e.getKey();
			double quantity = e.getValue();
			
			if(p.getDiscount() != null)
				total += p.getDiscount().getDiscountedPrice((p.getPrice())) * quantity;
			else
				total += p.getPrice() * quantity;
		}
		
		if(this.discount != null){
			if(total >= discount.getMinimum()){
				return discount.getDiscountedPrice(total);
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
