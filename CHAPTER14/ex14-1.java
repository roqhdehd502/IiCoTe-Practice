/**
14-01. 국영수

=== 입력 예시 ===
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
... 후략

=== 출력 예시 ===
Donghyuk
Sangkeun
Sunyoung
... 후략
*/

import java.util.*;

public class Dohyun implements Comparable<Dohyun> {
  private String name;
  private int kor;
  private int eng;
  private int mat;

  public Dohyun(String name, int kor, int eng, int mat) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.mat = mat;
  }

  public String getName() {
    return name;
  }

  public String getKor() {
    return kor;
  }

  public String getEng() {
    return eng;
  }

  public String getMat() {
    return mat;
  }

  /*
    1. 국어 점수 DESC
    2. 국어 점수가 서로 같으면 영어 점수가 ASC
    3. 국어 점수와 영어 점수가 서로 같으면 수학 점수가 DESC
    4. 모든 점수가 같으면 이름이 ASC
  */
  @Override
  public int compareTo(Dohyun d) {
    if((d.getKor() == getKor()) && (d.getEng() == getEng()) && (d.getMat() == getMat())) {
      return d.getName() - getName(); // 얘를 어떻게 정렬할지...
    } else if((d.getKor() == getKor()) && (d.getEng() == getEng())) {
      return d.getMat() - getMat();
    } else if(d.getKor() == getKor()) {
      return d.getEng() - getEng();  
    } else {
      return d.getKor() - getKor();
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 도현이네 반의 학생 수
    
    String name = "";
    int kor = 0;
    int eng = 0;
    int mat = 0;
    ArrayList<Dohyun> dohyun = new ArrayList<>;
    
    for(int i=0; i<n; i++) {
      name = sc.next();
      kor = sc.nextInt();
      eng = sc.nextInt();
      mat = sc.nextInt();
      dohyun.add(new Dohyun(name, kor, eng, mat));
    }
    sc.close();

    Collections.sort(dohyun);
    for(int i=0; i<n; i++) {
      System.out.println(dohyun.get(i).getName());
    }
  }
}






/////////////////////////////////////////////////////////////////////////////////////////////////////






import java.util.*;

class Student implements Comparable<Student> {

    private String name;
    private int kor;
    private int eng;
    private int m;

    public Student(String name, int kor, int eng, int m) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.m = m;
    }

    /*
    [ 정렬 기준 ]
    1) 두 번째 원소를 기준으로 내림차순 정렬
    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
    */

    public String getName() {
        return this.name;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if (this.kor == other.kor && this.eng == other.eng && this.m == other.m) {
            return this.name.compareTo(other.name);
        }
        if (this.kor == other.kor && this.eng == other.eng) {
            return Integer.compare(other.m, this.m);
        }
        if (this.kor == other.kor) {
            return Integer.compare(this.eng, other.eng);
        }
        return Integer.compare(other.kor, this.kor);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int m = sc.nextInt();
            students.add(new Student(name, kor, eng, m));
        }

        Collections.sort(students);

        // 정렬된 학생 정보에서 이름만 출력
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }
}
