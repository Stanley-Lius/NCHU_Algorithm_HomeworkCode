package algHW;

public class HW08_410906427 extends Buy_Phone_v2{
	


	
	public int[][] bestPhone(int[][] inputArr){
		int l = inputArr.length;

		int[][] fi = sort_4109064207(inputArr,l);
		
	
		
		return fi;
	}

	
	 public static int[][] sort_4109064207(int[][] input,int ln){
		
		int[][] aux = new int[ln][6];
		for(int d = 5;d>=0;d--) {
			int[] count = new int[1024];
			int l = input.length;
			for(int i=0;i<l;i++) {
				count[input[i][d]+1]++;
			}
			
			for(int r=0;r<1022;r++) {
				count[r+1]+=count[r];
			}
			
			for(int i=0;i<l;i++) {
				aux[count[input[i][d]]++] = input[i];
			}
			for(int i=0;i<l;i++) {
				input[i] = aux[i];
				
			}
			input = find_4109064207(input,l);
		}
		
		return input;
	}
	
	 public static int[][] find_4109064207(int[][] input,int l){
		int count = 0;
		int[][] pre_ans = new int[l][6];
		int[] test = input[l-1];
		pre_ans[count++] = test;
		for(int i =l-2;i>=0;i--) {
			int[] fight = input[i];
			for(int j=0;j<6;j++) {
				if(fight[j] > test[j]) {
					pre_ans[count++] = fight;
					j=6;
					test = fight;
				}
			}
		
		}
		int [][] ans = new int[count][6];
		
		for(int i=0;i<count;i++) {
			ans[i] = pre_ans[i];
		}
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW08_410906427 test = new HW08_410906427();
		int[][] inputArr= {{9,8,7,3,6,5},{2,4,4,6,2,1},{4,0,5,1,3,2},{5,2,4,3,7,3},{7,5,6,9,8,9},{1,1,1,1,1,100},{1,1,1,1,1,100}, {1,1,1,4,1,3}, {1,1,1,3,1,300},{8,7,7,4,2,1},{4,2,6,7,8,0},{7,7,7,2,3,8},{5,1,3,5,9,9},{10,13,17,6,9,8},{15,14,6,6,6,2},{26,5,23,45,8,10}};
		
		int[][] ans = test.bestPhone(inputArr); 
		
		for(int i =0;i<ans.length;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(ans[i][j]+"  ");
			}
			System.out.println();
		}
		
		final long end = System.nanoTime();
		System.out.printf("Used time: %d\n",end-begin);
	}

}
