#include "bits/stdc++.h"
using namespace std;
#define rep(i,n) for(int (i)=0;(i)<(int)(n);++(i))
#define rer(i,l,u) for(int (i)=(int)(l);(i)<=(int)(u);++(i))
#define reu(i,l,u) for(int (i)=(int)(l);(i)<(int)(u);++(i))
static const int INF = 0x3f3f3f3f; static const long long INFL = 0x3f3f3f3f3f3f3f3fLL;
typedef vector<int> vi; typedef pair<int, int> pii; typedef vector<pair<int, int> > vpii; typedef long long ll;
template<typename T, typename U> static void amin(T &x, U y) { if (y < x) x = y; }
template<typename T, typename U> static void amax(T &x, U y) { if (x < y) x = y; }

int main() {
    int T;
    scanf("%d", &T);
    const int X = 300000, K = 18;
    vector<vector<ll>> dp(K + 2, vector<ll>(X + 1));
    dp[0][0] = 1;
    rer(k, 0, K) {
        rer(d, 0, 9) for (int j = X - (d << k); j >= 0; --j)
            dp[k + 1][j + (d << k)] += dp[k][j];
    }
    vector<ll> sum(X + 2);
    rer(j, 0, X)
        sum[j + 1] = sum[j] + dp[K + 1][j];
    for (int ii = 0; ii < T; ++ii) {
        long long rank;
        scanf("%lld", &rank), --rank;
        int x = (int)(upper_bound(sum.begin(), sum.end(), rank) - sum.begin()) - 1;
        rank -= sum[x];
        string ans;
        bool lz = true;
        for (int k = K; k >= 0; --k) {
            bool ok = false;
            rer(d, 0, 9) {
                ll cnt = x >= d << k ? dp[k][x - (d << k)] : 0;
                if (rank < cnt) {
                    ok = true;
                    x -= d << k;
                    lz &= d == 0 && k != 0;
                    if(!lz)
                        ans += char('0' + d);
                    break;
                }
                rank -= cnt;
            }
            assert(ok);
        }
        puts(ans.c_str());
    }
    return 0;
}
