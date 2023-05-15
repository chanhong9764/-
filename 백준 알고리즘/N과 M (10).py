n, m = map(int, input().split())

array = list(map(int, input().split()))
array.sort()
temp = []

def dfs(start):
    if len(temp) == m:
        for index in temp:
            print(array[index], end=' ')
        print('')
        return
    value = 0
    for i in range(start, n):
        if i not in temp and value != array[i]:
            value = array[i]
            temp.append(i)
            dfs(i + 1)
            temp.pop()
            
dfs(0)