package usj.renting;


public class Rental {
	  private Car car;
	  private int daysRented;
	  
	  public Rental (Car car, int daysRented) {
	    this.car = car;
	    this.daysRented = daysRented;
	  }

	  public int getDaysRented () {
	    return daysRented;
	  }

	  public Car getCar () {
	    return car;
	  }
	  
	  int getLoyaltyPoints(){
		  return car.getLoyaltyPoints(daysRented);
	  }
	  
	  double getCharge()
	  {
		 return car.getCharge(daysRented);
	  }
	}
