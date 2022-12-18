import sys
input = sys.stdin.readline
n, m = map(int, input().split())

data = {}
reversed_data = {}

for i in range(1, n+1):
    temp = input().rstrip()
    data[temp] = i
    reversed_data[i] = temp

for _ in range(m):
    temp = input().rstrip()
    if ord(temp[0]) >= 48 and ord(temp[0]) <= 57:
        print(reversed_data[int(temp)])
    else:
        print(data[temp])