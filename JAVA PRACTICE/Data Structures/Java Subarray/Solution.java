import java.util.*;
public class Solution
{
    
    
    public static void main(String[] argh)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[102];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int sum=0;
                for(int k=i;k<=j;k++)
                {
                    sum=sum+arr[k];
                }
                if(sum<0)
                {
                    //System.out.println("["+i+":"+j+"]");
                    ans=ans+1;
                    
                }
            }
        }
        System.out.println(ans);
    }
    
    
    
}
