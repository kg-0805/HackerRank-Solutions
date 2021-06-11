from math import *
def phi(x, mu=70, sigma=10):
    return (1.0 + erf((x-mu) / (sigma * sqrt(2.0)))) / 2.0

print '%.2f' % (100*(1 - phi(80)))
print '%.2f' % (100*(1 - phi(60)))
print '%.2f' % (100*phi(60))
