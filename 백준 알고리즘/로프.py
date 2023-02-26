import sys
input = sys.stdin.readline
n = int(input())

array = [int(input()) for _ in range(n)]
array.sort()

answer = 0

for i in range(len(array)):
    answer = max(answer, array[i] * (len(array) - i))
    
print(answer)