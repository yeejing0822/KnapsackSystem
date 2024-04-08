import java.util.Arrays;
import java.util.Comparator;


public class Item {

	//	instance variables
	private String i;		// to store item name
	private double w;			// to store item weight
	private Double v;			// to store item value
	private Double ratio;		// to store the ratio of the item
	
	//	getter
	public String getI() {
		
		return i;
	}
	
	public double getW() {
		
		return w;
	}

	public Double getV() {
		
		return v;
	}
	
	public Double getRatio() {
		
		return ratio;
	}

	//	setter
	public void setI(String value) {
		
		i = value;
	}

	public void setW(double value) {
		
		w = value;
	}
	
	public void setV(Double value) {
		
		v = value;
	}
	
	public void setRatio(Double value) {
		
		ratio = value;
	}

	//	constructor with three parameters, which are item name (i), item weight (w) and item value (v)
	public Item(String i, double w, Double v) {
		
		super();
		this.i = i;
		this.w = w * 1.00f;
		this.v = v * 1.00f;
		this.ratio = v * 1.00f / w;		// ratio = value / weight
	}
}
