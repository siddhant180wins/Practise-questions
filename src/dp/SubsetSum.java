package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubsetSum {
// Regular TIme Complexity : 2^n, as we need to compute all the subsets.
// DP Solution : Pseudo Polynomial time. O(n*Sum). NP Complete
	public boolean addToSum(int a[],int sum){
		int n = a.length;
		boolean[][] m = new boolean[n+1][sum+1];
		// empty sets always add to sum 0.
		for(int i=0;i<=n;i++){
			m[i][0] = true;
		}
		//if 0 adds to sum i.
		for(int i=0;i<sum;i++){
			m[0][i] = i==0;
		}
		
		/*for others : 
		* check if it adds to sum(j) excluding ith element. m[i-1][j];
		* check if it adds to sum(j) including ith.{
		*  check if previous set adds to sum(j) - a[i],
		*  	yes -> true.
		*  no ->false.
		*  } 
		*/
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				
				if(j-a[i-1]>=0 )
				{
					m[i][j] = m[i-1][j] || m[i-1][j-a[i-1]];
				}
				else{
					m[i][j] = m[i-1][j];
					
				}
					
			}
		}
		
		return m[n][sum];
	}
	public static void main(String s[]){
		Scanner sc = new Scanner(System.in);
	
		
		//int t = sc.nextInt();
//		while(t>0){
//			int n = sc.nextInt();
//			int[] a = new int[n];
//			for(int i=0;i<n;i++){
//				a[i] = sc.nextInt();
//			}
		int a[] = {3,4,2,19,3,7,13,10,6,11};
		int b[] = {1,3,9,2};
		int suma = 17;
		int sumb = 5;
			SubsetSum ss = new SubsetSum();
			System.out.println(ss.addToSum(a, suma));
			System.out.println(ss.addToSum(b, sumb));
		}
		
}
