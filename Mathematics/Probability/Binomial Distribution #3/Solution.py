import math

def choose(n,k):
    return (math.factorial(n) / (math.factorial(k) * math.factorial(n-k)))

def pmf(k,n,p):
    return choose(n,k) * p**k * (1-p)**(n-k)

P = 0.12
print '%.3f' % (pmf(0,10,P) + pmf(1,10,P) + pmf(2,10,P))
print '%.3f' % (1 - (pmf(0,10,P) + pmf(1,10,P)))
