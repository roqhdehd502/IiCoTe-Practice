/* 
4-3. 왕실의 나이트: 문제 설명
행복 왕국의 왕실 정원은 체스판과 같은 8 × 8 좌표 평면이다. 왕실 정원의 특정한 한 칸에 나이트가 서있다.
나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
나이트는 특정 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.
- 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
- 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
이처럼 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하라.
ex-1) c2에 있을 때 이동할 수 있는 경우의 수는 6가지이다.
ex-2) a1에 있을 때 이동할 수 있는 경우의 수는 2가지이다.
*/

/*
나이트가 체스판을 벗어나지 않는 경우의 수
: 2칸, 4칸, 6칸, 8칸
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // 체스판의 좌표
      //String chess[][] = {{"a1","b1","c1","d1","e1","f1","g1","h1"},
      //                   {"a2","b2","c2","d2","e2","f2","g2","h2"},
      //                   {"a3","b3","c3","d3","e3","f3","g3","h3"},
      //                   {"a4","b4","c4","d4","e4","f4","g4","h4"},
      //                   {"a5","b5","c5","d5","e5","f5","g5","h5"},
      //                   {"a6","b6","c6","d6","e6","f6","g6","h6"},
      //                   {"a7","b7","c7","d7","e7","f7","g7","h7"},
      //                   {"a8","b8","c8","d8","e8","f8","g8","h8"}};
      
      // 나이트의 좌표 지정
      System.out.print("나이트의 좌표 입력(ex. a1): ");
      String knight = sc.nextLine();

      if(knight.contains("a1") || knight.contains("a8") || knight.contains("h8") || knight.contains("h1")) {
        System.out.println("2");

      } else if(knight.contains("c1") || knight.contains("d1") || knight.contains("e1") || knight.contains("e1")
        || knight.contains("a3") || knight.contains("a4") || knight.contains("a5") || knight.contains("a6")
        || knight.contains("c8") || knight.contains("d8") || knight.contains("e8") || knight.contains("f8")
        || knight.contains("f3") || knight.contains("f4") || knight.contains("f5") || knight.contains("f6")) {
        System.out.println("4");

      } else if(knight.contains("c2") || knight.contains("c3") || knight.contains("c4") || knight.contains("c5") || knight.contains("c6") || knight.contains("c7")
        || knight.contains("b6") || knight.contains("c6") || knight.contains("d6") || knight.contains("e6") || knight.contains("f6") || knight.contains("g6")
        || knight.contains("f2") || knight.contains("f3") || knight.contains("f4") || knight.contains("f5") || knight.contains("f6") || knight.contains("f7")
        || knight.contains("b3") || knight.contains("c3") || knight.contains("d3") || knight.contains("e3") || knight.contains("f3") || knight.contains("g3")) {
        System.out.println("6");

      } else {
        System.out.println("8");
      }

      sc.close();
    }
}
