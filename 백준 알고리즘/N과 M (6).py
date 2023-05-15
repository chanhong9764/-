n, m = map(int, input().split())

array = list(map(int, input().split()))
array.sort()

temp = []

def dfs(start):
    if len(temp) == m:
        for value in temp:
            print(value, end=' ')
        print('')
        return
    
    for i in range(start, n):
        temp.append(array[i])
        dfs(i + 1)
        temp.pop()

dfs(0)