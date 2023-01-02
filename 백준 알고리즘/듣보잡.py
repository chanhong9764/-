import heapq
import sys
input = sys.stdin.readline
n, m = map(int, input().split())

listen = set()
see = set()

for _ in range(n):
    listen.add(input().rstrip())

for _ in range(m):
    see.add(input().rstrip())

answer = listen & see

print(len(answer))

for value in sorted(answer):
    print(value)