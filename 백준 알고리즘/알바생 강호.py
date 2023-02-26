import sys
input = sys.stdin.readline

n = int(input())

array = sorted([int(input()) for _ in range(n)], key=lambda x : (-x))

answer = 0

for i in range(n):
    tip = array[i] - i
    if tip >= 1:
        answer += tip
print(answer)