import sys
input = sys.stdin.readline

m = int(input())

s = set()

for _ in range(m):
    temp = input().rstrip()
    if temp == 'all':
        s = set([i for i in range(1, 21)])
    elif temp == 'empty':
        s.clear()
    else:
        op, value = temp.split(' ')
        value = int(value)
        if op == 'add':
            s.add(value)
        elif op == 'remove':
            s.discard(value)
        elif op == 'check':
            if value in s:
                print('1')
            else:
                print('0')
        else:
            if value in s:
                s.remove(value)
            else:
                s.add(value)
