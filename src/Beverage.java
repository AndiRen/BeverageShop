/**
 * The abstract super class for all beverages in the BevShop
 * @author Andrew Christian
 *
 */
abstract class Beverage {
	
	private String bevName;
	private Type bevType;
	private Size bevSize;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_UP = 1.0;
	
	/**
	 * Parameterized constructor
	 * @param name- of beverage
	 * @param type- of beverage
	 * @param size= of beverage
	 */
	public Beverage (String name, Type type, Size size)
	{
		bevName = name;
		bevType = type;
		bevSize = size;	
	}
	
	/**
	 * Abstract method all beverage types will use to calculate the cost of the beverage
	 * @return double- the cost of the beverage
	 */
	abstract double calcPrice();
	
	/**
	 * Return name of beverage
	 * @return bevName
	 */
	public String getBevName()
	{
		return bevName;
	}
	
	/**
	 * Return the type of beverage
	 * @return bevType
	 */
	public Type getType()
	{
		return bevType;
	}
	
	/**
	 * Return the size of the beverage
	 * @return bevSize
	 */
	public Size getSize()
	{
		return bevSize;
	}
	
	/**
	 * Return the base price of all beverages
	 * @return BASE_PRICE
	 */
	public double getBasePrice()
	{
		return BASE_PRICE;
	}
	
	/**
	 * Return the cost to up the size of the beverage
	 * @return SIZE_UP
	 */
	public double getSizeUp()
	{
		return SIZE_UP;
	}
	
	/**
	 * Set the name of the beverage
	 * @param name
	 */
	public void setName(String name)
	{
		bevName = name;
	}
	
	/**
	 * Set the type of the beverage
	 * @param type
	 */
	public void setType(Type type)
	{
		bevType = type;
	}
	
	/**
	 * Set the size of the beverage
	 * @param size
	 */
	public void setSize(Size size)
	{
		bevSize = size;
	}
	
	/**
	 * Overrides the toString method
	 * @return info- the details common to all beverages
	 */
	@Override
	public String toString()
	{
		String info = "";
		info = "Beverage: " + bevName +
				"\n\tSize: " + bevSize;
		
		return info;
	}
	
	/**
	 * Overrides the equals methods
	 * @param otherBev- to be checked against current beverage
	 * @return- true/false depending on whether the beverages match or not
	 */
	public boolean equals(Beverage otherBev)
	{
		
		if (!otherBev.getBevName().equals(bevName))
			return false;
		if (otherBev.getType() != bevType)
			return false;
		if (otherBev.getSize() != bevSize)
			return false;
		else
			return true;
	}

}
