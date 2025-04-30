import java.rmi.*;
public class Server{
    public static void main(String args[])
    {
        try{
            Serverimpl serverimpl=new Serverimpl();
            Naming.rebind("Server",serverimpl);
            System.out.println("Server Started !");
        }catch(Exception e)
        {
            System.out.println("Error occure in server "+e);
        }
    }
}