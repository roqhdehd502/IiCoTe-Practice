/* 예제 3-1 거스름돈 */

class Main {  
  public static void main(String args[]) { 
    int coin[] = {500, 100, 50, 10}; // 동전

    int pay = 5680; // 돈
    int coinCnt = 0; // 동전갯수

    System.out.println("지출액(원): " + pay);
    System.out.println();

    long start = System.nanoTime();

    for(int i=0; i<coin.length; i++) {
        System.out.println(coin[i] + "원 갯수: " + pay / coin[i]);
        coinCnt += pay / coin[i];
        pay = pay - ((pay / coin[i]) * coin[i]);
        System.out.println("남은돈(원): " + pay);
        System.out.println();
    }

    long end = System.nanoTime();

    System.out.println("동전갯수: " + coinCnt + "개");
    System.out.println("수행시간: " + (end - start) + " ns");
  }
}
