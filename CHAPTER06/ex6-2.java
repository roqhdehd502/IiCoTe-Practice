/*
6-2. 위에서 아래로
*/

import java.util.Arrays;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = 4;
    int arr[] = new int[n];

    for(int i=0; i<arr.length; i++) {
      arr[i] = Integer.parseInt(sc.nextLine());
    }

    Arrays.sort(arr);

    for(int i=arr.length-1; i>=0; i--) {
      System.out.print(arr[i] + " ");
    }
    
    sc.close();
  }
}
