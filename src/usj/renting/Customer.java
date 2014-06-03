package usj.renting;

import java.util.*;

public class Customer {

	private String name;
	static Vector<Rental> rentals = new Vector<Rental>();

	public Customer (String name) {
	  this.name = name;
	}

	public void addRental(Rental rental) {
	  rentals.addElement (rental);
	}

	  public String getName () {
	    return name;
	  }


	  public String statement () {
		Enumeration<Rental> rentalsEnum = rentals.elements ();
	    String result = "Rental Record for " + getName() + "\n";
	    while (rentalsEnum.hasMoreElements ()) {
	      Rental rental = (Rental) rentalsEnum.nextElement();
	      
	      // Show figures for this rental  
	      result += "\t" + rental.getCar().getPlate() + "\t" + String.valueOf(rental.getCharge()) + "\n";
	    }
	    // add footer lines
	    result += "Amount payed is " + String.valueOf(getTotalCharge()) + "\n";
	    result += "You earned " + String.valueOf(getTotalLoyaltyPoints()) + " loyalty points";
	    return result;
	  }
	    
	  private double getTotalCharge(){
		double result = 0;
		Enumeration<Rental> rentalsEnum = rentals.elements ();
		while (rentalsEnum.hasMoreElements ()) {
			Rental rental = (Rental) rentalsEnum.nextElement();
			result += rental.getCharge();
		}
		return result;
	  }
	  
	  private double getTotalLoyaltyPoints(){
		  double result = 0;
		  Enumeration<Rental> rentalsEnum = rentals.elements ();
		  while (rentalsEnum.hasMoreElements()){
			  Rental rental = (Rental)rentalsEnum.nextElement();
			  result += rental.getLoyaltyPoints();
		  }
		  return result;  
	  }
	  

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Ejecutando main");
        Customer customer = new Customer("John Doe");
        
        Car car1 = new Car("2345-FDM", Car.LIMOUSINE);
        Rental rental1 = new Rental(car1, 10);
        Car car2 = new Car("2333-CKS", Car.SEDAN);
        Rental rental2 = new Rental(car2, 8);
        Car car3 = new Car("1111-BMD", Car.COUPE);
        Rental rental3 = new Rental(car3, 4);
        
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        
        System.out.println(customer.statement());
	}

}