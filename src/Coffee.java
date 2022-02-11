/**
 * A class that processes info for coffee drinks
 * @author Andrew Christian
 *
 */
public class Coffee extends Beverage {
	
	boolean extraShot = false;
	boolean extraSyrup = false;
	// variables for 0.5 extra charge for shots and syrup???
	
	/**
	 * Parameterized constructor
	 * @param name- of drink
	 * @param size- of drink
	 * @param xShot- whether an extra shot was orderd
	 * @param xSyrup- whether extra syrup was ordered
	 */
	public Coffee (String name, Size size, boolean xShot, boolean xSyrup)
	{
		super(name, Type.COFFEE, size);
		extraShot = xShot;
		extraSyrup = xSyrup;
	}
	
	/**
	 * Returns whether or not an extra shot was ordered
	 * @return extraShot
	 */
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	/**
	 * Returns whether or not extra syrup was ordered
	 * @return extraSyrup
	 */
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	/**
	 * Sets whether or not the coffee will have an extra shot
	 * @param xShot
	 */
	public void setShot(boolean xShot)
	{
		extraShot = xShot;
	}
	
	/**
	 * Sets whether or not the coffee will have extra syrup
	 * @param xSyrup
	 */
	public void setSyrup(boolean xSyrup)
	{
		extraSyrup = xSyrup;
	}
	
	/**
	 * Overrides the Beverage calcPrice method
	 * adds $1.00 for every size increase above small
	 * adds $0.50 to base cost of beverage if extra shot added
	 * adds $0.50 to base cost of beverage if extra syrup added
	 * @return cost- the total cost of the beverage
	 */
	public double calcPrice()
	{
		double cost = 0.0;
		
		cost += this.getBasePrice();
		
		if (extraShot == true)
			cost += 0.5;
		if (extraSyrup == true)
			cost += 0.5;
		if (this.getSize() == Size.MEDIUM)
			cost += this.getSizeUp();
		if (this.getSize() == Size.LARGE)
			cost += (this.getSizeUp() * 2);
		
		return cost;
	}
	
	/**
	 * Overrides toString method
	 * @return info- the detail on the drink
	 */
	@Override
	public String toString()
	{
		String info = "";
		String shot = "";
		String syrup = "";
		
		if (extraShot == true)
			shot = "Yes";
		else
			shot = "No";
		
		if (extraSyrup == true)
			syrup = "Yes";
		else
			syrup = "No";
		
		info = super.toString() +
				"\n\tExtra Shot: " + shot +
				"\n\tExtra Syrup: " + syrup +
				"\n\tPrice: $" + calcPrice();
		
		return info;
	}
	
	/**
	 * Overrides equals method
	 * @param otherBev- to be compared with current beverage
	 * @return true/false
	 */
	public boolean equals (Coffee otherBev)
	{
		if (!super.equals(otherBev))
			return false;
		if (otherBev.getExtraShot() != extraShot)
			return false;
		if (otherBev.getExtraSyrup() != extraSyrup)
			return false;
		else
			return true;
	}

}
