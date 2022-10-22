n, x = map(int, input().split())

data = list(map(int, input().split()))

count = 0
start = 0
end = n - 1

while start <= end and x in data:
    mid = (start + end) // 2
    if data[mid] == x:
        count += 1
        data.pop(mid)
    elif data[mid] > x:
        end = mid - 1
    else:
        start = mid + 1

if count == 0:
    print("-1")
else:
    print(count)