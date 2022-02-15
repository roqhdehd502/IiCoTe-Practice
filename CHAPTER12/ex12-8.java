/**
12-08. 외벽 점검

=== 입력 예시 ===
n: 12
weak: [1, 5, 6, 10]
dist: [1, 2, 3, 4]

=== 출력 예시 ===
Result: 2
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 외벽의 길이
   
    int temp = 0;
    ArrayList<Integer> weak = new ArrayList<>(); // 취약 지점의 위치가 담긴 배열
    ArrayList<Integer> dist = new ArrayList<>(); // 각 친구가 1시간 동안 이동할 수 있는 거리가 담긴 배열
    while(true) {
      temp = sc.nextInt();
      if(temp <= 0) {
        break;
      } else {
        weak.add(temp);
      }
    }
    while(true) {
      temp = sc.nextInt();
      if(temp <= -1) {
        break;
      } else {
        dist.add(temp);
      }
    }
    sc.close();

    ArrayList<Integer> wall = new ArrayList<>(); // 벽
    for(int i=0; i<n; i++) {
      if(i == weak.indexOf(i)) { 
        wall.add(1); // 취약점이 있는 곳은 1
      } else {
        wall.add(0); // 취약점이 없는 곳은 0
      }
    }

    int lCnt, rCnt;
    lCnt = rCnt = 0;
    int tdCnt = weak.size();
    char direction = 'L';
    while(true) { // 탐색 알고리즘
      if(tdCnt == 0) { break; }

      for() { // 탐색해야할 벽을 2분할 하여 좌/우 중 어떤 쪽이 수리해야할 벽이 더 많은지 계산
        if(i < n/2) {
          rCnt++;
        } else {
          lCnt++;
        }
      }
      if(lCnt > rCnt) { // 수리해야할 포인트가 더 많은쪽을 선택하여 탐색방향을 정한다
        direction = 'L'; // 반시계방향
      } else if(lCnt < rCnt) {
        direction = 'R'; // 시계방향
      }
      

      // 반시계방향으로 탐색
      // ...lCnt;

      // 시계방향으로 탐색
      // ...rCnt;
    }
  }
}






//////////////////////////////////////////////////////////////






import java.util.*;

class Permutation {
    private int n;
    private int r;
    private int[] now; // 현재 순열
    private ArrayList<ArrayList<Integer>> result; // 모든 순열

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
        // 현재 순열의 길이가 r일 때 결과 저장
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        // 길이를 2배로 늘려서 '원형'을 일자 형태로 변경
        ArrayList<Integer> weakList = new ArrayList<Integer>();
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i]);
        }
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i] + n);
        }
        // 투입할 친구 수의 최솟값을 찾아야 하므로 len(dist) + 1로 초기화
        int answer = dist.length + 1;
        // 친구 정보를 이용해 모든 순열 계산
        Permutation perm = new Permutation(dist.length, dist.length);
        perm.permutation(dist, 0);
        ArrayList<ArrayList<Integer>> distList = perm.getResult();
        // 0부터 length - 1까지의 위치를 각각 시작점으로 설정
        for (int start = 0; start < weak.length; start++) {
            // 친구를 나열하는 모든 경우 각각에 대하여 확인
            for (int i = 0; i < distList.size(); i++) {
                int cnt = 1; // 투입할 친구의 수
                // 해당 친구가 점검할 수 있는 마지막 위치
                int position = weakList.get(start) + distList.get(i).get(cnt - 1);
                // 시작점부터 모든 취약한 지점을 확인
                for (int index = start; index < start + weak.length; index++) {
                    // 점검할 수 있는 위치를 벗어나는 경우
                    if (position < weakList.get(index)) {
                        cnt += 1; // 새로운 친구를 투입
                        if (cnt > dist.length) { // 더 투입이 불가능하다면 종료
                            break;
                        }
                        position = weakList.get(index) + distList.get(i).get(cnt - 1);
                    }
                }
                answer = Math.min(answer, cnt); // 최솟값 계산
            }
        }
        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }
}
