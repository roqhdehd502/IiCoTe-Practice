/**
11-1. 모험가 길드
: 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야한다.

입력예시
=====
5
2 3 1 2 2

출력예시
=====
2
*/

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // int sum = 0; // 공포도 합산
    // int n = sc.nextInt(); // 파티원의 수
    // int[] a = new int[n]; // 파티원의 공포도를 담기위한 배열

    // for(int i=0; i<a.length; i++) { 
    //   a[i] = sc.nextInt();
    //   sum += a[i];
    // }
    // sc.close();

    // int x = sum / a.length; // 파티원들의 평균 공포도 x를 구한다(소수점값 버림)

    // System.out.println(a.length / x); // 나머지 값 버림을 통해 그룹의 최대값을 구한다

    /*=================================================================*/

    int n = sc.nextInt();
    int[] a = new int[n];
    int cnt = 0; // 현재 그룹에 포함된 모험가의 수
    int result = 0; // 결과값

    for(int i=0; i<a.length; i++) { a[i] = sc.nextInt(); }
    sc.close();

    Arrays.sort(a); // 배열 오름차순 정렬

    for(int i=0; i<a.length; i++) { 
      cnt++; // 현재 그룹에 해당 모험가를 포함시키기
      if(cnt >= a[i]) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면 그룹 결성
        result++; // 총 그룹의 수 증가시키기
        cnt = 0; // 현재 그룹에 포함된 모함가의 수 초기화
      }
    }

    System.out.println(result); // 총 그룹의 수 출력
  }
}
