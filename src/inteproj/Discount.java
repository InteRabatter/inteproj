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
		assert minimum >= 0;
		assert value > 0;
		
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
		assert originalPrice > 0;
		
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
