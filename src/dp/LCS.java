package dp;

public class LCS {
	//Recursive LCS : 
	String x;
	String y;
	public LCS(String x,String y){
		this.x = x;
		this.y = y;
	}
	
	public int LCSRecursiveWrapper(){
		return LCSRecursive(0,0);
	}
	private int LCSRecursive(int i,int j){
		if(i >= x.length() || j >= y.length() ) return 0;
		if(x.charAt(i)==y.charAt(j)) return 1+LCSRecursive(i+1,j+1);
		return max(LCSRecursive(i+1,j),LCSRecursive(i,j+1));
	}
	public int LCSDPWrapper(){
		int lx = x.length();
		int ly = y.length();
		int[][] mem = new int[lx+1][ly+1];
		for(int i=lx;i>=0;i--){
			mem[i][ly]=0;
		}
		for(int i=ly;i>=0;i--){
			mem[lx][i]=0;
		}
		
		for(int i=lx-1;i>=0;i--){
			for(int j=ly-1;j>=0;j--){
				if(x.charAt(i)==y.charAt(j))
					mem[i][j]=1+mem[i+1][j+1];
				else{
					if(mem[i+1][j]>=mem[i][j+1])
						mem[i][j]=mem[i+1][j];
					else
						mem[i][j]=mem[i][j+1];
				}
					
			}
		}
		return mem[0][0];
	}
	private int max(int a,int b){
		return a>=b?a:b;
	}
	
	public static void main(String ...s){
		LCS lcs = new LCS("ABCBDAB","BDCABA");
		System.out.println(lcs.LCSDPWrapper());
	}
}
