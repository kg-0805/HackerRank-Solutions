import java.util.*;

class Solution
{
    
    static int emptyx,emptyy;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        char arr[][] = new char[10][10];
        int i,j,k,l;
        for(i = 0;i<10;i++)
        {
            String s  = sc.nextLine();
            for(j = 0;j<s.length();j++)
            {
                arr[i][j] = s.charAt(j);
            }
        }
        String temp = sc.nextLine();
        String[] str = temp.split(";");
        boolean done[] = new boolean[str.length];
        if(solveshit(arr,str,done))
        {
            for(i = 0;i<10;i++)
            {
                for(j = 0;j<10;j++)
                {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static boolean solveshit(char arr[][],String str[], boolean done[])
    {
        if(isFull(arr))
        {
            return true;
        }
        else
        {
            //part 1
            //System.out.println("fuck the police");
            int i,j,k,l,m,n,flag;
            i = emptyx;
            j = emptyy;
            j--;            
            while(ifSafe(j) && arr[i][j] !='+')
            {
                j--;
            }
            j++;
            k = j;
            int length=0;
            while(ifSafe(k) && arr[i][k] != '+')
            {
                length++;
                k++;
            }
            k--;
            for(l = 0;l<str.length;l++)
            {
                if(str[l].length() == length && done[l] == false)
                {
                    char tempstr[] = str[l].toCharArray();
                    char tempchar[] = new char[length];
                    for(m = 0;m<length;m++)
                        tempchar[m] =arr[i][j+m]; 
                    flag = 0;
                    for(m =0;m<length;m++)
                    {
                        if(arr[i][j+m] == tempstr[m] || arr[i][j+m] == '-')
                        {
                            
                        }
                        else
                            flag = 1;
                    }
                    if(flag == 0)
                    {
                        done[l] = true;
                        for(m = 0;m<length;m++)
                        {
                            arr[i][j+m] = tempstr[m];
                        }
                        if(solveshit(arr,str,done))
                            return true;
                        done[l] = false;
                        for(m = 0;m<length;m++)
                        {
                            arr[i][j+m] = tempchar[m];
                        }
                        
                    }
                }
            }
            //part 2
            //
            //System.out.println("fuck the damm police");
            i = emptyx;
            j = emptyy;
            i--;            
            while(ifSafe(i) && arr[i][j] !='+')
            {
                i--;
            }
            i++;
            k = i;
            length=0;
            while(ifSafe(k) && arr[k][j] != '+')
            {
                length++;
                k++;
            }
            //System.out.println("i = "+i);
            //System.out.println("j = "+j);
            //System.out.println(length);
            k--;
            for(l = 0;l<str.length;l++)
            {
                //System.out.println(str[l].length());
                if(str[l].length() == length && done[l] == false)
                {
                    char tempstr[] = str[l].toCharArray();
                    char tempchar[] = new char[length];
                    for(m = 0;m<length;m++)
                        tempchar[m] =arr[i+m][j]; 
                    flag = 0;
                    for(m =0;m<length;m++)
                    {
                        if(arr[i+m][j] == tempstr[m] || arr[i+m][j] == '-')
                        {
                            
                        }
                        else
                            flag = 1;
                    }
                    if(flag == 0)
                    {
                        done[l] = true;
                        for(m = 0;m<length;m++)
                        {
                            arr[i+m][j] = tempstr[m];
                        }
                        if(solveshit(arr,str,done))
                            return true;
                        done[l] = false;
                        for(m = 0;m<length;m++)
                        {
                            arr[i+m][j] = tempchar[m];
                        }
                        
                    }
                }
            }
            return false;
        }
    }
    public static boolean ifSafe(int x)
    {
        if(x>=0 && x<10)
            return true;
        else
            return false;
    }
    
    
    public static boolean isFull(char arr[][])
    {
        int i,j,k;
        for(i = 0;i<10;i++)
        {
            for(j = 0;j<10;j++)
            {
                if(arr[i][j] == '-')
                {
                    emptyx = i;
                    emptyy = j;
                    return false;
                }
            }
        }
        return true;
    }
}
