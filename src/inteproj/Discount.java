package inteproj;

public class Discount {
	
	private double minimum;
	private double value;
	
	public Discount(double minimum, double value){
		this.minimum = minimum;
		this.value = value;	// discount value in fractions.
	}
	
	public double getMinimum(){
		return this.minimum;
	}
	
	public double getValue(){
		return this.value;
	}
}
