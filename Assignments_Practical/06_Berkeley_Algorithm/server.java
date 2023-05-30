//server.java
import java.io.*;
import java.net.*;
import java.util.*;

public class server extends Thread {

  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(12345);
      List<Long> clientTimes = new ArrayList<>();
      clientTimes.add(System.currentTimeMillis());
      System.out.println("Server is running. Waiting for clients...");
      while (clientTimes.size() < 1000) {
        System.out.println("-------------------------------------");
        Socket clientSocket = serverSocket.accept();
        DataInputStream inputStream = new DataInputStream(
          clientSocket.getInputStream()
        );
        DataOutputStream outputStream = new DataOutputStream(
          clientSocket.getOutputStream()
        );
        System.out.println("listening to client timing ");

        long clientTime = inputStream.readLong();
        clientTimes.add(clientTime);

        outputStream.writeUTF(
          "Time received by the server." + new Date(clientTime)
        );
        long sum = 0, n = clientTimes.size();
        for (int i = 0; i < n; i++) {
          sum += clientTimes.get(i);
        }

        System.out.println("Number of client to be synchronized " + n);
        System.out.println("-------------------------------------");

        long averageTime = sum / clientTimes.size();
        outputStream.writeLong(averageTime);
        inputStream.close();
        outputStream.close();
        clientSocket.close();
      }
      serverSocket.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
----------------------------------------------------------------------
