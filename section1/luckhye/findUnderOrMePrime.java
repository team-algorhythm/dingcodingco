package dingCoDingCo.chapter1.chinheajigi;


import java.util.ArrayList;
import java.util.List;

public class findUnderOrMePrime {

  public static void main(String[] args) {
    int input = 20;
    ArrayList<Integer> result = find_prime_list_under_number(input);
    System.out.println("답은 [2, 3, 5, 7, 11, 13, 17, 19], 결과는 " + result);
  }

  public static ArrayList<Integer> find_prime_list_under_number(int number) {
    // 문제 특징. 소수는 1또는 나자신으로 나누면 0이고, 그 외는 나머지가 존재한다. 이하라고 했으니, 나 랑 내 밑 숫자들에 해당된다.
    // 컴퓨터한테 이해시킬 상황 : 주어진 수 이하를 순회하면서, 해당 수가 소수이면 리스트에 담는다. 소수는 1보다 커야한다.

    ArrayList<Integer> pimeList = new ArrayList();
    for (int i = 2; i <= number; i++) { // num길이 만큼 순회.
//      if (isPrime(i)) {
      if (isPrime_2(i)) {
        pimeList.add(i); // 소수이면 리스트에 추가
      }
    }
    return pimeList;
  }


  public static boolean isPrime(int prime) {
    if (prime < 2) {
      return false; // 2보다 작은 수는 소수가 아님
    }

    // 자기보다 작은 수를 순회하면서 나머지가 0이 아닌 수를 발견하면 소수임 플래그 빠꾼다.
    for (int i = 2; i <= prime; i++) {
      if (i == prime) {
        continue;
      }

      if (prime % i == 0) {
        return false; // 나누어 떨어지는 수가 있으면 소수가 아님
      }
    }

    return true; // 소수임
  }


//  주어진 자연수 N이 소수이기 위한 필요충분 조건은 N이 N의 제곱근보다 크지 않은 어떤 소수로도 나눠지지 않는다. 수가 수를 나누면 몫이 발생하게 되는데 몫과 나누는 수, 둘 중 하나는 반드시 N의 제곱근 이하이기 때문입니다.
//  이를 이용해서 i * i ≤ n 일 때까지만 비교하시면 됩니다!
  public static boolean isPrime_2(int prime) {
    if (prime < 2) {
      return false; // 2보다 작은 수는 소수가 아님
    }

    // 자기보다 작은 수를 순회하면서 나머지가 0이 아닌 수를 발견하면 소수임 플래그 빠꾼다.
    for (int i = 2; i <= Math.sqrt(prime); i++) {
      if (i == prime) {
        continue;
      }

      if (prime % i == 0) {
        return false; // 나누어 떨어지는 수가 있으면 소수가 아님
      }
    }

    return true; // 소수임
  }




}