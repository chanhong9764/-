def is_available(candidate, row, col):
    for i in range(len(candidate)):
        if candidate[i] == col or abs(candidate[i] - col) == row - i:
            return False
    return True

def dfs(r, queens):
    global ans

    if r == N:
        ans += 1
        return

    for i in range(N):
        if is_available(queens, r, i):
            queens.append(i)
            dfs(r+1, queens)
            queens.pop()

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    ans = 0
    dfs(0, [])
    print('#{} {}'.format(tc, ans))