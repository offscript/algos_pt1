import java.lang.Math;

public class p1120 {

    public static int recursive_ln (double argument) {
        double argument_factorialized = calculate_factorial(argument);
        System.out.println(argument_factorialized);
        double base = Math.E;
        int count = 1;
        if (argument < base) {
            return 0;
        } else {
            return recursive_ln_work(argument_factorialized, base, count);
        }
    }

    public static int recursive_ln_work (double argument, double answer, int count) {
        double base = Math.E;
        if (answer == argument) {
            return count;      
        } else if (answer > argument) {
            return count - 1;
        } else {
            answer*=base;
            System.out.println(answer);
            count++;
            return recursive_ln_work(argument, answer, count);
        }
    }

    public static double calculate_factorial (double argument) {
        if (argument == 1) {
            return 1.0;
        } else {
            return argument * calculate_factorial(argument - 1);
        }
    }

    public static void main (String args[]) {

        try {
            int argument = Integer.parseInt(args[0]);
            int answer = recursive_ln(argument);
            System.out.println(answer);
        } catch (NumberFormatException e) {
            System.out.println("Please input a number");
        }

    }
}