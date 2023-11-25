package app.server;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class server implements Hello {
        
    public server() {}

    public String sayHello() {
        return "Hello, world!";
    }
        
    public static void main(String args[]) {
        
        try {
            //Create and export a remote object
            server obj = new server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            //Register the remote object with a Java RMI registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}