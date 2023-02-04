import sys
sys.setrecursionlimit(10**7)
n, m = map(int, input().split())

array = []
number = list(map(int, input().split()))
number.sort()
visited = [False] * n

def dfs(idx):
    if idx == m:
        print(*array)
        return
    
    temp = 0
    for i in range(n):
        if not visited[i] and temp != number[i]:
            visited[i] = True
            array.append(number[i])
            temp = number[i]
            dfs(idx + 1)
            visited[i] = False
            array.pop()
dfs(0)