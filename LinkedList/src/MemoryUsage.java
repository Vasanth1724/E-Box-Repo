import java.util.Scanner;

class Software{
    String name;
    int memory;
    Software next;
    Software(String name,int memory){
        this.name=name;
        this.memory=memory;
    }
}
class MemoryUsageProblem {
    static Software head=null;
    public static void append(String name,int memory){
        Software s=new Software(name,memory);
        if (head==null){
            head=s;
            return;
        }
        Software temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=s;
    }
    public static void display(){
        if (head==null){
            return;
        }
        Software temp=head;
        int id=1;
        while (temp!=null){
            System.out.println(id++ +")"+temp.name+" "+temp.memory);
            temp=temp.next;
        }
    }
    public static void minimumSoftware(){
        if (head==null) return;
        Software temp=head.next;
        Software minNode=head;
        while (temp!=null){
            if (temp.memory< minNode.memory){
                minNode= temp;
            }
            temp=temp.next;
        }
        System.out.println(minNode.name+" "+minNode.memory);
    }
}

class MemoryUsage{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.Insert new software");
            System.out.println("2.Display all the softwares");
            System.out.println("3.Get the minimum memory software");
            System.out.println("4. Exit");
            System.out.println("Enter your choice :");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    int n=sc.nextInt();
                    sc.nextLine();
                    for (int i=0;i<n;i++){
                        System.out.println("Enter the software :");
                        String name=sc.nextLine();
                        System.out.println("Enter the memory :");
                        int val=sc.nextInt();
                        sc.nextLine();
                        MemoryUsageProblem.append(name,val);
                    }
                    break;
                case 2:
                    System.out.println("Software list :");
                    MemoryUsageProblem.display();
                    break;
                case 3:
                    System.out.println("Minimum memory :");
                    MemoryUsageProblem.minimumSoftware();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}