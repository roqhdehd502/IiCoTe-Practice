/**
12-06. 기둥과 보 설치

=== 입력예시 ===


=== 출력예시 ===

*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 격자의 크기 지정
    int[][] build_frame = new int[n][4]; // 프레임 배열 지정
    int[][] result = new int[n][3]; // 리턴할 배열 지정
    
    for(int i=0; i<n; i++) {
      for(int j=0; j<4; j++) {
        build_frame[i][j] = sc.nextInt(); // x, y, a, b 값 입력
        /**
        x, y : 기둥과 보를 설치 또는 삭제할 교차점의 좌표로, [가로 좌표, 세로 좌표] 형태
        a : 설치 또는 삭제할 구조물의 종류로, 0은 기둥, 1은 보를 뜻함
        b : 구조물을 설치 혹은 삭체할 지의 여부로, 0은 삭제, 1은 설치를 뜻함
        */
      }
      System.out.println(build_frame[i]); // 각 줄마다 입력한 값 출력
    }
    sc.close();

    for(int i=0; i<n; i++) { // 로직 계산
      result[0] = build_frame[i][0]; // x값 주입
      result[1] = build_frame[i][1]; // y값 주입
      result[2] = build_frame[i][2]; // a값 주입
    }

    System.out.println(result); // 결과값 출력
  }
}
