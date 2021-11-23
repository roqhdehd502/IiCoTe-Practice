/*
8-3. 개미 전사

입력예시
======
4
1 3 1 5

출력예시
======
8
*/

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] k = new int[n];
    int max = 0;
    
    for(int i=0; i<k.length; i++) { k[i] = sc.nextInt(); }
    sc.close();
    
    Arrays.sort(k);

    if(n % 2 == 0) {
      for(int i=n-1; i>((n/2)-1); i--) { max += k[i]; }
    } else if(n % 2 == 1) {
      for(int i=n-1; i>=n/2; i--) { max += k[i]; }
    }
    
    System.out.println(max);
  }
}
