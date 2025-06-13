import java.util.Scanner;
import java.util.Stack;

public class ParenthesesBalance {
    public static boolean isValid(String expr){
        Stack<Character> stack=new Stack<>();
        for (char ch:expr.toCharArray()){
            if (ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if (stack.isEmpty()) return false;
                char top=stack.pop();
                if ((ch==')'&&top!='(')||(ch=='}'&&top!='{')||(ch==']'&&top!='[')) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if(isValid(s)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
