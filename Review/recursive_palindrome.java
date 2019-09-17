public class recursive_palindrome {

    public static void main(String[] args) {
        String s = "323";
        System.out.println(s.substring(1, s.length() - 1));
        //System.out.println(isPalindromeRecursive("thomas"));
        System.out.println(isPalindromeRecursive("anna"));
    }

    public static boolean isPalindromeIterative(String s) {
        int N = s.length();
        for (int i = 0; i < N/2; i++) {
            if (s.charAt(i) != s.charAt(N-1-i)) // compare first and last
                return false;                                // remember length - 1 - i is last is java
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String s) {
        System.out.println(s);
        if (s.length() == 0 || s.length() == 1) {
            return true;
        } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindromeRecursive(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }
}




