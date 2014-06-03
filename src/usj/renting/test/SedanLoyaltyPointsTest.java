package usj.renting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usj.renting.SedanPrice;

public class SedanLoyaltyPointsTest {

	/**
	 * Magic Numbers
	 */
	private static final double DELTA = 00;
	private static final int NEGATIVO = -2;
	private static final int ZERO = 0;
	private static final int EXACTOS = 1;
	private static final int MAYOR = 93;

	private SedanPrice sedanPrice;

	@Before
	public void init() {
		sedanPrice = new SedanPrice();
	}

	/**
	 * Si se introducen números negativos no debería dar puntos
	 */
	@Test
	public void negativoTest() {
		double charge = sedanPrice.getLoyaltyPoints(NEGATIVO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 0 dias no debería dar puntos
	 */
	@Test
	public void sinDiasTest() {
		double charge = sedanPrice.getLoyaltyPoints(ZERO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 1 días exacto devolver 1 punto
	 */
	@Test
	public void diasExactosTest() {
		double charge = sedanPrice.getLoyaltyPoints(EXACTOS);
		Assert.assertEquals(1, charge, DELTA);
	}

	/**
	 * Indicando >1 días debería dar 1 punto
	 */
	@Test
	public void masDiasTest() {
		double charge = sedanPrice.getLoyaltyPoints(MAYOR);
		Assert.assertEquals(1, charge, DELTA);
	}

}
