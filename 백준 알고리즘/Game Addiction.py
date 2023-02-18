import sys
sys.setrecursionlimit(10**7)

h, n = map(int, input().split())

diff = abs(h - n) + 1

array = [[0] * diff for _ in range(diff)]

for i in range(diff):
    array[0][i] = 1

for i in range(1, diff):
    for j in range(i, diff):
        array[i][j] = array[i - 1][j] + array[i][j - 1]

print(array[-1][-1])