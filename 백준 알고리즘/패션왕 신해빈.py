import sys
input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
    closet = {}
    n = int(input())
    answer = 1
    
    for _ in range(n):
        cloth, kind = input().split(' ')
        
        if kind in closet:
            temp = list(closet[kind])
            temp.append(cloth)
            closet[kind] = temp
        else:
            closet[kind] = [cloth]
    
    for value in closet.values():
        answer *= len(value) + 1
    print(answer - 1)