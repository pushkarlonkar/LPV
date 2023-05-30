import java.io.*;
import java.net.*;
import java.util.*;

public class server {

  public static void main(String[] args) throws Exception {
    try {
      ServerSocket ss = new ServerSocket(3333, 0, null);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      Scanner sc = new Scanner(System.in);

      String str = "", str2 = "";
      while (!str.equals("stop")) {
        str2 = din.readUTF();
        System.out.print("Client : " + str2);
        System.out.println("Server : ");
        str = sc.next();
        dout.writeUTF(str);
      }
      sc.close();
      din.close();
      dout.close();
      s.close();
      ss.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}