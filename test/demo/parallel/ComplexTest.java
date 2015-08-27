package demo.parallel;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Iskra Vitaly <vitaly.iskra@omnigon.com>
 *         <p>
 *         Date: 27/08/2015
 */
public class ComplexTest {
  @Test
  public void div() {
    Complex c1 = new Complex(42, 420);
    Complex c2 = new Complex(34, 58);
    Complex mustBeC1 = c2.copy().times(c1).div(c2);
    Assert.assertTrue(mustBeC1.fuzzyEqual(c1, 0.000001));
  }

  @Test
  public void euler() {
    Assert.assertTrue(Complex.e().pow(Complex.i().times(Complex.pi())).fuzzyEqual(Complex.real(-1), 0.0000000001));
  }

  @Test
  public void powerAndRoot() {
    Complex z = new Complex(42, 442);
    Complex p = new Complex(3, 2);
    Complex antiP = Complex.real(1).div(p);
    Complex mustBeZ = z.copy().pow(antiP).pow(p);
    Assert.assertTrue(mustBeZ.fuzzyEqual(z, 0.0000001));
  }

  @Test
  public void powerMul() {
    Complex z = new Complex(42, 442);
    Complex p1 = new Complex(0.1, 0.2);
    Complex p2 = new Complex(0.4, -0.3);
    Complex res1 = z.copy().pow(p1).pow(p2);
    Complex res2 = z.copy().pow(p1.copy().times(p2));
    Assert.assertTrue(res1.fuzzyEqual(res2, 0.0000001));
  }
}
