package ps1;
import java.rmi.*;

public interface AddServerInf extends Remote {
	
	double add(double d1, double d2) throws RemoteException;
	
}
