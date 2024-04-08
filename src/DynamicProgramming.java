import java.util.Arrays;
import java.util.Comparator;

public class DynamicProgramming {
	
	//	declare instance variables
	private double[][] itemValue;		//	to store the item value that can be put in a knapsack with a maximum capacity
	private double itemWeight;			//	to store the total weight of the selected items
	
	//	getter
	public double[][] getitemValue() {
		
		return itemValue;
	}
	
	public double getItemWeight() {
		
		return itemWeight;
	}
	
	//	setter
	public void setItemValue(double[][] value) {
		
		itemValue = value;
	}
	
	public void setItemWeight(double value) {
		
		itemWeight = value;
	}
	
	//	constructor with two parameters, which are maximum capacity of knapsack (c) and number of items (n)
	public DynamicProgramming(double c, int n) {
		
		itemValue = new double[n + 1][(int)c + 1];		//	allocating memory to array
		itemWeight = 0.00f;					//	assign 0 to itemWeight
	}
	
	//	a method to apply the Dynamic Programming Algorithm
	public void applyDP(double c, int n, Item[] itemList) {
		
		//		sorting items by item value
		Arrays.sort(itemList, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2)
			{
				int compareResult = 0;
				
				if(i1 != null && i2 != null)
					compareResult = i2.getV().compareTo(i1.getV());
				
				return compareResult;
			}
		});
		
		for (int item = 0; item <= n; item++) {
			
			for (int capacity = 0; capacity <= c; capacity++) {
				
				//	base case
				if (item == 0 || capacity == 0)					//	set the itemValue to 0 if the index of row (item) and column (capacity) in itemValue is equal to 0
					itemValue[item][capacity] = 0;				
				
				//	recursive calls
				else if (itemList[item].getW() > capacity)		//	if this item weight is bigger than the capacity left
					itemValue[item][capacity] = itemValue[item-1][capacity];
				else											//	if this item weight is smaller or equal to the capacity left
					itemValue[item][capacity] = 
					Math.max(itemValue[item-1][capacity-(int)(Math.ceil(itemList[item].getW()))] + itemList[item].getV(), itemValue[item-1][capacity]);
			}
		}
	}
	
	//	a method to display all the details of items that are selected to put into knapsack
	//	including item name, item weight and item value
	public void displaySelectedItems(double c, int n, Item[] itemList) {
		
		int item = n;			//	declare item in type integer and assign number of items (n) into it
		int capacity = (int)c;		//	declare capacity in type integer and assign maximum capacity of knapsack (c) into it
		
		//	print the header of selected items details
		System.out.println("\n\nRecommended Items:");
		System.out.println(" ---------------------- ------------- ------------ ");
		System.out.format("| %-20s |", "Item Name");
		System.out.format(" %-11s ", "Weight (kg)");
		System.out.format("| %-10s |", "Value (RM)");
		System.out.println("\n ---------------------- ------------- ------------ ");
		
		while (item != 0) {
			
			if (itemValue[item][capacity] != itemValue[item-1][capacity]) {		//	if the value at current place is not equal to the value at previous row same column
				
				System.out.format("| %-20s |", itemList[item].getI());		//	print item name
				System.out.format(" %-11.2f ", itemList[item].getW());		//	print item weight
				System.out.format("| %-10.2f |", itemList[item].getV());		//	print item value
				System.out.println("\n ---------------------- ------------- ------------ ");
				
				itemWeight += itemList[item].getW();		//	add this item weight into selected item weight
				
				capacity -= itemList[item].getW();			//	minus total capacity left with this item weight
			}
			
			item--;		// minus index of itemList by 1
		}
		
		//	print total weight and total value that can put into the knapsack
		System.out.format("| %20s |", "TOTAL");
		System.out.format(" %-11.2f ", itemWeight);
		System.out.format("| %-10.2f |", itemValue[n][(int)c]);
		System.out.println("\n ---------------------- ------------- ------------ ");
	}
}
