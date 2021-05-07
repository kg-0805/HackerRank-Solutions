#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

bool check(ll machines, ll workers, ll price, ll target, ll rounds) {
    if (machines >= (target+workers-1)/workers) return true;
    ll cur = machines*workers;
    rounds--;
    if (rounds == 0) return false;
    while (1) {
        ll rem = target - cur;
        ll rnds = (rem + machines*workers - 1) / (machines*workers);
        if (rnds <= rounds) return true;
        if (cur < price) {
          rem = price - cur;
          rnds = (rem + machines*workers - 1) / (machines*workers);
          rounds -= rnds;
          if (rounds < 1) return false;
          cur += rnds * machines * workers;
        }
        cur -= price;
        if (machines > workers) {
          workers++;
        } else {
          machines++;
        }
    }
    return false;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    ll m, w, p, n;
    cin >> m >> w >> p >> n;
    ll a = 1, b = 1000000000000LL;
    while (a < b) {
        ll mid = (a + b) >> 1;
        if (check(m, w, p, n, mid)) {
          b = mid;
        } else {
          a = mid + 1;
        }
    }
    cout << a << "\n";
    return 0;
}
