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

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] k = new int[n];
    for(int i=0; i<k.length; i++) { k[i] = sc.nextInt(); }
    sc.close();

    // int m1 = 0;
    // int m2 = 0;
    // for(int i=0; i<k.length; i+=2) { m1 += k[i]; }
    // for(int i=1; i<k.length; i+=2) { m2 += k[i]; }

    // System.out.println(Math.max(m1, m2));
    
    int[] d = new int[100];

    d[0] = k[0];
    d[1] = Math.max(k[0], k[1]);
    for(int i=2; i<n; i++) {
      d[i] = Math.max(d[i-1], d[i-2]+k[i]);
    }

    System.out.println(d[n-1]);
  }
}
