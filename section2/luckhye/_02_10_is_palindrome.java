package dingCoDingCo.chapter2.arrayAndLlinkedList;

public class _02_10_is_palindrome {

  public static void main(String[] args) {
    String input = "abcba";
    String input2 = "abcbaab";

    System.out.println(is_palindrome_dh(input));
    System.out.println(is_palindrome_dh(input2));
    System.out.println(is_palindrome(input));
    System.out.println(is_palindrome(input2));
    System.out.println(is_palindrome_recursive(input));
    System.out.println(is_palindrome_recursive(input2));
  }

  public static boolean is_palindrome_dh(String input) {
    // 확인 부분을 제거한다.
    // 회문 특징 : 첫 문자 == 끝 문자
    char fisrt_str = input.charAt(0);
    char last_str = input.charAt(input.length() - 1);

    if (fisrt_str != last_str) {
      return false;
    } else {
      String input2 = input.substring(1, input.length() - 2);
      is_palindrome(input2);
    }

    return true;
  }


  public static boolean is_palindrome(String input) {
    int n = input.length();
    for (int i = 0; i < n; i++) { // 0 <= i <= n
      if (input.charAt(i) != input.charAt((n - 1) - i)) { // (질문) 이런거 맞추는게 어려움.
        return false;
      }
    }

    return true;
  }


  public static boolean is_palindrome_recursive(String input) { // 소주만병만주소
    if (input.length() <= 1) {
      return true;
    }

    if (input.charAt(0) != input.charAt((input.length() - 1))) {
      return false;
    }

    return is_palindrome_recursive(input.substring(1, input.length() - 1)); // 주만병만주
  }


}