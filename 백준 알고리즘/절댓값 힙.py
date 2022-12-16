import sys
import heapq
input = sys.stdin.readline

n = int(input())

hq = []
for _ in range(n):
    value = int(input())
    if value == 0:
        if len(hq) == 0:
            print('0')
        else:
            print(heapq.heappop(hq)[1])
    else:
        heapq.heappush(hq, (abs(value), value))