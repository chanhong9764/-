n = int(input())

array = [0] * 20000001

inputArray = list(map(int, input().split()))

for value in inputArray:
    array[10000000 + value] += 1

m = int(input())

inputArray = list(map(int, input().split()))

for value in inputArray:
    print(array[10000000 + value], end=' ')