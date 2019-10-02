public class p126 {

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        System.out.println(circular_rotation(s, t));
    }


    public static boolean circular_rotation(String s, String t) {
        if (s.length() == t.length() && (s + s).contains(t)) {
            return true;
        } else {
            return false;
        }
    }
}
