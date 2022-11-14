T=int(input())

ans=''

for tc in range(1,T + 1):
    A,B,C,D=map(int,input().split())
    List1=[i for i in range(A,B+1)]
    List2=[i for i in range(C,D+1)]
    res=max(0,len(list(set(List1)&set(List2)))-1)
    ans += f'#{tc} {res}\n'

print(ans,end='')