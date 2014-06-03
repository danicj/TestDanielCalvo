package usj.renting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usj.renting.CoupePrice;

public class CoupeChargeTest {

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
	 * Se comprueba que si son 2 dias exactos, el resultado sea 2
	 */
	@Test
	public void negativoTest() {

		double charge = coupePrice.getCharge(NEGATIVO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 0 dias debería de dar precio 0
	 */
	@Test
	public void sinDiasTest() {
		double charge = coupePrice.getCharge(ZERO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 2 días exactos debería devolver 2
	 */
	@Test
	public void diasExactosTest() {
		double charge = coupePrice.getCharge(EXACTOS);
		Assert.assertEquals(2, charge, DELTA);
	}

	/**
	 * Indicando >2 días debería realizar correctamente la fórmula
	 */
	@Test
	public void masDiasTest() {
		double charge = coupePrice.getCharge(MAYOR);
		Assert.assertEquals(3.5, charge, DELTA);
	}

}
