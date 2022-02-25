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

    int n = sc.nextInt(); // 크기 설정
    char[][] arr = new char[n][n]; // 복도 설정
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.next().charAt(j); // S: 학생, T: 선생님, X: 아무것도 존재하지 않음
      }
      sc.nextLine();
    }

    int[][] find  = new int[n][n]; // 발각 직전 좌표
    /* ToDo: 발각 직전 서로 겹치는 좌표가 있을 것이다 이 경우 우선적으로 장애물을 세운다 */
    for(int i=0; i<n; i++) { // 선생님의 학생 감시
      for(int j=0; j<n; j++) {
        if(arr[i][j] == 'T') { 
          if(nMntrng(arr, i, j) != -1) {
            find[i][j]++; // 카운팅
          }
          if(sMntrng(arr, n, i, j) != -1) {
            find[i][j]++;
          }
          if(wMntrng(arr, i, j) != -1) {
            find[i][j]++;
          }
          if(eMntrng(arr, n, i, j) != -1) {
            find[i][j]++;
          }
        }
      }
    }

    ArrayList<ArrayList<Integer>> obst = new ArrayList<ArrayList<Integer>>(); // 장애물을 세우기 위한 배열
    ArrayList<Integer> nobst = new ArrayList<Integer>();
    ArrayList<Integer> sobst = new ArrayList<Integer>();
    ArrayList<Integer> wobst = new ArrayList<Integer>();
    ArrayList<Integer> eobst = new ArrayList<Integer>();

    /* ToDo: 장애물을 3개 세울때 학생이 발각되지 않는 여부를 리턴한다 */
  }
    

  /* 감시 알고리즘을 체스의 룩 처럼 구현하여 발각 직전 지점을 리턴한다 */
  private static int nMntrng(char[][] arr, int i, int j) { // 북쪽으로
    int loc = -1;
    for(int v=i; v>=0; v--) {
      if(arr[v][j] == 'S') {
        loc = v+1;
        break;
      }
    }
    return loc;    
  }
  private static int sMntrng(char[][] arr, int n, int i, int j) { // 남쪽으로
    int loc = -1;
    for(int v=i; v<n; v++) {
      if(arr[v][j] == 'S') {
        loc = v-1;
        break;
      }
    }
    return loc;
  }
  private static int wMntrng(char[][] arr, int i, int j) { // 서쪽으로
    int loc = -1;
    for(int h=i; h>=0; h--) {
      if(arr[i][h] == 'S') {
        loc = h+1;
        break;
      }
    }
    return loc;
  }
  private static int eMntrng(char[][] arr, int n, int i, int j) { // 동쪽으로
    int loc = -1;
    for(int h=i; h<n; h++) {
      if(arr[i][h] == 'S') {
        loc = h-1;
        break;
      }
    }
    return loc;
  }
}
