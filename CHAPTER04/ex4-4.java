/* 
4-4. 게임 개발
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 게임의 맵을 담당
    static int[][] map; 
    // 각 칸의 방문 여부 확인
    static boolean[][] visit;
    // 캐릭터가 바라보는 방향 
    static int playerDir;
    // 캐릭터의 좌표값
    static int playerRowPos;
    static int playerColPos;

    // 북, 동, 남, 서를 바라볼때 움직이는 경로
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("크기 입력");
      StringTokenizer st = new StringTokenizer(br.readLine());

      int mapRow = Integer.parseInt(st.nextToken());
      int mapCol = Integer.parseInt(st.nextToken());

      map = new int[mapRow][mapCol];
      visit = new boolean[mapRow][mapCol];

      System.out.println("초기 좌표 및 방향 입력");
      st = new StringTokenizer(br.readLine());
      playerRowPos = Integer.parseInt(st.nextToken());
      playerColPos = Integer.parseInt(st.nextToken());
      playerDir = Integer.parseInt(st.nextToken());

      visit[playerRowPos][playerColPos] = true;

      System.out.println("맵 시드 입력");
      for (int i = 0; i < mapRow; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0; j < mapCol; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
          }
      }

      // 네 번 회전 하였는지 카운트하여 점검
      int count = 0;
      // 몇 칸 방문했는지 세기
      int visitCount = 1;

      while (true) {
        turnPlayer();

        if ((map[playerRowPos + dRow[playerDir]][playerColPos + dCol[playerDir]] == 0) &&
                (visit[playerRowPos + dRow[playerDir]][playerColPos + dCol[playerDir]] == false)) {
          visit[playerRowPos + dRow[playerDir]][playerColPos + dCol[playerDir]] = true;
          visitCount++;

          playerRowPos += dRow[playerDir];
          playerColPos += dCol[playerDir];

          count = 0;
        } else {
          count++;
        }

        if (count == 4) {
          if (map[playerRowPos - dRow[playerDir]][playerColPos - dCol[playerDir]] == 1) {
            break;
          } else {
            count = 0;
            playerRowPos -= dRow[playerDir];
            playerColPos -= dCol[playerDir];
          }
        }
      }

    System.out.println("방문 횟수: " + visitCount);
  }
  
  // 방향전환 함수
  static void turnPlayer() {
    playerDir -= 1;

    if (playerDir < 0) {
      playerDir = 3;
    }
  }
}
