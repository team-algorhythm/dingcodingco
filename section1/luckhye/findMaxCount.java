package dingCoDingCo.chapter1.chinheajigi;

import java.util.Arrays;

public class findMaxCount {

  public static void main(String[] args) {
    // 최빈값 구하기 (단 최빈값을 가진 알파벳이 여러개일 경우 알파벳 순서가 가장 앞에 위치한 알파벳을 출력하시오)

    //    System.out.println((int) 'a');

    // 함수 작성

//    find_max_count("hello my name is dingcodingco");
    findMaxCount("hello my name is dingcodingco");
  }

  // 문자 -> 유니코드(int)로 변환

  // "문제 유니코드를 -> 인덱스 집합으로 매핑" : 이산 집합간의 매핑

  // 인덱스 마다 문자 빈도수 카운트

  // {인덱스 집합 : 빈도수 집합} 세트 집합으로 -> array 집합에서 관리.

  // 빈도수 1인 애들 중에서 처음에 나온 인덱스(=치환활 문자)를 확인.
  private static void find_max_count(String str) {
    // 26 글자 array
    int[] indexAndFreaquncyeArr = new int[26];

    int toMinIndexFromUnicode = 'a'; // 97
    int toMaxIndexFromUnicode = 'z'; // 97

    str.chars()
        .filter(
            c -> c >= toMinIndexFromUnicode && c <= toMaxIndexFromUnicode) // 'a' ~ 'z' 범위의 문자만 필터링
        .forEach(c -> indexAndFreaquncyeArr[c - toMinIndexFromUnicode] += 1);

    // 최대값 구하기
    int maxIndex = 0;
    for (int i = 0; i < indexAndFreaquncyeArr.length; i++) {
      if (indexAndFreaquncyeArr[maxIndex] < indexAndFreaquncyeArr[i]) {
        maxIndex = i;
      }
    }

    System.out.println("정답은 i 이고, 결과값은 : " + (char) (maxIndex + toMinIndexFromUnicode));
  }

  // 각 알파벳 빈도수를 indexAndFreaquncyeArr라는 변수에 저장합니다.
  // 그리고 각 문자열을 순회하면서 해당 문자가 알파벳인지 확인하고, 알파벳을 인덱스화 시켜 각 알파벳의 빈도수를 업데이트 합니다.
  // 이후, 알파벳의 빈도수가 가장 높은 인덱스를 찾습니다.

  // 주어진 알파벳들 대상으로 하나의 알파벳이 다른 알파벳보다 빈도수가 높은지 확인하는 로직을 구합니다.
  // 'h' -> 'h', 'e', 'l', ...    => 'h' : 몇개  => 최대값 < h 개수 비교 => 최대값이 h 개수보다 작으면 h의 개수를 저장.
  // 'e' -> 'h', 'e', 'l', ...

  public static int findMaxCount(String str) {
    int maxCount = 0;
    char maxCountChar = 0;
    for (char c : str.toCharArray()) {
      if( c < 'a' || c > 'z') {
        continue; // 알파벳이 아닌 경우는 건너뜀
      }

      int occurrences = 0;
      for (char cOfAll : str.toCharArray()) {
        // 판단시점1. 하나 요소의 빈도수
        if( c == cOfAll) {
          occurrences++;
        }
      }

      // 판단시점2. 최대값과 비교
      //if( 최대값 < occurrences) {
      // 유니코드 비교해서 크면 업데이트 안함.
      boolean isMaxBigUnicode = c < maxCountChar ? true : false;
      if (maxCount < occurrences) {
        maxCount = occurrences;     // 대입을 업데이트.라고 표현하네.
        maxCountChar = c;
      } else if(maxCount == occurrences && isMaxBigUnicode ){
        maxCountChar = c; // 같은 빈도수라면 유니코드가 더 큰 알파벳으로 업데이트
      }
    }

    System.out.println("정답은 i 이고, 결과값은 : " + maxCountChar);
    return maxCount;
  }

}