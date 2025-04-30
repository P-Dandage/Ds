import java.util.*;
class TokenRing{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);

        System.out.print("Enter the Number of Nodes in ring");
        int n=s.nextInt();

        System.out.println("Nodes in Ring are as Below :");
        for(int i=0;i<n;i++)
        System.out.print(" "+i+" ->");
        System.out.print(" 0(Loop Back to 0");
        System.out.println("\n Note :Initialy Token is at Node 0");

        int sender,receiver;
        int token=0;
        int choice;
        do{
            while(true)
            {
                System.out.println("Enter Sender : ");
                sender=s.nextInt();
                if(sender<0|| sender>n)
                System.out.println("Enter valid Sender between"+1+" to "+sender);
                else
                break;
            }
          
            while(true)
            {
                System.out.println("Enter receiver : ");
                receiver=s.nextInt();
                if(receiver<0|| receiver>n)
                System.out.println("Enter valid Sender between"+1+" to "+sender);
                else
                break;
            }
            System.out.println("Enter Data : ");
            int data=s.nextInt();

            System.out.println("sender is "+sender +" Sending data "+data);
              System.out.println("Token passing [previous -> next Node]");
              for(int i=token; i!=sender;i=(i+1)%n)
                System.out.print(" "+i+"->");
              System.out.print(" "+sender);
                          System.out.println("\n Note: Current Token is at Node " + sender);

                            System.out.println("Data passing [previous -> next Node]");
              for(int i=sender; i!=receiver;i=(i+1)%n)
                System.out.print(" "+i+"->");
              System.out.print(" "+receiver);
            System.out.println("\nReceiver: " + receiver + ", Received the data: " + data);
            token=sender;

            System.out.print("\nDo you want to send data again? If yes Enter 1, If no Enter 0 ");
               choice=s.nextInt();
        }while(choice==1);

    }
}