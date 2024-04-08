Greedy Algorithm
Greedy Algorithm always offer the optimal and best choice for the system for every step in the algorithm and it can apply to a wide variety of problems. Besides,greedy Algorithm tend to code in an easy way. However, it very often does not provide a globally optimal solution. Greedy Algorithm is a kind of fractional knapsack, the item’s value is divided by the item’s weight, and sort the ratio from biggest to smallest. It will pick the items with the highest ratio and keep adding on the next items as much as possible. The items can be split for maximizing the knapsack’s total value. Once the capacity is full, it will stop adding the remaining items. 

Dynamic Programming
Dynamic Programming is a 1-0 knapsack.An overlapping subproblems and optimal substructure is required for Dynamic Programming. Items in Dynamic Programming cannot be split and it can only pick the whole complete item or do not pick the item. It is involving the recursion approach inside the Dynamic Programming. It involves all the items’ subsets and computes the total item’s value and item’s weight. After that, it will study the total weight of subsets that is smaller than the capacity and pick the subset that has the highest value.

Array List Data Structure
The size of an array cannot be changed after an array created and it is a fixed size data structure. However, dynamic data structure still can be implemented by using arrays.In the list,  if the array is not affordable to hold the new elements, a new larger array can be created to replace the array which is not affordable to hold the new elements.  

---Sample of input data and test cases---

**Greedy Algotirhm**

Test Case 1

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/3b18acd7-817c-4ce1-a406-e891be159399)

Test Case 2

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/0441b1e6-85ad-4d16-aa3f-1a4ad3930636)

**Dynamic Programming**

Test Case 1

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/cd5e4f0e-a8d8-4f3c-92af-ba6c54d6baa0)

Test Case 2

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/4676f662-e50e-4169-b1d1-3122446ae22c)

---Sample outputs of program---

**Output Of Greedy Algorithm**

Test Case 1

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/1ed7bc16-c6c4-4a02-9650-0d7c7ac39ebe)

Test Case 2

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/fe01be0d-a525-4314-932d-ba7c467185d4)

**Output of Dynamic Programming**

Test Case 1

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/80856c83-0760-44c2-bab7-f38b078124a6)

Test Case 2

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/aaad75ad-51f7-426f-969e-4f201479da50)

---Retype Knapsack And Item Information---

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/54c8c9e9-a230-44eb-955a-2162dcae945e)
![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/59b3ae00-6c9d-480c-9592-0e429aec8087)

- When users want to retype knapsack and item information, users can key in “1” in the menu selection to retype knapsack and item information.

---Exit System---

![image](https://github.com/yeejing0822/KnapsackSystem/assets/86753374/f86fd79d-2833-450f-bfa0-8c7910c55ea6)

-When users want to exit the knapsack system, users can key in “4” in the menu selection to exit the system and “You Are Exit Now, Thank You” message will appear to inform users they are successfully exit.

~~~~~~Discussion/complexity analysis of the application~~~~~~ 

  To solve the knapsack problem, Greedy Algorithm and Dynamic Programming are used. By using these algorithms, the system will always make the best choice at the moment and it may lead to a global optimal solution.

  For Greedy Algorithm, it is generally faster than many commonly used algorithms in time complexity and it has best-case and worst-case behaviour. It is easy to implement in the problem. With implementation of Greedy Algorithm, it will calculate the ratio of the item's value divide ratio’s weight first, and then it will choose the highest ratio until the next item cannot fit into the knapsack. It calculates its solution by making its choices in a serial forward fashion, It will never revise previous choices and it will calculate the solution with serial forward fashion via making its choices. From Diagram 1.1 and 1.2 that shows the knapsack's test case,  it will show the output of the test case as Diagram 2.1 and 2.2 and exclusive the items in the knapsack due to the ratio of it being lowest such as Bottle from Diagram 1.1 and Toys from Diagram 1.2. This system will select the maximum value with lowest weight to ensure the usage of maximum capacity of knapsack with highest total value in the knapsack problem.

  For Dynamic Programming, it is another algorithm that solves the knapsack problem and it is generally slower in its time complexity. By using this algorithm, the system chooses the total weight of subsets that are smaller than the capacity and picks the subset that has the highest value. As shown in the input Diagram 1.3 and Diagram 1.4 , the result output will show as Diagram 2.3 and Diagram 2.4 exclusive  the Encyclopedia and Charger from Diagram 1.3 and exclusive the Toys and Magazine from Diagam 1.4 in the knapsack.

  When comparing between the Greedy Algorithm and Dynamic Programming, greedy algorithm will be more efficient as the total value in Greedy Algorithm is more than the total value in Dynamic Algorithm. The results show in Diagram 2.1 implemented Greedy Algorithm which have total value RM 14.60 more than the Diagram 2.3 implemented Dynamic Algorithm which only have total value in RM 13.00 although they have total maximum weight which is 10kg in test case 1. For test case 2, the results show in Diagram 2.2 implemented Greedy Algorithm which have total value RM 6.00 and total weight in 5kg. However for Diagram 2.4 which implements Dynamic Algorithm only have total value RM 5.00 and 4kg in total weight. These are the evidences that show that Greedy Algorithm is more effective than Dynamic Programming.

