package luckhye;

import java.util.Arrays;

public class _02_02_bubble_sort {

  public static void main(String[] args) {
//    K:1 array.length: 5 i:1 배열:[4, 6, 2, 9, 1]
//    K:1 array.length: 5 i:2 배열:[4, 2, 6, 9, 1]
//    K:1 array.length: 5 i:3 배열:[4, 2, 6, 9, 1]
//    K:1 array.length: 5 i:4 배열:[4, 2, 6, 1, 9]
//    K:2 array.length: 5 i:1 배열:[2, 4, 6, 1, 9]
//    K:2 array.length: 5 i:2 배열:[2, 4, 6, 1, 9]
//    K:2 array.length: 5 i:3 배열:[2, 4, 1, 6, 9]
//    K:3 array.length: 5 i:1 배열:[2, 4, 1, 6, 9]
//    K:3 array.length: 5 i:2 배열:[2, 1, 4, 6, 9]
//    K:4 array.length: 5 i:1 배열:[1, 2, 4, 6, 9]
//    [1, 2, 4, 6, 9]
    // System.out.println(Arrays.toString(dahye_bubble(new Integer[]{4, 6, 2, 9, 1})));


//    K:0 array.length: 5 i:0 배열:[4, 6, 2, 9, 1]
//    K:0 array.length: 5 i:1 배열:[4, 2, 6, 9, 1]
//    K:0 array.length: 5 i:2 배열:[4, 2, 6, 9, 1]
//    K:0 array.length: 5 i:3 배열:[4, 2, 6, 1, 9]
//    K:1 array.length: 5 i:0 배열:[2, 4, 6, 1, 9]
//    K:1 array.length: 5 i:1 배열:[2, 4, 6, 1, 9]
//    K:1 array.length: 5 i:2 배열:[2, 4, 1, 6, 9]
//    K:2 array.length: 5 i:0 배열:[2, 4, 1, 6, 9]
//    K:2 array.length: 5 i:1 배열:[2, 1, 4, 6, 9]
//    K:3 array.length: 5 i:0 배열:[1, 2, 4, 6, 9]
//    [1, 2, 4, 6, 9]
    // (사람이 세는 단위) 횟수 // 길이 // (컴퓨터가 세는 단위) 인덱스 다다르네.
    // i < array.length - 1 - k인지 or i <= array.length - 1 - k 인지.
    System.out.println(Arrays.toString(dingco_bubble(new Integer[]{4, 6, 2, 9, 1})));

  }

  public static Integer[] one_path_bubble_sort(Integer[] array) {
    for (int i = 1; i < array.length - 1; i++) {
      Integer prevItem = array[i - 1];
      Integer currItem = array[i];
      if (prevItem > currItem) {
        array[i - 1] = currItem;  // '값'을 저장하여
        array[i] = currItem;      // '값'을 저장하여 교환을 진행.
      }
    }
    // [4, 6, 2, 9, 1]
    // 첫번째 원소에 접근 -> 인덱스 0 -> 조건 미달 pass
    // 두번째 원소에 접근 -> 인덱스 1 -> 4, 6. 4>6, 인덱스0의 변수에 6, 인덱스1의 변수에 1
    // 세번째 원소에 접근 -> 인덱스 2 -> 6, 2, 6>2, 인덱스1의 변수에 2, 인덱스2의 변수에 6
    // ...
    // 길이-1 원소에 접근 -> 인덱스 4 -> 6, 9, 6>9
    // 결국  [4, 2, 6, 1, '9'] : 9가 떠오름.
    return array;
  }

  public static Integer[] dahye_bubble(Integer[] array) {
    // 결국  [4, 6, 2, 9, 1] ->  [4, 2, 6, 1, '9'] : 9가 떠오름. 즉, 5개의 원소에 4개를 접근했음.
    // 1바퀴에 ' array.length - 1' -> 2바퀴에 ' array.length - 2 ' -> k바퀴에는 ' array.length - k'까지 접근한다. => 원소 접근 범위를 확인했다.

    for (int k = 1; k <= array.length - 1; k++) {
      for (int i = 1; i <= array.length - k; i++) {
        Integer prevItem = array[i - 1];
        Integer currItem = array[i];
        if (prevItem > currItem) {
          array[i - 1] = currItem;  // '값'을 저장하여
          array[i] = prevItem;      // '값'을 저장하여 교환을 진행.
        }
        System.out.println(
            "K:" + k + " array.length: " + array.length + " i:" + i + " 배열:" + Arrays.toString(
                array));
      }

    }
    return array;
  }

  public static Integer[] dingco_bubble(Integer[] array) {
    // 결국  [4, 6, 2, 9, 1] ->  [4, 2, 6, 1, '9'] : 9가 떠오름. 즉, 5개의 원소에 4개를 접근했음.
    // 1바퀴에 ' array.length - 1' -> 2바퀴에 ' array.length - 2 ' -> k바퀴에는 ' array.length - k'까지 접근한다. => 원소 접근 범위를 확인했다.

    for (int k = 0; k <= array.length - 1; k++) {
      for (int i = 0; i < array.length - 1 - k; i++) {
        Integer nextItem = array[i + 1];
        Integer currItem = array[i];
        if (currItem > nextItem) {
          array[i] = nextItem;          // '값'을 저장하여
          array[i + 1] = currItem;      // '값'을 저장하여 교환을 진행.
        }
        System.out.println(
            "K:" + k + " array.length: " + array.length + " i:" + i + " 배열:" + Arrays.toString(
                array));
      }

    }
    return array;
  }

}