/* 3-2 큰 수의 법칙 */

import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int N = 5; // 배열의 크기
    int M = 8; // 숫자가 더해지는 횟수
    int K = 3; // 연속으로 더해지는 상한값

    int arr[] = {2, 4, 5, 4, 6}; // 원래는 배열의 크기 N만큼 지정한 후 각 인덱스의 값들을 랜덤으로 지정해야 하는데 여기선 임의로 주어진 것으로 가정한다
    int temp = 0; // 누적되는 값
    int cnt = 0; // 상한값 카운팅
    int arCnt = 1; // 다음값 카운팅
    
    Arrays.sort(arr); // 오름차순으로 정렬

    for(int i=0; i<M; i++) { // 숫자가 더해지는 횟수만큼 루프 돌리기 
      if(cnt != K) { // 상한값 카운팅이 K가 아닐 때
        if(arr[arr.length-arCnt] < arr[arr.length-1]) { // 배열의 원소가 최대값이 아닐때
          temp += arr[arr.length-arCnt]; // 해당 원소값을 누적하고
          arCnt--; // 다음값 카운팅을 -1한다음
          cnt = 0; // 상한값 카운팅을 0으로 초기화 한다
        } else { // 배열의 원소가 최대값일 때
          temp += arr[arr.length-arCnt]; //해당 원소값을 누적하고
          cnt++; // 상한값을 카운팅한다
        }
      } else { // 상한값 카운팅이 K일때
        arCnt++; // 다음값 카운팅을 +1한다음
        temp += arr[arr.length-arCnt]; // 해당 원소값을 누적하고
        cnt = 0; // 상한값 카운팅을 0으로 초기화 한다
      } 
    }

    System.out.println(temp); // 누적값 출력
  }  
}
