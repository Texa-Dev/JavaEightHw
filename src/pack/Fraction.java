package pack;

import java.util.function.*;

public class Fraction {
    private int flag;
    private int dig;

    public Fraction(int flag, int dig) {
        this.flag = flag;
        this.dig = dig;
    }

    //геттеры  сеттеры
    public final IntSupplier getFlag = () -> flag;
    public final IntConsumer setFlag = flag -> this.flag = flag;
    public final IntSupplier getDig = () -> dig;
    public final IntConsumer setDig = dig -> this.dig = dig;

    //преобразование дроби в строку "1/2"
    public final Supplier<String> toString = () -> (this.flag + "/" + this.dig); //done

    //преобразование дроби в десятичную 1/2 –> 0.5
    public final Supplier<Double> toDecimalFraction = () -> ((double) this.flag / this.dig); //done

    // сравнение этой дроби с другой
    public final Predicate<Fraction> equals = frac -> (decimal.apply(this).equals(decimal.apply(frac)));//done
    //умножение этой дроби на другую
    public final UnaryOperator<Fraction> multi = frac -> new Fraction(this.flag * frac.flag, this.dig * frac.dig); //done

    //деление этой дроби на другую
    public final UnaryOperator<Fraction> dived = frac -> new Fraction(this.flag * frac.dig, this.dig * frac.flag);

    //суммирование этой дроби с другой
    public final UnaryOperator<Fraction> addition = frac -> {
        int f = lcm(frac.dig, this.dig);
        return new Fraction((this.flag * (f / this.dig)) + (frac.flag * (f / frac.dig)),
                (this.dig * (f / this.dig)));
    };
    //отнимание другой дроби от этой
    public final UnaryOperator<Fraction> subtraction = frac -> {
        int f = lcm(frac.dig, this.dig);
        return new Fraction((this.flag * (f / this.dig)) - (frac.flag * (f / frac.dig)),
                (this.dig * (f / this.dig)));
    };


    //преобразование дроби в десятичную 1/2 -> 0.5
    public static final Function<Fraction, Double> decimal = p -> (double) p.flag / p.dig;

    //сравнение двух дробей
    public static final BiPredicate<Fraction, Fraction> equalsTwoFrac = (frac1, frac2) -> decimal.apply(frac1).equals(decimal.apply(frac2));

    //преобразовать строку в дробь. Строка должна иметь вид: "1/2".
    public static final Function<String, Fraction> stringToFrac = s -> {
        String[] split = s.split("/");
        return new Fraction(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    };

    //умножение двух дробей
    public static final BinaryOperator<Fraction> multiTwoFrac =
            (f1, f2) -> new Fraction(f1.flag * f2.flag, f1.dig * f2.dig);

    //деление двух дробей
    public static final BinaryOperator<Fraction> divedTwoFrac =
            (f1, f2) -> new Fraction(f1.flag * f2.dig, f1.dig * f2.flag);


    //функции приведения к общему знаменателю
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

}
