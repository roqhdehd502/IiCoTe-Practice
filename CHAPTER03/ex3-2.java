/* 3-2. 큰 수의 법칙 */

import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int N = 6; // 배열의 크기
    int M = 100; // 숫자가 더해지는 횟수
    int K = 9; // 연속으로 더해지는 상한값

    int arr[] = {2, 4, 5, 4, 6, 7}; // 배열의 크기 N만큼 지정한 후 각 인덱스의 값들을 랜덤으로 지정해야 하는데 여기선 임의로 주어진 것으로 가정한다
    int temp = 0; // 누적되는 값
    int cnt = 0; // 상한값 카운팅
    
    Arrays.sort(arr); // 오름차순으로 정렬

    for(int i=0; i<M; i++) {
      if(cnt != K) { // 상한값 카운팅이 K가 아닐때
        temp += arr[arr.length-1]; // 배열의 최대값을 누적한다
        cnt++; // 상한값 카운트
        System.out.println(i + " temp: " + temp);
      } else { // 상한값 카운팅이 K가 아닐때
        temp += arr[arr.length-2]; // 배열의 2번째 최대값을 누적한다
        cnt = 0; // 상한값 카운트 0으로 초기화
        System.out.println(i + " temp: " + temp);
      }   
    }

    System.out.println(temp); // 누적값 출력
    
    
    
    
    
    
    
    /* 이에 대한 과정을 더 최적화 시켜서 코드화를 하면... */
    //M = (K + 1) * (M / (K + 1)); // M이 나오기 위한 공식
    int cSec = M / (K + 1); // 두 번째로 큰 배열의 최대값의 개수
    int cFst = M - cSec; // 배열의 최대값의 개수

    int result = (cFst * arr[N-1]) + (cSec * arr[N-2]); // 결과값

    System.out.println(result);
  }  
}
