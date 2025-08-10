package dingCoDingCo.chapter2.arrayAndLlinkedList;

public class _02_09_factorier {

  public static void main(String[] args) {
    System.out.println("기댓값 6, 내 정답 =" + factorial(3));
    System.out.println("기댓값 120, 내 정답 =" + factorial(5));
  }

  public static int factorial(int n) {
    // 3 = 3 * 2 * 1
    // 수학적 수식 : f(3) = 3 * f(2) = 3 * 2 * f(1)
    //            f(n) = n * f(n-1)
    // 수식으로 치환.
//    return n * factorial(n - 1);

    // 탈출 조건
    // f(0) = 0, f(1) != 1 * f(0) => f(1) = 1
    if (n <= 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }
}