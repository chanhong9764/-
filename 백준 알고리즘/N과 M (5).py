import sys
sys.setrecursionlimit(10**7)
n, m = map(int, input().split())

array = []
number = list(map(int, input().split()))
number.sort()

def dfs(value):
    if len(array) == m:
        for value in array:
            print(number[value], end=' ')
        print('')
        return

    for i in range(n):
        if i not in array:
            array.append(i)
            dfs(i + 1)
            array.pop()

dfs(0)