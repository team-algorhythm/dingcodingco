package dingCoDingCo.chapter1.chinheajigi;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class findNoneDupliChar {

  public static void main(String[] args) {

    String input1 = "abadabac";
    String input2 = "aabbcddd";
    String input3 = "aaaaaaaa";

    System.out.println("정답 = d 현재 풀이 값 = " + find_not_repeating_first_character(input1));
    System.out.println("정답 = c 현재 풀이 값 = " + find_not_repeating_first_character(input2));
    System.out.println("정답 = _ 현재 풀이 값 = " + find_not_repeating_first_character(input3));
  }

  public static char find_not_repeating_first_character(String content) {
    // 1. 문제 특징 : 중복 여부를 판단해야한다. 반복되지 않은 문자 중 문제의 문자들중 첫번째를 반환한다.
    // 중복 여부는, 1회만 등장하는 것을 말함.
    // 2. 컴퓨터한테 이해시킬 상황 : 주어진 문자열을 순회하면서 중복 횟수를 저장한다. 저장된 횟수 중 1번만 발생한 것들 중에 (1안) 인덱스로 첫번째껄 찾는다. (2안) 순회하며 두 문자 중 뭐가 먼저 나오는지 확인한다.

    ArrayList<Character> noneDuples = findAplabetOccurrenceArray(content);

    for (char c : content.toCharArray()) {
      if (noneDuples.contains(c)) {
        return c; // 중복되지 않은 첫번째 문자 반환
      }
    }

    //throw new RuntimeException("No non-repeating character found in the string.");
    return '_';
  }

  private static ArrayList<Character> findAplabetOccurrenceArray(String content) {
    int[] charCount = new int[26];
    int indexStart = 'a'; // 'a'의 유니코드 값

    content.chars().forEach(c -> charCount[c - indexStart]++);

    ArrayList<Character> noneDuples = new ArrayList();
    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] == 1) {
        noneDuples.add((char) (i + indexStart)); // 중복되지 않은 문자만 추가
      }
    }
    return noneDuples;
  }

//  public static char find_not_repeating_first_character_2(String string) {
//    // 2. 컴퓨터한테 이해시킬 상황 : 주어진 문자열을 순회하면서 중복 횟수가 1인 첫번째 문자를 확인한다. (X) 끝까지 돌아야 중복을 알 수 있따다
//    return 'a';
//  }


}