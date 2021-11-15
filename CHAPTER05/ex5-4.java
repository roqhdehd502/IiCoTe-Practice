/* 
5-4. 미로 탈출: 문제 설명

- 동빈이는 N × M 크기의 직사각형 형태의 미로에 갇혔다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다
- 동빈이의 위치는 (1, 1)이며 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있다. 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다. 미로는 반드시 탈출할 수 있는 형태로 제시된다
- 이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하라. 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다

입력 조건
========
첫째 줄에 두 정수 N, M(4<=N, M<=200)이 주어집니다. 다음 N개의 줄에는 각각 M개의 정수(0 혹은 1)로 미로의 정보가 주어집니다. 각각의 수들은 공백 없이 붙어서 입력으로 제시됩니다. 또한 시작칸과 마지막 칸은 항상 1입니다.

출력 조건
========
첫째 줄에 최소 이동 칸의 개수를 출력합니다.

입력예시
========
5 6
101010
111111
000001
111111
111111

출력 예시
========
10
*/

import java.util.*;

public class Main {
  // 크기 설정
  public static int n, m;
  public static int[][] maze = new int[(n*m)][(n*m)];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // N, M을 공백을 기준으로 구분하여 입력 받기
    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine(); // 버퍼 지우기

    // 2차원 리스트의 맵 정보 입력 받기
    for (int i = 0; i<n; i++) {
      String str = sc.nextLine();
      for (int j = 0; j < m; j++) {
        maze[i][j] = str.charAt(j) - '0';
      }
    }

    // 모든 노드(위치)에 대하여 미로 탐색하기
    int result = 1;
    int i = 0;
    int j = 0;

    loopOut:
    while(true) { 
      System.out.println("현재 위치: " + i + ", " + j);

      // 최대한 우측 하단으로 이동
      if (maze[i+1][j] == 1) { 
        maze[i][j] = 2;
        i++;
        result++;
        System.out.println("변위: " + i + ", " + j);
        System.out.println("result: " + result);
        System.out.println();
      } else if (maze[i][j+1] == 1) {
        maze[i][j] = 2;
        j++;
        result++;
        System.out.println("변위: " + i + ", " + j);
        System.out.println("result: " + result);
        System.out.println();
      } else if (maze[i][j-1] == 1) {
        maze[i][j] = 2;
        j++;
        result++;
        System.out.println("변위: " + i + ", " + j);
        System.out.println("result: " + result);
        System.out.println();  
      } else if(maze[i-1][j] == 2) {
        i--;
        System.out.println("변위: " + i + ", " + j);
        System.out.println("result: " + result);
        System.out.println();
      } else if(maze[i][j-1] == 2) {
        j--;
        System.out.println("변위: " + i + ", " + j);
        System.out.println("result: " + result);
        System.out.println();
      }

      if((i==(n-1)) && (j==(m-1))) { break loopOut; }
    }
    
    System.out.println("정답: " + result); // 정답 출력
    sc.close();  
  }
}
