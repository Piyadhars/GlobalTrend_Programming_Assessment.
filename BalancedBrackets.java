import java.util.*;

class Main{
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String value =in.next();
        
        if(isValid(value)){
            System.out.println("Balanced");
        }else
        System.out.println("Not Balanced");
    }
    
}
