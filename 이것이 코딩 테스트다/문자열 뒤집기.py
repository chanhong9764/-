import math

s = input()

answer = 0

for i in range(0,len(s)-1):
    if s[i] != s[i+1]:
        answer += 1 

print(math.ceil(answer / 2))


# 백준 알고리즘
# https://www.acmicpc.net/problem/1439
# 문자열 뒤집기
# 이것이 코딩 테스트다