/* 예제 3-1 거스름돈 */

class Main {  
  public static void main(String args[]) { 
    int coin[] = {500, 100, 50, 10}; // 동전

    int pay = 121687; // 돈
    int coinCnt = 0; // 동전갯수

    System.out.println("지출액(원): " + pay);
    System.out.println();

    for(int i=0; i<4; i++) {
        System.out.println(coin[i] + "원 갯수: " + pay / coin[i]);
        coinCnt += pay / coin[i];
        pay = pay - ((pay / coin[i]) * coin[i]);
        System.out.println("남은돈(원): " + pay);
        System.out.println();
    }

    System.out.println("동전갯수: " + coinCnt + "개");
  } 
}
