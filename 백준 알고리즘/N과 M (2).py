import sys
sys.setrecursionlimit(10**7)
n, m = map(int, input().split())

array = []

def dfs(start):
    if len(array) == m:
        for value in array:
            print(value, end=' ')
        print('')
        return

    for i in range(start, n + 1):
        array.append(i)
        dfs(i + 1)
        array.pop()
    
dfs(1)