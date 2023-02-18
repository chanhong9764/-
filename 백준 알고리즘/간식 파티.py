import sys
input = sys.stdin.readline
 
n = int(input())

snack = int(input())
dp = [snack]
dp2 = [snack]
 
for _ in range(n-1):
    snack = int(input())
    
    tmp = []
    for i,v in enumerate(dp):
        if v < snack:
            tmp.append(dp2[i])
    dp.append(snack)
    if tmp:
        dp2.append(max(tmp)+snack)
    else:
        dp2.append(snack)
    
print(max(dp2))