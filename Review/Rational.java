public class Rational {
    public long number;

    public Rational(long given_number) {
        number = given_number;
    }

    public Rational plus(Rational b) {
        Rational c = new Rational(0);
        c.number = this.number + b.number;
        return c;
    }

    public Rational minus(Rational b) {
        Rational c = new Rational(0);
        c.number = this.number - b.number;
        return c;
    }

    public Rational times(Rational b) {
        Rational c = new Rational(0);
        c.number = this.number * b.number;
        return c;
    }

    public Rational divides(Rational b) {
        Rational c = new Rational(0);
        c.number = this.number / b.number;
        return c;
    }

    public boolean equals(Rational b) {
        return this.number == b.number;
    }

    public String toString() {
        return "" + this.number;
    }

    public static void main(String[] args) {
        String in = args[0];
        String in2 = args[1];
        long use_this = Long.parseLong(in);
        long use_this2 = Long.parseLong(in2);
        Rational test = new Rational(use_this);
        Rational test2 = new Rational(use_this2);
        System.out.println(test.plus(test2).toString());
        System.out.println(test.minus(test2).toString());
        System.out.println(test.times(test2).toString());
        System.out.println(test.divides(test2).toString());
        System.out.println(test.toString());
    }

}
