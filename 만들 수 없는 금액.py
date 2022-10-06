n = int(input())

data = list(map(int,input().split()))
data.sort()

target = 1
for value in data:
    if target < value:
        break
    target += value
    
print(target)

# 만들 수 없는 금액
# 이것이 코딩 테스트다