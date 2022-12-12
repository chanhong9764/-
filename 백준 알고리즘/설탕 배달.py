n = int(input())

five = n // 5
three = n // 3

answer = []

for i in range(five+1):
    for j in range(three+1):
        result = i*5 + j*3
        if result // n == 1 and result % n == 0:
            answer.append(i+j)
            
if len(answer) != 0:
    print(min(answer))
else:
    print(-1)