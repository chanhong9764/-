from itertools import combinations

n, m = map(int, input().split())

array = list(map(int, input().split()))

maxValue = 0
for x, y, z in combinations(array, 3):
    sum = x + y + z
    if maxValue <= sum and m >= sum:
        maxValue = x + y + z
print(maxValue)