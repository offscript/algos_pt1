public class p1113 {

    public static int lg(int argument) {
        int base = 2;
        int answer = 2;
        int count = 1;

        if (argument < base) {
            return 0;
        } else {
            while (argument >= answer) {
                answer*=base;
                count++;
            }
            return count - 1;
        }
    }

    public static int lg_recursive(int argument) {
        int count = 1;
        int base = 2;
        int answer;
        if (argument < base) {
            return 0;
        } else {
            answer = lg_recursive_work(argument, base, count);
            return answer;
        }
    }
    
    public static int lg_recursive_work(int argument, int answer, int count) {
        int base = 2;
        if (argument == answer) {
            return count;
        }else if (answer > argument) {
            return count -1;
        } else {
            answer*=base;
            count++;
            return lg_recursive_work(argument, answer, count);
        }
    }

    public static void main(String args[]) {

        try {
            int argument = Integer.parseInt(args[0]);
            int printnum = lg(argument);
            System.out.println("Iterative answer " + printnum);


            printnum = lg_recursive(argument);
            System.out.println("Recursive answer " + printnum);

        } catch (NumberFormatException e) {
            System.out.println("please enter a number");
        }

    }

}