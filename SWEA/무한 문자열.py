for tc in range(1, int(input()) + 1):
    s, t = input().split()
    
    s_len = len(s)
    t_len = len(t)
    
    if s_len != t_len:
        s = s * t_len
        t = t * s_len
    if s != t:
        print("#", tc, " ", 'no', sep="")
    else:
        print("#", tc, " ", 'yes', sep="")