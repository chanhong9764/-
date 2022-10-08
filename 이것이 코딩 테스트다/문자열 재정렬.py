from unittest import result


s = list(input())
s.sort()
index = -1
result = 0
 
for i in range(0, len(s)):
    if s[i] >= 'A':
        index = i
        break

for i in range(0, index):
    result += int(s[i])

for i in range(index, len(s)):
    print(s[i], end='')
    
print(result)