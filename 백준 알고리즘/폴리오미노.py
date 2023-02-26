temp = input()

count = 0

answer = ''

for i in range(len(temp)):
    if temp[i] == 'X':
        count += 1
    else:
        if count == 2:
            answer += 'BB'
        answer += '.'
        count = 0

    if count == 4:
        answer += 'AAAA'
        count = 0
        
if count == 2:
    answer += 'BB'

if len(answer) != len(temp):
    print(-1)
else:
    print(answer)