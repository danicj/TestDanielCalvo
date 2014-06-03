package usj.renting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usj.renting.LimousinePrice;

public class LimousineLoyaltyPointsTest {

	/**
	 * Magic Numbers
	 */
	private static final double DELTA = 00;
	private static final int NEGATIVO = -2;
	private static final int ZERO = 0;
	private static final int EXACTOS = 1;
	private static final int MAYOR = 3;

	private LimousinePrice limousinePrice;

	@Before
	public void init() {
		limousinePrice = new LimousinePrice();
	}

	/**
	 * Si se introducen n�meros negativos no deber�a dar puntos
	 */
	@Test
	public void negativoTest() {
		double charge = limousinePrice.getLoyaltyPoints(NEGATIVO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 0 dias no deber�a dar puntos
	 */
	@Test
	public void sinDiasTest() {
		double charge = limousinePrice.getLoyaltyPoints(ZERO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 1 d�as exacto devolver 1 punto
	 */
	@Test
	public void diasExactosTest() {
		double charge = limousinePrice.getLoyaltyPoints(EXACTOS);
		Assert.assertEquals(1, charge, DELTA);
	}

	/**
	 * Indicando >1 d�as deber�a dar 2 puntos
	 */
	@Test
	public void masDiasTest() {
		double charge = limousinePrice.getLoyaltyPoints(MAYOR);
		Assert.assertEquals(2, charge, DELTA);
	}

}
