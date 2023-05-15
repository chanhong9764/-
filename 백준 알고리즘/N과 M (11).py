n, m = map(int, input().split())

array = list(map(int, input().split()))
array.sort()
temp = []

def dfs():
    if len(temp) == m:
        for index in temp:
            print(array[index], end=' ')
        print('')
        return
    value = -1
    for i in range(n):
        if value != array[i]:
            value = array[i]
            temp.append(i)
            dfs()
            temp.pop()

dfs()