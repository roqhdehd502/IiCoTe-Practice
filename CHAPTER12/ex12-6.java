/**
12-06. 기둥과 보 설치
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
      /*
      TO-DO :
      조건문을 통해 보/기둥을 설치 및 삭제가 비정상적이면 build_frame의 요소를 삭제해야 한다...

      01. 기둥의 경우 땅위에서만 단독적으로 지을 수 있다.
      02. 보의 경우 바닥에 지을 수 없다.
      03. 기둥 - 보, 보 - 보간 서로 연결해서 지을 수 있다.
      */

      result[i][0] = build_frame[i][0]; // x값 주입
      result[i][1] = build_frame[i][1]; // y값 주입
      result[i][2] = build_frame[i][2]; // a값 주입
    }

    System.out.println(result); // 결과값 출력
  }
}






////////////////////////////////////////////////////






import java.util.*;

class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int stuff;

    public Node(int x, int y, int stuff) {
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getStuff() {
        return this.stuff;
    }
    
    // 정렬 기준 설정 (x, y, stuff 순서대로 오름차순)
    @Override
    public int compareTo(Node other) {
        if (this.x == other.x && this.y == other.y) {
            return Integer.compare(this.stuff, other.stuff);
        }
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

class Solution {
    
    // 현재 설치된 구조물이 '가능한' 구조물인지 확인하는 함수
    public boolean possible(ArrayList<ArrayList<Integer>> answer) {
        for (int i = 0; i < answer.size(); i++) {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);
            if (stuff == 0) { // 설치된 것이 '기둥'인 경우
                boolean check = false;
                // '바닥 위'라면 정상
                if (y == 0) check = true;
                // '보의 한 쪽 끝 부분 위' 혹은 '다른 기둥 위'라면 정상
                for (int j = 0; j < answer.size(); j++) {
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                }
                if (!check) return false; // 아니라면 거짓(False) 반환
            }
            else if (stuff == 1) { // 설치된 것이 '보'인 경우
                boolean check = false;
                boolean left = false;
                boolean right = false;
                // '한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        left = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        right = true;
                    }
                }
                if (left && right) check = true;
                if (!check) return false; // 아니라면 거짓(False) 반환
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        // 작업(frame)의 개수는 최대 1,000개
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operate = build_frame[i][3];
            if (operate == 0) { // 삭제하는 경우
                // 일단 삭제를 해 본 뒤에
                int index = 0;
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2)) {
                        index = j;
                    }
                }
                ArrayList<Integer> erased = answer.get(index);
                answer.remove(index);
                if (!possible(answer)) { // 가능한 구조물인지 확인
                    answer.add(erased); // 가능한 구조물이 아니라면 다시 설치
                }
            }
            if (operate == 1) { // 설치하는 경우
                // 일단 설치를 해 본 뒤에
                ArrayList<Integer> inserted = new ArrayList<Integer>();
                inserted.add(x);
                inserted.add(y);
                inserted.add(stuff);
                answer.add(inserted);
                if (!possible(answer)) { // 가능한 구조물인지 확인
                    answer.remove(answer.size() - 1); // 가능한 구조물이 아니라면 다시 제거
                }
            }
        }

        // 정렬 수행
        ArrayList<Node> ans = new ArrayList<Node>();
        for (int i = 0; i < answer.size(); i++) {
            ans.add(new Node(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
        }
        Collections.sort(ans);
        
        // 배열로 바꾸어 반환
        int[][] res = new int[ans.size()][3];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).getX();
            res[i][1] = ans.get(i).getY();
            res[i][2] = ans.get(i).getStuff();
        }
        return res;
    }
}
