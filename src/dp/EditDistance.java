package dp;

public class EditDistance {
	
	public int editDistance(String a,String b,int ci,int cd,int cr){
		int m = a.length();
		int n = b.length();
		int [][] mem = new int[m+1][n+1];
		for(int i=0;i<m;i++){
			mem[i][0]=i*ci;
		}
		for(int i=0;i<n;i++){
			mem[0][i] = i*ci;
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				int insert = mem[i-1][j] + ci;
				int remove = mem[i][j-1] + cd;
				int replace=0;
				if(a.charAt(i)==b.charAt(j)){
					replace = mem[i-1][j-1];
				}else{
					replace = mem[i-1][j-1]+cr;
				}
				mem[i][j] = min(insert,remove,replace);
			}
		}
		return mem[m-1][n-1];
	}
	private int min(int a,int b,int c){
		return a<=b?(a<=c?a:c):(b<=c?b:c);
	}
	
	public static void main(String s[]){
		String a = "geek";
		String b = "gesek";
		System.out.println(new EditDistance().editDistance(a,b,1,1,1));
	}
	

}
