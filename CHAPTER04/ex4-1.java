/* 4-1. 상하좌우 */

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = 5; // 공간의 크기
    int coordinate[] = {1, 1}; // 좌표

    System.out.println("L, R, U, D를 띄어 써서 입력");
    String direction = sc.nextLine(); // 띄어쓰기로 나눠서 방향입력
    String[] newStr = direction.split("\\s+"); // 공백을 기준으로 나눠서 문자를 배열에 담기

    for(int i = 0; i<newStr.length; i++) {
      if(newStr[i].equals("L")) {
        coordinate[1]--;
      } else if(newStr[i].equals("R")) {
        coordinate[1]++;
      } else if(newStr[i].equals("U")) {
        coordinate[0]--;
      } else if(newStr[i].equals("D")) {
        coordinate[0]++;
      }

      if (coordinate[0] > N) { // 크기가 N을 벗어나도 무시한다
        coordinate[0] = N;
      } else if(coordinate[1] > N) {
        coordinate[1] = N;
      } else if(coordinate[0] < 1) {  // 크기가 1미만이어도 무시한다
        coordinate[0] = 1;
      } else if(coordinate[1] < 1) {
        coordinate[1] = 1;
      }

      System.out.println("x축: " + coordinate[1]);
      System.out.println("y축: " + coordinate[0]);
    }

    System.out.println(coordinate[0] + " " + coordinate[1]);

    sc.close();
  }
}
