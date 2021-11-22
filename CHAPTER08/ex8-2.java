/*
8-2. 1로 만들기

입력예시
==========
26
==========

출력예시
==========
3
==========
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int x = sc.nextInt();
    sc.close();
    // int[] d = new int[30001]; // 1 <= x <= 30000

    // for(int i=2; i<(x+1); i++) { // Ai = min(Ai-1, Ai/2, Ai/3, Ai/5) + 1
    //   d[i] = d[i-1] + 1;

    //   if(i % 2 == 0) {
    //     d[i] = Math.min(d[i], d[i/2]+1); 
    //   } else if(i % 3 == 0) {
    //     d[i] = Math.min(d[i], d[i/3]+1); 
    //   } else if(i % 5 == 0) {
    //     d[i] = Math.min(d[i], d[i/5]+1); 
    //   }
    // }

    // System.out.println(d[x]);

    int cnt = 0;

    while(x > 1) {
      if(x % 2 == 0 && x % 3 == 0) {
        cnt++;
        x = Math.min(x/2, x/3);
      } else if(x % 2 == 0 && x % 5 == 0) {
        cnt++;
        x = Math.min(x/2, x/5);
      } else if(x % 3 == 0 && x % 5 == 0) {
        cnt++;
        x = Math.min(x/3, x/5);
      } else if(x == 2) {
        cnt++;
        x /= 2;
      } else if(x == 3) {
        cnt++;
        x /= 3;
      } else if(x == 5) {
        cnt++;
        x /= 5;    
      } else {
        cnt++;
        x--;
      }
    }

    System.out.println(cnt);
  }
}
