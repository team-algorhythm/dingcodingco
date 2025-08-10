package dingCoDingCo.chapter1.chinheajigi;


public class findMaxNumByOperation {

  public static void main(String[] args) {

    System.out.println(
        ("정답 = 728 현재 풀이 값 =" + find_max_plus_or_multiply(new int[]{0, 3, 5, 6, 1, 2, 4} )));
    System.out.println(
        ("정답 = 8820 현재 풀이 값 =" + find_max_plus_or_multiply(new int[]{3, 2, 1, 5, 9, 7, 4})));
    System.out.println(
        ("정답 = 270 현재 풀이 값 =" + find_max_plus_or_multiply(new int[]{1, 1, 1, 3, 3, 2, 5})));
  }

  public static int find_max_plus_or_multiply(int[] array) {
    // 1. 문제 특징 :왼쪽부터 오른쪽으로 연산하며 X 또는 + 연산을 넣음. X는 0또는 1인 경우, +보다 작음.
    // 2. 컴퓨터한테 이해시킬 상황 : 순회하면서 0또는 1인 요소에 대해서는 +, 그외는 X을 진행.

    int plusOrMultiplyResult = 0;
    for(int num : array) {

      if(plusOrMultiplyResult == 0 || num == 0 || num == 1) {
        plusOrMultiplyResult += num; // 0 또는 1인 경우는 더하기
      }else {
        plusOrMultiplyResult *= num;
      }
    }
    // 이 부분을 채워보세요!
    return plusOrMultiplyResult;
  }

}