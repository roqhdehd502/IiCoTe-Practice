/**
13-04. 괄호 변환
=== 입력 예시 ===
()))((()
=== 출력 예시 ===
()(())()
*/

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String p = sc.nextLine(); // 입력할 문자열
    sc.close();
    
    char[] chr = new char[p.length()]; // 문자를 담기위한 배열
    for(int i=0; i<chr.length; i++) { chr[i] = p.charAt(i); }

    int temp = 0; // 중복 방지용 임시 값
    int cnt = 0; // ( 및 )가 들어오는 순서를 알기위한 판단 여부
    for(int i=0; i<chr.length; i++) { // 올바른 괄호 문자열 만들기
      if(chr[i] == '(') {
        cnt++; // 좌괄호가 들어올때 cnt가 증가된다
      } else if(chr[i] == ')') {
        cnt--; // 우괄호가 들어올때 cnt가 감소된다
      }
      if(cnt < 0) { // 우괄호가 편향적으로 들어올 경우
        for(int j=i; j<chr.length; j++) { // 좌괄호가 있는 문자열 인덱스를 탐색한다
          if(chr[j] == '(') { // 해당 인덱스에 좌괄호가 있을경우
            if(temp == 0 || j != temp) {
              chr[j] = ')'; // 지정된 인덱스는 우괄호로 변경한다
              chr[i] = '('; // 문제의 인덱스는 좌괄호로 변경한다(스왑)
              temp = j; // 중복 방지용 임시 값 저장

              /* 해당 cnt값을 처리할 방법을 강구하자... */
              cnt += 2;

              System.out.println();
              break;
            } 
          }
        }
      }
    }

    for(int i=0; i<chr.length; i++) { System.out.print(chr[i]); } // 결과값 출력
  }
}







/////////////////////////////////////////////////////////////////////////////////






import java.util.*;

class Solution {
    
    // "균형잡힌 괄호 문자열"의 인덱스 반환
    public int balancedIndex(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else count -= 1;
            if (count == 0) return i;
        }
        return -1;
    }

    // "올바른 괄호 문자열"인지 판단
    public boolean checkProper(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else {
                if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count -= 1;
            }
        }
        return true; // 쌍이 맞는 경우에 true 반환
    }
    
    public String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u)) {
            answer = u + solution(v);
        }
        // "올바른 괄호 문자열"이 아니라면 아래의 과정을 수행
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}
