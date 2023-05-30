import java.util.*;
import java.net.*;
import java.io.*;

public class ring {
    static boolean[] state = new boolean[1000];
    static int n;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Processes : ");
        n = sc.nextInt();
        for(int i = 0;i<n;i++){
            state[i] = true;
        }
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = -1;
        }
        

        System.out.println("There are "+n + "Processses");
        for(int i = 0;i<n;i++){
            System.out.print("p"+i+"");
        }
        System.out.println("Process" + (n-1)+ "fails");


        state[n-1] = false;

        int choice = 0;

        do{
            System.out.println("1. Election");
            System.out.println("2. Exit");
            System.out.println("Enter your choice");

            choice = sc.nextInt();
            switch(choice){
                case 1 : {
                    System.out.println("Enter Process who is initializing the election");
                    int process = sc.nextInt();
                    int cur = process , j = 0;
                    do {
                        arr[j++] = cur;
                        int next = (cur+1)%n;
                        while(!state[next]){
                            next =( next + 1 ) %n;
                        }
                        System.out.println("Process " + cur + "sends message to"+ next);
                        cur = next;

                    }while(cur!=process);


                    int maxi = -1;
                    for(int i = 0;i<n;i++) if(maxi<arr[i]) maxi = arr[i];
                    System.out.println("Process " + maxi + "Selected as coordinator");
                    cur = process;

                    do{
                        int next = ( cur + 1 ) %n;
                        while(!state[next] ) next = (next + 1 ) % n;
                        System.out.println("Process " + cur + "Pass Coordinator ( " + maxi + ") message to" + next);
                        cur = next;
                    }while(cur!=process);
                }
                case 2 : {
                    return ;
                }
                default : {
                    break;
                }
            }

        }while(true);
    }
}
