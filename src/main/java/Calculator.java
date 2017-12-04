public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    };

    public static double substract (double a, double b) {
        return a - b;
    };

    public static double multiply (double a, double b) {
        return a * b;
    };

    public static double divide (double a, double b) {
        if (a == 0 && b == 0) {throw new ArithmeticException("Cannot divide 0 by 0");}
        return a / b;
    };

    public static void main(String [ ] args) {
        System.out.println(divide(0,0));
    }
}
