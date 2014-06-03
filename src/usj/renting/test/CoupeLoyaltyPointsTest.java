package usj.renting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usj.renting.CoupePrice;

public class CoupeLoyaltyPointsTest {

	/**
	 * Magic Numbers
	 */
	private static final double DELTA = 00;
	private static final int NEGATIVO = -2;
	private static final int ZERO = 0;
	private static final int EXACTOS = 2;
	private static final int MAYOR = 3;

	private CoupePrice coupePrice;

	@Before
	public void init() {
		coupePrice = new CoupePrice();
	}

	/**
	 * Si se introducen números negativos no debería dar puntos
	 */
	@Test
	public void negativoTest() {
		double charge = coupePrice.getLoyaltyPoints(NEGATIVO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 0 dias no debería dar puntos
	 */
	@Test
	public void sinDiasTest() {
		double charge = coupePrice.getLoyaltyPoints(ZERO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 2 días exactos devolver 1 punto
	 */
	@Test
	public void diasExactosTest() {
		double charge = coupePrice.getLoyaltyPoints(EXACTOS);
		Assert.assertEquals(1, charge, DELTA);
	}

	/**
	 * Indicando >2 días debería dar 1 punto
	 */
	@Test
	public void masDiasTest() {
		double charge = coupePrice.getLoyaltyPoints(MAYOR);
		Assert.assertEquals(1, charge, DELTA);
	}

}
