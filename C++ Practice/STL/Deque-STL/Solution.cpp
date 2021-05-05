#include <string>
#include <vector>
#include <algorithm>
#include <numeric>
#include <set>
#include <map>
#include <queue>
#include <iostream>
#include <sstream>
#include <cstdio>
#include <cmath>
#include <ctime>
#include <cstring>
#include <cctype>
#include <cassert>
#include <limits>
#include <functional>
#define rep(i,n) for(int (i)=0;(i)<(int)(n);++(i))
#define rer(i,l,u) for(int (i)=(int)(l);(i)<=(int)(u);++(i))
#define reu(i,l,u) for(int (i)=(int)(l);(i)<(int)(u);++(i))
#if defined(_MSC_VER) || __cplusplus > 199711L
#define aut(r,v) auto r = (v)
#else
#define aut(r,v) __typeof(v) r = (v)
#endif
#define each(it,o) for(aut(it, (o).begin()); it != (o).end(); ++ it)
#define all(o) (o).begin(), (o).end()
#define pb(x) push_back(x)
#define mp(x,y) make_pair((x),(y))
#define mset(m,v) memset(m,v,sizeof(m))
#define INF 0x3f3f3f3f
#define INFL 0x3f3f3f3f3f3f3f3fLL
using namespace std;
typedef vector<int> vi; typedef pair<int,int> pii; typedef vector<pair<int,int> > vpii; typedef long long ll;
template<typename T, typename U> inline void amin(T &x, U y) { if(y < x) x = y; }
template<typename T, typename U> inline void amax(T &x, U y) { if(x < y) x = y; }

struct Val {
    int x;
    Val() : x(-INF) {}
    Val(int x_) : x(x_) {}
    Val &operator+=(const Val &that) {
        amax(x, that.x);
        return *this;
    }
};

struct TwoStackQueue {
    typedef Val Sum;

    //queue = reverse(vals2) ++ vals1
    vector<Val> vals1, vals2;
    vector<Sum> sums1, sums2;

    pair<Sum,Sum> getsumparts() const {
        Sum s1 = sums1.empty() ? Sum() : sums1.back();
        Sum s2 = sums2.empty() ? Sum() : sums2.back();
        return make_pair(s1, s2);
    }
    void push(const Val &v) {
        Sum s = !sums1.empty() ? sums1.back() : Sum();
        s += v;
        vals1.push_back(v);
        sums1.push_back(s);
    }
    void pop() {
        ensure();
        if(!vals2.empty()) {
            vals2.pop_back();
            sums2.pop_back();
        }
    }

private:
    void ensure() {
        if(!vals2.empty()) return;
        reverse(all(vals1));
        vals2.swap(vals1);
        sums1.clear();
        Sum s;
        sums2.resize(vals2.size());
        for(size_t i = 0; i < vals2.size(); ++ i) {
            s += vals2[i];
            sums2[i] = s;
        }
    }
};

int main() {
    int T;
    scanf("%d", &T);
    rep(ii, T) {
        int N, K;
        scanf("%d%d", &N, &K);
        vector<int> A(N);
        for(int i = 0; i < N; ++ i)
            scanf("%d", &A[i]);
        TwoStackQueue q;
        rep(i, K)
            q.push(A[i]);
        vector<int> ans(N - K + 1);
        for(int i = K;; ++ i) {
            pair<Val,Val> p = q.getsumparts();
            ans[i - K] = max(p.first.x, p.second.x);
            if(i == N) break;
            q.pop();
            q.push(A[i]);
        }
        for(int i = 0; i < N - K + 1; ++ i) {
            if(i != 0) putchar(' ');
            printf("%d", ans[i]);
        }
        puts("");
    }
    return 0;
}
