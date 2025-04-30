import java.rmi.*;
import java.rmi.server.*;
public class Serverimpl extends UnicastRemoteObject implements Serverintf{
    public  Serverimpl() throws RemoteException{

    }
      public int add(int a,int b) throws RemoteException{
           return a+b;
    }
      public int sub(int a,int b) throws RemoteException{
        return a-b;
    }
   public int mul(int a,int b) throws RemoteException{
           return a*b;
    }
       public int div(int a,int b) throws RemoteException{
           return a/b;
    }

}