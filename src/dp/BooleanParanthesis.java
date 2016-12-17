package dp;

public class BooleanParanthesis {
	
	public int countAll(boolean exp[],char symbol[]){
		int expn = exp.length;
		int symn = exp.length;
		int [][] tr = new int[expn][expn];
		int [][] fl = new int[expn][expn];
		
		for(int i=0;i<expn;i++){
			tr[i][i] = exp[i]==true?1:0;
			fl[i][i] = exp[i]==false?1:0;
		}
		for(int len = 1;len<expn;len++){
			//System.out.println("LEN"+len);
			for(int i=0,j=i+len;j<expn;i++,j++){
					tr[i][j] = 0;
					fl[i][j] = 0;
					for(int k=i;k<j;k++){
						if(symbol[k] =='&'){
							tr[i][j] +=(tr[i][k]*tr[k+1][j]);
							fl[i][j] +=(tr[i][k]*fl[k+1][j] + fl[i][k]*tr[k+1][j] + fl[i][k]*fl[k+1][j]);
						}
						if(symbol[k] == '|'){
							tr[i][j] +=(tr[i][k]*fl[k+1][j] + fl[i][k]*tr[k+1][j] + tr[i][k]*tr[k+1][j]);
							fl[i][j] += (fl[i][k]*fl[k+1][j]);
						}
						if(symbol[k] == '^'){
							tr[i][j] += (tr[i][k]*fl[k+1][j] + fl[i][k]*tr[k+1][j]);
							fl[i][j] += (tr[i][k]*tr[k+1][j]+fl[i][k]*fl[k+1][j]);
						}
					}
				//System.out.println("i,j,t"+i+","+j+","+tr[i][j]);
			}
			//System.out.println();
		}
		
		return tr[0][expn-1];
	}
	public static void main(String s[]){
		boolean exp[] = {true,true,false,true};
		char symbol[] = {'|','&','^'};
		System.out.println(new BooleanParanthesis().countAll(exp, symbol));
	}
	
	
}
