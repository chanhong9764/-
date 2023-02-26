import sys
input = sys.stdin.readline
from collections import deque
n, m, x = map(int, input().split())

higher = [[] for _ in range(n + 1)]
lower = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    higher[a].append(b)
    lower[b].append(a)
    
def bfs(start, array):
    q = deque([start])
    visited[start] = True
    count = 0
    
    while q:
        value = q.popleft()

        for i in array[value]:
            if not visited[i]:
                count += 1
                q.append(i)
                visited[i] = True
    return count


print(1 + bfs(x, lower), n - bfs(x, higher))