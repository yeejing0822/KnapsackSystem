import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {

	//	declare instance variables
	private double[] itemValue;			//	to store item value that can be put in a knapsack with a maximum capacity
	private double[] itemWeight;			//	to store the total weight of the selected items
	private double totalValue;			//	to store total value of the selected items
	private double totalWeight;			//	to store total weight of the selected items
	
	//	getter
	public double[] getitemValue() {
		
		return itemValue;
	}
	
	public double[] getItemWeight() {
		
		return itemWeight;
	}
	
	public double getTotalValue() {
		
		return totalValue;
	}
	
	public double getTotalWeight() {
		
		return totalWeight;
	}
	
	//	setter
	public void setItemValue(double[] value) {
		
		itemValue = value;
	}
	
	public void setItemWeight(double[] value) {
		
		itemWeight = value;
	}
	
	public void setTotalValue(double value) {
		
		totalValue = value;
	}
	
	public void setTotalWeight(double value) {
		
		totalWeight = value;
	}
	
	//	constructor with one parameter which is number of items (n)
	public GreedyAlgorithm(int n) {
		super();
		itemValue = new double[n + 1];		//	allocating memory to array
		itemWeight = new double[n + 1];		//	assign 0 to itemWeight
		totalValue = 0.00f;					//	assign 0 to totalValue
		totalWeight = 0.00f;				//	assign 0 to totalWeight
	}
	
	//	a method to apply the Greedy Algorithm
	public void applyGA(double c, int n, Item[] itemList) {
		
		double capacity = c * 1.00f;		//	set c to double and assign it to capacity
		
		//	sorting items by item ratio
		Arrays.sort(itemList, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2)
			{
				int compareResult = 0;
				
				if(i1 != null && i2 != null)
					compareResult = i2.getRatio().compareTo(i1.getRatio());
				
				return compareResult;
			}
		});
		
		for (int item = 0; item <= n; item++) {
			
			if (item == 0) {					//	if index of itemList is 0
				
				itemValue[item] = 0.00f;		//	initialize the first element of itemValue
				itemWeight[item] = 0.00f;		//	initialize the first element of itemWeight
			}
			
			else if (itemList[item].getW() <= capacity) {		//	if this item weight is less than or equal to capacity left
				
				capacity -= itemList[item].getW();				//	calculate the capacity left in the knapsack
				itemWeight[item] = itemList[item].getW();		//	initialize the elements of the itemWeight
				itemValue[item] = itemList[item].getV();		//	initialize the elements of itemValue
				totalWeight += itemWeight[item];						//	perform adding on the totalWeight
				totalValue += itemValue[item];							//	perform adding on the totalValue
			}
			
			else {														//	if this item weight is greater than capacity left
				
				double fraction = capacity / itemList[item].getW();		//	calculate the capacity left in the knapsack
				itemWeight[item] = fraction * itemList[item].getW();	//	calculate the weight of item that is adding into the knapsack
				itemValue[item] = fraction * itemList[item].getV();		//	initialize the elements of the itemValue
				totalWeight += itemWeight[item];						//	perform adding on the totalWeight
				totalValue += itemValue[item];							//	perform adding on the totalValue
				break;		// stop the for loop
			}
		}
	}
	
	//	a method to display all the details of items that are selected to put into knapsack
	//	including item name, item weight and item value
	public void displaySelectedItems(double c, int n, Item[] itemList) {
		
		int item = n;		//	declare item in type integer and assign number of items (n) into it
		
		//	print the header of selected items details
		System.out.println("\n\nRecommended Items:");
		System.out.println(" ---------------------- ------------- ------------ ");
		System.out.format("| %-20s |", "Item Name");
		System.out.format(" %-11s ", "Weight (kg)");
		System.out.format("| %-10s |", "Value (RM)");
		System.out.println("\n ---------------------- ------------- ------------ ");
		
		
		while (item != 0) {
			
			if (itemValue[item] != 0) {
				
				System.out.format("| %-20s |", itemList[item].getI());		//	print item name
				System.out.format(" %-11.2f ", itemWeight[item]);		//	print item weight
				System.out.format("| %-10.2f |", itemValue[item]);		//	print item value
				System.out.println("\n ---------------------- ------------- ------------ ");
			}
			
			item--;		// minus index of itemList by 1
		}
		
		//		print total weight and total value that can put into the knapsack
		System.out.format("| %20s |", "TOTAL");
		System.out.format(" %-11.2f ", totalWeight);
		System.out.format("| %-10.2f |", totalValue);
		System.out.println("\n ---------------------- ------------- ------------ ");
	}
}