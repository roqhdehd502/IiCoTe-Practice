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

    int cnt = 0; // ( 및 )가 들어오는 순서를 알기위한 판단 여부
    char[] chr = new char[p.length()]; // 문자를 담기위한 배열

    int temp = 0; // 중복 방지용 임시 값
    for(int i=0; i<chr.length; i++) { // 올바른 괄호 문자열 만들기
      if(p.charAt(i) == '(') {
        cnt++; // 좌괄호가 들어올때 cnt가 증가된다
      } else if(p.charAt(i) == ')') {
        cnt--; // 우괄호가 들어올때 cnt가 감소된다
      }
      if(cnt < 0) { // 우괄호가 편향적으로 들어올 경우
        for(int j=i; j<p.length(); j++) { // 좌괄호가 있는 문자열 인덱스를 탐색한다
          if(p.charAt(j) == '(') { // 해당 인덱스에 좌괄호가 있을경우
            if(j != temp) {
              System.out.println();
              System.out.println("bf=> chr[j]: " + chr[j] + " temp: " + temp + " j: " + j);
              chr[j] = ')'; // 지정된 인덱스는 우괄호로 변경한다
              temp = j; // 중복 방지용 임시 값 저장
              System.out.println("af=> chr[j]: " + chr[j] + " temp: " + temp + " j: " + j);
              System.out.println();
              break;
            } 
          }
        }

        if(i != temp) {
          chr[i] = '('; // 문제의 인덱스는 좌괄호로 변경한다(스왑)
          cnt = 0; // 카운터 초기화
        }
      } else { // 문제가 없으면 그대로 배열안에 값을 넣는다
        if(i == 0 || i != temp) { // 이미 스왑된 값 새로 넣는것 방지하기
          chr[i] = p.charAt(i);
        }
      }
    }

    for(int i=0; i<chr.length; i++) { System.out.print(chr[i]); } // 결과값 출력
  }
}
