package usj.renting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usj.renting.LimousinePrice;

public class LimousineChargeTest {

	/**
	 * Magic Numbers
	 */
	private static final double DELTA = 00;
	private static final int NEGATIVO = -2;
	private static final int ZERO = 0;
	private static final int MAYOR = 5;

	private LimousinePrice limousinePrice;

	@Before
	public void init() {
		limousinePrice = new LimousinePrice();
	}

	/**
	 * Se comprueba que si se envia numeros devuelva 0
	 */
	@Test
	public void negativoTest() {
		double charge = limousinePrice.getCharge(NEGATIVO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 0 dias debería de dar precio 0
	 */
	@Test
	public void sinDiasTest() {
		double charge = limousinePrice.getCharge(ZERO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 3 días debe devolverlo multiplicado siempre por 3
	 */
	@Test
	public void masDiasTest() {
		double charge = limousinePrice.getCharge(MAYOR);
		Assert.assertEquals(15, charge, DELTA);
	}

}
