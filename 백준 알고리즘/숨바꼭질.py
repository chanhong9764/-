import sys
sys.setrecursionlimit(10**7)
from collections import deque

n, k = map(int, input().split())

visited = [False] * (max(n, k) + 2)

def bfs(start):
    q = deque([start])
    answer = 0
    length = 1
    
    while q:
        v = q.popleft()
        visited[v] = True
        if v == k:
            print(answer)
            break    
        else:
            if not (v - 1 <= -1):
                if not visited[v - 1]:
                    q.append(v - 1)
            if not (v + 1 >= max(n, k) + 2):
                if not visited[v + 1]:
                    q.append(v + 1)
            if not (v * 2 >= max(n, k) + 2):
                if not visited[v * 2]:
                    q.append(v * 2)
                
        length -= 1
        
        if length == 0:
            answer += 1
            length = len(q)
    
bfs(n)