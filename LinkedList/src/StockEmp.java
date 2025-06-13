import java.util.Scanner;

class Stock{
    int number;
    Stock next;
    Stock(int number){
        this.number=number;
    }
}
class StockList{
    static Stock head=null;
    public static void insert(int id){
        Stock newNode=new Stock(id);
        if (head==null){
            head=newNode;
            return;
        }
        Stock temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public static void display(){
        if(head==null){
            return;
        }
        Stock temp=head;
        while (temp!=null){
            System.out.print(temp.number+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void removeAtBegin(){
        if (head==null){
            return;
        }
       Stock newNode=head;
        head=head.next;
        newNode.next=null;
        System.out.println("Delivered Successfully");
        display();
    }
}
public class StockEmp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.Add goods to be delivered");
            System.out.println("2.List the goods");
            System.out.println("3.Delivered a good");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Stock ID :");
                    int id=sc.nextInt();
                    StockList.insert(id);
                    break;
                case 2:
                    System.out.println("Stock List :");
                    StockList.display();
                    break;
                case 3:
                    StockList.removeAtBegin();
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}
