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
    /* === 입력값 설정 === */
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 크기 설정
    char[][] arr = new char[n][n]; // 복도 설정
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.next().charAt(j); // S: 학생, T: 선생님, X: 아무것도 존재하지 않음
      }
      sc.nextLine();
    }
    sc.close();
    /* ================== */

    /* === 발각 시점 및 발각 직전 좌표 설정 === */
    int[][] find  = new int[n][n]; // 발각 직전 좌표
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
    /* ==================================== */

    /* === 발각 직전 좌표 값을 통한 장애물 세우기 === */
    ArrayList<ArrayList<Integer>> obst = new ArrayList<ArrayList<Integer>>(); // 장애물을 세우기 위한 배열
    ArrayList<Integer> nobst = new ArrayList<Integer>();
    ArrayList<Integer> sobst = new ArrayList<Integer>();
    ArrayList<Integer> wobst = new ArrayList<Integer>();
    ArrayList<Integer> eobst = new ArrayList<Integer>();
    int obsCnt = 3;
    boolean isPossible = false;

    /* ToDo: 장애물을 3개 세울때 학생이 발각되지 않는 여부를 리턴한다 */
    /* ========================================= */
    
    /* === 결과값 출력 === */
    if(isPossible == true) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    /* ================== */
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






/////////////////////////////////////////////////////////////////////////////////////////






import java.util.*;

class Combination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Position>> result; // 모든 조합

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {

    public static int n; // 복도의 크기
    public static char[][] board = new char[6][6]; // 복도 정보 (N x N)
    public static ArrayList<Position> teachers = new ArrayList<>(); // 모든 선생님 위치 정보
    public static ArrayList<Position> spaces = new ArrayList<>(); // 모든 빈 공간 위치 정보

    // 특정 방향으로 감시를 진행 (학생 발견: true, 학생 미발견: false)
    public static boolean watch(int x, int y, int direction) {
        // 왼쪽 방향으로 감시
        if (direction == 0) {
            while (y >= 0) {
                if (board[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (board[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                y -= 1;
            }
        }
        // 오른쪽 방향으로 감시
        if (direction == 1) {
            while (y < n) {
                if (board[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (board[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                y += 1;
            }
        }
        // 위쪽 방향으로 감시
        if (direction == 2) {
            while (x >= 0) {
                if (board[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (board[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                x -= 1;
            }
        }
        // 아래쪽 방향으로 감시
        if (direction == 3) {
            while (x < n) {
                if (board[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (board[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                x += 1;
            }
        }
        return false;
    }

    // 장애물 설치 이후에, 한 명이라도 학생이 감지되는지 검사
    public static boolean process() {
        // 모든 선생의 위치를 하나씩 확인
        for (int i = 0; i < teachers.size(); i++) {
            int x = teachers.get(i).getX();
            int y = teachers.get(i).getY();
            // 4가지 방향으로 학생을 감지할 수 있는지 확인
            for (int j = 0; j < 4; j++) {
                if (watch(x, y, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
                // 선생님이 존재하는 위치 저장
                if (board[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }
                // 장애물을 설치할 수 있는 (빈 공간) 위치 저장
                if (board[i][j] == 'X') {
                    spaces.add(new Position(i, j));
                }
            }
        }

        // 빈 공간에서 3개를 뽑는 모든 조합을 확인
        Combination comb = new Combination(spaces.size(), 3);
        comb.combination(spaces, 0, 0, 0);
        ArrayList<ArrayList<Position>> spaceList = comb.getResult();

        // 학생이 한 명도 감지되지 않도록 설치할 수 있는지의 여부
        boolean found = false; 
        for (int i = 0; i < spaceList.size(); i++) {
            // 장애물들을 설치해보기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                board[x][y] = 'O';
            }
            // 학생이 한 명도 감지되지 않는 경우
            if (!process()) {
                // 원하는 경우를 발견한 것임
                found = true;
                break;
            }
            // 설치된 장애물을 다시 없애기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                board[x][y] = 'X';
            }
        }

        if (found) System.out.println("YES");
        else System.out.println("NO");
    }
}
