import ReverseModule.*;
import java.util.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextExtPackage.*;
import org.omg.PortableServer.*;

public class ReverseClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            NamingContextExt ncRef = NamingContextExtHelper.narrow(
                orb.resolve_initial_references("NameService")
            );

            Reverse reverse = ReverseHelper.narrow(ncRef.resolve_str("Reverse");
            
            System.out.println("Enter String : ");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            String revStr = reverse.reverse_string(str);
            System.out.println(revStr);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
