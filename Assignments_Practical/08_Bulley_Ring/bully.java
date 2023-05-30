// bully

import java.util.*;

public class bully {

  static boolean state[] = new boolean[1000];
  static int n;

  static void up(int process) {
    if (state[process]) {
      System.out.println("Process is already up");
    } else {
      state[process] = true;
      mess(process);
    }
  }

  public static void down(int process) {
    if (!state[process]) {
      System.out.println("Process is already down");
    } else {
      state[process] = false;
      System.out.println("Process down successfully");
    }
  }

  static void mess(int process) {
    if (state[process]) {
      System.out.println("Process" + process + " intiate election");
      for (int i = process + 1; i < n; i++) {
        System.out.println(
          "election message send from process " + process + " to process " + i
        );
      }
      for (int i = n - 1; i >= process; i--) {
        if (state[i]) {
          System.out.println("Coordinator message send from " + i + " to all");
          break;
        }
      }
    } else {
      System.out.println("Process" + process + " is down.");
    }
  }

  public static void main(String[] args) {
    int choice = 0, process = 0;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Number of Process : ");
    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      state[i] = true;
    }
    System.out.println("There are " + n + "Processes are active : ");
    for (int i = 0; i < n; i++) System.out.print("p" + i + " ");
    System.out.println("\nProcess " + n + " is coordinator.");

    do {
      System.out.println("1. Up the process");
      System.out.println("2. Down the process");
      System.out.println("3. send message");
      System.out.print("Enter the choice : ");
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Bring Up Process : ");
          process = sc.nextInt();
          up(process);
          break;
        case 2:
          System.out.print("Bring Down Process : ");
          process = sc.nextInt();
          down(process);
          break;
        case 3:
          System.out.print("Message send by Process : ");
          process = sc.nextInt();
          mess(process);
          break;
      }
    } while (choice != 4);
  }
}