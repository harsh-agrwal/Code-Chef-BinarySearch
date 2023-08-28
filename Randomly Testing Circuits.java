/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static double getAns(int[][] arr, int n, double m){
        double[] dp = new double[n];
        for(int i = 0; i<n; i++){
            if(arr[i][0]==0)
                dp[i] = m;
            else if (arr[i][0]==1)
                dp[i] = 1 - (1-dp[arr[i][1]])*(1-dp[arr[i][2]]);
            else
                dp[i] = dp[arr[i][1]]*dp[arr[i][2]];
        }
        return dp[n-1];
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int[][] arr = new int[n][3];
		    for(int i = 0; i<n; i++){
		        arr[i][0] = sc.nextInt();
		        if(arr[i][0]!=0){
		            arr[i][1] = sc.nextInt()-1;
		            arr[i][2] = sc.nextInt()-1;
		        }
		    }
		    double l = 0, r = 1, m = 0, ans = 0;
		    while(r-l>0.00000001){
		        m = (l+r)/2;
		        ans = getAns(arr, n, m);
		        if(ans>0.5)
		            r = m;
		        else
		            l = m;
		    }
		    System.out.printf("%.5f%n",m);
		}
	}
}
