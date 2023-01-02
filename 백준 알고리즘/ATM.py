import sys
input = sys.stdin.readline

n = int(input())

second = list(map(int, input().split()))
second.sort()

answer = []
result = 0

for value in second:
    result = value + result
    answer.append(result)
    
print(sum(answer))