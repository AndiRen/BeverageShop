/**
 * A class that processes info for alcoholic drinks
 * @author Andrew Christian
 *
 */
public class Alcohol extends Beverage {
	
	boolean onWeekend = false; // variable to hold whether a drink is served on the weekends
	
	/**
	 * Parameterized constructor
	 * @param name- of drink
	 * @param size- of drink
	 * @param weekend- whether drink is offered on weekends
	 */
	public Alcohol (String name, Size size, boolean weekend)
	{
		super(name, Type.ALCOHOL, size);
		onWeekend = weekend;
	}
	
	/**
	 * Checks whether a drink is offered on the weekend
	 * @return onWeekend
	 */
	public boolean getWeekend()
	{
		return onWeekend;
	}
	
	/**
	 * Sets whether a drink is offered on a weekend
	 * @param weekend- true or false parameter
	 */
	public void setWeekend(boolean weekend)
	{
		onWeekend = weekend;
	}
	
	/**
	 * Overrides the Beverage calcPrice method
	 * adds $1.00 for every size increase above small
	 * adds $0.60 to base cost of beverage if the drink is offered on the weekend
	 * @return cost- the total cost of the beverage
	 */
	public double calcPrice()
	{
		double cost = 0.0;
		cost += this.getBasePrice();
		
		if (onWeekend == true)
			cost += 0.6;
		if (this.getSize() == Size.MEDIUM)
			cost += this.getSizeUp();
		if (this.getSize() == Size.LARGE)
			cost += (this.getSizeUp() * 2);
		
		return cost;
	}
	
	/**
	 * Overrides the toString method
	 * @return info- the details on the drink
	 */
	@Override
	public String toString()
	{
		String info = "";
		String weekend = "";
		
		if (onWeekend == true)
			weekend = "Yes";
		else
			weekend = "No";
		
		info = super.toString() +
				"\n\tAvailable Weekend: " + weekend +
				"\n\tPrice: $" + calcPrice();
		
		return info;
	}
	
	/**
	 * Overrides the equals method
	 * @param otherBev- beverage to check against current beverage
	 * @return true/false- depending on whether the two beverages match or not
	 */
	public boolean equals (Alcohol otherBev)
	{
		if (!super.equals(otherBev))
			return false;
		if (otherBev.getWeekend() != onWeekend)
			return false;
		else
			return true;
	}

}
