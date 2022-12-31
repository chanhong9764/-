import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

tc = int(input())

def dfs(x, y, array):
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return False
    
    if array[x][y] == 1:
        array[x][y] = 2
        dfs(x - 1, y, array)
        dfs(x + 1, y, array)   
        dfs(x, y - 1, array)   
        dfs(x, y + 1, array)   
        return True
    
    return False

for _ in range(tc):
    m, n, k = map(int, input().split(' '))
    
    array = [[0] * n for _ in range(m)]
    
    position = []
    count = 0
    
    for _ in range(k):
        x, y = map(int, input().split(' '))
        position.append((x, y))
        array[x][y] = 1
    
    for x, y in position:
        if dfs(x, y, array):
            count += 1
    print(count)