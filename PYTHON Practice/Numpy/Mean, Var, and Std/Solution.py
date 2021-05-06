import numpy as np
n,m = map(int,input().split())
l = []
for i in range(n):
    v = list(map(int, input().split()))
    l.append(v)
l=np.array(l)
print(np.mean(l,axis=1))
print(np.var(l,axis=0))
std = np.std(l,axis=None)
rnd = np.around(std,11)
print(rnd)
