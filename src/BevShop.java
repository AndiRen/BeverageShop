/**
 * A class that simulates a beverages shop
 * Processes orders of beverages
 * Stores and shares information on beverage sales
 * @author Andrew Christian
 *
 */
public class BevShop implements BevShopInterfce{

	private int alcoholCount; // number of alcoholic drinks for current order
	private Order[] orderList; // list of all orders for the month
	private Order currentOrder; // the active order
	private int orderIndex; // number of orders currently in orderList
	
	/**
	 * Parameterized Constructor
	 * initializes orderList, sets orderIndex and alcoholCount to 0
	 */
	public BevShop()
	{
		orderList = new Order[1000];
		orderIndex = 0;
		alcoholCount = 0;
	}
	
	/**
	 * Checks if the number of fruits in a smoothie is above the max fruit allowed
	 * @param number- of fruits
	 * @return true/false
	 */
	public boolean isMaxFruit(int number)
	{
		if (number > BevShopInterfce.MAX_FRUIT)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean validTime(int time)
	{
		if (time >= BevShopInterfce.MIN_TIME && time <= BevShopInterfce.MAX_TIME)
			return true;
		else
			return false;
	}
	
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	public boolean eligibleForMore()
	{
		if (alcoholCount < BevShopInterfce.MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	public  boolean validAge(int age)
	{
		if (age >= BevShopInterfce.MIN_AGE_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param Day Day of the order of Type Day
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	public void startNewOrder(int time, Day Day, String customerName, int customerAge)
	{
		Customer cust = new Customer(customerName, customerAge);
		currentOrder = new Order(time, Day, cust);
		alcoholCount = 0;
		orderList[orderIndex] = currentOrder;
		orderIndex++;
	}
	
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param Size beverage Size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void processCoffeeOrder( String bevName, Size Size, boolean extraShot, boolean extraSyrup )
	{
		currentOrder.addNewBeverage(bevName, Size, extraShot, extraSyrup);
	}
	
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param Size beverage Size
	 */
	public void  processAlcoholOrder( String bevName, Size Size ) // deal with MAX allowed...*****
	{
		currentOrder.addNewBeverage(bevName, Size);
		alcoholCount++;
	}
	
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param Size beverage Size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	public void processSmoothieOrder( String bevName, Size Size, int numOfFruits, boolean addProtien)
	{
		currentOrder.addNewBeverage(bevName, Size, numOfFruits, addProtien);
	}
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	public int findOrder(int orderNo)
	{
		for (int i = 0; i < orderList.length; i++)
		{
			if (i < orderIndex)
			{
				if (orderList[i].getOrderNo() == orderNo)
					return i;
			}
		}

		return -1;
	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order, or -1.0 if no order is found.
	 */
	public double totalOrderPrice(int orderNo)
	{
		for (int i = 0; i < orderList.length; i++)
		{
			if (i < orderIndex)
			{
				if (orderList[i].getOrderNo() == orderNo)
					return orderList[i].calcOrderTotal();
			}
		}
		
		return -1.0;
	}
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	public double totalMonthlySale()
	{
		double monthlyTotal = 0;
		
		for (int i = 0; i < orderList.length; i++)
		{
			if (i < orderIndex)	
				monthlyTotal += orderList[i].calcOrderTotal();
		}
	
		return monthlyTotal;
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	public  void sortOrders()
	{
		int startingPosition;
		int sortingIndex;
		
		for (startingPosition = 0; startingPosition < (orderIndex - 1); startingPosition++)
		{
			for (sortingIndex = (startingPosition + 1); sortingIndex < orderIndex; sortingIndex++)
			{
				if (orderList[sortingIndex].getOrderNo() < orderList[startingPosition].getOrderNo())
				{
					Order minOrder = orderList[startingPosition];
					orderList[startingPosition] = orderList[sortingIndex];
					orderList[sortingIndex] = minOrder;
				}
			}
		}		
	}
	
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	public Order getOrderAtIndex(int index)
	{
		return orderList[index];
	}
	
	public Order getCurrentOrder()
	{
		return currentOrder;
	}
	
	/**
	 * Returns the current number of alcoholic drinks for the current order
	 * @return alcoholCount
	 */
	public int getNumOfAlcoholDrink()
	{
		return alcoholCount;
	}
	
	/**
	 * Returns the total number of orders for the month for the BevShop
	 * @return orderIndex (the number of orders in orderList)
	 */
	public int totalNumOfMonthlyOrders()
	{
		return orderIndex;
	}
	
	/**
	 * Returns the maximum number of alcoholic drinks allowed per order
	 * @return MAX_ORDER_FOR_ALCOHOL
	 */
	public int getMaxOrderForAlcohol()
	{
		return BevShopInterfce.MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Returns the minimum age needed to order alcohol
	 * @return MIN_AGE_FOR_ALCOHOL
	 */
	public int getMinAgeForAlcohol()
	{
		return BevShopInterfce.MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * Returns a deep copy of the BevShop orderList
	 * @return newList
	 */
	public Order[] getOrderList()
	{
		Order[] newList = new Order[1000];
		
		for (int i = 0; i < orderList.length; i++)
		{
			newList[i] = orderList[i];
		}
		
		return newList;
	}
	
	/**
	 * Returns the current number of orders in orderList/the (index + 1) of the last order added to orderList
	 * @return orderIndex
	 */
	public int getOrderIndex()
	{
		return orderIndex;
	}
	
	/**
	 * Sets the index for the orderList array
	 * @param number- the index is to be set to
	 */
	public void setOrderIndex(int number)
	{
		orderIndex = number;
	}
	
	/**
	 * Sets the current count of alcoholic drinks for the current order
	 * @param number- the number the count will be changed to
	 */
	public void setAlcoholCount(int number)
	{
		alcoholCount = number;
	}
	
	/**
	 * Replaces the entire orderList for the BevShop with a new list of orders
	 * @param newList
	 */
	public void setOrderList(Order[] newList)
	{
		orderList = null;
		
		for (int i = 0; i < newList.length; i++)
		{
			orderList[i] = newList[i];
		}
	}
	
	/**
	 * Replaces the order at the given index with the provided new order
	 * @param order- the new order
	 * @param index- index of the old order to be replaced
	 */
	public void replaceOrderAtIndex(Order order, int index)
	{
		orderList[index] = order;
	}
	
	/**
	 * Overrides the toString method
	 * @return info- the details on every order in the BevShop as well as total monthly sales for all orders
	 */
	@Override
	public String toString()
	{
		String info = "";
		double monthlySales = 0.0;
		
		info = "The BevShop Sales Report\n" +
				"------------------------------\n";
		
		for (int i = 0; i < orderIndex; i++)
		{
			info += orderList[i].toString() + "\n" +
					"------------------------------\n";
			
			monthlySales += orderList[i].calcOrderTotal();
		}
		
		info += "\nTotal monthly sales: $" + monthlySales;
		
		return info;
	}
}
