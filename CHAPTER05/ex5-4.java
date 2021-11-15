/* 
5-4. 미로 탈출: 문제 설명
*/

import java.util.Scanner;

public class Main {
  // 크기 설정
  public static int n, m;
  public static int[][] maze = new int[100][100]; // 나중에 어떤 이유로 배열범위 초과가 되는지 원인분석을 해보자

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
      // 최대한 우측 하단으로 이동되게 로직을 짜보자
      if (maze[i+1][j] == 1) { 
        maze[i][j] = 2;
        i++;
        result++;
      } else if (maze[i][j+1] == 1) {
        maze[i][j] = 2;
        j++;
        result++;
      } else if (maze[i][j-1] == 1) {
        maze[i][j] = 2;
        j--;
        result++;
      } else if(maze[i-1][j] == 2) {
        i--;
      } else if(maze[i][j-1] == 2) {
        j--;
      }

      if((i==(n-1)) && (j==(m-1))) { break loopOut; }
    }
    
    System.out.println(result); // 정답 출력
    sc.close();  
  }
}
