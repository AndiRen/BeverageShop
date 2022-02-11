/**
 * A class that processes info for smoothie drinks
 * @author Andrew Christian
 *
 */
public class Smoothie extends Beverage {
	
	int fruitCount = 0; // the number of fruits added to the smoothie
	boolean proteinPowder = false; // whether or not protein powder was added to smoothie
	
	/**
	 * Parameterized constructor
	 * @param name- of drink
	 * @param size- of drink
	 * @param fruit- number of fruits added
	 * @param powder- whether or not protein powder was added
	 */
	public Smoothie (String name, Size size, int fruit, boolean powder)
	{
		super(name, Type.SMOOTHIE, size);
		fruitCount = fruit;
		proteinPowder = powder;
	}
	
	/**
	 * Returns the number of fruits added to the smoothie
	 * @return fruitCount
	 */
	public int getNumOfFruits()
	{
		return fruitCount;
	}
	
	/**
	 * Returns whether or not protein powder was added to the smoothie
	 * @return proteinPowder
	 */
	public boolean getAddProtein()
	{
		return proteinPowder;
	}
	
	/**
	 * Sets the number of fruits in the smoothie
	 * @param fruit
	 */
	public void setNumOfFruits(int fruit)
	{
		fruitCount = fruit;
	}
	
	/**
	 * Sets whether or not to add protein powder to smoothie
	 * @param powder
	 */
	public void setPowder(boolean powder)
	{
		proteinPowder = powder;
	}
	
	/**
	 * Overrides the Beverage calcPrice method
	 * adds $1.00 for every size increase above small
	 * adds $0.50 to base cost for every piece of fruit added
	 * adds $1.50 to base cost if protein powder was added
	 * @return cost- the total cost of the beverage
	 */
	public double calcPrice()
	{
		double cost = 0.0;
		
		cost += this.getBasePrice();
		cost += (fruitCount * 0.5);
		
		if (proteinPowder == true)
			cost += 1.5;;
		if (this.getSize() == Size.MEDIUM)
			cost += this.getSizeUp();
		if (this.getSize() == Size.LARGE)
			cost += (this.getSizeUp() * 2);
		
		return cost;
	}
	
	/**
	 * Overrides the toString method
	 * @return info- details on the smoothie
	 */
	@Override
	public String toString()
	{
		String info = "";
		String powder = "";
		
		if (proteinPowder == true)
			powder = "Yes";
		else
			powder = "No";
		
		info = super.toString() +
				"\n\tPieces of Fruit: " + fruitCount +
				"\n\tProtein Powder: " + powder +
				"\n\tPrice: $" + calcPrice();
		
		return info;
	}
	
	/**
	 * Overrides the equals method
	 * @param otherBev- to be compared to
	 * @return true/false depending on if same or not
	 */
	public boolean equals (Smoothie otherBev)
	{
		if (!super.equals(otherBev))
			return false;
		if (otherBev.getNumOfFruits() != fruitCount)
			return false;
		if (otherBev.getAddProtein() != proteinPowder)
			return false;
		else
			return true;
	}

}
