
public class TestDriver {

	public static void main(String[] args) {
		
		
		BevShop bevShop = new BevShop();
		
		// First Order
		bevShop.startNewOrder(11,Day.TUESDAY,"Bob", 55);
		
		bevShop.getOrderAtIndex(0).addNewBeverage("regular Coffee", Size.SMALL, false,false);
		
		System.out.println(bevShop.getOrderAtIndex(0).toString());
		System.out.println("---------------------------------\n");
		// Second Order
		bevShop.startNewOrder(20,Day.SATURDAY,"Silvia", 19);
		
		bevShop.getOrderAtIndex(1).addNewBeverage("Detox", Size.MEDIUM,1,false);
		
		if (bevShop.validAge(bevShop.getOrderAtIndex(1).getCustomer().getAge()))
			bevShop.getOrderAtIndex(1).addNewBeverage("Mohito", Size.SMALL);	
		
		System.out.println(bevShop.getOrderAtIndex(1).toString());
		if (!bevShop.validAge(bevShop.getOrderAtIndex(1).getCustomer().getAge()))
			System.out.println("*Not old enough for alcohol");
		
		
		
		
		// After
		int index = bevShop.getOrderIndex();
		

		System.out.println("---------------------------------\n");
		
		for (int i = 0; i < index; i++)
		{
			System.out.print("The order Number of the order at index " + i + " of the order list is: ");
			System.out.println(bevShop.getOrderAtIndex(i).getOrderNo());
		}
		
		System.out.println("\nSorting array...\n");
		bevShop.sortOrders();
		
		for (int i = 0; i < index; i++)
		{
			System.out.print("The order Number of the order at index " + i + " of the order list is: ");
			System.out.println(bevShop.getOrderAtIndex(i).getOrderNo());
		}
		
		System.out.println();
		System.out.println(bevShop.toString());	
	}
}
