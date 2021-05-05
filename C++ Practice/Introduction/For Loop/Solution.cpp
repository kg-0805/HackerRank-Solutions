#include <iostream>
#include <cstdio>
using namespace std;

void name(int n)
{
    if(n==1)
    {
        cout<<"one"<<endl;
    }
    else
    if(n==2)
    {
        cout<<"two"<<endl;
    }
    else
    if(n==3)
    {
        cout<<"three"<<endl;
    }
    else
    if(n==4)
    {
        cout<<"four"<<endl;
    }
    else
    if(n==5)
    {
        cout<<"five"<<endl;
    }
    else
    if(n==6)
    {
        cout<<"six"<<endl;
    }
    else
    if(n==7)
    {
        cout<<"seven"<<endl;
    }
    else
    if(n==8)
    {
        cout<<"eight"<<endl;
    }
    else
    if(n==9)
    {
        cout<<"nine"<<endl;;
    }
}


void type(int n)
{
    if(n%2==0)
    {
        cout<<"even"<<endl;
    }
    else
    {
        cout<<"odd"<<endl;
    }
}

int main() {
    int a,b;
    cin>>a>>b;
    while(a<=b)
    {
        if(a<=9)
        {
            name(a);
        }
        else
        {
            type(a);
        }
        a++;
    }
    return 0;
}

