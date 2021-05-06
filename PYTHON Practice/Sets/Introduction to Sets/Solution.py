from __future__ import division

def average(array):
    distinct_heights = set(array)
    return sum(distinct_heights) / len(distinct_heights)
if __name__ == '__main__':
    n = int(raw_input())
    arr = map(int, raw_input().split())
    result = average(arr)
    print result