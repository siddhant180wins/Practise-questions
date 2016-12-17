import java.util.Scanner;

/*
 * Uses Coin change greedy problem
 */
public class EqualHR {
	public static int getMin(int a[]){
		int n = a.length;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(a[i]<min)
				min = a[i];
		}
		return min;
	}
	//coins in increasing order
	public static int greedyCoinChange(int coins[],int val){
		int n = coins.length;
		int count=0;
		for(int i=n-1;i>=0 && val>0;i--){
			count += val/coins[i];
			val = val%coins[i];
		}
		return count;
	}
	public static void main(String s[]){
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t>0){
			int  n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			int coins[] = {1,2,5};
			int min = EqualHR.getMin(a);
			int sum[] = new int[5];
			for(int i=0;i<5;i++){
				int curmin = min-i;
				sum[i]=0;
				for(int j=0;j<n;j++){
					sum[i]+=EqualHR.greedyCoinChange(coins, Math.abs(a[j]-curmin));
				}
			}
			System.out.println(EqualHR.getMin(sum));
			t--;
		}
	}
}
