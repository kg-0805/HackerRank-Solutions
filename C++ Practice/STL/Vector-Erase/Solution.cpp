#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    vector <long long int> v;
    long long n,x,a,b;
    cin>>n;
    for(long long i=0;i<n;i++){
        cin>>x;
        v.push_back(x);
    }
    cin>>x>>a>>b;
    v.erase(v.begin()+x-1);
    v.erase(v.begin()+a-1,v.begin()+b-1);
    cout<<v.size()<<endl;
    for(long long i=0;i<v.size();i++)
        cout<<v[i]<<" ";
    return 0;
}
