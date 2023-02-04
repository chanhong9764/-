import sys
sys.setrecursionlimit(10**7)
array = []

while True:
    try:
        array.append(int(input()))
    except:
        break
    
def postOrder(start, end):
    if start > end:
        return
    
    mid = end + 1
    for i in range(start + 1, end + 1):
        if array[i] > array[start]:
            mid = i
            break
    postOrder(start + 1, mid - 1)
    postOrder(mid, end)
    print(array[start])

postOrder(0, len(array) - 1)