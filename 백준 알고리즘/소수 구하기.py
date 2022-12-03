m, n  = map(int, input().split())

array = [True] * (n + 1)
array[0], array[1] = False, False
limit = int(n**0.5)

for i in range(2, limit + 1):
    if array[i] == True:
        for j in range(i + i, n + 1, i):
            array[j] = False

for i in range(m, n + 1):
    if array[i]:
        print(i)
        
# 에라토스테네스의 체 알고리즘