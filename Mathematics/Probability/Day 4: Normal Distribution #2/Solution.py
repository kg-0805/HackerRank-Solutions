from math import *
def phi(x, mu=20, sigma=2):
    return (1.0 + erf((x-mu) / (sigma * sqrt(2.0)))) / 2.0

print '%.3f' % phi(19.5)
print '%.3f' % ( phi(20) + phi(22) - 1)
