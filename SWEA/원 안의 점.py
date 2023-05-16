for tc in range(1, int(input()) + 1):
    n = int(input())
    answer = 0
    
    # 공식 대입
    for i in range(-n, n + 1):
        for j in range(-n, n + 1):
            if (i*i) + (j*j) <= (n*n):
                answer += 1 
    
    print("#", tc, " ", answer, sep="")