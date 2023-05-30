import java.util.*;
import java.net.*;
import java.io.*;


public class ring{
    public static void main(String[] args) {
        int sender = 0;
        int receiver = 0;
        int token = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of process : ");
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            System.out.print(" p"+i);
        }
        System.out.println(" p"+0);

        while(true){
            System.out.println("-----------------");
            System.out.println("Enter Sender : ");
            sender = sc.nextInt();
            System.out.println("Enter Receiver  :");
            receiver = sc.nextInt();
            System.out.println("Token passes : ");
            for(int i = token;i!=sender;i = (i+1)%n){
                System.out.print(i+" -->");
            }
            System.out.println();
            System.out.println(sender);
            System.out.println("Enter data to be sent : ");
            String data = sc.next();


            for(int i = sender;i!=receiver;i = (i+1)%n){
                System.out.println(data + " forwarded by "+i);
            }

            System.out.println(data + " received at " + receiver);
            token = sender;
            System.out.println("--------------------------");
        }
    }
}