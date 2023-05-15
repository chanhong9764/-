n, m = map(int, input().split())

array = list(map(int, input().split()))
array.sort()

temp = []

def dfs():
    if len(temp) == m:
        for value in temp:
            print(value, end=' ')
        print('')
        return
    
    for value in array:
        temp.append(value)
        dfs()
        temp.pop()

dfs()