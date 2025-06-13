import java.util.Scanner;

class Employee{
    int id;
    Employee next;
    Employee(int id){
        this.id=id;
    }
}
class EmpList{
    static Employee head=null;
    public static void insert(int id){
        Employee newNode=new Employee(id);
        if (head==null){
            head=newNode;
            return;
        }
        Employee temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public static void display(){
        if(head==null){
            System.out.println("Employee list is empty");
            return;
        }
        Employee temp=head;
        while (temp!=null){
            System.out.print(temp.id+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void removeId(int id){
        if (head==null){
            System.out.println("Employee ID list is empty");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Removed successfully");
            return;
        }
        Employee temp=head;
        Employee prev=null;
        while (temp!=null&&temp.id!=id){
            prev=temp;
            temp=temp.next;
        }
        if (temp==null){
            System.out.println("Employee ID "+id+" is not found");
        }else{
            prev.next=temp.next;
            temp.next=null;
            System.out.println("Removed successfully");
        }
    }
}
public class EmployeeList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1.Insert a new Employee");
            System.out.println("2.Display the Employees");
            System.out.println("3.Remove an Employee ID");
            System.out.println("Exit");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter an Employee ID :");
                    int id=sc.nextInt();
                    EmpList.insert(id);
                    break;
                case 2:
                    EmpList.display();
                    break;
                case 3:
                    System.out.println("Enter an Employee id to be removed :");
                    int removeid=sc.nextInt();
                    EmpList.removeId(removeid);
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}
