n, m = map(int, input().split())

array =  []

def dfs():
    if len(array) == m:
        for value in array:
            print(value, end=' ')
        print('')
        return
    
    for i in range(1, n + 1):
        array.append(i)
        dfs()
        array.pop()

dfs()