n = int(input())
answer = 0

result = 1
for i in range(2, n + 1):
    result *= i
for value in reversed(str(result)):
    if value != '0':
        break
    answer += 1
            
print(answer)