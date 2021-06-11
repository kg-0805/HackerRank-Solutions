def solve(n, m, p):
    q = 1 - p

    def count11(n, m):
        if n > m: n, m = m, n
        ans = 0
        if n == 1:
            if m == 1:
                ans += 1
            else:
                ans += q * 2
                ans += q**2 * (m - 2)
        else:
            ans += q**2 * 4
            ans += q**3 * 2 * (n + m - 4)
            ans += q**4 * (n - 2) * (m - 2)
        return ans

    def count12(n, m):
        ans = 0
        if m == 1:
            pass
        elif n == 1:
            if m == 2:
                ans += 1
            else:
                ans += q * 2
                ans += q**2 * (m - 3)
        elif m == 2:
            ans += q**2 * 2
            ans += q**4 * (n - 2)
        else:
            ans += q**3 * 4
            ans += q**4 * 2 * (m - 3)
            ans += q**5 * 2 * (n - 2)
            ans += q**6 * (n - 2) * (m - 3)
        return ans*p

    def count22(n, m):
        if n > m: n, m = m, n
        ans = 0
        if n == 1:
            pass
        elif n == 2:
            if m == 2:
                ans += q**2
            else:
                ans += q**3
                ans += q**4
                ans += q**5 * (m - 3)
        else:
            ans += q**4
            ans += q**5 * 2
            ans += q**6 * (n + m - 5)
            ans += q**7 * (n + m - 6)
            ans += q**8 * (n - 3) * (m - 3)
        return ans*p**2

    def count13(n, m):
        ans = 0
        if m <= 2:
            pass
        elif n == 1:
            if m == 3:
                ans += 1
            else:
                ans += q * 2
                ans += q**2 * (m - 4)
        elif m == 3:
            ans += q**3 * 2
            ans += q**6 * (n - 2)
        else:
            ans += q**4 * 4
            ans += q**5 * 2 * (m - 4)
            ans += q**7 * 2 * (n - 2)
            ans += q**8 * (n - 2) * (m - 4)
        return ans*p**2

    ans = 0
    ans += count11(n, m)
    ans += count12(n, m)
    ans += count12(m, n)
    ans += count22(n, m) * 4
    ans += count13(n, m)
    ans += count13(m, n)

    return ans / (n*m)

for cas in xrange(input()):
    n, m, p = raw_input().strip().split()
    n = int(n)
    m = int(m)
    p = float(p)
    print "{:.30}".format(solve(n, m, p))
