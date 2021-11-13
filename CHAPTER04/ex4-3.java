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

class Main {
    public static void main(String[] args) {
      // 크기 지정
      int X = 8;
      int Y = 8; 

      // 나이트의 좌표 지정(    )
      int kn[] = {1, 1}; // y, x

      // 나이트의 변위
      int dx[] = {2, 1, -2, -1};
      int dy[] = {2, 1, -2, -1};

      // 경우의 수 카운팅
      int cnt = 0;
      
      // 나이트가 이동할 수 있는 경로대로 카운트하기
      switch(1) {
        case 1: // 1시방향
          if((kn[0]+dy[1] <= Y) && (kn[1]+dx[0] <= X)) { cnt++; }
          System.out.println(kn[0]+dy[1]);
          System.out.println(kn[1]+dx[0]);
          System.out.println(cnt);
          System.out.println();
        case 2: // 2시방향
          if((kn[0]+dy[0] <= Y) && (kn[1]+dx[1] <= X)) { cnt++; }
          System.out.println(kn[0]-dy[0]);
          System.out.println(kn[1]-dx[1]);
          System.out.println(cnt);
          System.out.println();
        case 4: // 4시방향
          if((kn[0]+dy[3] >= 1) && (kn[1]+dx[0] <= X)) { cnt++; }
          System.out.println(kn[0]-dy[3]);
          System.out.println(kn[1]-dx[0]);
          System.out.println(cnt);
          System.out.println();
        case 5: // 5시방향
          if((kn[0]+dy[2] >= 1) && (kn[1]+dx[1] <= X)) { cnt++; }
          System.out.println(kn[0]-dy[2]);
          System.out.println(kn[1]-dx[1]);
          System.out.println(cnt);
          System.out.println();
        case 7: // 7시방향
          if((kn[0]+dy[2] >= 1) && (kn[1]+dx[3] >= 1)) { cnt++; }
          System.out.println(kn[0]-dy[2]);
          System.out.println(kn[1]-dx[3]);
          System.out.println(cnt);
          System.out.println();
        case 8: // 8시방향
          if((kn[0]+dy[3] >= 1) && (kn[1]+dx[2] >= 1)) { cnt++; }
          System.out.println(kn[0]-dy[3]);
          System.out.println(kn[1]-dx[2]);
          System.out.println(cnt);
          System.out.println();
        case 10: // 10시방향
          if((kn[0]+dy[1] <= Y) && (kn[1]+dx[2] >= 1)) { cnt++; }
          System.out.println(kn[0]-dy[1]);
          System.out.println(kn[1]-dx[2]);
          System.out.println(cnt);
          System.out.println();
        case 11: // 11시방향
          if((kn[0]+dy[0] <= Y) && (kn[1]+dx[3] >= 1)) { cnt++; }
          System.out.println(kn[0]-dy[0]);
          System.out.println(kn[1]-dx[3]);
          System.out.println(cnt);
          System.out.println();
      }

      System.out.println(cnt);
    }
}
