from collections import deque
a, b = map(int, input().split())


def bfs(start):
    answer = 0
    q = deque([(answer, start)])
    
    while q:
        count, value = q.popleft()
        count += 1

        if value > b:
            continue
        elif value == b:
            answer = count
            break
        q.append((count,value * 2))
        q.append((count, int(str(value) + '1')))
    if answer == 0:
        return -1
    else:
        return answer

print(bfs(a))