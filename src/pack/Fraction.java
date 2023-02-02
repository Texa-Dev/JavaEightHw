package pack;

import java.util.function.*;

public class Fraction {
    private int flag;
    private int dig;

    public Fraction(int flag, int dig) {
        this.flag = flag;
        this.dig = dig;
    }

    public final IntSupplier getFlag=() -> flag;
    public final IntConsumer setFlag=flag -> this.flag=flag;
    public final IntSupplier getDig=() -> dig;
    public final IntConsumer setDig=dig -> this.dig=dig;

    public static final BinaryOperator<Fraction> multyFrac =
            (f1,f2)->new Fraction(f1.flag* f2.flag, f1.dig* f2.dig );

    public final Supplier<String> toString = () ->( this.getFlag.getAsInt() +"\\"+ this.getDig.getAsInt());
}
