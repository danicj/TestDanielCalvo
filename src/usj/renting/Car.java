package usj.renting;



public class Car {
  public static final int SEDAN = 2;
  public static final int COUPE = 0;
  public static final int LIMOUSINE = 1;

  private String plate;
  private Price price;

  public Car (String plate, int priceCode) {
    this.plate = plate;
    setPriceCode(priceCode);
  }

  public int getPriceCode () {
    return price.getPriceCode();
  }

  public void setPriceCode (int arg) {
     switch (arg)
     {
       case SEDAN:
    	   price = new SedanPrice(); 
    	   break;
       case COUPE:
    	   price = new CoupePrice();
    	   break;
       case LIMOUSINE:
    	   price = new LimousinePrice();
    	   break;
       default:
    	   throw new IllegalArgumentException("Incorrect Price Code");
    	
     }
  }

  public String getPlate () {
    return plate;
  }
  
  double getCharge(int daysRented){
	  return price.getCharge(daysRented);
    }
  
    int getLoyaltyPoints(int daysRented){
       return price.getLoyaltyPoints(daysRented);
    }
  
}
