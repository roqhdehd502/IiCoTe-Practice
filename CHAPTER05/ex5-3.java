/* 
5-3. 음료수 얼려먹기
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
      //Scanner sc = new Scanner(System.in);
      // Stack<Integer> stack = new Stack<>(); //int형 스택 선언

      int N = 4; // 세로길이
      int M = 5; // 가로길이

      int arr[][] = {{0, 0, 1, 1, 0},
                     {0, 0, 0, 1, 1},
                     {1, 1, 1, 1, 1},
                     {0, 0, 0, 0, 0}};

      int cntY[] = new int[M];
      int cntX[] = new int[N];
      int isCon = 0; // 연속 혹은 불연속인 라인이 있는지 카운트

      for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
          System.out.print(arr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();       

      for(int i=0; i<N; i++) { // X축에서 연속적인 라인이 있는지 확인
        for(int j=1; j<M; j++) {
          if( (arr[i][j] == 0) && (arr[i][j] == arr[i][j-1]) ) {
            isCon = 1;
          }
        }
        cntX[i] = (isCon >= 1) ? isCon : 0;
        isCon = 0;
      }
      for(int i=0; i<M; i++) { // Y축에서 연속적인 라인이 있는지 확인
        for(int j=1; j<N; j++) {
          if( (arr[j][i] == 0) && (arr[j][i] == arr[j-1][i]) ) {
            isCon = 1;
          }
        }
        cntY[i] = (isCon >= 1) ? isCon : 0;
        isCon = 0;
      }

      System.out.println("X축에서 연속하는지의 여부");
      for(int i=0; i<cntX.length; i++) {
        System.out.print(cntX[i] + " ");
      }
      System.out.println();
      System.out.println("Y축에서 연속하는지의 여부");
      for(int i=0; i<cntY.length; i++) {
        System.out.print(cntY[i] + " ");
      }
      System.out.println();

      for(int i=0; i<cntX.length; i++) {
        for(int j=0; j<cntY.length; j++) {
          cntX[i]^cntY[j]
        }
      }
      

      
      

      //sc.close();
    }
}
