import java.util.Scanner;

class StackOperations1{
    static int[] arr=new int[5];
    static int top=-1;
    public static void resize(){
        int[] temp=new int[arr.length*2];
        for (int i=0;i<=top;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }
    public static void push(int val){
        if (top==arr.length-1){
            resize();
        }
        arr[++top]=val;
    }
    public static void pop(){
        if (top==-1){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Popped element is :"+arr[top]);
        top--;
    }
    public static void display(){
        System.out.println("The contents of the stack are :");
        for (int i=0;i<=top;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
public class DynamicArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Choice 1 : Push");
            System.out.println("Choice 2 : Pop");
            System.out.println("Choice 3 : Display");
            System.out.println("Any other choice : Exit");
            System.out.println("Enter your choice :");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the element to be pushed");
                    int val=sc.nextInt();
                    StackOperation.push(val);
                    break;
                case 2:
                    StackOperation.pop();
                    break;
                case 3:
                    StackOperation.display();
                    break;
                default:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}
