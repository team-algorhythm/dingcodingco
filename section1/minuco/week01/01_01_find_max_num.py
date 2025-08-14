"""
Q. 다음과 같이 숫자로 이루어진 배열이 있을 때, 이 배열 내에서 가장 큰 수를 반환하시오.
[3, 5, 6, 1, 2, 4, 3, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 4]
"""
def find_max_num1(array):
    # array의 인덱스를 하나씩
    for number in array:
        is_max_num = True # 매번 초기화
        for compare_num in array:
            """
                     0  1  2  3  4  5
            array = [3, 5, 6, 1, 2, 4]
            0번째 roop, num: 3	3 → 5 → 6 → 1 → 2 → 4
            ...
            5번째 roop, num: 4	3 → 5 → 6 → 1 → 2 → 4
            즉, number = 3 vs 3 그대로 3 vs 5 false
            ... number = 6 vs 3, 5,..., 4 그대로(true)
            """
            if number < compare_num:
                is_max_num = False
        if is_max_num:
            return number # 6 반환

def find_max_num2(array):
    max_num = array[0]
    for num in array:
        if num > max_num:
            """
            [3, 5, 6, 1, 2, 4]
            max_num(3) vs num (3,5)
            max_num(5) vs num (3,5,6)
            max_num(6) vs num (3,5,6,1,2,4)
            """
            max_num = num
    return max_num
"""
1. 하나의 원소를 다른 원소들과 비교해서 최대값인지 비교하는 방법
2. 하나의 변수를 만들어 그 변수와 배열의 원소를 비교해 가장 큰 수를 찾는 방법,
"""
#배열 내에서 가장 큰 수를 반환
def find_max_num_test(array):
    max_num= array[0]
    for num in array:
        if num > max_num:
            max_num = num
    return max_num

print("정답 = 6 / 현재 풀이 값 = ", find_max_num2([3, 5, 6, 1, 2, 4]))
print("정답 = 6 / 현재 풀이 값 = ", find_max_num2([6, 6, 6]))
print("정답 = 1888 / 현재 풀이 값 = ", find_max_num2([6, 9, 2, 7, 1888]))