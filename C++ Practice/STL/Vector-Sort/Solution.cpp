#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N = 0;
    cin>>N;
    
    vector<int> vecInt;
    int number = 0;
    
    while (cin>>number)
        vecInt.push_back(number);
    
    sort(vecInt.begin(), vecInt.end());
    
    for ( vector<int>::iterator it = vecInt.begin(); it != vecInt.end(); it++)
        cout<<*it<<" ";
    return 0;
}
