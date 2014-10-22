package inteproj;

public class Discount {
	
	private double minimum;
	private double value;
	private DiscountType type;
	
	public enum DiscountType{
		PERCENTAGE,
		ABSOLUTE
	}
	
	public Discount(double minimum, double value, DiscountType typeFlag){
		this.minimum = minimum;
		this.value = value;	// discount value in fractions.
		this.type = typeFlag;
	}
	
	public double getMinimum(){
		return this.minimum;
	}
	
	public double getValue(){
		return this.value;
	}
	
	public double getDiscountedPrice(double originalPrice){
		double newPrice = 0;
		
		switch(type){
			case PERCENTAGE:
				newPrice = originalPrice * (1 - value);
			break;
			case ABSOLUTE:
				newPrice = originalPrice - value;
			break;
		}
		
		return newPrice;
	}
}
