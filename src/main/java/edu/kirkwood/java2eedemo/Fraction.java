package edu.kirkwood.java2eedemo;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        setDenominator(denominator); // validates the denominator
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.denominator = denominator;
    }

    public String toString() {
        return String.format("<sup>%s</sup>/<sub>%s</sub>", numerator, denominator);
    }

    // Source: https://stackoverflow.com/a/4009247
    // Example of Recursion
    public static int gcd(int a, int b) {
        if (b==0) return Math.abs(a);
        return gcd(b,a % b);
    }

    public Fraction simplify() {
        int gcd = Fraction.gcd(this.numerator, this.denominator);
        Fraction result = new Fraction(this.numerator / gcd, this.denominator / gcd);
        if(result.numerator >= 0 && result.denominator < 0 || result.numerator < 0 && result.denominator < 0) {
            result.numerator *= -1;
            result.denominator *= -1;
        }
        return result;
    }

    public String mixedNumber() {
        Fraction simplified = simplify();
        if(simplified.denominator == 1) {
            return simplified.numerator + ""; // convert int to String
        } else if(simplified.numerator == 0) {
            return "0";
        } else if(simplified.numerator > simplified.denominator) {
            int wholeNumber = simplified.numerator / simplified.denominator;
            int remainder = simplified.numerator % simplified.denominator;
            return wholeNumber + " <sup>" + remainder + "</sup>/<sub>" + simplified.denominator + "</sub>";
        } else if(simplified.numerator < 0 && Math.abs(simplified.numerator) > simplified.denominator) {
            int wholeNumber = simplified.numerator / simplified.denominator;
            int remainder = Math.abs(simplified.numerator) % simplified.denominator;
            return wholeNumber + " <sup>" + remainder + "</sup>/<sub>" + simplified.denominator + "</sub>";
        }
        return simplified.toString();
    }

    public String add(Fraction other) {
        Fraction s1 = simplify();
        Fraction s2 = other.simplify();
        Fraction result = new Fraction();
        result.setNumerator(s1.numerator * s2.denominator + s1.denominator * s2.numerator);
        result.setDenominator(s1.denominator * s2.denominator);
        return s1.mixedNumber() + " + " + s2.mixedNumber() + " = " + result.mixedNumber();
    }


}
