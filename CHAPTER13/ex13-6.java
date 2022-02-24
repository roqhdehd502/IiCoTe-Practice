/**
13-06. 감시 피하기

=== 입력예시 ===
5
X S X X T
T X S X X
X X X X X
X T X X X
X X T X X

=== 출력예시 ===
YES
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[][] arr = new String[n][n];
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.next();
      }
      sc.nextLine();
    }
    /* 구현중... */

    sc.close();
  }
}
