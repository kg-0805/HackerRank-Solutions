#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    vector<long long int> v;
    long long n,q,x;
    cin>>n;
    for(long long i=0;i<n;i++){
        cin>>q;
        v.push_back(q);
    }
    cin>>q;
    vector<long long>::iterator low,up;
    while(q--){
        cin>>x;
        if(binary_search(v.begin(),v.end(),x)){
            low=lower_bound(v.begin(),v.end(),x);
            cout<<"Yes "<<(low-v.begin()+1)<<endl;
        }
        else{
            up=upper_bound(v.begin(),v.end(),x);
            cout<<"No "<<(up-v.begin()+1)<<endl;
        }
    }
    return 0;
}
