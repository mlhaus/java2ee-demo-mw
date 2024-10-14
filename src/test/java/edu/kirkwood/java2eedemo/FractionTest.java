package edu.kirkwood.java2eedemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction f1;
    private Fraction f2;

    @BeforeEach
    void setUp() {
        f1 = new Fraction();
        f2 = new Fraction(2, 3);
    }

    @Test
    void getNumerator() {
        assertEquals(1, f1.getNumerator());
        assertEquals(2, f2.getNumerator());
    }

    @Test
    void setNumerator() {
        f1.setNumerator(5);
        assertEquals(5, f1.getNumerator());
        f1.setNumerator(0);
        assertEquals(0, f1.getNumerator());
        f1.setNumerator(-5);
        assertEquals(-5, f1.getNumerator());
    }

    @Test
    void getDenominator() {
        assertEquals(1, f1.getDenominator());
        assertEquals(3, f2.getDenominator());
    }

    @Test
    void setDenominator() {
        f1.setDenominator(5);
        assertEquals(5, f1.getDenominator());
        assertThrows(ArithmeticException.class, () -> f1.setDenominator(0));
        assertEquals(5, f1.getDenominator());
        f1.setDenominator(-5);
        assertEquals(-5, f1.getDenominator());
    }

    @Test
    void testToString() {
        assertEquals("<sup>1</sup>/<sub>1</sub>", f1.toString());
        assertEquals("<sup>2</sup>/<sub>3</sub>", f2.toString());
    }

    @Test
    void gcd() {
//        assertEquals(15, Fraction.gcd(75, 45));
//        assertEquals(2, Fraction.gcd(2, 4));
//        assertEquals(1, Fraction.gcd(7, 5));
//        assertEquals(1, Fraction.gcd(-7, 5));
//        assertEquals(1, Fraction.gcd(-7, -5));
        //gcd{a,b}=gcd{−a,b}=gcd{a,−b}=gcd{−a,−b}
        int a = Fraction.gcd(5, 3);
        int b = Fraction.gcd(-5, 3);
        int c = Fraction.gcd(5, -3);
        int d = Fraction.gcd(-5, -3);
        assertTrue(a == b && b == c && c == d);
    }

    @Test
    void simplify() {
        Fraction f3 = f1.simplify();
        assertEquals(1, f3.getNumerator());
        assertEquals(1, f3.getDenominator());

        f1.setNumerator(75);
        f1.setDenominator(45);
        f3 = f1.simplify();
        assertEquals(5, f3.getNumerator());
        assertEquals(3, f3.getDenominator());

        f1.setNumerator(-50);
        f1.setDenominator(20);
        f3 = f1.simplify();
        assertEquals(-5, f3.getNumerator());
        assertEquals(2, f3.getDenominator());

        f1.setNumerator(25);
        f1.setDenominator(-100);
        f3 = f1.simplify();
        assertEquals(-1, f3.getNumerator());
        assertEquals(4, f3.getDenominator());
        
        f1.setNumerator(-10);
        f1.setDenominator(-15);
        f3 = f1.simplify();
        assertEquals(2, f3.getNumerator());
        assertEquals(3, f3.getDenominator());
    }

    @Test
    void mixedNumber() {
        assertEquals("1", f1.mixedNumber());

        f1.setNumerator(0);
        assertEquals("0", f1.mixedNumber());

        f1.setNumerator(75);
        f1.setDenominator(45);
        assertEquals("1 <sup>2</sup>/<sub>3</sub>", f1.mixedNumber());

        f1.setNumerator(-50);
        f1.setDenominator(20);
        assertEquals("-2 <sup>1</sup>/<sub>2</sub>", f1.mixedNumber());

        f1.setNumerator(25);
        f1.setDenominator(-100);
        assertEquals("<sup>-1</sup>/<sub>4</sub>", f1.mixedNumber());

        f1.setNumerator(-10);
        f1.setDenominator(-15);
        assertEquals("<sup>2</sup>/<sub>3</sub>", f1.mixedNumber());
    }

    @Test
    void add() {
        assertEquals("1 + <sup>2</sup>/<sub>3</sub> = 1 <sup>2</sup>/<sub>3</sub>", f1.add(f2));

        f1.setNumerator(25);
        f1.setDenominator(-100);

        f2.setNumerator(-10);
        f2.setDenominator(-15);
        assertEquals("<sup>-1</sup>/<sub>4</sub> + <sup>2</sup>/<sub>3</sub> = <sup>5</sup>/<sub>12</sub>", f1.add(f2));
    }
}