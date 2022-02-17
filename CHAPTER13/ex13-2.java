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






///////////////////////////////////////////////////////////////////////






import java.util.*;

public class Main {

    public static int n, m, result = 0;
    public static int[][] arr = new int[8][8]; // 초기 맵 배열
    public static int[][] temp = new int[8][8]; // 벽을 설치한 뒤의 맵 배열
    
    // 4가지 이동 방향에 대한 배열
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // 깊이 우선 탐색(DFS)을 이용해 각 바이러스가 사방으로 퍼지도록 하기
    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // 현재 맵에서 안전 영역의 크기 계산하는 메서드
    public static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }

    // 깊이 우선 탐색(DFS)을 이용해 울타리를 설치하면서, 매 번 안전 영역의 크기 계산
    public static void dfs(int count) {
        // 울타리가 3개 설치된 경우
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            // 각 바이러스의 위치에서 전파 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            // 안전 영역의 최대값 계산
            result = Math.max(result, getScore());
            return;
        }
        // 빈 공간에 울타리를 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
    }
}
