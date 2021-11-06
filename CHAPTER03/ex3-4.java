/* 3-4 1이 될 때까지 */

class Main {
  public static void main(String[] args) {
    int N = 25; // 나눔을 당하는 수
    int K = 5; // 나누고자 하는 수
    int cnt = 0; // 과정의 횟수

    long start = System.nanoTime();

    while(N != 1) { // N이 1이 될때까지 루프
      if(N % K == 0) { // N / K의 나머지가 0일때
        N /= K; // N / K를 수행한다
        cnt++;    
      } else { // N / K의 나머지가 0이 아닐때
        N--; // N을 1씩 차감한다
        cnt++;
      }
    }

    long end = System.nanoTime();

    System.out.println(cnt); // 1이 될떄까지 계산한 횟수를 출력한다
    System.out.println((end-start) + "ns");
  }  
}
