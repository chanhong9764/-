while True:
    try:
        n, s, m = map(int, input().split())
        array = list(map(int, input().split()))
        
        dp = [[0] * (m + 1) for _ in range(n + 1)]
        dp[0][s] = 1
        
        for i in range(1, n + 1):
            for j in range(m + 1):
                if dp[i - 1][j] != 0:
                    if m >= j + array[i - 1] >= 0:
                        dp[i][j + array[i - 1]] = 1
                    if m >= j - array[i - 1] >= 0:
                        dp[i][j - array[i - 1]] = 1
        answer = -1
        for i in range(m, -1, -1):
            if dp[n][i] == 1:
                answer = i
                break
        print(answer)
    except:
        break