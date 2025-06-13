import java.util.Scanner;

class File{
    int number;
    File next;
    File(int number){
        this.number=number;
    }
}
class FileList{
    public static File insert(File head,int val){
        File newNode=new File(val);
        if(head==null){
            head=newNode;
            return head;
        }
        File temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    public static void viewDisplay(File head){
        if(head==null){
            return;
        }
        File temp=head;
        while(temp!=null){
            System.out.print(temp.number+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static File getMiddle(File head){
        File slow=head;
        File fast =head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static File sortList(File head){
        if(head ==null||head.next==null) return head;
        File middleNode=getMiddle(head);
        File right=middleNode.next;
        File left=head;
        middleNode.next=null;
        left=sortList(left);
        right=sortList(right);
        return merge(left,right);
    }
    public static File merge(File list1,File list2){
        File dummy=new File(-1);
        File temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.number<list2.number){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next=list1;
        }else{
            temp.next=list2;
        }
        return dummy.next;
    }
}
class FileProblem
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        File head=null;
        while (true){
            System.out.println("1.Enter a new file");
            System.out.println("2.View desktop");
            System.out.println("3.Arrange in order");
            System.out.println("4.Exit");
            System.out.println("Enter your choice :");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the file :");
                    int num=sc.nextInt();
                    if (num>100){
                        System.out.println("Oops!! not in range.");
                        break;
                    }
                    head=FileList.insert(head,num);
                    break;
                case 2:
                    System.out.println("Files are :");
                    FileList.viewDisplay(head);
                    break;
                case 3:
                    System.out.println("Files are :");
                    head=FileList.sortList(head);
                    FileList.viewDisplay(head);
                    break;
                case 4:
                    System.out.println("Exitt");
                    System.exit(0);
            }
        }
    }
}