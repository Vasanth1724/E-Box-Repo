import java.util.Scanner;
import java.util.Stack;

public class CalculateInfix {
    public static boolean isOperator(char ch){
        if (ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'){
            return true;
        }
        return false;
    }

    public static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            case '^':return 3;
        }
        return -1;
    }

    public static int applyOp(int a, int b, char op){
        switch (op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
            case '^': return (int) Math.pow(a,b);
        }
        return 0;
    }

    public static int calculateInfix(String expr){
        Stack<Integer> digit=new Stack<>();
        Stack<Character> operator=new Stack<>();
        for (int i = 0; i < expr.length(); i++){
            char ch = expr.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)){
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))){
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                digit.push(num);
                i--;
            }else if(ch=='('){
                operator.push(ch);
            }else if(ch==')'){
                while (!operator.isEmpty()&&operator.peek()!='('){
                    char op=operator.pop();
                    int b=digit.pop();
                    int a=digit.pop();
                    int res=applyOp(a,b,op);
                    digit.push(res);
                }
                if (!operator.isEmpty()&&operator.peek()=='('){
                    operator.pop();
                }
            }else if (isOperator(ch)){
                while ((!operator.isEmpty()) && (operator.peek()!='(') &&
                        ((precedence(ch)<precedence(operator.peek())) ||
                                ((precedence(ch)==precedence(operator.peek()))) &&ch!='^')){
                    char op=operator.pop();
                    int b=digit.pop();
                    int a=digit.pop();
                    int res=applyOp(a,b,op);
                    digit.push(res);
                }
                operator.push(ch);
            }
        }
        while (!operator.isEmpty()){
            char op=operator.pop();
            int b=digit.pop();
            int a=digit.pop();
            int res=applyOp(a,b,op);
            digit.push(res);
        }
        return digit.pop();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println("PostFix :"+calculateInfix(s));
    }
}
