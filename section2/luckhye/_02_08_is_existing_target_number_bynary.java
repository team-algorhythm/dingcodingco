package dingCoDingCo.chapter2.arrayAndLlinkedList;

public class _02_08_is_existing_target_number_bynary {

  public static void main(String[] args) {
    int finding_target = 14;
    int[] finding_numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

//    boolean result = is_existing_target_number_binary_dh(finding_target, finding_numbers);
//    System.out.println("기댓값 : true, 내답 : " + result);
//    boolean result2 = is_existing_target_number_binary_dh_2(finding_target, finding_numbers);
//    System.out.println("기댓값 : true, 내답 : " + result2);


    is_existing_target_number_sequential(finding_target, finding_numbers);
    is_existing_target_number_binary(finding_target, finding_numbers);

  }

  public static boolean is_existing_target_number_binary_dh(int target, int[] array) {
    for (int item : array) {
      if (item == target) {
        return true;
      }
    }
    return false;
  }

  // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}
  //                      탐색
  // UP -> [8, 9, 10, 11, 12, 13, 14, 15, 16]
  // DOWN -> [1, 2, 3, 4, 5, 6, 7]
  // 우리가 찾고자 하는 범위가  계속해서, 탐색을 통해 줄어든다라고 말할 수 있다.

  // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}
  // 최소                                                 최대

  // UP -> [9, 10, 11, 12, 13, 14, 15, 16] : 9~16
  //        최소                         쵀대
  // DOWN -> [1, 2, 3, 4, 5, 6, 7] : 1~7
  //         최소                쵀대



  /*

  최소               탐색                               최대
  0                  6                                15
  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}


                       최소       탐색                   최대
                        7         11                   15
  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}


                                 최소      탐색         최대
                                  10      13           15
  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}


                                             최소  탐색  최대
                                              13  14  15
  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}


                                          최소=탐색=최대
                                              13
  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}
  */


  public static boolean is_existing_target_number_binary_dh_2(int target, int[] array) {
    int min_num = array[0];
    int max_num = array[array.length - 1];

    // 종료 조건 : Min == max
    // while문 조건문을 종료조건으로 사용하는 전제 : 조건문이 참 -> 거짓으로 변화할 수 있는 구조여야하고, 그 변화는 반복문 내부에서 객체의상태가 필연적으로 변경되어야함.
    while (min_num == max_num) {

      if (target == min_num || target == max_num) {
        return true;
      }

      // 하나는 상수로 생각하고, 고정 두기. 업다움 고정점(=탐색점).
      int up_down_value = (min_num + max_num) / 2;

      // 업다운 체커
      if (target > up_down_value) {
        min_num = up_down_value + 1;
      } else {
        max_num = up_down_value - 1;
      }
    }

    return false;
  }


  // 업다운 => 현재범위 / 추측 값
  /// 업범위/ 다움범위 / 다음 추측
  /// while (low <= high)
  public static boolean is_existing_target_number_binary(int target, int[] array) {
    int current_min = 0;
    int current_max = array.length - 1;
    int current_guess = (current_min + current_max) / 2;
    int find_count = 0;

    // 종료 조건 : current_min과 current_max이 올라감.
    // currnet_min이 계속해서 올라가서 current_max에 동일할때까지 진행할 예정.
    while (current_min <= current_max) {
      find_count += 1;

      // 반복에서 해야하는 작업.
      if (array[current_guess] == target) {
        System.out.println("is_existing_target_number_binary => find_count : "+ find_count);
        return true;
        // UP -> [9, 10, 11, 12, 13, 14, 15, 16] : 9~16
        // 범위를 (위)로 바꾼다.
      } else if (array[current_guess] < target) {
        current_min = current_guess + 1;
        // 범위를 (아래)로 바꾼다.
      } else if (array[current_guess] > target) {
        current_max = current_guess - 1;
      }

      // 다음 해야할 행동 : 다음 탐색할 값을 설정해야줘야함.
      current_guess = (current_min + current_max) / 2;
    }

    return false;
  }

  public static boolean is_existing_target_number_sequential(int target, int[] array){
    int find_count = 0;
    for (int item : array){
      find_count += 1;
      if(target == item){
        System.out.println("is_existing_target_number_sequential => find_count : "+ find_count);
        return true;
      }
    }
    return false;
  }





}