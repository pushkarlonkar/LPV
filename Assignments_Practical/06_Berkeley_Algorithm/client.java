//client.java
import java.io.*;
import java.net.*;
import java.util.*;

public class client extends Thread {

  public static void main(String[] args) {
    try {
      // Connect to the server
      while (true) {
        Socket socket = new Socket("localhost", 12345);
        DataInputStream inputStream = new DataInputStream(
          socket.getInputStream()
        );
        DataOutputStream outputStream = new DataOutputStream(
          socket.getOutputStream()
        );

        long clientTime = System.currentTimeMillis();
        outputStream.writeLong(clientTime);
        String acknowledgment = inputStream.readUTF();

        System.out.println(acknowledgment);

        long averageTime = inputStream.readLong();
        System.out.println("-------------------------------------");
        System.out.println("Current time : " + new Date(clientTime));
        System.out.println("Adjusted time : " + new Date(averageTime));
        System.out.println("-------------------------------------");

        inputStream.close();
        outputStream.close();
        socket.close();

        Thread.sleep(10000);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}