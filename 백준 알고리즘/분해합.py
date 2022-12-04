n = int(input())

answer = []

for value in range(n - 1, 0, -1):
    total = value
    listValue = list(str(value))
    
    for number in listValue:
        total += int(number)
        
    if total == n:
        answer.append(value)

if len(answer) != 0:
    print(min(answer))
else:
    print('0')