"""
각 알파벳 마다 문자여을 돌면서 몇 글자가 나왔는지 확인한다.
만약 그 숫자가 저장한 알파벳 빈도 수 보다 크다면 그 값을 저장하고 제일 큰 알파벳으로 저장.
이 과정을 반복 해 가장 많이 나왔던 알파벳을 알하내라

Q.다음과 같은 문자열을 입력받았을 때, 어떤 알파벳이 가장 많이 포함되어 있는지 반환하시오.
(단 최빈값을 가진 알파벳이 여러개일 경우 알파벳 순서가 가장 앞에 위치한 알파벳을 출력하시오)

"""
# 각 알파벳 출현 빈도스를 구하기 위해선 A ~ Z 까지 산 알파벳이 몇글짜인지 알아야함. -> 배열이 가장 효율적
# [0][1][2][3]...[25]
# a   b  c  d  ... z
# ord('a')함수를 쓰면 a의 ASCII 코드 97로 변환해줌
#ord('a') - 97 = 0| ord('b') - 97 = 1 | ord('c') - 97 = 2
# chr(97) 함수를 쓰면 숫자를 문자로 변경해줌. 즉 a가 나옴

# d -> 3 을 구하려면, ord('d') = 100임, a ~z 까지일때 d 의 인덱스는 3
# ord('d') - ord('c')를 해주면 3이 나옴

def find_max_occurred_alphabet(string):
    alphabet_array = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                      "t", "u", "v", "x", "y", "z"]
    max_occurene = 0 # 알파벳 개수
    max_alphabet = alphabet_array[0] # alphabet 의 첫번째 원소 a

    for alphabet in alphabet_array:
        # 알파벳을 순회하면서 각각의 몇 번 나왔는지를 저장 할 수 있는 변수
        occurene = 0
        for char in string:
            if char == alphabet:
                occurene = occurene + 1
        if occurene > max_occurene:
            max_alphabet = alphabet
            max_occurene = occurene

    return max_alphabet
# 1. a, b, c 처럼 문자가 해당 문자열에 얼마나 있는지 파악하고,
# 그 개수가 가장 크다면 변환해 줘야 하는 값을 그 알파벳으로 변환한다..
# a -> hello my name is dingcodingco -> a는 0개나오고, max_occurence = 0, max_alphabet = a
# b -> hello my name is dingcodingco -> a는 0개나오고, max_occurence = 0, max_alphabet = b
# c -> hello my name is dingcodingco -> c의 빈도수 2개, max_occurence = 2, max_alphabet = c
# 알파벳을 하나씩 조회하면서 max_occurence, max_alphabet 이 업데이트 되는 방식으로 코드를 구현


result = find_max_occurred_alphabet
print("정답 = i 현재 풀이 값 =", result("hello my name is dingcodingco"))
print("정답 = e 현재 풀이 값 =", result("we love algorithm"))
print("정답 = b 현재 풀이 값 =", result("best of best youtube"))

# 알파벳 빈도를 새는 함수?
def find_alphabet_occurrence_array(string):
    alphabet_occurrence_array = [0] * 26

    # 이 부분을 채워보세요!

    return alphabet_occurrence_array


print("정답 = [1, 0, 2, 2, 2, 0, 2, 1, 3, 0, 0, 2, 2, 3, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0] \n현재 풀이 값 =",
      find_alphabet_occurrence_array("hello my name is dingcodingco"))
print("정답 = [1, 0, 0, 0, 2, 0, 1, 1, 1, 0, 0, 2, 1, 0, 2, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0] \n현재 풀이 값 =",
      find_alphabet_occurrence_array("we love algorithm"))
print("정답 = [0, 3, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 3, 2, 0, 0, 0, 1, 0] \n현재 풀이 값 =",
      find_alphabet_occurrence_array("best of best youtube"))