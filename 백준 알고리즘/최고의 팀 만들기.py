dp = [[0] * 16 for _ in range(16)]
array = []

while True:
    try:
        white, black = map(int, input().split())
        for w in range(15, -1, -1):
            for b in range(15, -1, -1):
                if w != 0:
                    dp[w][b] = max(dp[w][b], dp[w - 1][b] + white)
                if b != 0:
                    dp[w][b] = max(dp[w][b], dp[w][b - 1] + black)
    except:
        print(dp[15][15])
        break