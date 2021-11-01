/* 예제 3-1 거스름돈 */

class Main {  
  public static void main(String args[]) { 
    int coin[] = {500, 100, 50, 10}; // 동전

    int pay = 121687; // 지출액
    int charge = 0; // 남은돈
    int coinCnt = 0; // 동전갯수

    System.out.println("지출액(원): " + pay);
    System.out.println();

    for(int i=0; i<4; i++) {
      if(coin[i] == 500) { // 첫 지출액을 감안해서 가장 큰 돈을 거스름돈으로 환산한다
        System.out.println(coin[i] + "원 갯수: " + pay / coin[i]);
        coinCnt += pay / coin[i];
        charge = pay - ((pay / coin[i]) * coin[i]);
        System.out.println("남은돈(원): " + charge);
        System.out.println();

      } else { // 나머지 돈들을 거스름돈으로 환산한다
        System.out.println(coin[i] + "원 갯수: " + charge / coin[i]);
        coinCnt += charge / coin[i];
        charge = charge - ((charge / coin[i]) * coin[i]);
        System.out.println("남은돈(원): " + charge);
        System.out.println();
      }
    }

    System.out.println("동전갯수: " + coinCnt + "개");
  } 
}
