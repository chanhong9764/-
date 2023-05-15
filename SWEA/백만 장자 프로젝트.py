tc = int(input())

for t in range(1, tc + 1):
    n = int(input())

    data = list(map(int, input().split(' ')))
    maxPrice = 0
    answer = 0
    for val in data[::-1]:
        if val >= maxPrice:
            maxPrice = val
        else:
            answer += maxPrice - val
    print('#', t, " ", answer, sep="")