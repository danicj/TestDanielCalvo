package usj.renting;

public abstract class Price {
	abstract int getPriceCode();
	abstract double getCharge(int daysRented);
	abstract int getLoyaltyPoints(int daysRented);
	}
