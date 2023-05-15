import sys
sys.setrecursionlimit(10**7)

tc = list(input())

answer = [''] * len(tc)

def recursion(start, index):
    global answer
    if start:
        mid = start.index(min(start))
    
        answer[index + mid] = start[mid]

        print(*answer, sep='')

        recursion(start[mid + 1:], index + mid + 1)
        recursion(start[:mid], index)


recursion(tc, 0)