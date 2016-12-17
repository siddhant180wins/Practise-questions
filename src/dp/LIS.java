package dp;

import java.util.Scanner;

public class LIS {

	//Straight solution
//	public int LISLoop(int [] a){
//		int n = a.length;
//		for(int i=0;i<n;i++){
//			int prev = a[i];
//			for(int j=i+1;j<n;j++){
//				for(int k=i;k<j;k++){
//					if(a[k]>=a[i] && a[k]<=a[])
//				}
//			}
//		}
//		return 0;
//	}
	
	
	
	public int LISDP(int a[]){
		int n = a.length;
		int lis[] = new int[n];
		lis[0] = 1;
		for(int i=1;i<n;i++){
			int max=1;
			for(int j=0;j<i;j++){
				if(a[j]<a[i]){
					if(max<(lis[j]+1))
						max = lis[j]+1;
				}
			}
			lis[i] = max;
		}
		int max = -1;
		for(int i=0;i<n;i++){
			if(lis[i]>max)
				max = lis[i];
		}
		return max;
	}
	public static void main(String...strings ){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			int n = sc.nextInt();
			int [] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			System.out.println(new LIS().LISDP(a));
			t--;
		}
	}
}
