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

    int n = sc.nextInt(); // 거리의 규모 입력(2 <= n <= 50)
    int m = sc.nextInt(); // 최소한 개업 시켜놓을 치킨집의 개수(1 <= m <= 13)

    int hCnt, cCnt; // 집과 치킨집의 개수
    hCnt = cCnt = 0;
    int[][] arr = new int[n][n]; // 거리의 집과 치킨집을 입력할 2차원 배열
    ArrayList<Integer> r1, c1, r2, c2; // 집과 치킨집의 위치(r행과 c열)
    r1 = c1 = r2 = c2 = new ArrayList<>();
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j] = sc.nextInt(); // 집(1 <= x <= 2n), 치킨집(m <= y <= 13)
        if(arr[i][j] == 2) { // 치킨집(2) 일때 
          cCnt++;
          r2.add(i+1);
          c2.add(j+1); 
        } else if(arr[i][j] == 1) { // 집(1) 일때
          hCnt++;
          r1.add(i+1);
          c1.add(j+1); 
        }
      }
    }
    sc.close();

    int xSum, ySum, cX, cY, temp;
    xSum = ySum = cX = cY = temp = 0;
    ArrayList<Integer> cd = new ArrayList<>(); // 치킨 거리
    
    if(cCnt > m) { // 치킨집의 수가 m개 보다 많을 때 폐업시키기
      for(int i=0; i<r1.size(); i++) { // 각 가정집들의 중심 좌표
        xSum += r1.get(i);
        ySum += c1.get(i);
      }
      cX = xSum / hCnt ; // 중심 좌표 x값
      cY = ySum / hCnt ; // 중심 좌표 y값

      while(true) { // 치킨집이 m개가 될 때까지 순위를 매겨 미달된 곳은 폐업시키기
        int[] rank = new int[r2.size()];
        double[] score = new double[r2.size()];

        for(int i=0; i<r2.size(); i++) { score[i] = edistance(cX, cY, r2.get(i), c2.get(i)); }

        for(int i=0; i<score.length; i++){ // 각 거리별로 순위를 매긴다(최소 거리일수록 1위)
          rank[i] = 1;
          for (int j=0; j<score.length; j++) { if(score[i] > score[j]){ rank[i]++; } }          
        }

        for(int i=0; i<score.length; i++) {
          if(rank[i] < m) { // 해당 랭크가 m위 미만이면 해당 인덱스의 치킨집을 삭제한다
            r2.remove(i);
            c2.remove(i);
            break;
          }
        }

        if(r2.size() ==  m) { break; }
      }
      for(int i=0; i<r1.size(); i++) {
        for(int j=0; j<r2.size(); j++) {
          temp = Math.min(temp, cdistance(r1.get(i), c1.get(i), r2.get(j), c2.get(j)));
        }
        cd.add(temp);
      }
    } else { // 치킨집의 수가 m개일때 그대로 치킨 거리 계산(어처피 최소거리만 구해도 되므로...)
      for(int i=0; i<r1.size(); i++) {
        for(int j=0; j<r2.size(); j++) {
          temp = Math.min(temp, cdistance(r1.get(i), c1.get(i), r2.get(j), c2.get(j)));
        }
        cd.add(temp);
      }
    }

    int ccd = 0; // 도시의 치킨 거리의 최솟값
    for(int i=0; i<cd.size(); i++) { ccd += cd.get(i); }
    System.out.println(ccd); // 결과값 출력
  }


  private static double edistance(int x1, int y1, int x2, int y2) { // 유클리드 거리
    return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));  
  }


  private static int cdistance(int r1, int c1, int r2, int c2) { // 치킨 거리
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
