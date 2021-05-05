#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
class Matrix {
  public:
    Matrix() {}
    Matrix(const Matrix& x) : a(x.a) {}
    Matrix(const vector<vector<int>>& v) : a(v) {}
    Matrix operator+(const Matrix&);
    vector<vector<int>> a;
};

Matrix Matrix::operator+(const Matrix& m){
    vector<vector<int>> vv = a;
    for (int i=0; i<vv.size(); i++){
        for (int j=0; j<vv[0].size(); j++){
            vv[i][j] += m.a[i][j];
        }
    }
    return Matrix(vv);
}
int main () {
   int cases,k;
   cin >> cases;
   for(k=0;k<cases;k++) {
      Matrix x;
      Matrix y;
      Matrix result;
      int n,m,i,j;
      cin >> n >> m;
      for(i=0;i<n;i++) {
         vector<int> b;
         int num;
         for(j=0;j<m;j++) {
            cin >> num;
            b.push_back(num);
         }
         x.a.push_back(b);
      }
      for(i=0;i<n;i++) {
         vector<int> b;
         int num;
         for(j=0;j<m;j++) {
            cin >> num;
            b.push_back(num);
         }
         y.a.push_back(b);
      }
      result = x+y;
      for(i=0;i<n;i++) {
         for(j=0;j<m;j++) {
            cout << result.a[i][j] << " ";
         }
         cout << endl;
      }
   }  
   return 0;
}
