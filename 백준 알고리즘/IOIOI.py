import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
answer = 0

s = input()
index = 0
count = 0

while index < m - 1:
    if s[index:index+3] == 'IOI':
        count += 1
        index += 2
        if count == n:
            answer += 1
            count -= 1
    else:
        index += 1
        count = 0
        
print(answer)