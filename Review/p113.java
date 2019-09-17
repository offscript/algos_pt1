public class p113 {
    public static void main(String args[]) {
        //predicate to make sure that all values are ints

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println(('a' + 4));

        try {
            int val1 = Integer.parseInt(args[0]);
            int val2 = Integer.parseInt(args[1]);
            int val3 = Integer.parseInt(args[2]);

            if (val1 == val2 && val2 == val3) {
                System.out.println("equal");
            }
            else {
                System.out.println("not equal");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }
        //compare the values and reutnr if they are all the same 
    }

}