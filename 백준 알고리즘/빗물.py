h, w = map(int, input().split())

number = list(map(int, input().split()))
answer = 0

for i in range(1, w - 1):
    left_max = max(number[:i])
    right_max = max(number[i+1:])

    compare = min(left_max, right_max)

    if number[i] < compare:
        answer += compare - number[i]
print(answer)