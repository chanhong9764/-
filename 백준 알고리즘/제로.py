import sys
input = sys.stdin.readline

k = int(input())

array = []

for _ in range(k):
    n = int(input())
    if n != 0:
        array.append(n)
    else:
        array.pop(-1)

print(sum(array))