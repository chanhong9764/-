import sys
sys.setrecursionlimit(10**7)
n, s = map(int, input().split())

number = list(map(int, input().split()))

visited = [False] * n
answer = 0

def dfs(total, start):
    global answer

    if start >= n:
        return
    total += number[start]
    
    if total == s:
        answer += 1
        return
    
    for i in range(start, n):
        if not visited[i]:
            visited[i] = True
            dfs(total, i + 1)
            visited[i] = False
        

dfs(number[0], 1)
print(answer)
