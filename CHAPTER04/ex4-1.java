/* 4-1. 상하좌우 */

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = 7; // 공간의 크기
    int coordinate[] = {1, 1}; // 좌표

    System.out.println("L, R, U, D를 띄어 써서 입력");
    String direction = sc.nextLine(); // 띄어쓰기로 나눠서 방향입력
    String[] newStr = direction.split("\\s+"); // 공백을 기준으로 나눠서 문자를 배열에 담기

    for(int i = 0; i<newStr.length; i++) {
      if(newStr[i].equals("L") && coordinate[1] > 1) {
        coordinate[1]--;
      } else if(newStr[i].equals("R") && coordinate[1] < N) {
        coordinate[1]++;
      } else if(newStr[i].equals("U") && coordinate[0] > 1) {
        coordinate[0]--;
      } else if(newStr[i].equals("D") && coordinate[0] < N) {
        coordinate[0]++;
      } else {
        continue;
      }
    }

    System.out.println(coordinate[0] + " " + coordinate[1]);
    sc.close();
  }
}
