import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    public static boolean isOperator(char ch){
        return (ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^');
    }
    public static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String expr){
        StringBuilder result=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (char ch:expr.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                result.append(ch);
            }else if(ch=='('){
                stack.push(ch);
            }else if (ch==')'){
                while (!stack.isEmpty()&&stack.peek()!='('){
                    result.append(stack.pop());
                }
                stack.pop();
            }else if(isOperator(ch)){
                while (!stack.isEmpty()&&precedence(ch)<=precedence(stack.peek())&&ch!='^'){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }

        }
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(infixToPostfix(s));
    }
}
