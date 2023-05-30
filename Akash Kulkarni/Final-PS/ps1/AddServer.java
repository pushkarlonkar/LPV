package ps1;
import java.rmi.*;
import java.net.*;

public class AddServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			AddServerImpl addServerImpl =  new AddServerImpl() ;
			Naming.rebind("AddServer", addServerImpl);
			
		}
		
		catch(Exception e) { 
			System.out.println("Exception: "+ e);
		}
	}

}
