package pack;

import java.util.function.*;

public class Fraction {
    private int flag;
    private int dig;

    public Fraction(int flag, int dig) {
        this.flag = flag;
        this.dig = dig;
    }

    public final IntSupplier getFlag = () -> flag;
    public final IntConsumer setFlag = flag -> this.flag = flag;
    public final IntSupplier getDig = () -> dig;
    public final IntConsumer setDig = dig -> this.dig = dig;

    public final Supplier<String> toString = () -> (this.getFlag.getAsInt() + "\\" + this.getDig.getAsInt()); //done
    public final Supplier<Double> toDecimalFraction = () -> ((double) this.getFlag.getAsInt() / this.getDig.getAsInt()); //done

    public final Predicate<Fraction> equals = frac -> (this.flag / this.dig) == (frac.flag / frac.dig);//done
    public final UnaryOperator<Fraction> multy = frac -> new Fraction(this.flag * frac.flag, this.dig * frac.dig); //done
    public final UnaryOperator<Fraction> dived = frac -> new Fraction(this.flag * frac.dig, this.dig * frac.flag);
    public final UnaryOperator<Fraction> addition = frac -> {
        int f = lcm(frac.dig, this.dig);
        return new Fraction((this.flag * (f / this.dig)) + (frac.flag * (f / frac.dig)),
                (this.dig * (f / this.dig)));
    };
    public final UnaryOperator<Fraction> sub = frac -> {
        int f = lcm(frac.dig, this.dig);
        return new Fraction((this.flag * (f / this.dig)) - (frac.flag * (f / frac.dig)),
                (this.dig * (f / this.dig)));
    };

    public static final BinaryOperator<Fraction> multyFrac =
            (f1, f2) -> new Fraction(f1.flag * f2.flag, f1.dig * f2.dig);
    public static final Function<Fraction, Double> decimal = p -> (double) p.flag / p.dig;

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

}
