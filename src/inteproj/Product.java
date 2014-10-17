package inteproj;

public class Product {

	private String name;
	private double price;
	private Discount discount = null;
	
	public Product(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public Product(String name, double price, Discount disc){
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
