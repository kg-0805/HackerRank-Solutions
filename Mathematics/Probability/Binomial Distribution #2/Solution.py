import math
def choose(n,k):
    return (math.factorial(n) / (math.factorial(k) * math.factorial(n-k)))

def pmf(k,n,p):
    return choose(n,k) * p**k * (1-p)**(n-k)

P = 109.0 / (100+109)

print '%.3f' % (pmf(3,6,P) + pmf(4,6,P) + pmf(5,6,P) + pmf(6,6,P))
