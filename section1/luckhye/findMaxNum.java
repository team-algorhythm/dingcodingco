package dingCoDingCo.chapter1.chinheajigi;

public class findMaxNum {

  public static void main(String[] args) {

    int[] arr = {3, 5, 6, 1, 2, 4, 3, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2,
        43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1,
        2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6,
        1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5,
        6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 4};

    // 함수 작성
    // 1번 함수.
    // find_max_num(arr);

    // 강의 함수1.
    int answer1 = compare_one_and_all(arr);
    System.out.println("답은 43, 함수 결과 : " + answer1);

//    int answer2 = compare_one_and_all_odap(arr);
//    System.out.println("답은 43, 함수 결과 : " + answer2);

  }


  public static int find_max_num(int[] arr) {
    int compare_num = 0;

    for (int num : arr) {
      // System.out.println(num); 3,4,5,6,...
      compare_num = num > compare_num ? num : compare_num;
    }

    return compare_num;
  }


  public static int compare_one_and_all(int[] arr) {
    for (int one : arr) {
      System.out.println("one : " + one); // 3,4,5,6,....

      boolean isMaxforAll = true;
      for (int oneOfAll : arr) {
        System.out.println("all : " + oneOfAll); // 3,4,5,6,...

        if (one <= oneOfAll) {
          break;
        }
      }

      if (isMaxforAll) {
        return one;
      }
    }

    throw new RuntimeException("No maximum number found in the array.");
  }


  public static int compare_one_and_all_odap(int[] arr) {
    for (int one : arr) {
      for (int oneOfAll : arr) {
        boolean isMaxforAll = true;
        if (one < oneOfAll) {
          isMaxforAll = false;
        }
        if (isMaxforAll) {
          return one;
        }
      }
    }
    throw new RuntimeException("No maximum number found in the array.");
  }


}