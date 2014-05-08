package compete;

import java.util.Scanner;

class KnightKnave{
	Scanner scn = new Scanner(System.in);
	public static void main(String args[]){
		KnightKnave kk = new KnightKnave();
		kk.startWorking();
	}

	void startWorking(){
		int tCases = scn.nextInt();
		for(int i = 0;i<tCases;i++){//loop for each case
			int ppl = scn.nextInt();
			int[][] pplArr = new int[ppl][2];
			for(int j = 0;j<ppl;j++){//for no of ppl
				pplArr[j][0]=scn.nextInt();
				pplArr[j][1]=scn.nextInt();
			}
		forTestCase(pplArr);			
		}
	}
	
	void forTestCase(int[][] pA){
		int does00Exist = 0;
		int distSols = pA.length;
		int smallest = 2*(int)Math.pow(10,pA.length);
		for(int i = 0;i<pA.length;i++){//for selecting which //person to compare against
			if( pA[i][0] == 0 && pA[i][1] == 0){
				does00Exist++;
			}
			int op[] = new int[pA.length];
			int lb = pA[i][0];
			int ub = pA[i][1];
			for(int j = 0;j<pA.length;j++){//comparing //against each person in the test case
				op[i] *= 10;
				if(!(ub < pA[j][0])){
					if(!(lb > pA[j][1])){
						op[i]++;
						
					}
				}
			}
			int k = i-1;
			for(;k>=0 && op[k]!=op[i]; k--)
			{
			}
			if(k!= -1)
				distSols--;
			if(smallest > op[i])
				smallest = op[i];
			
		}
		if(does00Exist == 0)
		{
			System.out.println((distSols+1) % 1000000007);
			for(int k = 0;k<pA.length;k++)
			{
				System.out.print(0);
			}
		}
		else
		{
			System.out.println(distSols%1000000007);
			int lead0 = (int) Math.pow(10,(pA.length-1));
			for( int k = 0 ;lead0 > smallest * Math.pow(10,k);k++)
			{
				System.out.print(0);
			}
			System.out.print(smallest);
		}
	}
	

}
