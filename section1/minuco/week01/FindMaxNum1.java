package week01.num01;


/*
Q. 다음과 같이 숫자로 이루어진 배열이 있을 때, 이 배열 내에서 가장 큰 수를 반환하시오.
[3, 5, 6, 1, 2, 4, 3, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 4]
 이 문제를 풀기 위해서는 어떻게 해야 할까요?
 아래 코드를 복사 붙여넣기 하고 함수를 작성해보세요!
 2분 정도 고민해 본 다음, 아래 방법들을 펼쳐 봅시다!

# 1. a, b, c 처럼 문자가 해당 문자열에 얼마나 있는지 파악하고, 그 개수가 가장 크다면 반환해줘야 하는 값을 그 알파벳으로 변환한다.
# a -> hello my name is dingcodingco -> 0 max_occurence = 0 max_alphabet = a
# b -> hello my name is dingcodingco -> 0 max_occurence = 0 max_alphabet = b
# c -> hello my name is dingcodingco -> 2 max_occurence = 2 max_alphabet = c

 */
// [코드스니펫 최대값찾기]
/*
public class FindMaxNum1 {
    public static int findMaxNum(int[] array) {
        // 이 부분을 채워주세요
        return 0;
    }

    public static void main(String[] args) {

        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 6, 6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 9, 2, 7, 1888}));
    }
}
 */

// 첫번째 방법
class FindMaxNum1 {
    public static int findMaxNum(int[] array) {
        for (int number : array) {
            boolean isMaxNum = true;
            for (int compareNumber : array) {
                if (number < compareNumber) {
                    isMaxNum = false;
                }
            }
            if (isMaxNum) {
                return number;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 6, 6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 9, 2, 7, 1888}));
    }
}

// 2번째 방법
class FindMaxNum2 {
    public static int findMaxNum(int[] array) {
        int maxNum = array[0];
        for (int num : array) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{3, 5, 6, 1, 2, 4}));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 6, 6}));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(new int[]{6, 9, 2, 7, 1888}));
    }
}