import sys
input = sys.stdin.readline
n = int(input())

array = [int(input()) for _ in range(n)]
array.sort(reverse=True)

answer = 0

for i in range(n // 3):
    answer += array[i*3] + array[i*3 + 1]

temp = 3 * (n // 3)

while n > temp:
    answer += array[temp]
    temp += 1
    
print(answer)