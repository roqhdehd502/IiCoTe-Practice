/**
16-02. 정수 삼각형

=== 입력 예시 ===
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

=== 출력 예시 ===
30(= 7+8+1+7+5)
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    int n = 5;
    int[][] tri = {
                    {7}
                  , {3, 8}
                  , {8, 1, 0}
                  , {2, 7, 4, 4}
                  , {4, 5, 2, 6, 5}
                  };

    int start = 0;    
    int temp = 0;
    int sum = 0;
    for(int i=0; i<n; i++) {
      for(int j=start; j<i; j++) {
        temp = Math.max(temp, tri[i][j]); // start의 시점을 지정하는 코드를 추가해보자!
      }
      sum += temp;
      temp = 0;
    }

    System.out.println(sum);
  }
}
