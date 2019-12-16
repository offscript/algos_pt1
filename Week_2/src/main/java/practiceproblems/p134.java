package practiceproblems;

import java.util.HashMap;

public class p134 {

    public static void main(String[] args) {
        parentheses_input();
    }

    public static void parentheses_input() {
        GenericResizingIteratingStack<String> s;
        s = new GenericResizingIteratingStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else {
                System.out.println(match_parentheses(s));
                s = new GenericResizingIteratingStack<String>();
            }
        }
        //StdOut.println("(" + s.size() + " left on stack)");
    }

    public static boolean match_parentheses(GenericResizingIteratingStack<String> s) {
        HashMap<String, String> map
                = new HashMap<>();
        map.put("}", "{");
        map.put(")", "(");
        map.put("]", "[");
        GenericResizingIteratingStack<String> removed_items = new GenericResizingIteratingStack<String>();
        try {
            for (String i : s) {
                if (map.containsValue(i)) {
                    removed_items.push(i);
                } else if (map.containsKey(i)) {
                    if (!map.get(i).equals(removed_items.pop())) {
                        System.out.println("doesn't equal");
                        return false;
                    }
                } else {
                    System.out.println("not in hash");
                    return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
            return false;
        }
        return true;
    }


/*

Attempt 1, roughly

    public static boolean match_parentheses(p134 stack) {
        System.out.println("test");
        HashMap<String, String> map
                = new HashMap<>();
        map.put("{", "}");
        map.put("(", ")");
        map.put("[", "]");
        GenericResizingIteratingStack<String> removed_items = new GenericResizingIteratingStack<String>();
        GenericResizingIteratingStack<String> copied_stack = stack;
        return recursive_pop(copied_stack, removed_items, map);
    }

    public static boolean recursive_pop(GenericResizingIteratingStack<String> stack, GenericResizingIteratingStack<String> removed_keys, HashMap<String, String> map) {
        String item = stack.pop();
        System.out.println("Item is: " + item);
        if (item == null) {
            return true;
        } else if (map.containsKey(item)) {
            removed_keys.push(item);
            return recursive_pop(stack, removed_keys, map);
        } else if (map.containsValue(item)) {
            System.out.println("removed keys: " + removed_keys.peek());
            System.out.println("given item: " + item);
            System.out.println("item mapped to removed key " + map.get(removed_keys.peek()));
            if (map.get(removed_keys.peek()).equals(item)) {
                System.out.println("match");
                item = removed_keys.pop();
                return recursive_pop(stack, removed_keys, map);
            } else {
                System.out.println("parentheses not matched");
                return false;
            }
        } else {
            return false;
        }
    } */
}

/*
Notes on Attempt 1:

Problems:

I thought this algorithm was goinig to be pretty clever but it has some problems.

Problem One: A single parentheses is always evaluated to be true. I need to move the truth checking
portion elsewhere. The parentheses should be said to match only when the stack is now empty and a
pair of parentheses has just been matched.

Thought One: I'm not super convinced by this recursive solution. I maybe could have used an iterator.
Same setup as this, pop onto a stack to hold left parentheses, match left ones when they occur, false if
they don't match.

Attempt 2:

Looks good, the iterator looks better.

Now we need a test client, good to get in the habit of doing.

 */
