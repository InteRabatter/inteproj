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
	
	public void add(Product prod, double unitValue){
		if(unitValue < 0) throw new IllegalArgumentException("unitValue cannot be negative.");
		if(prod == null) throw new IllegalArgumentException("Product must not be null.");
		
		if(products.containsKey(prod)){	// Check if the product exists in the HashMap
			products.put(prod, unitValue + products.get(prod));
		}else{
			products.put(prod, unitValue);
			productIndex.add(prod);
		}
	}
	
	public double getItemSubTotal(int rowNumber){
		
		if(rowNumber <= 0) throw new IllegalArgumentException("RowNumber must 1 or higher.");
		
		Product prod = productIndex.get(rowNumber - 1);
		Discount disc = prod.getDiscount();
		
		if(disc == null){
			return prod.getPrice() * products.get(prod);
		}else{
			double normalPrice = prod.getPrice();
			double discountPrice = disc.getDiscountedPrice(prod.getPrice());
			
			if(disc.getMinimumPurchaseAmount() == 0){
				// Special case, if minimum required amount is zero you get a discount on the entire subtotal.
				return discountPrice * products.get(prod); 
			}
			
			double discProdsCount = Math.floor(products.get(prod) / disc.getMinimumPurchaseAmount()) * disc.getMinimumPurchaseAmount();
			double nonDiscProdsCount = products.get(prod) % disc.getMinimumPurchaseAmount();
			
			return normalPrice * nonDiscProdsCount + discountPrice * discProdsCount;
		}
	}
	
	public double getTotal(){
		
		double total = 0;
		
		for(Entry<Product, Double> entry : products.entrySet()){
			Product p = entry.getKey();
			double quantity = entry.getValue();
			
			if(p.getDiscount() != null)
				total += p.getDiscount().getDiscountedPrice((p.getPrice())) * quantity;
			else
				total += p.getPrice() * quantity;
		}
		
		if(this.discount != null){
			if(total >= discount.getMinimumPurchaseAmount()){
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
