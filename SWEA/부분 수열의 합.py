def dfs(idx, sum):
    global count
    visited[idx] = 1
    sum += data[idx]
    if sum == k:
        count += 1
    for i in range(idx, n):
        if not visited[i]:
            dfs(i, sum)
            visited[i] = 0


T = int(input())

for tc in range(1, T + 1):
    n, k = map(int, input().split())
    data = list(map(int, input().split()))
    
    count = 0
    
    for i in range(n):
        visited = [0] * n
        dfs(i, 0)
    print(f'#{tc} {count}')
# dfs 풀이