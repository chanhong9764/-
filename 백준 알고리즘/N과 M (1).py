import sys
sys.setrecursionlimit(10**7)
n, m = map(int, input().split())

array = []

def backtracking():
    if len(array) == m:
        for value in array:
            print(value, end=' ')
        print('')
        return
    
    for i in range(1, n + 1):
        if i not in array:
            array.append(i)
            backtracking()
            array.pop()
        
backtracking()