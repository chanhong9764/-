from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

array = [[] for _ in range(n + 1)]
answer = [0] * (n + 1)

for _ in range(n - 1):
    a, b = map(int, input().split())
    array[a].append(b)
    array[b].append(a)

def bfs(start):
    q = deque([start])
    visited = [False] * (n + 1)
    visited[start] = True
    
    while q:
        value = q.popleft()
    
        for i in array[value]:
            if answer[i] == 0:
                answer[i] = value
                q.append(i)
                visited[i] = True
bfs(1)

for i in range(2, n + 1):
    print(answer[i])