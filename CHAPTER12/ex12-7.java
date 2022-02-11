/**
12-07. 치킨 배달

=== 입력 예시 ===
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

=== 출력 예시 ===
5
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 크기 입력
    int m = sc.nextInt(); // 폐업시키지 않을 치킨집의 최대 개수

    ArrayList<Integer> r1 = new ArrayList<>(); // 행
    ArrayList<Integer> c1 = new ArrayList<>(); // 열
    ArrayList<Integer> r2 = new ArrayList<>();
    ArrayList<Integer> c2 = new ArrayList<>();

    int[][] arr = new int[n][n]; // 도시 
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.nextInt(); // 도시의 정보(0: 빈칸, 1: 집, 2: 치킨집)

        if(arr[i][j] == 1) { // 집
          r1.add(j+1);
          c1.add(i+1);
        } else if(arr[i][j] == 2) { // 치킨 집
          r2.add(j+1);
          c2.add(i+1);
        }
      }
    }
    sc.close();

    /* ToDo: 치킨집 폐업시키기 */
    for() { ... }

    /* ToDo: 각 행과 열의 값 간의 거리를 계산 후 최솟값 산출하기 */
    int temp1 = 0;
    int temp2 = 0;
    ArrayList<Integer> cd = new ArrayList<>(); // 치킨 거리 
    for(int i; i<c2.size(); i++) {
      for(int j; j<c1.size(); j++) {
        distance(r1.get(j), r2.get(i), c1.get(j), c2.get(i));
      }
      cd.add(Math.min(temp1, temp2)); // 해당 최솟값을 산출(치킨 거리)
    }

    int sum = 0;
    for(int i : cd) { sum += cd; } // 도시의 치킨 거리
    System.out.println(sum); // 결과값 출력
  }
  
  private static int distance(int r1, int r2, int c1, int c2) {
    return Math.abs(r1-r2) + Math.abs(c1-c2);
  }
}






/////////////////////////////////////////////////////////////////////////////






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

    public static int n, m;
    public static int[][] arr = new int[50][50];
    public static ArrayList<Position> chicken = new ArrayList<>();
    public static ArrayList<Position> house = new ArrayList<>();

    public static int getSum(ArrayList<Position> candidates) {
        int result = 0;
          // 모든 집에 대하여
          for (int i = 0; i < house.size(); i++) {
              int hx = house.get(i).getX();
              int hy = house.get(i).getY();
              // 가장 가까운 치킨 집을 찾기
              int temp = (int) 1e9;
              for (int j = 0; j < candidates.size(); j++) {
                  int cx = candidates.get(j).getX();
                  int cy = candidates.get(j).getY();
                  temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
              }
              // 가장 가까운 치킨 집까지의 거리를 더하기
              result += temp;
          }
          // 치킨 거리의 합 반환
          return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                arr[r][c] = sc.nextInt();
                if (arr[r][c] == 1) house.add(new Position(r, c)); // 일반 집
                else if (arr[r][c] == 2) chicken.add(new Position(r, c)); // 치킨집
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        Combination comb = new Combination(chicken.size(), m);
        comb.combination(chicken, 0, 0, 0);
        ArrayList<ArrayList<Position>> chickenList = comb.getResult();

        // 치킨 거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
    }
}
