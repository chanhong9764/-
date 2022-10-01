n = input()

total = int(n[0])

for i in range(1, len(n)):
    data = int(n[i])
    if data <= 1 or total <= 1:
        total += data
    else:
        total *= data
    
print(total)