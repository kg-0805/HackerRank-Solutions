import math

def choose(n,k):
    return (math.factorial(n) / (math.factorial(k) * math.factorial(n-k)))

def pmf(k,n,p):
    return choose(n,k) * p**k * (1-p)**(n-k)

print '%.3f' % (pmf(3,4,0.8) + pmf(4,4,0.8))
print '%.3f' % (pmf(1,4,0.8) + pmf(0,4,0.8))
