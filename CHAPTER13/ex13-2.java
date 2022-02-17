/**
13-02. 연구소

=== 입력예시 ===
4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

=== 출력예시 ===
9

바이러스 노드는 빈칸 노드와 인접할 경우 바이러스 노드로 변경할 수 있다.
바이러스 노드는 벽 노드와 인접할 경우 더이상 바이러스 노드로 변경할 수 없다.
빈칸 노드에서 벽 노드로 바꾸기 위한 최소 및 최대 횟수는 3이다.
안전영역의 최대값을 얻기 위해선 바이러스와 인접노드가 빈칸 노드일경우 적어도 해당 공간에 벽노드로 변경해야 한다.
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 세로 크기
    int m = sc.nextInt(); // 가로 크기
    
    int[][] arr = new int[n][m];
    ArrayList<Integer> vRow = new ArrayList<>(); // 바이러스 행
    ArrayList<Integer> vCol = new ArrayList<>(); // 바이러스 열
    ArrayList<Integer> wRow = new ArrayList<>(); // 벽 행
    ArrayList<Integer> wCol = new ArrayList<>(); // 벽 열
    ArrayList<Integer> eRow = new ArrayList<>(); // 빈칸 행
    ArrayList<Integer> eCol = new ArrayList<>(); // 빈칸 열
    for(int i=0; i<n; i++) {
      for(int j=0; j<m; j++) {
        arr[n][m] = sc.nextInt(); // 0: 빈칸, 1: 벽, 2: 바이러스
        if(arr[i][j] == 2) {
          vRow.add(i);
          vCol.add(j);
        } else if(arr[i][j] == 1) {
          wRow.add(i);
          wCol.add(j);
        } else {
          eRow.add(i);
          eCol.add(j);
        }
      }
    }
    sc.close();

    int rRes = 3; // 세울 수 있는 벽의 개수
    for(int i=0; i<n; i++) { // 격리시키기 위한 벽 설치
      for(int j=0; j<m; j++) {
        if(arr[i][j] == 2) { // 해당 노드가 바이러스(2) 일때
          if(rRes >= 2) { // 세울 수 있는 벽의 개수가 2개 이상일 때 남은 리소스 관계없이 사용
            if(arr[i-1][j] == 0) { // 상하좌우 인접노드 중 빈칸(0) 노드가 있을 경우
              arr[i-1][j] = 1;
            } else if(arr[i+1][j] == 0) {
              arr[i-1][j] = 1;
            } else if(arr[i][j-1] == 0) {
              arr[i-1][j] = 1;
            } else if(arr[i][j+1] == 0) {
              arr[i-1][j] = 1;
            }
          } else if(rRes == 1) { // 세울 수 있는 벽의 개수가 1개 일 때 남은 리소스를 고려하여 사용
            for(int a=0; a<n; a++) {
              for(int b=0; b<m; b++) {
                if(arr[a][b] == 0) {
                  d
                }
              }
            }
          }
        }
      }
    }

    for(int i=0; i<n; i++) { // 바이러스의 확산
      for(int j=0; j<m; j++) { // 우로 스캔
        if(arr[i][j] == 2) {
          
        }
      }
      for(int j=m; j>=0; j--) { // 좌로 스캔
        if(arr[i][j] == 2) {
          
        }
      }
    }

    int cnt = 0;
    for(int i=0; i<n; i++) { // 안전지대 개수 탐색
      for(int j=0; j<m; j++) {
        if(arr[i][j] == 0) {
          cnt++;
        }
      }
    }

    System.out.println(cnt); // 결과값 출력
  }
}
