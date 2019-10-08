public class p1215 {

    public static void main(String[] args) {
        int[] arrayofints = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(readInts(arrayofints));
    }

    public static String readInts(int[] in) {
        String returnThis = "";
        for (int i = 0; i < in.length; i++) {
            returnThis = returnThis.concat(Integer.toString(in[i]));
        }
        return returnThis;
    }


}
