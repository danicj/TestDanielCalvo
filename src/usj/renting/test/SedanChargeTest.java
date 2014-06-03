package usj.renting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usj.renting.SedanPrice;

public class SedanChargeTest {

	/**
	 * Magic Numbers
	 */
	private static final double DELTA = 00;
	private static final int NEGATIVO = -2;
	private static final int ZERO = 0;
	private static final int SUPERIOR = 5;
	private static final int INFERIOR = 2;
	private static final int EXACTO = 3;

	private SedanPrice sedanPrice;

	@Before
	public void init() {
		sedanPrice = new SedanPrice();
	}

	/**
	 * Se comprueba que si se envían dias negativos el precio sea 0
	 */
	@Test
	public void negativoTest() {
		double charge = sedanPrice.getCharge(NEGATIVO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 0 dias debería de dar precio 0
	 */
	@Test
	public void sinDiasTest() {
		double charge = sedanPrice.getCharge(ZERO);
		Assert.assertEquals(0, charge, DELTA);
	}

	/**
	 * Indicando 2 días debe devolver siempre 1.5
	 */
	@Test
	public void menosDiasTest() {
		double charge = sedanPrice.getCharge(INFERIOR);
		Assert.assertEquals(1.5, charge, DELTA);
	}
	
	/**
	 * Indicando 3 dias exactos debe dar un precio de 1.5
	 */
	@Test
	public void diasExactosTest() {
		double charge = sedanPrice.getCharge(EXACTO);
		Assert.assertEquals(1.5, charge, DELTA);
	}
	
	/**
	 * Indicando >3 debe dar el precio calculado con la formula
	 */
	@Test
	public void masDiasTest() {
		double charge = sedanPrice.getCharge(SUPERIOR);
		Assert.assertEquals(4.5, charge, DELTA);
	}

}
