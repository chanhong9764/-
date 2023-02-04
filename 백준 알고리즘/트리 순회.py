import sys
sys.setrecursionlimit(10**7)

n = int(input())

array = {}

for _ in range(n):
    root, left, right = input().split()
    array[root] = (left, right)

def preOrder(value):
    print(value, end='')
    left, right = array[value]
    if left != '.':
        preOrder(left)
    if right != '.':
        preOrder(right)
        
def inOrder(value):
    left, right = array[value]
    if left != '.':
        inOrder(left)
    print(value, end='')
    if right != '.':
        inOrder(right)
        
def postOrder(value):
    left, right = array[value]
    if left != '.':
        postOrder(left)
    if right != '.':
        postOrder(right)
    print(value, end='')

preOrder('A')
print('')
inOrder('A')
print('')
postOrder('A')