package luckhye;

import java.util.Arrays;
import java.util.LinkedList;

public class _02_04_insertion_sort {

  public static void main(String[] args) {
    // n[4, 6, 2, 9, 1]
    // ----------- 값들 -----------
    // 4,6,2,9,1 -> 정렬되지 않은 집합, 6,2,9,1 과 정렬된 집합 4 -> 정렬되지 않은 집합의 첫번째 원소에 접근 -> 정렬된 집합의 첫번째 원소와 비교해서 작으면 첫번째값으로 저장. 그게 아니면 두번째값으로 저장.
    // 4,6,2,9,1 -> 행위 명명, 1번 행위 치환

    // ----------- 알고리즘 -------
    // 배열 -> 인덱스0, 나머지시작인덱스 -> 나머지에 대해 첫번째 원소(값) 접근 -> 인덱스0보다 크면 뒤로 이동.
    // 배열 -> 인덱스0, 인덱스1, 나머지 -> [치환행위1 발생], 위에 치환행위 명명

    // print(dahye_insertion_sort(new Integer[]{4, 6, 2, 9, 1}));
    System.out.print(Arrays.toString(insertionSort(new int[]{4, 6, 2, 9, 1})));
  }

  public static void print(LinkedList<Integer> array) {
    System.out.println(array);
  }

  public static LinkedList dahye_insertion_sort(Integer[] array) {
//    int 나머지시작인덱스 = 1;
//    for(int i = 나머지시작인덱스; i < array.length; i++){
//
//      for(int k = 0; k < 나머지시작인덱스; k++){
//        if(array[i] > array[k] ){ // 1 <- 2
//         // 넘어가
//        }else if(array[i] <= array[k]){ // 2 <- 1
//          array[k] = array[i]; // 삽입이 발생하면서, 기존 인덱스가 뒤로 밀림. => 링크드 리스트가 나을듯
//        }
//      }
//    }

//    LinkedList<Integer> sorts = new LinkedList();
//    sorts.add(array[0]);
//    int 나머지시작인덱스 = 1;
//    for (int i = 나머지시작인덱스; i < array.length; i++) {
//      // for(Integer item : sorts){
//      for (int s = 0; s <= i; s++) {
//        if (array[i] <= sorts.get(s)) {
//          sorts.add(s + 1, sorts.get(s));
//          break;
//        }
//      }
//    }

//    return sorts;
    return null;
  }

  public static int[] insertionSort(int[] array) {
    // [4, 6, 2, 9, 1]
    // ----------- 값들 -----------
    // 4,6,2,9,1 -> 정렬되지 않은 집합, 6,2,9,1 과 정렬된 집합 4 -> 정렬되지 않은 집합의 첫번째 원소에 접근 -> 정렬된 집합의 마지막 원소와 비교해서 크면 저장 작으면 왼쪽이동하면서 교환.

    int n = array.length;

    for (int i = 1; i < n; ++i) {

      for(int j = 0; j < i; ++j) {
        if (array[i - j - 1] > array[i - j]) {
          int tempNum = array[i - j - 1];
          array[i - j - 1] = array[i - j];
          array[i - j] = tempNum;
        }
      }


    }

    return array;
  }
}