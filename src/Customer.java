/**
 * A class the implements an instance of a customer
 * @author Andrew Christian
 *
 */
public class Customer {
	
	private String name; // name of customer
	private int age; // age of customer
	
	/**
	 * Parameterized constructor
	 * @param name- of customer
	 * @param age- of customer
	 */
	public Customer (String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Copy constructor
	 * @param otherCustomer- to be copied
	 */
	public Customer (Customer otherCustomer)
	{
		name = otherCustomer.getName();
		age = otherCustomer.getAge();
	}
	
	/**
	 * Returns the name of the customer
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the age of the customer
	 * @return age
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Sets the name of the customer
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets the age of the customer
	 * @param age
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Overrides the toString method
	 * @return info- the details on the customer
	 */
	@Override
	public String toString()
	{
		String info = "";
		
		info = "Name: " + name +
			   "\nAge: " + age;
		
		return info;
	}

}
