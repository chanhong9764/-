import sys
input = sys.stdin.readline

n, m = map(int, input().split())

data = {}

for _ in range(n):
    address, password = input().split(' ')
    data[address] = password.strip()

for _ in range(m):
    print(data[input().strip()])