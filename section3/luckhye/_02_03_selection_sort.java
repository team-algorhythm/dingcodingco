package luckhye;

import java.util.Arrays;

public class _02_03_selection_sort {

  public static void main(String[] args) {
//    input = [4, 6, 2, 9, 1]
//
//
//    def selection_sort(array):
//    # 이 부분을 채워보세요!
//    return
//
//
//        selection_sort(input)
    // System.out.println(Arrays.toString(dahye_selection_sort(new Integer[]{4, 6, 2, 9, 1})));



    print(dahye_selection_sort(new Integer[]{4, 6, 2, 9, 1}));
    print(dahye_selection_sort(new Integer[]{3, -1, 17, 9}));
    print(dahye_selection_sort(new Integer[]{100, 56, -3, 32, 44}));
  }

  public static void print(Integer[] array) {
    System.out.println(Arrays.toString(array));
  }

  public static Integer[] dahye_selection_sort_substitution_1(Integer[] array,
      int arrayMaxSortIdx) {
    // --------정해진 값들-------------
    // 값들에대해 정렬과정 진행. -> (반복1) 이전행위를 치환
    // [4, 6, 2, 9, 1]
    // (행위) 4, 6, 2, 9, 1 -> 최소값 -> 첫번째 원소와 교환
    // 1, 6, 2, 9, 4 -> 두번재 원소부터 ~ 마지막 탐색 6, 2, 9, 4 -> (이전행위를 치환)

    // ----------알고리즘-----------
    // 배열
    // (행위1) 배열 -> 최소값 -> 첫번째원소와 교환
    // (행위2) 정렬된 집합 vs 비정렬된 집합 -> 비정렬된 집합 = 배열로 치환 -> 행위1

    int minNumIdx = arrayMaxSortIdx;
    for (int i = arrayMaxSortIdx; i < array.length; i++) { // 탐색하는 마지막 원소 = (마지막 값 체크)
      if (array[i] < array[minNumIdx]) {
        minNumIdx = i;
      }
    }

    int minNum = array[minNumIdx]; // 값을 보관, 이제 변수 활용 가능.
    array[minNumIdx] = array[arrayMaxSortIdx];
    array[arrayMaxSortIdx] = minNum;

    return array;
  }

  public static Integer[] dahye_selection_sort(Integer[] array) {
    // ----------알고리즘-----------
    // 배열
    // (치환행위1) dahye_selection_sort_substitution_1
    // (치환행위2) 정렬된 집합 vs 비정렬된 집합 -> 비정렬된 집합 = 배열로 치환 -> 이전행위를 반복, 이전행위를 치환행위로 명명, 치환행위의 집합 탄생!

    // (치환행위2) 반복 횟수 -> 정렬집합이 몇번 발생해야함  -> 리스트당 하나의 원소 정렬됨. -> 5개라하면 4번만하면 됨. 나머지는 자동 정렬되기때문.
//    Integer[] combinedUnAndMixedSortArray = dahye_selection_sort_substitution_1(array);
    for (int i = 0; i < array.length - 1; i++) {
      int arrayMaxSortIdx = i;
      dahye_selection_sort_substitution_1(array, arrayMaxSortIdx);
    }

    return array;
  }


}