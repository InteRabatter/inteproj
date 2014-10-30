package inteproj;


/*
 Klassen Discount innehåller metoder för att kunna lägga till och ändra rabatter på enskilda varor, och dessutom en metod för att
 beräkna det rabatterade priset på en vara om den är rabatterad.
 */


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
		if(value >= 1 && typeFlag == Discount.DiscountType.PERCENTAGE) throw new IllegalArgumentException("The percentage value cannot be 100% or above.");
		
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
	
	/*
	 Metoden tar emot ett orginalpris och returnerar ett rabatterat pris som varierar beroende på vilken sorts
	 rabatt det är på varan.
	 */
	
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
				throw new IllegalStateException("The discount-type has not been defined.");
		}
		
		return newPrice;
	}
	
	public Discount.DiscountType getType(){
		return this.typeFlag;
	}
}
