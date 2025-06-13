import java.util.Scanner;

class Keyboard{
    int key;
    Keyboard next;
    Keyboard(int key){
        this.key=key;
    }
}
class List{
    static Keyboard head=null;
    public static void insert(int val){
        Keyboard newNode=new Keyboard(val);
        if (head==null||head.key>val){
            newNode.next=head;
            head=newNode;
            return;
        }
        Keyboard temp=head;
        while (temp.next!=null&&temp.next.key<val){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public static void display(){
        if (head==null){
            return;
        }
        Keyboard temp=head;
        System.out.println("Keyboard: ");
        while (temp!=null){
            System.out.print(temp.key+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
class KeyBoardProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.Enter a disassembled key");
            System.out.println("2.View keyboard");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    int val;
                    while (true){
                        System.out.println("Enter the key :");
                        val=sc.nextInt();
                        if (val>=0 && val<=9) break;
                    }
                    List.insert(val);
                    break;
                case 2:
                    List.display();
                    break;
                case 3:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}
