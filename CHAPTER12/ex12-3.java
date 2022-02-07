/**
12-3. 문자열 압축
=== 입력 예시.1 ===
aabbaccc
=== 출력 예시.1 ===
2a2ba3c => 7
=== 입력 예시.2 ===
ababcdcdababcdcd
=== 출력 예시.2 ===
2ab2cd2ab2cd => 9
=== 입력 예시.3 ===
abcabcdede
=== 출력 예시.3 ===
2abcdede => 8 (같은 문자열의 갯수로 자른다)
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int cnt = 0;
    String temp = "";
    String s = sc.nextLine();
    sc.close();

    for(int i=0; i<s.length(); i++) {
      if(i == s.length()-1) { // 마지막 인덱스
        if(String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(i-1)))) {
          cnt++;
          temp += Integer.toString(cnt);
          temp += String.valueOf(s.charAt(i));
        } else {
          temp += Integer.toString(cnt);
          temp += String.valueOf(s.charAt(i));
        }

      } else {
        if(String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(i+1)))) {
          cnt++;
        } else {
          cnt++;
          temp += (cnt == 1) ? "" : Integer.toString(cnt); 
          temp += String.valueOf(s.charAt(i));
          cnt = 0;
        }
      }

      System.out.println(temp);
    }
    System.out.println(temp.length());
  }
}










////////////////////////////////////////////////










import java.util.*;

class Solution {

    public int solution(String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step); // 앞에서부터 step만큼의 문자열 추출
            int cnt = 1;
            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j += step) {
                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1;
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else {
                    compressed += (cnt >= 2)? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }
            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2)? cnt + prev : prev;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    } 
}
