T = int(input())

for tc in range(1, T + 1):
    currentValue = 97
    count = 0
    data = list(input())
    
    for value in data:
        if ord(value) == currentValue:
            count += 1
            currentValue += 1
        else:
            break
    print(f'#{tc} {count}')