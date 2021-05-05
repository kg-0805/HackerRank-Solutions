#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
 int main(){ 
  int n;
  int q;
  std::cin >> n >> q;
  int** arr = new int*[n];
  for (auto i = 0; i < n; ++i) {
    int k;
    std::cin >> k;
    arr[i] = new int[k];
    for (auto j = 0; j < k; ++j) {
      std::cin >> arr[i][j];
    }
  }
  for (auto i = 0; i < q; ++i) {
    int a;
    int b;
    std::cin >> a >> b;
    std::cout << arr[a][b] << std::endl;
  }
  return 0;
}
