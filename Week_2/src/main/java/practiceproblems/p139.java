package practiceproblems;

//import edu.princeton.cs.algs4.*;

public class p139 {
    public static void main(String[] args) {
        GenericResizingIteratingStack<String> ops = new GenericResizingIteratingStack<String>();
        GenericResizingIteratingStack<String> vals = new GenericResizingIteratingStack<String>();
        while (!StdIn.isEmpty()) { // Read token, push if operator.
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String v = vals.pop();
                String op = ops.pop();
                String v2 = vals.pop();
                String expression = "(" + v + op + v2 + ")";
                vals.push(expression);
            } // Token not operator or paren: push double value.
            else vals.push(s);
        }
        StdOut.println(vals.pop());
    }
}
