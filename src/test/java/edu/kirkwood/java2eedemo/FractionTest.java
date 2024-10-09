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
        fail();
    }

    @Test
    void simplify() {
        fail();
    }

    @Test
    void mixedNumber() {
        fail();
    }

    @Test
    void add() {
        fail();
    }
}