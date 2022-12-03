n = int(input())

array = list(map(int, input().split()))
answer = 0

maxValue = max(array)

primeArray = [True] * (maxValue + 1)
primeArray[0], primeArray[1] = False, False

for i in range(2, maxValue):
    if primeArray[i] == True:
        for j in range(i+i, maxValue + 1, i):
            primeArray[j] = False
            
for value in array:
    if primeArray[value]:
        answer += 1
print(answer)

# 에라토스테네스의 체 알고리즘 활용