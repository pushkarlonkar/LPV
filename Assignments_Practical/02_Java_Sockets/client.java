// client 

import java.io.*;
import java.net.*;
import java.util.*;

public class client {

  public static void main(String[] args) throws Exception {
    try {
      Socket s = new Socket("127.0.0.1", 3333);
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      Scanner sc = new Scanner(System.in);

      String str = "", str2 = "";
      while (!str.equals("stop")) {
        System.out.print("Client : ");
        str = sc.next();
        dout.writeUTF(str);
        str2 = din.readUTF();
        System.out.println("Server : " + str2);
      }
      dout.close();
      din.close();
      sc.close();
      s.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}