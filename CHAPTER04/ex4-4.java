/* 
4-4. 게임 개발
*/

//import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      //Scanner sc = new Scanner(System.in);

      int map[][] = {{1, 1, 1, 1},
                     {1, 0, 0, 1},
                     {1, 1, 0, 1},
                     {1, 1, 1, 1}}; // 맵 시드

      int C[] = {1, 1}; // 캐릭터의 좌표(x, y)
      int cnt = 0; // 방문한 칸의 수

      boolean out = true;

      while(out) {
        System.out.println();
        if((map[C[1]][C[0]] != 1) && (C[1] >= 0)) { // 북
          map[C[1]][C[0]] = 2;
          C[1]--;
          cnt++;
          System.out.println("방문한 칸의 수: " + cnt);
        } else if((map[C[1]][C[0]] != 1) && (C[0] <= 3)) { // 동
          map[C[1]][C[0]] = 2;
          C[0]++;
          cnt++;
          System.out.println("방문한 칸의 수: " + cnt);
        } else if((map[C[1]][C[0]] != 1) && (C[1] <= 3)) { // 남
          map[C[1]][C[0]] = 2;
          C[1]++;
          cnt++;
          System.out.println("방문한 칸의 수: " + cnt);
        } else if((map[C[1]][C[0]] != 1) && (C[0] >= 0)) { // 서
          map[C[1]][C[0]] = 2;
          C[0]--;
          cnt++;
          System.out.println("방문한 칸의 수: " + cnt);
        }
        System.out.println();

        for(int i=0; i<4; i++) {
          for(int j=0; j<4; j++) {


            if(map[i][j] == 1) {
              System.out.println("[x]: " + j + " [y]: " + i +  " => " + map[i][j]);
            } else if(map[i][j] == 2) {
              System.out.println("[x]: " + j + " [y]: " + i +  " => " + map[i][j]);
            } else {
              System.out.println("[x]: " + j + " [y]: " + i +  " => " + map[i][j]);
              out = false;
            }
          }
          System.out.println("==================");
        }
      }

      //sc.close();
    }
}
