#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


int main() 
{
    int a, b,t,s;
    scanf("%d\n%d", &a, &b);
     t=a>b?a:b;
    s=a<b?a:b;
    for(s;s<=t;s++)
    {
        if(s<10)
        {
            if(s==1)
            printf("one\n");
            if(s==2)
            printf("two\n");
            if(s==3)
            printf("three\n");
            if(s==4)
            printf("four\n");
            if(s==5)
            printf("five\n");
            if(s==6)
            printf("six\n");
            if(s==7)
            printf("seven\n");
            if(s==8)
            printf("eight\n");
            if(s==9)
            printf("nine\n");
        }
        if(s>=10)
        {
            if(s%2==0)
                printf("even\n");
            else
                printf("odd\n");
        }
        
    }

    return 0;
}
