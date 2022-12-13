import sys
input = sys.stdin.readline
n, m = map(int, input().rstrip().split())

array = list(map(int, input().rstrip().split()))

start = 0
end = max(array)

answer = 0

while start <= end:
    total = 0
    mid = (start + end) // 2
    
    for value in array:
        if value > mid:
            total += value - mid
    
    if total < m:
        end = mid - 1
    else:
        answer = mid
        start = mid + 1

print(answer)