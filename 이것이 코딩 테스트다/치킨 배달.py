from itertools import combinations

n, m = map(int, input().split())

home = []
store = []

for r in range(n):
    data = list(map(int, input().split()))
    for i in range(n):
        if data[i] == 1:
            home.append((r, i))
        elif data[i] == 2:
            store.append((r, i))
            
chickens = list(combinations(store, m))

def get_sum(chicken):
    result = 0
    for hx, hy in home:
        temp = 1e9
        for cx, cy in chicken:
            temp = min(temp, abs(hx - cx) + abs(hy - cy))
        result += temp
    return result
    
result = 1e9
for chicken in chickens:
    result = min(result, get_sum(chicken))

print(result)

# 핵심 키워드
# 조합