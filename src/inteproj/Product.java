package inteproj;


/*
 Klassen Product håller koll på information om varornas namn och orginalpris, och om en vara har en eventuell rabatt 
 */

public class Product {

	private String name;
	private double price;
	private Discount discount = null;
	
	public Product(String name, double price){
		if(name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
		if(price <= 0) throw new IllegalArgumentException("Price cannot be 0 or below.");
		
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, double price, Discount disc){
		if(name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
		if(price <= 0) throw new IllegalArgumentException("Price cannot be 0 or below.");
		
		this.name = name;
		this.price = price;
		this.discount = disc;
	}
	
	public String getName(){
		
		return this.name;
		
	}
	
	public double getPrice(){
		
		return this.price;
		
	}
	
	public Discount getDiscount(){
		return this.discount;
	}
	
	/*
	 Metoden kontrollerar så att en rabatt inte kan vara större eller lika med priset på produkten.
	 */
	public void setDiscount(Discount disc){
		if(disc.getType() == Discount.DiscountType.ABSOLUTE && disc.getDiscountValue() >= this.price)
			throw new IllegalStateException("Discount value cannot be equal to product price or above.");
		this.discount = disc;
	}
	
	public void removeDiscount(){
		this.discount = null;
	}
}
