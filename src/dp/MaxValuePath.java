package dp;

import java.util.Scanner;

/*
 * Max value path from a,b to bottom most in a matrix
 */
public class MaxValuePath {
	
	public int maxPathSubMatrix(int a[][],int n,int m){
		int s[][] = new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			s[i][0]=0;
		}
		for(int i=0;i<=m;i++){
			s[0][i]=0;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				s[i][j] = a[i][j]+Math.max(s[i-1][j],s[i][j-1]);
			}
		}
		return s[n][m];

	}
	public int maxOneSquareSubmatrix(int a[][],int n,int m){
		int s[][] = new int[n][m];
		for(int i=0;i<n;i++)
			s[i][0] =a[i][0]; 
		for(int i=0;i<m;i++)
			s[0][i] =a[0][i];
		int max=0;
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				s[i][j]=0;
				if(a[i][j]==1){
					s[i][j] = Math.min(s[i-1][j],Math.min(s[i][j-1], s[i-1][j-1]))+1;
				}
				max = Math.max(s[i][j], max);
			}
		}
		return max;
	}
	public static void main(String... string){
		int n;
		int m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int a[][] = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j] = sc.nextInt();
			}
		}
				
	}
}
