
import java.util.*;

public class Menu {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		//	enable user to input
		
		//	call menuHeader() method
		menuHeader();
		
		//	print title of knapsack information
		System.out.println("\nKnapsack Information:\n");

		try {
			
			// read maximum capacity of knapsack from user input
			System.out.print("Maximum capacity of knapsack (in kg): ");
			double c = input.nextInt();

			// read number of items from user input
			System.out.print("Number of items: ");
			int n = input.nextInt();
		
			Item items;		//	declare an object
			Item[] itemList = new Item[n + 1];		//	create an object and allocating memory to the object
			
			//	print menu header and title of item information
			System.out.println("\n\nItem Information:");
			
			//	initialize the first element of itemList
			itemList[0] = null;
			
			// assign 1 into count
			int count = 1;
		
			//	repeat while count is less than number of items
			while (count <= n) {
				
				//	print which number of items
				System.out.format("\nItem %d", count);
				
				//	read item name from user input
				System.out.print("\nItem Name: ");
				String i = input.next();
				
				//	read item weight from user input
				System.out.print("Weight (in kg): ");
				double w = input.nextDouble();
				
				//	read item value from user input
				System.out.print("Value (in RM): ");
				Double v = input.nextDouble();
				
				//	create an object
				items = new Item(i, w, v);
				
				//	initialize the elements of the itemList
				itemList[count++] = items;
			}

			//	call displayMenu()
			displayMenu();

			//	assign 0 to choice
			int choice = getChoice();
			
			//	call runAction() method
			runAction(choice, c, n, itemList);
		}
		
		catch (InputMismatchException ex) {
			
			System.out.println("\nYour Input Is In Wrong Format.");
			System.exit(1);
		}
	}
	
	//	a method to display menu header
	public static void menuHeader() {
		
		System.out.println("**************************************************");
		System.out.println("|                   Welcome To                   |");
		System.out.println("|                Knapsack System                 |");
		System.out.println("**************************************************");
	}
	
	//	a method to display menu option
	public static void displayMenu() {
		
		//	print menu selection
		System.out.println("\n\nMenu Selection:");
		System.out.println("1. Retype Knapsack And Item Information");
		System.out.println("2. Greedy Algorithm (Fractional)");
		System.out.println("3. Dynamic Programming (1-0)");
		System.out.println("4. Exit");
		
		//	print definition of fractional and 1-0 knapsack
		System.out.println("\nFractional Knapsack - You can break items for maximizing the total value of knapsack. ");
		System.out.println("1-0 Knapsack - You cannot break an item, either pick the complete item or don’t pick it (0-1 property).");
	}
	
	//	a method to read user selection
	public static int getChoice() {
		
		Scanner input = new Scanner(System.in);		//	enable user to input
		
		//	assign 0 to choice
		int choice = 0;
		
		while(choice < 1 || choice > 4) {
			
			try {
				
				//	read choice from user input
				System.out.print("\nPlease Enter Your Selection (1-4) : ");
				choice = Integer.parseInt(input.nextLine());
				
				if(choice < 1 || choice > 4)
					throw new NumberFormatException();
			}
			
			catch (NumberFormatException ex) {
				
				System.out.println("\nYour Selection Is Invalid. Please Try Again");
			}
		}

		return choice;		//	return the user choice
	}
	
	//	a method use to run the user selected solution
	public static void runAction(int choice, double c, int n, Item[] itemList) {
		
		switch (choice) {
		
			case 1:		//	call main() method
				for (int i = 0; i < 50; i ++)		//	bring user to next 50 lines
					System.out.println();
				String[] str = new String[1];
				main(str);
			
			case 2:		//	Greedy Algorithm
				ga(c, n, itemList);
				break;
			
			case 3:		//	Dynamic Programming
				dp(c, n, itemList);
				break;
			
			case 4:		//	Exit the system
				System.out.println("\n\nYou Are Exit Now, Thank You");
				System.exit(1);
				break;
				
			default:	//	default case
				break;
			
		}
	}

	//	a method use to perform Dynamic Programming
	public static void dp(double c, int n, Item[] itemList) {
		
		// create an objects of DynamicProgramming class
		DynamicProgramming dp = new DynamicProgramming(c, n);		
				
		//	call the applyDP() method using object dp
		//	Initialize the return value from applyDP() method to the totalItemValue
		dp.applyDP(c, n, itemList);
				
		//	call displayResult() method
		displayDPResult(c, n, itemList, dp);
	}

	//	a method to display the Dynamic Programming final result
	public static void displayDPResult(double c, int n, Item[] itemList, DynamicProgramming dp) {
		
		//	call displaySelectedItems() using object dp
		dp.displaySelectedItems(c, n, itemList);

		//	call displayMenu()
		displayMenu();

		//	assign 0 to choice
		int choice = getChoice();
		
		//	call runAction() method
		runAction(choice, c, n, itemList);
	}
	
	//	a method use to perform Greedy Algorithm
	public static void ga(double c, int n, Item[] itemList) {
				
		// create an objects of GreedyAlgorithm class
		GreedyAlgorithm ga = new GreedyAlgorithm(n);
		
		//	call the applyGA() method using object ga
		ga.applyGA(c, n, itemList);
					
		//	call displayResult() method
		displayGAResult(c, n, itemList, ga);
	}
	
	//	a method to display the Greedy Algorithm final result
	public static void displayGAResult(double c, int n, Item[] itemList, GreedyAlgorithm ga) {
		
		//	call displaySelectedItems() using object ga
		ga.displaySelectedItems(c, n, itemList);

		//	call displayMenu()
		displayMenu();

		//	assign 0 to choice
		int choice = getChoice();
		
		//	call runAction() method
		runAction(choice, c, n, itemList);
	}
}