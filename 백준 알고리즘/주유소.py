n = int(input())

distance = list(map(int, input().split()))
oil = list(map(int, input().split()))

answer = distance[0] * oil[0]
lower = oil[0]
for i in range(1, n - 1):
    if lower > oil[i]:
        answer += oil[i] * distance[i]
        lower = oil[i]
    else:
        answer += lower * distance[i]

print(answer)