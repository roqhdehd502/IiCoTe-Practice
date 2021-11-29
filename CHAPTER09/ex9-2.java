/*
9-2. 미래도시

=== 입력예시1 ===
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
=== 출력예시1 ===
3

=== 입력예시2 ===
4 2
1 3
2 4
3 4
=== 출력예시2 ===
-1

*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] web = new int[m];
    for(int i=0; i<m; i++) {
      web[i] = sc.nextInt();
    }
    
  }
}
