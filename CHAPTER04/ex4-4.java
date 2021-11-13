/* 
4-4. 게임 개발
*/

class Main {
    public static void main(String[] args) {
      // 크기 지정
      int X = 4;
      int Y = 4;

      // 플레이어의 변위(인덱스 별 - 0: 북, 1: 동, 2: 남, 3: 서)
      int dx[] = {0, 1, 0, -1};
      int dy[] = {-1, 0, 1, 0};

      // 맵 시드
      int map[][] = {{1, 1, 1, 1},
                     {1, 0, 0, 1},
                     {1, 1, 0, 1},
                     {1, 1, 1, 1}}; 

      // 캐릭터의 좌표 지정(y, x)
      int c[] = {2, 2};

      // 방문한 칸의 수
      int cnt = 0;

      outerOut:
      while(true) {
        System.out.println("현재 지형: " + map[c[1]][c[0]]);
        System.out.println("현재 좌표(y, x): " + c[1] + ", " + c[0]);
        innerOut:
        switch(1) {
          case 1:
              if(c[0] >= 0) { // 북
                if(map[c[1]+dy[0]][c[0]+dx[0]] == 0) {
                  map[c[1]][c[0]] = 2;
                  c[0] += dy[0];
                  c[1] += dx[0];
                  cnt++;
                  System.out.println("이동한 지형: " + map[c[1]][c[0]]);
                  System.out.println("이동한 좌표(y, x): " + c[1] + ", " + c[0]);
                  System.out.println("방문한 칸의 수: " + cnt);
                  System.out.println();
                  break innerOut;
                }
              } else if(c[1] <= (X-1)) { // 동
                if(map[c[1]+dy[1]][c[0]+dx[1]] == 0) {
                  map[c[1]][c[0]] = 2;
                  c[0] += dy[1];
                  c[1] += dx[1];
                  cnt++;
                  System.out.println("이동한 지형: " + map[c[1]][c[0]]);
                  System.out.println("이동한 좌표(y, x): " + c[1] + ", " + c[0]);
                  System.out.println("방문한 칸의 수: " + cnt);
                  System.out.println();
                  break innerOut;
                }
              } else if(c[0] <= (Y-1)) { // 남
                if(map[c[1]+dy[2]][c[0]+dx[2]] == 0) {
                  map[c[1]][c[0]] = 2;
                  c[0] += dy[2];
                  c[1] += dx[2];
                  cnt++;
                  System.out.println("이동한 지형: " + map[c[1]][c[0]]);
                  System.out.println("이동한 좌표(y, x): " + c[1] + ", " + c[0]);
                  System.out.println("방문한 칸의 수: " + cnt);
                  System.out.println();
                  break innerOut;
                }               
              } else if(c[1] >= 0) { // 서
                if(map[c[1]+dy[3]][c[0]+dx[3]] == 0) {
                  map[c[1]][c[0]] = 2;
                  c[0] += dy[3];
                  c[1] += dx[3];
                  cnt++;
                  System.out.println("이동한 지형: " + map[c[1]][c[0]]);
                  System.out.println("이동한 좌표(y, x): " + c[1] + ", " + c[0]);
                  System.out.println("방문한 칸의 수: " + cnt);
                  System.out.println();
                  break innerOut;
                }
              }
            
          default:
            break outerOut; // 갈 곳 없으면 루프 탈출
        }    
      }

      System.out.println("최종적으로 이동한 칸의 수: " + cnt);
    }
}
