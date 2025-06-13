import java.util.Scanner;

class StackOperations{
    static int[] arr;
    static int top1;
    static int top2;

    public static void assignArray(int size){
        arr=new int[size];
        top1=-1;
        top2=arr.length;
    }
    public static void push1(int val){
        if(top1+1==top2){
            System.out.println("Stack1 is full");
            return;
        }
        arr[++top1]=val;
    }
    public static void push2(int val){
        if (top1+1==top2){
            System.out.println("Stack2 is full");
            return;
        }
        arr[--top2]=val;
    }
    public static void pop1(){
        if (top1==-1){
            System.out.println("Stack1 is empty");
            return;
        }
        System.out.println("The popped element from stack1 :"+arr[top1]);
        top1--;
    }
    public static void pop2(){
        if (top2==arr.length){
            System.out.println("Stack2 is empty");
            return;
        }
        System.out.println("The popped element from stack2 :"+arr[top2]);
        top2++;
    }
    public static void display1(){
        System.out.println("The contents of the stack1 are ");
        for (int i=0;i<=top1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void display2(){
        System.out.println("The contents of the stack2 are ");
        for (int i=arr.length-1;i>=top2;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
public class TwoStackInAnArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the maximum size of the stack :");
        int size=sc.nextInt();
        StackOperations.assignArray(size);
        while (true){
            System.out.println("Choice 1 : Push1");
            System.out.println("Choice 2 : Push2");
            System.out.println("Choice 3 : Pop1");
            System.out.println("Choice 4 : Pop2");
            System.out.println("Choice 5 : Display1");
            System.out.println("Choice 6 : Display2");
            System.out.println("Any other choice : Exit");
            System.out.println("Enter your choice :");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter element to be pushed into the stack1 :");
                    int val1=sc.nextInt();
                    StackOperations.push1(val1);
                    break;
                case 2:
                    System.out.println("Enter element to be pushed into the stack2 :");
                    int val2=sc.nextInt();
                    StackOperations.push2(val2);
                    break;
                case 3:
                    StackOperations.pop1();
                    break;
                case 4:
                    StackOperations.pop2();
                    break;
                case 5:
                    StackOperations.display1();
                    break;
                case 6:
                    StackOperations.display2();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
