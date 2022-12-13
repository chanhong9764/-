n = int(input())

hashString = input()

answer = 0

for i in range(len(hashString)):
    answer += (ord(hashString[i]) - 96)*31**i
print(answer % 1234567891)