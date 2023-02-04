import sys
sys.setrecursionlimit(10**7)
n, m = map(int, input().split())

array = []
number = list(map(int, input().split()))
number.sort()

def dfs(start):
    if len(array) == m:
        for i in array:
            print(number[i], end=' ')
        print('')
        return

    for i in range(start, n):
        array.append(i)
        dfs(i)
        array.pop()

dfs(0)