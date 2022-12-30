from collections import deque

n, m, v = map(int, input().split(' '))

array = [[] for _ in range(n+1)]

visitedDFS = [False] * (n+1)
visitedBFS = [False] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    array[a].append(b)
    array[b].append(a)

for i in range(1, n+1):
    array[i].sort() 

def dfs(value):
    visitedDFS[value] = True
    
    print(value, end=' ')
    
    for i in array[value]:
        if not visitedDFS[i]:
            dfs(i)
 
def bfs(value):
    q = deque([value])
    visitedBFS[value] = True
    
    while q:
        v = q.popleft()
        print(v, end=' ')
        
        for i in array[v]:
            if not visitedBFS[i]:
                q.append(i)
                visitedBFS[i] = True
            
dfs(v)
print('')
bfs(v)