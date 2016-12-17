package dp;

public class SingleDP {
	//Max Contiguous subarray;
	/*
	 * Nice divide and conquer strategy. O(nlogn)
	 */
	public int MaxContiguousSubArray(int[] a,int left,int right){
		int maxLeft=Integer.MIN_VALUE;
		int maxRight=Integer.MIN_VALUE;
		int maxLeftBorder =Integer.MIN_VALUE;
		int maxRightBorder =Integer.MIN_VALUE;
		int maxV=Integer.MIN_VALUE;
		if(left>=right){
			return  a[left];
		}
		int mid = left + (right-left)/2;
		maxLeft =  MaxContiguousSubArray(a,left,mid);
		maxRight = MaxContiguousSubArray(a,mid+1,right);
		
		maxV = max(maxLeft,maxRight);
		
		int leftBorderSum=0;
		for(int i=mid;i>=left;i--){
			leftBorderSum+=a[i];
			if(leftBorderSum>maxLeftBorder)
				maxLeftBorder =leftBorderSum;
		}
		int rightBorderSum = 0;
		for(int i=mid+1;i<=right;i++){
			rightBorderSum+=a[i];
			if(rightBorderSum>maxRightBorder)
				maxRightBorder = rightBorderSum;
		}
		return max(maxV,maxRightBorder+maxLeftBorder);
	}
	private int max(int a,int b){
		return a>=b?a:b;
	}
	/*
	 * TODO:DP Solution for max contiguos subarray
	 */
	/*
	 * TODO :max contiguos subarray without selecting n contiguous.
	 */
	public static void main(String... s){
		int a[] = {-2,11,-4,13,-5,2};
		System.out.println(new SingleDP().MaxContiguousSubArray(a, 0, 5));
	}
}
