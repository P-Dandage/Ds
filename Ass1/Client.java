import java.rmi.*;
import java.util.*;

public class Client{

public static void main(String[]args)
{
    Scanner s=new Scanner(System.in);

    try{
        String url="rmi://localhost/Server";
        Serverintf serverintf=(Serverintf) Naming.lookup(url);

        System.out.println("Enter n1:");
        int a=s.nextInt();
         System.out.println("Enter n2:");
        int b=s.nextInt();

        System.out.println("add : "+serverintf.add(a,b));
         System.out.println("sub : "+serverintf.sub(a,b));
          System.out.println("add : "+serverintf.mul(a,b));
           System.out.println("div : "+serverintf.div(a,b));

    }catch(Exception e)
    {
        System.out.println("Error occure"+ e);
    }

}}