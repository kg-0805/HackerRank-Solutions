#include <iostream>
#include <string>
using namespace std;

int main() {
   // Complete the program
   string a,b;
   char temp;
    cin>>a;
    cin>>b;
    cout<<a.size();
    cout<<" ";
    cout<<b.size();
    cout<<"\n";
    cout<<a<<b;
    temp=a[0];
    a[0]=b[0];
    b[0]=temp;
    cout<<"\n"<<a<<" "<<b;
    
    
    
    return 0;
}
