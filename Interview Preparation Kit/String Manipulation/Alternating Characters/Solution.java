import java.util.Scanner;
public class Solution {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        while(t-- > 0)
        {
            int count = 0;
            String str = s.nextLine();
            for(int i=1;i<str.length();i++)
            {
                if(str.charAt(i)==str.charAt(i-1))
                {
                    count++;
                }
            }
            System.out.println(count);    
        }
    }

}
