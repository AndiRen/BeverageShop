/**
 * A class that implements an order for the BevShop
 * tracks info on the customer as well as all beverages on an order 
 * @author Andrew Christian
 *
 */
public class Order implements OrderInterface, Comparable<Order> {
	
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private Beverage[] beverageList; // holds all beverages for given order
	private int bevIndex; // number of beverages in order/(index + 1) of last beverage added to order
	
	/**
	 * Parameterized constructor
	 * initializes beverageList and bevIndex
	 * @param time- of order
	 * @param day- of order
	 * @param cust- the customer who is making the order
	 */
	public Order (int time, Day day, Customer cust)
	{
		orderNumber = generateOrderNo();
		orderTime = time;
		orderDay = day;
		customer = new Customer(cust);
		beverageList = new Beverage[50];
		bevIndex = 0;
	}
	
	/**
	 * Returns a randomly generated number for the order number (10000-90000)
	 * @return
	 */
	public int generateOrderNo()
	{
		int number = 0;
		int min = 10000;
		int max = 90000;
		
		number = (int)Math.floor(Math.random() * (max - (min - 1) + 10000));
		
		return number;
	}
	
	/**
	 * 
	 * @param Day the Day of the week
	 * @return true if the Day is a weekend Day (Saturday or Sunday)
	 */
	public boolean isWeekend()
	{
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
			return true;
		else
			return false;
	}
	
	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	public Beverage getBeverage(int itemNo)
	{
		return beverageList[itemNo];
	}
	
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param Size beverage Size of Type Size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		beverageList[bevIndex] = new Coffee (bevName, size, extraShot, extraSyrup);
		bevIndex++;
	}
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param Size beverage Size
	 */ 
	public void addNewBeverage(String bevName, Size size)
	{
		beverageList[bevIndex] = new Alcohol (bevName, size, isWeekend());
		bevIndex++;
	}
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param Size beverage Size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	public void addNewBeverage(String bevName, Size size, int numberOfFruits, boolean addProtein)
	{
		beverageList[bevIndex] = new Smoothie (bevName, size, numberOfFruits, addProtein);
		bevIndex++;
	}
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal()
	{
		double total = 0;
		
		for (int i = 0; i < beverageList.length; i++)
		{
			if (i < bevIndex)
			{
				total += beverageList[i].calcPrice();
			}
		}
		
		return total;
	}
	
	/**
	 * returns the number of beverages of same Type in an order
	 * @param Type the Type of the beverage
	 * @return number of beverages of Type Type in this order
	 */
	public int findNumOfBeveType(Type type)
	{
		int count = 0;
		
		for (int i = 0; i < beverageList.length; i++)
		{
			if (i < bevIndex)
			{
				if (beverageList[i].getType() == type)
					count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Returns the total number of beverages for this order
	 * @return bevIndex
	 */
	public int getTotalItems()
	{
		return bevIndex;
	}
	
	/**
	 * Returns the order's order number
	 * @return orderNumber
	 */
	public int getOrderNo()
	{
		return orderNumber;
	}
	
	/**
	 * Returns a deep copy of the customer for the given order
	 * @return customer (copy)
	 */
	public Customer getCustomer()
	{
		return new Customer(customer);
	}
	
	/**
	 * Returns a deep copy of the order's beverageList
	 * @return newArray 
	 */
	public Beverage[] getBeverageList()
	{
		Beverage[] newArray = new Beverage[50];
		
		for (int i = 0; i < beverageList.length; i++)
		{
			newArray[i] = beverageList[i];
		}
		
		return newArray;
	}
	
	/**
	 * Returns the time the order was made
	 * @return orderTime
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 * Returns the day the order was made
	 * @return orderDay
	 */
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * Returns the number of orders in the beverageList/the (index + 1) of the last beverage added to beverageList
	 * @return bevIndex
	 */
	public int getIndex()
	{
		return bevIndex;
	}
	
	/**
	 * Sets the order number
	 * @param number
	 */
	public void setOrderNo(int number)
	{
		orderNumber = number;
	}
	
	/**
	 * Sets the order day
	 * @param day
	 */
	public void setOrderDay(Day day)
	{
		orderDay = day;
	}
	
	/**
	 * Sets the order time
	 * @param hour
	 */
	public void setOrderTime(int hour)
	{
		orderTime = hour;
	}
	
	/**
	 * Replaces the original customer on the order with a new customer
	 * @param cust
	 */
	public void setCustomer(Customer cust)
	{
		customer = new Customer(cust);
	}
	
	/**
	 * Sets bevIndex to new value
	 * @param i- the new value for bevIndex
	 */
	public void setIndex(int i)
	{
		bevIndex = i;
	}
	
	/**
	 * Overrides the compareTo method
	 * compares the orderNo of two orders
	 * @return 1 if the current order is greater than otherOrder, -1 if it is less, and 0 if they are the same
	 */
	@Override
	public int compareTo(Order otherOrder)
	{
		int otherNumber = otherOrder.getOrderNo();
		
		if (orderNumber > otherNumber)
			return 1;
		if (orderNumber < otherNumber)
			return -1;
		else
			return 0;
	}
	
	/**
	 * Overrides toString method
	 * @return info- the details on the order
	 */
	@Override
	public String toString()
	{
		String info = "";
		
		info = "*Order No: " + orderNumber + "*" +
				"\nTime: " + orderTime +
				"\nDay: " + orderDay +
				"\nCustomer Name: " + customer.getName() +
				"\nCustomer Age: " + customer.getAge();
		
		for (int i = 0; i < beverageList.length; i++)
		{
			if (i < bevIndex)
			info += "\n" + beverageList[i].toString();
		}
		
		info += "\nTotal Cost: $" + calcOrderTotal();
		
		return info;
	}
}
