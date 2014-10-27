package inteproj;

public class Discount {
	
	private double minimumPurchaseAmount;
	private double discountValue;
	private DiscountType typeFlag;
	
	public enum DiscountType{
		PERCENTAGE,
		ABSOLUTE
	}
	
	public Discount(double minimum, double value, DiscountType typeFlag){
		if(minimum < 0) throw new IllegalArgumentException("Minimum purchase amount required cannot be negative.");
		if(value <= 0) throw new IllegalArgumentException("Discount value cannot be 0 or below.");
		
		this.minimumPurchaseAmount = minimum;
		this.discountValue = value;	// discount value in fractions.
		this.typeFlag = typeFlag;
	}
	
	public double getMinimumPurchaseAmount(){
		return this.minimumPurchaseAmount;
	}
	
	public double getDiscountValue(){
		return this.discountValue;
	}
	
	public double getDiscountedPrice(double originalPrice){
		if(originalPrice <= 0) throw new IllegalArgumentException("The starting price cannot be 0 or below.");
		
		double newPrice = 0;
		
		switch(typeFlag){
			case PERCENTAGE:
				newPrice = originalPrice * (1 - discountValue);
			break;
			case ABSOLUTE:
				newPrice = originalPrice - discountValue;
			break;
			default:
			break;
		}
		
		return newPrice;
	}
}
