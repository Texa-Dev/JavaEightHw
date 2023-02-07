package pack;



public class Main {
    public static void main(String[] args) {
//TODO реализивать проверки в методах Fraction

        Fraction testF = new Fraction(2, 6);
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);


        //setters
//        testF.setFlag.accept(3);
//        testF.setDig.accept(4);
//        System.out.println(testF.toString.get());

        //fraction to decimal
        System.out.println(f.toDecimalFraction.get());

        //equals
        System.out.println(testF.equals.test(f));
        System.out.println(f.equals.test(f2));

        //multi
        System.out.println(f.multi.apply(testF).toString.get());

        //dived
        System.out.println(f.dived.apply(testF).toString.get());

        //addition
        System.out.println(f.addition.apply(f2).toString.get());

        //subtraction
        System.out.println(testF.subtraction.apply(f2).toString.get());

        //Static methods

        //to Decimal
        System.out.println(Fraction.decimal.apply(testF));

        //equalsTwoFrac
        System.out.println(Fraction.equalsTwoFrac.test(f,f2));
        System.out.println(Fraction.equalsTwoFrac.test(testF,f2));

        //string to Fraction
        Fraction f3 = Fraction.stringToFrac.apply("125/247");
        System.out.println( f3.toString.get() +" "+ f3.getClass());

        //multiTwoFrac
        System.out.println(Fraction.multiTwoFrac.apply(f,f2).toString.get());

        //divedTwoFrac
        System.out.println(Fraction.divedTwoFrac.apply(f,f2).toString.get());
    }
}