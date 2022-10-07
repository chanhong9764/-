n, m = map(int, input().split())

data = list(map(int, input().split()))

answer = 0

for i in range(n - 1):
    for j in range(i + 1, n):
        if data[i] != data[j]:
            answer += 1
            
print(answer)

# 볼링공 고르기
# 이것이 코딩 테스트다