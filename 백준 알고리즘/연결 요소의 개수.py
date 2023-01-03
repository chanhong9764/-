from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

array = [[] * (n + 1) for _ in range(n + 1)]
visited = [False] * (n + 1)

answer = 0

for _ in range(m):
    u, v = map(int, input().split())
    array[u].append(v)
    array[v].append(u)
    
def bfs(start):
    q = deque([start])
    visited[start] = True
    
    while q:
        value = q.popleft()
        
        for i in array[value]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

for i in range(1, n + 1):
    if not visited[i]:
        bfs(i)
        answer += 1
        
print(answer)