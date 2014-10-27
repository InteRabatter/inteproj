package inteproj;

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
	
	public void setDiscount(Discount disc){
		this.discount = disc;
	}
	
	public void removeDiscount(){
		this.discount = null;
	}
}
