import java.util.Scanner;

class Ticket{
    int number;
    Ticket next;
    Ticket(int number){
        this.number=number;
    }
}

class Listt{
    static Ticket head=null;
    public static void insert(int num){
        Ticket newNode=new Ticket(num);
        if (head==null){
            newNode.next=head;
            head=newNode;
            return;
        }
        Ticket temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public static void display(){
        if (head==null){
            return;
        }
        Ticket temp=head;
        System.out.println("Seating position are :");
        while (temp!=null){
            System.out.print(" "+temp.number);
            temp=temp.next;
        }
        System.out.println();
    }
    public static void insertAtPos(int pos,int num){
        if (pos<1){
            System.out.println("Invalid position");
            return;
        }
        Ticket newNode=new Ticket(num);
        if (pos==1){
            newNode.next=head;
            head=newNode;
            System.out.println("Wrong seat has been moved");
            return;
        }
        Ticket temp=head;
        int count=1;
        while (temp!=null && count<pos-1){
            temp=temp.next;
            count++;
        }
        if (temp==null){
            System.out.println("Nobody has occupied the seat");

        }else {
            newNode.next=temp.next;
            temp.next=newNode;
            System.out.println("Wrong seat has been moved");
        }
    }
}
class TicketBooking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.Enter ticket number occupying wrong seat");
            System.out.println("2.Arrange the seating position");
            System.out.println("3.Display current seating position");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the ticket :");
                    int seat=sc.nextInt();
                    Listt.insert(seat);
                    break;
                case 2:
                    System.out.println("Enter the position of the ticket :");
                    int pos=sc.nextInt();
                    System.out.println("Enter the ticket number :");
                    int correctSeat= sc.nextInt();
                    Listt.insertAtPos(pos,correctSeat);
                    break;
                case 3:
                    Listt.display();
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}
