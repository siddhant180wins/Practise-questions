package dp;

import javax.swing.plaf.synth.SynthOptionPaneUI;

class Matrix{
	int rows;
	int cols;
}
public class MatrixMultiplication {
	int n;
	Matrix [] p;
	
	public MatrixMultiplication(Matrix [] p,int n){
		this.n = n;
		this.p = p;
	}
	public long multiplyDP(){
		long[][] mem = new long[n][n];
		int[][] s = new int[n][n];
		for(int i=0;i<n;i++){
			mem[i][i] = 0;
		}
		//l : chain length;
		for(int l=2;l<=n;l++){
			System.out.println(l);
			for(int i=0;i<n-l+1;i++){
				
				int j = i+l-1;
				System.out.println(i+","+j);
				mem[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					long q = mem[i][k] + mem[k+1][j] + (p[i].rows*p[k].cols*p[j].cols);
					if(q<mem[i][j]){
						mem[i][j] = q;
						s[i][j]=k;
					}
					
				}
				System.out.println(mem[i][j]+","+s[i][j]);
			}
		}
		return mem[0][n-1];
	}
	private long min(long a,long b){
		return a<=b?a:b;
	}
	public static void main(String ...strings ){
		Matrix[] p = new Matrix[6];
		p[0] = new Matrix();
		p[0].rows = 30;
		p[0].cols = 35;
		
		p[1] = new Matrix();
		p[1].rows = 35;
		p[1].cols = 15;
		
		p[2] = new Matrix();
		p[2].rows = 15;
		p[2].cols = 5;
		
		p[3] = new Matrix();
		p[3].rows = 5;
		p[3].cols = 10;
		
		p[4] = new Matrix();
		p[4].rows = 10;
		p[4].cols = 20;
		
		p[5] = new Matrix();
		p[5].rows = 20;
		p[5].cols = 25;
		MatrixMultiplication mm = new MatrixMultiplication(p, 6);
		
		System.out.println(mm.multiplyDP());
		
		
	}
	
}
