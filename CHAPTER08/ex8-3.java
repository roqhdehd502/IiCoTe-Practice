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
    int m1 = 0;
    int m2 = 0;
    
    for(int i=0; i<k.length; i++) { k[i] = sc.nextInt(); }
    sc.close();

    for(int i=0; i<k.length; i+=2) { m1 += k[i]; }
    for(int i=1; i<k.length; i+=2) { m2 += k[i]; }

    System.out.println(Math.max(m1, m2));
  }
}
