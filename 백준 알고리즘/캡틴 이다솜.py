n = int(input())

number = [0, 1]

i = 1
temp = 1
while number[i] < n:
    i += 1
    temp += i
    number.append(temp + number[i - 1])

dp = [n] * (n + 1)

for i in range(1, n + 1):
    for num in number:
        if num > i:
            break
        elif num == i:
            dp[i] = 1
            break
        else:
            dp[i] = min(dp[i], dp[i - num] + 1)
print(dp[n])