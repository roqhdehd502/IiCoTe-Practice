/**
12-04. 자물쇠와 열쇠

=== 입력예시 ===
key : [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock : [[1, 1, 1], [1, 1, 0], [1, 0, 1]]

=== 출력예시 ===
result : true

※ key를 시계 방향으로 90도 회전하고, 오른쪽으로 한 칸, 아래로 한칸 이동하면 lock의 홈 부분을 정확히 모두 채울 수 있습니다.
*/

import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    int m = sc.nextInt(); // key의 한 변 크기 (m은 항상 n이하)
    int n = sc.nextInt(); // lock의 한 변 크기
    
    int[][] key = new int[m][m];
    int[][] lock = new int[n][n];

    for(int i=0; i<m; i++) { // 0은 홈이 들어간 부분, 1은 돌기가 튀어나온 부분
      for(int j=0; j<m; j++) {
        key[i][j] = rand.nextInt(1);
      }
    }
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        lock[i][j] = rand.nextInt(1);
      }
    }

    sc.close();
  }
}



//////



import java.util.*;

class Solution {

    // 2차원 리스트 90도 회전하기
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    // 자물쇠의 중간 부분이 모두 1인지 확인
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n * 3][n * 3];
        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        // 4가지 방향에 대해서 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // 열쇠 회전
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // 자물쇠에 열쇠를 끼워 넣기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }
                    // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
                    if (check(newLock)) return true;
                    // 자물쇠에서 열쇠를 다시 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
}
