tc = int(input())

d = [0] * 11

d[1] = 1
d[2] = 2
d[3] = 4

for i in range(4, 11):
    d[i] = d[i-1] + d[i-2] + d[i-3]
    
for _ in range(tc):
    print(d[int(input())])