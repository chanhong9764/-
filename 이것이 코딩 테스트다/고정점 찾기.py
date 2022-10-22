n = int(input())

data = list(map(int, input().split()))
answer = -1

start = 0
end = n - 1

while start <= end:
    mid = (start + end) // 2
    
    if data[mid] == mid:
        answer = mid
        break
    elif data[mid] > mid:
        end = mid - 1
    else:
        start = mid + 1

print(answer)
