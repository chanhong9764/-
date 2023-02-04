n, m = map(int, input().split())

array = []
number = list(set(map(int, input().split())))
number.sort()

def dfs(start):
    if len(array) == m:
        for value in array:
            print(number[value], end=' ')
        print('')
        return
    
    for i in range(start, len(number)):
        array.append(i)
        dfs(i)
        array.pop()
        
dfs(0)