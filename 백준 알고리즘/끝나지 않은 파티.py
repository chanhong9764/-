import sys
input = sys.stdin.readline

n, m = map(int, input().split())

array = [list(map(int, input().split())) for _ in range(n)]

for k in range(n):
    for a in range(n):
        for b in range(n):
            array[a][b] = min(array[a][b], array[a][k] + array[k][b])


for _ in range(m):
    a, b, c = map(int, input().split())
    if array[a - 1][b - 1] <= c:
        print('Enjoy other party')
    else:
        print('Stay here')