from math import *
def phi(x, mu=30, sigma=4):
    return (1.0 + erf((x-mu) / (sigma * sqrt(2.0)))) / 2.0

print '%.3f' % phi(40,30,4)
print '%.3f' % (1 - phi(21, 30, 4))
print '%.3f' % ( phi(30) + phi(35) - 1)
