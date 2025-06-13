import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
class StackOper{
    static Node top;
    static int count=0;
    public static void push(int val){
        Node newNode=new Node(val);
        newNode.next=top;
        top=newNode;
        count++;
    }
    public static void pop(){
        Node temp=top;
        System.out.println("Popped element :"+temp.data);
        top=top.next;
        temp=null;
        count--;
    }
    public static void display(){
        Node temp=top;
        System.out.println("Stack contents :");
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void getCount(){
        System.out.println("Number of elements in the linked list is "+count);
    }
}
public class StackUsingLinkedList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Choice 1 : To push data");
        System.out.println("Choice 2 : To pop data");
        System.out.println("Choice 3 : To display");
        System.out.println("Choice 4 : To count");
        while (true){
            System.out.println("Enter your choice :");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the data to be pushed :");
                    int val=sc.nextInt();
                    StackOper.push(val);
                    break;
                case 2:
                    StackOper.pop();
                    break;
                case 3:
                    StackOper.display();
                    break;
                case 4:
                    StackOper.getCount();
                    break;
                default:
                    System.out.println("End");
                    System.exit(0);
            }
        }
    }
}
